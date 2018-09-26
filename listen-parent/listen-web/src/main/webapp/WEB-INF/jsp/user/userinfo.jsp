<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/21
  Time: 10:16
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
    $(document).ready(function () {
        if (${sessionScope.get("student") == null})
        {
            window.location.href = "../../login.jsp";
        }

    });
</script>
<body>
<header class="bgcolor">

</header>
<div class="contentuser center-block userdiv"><!-- 内容 -->
    <div class="container">
        <div class="row center-block">
            <div class="col-md-4">
                <img src="../../images/1.jpg" class="img-circle userimg center-block">
            </div>
            <div class="col-md-8">
                <h4>
                    <p id="userid">${student.name}</p>
                    <span>帐号：<span>${student.account}</span></span>
                </h4>
            </div>
        </div>
    </div>
</div>

<!-- 用户下面的等级和类别，这里我留了2个位置，
  在等级后面添加标签即可 -->
<div class="info-content">
    <div class="lv"><p>等级: <s:if test="#session.student.grade == 0">无名小卒</s:if>
        <s:elseif test="#session.student.grade == 1">初生牛犊</s:elseif></p></div>
    <hr>
    <div class="userclass"><p>类别: ${sutdent.classify}</p></div>
</div>

<!-- 返回上一层组件 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>
<!-- 右上角设置组件 -->
<a href="#" class="userset">
    <span class="glyphicon glyphicon-cog"></span>
</a>

<script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
</body>
</html>
