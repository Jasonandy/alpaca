package cn.ucaner.alpaca.pay;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

import cn.ucaner.alpaca.pay.account.service.RpAccountTransactionService;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.permission.entity.PmsOperator;
import cn.ucaner.alpaca.pay.permission.service.PmsOperatorService;
import cn.ucaner.alpaca.pay.trade.dao.RpTradePaymentOrderDao;
import cn.ucaner.alpaca.pay.trade.entity.RpTradePaymentRecord;
import cn.ucaner.alpaca.pay.trade.service.RpTradePaymentManagerService;
import cn.ucaner.alpaca.pay.trade.service.RpTradePaymentQueryService;

/**
* @Package：cn.ucaner.alpaca.pay   
* @ClassName：DubboProvider   
* @Description：   <p> 启动Dubbo服务用的MainClass. </p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:22:06   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class DubboProvider {

	private static final Log log = LogFactory.getLog(DubboProvider.class);

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-context-service.xml");
			RpAccountTransactionService rpAccountTransactionService = (RpAccountTransactionService) ac.getBean("rpAccountTransactionService");
			PmsOperatorService operator = (PmsOperatorService) ac.getBean("pmsOperatorService");
			RpTradePaymentQueryService trade = (RpTradePaymentQueryService) ac.getBean("rpTradePaymentQueryService");
			RpTradePaymentManagerService manage = (RpTradePaymentManagerService) ac.getBean("rpTradePaymentManagerService");
			
			//rpTradePaymentOrderDao
			RpTradePaymentOrderDao rpDao = (RpTradePaymentOrderDao) ac.getBean("rpTradePaymentOrderDao");
			PmsOperator pmsOperator = new PmsOperator();
			pmsOperator.setLoginName("admin");
			pmsOperator.setRealName("超级");
			//pmsOperator.setStatus("{id:'ACTIVE',desc:'激活'}");//ACTIVE
			pmsOperator.setStatus("ACTIVE");
			PageBean listPage = operator.listPage(new PageParam(), pmsOperator);
			PmsOperator op = operator.findOperatorByLoginName("admin");
			List<RpTradePaymentRecord> listPaymentRecordList = trade.listPaymentRecord(null);
			System.out.println(listPaymentRecordList);
			System.out.println(listPage);
			System.out.println(JSON.toJSONString(listPage));
			System.out.println(listPage.getCountResultMap());
			System.out.println(JSON.toJSONString(op));
			System.out.println(manage);
			System.out.println(rpDao);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("== DubboProvider context start error:", e);
		}
	}

}
//outputs 
//cn.ucaner.alpaca.pay.common.core.page.PageBean@3a0baae5
//{
//	"beginPageIndex": 1,
//	"currentPage": 1,
//	"endPageIndex": 1,
//	"numPerPage": 15,
//	"recordList": [{
//		"createTime": 1464923263000,
//		"creater": "APLACA",
//		"credentialsSalt": "ADMIN8D78869F470951332959580424D4BF4F",
//		"editTime": 1464923263000,
//		"editor": "ADMIN",
//		"id": 1,
//		"loginName": "ADMIN",
//		"loginPwd": "D3C59D25033DBF980D29554025C23A75",
//		"mobileNo": "18620936193",
//		"realName": "超级管理员",
//		"remark": "超级管理员",
//		"status": "ACTIVE",
//		"type": "ADMIN",
//		"version": 0
//	}],
//	"totalCount": 1,
//	"totalPage": 1
//}