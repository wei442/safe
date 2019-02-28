package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponLogExample implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponLogExample() {
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

        public Criteria andCouponLogIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdEqualTo(Long value) {
            addCriterion("id =", value, "couponLogId");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "couponLogId");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdGreaterThan(Long value) {
            addCriterion("id >", value, "couponLogId");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "couponLogId");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdLessThan(Long value) {
            addCriterion("id <", value, "couponLogId");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "couponLogId");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdIn(List<Long> values) {
            addCriterion("id in", values, "couponLogId");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "couponLogId");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "couponLogId");
            return (Criteria) this;
        }

        public Criteria andCouponLogIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "couponLogId");
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

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Integer value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Integer value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Integer value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Integer value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Integer> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Integer> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "userAccount");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeEqualTo(Integer value) {
            addCriterion("coupon_type =", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotEqualTo(Integer value) {
            addCriterion("coupon_type <>", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThan(Integer value) {
            addCriterion("coupon_type >", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_type >=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThan(Integer value) {
            addCriterion("coupon_type <", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_type <=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIn(List<Integer> values) {
            addCriterion("coupon_type in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotIn(List<Integer> values) {
            addCriterion("coupon_type not in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type not between", value1, value2, "couponType");
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

        public Criteria andDiamondEqualTo(Integer value) {
            addCriterion("diamond =", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondNotEqualTo(Integer value) {
            addCriterion("diamond <>", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondGreaterThan(Integer value) {
            addCriterion("diamond >", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondGreaterThanOrEqualTo(Integer value) {
            addCriterion("diamond >=", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondLessThan(Integer value) {
            addCriterion("diamond <", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondLessThanOrEqualTo(Integer value) {
            addCriterion("diamond <=", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondIn(List<Integer> values) {
            addCriterion("diamond in", values, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondNotIn(List<Integer> values) {
            addCriterion("diamond not in", values, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondBetween(Integer value1, Integer value2) {
            addCriterion("diamond between", value1, value2, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondNotBetween(Integer value1, Integer value2) {
            addCriterion("diamond not between", value1, value2, "diamond");
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andCouponTimeIsNull() {
            addCriterion("coupon_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponTimeIsNotNull() {
            addCriterion("coupon_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTimeEqualTo(Date value) {
            addCriterion("coupon_time =", value, "couponTime");
            return (Criteria) this;
        }

        public Criteria andCouponTimeNotEqualTo(Date value) {
            addCriterion("coupon_time <>", value, "couponTime");
            return (Criteria) this;
        }

        public Criteria andCouponTimeGreaterThan(Date value) {
            addCriterion("coupon_time >", value, "couponTime");
            return (Criteria) this;
        }

        public Criteria andCouponTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("coupon_time >=", value, "couponTime");
            return (Criteria) this;
        }

        public Criteria andCouponTimeLessThan(Date value) {
            addCriterion("coupon_time <", value, "couponTime");
            return (Criteria) this;
        }

        public Criteria andCouponTimeLessThanOrEqualTo(Date value) {
            addCriterion("coupon_time <=", value, "couponTime");
            return (Criteria) this;
        }

        public Criteria andCouponTimeIn(List<Date> values) {
            addCriterion("coupon_time in", values, "couponTime");
            return (Criteria) this;
        }

        public Criteria andCouponTimeNotIn(List<Date> values) {
            addCriterion("coupon_time not in", values, "couponTime");
            return (Criteria) this;
        }

        public Criteria andCouponTimeBetween(Date value1, Date value2) {
            addCriterion("coupon_time between", value1, value2, "couponTime");
            return (Criteria) this;
        }

        public Criteria andCouponTimeNotBetween(Date value1, Date value2) {
            addCriterion("coupon_time not between", value1, value2, "couponTime");
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