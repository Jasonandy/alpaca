package cn.ucaner.alpaca.framework.utils.tools.poi;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.DependencyException;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ClassLoaderUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.poi   
* @ClassName：PoiChecker   
* @Description：   <p> POI引入检查器 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:42:25   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class PoiChecker {
	
	/**
	 * 检查POI包的引入情况
	 */
	public static void checkPoiImport() {
		try {
			Class.forName("org.apache.poi.ss.usermodel.Workbook", false, ClassLoaderUtil.getClassLoader());
		} catch (ClassNotFoundException | NoClassDefFoundError e) {
			throw new DependencyException(e, "You need to add POI dependency 'poi-ooxml' to your project, and version >= 3.17");
		}
	}
	
	/**
	 * 当对应的包或类未找到时，抛出指定异常
	 */
	public static DependencyException transError(NoClassDefFoundError e) {
		switch (e.getMessage()) {
		case "org/apache/poi/ss/usermodel/Workbook":
			return new DependencyException(e, "You need to add POI dependency 'poi-ooxml' to your project, and version >= 3.17");
		case "org/apache/poi/poifs/filesystem/FileMagic":
			return new DependencyException(e, "You need to add POI dependency 'poi-ooxml' to your project, and version >= 3.17");

		default:
			return new DependencyException(e);
		}
	}
}
