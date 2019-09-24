package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.UserTitleParam;
import com.cloud.provider.safe.po.UserTitle;
import com.cloud.provider.safe.vo.user.UserTitleVo;

public interface UserTitleDao {

    /**
     * 查询当前用户职务下的所有人员
     * @param param
     * @return List<UserTitleVo>
     */
    public List<UserTitleVo> selectList(UserTitleParam param);

    /**
     * 批量插入
     * @param list
     * @return int
     */
    public int insertList(List<UserTitle> list);

}