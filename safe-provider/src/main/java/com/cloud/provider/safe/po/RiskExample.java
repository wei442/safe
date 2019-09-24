package com.cloud.provider.safe.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiskExample() {
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

        public Criteria andRiskCodeIsNull() {
            addCriterion("risk_code is null");
            return (Criteria) this;
        }

        public Criteria andRiskCodeIsNotNull() {
            addCriterion("risk_code is not null");
            return (Criteria) this;
        }

        public Criteria andRiskCodeEqualTo(String value) {
            addCriterion("risk_code =", value, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeNotEqualTo(String value) {
            addCriterion("risk_code <>", value, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeGreaterThan(String value) {
            addCriterion("risk_code >", value, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeGreaterThanOrEqualTo(String value) {
            addCriterion("risk_code >=", value, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeLessThan(String value) {
            addCriterion("risk_code <", value, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeLessThanOrEqualTo(String value) {
            addCriterion("risk_code <=", value, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeLike(String value) {
            addCriterion("risk_code like", value, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeNotLike(String value) {
            addCriterion("risk_code not like", value, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeIn(List<String> values) {
            addCriterion("risk_code in", values, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeNotIn(List<String> values) {
            addCriterion("risk_code not in", values, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeBetween(String value1, String value2) {
            addCriterion("risk_code between", value1, value2, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskCodeNotBetween(String value1, String value2) {
            addCriterion("risk_code not between", value1, value2, "riskCode");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceIsNull() {
            addCriterion("risk_work_place is null");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceIsNotNull() {
            addCriterion("risk_work_place is not null");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceEqualTo(String value) {
            addCriterion("risk_work_place =", value, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceNotEqualTo(String value) {
            addCriterion("risk_work_place <>", value, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceGreaterThan(String value) {
            addCriterion("risk_work_place >", value, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("risk_work_place >=", value, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceLessThan(String value) {
            addCriterion("risk_work_place <", value, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("risk_work_place <=", value, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceLike(String value) {
            addCriterion("risk_work_place like", value, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceNotLike(String value) {
            addCriterion("risk_work_place not like", value, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceIn(List<String> values) {
            addCriterion("risk_work_place in", values, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceNotIn(List<String> values) {
            addCriterion("risk_work_place not in", values, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceBetween(String value1, String value2) {
            addCriterion("risk_work_place between", value1, value2, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("risk_work_place not between", value1, value2, "riskWorkPlace");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryIsNull() {
            addCriterion("risk_category is null");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryIsNotNull() {
            addCriterion("risk_category is not null");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryEqualTo(String value) {
            addCriterion("risk_category =", value, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryNotEqualTo(String value) {
            addCriterion("risk_category <>", value, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryGreaterThan(String value) {
            addCriterion("risk_category >", value, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("risk_category >=", value, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryLessThan(String value) {
            addCriterion("risk_category <", value, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryLessThanOrEqualTo(String value) {
            addCriterion("risk_category <=", value, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryLike(String value) {
            addCriterion("risk_category like", value, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryNotLike(String value) {
            addCriterion("risk_category not like", value, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryIn(List<String> values) {
            addCriterion("risk_category in", values, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryNotIn(List<String> values) {
            addCriterion("risk_category not in", values, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryBetween(String value1, String value2) {
            addCriterion("risk_category between", value1, value2, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskCategoryNotBetween(String value1, String value2) {
            addCriterion("risk_category not between", value1, value2, "riskCategory");
            return (Criteria) this;
        }

        public Criteria andRiskReasonIsNull() {
            addCriterion("risk_reason is null");
            return (Criteria) this;
        }

        public Criteria andRiskReasonIsNotNull() {
            addCriterion("risk_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRiskReasonEqualTo(String value) {
            addCriterion("risk_reason =", value, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonNotEqualTo(String value) {
            addCriterion("risk_reason <>", value, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonGreaterThan(String value) {
            addCriterion("risk_reason >", value, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonGreaterThanOrEqualTo(String value) {
            addCriterion("risk_reason >=", value, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonLessThan(String value) {
            addCriterion("risk_reason <", value, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonLessThanOrEqualTo(String value) {
            addCriterion("risk_reason <=", value, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonLike(String value) {
            addCriterion("risk_reason like", value, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonNotLike(String value) {
            addCriterion("risk_reason not like", value, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonIn(List<String> values) {
            addCriterion("risk_reason in", values, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonNotIn(List<String> values) {
            addCriterion("risk_reason not in", values, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonBetween(String value1, String value2) {
            addCriterion("risk_reason between", value1, value2, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskReasonNotBetween(String value1, String value2) {
            addCriterion("risk_reason not between", value1, value2, "riskReason");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNull() {
            addCriterion("risk_level is null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNotNull() {
            addCriterion("risk_level is not null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelEqualTo(String value) {
            addCriterion("risk_level =", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotEqualTo(String value) {
            addCriterion("risk_level <>", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThan(String value) {
            addCriterion("risk_level >", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThanOrEqualTo(String value) {
            addCriterion("risk_level >=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThan(String value) {
            addCriterion("risk_level <", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThanOrEqualTo(String value) {
            addCriterion("risk_level <=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLike(String value) {
            addCriterion("risk_level like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotLike(String value) {
            addCriterion("risk_level not like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIn(List<String> values) {
            addCriterion("risk_level in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotIn(List<String> values) {
            addCriterion("risk_level not in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelBetween(String value1, String value2) {
            addCriterion("risk_level between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotBetween(String value1, String value2) {
            addCriterion("risk_level not between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andControlReasonIsNull() {
            addCriterion("control_reason is null");
            return (Criteria) this;
        }

        public Criteria andControlReasonIsNotNull() {
            addCriterion("control_reason is not null");
            return (Criteria) this;
        }

        public Criteria andControlReasonEqualTo(String value) {
            addCriterion("control_reason =", value, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonNotEqualTo(String value) {
            addCriterion("control_reason <>", value, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonGreaterThan(String value) {
            addCriterion("control_reason >", value, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonGreaterThanOrEqualTo(String value) {
            addCriterion("control_reason >=", value, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonLessThan(String value) {
            addCriterion("control_reason <", value, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonLessThanOrEqualTo(String value) {
            addCriterion("control_reason <=", value, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonLike(String value) {
            addCriterion("control_reason like", value, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonNotLike(String value) {
            addCriterion("control_reason not like", value, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonIn(List<String> values) {
            addCriterion("control_reason in", values, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonNotIn(List<String> values) {
            addCriterion("control_reason not in", values, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonBetween(String value1, String value2) {
            addCriterion("control_reason between", value1, value2, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlReasonNotBetween(String value1, String value2) {
            addCriterion("control_reason not between", value1, value2, "controlReason");
            return (Criteria) this;
        }

        public Criteria andControlMethodIsNull() {
            addCriterion("control_method is null");
            return (Criteria) this;
        }

        public Criteria andControlMethodIsNotNull() {
            addCriterion("control_method is not null");
            return (Criteria) this;
        }

        public Criteria andControlMethodEqualTo(String value) {
            addCriterion("control_method =", value, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodNotEqualTo(String value) {
            addCriterion("control_method <>", value, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodGreaterThan(String value) {
            addCriterion("control_method >", value, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodGreaterThanOrEqualTo(String value) {
            addCriterion("control_method >=", value, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodLessThan(String value) {
            addCriterion("control_method <", value, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodLessThanOrEqualTo(String value) {
            addCriterion("control_method <=", value, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodLike(String value) {
            addCriterion("control_method like", value, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodNotLike(String value) {
            addCriterion("control_method not like", value, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodIn(List<String> values) {
            addCriterion("control_method in", values, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodNotIn(List<String> values) {
            addCriterion("control_method not in", values, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodBetween(String value1, String value2) {
            addCriterion("control_method between", value1, value2, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andControlMethodNotBetween(String value1, String value2) {
            addCriterion("control_method not between", value1, value2, "controlMethod");
            return (Criteria) this;
        }

        public Criteria andRiskStatusIsNull() {
            addCriterion("risk_status is null");
            return (Criteria) this;
        }

        public Criteria andRiskStatusIsNotNull() {
            addCriterion("risk_status is not null");
            return (Criteria) this;
        }

        public Criteria andRiskStatusEqualTo(Integer value) {
            addCriterion("risk_status =", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusNotEqualTo(Integer value) {
            addCriterion("risk_status <>", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusGreaterThan(Integer value) {
            addCriterion("risk_status >", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("risk_status >=", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusLessThan(Integer value) {
            addCriterion("risk_status <", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("risk_status <=", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusIn(List<Integer> values) {
            addCriterion("risk_status in", values, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusNotIn(List<Integer> values) {
            addCriterion("risk_status not in", values, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusBetween(Integer value1, Integer value2) {
            addCriterion("risk_status between", value1, value2, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("risk_status not between", value1, value2, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andIsDangerIsNull() {
            addCriterion("is_danger is null");
            return (Criteria) this;
        }

        public Criteria andIsDangerIsNotNull() {
            addCriterion("is_danger is not null");
            return (Criteria) this;
        }

        public Criteria andIsDangerEqualTo(Integer value) {
            addCriterion("is_danger =", value, "isDanger");
            return (Criteria) this;
        }

        public Criteria andIsDangerNotEqualTo(Integer value) {
            addCriterion("is_danger <>", value, "isDanger");
            return (Criteria) this;
        }

        public Criteria andIsDangerGreaterThan(Integer value) {
            addCriterion("is_danger >", value, "isDanger");
            return (Criteria) this;
        }

        public Criteria andIsDangerGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_danger >=", value, "isDanger");
            return (Criteria) this;
        }

        public Criteria andIsDangerLessThan(Integer value) {
            addCriterion("is_danger <", value, "isDanger");
            return (Criteria) this;
        }

        public Criteria andIsDangerLessThanOrEqualTo(Integer value) {
            addCriterion("is_danger <=", value, "isDanger");
            return (Criteria) this;
        }

        public Criteria andIsDangerIn(List<Integer> values) {
            addCriterion("is_danger in", values, "isDanger");
            return (Criteria) this;
        }

        public Criteria andIsDangerNotIn(List<Integer> values) {
            addCriterion("is_danger not in", values, "isDanger");
            return (Criteria) this;
        }

        public Criteria andIsDangerBetween(Integer value1, Integer value2) {
            addCriterion("is_danger between", value1, value2, "isDanger");
            return (Criteria) this;
        }

        public Criteria andIsDangerNotBetween(Integer value1, Integer value2) {
            addCriterion("is_danger not between", value1, value2, "isDanger");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(String value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(String value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(String value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(String value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(String value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLike(String value) {
            addCriterion("frequency like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotLike(String value) {
            addCriterion("frequency not like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<String> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<String> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(String value1, String value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(String value1, String value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
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