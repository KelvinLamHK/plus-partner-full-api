package com.ftlife.plus.partner.controller;

import com.ftlife.plus.partner.configuration.LogConfig;
import com.ftlife.plus.partner.dto.CampaignDetailListDto;
import com.ftlife.plus.partner.dto.CampaignListDto;
import com.ftlife.plus.partner.dto.ExceptionDto;
import com.ftlife.plus.partner.dto.RecordDto;
import com.ftlife.plus.partner.entity.VCampaignDetailAgentEntity;
import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.service.CampaignService;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CampaignControllerTest {

    @Mock
    CampaignService campaignService;
    @Mock
    HttpServletRequest httpServletRequest;
    @Mock
    LogConfig logConfig;

    @InjectMocks
    CampaignController campaignController = new CampaignController();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    RequestParameter requestParameter = new RequestParameter();
    UserParameter userParameter = new UserParameter();
    CampaignHeaderParameter campaignHeaderParameter = new CampaignHeaderParameter();


    @Test
    public void testGetCampaignListByCriteria() throws ParseException{
        userParameter.setLoginName("IFA-0317543-00006");
        userParameter.setName("XXXXXXXX Wong");
        userParameter.setCompanyID("IFA");
        userParameter.setEmail("xxxxxxxxxxxx@iamlegacy.com");
        userParameter.setBrokerCode("0328693;0317543;0328693;0328693");
        userParameter.setIfaIdentity("USER");
        userParameter.setPibaNumber("PIBA-0433-022049");
        userParameter.setIfaCaNameEng("XXXX Ip Wun");
        userParameter.setIfaCaNameOther("IA9205");
        userParameter.setCompanyName(null);
        userParameter.setIfaCaLicenseNumber("TR1234");
        userParameter.setRole("internal-admin");

        campaignHeaderParameter.setCampaignCode("A0001");
        campaignHeaderParameter.setCampaignHeaderId("1");
        campaignHeaderParameter.setCampaignNameEng("A0001");
        campaignHeaderParameter.setCampaignNameZHTW("A0001中");
        campaignHeaderParameter.setCampaignNameZHCN("A0001簡");
        campaignHeaderParameter.setIfaCaIndicator("IFA/CA");
        campaignHeaderParameter.setRemark("remark");
        campaignHeaderParameter.setThumbnailDocID("12345");
        campaignHeaderParameter.setCampaignStartDate("2022-01-01");
        campaignHeaderParameter.setCampaignEndDate("2022-12-31");

        requestParameter.setUserParameter(userParameter);
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);

//        CampaignListDto campaignListDto = new CampaignListDto();
//        doReturn(campaignListDto).when(campaignService).findCampaignListByCriteria(any(RequestParameter.class));
//        doReturn("localhost:6379").when(logConfig).getApplicationName();
//        doReturn("https://dev-plus-log-api.apps.ocpuat.interconnect.systems/v1/log").when(logConfig).getLogUrl();
//        doReturn("https://dev-plus-log-api.apps.ocpuat.interconnect.systems/v1/log").when(httpServletRequest).getRequestURI();
//        doReturn("localhost:6379").when(httpServletRequest).getRemoteAddr();

        campaignController.getCampaignListByCriteria(requestParameter);
        verify(campaignService, times(1)).findCampaignListByCriteria(any(RequestParameter.class));
    }

