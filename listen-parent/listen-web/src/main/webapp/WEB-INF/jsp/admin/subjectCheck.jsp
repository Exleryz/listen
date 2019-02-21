<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25
  Time: 10:07
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
    <script src="../../js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="../../../js/all.js"></script>
</head>
<style type="text/css">
    .testbox{
        width: 100%;
    }
</style>
<script type="text/javascript">
    var answer = new Array();
    var id;
    var count = 0;
    $(document).ready(function () {
        id = getParam("id");
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/library/queryLibrary",
            data: "libId="+id,
            dataType: "json",
            success: function (data) {
                console.log(data);
                    var $div = '<div id="' + (0 + 1) + '" style="display: none"><div class="testbox-title" style="margin-left: 20px">题号:<span>' + (0 + 1) + '</span></div><div  style="font-size: 2em;margin-left: 15px" >' + '<audio controls="controls" controlsList="nodownload" name="media"><source src="${pageContext.request.contextPath}'+data["data"]["src"]+'"></source></audio>' + '</div><div class="container" ><div class="row">';
                    $.each(data["data"]["subjects"], function (indexs, vals) {
                        //analysis[index] = vals["analysis"];
                        $div += (indexs + 1) + ".<br/>"
                        console.log(vals);
                        count+=1;
                                $div += '<div class="col-md-3"><label for="a">A.<input onclick="checkMe(this)" type="radio" value="A" name="' + count + '" >' + vals["optionA"] + '</label></div>';
                                $div += '<div class="col-md-3"><label for="b">B.<input onclick="checkMe(this)" type="radio" value="B" name="' + count + '" >' + vals["optionB"] + '</label></div>';
                                $div += '<div class="col-md-3"><label for="c">C.<input onclick="checkMe(this)" type="radio" value="C" name="' + count + '" >' + vals["optionC"] + '</label></div>';
                                $div += '<div class="col-md-3"><label for="d">D.<input onclick="checkMe(this)" type="radio" value="D" name="' + count + '" >' + vals["optionD"] + '</label></div><br/>';
                    });
                    $div += '</div></div></div>';
                    $("#question").append($div);
                $("#1").show();
            }, error: function (data) {
            },
        });
    });
    function checkMe(radio) {
        var name = $(radio).attr("name");
        $(radio).attr("checked", "checked");
        $("input[type='radio'][name='" + name + "']").removeAttr("checked");
        //$("radio[name='"+name+"']").removeAttr("checked");
        $(radio).attr("checked", "checked");
        $(radio).prop("checked", "checked");
    }
    function pre() {
        var id = $("#question >div:visible").attr("id");
        if (id > 1) {
            $("#" + id).hide();
            $("#" + (eval(id) - 1)).show();
            $("#" + id+" audio")[0].pause();
        }
        if (id==2){
            $("#preBut").hide();
        }
        if ($("#nextBut").is(':hidden')) {
            $("#nextBut").show();
        }
    }
    function next() {
        var id = $("#question >div:visible").attr("id");
        if (id < 5) {
            $("#" + id).hide();
            $("#" + (eval(id) + 1)).show();
            $("#" + id+" audio")[0].pause();
        }

        if ($("#nextBut").is(':hidden')) {
            $("#nextBut").show();
        }
        if ($("#preBut").is(':hidden')) {
            $("#preBut").show();
        }

        if (id == 4) {
            $("#subTest").show();
            $("#nextBut").hide();
        }

    }
    function sub() {
        var score = "";
        var size = $("#question input:last");
        var all = size.attr('name');
        for ( var index=0;index<all;index++) {
            var temp = $("input[type='radio'][name='" + (eval(index) + 1) + "'][checked='checked']").val();
            score += temp;
            score +=",";
        }
        score = score.substr(0,score.length-1);
        if(confirm("你确定要提交吗")){
        $.ajax({
            async: false,
            type: "POST",
            url: '${pageContext.request.contextPath}/user/submitScore',
            contentType: "application/x-www-form-urlencoded",
            data: {'answers':score,'checkPoint':<%=request.getParameter("checkId")%>},
            dataType: "json",
            success: function (data) {
                alert(data['data']);
                window.location.href = '${pageContext.request.contextPath}/page/user/checkPointList.html';
            },
            error: function (data) {
                alert("请先完成全部题目")
            }
        })
        }


    }
</script>
<body>
<header>
    <nav class="top">
        <p>查看题目</p>
    </nav>
</header>
<br>
<br>
<div class="testbox">
    <div id="question">


    </div>
</div>
<div id="subTest" class="text-right" style="margin-top: 50px;margin-right: 10px;display: none;">
    <button type="button" class="btn btn-default" onclick="sub()">交卷</button>
</div>
<!-- 返回上一层 -->
<a href="/page/admin/subjects.html" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

</body>
</html>