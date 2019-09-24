package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.RiskDutyParam;
import com.cloud.provider.safe.vo.risk.RiskDutyVo;

public interface RiskDutyDao {

    /**
     * 查询风险责任列表
     * @param param
     * @return List<RiskDutyVo>
     */
    public List<RiskDutyVo> selectList(RiskDutyParam param);

}