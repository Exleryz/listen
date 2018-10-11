<%--
  Created by IntelliJ IDEA.
  User: Exler
  Date: 2018/4/18
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../css/main.css">
    <script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>
</head>
<script type="text/javascript">
</script>
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
                    <li><a href="${pageContext.request.contextPath}/jsp/Student/userinfo.jsp"><span
                            class="glyphicon glyphicon-user"></span>Personal Center</a></li>
                    <li><a href="${pageContext.request.contextPath}/sso/logout"><span
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
                <img src="../../images/1.jpg" class="img-circle userimg center-block">
            </div>
            <div class="col-md-8">
                <h4>
                    <p id="userid">Welcome: ${student.name}</p>
                    <span>Num: <span>${student.account}</span></span>
                </h4>
            </div>
        </div>
    </div>
</div>

<s:if test="#session.student.grade==0">
    <div class="contentuser center-block"><!-- 内容 -->
        <div class="container">
            <div class="row center-block">
                <div class="col-md-4">
                    <img src="../../images/big5.jpg" class=" taskimg conter-block">
                </div>
                <div class="col-md-4">
                    <h2 style="color: red">rating exam</h2>
                    <h6>First You Should Do This
                        <small>(hang in the air)</small>
                    </h6>
                    <button onclick="javascript:window.location.href='/page/user/initGrade.html'"
                            class="btn btn-block btn-success startbtn">Now Start
                    </button>
                </div>
            </div>
        </div>
    </div>
</s:if>
<div class="contentuser center-block">
    <div class="container">
        <div class="row center-block">
            <%--<div class="col-md-4">--%>
            <%--<img src="images/big5.jpg" class=" taskimg conter-block">--%>
            <%--<h2 class="text-muted">练习</h2>--%>
            <%--<button class="btn btn-block btn-success startbtn">开始</button>--%>
            <%--</div>--%>
            <%--<div class="col-md-4">--%>
            <%--<img src="images/big5.jpg" class=" taskimg conter-block">--%>
            <%--<h2 class="text-muted">测试</h2>--%>
            <%--<button class="btn btn-block btn-success startbtn">开始</button>--%>
            <%--</div>--%>
            <div class="col-md-6">
                <img src="../../images/oneplus_1.jpg" class=" taskimg conter-block">
                <h2 class="text-muted">闯关</h2>
                <%--加载 历史记录--%>
                <button class="btn btn-block btn-success startbtn" onclick="javascript:window.location.href='checkPointList.html'">开始</button>
            </div>

            <div class="col-md-6">
                <img src="../../images/oneplus_2.jpg" class=" taskimg conter-block">
                <h2 class="text-muted">资料</h2>
                <button class="btn btn-block btn-success startbtn">开始</button>
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
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
</body>
</html>
