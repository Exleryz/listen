<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/22
  Time: 9:57
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
<header>
    <nav class="top">
        <p>考试界面</p>
    </nav>
</header>
<div class="testbox">
    <div class="testbox-title">
        题号:<span>1</span>
    </div>
    <div class="testfile">
        先给文件留个位置
        <!-- 这块放音频	 -->
    </div>
    <!-- 下面是4个选项，每个选项前用了laber，可以点击文字选中 -->
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <input type="radio" checked="checked" value="B" name="daan" id="a">
                选我,我是A
            </div>
            <div class="col-md-3">
                <label for="b">	<input type="radio" value="A" name="daan" id="b">
                    选我,我是B</label>
            </div>
            <div class="col-md-3">
                <label for="c">	<input type="radio" value="A" name="daan" id="c">
                    选我,我是C</label>
            </div>
            <div class="col-md-3">
                <label for="d">	<input type="radio" value="A" name="daan" id="d">
                    选我,我是D</label>
            </div>
        </div>
    </div>
    <div class="testbox-tip">
        <p>答案正确</p>
    </div>
    <div class="testbox-btn">
        <button class="btn btn-default">
            上一题
        </button>
        <button type="submit" class="btn btn-default">确定</button>
        <button class="btn btn-default">
            下一题
        </button>
        <button type="submit" class="btn btn-default">交卷</button>
    </div>
</div>
<!-- 返回上一层 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
