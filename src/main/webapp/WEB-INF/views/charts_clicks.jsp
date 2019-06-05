<%--
  Created by IntelliJ IDEA.
  User: policedog
  Date: 2019/05/25
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>课程统计</title>
    <jsp:include page="../includes/header.jsp"/>
    <script type="text/javascript" src="/assets/bower_components/jquery/dist/jquery.min.js"></script>
    <jsp:include page="../includes/footer.jsp"/>
    <script type="text/javascript">
        $(function () {
            $('#container').highcharts({
                credits:{
                    enabled:false
                },
                exporting:{
                    enabled:false
                },
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: 1,//null,
                    plotShadow: false,

                },
                title: {
                    text: '课程统计图表 点击量统计'
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                            }
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    name: '点击量比例',
                    data: ${datas}
                }]
            });
        });


    </script>
</head>
<body class ="hold-transition skin-blue sidebar-mini">
<script src="/assets/plugins/Highcharts/highcharts.js"></script>
<script src="/assets/plugins/Highcharts/modules/exporting.js"></script>
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
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">课程统计</li>
            </ol>
        </section>
        <div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
        <!-- Main content -->
        <section class="content">

        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>



</body>
</html>

