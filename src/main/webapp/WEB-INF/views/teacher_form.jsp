<%--
  Created by IntelliJ IDEA.
  User: policedog
  Date: 2019/03/25
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>教师管理</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                教师管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">教师表单</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbUser.id==null?"新增":"编辑"}教师</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/teacher/save" method="post" modelAttribute="teacher">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">

                                    <label for="email"  class="col-sm-2 control-label">邮箱</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required email" path="email" placeholder="请输入邮箱"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password"  class="col-sm-2 control-label">密码</label>

                                    <div class="col-sm-10">
                                        <form:password cssClass="form-control required" path="password" placeholder="请输入密码"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="username"  class="col-sm-2 control-label">用户名</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="username" placeholder="请输入用户名"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="phone"  class="col-sm-2 control-label">手机</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required mobile" path="phone" placeholder="请输入手机号码"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="pic"  class="col-sm-2 control-label">图片</label>

                                    <div class="col-sm-10">
                                        <form:input id="pic" cssClass="form-control" path="pic" placeholder="图片"/>
                                        <div id="dropz" class="dropzone">

                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="teacherinfo"  class="col-sm-2 control-label">教师简介</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="teacherinfo" placeholder="请输入教师简介"/>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>
<script>
    var myDropzone = new Dropzone("#dropz", {
        url: "/upload",
        paramName:"dropFile",
        dictDefaultMessage: '拖动文件至此或者点击上传',
        init:function () {
            this.on("success",function (file,data) {
                $("#pic").val(data.fileName);
            });
        }
    });
</script>
</body>
</html>