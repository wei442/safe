package com.cloud.common.enums;

import com.cloud.common.constants.RetConstants;

/**
 * @author wei.yong
 * @date 2019-02-21 11:24
 */
public interface ResultEnum {

    /**
     * 获取编码: default:0000000
     * @return java.lang.String
     * @author yueli
     * @date 2019-02-21 11:23
     */
    default String getCode() {
        return RetConstants.OK;
    }

    /**
     * 获取提示信息: default:SUCCESS
     * @return java.lang.String
     * @author yueli
     * @date 2019-02-21 11:23
     */
    default String getMsg() {
        return RetConstants.OK_MSG;
    }

}