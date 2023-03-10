package com.ftlife.plus.partner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftlife.plus.partner.configuration.LogConfig;
import com.ftlife.plus.partner.configuration.SchedulerConfig;
import com.ftlife.plus.partner.dto.ExceptionDto;
import com.ftlife.plus.partner.dto.RecordDto;
import com.ftlife.plus.partner.parameter.ApiLogParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.service.CampaignService;
import com.ftlife.plus.partner.util.HttpUtil;
import com.ftlife.plus.partner.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.text.ParseException;

@RestController
public class CampaignController {
    @Autowired
    LogConfig logConfig;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    CampaignService campaignService;

    @PostMapping(value = "/v1/campaign/headers")
    public ResponseEntity<Object> getCampaignListByCriteria(@RequestBody RequestParameter requestParameter) throws ParseException {

            var campaignListDto = campaignService.findCampaignListByCriteria(requestParameter);

            return ResponseEntity.ok().body(campaignListDto);

        }



    //    @PostMapping(value = "/v1/campaign/headers")
//    public ResponseEntity<Object> getCampaignListByCriteria(@RequestBody RequestParameter requestParameter,HttpServletRequest httpServletRequest){
//        var httpUtil = new HttpUtil();
//        try {
//            var campaignListDto = campaignService.findCampaignListByCriteria(requestParameter);
//            String logResponse = httpUtil.logResponseRequest(httpServletRequest, requestParameter, logConfig, campaignListDto, null);
//            return ResponseEntity.ok().body(campaignListDto);
//        } catch (IOException | ParseException e){
//            String logResponse = null;
//            try {
//                logResponse = httpUtil.logResponseRequest(httpServletRequest,requestParameter,logConfig,null,e.getLocalizedMessage());
//            } catch (IOException ex) {
//                return ResponseEntity.badRequest().body(ex);
//            }
//            return ResponseEntity.badRequest().body(logResponse);
//        }
//
//    }

        @PostMapping(value = "/v1/campaign/header")
    public ResponseEntity<Object> saveOrUpdateCampaignHeader (@RequestBody RequestParameter requestParameter) throws ParseException, IOException {
        var errorMessage = ValidationUtil.validateUserParameter(requestParameter);
        if (errorMessage != null){
            ExceptionDto exceptionDto = new ExceptionDto();
            exceptionDto.setErrorMessage(errorMessage);
            return ResponseEntity.badRequest().body(exceptionDto);
        }
        errorMessage = ValidationUtil.validateCampaignHeaderParameter(requestParameter);
        if (errorMessage != null){
            ExceptionDto exceptionDto = new ExceptionDto();
            exceptionDto.setErrorMessage(errorMessage);
            return ResponseEntity.badRequest().body(exceptionDto);
        }

        long recordId = campaignService.createOrUpdateCampaign(requestParameter);
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId(String.valueOf(recordId));
        return ResponseEntity.ok().body(recordDto);
    }

    @PostMapping(value = "/v1/campaign/details")
    public ResponseEntity<Object> getCampaignDetailListByCriteria(@RequestBody RequestParameter requestParameter) throws ParseException {
        return ResponseEntity.ok().body(campaignService.findCampaignDetailListByCriteria(requestParameter));
    }

    @PostMapping(value = "/v1/campaign/details/uploads")
    public ResponseEntity<Object> uploadCampaignDetailsByExcel(@RequestBody RequestParameter requestParameter) {
        return ResponseEntity.ok().body("");
    }

    @PostMapping(value = "/v1/campaign/details/upload")
    public ResponseEntity<Object> saveOrUpdateCampaignDetailList (@RequestBody RequestParameter requestParameter) throws ParseException {
        RecordDto recordDto = new RecordDto();
        recordDto.setNumberOfRecord(String.valueOf(campaignService.createCampaignDetailList(requestParameter)));
        return ResponseEntity.ok().body(recordDto);
    }

    @PostMapping(value = "/v1/campaign/detail/edit")
    public ResponseEntity<Object> updateCampaignDetail (@RequestBody RequestParameter requestParameter) throws ParseException {
        long recordId = campaignService.createOrUpdateCampaignDetail(requestParameter);
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId(String.valueOf(recordId));
        return ResponseEntity.ok().body(recordDto);
    }

}
