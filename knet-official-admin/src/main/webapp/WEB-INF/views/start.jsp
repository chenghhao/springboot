<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KNET官网后台管理系统</title>
    <link rel="apple-touch-icon" href="${ctx}/asset/images/favicon.ico"/>
    <link rel="Shortcut Icon" href="${ctx}/asset/images/favicon.ico"/>
    <link rel="stylesheet" href="${ctx}/asset/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/common/reset.css">
    <link rel="stylesheet" href="${ctx}/asset/css/start.css?v=20190313">
</head>

<body>

<div class="wrapper">

    <%@include file="common/aside.jsp" %>

    <div class="content-wrapper" style="font-size: 20px; text-align: left;padding: 20px;">
        <span class="user_name"> 欢迎您， <span>${userAccount.name}</span></span>
    </div>
</div>

<script src="${ctx}/asset/js/common/jquery-3.3.1.min.js"></script>
<script src="${ctx}/asset/js/common/bootstrap.min.js"></script>
<script src="${ctx}/asset/js/common/common.js"></script>
</body>
</html>