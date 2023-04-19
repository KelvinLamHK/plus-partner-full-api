package com.ftlife.plus.partner.parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestParameter {
    PolicyListParameter policyListParameter;
    PageableParameter pageableParameter;
    DocumentParameter documentParameter;
    UserParameter userParameter;
    CampaignListParameter campaignListParameter;
    CampaignHeaderParameter campaignHeaderParameter;
    CampaignDetailParameter campaignDetailParameter;
    DocumentCenterParameter documentCenterParameter;
    CampaignDetailListParameter campaignDetailListParameter;
    DocumentCenterCategoryParameter documentCenterCategoryParameter;
    LinkParameter linkParameter;
}
