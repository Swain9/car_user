<%--
  Created by IntelliJ IDEA.
  User: 45022
  Date: 2017/12/30
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同上传</title>
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
                    <div class="weui-cells__title">合同信息</div>
                    <div class="weui-cells weui-cells_form">
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">订单编号：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="order_id" name="orderId" type="hidden">
                                <a id="addOrderId" href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary">新增</a>
                                <a id="delOrderId" href="javascript:;" class="weui-btn weui-btn_mini weui-btn_default">删除</a>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__bd">
                                <textarea id="lblOrderId" class="weui-textarea" rows="3" disabled></textarea>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">手机号码：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="user_phone" name="userPhone" class="weui-input" type="tel"
                                       required pattern="REG_PHONE" placeholder="请输入联系号码"
                                       emptytips="请输入号码" notmatchtips="请输入正确的号码">
                            </div>
                            <div class="weui-cell__ft">
                                <i class="weui-icon-warn"></i>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">真实姓名：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="user_name" name="userName" class="weui-input" type="text"
                                       required pattern="REG_JNAME" placeholder="请输入您的姓名"
                                       emptytips="请输入姓名" notmatchtips="请输入正确的姓名">
                            </div>
                            <div class="weui-cell__ft">
                                <i class="weui-icon-warn"></i>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">所属代理：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="agent_area" name="agentName" class="weui-input" type="text"
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
                                <label class="weui-label">合同1页：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="annex1" name="annexFile1" class="weui-input" type="file"
                                       accept="image/gif,image/jpeg,image/jpg,image/png">
                            </div>
                            <div class="weui-cell__ft">
                                <%--警告显示的原因是：weui-cells_form--%>
                                <i class="weui-icon-warn"></i>
                            </div>
                        </div>
                        <div class="weui-cell">
                            <div class="weui-cell__hd">
                                <label class="weui-label">合同4页：</label>
                            </div>
                            <div class="weui-cell__bd">
                                <input id="annex2" name="annexFile2" class="weui-input" type="file"
                                       accept="image/gif,image/jpeg,image/jpg,image/png">
                            </div>
                            <div class="weui-cell__ft">
                                <%--警告显示的原因是：weui-cells_form--%>
                                <i class="weui-icon-warn"></i>
                            </div>
                        </div>
                    </div>
                    <div class="weui-cells">
                        <a id="ordersub" href="javascript:;" class="weui-btn weui-btn_primary">提交合同</a>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="foot.jsp"/>
    </div>
    <div id="orderIds" style="display: none;">
        <div class="weui-mask"></div>
        <div class="weui-dialog">
            <div class="weui-dialog__hd"><strong class="weui-dialog__title">订单编号</strong></div>
            <div class="weui-dialog__bd">
                <div class="weui-cells weui-cells_form">
                    <div class="weui-cell">
                        <div class="weui-cell__hd">
                            订单编号：
                        </div>
                        <div class="weui-cell__bd">
                            <input id="input_order_id" class="weui-input" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="weui-dialog__ft">
                <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_default">取消</a>
                <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary">确定</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/weui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/zepto.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wechat.js"></script>
<script>
    Array.prototype.indexOf = function (val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] === val) return i;
        }
        return -1;
    };

    Array.prototype.remove = function (val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };
    var paystatus = 1;
    var opentype = "del";
    var orderIds = [];
    $(function () {
        $("#addOrderId").on("click", function () {
            opentype = "add";
            $("#input_order_id").val("");
            $("#orderIds").css("display", "block");
        });
        $("#delOrderId").on("click", function () {
            opentype = "del";
            $("#input_order_id").val("");
            $("#orderIds").css("display", "block");
        });
        $("#orderIds").on("click", ".weui-dialog__btn", function () {
            if ($(this).text() === "取消") {
                $("#orderIds").css("display", "none");
            } else {
                var orderId = $("#input_order_id").val();
                if (!/^[a-zA-Z]*\d{2}$|^\d{1,8}$/.test(orderId)) {
                    weui.topTips("请输入正确编号");
                    return;
                }
                if (/^\d{1,8}$/.test(orderId)) {
                    orderId = checkOrderId(orderId);
                }
                doOrderId(orderId.toLocaleUpperCase());
                setValues();
                $("#orderIds").css("display", "none");
            }
        });

        function doOrderId(orderId) {
            if (opentype === "del") {
                orderIds.remove(orderId);
            } else if (opentype === "add") {
                var index = orderIds.indexOf(orderId);
                if (index === -1) {
                    orderIds.push(orderId);
                }
            }
        }

        function setValues() {
            var orderIdsStr = orderIds.join(",");
            $("#lblOrderId").val(orderIdsStr);
            $("#order_id").val(orderIdsStr);
        }

        function checkOrderId(orderId) {
            if (/^\d{1,8}$/.test(orderId)) {
                var intValue = parseInt(orderId);
                var x = parseInt(intValue / 100);
                var y = intValue % 100;

                var s = int2AAA(x);
                if (y < 10) {
                    s += "0" + y;
                } else {
                    s += y;
                }
                return s;
            }
        }

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

        function checkFile(file) {
            if (!file || file.size === 0) {
                weui.topTips("请上传合同！");
                return false;
            }

            if (file && file.size > 4 * 1024 * 1024) {
                weui.topTips("上传文件请小于4M！");
                return false;
            }
            return true;
        }

        function int2AAA(x) {
            if (x < 0)
                return "";

            var a = x / 26;
            var b = x % 26;
            return int2AAA(a - 1) + String.fromCharCode((b + 'A'.charCodeAt(0)));
        }

        //生成订单,这里有问题：Deferred long-running timer task(s) to improve scrolling smoothness
        //猜测与顶部提示有关。开启了多个定时器
        $("#ordersub").on("click", function () {
            if (paystatus == 0) {
                return;
            }
            weui.form.validate("#form", function (error) {
                if (!error) {
                    if(orderIds.length === 0){
                        weui.topTips("请填写编号");
                        return;
                    }

                    var file1 = $("#annex1")[0].files[0];
                    var file2 = $("#annex2")[0].files[0];
                    if (!checkFile(file1) || !checkFile(file2)) {
                        return false;
                    }
                    paystatus = 0;

                    var loading = weui.loading("提交中...");
                    var ele_form = document.getElementById("form");
                    var formdata = new FormData(ele_form);
                    $.ajax({
                        type: "POST",
                        url: baseURL + "/contract/save",
                        // json.stringify():login,register
                        data: formdata,
                        processData: false,
                        contentType: false,
                        success: function (data) {
                            if (data.code != 200) {
                                alert(data.msg);
                            } else {
                                window.location.href = baseURL + '/page/member'
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
                    PHONE: /^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9]|9[0-9])\d{8}$/,
                    JNAME: /^[\u4E00-\u9FA5a-zA-Z0-9_]{2,20}$/,
                    ORDER: /^[a-zA-Z]*\d{2}$|^\d{1,8}$/
                }
            });
        });

    });
</script>
</body>
</html>
