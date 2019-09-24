package com.cloud.provider.safe.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiskAcceptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiskAcceptExample() {
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

        public Criteria andRiskIdIsNull() {
            addCriterion("risk_id is null");
            return (Criteria) this;
        }

        public Criteria andRiskIdIsNotNull() {
            addCriterion("risk_id is not null");
            return (Criteria) this;
        }

        public Criteria andRiskIdEqualTo(Integer value) {
            addCriterion("risk_id =", value, "riskId");
            return (Criteria) this;
        }

        public Criteria andRiskIdNotEqualTo(Integer value) {
            addCriterion("risk_id <>", value, "riskId");
            return (Criteria) this;
        }

        public Criteria andRiskIdGreaterThan(Integer value) {
            addCriterion("risk_id >", value, "riskId");
            return (Criteria) this;
        }

        public Criteria andRiskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("risk_id >=", value, "riskId");
            return (Criteria) this;
        }

        public Criteria andRiskIdLessThan(Integer value) {
            addCriterion("risk_id <", value, "riskId");
            return (Criteria) this;
        }

        public Criteria andRiskIdLessThanOrEqualTo(Integer value) {
            addCriterion("risk_id <=", value, "riskId");
            return (Criteria) this;
        }

        public Criteria andRiskIdIn(List<Integer> values) {
            addCriterion("risk_id in", values, "riskId");
            return (Criteria) this;
        }

        public Criteria andRiskIdNotIn(List<Integer> values) {
            addCriterion("risk_id not in", values, "riskId");
            return (Criteria) this;
        }

        public Criteria andRiskIdBetween(Integer value1, Integer value2) {
            addCriterion("risk_id between", value1, value2, "riskId");
            return (Criteria) this;
        }

        public Criteria andRiskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("risk_id not between", value1, value2, "riskId");
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

        public Criteria andEffectIsNull() {
            addCriterion("effect is null");
            return (Criteria) this;
        }

        public Criteria andEffectIsNotNull() {
            addCriterion("effect is not null");
            return (Criteria) this;
        }

        public Criteria andEffectEqualTo(String value) {
            addCriterion("effect =", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotEqualTo(String value) {
            addCriterion("effect <>", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectGreaterThan(String value) {
            addCriterion("effect >", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectGreaterThanOrEqualTo(String value) {
            addCriterion("effect >=", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectLessThan(String value) {
            addCriterion("effect <", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectLessThanOrEqualTo(String value) {
            addCriterion("effect <=", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectLike(String value) {
            addCriterion("effect like", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotLike(String value) {
            addCriterion("effect not like", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectIn(List<String> values) {
            addCriterion("effect in", values, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotIn(List<String> values) {
            addCriterion("effect not in", values, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectBetween(String value1, String value2) {
            addCriterion("effect between", value1, value2, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotBetween(String value1, String value2) {
            addCriterion("effect not between", value1, value2, "effect");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdIsNull() {
            addCriterion("accept_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdIsNotNull() {
            addCriterion("accept_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdEqualTo(Integer value) {
            addCriterion("accept_user_id =", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdNotEqualTo(Integer value) {
            addCriterion("accept_user_id <>", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdGreaterThan(Integer value) {
            addCriterion("accept_user_id >", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("accept_user_id >=", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdLessThan(Integer value) {
            addCriterion("accept_user_id <", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("accept_user_id <=", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdIn(List<Integer> values) {
            addCriterion("accept_user_id in", values, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdNotIn(List<Integer> values) {
            addCriterion("accept_user_id not in", values, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdBetween(Integer value1, Integer value2) {
            addCriterion("accept_user_id between", value1, value2, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("accept_user_id not between", value1, value2, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountIsNull() {
            addCriterion("accept_user_account is null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountIsNotNull() {
            addCriterion("accept_user_account is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountEqualTo(String value) {
            addCriterion("accept_user_account =", value, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountNotEqualTo(String value) {
            addCriterion("accept_user_account <>", value, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountGreaterThan(String value) {
            addCriterion("accept_user_account >", value, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("accept_user_account >=", value, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountLessThan(String value) {
            addCriterion("accept_user_account <", value, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountLessThanOrEqualTo(String value) {
            addCriterion("accept_user_account <=", value, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountLike(String value) {
            addCriterion("accept_user_account like", value, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountNotLike(String value) {
            addCriterion("accept_user_account not like", value, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountIn(List<String> values) {
            addCriterion("accept_user_account in", values, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountNotIn(List<String> values) {
            addCriterion("accept_user_account not in", values, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountBetween(String value1, String value2) {
            addCriterion("accept_user_account between", value1, value2, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserAccountNotBetween(String value1, String value2) {
            addCriterion("accept_user_account not between", value1, value2, "acceptUserAccount");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameIsNull() {
            addCriterion("accept_user_name is null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameIsNotNull() {
            addCriterion("accept_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameEqualTo(String value) {
            addCriterion("accept_user_name =", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameNotEqualTo(String value) {
            addCriterion("accept_user_name <>", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameGreaterThan(String value) {
            addCriterion("accept_user_name >", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("accept_user_name >=", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameLessThan(String value) {
            addCriterion("accept_user_name <", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameLessThanOrEqualTo(String value) {
            addCriterion("accept_user_name <=", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameLike(String value) {
            addCriterion("accept_user_name like", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameNotLike(String value) {
            addCriterion("accept_user_name not like", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameIn(List<String> values) {
            addCriterion("accept_user_name in", values, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameNotIn(List<String> values) {
            addCriterion("accept_user_name not in", values, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameBetween(String value1, String value2) {
            addCriterion("accept_user_name between", value1, value2, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameNotBetween(String value1, String value2) {
            addCriterion("accept_user_name not between", value1, value2, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNull() {
            addCriterion("accept_time is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNotNull() {
            addCriterion("accept_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeEqualTo(Date value) {
            addCriterion("accept_time =", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotEqualTo(Date value) {
            addCriterion("accept_time <>", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThan(Date value) {
            addCriterion("accept_time >", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("accept_time >=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThan(Date value) {
            addCriterion("accept_time <", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            addCriterion("accept_time <=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIn(List<Date> values) {
            addCriterion("accept_time in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotIn(List<Date> values) {
            addCriterion("accept_time not in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeBetween(Date value1, Date value2) {
            addCriterion("accept_time between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            addCriterion("accept_time not between", value1, value2, "acceptTime");
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