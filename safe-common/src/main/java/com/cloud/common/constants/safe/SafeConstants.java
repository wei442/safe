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
		safeMap.put("101001", "作业场所");
		safeMap.put("101002", "风险类别");
		safeMap.put("101003", "风险因素");
		safeMap.put("101004", "风险级别");
		safeMap.put("101005", "管控因素");
		safeMap.put("101006", "管控措施");
		safeMap.put("101007", "检查频次");

		//隐患
		safeMap.put("102001", "隐患级别");
		safeMap.put("102002", "隐患大类");
		safeMap.put("102003", "隐患小类");
	}

}