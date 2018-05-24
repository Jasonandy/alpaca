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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
* @Package：cn.ucaner.common.excel   
* @ClassName：ExcelLogs   
* @Description：   <p> ExcelLogs</p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 下午2:34:25   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class ExcelLogs {
    private Boolean hasError;
    private List<ExcelLog> logList;

    public ExcelLogs() {
        super();
        hasError = false;
    }

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }
    public List<ExcelLog> getLogList() {
        return logList;
    }

    public List<ExcelLog> getErrorLogList() {
        List<ExcelLog> errList = new ArrayList<>();
        for (ExcelLog log : this.logList) {
            if (log != null && StringUtils.isNotBlank(log.getLog())) {
                errList.add(log);
            }
        }
        return errList;
    }

    public void setLogList(List<ExcelLog> logList) {
        this.logList = logList;
    }

}
