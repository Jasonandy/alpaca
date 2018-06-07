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
//Outputs
//b23d6732676a46d9bf4d572e466c1fb8
//d385ed22466e45e3840e5361e3701b09
//c6ba882e317947e793ac8ad3f0a73134
//1133868292f743a18682e6d3d2a33890
//2c4877a35e1d42778b2c74b02461293d
//62dfd30cb2634a189f98f304fcf99aec
//6f1f362a84b548b18ef37f33644af3b7
//19d25f0cda5d462385e023cb62b8656d
//b6c7177a13b74e50bafd912e337e7850
//bbd4fe98fe764fc390a105c0507556e0
//b5c6c66f17d24488ab1b430cc1877608