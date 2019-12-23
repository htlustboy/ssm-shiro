<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/common.jsp"></jsp:include>
<link rel="stylesheet" href="/resource/css/style.css"></link>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎</title>

</head>
<body>

<div id="wrapper">
    <div class="overlay"></div>
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

        <div class="container" style="background: #ffffff">
            <form action="/user/save" method="post" id="userForm">
                <table class="table">
                    <tr>
                        <td>用户名</td>
                        <td><input type="text" name="user.username" value="${user.username}"></td>
                    </tr>
                    <tr>
                        <td>昵称</td>
                        <td><input type="password" name="user.password" id="${user.password}"></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>重复密码</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>是否管理员</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>是否启用</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>备注</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>备注</td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<!-- /#wrapper -->

</body>
</html>

<script>

</script>