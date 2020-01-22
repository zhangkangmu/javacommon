<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 洪
  Date: 2018/1/10
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="true">
    <h1>这是if语句</h1>
</c:if>
<hr>
<br>

<%
    ArrayList<String> list = new ArrayList<>();
    list.add("zhang");
    list.add("yu");
    list.add("hong");
    request.setAttribute("list", list);

    request.setAttribute("num", 2);
%>
<h3>循环语句</h3>
<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
    <font color="#a52a2a">${i}</font>
    <font color="blue">${s.index}</font>
    <font color="#8a2be2">${s.count}</font>
    <br>
</c:forEach>
<br>
<h3>遍历语句</h3>
<c:if test="${not empty requestScope.list}">
    <c:forEach items="${requestScope.list}" var="str" varStatus="s">
        <font color="#a52a2a">${s.index}${s.count}${str}</font><br>
    </c:forEach>
</c:if>
<hr>
<br>

<c:choose>
    <c:when test="${requestScope.num==1}">星期一</c:when>
    <c:when test="${requestScope.num==2}">星期二</c:when>
    <c:when test="${requestScope.num==3}">星期三</c:when>
    <c:when test="${requestScope.num==4}">星期四</c:when>
    <c:when test="${requestScope.num==5}">星期五</c:when>
    <c:when test="${requestScope.num==6}">星期六</c:when>
    <c:when test="${requestScope.num==7}">星期天</c:when>
    <c:otherwise>数字输入有误</c:otherwise>
</c:choose>


</body>
</html>
