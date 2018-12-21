package cn.yuntangnet.util;

import java.util.UUID;

/**
 * @author 张茂林
 * @since 2018/3/10 14:55
 */
public class StringsUtil {

    /**
     * 生成32位的随机字符串
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
