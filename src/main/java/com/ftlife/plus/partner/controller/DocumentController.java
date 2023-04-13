package com.ftlife.plus.partner.controller;

import com.ftlife.plus.partner.dto.DocumentDto;
import com.ftlife.plus.partner.dto.RecordDto;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.service.DocumentService;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@CrossOrigin(origins = {"http://172.29.9.104:3000/", "http://localhost:3000/","http://10.20.145.30:3000"})
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @PostMapping(value = "v1/document/upload")
    public ResponseEntity<Object> documentUpload(@RequestBody RequestParameter requestParameter) throws ParseException, JSchException, SftpException {
        if (requestParameter.getDocumentParameter() != null){
            try {
                long docId = documentService.uploadFile(requestParameter);
                RecordDto recordDto = new RecordDto();
                recordDto.setReferenceId(String.valueOf(docId));
                return ResponseEntity.ok().body(recordDto);
            } catch (JSchException e) {
                throw new JSchException();
            } catch (SftpException e) {
                throw new SftpException(1, e.getMessage());
            }

        }else
            return ResponseEntity.badRequest().body("invalid input");
    }

    @PostMapping(value = "v1/document/download")
    public ResponseEntity<Object> documentDownload(@RequestBody RequestParameter requestParameter) throws JSchException, SftpException, IOException {
        DocumentDto documentDto = documentService.downloadDocument(requestParameter);
        return ResponseEntity.ok().body(documentDto);
    }

}
