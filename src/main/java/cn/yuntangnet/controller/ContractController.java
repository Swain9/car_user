package cn.yuntangnet.controller;

import cn.yuntangnet.annotation.Login;
import cn.yuntangnet.annotation.LoginUser;
import cn.yuntangnet.pojo.SystemContract;
import cn.yuntangnet.pojo.UserWechat;
import cn.yuntangnet.service.ContractService;
import cn.yuntangnet.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 张茂林
 * @since 2018/1/11 10:51
 */
@Controller
@RequestMapping("/contract")
public class ContractController {

    @Value("${hetong}")
    private String hetong;

    private final ContractService contractService;


    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @Login
    @RequestMapping("/my")
    @ResponseBody
    public ResultBean myContract(@LoginUser UserWechat wechat, int total) {
        List<SystemContract> list = contractService.getByUserId(wechat.getId(), total);
        return ResultBean.ok(list);
    }


    @Login
    @RequestMapping("/save")
    @ResponseBody
    public ResultBean save(@LoginUser UserWechat wechat, SystemContract systemContract, MultipartFile annexFile1, MultipartFile annexFile2) throws IOException {

        return ResultBean.error("错误的请求");
/*

        String[] split = systemContract.getOrderId().split(",");
        ResultBean check = contractService.checkOrderId(split);

        if (check.getCode() != 200) {
            return check;
        }
        List<SystemContract> list = (List<SystemContract>) check.getData();

        String uuidfilename1 = uuidFilename(annexFile1.getOriginalFilename());
        String uuidfilename2 = uuidFilename(annexFile2.getOriginalFilename());

        List<String> orderList = new ArrayList<>();

        for (SystemContract save : list) {
            orderList.add(save.getOrderId());

            save.setAnnex1(uuidfilename1);
            save.setAnnex2(uuidfilename2);

            save.setUserName(systemContract.getUserName());
            save.setUserPhone(systemContract.getUserPhone());
            save.setAgentName(systemContract.getAgentName());
            save.setSendId(wechat.getId());
            save.setSendName(wechat.getNickname());
            save.setContractStatus("2");

            save.setGmtModified(new Date());

        }
        saveFile(annexFile1, annexFile2, orderList, uuidfilename1, uuidfilename2);


        contractService.updateBatch(list);

        return ResultBean.ok();
*/

        /*SystemContract exit = contractService.getByOrderId(systemContract.getOrderId());

        if (exit == null) {
            return ResultBean.error("订单编号不存在");
        }
        //1.未提交
        if (!"1".equals(exit.getContractStatus())) {
            return ResultBean.error("该合同已提交");
        }
        contractService.update(exit);
        */
    }

    /**
     * 文件的保存目录
     *
     * @param orderId
     * @return
     */
    private String fullPathFile(String uuidFilename, String orderId) {
        String fullPath = hetong + "/" + orderId + "/" + uuidFilename;
        return fullPath;
    }

    private String fullPath(String orderId) {
        return hetong + "/" + orderId + "/";
    }

    /**
     * 文件名
     *
     * @param filename
     * @return
     */
    private String uuidFilename(String filename) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String uuidFilename = uuid + filename.substring(filename.lastIndexOf("."));
        return uuidFilename;
    }

    private void saveFile(MultipartFile file1, MultipartFile file2, List<String> orderList, String uuidfilename1, String uuidfilename2) throws IOException {
        String order1 = orderList.get(0);
        String fullPath1 = fullPathFile(uuidfilename1, order1);
        File saveFile1 = new File(fullPath(order1));
        if (!saveFile1.exists()) {
            saveFile1.mkdirs();
        }
        file1.transferTo(new File(fullPath1));

        String fullPath2 = fullPathFile(uuidfilename2, order1);
        File saveFile2 = new File(fullPath(order1));
        if (!saveFile2.exists()) {
            saveFile2.mkdirs();
        }
        file2.transferTo(new File(fullPath2));

        int len = orderList.size();
        for (int i = 1; i < len; i++) {
            String orderId = orderList.get(i);
            String saveFullPath1 = fullPathFile(uuidfilename1, orderId);
            String saveFullPath2 = fullPathFile(uuidfilename2, orderId);

            if (!Files.exists(Paths.get(fullPath(orderId)))) {
                Files.createDirectory(Paths.get(fullPath(orderId)));
            }

            Files.copy(Paths.get(fullPath1), Paths.get(saveFullPath1));
            Files.copy(Paths.get(fullPath2), Paths.get(saveFullPath2));

        }

        /*if (file != null && file.getSize() > 0) {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String filename = file.getOriginalFilename();
            String uuidFilename = uuid + filename.substring(filename.lastIndexOf("."));
            String fullPath = hetong + "/" + orderId + "/" + uuidFilename;
            File file1 = new File(fullPath);
            if (!file1.exists()) {
                file1.mkdirs();
            }
            file.transferTo(file1);
            return uuidFilename;
        }
        return null;*/
    }
}
