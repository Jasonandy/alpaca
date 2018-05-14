package cn.ucaner.alpaca.pay.app.order.polling;


import java.util.concurrent.DelayQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import cn.ucaner.alpaca.pay.app.order.polling.core.PollingPersist;
import cn.ucaner.alpaca.pay.app.order.polling.core.PollingTask;

/**
* @Package：cn.ucaner.alpaca.pay.app.order.polling   
* @ClassName：App   
* @Description：   <p> 消息APP启动类</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午1:54:58   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class App {
	
    private static final Log LOG = LogFactory.getLog(App.class);

    public static DelayQueue<PollingTask> tasks = new DelayQueue<PollingTask>();

    private static ClassPathXmlApplicationContext context;

    private static ThreadPoolTaskExecutor threadPool;

    public static PollingPersist pollingPersist;

    public static void main(String[] args) {
        try {
            context = new ClassPathXmlApplicationContext(new String[] { "spring/spring-context.xml" });
            context.start();
            threadPool = (ThreadPoolTaskExecutor) context.getBean("threadPool");
            pollingPersist = (PollingPersist) context.getBean("pollingPersist");

            startThread(); // 启动任务处理线程

            LOG.info("== context start");
        } catch (Exception e) {
            LOG.error("== application start error:", e);
            return;
        }
        synchronized (App.class) {
            while (true) {
                try {
                    App.class.wait();
                } catch (InterruptedException e) {
                    LOG.error("== synchronized error:", e);
                }
            }
        }
    }

    private static void startThread() {
        LOG.info("==>startThread");

        threadPool.execute(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(100);
                        LOG.info("==>threadPool.getActiveCount():" + threadPool.getActiveCount());
                        LOG.info("==>threadPool.getMaxPoolSize():" + threadPool.getMaxPoolSize());
                        // 如果当前活动线程等于最大线程，那么不执行
                        if (threadPool.getActiveCount() < threadPool.getMaxPoolSize()) {
                            LOG.info("==>tasks.size():" + tasks.size());
                            final PollingTask task = tasks.take(); //使用take方法获取过期任务,如果获取不到,就一直等待,知道获取到数据
                            if (task != null) {
                                threadPool.execute(new Runnable() {
                                    public void run() {
                                        tasks.remove(task);
                                        task.run(); // 执行通知处理
                                        LOG.info("==>tasks.size():" + tasks.size());
                                    }
                                });
                            }
                        }
                    }
                } catch (Exception e) {
                    LOG.error("系统异常;", e);
                }
            }
        });
    }

}
