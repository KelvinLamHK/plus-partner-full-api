
package com.ftlife.plus.partner.service;


import com.ftlife.plus.partner.dto.BrokerListDto;
import com.ftlife.plus.partner.dto.DocumentCenterCategoryListDto;
import com.ftlife.plus.partner.dto.DocumentCenterListDto;
import com.ftlife.plus.partner.entity.TBrokerEntity;
import com.ftlife.plus.partner.entity.TDocumentCenterCategoryEntity;
import com.ftlife.plus.partner.entity.TDocumentCenterEntity;
import com.ftlife.plus.partner.entity.TDocumentCenterVisibilityEntity;
import com.ftlife.plus.partner.parameter.RequestParameter;

import java.text.ParseException;
import java.util.List;

public interface DocumentCenterService {

    TDocumentCenterEntity createOrUpdateDocumentCenterRecord (RequestParameter requestParameter) throws ParseException;

    List<TBrokerEntity> getBrokerList();

    BrokerListDto getBrokerListPage(RequestParameter requestParameter);

    DocumentCenterListDto findDocumentCenterListByCriteria(RequestParameter requestParameter) throws ParseException;

    TDocumentCenterEntity findDocumentCenterRecordById (Long documentCenterRecordId);

    DocumentCenterCategoryListDto getCategoryList();

    TDocumentCenterCategoryEntity createOrUpdateDocumentCenterCategory(RequestParameter requestParameter);

    List<TDocumentCenterVisibilityEntity> findTDocumentCenterVisibilityListByDocumentCenterId(RequestParameter requestParameter);
}
