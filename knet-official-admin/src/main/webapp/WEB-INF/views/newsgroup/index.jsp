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
    <%@include file="../common/aside.jsp" %>
    <div class="content-wrapper">
        <ul class="breadcrumb">
            <li><a href="${ctx}/news/index">新闻管理</a></li>
            <li>分组管理</li>
        </ul>

        <div class="newsEditInput">
            <div class="result">
                <span class="btn btn-custom addNews" id="addGroup">新建分组</span>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>分组名称</th>
                        <th>文章数量</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="GroupList">

                    </tbody>
                </table>
                <div class="pages">
                    <ul class="pagination" id="page">

                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>
<script src="${ctx}/asset/js/common/jquery-3.3.1.min.js"></script>
<script src="${ctx}/asset/js/common/bootstrap.min.js"></script>
<script src="${ctx}/asset/js/common/layer.js"></script>
<script src="${ctx}/asset/js/common/common.js"></script>
<script src="${ctx}/asset/js/news/newsGroup.js"></script>
</body>
</html>