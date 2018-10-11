<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/21
  Time: 10:16
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
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../css/main.css">
    <script src="../../js/jquery-1.12.4.js"></script>

</head>
<style type="text/css">
    .btn_left {
        float: left;
        margin-left: 20px;
    }

    .btn_right {
        float: right;
        margin-right: 15px;
    }

</style>
<script type="text/javascript">
    var currentPage = 1;
    var id;
    var totalPage;

    <%--$(document).ready(function () {--%>
        <%--if (${sessionScope.get("student") == null}) {--%>
            <%--window.location.href = "../../login.jsp";--%>
        <%--} else {--%>
            <%--if (${sessionScope.get("student").getGrade() == 0 }) {--%>
                <%--alert("请先完成词汇测试");--%>
            <%--}--%>
        <%--}--%>
    <%--});--%>

    function chbgcol(obj) {
        $("li").css({"background-color": "#FFF", "color": "#FFF"});
        $("li").removeClass("selected");
        $(obj).css({"background-color": "#2E918C", "color": "#fff"});
        $(obj).addClass("selected");
        id = $(obj).attr("id");
        showHistroy();
    }

    function showHistroy() {
        //if (id <= <s:property value="%{#session.student == null ? -1: #session.student.currentCheck + 1}"/>) {
        if (id <= ${user==null?-1:user.currentCheck+1}) {
            console.log(id);
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/user/history",
                data: "checkPoint=" + id + "&pageNum=" + currentPage,
                dataType: "json",
                success: function (data) {
                    data=data["data"];
                    totalPage = data["pages"];
                    var $tr = '';
                    $.each(data["list"], function (index, val) {
                        $tr += '<tr><td>' + (index + 1 + (currentPage - 1) * 5) + '</td><td>' + val["count"] + '</td><td>' + val["score"] + '</td><td>' + id + '</td></tr>';
                    });
                    $("#pageList").html($tr);
                    console.log(data["list"]);
                    $("#historyBox").show();
                }, error: function (data) {
                    alert("error");
                },
            });
        } else {
            $("#historyBox").hide();
        }
    }

    function submitIdToSubject() {
        var checkId = $(".selected").attr("id"); //获取id
        //var currentId = <s:property value='%{#session.student.currentCheck + 1}'/>;
        var currentId = ${user.currentCheck+1};
        if (currentId >= checkId) {
            window.location.href = "${pageContext.request.contextPath}/page/user/Examination.html?checkId=" + checkId;
        } else {
            alert("请先通过之前的关卡！");
        }
    }

    function pre() {
        if (currentPage > 1) {
            currentPage -= 1;
            showHistroy();
        }
    }

    function next() {
        if (currentPage < totalPage) {
            currentPage += 1;
            showHistroy();
        }
    }
</script>
<body>
<header>
    <nav class="top">
        <p>选择关卡</p>
    </nav>
</header>

<div class="change">
    <div class="changebox">
        <%--<s:iterator begin="1" end="25" step="5" status="i">--%>
        <c:forEach begin="0" end="5" step="1" var="i">
            <%-- #{} 保证{}内的是ognl表达式--%>
            <%-- 当前关卡 == index red  < yellow > blue  --%>
            <ul class="row">
                <%--<li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+1"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< (#i.index*5) ?"blue":#session.student.currentCheck == (#i.index*5)? "red":"yellow"}'/>"><S:property
                        value="#i.index*5+1"/></font></li>
                <li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+2"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< #i.index*5+1 ?"blue":#session.student.currentCheck == (#i.index*5+1)? "red":"yellow"}'/>"><S:property
                        value="#i.index*5+2"/></font></li>
                <li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+3"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< #i.index*5+2 ?"blue":#session.student.currentCheck == (#i.index*5+2)? "red":"yellow"}'/>"><S:property
                        value="#i.index*5+3"/></font></li>
                <li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+4"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< #i.index*5+3 ?"blue":#session.student.currentCheck == (#i.index*5+3)? "red":"yellow"}'/>"><S:property
                        value="#i.index*5+4"/></font></li>
                <li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+5"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< #i.index*5+4 ?"blue":#session.student.currentCheck == (#i.index*5+4)? "red":"yellow"}'/>"><S:property
                        value="#i.index*5+5"/></font></li>--%>
                <li onclick="chbgcol(this)" class="item" id="${i*5+1}"><font
                        color="${user.currentCheck + 1< (i*5+1)?"blue":user.currentCheck + 1==(i*5+1)?"red":"yellow"}">${i*5+1}</font></li>

                <li onclick="chbgcol(this)" class="item" id="${i*5+2}"><font
                        color="${user.currentCheck + 1< (i*5+2)?"blue":user.currentCheck + 1==(i*5+2)?"red":"yellow"}">${i*5+2}</font></li>

                <li onclick="chbgcol(this)" class="item" id="${i*5+3}"><font
                        color="${user.currentCheck + 1< (i*5+3)?"blue":user.currentCheck + 1==(i*5+3)?"red":"yellow"}">${i*5+3}</font></li>

                <li onclick="chbgcol(this)" class="item" id="${i*5+4}"><font
                        color="${user.currentCheck + 1< (i*5+4)?"blue":user.currentCheck + 1==(i*5+4)?"red":"yellow"}">${i*5+4}</font></li>

                <li onclick="chbgcol(this)" class="item" id="${i*5+5}"><font
                        color="${user.currentCheck + 1< (i*5+5)?"blue":user.currentCheck + 1==(i*5+5)?"red":"yellow"}">${i*5+5}</font></li>

            </ul>
        <%--</s:iterator>--%>
        </c:forEach>
    </div>

    <div class="starttest" style="margin-top: 15px">
        <button class="btn btn-success"
                onclick="submitIdToSubject()">
            开始考试
        </button>
    </div>

    <div class="historybox" id="historyBox" style="display: none">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>编号</th>
                <th>次数</th>
                <th>成绩</th>
                <th>关数</th>
            </tr>
            </thead>
            <tbody id="pageList">
            <%--插入当前关卡 历史做题记录--%>
            </tbody>
        </table>
        <div class="clearfix">
            <div class="btn_left">
                <button class="btn btn-success"
                        onclick="pre()">
                    上一页
                </button>
            </div>
            <div class="btn_right">
                <button class="btn btn-success" style="margin-right: 10px"
                        onclick="next()">
                    下一页
                </button>
            </div>
        </div>
    </div>

</div>
<!-- 返回上一层 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
</body>
</html>