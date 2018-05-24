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
package cn.ucaner.alpaca.framework.utils.date;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
* @Package：cn.ucaner.framework.utils   
* @ClassName：UT   
* @Description：   <p> 时间工具</p>
* @Author： - Jason
* @CreatTime：2017年8月30日 下午2:06:05   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class UT {

	public UT() {
	}

	public static String getTimeStamp() {
		Calendar ca = Calendar.getInstance();
		return ca.get(1) + "-" + (ca.get(2) + 1) + "-" + ca.get(5) + " " + ca.get(11) + ":" + ca.get(12) + ":" + ca.get(13);
	}

	public static String getSysDate() {
		Calendar dt = Calendar.getInstance();
		String strYear = dt.get(1) + "";
		int iTmp = dt.get(2) + 1;
		String strMonth = iTmp + "";
		String strDay = dt.get(5) + "";
		return dateFormat(strYear, strMonth, strDay);
	}

	public static String getSysTime() {
		Calendar dt = Calendar.getInstance();
		String hour = dt.get(11) + "";
		String second = dt.get(13) + "";
		String minute = dt.get(12) + "";
		if (hour.length() == 1)
			hour = "0" + hour;
		if (minute.length() == 1)
			minute = "0" + minute;
		if (second.length() == 1)
			second = "0" + second;
		return hour + minute + second;
	}

	public static int getSecond() {
		Calendar ca = Calendar.getInstance();
		return ca.get(13);
	}

	public static int getMilliSecond() {
		Calendar ca = Calendar.getInstance();
		return ca.get(14);
	}

	public static long getMilliSend(String datetime) {
		long ret;
		try {
			Date d = toDate(datetime, "yyyymmddhhmmss");
			ret = d.getTime();
		} catch (ParseException er) {
			er.printStackTrace();
			return 0L;
		}
		return ret;
	}

	public static boolean isNull(Object obj) {
		if (obj == null) {
			System.out.println("\u4E32\u4E3A\u7A7A!");
			return false;
		} else {
			return true;
		}
	}

	public static boolean isDigital(String strInput) {
		for (int i = 0; i < strInput.length(); i++)
			if (strInput.charAt(i) > '9' || strInput.charAt(i) < '0')
				return false;

		return true;
	}

	public static boolean isInt(String strInput) {
		try {
			Integer.parseInt(strInput);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isFloat(String strInput) {
		try {
			(new Double(strInput)).doubleValue();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isTime(String strInput) {
		try {
			(new Double(strInput)).doubleValue();
			int i = Integer.parseInt(strInput);
			return !((i < 0) | (i > 0x399b7));
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isDate(String strInput) {
		String fmt = "";
		if (strInput == null) {
			System.out.println("\u65E5\u671F\u6821\u9A8C\u65F6,\u8F93\u5165\u53C2\u6570\u4E3Anull");
			return false;
		}
		strInput = strInput.trim();
		if (strInput.equals("")) {
			System.out.println("\u65E5\u671F\u6821\u9A8C\u65F6,\u8F93\u5165\u53C2\u6570\u4E3Anull");
			return false;
		}
		if (strInput.indexOf("-") < 0)
			strInput = dateFormat(strInput, "yyyy-mm-dd");
		String dd[] = strSplit(strInput, "-");
		for (int i = 0; i < dd[0].length(); i++)
			fmt = fmt + "y";

		fmt = fmt + "-";
		for (int i = 0; i < dd[1].length(); i++)
			fmt = fmt + "M";

		fmt = fmt + "-";
		for (int i = 0; i < dd[2].length(); i++)
			fmt = fmt + "d";

		try {
			SimpleDateFormat fdt = new SimpleDateFormat(fmt);
			Date dt = fdt.parse(strInput);
			String tmp = fdt.format(dt);
			if (tmp.equals(strInput))
				return isDateValid(dd[0] + dd[1] + dd[2], 0, 3000);
			else
				return false;
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean IsDateFormat(String strInput, String strType) {
		strType = strType.trim();
		strInput = strInput.trim();
		if (strType.length() != strInput.length()) {
			System.out.println("\u65E5\u671F" + strInput + "\u7684\u957F\u5EA6\u5E94\u4E0E\u7C7B\u578B" + strType + "\u957F\u5EA6\u76F8\u7B49!");
			return false;
		}
		String strYear = "";
		String strMonth = "";
		String strDay = "";
		String strTmp = strType.toLowerCase();
		int iIndex = strTmp.indexOf("yyyy");
		if (iIndex == -1) {
			iIndex = strTmp.indexOf("yy");
			strYear = "19" + strInput.substring(iIndex, iIndex + 2);
		} else {
			strYear = strYear + strInput.substring(iIndex, iIndex + 4);
		}
		iIndex = strTmp.indexOf("mm");
		if (iIndex != -1)
			strMonth = strMonth + strInput.substring(iIndex, iIndex + 2);
		iIndex = strTmp.indexOf("dd");
		if (iIndex != -1)
			strDay = strDay + strInput.substring(iIndex, iIndex + 2);
		return isDateValid(strYear + strMonth + strDay, 0, 3000);
	}

	private static boolean isDateValid(String strInput, int startYear, int endYear) {
		if (!isNull(strInput))
			return false;
		strInput = strInput.trim();
		int iLen = strInput.length();
		if (iLen != 8) {
			System.out.println("\u65E5\u671F" + strInput + "\u957F\u5EA6\u5E94\u4E3A8\u4F4D,\u598219991012");
			return false;
		}
		if (!isDigital(strInput)) {
			System.out.println("\u65E5\u671F" + strInput + "\u5E94\u4E3A\u6570\u5B57\u7C7B\u578B,\u598219991012");
			return false;
		}
		String strTmp = strInput.substring(0, 4);
		int iYear = Integer.parseInt(strTmp);
		if (iYear > endYear || iYear < startYear) {
			System.out.println("\u65E5\u671F" + strInput + "\u4E2D\u5E74\u7684\u8303\u56F4\u5E94\u8BE5\u5728" + startYear + "-" + endYear + "\u4E4B\u95F4!");
			return false;
		}
		strTmp = strInput.substring(4, 6);
		int iMonth = Integer.parseInt(strTmp);
		if (iMonth > 13 || iMonth < 1) {
			System.out.println("\u65E5\u671F" + strInput + "\u4E2D\u6708\u7684\u8303\u56F4\u5E94\u8BE5\u57281-12\u4E4B\u95F4!");
			return false;
		}
		strTmp = strInput.substring(6, 8);
		int iDay = Integer.parseInt(strTmp);
		switch (iMonth) {
			case 4 : // '\004'
			case 6 : // '\006'
			case 9 : // '\t'
			case 11 : // '\013'
				if (iDay > 30) {
					System.out.println("\u65E5\u671F" + strInput + "\u4E2D" + iMonth + "\u6708\u53EA\u670930\u5929!");
					return false;
				}
				break;

			case 2 : // '\002'
				if (iYear % 400 == 0 || iYear % 100 != 0 && iYear % 4 == 0) {
					if (iDay > 29) {
						System.out.println("\u65E5\u671F" + strInput + "\u4E2D" + iMonth + "\u6708\u6700\u591A\u53EA\u670929\u5929!");
						return false;
					}
				} else if (iDay > 28) {
					System.out.println("\u65E5\u671F" + strInput + "\u4E2D" + iMonth + "\u6708\u6700\u591A\u53EA\u670928\u5929!");
					return false;
				}
				break;
		}
		if (iDay > 31 || iDay < 1) {
			System.out.println("\u65E5\u671F" + strInput + "\u4E2D\u65E5\u7684\u8303\u56F4\u5E94\u8BE5\u57281-31\u4E4B\u95F4!");
			return false;
		} else {
			return true;
		}
	}

	public static String strAddChar(String str, String spec, String add) {
		String ret = "";
		String tmp[] = strSplit(str, spec);
		for (int i = 0; i < tmp.length; i++)
			ret = ret + spec + add + tmp[i] + add;

		return ret.substring(spec.length());
	}

	public static String strAlign(char type, int len, String str, char fillChar) {
		int i = len - str.length();
		String tmp = new String();
		if (i <= 0) {
			switch (type) {
				case 76 : // 'L'
					str = str.substring(0, len);
					break;

				case 77 : // 'M'
					str = str.substring(-i / 2, len);
					break;

				case 82 : // 'R'
					str = str.substring(-i);
					break;
			}
		} else {
			for (int j = i; j-- > 0;)
				tmp = tmp + fillChar;

			switch (type) {
				case 76 : // 'L'
					str = str + tmp;
					break;

				case 77 : // 'M'
					str = tmp.substring(0, i / 2) + str + tmp.substring(0, i / 2 + i % 2);
					break;

				case 82 : // 'R'
					str = tmp + str;
					break;
			}
		}
		return str;
	}

	public static String strFilter(String strSource, String strFilter) {
		return strReplace(strSource, strFilter, "");
	}

	public static String strReplace(String str, String str1, String str2) {
		String ret = "";
		if (str == null)
			return "";
		int i;
		while ((i = str.indexOf(str1)) >= 0) {
			ret = ret + str.substring(0, i) + str2;
			str = str.substring(i + str1.length());
		}
		ret = ret + str;
		return ret;
	}

	public static String strReplaceAt(String str, int num, char c) {
		String head = str.substring(0, num);
		String tail = str.substring(num + 1);
		return head + c + tail;
	}

	public static String[] strSplit(String strSource, String delimiter) {
		String str = null;
		int intPos = 0;
		Vector<String> vector = new Vector<String>();
		String strRet[] = new String[1];
		if (strSource == null)
			return new String[0];
		if (delimiter == null)
			return new String[0];
		if (strSource.trim().equals(""))
			return new String[0];
		intPos = strSource.indexOf(delimiter);
		String strTemp = "";
		while (intPos != -1)
			if (intPos != 0 && strSource.substring(intPos - 1, intPos).equals("\\")) {
				strTemp = strTemp + strSource.substring(0, intPos - 1) + delimiter;
				strSource = strSource.substring(intPos + 1);
				intPos = strSource.indexOf(delimiter);
			} else {
				str = strTemp.equals("") ? strSource.substring(0, intPos).trim() : strTemp + strSource.substring(0, intPos).trim();
				strSource = strSource.substring(intPos + 1);
				vector.addElement(str);
				strTemp = "";
				intPos = strSource.indexOf(delimiter);
			}
		vector.addElement(strSource.trim());
		int len = vector.size();
		strRet = new String[len];
		for (int i = 0; i < len; i++)
			strRet[i] = (String) vector.elementAt(i);

		return strRet;
	}

	public static String[] strConstruct(String strSource) {
		if (strSource == null)
			return new String[0];
		strSource = strSource.trim();
		if (strSource.equals(""))
			return new String[0];
		int iStart = 0;
		try {
			iStart = Integer.parseInt(strSource);
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
			return new String[0];
		}
		Calendar dt = Calendar.getInstance();
		int iEnd = dt.get(1);
		int iTemp = iStart - iEnd;
		if (iTemp > 0) {
			iStart = iEnd;
			iEnd = iStart + iTemp;
		} else {
			iTemp = 0 - iTemp;
		}
		String sRet[] = new String[++iTemp];
		for (int i = 0; i < iTemp; i++)
			sRet[i] = (iStart + i) + "";

		return sRet;
	}

	public static int strCompare(String str1, String str2) {
		return str1.compareTo(str2);
	}

	public static String timeFormat(String strDate, String strType) {
		if (!isNull(strType))
			return "";
		String strTypeCp = strType.toLowerCase();
		int iPos = strTypeCp.indexOf("hh");
		if (iPos != -1)
			strType = strReplace(strType, "hh", strDate.substring(0, 2));
		iPos = strTypeCp.indexOf("mm");
		if (iPos != -1)
			strType = strReplace(strType, "mm", strDate.substring(2, 4));
		iPos = strTypeCp.indexOf("ss");
		if (iPos != -1)
			strType = strReplace(strType, "ss", strDate.substring(4, 6));
		return strType;
	}

	public static String dateFormat(String strDate, String strType) {
		if (!isNull(strType))
			return "";
		String strTypeCp = strType.toLowerCase();
		int iPos = strTypeCp.indexOf("yyyy");
		if (iPos == -1) {
			iPos = strTypeCp.indexOf("yy");
			if (iPos != -1)
				strType = strReplace(strType, "yy", strDate.substring(2, 4));
		} else {
			strType = strReplace(strType, "yyyy", strDate.substring(0, 4));
		}
		iPos = strTypeCp.indexOf("mm");
		if (iPos != -1)
			strType = strReplace(strType, "mm", strDate.substring(4, 6));
		iPos = strTypeCp.indexOf("dd");
		if (iPos != -1)
			strType = strReplace(strType, "dd", strDate.substring(6, 8));
		return strType;
	}

	public static String dateFormat(String strYear, String strMonth, String strDay, String strType) {
		String strRet = dateFormat(strYear, strMonth, strDay);
		if (!strRet.equals("")) {
			strRet = dateFormat(strRet, strType);
			if (!strRet.equals(""))
				return strRet;
		}
		return "";
	}

	public static String dateFormat(String strYear, String strMonth, String strDay) {
		if (!isNull(strYear))
			return "";
		if (!isNull(strMonth))
			return "";
		if (!isNull(strDay))
			return "";
		strYear = strYear.trim();
		if (strYear.length() == 2)
			strYear = "20" + strYear;
		strMonth = strMonth.trim();
		if (strMonth.length() == 1)
			strMonth = "0" + strMonth;
		strDay = strDay.trim();
		if (strDay.length() == 1)
			strDay = "0" + strDay;
		String strDate = strYear + strMonth + strDay;
		if (!isDateValid(strDate, 0, 3000))
			strDate = "";
		return strDate;
	}

	public static String dateGetYear(String strDate, String strType) {
		String strTmp = "";
		if (strDate == null)
			return "00";
		if (strType == null)
			return "00";
		strType = strType.toLowerCase();
		int iPos = strType.indexOf("yyyy");
		if (iPos == -1)
			return "00";
		strTmp = strDate.substring(iPos, iPos + 4);
		if (strTmp == null)
			return "00";
		else
			return strTmp;
	}

	public static String dateGetMonth(String strDate, String strType) {
		String strTmp = "";
		if (strDate == null)
			return "00";
		if (strType == null)
			return "00";
		strType = strType.toLowerCase();
		int iPos = strType.indexOf("mm");
		if (iPos == -1)
			return "00";
		strTmp = strDate.substring(iPos, iPos + 2);
		if (strTmp == null)
			return "00";
		else
			return strTmp;
	}

	public static String dateGetDate(String strDate, String strType) {
		String strTmp = "";
		if (strDate == null)
			return "00";
		if (strType == null)
			return "00";
		strType = strType.toLowerCase();
		int iPos = strType.indexOf("dd");
		if (iPos == -1)
			return "00";
		strTmp = strDate.substring(iPos, iPos + 2);
		if (strTmp == null)
			return "00";
		else
			return strTmp;
	}

	public static String dateGetSeason(String strDate, String strType) {
		String strTmp = dateGetMonth(strDate, strType);
		if ("00".equals(strTmp))
			return "00";
		int iTmp = Integer.parseInt(strTmp);
		switch (iTmp) {
			case 1 : // '\001'
			case 2 : // '\002'
			case 3 : // '\003'
				return "01";

			case 4 : // '\004'
			case 5 : // '\005'
			case 6 : // '\006'
				return "02";

			case 7 : // '\007'
			case 8 : // '\b'
			case 9 : // '\t'
				return "03";

			case 10 : // '\n'
			case 11 : // '\013'
			case 12 : // '\f'
				return "04";
		}
		return "00";
	}

	public static String floatFormat(boolean addComma, String flt, int len, int prec) {
		int i = flt.indexOf(".");
		String str;
		if (i < 0) {
			str = strAlign('R', len, flt, '0');
			for (int j = 0; j < prec; j++)
				str = str + "0";

			len += prec;
		} else {
			str = flt.substring(0, i) + strAlign('L', prec, flt.substring(i + 1), '0');
			str = strAlign('R', len, str, '0');
		}
		String a = str.substring(0, len - prec);
		String b = str.substring(len - prec);
		i = a.length();
		if (addComma)
			while (i > 3) {
				i -= 3;
				a = a.substring(0, i) + "," + a.substring(i);
			}
		char tmp[] = a.toCharArray();
		for (i = 0; (tmp[i] == ' ' || tmp[i] == '0' || tmp[i] == ',') && i < tmp.length - 1; tmp[i++] = ' ');
		return new String(tmp, i, tmp.length - i) + "." + b;
	}

	public static String floatUnFormat(String fmt, int len, int prec) {
		String flt = new String();
		String tmp[] = strSplit(fmt, ",");
		for (int i = 0; i < tmp.length; i++)
			flt = flt + tmp[i];

		return strAlign('R', len, flt, '0');
	}

	public static String floatUnFormat(String fmt) {
		String flt = new String();
		String tmp[] = strSplit(fmt, ",");
		for (int i = 0; i < tmp.length; i++)
			flt = flt + tmp[i];

		return flt;
	}

	public static Date toDate(String date1, String fmt) throws ParseException {
		String date = fmt.substring(0, 8);
		String time = fmt.substring(8, 14);
		date = date.replace('Y', 'y');
		date = date.replace('m', 'M');
		date = date.replace('D', 'd');
		time = time.replace('h', 'H');
		time = time.replace('M', 'm');
		time = time.replace('S', 's');
		Date dt;
		try {
			SimpleDateFormat fdt = new SimpleDateFormat(date + time);
			dt = fdt.parse(date1);
		} catch (ParseException e) {
			throw new ParseException(e.getMessage(), e.getErrorOffset());
		}
		return dt;
	}

	public static int[] toInt(String str[]) {
		int tmp[];
		try {
			tmp = new int[str.length];
			for (int i = 0; i < str.length; i++)
				tmp[i] = Integer.parseInt(str[i]);

		} catch (NumberFormatException e) {
			return new int[0];
		}
		return tmp;
	}

	public static String toDateString(Date dt, String fmt) {
		fmt = fmt.replace('e', 'E');
		fmt = fmt.replace('Y', 'y');
		fmt = fmt.replace('m', 'M');
		fmt = fmt.replace('D', 'd');
		SimpleDateFormat fdt = new SimpleDateFormat(fmt);
		String tmp = fdt.format(dt);
		try {
			return tmp;
		} catch (Exception e) {
			return tmp;
		}
	}

	public static String toTimeString(Date dt, String fmt) {
		fmt = fmt.replace('h', 'H');
		fmt = fmt.replace('M', 'm');
		fmt = fmt.replace('S', 's');
		SimpleDateFormat fdt = new SimpleDateFormat(fmt);
		String tmp = fdt.format(dt);
		try {
			return tmp;
		} catch (Exception e) {
			return tmp;
		}
	}

	public static String gb2Unicode(String str) {
		if (str == null)
			return null;
		try {
			System.out.println("*** gb2Unicode:");
			str = new String(str.getBytes("GBK"), "ISO8859_1");
			return str;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	public static String unicode2Gb(String str) {
		if (str == null)
			return null;
		try {
			str = new String(str.getBytes("ISO8859_1"), "GBK");
			return str;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	public static int arrayFindValue(String array[][], String value, int col) {
		if (array == null)
			return -1;
		if (col >= array[0].length)
			return -1;
		for (int i = 0; i < array.length; i++)
			if (array[i][col].equals(value))
				return i;

		return -1;
	}

	public static String[][] arrayMergerCol(String array1[][], String array2[][]) {
		String tmp[][] = (String[][]) null;
		if (array1.length > 0 && array2.length == array1.length) {
			int l1 = array1[0].length;
			int l2 = array2[0].length;
			if (l1 > 0 && l2 > 0) {
				int col = l1 + l2;
				tmp = new String[array1.length][col];
				for (int i = 0; i < array1.length; i++) {
					for (int j = 0; j < l1; j++)
						tmp[i][j] = array1[i][j];

				}

				for (int i = 0; i < array2.length; i++) {
					for (int j = 0; j < l2; j++)
						tmp[i][j + l1] = array2[i][j];

				}

			}
		}
		return tmp;
	}

	public static String[][] arrayMergerRow(String array1[][], String array2[][]) {
		String tmp[][] = (String[][]) null;
		if (array1.length > 0 && array2.length > 0 && array1[0].length > 0 && array2[0].length > 0) {
			int row = array1.length + array2.length;
			tmp = new String[row][];
			int i;
			for (i = 0; i < array1.length; i++)
				tmp[i] = array1[i];

			for (int j = 0; i < row; j++) {
				tmp[i] = array2[j];
				i++;
			}

		}
		return tmp;
	}

	public static String[][] getArrayFromClass(Object obj) {
		Class<? extends Object> objClass = obj.getClass();
		Field fields[] = objClass.getFields();
		String aa[][] = new String[2][fields.length];
		if (fields.length > 0) {
			for (int i = 0; i < fields.length; i++) {
				aa[0][i] = fields[i].getName();
				try {
					if (fields[i].get(obj) == null)
						aa[1][i] = "&nbsp;";
					else
						aa[1][i] = fields[i].get(obj).toString();
				} catch (Exception exception) {
				}
			}

		}
		return aa;
	}

	public static int setObjectFromArray(Object obj, String array[][]) {
		if (array == null) {
			obj = null;
			return -1;
		}
		try {
			Class<? extends Object> objClass = obj.getClass();
			Field fields[] = objClass.getFields();
			for (int i = 0; i < fields.length; i++) {
				String strVal = "0";
				String fieldName = fields[i].getName().toLowerCase();
				for (int j = 0; j < array[0].length; j++) {
					if (!array[0][j].toLowerCase().equals(fieldName))
						continue;
					strVal = array[1][j];
					break;
				}

				String typeName = fields[i].getType().getName();
				if (!typeName.equals("double") && !typeName.equals("float"))
					if (typeName.equals("int"))
						fields[i].setInt(obj, Integer.parseInt(strVal));
					else if (typeName.equals("long"))
						fields[i].setLong(obj, Long.parseLong(strVal));
					else if (typeName.equals("short"))
						fields[i].setShort(obj, Short.parseShort(strVal));
					else if (typeName.equals("java.lang.String"))
						fields[i].set(obj, strVal);
					else
						System.out.println("UT error:setObjectFromArray don't data type");
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return 0;
	}

	public static String getRangeIntStr(String array[]) throws Exception {
		String logNoStr = "( ";
		int len = array.length;
		for (int i = 0; i < len - 1; i++)
			logNoStr = logNoStr + array[i] + ", ";

		logNoStr = logNoStr + array[len - 1] + ")";
		return logNoStr;
	}

	public static String getRangeStr(String array[]) throws Exception {
		String logNoStr = "( '";
		int len = array.length;
		for (int i = 0; i < len - 1; i++)
			logNoStr = logNoStr + array[i] + "', '";

		logNoStr = logNoStr + array[len - 1] + "')";
		return logNoStr;
	}

	public static String[] getHashNames(Hashtable<String, Object> tb) {
		int i = 0;
		String names[] = new String[tb.size()];
		for (Enumeration<String> enu = tb.keys(); enu.hasMoreElements();) {
			names[i] = enu.nextElement().toString();
			i++;
		}

		return names;
	}

	public static String smallToBig1(String small) {
		String bigAmt = "\u4E07\u4EDF\u4F70\u62FE\u4EBF\u4EDF\u4F70\u62FE\u4E07\u4EDF\u4F70\u62FE\u5143";
		String bigChar = "\u96F6\u58F9\u8D30\u53C1\u8086\u4F0D\u9646\u67D2\u634C\u7396";
		String tail = "";
		String head = "";
		System.out.println("small=[" + small + "]");
		int pos = small.indexOf(".");
		String smallStr;
		if (pos == -1) {
			tail = "\u6574";
			smallStr = small;
		} else {
			String os[] = strSplit(small, ".");
			smallStr = os[0];
			System.out.println("os0=[" + smallStr + "]");
			if (os[1] == null) {
				tail = "\u6574";
			} else {
				tail = "\u96F6";
				System.out.println("os1=[" + os[1] + "]");
				if (Integer.parseInt(os[1]) == 0)
					tail = "\u6574";
				char c1 = os[1].charAt(0);
				char c2 = os[1].length() <= 1 ? '\0' : os[1].charAt(1);
				System.out.println("c1=" + c1 + ",c2=" + c2);
				if (c1 != '0')
					tail = tail + bigChar.substring((c1 - 48) * 2, (c1 - 48) * 2 + 2) + "\u89D2";
				if (c2 != 0 && c2 != '0')
					tail = tail + bigChar.substring((c2 - 48) * 2, (c2 - 48) * 2 + 2) + "\u5206";
			}
		}
		System.out.println(tail);
		int len = smallStr.length();
		System.out.println("smallStr" + smallStr);
		boolean bz = false;
		System.out.println("len=[" + len + "]");
		for (int j = 0; j < len; j++) {
			if (bz)
				head = "\u96F6" + head;
			bz = false;
			char c = smallStr.charAt(len - j - 1);
			if (c == '0' && j != 0 && j != 4 && j != 8)
				bz = true;
			else if (c == '0' && (j == 4 || j == 8 || j == 0)) {
				head = bigAmt.substring((12 - j) * 2, (12 - j) * 2 + 2) + head;
			} else {
				head = bigChar.substring((c - 48) * 2, (c - 48) * 2 + 2) + bigAmt.substring((12 - j) * 2, (12 - j) * 2 + 2) + head;
				System.out.println(head);
			}
		}

		int n0 = head.indexOf("\u5143");
		if (n0 != -1) {
			for (int i = 0; head.substring(n0 - 2 * i - 2, n0 - 2 * i).equals("\u96F6"); i++)
				head = head.substring(0, n0 - 2 * i - 2) + head.substring(n0 - 2 * i);

		}
		int n4 = head.indexOf("\u4E07");
		if (n4 != -1) {
			for (int i = 0; head.substring(n4 - 2 * i - 2, n4 - 2 * i).equals("\u96F6"); i++)
				head = head.substring(0, n4 - 2 * i - 2) + head.substring(n4 - 2 * i);

		}
		int n8 = head.indexOf("\u4EBF");
		if (n8 != -1) {
			for (int i = 0; head.substring(n8 - 2 * i - 2, n8 - 2 * i).equals("\u96F6"); i++)
				head = head.substring(0, n8 - 2 * i - 2) + head.substring(n8 - 2 * i);

		}
		return head + tail;
	}

	public static String smallToBig(String small) {
		String bigAmt = "\u4E07\u4EDF\u4F70\u62FE\u4EBF\u4EDF\u4F70\u62FE\u4E07\u4EDF\u4F70\u62FE\u5143";
		String bigChar = "\u96F6\u58F9\u8D30\u53C1\u8086\u4F0D\u9646\u67D2\u634C\u7396";
		String tail = "";
		String head = "";
		System.out.println("small=[" + small + "]");
		int pos = small.indexOf(".");
		String smallStr;
		if (pos == -1) {
			tail = "\u6574";
			smallStr = small;
		} else {
			String os[] = strSplit(small, ".");
			smallStr = os[0];
			System.out.println("os0=[" + smallStr + "]");
			if (os[1] == null) {
				tail = "\u6574";
			} else {
				tail = "";
				System.out.println("os1=[" + os[1] + "]");
				if (Integer.parseInt(os[1]) == 0)
					tail = "\u6574";
				char c1 = os[1].charAt(0);
				char c2 = os[1].length() <= 1 ? '\0' : os[1].charAt(1);
				System.out.println("c1=" + c1 + ",c2=" + c2);
				if (c1 != '0')
					tail = tail + bigChar.substring(c1 - 48, (c1 - 48) + 1) + "\u89D2";
				if (c2 != 0 && c2 != '0')
					tail = tail + bigChar.substring(c2 - 48, (c2 - 48) + 1) + "\u5206";
			}
		}
		System.out.println(tail);
		int len = smallStr.length();
		System.out.println("smallStr" + smallStr);
		boolean bz = false;
		System.out.println("len=[" + len + "]");
		if (smallStr.equals("0") && tail.length() > 0) {
			head = "";
		} else {
			for (int j = 0; j < len; j++) {
				if (bz && !head.substring(0, 1).equals("\u96F6"))
					head = "\u96F6" + head;
				bz = false;
				char c = smallStr.charAt(len - j - 1);
				if (c == '0' && j != 0 && j != 4 && j != 8) {
					bz = true;
				} else {
					System.out.println("head1[" + head + "]");
					if (c == '0' && (j == 4 || j == 8 || j == 0)) {
						head = bigAmt.substring(12 - j, (12 - j) + 1) + head;
						System.out.println("head1**[" + head + "]");
					} else {
						System.out.println("head2[" + head + "]");
						head = bigChar.substring(c - 48, (c - 48) + 1) + bigAmt.substring(12 - j, (12 - j) + 1) + head;
						System.out.println(head);
					}
				}
			}

		}
		int n0 = head.indexOf("\u5143");
		if (n0 != -1) {
			for (int i = 0; head.substring(n0 - i - 1, n0 - 1 * i).equals("\u96F6"); i++)
				head = head.substring(0, n0 - i - 1) + head.substring(n0 - 1 * i);

		}
		int n4 = head.indexOf("\u4E07");
		if (n4 != -1) {
			for (int i = 0; head.substring(n4 - 1 * i - 1, n4 - 1 * i).equals("\u96F6"); i++)
				head = head.substring(0, n4 - 1 * i - 1) + head.substring(n4 - 1 * i);

		}
		int n8 = head.indexOf("\u4EBF");
		if (n8 != -1) {
			for (int i = 0; head.substring(n8 - 1 * i - 1, n8 - 1 * i).equals("\u96F6"); i++)
				head = head.substring(0, n8 - 1 * i - 1) + head.substring(n8 - 1 * i);

		}
		return head + tail;
	}

	public static double round2(double amt) {
		return (double) Math.round(amt * 100D) / 100D;
	}

	private static byte[] _HexToBytes(String hex) {
		String _hex = hex.toUpperCase();
		byte result[] = new byte[hex.length() / 2];
		for (int i = 0; i < _hex.length() / 2; i++) {
			byte HH = (byte) (HEX.indexOf(_hex.substring(2 * i, 2 * i + 1)) << 4);
			byte HL = (byte) HEX.indexOf(_hex.substring(2 * i + 1, 2 * i + 2));
			result[i] = (byte) (HH | HL);
		}

		return result;
	}

	public static String StrtoHex(String value) {
		String str = "";
		byte btmp[] = value.getBytes();
		for (int i = 0; i < btmp.length; i++)
			str = str + toHex_B(btmp[i]);

		return str;
	}

	public static String HexToStr(String hex) {
		byte temp[] = _HexToBytes(hex);
		String result = new String(temp);
		return result;
	}

	public static byte[] hexToBytes(String hex) {
		byte temp[] = _HexToBytes(hex);
		return temp;
	}

	public static String HexBytesToStr(byte bytes[]) {
		String ret = "";
		for (int i = 0; i < bytes.length; i++)
			ret = ret + toHex_B(bytes[i]);

		return ret;
	}

	public static String toHex_B(byte one) {
		String HEX = "0123456789ABCDEF";
		byte bTmp[] = new byte[2];
		bTmp[0] = (byte) HEX.charAt((one & 0xf0) >> 4);
		bTmp[1] = (byte) HEX.charAt(one & 0xf);
		String result = new String(bTmp);
		return result;
	}

	public static String makeString(String value, int len) {
		String ret = value;
		if (value == null)
			value = "null";
		byte bytes[] = value.getBytes();
		int length = bytes.length;
		if (length > len)
			ret = new String(bytes, 0, len);
		else if (length < len) {
			String blank = "";
			for (int i = 0; i < len - length; i++)
				blank = blank + " ";

			ret = value + blank;
		}
		return ret;
	}

	public static String BlobToString(InputStream desc) throws IOException {
		String str = "";
		desc.mark(0);
		int I;
		for (I = 0; desc.read() != -1; I++);
		desc.reset();
		byte result[] = new byte[I];
		desc.read(result);
		str = new String(result);
		return str;
	}

	public static void main(String args1[]) {
	}

	private static String HEX = "0123456789ABCDEF";

}
