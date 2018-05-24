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
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.ucaner.alpaca.framework.component.excel.one.ExcelUtil;

/**
* @Package：cn.ucaner.common.excel.one.test   
* @ClassName：TestExportBean   
* @Description：   <p> 测试到处bean </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 下午2:40:29   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class TestExportBean {
    public static void main(String[] args) throws IOException {
        
        //String[] headers = {"a","b","c"};
        //用排序的Map且Map的键赢与ExcelCell注解的index对应
        Map<String,String> map1 = new LinkedHashMap<>();
        map1.put("a","姓名");
        map1.put("b","年龄");
        map1.put("c","性别");
        map1.put("d","出生日期");
        Collection<Object> dataset=new ArrayList<Object>();
        dataset.add(new Model("", "", "",null));
        dataset.add(new Model(null, null, null,null));
        dataset.add(new Model("王五", "34", "男",new Date()));
        File f=new File("D:/test.xls");
        OutputStream out =new FileOutputStream(f);
        ExcelUtil.exportExcel(map1, dataset, out);
        out.close();
    }
}
