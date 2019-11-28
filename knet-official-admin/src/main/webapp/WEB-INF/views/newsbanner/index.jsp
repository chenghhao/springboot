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
            <li>banner管理</li>
        </ul>

        <div class="newsEditInput">
            <div class="result bannerRes">
                <span class="btn btn-custom addNews" id="addBanBtn">添加Banner</span>（拖动图片排序）

                <div class="bannerMain" id="bannerList">

                </div>
            </div>
        </div>

        <div class="bannerAdd" id="bannerAdd" style="display: none;">
            <div class="banenrEdit">
                <div class="form-group">
                    <label class="col-sm-3 control-label">图片：</label>
                    <div class="col-sm-8">
                        <div class="btn btn-custom fileBtn">
                            <span>选择图片</span>
                            <input class="fileup" type="file" id="file" name="file" onchange="upload(this)">
                        </div>
                        <p class="fileImg">
                            <a id="fileImgUrl" href="${news.cover}" target="_blank">
                                <img class="cover1" id="cover1" name="cover1" src="${news.cover}"/>
                            </a>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">链接地址：</label>
                    <div class="col-sm-8">
                        <textarea name="link" id="link" class="form-control" rows="2" cols=""
                                  placeholder="链接地址">${news.title }</textarea>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script src="${ctx}/asset/js/common/jquery-3.3.1.min.js"></script>
<script src="${ctx}/asset/js/common/bootstrap.min.js"></script>
<script src="${ctx}/asset/js/common/layer.js"></script>
<script src="${ctx}/asset/js/common/common.js"></script>
<script src="${ctx}/asset/js/common/ajax-upload.js"></script>
<script src="${ctx}/asset/js/news/dragSort.js"></script>
<script src="${ctx}/asset/js/news/newsBanner.js"></script>
</body>
</html>