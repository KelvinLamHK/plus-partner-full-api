package com.ftlife.plus.partner.parameter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftlife.plus.partner.configuration.LogConfig;
import com.ftlife.plus.partner.configuration.SchedulerConfig;
import com.ftlife.plus.partner.dto.CampaignBirthdayDelightListDto;
import com.ftlife.plus.partner.util.HttpUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

@Getter
@Setter
@NoArgsConstructor
public class ApiLogParameter {

    String application;
    String ipAddress;
    String createdBy;
    String requestUrl;
    String requestBody;
    String response;
    String error;

}
