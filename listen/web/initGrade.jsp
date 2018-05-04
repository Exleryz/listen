<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/20
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<style type="text/css">
    .top1 {
        color: #fff;
        font-size: 1.6rem;
        top: 0em;
        right: 1em;
        position: fixed;
    }
</style>
<script type="text/javascript">
    var answer = new Array();
    $(document).ready(function () {
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/StudentAction_initGrade",
            data: "",
            contentType: "json",
            dataType: "json",
            success: function (data) {

                $.each(data, function (index, val) {
                    var $div = '<div id="' + (index + 1) + '" style="display: none"><div class="testbox-title" style="margin-left: 20px">题号:<span>' + (index + 1) + '</span></div><div class="testfile" style="font-size: 2em;margin-left: 15px" >' + val["question"] + '</div><div class="container" ><div class="row">';
                    $.each(val["options"], function (indexs, vals) {
                        if (vals["answer"] == true) {
                            if (indexs == 0)
                                answer[index] = "A";
                            if (indexs == 1)
                                answer[index] = "B";
                            if (indexs == 2)
                                answer[index] = "C";
                            if (indexs == 3)
                                answer[index] = "D";
                        }
                        if (indexs == 0)
                            $div += '<div class="col-md-3"><label for="a">A.<input onclick="checkMe(this)" type="radio" value="A" name="' + (index + 1) + '" >' + vals["content"] + '</label></div>';
                        if (indexs == 1)
                            $div += '<div class="col-md-3"><label for="b">B.<input onclick="checkMe(this)" type="radio" value="B" name="' + (index + 1) + '" >' + vals["content"] + '</label></div>';
                        if (indexs == 2)
                            $div += '<div class="col-md-3"><label for="c">C.<input onclick="checkMe(this)" type="radio" value="C" name="' + (index + 1) + '" >' + vals["content"] + '</label></div>';
                        if (indexs == 3)
                            $div += '<div class="col-md-3"><label for="d">D.<input onclick="checkMe(this)" type="radio" value="D" name="' + (index + 1) + '" >' + vals["content"] + '</label></div>';
                    })
                    $div += '</div></div></div>';
                    $("#question").append($div);
                })
                $("#1").show();
                startTime()
            }, error: function (data) {
                alert("error");
            },
        });
    })

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
        }
    }

    function next() {
        var id = $("#question >div:visible").attr("id");
        if (id < 20) {
            $("#" + id).hide();
            $("#" + (eval(id) + 1)).show();
        }
    }

    var mi = 3;
    var se = 0;

    function startTime() {
        if (se == 0 && mi == 0) {
            document.getElementById('time').innerHTML = "00:00";
            alert("time out");
            sub();
            return;
        }
        if (se < 10 && mi >= 0 && se >= 0) {
            document.getElementById('time').innerHTML = "0" + mi + ":" + "0" + se;
            if (se == 0) {
                mi -= 1;
                se = 59;
            } else {
                se--;
            }
        } else {
            document.getElementById('time').innerHTML = "0" + mi + ":" + se;
            se--;
        }
        setTimeout('startTime()', 1000)
    }

    function sub() {
        var score = 0;
        for (var index in answer) {
            var temp = $("input[type='radio'][name='" + (eval(index) + 1) + "'][checked='checked']").val();
            if (temp == answer[index])
                score += 1;
        }
        window.location.href = '${pageContext.request.contextPath}/StudentAction_submitGrade?score=' + score;
        if (mi == 0 && se == 0) {
            alert("做题超时，已自动提交");
        } else {
            alert("恭喜您完成测试，再也不是无名小卒啦！");
        }
    }
</script>
<body>
<header>
    <nav class="top">
        <p>词汇量测试</p>
        <div class="text-right top1" id="time"></div>
    </nav>
</header>
<div class="testbox">
    <div id="question">


    </div>
    <div class="testbox-btn" style="margin: 5px;margin-top: 10px">
        <button class="btn btn-default" onclick="pre()">
            上一题
        </button>
        <button class="btn btn-default" onclick="next()">
            下一题
        </button>
    </div>
</div>
<div class="text-right" style="margin-top: 50px;margin-right: 10px">
    <button type="submit" class="btn btn-default" onclick="sub()">交卷</button>
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