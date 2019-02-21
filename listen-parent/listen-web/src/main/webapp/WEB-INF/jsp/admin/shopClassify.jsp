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
    <script type="text/javascript" src="../../../js/all.js"></script>
    <title>商城分类</title>
    <script type="text/javascript">
        function addClassName() {
            var className = $("#className").val();
            addClass(className);
            var allClass = getClass();
            showList(allClass);
        }

        function showList(allClass){
            var text = "";
            $.each(allClass, function (index, val) {
                if (index!=0){
                    text+='<hr class="hrStyle" />';
                }
                console.log(val)
                text+='<div class="row bottomDiv">\n' +
                    '            <div class="col-md-2">'+(index+1)+'</div>\n' +
                    '            <div class="col-md-4">\n' +
                    '                <div class="textLength">\n' +
                    val["className"] +
                    '                </div>\n' +
                    '            </div>\n' +
                    '            <div class="col-md-2">'+(val["flag"]==1?"是":"否")+'</div>\n' +
                    '            <div class="col-md-2">'+val["gmtModified"]+'</div>\n' +
                    '            <div class="col-md-2">\n' +
                    '                <input onclick="removeClass('+val["id"]+')" class="btn btn-default tableButton"  type="button" value="移除">\n' +
                    '            </div>\n' +
                    '        </div>\n';
            })
            $("#classList").html(text);
        }
        /*$(document).ready(function(){
            var allClass = getClass();
            showList(allClass);
        });*/

        //删除题目分类
        function removeClass(id) {
            $.ajax({
                async: false,
                type: "post",
                url: '${pageContext.request.contextPath}/library/delectClassDic',
                contentType: "application/x-www-form-urlencoded",
                data: {'id':id},
                dataType: "json",
                success: function (data) {
                    alert("删除成功");
                    var allClass = getClass();
                    showList(allClass);
                },
                error: function (data) {
                    console.log(data);
                }
            })
        }
    </script>
</head>
<body>
<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
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
                <input id="className" type="text" class="form-control" placeholder="分类名称">
            </div>
            <div class="form-group col-md-3">
            </div>

            <div class="form-group col-md-6">
                <button type="button" onclick="addClassName()" class="btn btn-primary">添加</button>
            </div>
        </div>
    </div>
</div>


<div class="width95 testbox" style="font-size: 1.2em;" >
    <div class="row bottomDiv" style="border-bottom-width: 1px">
        <div class="col-md-2">编号</div>
        <div class="col-md-4">分类名称</div>
        <div class="col-md-2">是否启动</div>
        <div class="col-md-2">修改时间</div>
        <div class="col-md-2">移除</div>
    </div>
    <hr class="hrStyle" />
    <div id="classList">
        <div class="row bottomDiv">
            <div class="col-md-2">1</div>
            <div class="col-md-4">
                <div class="textLength">
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </div>
            </div>
            <div class="col-md-2">是</div>
            <div class="col-md-2">2019-2-18 12：00</div>
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
            <div class="col-md-2">是</div>
            <div class="col-md-2">2019-2-18 12：00</div>
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
            <div class="col-md-2">是</div>
            <div class="col-md-2">2019-2-18 12：00</div>
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
            <div class="col-md-2">是</div>
            <div class="col-md-2">2019-2-18 12：00</div>
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
            <div class="col-md-2">是</div>
            <div class="col-md-2">2019-2-18 12：00</div>
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
            <div class="col-md-2">是</div>
            <div class="col-md-2">2019-2-18 12：00</div>
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
            <div class="col-md-2">是</div>
            <div class="col-md-2">2019-2-18 12：00</div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
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
