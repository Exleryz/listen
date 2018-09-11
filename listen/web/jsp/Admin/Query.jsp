<%--
  Created by IntelliJ IDEA.
  User: Exler
  Date: 2018/9/11
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-1.4.1.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">

    function sub() {
        $.ajax({
            type: "GET",   //提交的方法
            url: "${pageContext.request.contextPath}/AdminAction_queryHistory", //提交的地址
            data: $('#myForm').serialize(),// 序列化表单值
            async: true,
            error: function (request) {  //失败的话
                alert("Connection error");
            },
            success: function (data) {  //成功
                alert(data);  //就将返回的数据显示出来
                // window.location.href="跳转页面"
            }
        });

    }

</script>
<body>
<form id="myForm" action="">
    <input type="text" name="studentName"/>
    <input type="text" name="studentAccount"/>
    <input type="text" name="score"/>
    <input type="text" name="scoreOperator"/>
    <input type="text" name="grade"/>
    <input type="text" name="check"/>
    <input type="text" name="timeStart"/>
    <input type="text" name="timeEnd"/>
    <input type="button" onclick="sub()" value="查询">
</form>
</body>
</html>
