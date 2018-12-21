package cn.yuntangnet.controller;

import cn.yuntangnet.annotation.Login;
import cn.yuntangnet.pojo.UserWechat;
import cn.yuntangnet.pojo.WorkOrder;
import cn.yuntangnet.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 张茂林
 * @since 2017/12/15 11:48
 */
@Controller
public class PageController {

    @Autowired
    private WorkOrderService workOrderService;

    @Login
    @RequestMapping("/page/{name}")
    public String page(@PathVariable String name, Model model, HttpSession session) {
        if ("member".equals(name)) {
            UserWechat user = (UserWechat) session.getAttribute("user");
            model.addAttribute("wechat", user);
        }
        return name;
    }

    @Login
    @RequestMapping("/")
    public String index() {
        return "redirect:/page/member";
    }

    @Login
    @RequestMapping("/order/details/{id}")
    public String details(@PathVariable Long id, HttpServletRequest request) {
        WorkOrder workOrder = workOrderService.getById(id);
        if (workOrder != null) {
            String orderTypeName = getOrderType(workOrder.getOrderType());
            request.setAttribute("orderTypeName", orderTypeName);
            request.setAttribute("order", workOrder);
            return "detail";
        }
        return "my";
    }



    /**
     * <option value="1">报单资料</option>
     * <option value="2">直通车</option>
     * <option value="3">奖金奖励</option>
     * <option value="4">出彩记录</option>
     * <option value="5">合同跟踪</option>
     * <option value="6">积分发放</option>
     * <option value="7">交车资料</option>
     *
     * @param type
     * @return
     */
    private String getOrderType(String type) {
        switch (type) {
            case "1":
                return "报单资料";
            case "2":
                return "直通车";
            case "3":
                return "奖金奖励";
            case "4":
                return "团购出车";
            case "5":
                return "合同跟踪";
            case "6":
                return "积分发放";
            case "7":
                return "交车资料";
            case "8":
                return "云堂商城";
            case "9":
                return "话费油卡";
            case "10":
                return "代理底单";
            case "11":
                return "报单汇总";
            default:
                return "未知";
        }
    }
}
