package com.cloud.common.constants.gofun;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 推送 PushConstants
 * @author wei.yong
 */
public class PushConstants implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//推送Map
	public static Map<String, String> resSendMap = new HashMap<String, String>();

	//score-员工文明用车分数-CQL0001,dayLogin-每日签到-CQL0002,finishTimes-员工邀请好友信息-CQL0003,order-每日用车-CQL0004
	//verifyCard-身份证状态-CQL0005,verifyLicense-驾照状态-CQL0006,verifyDeposit-押金状态-CQL0007,freeSwitch-免密支付状态-CQL0008

	public static final String score = "score";
	public static final String dayLogin = "dayLogin";
	public static final String finishTimes = "finishTimes";
	public static final String order = "order";
	public static final String verifyCard = "verifyCard";
	public static final String verifyLicense = "verifyLicense";
	public static final String verifyDeposit = "verifyDeposit";
	public static final String freeSwitch = "freeSwitch";

	static {
		resSendMap.put(score, "CQL0001");
		resSendMap.put(dayLogin, "CQL0002");
		resSendMap.put(finishTimes, "CQL0003");
		resSendMap.put(order, "CQL0004");
		resSendMap.put(verifyCard, "CQL0005");
		resSendMap.put(verifyLicense, "CQL0006");
		resSendMap.put(verifyDeposit, "CQL0007");
		resSendMap.put(freeSwitch, "CQL0008");
	}

}