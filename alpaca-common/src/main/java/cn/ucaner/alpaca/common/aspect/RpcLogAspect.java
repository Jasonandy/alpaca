package cn.ucaner.alpaca.common.aspect;

import com.alibaba.dubbo.rpc.RpcContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @Package：cn.ucaner.alpaca.common.aspect   
* @ClassName：RpcLogAspect   
* @Description：   <p> rpc提供者和消费者日志打印 </p>
* @Author： -    
* @CreatTime：2018年5月24日 下午2:21:49   
* @Modify By：   
* @ModifyTime：  2018年5月24日
* @Modify marker：   
* @version    V1.0
 */
public class RpcLogAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(RpcLogAspect.class);

	// 开始时间
	private long startTime = 0L;
	// 结束时间
	private long endTime = 0L;

	@Before("execution(* *..rpc..*.*(..))")
	public void doBeforeInServiceLayer(JoinPoint joinPoint) {
		LOGGER.debug("doBeforeInServiceLayer");
		startTime = System.currentTimeMillis();
	}

	@After("execution(* *..rpc..*.*(..))")
	public void doAfterInServiceLayer(JoinPoint joinPoint) {
		LOGGER.debug("doAfterInServiceLayer");
	}

	@Around("execution(* *..rpc..*.*(..))")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Object result = pjp.proceed();
		// 是否是消费端
		boolean consumerSide = RpcContext.getContext().isConsumerSide();
		// 获取最后一次提供方或调用方IP
		String ip = RpcContext.getContext().getRemoteHost();
		// 服务url
		String rpcUrl = RpcContext.getContext().getUrl().getParameter("application");
		LOGGER.info("consumerSide={}, ip={}, url={}", consumerSide, ip, rpcUrl);
		return result;
	}

}
