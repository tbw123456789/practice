package cn.medigical.publish.utils;

import java.text.SimpleDateFormat;

/**
 * Created by Medicare on 2015/3/19, 7:05.
 * Copy right by Medicare
 */
public class MyDateFormat {
    private MyDateFormat(){

    }

    public static final String DATE_FORMAT_STR_Y ="yyyy";
    public static final String DATE_FORMAT_STR_M ="MM";
    public static final String DATE_FORMAT_STR_D ="dd";
    public static final String DATE_FORMAT_STR_HM = "HH:mm";
    public static final String DATE_FORMAT_STR_hh = "HH";
    public static final String DATE_FORMAT_STR_mm = "mm";
    public static final String DATE_FORMAT_STR_YMDHML = "yyyyMMddHHmmss";

    public static final String DATE_FORMAT_STR_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_STR_YMDHMSsss = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_FORMAT_STR_YMDHMSS = "yyyyMMddHHmmssSSS";
    public static final String DATE_FORMAT_STR_YMD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_STR_YMDHM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_STR_MD = "MM-dd";
    public static final String  DATE_FORMAT_STR_MDHM = "MM-dd HH:mm";
    public static final String DATE_FORMAT_STR = "yyyyMMddHHmm";
    public static final String DATE_FORMAT_STR_YM = "yyyy-MM";
    public static final String DATE_FORMAT_STR_YMD_NOGAP = "yyyyMMdd";
    public static final String DATE_FORTS = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_FORMAT_STR_YMDHMS2 = "yyyy/MM/dd HH:mm:ss";

    public static final SimpleDateFormat DATE_FORMAT_YMDHMSsss = new SimpleDateFormat(DATE_FORMAT_STR_YMDHMSsss);
    public static final SimpleDateFormat DATE_FORMAT_YMD = new SimpleDateFormat(DATE_FORMAT_STR_YMD);
    public static final SimpleDateFormat DATE_FORMAT_MD = new SimpleDateFormat(DATE_FORMAT_STR_MD);
    public static final SimpleDateFormat DATE_FORMAT_HM = new SimpleDateFormat(DATE_FORMAT_STR_HM);
    public static final SimpleDateFormat DATE_FORMAT_MDHM = new SimpleDateFormat(DATE_FORMAT_STR_MDHM);
    public static final SimpleDateFormat DATE_FORMAT_YMDHM = new SimpleDateFormat(DATE_FORMAT_STR_YMDHM);
    public static final SimpleDateFormat DATE_FORMAT_YMDHMS = new SimpleDateFormat(DATE_FORMAT_STR_YMDHMS);
    public static final SimpleDateFormat DATE_FORMAT_YMDHMS2 = new SimpleDateFormat(DATE_FORMAT_STR_YMDHMS2);
    public static final SimpleDateFormat DATE_FORMAT_YMDHMSS = new SimpleDateFormat(DATE_FORMAT_STR_YMDHMSS);
    public static final SimpleDateFormat DATE_FORMAT_yyyy = new SimpleDateFormat(DATE_FORMAT_STR_Y);
    public static final SimpleDateFormat DATE_FORMAT_hh = new SimpleDateFormat(DATE_FORMAT_STR_hh);
    public static final SimpleDateFormat DATE_FORMAT_mm = new SimpleDateFormat(DATE_FORMAT_STR_mm);
    public static final SimpleDateFormat DATE_FORMAT_MM = new SimpleDateFormat(DATE_FORMAT_STR_M);
    public static final SimpleDateFormat DATE_FORMAT_dd = new SimpleDateFormat(DATE_FORMAT_STR_D);
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STR);
    public static final SimpleDateFormat DATE_FORMAT_YM = new SimpleDateFormat(DATE_FORMAT_STR_YM);
    public static final SimpleDateFormat DATE_FORMAT_YMD_NOGAP = new SimpleDateFormat(DATE_FORMAT_STR_YMD_NOGAP);
    public static final SimpleDateFormat DATE_FORMAT_YMDHMl = new SimpleDateFormat(DATE_FORMAT_STR_YMDHML);
    public static final SimpleDateFormat DATE_FORTS_YMDHMS = new SimpleDateFormat(DATE_FORTS);
}
