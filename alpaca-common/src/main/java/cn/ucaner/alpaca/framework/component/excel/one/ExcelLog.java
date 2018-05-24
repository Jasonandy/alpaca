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

/**
* @Package：cn.ucaner.common.excel   
* @ClassName：ExcelLog   
* @Description：   <p> ExcelLog</p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 下午2:34:14   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class ExcelLog {
	
    private Integer rowNum;
    private Object object;
    private String log;

    /**
     * @return the rowNum
     */
    public Integer getRowNum() {
        return rowNum;
    }

    /**
     * @param rowNum
     *            the rowNum to set
     */
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    /**
     * @return the object
     */
    public Object getObject() {
        return object;
    }

    /**
     * @param object
     *            the object to set
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * @return the log
     */
    public String getLog() {
        return log;
    }

    /**
     * @param object
     * @param log
     */
    public ExcelLog(Object object, String log) {
        super();
        this.object = object;
        this.log = log;
    }

    /**
     * @param rowNum
     * @param object
     * @param log
     */
    public ExcelLog(Object object, String log, Integer rowNum) {
        super();
        this.rowNum = rowNum;
        this.object = object;
        this.log = log;
    }

    /**
     * @param log
     *            the log to set
     */
    public void setLog(String log) {
        this.log = log;
    }

}
