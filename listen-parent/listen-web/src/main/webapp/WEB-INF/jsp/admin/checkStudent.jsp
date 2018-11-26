<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/10
  Time: 9:48
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
</head>
<body>
<header>
    <nav class="top">
        <p>管理员查询学生做题</p>
    </nav>
</header>
<br/>
<div class="row testbox">
    <br>
        <div class="col-md-12">
            <div class="form-group col-md-3">
                <label for="InputId">学号</label>
                <input type="text" class="form-control" id="InputId" placeholder="学生学号">
            </div>
            <div class="form-group col-md-3">
                <label for="InputName">姓名</label>
                <input type="email" class="form-control" id="InputName" placeholder="学生姓名">
            </div>
            <div class="col-md-3">
                <label for="InputLevel">等级</label>
                <select id="InputLevel" class="form-control">
                    <option></option>
                    <option>初级</option>
                    <option>中级</option>
                    <option>高级</option>
                </select>
            </div>
            <div class="form-group col-md-3">
                <label for="InputStage">关卡</label>
                <select id="InputStage" class="form-control">
                    <option></option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
        </div>
    <div class="col-md-12">
            <div class="form-group col-md-3">
                <label for="InputStartScore">开始分数</label>
                <input type="text" class="form-control" id="InputStartScore" placeholder="开始分数">
            </div>
            <div class="form-group col-md-3">
                <label for="InputEndScore">结束分数</label>
                <input type="text" class="form-control" id="InputEndScore" placeholder="结束分数">
            </div>
            <div class="form-group col-md-3">
                <label for="startTime">开始时间</label>
                <div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="startTime" data-link-format="yyyy-mm-dd">
                    <input class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                </div>
                <input type="hidden" id="startTime" value="" /><br/>
            </div>
            <div class="form-group col-md-3">
                <label for="endTime" >结束时间</label>
                <div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="endTime" data-link-format="yyyy-mm-dd">
                    <input class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                </div>
                <input type="hidden" id="endTime" value="" /><br/>
            </div>
    <div class="col-md-3">
    </div>
    </div>
    <div class="col-md-12" style="text-align: right">
        <input class="btn btn-default twoButton"  type="button" value="查询">
        <input class="btn btn-default twoButton"  type="button" value="导出">
    </div>
</div>
<br>
<div>
    <table class="table" style="font-size: 1.2em">
        <tr bgcolor="#EDEFF5">
            <td>编号</td>
            <td>姓名</td>
            <td>关卡</td>
            <td>时间</td>
            <td>成绩</td>
        </tr>
        <tr>
            <td>1</td>
            <td>xxxxxx</td>
            <td>1</td>
            <td>2018-09-11</td>
            <td>60</td>
        </tr>
        <tr>
            <td>2</td>
            <td>xxxxxx</td>
            <td>1</td>
            <td>2018-09-11</td>
            <td>60</td>
        </tr>
        <tr>
            <td>3</td>
            <td>xxxxxx</td>
            <td>1</td>
            <td>2018-09-11</td>
            <td>60</td>
        </tr>
        <tr>
            <td>4</td>
            <td>xxxxxx</td>
            <td>1</td>
            <td>2018-09-11</td>
            <td>60</td>
        </tr>
    </table>
</div>
<!-- 返回上一层 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

<div class="col-md-12" style="text-align: center">
<input class="twoButton btn btn-default"   type="button" value="上一页">
<input class="twoButton btn btn-default"   type="button" value="下一页">

</div>
<script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
<script type="text/javascript" src="../../js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
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