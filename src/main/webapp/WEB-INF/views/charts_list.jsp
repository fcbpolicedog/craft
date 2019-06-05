<%--
  Created by IntelliJ IDEA.
  User: policedog
  Date: 2019/05/25
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>课程统计</title>
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
                课程统计
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">课程统计</li>
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
                            <h3 class="box-title">课程统计</h3>
                            <a href="/charts/clicks" type="button" class="btn btn-sm  btn-primary"><i class="fa fa-edit"></i> 点击量统计</a>&nbsp;&nbsp;&nbsp;
                            <a href="/charts/totaltime" type="button" class="btn btn-sm  btn-primary"><i class="fa fa-edit"></i> 学习时长统计</a>&nbsp;&nbsp;&nbsp;
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive ">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>课程名</th>
                                    <th>总点击量</th>
                                    <th>总学习时长</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${courseChartsVOList}" var="courseChartsVO">
                                    <tr>
                                        <td>${courseChartsVO.id}</td>
                                        <td>${courseChartsVO.coursename}</td>
                                        <td>${courseChartsVO.clicks}</td>
                                        <td>${courseChartsVO.totaltime}</td>
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
