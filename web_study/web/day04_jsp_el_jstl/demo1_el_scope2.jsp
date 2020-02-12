<%@ page import="day04_jsp_el_jstl.domain.User" %>
<%@ page import="day04_jsp_el_jstl.domain.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL从域里取JavaBean数据</title>
</head>
<body>
<%
    User user = new User("小张", new Address("河南", "郑州"));

    request.setAttribute("user", user);
%>

1. 从域里取user的name值：<br>
用Java表达式：<%=((User)request.getAttribute("user")).getName()%>
<br>
用EL表达式取：${user.name}   <%-- EL的：JavaBean对象.name 相当于 Java的：JavaBean对象.getName()方法--%>
<hr>

2. 从域里取user的address的省：<br>
用Java表达式：<%=((User)request.getAttribute("user")).getAddress().getProvince()%>
<br>
用EL表达式取：${user.address.province}

</body>
</html>
