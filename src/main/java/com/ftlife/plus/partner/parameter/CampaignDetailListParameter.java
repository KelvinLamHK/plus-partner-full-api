package com.ftlife.plus.partner.parameter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CampaignDetailListParameter {
    String campaignHeaderId;
    List<CampaignDetailParameter> campaignDetailList;
}
