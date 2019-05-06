package com.cloud.common.constants.safe;

import java.util.HashMap;
import java.util.Map;

/**
 * 安全变量 SafeConstants
 * @author wei.yong
 */
public class SafeConstants {

	//初始化密码，6个1，111111
	public static final String PASSWORD_INIT = "111111";

	//主管理员
	public static final String ADMIN_NAME_MASTER = "主管理员";

	//子管理员
	public static final String ADMIN_NAME_SALVE = "子管理员";

	//安全变量Map
	public static Map<String, String> safeMap = new HashMap<String, String>();

	static {
		//风险
		safeMap.put("101001", "风险类别");
		safeMap.put("101002", "风险因素");
		safeMap.put("101003", "风险级别");
		safeMap.put("101004", "管控因素");
		safeMap.put("101005", "管控措施");
		safeMap.put("101006", "检查频次");

		//隐患
		safeMap.put("102001", "隐患级别");
		safeMap.put("102002", "隐患大类");
		safeMap.put("102003", "隐患小类");
	}

//	//风险类别
//	public static final String DICT_CODE_RISK_CATEGORY = "101001";
//	public static final String DICT_NAME_RISK_CATEGORY = "风险类别";
//	//风险因素
//	public static final String DICT_CODE_RISK_REASON = "101002";
//	public static final String DICT_NAME_RISK_REASON = "风险因素";
//	//风险级别
//	public static final String DICT_CODE_RISK_LEVEL = "101003";
//	public static final String DICT_NAME_RISK_LEVEL = "风险级别";
//	//管控因素
//	public static final String DICT_CODE_CONTROL_REASON = "101004";
//	public static final String DICT_NAME_CONTROL_REASON = "管控因素";
//	//管控措施
//	public static final String DICT_CODE_CONTROL_METHOD = "101005";
//	public static final String DICT_NAME_CONTROL_METHOD = "管控措施";
//	//检查频次
//	public static final String DICT_CODE_FREQUENCY = "101006";
//	public static final String DICT_NAME_FREQUENCY = "检查频次";
//
//	//隐患级别
//	public static final String DICT_CODE_DANGER_LEVEL = "102001";
//	public static final String DICT_NAME_DANGER_LEVEL = "隐患级别";
//	//隐患大类
//	public static final String DICT_CODE_DANGER_MAIN_CATEGORY = "102002";
//	public static final String DICT_NAME_DANGER_MAIN_CATEGORY = "隐患大类";
//	//隐患小类
//	public static final String DICT_CODE_DANGER_SUB_CATEGORY = "102003";
//	public static final String DICT_NAME_DANGER_SUB_CATEGORY = "隐患小类";

}