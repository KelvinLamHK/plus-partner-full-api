package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.entity.TDocumentEntity;
import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.repository.TDocumentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class DocumentServiceImplTest {

    @Mock
    private TDocumentRepository tDocumentRepository;

    @InjectMocks
    private static DocumentService documentService = new DocumentServiceImpl();

    RequestParameter requestParameter = new RequestParameter();
    PolicyListParameter policyListParameter = new PolicyListParameter();
    PageableParameter pageableParameter = new PageableParameter();
    DocumentParameter documentParameter = new DocumentParameter();
    UserParameter userParameter = new UserParameter();
    DocumentCenterParameter documentCenterParameter = new DocumentCenterParameter();
    CampaignListParameter campaignListParameter = new CampaignListParameter();
    CampaignHeaderParameter campaignHeaderParameter = new CampaignHeaderParameter();
    CampaignDetailParameter campaignDetailParameter = new CampaignDetailParameter();
    CampaignDetailListParameter campaignDetailListParameter = new CampaignDetailListParameter();
    DocumentCenterCategoryParameter documentCenterCategoryParameter = new DocumentCenterCategoryParameter();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void TestCreateDocumentRecord(){
        TDocumentEntity tDocumentEntity = new TDocumentEntity();
        tDocumentEntity.setDocumentId(1);
        assertEquals(tDocumentEntity.getDocumentId(),documentService.createDocumentRecord(tDocumentEntity));
    }

}
