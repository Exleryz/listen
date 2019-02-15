<%--
  Created by IntelliJ IDEA.
  User: shiku
  Date: 2019/2/15
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../../css/main.css">
    <script type="text/javascript" src="../../../js/jquery-1.12.4.js"></script>
    <title>分类编辑</title>
</head>
<body>
<header>
    <nav class="top">
        <p>分类编辑</p>
    </nav>
</header>
<br>
<div class="change">
    <div class="width95" style="margin: 0px auto;font-size: 1.2em">
        <div class="row">
            <div class="form-group col-md-1" style="margin: 6px 0px">
                    分类名称
            </div>
            <div class="form-group col-md-2">
                <input type="text" class="form-control" placeholder="Text input">
            </div>
            <div class="form-group col-md-3">
            </div>

            <div class="form-group col-md-6">
                <button type="button" class="btn btn-primary">确定</button>
            </div>
        </div>
    </div>
</div>


<div class="width95 testbox" style="font-size: 1.2em;" >
    <div class="row bottomDiv" style="border-bottom-width: 1px">
        <div class="col-md-2">编号</div>
        <div class="col-md-4">分类名称</div>
        <div class="col-md-2">移除</div>
    </div>
    <hr class="hrStyle" />
    <div >
        <div class="row bottomDiv">
            <div class="col-md-2">1</div>
            <div class="col-md-4">
                <div class="textLength">
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </div>
            </div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
        </div>
        <hr class="hrStyle" />
        <div class="row bottomDiv">
            <div class="col-md-2">1</div>
            <div class="col-md-4">
                <div class="textLength">
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </div>
            </div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
        </div>
        <hr class="hrStyle" />
        <div class="row bottomDiv">
            <div class="col-md-2">1</div>
            <div class="col-md-4">
                <div class="textLength">
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </div>
            </div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
        </div>
        <hr class="hrStyle" />
        <div class="row bottomDiv">
            <div class="col-md-2">1</div>
            <div class="col-md-4">
                <div class="textLength">
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </div>
            </div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
        </div>
        <hr class="hrStyle" />
        <div class="row bottomDiv">
            <div class="col-md-2">1</div>
            <div class="col-md-4">
                <div class="textLength">
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </div>
            </div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
        </div>
        <hr class="hrStyle" />
        <div class="row bottomDiv">
            <div class="col-md-2">1</div>
            <div class="col-md-4">
                <div class="textLength">
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </div>
            </div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
        </div>
        <hr class="hrStyle" />
        <div class="row bottomDiv">
            <div class="col-md-2">1</div>
            <div class="col-md-4">
                <div class="textLength">
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </div>
            </div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
        </div>
        <hr class="hrStyle" />
        <div class="row bottomDiv">
            <div class="col-md-2">1</div>
            <div class="col-md-4">
                <div class="textLength">
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </div>
            </div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
        </div>
        <div class="" style="text-align: right ;padding: 0px 12px">
            <input class="btn btn-default twoButton" data-toggle="modal" data-target="#step1"  type="button" value="添加">
        </div>
    </div>
</div>
<br>
<div class="col-md-12" style="text-align: center">
    <input class="twoButton btn btn-default"   type="button" value="上一页">
    <font class="fontStyle1">1</font>
    <input class="twoButton btn btn-default"   type="button" value="下一页">

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
