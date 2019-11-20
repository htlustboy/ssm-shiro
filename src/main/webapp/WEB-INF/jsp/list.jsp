<jsp:include page="common/common.jsp"></jsp:include>
<link rel="stylesheet" href="/resource/css/style.css"></link>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎</title>

</head>
<body>

<div id="wrapper" class="toggled">
    <div class="overlay" style="display: block;"></div>
    <!-- Sidebar -->
    <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
        <ul class="nav sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    欢迎 ： ${user.principal}
                </a>
            </li>
            <li>
                <a href="/user/list"><i class="fa fa-fw fa-home"></i> 用户管理</a>
            </li>
            <li>
                <a href="/permission/list"><i class="fa fa-fw fa-folder"></i> 权限管理</a>
            </li>
            <li>
                <a href="/equipment/list"><i class="fa fa-fw fa-file-o"></i> 设备档案管理</a>
            </li>
            <li>
                <a href="/check/list"><i class="fa fa-fw fa-cog"></i>设备检测管理</a>
            </li>
            <li>
                <a href="/system/list"><i class="fa fa-fw fa-bank"></i> 系统配置</a>
            </li>
            <li>
                <a href="/record/list"><i class="fa fa-fw fa-dropbox"></i> 报表统计</a>
            </li>
            <li>
                <a href="/login/logout"><i class="fa fa-fw fa-twitter"></i> 注销</a>
            </li>
        </ul>
    </nav>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
        </button>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">

                </div>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

</body>
</html>