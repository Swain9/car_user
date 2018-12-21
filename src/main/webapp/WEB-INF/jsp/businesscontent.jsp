<%--
  Created by IntelliJ IDEA.
  User: 45022
  Date: 2018/3/7
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>活动列表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <link href="${pageContext.request.contextPath}/css/wechat.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/weui.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="weui-tab">
    <div class="weui-tab__panel">
        <div id="content_buddy" class="weui-tab__content" style="height:100%;overflow: scroll;display: block;">

            <c:forEach items="${list}" var="item" varStatus="status">
                <a class='weui-cell weui-cell_access' href='${pageContext.request.contextPath}/business/info/${item.id}'>
                    <div class='weui-cell__hd'></div>
                    <div class='weui-cell__bd'>
                        <div class='home__title___1stUx'>
                            <h4 class='home__name___a6nVC'>${item.contentTheme}</h4>
                            <span class='home__ext___1Twhh'>${item.contentTeacher}</span>
                        </div>
                        <p class='home__description___uf2CS'>
                            <fmt:formatDate value="${item.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/> -
                            <fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </p>
                    </div>
                </a>
            </c:forEach>

        </div>
    </div>
</div>
<script>

</script>
</body>
</html>
