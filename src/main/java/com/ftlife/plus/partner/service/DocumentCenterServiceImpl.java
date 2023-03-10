package com.ftlife.plus.partner.service;

import com.ftlife.plus.partner.dto.*;
import com.ftlife.plus.partner.entity.*;
import com.ftlife.plus.partner.parameter.DocumentCenterCategoryParameter;
import com.ftlife.plus.partner.parameter.GenericSpecification;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.repository.*;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class DocumentCenterServiceImpl implements DocumentCenterService {

    @Autowired
    private TDocumentCenterCategoryRepository tDocumentCenterCategoryRepository;

    @Autowired
    private TDocumentCenterVisibilityRepository tDocumentCenterVisibilityRepository;
    @Autowired
    private TDocumentCenterRepository tDocumentCenterRepository;

    @Autowired
    private VDocumentCenterRepository vDocumentCenterRepository;

    @Autowired
    private TBrokerRepository tBrokerRepository;

    @Override
    public TDocumentCenterEntity createOrUpdateDocumentCenterRecord(RequestParameter requestParameter) throws ParseException {
        TDocumentCenterEntity previousTDocumentCenterEntity = null;
        if(requestParameter.getDocumentCenterParameter().getDocumentCenterId() != null)
            previousTDocumentCenterEntity = findDocumentCenterRecordById(Long.parseLong(requestParameter.getDocumentCenterParameter().getDocumentCenterId()));

        TDocumentCenterEntity tDocumentCenterEntity = new TDocumentCenterEntity(requestParameter, previousTDocumentCenterEntity);
        tDocumentCenterEntity = tDocumentCenterRepository.save(tDocumentCenterEntity);
        tDocumentCenterVisibilityRepository.deleteByDocumentCenterId(tDocumentCenterEntity.getDocumentCenterId());
        TDocumentCenterVisibilityEntity tDocumentCenterVisibilityEntity = new TDocumentCenterVisibilityEntity();
        requestParameter.getDocumentCenterParameter().setDocumentCenterId(String.valueOf(tDocumentCenterEntity.getDocumentCenterId()));
        List<TDocumentCenterVisibilityEntity> tDocumentCenterVisibilityEntityList = tDocumentCenterVisibilityEntity.prepareTDocumentCenterVisibilityEntityList(requestParameter);
        tDocumentCenterVisibilityRepository.saveAll(tDocumentCenterVisibilityEntityList);
        return tDocumentCenterEntity;
    }

    @Override
    public List<TBrokerEntity> getBrokerList() {
        return tBrokerRepository.findAll();
    }

    @Override
    public BrokerListDto getBrokerListPage(RequestParameter requestParameter) {
        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        Pageable pageable = querySetupUtil.setPageable(requestParameter);

        return new BrokerListDto(tBrokerRepository.findAll(pageable));
    }

    @Override
    public DocumentCenterListDto findDocumentCenterListByCriteria(RequestParameter requestParameter) throws ParseException {
        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        Pageable pageable = querySetupUtil.setPageable(requestParameter);
        GenericSpecification<?> genericSpecification = querySetupUtil.setDocumentCenterListWhereClause(requestParameter);
        Page<VDocumentCenterEntity> vDocumentCenterEntityPage = vDocumentCenterRepository.findAll((Specification<VDocumentCenterEntity>) genericSpecification,pageable);
        return new DocumentCenterListDto(vDocumentCenterEntityPage);
    }

    @Override
    public TDocumentCenterEntity findDocumentCenterRecordById(Long documentCenterRecordId) {
        return tDocumentCenterRepository.findById(documentCenterRecordId).orElse(null);
    }

    @Override
    public DocumentCenterCategoryListDto getCategoryList() {

        List<TDocumentCenterCategoryEntity> tDocumentCenterCategoryEntityList = tDocumentCenterCategoryRepository.findAll();
        HashMap<String, MainCategoryDto> mainCategoryDtoHashMap = new HashMap<>();
        List<TDocumentCenterCategoryEntity> level2List = new ArrayList<>();
        tDocumentCenterCategoryEntityList.forEach(
                t -> {
                    if (t.getUpperCategoryId() == 0) {
                        MainCategoryDto mainCategoryDto = new MainCategoryDto();
                        mainCategoryDto.setCategoryId(String.valueOf(t.getCategoryId()));
                        mainCategoryDto.setUpperCategoryId(String.valueOf(t.getUpperCategoryId()));
                        mainCategoryDto.setCategoryEnglish(t.getCategoryEnglish());
                        mainCategoryDto.setCategoryZHTW(t.getCategoryZHTW());
                        mainCategoryDto.setCategoryZHCN(t.getCategoryZHCN());
                        mainCategoryDtoHashMap.put(mainCategoryDto.getCategoryId(),mainCategoryDto);
                    }
                    else level2List.add(t);
                }
        );



        level2List.forEach( l2 -> {
            DocumentCenterCategoryParameter subCategoryDto = new DocumentCenterCategoryParameter();
            MainCategoryDto mainCategoryDto = new MainCategoryDto();

            if (mainCategoryDtoHashMap.get(String.valueOf(l2.getUpperCategoryId())) != null) {
                mainCategoryDto = mainCategoryDtoHashMap.get(String.valueOf(l2.getUpperCategoryId()));
            }
            subCategoryDto.setCategoryId(String.valueOf(l2.getCategoryId()));
            subCategoryDto.setUpperCategoryId(String.valueOf(l2.getUpperCategoryId()));
            subCategoryDto.setCategoryEnglish(l2.getCategoryEnglish());
            subCategoryDto.setCategoryZHTW(l2.getCategoryZHTW());
            subCategoryDto.setCategoryZHCN(l2.getCategoryZHCN());
            if(mainCategoryDto.getSecondLevelCategoryList() == null) mainCategoryDto.setSecondLevelCategoryList(new ArrayList<>());
            mainCategoryDto.getSecondLevelCategoryList().add(subCategoryDto);
            mainCategoryDtoHashMap.put(mainCategoryDto.getCategoryId(),mainCategoryDto);
        });
        List<MainCategoryDto> mainCategoryDtoList = mainCategoryDtoHashMap.values().stream().collect(Collectors.toList());

        var documentCenterCategoryListDto = new DocumentCenterCategoryListDto();
        documentCenterCategoryListDto.setFirstLevelCategoryList(mainCategoryDtoList);
        return documentCenterCategoryListDto;
    }

    @Override
    public TDocumentCenterCategoryEntity createOrUpdateDocumentCenterCategory(RequestParameter requestParameter) {

        if (!requestParameter
                .getDocumentCenterCategoryParameter()
                .getUpperCategoryId()
                .equals("0")
                &&
                tDocumentCenterCategoryRepository
                    .findById(Long.valueOf(requestParameter.getDocumentCenterCategoryParameter().getUpperCategoryId()))
                    .orElseThrow(() -> new DataIntegrityViolationException("UpperCategoryId not exist"))
                    .getUpperCategoryId() != 0)
        {
            throw new DataIntegrityViolationException("UpperCategoryId Not a main category id ");
        }

        try{
            return tDocumentCenterCategoryRepository.save(new TDocumentCenterCategoryEntity(requestParameter));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Duplicate category name ");
        }
    }

    @Override
    public List<TDocumentCenterVisibilityEntity> findTDocumentCenterVisibilityListByDocumentCenterId(RequestParameter requestParameter){
        return tDocumentCenterVisibilityRepository.findByDocumentCenterId(Long.parseLong(requestParameter.getDocumentCenterParameter().getDocumentCenterId()));
    }


}
