<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交工单</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <link href="${pageContext.request.contextPath}/css/wechat.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/weui.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>
<body ontouchstart>
<div id="container" class="container">
    <div class="weui-tab" id="tab">
        <div class="weui-tab__panel">
            <div class="weui-tab__content" style="display: block;">
                <form id="form">
                    <div class="weui-cells__title">工单信息</div>
                    <div class="weui-cells weui-cells_form">
                        <%--
                       weui-cell_select-before|weui-cell_select-after|默认（无）三种下拉样式
                       需要分别搭配weui-cell_hd,bd,ft使用
                       --%>
                        <div class="weui-cell weui-cell_select weui-cell_select-after">
                            <div class="weui-cell__hd">
                                <label class="weui-label">工单类型：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <select id="select_type" class="weui-select" name="orderType">
                                    <option value="">请选择</option>
                                    <option value="1">报单资料</option>
                                    <option value="2">直通车</option>
                                    <option value="3">奖金奖励</option>
                                    <option value="4">团购出车</option>
                                    <option value="5">合同跟踪</option>
                                    <option value="6">积分发放</option>
                                    <option value="7">交车资料</option>
                                    <option value="8">云堂商城</option>
                                    <option value="9">话费油卡</option>
                                    <option value="10">代理底单</option>
                                    <option value="11">报单汇总</option>
                                </select>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">联系号码：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="user_phone" name="userPhone" class="weui-input" type="tel"
                                       required pattern="REG_PHONE" placeholder="请输入联系号码"
                                       emptytips="请输入号码" notmatchtips="请输入正确的号码">
                            </div>
                            <div class="weui-cell__ft">
                                <%--警告显示的原因是：weui-cells_form--%>
                                <i class="weui-icon-warn"></i>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">代理区域：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="agent_area" name="agentArea" class="weui-input" type="text"
                                       required pattern="REG_JNAME" placeholder="请输入您的代理区域"
                                       emptytips="请输入代理区域" notmatchtips="请输入正确的信息">
                            </div>
                            <div class="weui-cell__ft">
                                <%--警告显示的原因是：weui-cells_form--%>
                                <i class="weui-icon-warn"></i>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">代理商姓名：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="agent_name" name="agentName" class="weui-input" type="text"
                                       required pattern="REG_JNAME" placeholder="请输入您的姓名"
                                       emptytips="请输入姓名" notmatchtips="请输入正确的信息">
                            </div>
                            <div class="weui-cell__ft">
                                <%--警告显示的原因是：weui-cells_form--%>
                                <i class="weui-icon-warn"></i>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">资料上传：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="annex" name="annexFile" class="weui-input" type="file">
                            </div>
                            <div class="weui-cell__ft">
                                <%--警告显示的原因是：weui-cells_form--%>
                                <i class="weui-icon-warn"></i>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">问题描述：</label>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__bd">
                                <textarea class="weui-textarea" name="question" placeholder="请输入问题" rows="3"></textarea>
                                <div class="weui-textarea-counter"><span>0</span>/200</div>
                            </div>
                        </div>
                    </div>
                    <div class="weui-cells">
                        <a id="ordersub" href="javascript:;" class="weui-btn weui-btn_primary">提交工单</a>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="foot.jsp"/>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/weui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/zepto.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wechat.js"></script>
<script type="text/javascript">
    var paystatus = 1;
    $(function () {

        var max = 200;
        $('textarea').on('input', function () {
            var text = $(this).val();
            var len = text.length;
            $('.weui-textarea-counter span').text(len);
            if (len > max) {
                $(this).closest('.weui-cell').addClass('weui-cell_warn');
            }
            else {
                $(this).closest('.weui-cell').removeClass('weui-cell_warn');
            }
        });

        //生成订单,这里有问题：Deferred long-running timer task(s) to improve scrolling smoothness
        //猜测与顶部提示有关。开启了多个定时器
        $("#ordersub").on("click", function () {
            if (paystatus == 0) {
                return;
            }
            weui.form.validate("#form", function (error) {
                if (!error) {
                    var file = $("#annex")[0].files[0];
                    if (file && file.size > 5 * 1024 * 1024) {
                        weui.alert("上传文件请小于5M！");
                        return false;
                    }
                    var orderType = $("#select_type").val();
                    if (orderType == "" || orderType == undefined) {
                        weui.alert("请选择工单类型！");
                        return false;
                    }
                    var text = $(".weui-textarea").val();
                    if (text.length > 200) {
                        weui.alert("描述字符限制,请上传附件！");
                        return false;
                    }

                    paystatus = 0;
                    var loading = weui.loading("提交中...");
                    var ele_form = document.getElementById("form");
                    var formdata = new FormData(ele_form);
                    $.ajax({
                        type: "POST",
                        url: baseURL + "/order/save",
                        // json.stringify():login,register
                        data: formdata,
                        processData: false,
                        contentType: false,
                        success: function (data) {
                            if (data.code != 200) {
                                alert("传输失败");
                            } else {
                                window.location.href = baseURL + '/page/my'
                            }
                            loading.hide();
                            paystatus = 1;
                        },
                        error: function (xhr, type) {
                            loading.hide();
                            weui.alert("网络异常！");
                            paystatus = 1;
                        }
                    });
                    // setTimeout(function () {
                    //     loading.hide();
                    //     weui.toast('提交成功', 3000);
                    // }, 1500);
                }
                // return true; // 当return true时，不会显示错误
            }, {
                regexp: {
                    PHONE: /^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\d{8}$/,
                    JNAME: /^[\u4E00-\u9FA5a-zA-Z0-9_]{2,20}$/
                }
            });
        });

    });
</script>
</body>
</html>

