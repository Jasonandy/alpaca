/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JasonInternational Ucanx</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.utils.id;

import java.util.UUID;

/**
* @Package：cn.ucaner.common   
* @ClassName：PKGenerator   
* @Description：   <p> 主键ID 生成器</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午2:33:44   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class PKGenerator {
	
	
	/**
	 * 生成数据库主键ID值
	 * @return
	 */
	public static String generateId() {
		String s = UUID.randomUUID().toString();
		return s.replaceAll("-", "");
	}

	
	public static void main(String[] args) {
		for (int i = 0; i < 13; i++) {
			System.out.println(generateId());
		}
	}
	
}
