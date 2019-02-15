<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/10
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../../css/main.css">
</head>
<script type="text/javascript">
    var id;

    function chbgcol(obj) {
        $("li").css({"background-color": "#FFF", "color": "black"});
        $("li").removeClass("selected");
        $(obj).css({"background-color": "#2E918C", "color": "red"});
        $(obj).addClass("selected");
        id = $(obj).attr("id");
        //alert(id);
        // showDetails();
    }

    function submitIdToSettting() {
        var checkId = $(".selected").attr("id"); //获取id
        window.location.href = "${pageContext.request.contextPath}/page/admin/subjectEdit.html?currentCheck=" + checkId + "&currentGrade=1";
    }

    function showDetails() {
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/AdminAction_getCurrentScoreSet",
            data: "currentCheck=" + id + "&currentGrade=" + 1,
            dataType: "json",
            success: function (data) {
                console.log(data);
                totalPage = data["totalPage"];
                var $tr = '';
                $.each(data["list"], function (index, val) {
                    if (val["classify"] == 1) {
                        var type = "练习";
                    } else {
                        var type = "测试";
                    }
                    $tr += '<tr><td>' + (index + 1 + (currentPage - 1) * 5) + '</td><td>' + val["count"] + '</td><td>' + val["score"] + '</td><td>' + type + '</td><td>' + id + '</td></tr>';
                });
                $("#pageList").html($tr);
                console.log(data["list"]);
                $("#historyBox").show();
            }, error: function (data) {
                alert("error");
            },
        });
    }
</script>
<body>
<header>
    <nav class="top">
        <p>点击查看关卡详情</p>
    </nav>
</header>
<div class="change">
    <div class="changebox">
        <c:forEach begin="0" end="4" step="1" var="i">
        <ul class="row">
            <li onclick="chbgcol(this)" class="item" id="${i*5+1}"><font
                    color="${user.currentCheck + 1< (i*5+1)?"blue":user.currentCheck + 1==(i*5+1)?"blue":"yellow"}">${i*5+1}</font></li>

            <li onclick="chbgcol(this)" class="item" id="${i*5+2}"><font
                    color="${user.currentCheck + 1< (i*5+2)?"blue":user.currentCheck + 1==(i*5+2)?"blue":"yellow"}">${i*5+2}</font></li>

            <li onclick="chbgcol(this)" class="item" id="${i*5+3}"><font
                    color="${user.currentCheck + 1< (i*5+3)?"blue":user.currentCheck + 1==(i*5+3)?"blue":"yellow"}">${i*5+3}</font></li>

            <li onclick="chbgcol(this)" class="item" id="${i*5+4}"><font
                    color="${user.currentCheck + 1< (i*5+4)?"blue":user.currentCheck + 1==(i*5+4)?"blue":"yellow"}">${i*5+4}</font></li>

            <li onclick="chbgcol(this)" class="item" id="${i*5+5}"><font
                    color="${user.currentCheck + 1< (i*5+5)?"blue":user.currentCheck + 1==(i*5+5)?"blue":"yellow"}">${i*5+5}</font></li>

        </ul>
        </c:forEach>
    </div>
    <br>

    <div class="starttest">
        <button class="btn btn-success" onclick="submitIdToSettting()">设置当前选中关卡</button>
    </div>
</div>
<!-- 返回上一层 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

<script type="text/javascript" src="../../../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../../js/main.js"></script>
</body>
</html>