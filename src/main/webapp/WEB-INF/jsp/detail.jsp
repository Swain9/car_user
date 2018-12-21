<%--
  Created by IntelliJ IDEA.
  User: 45022
  Date: 2017/12/17
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工单详情</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <link href="${pageContext.request.contextPath}/css/wechat.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/weui.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>
<body ontouchstart>
<div class="container">
    <div class="weui-tab__panel">
        <div class="weui-tab__content" style="display: block;">
            <div class="weui-cells__title">工单信息</div>
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <label class="weui-label">工单类型：</label>
                    </div>
                    <div class="weui-cell__ft">
                        ${orderTypeName}
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <label class="weui-label">联系号码：</label>
                    </div>
                    <div class="weui-cell__ft">
                        ${order.userPhone}
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <label class="weui-label">代理区域：</label>
                    </div>
                    <div class="weui-cell__ft">
                        ${order.agentArea}
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <label class="weui-label">代理商姓名：</label>
                    </div>
                    <div class="weui-cell__ft">
                        ${order.agentName}
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <label class="weui-label">问题描述：</label>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" name="question" disabled="disabled" placeholder="无" rows="3">${order.question}</textarea>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <label class="weui-label">处理意见：</label>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" name="question" disabled="disabled" placeholder="等待处理" rows="3">${order.msg}</textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/weui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/zepto.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wechat.js"></script>
</body>
</html>
