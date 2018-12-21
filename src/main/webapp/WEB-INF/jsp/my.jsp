<%--
  Created by IntelliJ IDEA.
  User: Zml
  Date: 2017/2/19
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的工单</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <link href="${pageContext.request.contextPath}/css/wechat.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/weui.min.css" rel="stylesheet" type="text/css">
</head>
<body ontouchstart>
<div class="weui-tab">
    <div class="weui-tab__panel">
        <div id="content_buddy" class="weui-tab__content" style="height:100%;overflow: scroll;">
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/weui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/zepto.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wechat.js"></script>
<script type="text/javascript">
    function getOrderType(type) {
        switch (type) {
            case '1':
                return '报单资料';
            case '2':
                return '直 通 车';
            case '3':
                return '奖金奖励';
            case '4':
                return '出彩记录';
            case '5':
                return '合同跟踪';
            case '6':
                return '积分发放';
            case '7':
                return '交车资料';
            case '8':
                return '云堂商城';
            case '9':
                return '话费油卡';
            case '10':
                return '代理底单';
            case '11':
                return '报单汇总';
        }
    }

    function getOrderStatus(status) {
        switch (status) {
            case '1':
                return '未处理';
            case '2':
                return '已处理';
        }
    }

    function loadmore() {
        if (inajax) {
            return;
        }
        var scrollTop = $("#content_buddy").scrollTop();
        var window_height = $(window).height();
        if (scrollTop + window_height >= content_buddy_height) {
            inajax = true;
            begin_load();
        }
    }

    function begin_load() {
        var loading_friend = weui.loading("数据加载中");
        $.ajax({
            type: 'POST',
            url: baseURL + '/order/mywo',
            data: {"total": total},
            timeout: 5000,

            success: function (datas, status, xhr) {
                var content_buddy = $("#content_buddy");
                if (datas && datas.code === 200) {
                    var data = datas.data;
                    if (data.length > 0) {
                        total += data.length;
                        content_buddy_height += data.length * 70;
                        var result = '';
                        for (var i in data) {
                            if (data.hasOwnProperty(i)) {
                                var orderType = getOrderType(data[i].orderType);
                                var orderStatus = getOrderStatus(data[i].orderStatus);
                                var url = "${pageContext.request.contextPath}/order/details/" + data[i].id;
                                result += "<a class='weui-cell weui-cell_access' href='" + url + "'><div class='weui-cell__hd'></div><div class='weui-cell__bd'><div class='home__title___1stUx'><h4 class='home__name___a6nVC'>" + orderType + "</h4><span class='home__ext___1Twhh'>" + orderStatus + "</span></div><p class='home__description___uf2CS'>" + new Date(data[i].gmtCreate).Format("yyyy-MM-dd HH:mm:ss") + "</p></div></a>";
                            }
                        }
                        content_buddy.append(result);
                        content_buddy.show();
                    }
                    if (data.length < 10) {
                        content_buddy.off("scroll");
                        content_buddy.append("<div class='weui-loadmore weui-loadmore_line'><span class='weui-loadmore__tips'>暂无数据</span></div>");
                    }
                }
                loading_friend.hide();
                inajax = false;
            },
            error: function (xhr, errorType, error) {
                location.reload();
            }
        });
    }

    var total = 0;
    var content_buddy_height = 0;
    var inajax = false;
    //$(".weui-tab__content").on("scroll", throttle(loadmore, 500));
    $(function () {
        begin_load();
        $("#content_buddy").on("scroll", loadmore);
    });
</script>
</body>
</html>
