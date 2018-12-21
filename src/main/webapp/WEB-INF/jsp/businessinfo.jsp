<%--

  Created by IntelliJ IDEA.
  User: 45022
  Date: 2018/3/8
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>活动详情</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <link href="${pageContext.request.contextPath}/css/wechat.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/weui.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container" class="container">
    <div class="weui-tab" id="tab">
        <div class="weui-tab__panel">
            <div class="weui-tab__content" style="display: block;">
                <form id="form">
                    <div class="weui-cells__title">商学院活动</div>
                    <div class="weui-cells">
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">活动主题:</label>
                            </div>
                            <div class="weui-cell__bd">
                                <label class="weui-label">${content.contentTheme}</label>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">活动讲师：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <label class="weui-label">${content.contentTeacher}</label>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">报名费用：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <label class="weui-label">${content.contentMoney}</label>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">活动说明：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <textarea class="weui-textarea" placeholder="活动说明" rows="3"
                                          readonly>${content.contentDetails}</textarea>
                            </div>
                        </div>
                    </div>
                    <div class="weui-cells">
                        <c:choose>
                            <c:when test='${content.contentStatus.equals("1")}'>
                                <a id="ordersub" href="javascript:;" class="weui-btn weui-btn_primary">我要报名</a>
                            </c:when>
                            <c:otherwise> <a href="#" class="weui-btn weui-btn_warn">活动已结束</a></c:otherwise>
                        </c:choose>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/weui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/zepto.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wechat.js"></script>
<script type="text/javascript">
    $(function () {
        $("#ordersub").on("click",function () {

            var loading = weui.loading("提交中...");

            $.ajax({
                type: "POST",
                url: baseURL + "/business/order/${content.id}",
                success: function (data) {
                    if (data.code != 200) {
                        alert("传输失败");
                    } else {
                        window.location.href = baseURL + '/page/my'
                    }
                    loading.hide();
                },
                error: function (xhr, type) {
                    loading.hide();
                    weui.alert("网络异常！");
                }
            })
        });
        function onBridgeReady() {
            WeixinJSBridge.invoke(
                'getBrandWCPayRequest', {
                    "appId": "wx2421b1c4370ec43b",     //公众号名称，由商户传入
                    "timeStamp": "1395712654",         //时间戳，自1970年以来的秒数
                    "nonceStr": "e61463f8efa94090b1f366cccfbbb444", //随机串
                    "package": "prepay_id=u802345jgfjsdfgsdg888",
                    "signType": "MD5",         //微信签名方式：
                    "paySign": "70EA570631E4BB79628FBCA90534C63FF7FADD89" //微信签名
                },
                function (res) {
                    if (res.err_msg == "get_brand_wcpay_request:ok") {
                    }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                }
            );
        }

        if (typeof WeixinJSBridge == "undefined") {
            if (document.addEventListener) {
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            } else if (document.attachEvent) {
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        } else {
            onBridgeReady();
        }
    })
</script>
</body>
</html>
