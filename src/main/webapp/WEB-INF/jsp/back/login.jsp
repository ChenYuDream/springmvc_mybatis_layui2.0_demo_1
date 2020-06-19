<%--
  Created by IntelliJ IDEA.
  User: ChenYu
  Date: 2017-06-05
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../public/commonCss.jsp" %>
    <%@include file="../public/commonJs.jsp" %>
    <title>后台管理demo</title>
</head>
<body>
<div class="layui-canvs"></div>
<div class="login-main" id="login" style="display: block;">
    <header class="layui-elip" style="color: #1aa194;">后台管理demo</header>
    <form class="layui-form" id="loginform">
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input name="userName" lay-verify="required" placeholder="请输入登录用户名" type="text" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input name="password" lay-verify="required" placeholder="请输入登录密码" type="password" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" lay-submit="" lay-filter="login" class="layui-btn">登录</button>

        </div>
        <div class="layui-input-inline login-btn">
            <button type="button"  lay-filter="register" onclick=" window.location.href = '${ctx}/back/register';"
                    class="layui-btn layui-btn-warm">注册
            </button>
        </div>

    </form>
</div>
<script type="text/javascript">

    //监听提交
    form.on('submit(login)', function (data) {
        ajaxUtil.postDealCode('${ctx}/back/check', data.field, true, function (data) {
            if (data.code == 0) {
                window.location.href = "${ctx}/back/main";
            } else if (data.code == -2) {
                layui.layer.alert('用户名或密码不正确', {closeBtn: 0});
            }
        })
        return false;
    });

</script>
</body>
</html>
