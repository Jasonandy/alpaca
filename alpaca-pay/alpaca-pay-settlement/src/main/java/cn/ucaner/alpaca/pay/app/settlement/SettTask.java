package cn.ucaner.alpaca.pay.app.settlement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ucaner.alpaca.pay.app.settlement.scheduled.SettScheduled;

/**
* @Package：cn.ucaner.alpaca.pay.app.settlement   
* @ClassName：SettTask   
* @Description：   <p> 结算定时任务.(分商户统计账户历史进行汇总)</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:08:26   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class SettTask {
	
	private static final Log LOG = LogFactory.getLog(SettTask.class);
	
	private static final long MILLIS = 1000L;
	
	private SettTask(){
		
	}
	

	public static void main(String[] args) {

		try {

			@SuppressWarnings("resource")
			final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-context.xml" });
			context.start();
			LOG.debug("结算定时任务开始执行");
			SettScheduled settScheduled = (SettScheduled) context.getBean("settScheduled");

			LOG.debug("执行(每日待结算数据汇总)任务开始");
			settScheduled.launchDailySettCollect();
			LOG.debug("执行(每日待结算数据汇总)任务结束");
			
			Thread.sleep(MILLIS);

			LOG.debug("执行(定期自动结算)任务开始");
			settScheduled.launchAutoSett();
			LOG.debug("执行(定期自动结算)任务结束");

			context.stop();
		} catch (Exception e) {
			LOG.error("SettTask execute error:", e);
		} finally {
			System.exit(0);
			LOG.debug("SettTask Complete");
		}
	}

}
