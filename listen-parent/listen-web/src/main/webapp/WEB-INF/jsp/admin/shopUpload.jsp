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
    <script type="text/javascript" charset="utf-8" src="../../../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../../../ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="../../../ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
<header>
    <nav class="top">
        <p>商城文章上传</p>
    </nav>
</header>
<br/>



<div class="width95 row testbox " style="width: 80%">
    <br>
    <div class="col-md-12">
        <div class="form-group col-md-4">
            <label for="InputId">标题</label>
            <input type="text" class="form-control" id="Name" placeholder="标题">
        </div>
        <div class="form-group col-md-4">
            <label for="InputId">分类</label>
            <input type="text" class="form-control" id="class" placeholder="分类">
        </div>
        <div class="form-group col-md-4">
            <label for="InputId">积分</label>
            <input type="text" class="form-control" id="point" placeholder="积分">
        </div>
    </div>
    <div class="form-group col-md-12" style="padding-left: 30px">
        <label for="InputId">封面</label>
        <input type="file"  >
    </div>
    <div style="width: 92%;margin: 0 auto">
        <h1>内容</h1>
        <script id="editor" type="text/plain" style="width:100%;height:400px;"></script>
        </div>
            <br>
        <div class="col-md-12" style="text-align: right">
            <input class="btn btn-default twoButton"  type="button" value="上传">
            </div>
</div>

<br>




<!-- 返回上一层 -->
<a href="/page/admin/home.html" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

    <script type="text/javascript">

//实例化编辑器
//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
var ue = UE.getEditor('editor');


function insertHtml() {
    var value = prompt('插入html代码', '');
    UE.getEditor('editor').execCommand('insertHtml', value)
}
    </script>
<script type="text/javascript" src="../../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../../js/main.js"></script>
<script type="text/javascript" src="../../../js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../../js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

</body>
</html>