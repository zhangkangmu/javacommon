<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>一级标题</h1>


1. 嵌套Java表达式。注意表达式里不能多个Java语句（不能有分号;） <br>
<%=new Date()%>

<hr>
2. 嵌套Java代码块。通常用于处理一些逻辑，比如：if判断、for循环<br>
<%
    int i = 10;
    //QueryRunner runner = new QueryRunner();//如果导入的有dbutils的jar包，可以这样写
    //runner.query();

    for (int index = 0; index < i; index++) {
        //System.out.println(index);
%>
<span style="color:red;">aaa <%=index%></span>
<%
    }
%>


<hr>
3. 嵌套Java声明。通常用于声明一些成员变量和成员方法 <br>
<%!
    public int add(int a, int b){
        return a+b;
    }
%>
<%--  <%=add(1, 20)%> --%>
<!-- <%=add(1, 20)%> -->


</body>
</html>
