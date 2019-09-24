package com.cloud.provider.safe.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cloud.common.constants.safe.SafeConstants;
import com.cloud.provider.safe.po.Dict;

public enum DictUtil {

	INSTANCE;

	private List<Dict> dicList = new ArrayList<Dict>();

	/**
	 * 获取初始化字典列表
	 * @param enterpriseId
	 * @return List<Dict>
	 */
	public List<Dict> getInitDictList(Integer enterpriseId) {
		Map<String, String> safeMap = SafeConstants.safeMap;
		Dict dict = null;
		if(safeMap != null && !safeMap.isEmpty()) {
			for (Map.Entry<String, String> entry : safeMap.entrySet()) {
				dict = new Dict();
				dict.setEnterpriseId(enterpriseId);
				dict.setDictCode(entry.getKey());
				dict.setDictName(entry.getValue());
				dicList.add(dict);
			}
		}

		return dicList;
	}

}