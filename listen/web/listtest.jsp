<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/4
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
---------------------------------------------
<span>
${stulp[0].id}
---------------------------------------------
<span/>
<s:property value="#stulp[0].id"></s:property>
<br>
<span></span>
    ---------------------------------------------
    <br>
<s:iterator value="%{stulp}" var="item" status="s">
    <s:property value="#s.index +1"/>
    <s:property value="#item.count"/>
    <s:property value="#item.score"/>
    <s:property value="#item.classify == 1 ? '练习':'测试'"/>
    <s:property value="#item.lp.grade"/>
    <s:property value="#item.lp.checkPoint"/>
    <br>
</s:iterator>
<s:property value="#stulp[0].score"></s:property>
</body>
</html>
