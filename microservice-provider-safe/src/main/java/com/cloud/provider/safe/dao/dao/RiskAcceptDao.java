package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.RiskAcceptParam;
import com.cloud.provider.safe.vo.risk.RiskAcceptVo;

public interface RiskAcceptDao {

    /**
     * 查询风险验收列表
     * @param param
     * @return List<RiskAcceptVo>
     */
    public List<RiskAcceptVo> selectList(RiskAcceptParam param);

}