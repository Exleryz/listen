<%--
  Created by IntelliJ IDEA.
  User: shiku
  Date: 2019/2/11
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../../css/main.css">
    <script type="text/javascript" src="../../../js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="../../../js/all.js"></script>
    <script type="text/javascript">

    </script>
    <style>

        .testbox img{
            width:100%;
            height:auto;
        }
        .test{
            border: 2px solid #ddd;
            margin: 2% 4%;
            padding: 0 2px;
        }
        .test:hover{border: 2px solid red;}
    </style>
</head>
<body style="background-color: white">
<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
<header>
    <nav class="top">
        <p>商品列表</p>
    </nav>
</header>
<br/>



            <div class="width95 testbox" style="font-size: 1em;width: 75%;padding: 0 auto" >
                <%----------------%>
               <div class="row" style="margin: 2% auto">
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                   <div class="col-md-2 col-sm-3 col-xs-3 test"  >
                       <img src="../../../images/test1.jpg">
                       <p style="text-align: center">积分5</p>
                       <p style="text-align: center">java完全自学手册</p>
                   </div>
                </div>
                <%----------------%>
            </div>
<br>
<hr>

<!-- 返回上一层 -->
<a href="/page/admin/home.html" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>


<script type="text/javascript" src="../../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../../js/main.js"></script>
<script type="text/javascript" src="../../../js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../../js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
</script>
</body>
</html>