package cn.yuntangnet.controller;

import cn.yuntangnet.annotation.Login;
import cn.yuntangnet.annotation.LoginUser;
import cn.yuntangnet.pojo.UserWechat;
import cn.yuntangnet.pojo.WorkOrder;
import cn.yuntangnet.service.WorkOrderService;
import cn.yuntangnet.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 张茂林
 * @since 2017/12/15 15:10
 */
@RequestMapping("/order")
@RestController
public class WorkOrderController {

    @Value("${upload}")
    private String upload;

    @Autowired
    private WorkOrderService workOrderService;

    @PostConstruct
    public void init() {
        File file = new File(upload);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Login
    @RequestMapping("/save")
    public ResultBean save(@LoginUser UserWechat user, WorkOrder workOrder, MultipartFile annexFile) throws IOException {
        if (user == null) {
            return ResultBean.error();
        }
        if (annexFile != null && annexFile.getSize() > 0) {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String filename = annexFile.getOriginalFilename();
            String uuidFilename = uuid + filename.substring(filename.lastIndexOf("."));
            workOrder.setAnnex(uuidFilename);
            annexFile.transferTo(new File(upload + "/" + workOrder.getAnnex()));
        }

        Date date = new Date();

        workOrder.setUserWechatId(user.getId());
        workOrder.setGmtCreate(date);
        workOrder.setGmtModified(date);
        workOrder.setOrderStatus("1");

        workOrderService.save(workOrder);

        return ResultBean.ok();
    }


    @Login
    @RequestMapping("/mywo")
    public ResultBean myOrder(@LoginUser UserWechat user, int total) {
        if (user == null) {
            return ResultBean.error();
        }
        List<WorkOrder> list = workOrderService.getOrderListByUserId(user.getId(), total);
        return ResultBean.ok(list);
    }
}
