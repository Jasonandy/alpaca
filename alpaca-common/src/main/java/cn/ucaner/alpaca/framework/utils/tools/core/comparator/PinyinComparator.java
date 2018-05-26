package cn.ucaner.alpaca.framework.utils.tools.core.comparator;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.comparator   
* @ClassName：PinyinComparator   
* @Description：   <p> 按照GBK拼音顺序对给定的汉字字符串排序 </p>
* @Author： -    
* @CreatTime：2018年5月26日 上午10:35:23   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class PinyinComparator implements Comparator<String> {

	final Collator collator;

	/**
	 * 构造
	 */
	public PinyinComparator() {
		collator = Collator.getInstance(Locale.CHINESE);
	}

	@Override
	public int compare(String o1, String o2) {
		return collator.compare(o1, o2);
	}

}
