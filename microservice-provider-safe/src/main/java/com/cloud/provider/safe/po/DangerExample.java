package com.cloud.provider.safe.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DangerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DangerExample() {
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
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

        public Criteria andDangerSiteIsNull() {
            addCriterion("danger_site is null");
            return (Criteria) this;
        }

        public Criteria andDangerSiteIsNotNull() {
            addCriterion("danger_site is not null");
            return (Criteria) this;
        }

        public Criteria andDangerSiteEqualTo(String value) {
            addCriterion("danger_site =", value, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteNotEqualTo(String value) {
            addCriterion("danger_site <>", value, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteGreaterThan(String value) {
            addCriterion("danger_site >", value, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteGreaterThanOrEqualTo(String value) {
            addCriterion("danger_site >=", value, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteLessThan(String value) {
            addCriterion("danger_site <", value, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteLessThanOrEqualTo(String value) {
            addCriterion("danger_site <=", value, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteLike(String value) {
            addCriterion("danger_site like", value, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteNotLike(String value) {
            addCriterion("danger_site not like", value, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteIn(List<String> values) {
            addCriterion("danger_site in", values, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteNotIn(List<String> values) {
            addCriterion("danger_site not in", values, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteBetween(String value1, String value2) {
            addCriterion("danger_site between", value1, value2, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerSiteNotBetween(String value1, String value2) {
            addCriterion("danger_site not between", value1, value2, "dangerSite");
            return (Criteria) this;
        }

        public Criteria andDangerLevelIsNull() {
            addCriterion("danger_level is null");
            return (Criteria) this;
        }

        public Criteria andDangerLevelIsNotNull() {
            addCriterion("danger_level is not null");
            return (Criteria) this;
        }

        public Criteria andDangerLevelEqualTo(Integer value) {
            addCriterion("danger_level =", value, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerLevelNotEqualTo(Integer value) {
            addCriterion("danger_level <>", value, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerLevelGreaterThan(Integer value) {
            addCriterion("danger_level >", value, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("danger_level >=", value, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerLevelLessThan(Integer value) {
            addCriterion("danger_level <", value, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerLevelLessThanOrEqualTo(Integer value) {
            addCriterion("danger_level <=", value, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerLevelIn(List<Integer> values) {
            addCriterion("danger_level in", values, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerLevelNotIn(List<Integer> values) {
            addCriterion("danger_level not in", values, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerLevelBetween(Integer value1, Integer value2) {
            addCriterion("danger_level between", value1, value2, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("danger_level not between", value1, value2, "dangerLevel");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryIsNull() {
            addCriterion("danger_category is null");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryIsNotNull() {
            addCriterion("danger_category is not null");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryEqualTo(String value) {
            addCriterion("danger_category =", value, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryNotEqualTo(String value) {
            addCriterion("danger_category <>", value, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryGreaterThan(String value) {
            addCriterion("danger_category >", value, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("danger_category >=", value, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryLessThan(String value) {
            addCriterion("danger_category <", value, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryLessThanOrEqualTo(String value) {
            addCriterion("danger_category <=", value, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryLike(String value) {
            addCriterion("danger_category like", value, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryNotLike(String value) {
            addCriterion("danger_category not like", value, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryIn(List<String> values) {
            addCriterion("danger_category in", values, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryNotIn(List<String> values) {
            addCriterion("danger_category not in", values, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryBetween(String value1, String value2) {
            addCriterion("danger_category between", value1, value2, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerCategoryNotBetween(String value1, String value2) {
            addCriterion("danger_category not between", value1, value2, "dangerCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryIsNull() {
            addCriterion("danger_sub_category is null");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryIsNotNull() {
            addCriterion("danger_sub_category is not null");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryEqualTo(String value) {
            addCriterion("danger_sub_category =", value, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryNotEqualTo(String value) {
            addCriterion("danger_sub_category <>", value, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryGreaterThan(String value) {
            addCriterion("danger_sub_category >", value, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("danger_sub_category >=", value, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryLessThan(String value) {
            addCriterion("danger_sub_category <", value, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryLessThanOrEqualTo(String value) {
            addCriterion("danger_sub_category <=", value, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryLike(String value) {
            addCriterion("danger_sub_category like", value, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryNotLike(String value) {
            addCriterion("danger_sub_category not like", value, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryIn(List<String> values) {
            addCriterion("danger_sub_category in", values, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryNotIn(List<String> values) {
            addCriterion("danger_sub_category not in", values, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryBetween(String value1, String value2) {
            addCriterion("danger_sub_category between", value1, value2, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerSubCategoryNotBetween(String value1, String value2) {
            addCriterion("danger_sub_category not between", value1, value2, "dangerSubCategory");
            return (Criteria) this;
        }

        public Criteria andDangerTimeIsNull() {
            addCriterion("danger_time is null");
            return (Criteria) this;
        }

        public Criteria andDangerTimeIsNotNull() {
            addCriterion("danger_time is not null");
            return (Criteria) this;
        }

        public Criteria andDangerTimeEqualTo(Date value) {
            addCriterion("danger_time =", value, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerTimeNotEqualTo(Date value) {
            addCriterion("danger_time <>", value, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerTimeGreaterThan(Date value) {
            addCriterion("danger_time >", value, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("danger_time >=", value, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerTimeLessThan(Date value) {
            addCriterion("danger_time <", value, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerTimeLessThanOrEqualTo(Date value) {
            addCriterion("danger_time <=", value, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerTimeIn(List<Date> values) {
            addCriterion("danger_time in", values, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerTimeNotIn(List<Date> values) {
            addCriterion("danger_time not in", values, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerTimeBetween(Date value1, Date value2) {
            addCriterion("danger_time between", value1, value2, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerTimeNotBetween(Date value1, Date value2) {
            addCriterion("danger_time not between", value1, value2, "dangerTime");
            return (Criteria) this;
        }

        public Criteria andDangerDescIsNull() {
            addCriterion("danger_desc is null");
            return (Criteria) this;
        }

        public Criteria andDangerDescIsNotNull() {
            addCriterion("danger_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDangerDescEqualTo(String value) {
            addCriterion("danger_desc =", value, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescNotEqualTo(String value) {
            addCriterion("danger_desc <>", value, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescGreaterThan(String value) {
            addCriterion("danger_desc >", value, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescGreaterThanOrEqualTo(String value) {
            addCriterion("danger_desc >=", value, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescLessThan(String value) {
            addCriterion("danger_desc <", value, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescLessThanOrEqualTo(String value) {
            addCriterion("danger_desc <=", value, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescLike(String value) {
            addCriterion("danger_desc like", value, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescNotLike(String value) {
            addCriterion("danger_desc not like", value, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescIn(List<String> values) {
            addCriterion("danger_desc in", values, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescNotIn(List<String> values) {
            addCriterion("danger_desc not in", values, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescBetween(String value1, String value2) {
            addCriterion("danger_desc between", value1, value2, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerDescNotBetween(String value1, String value2) {
            addCriterion("danger_desc not between", value1, value2, "dangerDesc");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdIsNull() {
            addCriterion("danger_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdIsNotNull() {
            addCriterion("danger_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdEqualTo(Integer value) {
            addCriterion("danger_user_id =", value, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdNotEqualTo(Integer value) {
            addCriterion("danger_user_id <>", value, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdGreaterThan(Integer value) {
            addCriterion("danger_user_id >", value, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("danger_user_id >=", value, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdLessThan(Integer value) {
            addCriterion("danger_user_id <", value, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("danger_user_id <=", value, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdIn(List<Integer> values) {
            addCriterion("danger_user_id in", values, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdNotIn(List<Integer> values) {
            addCriterion("danger_user_id not in", values, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdBetween(Integer value1, Integer value2) {
            addCriterion("danger_user_id between", value1, value2, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangerUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("danger_user_id not between", value1, value2, "dangerUserId");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountIsNull() {
            addCriterion("dange_user_account is null");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountIsNotNull() {
            addCriterion("dange_user_account is not null");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountEqualTo(String value) {
            addCriterion("dange_user_account =", value, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountNotEqualTo(String value) {
            addCriterion("dange_user_account <>", value, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountGreaterThan(String value) {
            addCriterion("dange_user_account >", value, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("dange_user_account >=", value, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountLessThan(String value) {
            addCriterion("dange_user_account <", value, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountLessThanOrEqualTo(String value) {
            addCriterion("dange_user_account <=", value, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountLike(String value) {
            addCriterion("dange_user_account like", value, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountNotLike(String value) {
            addCriterion("dange_user_account not like", value, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountIn(List<String> values) {
            addCriterion("dange_user_account in", values, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountNotIn(List<String> values) {
            addCriterion("dange_user_account not in", values, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountBetween(String value1, String value2) {
            addCriterion("dange_user_account between", value1, value2, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserAccountNotBetween(String value1, String value2) {
            addCriterion("dange_user_account not between", value1, value2, "dangeUserAccount");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameIsNull() {
            addCriterion("dange_user_name is null");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameIsNotNull() {
            addCriterion("dange_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameEqualTo(String value) {
            addCriterion("dange_user_name =", value, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameNotEqualTo(String value) {
            addCriterion("dange_user_name <>", value, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameGreaterThan(String value) {
            addCriterion("dange_user_name >", value, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("dange_user_name >=", value, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameLessThan(String value) {
            addCriterion("dange_user_name <", value, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameLessThanOrEqualTo(String value) {
            addCriterion("dange_user_name <=", value, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameLike(String value) {
            addCriterion("dange_user_name like", value, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameNotLike(String value) {
            addCriterion("dange_user_name not like", value, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameIn(List<String> values) {
            addCriterion("dange_user_name in", values, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameNotIn(List<String> values) {
            addCriterion("dange_user_name not in", values, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameBetween(String value1, String value2) {
            addCriterion("dange_user_name between", value1, value2, "dangeUserName");
            return (Criteria) this;
        }

        public Criteria andDangeUserNameNotBetween(String value1, String value2) {
            addCriterion("dange_user_name not between", value1, value2, "dangeUserName");
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