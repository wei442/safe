package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.UserPostParam;
import com.cloud.provider.safe.vo.UserPostVo;

public interface UserPostDao {

    /**
     * 根据postId查询当前用户岗位下的所有人员
     * @param param
     * @return List<UserPostVo>
     */
    public List<UserPostVo> selectList(UserPostParam param);

}