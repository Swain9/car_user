package cn.yuntangnet.controller;

import cn.yuntangnet.exception.RtException;
import cn.yuntangnet.pojo.UserWechat;
import cn.yuntangnet.service.UserService;
import cn.yuntangnet.util.ResultBean;
import cn.yuntangnet.util.TotalUtil;
import cn.yuntangnet.util.WeChatUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 张茂林
 * @since 2017/12/13 19:27
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public ResultBean test() {
        throw new RtException("异常数据");
    }

    @RequestMapping("/oauto")
    public String login(String code, HttpSession session) {
        //用户openid
        JSONObject token = WeChatUtil.getTokenByCode(code);
        String openid = token.getString("openid");
        //查询用户openid是否存在
        UserWechat user = userService.findByOpenId(openid);
        //todo 这里会有一个问题，如果用户修改了昵称和头像，将会不匹配，首次注册的用户
        //以后需要去区分
        String access_token = token.getString("access_token");
        //刷新access_token的token，有效期为30天
        String refresh_token = token.getString("refresh_token");

        if (user == null) {

            user = WeChatUtil.getUserWechatByToken(openid, access_token);

            user.setIsDeleted(false);
            Date date = new Date();
            user.setGmtCreate(date);
            user.setGmtModified(date);

            //todo 过滤emoji特殊字符
            user.setNickname(TotalUtil.filterEmoji(user.getNickname(), "?"));

            userService.register(user);

            session.setAttribute("user", user);
            return "redirect:/page/member";
        } else {
            boolean update = false;

            UserWechat newUser = WeChatUtil.getUserWechatByToken(openid, access_token);
            if (!newUser.getHeadimgurl().equals(user.getHeadimgurl())) {
                user.setHeadimgurl(newUser.getHeadimgurl());
                update = true;
            }
            String newNickname = TotalUtil.filterEmoji(newUser.getNickname(), "?");
            if (!newNickname.equals(user.getNickname())) {
                user.setNickname(newNickname);
                update = true;
            }
            if (update) {
                userService.update(user);
            }


            session.setAttribute("user", user);
            return "redirect:/page/member";
        }
    }
}
