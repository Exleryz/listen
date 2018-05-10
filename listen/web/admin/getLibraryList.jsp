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
        <p>题库题目列表</p>
    </nav>
</header>

<div class="testbox">
    <br/>
    <s:iterator value="#librariesList" var="item" status="state">
        <div id="<s:property value="#item.id"/>">
            题目名:<s:property value="#item.title"/>
            上传管理员:<s:property value="#item.teacher.name"/>
            <button>查看</button>
            <button>删除</button>
        </div>
    </s:iterator>
</div>
<div id="">
    <button>提交</button>
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