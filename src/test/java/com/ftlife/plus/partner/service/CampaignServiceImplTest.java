package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.dto.CampaignDetailListDto;
import com.ftlife.plus.partner.dto.CampaignListDto;
import com.ftlife.plus.partner.dto.PageableDto;
import com.ftlife.plus.partner.entity.*;
import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.repository.*;
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
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CampaignServiceImplTest {
	@Mock
	TCampaignHeaderRepository tCampaignHeaderRepository;

	@Mock
	TCampaignDetailRepository tCampaignDetailRepository;

	@Mock
	TCampaignHeaderRepository TCampaignHeaderRepository;
	@Mock
	VCampaignHeaderAgentRepository vCampaignHeaderAgentRepository;

	@Mock
	VCampaignDetailAgentRepository vCampaignDetailAgentRepository;

	@InjectMocks
	private static CampaignService campaignService = new CampaignServiceImpl();

	RequestParameter requestParameter = new RequestParameter();
	PolicyListParameter policyListParameter = new PolicyListParameter();
	PageableParameter pageableParameter = new PageableParameter();
	DocumentParameter documentParameter = new DocumentParameter();
	UserParameter userParameter = new UserParameter();
	CampaignListParameter campaignListParameter = new CampaignListParameter();
	CampaignHeaderParameter campaignHeaderParameter = new CampaignHeaderParameter();
	CampaignDetailParameter campaignDetailParameter = new CampaignDetailParameter();
	CampaignDetailListParameter campaignDetailListParameter = new CampaignDetailListParameter();

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFindCampaignListInternalAdminByCriteria() throws ParseException {
		requestParameter.setPolicyListParameter(policyListParameter);
		userParameter.setRole("a");
		userParameter.setIfaIdentity("a");
		requestParameter.setUserParameter(userParameter);
		requestParameter.setDocumentParameter(documentParameter);
		pageableParameter.setOrderBy("a");
		pageableParameter.setPageNumber(0);
		pageableParameter.setOrderSequence("asc");
		pageableParameter.setPageSize(1);
		requestParameter.setPageableParameter(pageableParameter);
		campaignListParameter.setCampaignCode("a");
		requestParameter.setCampaignListParameter(campaignListParameter);
		requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
		requestParameter.setCampaignDetailParameter(campaignDetailParameter);
		requestParameter.setCampaignDetailListParameter(campaignDetailListParameter);

		TCampaignHeaderEntity tCampaignHeaderEntity = new TCampaignHeaderEntity();
		List<TCampaignHeaderEntity> tCampaignHeaderEntityList = new ArrayList<>();
		tCampaignHeaderEntityList.add(tCampaignHeaderEntity);
		QuerySetupUtil querySetupUtil = new QuerySetupUtil();
		var pageable = querySetupUtil.setPageable(requestParameter);
		Page<TCampaignHeaderEntity> tCampaignHeaderEntityPage = new PageImpl<>(tCampaignHeaderEntityList,pageable,tCampaignHeaderEntityList.size());

		doReturn(tCampaignHeaderEntityPage).when(tCampaignHeaderRepository).findAll(any(GenericSpecification.class),any(Pageable.class));

		CampaignListDto campaignListDto = new CampaignListDto(tCampaignHeaderEntityPage);

		assertEquals(campaignListDto.getCampaignList(),
				campaignService.findCampaignListInternalAdminByCriteria(requestParameter).getCampaignList());
	}

	@Test
	public void TestForCreateOrUpdateCampaignDetail() throws ParseException {
		requestParameter.setPolicyListParameter(policyListParameter);
		requestParameter.setUserParameter(userParameter);
		requestParameter.setDocumentParameter(documentParameter);
		requestParameter.setPageableParameter(pageableParameter);
		requestParameter.setCampaignListParameter(campaignListParameter);
		requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
		requestParameter.setCampaignDetailParameter(campaignDetailParameter);
		requestParameter.setCampaignDetailListParameter(campaignDetailListParameter);
		TCampaignDetailEntity tCampaignDetailEntity = new TCampaignDetailEntity(requestParameter);
		doReturn(tCampaignDetailEntity).when(tCampaignDetailRepository).save(any(TCampaignDetailEntity.class));
		assertEquals(tCampaignDetailEntity.getCampaignHeaderId(),
				campaignService.createOrUpdateCampaignDetail(requestParameter));
		verify(tCampaignDetailRepository, times(1)).save(any());

	}

	@Test
	public void TestCreateCampaignDetailList() throws ParseException {
		campaignDetailListParameter.setCampaignHeaderId("1");
		CampaignDetailParameter c1 = new CampaignDetailParameter();

		c1.setClientFullNameEng("a");
		c1.setClientFullNameChi("a");

		c1.setClientGender("a");
		c1.setDateOfBirth("2022-01-01");
		c1.setBirthdayMonth("a");
		c1.setLanguageForCommunication("a");
		c1.setDeathClaim("a");

		c1.setSalesChannel("a");
		c1.setProduceAgent1Region("a");
		c1.setProduceAgent1Code("a");
		c1.setProduceAgent1Name("a");
		c1.setProduceAgent2Region("a");

		userParameter.setLoginName("a");

		requestParameter.setCampaignDetailParameter(campaignDetailParameter);
		requestParameter.setUserParameter(userParameter);
		CampaignDetailParameter c2 = new CampaignDetailParameter();
		CampaignDetailParameter c3 = new CampaignDetailParameter();
		List<CampaignDetailParameter> a1 = new ArrayList<CampaignDetailParameter>();
		a1.add(c3);
		a1.add(c2);
		a1.add(c1);
		campaignDetailListParameter.setCampaignDetailList(a1);
		requestParameter.setCampaignDetailListParameter(campaignDetailListParameter);
		List<TCampaignDetailEntity> tCampaignDetailEntityList = new ArrayList<>();

		List<CampaignDetailParameter> campaignDetailList = requestParameter.getCampaignDetailListParameter()
				.getCampaignDetailList();
		UserParameter userParameter = requestParameter.getUserParameter();

		campaignDetailList.forEach(c -> {
			var requestParameterCampaignDetail = new RequestParameter();
			requestParameterCampaignDetail.setUserParameter(userParameter);
			requestParameterCampaignDetail.setCampaignDetailParameter(c);
			try {
				var tCampaignDetailEntity = new TCampaignDetailEntity(requestParameterCampaignDetail);
				tCampaignDetailEntityList.add(tCampaignDetailEntity);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		});

		doReturn(tCampaignDetailEntityList).when(tCampaignDetailRepository).saveAll(anyList());
		assertEquals(tCampaignDetailEntityList.size(), campaignService.createCampaignDetailList(requestParameter));
	}

	@Test
	public void TestForFindCampaignDetailListByCriteria() throws ParseException {

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

		requestParameter.setPolicyListParameter(policyListParameter);
		requestParameter.setUserParameter(userParameter);
		requestParameter.setDocumentParameter(documentParameter);
		requestParameter.setPageableParameter(pageableParameter);
		requestParameter.setCampaignListParameter(campaignListParameter);
		requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
		requestParameter.setCampaignDetailParameter(campaignDetailParameter);
		QuerySetupUtil querySetupUtil = new QuerySetupUtil();
		var vCampaignDetailAgentEntity = new VCampaignDetailAgentEntity();
		var vCampaignDetailAgentEntityArrayList = new ArrayList<VCampaignDetailAgentEntity>();
		vCampaignDetailAgentEntityArrayList.add(vCampaignDetailAgentEntity);
		var pageableParameter = new PageableParameter();
		pageableParameter.setOrderBy("a");
		pageableParameter.setPageNumber(0);
		pageableParameter.setOrderSequence("asc");
		pageableParameter.setPageSize(1);
		requestParameter.setPageableParameter(pageableParameter);

		var pageable = querySetupUtil.setPageable(requestParameter);
		var vCampaignDetailAgentEntityPage = new PageImpl<>(vCampaignDetailAgentEntityArrayList, pageable,
				vCampaignDetailAgentEntityArrayList.size());
		var campaignDetailListDto = new CampaignDetailListDto(vCampaignDetailAgentEntityPage);

		PageableDto pageableDto = new PageableDto();
		pageableDto.setPageNumber(0);
		pageableDto.setPageSize(0);
		pageableDto.setHasNext(true);
		pageableDto.setTotalPages(0);
		pageableDto.setTotalNumberOfRecords(0);
		campaignDetailListDto.getCampaignDetailList();
		campaignDetailListDto.getPagination();
		campaignDetailListDto.setCampaignDetailList(vCampaignDetailAgentEntityArrayList);
		campaignDetailListDto.setPagination(pageableDto);
		GenericSpecification genericSpecification = querySetupUtil
				.setCampaignListWhereClause(requestParameter);
		doReturn(vCampaignDetailAgentEntityPage).when(vCampaignDetailAgentRepository)
				.findAll(any(GenericSpecification.class), any(Pageable.class));
		assertEquals(campaignDetailListDto.getCampaignDetailList(),
				campaignService.findCampaignDetailListByCriteria(requestParameter).getCampaignDetailList());
		verify(vCampaignDetailAgentRepository, times(1)).findAll(any(GenericSpecification.class), any(Pageable.class));

	}

	@Test
	public void testCreateOrUpdateCampaign() throws ParseException, IOException {
		requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
		requestParameter.setUserParameter(userParameter);

		campaignHeaderParameter.setCampaignHeaderId("999");
		long id = 999;
		assertEquals(999, campaignService.createOrUpdateCampaign(requestParameter));
	}

	@Test
	public void testFindCampaignListByCriteria() throws ParseException {
		requestParameter.setPolicyListParameter(policyListParameter);
		userParameter.setRole("a");
		userParameter.setIfaIdentity("a");
		requestParameter.setUserParameter(userParameter);
		requestParameter.setDocumentParameter(documentParameter);
		pageableParameter.setOrderBy("a");
		pageableParameter.setPageNumber(0);
		pageableParameter.setOrderSequence("asc");
		pageableParameter.setPageSize(1);
		requestParameter.setPageableParameter(pageableParameter);
		campaignListParameter.setCampaignCode("a");
		requestParameter.setCampaignListParameter(campaignListParameter);
		requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
		requestParameter.setCampaignDetailParameter(campaignDetailParameter);
		requestParameter.setCampaignDetailListParameter(campaignDetailListParameter);
		requestParameter.setUserParameter(userParameter);
		userParameter.setRole("internal-admin");

		TCampaignHeaderEntity tCampaignHeaderEntity = new TCampaignHeaderEntity();
		List<TCampaignHeaderEntity> tCampaignHeaderEntityList = new ArrayList<>();
		tCampaignHeaderEntityList.add(tCampaignHeaderEntity);
		QuerySetupUtil querySetupUtil = new QuerySetupUtil();
		var pageable = querySetupUtil.setPageable(requestParameter);
		Page<TCampaignHeaderEntity> tCampaignHeaderEntityPage = new PageImpl<>(tCampaignHeaderEntityList,pageable,tCampaignHeaderEntityList.size());

		doReturn(tCampaignHeaderEntityPage).when(tCampaignHeaderRepository).findAll(any(GenericSpecification.class),any(Pageable.class));

		CampaignListDto campaignListDto = new CampaignListDto(tCampaignHeaderEntityPage);

		assertEquals(CampaignListDto.class,
				campaignService.findCampaignListByCriteria(requestParameter).getClass());
		userParameter.setRole("123");
		userParameter.setIfaIdentity("ADMIN");
		assertEquals(CampaignListDto.class,
				campaignService.findCampaignListByCriteria(requestParameter).getClass());


		userParameter.setRole("123");
		userParameter.setIfaIdentity("321");
		VCampaignHeaderAgentEntity vCampaignHeaderAgentEntity = new VCampaignHeaderAgentEntity();
		vCampaignHeaderAgentEntity.setCampaignCode("abCompany");
		vCampaignHeaderAgentEntity.setCampaignHeaderId(11);
		vCampaignHeaderAgentEntity.setCampaignNameEng("XXEng");
		vCampaignHeaderAgentEntity.setCampaignNameZHCN("XXCn");
		vCampaignHeaderAgentEntity.setCampaignNameZHTW("XXTw");
		vCampaignHeaderAgentEntity.setCreatedBy("tester");
		vCampaignHeaderAgentEntity.setIfaCaIndicator("XX1");
		vCampaignHeaderAgentEntity.setRemark("remark");
		vCampaignHeaderAgentEntity.setThumbnailDocID(999);
		vCampaignHeaderAgentEntity.setUpdatedBy("Ke");

		VCampaignHeaderAgentEntity vCampaignHeaderAgentEntity1 = new VCampaignHeaderAgentEntity();
		vCampaignHeaderAgentEntity1.setCampaignCode("abCompany");
		vCampaignHeaderAgentEntity1.setCampaignHeaderId(11);
		vCampaignHeaderAgentEntity1.setCampaignNameEng("XXEng");
		vCampaignHeaderAgentEntity1.setCampaignNameZHCN("XXCn");
		vCampaignHeaderAgentEntity1.setCampaignNameZHTW("XXTw");
		vCampaignHeaderAgentEntity1.setCreatedBy("tester");
		vCampaignHeaderAgentEntity1.setIfaCaIndicator("XX1");
		vCampaignHeaderAgentEntity1.setRemark("remark");
		vCampaignHeaderAgentEntity1.setThumbnailDocID(999);
		vCampaignHeaderAgentEntity1.setUpdatedBy("Ke");

		var vCampaignHeaderAgentEntityArrayList = new ArrayList<VCampaignHeaderAgentEntity>();
		vCampaignHeaderAgentEntityArrayList.add(vCampaignHeaderAgentEntity);
		vCampaignHeaderAgentEntityArrayList.add(vCampaignHeaderAgentEntity1);
		var pageableParameter = new PageableParameter();
		pageableParameter.setOrderBy("a");
		pageableParameter.setPageNumber(123);
		pageableParameter.setOrderSequence("asc");
		pageableParameter.setPageSize(321);
		requestParameter.setPageableParameter(pageableParameter);

		var vCampaignHeaderAgentEntityPage = new PageImpl<>(vCampaignHeaderAgentEntityArrayList,pageable, vCampaignHeaderAgentEntityArrayList.size()) ;
		doReturn(vCampaignHeaderAgentEntityPage).when(vCampaignHeaderAgentRepository).findAll(any(GenericSpecification.class),any(Pageable.class));

		assertEquals(CampaignListDto.class,
				campaignService.findCampaignListByCriteria(requestParameter).getClass());


	}

//	@Test
//	public void TestForFindCampaignListByCriteria() throws ParseException {
//
//		userParameter.setLoginName("a");
//		userParameter.setName("a");
//		userParameter.setCompanyName("a");
//		userParameter.setCompanyID("a");
//		userParameter.setEmail("a");
//		userParameter.setBrokerCode("a");
//		userParameter.setIfaIdentity("a");
//		userParameter.setPibaNumber("a");
//		userParameter.setIfaCaNameEng("a");
//		userParameter.setIfaCaNameOther("a");
//		userParameter.setIfaCaLicenseNumber("a");
//		userParameter.setRole("internal-admin");
//
//		requestParameter.setPolicyListParameter(policyListParameter);
//		requestParameter.setUserParameter(userParameter);
//		requestParameter.setDocumentParameter(documentParameter);
//		requestParameter.setPageableParameter(pageableParameter);
//		requestParameter.setCampaignListParameter(campaignListParameter);
//		requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
//		requestParameter.setCampaignDetailParameter(campaignDetailParameter);
//
//		QuerySetupUtil querySetupUtil = new QuerySetupUtil();
//		var tCampaignHeaderEntity = new TCampaignHeaderEntity();
//		var tCampaignHeaderEntityArrayList = new ArrayList<TCampaignHeaderEntity>();
//		tCampaignHeaderEntityArrayList.add(tCampaignHeaderEntity);
//		var pageableParameter = new PageableParameter();
//		pageableParameter.setOrderBy("a");
//		pageableParameter.setPageNumber(0);
//		pageableParameter.setOrderSequence("asc");
//		pageableParameter.setPageSize(1);
//		requestParameter.setPageableParameter(pageableParameter);
//
//		Pageable pageable = querySetupUtil.setPageable(requestParameter);
//		Page<TCampaignHeaderEntity> tCampaignHeaderEntityPage = new PageImpl<>(tCampaignHeaderEntityArrayList, pageable,
//				tCampaignHeaderEntityArrayList.size());
//		var campaignListDto = new CampaignListDto(tCampaignHeaderEntityPage);
//
//		pageableParameter.setOrderBy("a");
//		pageableParameter.setPageNumber(0);
//		pageableParameter.setOrderSequence("desc");
//		pageableParameter.setPageSize(1);
//		requestParameter.setPageableParameter(pageableParameter);
//
//		campaignListDto.getCampaignList();
//		campaignListDto.getPagination();
//		campaignListDto.setCampaignList(tCampaignHeaderEntityArrayList);
//
//		PageableDto pageableDto = new PageableDto();
//		pageableDto.setPageNumber(9);
//		pageableDto.setPageSize(0);
//		pageableDto.setHasNext(true);
//		pageableDto.setTotalPages(0);
//		pageableDto.setTotalNumberOfRecords(0);
//		campaignListDto.setPagination(pageableDto);
//
//		GenericSpecification genericSpecification = querySetupUtil
//				.setCampaignListWhereClause(requestParameter);
//
//		doReturn(tCampaignHeaderEntityPage).when(tCampaignHeaderRepository).findAll(any(GenericSpecification.class),
//				any(Pageable.class));
//		assertEquals(campaignListDto.getCampaignList(),
//				campaignService.findCampaignListByCriteria(requestParameter).getCampaignList());
//		verify(tCampaignHeaderRepository, times(1)).findAll(any(GenericSpecification.class), any(Pageable.class));
//
//		// Test for !internal admin && AdMIN
//		userParameter.setRole("a");
//		userParameter.setIfaIdentity("ADMIN");
//		var tCampaignHeaderEntity1 = new TCampaignHeaderEntity();
//		var vCampaignHeaderBrokerEntityArrayList = new ArrayList<TCampaignHeaderEntity>();
//		vCampaignHeaderBrokerEntityArrayList.add(tCampaignHeaderEntity1);
//		Page<TCampaignHeaderEntity> tCampaignHeaderEntityPage1 = new PageImpl<>(
//				vCampaignHeaderBrokerEntityArrayList, pageable, vCampaignHeaderBrokerEntityArrayList.size());
//		var campaignListDto2 = new CampaignListDto();
//		campaignListDto2.campaignListDtoBroker(tCampaignHeaderEntityPage1);
//		doReturn(tCampaignHeaderEntityPage1).when(TCampaignHeaderRepository)
//				.findAll(any(GenericSpecification.class), any(Pageable.class));
//		assertEquals(campaignListDto2.getPagination().getPageNumber(),
//				campaignService.findCampaignListByCriteria(requestParameter).getPagination().getPageNumber());
//
//
//		// Test for !internal admin && !AdMIN
//		userParameter.setRole("a");
//		userParameter.setIfaIdentity("a");
//		var tCampaignHeaderEntity2 = new TCampaignHeaderEntity();
//		var tCampaignHeaderEntityArrayList1 = new ArrayList<TCampaignHeaderEntity>();
//		tCampaignHeaderEntityArrayList1.add(tCampaignHeaderEntity2);
//		Page<TCampaignHeaderEntity> tCampaignHeaderEntityPage2 = new PageImpl<>(
//				tCampaignHeaderEntityArrayList1, pageable, tCampaignHeaderEntityArrayList1.size());
//		var campaignListDto3 = new CampaignListDto();
//		campaignListDto3.campaignListDtoAgent(tCampaignHeaderEntityPage2);
//		doReturn(tCampaignHeaderEntityPage2).when(TCampaignHeaderRepository)
//				.findAll(any(GenericSpecification.class), any(Pageable.class));
//		assertEquals(campaignListDto3.getPagination().getPageNumber(),
//				campaignService.findCampaignListByCriteria(requestParameter).getPagination().getPageNumber());
////		verify(TCampaignHeaderRepository, times(1)).findAll(any(GenericSpecification.class), any(Pageable.class));
//
//	}

}
