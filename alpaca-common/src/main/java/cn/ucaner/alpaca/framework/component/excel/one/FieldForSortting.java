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

import java.lang.reflect.Field;


/**
* @Package：cn.ucaner.common.excel   
* @ClassName：FieldForSortting   
* @Description：   <p> FieldForSortting </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 下午2:36:01   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class FieldForSortting {
	
    private Field field;
    
    private int index;

    public FieldForSortting(Field field) {
        super();
        this.field = field;
    }

    public FieldForSortting(Field field, int index) {
        super();
        this.field = field;
        this.index = index;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
