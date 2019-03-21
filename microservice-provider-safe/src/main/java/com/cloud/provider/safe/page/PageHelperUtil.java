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

		logger.info("map==="+map);
		return map;
	}

	/**
	 * 获取分页对象
	 * @param list
	 * @return PageVo
	 */
	public PageVo getPageVo(List<?> list) {
		PageVo page = null;
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

//		map = new HashMap<String, Object>();
//		map.put(PageConstants.PAGE, page);
//		map.put(PageConstants.DATA_LIST, list);

		return page;
	}



//	/**
//	 * 获取分页map列表对象
//	 * @param list
//	 * @return Map<String, Object>
//	 */
//	public Map<String, Object> getPageListMap(List<?> list) {
//		PageInfo<?> pageInfo = new PageInfo<>(list);
//		map = new HashMap<String, Object>();
//		map.put(PageConstants.DATA_LIST, list);
//		map.put(PageConstants.PAGE_NUM, pageInfo.getPageNum());
//		map.put(PageConstants.PAGE_SIZE, pageInfo.getPageSize());
//		map.put(PageConstants.SIZE, pageInfo.getSize());
//		map.put(PageConstants.TOTAL, pageInfo.getTotal());
//		map.put(PageConstants.PAGES, pageInfo.getPages());
//		map.put(PageConstants.PRE_PAGE, pageInfo.getPrePage());
//		map.put(PageConstants.NEXT_PAGE, pageInfo.getNextPage());
//		map.put(PageConstants.NAVIGATE_FIRST_PAGE, pageInfo.getNavigateFirstPage());
//		map.put(PageConstants.NAVIGATE_LAST_PAGE, pageInfo.getNavigateLastPage());
//		map.put(PageConstants.NAVIGATE_PAGE_NUMS, pageInfo.getNavigatepageNums());
//		return map;
//	}

//	/**
//	 * 获取分页对象
//	 * @param pageInfo
//	 * @return Page
//	 */
//	public Page getPage(List<?> list) {
//		PageInfo<?> pageInfo = new PageInfo<>(list);
//		page = new Page();
//		page.setPageNum(pageInfo.getPageNum());
//		page.setPageSize(pageInfo.getPageSize());
//		page.setSize(pageInfo.getSize());
//		page.setTotal(pageInfo.getTotal());
//		page.setPages(pageInfo.getPages());
//		page.setPrePage(pageInfo.getPrePage());
//		page.setNextPage(pageInfo.getNextPage());
//		page.setNavigateFirstPage(pageInfo.getNavigateFirstPage());
//		page.setNavigateLastPage(pageInfo.getNavigateLastPage());
//		page.setNavigatepageNums(pageInfo.getNavigatepageNums());
//		return page;
//	}
//
//	/**
//	 * 获取分页map对象
//	 * @param pageInfo
//	 * @return Map<String, Object>
//	 */
//	public Map<String, Object> getPageMap(List<?> list) {
//		map = new HashMap<String, Object>();
//		PageInfo<?> pageInfo = new PageInfo<>(list);
//		map.put(PageConstants.PAGE_NUM, pageInfo.getPageNum());
//		map.put(PageConstants.PAGE_SIZE, pageInfo.getPageSize());
//		map.put(PageConstants.SIZE, pageInfo.getSize());
//		map.put(PageConstants.TOTAL, pageInfo.getTotal());
//		map.put(PageConstants.PAGES, pageInfo.getPages());
//		map.put(PageConstants.PRE_PAGE, pageInfo.getPrePage());
//		map.put(PageConstants.NEXT_PAGE, pageInfo.getNextPage());
//		map.put(PageConstants.NAVIGATE_FIRST_PAGE, pageInfo.getNavigateFirstPage());
//		map.put(PageConstants.NAVIGATE_LAST_PAGE, pageInfo.getNavigateLastPage());
//		map.put(PageConstants.NAVIGATE_PAGE_NUMS, pageInfo.getNavigatepageNums());
//		return map;
//	}

}