package com.cloud.provider.safe.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseUserLoginLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseUserLoginLogExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdIsNull() {
            addCriterion("base_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdIsNotNull() {
            addCriterion("base_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdEqualTo(Integer value) {
            addCriterion("base_user_id =", value, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdNotEqualTo(Integer value) {
            addCriterion("base_user_id <>", value, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdGreaterThan(Integer value) {
            addCriterion("base_user_id >", value, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("base_user_id >=", value, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdLessThan(Integer value) {
            addCriterion("base_user_id <", value, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("base_user_id <=", value, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdIn(List<Integer> values) {
            addCriterion("base_user_id in", values, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdNotIn(List<Integer> values) {
            addCriterion("base_user_id not in", values, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdBetween(Integer value1, Integer value2) {
            addCriterion("base_user_id between", value1, value2, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("base_user_id not between", value1, value2, "baseUserId");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountIsNull() {
            addCriterion("base_user_account is null");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountIsNotNull() {
            addCriterion("base_user_account is not null");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountEqualTo(String value) {
            addCriterion("base_user_account =", value, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountNotEqualTo(String value) {
            addCriterion("base_user_account <>", value, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountGreaterThan(String value) {
            addCriterion("base_user_account >", value, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("base_user_account >=", value, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountLessThan(String value) {
            addCriterion("base_user_account <", value, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountLessThanOrEqualTo(String value) {
            addCriterion("base_user_account <=", value, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountLike(String value) {
            addCriterion("base_user_account like", value, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountNotLike(String value) {
            addCriterion("base_user_account not like", value, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountIn(List<String> values) {
            addCriterion("base_user_account in", values, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountNotIn(List<String> values) {
            addCriterion("base_user_account not in", values, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountBetween(String value1, String value2) {
            addCriterion("base_user_account between", value1, value2, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserAccountNotBetween(String value1, String value2) {
            addCriterion("base_user_account not between", value1, value2, "baseUserAccount");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameIsNull() {
            addCriterion("base_user_name is null");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameIsNotNull() {
            addCriterion("base_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEqualTo(String value) {
            addCriterion("base_user_name =", value, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameNotEqualTo(String value) {
            addCriterion("base_user_name <>", value, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameGreaterThan(String value) {
            addCriterion("base_user_name >", value, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("base_user_name >=", value, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameLessThan(String value) {
            addCriterion("base_user_name <", value, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameLessThanOrEqualTo(String value) {
            addCriterion("base_user_name <=", value, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameLike(String value) {
            addCriterion("base_user_name like", value, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameNotLike(String value) {
            addCriterion("base_user_name not like", value, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameIn(List<String> values) {
            addCriterion("base_user_name in", values, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameNotIn(List<String> values) {
            addCriterion("base_user_name not in", values, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameBetween(String value1, String value2) {
            addCriterion("base_user_name between", value1, value2, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameNotBetween(String value1, String value2) {
            addCriterion("base_user_name not between", value1, value2, "baseUserName");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnIsNull() {
            addCriterion("base_user_name_en is null");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnIsNotNull() {
            addCriterion("base_user_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnEqualTo(String value) {
            addCriterion("base_user_name_en =", value, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnNotEqualTo(String value) {
            addCriterion("base_user_name_en <>", value, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnGreaterThan(String value) {
            addCriterion("base_user_name_en >", value, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("base_user_name_en >=", value, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnLessThan(String value) {
            addCriterion("base_user_name_en <", value, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnLessThanOrEqualTo(String value) {
            addCriterion("base_user_name_en <=", value, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnLike(String value) {
            addCriterion("base_user_name_en like", value, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnNotLike(String value) {
            addCriterion("base_user_name_en not like", value, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnIn(List<String> values) {
            addCriterion("base_user_name_en in", values, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnNotIn(List<String> values) {
            addCriterion("base_user_name_en not in", values, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnBetween(String value1, String value2) {
            addCriterion("base_user_name_en between", value1, value2, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andBaseUserNameEnNotBetween(String value1, String value2) {
            addCriterion("base_user_name_en not between", value1, value2, "baseUserNameEn");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNull() {
            addCriterion("login_type is null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNotNull() {
            addCriterion("login_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeEqualTo(Integer value) {
            addCriterion("login_type =", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotEqualTo(Integer value) {
            addCriterion("login_type <>", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThan(Integer value) {
            addCriterion("login_type >", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_type >=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThan(Integer value) {
            addCriterion("login_type <", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThanOrEqualTo(Integer value) {
            addCriterion("login_type <=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIn(List<Integer> values) {
            addCriterion("login_type in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotIn(List<Integer> values) {
            addCriterion("login_type not in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeBetween(Integer value1, Integer value2) {
            addCriterion("login_type between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("login_type not between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginModeIsNull() {
            addCriterion("login_mode is null");
            return (Criteria) this;
        }

        public Criteria andLoginModeIsNotNull() {
            addCriterion("login_mode is not null");
            return (Criteria) this;
        }

        public Criteria andLoginModeEqualTo(String value) {
            addCriterion("login_mode =", value, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeNotEqualTo(String value) {
            addCriterion("login_mode <>", value, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeGreaterThan(String value) {
            addCriterion("login_mode >", value, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeGreaterThanOrEqualTo(String value) {
            addCriterion("login_mode >=", value, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeLessThan(String value) {
            addCriterion("login_mode <", value, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeLessThanOrEqualTo(String value) {
            addCriterion("login_mode <=", value, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeLike(String value) {
            addCriterion("login_mode like", value, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeNotLike(String value) {
            addCriterion("login_mode not like", value, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeIn(List<String> values) {
            addCriterion("login_mode in", values, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeNotIn(List<String> values) {
            addCriterion("login_mode not in", values, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeBetween(String value1, String value2) {
            addCriterion("login_mode between", value1, value2, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginModeNotBetween(String value1, String value2) {
            addCriterion("login_mode not between", value1, value2, "loginMode");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("login_ip =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("login_ip <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("login_ip >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("login_ip >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("login_ip <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("login_ip <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("login_ip like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("login_ip not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("login_ip in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("login_ip not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("login_ip between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("login_ip not between", value1, value2, "loginIp");
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