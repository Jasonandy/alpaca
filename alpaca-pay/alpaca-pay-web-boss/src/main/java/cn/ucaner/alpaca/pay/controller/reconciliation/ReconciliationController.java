package cn.ucaner.alpaca.pay.controller.reconciliation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ucaner.alpaca.pay.common.dwz.DWZ;
import cn.ucaner.alpaca.pay.common.dwz.DwzAjax;
import cn.ucaner.alpaca.pay.common.enums.PayWayEnum;
import cn.ucaner.alpaca.pay.common.exception.BizException;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckBatch;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistake;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistakeScratchPool;
import cn.ucaner.alpaca.pay.reconciliation.enums.MistakeHandleStatusEnum;
import cn.ucaner.alpaca.pay.reconciliation.enums.ReconciliationMistakeTypeEnum;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckBatchService;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckMistakeScratchPoolService;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckMistakeService;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckTransactionService;
import cn.ucaner.alpaca.pay.trade.enums.TradeStatusEnum;

/**
* @Package：cn.ucner.alpaca.pay.controller.reconciliation   
* @ClassName：ReconciliationController   
* @Description：   <p> 对账控制器. </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:28:55   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping("/reconciliation")
public class ReconciliationController {

	private static final Log log = LogFactory.getLog(ReconciliationController.class);

	@Autowired
	private RpAccountCheckBatchService rpAccountCheckBatchService;

	@Autowired
	private RpAccountCheckTransactionService rpAccountCheckTransactionService;

	@Autowired
	private RpAccountCheckMistakeService rpAccountCheckMistakeService;

	@Autowired
	private RpAccountCheckMistakeScratchPoolService rpAccountCheckMistakeScratchPoolService;

	/**
	 * 展示对账批次信息
	 * 
	 * @param pageParam
	 * @param checkbatch
	 * @param model
	 * @return
	 */
	@RequiresPermissions("recon:batch:view")
	@RequestMapping(value = "/list/checkbatch")
	public String listCheckbatch(PageParam pageParam, RpAccountCheckBatch checkbatch, Model model, String billDay) {
		try {
			// 对账批次分页列表
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("billDate", billDay);
			PageBean pageBean = rpAccountCheckBatchService.listPage(pageParam, paramMap);
			model.addAttribute("pageBean", pageBean);
			model.addAttribute("pageParam", pageParam);
			model.addAttribute("billDay", billDay);

		} catch (Exception e) {
			log.error(e);
			// 不是以form的形式提交的数据,要new一个DwzAjax对象
			DwzAjax dwz = new DwzAjax();
			dwz.setStatusCode(DWZ.ERROR);
			dwz.setMessage("对账批次信息分页列表异常，请通知系统管理员！");
			model.addAttribute("dwz", dwz);
			return "common/ajaxDone";
		}
		return "reconciliation/batch/list";
	}

	/**
	 * 展示对账差错信息
	 * 
	 * @param pageParam
	 * @param checkbatch
	 * @param model
	 * @return
	 */
	@RequiresPermissions("recon:mistake:view")
	@RequestMapping(value = "/list/mistake")
	public String listMistake(PageParam pageParam, RpAccountCheckMistake mistake, String billBeginDate, String billEndDate, Model model) {
		try {
			// 对账差错分页列表
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("beginDate", billBeginDate);
			paramMap.put("endDate", billEndDate);

			PageBean pageBean = rpAccountCheckMistakeService.listPage(pageParam, paramMap);
			model.addAttribute("billBeginDate", billBeginDate);
			model.addAttribute("billEndDate", billEndDate);
			model.addAttribute("pageBean", pageBean);
			model.addAttribute("pageParam", pageParam);
			model.addAttribute("tradeStatusEnums", TradeStatusEnum.toList());
			model.addAttribute("payWayEnums", PayWayEnum.toList());
			model.addAttribute("mistakeHandleStatusEnums", MistakeHandleStatusEnum.toList());
			model.addAttribute("reconciliationMistakeTypeEnums", ReconciliationMistakeTypeEnum.toList());

		} catch (Exception e) {
			log.error(e);
			// 不是以form的形式提交的数据,要new一个DwzAjax对象
			DwzAjax dwz = new DwzAjax();
			dwz.setStatusCode(DWZ.ERROR);
			dwz.setMessage("对账差错信息分页列表异常，请通知系统管理员！");
			model.addAttribute("dwz", dwz);
			return "common/ajaxDone";
		}
		return "reconciliation/mistake/list";
	}

	/**
	 * 展示对账缓冲池信息
	 * 
	 * @param pageParam
	 * @param checkbatch
	 * @param model
	 * @return
	 */
	@RequiresPermissions("recon:scratchPool:view")
	@RequestMapping(value = "/list/scratchPool")
	public String listScratchPool(PageParam pageParam, RpAccountCheckMistakeScratchPool scratchRecord, Model model) {
		try {
			// 对账缓冲池信息分页列表
			PageBean pageBean = rpAccountCheckMistakeScratchPoolService.listPage(pageParam, scratchRecord);

			model.addAttribute("pageBean", pageBean);
			model.addAttribute("pageParam", pageParam);

		} catch (Exception e) {
			log.error(e);
			// 不是以form的形式提交的数据,要new一个DwzAjax对象
			DwzAjax dwz = new DwzAjax();
			dwz.setStatusCode(DWZ.ERROR);
			dwz.setMessage("对账差错信息分页列表异常，请通知系统管理员！");
			model.addAttribute("dwz", dwz);
			return "common/ajaxDone";
		}
		return "reconciliation/scratchPool/list";
	}

	/**
	 * 展示对账差错信息
	 * 
	 * @param pageParam
	 * @param checkbatch
	 * @param model
	 * @return
	 */
	@RequiresPermissions("recon:mistake:view")
	@RequestMapping(value = "/mistake/tohandlePage")
	public String toHandlePage(Model model, HttpServletRequest request, @RequestParam("id") String id) {
		RpAccountCheckMistake mistake = rpAccountCheckMistakeService.getDataById(id);
		model.addAttribute("mistake", mistake);
		model.addAttribute("reconciliationMistakeTypeEnums", ReconciliationMistakeTypeEnum.toList());
		model.addAttribute("tradeStatusEnums", TradeStatusEnum.toList());
		return "reconciliation/mistake/handlePage";
	}

	/**
	 * 差错处理方法
	 * 
	 * @param dwz
	 * @param model
	 * @param request
	 * @param id
	 *            差错id
	 * @param handleType
	 *            处理类型(平台认账、银行认账)
	 * @param handleRemark
	 *            处理备注
	 * @return
	 */
	@RequiresPermissions("recon:mistake:edit")
	@RequestMapping(value = "/mistake/handle")
	public String handleMistake(DwzAjax dwz, Model model, HttpServletRequest request, @RequestParam("id") String id, @RequestParam("handleType") String handleType, @RequestParam("handleRemark") String handleRemark) {
		try {
			// 进行差错处理
			rpAccountCheckTransactionService.handle(id, handleType, handleRemark);
		} catch (BizException e) {
			log.error(e);
			dwz.setStatusCode(DWZ.ERROR);
			dwz.setMessage(e.getMsg());
			model.addAttribute("dwz", dwz);
			return "common/ajaxDone";
		} catch (Exception e) {
			log.error(e);
			dwz.setStatusCode(DWZ.ERROR);
			dwz.setMessage("对账差错处理异常，请通知系统管理员！");
			model.addAttribute("dwz", dwz);
			return "common/ajaxDone";
		}
		dwz.setStatusCode(DWZ.SUCCESS);
		dwz.setMessage("操作成功！");
		model.addAttribute("dwz", dwz);
		return "common/ajaxDone";
	}
}
