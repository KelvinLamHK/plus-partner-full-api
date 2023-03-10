package com.ftlife.plus.partner.controller;

import com.ftlife.plus.partner.dto.DocumentDto;
import com.ftlife.plus.partner.dto.RecordDto;
import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.service.DocumentService;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DocumentControllerTest {

    @Mock
    DocumentService documentService;

    @InjectMocks
    DocumentController documentController = new DocumentController();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    RequestParameter requestParameter = new RequestParameter();
    DocumentParameter documentParameter = new DocumentParameter();


    @Test
    public void testDocumentUploadNullDocumentParameter() throws ParseException, JSchException, SftpException {
        assertEquals("invalid input", documentController.documentUpload(requestParameter).getBody());
    }

    @Test
    public void testDocumentUpload() throws ParseException, JSchException, SftpException {
        requestParameter.setDocumentParameter(documentParameter);

        long docId = 1;
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId(String.valueOf(docId));

        doReturn(docId).when(documentService).uploadFile(any(RequestParameter.class));

        assertEquals(recordDto.getReferenceId(), ((RecordDto) documentController.documentUpload(requestParameter).getBody()).getReferenceId());
    }


    @Test
    public void testDocumentUploadJSchException() throws ParseException, JSchException, SftpException {
        requestParameter.setDocumentParameter(documentParameter);
        JSchException e = new JSchException();

        doThrow(e).when(documentService).uploadFile(any(RequestParameter.class));

        assertThrows(JSchException.class, () -> {
            documentController.documentUpload(requestParameter);
        });

    }

    @Test
    public void testDocumentUploadSftpException() throws ParseException, JSchException, SftpException {
        requestParameter.setDocumentParameter(documentParameter);
        SftpException e = new SftpException(1, "fds");

        doThrow(e).when(documentService).uploadFile(any(RequestParameter.class));

        assertThrows(SftpException.class, () -> {
            documentController.documentUpload(requestParameter);
        });

    }

    @Test
    public void testDocumentDownload() throws JSchException, SftpException, IOException, ParseException {
        DocumentDto documentDto = new DocumentDto();
        documentDto.setDocumentName("testName");
        doReturn(documentDto).when(documentService).downloadDocument(any(RequestParameter.class));
        assertEquals(documentDto.getDocumentName(), ((DocumentDto)documentController.documentDownload(requestParameter).getBody()).getDocumentName());
    }


}
