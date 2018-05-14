package cn.ucaner.alpaca.pay.reconciliation.fileDown;

import java.io.Serializable;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.fileDown   
* @ClassName：FileDownResult   
* @Description：   <p> 微信文件下载返回结果实体</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:34:48   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class FileDownResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9154198958690896977L;

	/**
	 * 文件编码
	 */
	private String fileCharSet = "UTF-8";

	/**
	 * 文件内容
	 */
	private String fileContent;

	/**
	 * 文件是否由平台生成
	 */
	private boolean isPlatBuild = true;

	public String getFileCharSet() {
		return fileCharSet;
	}

	public void setFileCharSet(String fileCharSet) {
		this.fileCharSet = fileCharSet;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public boolean isPlatBuild() {
		return isPlatBuild;
	}

	public void setPlatBuild(boolean isPlatBuild) {
		this.isPlatBuild = isPlatBuild;
	}

}
