<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KNET官网后台管理系统</title>
    <link rel="stylesheet" href="${ctx}/asset/css/common/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/common/reset.css">
    <link rel="stylesheet" href="${ctx}/asset/css/login.css?v=20190313">
</head>

<body class="login-bg">
<input id="commonCtx" type="hidden" value="${ctx}">
<div class="warper">
    <div id="content" class="content">
        <div class="header">
            <span>KNET 官网后台管理系统</span>
        </div>
        <div class="c_input">
            <form method="post">
                <div class="form-group">
                    <input name="username" id="j_username" type="input" class="form-control" placeholder="用户账号"/>
                </div>
                <div class="form-group">
                    <input type="password" id="j_password" name="password" class="form-control" placeholder="用户密码">
                </div>

                <button id="go" type="button" class="btn btn-danger btn-block">登 录</button>

                <div class="form-group error">
                    <span class="text-danger" id="error"></span>
                </div>
            </form>
        </div>
    </div>
    <div class="footer">
        <p>电信与信息服务业务经营许可证：京ICP证101069号 京ICP备09107995号 京公网安备11010802021188号 北龙中网（北京）科技有限责任公司 版权所有</p>
    </div>
</div>

<script src="${ctx}/asset/js/common/jquery-3.3.1.min.js"></script>
<script src="${ctx}/asset/js/common/bootstrap.min.js"></script>
<script src="${ctx}/asset/js/login.js"></script>
</body>
</html>