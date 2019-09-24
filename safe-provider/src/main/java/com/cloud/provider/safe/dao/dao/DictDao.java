package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.po.Dict;

public interface DictDao {

    /**
     * 批量插入
     * @param list
     * @return int
     */
    public int insertList(List<Dict> list);

}