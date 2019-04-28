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
import com.cloud.queue.safe.queue.DataAccountDiamondBalanceThread;
import com.cloud.queue.safe.queue.DataDiamondDrawQueueThread;
import com.cloud.queue.safe.queue.DataDiamondRecordQueueThread;
import com.cloud.queue.safe.queue.DataNewUserLoginThread;
import com.cloud.queue.safe.queue.DataUserCalculateConfigThread;
import com.cloud.queue.safe.queue.DataUserLoginLogThread;

/**
 * 方向盘线程启动执行
 * @author wei.yong
 */
@Component
@Order(value=0)
public class DataCommandRunner implements CommandLineRunner {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected ExecutorService executor = Executors.newCachedThreadPool();

	//用户算力配置线程
	@Autowired
	private DataUserCalculateConfigThread dataUserCalculateConfigThread;

	//能量线程
	@Autowired
	private DataDiamondRecordQueueThread dataDiamondRecordQueueThread;

	//能量领取线程
	@Autowired
	private DataDiamondDrawQueueThread dataDiamondDrawQueueThread;

	//新用户登录
	@Autowired
	private DataNewUserLoginThread dataNewUserLoginThread;

	//用户登录日志
	@Autowired
	private DataUserLoginLogThread dataUserLoginLogThread;

	//账户能量余额
	@Autowired
	private DataAccountDiamondBalanceThread dataAccountDiamondBalanceThread;

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
		this.startUserCalculateConfigThread();
		this.startDiamondRecordQueueThread();
		this.startDiamondDrawQueueThread();
		this.startNewUserLoginThread();
		this.startUserLoginLogThread();
		this.startAccountDiamondBalanceThread();
	}

	/**
	 * 启动用户算力配置数据线程队列
	 */
	public void startUserCalculateConfigThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataUserCalculateConfigThread);
		}
	}

	/**
	 * 启动能量记录线程队列
	 */
	public void startDiamondRecordQueueThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataDiamondRecordQueueThread);
		}
	}

	/**
	 * 启动能量领取线程队列
	 */
	public void startDiamondDrawQueueThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataDiamondDrawQueueThread);
		}
	}

	/**
	 * 启动新用户登录线程队列
	 */
	public void startNewUserLoginThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataNewUserLoginThread);
		}
	}

	/**
	 * 启动用户登录日志线程队列
	 */
	public void startUserLoginLogThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataUserLoginLogThread);
		}
	}

	/**
	 * 启动用账户能量余额线程队列
	 */
	public void startAccountDiamondBalanceThread() {
		for (int i = 0; i < 2; i++) {
			executor.execute(dataAccountDiamondBalanceThread);
		}
	}

}