<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KNET官网后台管理系统</title>
    <link rel="apple-touch-icon" href="${ctx}/asset/images/favicon.ico"/>
    <link rel="Shortcut Icon" href="${ctx}/asset/images/favicon.ico"/>

    <link rel="stylesheet" href="${ctx}/asset/css/bootstrap-beta.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/common/reset.css">
    <link rel="stylesheet" href="${ctx}/asset/css/start.css?v=20190313">
    <link rel="stylesheet" href="${ctx}/asset/editor/summernote-bs4.css">
</head>

<body>
<div class="wrapper">
    <%@include file="../common/aside.jsp" %>
    <div class="content-wrapper">
        <ul class="breadcrumb">
            <li><a href="${ctx}/news/index">新闻管理</a></li>
            <li>新闻编辑</li>
        </ul>
        <div class="col-md-8 newsEditContent">

            <!-- 加载编辑器的容器 -->
            <div class="cont">
                <div id="summernote">
                    ${news.content }
                </div>

            </div>
        </div>
        <div class="col-md-4">
            <div class="newsEditInput">
                <form class="form-horizontal" method="post">
                    <div class="form-group form-group-save">
                        <button type="button" id="query" class="btn btn-custom">保存</button>
                    </div>
                    <div class="newsEdit">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="id" value="${news.id }">
                            <input type="hidden" class="form-control" id="cover" value="${news.cover }">
                            <label class="col-sm-2 control-label">标题：</label>
                            <div class="col-sm-10">
                                <textarea name="title" id="title" class="form-control" rows="2" cols=""
                                          placeholder="标题">${news.title }</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">关键字：</label>
                            <div class="col-sm-10">
                                <textarea name="keyword" id="keyword" class="form-control" rows="5" cols=""
                                          placeholder="关键字">${news.keyword }</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">摘要：</label>
                            <div class="col-sm-10">
                                <textarea name="digest" id="digest" class="form-control" rows="5" cols=""
                                          placeholder="摘要">${news.digest }</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">封面：</label>
                            <div class="col-sm-10">
                                <div class="btn btn-custom fileBtn">
                                    <span>选择文件</span>
                                    <input class="fileup" type="file" id="file" name="file" onchange="upload()">
                                </div>
                                <p class="fileImg">
                                    <a id="fileImgUrl" href="${news.cover}" target="_blank">
                                        <img class="cover1" id="cover1" name="cover1" src="${news.cover}"/>
                                    </a>
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">创建时间：</label>
                            <div class="col-sm-10">
                                <input name="createDate" value="<fmt:formatDate value="${news.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" type="text" class="form-control form-control-min" id="createDate"
                                       data-date-format="yyyy-mm-dd hh:ii:ss" readonly/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">分类：</label>
                            <div class="col-sm-10">
                                <select id="selectpicker" class="selectpicker show-tick form-control" multiple>
                                    <!-- <option value="">无</option> -->
                                    <c:forEach items="${gr }" var="g">
                                        <option value="${g.id }"
                                                <c:forEach items="${glist }" var="l">
                                                    <c:if test="${g.id eq l.groupId }">selected</c:if>
                                                </c:forEach>>${g.groupName }
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<script src="${ctx}/asset/js/common/jquery-3.3.1.min.js"></script>
<script src="${ctx}/asset/js/common/bootstrap.min.js"></script>
<script src="${ctx}/asset/js/common/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/asset/js/common/bootstrap-select.min.js"></script>
<script src="${ctx}/asset/js/common/layer.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script> -->
<script src="${ctx}/asset/editor/summernote-bs4.js"></script>
<script src="${ctx}/asset/editor/summernote-zh-CN.js"></script>
<script src="${ctx}/asset/js/common/common.js"></script>
<script src="${ctx}/asset/js/common/ajax-upload.js"></script>
<script src="${ctx}/asset/js/news/newsEdit.js"></script>
</body>
</html>