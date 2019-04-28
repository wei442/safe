package com.cloud.queue.safe.vo.gofun;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class GCodeVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String gCode;

	private JSONObject content;

	public String getgCode() {
		return this.gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public JSONObject getContent() {
		return this.content;
	}

	public void setContent(JSONObject content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "GCodeVo [gCode=" + gCode + ", content=" + content + "]";
	}

}