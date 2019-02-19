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
        var id;
        var stagePage=1;
        var lastPage=1;
        var allPage=1;
        var allLastPage=1;
        $(document).ready(function(){
            var currentCheck = getParam("currentCheck");
            var currentGrade = getParam("currentGrade");
            $("#checkInput").html(currentCheck);
            if (currentGrade==1){
                $("#grandInput").html("初级");
            }
            if (currentGrade==2){
                $("#grandInput").html("中级");
            }
            if (currentGrade==3){
                $("#grandInput").html("高级");
            }
            var stageSetting = currentSetting(currentGrade,currentCheck);
            id = stageSetting["id"];
            //获取题目分类
            showClass("className");

            //加载当前关卡题目
            loadStageSubject();
        });
        function showClass(divName) {
            //获取题目分类
            var allClass = getClass();
            console.log(allClass);
            var text = "<option value=''></option>";
            $.each(allClass, function (index, val) {
                text+= '<option value="'+val["className"]+'">'+val["className"]+'</option>';
            })
            $("#"+divName).html(text);
        }

        //加载当前关卡题目列表
        function loadStageSubject() {
            var inputName = $("#inputName").val();
            var className = $("#className").val();
            var InputLevel = $("#InputLevel").val();
            var InputStage = $("#InputStage").val();

            $.ajax({
                async: false,
                type: "post",
                url: '${pageContext.request.contextPath}/libraryPool/queryList',
                contentType: "application/x-www-form-urlencoded",
                data: {'lpId':id,'pageNum':stagePage,'pageSize':10,'title':inputName,'sonCount':InputStage,'difficulty':InputLevel,'classDic':className},
                dataType: "json",
                success: function (data) {
                    lastPage = data["data"]["lastPage"];
                    var text="";
                    $.each(data["data"]["list"], function (index, val) {
                        if (index!=0){
                            text+='<hr class="hrStyle" />';
                        }
                        text+='<div class="row bottomDiv">\n' +
                            '            <div class="col-md-2">'+(index+1)+'</div>\n' +
                            '            <div class="col-md-4">\n' +
                            '                <div class="textLength">\n' +
                                                val["title"] +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="col-md-2">'+val["sonCount"]+'</div>\n' +
                            '            <div class="col-md-2">'+
                                    (val["difficulty"]==1?"初级":val["difficulty"]==2?"中级":val["difficulty"]==3?"高级":"")+
                                    '</div>\n' +
                            '            <div class="col-md-2">\n' +
                            '                <input onclick="removeSmallSubject('+val["id"]+')" class="btn btn-default tableButton"  type="button" value="移除">\n' +
                            '            </div>\n' +
                            '        </div>\n';
                    });
                    text +='<div class="" style="text-align: right ;padding: 0px 12px">\n' +
                        '            <input onclick="addSubject()" class="btn btn-default twoButton" data-toggle="modal" data-target="#step1"  type="button" value="添加">\n' +
                        '        </div>';
                    $("#stageDiv").html(text);
                },
                error: function (data) {
                    alert("发生错误，请联系管理员");
                }
            })
        }

        function addSubject() {
            //加载掩藏分类列表
            showClass("hiddenClassName");
            //加载题目
            loadAllSubject();
        }

        function setScore() {
            var score = $("#score").val();
            $.ajax({
                async: false,
                type: "post",
                url: '${pageContext.request.contextPath}/libraryPool/admin/updateLibraryPool',
                contentType: "application/x-www-form-urlencoded",
                data: {'id':id,'score':score},
                dataType: "json",
                success: function (data) {
                    alert("修改成功");
                },
                error: function (data) {
                    alert("发生错误，请联系管理员");
                }
            })
        }
        //加载全部题目列表
        function loadAllSubject() {
            var hiddenName = $("#hiddenName").val();
            var hiddenClassName = $("#hiddenClassName").val();
            var hiddenGrade = $("#hiddenGrade").val();
            var hiddenCount = $("#hiddenCount").val();
            $.ajax({
                async: false,
                type: "post",
                url: '${pageContext.request.contextPath}/library/queryList',
                contentType: "application/x-www-form-urlencoded",
                data: {'pageNum':allPage,'pageSize':10,"title":hiddenName,"difficulty":hiddenGrade,"sonCount":hiddenCount,'classDic':hiddenClassName},
                dataType: "json",
                success: function (data) {
                    var text ="";
                   console.log(data);
                   allLastPage = data["data"]["lastPage"];
                    $.each(data["data"]["list"], function (index, val) {
                        if (index!=0){
                            text+='<hr class="hrStyle" />';
                        }
                        text+='<div class="row bottomDiv">\n' +
                            '            <div class="col-md-2">'+(index+1)+'</div>\n' +
                            '            <div class="col-md-4">\n' +
                            '                <div class="textLength">\n' +
                            val["title"] +
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="col-md-2">'+val["sonCount"]+'</div>\n' +
                            '            <div class="col-md-2">'+
                            (val["difficulty"]==1?"初级":val["difficulty"]==2?"中级":val["difficulty"]==3?"高级":"")+
                            '</div>\n' +
                            '            <div class="col-md-2">\n' +
                            '                <input onclick="addSmallSubject('+val["id"]+')" class="btn btn-default tableButton"  type="button" value="添加">\n' +
                            '            </div>\n' +
                            '        </div>\n';
                    });
                    $("#hiddenSubjectDiv").html(text);
                },
                error: function (data) {
                    alert("发生错误，请联系管理员");
                }
            })
        }

        function addSmallSubject(libId) {
            $.ajax({
                async: false,
                type: "post",
                url: '${pageContext.request.contextPath}/libraryPool/admin/addLibrary',
                contentType: "application/x-www-form-urlencoded",
                data: {'lpId':id,'libIds':libId},
                dataType: "json",
                success: function (data) {
                    alert("添加成功");
                    loadStageSubject();
                },
                error: function (data) {
                    console.log(data);
                }
            })
        }
        function removeSmallSubject(libId) {
            $.ajax({
                async: false,
                type: "post",
                url: '${pageContext.request.contextPath}/libraryPool/admin/deleteLibrary',
                contentType: "application/x-www-form-urlencoded",
                data: {'lpId':id,'libIds':libId},
                dataType: "json",
                success: function (data) {
                    alert("删除成功");
                    loadStageSubject();
                },
                error: function (data) {
                    console.log(data);
                }
            })
        }

        function preSubject() {
            if (1<stagePage){
                stagePage-=1;
                loadStageSubject();
            }
        }
        function nextSubject() {
            if (stagePage<lastPage){
                stagePage+=1;
                loadStageSubject();
            }
        }
        function preHiddenSubject() {
            if (1<allPage){
                allPage-=1;
                loadAllSubject();
            }
        }
        function nextHiddenSubject() {
            if (allPage<allLastPage){
                allPage+=1;
                loadAllSubject();
            }
        }

    </script>
