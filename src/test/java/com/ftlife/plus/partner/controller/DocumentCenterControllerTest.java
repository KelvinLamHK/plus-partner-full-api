package com.ftlife.plus.partner.controller;

import com.ftlife.plus.partner.configuration.LogConfig;
import com.ftlife.plus.partner.dto.*;
import com.ftlife.plus.partner.entity.*;
import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.service.DocumentCenterService;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.TestExecutionListeners;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DocumentCenterControllerTest {

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    LogConfig logConfig;

    @Mock
    DocumentCenterService documentCenterService;

    @InjectMocks
    DocumentCenterController documentCenterController = new DocumentCenterController();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    RequestParameter requestParameter = new RequestParameter();
    PageableParameter pageableParameter = new PageableParameter();
    UserParameter userParameter = new UserParameter();
    DocumentCenterCategoryParameter documentCenterCategoryParameter = new DocumentCenterCategoryParameter();

    @Test
    public void testSaveOrUpdateCampaignHeader() throws ParseException {
        TDocumentCenterEntity tDocumentCenterEntity = new TDocumentCenterEntity();
        tDocumentCenterEntity.setDocumentCenterId(11);

        doReturn(tDocumentCenterEntity).when(documentCenterService).createOrUpdateDocumentCenterRecord(any(RequestParameter.class));

        assertEquals("11",((RecordDto) documentCenterController.saveOrUpdateDocumentCenter(requestParameter).getBody()).getReferenceId());
        verify(documentCenterService, times(1)).createOrUpdateDocumentCenterRecord(any(RequestParameter.class));
    }

    @Test
    public void testGetBrokerList(){
        List<TBrokerEntity> tBrokerEntityList = new ArrayList<>();

        doReturn(tBrokerEntityList).when(documentCenterService).getBrokerList();

        assertEquals(tBrokerEntityList, documentCenterController.getBrokerList().getBody());
        verify(documentCenterService, times(1)).getBrokerList();
    }

    @Test
    public void testGetBrokerListDto() {
        var tBrokerEntity = new TBrokerEntity();
        var tBrokerEntity2 = new TBrokerEntity();
        var tBrokerEntityArrayList = new ArrayList<TBrokerEntity>();
        tBrokerEntityArrayList.add(tBrokerEntity);
        tBrokerEntityArrayList.add(tBrokerEntity2);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(0);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(1);
        requestParameter.setPageableParameter(pageableParameter);
        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        var pageable = querySetupUtil.setPageable(requestParameter);
        var tBrokerEntityPage = new PageImpl<>(tBrokerEntityArrayList,pageable, tBrokerEntityArrayList.size()) ;
        BrokerListDto brokerListDto = new BrokerListDto(tBrokerEntityPage);

        doReturn(brokerListDto).when(documentCenterService).getBrokerListPage(any(RequestParameter.class));

        assertEquals(brokerListDto.getBrokerList().size(), ((BrokerListDto)documentCenterController.getBrokerListDto(requestParameter).getBody()).getBrokerList().size());
        verify(documentCenterService, times(1)).getBrokerListPage(any(RequestParameter.class));
    }

    @Test
    public void testGetDocumentCenterList() throws ParseException {
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(9);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(111);
        requestParameter.setPageableParameter(pageableParameter);
        VDocumentCenterEntity vDocumentCenterEntity = new VDocumentCenterEntity();
        List<VDocumentCenterEntity> vDocumentCenterEntityArrayList = new ArrayList<>();
        vDocumentCenterEntityArrayList.add(vDocumentCenterEntity);
        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        var pageable = querySetupUtil.setPageable(requestParameter);
        Page<VDocumentCenterEntity> vDocumentCenterEntityPage = new PageImpl<>(vDocumentCenterEntityArrayList,pageable,vDocumentCenterEntityArrayList.size());
        DocumentCenterListDto documentCenterListDto = new DocumentCenterListDto(vDocumentCenterEntityPage);

        doReturn(documentCenterListDto).when(documentCenterService).findDocumentCenterListByCriteria(any(RequestParameter.class));

        assertEquals(documentCenterListDto.getPagination().getPageSize(), ((DocumentCenterListDto) documentCenterController.getDocumentCenterList(requestParameter).getBody()).getPagination().getPageSize());
        assertEquals(documentCenterListDto.getPagination().getPageNumber(), ((DocumentCenterListDto) documentCenterController.getDocumentCenterList(requestParameter).getBody()).getPagination().getPageNumber());
        verify(documentCenterService, times(2)).findDocumentCenterListByCriteria(any(RequestParameter.class));
    }

    @Test
    public void testSaveOrUpdateDocumentCenterCategory() throws Exception {
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentCenterCategoryParameter(documentCenterCategoryParameter);

        TDocumentCenterCategoryEntity tDocumentCenterCategoryEntity = new TDocumentCenterCategoryEntity(requestParameter);
        tDocumentCenterCategoryEntity.setCategoryId(11);
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId("11");

        doReturn(tDocumentCenterCategoryEntity).when(documentCenterService).createOrUpdateDocumentCenterCategory(any(RequestParameter.class));

        assertEquals(recordDto.getReferenceId(),((RecordDto) documentCenterController.saveOrUpdateDocumentCenterCategory(requestParameter).getBody()).getReferenceId());
        verify(documentCenterService, times(1)).createOrUpdateDocumentCenterCategory(any(RequestParameter.class));

        doThrow(new NullPointerException()).when(documentCenterService).createOrUpdateDocumentCenterCategory(any(RequestParameter.class));
        assertEquals(ExceptionDto.class,(documentCenterController.saveOrUpdateDocumentCenterCategory(requestParameter).getBody()).getClass());


    }

    @Test
    public void testGetDocumentCenterCategoryList(){
        TDocumentCenterVisibilityEntity tDocumentCenterVisibilityEntity = new TDocumentCenterVisibilityEntity();
        List<TDocumentCenterVisibilityEntity> tDocumentCenterVisibilityEntityList = new ArrayList<>();
        tDocumentCenterVisibilityEntityList.add(tDocumentCenterVisibilityEntity);
        doReturn(tDocumentCenterVisibilityEntityList).when(documentCenterService).findTDocumentCenterVisibilityListByDocumentCenterId(any(RequestParameter.class));
        doReturn("localhost:6379").when(logConfig).getApplicationName();
        doReturn("https://dev-plus-log-api.apps.ocpuat.interconnect.systems/v1/log").when(logConfig).getLogUrl();
        doReturn("https://dev-plus-log-api.apps.ocpuat.interconnect.systems/v1/log").when(httpServletRequest).getRequestURI();
        doReturn("localhost:6379").when(httpServletRequest).getRemoteAddr();
        documentCenterController.getDocumentCenterCategoryList(requestParameter, httpServletRequest);
        verify(documentCenterService, times(1)).findTDocumentCenterVisibilityListByDocumentCenterId(any(RequestParameter.class));

        doReturn("error").when(logConfig).getApplicationName();
        doReturn("error").when(logConfig).getLogUrl();
        doReturn("error").when(httpServletRequest).getRequestURI();
        doReturn("error").when(httpServletRequest).getRemoteAddr();
       documentCenterController.getDocumentCenterCategoryList(requestParameter, httpServletRequest);
    }

    @Test
    public void testGetDocumentCenterCategoryList1(){
        DocumentCenterCategoryListDto documentCenterCategoryListDto = new DocumentCenterCategoryListDto();
        doReturn(documentCenterCategoryListDto).when(documentCenterService).getCategoryList();
        documentCenterController.getDocumentCenterCategoryList();
    }

}
