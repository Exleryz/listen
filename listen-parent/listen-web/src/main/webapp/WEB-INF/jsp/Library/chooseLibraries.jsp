<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/3
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../css/main.css">
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<script type="text/javascript">
    function forwardPage(page) {
        if (page == 1) {
            return;
        } else {
            window.location.href = "${pageContext.request.contextPath}/LibraryAction_getAllLibraries?currentPage=" + (page - 1);
        }
    }

    function nextPage(page) {
        if (page == <s:property value="#pageBean.totalPage"/>) {
            return;
        } else {
            window.location.href = "${pageContext.request.contextPath}/LibraryAction_getAllLibraries?currentPage=" + (page + 1);
        }
    }

    var a = new Array();
    var lpid;
    function x() {
        var cs = document.getElementsByName("c")
        for (var i = 0; i < cs.length; i++) {
            if (cs[i].checked == true) {
                a.push(cs[i].value);
            }
        }
        alert(a.toString());
        window.location.href = "${pageContext.request.contextPath}/CheckAction_addLibToLP?lId=" + a.toString()+"&lpId=<%=request.getParameter("lpId")%>";
    }
</script>
<body>
<div class="historybox">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>选择题目</th>
            <th>编号</th>
            <th>题目</th>
            <th>子题目数</th>
        </tr>
        </thead>
        <tbody>
        <%--<s:iterator value="#pageBean.list" var="lib" status="status">
            <tr>
                <td><input type="checkbox" name="c" value="<s:property value="#lib.id"></s:property>"></td>
                <td><s:property value="(#pageBean.currentPage -1) * #pageBean.pageSize + #status.index + 1"/></td>
                &lt;%&ndash;<td><input type="hidden" value="" name="id" /></td>&ndash;%&gt;
                <td><s:property value="#lib.title"></s:property></td>
                <td><s:property value="#lib.sonCount"></s:property></td>
                <td>
                    <button value="查看"/>
                </td>
            </tr>
        </s:iterator>--%>
            <tr>
                <td><input type="checkbox" name="c" value="1"></td>
                <td>1</td>
                <%--<td><input type="hidden" value="" name="id" /></td>--%>
                <td>标题</td>
                <td>子题目</td>
                <td>
                    <button value="查看"/>
                </td>
            </tr>
        </tbody>
    </table>
    <button value="上一页" onclick="forwardPage(<s:property value='#pageBean.currentPage'/>)"></button>
    第<s:property value="#pageBean.currentPage"/>页/共<s:property value="#pageBean.totalPage"></s:property>页
    <button value="下一页" onclick="nextPage(<s:property value='#pageBean.currentPage'/>)"></button>
    <button onclick="x()" value="确定"></button>
</div>
</body>
</html>
