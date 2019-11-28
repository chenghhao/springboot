<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KNET官网后台管理系统</title>

    <link rel="stylesheet" href="${ctx}/asset/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="${ctx}/asset/css/common/reset.css">
    <link rel="stylesheet" href="${ctx}/asset/css/start.css?v=20190313">
</head>

<body>

<div class="wrapper">

    <%@include file="../common/aside.jsp" %>

    <div class="content-wrapper">
        <div class="rowAll">

            <div class="newsMan">
                <form class="form-inline">
                    <div class="form-group">
                        <label for="title">新闻标题：</label>
                        <input type="text" class="form-control" id="title" placeholder="标题">
                    </div>

                    <div class="form-group">
                        <label for="fromDate">创建日期 自：</label>
                        <input name="fromDate" value="" type="text" class="form-control form-control-min" id="fromDate"
                               data-date-format="yyyy-mm-dd" readonly/>
                        <span>至</span>
                        <input name="toDate" value="" type="text" class="form-control form-control-min" id="toDate"
                               data-date-format="yyyy-mm-dd" readonly/>
                    </div>
                    <div class="form-group">
                        <label for="group">新闻分组：</label>
                        <select id="group" name="group" class="form-control">
                            <option value="">全部</option>
                            <c:forEach items="${gr }" var="g">
                                <option value="${g.id }">${g.groupName }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="group">发布状态：</label>
                        <select id="status" name="status" class="form-control">
                            <option value="">全部</option>
                            <option value="N">未发布</option>
                            <option value="Y">已发布</option>
                        </select>
                    </div>
                    <button type="button" id="query" class="btn btn-custom">查询</button>
                </form>
            </div>

            <div class="result">
                <a href="${ctx }/news/toAdd" class="btn btn-custom addNews">添加文章</a>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>标题</th>
                        <th>创建时间</th>
                        <th>发布状态</th>
                        <th>阅读量</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="NewsTable">

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
<script src="${ctx}/asset/js/common/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/asset/js/common/layer.js"></script>
<script src="${ctx}/asset/js/common/common.js"></script>
<script src="${ctx}/asset/js/common/page.js"></script>
<script src="${ctx}/asset/js/news/newsIndex.js"></script>
</body>
</html>