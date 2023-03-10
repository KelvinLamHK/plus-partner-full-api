package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.dto.*;
import com.ftlife.plus.partner.entity.*;
import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.repository.*;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import com.ftlife.plus.partner.util.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class DocumentCenterServiceImplTest {

    @Mock
    private TDocumentCenterCategoryRepository tDocumentCenterCategoryRepository;

    @Mock
    private TDocumentCenterVisibilityRepository tDocumentCenterVisibilityRepository;
    @Mock
    private VDocumentCenterRepository vDocumentCenterRepository;
    @Mock
    TBrokerRepository tBrokerRepository;
    @Mock
    private TDocumentCenterRepository tDocumentCenterRepository;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public DocumentCenterServiceImplTest() throws ParseException {
    }

    @InjectMocks
    private static DocumentCenterService documentCenterService = new DocumentCenterServiceImpl();

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
    public void testCreateOrUpdateDocumentCenterRecord() throws ParseException {
        documentCenterParameter.setDocumentCenterId("1");
        requestParameter.setDocumentCenterParameter(documentCenterParameter);
        requestParameter.setPolicyListParameter(policyListParameter);
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentParameter(documentParameter);
        requestParameter.setPageableParameter(pageableParameter);
        requestParameter.setCampaignListParameter(campaignListParameter);
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        requestParameter.setCampaignDetailParameter(campaignDetailParameter);
        requestParameter.setCampaignDetailListParameter(campaignDetailListParameter);

        TDocumentCenterEntity tDocumentCenterEntitySetUp = new TDocumentCenterEntity();
        tDocumentCenterEntitySetUp.setCreatedBy("a");
        tDocumentCenterEntitySetUp.setCreatedDate(date);
        tDocumentCenterEntitySetUp.setDescriptionEnglish("a");
        tDocumentCenterEntitySetUp.setDescriptionSimplifiedChinese("a");
        tDocumentCenterEntitySetUp.setDescriptionTraditionalChinese("a");
        tDocumentCenterEntitySetUp.setDocumentCenterId(0);
        tDocumentCenterEntitySetUp.setDocumentStatus("a");
        tDocumentCenterEntitySetUp.setEffectiveDateFrom(date);
        tDocumentCenterEntitySetUp.setEffectiveDateTo(date);
        tDocumentCenterEntitySetUp.setFile1Id(0);
        tDocumentCenterEntitySetUp.setFile2Id(0);
        tDocumentCenterEntitySetUp.setFile3Id(0);
        tDocumentCenterEntitySetUp.setLevel1CategoryId(0);
        tDocumentCenterEntitySetUp.setLevel2CategoryId(0);
        tDocumentCenterEntitySetUp.setTitleEnglish("a");
        tDocumentCenterEntitySetUp.setTitleSimplifiedChinese("a");
        tDocumentCenterEntitySetUp.setTitleTraditionalChinese("a");
        tDocumentCenterEntitySetUp.setUpdatedBy("a");
        tDocumentCenterEntitySetUp.setUpdatedDate(date);
        doReturn(tDocumentCenterEntitySetUp).when(tDocumentCenterRepository).save(any(TDocumentCenterEntity.class));

        TDocumentCenterEntity tDocumentCenterEntity = new TDocumentCenterEntity(requestParameter, tDocumentCenterEntitySetUp);

        assertEquals(tDocumentCenterEntity.getDocumentCenterId(),documentCenterService.createOrUpdateDocumentCenterRecord(requestParameter).getDocumentCenterId());

    }

    @Test
    public void testFindDocumentCenterListByCriteria() throws ParseException {
        var now = new Date();
        userParameter.setLoginName("a");
        userParameter.setName("a");
        userParameter.setCompanyName("a");
        userParameter.setCompanyID("a");
        userParameter.setEmail("a");
        userParameter.setBrokerCode("a");
        userParameter.setIfaIdentity("a");
        userParameter.setPibaNumber("a");
        userParameter.setIfaCaNameEng("a");
        userParameter.setIfaCaNameOther("a");
        userParameter.setIfaCaLicenseNumber("a");
        userParameter.setRole("a");
        requestParameter.setUserParameter(userParameter);
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setCategoryZHCN("a");
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setUpperCategoryId("1");
        requestParameter.setDocumentCenterCategoryParameter(documentCenterCategoryParameter);
        requestParameter.setPolicyListParameter(policyListParameter);
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentParameter(documentParameter);
        requestParameter.setPageableParameter(pageableParameter);
        requestParameter.setCampaignListParameter(campaignListParameter);
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        requestParameter.setCampaignDetailParameter(campaignDetailParameter);
        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        var tCampaignHeaderEntity = new TCampaignHeaderEntity();
        var tCampaignHeaderEntityList = new ArrayList<TCampaignHeaderEntity>();
        tCampaignHeaderEntityList.add(tCampaignHeaderEntity);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(0);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(1);
        requestParameter.setPageableParameter(pageableParameter);

        Pageable pageable = querySetupUtil.setPageable(requestParameter);
        Page<TCampaignHeaderEntity> tCampaignHeaderEntityPage = new PageImpl<>(tCampaignHeaderEntityList, pageable,
                tCampaignHeaderEntityList.size());
        var campaignListDto = new CampaignListDto(tCampaignHeaderEntityPage);

        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(0);
        pageableParameter.setOrderSequence("desc");
        pageableParameter.setPageSize(1);
        requestParameter.setPageableParameter(pageableParameter);

        campaignListDto.getCampaignList();
        campaignListDto.getPagination();
        campaignListDto.setCampaignList(tCampaignHeaderEntityList);

        PageableDto pageableDto = new PageableDto();
        pageableDto.setPageNumber(9);
        pageableDto.setPageSize(0);
        pageableDto.setHasNext(true);
        pageableDto.setTotalPages(0);
        pageableDto.setTotalNumberOfRecords(0);
        campaignListDto.setPagination(pageableDto);

        GenericSpecification genericSpecification = querySetupUtil
                .setCampaignListWhereClause(requestParameter);

        var vDocumentCenterEntity = new VDocumentCenterEntity();
        var vDocumentCenterEntityList = new ArrayList<VDocumentCenterEntity>();
        DocumentCenterParameter documentCenterParameter = new DocumentCenterParameter();

        documentCenterParameter.setTitleEnglish("a");
        documentCenterParameter.setTitleTraditionalChinese("a");
        documentCenterParameter.setTitleSimplifiedChinese("a");
        documentCenterParameter.setDocumentStatus("a");
        documentCenterParameter.setLevel1CategoryId("1");
        documentCenterParameter.setLevel2CategoryId("1");
        documentCenterParameter.setDescriptionEnglish("a");
        documentCenterParameter.setDescriptionTraditionalChinese("a");
        documentCenterParameter.setDescriptionSimplifiedChinese("a");
        documentCenterParameter.setFile1Id("1");
        documentCenterParameter.setFile2Id("1");
        documentCenterParameter.setFile3Id("1");
        documentCenterParameter.setEffectiveDateFrom("2022-01-01");
        documentCenterParameter.setEffectiveDateTo("2022-01-01");
        documentCenterParameter.setCreatedDateFrom("2022-01-01");
        documentCenterParameter.setCreatedDateTo("2022-01-01");
        documentCenterParameter.setUpdatedDateFrom("2022-01-01");
        documentCenterParameter.setUpdatedDateTo("2022-01-01");
        documentCenterParameter.setIsPin("a");
        documentCenterParameter.setIsPromo("a");
        documentCenterParameter.setIfaCaIndicator("a");
        String visibility[]={"1","2","3"};
        documentCenterParameter.setVisibilityList(visibility);
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentCenterParameter(documentCenterParameter);

        genericSpecification.add(new SearchCriteria("agentCode", requestParameter.getUserParameter().getBrokerCode(), SearchOperation.EXIST_DOCUMENT_CENTER));
        genericSpecification.add(new SearchCriteria("titleEnglish", documentCenterParameter.getTitleEnglish(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("titleTraditionalChinese", documentCenterParameter.getTitleTraditionalChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("titleSimplifiedChinese", documentCenterParameter.getTitleSimplifiedChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("documentStatus", documentCenterParameter.getDocumentStatus(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("level1CategoryId", Integer.parseInt(documentCenterParameter.getLevel1CategoryId()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("level2CategoryId", Integer.parseInt(documentCenterParameter.getLevel2CategoryId()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("descriptionEnglish", documentCenterParameter.getDescriptionEnglish(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("descriptionTraditionalChinese", documentCenterParameter.getDescriptionTraditionalChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("descriptionSimplifiedChinese", documentCenterParameter.getDescriptionSimplifiedChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("file1Id", Long.parseLong(documentCenterParameter.getFile1Id()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("file2Id", Long.parseLong(documentCenterParameter.getFile2Id()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("file3Id", Long.parseLong(documentCenterParameter.getFile3Id()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("effectiveDateFrom", StringUtil.stringToDate(documentCenterParameter.getEffectiveDateFrom(), "yyyy-MM-dd"), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("effectiveDateTo", StringUtil.stringToDate(documentCenterParameter.getEffectiveDateTo(), "yyyy-MM-dd"), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("createdDate", StringUtil.stringToDate(documentCenterParameter.getCreatedDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("createdDate", StringUtil.stringToDate(documentCenterParameter.getCreatedDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("updatedDate", StringUtil.stringToDate(documentCenterParameter.getUpdatedDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("updatedDate", StringUtil.stringToDate(documentCenterParameter.getUpdatedDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("isPin", documentCenterParameter.getIsPin(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("isPromo", documentCenterParameter.getIsPromo(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("ifaCaIndicator", documentCenterParameter.getIfaCaIndicator(), SearchOperation.MATCH));

        vDocumentCenterEntityList.add(vDocumentCenterEntity);
        Page<VDocumentCenterEntity> vDocumentCenterEntityPage = new PageImpl<>(vDocumentCenterEntityList,  pageable,vDocumentCenterEntityList.size() );
        doReturn(vDocumentCenterEntityPage).when(vDocumentCenterRepository).findAll(any(GenericSpecification.class),
                any(Pageable.class));

        assertEquals(DocumentCenterListDto.class,documentCenterService.findDocumentCenterListByCriteria(requestParameter).getClass());

    }

    @Test
    public void TestGetCategoryList_foreach_t(){
        var now = new Date();
        UserParameter userParameter = new UserParameter();
        userParameter.setLoginName("a");
        userParameter.setName("a");
        userParameter.setCompanyName("a");
        userParameter.setCompanyID("a");
        userParameter.setEmail("a");
        userParameter.setBrokerCode("a");
        userParameter.setIfaIdentity("a");
        userParameter.setPibaNumber("a");
        userParameter.setIfaCaNameEng("a");
        userParameter.setIfaCaNameOther("a");
        userParameter.setIfaCaLicenseNumber("a");
        userParameter.setRole("internal-admin");
        requestParameter.setUserParameter(userParameter);
        DocumentCenterCategoryParameter documentCenterCategoryParameter = new DocumentCenterCategoryParameter();
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setCategoryZHCN("a");
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setUpperCategoryId("0");
        requestParameter.setDocumentCenterCategoryParameter(documentCenterCategoryParameter);
        TDocumentCenterCategoryEntity tDocumentCenterCategoryEntity = new TDocumentCenterCategoryEntity(requestParameter);
        TDocumentCenterCategoryEntity tDocumentCenterCategoryEntity2 = new TDocumentCenterCategoryEntity(requestParameter);
        TDocumentCenterCategoryEntity tDocumentCenterCategoryEntity3 = new TDocumentCenterCategoryEntity(requestParameter);
        List<TDocumentCenterCategoryEntity> tDocumentCenterCategoryEntityList = new ArrayList<>();
        tDocumentCenterCategoryEntityList.add(tDocumentCenterCategoryEntity);
        tDocumentCenterCategoryEntityList.add(tDocumentCenterCategoryEntity2);
        tDocumentCenterCategoryEntityList.add(tDocumentCenterCategoryEntity3);
        doReturn(tDocumentCenterCategoryEntityList).when(tDocumentCenterCategoryRepository).findAll();
        assertEquals(DocumentCenterCategoryListDto.class,documentCenterService.getCategoryList().getClass());
    }

    @Test
    public void TestgetCategoryList_foreach_level2(){
        var now = new Date();
        UserParameter userParameter = new UserParameter();
        userParameter.setLoginName("a");
        userParameter.setName("a");
        userParameter.setCompanyName("a");
        userParameter.setCompanyID("a");
        userParameter.setEmail("a");
        userParameter.setBrokerCode("a");
        userParameter.setIfaIdentity("a");
        userParameter.setPibaNumber("a");
        userParameter.setIfaCaNameEng("a");
        userParameter.setIfaCaNameOther("a");
        userParameter.setIfaCaLicenseNumber("a");
        userParameter.setRole("a");
        requestParameter.setUserParameter(userParameter);
        DocumentCenterCategoryParameter documentCenterCategoryParameter = new DocumentCenterCategoryParameter();
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setCategoryZHCN("a");
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setUpperCategoryId("1");
        requestParameter.setDocumentCenterCategoryParameter(documentCenterCategoryParameter);
        TDocumentCenterCategoryEntity tDocumentCenterCategoryEntity = new TDocumentCenterCategoryEntity(requestParameter);
        TDocumentCenterCategoryEntity tDocumentCenterCategoryEntity2 = new TDocumentCenterCategoryEntity(requestParameter);
        TDocumentCenterCategoryEntity tDocumentCenterCategoryEntity3 = new TDocumentCenterCategoryEntity(requestParameter);
        List<TDocumentCenterCategoryEntity> tDocumentCenterCategoryEntityList = new ArrayList<>();
        tDocumentCenterCategoryEntityList.add(tDocumentCenterCategoryEntity);
        tDocumentCenterCategoryEntityList.add(tDocumentCenterCategoryEntity2);
        tDocumentCenterCategoryEntityList.add(tDocumentCenterCategoryEntity3);
        doReturn(tDocumentCenterCategoryEntityList).when(tDocumentCenterCategoryRepository).findAll();
        assertEquals(DocumentCenterCategoryListDto.class,documentCenterService.getCategoryList().getClass() );
    }

    @Test
    public void TestCreateOrUpdateDocumentCenterCategory() throws Exception {
        var now = new Date();
        userParameter.setLoginName("a");
        userParameter.setName("a");
        userParameter.setCompanyName("a");
        userParameter.setCompanyID("a");
        userParameter.setEmail("a");
        userParameter.setBrokerCode("a");
        userParameter.setIfaIdentity("a");
        userParameter.setPibaNumber("a");
        userParameter.setIfaCaNameEng("a");
        userParameter.setIfaCaNameOther("a");
        userParameter.setIfaCaLicenseNumber("a");
        userParameter.setRole("a");
        requestParameter.setUserParameter(userParameter);
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setCategoryZHCN("a");
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setUpperCategoryId("0");
        requestParameter.setDocumentCenterCategoryParameter(documentCenterCategoryParameter);
        requestParameter.setPolicyListParameter(policyListParameter);
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentParameter(documentParameter);
        requestParameter.setPageableParameter(pageableParameter);
        requestParameter.setCampaignListParameter(campaignListParameter);
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        requestParameter.setCampaignDetailParameter(campaignDetailParameter);
        TDocumentCenterCategoryEntity tDocumentCenterCategoryEntity = new TDocumentCenterCategoryEntity(requestParameter);
        doReturn(tDocumentCenterCategoryEntity).when(tDocumentCenterCategoryRepository).save(any(TDocumentCenterCategoryEntity.class));
        assertEquals(tDocumentCenterCategoryEntity,documentCenterService.createOrUpdateDocumentCenterCategory(requestParameter));

    }

    @Test
    public void testGetBrokerList(){
        List<TBrokerEntity> tBrokerEntityList = new ArrayList<>();
        doReturn(tBrokerEntityList).when(tBrokerRepository).findAll();
        assertEquals(tBrokerEntityList, documentCenterService.getBrokerList());
    }

    @Test
    public void testGetBrokerListPage(){
        userParameter.setLoginName("a");
        userParameter.setName("a");
        userParameter.setCompanyName("a");
        userParameter.setCompanyID("a");
        userParameter.setEmail("a");
        userParameter.setBrokerCode("a");
        userParameter.setIfaIdentity("a");
        userParameter.setPibaNumber("a");
        userParameter.setIfaCaNameEng("a");
        userParameter.setIfaCaNameOther("a");
        userParameter.setIfaCaLicenseNumber("a");
        userParameter.setRole("a");
        requestParameter.setUserParameter(userParameter);
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setCategoryZHCN("a");
        documentCenterCategoryParameter.setCategoryEnglish("a");
        documentCenterCategoryParameter.setUpperCategoryId("1");
        requestParameter.setDocumentCenterCategoryParameter(documentCenterCategoryParameter);
        requestParameter.setPolicyListParameter(policyListParameter);
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentParameter(documentParameter);
        requestParameter.setPageableParameter(pageableParameter);
        requestParameter.setCampaignListParameter(campaignListParameter);
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        requestParameter.setCampaignDetailParameter(campaignDetailParameter);
        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        var tCampaignHeaderEntity = new TCampaignHeaderEntity();
        var tCampaignHeaderEntityList = new ArrayList<TCampaignHeaderEntity>();
        tCampaignHeaderEntityList.add(tCampaignHeaderEntity);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(0);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(1);
        requestParameter.setPageableParameter(pageableParameter);
        TBrokerEntity tBrokerEntity = new TBrokerEntity();
        List<TBrokerEntity> brokerList = new ArrayList<>();
        brokerList.add(tBrokerEntity);
        Pageable pageable = querySetupUtil.setPageable(requestParameter);
        Page<TBrokerEntity> tBrokerEntityPage = new PageImpl<>(brokerList,pageable,brokerList.size()  );
        doReturn(tBrokerEntityPage).when(tBrokerRepository).findAll(any(Pageable.class));

        assertEquals(BrokerListDto.class, documentCenterService.getBrokerListPage(requestParameter).getClass());
    }

    @Test
    public void testFindTDocumentCenterVisibilityListByDocumentCenterId(){
        long ans = 1;
        List<TDocumentCenterVisibilityEntity> tDocumentCenterVisibilityEntityList = new ArrayList<>();
        documentCenterParameter.setDocumentCenterId("1");
        requestParameter.setDocumentCenterParameter(documentCenterParameter);
        doReturn(tDocumentCenterVisibilityEntityList).when(tDocumentCenterVisibilityRepository).findByDocumentCenterId(anyLong());
        documentCenterService.findTDocumentCenterVisibilityListByDocumentCenterId(requestParameter);
    }
}
