package cn.yuntangnet.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionResolver implements HandlerExceptionResolver {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object arg2, Exception exc) {
        logger.error(exc.getMessage(), exc);
        //保存异常信息
        String msg = "";

        //判断异常类型
        if (exc instanceof RtException) {
            //处理业务级别异常
            msg = ((RtException) exc).getMessage();
        } else {
            //处理运行时异常
            msg = "系统异常, 亲,对不起, 请及时联系管理员哦!";
        }

        MappingJackson2JsonView view = new MappingJackson2JsonView();
        Map<String, Object> map = new HashMap<>();
        map.put("code", "401");
        map.put("msg", msg);
        view.setAttributesMap(map);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(view);
        return modelAndView;
    }
}
