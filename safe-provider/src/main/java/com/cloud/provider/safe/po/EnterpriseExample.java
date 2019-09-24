package com.cloud.provider.safe.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseExample() {
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

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("enterprise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("enterprise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("enterprise_name =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("enterprise_name <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("enterprise_name >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_name >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("enterprise_name <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_name <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("enterprise_name like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("enterprise_name not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("enterprise_name in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("enterprise_name not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("enterprise_name between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_name not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNull() {
            addCriterion("enterprise_type is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNotNull() {
            addCriterion("enterprise_type is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeEqualTo(Integer value) {
            addCriterion("enterprise_type =", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotEqualTo(Integer value) {
            addCriterion("enterprise_type <>", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThan(Integer value) {
            addCriterion("enterprise_type >", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_type >=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThan(Integer value) {
            addCriterion("enterprise_type <", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_type <=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIn(List<Integer> values) {
            addCriterion("enterprise_type in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotIn(List<Integer> values) {
            addCriterion("enterprise_type not in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_type between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_type not between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIsNull() {
            addCriterion("enterprise_nature is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIsNotNull() {
            addCriterion("enterprise_nature is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureEqualTo(Integer value) {
            addCriterion("enterprise_nature =", value, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNotEqualTo(Integer value) {
            addCriterion("enterprise_nature <>", value, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureGreaterThan(Integer value) {
            addCriterion("enterprise_nature >", value, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_nature >=", value, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureLessThan(Integer value) {
            addCriterion("enterprise_nature <", value, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_nature <=", value, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIn(List<Integer> values) {
            addCriterion("enterprise_nature in", values, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNotIn(List<Integer> values) {
            addCriterion("enterprise_nature not in", values, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_nature between", value1, value2, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_nature not between", value1, value2, "enterpriseNature");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusIsNull() {
            addCriterion("enterprise_status is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusIsNotNull() {
            addCriterion("enterprise_status is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusEqualTo(Integer value) {
            addCriterion("enterprise_status =", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusNotEqualTo(Integer value) {
            addCriterion("enterprise_status <>", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusGreaterThan(Integer value) {
            addCriterion("enterprise_status >", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_status >=", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusLessThan(Integer value) {
            addCriterion("enterprise_status <", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_status <=", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusIn(List<Integer> values) {
            addCriterion("enterprise_status in", values, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusNotIn(List<Integer> values) {
            addCriterion("enterprise_status not in", values, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_status between", value1, value2, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_status not between", value1, value2, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasIsNull() {
            addCriterion("enterprise_alias is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasIsNotNull() {
            addCriterion("enterprise_alias is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasEqualTo(String value) {
            addCriterion("enterprise_alias =", value, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasNotEqualTo(String value) {
            addCriterion("enterprise_alias <>", value, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasGreaterThan(String value) {
            addCriterion("enterprise_alias >", value, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_alias >=", value, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasLessThan(String value) {
            addCriterion("enterprise_alias <", value, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasLessThanOrEqualTo(String value) {
            addCriterion("enterprise_alias <=", value, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasLike(String value) {
            addCriterion("enterprise_alias like", value, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasNotLike(String value) {
            addCriterion("enterprise_alias not like", value, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasIn(List<String> values) {
            addCriterion("enterprise_alias in", values, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasNotIn(List<String> values) {
            addCriterion("enterprise_alias not in", values, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasBetween(String value1, String value2) {
            addCriterion("enterprise_alias between", value1, value2, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAliasNotBetween(String value1, String value2) {
            addCriterion("enterprise_alias not between", value1, value2, "enterpriseAlias");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneIsNull() {
            addCriterion("enterprise_telphone is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneIsNotNull() {
            addCriterion("enterprise_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneEqualTo(String value) {
            addCriterion("enterprise_telphone =", value, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneNotEqualTo(String value) {
            addCriterion("enterprise_telphone <>", value, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneGreaterThan(String value) {
            addCriterion("enterprise_telphone >", value, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_telphone >=", value, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneLessThan(String value) {
            addCriterion("enterprise_telphone <", value, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneLessThanOrEqualTo(String value) {
            addCriterion("enterprise_telphone <=", value, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneLike(String value) {
            addCriterion("enterprise_telphone like", value, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneNotLike(String value) {
            addCriterion("enterprise_telphone not like", value, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneIn(List<String> values) {
            addCriterion("enterprise_telphone in", values, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneNotIn(List<String> values) {
            addCriterion("enterprise_telphone not in", values, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneBetween(String value1, String value2) {
            addCriterion("enterprise_telphone between", value1, value2, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTelphoneNotBetween(String value1, String value2) {
            addCriterion("enterprise_telphone not between", value1, value2, "enterpriseTelphone");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelIsNull() {
            addCriterion("enterprise_level is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelIsNotNull() {
            addCriterion("enterprise_level is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelEqualTo(Integer value) {
            addCriterion("enterprise_level =", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelNotEqualTo(Integer value) {
            addCriterion("enterprise_level <>", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelGreaterThan(Integer value) {
            addCriterion("enterprise_level >", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_level >=", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelLessThan(Integer value) {
            addCriterion("enterprise_level <", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_level <=", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelIn(List<Integer> values) {
            addCriterion("enterprise_level in", values, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelNotIn(List<Integer> values) {
            addCriterion("enterprise_level not in", values, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_level between", value1, value2, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_level not between", value1, value2, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxIsNull() {
            addCriterion("enterprise_fax is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxIsNotNull() {
            addCriterion("enterprise_fax is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxEqualTo(String value) {
            addCriterion("enterprise_fax =", value, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxNotEqualTo(String value) {
            addCriterion("enterprise_fax <>", value, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxGreaterThan(String value) {
            addCriterion("enterprise_fax >", value, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_fax >=", value, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxLessThan(String value) {
            addCriterion("enterprise_fax <", value, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxLessThanOrEqualTo(String value) {
            addCriterion("enterprise_fax <=", value, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxLike(String value) {
            addCriterion("enterprise_fax like", value, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxNotLike(String value) {
            addCriterion("enterprise_fax not like", value, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxIn(List<String> values) {
            addCriterion("enterprise_fax in", values, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxNotIn(List<String> values) {
            addCriterion("enterprise_fax not in", values, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxBetween(String value1, String value2) {
            addCriterion("enterprise_fax between", value1, value2, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFaxNotBetween(String value1, String value2) {
            addCriterion("enterprise_fax not between", value1, value2, "enterpriseFax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailIsNull() {
            addCriterion("enterprise_email is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailIsNotNull() {
            addCriterion("enterprise_email is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailEqualTo(String value) {
            addCriterion("enterprise_email =", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotEqualTo(String value) {
            addCriterion("enterprise_email <>", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailGreaterThan(String value) {
            addCriterion("enterprise_email >", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_email >=", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailLessThan(String value) {
            addCriterion("enterprise_email <", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailLessThanOrEqualTo(String value) {
            addCriterion("enterprise_email <=", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailLike(String value) {
            addCriterion("enterprise_email like", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotLike(String value) {
            addCriterion("enterprise_email not like", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailIn(List<String> values) {
            addCriterion("enterprise_email in", values, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotIn(List<String> values) {
            addCriterion("enterprise_email not in", values, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailBetween(String value1, String value2) {
            addCriterion("enterprise_email between", value1, value2, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotBetween(String value1, String value2) {
            addCriterion("enterprise_email not between", value1, value2, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeIsNull() {
            addCriterion("enterprise_post_code is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeIsNotNull() {
            addCriterion("enterprise_post_code is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeEqualTo(String value) {
            addCriterion("enterprise_post_code =", value, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeNotEqualTo(String value) {
            addCriterion("enterprise_post_code <>", value, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeGreaterThan(String value) {
            addCriterion("enterprise_post_code >", value, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_post_code >=", value, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeLessThan(String value) {
            addCriterion("enterprise_post_code <", value, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeLessThanOrEqualTo(String value) {
            addCriterion("enterprise_post_code <=", value, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeLike(String value) {
            addCriterion("enterprise_post_code like", value, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeNotLike(String value) {
            addCriterion("enterprise_post_code not like", value, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeIn(List<String> values) {
            addCriterion("enterprise_post_code in", values, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeNotIn(List<String> values) {
            addCriterion("enterprise_post_code not in", values, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeBetween(String value1, String value2) {
            addCriterion("enterprise_post_code between", value1, value2, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterprisePostCodeNotBetween(String value1, String value2) {
            addCriterion("enterprise_post_code not between", value1, value2, "enterprisePostCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrIsNull() {
            addCriterion("enterprise_addr is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrIsNotNull() {
            addCriterion("enterprise_addr is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrEqualTo(String value) {
            addCriterion("enterprise_addr =", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrNotEqualTo(String value) {
            addCriterion("enterprise_addr <>", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrGreaterThan(String value) {
            addCriterion("enterprise_addr >", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_addr >=", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrLessThan(String value) {
            addCriterion("enterprise_addr <", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrLessThanOrEqualTo(String value) {
            addCriterion("enterprise_addr <=", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrLike(String value) {
            addCriterion("enterprise_addr like", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrNotLike(String value) {
            addCriterion("enterprise_addr not like", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrIn(List<String> values) {
            addCriterion("enterprise_addr in", values, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrNotIn(List<String> values) {
            addCriterion("enterprise_addr not in", values, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrBetween(String value1, String value2) {
            addCriterion("enterprise_addr between", value1, value2, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrNotBetween(String value1, String value2) {
            addCriterion("enterprise_addr not between", value1, value2, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteIsNull() {
            addCriterion("enterprise_website is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteIsNotNull() {
            addCriterion("enterprise_website is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteEqualTo(String value) {
            addCriterion("enterprise_website =", value, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteNotEqualTo(String value) {
            addCriterion("enterprise_website <>", value, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteGreaterThan(String value) {
            addCriterion("enterprise_website >", value, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_website >=", value, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteLessThan(String value) {
            addCriterion("enterprise_website <", value, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteLessThanOrEqualTo(String value) {
            addCriterion("enterprise_website <=", value, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteLike(String value) {
            addCriterion("enterprise_website like", value, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteNotLike(String value) {
            addCriterion("enterprise_website not like", value, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteIn(List<String> values) {
            addCriterion("enterprise_website in", values, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteNotIn(List<String> values) {
            addCriterion("enterprise_website not in", values, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteBetween(String value1, String value2) {
            addCriterion("enterprise_website between", value1, value2, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andEnterpriseWebsiteNotBetween(String value1, String value2) {
            addCriterion("enterprise_website not between", value1, value2, "enterpriseWebsite");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryIsNull() {
            addCriterion("enterprise_main_category is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryIsNotNull() {
            addCriterion("enterprise_main_category is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryEqualTo(String value) {
            addCriterion("enterprise_main_category =", value, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryNotEqualTo(String value) {
            addCriterion("enterprise_main_category <>", value, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryGreaterThan(String value) {
            addCriterion("enterprise_main_category >", value, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_main_category >=", value, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryLessThan(String value) {
            addCriterion("enterprise_main_category <", value, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryLessThanOrEqualTo(String value) {
            addCriterion("enterprise_main_category <=", value, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryLike(String value) {
            addCriterion("enterprise_main_category like", value, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryNotLike(String value) {
            addCriterion("enterprise_main_category not like", value, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryIn(List<String> values) {
            addCriterion("enterprise_main_category in", values, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryNotIn(List<String> values) {
            addCriterion("enterprise_main_category not in", values, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryBetween(String value1, String value2) {
            addCriterion("enterprise_main_category between", value1, value2, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseMainCategoryNotBetween(String value1, String value2) {
            addCriterion("enterprise_main_category not between", value1, value2, "enterpriseMainCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryIsNull() {
            addCriterion("enterprise_sub_category is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryIsNotNull() {
            addCriterion("enterprise_sub_category is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryEqualTo(String value) {
            addCriterion("enterprise_sub_category =", value, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryNotEqualTo(String value) {
            addCriterion("enterprise_sub_category <>", value, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryGreaterThan(String value) {
            addCriterion("enterprise_sub_category >", value, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_sub_category >=", value, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryLessThan(String value) {
            addCriterion("enterprise_sub_category <", value, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryLessThanOrEqualTo(String value) {
            addCriterion("enterprise_sub_category <=", value, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryLike(String value) {
            addCriterion("enterprise_sub_category like", value, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryNotLike(String value) {
            addCriterion("enterprise_sub_category not like", value, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryIn(List<String> values) {
            addCriterion("enterprise_sub_category in", values, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryNotIn(List<String> values) {
            addCriterion("enterprise_sub_category not in", values, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryBetween(String value1, String value2) {
            addCriterion("enterprise_sub_category between", value1, value2, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSubCategoryNotBetween(String value1, String value2) {
            addCriterion("enterprise_sub_category not between", value1, value2, "enterpriseSubCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleIsNull() {
            addCriterion("enterprise_scale is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleIsNotNull() {
            addCriterion("enterprise_scale is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleEqualTo(Integer value) {
            addCriterion("enterprise_scale =", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleNotEqualTo(Integer value) {
            addCriterion("enterprise_scale <>", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGreaterThan(Integer value) {
            addCriterion("enterprise_scale >", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_scale >=", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleLessThan(Integer value) {
            addCriterion("enterprise_scale <", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_scale <=", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleIn(List<Integer> values) {
            addCriterion("enterprise_scale in", values, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleNotIn(List<Integer> values) {
            addCriterion("enterprise_scale not in", values, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_scale between", value1, value2, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_scale not between", value1, value2, "enterpriseScale");
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