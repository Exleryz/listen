<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
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
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="js/jquery-1.12.4.js"></script>
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
    $(document).ready(function () {
        changpage(1);
    });

    function chbgcol(obj) {
        $("li").css({"background-color": "#FFF", "color": "#FFF"});
        $("li").removeClass("selected");
        /* background-color: #2E918C;
         color: #fff;
         cursor: pointer;*/
        $(obj).css({"background-color": "#2E918C", "color": "#fff"});
        $(obj).addClass("selected");
        id = $(obj).attr("id");
        showHistroy();
        $("#historyBox").show();

    }

    function showHistroy() {
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/StudentAction_getCurrentHistoryList",
            data: "currentCheck=" + id + "&&currentPage=" + currentPage,
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
                //$("#pageList").html('<s:iterator value="#pageBean.list" var="item" status="s"><tr><td><s:property value="#s.index +1"/></td><td><s:property value="#item.count"/></td><td><s:property value="#item.score"/></td> <td><s:property value="#item.classify == 1 ? '练习':'测试'"/></td> <td><s:property value="#item.lp.checkPoint"/></td> </tr></s:iterator>');
            }, error: function (data) {
                alert("error");
            },
        });
    }

    function changpage(pageNum) {
        currentPage
        alert(pageNum);
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/StudentAction_pageTest",
            data: "currentPage=" + pageNum,
            success: function (data) {
                console.log(data);
                var $tr =
                    console.log(data[""])
                //$("#pageList").html('<s:iterator value="#pageBean.list" var="item" status="s"><tr><td><s:property value="#s.index +1"/></td><td><s:property value="#item.count"/></td><td><s:property value="#item.score"/></td> <td><s:property value="#item.classify == 1 ? '练习':'测试'"/></td> <td><s:property value="#item.lp.checkPoint"/></td> </tr></s:iterator>');
            }, error: function (data) {
                alert("error");
            },
        });
    }

    function submitIdToSubject() {
        var checkId = $(".selected").attr("id"); //获取id
        alert(checkId);
        // $('img [z-index=100]').attr('class');///获取样式名称
        window.location.href = "${pageContext.request.contextPath}/Examination.jsp?checkId=" + checkId;
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
        <s:iterator begin="1" end="25" step="5" status="i">
            <%-- #{} 保证{}内的是ognl表达式--%>
            <ul class="row">
                <li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+1"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< (#i.index*5) ?"blue":"red"}'/>"><S:property
                        value="#i.index*5+1"/></font></li>
                <li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+2"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< #i.index*5+1 ?"blue":"red"}'/>"><S:property
                        value="#i.index*5+2"/></font></li>
                <li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+3"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< #i.index*5+2 ?"blue":"red"}'/>"><S:property
                        value="#i.index*5+3"/></font></li>
                <li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+4"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< #i.index*5+3 ?"blue":"red"}'/>"><S:property
                        value="#i.index*5+4"/></font></li>
                <li onclick="chbgcol(this)" class="item" id="<S:property value="#i.index*5+5"/>"><font
                        color="<s:property value='%{#session.student.currentCheck< #i.index*5+4 ?"blue":"red"}'/>"><S:property
                        value="#i.index*5+5"/></font></li>
            </ul>
        </s:iterator>
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
                <th>类别</th>
                <th>关数</th>
            </tr>
            </thead>
            <tbody id="pageList">

            </tbody>
        </table>

    </div>
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
<!-- 返回上一层 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
<s:debug></s:debug>