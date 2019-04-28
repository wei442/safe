package com.cloud.queue.safe.vo.push;

import java.io.Serializable;

/**
 * 数据推送 DataPushVo
 * @author wei.yong
 */
public class DataPushVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String content;

    private Integer pushType;

    private Long registryNo;

    //重试次数 默认为0
    private Integer retry =  0;

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPushType() {
		return this.pushType;
	}

	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}

	public Long getRegistryNo() {
		return this.registryNo;
	}

	public void setRegistryNo(Long registryNo) {
		this.registryNo = registryNo;
	}

	public Integer getRetry() {
		return this.retry;
	}

	public void setRetry(Integer retry) {
		this.retry = retry;
	}

	@Override
	public String toString() {
		return "DataPushVo [content=" + content + ", pushType=" + pushType + ", registryNo=" + registryNo + ", retry="
				+ retry + "]";
	}

}