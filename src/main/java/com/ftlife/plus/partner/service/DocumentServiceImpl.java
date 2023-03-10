package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.configuration.SFTPConfig;
import com.ftlife.plus.partner.dto.DocumentDto;
import com.ftlife.plus.partner.entity.TDocumentEntity;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.repository.TDocumentRepository;
import com.ftlife.plus.partner.util.SftpUtil;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    SFTPConfig sftpConfig;

    @Autowired
    private TDocumentRepository tDocumentRepository;

    @Override
    public long uploadFile(RequestParameter requestParameter) throws JSchException, SftpException, ParseException {
        SftpUtil sftpUtil = new SftpUtil();
        String filePathString = requestParameter.getDocumentParameter().getDocumentCategory()+"/" + System.currentTimeMillis() + "/" ;
        String fileFullPathString = filePathString + requestParameter.getDocumentParameter().getDocumentName();
        sftpUtil.uploadDocument(sftpConfig,requestParameter.getDocumentParameter().getBase64FileString(),fileFullPathString);

        TDocumentEntity tDocumentEntity = new TDocumentEntity(requestParameter, filePathString);

        return createDocumentRecord(tDocumentEntity);
    }

    @Override
    public long createDocumentRecord(TDocumentEntity tDocumentEntity) {
        tDocumentRepository.save(tDocumentEntity);
        return tDocumentEntity.getDocumentId();
    }

    @Override
    public DocumentDto downloadDocument(RequestParameter requestParameter) throws JSchException, SftpException, IOException {
        SftpUtil sftpUtil = new SftpUtil();
        TDocumentEntity tDocumentEntity = tDocumentRepository.findById(Long.parseLong(requestParameter.getDocumentParameter().getDocumentId())).orElse(null);
        String documentFullPath = null;
        String documentBase64String = null;

        if (tDocumentEntity != null) {
            documentFullPath = tDocumentEntity.getSourcePath() + tDocumentEntity.getDocumentName();
            documentBase64String = sftpUtil.downloadDocument(sftpConfig,documentFullPath);
        }

        return new DocumentDto(tDocumentEntity,documentBase64String);
    }

}
