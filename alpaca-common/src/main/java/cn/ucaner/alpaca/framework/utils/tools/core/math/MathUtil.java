package cn.ucaner.alpaca.framework.utils.tools.core.math;

import java.util.List;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.math   
* @ClassName：MathUtil   
* @Description：   <p> 数学相关方法工具类 </p>
* 此工具类与{@link cn.ucaner.alpaca.framework.utils.tools.core.util.NumberUtil}属于一类工具，NumberUtil偏向于简单数学计算的封装，MathUtil偏向复杂数学计算
* @Author： - wubin   
* @CreatTime：2018年5月26日 上午12:03:11   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class MathUtil {

	//--------------------------------------------------------------------------------------------- Arrangement
	/**
	 * 计算排列数，即A(n, m) = n!/(n-m)!
	 * 
	 * @param n 总数
	 * @param m 选择的个数
	 * @return 排列数
	 */
	public static long arrangementCount(int n, int m) {
		return Arrangement.count(n, m);
	}
	
	/**
	 * 计算排列数，即A(n, n) = n!
	 * 
	 * @param n 总数
	 * @return 排列数
	 */
	public static long arrangementCount(int n) {
		return Arrangement.count(n);
	}

	/**
	 * 排列选择（从列表中选择n个排列）
	 * 
	 * @param datas 待选列表
	 * @param m 选择个数
	 * @return 所有排列列表
	 */
	public static List<String[]> arrangementSelect(String[] datas, int m) {
		return new Arrangement(datas).select(m);
	}
	
	/**
	 * 全排列选择（列表全部参与排列）
	 * 
	 * @param datas 待选列表
	 * @return 所有排列列表
	 */
	public static List<String[]> arrangementSelect(String[] datas) {
		return new Arrangement(datas).select();
	}
	
	//--------------------------------------------------------------------------------------------- Combination
	/**
	 * 计算组合数，即C(n, m) = n!/((n-m)! * m!)
	 * 
	 * @param n 总数
	 * @param m 选择的个数
	 * @return 组合数
	 */
	public static long combinationCount(int n, int m) {
		return Combination.count(n, m);
	}

	/**
	 * 组合选择（从列表中选择n个组合）
	 * 
	 * @param datas 待选列表
	 * @param m 选择个数
	 * @return 所有组合列表
	 */
	public static List<String[]> combinationSelect(String[] datas, int m) {
		return new Combination(datas).select(m);
	}
}
