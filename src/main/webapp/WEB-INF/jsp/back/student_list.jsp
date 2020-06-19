<%--
  Created by IntelliJ IDEA.
  User: yu_chen
  Date: 2018/3/6
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../public/commonCss.jsp" %>
    <%@include file="../public/commonJs.jsp" %>
    <title>Title</title>
</head>
<body class="pd" ms-controller="main" class="ms-controller">
<button class="layui-btn layui-btn-small">新增学生</button>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="150">
        <col width="200">
        <col width="200">
        <col width="200">
        <col width="200">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>联系方式</th>
        <th>班级</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <tr ms-repeat="tabledata">
        <td>{{el.stunum}}</td>
        <td>{{el.name}}</td>
        <td>{{el.sex}}</td>
        <td>{{el.age}}</td>
        <td>{{el.phone}}</td>
        <td>{{el.clazz}}</td>
        <td>
            <button class="layui-btn layui-btn-mini">修改</button>
            <button class="layui-btn layui-btn-mini layui-btn-danger">删除</button>
        </td>
    </tr>
    </tbody>
</table>

<script type="javascript">
    var vm;
    avalon.ready(function () {
        vm = avalon.define({
            $id: "main",
            tableData: [],
            loadTableData: function () {
                ajaxUtil.post("${ctx}/student/list", "", false, function (data) {
                    console.log(data.data);
                    vm.tableData = data.data
                })
            }
        });
        avalon.scan();
    });

    $(function () {
        alert("asdasd")
        vm.loadTableData();
    })

</script>
</body>
</html>
