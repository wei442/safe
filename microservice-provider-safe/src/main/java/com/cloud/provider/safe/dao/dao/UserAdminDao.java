package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.UserAdminParam;
import com.cloud.provider.safe.vo.user.UserAdminVo;

public interface UserAdminDao {

    /**
     * 查询用户管理用户
     * @param param
     * @return List<UserAdminVo>
     */
    public List<UserAdminVo> selectList(UserAdminParam param);

}