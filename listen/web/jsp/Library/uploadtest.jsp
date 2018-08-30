<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/12
  Time: 19:12
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
        <p>上传题目</p>
    </nav>
</header>
    <div class="update">
        <form action="${pageContext.request.contextPath}/LibraryAction_upload" method="post" enctype="multipart/form-data">
            标题:<input type="text" name="title"/>
            子题数:<input type="text" name="sonCount"/>
            音频文件<input type="file" name="listenLibrary"/>
            <br/>
            <input type="text" name="subjectList[0].sort"/>
            <input type="text" name="subjectList[0].answer"/>
            <input type="text" name="subjectList[0].optionA"/>
            <input type="text" name="subjectList[0].optionB"/>
            <input type="text" name="subjectList[0].optionC"/>
            <input type="text" name="subjectList[0].optionD"/>
            <input type="text" name="subjectList[0].analysis"/>
            <input type="submit" value="提交"/>
        </form>
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
