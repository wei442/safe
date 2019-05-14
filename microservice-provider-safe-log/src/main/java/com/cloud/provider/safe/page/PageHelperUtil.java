package com.cloud.provider.safe.page;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageInfo;

/**
 * 分页工具类
 * @author wei.yong
 */
public enum PageHelperUtil {

	INSTANCE;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

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
		return page;
	}


}