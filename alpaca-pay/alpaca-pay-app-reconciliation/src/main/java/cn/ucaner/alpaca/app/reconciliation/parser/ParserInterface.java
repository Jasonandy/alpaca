package cn.ucaner.alpaca.app.reconciliation.parser;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckBatch;
import cn.ucaner.alpaca.pay.reconciliation.vo.ReconciliationEntityVo;

/**
* @Package：cn.ucaner.alpaca.app.reconciliation.parser   
* @ClassName：ParserInterface   
* @Description：   <p> 定义一个解析的接口，实现着必须override接口中的parser方法.</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:50:47   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public interface ParserInterface {

	/**
	 * 
	 * @param file
	 * @param billDate
	 * @param batch
	 * @return
	 * @throws IOException 
	 */
	public List<ReconciliationEntityVo> parser(File file, Date billDate, RpAccountCheckBatch batch) throws IOException;

}
