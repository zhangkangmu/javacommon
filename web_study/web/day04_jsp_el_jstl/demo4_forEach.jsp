<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itheima.domain.User" %>
<%@ page import="com.itheima.domain.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL-forEach循环遍历</title>
</head>
<body>
<%--
c:forEach标签：用于循环遍历
    var：定义一个变量。 变量的值，被JSTL放到了pageScope域对象里
    begin：从几开始循环
    end：循环到几结束
    step：每次循环加几


    items：被循环遍历的对象
    var：定义一个变量。变量的值，被JSTL放到了pageScope域对象里

    varStatus：循环状态对象。这个对象里存储了循环中，当前的索引、序号等等一些状态值
--%>

1. 基本for循环：从1循环到10，显示到页面上，显示成红色 <br>
<c:forEach var="i" begin="1" end="10" step="1">
    <span style="color:red;">hello, 张三 ${i}</span>
</c:forEach>

<hr>
<%
    List<String> stringList = new ArrayList<>();
    stringList.add("苹果");
    stringList.add("华为");
    stringList.add("小米");
    stringList.add("一加");

    request.setAttribute("stringList", stringList);
%>

2. 增强for循环：域里有一个集合，把集合里的元素循环显示成红色的 <br>
<c:forEach items="${stringList}" var="str" varStatus="status">
    <span style="color:red;">
        当前值：${str}，
        当前索引：${status.index},
        当前序号：${status.count}
    </span>
    <br>
</c:forEach>

<hr>
<%
    User user1 = new User("佩奇", new Address("广东", "深圳"));
    User user2 = new User("乔治", new Address("广东", "东莞"));
    User user3 = new User("肖恩", new Address("广东", "惠州"));

    List<User> userList = new ArrayList<>();
    userList.add(user1);
    userList.add(user2);
    userList.add(user3);

    request.setAttribute("userList", userList);
%>
练习：域里有User对象的集合（实际开发中可能是从数据库里查询得到的），要把这个集合循环显示成表格 <br>

<table border="1" width="500">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>地址-省</td>
        <td>地址-市</td>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${user.name}</td>
            <td>${user.address.province}</td>
            <td>${user.address.city}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
