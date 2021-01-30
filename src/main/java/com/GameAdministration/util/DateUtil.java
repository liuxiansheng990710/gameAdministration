package com.GameAdministration.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.GameAdministration.Exception.ApplicationException;
import com.GameAdministration.Exception.GlobalErrorCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author YP
 * @Description: 时间工具类
 * @param:  Date
 * @date:     2021年1月29日上午11:06:18
 * 
 */
@Slf4j
public class DateUtil {
	
	/**
	 * @param format
	 * @param Date
	 * @return 获取当前日期与指定日期的日期差(单位：天)
	 */
	public static int getCurrentTimeDiff(String format,String Date){
		if(Date == null){
			throw new ApplicationException(GlobalErrorCode.TIME_ISEMPTY);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = simpleDateFormat.parse(Date);
		} catch (Exception e) {
			log.info("获取当前时间与指定时间的日期差错误");
			e.printStackTrace();
		}
		Date todayDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day1 = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(todayDate);
		int day2 = calendar.get(Calendar.DAY_OF_YEAR);
		return day2-day1;
	}
	
	/**
	 * @param beginDate
	 * @param endDate
	 * @return 获取两个日期的时间差(单位：天)
	 */
	public static int getDateDiffDays(Date beginDate,Date endDate){
		if(beginDate == null || endDate == null){
			throw new ApplicationException(GlobalErrorCode.TIME_ISEMPTY);
		}
		long diff= (endDate.getTime()-beginDate.getTime())/(60*60*24*1000);
		int days = new Long(diff).intValue();
		return days;
	}
	
	/**
	 * @param beginDate
	 * @param endDate
	 * @return 获取两个日期相差的毫秒数(单位：毫秒)
	 */
	public static long getDateDiffLong(Date beginDate,Date endDate){
		if(beginDate == null || endDate == null){
			throw new ApplicationException(GlobalErrorCode.TIME_ISEMPTY);
		}
		long time1 = beginDate.getTime();
		long time2 = endDate.getTime();
		return time1 - time2;
	}
	
	/**
	 * @param beginDate
	 * @param endDate
	 * @return 获取两个日期中最大的日期
	 */
	public static Date getDateMax(Date beginDate,Date endDate){
		if(beginDate == null){
			return endDate;
		}
		if(endDate == null){
			return beginDate;
		}
		if(beginDate.after(endDate)){
			return beginDate;
		}
		return endDate;
	}
	
	/**
	 * @param beginDate
	 * @param endDate
	 * @return 获取两个日期中最小的日期
	 */
	public static Date getDateMin(Date beginDate,Date endDate){
		if(beginDate == null){
			return endDate;
		}
		if(endDate == null){
			return beginDate;
		}
		if(beginDate.after(endDate)){
			return endDate;
		}
		return beginDate;
	}
}
