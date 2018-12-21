<%--
  Created by IntelliJ IDEA.
  User: Zml
  Date: 2017/2/18
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="weui-tabbar">
    <a href="http://app.yuntangnet.cn/index/index/uploadpact.html" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <i class="icon-message"></i>
        </div>
        <p class="weui-tabbar__label">合同上传</p>
    </a>
    <a href="${pageContext.request.contextPath}/page/wo" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <i class="icon-order"></i>
        </div>
        <p class="weui-tabbar__label">提交工单</p>
    </a>
    <a href="${pageContext.request.contextPath}/page/member" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <i class="icon-buddy"></i>
        </div>
        <p class="weui-tabbar__label">个人中心</p>
    </a>
</div>