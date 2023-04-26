package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.entity.TQuickLinkEntity;
import com.ftlife.plus.partner.parameter.LinkParameter;

import java.util.List;

public interface CmsService {
    void deleteLink (long linkId);

    long createOrUpdateLink (LinkParameter linkParameter);

    List<TQuickLinkEntity> getAllLinks();

    void deleteCommunication (long linkId);

    long createOrUpdateCommunication (LinkParameter linkParameter);

    List<TQuickLinkEntity> getAllCommunications();
}
