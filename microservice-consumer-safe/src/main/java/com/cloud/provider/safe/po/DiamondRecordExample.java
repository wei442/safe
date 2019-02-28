package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiamondRecordExample implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiamondRecordExample() {
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

    protected abstract static class GeneratedCriteria implements Serializable {

        /**
		 *
		 */
		private static final long serialVersionUID = 1L;

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

        public Criteria andDiamondRecordIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdEqualTo(Long value) {
            addCriterion("id =", value, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdGreaterThan(Long value) {
            addCriterion("id >", value, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdLessThan(Long value) {
            addCriterion("id <", value, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdIn(List<Long> values) {
            addCriterion("id in", values, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andDiamondRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "diamondRecordId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeIsNull() {
            addCriterion("diamond_code is null");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeIsNotNull() {
            addCriterion("diamond_code is not null");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeEqualTo(String value) {
            addCriterion("diamond_code =", value, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeNotEqualTo(String value) {
            addCriterion("diamond_code <>", value, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeGreaterThan(String value) {
            addCriterion("diamond_code >", value, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeGreaterThanOrEqualTo(String value) {
            addCriterion("diamond_code >=", value, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeLessThan(String value) {
            addCriterion("diamond_code <", value, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeLessThanOrEqualTo(String value) {
            addCriterion("diamond_code <=", value, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeLike(String value) {
            addCriterion("diamond_code like", value, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeNotLike(String value) {
            addCriterion("diamond_code not like", value, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeIn(List<String> values) {
            addCriterion("diamond_code in", values, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeNotIn(List<String> values) {
            addCriterion("diamond_code not in", values, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeBetween(String value1, String value2) {
            addCriterion("diamond_code between", value1, value2, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondCodeNotBetween(String value1, String value2) {
            addCriterion("diamond_code not between", value1, value2, "diamondCode");
            return (Criteria) this;
        }

        public Criteria andDiamondNameIsNull() {
            addCriterion("diamond_name is null");
            return (Criteria) this;
        }

        public Criteria andDiamondNameIsNotNull() {
            addCriterion("diamond_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiamondNameEqualTo(String value) {
            addCriterion("diamond_name =", value, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameNotEqualTo(String value) {
            addCriterion("diamond_name <>", value, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameGreaterThan(String value) {
            addCriterion("diamond_name >", value, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameGreaterThanOrEqualTo(String value) {
            addCriterion("diamond_name >=", value, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameLessThan(String value) {
            addCriterion("diamond_name <", value, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameLessThanOrEqualTo(String value) {
            addCriterion("diamond_name <=", value, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameLike(String value) {
            addCriterion("diamond_name like", value, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameNotLike(String value) {
            addCriterion("diamond_name not like", value, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameIn(List<String> values) {
            addCriterion("diamond_name in", values, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameNotIn(List<String> values) {
            addCriterion("diamond_name not in", values, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameBetween(String value1, String value2) {
            addCriterion("diamond_name between", value1, value2, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondNameNotBetween(String value1, String value2) {
            addCriterion("diamond_name not between", value1, value2, "diamondName");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeIsNull() {
            addCriterion("diamond_type is null");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeIsNotNull() {
            addCriterion("diamond_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeEqualTo(Integer value) {
            addCriterion("diamond_type =", value, "diamondType");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeNotEqualTo(Integer value) {
            addCriterion("diamond_type <>", value, "diamondType");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeGreaterThan(Integer value) {
            addCriterion("diamond_type >", value, "diamondType");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("diamond_type >=", value, "diamondType");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeLessThan(Integer value) {
            addCriterion("diamond_type <", value, "diamondType");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeLessThanOrEqualTo(Integer value) {
            addCriterion("diamond_type <=", value, "diamondType");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeIn(List<Integer> values) {
            addCriterion("diamond_type in", values, "diamondType");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeNotIn(List<Integer> values) {
            addCriterion("diamond_type not in", values, "diamondType");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeBetween(Integer value1, Integer value2) {
            addCriterion("diamond_type between", value1, value2, "diamondType");
            return (Criteria) this;
        }

        public Criteria andDiamondTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("diamond_type not between", value1, value2, "diamondType");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andDiamondIsNull() {
            addCriterion("diamond is null");
            return (Criteria) this;
        }

        public Criteria andDiamondIsNotNull() {
            addCriterion("diamond is not null");
            return (Criteria) this;
        }

        public Criteria andDiamondEqualTo(BigDecimal value) {
            addCriterion("diamond =", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondNotEqualTo(BigDecimal value) {
            addCriterion("diamond <>", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondGreaterThan(BigDecimal value) {
            addCriterion("diamond >", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("diamond >=", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondLessThan(BigDecimal value) {
            addCriterion("diamond <", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondLessThanOrEqualTo(BigDecimal value) {
            addCriterion("diamond <=", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondIn(List<BigDecimal> values) {
            addCriterion("diamond in", values, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondNotIn(List<BigDecimal> values) {
            addCriterion("diamond not in", values, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("diamond between", value1, value2, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("diamond not between", value1, value2, "diamond");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNull() {
            addCriterion("use_time is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("use_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(Date value) {
            addCriterion("use_time =", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(Date value) {
            addCriterion("use_time <>", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(Date value) {
            addCriterion("use_time >", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("use_time >=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(Date value) {
            addCriterion("use_time <", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(Date value) {
            addCriterion("use_time <=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<Date> values) {
            addCriterion("use_time in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<Date> values) {
            addCriterion("use_time not in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(Date value1, Date value2) {
            addCriterion("use_time between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(Date value1, Date value2) {
            addCriterion("use_time not between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(Integer value) {
            addCriterion("is_use =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(Integer value) {
            addCriterion("is_use <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(Integer value) {
            addCriterion("is_use >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_use >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(Integer value) {
            addCriterion("is_use <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(Integer value) {
            addCriterion("is_use <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<Integer> values) {
            addCriterion("is_use in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<Integer> values) {
            addCriterion("is_use not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(Integer value1, Integer value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRegistryNoIsNull() {
            addCriterion("registry_no is null");
            return (Criteria) this;
        }

        public Criteria andRegistryNoIsNotNull() {
            addCriterion("registry_no is not null");
            return (Criteria) this;
        }

        public Criteria andRegistryNoEqualTo(Long value) {
            addCriterion("registry_no =", value, "registryNo");
            return (Criteria) this;
        }

        public Criteria andRegistryNoNotEqualTo(Long value) {
            addCriterion("registry_no <>", value, "registryNo");
            return (Criteria) this;
        }

        public Criteria andRegistryNoGreaterThan(Long value) {
            addCriterion("registry_no >", value, "registryNo");
            return (Criteria) this;
        }

        public Criteria andRegistryNoGreaterThanOrEqualTo(Long value) {
            addCriterion("registry_no >=", value, "registryNo");
            return (Criteria) this;
        }

        public Criteria andRegistryNoLessThan(Long value) {
            addCriterion("registry_no <", value, "registryNo");
            return (Criteria) this;
        }

        public Criteria andRegistryNoLessThanOrEqualTo(Long value) {
            addCriterion("registry_no <=", value, "registryNo");
            return (Criteria) this;
        }

        public Criteria andRegistryNoIn(List<Long> values) {
            addCriterion("registry_no in", values, "registryNo");
            return (Criteria) this;
        }

        public Criteria andRegistryNoNotIn(List<Long> values) {
            addCriterion("registry_no not in", values, "registryNo");
            return (Criteria) this;
        }

        public Criteria andRegistryNoBetween(Long value1, Long value2) {
            addCriterion("registry_no between", value1, value2, "registryNo");
            return (Criteria) this;
        }

        public Criteria andRegistryNoNotBetween(Long value1, Long value2) {
            addCriterion("registry_no not between", value1, value2, "registryNo");
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
    }

    public static class Criteria extends GeneratedCriteria {

        /**
		 *
		 */
		private static final long serialVersionUID = 1L;

		protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        /**
		 *
		 */
		private static final long serialVersionUID = 1L;

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