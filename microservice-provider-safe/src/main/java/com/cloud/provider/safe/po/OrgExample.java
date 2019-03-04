package com.cloud.provider.safe.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrgExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(Integer value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Integer value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Integer value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Integer> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdIsNull() {
            addCriterion("parent_org_id is null");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdIsNotNull() {
            addCriterion("parent_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdEqualTo(Integer value) {
            addCriterion("parent_org_id =", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdNotEqualTo(Integer value) {
            addCriterion("parent_org_id <>", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdGreaterThan(Integer value) {
            addCriterion("parent_org_id >", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_org_id >=", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdLessThan(Integer value) {
            addCriterion("parent_org_id <", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_org_id <=", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdIn(List<Integer> values) {
            addCriterion("parent_org_id in", values, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdNotIn(List<Integer> values) {
            addCriterion("parent_org_id not in", values, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_org_id between", value1, value2, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_org_id not between", value1, value2, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameIsNull() {
            addCriterion("parent_org_name is null");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameIsNotNull() {
            addCriterion("parent_org_name is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEqualTo(String value) {
            addCriterion("parent_org_name =", value, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameNotEqualTo(String value) {
            addCriterion("parent_org_name <>", value, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameGreaterThan(String value) {
            addCriterion("parent_org_name >", value, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("parent_org_name >=", value, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameLessThan(String value) {
            addCriterion("parent_org_name <", value, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameLessThanOrEqualTo(String value) {
            addCriterion("parent_org_name <=", value, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameLike(String value) {
            addCriterion("parent_org_name like", value, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameNotLike(String value) {
            addCriterion("parent_org_name not like", value, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameIn(List<String> values) {
            addCriterion("parent_org_name in", values, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameNotIn(List<String> values) {
            addCriterion("parent_org_name not in", values, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameBetween(String value1, String value2) {
            addCriterion("parent_org_name between", value1, value2, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameNotBetween(String value1, String value2) {
            addCriterion("parent_org_name not between", value1, value2, "parentOrgName");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnIsNull() {
            addCriterion("parent_org_name_en is null");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnIsNotNull() {
            addCriterion("parent_org_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnEqualTo(String value) {
            addCriterion("parent_org_name_en =", value, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnNotEqualTo(String value) {
            addCriterion("parent_org_name_en <>", value, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnGreaterThan(String value) {
            addCriterion("parent_org_name_en >", value, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("parent_org_name_en >=", value, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnLessThan(String value) {
            addCriterion("parent_org_name_en <", value, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnLessThanOrEqualTo(String value) {
            addCriterion("parent_org_name_en <=", value, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnLike(String value) {
            addCriterion("parent_org_name_en like", value, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnNotLike(String value) {
            addCriterion("parent_org_name_en not like", value, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnIn(List<String> values) {
            addCriterion("parent_org_name_en in", values, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnNotIn(List<String> values) {
            addCriterion("parent_org_name_en not in", values, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnBetween(String value1, String value2) {
            addCriterion("parent_org_name_en between", value1, value2, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andParentOrgNameEnNotBetween(String value1, String value2) {
            addCriterion("parent_org_name_en not between", value1, value2, "parentOrgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnIsNull() {
            addCriterion("org_name_en is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnIsNotNull() {
            addCriterion("org_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnEqualTo(String value) {
            addCriterion("org_name_en =", value, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnNotEqualTo(String value) {
            addCriterion("org_name_en <>", value, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnGreaterThan(String value) {
            addCriterion("org_name_en >", value, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("org_name_en >=", value, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnLessThan(String value) {
            addCriterion("org_name_en <", value, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnLessThanOrEqualTo(String value) {
            addCriterion("org_name_en <=", value, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnLike(String value) {
            addCriterion("org_name_en like", value, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnNotLike(String value) {
            addCriterion("org_name_en not like", value, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnIn(List<String> values) {
            addCriterion("org_name_en in", values, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnNotIn(List<String> values) {
            addCriterion("org_name_en not in", values, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnBetween(String value1, String value2) {
            addCriterion("org_name_en between", value1, value2, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgNameEnNotBetween(String value1, String value2) {
            addCriterion("org_name_en not between", value1, value2, "orgNameEn");
            return (Criteria) this;
        }

        public Criteria andOrgAliasIsNull() {
            addCriterion("org_alias is null");
            return (Criteria) this;
        }

        public Criteria andOrgAliasIsNotNull() {
            addCriterion("org_alias is not null");
            return (Criteria) this;
        }

        public Criteria andOrgAliasEqualTo(String value) {
            addCriterion("org_alias =", value, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasNotEqualTo(String value) {
            addCriterion("org_alias <>", value, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasGreaterThan(String value) {
            addCriterion("org_alias >", value, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasGreaterThanOrEqualTo(String value) {
            addCriterion("org_alias >=", value, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasLessThan(String value) {
            addCriterion("org_alias <", value, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasLessThanOrEqualTo(String value) {
            addCriterion("org_alias <=", value, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasLike(String value) {
            addCriterion("org_alias like", value, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasNotLike(String value) {
            addCriterion("org_alias not like", value, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasIn(List<String> values) {
            addCriterion("org_alias in", values, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasNotIn(List<String> values) {
            addCriterion("org_alias not in", values, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasBetween(String value1, String value2) {
            addCriterion("org_alias between", value1, value2, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgAliasNotBetween(String value1, String value2) {
            addCriterion("org_alias not between", value1, value2, "orgAlias");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneIsNull() {
            addCriterion("org_telphone is null");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneIsNotNull() {
            addCriterion("org_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneEqualTo(String value) {
            addCriterion("org_telphone =", value, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneNotEqualTo(String value) {
            addCriterion("org_telphone <>", value, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneGreaterThan(String value) {
            addCriterion("org_telphone >", value, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("org_telphone >=", value, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneLessThan(String value) {
            addCriterion("org_telphone <", value, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneLessThanOrEqualTo(String value) {
            addCriterion("org_telphone <=", value, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneLike(String value) {
            addCriterion("org_telphone like", value, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneNotLike(String value) {
            addCriterion("org_telphone not like", value, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneIn(List<String> values) {
            addCriterion("org_telphone in", values, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneNotIn(List<String> values) {
            addCriterion("org_telphone not in", values, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneBetween(String value1, String value2) {
            addCriterion("org_telphone between", value1, value2, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTelphoneNotBetween(String value1, String value2) {
            addCriterion("org_telphone not between", value1, value2, "orgTelphone");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNull() {
            addCriterion("org_type is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("org_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(Integer value) {
            addCriterion("org_type =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(Integer value) {
            addCriterion("org_type <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(Integer value) {
            addCriterion("org_type >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_type >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(Integer value) {
            addCriterion("org_type <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(Integer value) {
            addCriterion("org_type <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<Integer> values) {
            addCriterion("org_type in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<Integer> values) {
            addCriterion("org_type not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(Integer value1, Integer value2) {
            addCriterion("org_type between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("org_type not between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNull() {
            addCriterion("org_status is null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNotNull() {
            addCriterion("org_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusEqualTo(Integer value) {
            addCriterion("org_status =", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotEqualTo(Integer value) {
            addCriterion("org_status <>", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThan(Integer value) {
            addCriterion("org_status >", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_status >=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThan(Integer value) {
            addCriterion("org_status <", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThanOrEqualTo(Integer value) {
            addCriterion("org_status <=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIn(List<Integer> values) {
            addCriterion("org_status in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotIn(List<Integer> values) {
            addCriterion("org_status not in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusBetween(Integer value1, Integer value2) {
            addCriterion("org_status between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("org_status not between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgLevelIsNull() {
            addCriterion("org_level is null");
            return (Criteria) this;
        }

        public Criteria andOrgLevelIsNotNull() {
            addCriterion("org_level is not null");
            return (Criteria) this;
        }

        public Criteria andOrgLevelEqualTo(Integer value) {
            addCriterion("org_level =", value, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgLevelNotEqualTo(Integer value) {
            addCriterion("org_level <>", value, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgLevelGreaterThan(Integer value) {
            addCriterion("org_level >", value, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_level >=", value, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgLevelLessThan(Integer value) {
            addCriterion("org_level <", value, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgLevelLessThanOrEqualTo(Integer value) {
            addCriterion("org_level <=", value, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgLevelIn(List<Integer> values) {
            addCriterion("org_level in", values, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgLevelNotIn(List<Integer> values) {
            addCriterion("org_level not in", values, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgLevelBetween(Integer value1, Integer value2) {
            addCriterion("org_level between", value1, value2, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("org_level not between", value1, value2, "orgLevel");
            return (Criteria) this;
        }

        public Criteria andOrgFaxIsNull() {
            addCriterion("org_fax is null");
            return (Criteria) this;
        }

        public Criteria andOrgFaxIsNotNull() {
            addCriterion("org_fax is not null");
            return (Criteria) this;
        }

        public Criteria andOrgFaxEqualTo(String value) {
            addCriterion("org_fax =", value, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxNotEqualTo(String value) {
            addCriterion("org_fax <>", value, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxGreaterThan(String value) {
            addCriterion("org_fax >", value, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxGreaterThanOrEqualTo(String value) {
            addCriterion("org_fax >=", value, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxLessThan(String value) {
            addCriterion("org_fax <", value, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxLessThanOrEqualTo(String value) {
            addCriterion("org_fax <=", value, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxLike(String value) {
            addCriterion("org_fax like", value, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxNotLike(String value) {
            addCriterion("org_fax not like", value, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxIn(List<String> values) {
            addCriterion("org_fax in", values, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxNotIn(List<String> values) {
            addCriterion("org_fax not in", values, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxBetween(String value1, String value2) {
            addCriterion("org_fax between", value1, value2, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgFaxNotBetween(String value1, String value2) {
            addCriterion("org_fax not between", value1, value2, "orgFax");
            return (Criteria) this;
        }

        public Criteria andOrgEmailIsNull() {
            addCriterion("org_email is null");
            return (Criteria) this;
        }

        public Criteria andOrgEmailIsNotNull() {
            addCriterion("org_email is not null");
            return (Criteria) this;
        }

        public Criteria andOrgEmailEqualTo(String value) {
            addCriterion("org_email =", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailNotEqualTo(String value) {
            addCriterion("org_email <>", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailGreaterThan(String value) {
            addCriterion("org_email >", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailGreaterThanOrEqualTo(String value) {
            addCriterion("org_email >=", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailLessThan(String value) {
            addCriterion("org_email <", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailLessThanOrEqualTo(String value) {
            addCriterion("org_email <=", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailLike(String value) {
            addCriterion("org_email like", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailNotLike(String value) {
            addCriterion("org_email not like", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailIn(List<String> values) {
            addCriterion("org_email in", values, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailNotIn(List<String> values) {
            addCriterion("org_email not in", values, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailBetween(String value1, String value2) {
            addCriterion("org_email between", value1, value2, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailNotBetween(String value1, String value2) {
            addCriterion("org_email not between", value1, value2, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeIsNull() {
            addCriterion("org_post_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeIsNotNull() {
            addCriterion("org_post_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeEqualTo(String value) {
            addCriterion("org_post_code =", value, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeNotEqualTo(String value) {
            addCriterion("org_post_code <>", value, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeGreaterThan(String value) {
            addCriterion("org_post_code >", value, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_post_code >=", value, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeLessThan(String value) {
            addCriterion("org_post_code <", value, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeLessThanOrEqualTo(String value) {
            addCriterion("org_post_code <=", value, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeLike(String value) {
            addCriterion("org_post_code like", value, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeNotLike(String value) {
            addCriterion("org_post_code not like", value, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeIn(List<String> values) {
            addCriterion("org_post_code in", values, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeNotIn(List<String> values) {
            addCriterion("org_post_code not in", values, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeBetween(String value1, String value2) {
            addCriterion("org_post_code between", value1, value2, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgPostCodeNotBetween(String value1, String value2) {
            addCriterion("org_post_code not between", value1, value2, "orgPostCode");
            return (Criteria) this;
        }

        public Criteria andOrgAddrIsNull() {
            addCriterion("org_addr is null");
            return (Criteria) this;
        }

        public Criteria andOrgAddrIsNotNull() {
            addCriterion("org_addr is not null");
            return (Criteria) this;
        }

        public Criteria andOrgAddrEqualTo(String value) {
            addCriterion("org_addr =", value, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrNotEqualTo(String value) {
            addCriterion("org_addr <>", value, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrGreaterThan(String value) {
            addCriterion("org_addr >", value, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrGreaterThanOrEqualTo(String value) {
            addCriterion("org_addr >=", value, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrLessThan(String value) {
            addCriterion("org_addr <", value, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrLessThanOrEqualTo(String value) {
            addCriterion("org_addr <=", value, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrLike(String value) {
            addCriterion("org_addr like", value, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrNotLike(String value) {
            addCriterion("org_addr not like", value, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrIn(List<String> values) {
            addCriterion("org_addr in", values, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrNotIn(List<String> values) {
            addCriterion("org_addr not in", values, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrBetween(String value1, String value2) {
            addCriterion("org_addr between", value1, value2, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgAddrNotBetween(String value1, String value2) {
            addCriterion("org_addr not between", value1, value2, "orgAddr");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideIsNull() {
            addCriterion("org_webside is null");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideIsNotNull() {
            addCriterion("org_webside is not null");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideEqualTo(String value) {
            addCriterion("org_webside =", value, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideNotEqualTo(String value) {
            addCriterion("org_webside <>", value, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideGreaterThan(String value) {
            addCriterion("org_webside >", value, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideGreaterThanOrEqualTo(String value) {
            addCriterion("org_webside >=", value, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideLessThan(String value) {
            addCriterion("org_webside <", value, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideLessThanOrEqualTo(String value) {
            addCriterion("org_webside <=", value, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideLike(String value) {
            addCriterion("org_webside like", value, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideNotLike(String value) {
            addCriterion("org_webside not like", value, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideIn(List<String> values) {
            addCriterion("org_webside in", values, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideNotIn(List<String> values) {
            addCriterion("org_webside not in", values, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideBetween(String value1, String value2) {
            addCriterion("org_webside between", value1, value2, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andOrgWebsideNotBetween(String value1, String value2) {
            addCriterion("org_webside not between", value1, value2, "orgWebside");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(String value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(String value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(String value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(String value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(String value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(String value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLike(String value) {
            addCriterion("created like", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotLike(String value) {
            addCriterion("created not like", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<String> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<String> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(String value1, String value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(String value1, String value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(String value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(String value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(String value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(String value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(String value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(String value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLike(String value) {
            addCriterion("updated like", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotLike(String value) {
            addCriterion("updated not like", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<String> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<String> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(String value1, String value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(String value1, String value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}