//    @Test
//    public void testGetCampaignListByCriteriaExceptionCase() throws ParseException {
//
//        userParameter.setLoginName("IFA-0317543-00006");
//        userParameter.setName("XXXXXXXX Wong");
//        userParameter.setCompanyID("IFA");
//        userParameter.setEmail("xxxxxxxxxxxx@iamlegacy.com");
//        userParameter.setBrokerCode("0328693;0317543;0328693;0328693");
//        userParameter.setIfaIdentity("USER");
//        userParameter.setPibaNumber("PIBA-0433-022049");
//        userParameter.setIfaCaNameEng("XXXX Ip Wun");
//        userParameter.setIfaCaNameOther("IA9205");
//        userParameter.setCompanyName(null);
//        userParameter.setIfaCaLicenseNumber("TR1234");
//        userParameter.setRole("internal-admin");
//        requestParameter.setUserParameter(userParameter);
//
//        assertEquals("missing campaignHeaderParameter", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
//        campaignHeaderParameter.setCampaignHeaderId("nonNumber");
//        assertEquals("campaignHeaderParameter.campaignHeaderId: incorrect format to a numeric value", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        campaignHeaderParameter.setCampaignHeaderId("11");
//        campaignHeaderParameter.setCampaignCode(null);
//        assertEquals( "missing campaignHeaderParameter.campaignCode", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        campaignHeaderParameter.setCampaignCode("A0001");
//        campaignHeaderParameter.setCampaignNameEng(null);
//        assertEquals( "missing campaignHeaderParameter.campaignNameEng", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        campaignHeaderParameter.setCampaignNameEng("A0001");
//        campaignHeaderParameter.setCampaignNameZHTW("A0001中");
//        campaignHeaderParameter.setCampaignNameZHCN("A0001簡");
//        campaignHeaderParameter.setIfaCaIndicator(null);
//        assertEquals( "missing campaignHeaderParameter.ifaCaIndicator", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        campaignHeaderParameter.setIfaCaIndicator("IFA/CA");
//        campaignHeaderParameter.setRemark("remark");
//        campaignHeaderParameter.setThumbnailDocID("wrong");
//        assertEquals( "campaignHeaderParameter.thumbnailDocID: incorrect format to a numeric value", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        campaignHeaderParameter.setThumbnailDocID("12345");
//        campaignHeaderParameter.setCampaignStartDate(null);
//        assertEquals( "missing campaignHeaderParameter.campaignStartDate", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        campaignHeaderParameter.setCampaignStartDate("2022");
//        assertEquals( "campaignHeaderParameter.campaignStartDate: Date format not match YYYY-MM-DD", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        campaignHeaderParameter.setCampaignStartDate("2022-01-01");
//        campaignHeaderParameter.setCampaignEndDate(null);
//        assertEquals( "missing campaignHeaderParameter.campaignEndDate", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        campaignHeaderParameter.setCampaignEndDate("2022");
//        assertEquals( "campaignHeaderParameter.campaignEndDate: Date format not match YYYY-MM-DD", ((ExceptionDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getErrorMessage());
//        campaignHeaderParameter.setCampaignEndDate("2022-12-31");
//
//        CampaignListDto campaignListDto = new CampaignListDto();
//        doReturn(campaignListDto).when(campaignService).findCampaignListByCriteria(any(RequestParameter.class));
//
//        assertEquals(CampaignListDto.class, ((CampaignListDto)campaignController.getCampaignListByCriteria(requestParameter).getBody()).getClass());
//        verify(campaignService, times(1)).findCampaignListByCriteria(any(RequestParameter.class));
//    }

    @Test
    public void testSaveOrUpdateCampaignHeader() throws ParseException, IOException {
        userParameter.setLoginName("IFA-0317543-00006");
        userParameter.setName("XXXXXXXX Wong");
        userParameter.setCompanyID("IFA");
        userParameter.setEmail("xxxxxxxxxxxx@iamlegacy.com");
        userParameter.setBrokerCode("0328693;0317543;0328693;0328693");
        userParameter.setIfaIdentity("USER");
        userParameter.setPibaNumber("PIBA-0433-022049");
        userParameter.setIfaCaNameEng("XXXX Ip Wun");
        userParameter.setIfaCaNameOther("IA9205");
        userParameter.setCompanyName(null);
        userParameter.setIfaCaLicenseNumber("TR1234");
        userParameter.setRole("internal-admin");

        campaignHeaderParameter.setCampaignCode("A0001");
        campaignHeaderParameter.setCampaignHeaderId("1");
        campaignHeaderParameter.setCampaignNameEng("A0001");
        campaignHeaderParameter.setCampaignNameZHTW("A0001中");
        campaignHeaderParameter.setCampaignNameZHCN("A0001簡");
        campaignHeaderParameter.setIfaCaIndicator("IFA/CA");
        campaignHeaderParameter.setRemark("remark");
        campaignHeaderParameter.setThumbnailDocID("12345");
        campaignHeaderParameter.setCampaignStartDate("2022-01-01");
        campaignHeaderParameter.setCampaignEndDate("2022-12-31");

        requestParameter.setUserParameter(userParameter);
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);

        long recordId = 11;
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId(String.valueOf(recordId));

        doReturn(recordId).when(campaignService).createOrUpdateCampaign(any(RequestParameter.class));

        assertEquals(recordDto.getReferenceId(), ((RecordDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getReferenceId());
        verify(campaignService, times(1)).createOrUpdateCampaign(any(RequestParameter.class));
    }

    @Test
    public void testSaveOrUpdateCampaignHeaderExceptionCase() throws ParseException, IOException {
        assertEquals("missing userParameter", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        requestParameter.setUserParameter(userParameter);
        userParameter.setName(null);
        assertEquals("missing userParameter.name", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        userParameter.setName("XXXXXXXX Wong");
        userParameter.setLoginName(null);
        assertEquals("missing userParameter.loginName", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        userParameter.setLoginName("IFA-0317543-00006");
        userParameter.setRole(null);
        assertEquals("missing userParameter.role", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        userParameter.setRole("internal-admin");
        userParameter.setCompanyID("IFA");
        userParameter.setEmail("xxxxxxxxxxxx@iamlegacy.com");
        userParameter.setBrokerCode("0328693;0317543;0328693;0328693");
        userParameter.setIfaIdentity("USER");
        userParameter.setPibaNumber("PIBA-0433-022049");
        userParameter.setIfaCaNameEng("XXXX Ip Wun");
        userParameter.setIfaCaNameOther("IA9205");
        userParameter.setCompanyName(null);
        userParameter.setIfaCaLicenseNumber("TR1234");

        assertEquals("missing campaignHeaderParameter", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        campaignHeaderParameter.setCampaignHeaderId("nonNumber");
        assertEquals("campaignHeaderParameter.campaignHeaderId: incorrect format to a numeric value", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        campaignHeaderParameter.setCampaignHeaderId("11");
        campaignHeaderParameter.setCampaignCode(null);
        assertEquals( "missing campaignHeaderParameter.campaignCode", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        campaignHeaderParameter.setCampaignCode("A0001");
        campaignHeaderParameter.setCampaignNameEng(null);
        assertEquals( "missing campaignHeaderParameter.campaignNameEng", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        campaignHeaderParameter.setCampaignNameEng("A0001");
        campaignHeaderParameter.setCampaignNameZHTW("A0001中");
        campaignHeaderParameter.setCampaignNameZHCN("A0001簡");
        campaignHeaderParameter.setIfaCaIndicator(null);
        assertEquals( "missing campaignHeaderParameter.ifaCaIndicator", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        campaignHeaderParameter.setIfaCaIndicator("IFA/CA");
        campaignHeaderParameter.setRemark("remark");
        campaignHeaderParameter.setThumbnailDocID("wrong");
        assertEquals( "campaignHeaderParameter.thumbnailDocID: incorrect format to a numeric value", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        campaignHeaderParameter.setThumbnailDocID("12345");
        campaignHeaderParameter.setCampaignStartDate(null);
        assertEquals( "missing campaignHeaderParameter.campaignStartDate", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        campaignHeaderParameter.setCampaignStartDate("2022");
        assertEquals( "campaignHeaderParameter.campaignStartDate: Date format not match YYYY-MM-DD", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        campaignHeaderParameter.setCampaignStartDate("2022-01-01");
        campaignHeaderParameter.setCampaignEndDate(null);
        assertEquals( "missing campaignHeaderParameter.campaignEndDate", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        campaignHeaderParameter.setCampaignEndDate("2022");
        assertEquals( "campaignHeaderParameter.campaignEndDate: Date format not match YYYY-MM-DD", ((ExceptionDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getErrorMessage());
        campaignHeaderParameter.setCampaignEndDate("2022-12-31");

        long recordId = 11;
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId(String.valueOf(recordId));

        doReturn(recordId).when(campaignService).createOrUpdateCampaign(any(RequestParameter.class));

        assertEquals(recordDto.getReferenceId(), ((RecordDto)campaignController.saveOrUpdateCampaignHeader(requestParameter).getBody()).getReferenceId());
        verify(campaignService, times(1)).createOrUpdateCampaign(any(RequestParameter.class));
    }

    @Test
    public void testGetCampaignDetailListByCriteria() throws ParseException {

        var vCampaignDetailAgentEntity = new VCampaignDetailAgentEntity();
        var vCampaignDetailAgentEntity1 = new VCampaignDetailAgentEntity();
        var vCampaignDetailAgentEntityArrayList = new ArrayList<VCampaignDetailAgentEntity>();
        vCampaignDetailAgentEntityArrayList.add(vCampaignDetailAgentEntity);
        vCampaignDetailAgentEntityArrayList.add(vCampaignDetailAgentEntity1);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(0);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(1);
        requestParameter.setPageableParameter(pageableParameter);
        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        var pageable = querySetupUtil.setPageable(requestParameter);
        var vCampaignDetailAgentEntityPage = new PageImpl<>(vCampaignDetailAgentEntityArrayList,pageable, vCampaignDetailAgentEntityArrayList.size()) ;

        CampaignDetailListDto campaignDetailListDto = new CampaignDetailListDto(vCampaignDetailAgentEntityPage);
        doReturn(campaignDetailListDto).when(campaignService).findCampaignDetailListByCriteria(any(RequestParameter.class));

        assertEquals(campaignDetailListDto.getCampaignDetailList(), ((CampaignDetailListDto)campaignController.getCampaignDetailListByCriteria(requestParameter).getBody()).getCampaignDetailList());
    }

    @Test
    public void testUploadCampaignDetailsByExcel(){
        assertEquals("", campaignController.uploadCampaignDetailsByExcel(requestParameter).getBody());
    }

    @Test
    public void testSaveOrUpdateCampaignDetailList()throws ParseException{
        RecordDto recordDto = new RecordDto();
        recordDto.setNumberOfRecord("11");
        int output = 11;
        doReturn(output).when(campaignService).createCampaignDetailList(any(RequestParameter.class));
        assertEquals(recordDto.getNumberOfRecord(), ((RecordDto)campaignController.saveOrUpdateCampaignDetailList(requestParameter).getBody()).getNumberOfRecord());

    }

    @Test
    public void testUpdateCampaignDetail() throws ParseException {
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId("11");
        long output = 11;

        doReturn(output).when(campaignService).createOrUpdateCampaignDetail(any(RequestParameter.class));

        assertEquals(recordDto.getReferenceId(),((RecordDto)campaignController.updateCampaignDetail(requestParameter).getBody()).getReferenceId());
    }


}
