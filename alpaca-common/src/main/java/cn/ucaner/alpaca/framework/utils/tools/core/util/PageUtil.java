/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.utils.tools.core.util;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.util   
* @ClassName：PageUtil   
* @Description：   <p> 分页工具类 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午12:56:31   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class PageUtil {
	
	/**
	 * 将页数和每页条目数转换为开始位置和结束位置<br>
	 * 此方法用于不包括结束位置的分页方法<br>
	 * 例如：<br>
	 * 页码：1，每页10 =》 [0, 10]<br>
	 * 页码：2，每页10 =》 [10, 20]<br>
	 * 。。。<br>
	 * 
	 * @param pageNo 页码（从1计数）
	 * @param countPerPage 每页条目数
	 * @return 第一个数为开始位置，第二个数为结束位置
	 */
	public static int[] transToStartEnd(int pageNo, int countPerPage) {
		if (pageNo < 1) {
			pageNo = 1;
		}

		if (countPerPage < 1) {
			countPerPage = 0;
		}

		int start = (pageNo - 1) * countPerPage;
		int end = start + countPerPage;

		return new int[] { start, end };
	}

	/**
	 * 根据总数计算总页数
	 * 
	 * @param totalCount 总数
	 * @param numPerPage 每页数
	 * @return 总页数
	 */
	public static int totalPage(int totalCount, int numPerPage) {
		if (numPerPage == 0) {
			return 0;
		}
		return totalCount % numPerPage == 0 ? (totalCount / numPerPage) : (totalCount / numPerPage + 1);
	}
}
