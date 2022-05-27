package cn.medigical.publish.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	      
	    /** 
	     * 前一周的第一天 
	     */  
	    public final static int FIRST_DAY_OF_PRE_WEEK = 0;  
	      
	    /** 
	     * 前一周的最后一天 
	     */  
	    public final static int LAST_DAY_OF_PRE_WEEK = 1;  
	      
	    /** 
	     * 本周的第一天 
	     */  
	    public final static int FIRST_DAY_OF_CUR_WEEK = 2;  
	      
	    /** 
	     * 本周的最后一天 
	     */  
	    public final static int LAST_DAY_OF_CUR_WEEK = 3;  
	      
	    /** 
	     * 前一月的第一天 
	     */  
	    public final static int FIRST_DAY_OF_PRE_MONTH = 4;  
	      
	    /** 
	     * 前一月的最后一天 
	     */  
	    public final static int LAST_DAY_OF_PRE_MONTH = 5;  
	      
	    /** 
	     * 本月的第一天 
	     */  
	    public final static int FIRST_DAY_OF_CUR_MONTH = 6;  
	      
	    /** 
	     * 本月的最后一天 
	     */  
	    public final static int LAST_DAY_OF_CUR_MONTH = 7;  
	      
	    /** 
	     * 前一年的第一天 
	     */  
	    public final static int FIRST_DAY_OF_PRE_YEAR = 8;  
	      
	    /** 
	     * 前一年的最后一天 
	     */  
	    public final static int LAST_DAY_OF_PRE_YEAR = 9;  
	      
	    /** 
	     * 本年的第一天 
	     */  
	    public final static int FIRST_DAY_OF_CUR_YEAR = 10;  
	      
	    /** 
	     * 本年的最后一天 
	     */  
	    public final static int LAST_DAY_OF_CUR_YEAR = 11;  
	      
	    //第一天  
	    private static String firstDay;  
	    //最后一天  
	    private static String lastDay;  
	    //日期格式化对象  
	   // private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	      
	  
	    /** 
	     *  
	     * @Title: getDateByConditions  
	     * @Description: 根据参数日期及要获取的日期条件，获取相应的日期TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @param contition  
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:59:44 
	     */  
	    public static Date getDateByConditions(Date date,int contition){  
	        Date day = null;  
	        switch (contition) {  
	        case 0:  
	            day = firstDayOfPreWeek(date);  
	            break;  
	        case 1:  
	            day = lastDayOfPreWeek(date);  
	            break;  
	        case 2:  
	            day = firstDayOfCurWeek(date);  
	            break;  
	        case 3:  
	            day = lastDayOfCurWeek(date);  
	            break;  
	        case 4:  
	            day = firstDayOfPreMonth(date);  
	            break;  
	        case 5:  
	            day = lastDayOfPreMonth(date);  
	            break;  
	        case 6:  
	            day = firstDayOfCurMonth(date);  
	            break;  
	        case 7:  
	            day = lastDayOfCurMonth(date);  
	            break;  
	        case 8:  
	            day = firstDayOfPreYear(date);  
	            break;  
	        case 9:  
	            day = lastDayOfPreYear(date);  
	            break;  
	        case 10:  
	            day = firstDayOfCurYear(date);  
	            break;  
	        case 11:  
	            day = lastDayOfCurYear(date);  
	            break;  
	        default:  
	            break;  
	        }  
	        return day;  
	    }  
	  
	    /** 
	     *  
	     * @Title: firstDayOfPreWeek  
	     * @Description: 获取参数日期前一周的第一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:54:41 
	     */  
	    private static Date firstDayOfPreWeek(Date date){  
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(date);  
	        cal.add(Calendar.DATE,-7);  
	        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
	        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	        if (1 == dayWeek) {  
	            cal.add(Calendar.DAY_OF_MONTH, -1);  
	        }  
	        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
	        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
	        //firstDay = dateFormat.format(cal.getTime());  
	        return cal.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: lastDayOfPreWeek  
	     * @Description: 获取参数日期前一周的最后一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:55:04 
	     */  
	    private static Date lastDayOfPreWeek(Date date){  
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(date);  
	        cal.add(Calendar.DATE,-7);  
	        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
	        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	        if (1 == dayWeek) {  
	            cal.add(Calendar.DAY_OF_MONTH, -1);  
	        }  
	        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
	        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
	        cal.add(Calendar.DATE, 6);  
	        //lastDay = dateFormat.format(cal.getTime());  
	        return cal.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: firstDayOfCurWeek  
	     * @Description: 获取参数日期所在周的第一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:55:27 
	     */  
	    private static Date firstDayOfCurWeek(Date date){  
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(date);  
	        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
	        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	        if (1 == dayWeek) {  
	            cal.add(Calendar.DAY_OF_MONTH, -1);  
	        }  
	        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
	        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
	        //firstDay = dateFormat.format(cal.getTime());  
	        return cal.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: lastDayOfCurWeek  
	     * @Description: 获取参数日期所在周的最后一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:55:50 
	     */  
	    private static Date lastDayOfCurWeek(Date date){  
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(date);  
	        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
	        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	        if (1 == dayWeek) {  
	            cal.add(Calendar.DAY_OF_MONTH, -1);  
	        }  
	        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
	        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
	        cal.add(Calendar.DATE, 6);  
	       // lastDay = dateFormat.format(cal.getTime());  
	        return cal.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: firstDayOfPreMonth  
	     * @Description: 获取参数日期前一月的第一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:56:15 
	     */  
	    private static Date firstDayOfPreMonth(Date date){  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(date);  
	        calendar.add(Calendar.MONTH, -1);  
	        Date theDate = calendar.getTime();  
	        // 上个月第一天  
	        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();  
	        gcLast.setTime(theDate);  
	        gcLast.set(Calendar.DAY_OF_MONTH, 1);  
	       // firstDay = dateFormat.format(gcLast.getTime());  
	        return gcLast.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: lastDayOfPreMonth  
	     * @Description: 获取参数日期前一月的最后一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:56:36 
	     */  
	    private static Date lastDayOfPreMonth(Date date){  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(date);  
	        calendar.add(Calendar.MONTH, -1);  
	        calendar.add(Calendar.MONTH, 1); // 加一个月  
	        calendar.set(Calendar.DATE, 1); // 设置为该月第一天  
	        calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天  
	        //lastDay = dateFormat.format(calendar.getTime());  
	        return calendar.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: firstDayOfCurMonth  
	     * @Description: 获取参数日期所在月的第一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:57:02 
	     */  
	    private static Date firstDayOfCurMonth(Date date){  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(date);  
	        Date theDate = calendar.getTime();  
	        // 上个月第一天  
	        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();  
	        gcLast.setTime(theDate);  
	        gcLast.set(Calendar.DAY_OF_MONTH, 1);  
	        //firstDay = dateFormat.format(gcLast.getTime());  
	        return gcLast.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: lastDayOfCurMonth  
	     * @Description: 获取参数日期所在月的最后一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:57:29 
	     */  
	    private static Date lastDayOfCurMonth(Date date){  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(date);  
	        calendar.add(Calendar.MONTH, 1); // 加一个月  
	        calendar.set(Calendar.DATE, 1); // 设置为该月第一天  
	        calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天  
	        //lastDay = dateFormat.format(calendar.getTime());  
	        return calendar.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: firstDayOfPreYear  
	     * @Description: 获取参数日期前一年的第一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:58:02 
	     */  
	    private static Date firstDayOfPreYear(Date date){  
	        Calendar calendar = Calendar.getInstance();  
	        int year = date.getYear() + 1900;  
	        calendar.clear();  
	        calendar.set(Calendar.YEAR, year-1);  
	        //firstDay = dateFormat.format(calendar.getTime());  
	        return calendar.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: lastDayOfPreYear  
	     * @Description: 获取参数日期前一年的最后一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:58:25 
	     */  
	    private static Date lastDayOfPreYear(Date date){  
	        Calendar calendar = Calendar.getInstance();  
	        int year = date.getYear() + 1900;  
	        calendar.clear();  
	        calendar.set(Calendar.YEAR, year);  
	        calendar.add(calendar.DATE, -1);  
	        //lastDay = dateFormat.format(calendar.getTime());  
	        return calendar.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: firstDayOfCurYear  
	     * @Description: 获取参数日期所在年的第一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:58:52 
	     */  
	    private static Date firstDayOfCurYear(Date date){  
	        Calendar calendar = Calendar.getInstance();  
	        int year = date.getYear() + 1900;  
	        calendar.clear();  
	        calendar.set(Calendar.YEAR, year);  
	        //firstDay = dateFormat.format(calendar.getTime());  
	        return calendar.getTime();  
	    }  
	  
	    /** 
	     *  
	     * @Title: lastDayOfCurYear  
	     * @Description: 获取参数日期所在年的最后一天TODO 
	     * @author ExceptionalBoy  
	     * @param @param date 
	     * @param @return  
	     * @return String    
	     * @throws 
	     * @date 2017年11月14日 上午10:59:16 
	     */  
	    private static Date lastDayOfCurYear(Date date){  
	        Calendar calendar = Calendar.getInstance();  
	        int year = date.getYear() + 1900;  
	        calendar.clear();  
	        calendar.set(Calendar.YEAR, year+1);  
	        calendar.add(calendar.DATE, -1);  
	        //lastDay = dateFormat.format(calendar.getTime());  
	        return calendar.getTime();  
	    }  
	    
	    /**
	     * 一天0点
	     * @param date
	     * @param
	     * @return
	     */
	    public static Date oneDaystart(Date date) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(date);

			calendar1.set(Calendar.HOUR_OF_DAY, 0);
			calendar1.set(Calendar.MINUTE, 0);
			calendar1.set(Calendar.SECOND, 0);
			return calendar1.getTime();
		}
	    /**
	     * 一天24点
	     * @param date
	     * @param
	     * @return
	     */
		public static Date oneDayend(Date date) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(date);
			calendar1.set(Calendar.HOUR_OF_DAY, 23);
			calendar1.set(Calendar.MINUTE, 59);
			calendar1.set(Calendar.SECOND, 59);
			return calendar1.getTime();
		}

	
		/**
		 * n天以前
		 * @param date
		 * @param n
		 * @return
		 */
		public static String agoday(Date date,int n) {
			Calendar calendar1 = Calendar.getInstance();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			calendar1.setTime(date);
			calendar1.add(Calendar.DAY_OF_YEAR, n);
			String three_days_ago = sdf1.format(calendar1.getTime());
			return three_days_ago;
		}
}

