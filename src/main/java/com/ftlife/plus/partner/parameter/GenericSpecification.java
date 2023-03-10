package com.ftlife.plus.partner.parameter;

import com.ftlife.plus.partner.entity.TCampaignDetailEntity;
import com.ftlife.plus.partner.entity.TCampaignHeaderEntity;
import com.ftlife.plus.partner.entity.TDocumentCenterVisibilityEntity;
import com.ftlife.plus.partner.util.StringUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericSpecification<T> implements Specification<T> {

    private static final long serialVersionUID = 1900581010229669687L;

    private List<SearchCriteria> list;

    public GenericSpecification() {
        this.list = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : list) {
            if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                if( criteria.getValue() instanceof Date )
                    predicates.add(builder.greaterThan(root.get(criteria.getKey()), (Date) criteria.getValue()));
                else
                    predicates.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                if( criteria.getValue() instanceof Date )
                    predicates.add(builder.lessThan(root.get(criteria.getKey()), (Date) criteria.getValue()));
                else
                    predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                if( criteria.getValue() instanceof Date )
                    predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()), (Date)criteria.getValue()));
                else
                    predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                if( criteria.getValue() instanceof Date )
                    predicates.add(builder.lessThanOrEqualTo(root.get(criteria.getKey()), (Date)criteria.getValue()));
                else
                    predicates.add(builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.IN)) {
                List<String> stringList = StringUtil.stringToStringListByDelimiter(criteria.getValue().toString(),";");
                Expression<String> exp = root.get(criteria.getKey());
                Predicate predicate = exp.in(stringList);
                predicates.add(predicate);
            } else if (criteria.getOperation().equals(SearchOperation.GROUP_OR)){
                var stringList = StringUtil.stringToStringListByDelimiter(criteria.getKey(),";");
                var predicateList = new ArrayList<Predicate>();
                stringList.forEach(s -> {
                    Predicate predicate = builder.like(builder.lower(root.get(s)), "%" + criteria.getValue().toString().toLowerCase() + "%");
                    predicateList.add(predicate);
                });
                predicates.add(builder.or(predicateList.toArray(predicateList.toArray(new Predicate[]{}))));

            } else if (criteria.getOperation().equals(SearchOperation.EXIST_DOCUMENT_CENTER)){
                Subquery<TDocumentCenterVisibilityEntity> subQuery = query.subquery(TDocumentCenterVisibilityEntity.class);
                Root<TDocumentCenterVisibilityEntity> subRoot = subQuery.from(TDocumentCenterVisibilityEntity.class);
                // Mapping field - main query and sub-query
                Predicate visibilityMainPredicate = builder.equal(root.get("documentCenterId"), subRoot.get("documentCenterId"));
                // Input Broker Code List
                Expression<String> exp = subRoot.get(criteria.getKey());
                List<String> stringList = StringUtil.stringToStringListByDelimiter(criteria.getValue().toString(),";");
                stringList.add("ALL");
                Predicate visibilityBrokerCodeListPredicate = exp.in(stringList);

                Predicate combinePredicate = builder.and(visibilityBrokerCodeListPredicate,visibilityMainPredicate);
                subQuery.select(subRoot).where(combinePredicate);
                predicates.add(builder.exists(subQuery));

            }else if (criteria.getOperation().equals(SearchOperation.EXIST_CAMPAIGN)){
                Subquery<TCampaignDetailEntity> subQuery = query.subquery(TCampaignDetailEntity.class);
                Root<TCampaignDetailEntity> subRoot = subQuery.from(TCampaignDetailEntity.class);
                // Mapping field - main query and sub-query
                Predicate visibilityMainPredicate = builder.equal(root.get("campaignHeaderId"), subRoot.get("campaignHeaderId"));
                // Input Broker Code List
                Expression<String> exp = subRoot.get(criteria.getKey());
                List<String> stringList = StringUtil.stringToStringListByDelimiter(criteria.getValue().toString(),";");
                stringList.add("ALL");
                Predicate visibilityBrokerCodeListPredicate = exp.in(stringList);

                Predicate combinePredicate = builder.and(visibilityBrokerCodeListPredicate,visibilityMainPredicate);
                subQuery.select(subRoot).where(combinePredicate);
                predicates.add(builder.exists(subQuery));

            }else if (criteria.getOperation().equals(SearchOperation.EXIST_VISIBILITY_LIST)){
                Subquery<TDocumentCenterVisibilityEntity> subQuery = query.subquery(TDocumentCenterVisibilityEntity.class);
                Root<TDocumentCenterVisibilityEntity> subRoot = subQuery.from(TDocumentCenterVisibilityEntity.class);
                // Mapping field - main query and sub-query
                Predicate visibilityMainPredicate = builder.equal(root.get("documentCenterId"), subRoot.get("documentCenterId"));
                // Input Broker Code List
//                Expression<String> exp = subRoot.get(criteria.getKey());
//                List<String> stringList = StringUtil.stringToStringListByDelimiter(criteria.getValue().toString(),";");
//                stringList.add("ALL");

                Expression<String> exp = subRoot.get(criteria.getKey());
                List<String> stringList = (List<String>) criteria.getValue();


                Predicate visibilityBrokerCodeListPredicate = exp.in(stringList);

                Predicate combinePredicate = builder.and(visibilityBrokerCodeListPredicate,visibilityMainPredicate);
                subQuery.select(subRoot).where(combinePredicate);
                predicates.add(builder.exists(subQuery));

            }
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}