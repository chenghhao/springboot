<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" id="commonCtx" value="${ctx}">

<div class="aside">
    <div class="user-panel">
        <div class="pull-left image">
            <img src="${ctx}/asset/images/logo.png" alt="knet">
        </div>
        <div class="pull-left info">
            <p>${userAccount.name}</p>
            <p><a href="${ctx }/logout" class="btn btn-primary" title="退出登录">退出登录</a></p>
        </div>
    </div>
    <ul class="sidebar-menu">
        <li class=""><a href="${ctx}/" class="" data-url="index"><i class="fa fa-home"></i><span>首页</span></a></li>
        <li class="treeview">
            <a href="#"><i class="fa fa-newspaper-o"></i><span>新闻系统</span><i class="fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a href="${ctx}/news/index">新闻管理</a></li>
                <li><a href="${ctx}/newsgroup/index">分组管理</a></li>
                <li><a href="${ctx}/newsbanner/index">banner管理</a></li>
            </ul>
        </li>
        <!-- <li class=""><a href="${ctx }/my/password" title="修改密码"><i class="fa fa-wrench"></i><span>修改密码</span></a></li> -->
    </ul>
</div>
