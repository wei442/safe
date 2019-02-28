package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountCalculateExample implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountCalculateExample() {
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

        public Criteria andAccountCalculateIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdEqualTo(Integer value) {
            addCriterion("id =", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdGreaterThan(Integer value) {
            addCriterion("id >", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdLessThan(Integer value) {
            addCriterion("id <", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdIn(List<Integer> values) {
            addCriterion("id in", values, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "accountCalculateId");
            return (Criteria) this;
        }

        public Criteria andAccountCalculateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "accountCalculateId");
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

        public Criteria andCivilizeCalculateIsNull() {
            addCriterion("civilize_calculate is null");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateIsNotNull() {
            addCriterion("civilize_calculate is not null");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateEqualTo(Integer value) {
            addCriterion("civilize_calculate =", value, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateNotEqualTo(Integer value) {
            addCriterion("civilize_calculate <>", value, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateGreaterThan(Integer value) {
            addCriterion("civilize_calculate >", value, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateGreaterThanOrEqualTo(Integer value) {
            addCriterion("civilize_calculate >=", value, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateLessThan(Integer value) {
            addCriterion("civilize_calculate <", value, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateLessThanOrEqualTo(Integer value) {
            addCriterion("civilize_calculate <=", value, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateIn(List<Integer> values) {
            addCriterion("civilize_calculate in", values, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateNotIn(List<Integer> values) {
            addCriterion("civilize_calculate not in", values, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateBetween(Integer value1, Integer value2) {
            addCriterion("civilize_calculate between", value1, value2, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andCivilizeCalculateNotBetween(Integer value1, Integer value2) {
            addCriterion("civilize_calculate not between", value1, value2, "civilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateIsNull() {
            addCriterion("task_calculate is null");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateIsNotNull() {
            addCriterion("task_calculate is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateEqualTo(Integer value) {
            addCriterion("task_calculate =", value, "taskCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateNotEqualTo(Integer value) {
            addCriterion("task_calculate <>", value, "taskCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateGreaterThan(Integer value) {
            addCriterion("task_calculate >", value, "taskCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_calculate >=", value, "taskCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateLessThan(Integer value) {
            addCriterion("task_calculate <", value, "taskCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateLessThanOrEqualTo(Integer value) {
            addCriterion("task_calculate <=", value, "taskCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateIn(List<Integer> values) {
            addCriterion("task_calculate in", values, "taskCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateNotIn(List<Integer> values) {
            addCriterion("task_calculate not in", values, "taskCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateBetween(Integer value1, Integer value2) {
            addCriterion("task_calculate between", value1, value2, "taskCalculate");
            return (Criteria) this;
        }

        public Criteria andTaskCalculateNotBetween(Integer value1, Integer value2) {
            addCriterion("task_calculate not between", value1, value2, "taskCalculate");
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