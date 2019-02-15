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
</head>
<body>
<header>
    <nav class="top">
        <p>关卡题目编辑</p>
    </nav>
</header>
<br/>
<div class="width95 row testbox " style="width: 100%">
    <br>
    <div class="col-md-12">
        <div class="form-group col-md-3">
            <label for="InputId">标题</label>
            <input type="text" class="form-control" id="InputId" placeholder="标题">
        </div>
        <div class="form-group col-md-3">
            <label for="InputName">主题</label>
            <input type="email" class="form-control" id="InputName" placeholder="主题">
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
            <label for="InputStage">小题数</label>
            <select id="InputStage" class="form-control">
                <option></option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
            </select>
        </div>
    </div>

    <div class="col-md-12" style="text-align: right">
        <input class="btn btn-default twoButton"  type="button" value="查询">
    </div>
</div>
<br>

<div class="width95 fontStyle2">已选题目</div>
<div class="width95 testbox" style="font-size: 1.2em;" >
    <div class="row bottomDiv" style="border-bottom-width: 1px">
        <div class="col-md-2">编号</div>
        <div class="col-md-4">标题</div>
        <div class="col-md-2">子题目数</div>
        <div class="col-md-2">等级</div>
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
            <div class="col-md-2">3</div>
            <div class="col-md-2">中级</div>
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
            <div class="col-md-2">3</div>
            <div class="col-md-2">中级</div>
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
            <div class="col-md-2">3</div>
            <div class="col-md-2">中级</div>
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
            <div class="col-md-2">3</div>
            <div class="col-md-2">中级</div>
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
            <div class="col-md-2">3</div>
            <div class="col-md-2">中级</div>
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
            <div class="col-md-2">3</div>
            <div class="col-md-2">中级</div>
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
            <div class="col-md-2">3</div>
            <div class="col-md-2">中级</div>
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
            <div class="col-md-2">3</div>
            <div class="col-md-2">中级</div>
            <div class="col-md-2">
                <input class="btn btn-default tableButton"  type="button" value="移除">
            </div>
        </div>
        <div class="" style="text-align: right ;padding: 0px 12px">
            <input class="btn btn-default twoButton" data-toggle="modal" data-target="#step1"  type="button" value="添加">
        </div>
    </div>
</div>
<div class="col-md-12" style="text-align: center">
    <input class="twoButton btn btn-default"   type="button" value="上一页">
    <font class="fontStyle1">1</font>
    <input class="twoButton btn btn-default"   type="button" value="下一页">

</div>



<div class="modal fade" id="step1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 70%">
        <div class="modal-content">
            <div class="width95 row testbox " style="width: 100%">
                <br>
                <div class="col-md-12">
                    <div class="form-group col-md-3">
                        <label for="InputId">标题</label>
                        <input type="text" class="form-control" id="InputId2" placeholder="标题">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="InputName">主题</label>
                        <input type="email" class="form-control" id="InputName2" placeholder="主题">
                    </div>
                    <div class="col-md-3">
                        <label for="InputLevel">等级</label>
                        <select id="InputLevel2" class="form-control">
                            <option></option>
                            <option>初级</option>
                            <option>中级</option>
                            <option>高级</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="InputStage">小题数</label>
                        <select id="InputStage2" class="form-control">
                            <option></option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                        </select>
                    </div>
                </div>

                <div class="col-md-12" style="text-align: right">
                    <input class="btn btn-default twoButton"  type="button" value="查询">
                </div>
            </div>
            <br>


            <div class="width95 testbox" style="font-size: 1.2em;" >
                <div class="row bottomDiv" style="border-bottom-width: 1px">
                    <div class="col-md-2">编号</div>
                    <div class="col-md-4">标题</div>
                    <div class="col-md-2">子题目数</div>
                    <div class="col-md-2">等级</div>
                    <div class="col-md-2">添加</div>
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
                        <div class="col-md-2">3</div>
                        <div class="col-md-2">中级</div>
                        <div class="col-md-2">
                            <input class="btn btn-default tableButton"  type="button" value="添加">
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
                        <div class="col-md-2">3</div>
                        <div class="col-md-2">中级</div>
                        <div class="col-md-2">
                            <input class="btn btn-default tableButton"  type="button" value="添加">
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
                        <div class="col-md-2">3</div>
                        <div class="col-md-2">中级</div>
                        <div class="col-md-2">
                            <input class="btn btn-default tableButton"  type="button" value="添加">
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
                        <div class="col-md-2">3</div>
                        <div class="col-md-2">中级</div>
                        <div class="col-md-2">
                            <input class="btn btn-default tableButton"  type="button" value="添加">
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
                        <div class="col-md-2">3</div>
                        <div class="col-md-2">中级</div>
                        <div class="col-md-2">
                            <input class="btn btn-default tableButton"  type="button" value="添加">
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
                        <div class="col-md-2">3</div>
                        <div class="col-md-2">中级</div>
                        <div class="col-md-2">
                            <input class="btn btn-default tableButton"  type="button" value="添加">
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
                        <div class="col-md-2">3</div>
                        <div class="col-md-2">中级</div>
                        <div class="col-md-2">
                            <input class="btn btn-default tableButton"  type="button" value="添加">
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
                        <div class="col-md-2">3</div>
                        <div class="col-md-2">中级</div>
                        <div class="col-md-2">
                            <input class="btn btn-default tableButton"  type="button" value="添加">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-12" style="text-align: center">
                <input class="twoButton btn btn-default"   type="button" value="上一页">
                <font class="fontStyle1">1</font>
                <input class="twoButton btn btn-default"   type="button" value="下一页">

            </div>
<br>
<hr>
        </div>
    </div>
</div>

<!-- 返回上一层 -->
<a href="javascript:history.go(-1)" class="header-back">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>

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