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

        $(document).ready(function(){
            addSubject();
        })

        function addSubject() {
            //加载掩藏分类列表
            showClass("hiddenClassName");
            //加载题目
            loadAllSubject();
        }
        var allPage=1;
        var allLastPage=1;
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
                data: {'pageNum':allPage,'pageSize':10,/*"title":hiddenName,"difficulty":hiddenGrade,"sonCount":hiddenCount,'classDic':hiddenClassName*/},
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
                            '<a href="${pageContext.request.contextPath}/page/admin/subjectCheck.html?id='+val["id"]+'">'+val["title"] +'</a>'+
                            '                </div>\n' +
                            '            </div>\n' +
                            '            <div class="col-md-2">图书</div>\n' +
                            '            <div class="col-md-2">'+
                            (val["difficulty"])+
                            '</div>\n' +
                            '            <div class="col-md-2">\n' +
                            '                <input onclick="addSmallSubject('+val["id"]+')" class="btn btn-default tableButton"  type="button" value="删除">\n' +
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

    </script>
</head>
<body>
<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
<header>
    <nav class="top">
        <p>商城管理</p>
    </nav>
</header>
<br/>



            <div class="width95 row testbox " style="width: 100%">
                <br>
                <div class="col-md-12">
                    <div class="form-group col-md-4">
                        <label for="InputId">标题</label>
                        <input type="text" class="form-control" id="hiddenName" placeholder="标题">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="hiddenClassName">主题</label>
                        <select id="hiddenClassName" class="form-control">
                            <option></option>
                            <option>初级</option>
                            <option>中级</option>
                            <option>高级</option>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="InputId">积分</label>
                        <input type="text" class="form-control" id="hiddenName" placeholder="标题">
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
                    <div class="col-md-2">主题</div>
                    <div class="col-md-2">积分</div>
                    <div class="col-md-2">删除</div>
                </div>
                <hr class="hrStyle" />
                <div id="hiddenSubjectDiv">
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
                <input onclick="preHiddenSubject()" class="twoButton btn btn-default"   type="button" value="上一页">
                <font class="fontStyle1">1</font>
                <input onclick="nextHiddenSubject()" class="twoButton btn btn-default"   type="button" value="下一页">

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