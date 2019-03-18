package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.UserParam;
import com.cloud.provider.safe.vo.UserInfoVo;

public interface UserInfoDao {

    /**
     * 根据orgId查询当前组织机构下的所有人员
     * @param param
     * @return List<UserInfoVo>
     */
    public List<UserInfoVo> selectUserInfoListByOrgId(UserParam param);

}