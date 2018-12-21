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
    <title>模板下载</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <link href="${pageContext.request.contextPath}/css/wechat.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/weui.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="weui-tab" id="tab">
        <div class="weui-tab__panel">
            <div class="weui-tab__content" style="display: block;">
                <div class="weui-cells__title">模板下载</div>
                <div class="weui-cells">
                    <a href="${pageContext.request.contextPath}/download/moban" class="weui-cell weui-cell_access">
                        <div class="weui-cell__bd">
                            奖金与直通车模板
                        </div>
                    </a>
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
