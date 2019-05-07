package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.RiskCheckParam;
import com.cloud.provider.safe.vo.risk.RiskCheckVo;

public interface RiskCheckDao {

    /**
     * 查询隐患排查列表
     * @param param
     * @return List<RiskCheckVo>
     */
    public List<RiskCheckVo> selectList(RiskCheckParam param);

}