package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRechargeCoinExample implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderRechargeCoinExample() {
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

        public Criteria andOrderRechargeCoinIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdEqualTo(Long value) {
            addCriterion("id =", value, "orderRechargeCoinId");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "orderRechargeCoinId");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdGreaterThan(Long value) {
            addCriterion("id >", value, "orderRechargeCoinId");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "orderRechargeCoinId");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdLessThan(Long value) {
            addCriterion("id <", value, "orderRechargeCoinId");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "orderRechargeCoinId");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdIn(List<Long> values) {
            addCriterion("id in", values, "orderRechargeCoinId");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "orderRechargeCoinId");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "orderRechargeCoinId");
            return (Criteria) this;
        }

        public Criteria andOrderRechargeCoinIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "orderRechargeCoinId");
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Long value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Long value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Long value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Long value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Long value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Long value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<Long> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<Long> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Long value1, Long value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Long value1, Long value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromIsNull() {
            addCriterion("account_addr_from is null");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromIsNotNull() {
            addCriterion("account_addr_from is not null");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromEqualTo(String value) {
            addCriterion("account_addr_from =", value, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromNotEqualTo(String value) {
            addCriterion("account_addr_from <>", value, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromGreaterThan(String value) {
            addCriterion("account_addr_from >", value, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromGreaterThanOrEqualTo(String value) {
            addCriterion("account_addr_from >=", value, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromLessThan(String value) {
            addCriterion("account_addr_from <", value, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromLessThanOrEqualTo(String value) {
            addCriterion("account_addr_from <=", value, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromLike(String value) {
            addCriterion("account_addr_from like", value, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromNotLike(String value) {
            addCriterion("account_addr_from not like", value, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromIn(List<String> values) {
            addCriterion("account_addr_from in", values, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromNotIn(List<String> values) {
            addCriterion("account_addr_from not in", values, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromBetween(String value1, String value2) {
            addCriterion("account_addr_from between", value1, value2, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrFromNotBetween(String value1, String value2) {
            addCriterion("account_addr_from not between", value1, value2, "accountAddrFrom");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToIsNull() {
            addCriterion("account_addr_to is null");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToIsNotNull() {
            addCriterion("account_addr_to is not null");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToEqualTo(String value) {
            addCriterion("account_addr_to =", value, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToNotEqualTo(String value) {
            addCriterion("account_addr_to <>", value, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToGreaterThan(String value) {
            addCriterion("account_addr_to >", value, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToGreaterThanOrEqualTo(String value) {
            addCriterion("account_addr_to >=", value, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToLessThan(String value) {
            addCriterion("account_addr_to <", value, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToLessThanOrEqualTo(String value) {
            addCriterion("account_addr_to <=", value, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToLike(String value) {
            addCriterion("account_addr_to like", value, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToNotLike(String value) {
            addCriterion("account_addr_to not like", value, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToIn(List<String> values) {
            addCriterion("account_addr_to in", values, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToNotIn(List<String> values) {
            addCriterion("account_addr_to not in", values, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToBetween(String value1, String value2) {
            addCriterion("account_addr_to between", value1, value2, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andAccountAddrToNotBetween(String value1, String value2) {
            addCriterion("account_addr_to not between", value1, value2, "accountAddrTo");
            return (Criteria) this;
        }

        public Criteria andTransactionHashIsNull() {
            addCriterion("transaction_hash is null");
            return (Criteria) this;
        }

        public Criteria andTransactionHashIsNotNull() {
            addCriterion("transaction_hash is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionHashEqualTo(String value) {
            addCriterion("transaction_hash =", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashNotEqualTo(String value) {
            addCriterion("transaction_hash <>", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashGreaterThan(String value) {
            addCriterion("transaction_hash >", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_hash >=", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashLessThan(String value) {
            addCriterion("transaction_hash <", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashLessThanOrEqualTo(String value) {
            addCriterion("transaction_hash <=", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashLike(String value) {
            addCriterion("transaction_hash like", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashNotLike(String value) {
            addCriterion("transaction_hash not like", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashIn(List<String> values) {
            addCriterion("transaction_hash in", values, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashNotIn(List<String> values) {
            addCriterion("transaction_hash not in", values, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashBetween(String value1, String value2) {
            addCriterion("transaction_hash between", value1, value2, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashNotBetween(String value1, String value2) {
            addCriterion("transaction_hash not between", value1, value2, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andGfcIsNull() {
            addCriterion("gfc is null");
            return (Criteria) this;
        }

        public Criteria andGfcIsNotNull() {
            addCriterion("gfc is not null");
            return (Criteria) this;
        }

        public Criteria andGfcEqualTo(String value) {
            addCriterion("gfc =", value, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcNotEqualTo(String value) {
            addCriterion("gfc <>", value, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcGreaterThan(String value) {
            addCriterion("gfc >", value, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcGreaterThanOrEqualTo(String value) {
            addCriterion("gfc >=", value, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcLessThan(String value) {
            addCriterion("gfc <", value, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcLessThanOrEqualTo(String value) {
            addCriterion("gfc <=", value, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcLike(String value) {
            addCriterion("gfc like", value, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcNotLike(String value) {
            addCriterion("gfc not like", value, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcIn(List<String> values) {
            addCriterion("gfc in", values, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcNotIn(List<String> values) {
            addCriterion("gfc not in", values, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcBetween(String value1, String value2) {
            addCriterion("gfc between", value1, value2, "gfc");
            return (Criteria) this;
        }

        public Criteria andGfcNotBetween(String value1, String value2) {
            addCriterion("gfc not between", value1, value2, "gfc");
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

        public Criteria andFeeEqualTo(String value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(String value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(String value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(String value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(String value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(String value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLike(String value) {
            addCriterion("fee like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotLike(String value) {
            addCriterion("fee not like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<String> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<String> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(String value1, String value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(String value1, String value2) {
            addCriterion("fee not between", value1, value2, "fee");
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

        public Criteria andCompleteTimeIsNull() {
            addCriterion("complete_time is null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNotNull() {
            addCriterion("complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeEqualTo(Date value) {
            addCriterion("complete_time =", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotEqualTo(Date value) {
            addCriterion("complete_time <>", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThan(Date value) {
            addCriterion("complete_time >", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complete_time >=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThan(Date value) {
            addCriterion("complete_time <", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("complete_time <=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIn(List<Date> values) {
            addCriterion("complete_time in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotIn(List<Date> values) {
            addCriterion("complete_time not in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("complete_time between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("complete_time not between", value1, value2, "completeTime");
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