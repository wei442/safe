package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeeConfigExample implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeeConfigExample() {
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

        public Criteria andFeeConfigIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdEqualTo(Integer value) {
            addCriterion("id =", value, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdGreaterThan(Integer value) {
            addCriterion("id >", value, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdLessThan(Integer value) {
            addCriterion("id <", value, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdIn(List<Integer> values) {
            addCriterion("id in", values, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "feeConfigId");
            return (Criteria) this;
        }

        public Criteria andFeeCodeIsNull() {
            addCriterion("fee_code is null");
            return (Criteria) this;
        }

        public Criteria andFeeCodeIsNotNull() {
            addCriterion("fee_code is not null");
            return (Criteria) this;
        }

        public Criteria andFeeCodeEqualTo(String value) {
            addCriterion("fee_code =", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotEqualTo(String value) {
            addCriterion("fee_code <>", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeGreaterThan(String value) {
            addCriterion("fee_code >", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fee_code >=", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeLessThan(String value) {
            addCriterion("fee_code <", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeLessThanOrEqualTo(String value) {
            addCriterion("fee_code <=", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeLike(String value) {
            addCriterion("fee_code like", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotLike(String value) {
            addCriterion("fee_code not like", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeIn(List<String> values) {
            addCriterion("fee_code in", values, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotIn(List<String> values) {
            addCriterion("fee_code not in", values, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeBetween(String value1, String value2) {
            addCriterion("fee_code between", value1, value2, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotBetween(String value1, String value2) {
            addCriterion("fee_code not between", value1, value2, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeNameIsNull() {
            addCriterion("fee_name is null");
            return (Criteria) this;
        }

        public Criteria andFeeNameIsNotNull() {
            addCriterion("fee_name is not null");
            return (Criteria) this;
        }

        public Criteria andFeeNameEqualTo(String value) {
            addCriterion("fee_name =", value, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameNotEqualTo(String value) {
            addCriterion("fee_name <>", value, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameGreaterThan(String value) {
            addCriterion("fee_name >", value, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("fee_name >=", value, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameLessThan(String value) {
            addCriterion("fee_name <", value, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameLessThanOrEqualTo(String value) {
            addCriterion("fee_name <=", value, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameLike(String value) {
            addCriterion("fee_name like", value, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameNotLike(String value) {
            addCriterion("fee_name not like", value, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameIn(List<String> values) {
            addCriterion("fee_name in", values, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameNotIn(List<String> values) {
            addCriterion("fee_name not in", values, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameBetween(String value1, String value2) {
            addCriterion("fee_name between", value1, value2, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeNameNotBetween(String value1, String value2) {
            addCriterion("fee_name not between", value1, value2, "feeName");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee not between", value1, value2, "fee");
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