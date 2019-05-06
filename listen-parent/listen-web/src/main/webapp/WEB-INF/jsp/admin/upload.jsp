<%--
  Created by IntelliJ IDEA.
  User: shiku
  Date: 2019/2/15
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../../../css/demoe2.css">
    <link rel="stylesheet" type="text/css" href="../../../layui/css/layui.css">
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../../css/main.css">
    <style type="text/css">
      /*  #test6{
            display: inline-block;
            height: 38px;
            line-height: 38px;
            padding: 0 18px;
            background-color: #009688;
            color: #fff;
            white-space: nowrap;
            text-align: center;
            font-size: 14px;
            border: none;
            border-radius: 2px;
            cursor: pointer;
            outline: 0;
            -webkit-appearance: none;
        }*/
    </style>
</head>
<body>
<header style="background-color: #318E8B">
   <%-- <a href="javascript:history.go(-1)" class="header-back">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <nav class="top">
        <p>题目上传</p>
    </nav>--%>
    <div class="row" style="padding: 8px 0px">
        <div class="col-md-1" onclick="history.go(-1)" style="font-size: 20px;
    color: #fff;text-align: center;cursor:pointer;"><span class="glyphicon glyphicon-chevron-left"></span></div>
        <div class="col-md-10" style="color: #fff;font-size: 1.6rem;text-align: center"><p>题目上传</p></div>
        <div class="col-md-1"></div>
    </div>
</header>
<form class="layui-form" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/library/admin/upload">
    <!-- 题目、上传文件 -->
    <div class="headbox layui-row ">
        <p>题目:    <input type="text"  name="title" placeholder="请输入题目"></p>
        <p>主题：<input type="text" name="classDic" placeholder="请输入主题"></p>
        <%--<button type="button" class="layui-btn" id="test6"><i class="layui-icon"></i>上传音频</button>
        --%>
        <input type="file" name="audioFile">
        <div><p>等级：
            <select name="difficulty" style="">
                <option>初级</option>
                <option>中级</option>
                <option>高级</option>
            </select>
        </p></div>
        <p>子题数：<span id="testNum" name="sonCount"></span></p>
    </div>
    <!-- 子题目设置部分 -->
    <div class="testbox" style="width: 700px" value="">
        <li>
        <label class="layui-form-label">sort：</label>
        <div class="layui-input-block"><input type="text" value="1" placeholder="请输入" class="layui-input"></div>
        </li>
        <ul>
            <li>
                <label class="layui-form-label">A：</label>
                <div class="layui-input-block">
                    <input type="text" name="subjectList[0].optionA" placeholder="请输入" class="layui-input">
                </div>
            </li>
            <li>
                <label class="layui-form-label">B：</label>
                <div class="layui-input-block">
                    <input type="text" name="subjectList[0].optionB" placeholder="请输入" class="layui-input">
                </div>
            </li>
            <li>
                <label class="layui-form-label">C：</label>
                <div class="layui-input-block">
                    <input type="text" name="subjectList[0].optionC" placeholder="请输入" class="layui-input">
                </div>
            </li>
            <li>
                <label class="layui-form-label">D：</label>
                <div class="layui-input-block">
                    <input type="text" name="subjectList[0].optionD" placeholder="请输入" class="layui-input">
                </div>
            </li>
            <li>
                <label class="layui-form-label" style="width: 100px">正确答案：</label>
                <div class="layui-input-block">
                    <select lay-ignore name="subjectList[0].answer">
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                    </select>
                </div>

            </li>
        </ul>
        <!-- 关闭按钮 -->
        <div class="closebox" onclick="del(this)">
            <i class="layui-icon">&#x1007;</i>
        </div>
    </div>
    <!-- 增加按钮 -->
    <div class="addbox" id="addbtn">
        <i class="layui-icon">&#xe608;</i>
    </div>

    <button type="submit" class="btn btn-primary">提交</button>
</form>

<!-- 返回上一层 -->
<%--<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>--%>


<script type="text/javascript" src="../../../js/jquery-1.12.4.js"></script>

<script type="text/javascript" src="../../../js/main.js"></script>
<script type="text/javascript" src="../../../layui/layui.all.js"></script>
<script type="text/javascript">
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        upload.render({
            elem: '#test6'
            ,url: '/upload/'
            ,accept: 'audio' //音频
            ,done: function(res){
                console.log(res)
            }
        });
    })
    // 给每个div编号
    function setNum(){
        var testBoxNum = $('div.testbox');
        for(var i=0;i<testBoxNum.length;i++){
            testBoxNum.eq(i).attr('value',i+1);
            // text(i+1);
        }
    }
    // 获得目前总共多少div块数量
    function getTestBoxNum(){
        var testBoxNum = $('div.testbox');
        $('#testNum').html(testBoxNum.length);
    }
    // 点击删除一个div块
    function del(obj){
        $(obj).parent().remove();
        getTestBoxNum();
        setNum();
    }
</script>
</body>
</html>