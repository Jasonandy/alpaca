package cn.ucaner.alpaca.pay.common.page;

import java.io.Serializable;

/**
* @Package：cn.ucaner.alpaca.pay.common.core.page   
* @ClassName：PageParam   
* @Description：   <p> 分页参数传递工具类 .</p>
* @Author： - jason   
* @CreatTime：2018年5月10日 下午9:51:25   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class PageParam implements Serializable {

    private static final long serialVersionUID = 6297178964005032338L;

    /**
     * 默认为第一页.
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 默认每页记录数(15).
     */
    public static final int DEFAULT_NUM_PER_PAGE = 15;

    /**
     * 最大每页记录数(100).
     */
    public static final int MAX_PAGE_SIZE = 100;

    private int pageNum = DEFAULT_PAGE_NUM; // 当前页数

    private int numPerPage; // 每页记录数

    /**
     * 默认构造函数
     */
    public PageParam(){}

    /**
     * 带参数的构造函数
     * @param pageNum
     * @param numPerPage
     */
    public PageParam(int pageNum , int numPerPage){
    	this.pageNum = pageNum;
    	this.numPerPage = numPerPage;
    }

    /** 当前页数 */
    public int getPageNum() {
        return pageNum;
    }

    /** 当前页数 */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /** 每页记录数 */
    public int getNumPerPage() {
        return numPerPage > 0 ? numPerPage : DEFAULT_NUM_PER_PAGE;
    }

    /** 每页记录数 */
    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

}
