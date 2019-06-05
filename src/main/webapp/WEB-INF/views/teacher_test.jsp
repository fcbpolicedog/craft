<%--
  Created by IntelliJ IDEA.
  User: policedog
  Date: 2019/05/13
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>课程列表</title>
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
                教师列表
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">教师列表</li>
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
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">教师列表</h3>
                            <div class="row" style="padding-left: 15px;padding-top: 10px;">
                                <a href="/teacher/form" type="button" class="btn btn-sm  btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;
                                <button type="button" onclick="App.deleteMulti('/teacher/delete')" class="btn btn-sm  btn-default"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;&nbsp;&nbsp;
                            </div>
                            <div class="box-tools">
                                <form action="/teacher/search" method="post">
                                    <div class="input-group input-group-sm" style="width: 150px;">
                                        <input type="text" name="keyword" class="form-control pull-right" placeholder="搜索">

                                        <div class="input-group-btn">
                                            <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive ">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master" /></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${teacherList}" var="teacher">
                                    <tr>
                                        <td><input id="${teacher.id}" type="checkbox" class="minimal" /></td>
                                        <td style="width: 600px;">
                                            <a>
                                                <img src="${teacher.pic}" style="width: 180px;height:100px;float: left;">
                                            </a>
                                            <div class="ml-15 w-350" style="float:left;">
                                                <a href="#">
                                                    <p class="ellipsis"><strong>${teacher.username}</strong></p>
                                                    <p class="ellipsis-multi h-40">简介：${teacher.teacherinfo}</p>
                                            </div>
                                        </td>
                                        <td>
                                            <p>${teacher.phone}</p>
                                            <p style="color: #ff0000;">${teacher.email}</p>

                                        </td>
                                        <td>
                                            <p>手艺技能 / 教学名师</p>
                                            <p><fmt:formatDate value="${teacher.created}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                                            <p><fmt:formatDate value="${teacher.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                                        </td>
                                        <td>
                                            <a href="/teacher/form?id=${teacher.id}" type="button" class="btn btn-sm  btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;
                                            <a href="/teacher/detail?id=${teacher.id}" type="button" class="btn btn-sm  btn-primary"><i class="fa fa-edit"></i> 详情</a>
                                        </td>
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
