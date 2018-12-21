package cn.yuntangnet.util;

import cn.yuntangnet.exception.RtException;
import cn.yuntangnet.pojo.UserWechat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 张茂林
 * @since 2017/12/14 13:47
 */
public class WeChatUtil {

    public static JSONObject getTokenByCode(String code) {
        //生成请求参数
        Map<String, String> tokenmap = new HashMap<String, String>();
        tokenmap.put("appid", "wxd5993673a9238d89");
        tokenmap.put("secret", "1997de871afd32629c09cd6bae5d2771");
        tokenmap.put("code", code);
        tokenmap.put("grant_type", "authorization_code");
        //请求微信得到json数据
        String jsontoken = TotalUtil.sendGet("https://api.weixin.qq.com/sns/oauth2/access_token", tokenmap);
        if ("连接超时".equals(jsontoken)) {
            throw new RtException("连接超时");
        }
        // TODO 获取到token并赋值保存,该token和操作公众号的token不一样,可以理解为用户token
        //将json字符串转为json对象
        JSONObject jsontokenObject = JSON.parseObject(jsontoken);
        //如果返回错误数据
        if (jsontokenObject.get("errcode") != null) {
            throw new RtException("数据错误");
        }
        return jsontokenObject;
    }

    public static UserWechat getUserWechatByToken(String openid, String access_token) {
        //第四步：拉取用户信息(需scope为 snsapi_userinfo)
        //?access_token={0}&openid={1}&lang=zh_CN
        Map<String, String> userinfo = new HashMap<String, String>();
        userinfo.put("access_token", access_token);
        userinfo.put("openid", openid);
        userinfo.put("lang", "zh_CN");

        String wechatJson = TotalUtil.sendGet("https://api.weixin.qq.com/sns/userinfo", userinfo);
        if ("连接超时".equals(wechatJson)) {
            throw new RtException("连接超时");
        }
        if (wechatJson.contains("errcode")) {
            throw new RtException("错误数据");
        }
        UserWechat userWechat = JSON.parseObject(wechatJson, UserWechat.class);
        return userWechat;
    }

}
