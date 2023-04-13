package com.ftlife.plus.partner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftlife.plus.partner.configuration.LogConfig;
import com.ftlife.plus.partner.dto.ExceptionDto;
import com.ftlife.plus.partner.dto.RecordDto;
import com.ftlife.plus.partner.entity.TDocumentCenterCategoryEntity;
import com.ftlife.plus.partner.parameter.ApiLogParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.service.DocumentCenterService;
import com.ftlife.plus.partner.util.HttpUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

@RestController
@Log4j2
@CrossOrigin(origins = {"http://172.29.9.104:3000/", "http://localhost:3000/","http://10.20.145.30:3000"})
public class DocumentCenterController {

    @Autowired
    DocumentCenterService documentCenterService;

    @Autowired
    LogConfig logConfig;

    @PostMapping(value = "/v1/document-center")
    public ResponseEntity<Object> saveOrUpdateDocumentCenter (@RequestBody RequestParameter requestParameter) throws ParseException {
        var tDocumentCenterEntity= documentCenterService.createOrUpdateDocumentCenterRecord(requestParameter);
        long recordId = tDocumentCenterEntity.getDocumentCenterId();
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId(String.valueOf(recordId));
        return ResponseEntity.ok().body(recordDto);
    }

    @PostMapping(value = "/v1/broker/list")
    public ResponseEntity<Object> getBrokerList(){
        return ResponseEntity.ok().body(documentCenterService.getBrokerList());
    }

    @PostMapping(value = "/v1/broker/list-page")
    public ResponseEntity<Object> getBrokerListDto(@RequestBody RequestParameter requestParameter){
        return ResponseEntity.ok().body(documentCenterService.getBrokerListPage(requestParameter));
    }

    @PostMapping(value = "/v1/document-center/list")
    public ResponseEntity<Object> getDocumentCenterList(@RequestBody RequestParameter requestParameter) throws ParseException {
        return ResponseEntity.ok().body(documentCenterService.findDocumentCenterListByCriteria(requestParameter));
    }

    @PostMapping(value = "/v1/document-center/category")
    public ResponseEntity<Object> saveOrUpdateDocumentCenterCategory(@RequestBody RequestParameter requestParameter){
        var tDocumentCenterCategoryEntity = new TDocumentCenterCategoryEntity();
        try {
            tDocumentCenterCategoryEntity= documentCenterService.createOrUpdateDocumentCenterCategory(requestParameter);
        }catch (Exception e){
            ExceptionDto exceptionDto = new ExceptionDto();
            exceptionDto.setErrorMessage(e.getMessage());
            return ResponseEntity.badRequest().body(exceptionDto);
        }

        var recordId = tDocumentCenterCategoryEntity.getCategoryId();
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId(String.valueOf(recordId));
        return ResponseEntity.ok().body(recordDto);
    }

    @PostMapping(value = "/v1/document-center/category/list")
    public ResponseEntity<Object> getDocumentCenterCategoryList(){
        return ResponseEntity.ok().body(documentCenterService.getCategoryList());
    }

    @PostMapping(value = "/v1/document-center/visibility/list")
    public ResponseEntity<Object> getDocumentCenterCategoryList(@RequestBody RequestParameter requestParameter, HttpServletRequest httpServletRequest)  {

        var httpUtil = new HttpUtil();
        try {
            var visibilityEntityList = documentCenterService.findTDocumentCenterVisibilityListByDocumentCenterId(requestParameter);
            String logResponse = httpUtil.logResponseRequest(httpServletRequest,requestParameter,logConfig,visibilityEntityList,null);
            return ResponseEntity.ok().body(visibilityEntityList);
        } catch (IOException e){
            String logResponse = null;
            try {
                logResponse = httpUtil.logResponseRequest(httpServletRequest,requestParameter,logConfig,null,e.getLocalizedMessage());
            } catch (IOException ex) {
                return ResponseEntity.badRequest().body(ex);
            }
            return ResponseEntity.badRequest().body(logResponse);
        }

    }


}
