<%--
  Created by IntelliJ IDEA.
  User: policedog
  Date: 2019/04/06
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>课程编辑</title>
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
                课程管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">课程编辑</li>
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
                            <h3 class="box-title">编辑课程</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/course/save" method="post" modelAttribute="course">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">

                                    <label for="coursename"  class="col-sm-2 control-label">课程名</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="coursename" placeholder="请输入课程名"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="teacherid"  class="col-sm-2 control-label">教师ID</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="teacherid" placeholder="请输入教师ID"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="coursetype"  class="col-sm-2 control-label">课程类型</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="coursetype" placeholder="请输入课程类型"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="courseinfo"  class="col-sm-2 control-label">课程介绍</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="courseinfo" placeholder="请输入课程介绍"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="teacherinfo"  class="col-sm-2 control-label">教师介绍</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="teacherinfo" placeholder="请输入教师介绍"/>
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
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">课程评论</h3>
                            <div class="row" style="padding-left: 15px;padding-top: 10px;">
                                <button type="button" onclick="App.deleteMulti('/course/commentdelete')" class="btn btn-sm  btn-default"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;&nbsp;&nbsp;
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive ">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master" /></th>
                                    <th>ID</th>
                                    <th>课程ID</th>
                                    <th>学生ID</th>
                                    <th>课程评论</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${courseCommentList}" var="courseComment">
                                    <tr>
                                        <td><input id="${courseComment.id}" type="checkbox" class="minimal" /></td>
                                        <td>${courseComment.id}</td>
                                        <td>${courseComment.courseid}</td>
                                        <td>${courseComment.studentid}</td>
                                        <td>${courseComment.comment}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>
<!--自定义模态框-->
<sys:modal />
<script>
    $(function () {
        $("#dataTable").DataTable({
            "paging":true,
            "info":true,
            "lengthChange":false,
            "ordering":false,
            "processing":true,
            "searching":false,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });
    });
</script>
</body>
</html>