</head>
<body>
<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
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
            <input type="text" class="form-control" id="inputName" placeholder="标题">
        </div>
        <div class="form-group col-md-3">
            <label for="className">主题</label>
            <select id="className" class="form-control">
                <option value=""></option>
                <option value="1">初级</option>
                <option value="2">中级</option>
                <option value="3">高级</option>
            </select>
        </div>
        <div class="col-md-3">
            <label for="InputLevel">等级</label>
            <select id="InputLevel" class="form-control">
                <option value=""></option>
                <option value="1">初级</option>
                <option value="2">中级</option>
                <option value="3">高级</option>
            </select>
        </div>
        <div class="form-group col-md-3">
            <label for="InputStage">小题数</label>
            <select id="InputStage" class="form-control">
                <option value=""></option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
            </select>
        </div>
    </div>

    <div class="col-md-12" style="text-align: right">
        <input class="btn btn-default twoButton"  type="button" value="查询">
    </div>
</div>
<br>
<div class="width95" style="margin: 0px auto;font-size: 1.2em;box-shadow: 0 0 3px #999;border: 2px solid #ddd;border-radius: 5px;">
    <div class="row">
        <div class="form-group col-md-4">
            <label for="InputId">当前关卡：</label>
            <label for="InputId" id="checkInput"></label>
        </div>
        <div class="form-group col-md-4">
            <label for="InputId">关卡难度</label>
            <label for="InputId" id="grandInput"></label>
        </div>
        <div class="form-group col-md-4">
            <label for="InputId">通关分数</label>
            <select id="score" class="form-control">
                <option value="60">60%</option>
                <option value="70">70%</option>
                <option value="80">80%</option>
            </select>
        </div>
        <div class="" style="text-align: right ;padding: 0px 12px">
            <input class="twoButton btn btn-default" onclick="setScore()"  type="button" value="确定">
        </div>
    </div>
</div>
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
    <div id="stageDiv">
        <div class="" style="text-align: right ;padding: 0px 12px">
            <input class="btn btn-default twoButton" data-toggle="modal" data-target="#step1"  type="button" value="添加">
        </div>
    </div>
</div>
<div class="col-md-12" style="text-align: center">
    <input onclick="preSubject()" class="twoButton btn btn-default"   type="button" value="上一页">
    <font class="fontStyle1">1</font>
    <input onclick="nextSubject()" class="twoButton btn btn-default"   type="button" value="下一页">

</div>



<div class="modal fade" id="step1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 70%">
        <div class="modal-content">
            <div class="width95 row testbox " style="width: 100%">
                <br>
                <div class="col-md-12">
                    <div class="form-group col-md-3">
                        <label for="InputId">标题</label>
                        <input type="text" class="form-control" id="hiddenName" placeholder="标题">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="hiddenClassName">主题</label>
                        <select id="hiddenClassName" class="form-control">
                            <option></option>
                            <option>初级</option>
                            <option>中级</option>
                            <option>高级</option>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <label for="InputLevel">等级</label>
                        <select id="hiddenGrade" class="form-control">
                            <option></option>
                            <option value="1">初级</option>
                            <option value="2">中级</option>
                            <option value="3">高级</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="InputStage">小题数</label>
                        <select id="hiddenCount" class="form-control">
                            <option value=""></option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
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
                <div id="hiddenSubjectDiv">
                </div>
            </div>
            <div class="col-md-12" style="text-align: center">
                <input onclick="preHiddenSubject()" class="twoButton btn btn-default"   type="button" value="上一页">
                <font class="fontStyle1">1</font>
                <input onclick="nextHiddenSubject()" class="twoButton btn btn-default"   type="button" value="下一页">

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