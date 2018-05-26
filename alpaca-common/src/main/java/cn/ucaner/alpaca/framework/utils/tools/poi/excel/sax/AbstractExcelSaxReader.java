package cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax;

import java.io.File;
import java.io.InputStream;

import cn.ucaner.alpaca.framework.utils.tools.core.io.FileUtil;
import cn.ucaner.alpaca.framework.utils.tools.poi.exceptions.POIException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax   
* @ClassName：AbstractExcelSaxReader   
* @Description：   <p> 抽象的Sax方式Excel读取器，提供一些共用方法 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:38:32   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractExcelSaxReader<T> implements ExcelSaxReader<T> {
	
	@Override
	public T read(String path) throws POIException {
		return read(FileUtil.file(path));
	}

	@Override
	public T read(File file) throws POIException {
		return read(file, -1);
	}

	@Override
	public T read(InputStream in) throws POIException {
		return read(in, -1);
	}

	@Override
	public T read(String path, int sheetIndex) throws POIException {
		return read(FileUtil.file(path), sheetIndex);
	}
}
