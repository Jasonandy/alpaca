package cn.ucaner.alpaca.pay.common.core.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;


/**
* @Package：cn.ucaner.alpaca.pay.common.core.entity   
* @ClassName：ApiPageListResultVo   
* @Description：   <p> API请求,返回分页数据时,统一实体类,将返回的数据统一封装到该实体中,返回给客户端</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午9:59:31   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class ApiPageListResultVo {

    /**
     * 返回码
     */
    private int code;

    /**
     *  返回描述
     */
    private String msg = "";

    /**
     *  返回分页数据,默认为0页0条
     */
    private PageListVO data = new PageListVO(0,0,0,new ArrayList<rpObject>());

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(PageListVO data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public PageListVO getData() {
        return data;
    }



    public static  void main(String [] args ){

        ApiPageListResultVo apiPageListResultVo = new ApiPageListResultVo();
        apiPageListResultVo.setCode(-1);
        apiPageListResultVo.setMsg("测试数据");

        PageListVO pageListVO = new PageListVO(0,2,33,new ArrayList<Object>());

        apiPageListResultVo.setData(pageListVO);

        System.out.println(JSONObject.toJSONString(apiPageListResultVo));
    }

}
