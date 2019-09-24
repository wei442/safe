package com.cloud.consumer.safe.runner;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 用户数据启动加载
 * @author wei.yong
 */
@Component
@Order(value=0)
public class DataCommandRunner implements CommandLineRunner {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 运行
	 */
	@Override
	public void run(String... args) throws Exception {
	}

	/**
	 * 销毁
	 * 睡眠5秒
	 */
	@PreDestroy
    public void destory() {
		long begintime = System.currentTimeMillis();
    	if(logger.isInfoEnabled())logger.info("【DataCommandRunner-destroy】-用户数据销毁开始,请等待5秒,程序将自动退出!");
    	try {
    		//睡眠5000毫秒(5秒)
    		Thread.sleep(5000);
		} catch (InterruptedException e) {
			logger.error("【DataCommandRunner-destroy】-用户数据销毁--事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}
        long endtime = System.currentTimeMillis();
        if(logger.isInfoEnabled())logger.info("【DataCommandRunner-destroy】-用户数据销毁完成, 耗时"+(endtime-begintime)+"ms！");
    }

}