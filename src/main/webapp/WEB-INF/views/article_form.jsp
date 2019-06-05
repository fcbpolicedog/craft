<%--
  Created by IntelliJ IDEA.
  User: policedog
  Date: 2019/04/14
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>内容管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <%--<link rel="stylesheet" href="/assets/plugins/wangEditor/wangEditor.min.css"/>--%>
    <link rel="stylesheet" href="/assets/plugins/wangEditor/wangEditor.min.css">
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
                内容管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">文章表单</li>
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
                            <h3 class="box-title">${tbUser.id==null?"新增":"编辑"}文章</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/article/save" method="post" modelAttribute="article">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">

                                    <label for="writerid"  class="col-sm-2 control-label">作者ID</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="writerid" placeholder="请输入作者ID"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="title"  class="col-sm-2 control-label">文章标题</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="title" placeholder="请输入文章标题"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">文章内容</label>

                                    <div class="col-sm-10">
                                        <form:hidden path="content"/>
                                        <div id="editor">${article.content}</div>
                                        <%--<form:input cssClass="form-control required" path="content" placeholder="请输入文章内容"/>--%>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button id="btnSubmit" type="submit" class="btn btn-info pull-right">提交</button>
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
<%--<script src="/assets/plugins/wangEditor/wangEditor.min.js"/>--%>
<script src="/assets/plugins/wangEditor/wangEditor.min.js"></script>
<script>
    // var E = window.wangEditor
    // var editor = new E('#editor')
    // // 或者 var editor = new E( document.getElementById('editor') )
    // editor.create()
    $(function () {
        var E = window.wangEditor
        var editor = new E('#editor')
        // 或者 var editor = new E( document.getElementById('editor') )
        editor.create()

        $("#btnSubmit").bind("click",function () {
           var contentHtml = editor.txt.html();
           $("#content").val(contentHtml);
        });
    })
</script>
</body>
</html>
