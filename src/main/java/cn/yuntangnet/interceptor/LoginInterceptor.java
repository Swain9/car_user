package cn.yuntangnet.interceptor;

import cn.yuntangnet.annotation.Login;
import cn.yuntangnet.pojo.UserWechat;
import cn.yuntangnet.util.JsonUtils;
import cn.yuntangnet.util.ResultBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.MessageFormat;

public class LoginInterceptor implements HandlerInterceptor {

    @Value("${active}")
    private String active;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        Login annotation;
        if (o instanceof HandlerMethod) {
            annotation = ((HandlerMethod) o).getMethodAnnotation(Login.class);
        } else {
            return true;
        }

        if (annotation == null) {
            return true;
        }
        Object user = request.getSession().getAttribute("user");
        if (user == null && "dev".equals(active)) {
            UserWechat userWechat = new UserWechat();
            userWechat.setId(1L);
            userWechat.setNickname("你好");
            request.getSession().setAttribute("user", userWechat);
        }

        if (user == null && "pro".equals(active)) {
            String baseUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope={2}&state={3}#wechat_redirect";
            String state = "";
            String redirectUrl = URLEncoder.encode("http://wx.yuntangnet.cn/app/oauto", "UTF-8");
            String url = MessageFormat.format(baseUrl, "wxd5993673a9238d89", redirectUrl, "snsapi_userinfo", state);

            String header = request.getHeader("X-Requested-With");

            if ("XMLHttpRequest".equalsIgnoreCase(header)) {
                ResultBean bean = ResultBean.error(HttpStatus.UNAUTHORIZED.value(), "未登录", url);
                String json = JsonUtils.objectToJson(bean);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(json);
            } else {
                response.sendRedirect(url);
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
