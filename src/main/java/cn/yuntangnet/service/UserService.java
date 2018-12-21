package cn.yuntangnet.service;

import cn.yuntangnet.pojo.UserWechat;

/**
 * @author 张茂林
 * @since 2017/12/14 10:44
 */
public interface UserService {


    /**
     * 根据openId查询用户信息
     *
     * @param openid
     * @return
     */
    UserWechat findByOpenId(String openid);

    /**
     * 微信用户注册
     *
     * @param user
     */
    void register(UserWechat user);

    /**
     * 更新微信用户
     *
     * @param user
     */
    void update(UserWechat user);
}
