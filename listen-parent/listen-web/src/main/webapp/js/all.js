    document.write("<script src='../../../js/jquery-1.12.4.js'><\/script>");
//环境变量
function getParam(paramName) {
    paramValue = "", isFound = !1;
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;
        while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
    }
    return paramValue == "" && (paramValue = null), paramValue;
}

function getClass() {
    //获取题目分类
    var value;
    $.ajax({
        async: false,
        type: "post",
        url: $("#PageContext").val()+'/library/getClassDic',
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        success: function (data) {
            value =  data["data"];
        },
        error: function (data) {
            alert("发生错误，请联系管理员");
        }
    })
    return value;
}

function addClass(className) {

    //添加题目分类
    var time = getNowFormatDate();
    $.ajax({
        async: false,
        type: "post",
        url: $("#PageContext").val()+'/library/addClassDic',
        contentType: "application/x-www-form-urlencoded",
        data: {'className':className,'flag':1,'gmtCreate':time,'gmtModified':time,},
        dataType: "json",
        success: function (data) {
            alert("添加成功");
        },
        error: function (data) {
            alert("发生错误，请联系管理员");
        }
    })
}
//获取当前时间 格式“yyyy-MM-dd HH:MM:SS”
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}

    function currentSetting(currentGrade,currentCheck){
    var list;
    //获取当前关卡设置
    $.ajax({
        async: false,
        type: "post",
        url: $("#PageContext").val()+'/libraryPool/getSetting',
        contentType: "application/x-www-form-urlencoded",
        data: {'grade':currentGrade,'checkPoint':currentCheck},
        dataType: "json",
        success: function (data) {
            list=data["data"];
            //window.location.href = '${pageContext.request.contextPath}/page/user/checkPointList.html';
        },
        error: function (data) {
            alert("发生错误，请联系管理员");
        }
    })
        return list;
    }