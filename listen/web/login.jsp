<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/8
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<script type="text/javascript">
    function submitRegister() {
        var balabala = document.getElementById("balabala").innerText;
        if (balabala=="账号格式不正确") {
            alert("填写内容格式不正确");
        }
        if (balabala=="该账号已存在") {
            alert("该账号已存在");
        }
        alert("register success!");
        $("#reg").submit();
    }

    function submitCheckAccount() {
        var xmlHttp;
        if (window.XMLHttpRequest) {    // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlHttp = new XMLHttpRequest();
        } else {    // code for IE6, IE5
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        var rAccount = document.getElementById("rAccount");
        if (rAccount.value.length == 11) {
            // alert(rAccount.value);
            // xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.open("POST", "${pageContext.request.contextPath}/StudentAction_checkAccount?account=" + rAccount.value, true);
            xmlHttp.send();
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    var text = xmlHttp.responseText;
                    if (text == "该账号已存在")
                        document.getElementById("balabala").innerHTML = "<h6><font color='red' >" + text + "</font></h6>";
                    else
                        document.getElementById("balabala").innerHTML = "<h6><font color='green' >" + text + "</font></h6>";
                }
            };
        } else {
            document.getElementById("balabala").innerHTML = "<h6><font color='red' >" + "账号格式不正确" + "</font></h6>";
        }
    }
</script>
<body>
<!-- 整个登录界面 -->
<div class="login">
    <!-- 标签选择页，根据锚点#选择登录或是注册 -->
    <ul id="myTab" class="nav nav-tabs">
        <li class="active">
            <a href="#login" data-toggle="tab">
                登录
            </a>
        </li>
        <li><a href="#register" data-toggle="tab">注册</a></li>
    </ul>
    <!-- 登录/注册的具体页面 -->
    <div id="myTabContent" class="tab-content">
        <div class="tab-pane fade in active" id="login">
            <h4 class="title">登 录</h4>
            <form action="${pageContext.request.contextPath}/StudentAction_login" method="post">
                <%-- 使得studentaction中student的name='' --%>
                <input type="hidden" name="name"/>
                <div class="item">
                    <!-- 下面这个输入框为帐号输入框 -->
                    <input id="usernumber" class="input" name="account" type="text" placeholder="请输入帐号"/>
                </div>
                <div class="item">
                    <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-6">
                            <!-- 下面这个输入框为密码输入框 -->
                            <input id="password" class="input" name="password" type="password" placeholder="请输入密码"/>
                        </div>
                        <div class="col-lg-2" style="margin-left: -0px;margin-top: 10px" id="errormsg">
                            <font color="red" id="login_error_msg">${error}</font>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <!-- 下面这个按钮为登录按钮 -->
                    <label>&nbsp;</label>
                    <button class="btn btn-success" id="loginbtn">登录</button>
                </div>
            </form>
        </div>
        <!-- 下面为注册界面 -->
        <div class="tab-pane fade" id="register">
            <h4 class="title">注册</h4>
            <form id="reg" action="${pageContext.request.contextPath}/StudentAction_register" method="post">
                <div class="item">
                    <!-- 下面这个输入框为用户的姓名 -->
                    <input id="name" class="input" name="name" type="text" placeholder="请输入您的姓名"/>
                </div>
                <div class="item">
                    <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-6">
                            <!-- 下面这个输入框为用户设置的帐号 -->
                            <input id="rAccount" class="input" onblur="submitCheckAccount()" name="account" type="text"
                                   placeholder="请输入您的学号"/>
                        </div>
                        <div class="col-lg-2" style="margin-left: -50px;" id="balabala">
                        </div>
                    </div>
                </div>
                <div class="item">
                    <!-- 下面这个输入框为用户设置的密码 -->
                    <input id="password" class="input" name="password" type="password" placeholder="请输入您设置的密码"/>
                </div>
                <div class="item">
                    <!-- 下面这个输入框为用户确认密码-->
                    <input id="repassword" class="input" type="password" placeholder="请再输入一次密码"/>
                </div>
                <!-- 下面这个按钮为注册按钮-->
                <div class="item">
                    <label>&nbsp;</label>
                    <button type="button" class="btn btn-success" id="registerbtn" onclick="submitRegister()">注册</button>
                </div>
            </form>
        </div>

    </div>
</div>

<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
