package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.UserOrgParam;
import com.cloud.provider.safe.vo.user.UserOrgVo;

public interface UserOrgDao {

    /**
     * 查询当组织机构下的所有人员
     * @param param
     * @return List<UserOrgVo>
     */
    public List<UserOrgVo> selectList(UserOrgParam param);

    /**
     * 根据orgId更新用户组织机构机构名称
     * @param param
     * @return int
     */
    public int updateOrgNameByOrgId(UserOrgParam param);

}