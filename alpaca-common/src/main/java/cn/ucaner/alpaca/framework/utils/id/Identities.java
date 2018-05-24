/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.ucaner.alpaca.framework.utils.id;

import java.security.SecureRandom;
import java.util.UUID;

import cn.ucaner.alpaca.framework.utils.encode.EncodeUtils;

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
        return EncodeUtils.encodeBase62(randomBytes);
    }
}
