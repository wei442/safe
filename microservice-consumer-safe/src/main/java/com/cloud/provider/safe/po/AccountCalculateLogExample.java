package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountCalculateLogExample implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountCalculateLogExample() {
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

        public Criteria andAccountCalculateLogIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdEqualTo(Long value) {
            addCriterion("id =", value, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdGreaterThan(Long value) {
            addCriterion("id >", value, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdLessThan(Long value) {
            addCriterion("id <", value, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdIn(List<Long> values) {
            addCriterion("id in", values, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateLogIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "accountCalculateLogId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdIsNull() {
            addCriterion("account_calculate_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdIsNotNull() {
            addCriterion("account_calculate_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdEqualTo(Integer value) {
            addCriterion("account_calculate_id =", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdNotEqualTo(Integer value) {
            addCriterion("account_calculate_id <>", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdGreaterThan(Integer value) {
            addCriterion("account_calculate_id >", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_calculate_id >=", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdLessThan(Integer value) {
            addCriterion("account_calculate_id <", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_calculate_id <=", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdIn(List<Integer> values) {
            addCriterion("account_calculate_id in", values, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdNotIn(List<Integer> values) {
            addCriterion("account_calculate_id not in", values, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdBetween(Integer value1, Integer value2) {
            addCriterion("account_calculate_id between", value1, value2, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_calculate_id not between", value1, value2, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andCalculateIsNull() {
            addCriterion("calculate is null");
            return (Criteria) this;
        }

        public Criteria andCalculateIsNotNull() {
            addCriterion("calculate is not null");
            return (Criteria) this;
        }

        public Criteria andCalculateEqualTo(Integer value) {
            addCriterion("calculate =", value, "calculate");
            return (Criteria) this;
        }

        public Criteria andCalculateNotEqualTo(Integer value) {
            addCriterion("calculate <>", value, "calculate");
            return (Criteria) this;
        }

        public Criteria andCalculateGreaterThan(Integer value) {
            addCriterion("calculate >", value, "calculate");
            return (Criteria) this;
        }

        public Criteria andCalculateGreaterThanOrEqualTo(Integer value) {
            addCriterion("calculate >=", value, "calculate");
            return (Criteria) this;
        }

        public Criteria andCalculateLessThan(Integer value) {
            addCriterion("calculate <", value, "calculate");
            return (Criteria) this;
        }

        public Criteria andCalculateLessThanOrEqualTo(Integer value) {
            addCriterion("calculate <=", value, "calculate");
            return (Criteria) this;
        }

        public Criteria andCalculateIn(List<Integer> values) {
            addCriterion("calculate in", values, "calculate");
            return (Criteria) this;
        }

        public Criteria andCalculateNotIn(List<Integer> values) {
            addCriterion("calculate not in", values, "calculate");
            return (Criteria) this;
        }

        public Criteria andCalculateBetween(Integer value1, Integer value2) {
            addCriterion("calculate between", value1, value2, "calculate");
            return (Criteria) this;
        }

        public Criteria andCalculateNotBetween(Integer value1, Integer value2) {
            addCriterion("calculate not between", value1, value2, "calculate");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andCalculateTypeIsNull() {
            addCriterion("calculate_type is null");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeIsNotNull() {
            addCriterion("calculate_type is not null");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeEqualTo(Integer value) {
            addCriterion("calculate_type =", value, "calculateType");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeNotEqualTo(Integer value) {
            addCriterion("calculate_type <>", value, "calculateType");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeGreaterThan(Integer value) {
            addCriterion("calculate_type >", value, "calculateType");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("calculate_type >=", value, "calculateType");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeLessThan(Integer value) {
            addCriterion("calculate_type <", value, "calculateType");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("calculate_type <=", value, "calculateType");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeIn(List<Integer> values) {
            addCriterion("calculate_type in", values, "calculateType");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeNotIn(List<Integer> values) {
            addCriterion("calculate_type not in", values, "calculateType");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeBetween(Integer value1, Integer value2) {
            addCriterion("calculate_type between", value1, value2, "calculateType");
            return (Criteria) this;
        }

        public Criteria andCalculateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("calculate_type not between", value1, value2, "calculateType");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Integer value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Integer value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Integer value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Integer value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Integer value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Integer> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Integer> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Integer value1, Integer value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Integer value1, Integer value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
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