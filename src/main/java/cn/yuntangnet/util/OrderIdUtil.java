package cn.yuntangnet.util;

/**
 * Created by Zml on 2017/3/2.
 */
public class OrderIdUtil {
    public static String getOrderId(String type) {
        return type + MyDateUtil.getDateTimeStr() + String.valueOf(System.nanoTime()).substring(5, 10);
    }
}
