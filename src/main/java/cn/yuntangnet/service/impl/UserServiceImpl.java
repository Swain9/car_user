package cn.yuntangnet.service.impl;

import cn.yuntangnet.mapper.UserWechatMapper;
import cn.yuntangnet.pojo.UserWechat;
import cn.yuntangnet.pojo.UserWechatExample;
import cn.yuntangnet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张茂林
 * @since 2017/12/14 10:47
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserWechatMapper userWechatMapper;

    /**
     * 根据openId查询用户信息
     *
     * @param openid
     * @return
     */
    @Override
    public UserWechat findByOpenId(String openid) {
        UserWechatExample example = new UserWechatExample();
        UserWechatExample.Criteria criteria = example.createCriteria();
        criteria.andOpenidEqualTo(openid);
        List<UserWechat> list = userWechatMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 微信用户注册
     *
     * @param user
     */
    @Override
    @Transactional
    public void register(UserWechat user) {
        userWechatMapper.insert(user);
    }

    /**
     * 更新微信用户
     *
     * @param user
     */
    @Override
    @Transactional
    public void update(UserWechat user) {
        userWechatMapper.updateByPrimaryKey(user);
    }
}
