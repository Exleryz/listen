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
</head>
<body style="background-color: white">
<header>
    <nav class="top">
        <p>积分管理</p>
    </nav>
</header>
<div class="select_box">
    <div class="box_row">
        <div class="row_item">
            <div class="laber">帐号：</div>
            <input type="text" class="item_input">
        </div>
        <div class="row_item">
            <div class="laber">用户名：</div>
            <input type="text" class="item_input">
        </div>
        <div class="row_item">
            <div class="laber">等级：</div>
            <select name="" id="" class="item_select">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
        </div>
    </div>
    <div class="box_row row_2">
        <input type="button" value="搜索" class="layui-btn">
    </div>
</div>
<div class="table">
    <table>
        <tr class="title_row">
            <td class="">帐号</td>
            <td class="">用户名</td>
            <td class="">等级</td>
            <td class="">积分</td>
            <td class="">修改原因</td>
            <td class="">加减</td>
            <td class="">确定</td>
        </tr>
        <tr class="content_row">
            <td class="">xxx</td>
            <td class="">xxxxx</td>
            <td class="">中级</td>
            <td class="">103</td>
            <td class="">
                <input type="text" placeholder="请输入修改原因">
            </td>
            <td>
                <div class="add">
                    <div>+</div>
                    <input type="text" style="width: 30px;height: 30px;">
                    <div>-</div>
                </div>
            </td>
            <td class="">
                <input type="button" value="确定" class="layui-btn layui-btn-sm">
            </td>
        </tr>
        <tr class="content_row">
            <td class="">xxx</td>
            <td class="">xxxxx</td>
            <td class="">中级</td>
            <td class="">103</td>
            <td class="">
                <input type="text" placeholder="请输入修改原因">
            </td>
            <td>
                <div class="add">
                    <div>+</div>
                    <input type="text" style="width: 30px;height: 30px;">
                    <div>-</div>
                </div>
            </td>
            <td class="">
                <input type="button" value="确定" class="layui-btn layui-btn-sm">
            </td>
        </tr>
    </table>
</div>
<!-- 返回上一层 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>
<script type="text/javascript" src="../../../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../../../js/main.js"></script>
<script type="text/javascript" src="../../../layui/layui.all.js"></script>
<script type="text/javascript">
</script>
</body>
</html>