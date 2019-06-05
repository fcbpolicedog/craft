<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/assets/img/admin.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${user.email}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">系统导航栏</li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-user"></i> <span>学生管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: none">
                    <li><a href="/student/list"><i class="fa fa-circle-o"></i>学生列表</a></li>
                    <li><a href="/student/form"><i class="fa fa-circle-o"></i>新增学生</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-graduation-cap"></i> <span>教师管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: none">
                    <li><a href="/teacher/test"><i class="fa fa-circle-o"></i>教师列表</a></li>
                    <li><a href="/teacher/form"><i class="fa fa-circle-o"></i>新增教师</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>课程管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: none">
                    <li><a href="/course/test"><i class="fa fa-circle-o"></i>课程列表</a></li>
                    <li><a href="/course/form"><i class="fa fa-circle-o"></i>新增课程</a></li>
                    <li><a href="/charts/list"><i class="fa fa-circle-o"></i>课程统计</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-gg-circle"></i> <span>问答管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: none">
                    <li><a href="/Community/list"><i class="fa fa-circle-o"></i>帖子列表</a></li>
                    <li><a href="/Community/form"><i class="fa fa-circle-o"></i>新增帖子</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-file-text"></i> <span>文章管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: none">
                    <li><a href="/article/list"><i class="fa fa-circle-o"></i>文章列表</a></li>
                    <li><a href="/article/form"><i class="fa fa-circle-o"></i>内容管理</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-camera"></i> <span>视频反馈</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: none">
                    <li><a href="/videomsg/list"><i class="fa fa-circle-o"></i>反馈信息列表</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa  fa-commenting"></i> <span>消息推送</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: none">
                    <li><a href="/message/list"><i class="fa fa-circle-o"></i>推送消息列表</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>