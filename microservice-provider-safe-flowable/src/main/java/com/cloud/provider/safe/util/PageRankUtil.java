//package com.cloud.provider.safe.util;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.cloud.provider.safe.po.CalculateRank;
//import com.ochain.pagehepler.mybatis.Page;
//
///**
// * @ClassName: PageRankUtil
// * @Description: 分页排名工具类
// * @author wei.yong
// * @date 2018-07-10
// */
//public class PageRankUtil {
//
//	protected final static Logger logger = LoggerFactory.getLogger(PageRankUtil.class);
//
//	/**
//	 * 获取分页排名查询字符串
//	 * @param page
//	 * @return String
//	 */
//	public static String getPageNumStr(Page<?> page) {
//		Integer pageSize = page.getPageSize();
//		Integer first = page.getFirst() - 1;
//		StringBuffer pageNumStr = new StringBuffer();
//		for(int i =0; i<pageSize;i++) {
//			pageNumStr.append(" '$[ ");
//			pageNumStr.append(first+i);
//			pageNumStr.append(" ]' , ");
//		}
//
//		String pageStr = StringUtils.deleteWhitespace(pageNumStr.toString());
//		pageStr = StringUtils.removeEnd(pageStr, ",");
//		return pageStr;
//	}
//
//	public static void main(String[] args) {
//		Page<CalculateRank> page = new Page<CalculateRank>(2, 200);
//		System.out.println(getPageNumStr(page));
//	}
//
//}