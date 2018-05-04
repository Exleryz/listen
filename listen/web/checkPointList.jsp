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
<script type="text/javascript">
    function chbgcol(obj) {
        $("li").css({"background-color": "#FFF", "color": "#FFF"});
        $("li").removeClass("selected");
        /* background-color: #2E918C;
         color: #fff;
         cursor: pointer;*/
        $(obj).css({"background-color": "#2E918C", "color": "#fff"});
        $(obj).addClass("selected");
    }

    function submitIdToSubject() {
        var checkId = $(".selected").attr("id"); //获取id
        alert(checkId);
        // $('img [z-index=100]').attr('class');///获取样式名称
        window.location.href="${pageContext.request.contextPath}/StudentAction_initSubject?checkId="+checkId;
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
        <button class="btn btn-success"
                onclick="submitIdToSubject()">
            开始考试
        </button>
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