<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>后台管理系统</title>
    <link rel="shortcut icon" href="${ctx}/static/web/images/favicon.ico"/>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx}/static/back/css/adminstyle.css">
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
</head>
<body>
<!-- 布局容器 -->
<div class="layui-layout layui-layout-admin">
    <!-- 头部 -->
    <div class="layui-header">
        <div class="layui-main">
            <!-- logo -->
            <span style="font-size: 20px;color: #fff;margin: auto 0">LOGO</span>
            <!-- 水平导航 -->
            <ul class="layui-nav" style="position: absolute; top: 0; right: 0; background: none;">
                <li class="layui-nav-item">
                    <a href="http://www.layui.com" target="_blank">访问官网</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        admin
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">个人信息</a></dd>
                        <dd><a href="javascript:;">修改密码</a></dd>
                        <dd><a href="javascript:;" onclick="logout()">退出登录</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <!-- 侧边栏 -->
    <div class="layui-side layui-bg-black layui-larry-side">
        <div class="user-photo">
            <a class="img" title="我的头像">
                <img src="${ctx}/static/back/images/pic.jpg" class="userimg1"></a>
            <p>你好！admin, 欢迎登录</p>
        </div>
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="left-nav" style="border-radius: 0;">

            </ul>
        </div>
    </div>

    <!-- 主体 -->
    <div class="layui-body" style="bottom: 0px">
        <!-- 顶部切换卡 -->
        <div class="layui-tab layui-tab-brief" lay-filter="top-tab" lay-allowClose="true"
             style="margin: 0;overflow: hidden">
            <ul class="layui-tab-title"></ul>
            <div class="layui-tab-content"></div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${ctx}/static/layui/layui.js"></script>
<script type="text/javascript">
    /**
     * 对layui进行全局配置
     */
    layui.config({
        base: '${ctx}/static/back/js/'
    });

    //可使用ajax从数据库中获取
    var menuData = [
        {id: '1', name: '学生管理', pid: '0', url: '${ctx}/page/index'},
    ]

    layui.use(['cms'], function () {
        var cms = layui.cms('left-nav', 'top-tab');
        cms.addNav(menuData, 0, 'id', 'pid', 'name', 'url');
        cms.bind(60 + 41); //头部高度 + 顶部切换卡标题高度 + 顶部切换卡内容padding + 底部高度
        cms.clickLI(0);
    });

    function logout() {
        var index;
        index = parent.layui.layer.confirm("你确定退出登录吗？", {
            btn: ['确定', '取消'] //按钮
        }, function () {
            parent.layui.layer.close(index);
            window.location.href="${ctx}/back/logout"
        });
    }


</script>
</body>
</html>