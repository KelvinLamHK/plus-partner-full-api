package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.entity.TQuickLinkEntity;
import com.ftlife.plus.partner.parameter.LinkParameter;
import com.ftlife.plus.partner.repository.TQuickLinkRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;

@Service
@Log4j2
public class CmsServiceImpl implements CmsService {
    @Autowired
    TQuickLinkRepository tQuickLinkRepository;


    @Override
    public void deleteLink(long linkId) {
        tQuickLinkRepository.deleteById(linkId);
    }

    @Override
    public long createOrUpdateLink(LinkParameter linkParameter) {
        Date date = new Date();
        if(linkParameter.getStatus().equals("new")){
            TQuickLinkEntity tQuickLinkEntity = new TQuickLinkEntity();
            tQuickLinkEntity.setUrl(linkParameter.getUrl());
            tQuickLinkEntity.setLinkEngName(linkParameter.getLinkEngName());
            tQuickLinkEntity.setLinkChiName(linkParameter.getLinkChiName());
            tQuickLinkEntity.setLinkSimName(linkParameter.getLinkSimName());
            tQuickLinkEntity.setLatestUpdate(date);
            tQuickLinkRepository.save(tQuickLinkEntity);
        }else{
            deleteLink(linkParameter.getLinkId());
            TQuickLinkEntity tQuickLinkEntity = new TQuickLinkEntity();
            tQuickLinkEntity.setLinkEngName(linkParameter.getLinkEngName());
            tQuickLinkEntity.setLinkSimName(linkParameter.getLinkSimName());
            tQuickLinkEntity.setLinkChiName(linkParameter.getLinkChiName());
            tQuickLinkEntity.setUrl(linkParameter.getUrl());
            tQuickLinkEntity.setLatestUpdate(date);
            tQuickLinkRepository.save(tQuickLinkEntity);
        }

        return 0;
    }

    @Override
    public List<TQuickLinkEntity> getAllLinks() {
        List<TQuickLinkEntity> linkParameterList = new ArrayList<>();
        tQuickLinkRepository.findAll().forEach(linkParameterList::add);
        Collections.sort(linkParameterList);
        return linkParameterList;
    }

    @Override
    public void deleteCommunication(long linkId) {

    }

    @Override
    public long createOrUpdateCommunication(LinkParameter linkParameter) {
        return 0;
    }

    @Override
    public List<TQuickLinkEntity> getAllCommunications() {
        return null;
    }
}
