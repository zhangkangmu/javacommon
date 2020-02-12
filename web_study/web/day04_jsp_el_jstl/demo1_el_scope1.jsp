<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL从域里取数据</title>
</head>
<body>
<%
    request.setAttribute("name","tom_req");    //request：JSP内置的request对象，我们可以直接使用
    request.removeAttribute("name");

    session.setAttribute("name","tom_session");//session：JSP内置的HttpSession对象，我们可以直接使用
    session.removeAttribute("name");

    application.setAttribute("name","tom_app");//application: JSP内置的ServletContext对象，我们可以直接使用
    application.removeAttribute("name");
%>
1. 从request域里取name的值：<br>
用Java表达式：<%=request.getAttribute("name")%>
<br>
用EL表达式取：${requestScope.name}

<hr>
2. 从session域里取name的值：<br>
用Java表达式：<%=session.getAttribute("name")%>
<br>
用EL表达式取：${sessionScope.name}

<hr>
3. 从ServletContext域里取name的值：<br>
用Java表达式：<%=application.getAttribute("name")%>
<br>
用EL表达式取：${applicationScope.name}

<hr>
用EL表达式，从四个域中，按照从小到大的顺序，查找数据：<br>
${name}

</body>
</html>
