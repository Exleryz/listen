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
    <link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/main.js"></script>
<script type="text/javascript">
    function register() {
        if ($("#checkAccount").html() != '') {
            return;
        }

        $.ajax({
            async: false,
            type: "POST",
            url: '${pageContext.request.contextPath}/sso/register',
            contentType: "application/x-www-form-urlencoded",
            data: $("#registerForm").serialize(),
            dataType: "json",
            success: function (data) {
                if (data['flag']) {
                    window.location.href = '${pageContext.request.contextPath}/page/user/login';
                } else {
                    alert(data['msg']);
                }
            },
            error: function (data) {
                alert(data['msg']);
            }
        })
    }

    function login() {
        $.ajax({
            async: false,
            type: "POST",
            url: '${pageContext.request.contextPath}/sso/login',
            contentType: "application/x-www-form-urlencoded",
            data: $("#loginForm").serialize(),
            dataType: "json",
            success: function (data) {
                if (data['flag']) {
                    window.location.href = '${pageContext.request.contextPath}/page/' + data['data']['redirect'] + '/home.html';
                } else {
                    $("#login_error_msg").html(data['msg']);
                }
            },
            error: function (data) {
                alert('服务器出现问题，请联系管理员');
            }
        })
    }

    function checkRegister() {
        $.ajax({
            async: false,
            type: "POST",
            url: '${pageContext.request.contextPath}/user/check',
            contentType: "application/x-www-form-urlencoded",
            data: $("#registerForm").serialize(),
            dataType: "json",
            success: function (data) {
                if (!data['flag']) {
                    $("#checkAccount").html(data['msg']);
                } else {
                    $("#checkAccount").html('');
                }
            },
            error: function (data) {
                $("#checkAccount").html(data['msg']);
            }
        })
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
            <form id="loginForm">
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
                            <input id="apassword" class="input" name="password" type="password" placeholder="请输入密码"/>
                        </div>
                        <div class="col-lg-2" style="margin-left: -0px;margin-top: 10px" id="errormsg">
                            <font color="red" id="login_error_msg">${error}</font>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <!-- 下面这个按钮为登录按钮 -->
                    <label>&nbsp;</label>
                    <button type="button" class="btn btn-success" onclick="login()" id="loginbtn">登录</button>
                </div>
            </form>
        </div>
        <!-- 下面为注册界面 -->
        <div class="tab-pane fade" id="register">
            <h4 class="title">注册</h4>
            <form id="registerForm" method="post">
                <div class="item">
                    <!-- 下面这个输入框为用户的姓名 -->
                    <input id="username" class="input" name="username" type="text" placeholder="请输入您的姓名"/>
                </div>
                <div class="item">
                    <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-6">
                            <!-- 下面这个输入框为用户设置的帐号 -->
                            <input id="rAccount" class="input" onblur="checkRegister()" name="account" type="text"
                                   placeholder="请输入您的学号"/>
                        </div>
                        <div class="col-lg-2" style="margin-left: -50px;color:red" id="checkAccount">
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
                    <button type="button" class="btn btn-success" id="registerbtn" onclick="register()">注册</button>
                </div>
            </form>
        </div>

    </div>
</div>


</body>
