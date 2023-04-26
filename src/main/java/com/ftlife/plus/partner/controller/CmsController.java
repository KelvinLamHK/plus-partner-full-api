package com.ftlife.plus.partner.controller;

import com.ftlife.plus.partner.parameter.LinkParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.service.CmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = {"http://172.29.9.104:3000/", "http://localhost:3000/","http://10.20.145.30:3000"})
public class CmsController {

    @Autowired
    CmsService cmsService;

    @PostMapping(value = "/cms/link")
    public ResponseEntity<Object> saveOrUpdateOrDeleteLink(@RequestBody RequestParameter requestParameter)  {
        if(requestParameter.getLinkParameter().getStatus().equals("d")){
            cmsService.deleteLink(requestParameter.getLinkParameter().getLinkId());
        }else{
            LinkParameter linkParameter = new LinkParameter();
            if(!requestParameter.getLinkParameter().getStatus().equals("new")){
                linkParameter.setLinkId(requestParameter.getLinkParameter().getLinkId());
            }
            linkParameter.setStatus(requestParameter.getLinkParameter().getStatus());
            linkParameter.setUrl(requestParameter.getLinkParameter().getUrl());
            linkParameter.setLinkEngName(requestParameter.getLinkParameter().getLinkEngName());
            linkParameter.setLinkChiName(requestParameter.getLinkParameter().getLinkChiName());
            linkParameter.setLinkSimName(requestParameter.getLinkParameter().getLinkSimName());
            cmsService.createOrUpdateLink(linkParameter);
        }

        return ResponseEntity.ok().body("0");
    }

    @PostMapping(value = "/cms/links")
    public ResponseEntity<Object> getLink()  {

        return ResponseEntity.ok().body( cmsService.getAllLinks());
    }

    @PostMapping(value = "/cms/communication")
    public ResponseEntity<Object> saveOrUpdateOrDeleteCommunication(){
        return ResponseEntity.ok().body( "123");
    }
}
