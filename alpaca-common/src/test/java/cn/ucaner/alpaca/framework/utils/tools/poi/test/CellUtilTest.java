package cn.ucaner.alpaca.framework.utils.tools.poi.test;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.junit.Ignore;
import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.core.lang.Console;

public class CellUtilTest {
	
	@Test
	@Ignore
	public void isDateTest() {
		String[] all = BuiltinFormats.getAll();
		for(int i = 0 ; i < all.length; i++) {
			Console.log("{} {}", i, all[i]);
		}
	}
}
