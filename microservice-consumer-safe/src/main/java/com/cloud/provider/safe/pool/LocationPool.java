package com.ochain.provider.wheel.pool;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @ClassName: LocationPool
 * @Description: 地域连接池
 * @author wei.yong
 * @date 2017-09-05
 */
public class LocationPool {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** 地域名称列表  */
    private final Set<String> locationSet = new HashSet<String>();

    /**
     * 构造器
     */
    public LocationPool() {
    }

    /**
     * 构造器
     * @param addrs
     */
    public LocationPool(Collection<String> locations) {
    	init(locations);
    }

    /**
     * 初始化
     * @param locations
     */
	private void init(Collection<String> locations) {
		locationSet.addAll(locations);
        logger.info("init location set : {} ", locationSet);
    }

	/**
	 * 随机获取地域名称
	 * @return String
	 */
	public String get() {
		int size = locationSet.size();
		int index = RandomUtils.nextInt(0, size);
		String locationName = Objects.toString(CollectionUtils.get(locationSet, index));
		logger.info("get a location name from set: {} ", locationName);
		return locationName;
	}

	/**
	 * 新增一个成员元素加入到集合中
	 * @param member
	 * @return boolean
	 */
	public boolean add(final String member) {
		boolean flag = locationSet.add(member);
		logger.info("add location name set is success: {} ", flag);
		return flag;
	}

	/**
	 * 返回成员元素
	 * @return Set<String>
	 */
	public Set<String> smembers() {
		return locationSet;
	}

}