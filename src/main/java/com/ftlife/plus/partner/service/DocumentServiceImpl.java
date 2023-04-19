package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.configuration.SMBConfig;
import com.ftlife.plus.partner.dto.DocumentDto;
import com.ftlife.plus.partner.entity.TDocumentEntity;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.repository.TDocumentRepository;
import com.ftlife.plus.partner.util.SmbUtil;
import com.hierynomus.smbj.share.DiskShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    SMBConfig smbConfig;

    @Autowired
    private TDocumentRepository tDocumentRepository;

    @Override
    public long uploadFile(RequestParameter requestParameter) throws ParseException {
        String filePathString = requestParameter.getDocumentParameter().getDocumentCategory()+"/" + System.currentTimeMillis() +"/";
        String fileFullPathString = filePathString + requestParameter.getDocumentParameter().getDocumentName();
        try (DiskShare diskShare = SmbUtil.getDiskShare(smbConfig)) {
            SmbUtil.uploadDocument(diskShare, requestParameter.getDocumentParameter().getBase64FileString(), fileFullPathString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TDocumentEntity tDocumentEntity = new TDocumentEntity(requestParameter, filePathString);

        return createDocumentRecord(tDocumentEntity);
    }

    @Override
    public long createDocumentRecord(TDocumentEntity tDocumentEntity) {
        tDocumentRepository.save(tDocumentEntity);
        return tDocumentEntity.getDocumentId();
    }

    @Override
    public DocumentDto downloadDocument(RequestParameter requestParameter) throws IOException {
        String documentBase64String;
        TDocumentEntity tDocumentEntity = tDocumentRepository.findById(Long.parseLong(requestParameter.getDocumentParameter().getDocumentId())).orElse(null);
        String documentFullPath = null;

        if (tDocumentEntity != null) {
            documentFullPath = tDocumentEntity.getSourcePath() + "/"+tDocumentEntity.getDocumentName();
            try (DiskShare diskShare = SmbUtil.getDiskShare(smbConfig)) {
                documentBase64String = SmbUtil.downloadDocument(diskShare, documentFullPath);
            }
        } else {
            documentBase64String = null;
        }

        return new DocumentDto(tDocumentEntity, documentBase64String);
    }

}