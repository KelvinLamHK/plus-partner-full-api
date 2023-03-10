package com.ftlife.plus.partner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftlife.plus.partner.dto.CampaignBirthdayDelightListDto;
import com.ftlife.plus.partner.dto.CampaignDetailListDto;
import com.ftlife.plus.partner.dto.CampaignListDto;
import com.ftlife.plus.partner.entity.*;
import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.repository.*;
import com.ftlife.plus.partner.util.HttpUtil;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    TCampaignHeaderRepository tCampaignHeaderRepository;

    @Autowired
    TCampaignDetailRepository tCampaignDetailRepository;

    @Autowired
    VCampaignDetailAgentRepository vCampaignDetailAgentRepository;

    @Autowired
    VCampaignHeaderAgentRepository vCampaignHeaderAgentRepository;

    @Override
    public long createOrUpdateCampaign(RequestParameter requestParameter) throws IOException {
        TCampaignHeaderEntity tCampaignHeaderEntity = null;
        try {
            tCampaignHeaderEntity = new TCampaignHeaderEntity(requestParameter);
            tCampaignHeaderRepository.save(tCampaignHeaderEntity);
            return tCampaignHeaderEntity.getCampaignHeaderId();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public CampaignListDto findCampaignListByCriteria(RequestParameter requestParameter) throws ParseException {
        String parameter = "internal-admin";
        if(requestParameter.getUserParameter().getRole().equals(parameter)){
            return findCampaignListInternalAdminByCriteria (requestParameter);
        } else if ((!requestParameter.getUserParameter().getRole().equals(parameter))&& (requestParameter.getUserParameter().getIfaIdentity().equals("ADMIN"))){
            return findCampaignListInternalAdminByCriteria (requestParameter);
        } else if ((!requestParameter.getUserParameter().getRole().equals(parameter))&& (!requestParameter.getUserParameter().getIfaIdentity().equals("ADMIN"))){
            return findCampaignListAgentByCriteria (requestParameter);
        }
        return null;
    }

    @Override
    public CampaignListDto findCampaignListInternalAdminByCriteria(RequestParameter requestParameter) throws ParseException {
        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        Pageable pageable = querySetupUtil.setPageable(requestParameter);
        GenericSpecification<?> genericSpecification = querySetupUtil.setCampaignListWhereClause(requestParameter);
        Page<TCampaignHeaderEntity> tCampaignHeaderEntityPage = tCampaignHeaderRepository.findAll((Specification<TCampaignHeaderEntity>) genericSpecification,pageable);
        CampaignListDto campaignListDto = new CampaignListDto(tCampaignHeaderEntityPage);

        return campaignListDto;
    }

    @Override
    public CampaignListDto findCampaignListAgentByCriteria(RequestParameter requestParameter) throws ParseException {

        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        Pageable pageable = querySetupUtil.setPageable(requestParameter);
        GenericSpecification<?> genericSpecification = querySetupUtil.setCampaignListWhereClause(requestParameter);
        Page<VCampaignHeaderAgentEntity> vCampaignHeaderAgentEntityPage = vCampaignHeaderAgentRepository.findAll((Specification<VCampaignHeaderAgentEntity>) genericSpecification,pageable);
        CampaignListDto campaignListDto = new CampaignListDto();
        campaignListDto.campaignListDtoAgent(vCampaignHeaderAgentEntityPage);

        return campaignListDto;

    }

    @Override
    public CampaignDetailListDto findCampaignDetailListByCriteria(RequestParameter requestParameter) throws ParseException {
        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        Pageable pageable = querySetupUtil.setPageable(requestParameter);
        GenericSpecification<?> genericSpecification = querySetupUtil.setCampaignDetailListParameterWhereClause(requestParameter);
        Page<VCampaignDetailAgentEntity> vCampaignDetailAgentEntityPage = vCampaignDetailAgentRepository.findAll((Specification<VCampaignDetailAgentEntity>) genericSpecification,pageable);
        CampaignDetailListDto campaignDetailListDto = new CampaignDetailListDto(vCampaignDetailAgentEntityPage);

        return campaignDetailListDto;
    }

    @Override
    public int createCampaignDetailList(RequestParameter requestParameter) {
        deleteCampaignDetailListByHeaderId(requestParameter.getCampaignDetailListParameter().getCampaignHeaderId());
        List<TCampaignDetailEntity> tCampaignDetailEntityList = new ArrayList<>();

        List<CampaignDetailParameter> campaignDetailList = requestParameter.getCampaignDetailListParameter().getCampaignDetailList();
        UserParameter userParameter = requestParameter.getUserParameter();

        campaignDetailList.forEach(c -> {
            var requestParameterCampaignDetail = new RequestParameter();
            requestParameterCampaignDetail.setUserParameter(userParameter);
            requestParameterCampaignDetail.setCampaignDetailParameter(c);

            TCampaignDetailEntity tCampaignDetailEntity = null;
            try {
                tCampaignDetailEntity = new TCampaignDetailEntity(requestParameterCampaignDetail);
            } catch (ParseException e) {
                throw new RuntimeException(e.getMessage());
            }
            tCampaignDetailEntityList.add(tCampaignDetailEntity);

        });

        return tCampaignDetailRepository.saveAll(tCampaignDetailEntityList).size();
    }

    @Override
    public void deleteCampaignDetailListByHeaderId(String campaignHeaderId) {
        tCampaignDetailRepository.deleteByCampaignHeaderId(Long.parseLong(campaignHeaderId));
    }

    @Override
    public long createOrUpdateCampaignDetail(RequestParameter requestParameter) throws ParseException {
        TCampaignDetailEntity tCampaignDetailEntity = new TCampaignDetailEntity(requestParameter);
        tCampaignDetailRepository.save(tCampaignDetailEntity);
        return tCampaignDetailEntity.getCampaignDetailId();
    }

}
