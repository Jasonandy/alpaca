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
package cn.ucaner.alpaca.framework.utils.chinese;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
* @Package：cn.ucaner.framework.utils   
* @ClassName：PinyinUtils   
* @Description：   <p> 中文转换拼音工具</p>
* @Author： -  
* @CreatTime：2017年8月30日 下午2:09:07   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class PinyinUtils {
	
	/** 
	 * 获取汉字串拼音首字母,英文字符不变 
	 * @param chinese 汉字串 
	 * @return 汉语拼音首字母 
	 */
	public static String getChineseFirstWord(String chinese) {
		StringBuffer pybf = new StringBuffer();
		char[] arr = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 128) {
				try {
					String[] word = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
					if (word != null) {
						pybf.append(word[0].charAt(0));
					}
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pybf.append(arr[i]);
			}
		}
		return pybf.toString().replaceAll("\\W", "").trim();
	}

	/** 
	 * 获取汉字串拼音，英文字符不变 
	 * @param chinese 汉字串 
	 * @return 汉语拼音 
	 */
	public static String getChineseAllWord(String chinese) {
		StringBuffer pybf = new StringBuffer();
		char[] arr = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 128) {
				try {
					pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pybf.append(arr[i]);
			}
		}
		return pybf.toString();
	}
	
	/**
	 * For Test By Jason
	 */
	public static void main(String[] args) {
		//issue: 不能空格  woaizhongguo! byJson
		System.out.println(getChineseAllWord("我爱中国! byJson"));
		System.out.println(getChineseFirstWord("我爱中国! byJson"));//wazgbyJson
	}
}
