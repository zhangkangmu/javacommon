<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="day00_hong.User" %><%--
  Created by IntelliJ IDEA.
  User: 洪
  Date: 2018/1/10
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${3>=4}
\${3>=4}
<hr>
<h3>el运算符</h3>
${3+4}<br>
${3/4}<br>
${3 div 4}<br>
<%
    String str = "zhan";
    request.setAttribute("str", str);
    ArrayList<String> list = new ArrayList<>();
    list.add("zhang");
    request.setAttribute("list", list);
%>
<hr>
<br>
${ not empty requestScope.str}<br>
${ not empty requestScope.list}<br>
${ requestScope.list}<br>
${ requestScope.str}<br>
<%-- 张宇洪 --%>

<hr>
${pageContext.request.servletPath}<br>
<hr>

<%
session.setAttribute("name","张三");
request.setAttribute("name","李四");
    request.setAttribute("hong","");
%>
${requestScope.get("name")}<br>
${sessionScope.name}<br>
${name}<br>
${hong}<br>
${requestScope.get("name")}<br>

<hr>
<%
    User user = new User();
    user.setName("张宇洪");
    user.setAge(25);
    HashMap map = new HashMap<>();
    map.put("sname","李四");
    map.put("gender","男");
    map.put("user",user);
    request.setAttribute("map",map);
%>

${requestScope.map}<br>
${requestScope.map["sname"]}<br>
sname=${requestScope.map.sname}<br>
${requestScope.map.user.name}<br>

</body>
</html>
