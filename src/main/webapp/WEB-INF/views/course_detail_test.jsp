<%--
  Created by IntelliJ IDEA.
  User: policedog
  Date: 2019/05/10
  Time: 16:16
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
                课程详情
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">课程详情</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">课程详情</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive ">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style="width: 600px;">
                                            <a>
                                                <img src="${course.pic}" style="width: 180px;height:100px;float: left;">
                                            </a>
                                            <div class="ml-15 w-350" style="float:left;">
                                                <a href="/course/detail?id=${course.id}">
                                                    <p class="ellipsis"><strong>${course.coursename}</strong></p>
                                                    <p class="ellipsis-multi h-40">简介：${course.courseinfo}</p>
                                            </div>
                                        </td>
                                        <td>
                                            <p><fmt:formatDate value="${course.created}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                                            <p style="color: #ff0000;">教师编号${course.teacherid}</p>
                                            <p>${course.coursetype}</p>
                                        </td>
                                        <td>
                                            <p>手艺技能 / 视频教学</p>
                                            <p>${course.studentnum}人在学</p>
                                            <p><fmt:formatDate value="${course.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                                        </td>
                                        <td>
                                            <a href="/course/form?id=${course.id}" type="button" class="btn btn-sm  btn-primary"><i class="fa fa-edit"></i> 编辑课程</a>&nbsp;&nbsp;&nbsp;
                                            <a href="/course/comment?id=${course.id}" type="button" class="btn btn-sm  btn-primary"><i class="fa fa-edit"></i> 课程评论</a>
                                        </td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->

                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <!--<th><input type="checkbox" class="minimal icheck_master" /></th>-->
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${sectionList}" var="section">
                                    <tr>
                                        <!--<td><input id="" type="checkbox" class="minimal" /></td>-->
                                        <td>${section.sectionid}${section.title}(${section.sectiondate})</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
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
