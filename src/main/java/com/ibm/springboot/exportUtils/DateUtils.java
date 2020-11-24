package com.ibm.springboot.exportUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * Date时间转指定时间格式字符串
	 * 
	 * @param date   date时间
	 * @param format 格式化时间字符串
	 * @return
	 */
	public static String dateToString(Date date, String format)
	{
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}

	/**
	 * 得到当前时间,格式:yyyyMMddHHmmss
	 *
	 * @return
	 */
	public static String currtimeToString14() 
	{
		return dateToString(new Date(), "yyyyMMddHHmmss");
	}

}
