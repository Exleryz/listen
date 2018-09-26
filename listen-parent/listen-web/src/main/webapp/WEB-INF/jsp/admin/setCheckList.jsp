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
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../css/main.css">
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
        window.location.href = "${pageContext.request.contextPath}/AdminAction_seeDetails?currentCheck=" + checkId + "&currentGrade=1";
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
        <ul class="row">
            <li class="item" onclick="chbgcol(this)" id="1">1</li>
            <li class="item" onclick="chbgcol(this)" id="2">2</li>
            <li class="item" onclick="chbgcol(this)" id="3">3</li>
            <li class="item" onclick="chbgcol(this)" id="4">4</li>
            <li class="item" onclick="chbgcol(this)" id="5">5</li>
        </ul>
        <ul class="row">
            <li class="item" onclick="chbgcol(this)" id="6">6</li>
            <li class="item" onclick="chbgcol(this)" id="7">7</li>
            <li class="item" onclick="chbgcol(this)" id="8">8</li>
            <li class="item" onclick="chbgcol(this)" id="9">9</li>
            <li class="item" onclick="chbgcol(this)" id="10">10</li>
        </ul>
        <ul class="row">
            <li class="item" onclick="chbgcol(this)" id="11">11</li>
            <li class="item" onclick="chbgcol(this)" id="12">12</li>
            <li class="item" onclick="chbgcol(this)" id="13">13</li>
            <li class="item" onclick="chbgcol(this)" id="14">14</li>
            <li class="item" onclick="chbgcol(this)" id="15">15</li>
        </ul>
        <ul class="row">
            <li class="item" onclick="chbgcol(this)" id="16">16</li>
            <li class="item" onclick="chbgcol(this)" id="17">17</li>
            <li class="item" onclick="chbgcol(this)" id="18">18</li>
            <li class="item" onclick="chbgcol(this)" id="19">19</li>
            <li class="item" onclick="chbgcol(this)" id="20">20</li>
        </ul>
        <ul class="row">
            <li class="item" onclick="chbgcol(this)" id="21">21</li>
            <li class="item" onclick="chbgcol(this)" id="22">22</li>
            <li class="item" onclick="chbgcol(this)" id="23">23</li>
            <li class="item" onclick="chbgcol(this)" id="24">24</li>
            <li class="item" onclick="chbgcol(this)" id="25">25</li>
        </ul>
    </div>

    <div class="historybox">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>编号</th>
                <th>时间</th>
                <th>成绩</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>001</td>
                <td>Rammohan</td>
                <td>Reddy</td>
            </tr>
            <tr>
                <td>002</td>
                <td>Smita</td>
                <td>Pallod</td>
            </tr>
            <tr>
                <td>003</td>
                <td>Rabindranath</td>
                <td>Sen</td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="starttest">
        <button class="btn btn-success" onclick="submitIdToSettting()">设置当前选中关卡</button>
    </div>
</div>
<!-- 返回上一层 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

<script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
</body>
</html>