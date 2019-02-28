package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GCouponExample implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GCouponExample() {
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

        public Criteria andGCouponIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andGCouponIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andGCouponIdEqualTo(String value) {
            addCriterion("id =", value, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdNotEqualTo(String value) {
            addCriterion("id <>", value, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdGreaterThan(String value) {
            addCriterion("id >", value, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdLessThan(String value) {
            addCriterion("id <", value, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdLike(String value) {
            addCriterion("id like", value, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdNotLike(String value) {
            addCriterion("id not like", value, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdIn(List<String> values) {
            addCriterion("id in", values, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdNotIn(List<String> values) {
            addCriterion("id not in", values, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGCouponIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "gCouponId");
            return (Criteria) this;
        }

        public Criteria andGNameIsNull() {
            addCriterion("g_name is null");
            return (Criteria) this;
        }

        public Criteria andGNameIsNotNull() {
            addCriterion("g_name is not null");
            return (Criteria) this;
        }

        public Criteria andGNameEqualTo(String value) {
            addCriterion("g_name =", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotEqualTo(String value) {
            addCriterion("g_name <>", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThan(String value) {
            addCriterion("g_name >", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThanOrEqualTo(String value) {
            addCriterion("g_name >=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThan(String value) {
            addCriterion("g_name <", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThanOrEqualTo(String value) {
            addCriterion("g_name <=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLike(String value) {
            addCriterion("g_name like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotLike(String value) {
            addCriterion("g_name not like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameIn(List<String> values) {
            addCriterion("g_name in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotIn(List<String> values) {
            addCriterion("g_name not in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameBetween(String value1, String value2) {
            addCriterion("g_name between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotBetween(String value1, String value2) {
            addCriterion("g_name not between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGMoneyIsNull() {
            addCriterion("g_money is null");
            return (Criteria) this;
        }

        public Criteria andGMoneyIsNotNull() {
            addCriterion("g_money is not null");
            return (Criteria) this;
        }

        public Criteria andGMoneyEqualTo(Integer value) {
            addCriterion("g_money =", value, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGMoneyNotEqualTo(Integer value) {
            addCriterion("g_money <>", value, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGMoneyGreaterThan(Integer value) {
            addCriterion("g_money >", value, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_money >=", value, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGMoneyLessThan(Integer value) {
            addCriterion("g_money <", value, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("g_money <=", value, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGMoneyIn(List<Integer> values) {
            addCriterion("g_money in", values, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGMoneyNotIn(List<Integer> values) {
            addCriterion("g_money not in", values, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGMoneyBetween(Integer value1, Integer value2) {
            addCriterion("g_money between", value1, value2, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("g_money not between", value1, value2, "gMoney");
            return (Criteria) this;
        }

        public Criteria andGCityNameIsNull() {
            addCriterion("g_city_name is null");
            return (Criteria) this;
        }

        public Criteria andGCityNameIsNotNull() {
            addCriterion("g_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andGCityNameEqualTo(String value) {
            addCriterion("g_city_name =", value, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameNotEqualTo(String value) {
            addCriterion("g_city_name <>", value, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameGreaterThan(String value) {
            addCriterion("g_city_name >", value, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("g_city_name >=", value, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameLessThan(String value) {
            addCriterion("g_city_name <", value, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameLessThanOrEqualTo(String value) {
            addCriterion("g_city_name <=", value, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameLike(String value) {
            addCriterion("g_city_name like", value, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameNotLike(String value) {
            addCriterion("g_city_name not like", value, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameIn(List<String> values) {
            addCriterion("g_city_name in", values, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameNotIn(List<String> values) {
            addCriterion("g_city_name not in", values, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameBetween(String value1, String value2) {
            addCriterion("g_city_name between", value1, value2, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGCityNameNotBetween(String value1, String value2) {
            addCriterion("g_city_name not between", value1, value2, "gCityName");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeIsNull() {
            addCriterion("g_price_type is null");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeIsNotNull() {
            addCriterion("g_price_type is not null");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeEqualTo(Integer value) {
            addCriterion("g_price_type =", value, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeNotEqualTo(Integer value) {
            addCriterion("g_price_type <>", value, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeGreaterThan(Integer value) {
            addCriterion("g_price_type >", value, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_price_type >=", value, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeLessThan(Integer value) {
            addCriterion("g_price_type <", value, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("g_price_type <=", value, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeIn(List<Integer> values) {
            addCriterion("g_price_type in", values, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeNotIn(List<Integer> values) {
            addCriterion("g_price_type not in", values, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeBetween(Integer value1, Integer value2) {
            addCriterion("g_price_type between", value1, value2, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGPriceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("g_price_type not between", value1, value2, "gPriceType");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoIsNull() {
            addCriterion("g_area_info is null");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoIsNotNull() {
            addCriterion("g_area_info is not null");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoEqualTo(String value) {
            addCriterion("g_area_info =", value, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoNotEqualTo(String value) {
            addCriterion("g_area_info <>", value, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoGreaterThan(String value) {
            addCriterion("g_area_info >", value, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoGreaterThanOrEqualTo(String value) {
            addCriterion("g_area_info >=", value, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoLessThan(String value) {
            addCriterion("g_area_info <", value, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoLessThanOrEqualTo(String value) {
            addCriterion("g_area_info <=", value, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoLike(String value) {
            addCriterion("g_area_info like", value, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoNotLike(String value) {
            addCriterion("g_area_info not like", value, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoIn(List<String> values) {
            addCriterion("g_area_info in", values, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoNotIn(List<String> values) {
            addCriterion("g_area_info not in", values, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoBetween(String value1, String value2) {
            addCriterion("g_area_info between", value1, value2, "gAreaInfo");
            return (Criteria) this;
        }

        public Criteria andGAreaInfoNotBetween(String value1, String value2) {
            addCriterion("g_area_info not between", value1, value2, "gAreaInfo");
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