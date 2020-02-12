<%@ page import="com.itheima.domain.User" %>
<%@ page import="com.itheima.domain.Address" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL从域里取集合/数组数据</title>
</head>
<body>
<%
    User user1 = new User("小张", new Address("河南", "郑州"));
    User user2 = new User("小王", new Address("广东", "深圳"));

    List<User> userList = new ArrayList<>();
    userList.add(user1);
    userList.add(user2);

    request.setAttribute("list", userList);
%>

1. 从域里取第一个user的name值：<br>
用Java表达式：<%=((List<User>)request.getAttribute("list")).get(0).getName()%>
<br>
用EL表达式取：${list[0].name} <%-- EL表达式里：从指定索引取值 用[索引] --%>
<hr>

2. 从域里取第二个user的address的省：<br>
用Java表达式：<%=((List<User>)request.getAttribute("list")).get(1).getAddress().getProvince()%>
<br>
用EL表达式取：${list[1].address.province}

</body>
</html>
