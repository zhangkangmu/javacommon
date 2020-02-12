<%@ page import="com.itheima.domain.Address" %>
<%@ page import="com.itheima.domain.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL从域里取Map数据</title>
</head>
<body>
<%
    User user1 = new User("小张", new Address("河南", "郑州"));
    User user2 = new User("小王", new Address("广东", "深圳"));

    Map<String, User> userMap = new HashMap<>();
    userMap.put("u1", user1);
    userMap.put("u2", user2);

    request.setAttribute("map", userMap);

    //在JSP里嵌套Java代码，使用四个域对象：pageContext, request, session, application

%>

1. 从域里取map中u1的name值：<br>
用Java表达式：<%=((Map<String, User>)request.getAttribute("map")).get("u1").getName()%>
<br>
用EL表达式取：${map.u1.name}  <%-- EL里  map.key，表示从map里取key对应的值 --%>
<hr>

2. 从域里取map中u2的address的省：<br>
用Java表达式：<%=((Map<String, User>)request.getAttribute("map")).get("u2").getAddress().getProvince()%>
<br>
用EL表达式取：${map.u2.address.province}


<hr>

在EL表达式里使用四个域对象：
${pageScope}
${requestScope}
${sessionScope}
${applicationScope}
</body>
</html>
