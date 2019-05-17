package com.cloud.queue.safe.runner;

import java.util.concurrent.ExecutionException;
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

import com.cloud.queue.safe.queue.DataAttachmentLogThread;
import com.cloud.queue.safe.queue.DataBaseUserLoginLogThread;
import com.cloud.queue.safe.queue.DataUserAdminLoginLogThread;
import com.cloud.queue.safe.queue.DataUserAppLoginLogThread;

/**
 * 安全日志线程启动执行
 * @author wei.yong
 */
@Component
@Order(value=1)
public class DataCommandRunner implements CommandLineRunner {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//线程
	protected ExecutorService executor = Executors.newCachedThreadPool();

	//附件日志线程
	@Autowired
	private DataAttachmentLogThread dataAttachmentLogThread;

	//基础用户登录日志线程
	@Autowired
	private DataBaseUserLoginLogThread dataBaseUserLoginLogThread;

	//用户管理登录日志线程
	@Autowired
	private DataUserAdminLoginLogThread dataUserAdminLoginLogThread;

	//用户app登录日志线程
	@Autowired
	private DataUserAppLoginLogThread dataUserAppLoginLogThread;

	/**
	 * 在对象销毁的时候执行
	 * 等待**秒后自动结束
	 */
	@PreDestroy
    public void destroy() {
		long begintime = System.currentTimeMillis();
		logger.info("(DataCommandRunner-destroy)-线程销毁开始,请等待,程序将自动退出!");
		try {
			this.addShutdownHook();
			executor.shutdown();
    		executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("(DataCommandRunner-destroy)-线程销毁-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		} finally {
			if(!executor.isTerminated()) {
                executor.shutdownNow();
            }
		}
        long endtime = System.currentTimeMillis();
        logger.info("(DataCommandRunner-destroy)-线程销毁完成,耗时"+(endtime-begintime)+"ms！");
    }

	/**
	 * 运行
	 */
	@Override
	public void run(String... args) {
		this.startDataAttachmentLogThread();
		this.startDataBaseUserLoginLogThread();
		this.startDataUserAdminLoginLogThread();
		this.startDataUserAppLoginLogThread();
	}

	/**
	 * 启动附件日志数据线程队列
	 */
	public void startDataAttachmentLogThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataAttachmentLogThread);
		}
	}

	/**
	 * 启动基础用户登录日志线程
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public void startDataBaseUserLoginLogThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataBaseUserLoginLogThread);
		}
	}

	/**
	 * 启动用户管理登录日志线程
	 */
	public void startDataUserAdminLoginLogThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataUserAdminLoginLogThread);
		}
	}

	/**
	 * 启动用户app登录日志线程
	 */
	public void startDataUserAppLoginLogThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataUserAppLoginLogThread);
		}
	}

	/**
	 * 添加钩子,保证程序安全退出。
	 * 进程关闭时，我们将线程池中已经添加的任务继续执行完毕，防止已添加的任务丢失。
	 */
	public void addShutdownHook() {
		logger.info("(DataCommandRunner-addShutdownHook)-添加钩子开始");
		Runtime.getRuntime().addShutdownHook(dataAttachmentLogThread);
		Runtime.getRuntime().addShutdownHook(dataBaseUserLoginLogThread);
		Runtime.getRuntime().addShutdownHook(dataUserAdminLoginLogThread);
		Runtime.getRuntime().addShutdownHook(dataUserAppLoginLogThread);
		logger.info("(DataCommandRunner-addShutdownHook)-添加钩子结束");
	}

}