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
            <form class="form-search" style="margin: 20px;margin-bottom: 40px;" id="searchForm" action="/user/list" method="post">
                <input class="input-medium search-query" placeholder="用户昵称" name="displayName" id="displayName" value="${pager.searchInfo.displayName}" type="text" />
                <button type="submit" class="btn-sm">查找</button>
                <button type="button" onclick="doClear()" class="btn-sm">重置</button>
                <button type="button" onclick="add()" style="float: right" class="btn-sm">新增用户</button>
                <input type="hidden" name="pageNo" id="pageNo" value="${pager.pageNo}">

            <table class="table">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" class="ids" id="ids"/>
                    </th>
                    <th>
                        用户名
                    </th>
                    <th>
                        用户昵称
                    </th>
                    <th>
                        是否是管理员
                    </th>
                    <th>
                        是否可用
                    </th>
                    <th>
                        备注
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty userList}">
                    <c:forEach items="${userList}" var="user" step="1">
                        <tr class="success">
                            <td>
                                <input type="checkbox" name="user.id" id="id" value="{user.id}">
                            </td>
                            <td>
                                    ${user.username}
                            </td>
                            <td>
                                    ${user.displayName}
                            </td>
                            <td>
                                <c:if test="${user.isAdmin==true}">
                                    是
                                </c:if>
                                <c:if test="${user.isAdmin!=true}">
                                    否
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${user.status==true}">
                                    可用
                                </c:if>
                                <c:if test="${user.status!=true}">
                                    禁用
                                </c:if>
                            </td>
                            <td>
                                    ${user.memo}
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                 <c:if test="${empty pager.result}">
                     <tr class="warning">
                         <td>没有找到相关记录...</td>
                     </tr>
                 </c:if>
                </tbody>
            </table>

            <div class="container">
                <div class="row myCenter">
                    <div>
                        <ul class="pagination col-md-5 col-center-block">
                            <c:if test="${pager.pageNo>1}">
                                <li><a href="#" onclick="doPage(${pager.pageNo-1})">上一页</a></li>
                            </c:if>
                           <c:if test="${pager.totalPageSize>pager.pageNo}">
                            <li><a href="#" onclick="doPage(${pager.pageNo+1})" >下一页</a></li>
                           </c:if>
                        </ul>
                        <span>共 ${pager.totalItems} 条记录，共 ${pager.totalPageSize} 页，当前第 ${pager.pageNo} 页</span>
                    </div>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>
<!-- /#wrapper -->

</body>
</html>

<script>

    function doPage(pageNo){
        $("#pageNo").val(pageNo);
        $("#searchForm").submit();
    }

    function doClear(){
        $("#displayName").val("");
    }

    function add() {
        location.href = "/user/add";
    }
</script>