package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.dto.CampaignDetailListDto;
import com.ftlife.plus.partner.dto.CampaignListDto;
import com.ftlife.plus.partner.parameter.RequestParameter;

import java.io.IOException;
import java.text.ParseException;

public interface CampaignService {
    long createOrUpdateCampaign (RequestParameter requestParameter) throws ParseException, IOException;

    long createOrUpdateCampaignDetail (RequestParameter requestParameter) throws ParseException;

       CampaignListDto findCampaignListByCriteria (RequestParameter requestParameter) throws ParseException;

       CampaignListDto findCampaignListInternalAdminByCriteria (RequestParameter requestParameter) throws ParseException;

       CampaignListDto findCampaignListAgentByCriteria(RequestParameter requestParameter) throws ParseException;

       CampaignDetailListDto findCampaignDetailListByCriteria (RequestParameter requestParameter) throws ParseException;

       int createCampaignDetailList (RequestParameter requestParameter) throws ParseException ;

       void deleteCampaignDetailListByHeaderId(String campaignHeaderId);

}

