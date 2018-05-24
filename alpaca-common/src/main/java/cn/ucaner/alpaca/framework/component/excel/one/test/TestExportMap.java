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
package cn.ucaner.alpaca.framework.component.excel.one.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.ucaner.alpaca.framework.component.excel.one.ExcelUtil;

/**
* @Package：cn.ucaner.common.excel.one.test   
* @ClassName：TestExportMap   
* @Description：   <p> TestExportMap </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 下午2:41:14   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class TestExportMap {
	
  public static void main(String[] args) throws IOException {
    List<Map<String,Object>> list = new ArrayList<>();
    Map<String,Object> map =new LinkedHashMap<>();
    map.put("name", "");
    map.put("age", "");
    map.put("birthday","");
    map.put("sex","");
    Map<String,Object> map2 =new LinkedHashMap<String, Object>();
    map2.put("name", "测试是否是中文长度不能自动宽度.测试是否是中文长度不能自动宽度.");
    map2.put("age", null);
    map2.put("sex", null);
    map.put("birthday",null);
    Map<String,Object> map3 =new LinkedHashMap<String, Object>();
    map3.put("name", "张三");
    map3.put("age", 12);
    map3.put("sex", "男");
    map3.put("birthday",new Date());
    list.add(map);
    list.add(map2);
    list.add(map3);
    Map<String,String> map1 = new LinkedHashMap<>();
    map1.put("name","姓名");
    map1.put("age","年龄");
    map1.put("birthday","出生日期");
    map1.put("sex","性别");
    File f= new File("D:/test.xls");
    OutputStream out = new FileOutputStream(f);
    ExcelUtil.exportExcel(map1,list, out );
    out.close();
  }
}
