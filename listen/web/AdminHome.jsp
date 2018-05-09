<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/9
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<header class="clearfix"><!-- 头部 -->

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Listening Club</a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/userinfo.jsp"><span
                            class="glyphicon glyphicon-user"></span>Personal Center</a></li>
                    <li><a href="${pageContext.request.contextPath}/StudentAction_loginOut.action"><span
                            class="glyphicon glyphicon-log-in"></span>Sign out</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div class="contentuser center-block"><!-- 内容 -->
    <div class="container">
        <div class="row center-block">
            <div class="col-md-2">
                <img src="images/1.jpg" class="img-circle userimg center-block">
            </div>
            <div class="col-md-8">
                <h4>
                    <p> 管理员</p>
                    <%-- 待实现功能--%>
                    <button class="btn btn-success startbtn">我也要闯关</button>
                    <p id="userid">Welcome: ${admin.name}</p>
                    <span>Num: <span>${admin.account}</span></span>
                </h4>
            </div>
        </div>
    </div>
</div>

<div class="contentuser center-block">
    <div class="container">
        <div class="row center-block">
            <div class="col-md-6">
                <h2 class="text-muted" style="text-align: center;">闯关题库</h2>
                <%--设置每关标准--%>
                <%--设置每关题库池--%>
                <%--查看每关题库池--%>
                <button class="btn btn-success startbtn" onclick="javascript:window.location.href='#'">设置</button>
            </div>

            <div class="col-md-6">
                <h2 class="text-muted" style="text-align: center">听力题目</h2>
                <%--查看题目列表--%>
                <%--查看题目详情--%>
                <%--上传题目--%>
                <%--删除题目--%>
                <%--(第一版中不完成)--%>
                <%--修改题目--%>
                <%--查询题目--%>
                <button class="btn btn-success startbtn" onclick="javascript:window.location.href='#'">设置</button>
            </div>
        </div>
    </div>
</div>


<footer class="center-block footer">
    <div class="container">
        <div class="row center-block">
            <div class="col-md-6">
                <span>反馈邮箱：zyezhou@163.com &nbsp; &nbsp; &nbsp;联系方式：54188</span>
            </div>
            <div class="col-md-6">
                <span>@2018-2020 Wenzhou Demo Worker</span>
            </div>
        </div>
    </div>
</footer>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>

