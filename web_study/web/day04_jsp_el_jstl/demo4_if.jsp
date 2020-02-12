<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签-if判断</title>
</head>
<body>
<%--
c:if标签： JSTL提供的，用于判断的标签
    test属性：用于写判断条件。如果判断为true，c:if标签体里的内容会生效；否则不生效
--%>
<c:if test="false">
    如果test属性值为true，这里的内容会生效
</c:if>

<hr>

<%
    request.setAttribute("age", 105);
%>
需求：域里有一个age。要求如果age>=18，显示 绿色的“已成年”；否则显示红色的“未成年” <br>
<c:if test="${age >= 18}">
    <span style="color:green;">已成年</span>
</c:if>
<c:if test="${age < 18}">
    <span style="color:red;">未成年</span>
</c:if>

</body>
</html>
