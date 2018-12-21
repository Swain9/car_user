package cn.yuntangnet.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created by 45022 on 2017/7/29.
 */
public class TotalUtil {
    private static final OkHttpClient client = new OkHttpClient();
    public static String sendGet(String reqUrl,Map<String,String> map){
        //构建URL字符串
        String url = buildUrl(reqUrl, map);
        //构建request对象
        Request request = new Request.Builder()
                .url(url)
                .header("Accept-Encoding", "gzip")
                .build();
        try (
                //response body必须被关闭
                Response response = client.newCall(request).execute()
                //InputStream is = response.body().byteStream()
        ) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                return "连接超时";
            }
        } catch (IOException e) {
            return "连接超时";
        }
    }
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
    public static   String filterEmoji(String source, String slipStr) {
        if (source != null && !"".equals(source.trim())) {
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);
        } else {
            return source;
        }
    }
    private static String buildUrl(String reqUrl, Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        Set<String> set = params.keySet();
        for (String key : set) {
            query.append(String.format("%s=%s&", key, params.get(key)));
        }
        return reqUrl + "?" + query.toString();
    }
}
