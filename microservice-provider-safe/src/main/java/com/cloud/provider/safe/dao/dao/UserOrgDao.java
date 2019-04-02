package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.UserOrgParam;
import com.cloud.provider.safe.vo.UserOrgVo;

public interface UserOrgDao {

    /**
     * 查询当组织机构下的所有人员
     * @param param
     * @return List<UserOrgVo>
     */
    public List<UserOrgVo> selectList(UserOrgParam param);

}