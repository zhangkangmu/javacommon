<%@ page import="day00_hong.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 洪
  Date: 2018/1/10
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加集合元素到表单里</title>
</head>
<body>
<%
    User user = new User("张宇洪", "男", 25);
    User user2 = new User("张宇", "女", 30);
    User user3 = new User("张洪", "男", 20);
    ArrayList<User> users = new ArrayList<>();
    users.add(user);
    users.add(user2);
    users.add(user3);
    request.setAttribute("list", users);
//   自己测试的东西，类成员也可以直接取出来
//    HashMap<String, User> map = new HashMap<>();
//    map.put("user",user);
//    map.put("user2",user2);
//    map.put("user3",user3);
//    request.setAttribute("map",map);
%>
${requestScope.list}<br>
<%--自己测试的东西，类成员也可以直接取出来,不一定要是属性--%>
<%--${requestScope.map.user.name}--%>

<table border="1px" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
    </tr>
    <c:if test="${not empty requestScope.list}">
        <c:forEach items="${requestScope.list}" varStatus="s" var="str">
            <c:if test="${s.count%2==0}">
                <tr bgcolor="#5f9ea0">
                    <td>${s.count}</td>
                    <td>${str.name}</td>
                    <td>${str.sex}</td>
                    <td>${str.age}</td>
                </tr>
            </c:if>
            <c:if test="${s.count%2!=0}">
                <tr bgcolor="#faebd7">
                    <td>${s.count}</td>
                    <td>${str.name}</td>
                    <td>${str.sex}</td>
                    <td>${str.age}</td>
                </tr>
            </c:if>
        </c:forEach>

    </c:if>

</table>
</body>
</html>
