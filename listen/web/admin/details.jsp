<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/10
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<header>
    <nav class="top">
        <p>点击查看关卡详情</p>
    </nav>
</header>

<div class="testbox">
    编号: <input type="text" name="id" value="${lp.id}"/><br>
    关卡等级:<input type="" name="grade" value="${lp.grade}"/><br>
    当前关:<input type="text" name="grade" value="${lp.checkPoint}"/><br>
    通关分数:<input type="text" name="grade" value="${lp.score}"/><br>
    每次闯关题目数:<input type="text" name="grade" value="${lp.subjectCount}"/><br>
    <s:iterator value="#lp.librarieSet" var="lib" status="status">
        <s:property value="#status.index + 1"/>
        <input type="hidden" value="<s:property value="#lib.id"/>">
        <s:property value="#lib.title"/>
        <button>删除题目</button>
        <br>
    </s:iterator>
    <div>
        <button onclick="window.location.href='${pageContext.request.contextPath}/LibraryAction_getAllLibraries.action?lpId=${lp.id}'">添加题目</button>
    </div>
    <br/>
</div>
<div id="">
    <button>提交修改</button>
    <button>确定</button>
</div>

<!-- 返回上一层 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
</body>
</html>