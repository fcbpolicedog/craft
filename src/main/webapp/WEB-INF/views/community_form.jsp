<%--
  Created by IntelliJ IDEA.
  User: policedog
  Date: 2019/04/10
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>课程管理</title>
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
                问答管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">帖子表单</li>
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
                            <h3 class="box-title">${tbUser.id==null?"新增":"编辑"}帖子</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/Community/save" method="post" modelAttribute="community">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">

                                    <label for="isStudent"  class="col-sm-2 control-label">发帖人类型</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="isStudent" placeholder="请输入发帖人类型"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="userid"  class="col-sm-2 control-label">发帖人ID</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="userid" placeholder="请输入发帖人ID"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="isQuestion"  class="col-sm-2 control-label">帖子类型</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="isQuestion" placeholder="请输入帖子类型"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="fatherid"  class="col-sm-2 control-label">主贴ID</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="fatherid" placeholder="请输入主贴ID"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="content"  class="col-sm-2 control-label">帖子内容</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="content" placeholder="请输入帖子内容"/>
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
<!--<script>
    $(function () {
        Validate.init();
    });
</script>-->
</body>
</html>
