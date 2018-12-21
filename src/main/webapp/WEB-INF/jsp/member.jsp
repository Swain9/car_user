<%--
  Created by IntelliJ IDEA.
  User: Zml
  Date: 2017/2/17
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <link href="${pageContext.request.contextPath}/css/wechat.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/weui.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>
<body ontouchstart>
<div id="container" class="container">
    <div class="home">
        <div class="weui-tab" id="tab">
            <div class="weui-tab__panel">
                <div class="weui-tab__content" style="display: block;">
                    <div class="weui-cells">
                        <a href="#" class="weui-cell weui-cell_access">
                            <div class="weui-cell__hd">
                                <img src="${wechat.headimgurl}" alt="" class="home__avatar___3hB8h">
                            </div>
                            <div class="weui-cell__bd">
                                <h4 class="home__nickname___3LZkJ">昵称：${wechat.nickname}</h4>

                                <p class=""></p>
                            </div>
                            <div class="weui-cell__ft">

                            </div>
                        </a>
                    </div>
                    <%--<div class="weui-cells">
                        <a href="${pageContext.request.contextPath}/page/business"
                           class="weui-cell weui-cell_access">
                            <div class="weui-cell__hd">
                                &lt;%&ndash;<i class="home__icon-wallet___1dSK- home__icon___2XgfG"></i>&ndash;%&gt;
                            </div>
                            <div class="weui-cell__bd">
                                <p>商学院</p>
                            </div>
                        </a>
                    </div>--%>
                    <div class="weui-cells">
                        <a href="${pageContext.request.contextPath}/page/my"
                           class="weui-cell weui-cell_access">
                            <div class="weui-cell__hd">
                                <%--<i class="home__icon-wallet___1dSK- home__icon___2XgfG"></i>--%>
                            </div>
                            <div class="weui-cell__bd">
                                <p>我的工单</p>
                            </div>
                        </a>
                        <a href="${pageContext.request.contextPath}/page/mycontract"
                           class="weui-cell weui-cell_access">
                            <div class="weui-cell__hd">
                                <%--<i class="home__icon-card___3sda4 home__icon___2XgfG"></i>--%>
                            </div>
                            <div class="weui-cell__bd">
                                <p>我的合同</p>
                            </div>
                        </a>
                    </div>
                    <div class="weui-cells">
                        <a href="${pageContext.request.contextPath}/page/dl"
                           class="weui-cell weui-cell_access">
                            <div class="weui-cell__hd">
                                <%--<i class="home__icon-wallet___1dSK- home__icon___2XgfG"></i>--%>
                            </div>
                            <div class="weui-cell__bd">
                                <p>模板下载</p>
                            </div>
                        </a>
                        <a href="https://pan.baidu.com/s/1nwlWnAp"
                           class="weui-cell weui-cell_access">
                            <div class="weui-cell__hd">
                                <%--<i class="home__icon-wallet___1dSK- home__icon___2XgfG"></i>--%>
                            </div>
                            <div class="weui-cell__bd">
                                <p>宣传资料</p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <jsp:include page="foot.jsp"/>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/weui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/zepto.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wechat.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/qrcode.min.js"></script>
</body>
</html>
