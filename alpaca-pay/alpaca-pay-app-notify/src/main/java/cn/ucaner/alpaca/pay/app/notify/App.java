package cn.ucaner.alpaca.pay.app.notify;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.DelayQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import cn.ucaner.alpaca.pay.app.notify.core.NotifyPersist;
import cn.ucaner.alpaca.pay.app.notify.core.NotifyQueue;
import cn.ucaner.alpaca.pay.app.notify.core.NotifyTask;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecord;
import cn.ucaner.alpaca.pay.notify.service.RpNotifyService;

/**
* @Package：cn.alpaca.pay.app.notify   
* @ClassName：App   
* @Description：   <p> 消息APP启动类</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午1:39:36   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class App {
	
    private static final Log LOG = LogFactory.getLog(App.class);

    public static DelayQueue<NotifyTask> tasks = new DelayQueue<NotifyTask>();

    private static ClassPathXmlApplicationContext context;

    private static ThreadPoolTaskExecutor threadPool;

    public static RpNotifyService rpNotifyService;

    private static NotifyQueue notifyQueue;

    public static NotifyPersist notifyPersist;

    public static void main(String[] args) {
        try {
            context = new ClassPathXmlApplicationContext(new String[] { "spring/spring-context.xml" });
            context.start();
            threadPool = (ThreadPoolTaskExecutor) context.getBean("threadPool");
            rpNotifyService = (RpNotifyService) context.getBean("rpNotifyService");
            notifyQueue = (NotifyQueue) context.getBean("notifyQueue");
            notifyPersist = (NotifyPersist) context.getBean("notifyPersist");
            startInitFromDB();
            startThread();
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
        LOG.info("startThread");

        threadPool.execute(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(50);//50毫秒执行一次
                        // 如果当前活动线程等于最大线程，那么不执行
                        if (threadPool.getActiveCount() < threadPool.getMaxPoolSize()) {
                            final NotifyTask task = tasks.poll();
                            if (task != null) {
                                threadPool.execute(new Runnable() {
                                    public void run() {
                                        LOG.info(threadPool.getActiveCount() + "---------");
                                        tasks.remove(task);
                                        task.run();
                                    }
                                });
                            }
                        }
                    }
                } catch (Exception e) {
                    LOG.error("系统异常",e);
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 从数据库中取一次数据用来当系统启动时初始化
     */
    @SuppressWarnings("unchecked")
    private static void startInitFromDB() {
        LOG.info("get data from database");

        int pageNum = 1;
        int numPerPage = 500;
        PageParam pageParam = new PageParam(pageNum, numPerPage);

        // 查询状态和通知次数符合以下条件的数据进行通知
        String[] status = new String[] { "101", "102", "200", "201" };
        Integer[] notifyTime = new Integer[] { 0, 1, 2, 3, 4 };
        // 组装查询条件
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("statusList", status);
        paramMap.put("notifyTimeList", notifyTime);

        PageBean<RpNotifyRecord> pager = rpNotifyService.queryNotifyRecordListPage(pageParam, paramMap);
        int totalSize = (pager.getNumPerPage()-1)/numPerPage+1;//总页数
        while (pageNum <= totalSize) {
            List<RpNotifyRecord> list = pager.getRecordList();
            for (int i = 0; i < list.size(); i++) {
                RpNotifyRecord notifyRecord = list.get(i);
                notifyRecord.setLastNotifyTime(new Date());
                notifyQueue.addElementToList(notifyRecord);
            }
            pageNum++;
            LOG.info(String.format("调用通知服务.rpNotifyService.queryNotifyRecordListPage(%s, %s, %s)", pageNum, numPerPage, paramMap));
            pageParam = new PageParam(pageNum, numPerPage);
            pager = rpNotifyService.queryNotifyRecordListPage(pageParam, paramMap);
        }
    }

}
