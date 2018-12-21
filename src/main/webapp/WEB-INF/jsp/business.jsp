<%--
  Created by IntelliJ IDEA.
  User: 45022
  Date: 2018/3/7
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商学院</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <link href="${pageContext.request.contextPath}/css/wechat.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/weui.min.css" rel="stylesheet" type="text/css">
</head>
<body ontouchstart>
<div id="container" class="container">
    <div class="home">
        <div class="weui-tab" id="tab">
            <div class="weui-tab__panel">
                <div class="weui-tab__content" style="display: block;">
                    <div class="weui-cells">
                        <a href="${pageContext.request.contextPath}/business/content"
                           class="weui-cell weui-cell_access">
                            <div class="weui-cell__hd">
                                <%--<i class="home__icon-wallet___1dSK- home__icon___2XgfG"></i>--%>
                            </div>
                            <div class="weui-cell__bd">
                                <p>商学院培训</p>
                            </div>
                        </a>
                        <a href="${pageContext.request.contextPath}/business/order"
                           class="weui-cell weui-cell_access">
                            <div class="weui-cell__hd">
                                <%--<i class="home__icon-card___3sda4 home__icon___2XgfG"></i>--%>
                            </div>
                            <div class="weui-cell__bd">
                                <p>我的报名</p>
                            </div>
                        </a>
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
