package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiamondConfigExample implements Serializable{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiamondConfigExample() {
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

        public Criteria andDiamondConfigIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdEqualTo(Integer value) {
            addCriterion("id =", value, "diamondConfigId");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "diamondConfigId");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdGreaterThan(Integer value) {
            addCriterion("id >", value, "diamondConfigId");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "diamondConfigId");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdLessThan(Integer value) {
            addCriterion("id <", value, "diamondConfigId");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "diamondConfigId");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdIn(List<Integer> values) {
            addCriterion("id in", values, "diamondConfigId");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "diamondConfigId");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "diamondConfigId");
            return (Criteria) this;
        }

        public Criteria andDiamondConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "diamondConfigId");
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

        public Criteria andSendAmountIsNull() {
            addCriterion("send_amount is null");
            return (Criteria) this;
        }

        public Criteria andSendAmountIsNotNull() {
            addCriterion("send_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSendAmountEqualTo(Integer value) {
            addCriterion("send_amount =", value, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andSendAmountNotEqualTo(Integer value) {
            addCriterion("send_amount <>", value, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andSendAmountGreaterThan(Integer value) {
            addCriterion("send_amount >", value, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andSendAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_amount >=", value, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andSendAmountLessThan(Integer value) {
            addCriterion("send_amount <", value, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andSendAmountLessThanOrEqualTo(Integer value) {
            addCriterion("send_amount <=", value, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andSendAmountIn(List<Integer> values) {
            addCriterion("send_amount in", values, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andSendAmountNotIn(List<Integer> values) {
            addCriterion("send_amount not in", values, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andSendAmountBetween(Integer value1, Integer value2) {
            addCriterion("send_amount between", value1, value2, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andSendAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("send_amount not between", value1, value2, "sendAmount");
            return (Criteria) this;
        }

        public Criteria andIsFixIsNull() {
            addCriterion("is_fix is null");
            return (Criteria) this;
        }

        public Criteria andIsFixIsNotNull() {
            addCriterion("is_fix is not null");
            return (Criteria) this;
        }

        public Criteria andIsFixEqualTo(Integer value) {
            addCriterion("is_fix =", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixNotEqualTo(Integer value) {
            addCriterion("is_fix <>", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixGreaterThan(Integer value) {
            addCriterion("is_fix >", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_fix >=", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixLessThan(Integer value) {
            addCriterion("is_fix <", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixLessThanOrEqualTo(Integer value) {
            addCriterion("is_fix <=", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixIn(List<Integer> values) {
            addCriterion("is_fix in", values, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixNotIn(List<Integer> values) {
            addCriterion("is_fix not in", values, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixBetween(Integer value1, Integer value2) {
            addCriterion("is_fix between", value1, value2, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixNotBetween(Integer value1, Integer value2) {
            addCriterion("is_fix not between", value1, value2, "isFix");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountIsNull() {
            addCriterion("fix_send_amount is null");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountIsNotNull() {
            addCriterion("fix_send_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountEqualTo(BigDecimal value) {
            addCriterion("fix_send_amount =", value, "fixSendAmount");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountNotEqualTo(BigDecimal value) {
            addCriterion("fix_send_amount <>", value, "fixSendAmount");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountGreaterThan(BigDecimal value) {
            addCriterion("fix_send_amount >", value, "fixSendAmount");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fix_send_amount >=", value, "fixSendAmount");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountLessThan(BigDecimal value) {
            addCriterion("fix_send_amount <", value, "fixSendAmount");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fix_send_amount <=", value, "fixSendAmount");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountIn(List<BigDecimal> values) {
            addCriterion("fix_send_amount in", values, "fixSendAmount");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountNotIn(List<BigDecimal> values) {
            addCriterion("fix_send_amount not in", values, "fixSendAmount");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fix_send_amount between", value1, value2, "fixSendAmount");
            return (Criteria) this;
        }

        public Criteria andFixSendAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fix_send_amount not between", value1, value2, "fixSendAmount");
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