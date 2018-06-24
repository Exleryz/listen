<%--
  Created by IntelliJ IDEA.
  User: Exler
  Date: 2018/6/22
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="${pageContext.request.contextPath}/LibraryAction_upload" enctype="multipart/form-data"
      method="post">
    <!-- 题目、上传文件 -->
    <div class="headbox">
        <h1>标题: <input type="text" name="title" placeholder="请输入标题"></h1>
        <%--<button type="button" class="layui-btn" id="test6" name="listenLibrary"><i class="layui-icon"></i>上传音频</button>--%>
        <input type="file" name="listenLibrary">
        <p>子题数：<span id="testNum"></span><input type="hidden" id="sonCount" name="sonCount"></p>
    </div>
    <!-- 子题目设置部分 -->
    <div class="testbox" value="">
        <ul>
            <li>
                <label class="layui-form-label">sort</label>
                <div class="layui-input-block">
                    <input type="text" placeholder="请输入" class="layui-input">
                </div>
            </li>
            <li>
                <label class="layui-form-label">A：</label>
                <div class="layui-input-block">
                    <input type="text" placeholder="请输入" class="layui-input">
                </div>
            </li>
            <li>
                <label class="layui-form-label">B：</label>
                <div class="layui-input-block">
                    <input type="text" placeholder="请输入" class="layui-input">
                </div>
            </li>
            <li>
                <label class="layui-form-label">C：</label>
                <div class="layui-input-block">
                    <input type="text" placeholder="请输入" class="layui-input">
                </div>
            </li>
            <li>
                <label class="layui-form-label">D：</label>
                <div class="layui-input-block">
                    <input type="text" placeholder="请输入" class="layui-input">
                </div>
            </li>
            <li>
                <label class="layui-form-label">正确答案：</label>
                <div class="layui-input-block">
                    <select lay-ignore>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                    </select>
                </div>
            </li>
            <li>
                <label class="layui-form-label">解析</label>
                <div class="layui-input-block">
                    <input type="text" placeholder="请输入" class="layui-input">
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
    <input type="submit">

</form>

<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../layui/layui.all.js"></script>
<script type="text/javascript">
    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;

        upload.render({
            elem: '#test6'
            , url: '/upload/'
            , accept: 'audio' //音频
            , done: function (res) {
                console.log(res)
            }
        });
    })

    // 给每个div编号
    function setNum() {
        var testBoxNum = $('div.testbox');
        for (var i = 0; i < testBoxNum.length; i++) {
            testBoxNum.eq(i).attr('value', i + 1);
            var lis = testBoxNum.eq(i).find("li");
            lis.eq(0).find("input").attr("name", "subjectList[" + i + "].sort");
            lis.eq(0).find("input").val(i+1);
            lis.eq(1).find("input").attr("name", "subjectList[" + i + "].optionA");
            lis.eq(2).find("input").attr("name", "subjectList[" + i + "].optionB");
            lis.eq(3).find("input").attr("name", "subjectList[" + i + "].optionC");
            lis.eq(4).find("input").attr("name", "subjectList[" + i + "].optionD");
            lis.eq(5).find("select").attr("name", "subjectList[" + i + "].answer");
            lis.eq(6).find("input").attr("name", "subjectList[" + i + "].analysis");
            // text(i+1);
        }
    }

    // 获得目前总共多少div块数量
    function getTestBoxNum() {
        var testBoxNum = $('div.testbox');
        $('#testNum').html(testBoxNum.length);

    }

    // 点击删除一个div块
    function del(obj) {
        $(obj).parent().remove();
        getTestBoxNum();
        setNum();
    }
</script>
</body>
</html>