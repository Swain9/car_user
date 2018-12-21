package cn.yuntangnet.controller;

import cn.yuntangnet.annotation.Login;
import cn.yuntangnet.annotation.LoginUser;
import cn.yuntangnet.pojo.BusinessContent;
import cn.yuntangnet.pojo.BusinessOrder;
import cn.yuntangnet.pojo.UserWechat;
import cn.yuntangnet.service.BusinessService;
import cn.yuntangnet.util.IPUtils;
import cn.yuntangnet.util.OrderIdUtil;
import cn.yuntangnet.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 张茂林
 * @since 2018/3/7 14:18
 */
@Controller
@RequestMapping("/business")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @Login
    @RequestMapping("/content")
    public String contentList(Model model) {
        List<BusinessContent> list = businessService.selectStartContent();
        model.addAttribute("list", list);
        return "businesscontent";
    }

    @Login
    @RequestMapping("/info/{id}")
    public String contentInfo(@PathVariable Long id, Model model) {
        BusinessContent businessContent = businessService.selectContentById(id);
        if (businessContent == null) {
            return "redirect:/member";
        }
        model.addAttribute("content", businessContent);
        return "businessinfo";
    }
/*
    @Login
    @RequestMapping("/order/${id}")
    @ResponseBody
    public ResultBean order(HttpServletRequest request, @LoginUser UserWechat wechat, @PathVariable(value = "id") Long contentId, @RequestParam Map<String, String> map) {
        BusinessContent content = businessService.selectContentById(contentId);
        if (content == null || !"1".equals(content.getContentStatus())) {
            return ResultBean.error("活动已结束");
        }

        BusinessOrder order = businessService.getUserOrder(wechat.getId(), contentId);
        if (order != null) {
            return ResultBean.error("您已报名!");
        }
        order = new BusinessOrder();
        Date date = new Date();

        order.setUserWechatId(wechat.getId());
        order.setOpenId(wechat.getOpenid());
        order.setOrderId(OrderIdUtil.getOrderId("WX"));
        order.setContentId(content.getId());
        order.setIpAddress(IPUtils.getIpAddr(request));
        order.setUserName(map.get("user_name"));
        order.setUserPhone(map.get("user_phone"));
        order.setPayMoney(content.getContentMoney());
        order.setPayType("1");
        order.setIsPay(false);
        order.setIsDone(false);
        order.setPlatformId(map.get("platform_id"));
        order.setPlatformPhone(map.get("platform_phone"));
        order.setPlatformName(map.get("platform_name"));
        order.setGmtCreate(date);
        order.setGmtModified(date);

        businessService.saveOrder(order);

        return ResultBean.ok();
    }*/
}
