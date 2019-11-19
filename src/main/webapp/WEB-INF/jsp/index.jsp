<jsp:include page="common/common.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>设备档案管理系统</title>
        <link href="favicon.ico" rel="shortcut icon" />
        <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style=" background: url('/resource/image/index/bg.jpg') no-repeat center center fixed; background-size: 100%;">

    <div class="modal-dialog" style="margin-top: 10%;">
        <form action="/login/login" id="loginForm" name="loginForm">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title text-center" id="myModalLabel">Welcome</h4>
                </div>
                <div class="modal-body" id = "model-body">
                    <div class="form-group">
                        <input type="text" class="form-control"placeholder="用户名" value="${username}" name="username" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="密码" value="${password}" name="password" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <h6 style="color: red">${errorMessage}</h6>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="form-group">
                        <button type="button" onclick="doSubmit()" class="btn btn-primary form-control">登录</button>
                    </div>
                    <div class="form-group">
                        <button type="button" onclick="doRegiter()" class="btn btn-default form-control">注册</button>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </form>
    </div><!-- /.modal -->
    </body>
</html>

<script>

    <!-- 登陆 -->
    function doSubmit(){
        var username = $("input[name='username']").val();
        var password = $("input[name='password']").val();
        if(username=='' || password==''){
            alert("用户名或密码不能为空！");
            return;
        }
        $("#loginForm").submit();
    }

</script>