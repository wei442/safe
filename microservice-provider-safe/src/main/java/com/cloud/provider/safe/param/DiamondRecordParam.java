package com.cloud.provider.safe.param;

import java.io.Serializable;

/**
 * 能量记录请求 DiamondRecordParam
 * @author wei.yong
 */
public class DiamondRecordParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    //领用时间开始字符串
  	private String useTimeStartStr;

  	//领用时间结束字符串
  	private String useTimeEndStr;

  	//创建时间开始字符串
  	private String createTimeStartStr;

  	//创建时间结束字符串
  	private String createTimeEndStr;

	public String getUseTimeStartStr() {
		return this.useTimeStartStr;
	}

	public void setUseTimeStartStr(String useTimeStartStr) {
		this.useTimeStartStr = useTimeStartStr;
	}

	public String getUseTimeEndStr() {
		return this.useTimeEndStr;
	}

	public void setUseTimeEndStr(String useTimeEndStr) {
		this.useTimeEndStr = useTimeEndStr;
	}

	public String getCreateTimeStartStr() {
		return this.createTimeStartStr;
	}

	public void setCreateTimeStartStr(String createTimeStartStr) {
		this.createTimeStartStr = createTimeStartStr;
	}

	public String getCreateTimeEndStr() {
		return this.createTimeEndStr;
	}

	public void setCreateTimeEndStr(String createTimeEndStr) {
		this.createTimeEndStr = createTimeEndStr;
	}

	@Override
	public String toString() {
		return "DiamondRecordParam [useTimeStartStr=" + useTimeStartStr + ", useTimeEndStr=" + useTimeEndStr
				+ ", createTimeStartStr=" + createTimeStartStr + ", createTimeEndStr=" + createTimeEndStr + "]";
	}

}