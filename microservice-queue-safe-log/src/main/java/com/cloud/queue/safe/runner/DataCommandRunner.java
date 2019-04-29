package com.cloud.queue.safe.runner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cloud.queue.safe.hook.ShutdownHandler;
import com.cloud.queue.safe.queue.DataAttachmentLogThread;

/**
 * 方向盘线程启动执行
 * @author wei.yong
 */
@Component
@Order(value=0)
public class DataCommandRunner implements CommandLineRunner {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected ExecutorService executor = Executors.newCachedThreadPool();

	//附件日志线程
	@Autowired
	private DataAttachmentLogThread dataAttachmentLogThread;

	/**
	 * 在对象销毁的时候执行
	 * 等待20秒后自动结束
	 */
	@PreDestroy
    public void destroy() {
		long begintime = System.currentTimeMillis();
		if(logger.isInfoEnabled())logger.info("(DataCommandRunner-destroy)-线程销毁开始,请等待20秒,程序将自动退出!");
		try {
			executor.shutdown();
    		if(logger.isInfoEnabled())logger.info("(DataCommandRunner-destroy)-线程销毁开始-线程循环开关原值(keepRunning), old={}", ShutdownHandler.INSTANCE.keepRunning());
    		ShutdownHandler.INSTANCE.setKeepRunning(false);
    		if(logger.isInfoEnabled())logger.info("(DataCommandRunner-destroy)-线程销毁开始-线程循环开关新值(keepRunning), new={}", ShutdownHandler.INSTANCE.keepRunning());
    		executor.awaitTermination(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			logger.error("(DataCommandRunner-destroy)-线程销毁-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		} finally {
			if(!executor.isTerminated()) {
                executor.shutdownNow();
            }
		}
        long endtime = System.currentTimeMillis();
        if(logger.isInfoEnabled())logger.info("(DataCommandRunner-destroy)-线程销毁完成,耗时"+(endtime-begintime)+"ms！");
    }

	/**
	 * 运行
	 */
	@Override
	public void run(String... args) {
		this.startAttachmentLogThread();
	}

	/**
	 * 启动附件日志数据线程队列
	 */
	public void startAttachmentLogThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataAttachmentLogThread);
		}
	}


}