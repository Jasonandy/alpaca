package cn.ucaner.alpaca.pay.user.entity;

import java.io.Serializable;

import cn.ucaner.alpaca.pay.common.core.entity.BaseEntity;

/**
* @Package：cn.ucaner.alpaca.pay.user.entity   
* @ClassName：SeqBuild   
* @Description：   <p> 此实体没有关联的表，只作用于序列查找时传参使用 </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:45:57   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class SeqBuild extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 序列名称 **/
	private String seqName;

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

}