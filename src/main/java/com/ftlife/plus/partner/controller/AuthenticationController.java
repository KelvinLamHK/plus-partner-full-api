package com.ftlife.plus.partner.controller;

import com.ftlife.plus.partner.dto.UserDto;
import com.ftlife.plus.partner.entity.LogEntity;
import com.ftlife.plus.partner.entity.UserEntity;
import com.ftlife.plus.partner.parameter.LoginRequest;
import com.ftlife.plus.partner.repository.LogRepository;
import com.ftlife.plus.partner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = {"http://172.29.9.104:3000/", "http://localhost:3000/", "http://10.20.145.30:3000"})
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LogRepository logRepository;

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        Optional<UserEntity> optionalUser = Optional.ofNullable(userRepository.findByUsername(request.getUsername()));
        if (!optionalUser.isPresent() || request.getDeviceId() == null) {
            return ResponseEntity.ok().body("Invalid");
        }

        UserEntity user = optionalUser.get();
        if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok().body("Invalid");
        }

        LogEntity logEntity = new LogEntity();
        String token = UUID.randomUUID().toString();
        Date date = new Date();
        logEntity.setLastLogin(date);
        logEntity.setToken(token);
        logEntity.setDeviceId(request.getDeviceId());
        logRepository.save(logEntity);
        user.setLogId(logEntity.getLogId());
        userRepository.save(user);

        return ResponseEntity.ok().body(token);
    }

    @PostMapping(value = "/protected")
    public ResponseEntity<Object> getProtectedResource(@RequestHeader("Authorization") String authorization, @RequestHeader("DeviceId") String deviceId) {
        if (authorization == null || deviceId == null || !authorization.startsWith("plus ")) {
            return ResponseEntity.ok().body("Invalid");
        }

        String token = authorization.replaceFirst("plus ", "");
        Optional<LogEntity> optionalLogEntity = Optional.ofNullable(logRepository.findByToken(token));
        if (!optionalLogEntity.isPresent()) {
            return ResponseEntity.ok().body("Invalid");
        }

        LogEntity logEntity = optionalLogEntity.get();
        Date date = new Date();
        long diffInMilliseconds = date.getTime() - logEntity.getLastLogin().getTime();
        int diffInDays = (int) (diffInMilliseconds / (24 * 60 * 60 * 1000));

        if (!logEntity.getDeviceId().equals(deviceId) || diffInDays > 7) {
            return ResponseEntity.ok().body("Invalid");
        }

        logEntity.setLastLogin(date);
        logRepository.save(logEntity);
        Optional<UserEntity> optionalUserEntity = Optional.ofNullable(userRepository.findByLogId(logEntity.getLogId()));

        if (!optionalUserEntity.isPresent()) {
            return ResponseEntity.ok().body("Invalid");
        }

        UserDto userDto = new UserDto();
        userDto.setUsername(optionalUserEntity.get().getUsername());
        return ResponseEntity.ok().body(userDto);
    }
}