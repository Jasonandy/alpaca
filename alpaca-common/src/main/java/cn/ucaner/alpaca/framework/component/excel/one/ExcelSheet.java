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
package cn.ucaner.alpaca.framework.component.excel.one;

import java.util.Collection;
import java.util.Map;

/**
* @Package：cn.ucaner.common.excel   
* @ClassName：ExcelSheet   
* @Description：   <p> 用于汇出多个sheet的Vo The <code>ExcelSheet</code> </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 下午2:34:38   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class ExcelSheet<T> {
    private String sheetName;
    private Map<String,String> headers;
    private Collection<T> dataset;

    /**
     * @return the sheetName
     */
    public String getSheetName() {
        return sheetName;
    }

    /**
     * Excel页签名称
     * 
     * @param sheetName
     *            the sheetName to set
     */
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * Excel表头
     * 
     * @return the headers
     */
    public Map<String,String> getHeaders() {
        return headers;
    }

    /**
     * @param headers
     *            the headers to set
     */
    public void setHeaders(Map<String,String> headers) {
        this.headers = headers;
    }

    /**
     * Excel数据集合
     * 
     * @return the dataset
     */
    public Collection<T> getDataset() {
        return dataset;
    }

    /**
     * @param dataset
     *            the dataset to set
     */
    public void setDataset(Collection<T> dataset) {
        this.dataset = dataset;
    }

}
