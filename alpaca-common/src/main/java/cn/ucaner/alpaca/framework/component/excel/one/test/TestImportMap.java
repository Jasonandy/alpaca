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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import cn.ucaner.alpaca.framework.component.excel.one.ExcelLogs;
import cn.ucaner.alpaca.framework.component.excel.one.ExcelUtil;

/**
* @Package：cn.ucaner.common.excel.one.test   
* @ClassName：TestImportMap   
* @Description：   <p> 测试导入Map</p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 下午2:41:49   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class TestImportMap {
	
  @SuppressWarnings("rawtypes")
  public static void main(String[] args) throws FileNotFoundException {
    File f=new File("/aa/bb/test.xls");
    InputStream inputStream= new FileInputStream(f);
    ExcelLogs logs =new ExcelLogs();
    Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs , 0);
    for(Map m : importExcel){
      System.out.println(m);
    }
  }
}
