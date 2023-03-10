package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.dto.DocumentDto;
import com.ftlife.plus.partner.entity.TDocumentEntity;
import com.ftlife.plus.partner.parameter.RequestParameter;

import java.io.IOException;
import java.text.ParseException;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

public interface DocumentService {
    long uploadFile (RequestParameter requestParameter) throws JSchException, SftpException, ParseException;

    long createDocumentRecord (TDocumentEntity tDocumentEntity);

    DocumentDto downloadDocument(RequestParameter requestParameter) throws JSchException, SftpException, IOException;

}
