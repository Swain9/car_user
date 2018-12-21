package cn.yuntangnet.aspect;

import cn.yuntangnet.pojo.BusinessOrder;
import cn.yuntangnet.util.MyDateUtil;
import cn.yuntangnet.util.OrderIdUtil;
import cn.yuntangnet.util.StringsUtil;
/*import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;*/
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 张茂林
 * @since 2018/4/4 10:02
 */

public class OrderAspect {

    //private final WxPayService wxPayService;

//    @Autowired
//    public OrderAspect(WxPayService wxPayService) {
//        this.wxPayService = wxPayService;
//    }


    public void sendWx(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        BusinessOrder order = (BusinessOrder) args[0];

        try {
            point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
/*
        WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = new WxPayUnifiedOrderRequest();
        wxPayUnifiedOrderRequest.setDeviceInfo("WEB");
        wxPayUnifiedOrderRequest.setNonceStr(StringsUtil.getUUID());
        wxPayUnifiedOrderRequest.setSignType("MD5");
        wxPayUnifiedOrderRequest.setBody("云堂-服务");
        wxPayUnifiedOrderRequest.setOutTradeNo(order.getOrderId());
        wxPayUnifiedOrderRequest.setFeeType("CNY");
        wxPayUnifiedOrderRequest.setTotalFee(Math.toIntExact(order.getPayMoney()));
        wxPayUnifiedOrderRequest.setSpbillCreateIp(order.getIpAddress());
        long time = System.currentTimeMillis();
        wxPayUnifiedOrderRequest.setTimeStart(MyDateUtil.getDateTimeStr(time));
        wxPayUnifiedOrderRequest.setTimeExpire(MyDateUtil.getDateTimeStr(time + 3600000));
        wxPayUnifiedOrderRequest.setNonceStr();

        try {
            wxPayService.unifiedOrder(new WxPayUnifiedOrderRequest());
        } catch (WxPayException e) {
            e.printStackTrace();
        }*/
    }
}
