$(function () {
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "H+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };
    //页面跳转不需要这个方法，单页面锚点需要
    // $(".weui-tabbar__item").on("click", function () {
    //     //.sibiling选择兄弟节点的时候没有加上.Class选择器
    //     $(this).addClass("weui-bar__item_on").siblings(".weui-bar__item_on").removeClass("weui-bar__item_on");
    // });
    //九宫格点击事件
    $(".weui-grid").on("click", function () {
        $(this).addClass("weui-bar__item_on").siblings(".weui-bar__item_on").removeClass("weui-bar__item_on");
    });
    showIcon();
    // 约定正则
    var regexp = {
        regexp: {
            PHONE: /^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9]|9[0-9])\d{8}$/,
            JNAME: /^[\u4E00-\u9FA5a-zA-Z0-9_]{2,20}$/,
            ORDER: /^[a-zA-Z]*\d{2}$|^\d{1,8}$/
        }
    };
    //todo我说怎么老是pay.jsp出错 失去焦点时检测
    weui.form.checkIfBlur("#form", regexp);
});

//底部导航图标样式改变
function showIcon() {
    var iconArr = ["contract", "wo", "member"];
    var href = window.location.href; //获取地址栏的路径名
    //http://192.168.0.88:8080/dispatcher?op=order
    //默认首页
    if (href.indexOf("/page/") == -1) {
        $(".weui-tabbar__item").eq(2).addClass("weui-bar__item_on");
    } else {
        var subHref = href.substring(href.indexOf("/page/") + 6, href.length);
        for (var i = 0; i < iconArr.length; i++) {
            if (subHref == iconArr[i]) {
                $(".weui-tabbar__item").eq(i).addClass("weui-bar__item_on");
                return;
            }
        }
    }
}

//请求前缀
var baseURL = "/app";
$.ajaxSettings = $.extend($.ajaxSettings, {
    dataType: "json",
    cache: false,
    complete: function (xhr) {
        //token过期，则跳转到登录页面,zepto不需要responseJSON
        var value = JSON.parse(xhr.response);
        if (value.code === 401) {
            parent.location.href = value.data;
        }
    }
});
/*
 * 频率控制 返回函数连续调用时，fn 执行频率限定为每多少时间执行一次
 * @param fn {function}  需要调用的函数
 * @param delay  {number}    延迟时间，单位毫秒
 * @param immediate  {bool} 给 immediate参数传递false 绑定的函数先执行，而不是delay后后执行。
 * @return {function}实际调用函数
 */
var throttle = function (fn, delay, immediate, debounce) {
    var curr = +new Date(),//当前事件
        last_call = 0,
        last_exec = 0,
        timer = null,
        diff, //时间差
        context,//上下文
        args,
        exec = function () {
            last_exec = curr;
            fn.apply(context, args);
        };
    return function () {
        curr = +new Date();
        context = this,
            args = arguments,
            diff = curr - (debounce ? last_call : last_exec) - delay;
        clearTimeout(timer);
        if (debounce) {
            if (immediate) {
                timer = setTimeout(exec, delay);
            } else if (diff >= 0) {
                exec();
            }
        } else {
            if (diff >= 0) {
                exec();
            } else if (immediate) {
                timer = setTimeout(exec, -diff);
            }
        }
        last_call = curr;
    }
};
var debounce = function (fn, delay, immediate) {
    return throttle(fn, delay, immediate, true);
};