<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/static/common/taglib.jsp" %>
<%@include file="../../public/commonJs.jsp" %>
<%@include file="../../public/commonCss.jsp" %>
<div class="layui-form" style="padding: 10px">
    <input type="hidden" value="${studnet.id}" name="id">
    <div class="layui-form-item">
        <label class="layui-form-label"><span class="fontRed">*</span>学号：</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" lay-verify="required" placeholder="请输入人员编号"
                   value="${studnet.stunum}"
                   name="userNum"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span class="fontRed">*</span>姓名：</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" lay-verify="required" placeholder="请输入人员姓名"
                   name="username"
                   value="${studnet.name}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span class="fontRed"></span>所属部门：</label>
        <div class="layui-input-block">
            <select lay-verify="required">
                <option value="">--请选择部门--</option>
                <c:forEach var="bm" items="${bms}">
                    <option value="${bm.itemValue}"
                            <c:if test="${studnet.depNum eq bm.itemValue}">selected</c:if>>${bm.itemText}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span class="fontRed"></span>上岗资质：</label>
        <div class="layui-input-block">
            <c:forEach var="tt" items="${tts}">
                <input type="checkbox"
                       name="trainTypeNames[${tt.itemValue}]" title="${tt.itemText}"
                       value="${tt.itemText}"
                       <c:if test="${tt.isCheck=='true'}">checked</c:if>>
            </c:forEach>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span class="fontRed"></span>所属角色：</label>
        <div class="layui-input-block">
            <select name="roleType">
                <option value="">--请选择角色--</option>
                <c:forEach var="js" items="${jss}">
                    <option value="${js.itemValue}"
                            <c:if test="${studnet.roleType eq js.itemValue}">selected</c:if>>${js.itemText}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span class="fontRed"></span>手机号：</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" placeholder="请输入手机号"
                   name="phoneNum"
                   value="${studnet.phoneNum}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"></label>
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    var form = layui.form();
    form.render();

    //监听提交
    form.on('submit(demo1)', function (data) {
        ajaxUtil.postDealCode("${ctx}/userController/saveOrUpdate.action", data.field, false, function (data) {
            if (data.code == 0) {
                layerUtil.success("保存成功");
                parent.loadTableData();
            } else if (data.code == -2) {
                layerUtil.fail("用户编号已经存在")
            }

        });
        return false;
    });

    //加载下拉框数据
    function saveOrUpdate() {
        var dataStr = vm.$model.user;
        $.ajax({
            type: 'post',
            url: '${ctx}/userController/saveOrUpdate.action',
            data: dataStr,
            dataType: "json",
            timeout: 10000,
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.closeAll();
                    parent.layer.msg('保存成功', {icon: 1});
                    parent.loadTableData();
                } else if (data.code == -2) {
                    parent.layer.msg('用户编号已经存在', {icon: 2});
                } else {
                    parent.layer.msg('保存失敗', {icon: 2});
                }
            }
        });
    }

    //关闭对话框
    function closeLayer() {
        parent.layer.closeAll();
    }
</script>
