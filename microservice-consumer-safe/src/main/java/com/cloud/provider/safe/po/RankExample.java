package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RankExample implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RankExample() {
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

        public Criteria andRankIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andRankIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andRankIdEqualTo(Integer value) {
            addCriterion("id =", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdGreaterThan(Integer value) {
            addCriterion("id >", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdLessThan(Integer value) {
            addCriterion("id <", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdIn(List<Integer> values) {
            addCriterion("id in", values, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "rankId");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondIsNull() {
            addCriterion("total_diamond is null");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondIsNotNull() {
            addCriterion("total_diamond is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondEqualTo(BigDecimal value) {
            addCriterion("total_diamond =", value, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondNotEqualTo(BigDecimal value) {
            addCriterion("total_diamond <>", value, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondGreaterThan(BigDecimal value) {
            addCriterion("total_diamond >", value, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_diamond >=", value, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondLessThan(BigDecimal value) {
            addCriterion("total_diamond <", value, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_diamond <=", value, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondIn(List<BigDecimal> values) {
            addCriterion("total_diamond in", values, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondNotIn(List<BigDecimal> values) {
            addCriterion("total_diamond not in", values, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_diamond between", value1, value2, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalDiamondNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_diamond not between", value1, value2, "totalDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondIsNull() {
            addCriterion("plan_diamond is null");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondIsNotNull() {
            addCriterion("plan_diamond is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondEqualTo(BigDecimal value) {
            addCriterion("plan_diamond =", value, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondNotEqualTo(BigDecimal value) {
            addCriterion("plan_diamond <>", value, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondGreaterThan(BigDecimal value) {
            addCriterion("plan_diamond >", value, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_diamond >=", value, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondLessThan(BigDecimal value) {
            addCriterion("plan_diamond <", value, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_diamond <=", value, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondIn(List<BigDecimal> values) {
            addCriterion("plan_diamond in", values, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondNotIn(List<BigDecimal> values) {
            addCriterion("plan_diamond not in", values, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_diamond between", value1, value2, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andPlanDiamondNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_diamond not between", value1, value2, "planDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondIsNull() {
            addCriterion("real_diamond is null");
            return (Criteria) this;
        }

        public Criteria andRealDiamondIsNotNull() {
            addCriterion("real_diamond is not null");
            return (Criteria) this;
        }

        public Criteria andRealDiamondEqualTo(BigDecimal value) {
            addCriterion("real_diamond =", value, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondNotEqualTo(BigDecimal value) {
            addCriterion("real_diamond <>", value, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondGreaterThan(BigDecimal value) {
            addCriterion("real_diamond >", value, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_diamond >=", value, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondLessThan(BigDecimal value) {
            addCriterion("real_diamond <", value, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_diamond <=", value, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondIn(List<BigDecimal> values) {
            addCriterion("real_diamond in", values, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondNotIn(List<BigDecimal> values) {
            addCriterion("real_diamond not in", values, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_diamond between", value1, value2, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andRealDiamondNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_diamond not between", value1, value2, "realDiamond");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateIsNull() {
            addCriterion("total_calculate is null");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateIsNotNull() {
            addCriterion("total_calculate is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateEqualTo(Long value) {
            addCriterion("total_calculate =", value, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateNotEqualTo(Long value) {
            addCriterion("total_calculate <>", value, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateGreaterThan(Long value) {
            addCriterion("total_calculate >", value, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateGreaterThanOrEqualTo(Long value) {
            addCriterion("total_calculate >=", value, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateLessThan(Long value) {
            addCriterion("total_calculate <", value, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateLessThanOrEqualTo(Long value) {
            addCriterion("total_calculate <=", value, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateIn(List<Long> values) {
            addCriterion("total_calculate in", values, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateNotIn(List<Long> values) {
            addCriterion("total_calculate not in", values, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateBetween(Long value1, Long value2) {
            addCriterion("total_calculate between", value1, value2, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCalculateNotBetween(Long value1, Long value2) {
            addCriterion("total_calculate not between", value1, value2, "totalCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateIsNull() {
            addCriterion("total_civilize_calculate is null");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateIsNotNull() {
            addCriterion("total_civilize_calculate is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateEqualTo(Long value) {
            addCriterion("total_civilize_calculate =", value, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateNotEqualTo(Long value) {
            addCriterion("total_civilize_calculate <>", value, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateGreaterThan(Long value) {
            addCriterion("total_civilize_calculate >", value, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateGreaterThanOrEqualTo(Long value) {
            addCriterion("total_civilize_calculate >=", value, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateLessThan(Long value) {
            addCriterion("total_civilize_calculate <", value, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateLessThanOrEqualTo(Long value) {
            addCriterion("total_civilize_calculate <=", value, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateIn(List<Long> values) {
            addCriterion("total_civilize_calculate in", values, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateNotIn(List<Long> values) {
            addCriterion("total_civilize_calculate not in", values, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateBetween(Long value1, Long value2) {
            addCriterion("total_civilize_calculate between", value1, value2, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalCivilizeCalculateNotBetween(Long value1, Long value2) {
            addCriterion("total_civilize_calculate not between", value1, value2, "totalCivilizeCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateIsNull() {
            addCriterion("total_task_calculate is null");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateIsNotNull() {
            addCriterion("total_task_calculate is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateEqualTo(Long value) {
            addCriterion("total_task_calculate =", value, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateNotEqualTo(Long value) {
            addCriterion("total_task_calculate <>", value, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateGreaterThan(Long value) {
            addCriterion("total_task_calculate >", value, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateGreaterThanOrEqualTo(Long value) {
            addCriterion("total_task_calculate >=", value, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateLessThan(Long value) {
            addCriterion("total_task_calculate <", value, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateLessThanOrEqualTo(Long value) {
            addCriterion("total_task_calculate <=", value, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateIn(List<Long> values) {
            addCriterion("total_task_calculate in", values, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateNotIn(List<Long> values) {
            addCriterion("total_task_calculate not in", values, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateBetween(Long value1, Long value2) {
            addCriterion("total_task_calculate between", value1, value2, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andTotalTaskCalculateNotBetween(Long value1, Long value2) {
            addCriterion("total_task_calculate not between", value1, value2, "totalTaskCalculate");
            return (Criteria) this;
        }

        public Criteria andRankTimeIsNull() {
            addCriterion("rank_time is null");
            return (Criteria) this;
        }

        public Criteria andRankTimeIsNotNull() {
            addCriterion("rank_time is not null");
            return (Criteria) this;
        }

        public Criteria andRankTimeEqualTo(Date value) {
            addCriterion("rank_time =", value, "rankTime");
            return (Criteria) this;
        }

        public Criteria andRankTimeNotEqualTo(Date value) {
            addCriterion("rank_time <>", value, "rankTime");
            return (Criteria) this;
        }

        public Criteria andRankTimeGreaterThan(Date value) {
            addCriterion("rank_time >", value, "rankTime");
            return (Criteria) this;
        }

        public Criteria andRankTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rank_time >=", value, "rankTime");
            return (Criteria) this;
        }

        public Criteria andRankTimeLessThan(Date value) {
            addCriterion("rank_time <", value, "rankTime");
            return (Criteria) this;
        }

        public Criteria andRankTimeLessThanOrEqualTo(Date value) {
            addCriterion("rank_time <=", value, "rankTime");
            return (Criteria) this;
        }

        public Criteria andRankTimeIn(List<Date> values) {
            addCriterion("rank_time in", values, "rankTime");
            return (Criteria) this;
        }

        public Criteria andRankTimeNotIn(List<Date> values) {
            addCriterion("rank_time not in", values, "rankTime");
            return (Criteria) this;
        }

        public Criteria andRankTimeBetween(Date value1, Date value2) {
            addCriterion("rank_time between", value1, value2, "rankTime");
            return (Criteria) this;
        }

        public Criteria andRankTimeNotBetween(Date value1, Date value2) {
            addCriterion("rank_time not between", value1, value2, "rankTime");
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