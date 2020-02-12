<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式进行运算</title>
</head>
<body>
<%
    request.setAttribute("number", 10);

    request.setAttribute("list1", new ArrayList<>());

    List<String> list2 = new ArrayList<>();
    list2.add("");
    request.setAttribute("list2", list2);

    request.setAttribute("map1", new HashMap<>());

    Map<String, String> map2 = new HashMap<>();
    map2.put("aa", "");
    request.setAttribute("map2", map2);
%>

1. 基本数学运算：+,-,*,/.. <br>
1+1 = ${1+1}<br>
number+1= ${number+1}

<hr>
2. 比较运算：>,<,>=,<=,==,!= 或者 gt, lt, ge, le, eq, ne <br>
number > 5? ${number > 5}, ${number gt 5}

<hr>
3. 逻辑运算：&&, ||, ! 或者 and, or, not <br>
number是5~15之间的数字吗？${number >= 5 and number <= 15}, ${number >= 5 && number <= 15}

<hr>
4. 可以判空：empty <br>
0是空吗？${empty 0}<br>
1是空吗？${empty 1}<br>
""是空吗？${empty ""}<br>
null是空吗？${empty null}<br>
list1是空吗？${empty list1}<br>
list2是空吗? ${empty list2}<br>
map1是空吗？${empty map1}<br>
map2是空吗？${empty map2}

<hr>
5. 三元运算 <br>
map2是空吗？${empty map2?"空":"非空"}

<hr>
实际的JSP使用中，要尽可能少出现、甚至不出现嵌套Java代码。<br>
如果在JSP里需要使用  动态获取项目路径：<br>
嵌套Java代码方式：<%=request.getContextPath()%> <br>
使用EL表达式方式：${pageContext.request.contextPath}<br>


</body>
</html>
