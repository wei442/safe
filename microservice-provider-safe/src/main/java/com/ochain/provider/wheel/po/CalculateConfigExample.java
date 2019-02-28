package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalculateConfigExample implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CalculateConfigExample() {
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

        public Criteria andCalculateConfigIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdEqualTo(Integer value) {
            addCriterion("id =", value, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdGreaterThan(Integer value) {
            addCriterion("id >", value, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdLessThan(Integer value) {
            addCriterion("id <", value, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdIn(List<Integer> values) {
            addCriterion("id in", values, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "calculateConfigId");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeIsNull() {
            addCriterion("calculate_code is null");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeIsNotNull() {
            addCriterion("calculate_code is not null");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeEqualTo(String value) {
            addCriterion("calculate_code =", value, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeNotEqualTo(String value) {
            addCriterion("calculate_code <>", value, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeGreaterThan(String value) {
            addCriterion("calculate_code >", value, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("calculate_code >=", value, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeLessThan(String value) {
            addCriterion("calculate_code <", value, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeLessThanOrEqualTo(String value) {
            addCriterion("calculate_code <=", value, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeLike(String value) {
            addCriterion("calculate_code like", value, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeNotLike(String value) {
            addCriterion("calculate_code not like", value, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeIn(List<String> values) {
            addCriterion("calculate_code in", values, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeNotIn(List<String> values) {
            addCriterion("calculate_code not in", values, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeBetween(String value1, String value2) {
            addCriterion("calculate_code between", value1, value2, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateCodeNotBetween(String value1, String value2) {
            addCriterion("calculate_code not between", value1, value2, "calculateCode");
            return (Criteria) this;
        }

        public Criteria andCalculateNameIsNull() {
            addCriterion("calculate_name is null");
            return (Criteria) this;
        }

        public Criteria andCalculateNameIsNotNull() {
            addCriterion("calculate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCalculateNameEqualTo(String value) {
            addCriterion("calculate_name =", value, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameNotEqualTo(String value) {
            addCriterion("calculate_name <>", value, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameGreaterThan(String value) {
            addCriterion("calculate_name >", value, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameGreaterThanOrEqualTo(String value) {
            addCriterion("calculate_name >=", value, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameLessThan(String value) {
            addCriterion("calculate_name <", value, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameLessThanOrEqualTo(String value) {
            addCriterion("calculate_name <=", value, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameLike(String value) {
            addCriterion("calculate_name like", value, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameNotLike(String value) {
            addCriterion("calculate_name not like", value, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameIn(List<String> values) {
            addCriterion("calculate_name in", values, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameNotIn(List<String> values) {
            addCriterion("calculate_name not in", values, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameBetween(String value1, String value2) {
            addCriterion("calculate_name between", value1, value2, "calculateName");
            return (Criteria) this;
        }

        public Criteria andCalculateNameNotBetween(String value1, String value2) {
            addCriterion("calculate_name not between", value1, value2, "calculateName");
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(Object value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(Object value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(Object value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(Object value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(Object value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(Object value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<Object> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<Object> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(Object value1, Object value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(Object value1, Object value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIsSkipIsNull() {
            addCriterion("is_skip is null");
            return (Criteria) this;
        }

        public Criteria andIsSkipIsNotNull() {
            addCriterion("is_skip is not null");
            return (Criteria) this;
        }

        public Criteria andIsSkipEqualTo(Integer value) {
            addCriterion("is_skip =", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipNotEqualTo(Integer value) {
            addCriterion("is_skip <>", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipGreaterThan(Integer value) {
            addCriterion("is_skip >", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_skip >=", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipLessThan(Integer value) {
            addCriterion("is_skip <", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipLessThanOrEqualTo(Integer value) {
            addCriterion("is_skip <=", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipIn(List<Integer> values) {
            addCriterion("is_skip in", values, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipNotIn(List<Integer> values) {
            addCriterion("is_skip not in", values, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipBetween(Integer value1, Integer value2) {
            addCriterion("is_skip between", value1, value2, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipNotBetween(Integer value1, Integer value2) {
            addCriterion("is_skip not between", value1, value2, "isSkip");
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