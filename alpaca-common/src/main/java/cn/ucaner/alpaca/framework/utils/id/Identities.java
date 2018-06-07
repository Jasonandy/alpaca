/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.ucaner.alpaca.framework.utils.id;

import java.security.SecureRandom;
import java.util.UUID;

/**
* @Package：cn.ucaner.framework.utils   
* @ClassName：Identities   
* @Description：   <p> 唯一ID生产工具类</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午2:12:43   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class Identities {
    
    private static SecureRandom random = new SecureRandom();
    
    private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    
    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }
    
    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid2() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }
    
    /**
     * 基于Base62编码的SecureRandom随机生成bytes.
     */
    public static String randomBase62(int length) {
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return encodeBase62(randomBytes);
    }
    
    /**
     * @Description: 加码器 Base64
     * @param input
     * @return String
     * @Autor: Jason - jasonandy@hotmail.com
     */
    public static String encodeBase62(byte[] input) {
		char[] chars = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			chars[i] = BASE62[ ( input[i] & 0xFF ) % BASE62.length];
		}
		return new String(chars);
	}
    
    public static void main(String[] args) {
    	System.out.println(Identities.uuid());
    	System.out.println(Identities.uuid2());
    	System.out.println(randomLong());
    	System.out.println(randomBase62(18));
	}
}
//Outputs
//a1863aa6-a600-4cc4-86e2-1555a85b2694
//65343b01c06840329a3f733ff71d23f1
//4711238897727653840
//RhcM03ErBS7MNqvNFn
