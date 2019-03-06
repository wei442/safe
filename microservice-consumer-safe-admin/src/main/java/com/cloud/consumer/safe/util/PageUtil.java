package com.cloud.consumer.safe.util;

import java.io.Serializable;

/**
 * Mybatis分页参数及查询结果封装. 注意所有序号从1开始.
 * @param <T>  Page中记录的类型.
 * @author wei.yong
 * @since 2014年5月18日 下午1:34:32
 **/
public class PageUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    // --分页参数 --//
    /**
     * 页编号 : 第几页
     */
    protected int pageNum = 1;
    /**
     * 页大小 : 每页的数量
     */
    protected int pageSize = 10;

    /**
     * 偏移量 : 第一条数据在表中的位置
     */
    protected int offset;

    /**
     * 限定数 : 每页的数量
     */
    protected int limit;

    /**
     * 总条数
     */
    protected long totalCount;

    /**
     * 总页数
     */
    protected int totalPages;

    // --计算 数据库 查询的参数 : LIMIT 3, 3; LIMIT offset, limit; --//
    /**
     * 计算偏移量
     */
    private void calcOffset() {
        this.offset = ((pageNum - 1) * pageSize);
    }

    /**
     * 计算限定数
     */
    private void calcLimit() {
        this.limit = pageSize;
    }

    // -- 构造函数 --//
    public PageUtil() {
        this.calcOffset();
        this.calcLimit();
    }

    public PageUtil(int pageNum, int pageSize) {
        if (pageNum > 0) {
            this.pageNum = pageNum;
        }
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
        this.calcOffset();
        this.calcLimit();
    }

    // -- 访问查询参数函数 --//
    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getPageNum() {
        return pageNum;
    }

    /**
     * 获得每页的记录数量,默认为1.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    public int getFirst() {
        return ((pageNum - 1) * pageSize) + 1;
    }

    /**
     * 取得总记录数, 默认值为-1.
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数.
     */
    public void setTotalCount(final long totalCount) {
        this.totalCount = totalCount;

        if (totalCount < 0) {
            this.totalPages = -1;
        } else {
            long pages = totalCount / pageSize;
            this.totalPages = (int) (totalCount % pageSize > 0 ? ++pages : pages);
        }
    }

    /**
     * 根据pageSize与totalCount计算总页数, 默认值为-1.
     */
    public int getTotalPages() {
        return this.totalPages;
    }


}