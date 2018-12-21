package cn.yuntangnet.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Zml on 2017/3/2.
 */
public class MyDateUtil {

    /**
     * 把传入格式的字符串时间转为Timestamp
     *
     * @param time     时间字符串
     * @param timeType 转换的格式
     * @return Timestamp
     */
    public static Timestamp getTimestampFormat(String time, String timeType) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(timeType);
            Date date = sdf.parse(time);
            return new Timestamp(date.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成当前传入格式的当前日期
     *
     * @param type 格式
     * @return 日期字符串
     */
    public static String getDateTimeStr(String type) {
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(new Date());
    }

    /**
     * 将传入日期的转为传入格式的字符串
     *
     * @param type  格式
     * @param times 日期
     * @return 日期字符串
     */
    public static String getDateTimeStr(String type, long times) {
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(new Date(times));
    }

    public static String getDateTimeStr(String type, Date times) {
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(times);
    }

    /**
     * 返回当前时间的日期字符串
     *
     * @return 字符串
     */
    public static String getDateTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    /**
     * 返回yyyyMMddHHmmss格式的字符串
     *
     * @param timestamp 时间戳
     * @return 字符串
     */
    public static String getDateTimeStr(Timestamp timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(timestamp);
    }

    /**
     * 返回yyyyMMddHHmmss格式的字符串
     *
     * @param times 从1970。。。以来的毫秒数
     * @return 字符串
     */
    public static String getDateTimeStr(long times) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date(times));
    }

    /**
     * 获取当前系统日期的时间戳
     *
     * @return Timestamp
     */
    public static Timestamp getNowTimestamp() {
        //return new Timestamp(new Date().getTime());
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取订单的下次处理时间
     *
     * @param next
     * @param paystatus
     * @return
     */
    public static Timestamp getNextTime(Timestamp next, int paystatus) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(next);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 30 * paystatus);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * 获取当天最后一秒
     * HOUR  是12小时制，HOUR_OF_DAY 24小时制
     *
     * @return
     */
    public static Timestamp getLastTimeByDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTime().getTime());
    }
}
