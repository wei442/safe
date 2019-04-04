package com.cloud.provider.safe.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.common.constants.PageConstants;
import com.github.pagehelper.PageInfo;

/**
 * 分页工具类
 * @author wei.yong
 */
public enum PageHelperUtil {

	INSTANCE;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private Map<String, Object> map = null;

	private PageVo page = null;

	/**
	 * 获取分页map列表对象
	 * @param list
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getPageListMap(List<?> list) {
		if(list != null && !list.isEmpty()) {
			PageInfo<?> pageInfo = new PageInfo<>(list);
			page = new PageVo();
			page.setPageNum(pageInfo.getPageNum());
			page.setPageSize(pageInfo.getPageSize());
			page.setSize(pageInfo.getSize());
			page.setTotal(pageInfo.getTotal());
			page.setPages(pageInfo.getPages());
			page.setPrePage(pageInfo.getPrePage());
			page.setNextPage(pageInfo.getNextPage());
			page.setNavigateFirstPage(pageInfo.getNavigateFirstPage());
			page.setNavigateLastPage(pageInfo.getNavigateLastPage());
			page.setNavigatepageNums(pageInfo.getNavigatepageNums());
		}

		map = new HashMap<String, Object>();
		map.put(PageConstants.PAGE, page);
		map.put(PageConstants.DATA_LIST, list);
		return map;
	}

}