package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.RequestParameter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TDocumentCenterVisibility")
@Getter
@Setter
public class TDocumentCenterVisibilityEntity extends DefaultCommon{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documentCenterVisibilityId")
    private long documentCenterVisibilityId;

    @Column(name = "documentCenterId", nullable = false)
    private long documentCenterId;

    @Column(name = "agentCode", nullable = false)
    @Size(min = 1, max = 200)
    private String agentCode;


    public List<TDocumentCenterVisibilityEntity> prepareTDocumentCenterVisibilityEntityList(RequestParameter requestParameter){
        if (requestParameter.getDocumentCenterParameter().getVisibilityList() == null){
            return new ArrayList<>();
        }
        List<String> visibilityList = Arrays.asList(requestParameter.getDocumentCenterParameter().getVisibilityList());
        List<TDocumentCenterVisibilityEntity> tTDocumentCenterVisibilityEntityList = new ArrayList<TDocumentCenterVisibilityEntity>();

        visibilityList.forEach(a -> {
            var tTDocumentCenterVisibilityEntity = new TDocumentCenterVisibilityEntity();
            tTDocumentCenterVisibilityEntity.setDocumentCenterId(Long.parseLong(requestParameter.getDocumentCenterParameter().getDocumentCenterId()));
            tTDocumentCenterVisibilityEntity.setAgentCode(a);
            tTDocumentCenterVisibilityEntity.setCreatedBy(requestParameter.getUserParameter().getLoginName());
            tTDocumentCenterVisibilityEntity.setUpdatedBy(requestParameter.getUserParameter().getLoginName());
            Date now = new Date();
            tTDocumentCenterVisibilityEntity.setCreatedDate(now);
            tTDocumentCenterVisibilityEntity.setUpdatedDate(now);
            tTDocumentCenterVisibilityEntityList.add(tTDocumentCenterVisibilityEntity);
        });
        return tTDocumentCenterVisibilityEntityList;
    }
}
