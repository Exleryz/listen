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
    编号:${library.id}
    src:${library.src}
    标题:${library.title}
    子题数:${library.sonCount}
    上传者:${library.teacher.name}
    <div>
        <button>添加子题</button>
        <button>删除子题</button>

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