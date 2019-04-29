package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.po.UserMenu;

public interface UserMenuDao {

    /**
     * 批量插入
     * @param list
     * @return int
     */
    public int insertList(List<UserMenu> list);

}