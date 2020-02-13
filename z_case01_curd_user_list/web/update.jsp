<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/contactsServlet" method="post">
        <!--  隐藏域 提交id-->
        <input type="hidden" name="id" value="${requestScope.contact.id}">
        <input type="hidden" name="action" value="edit">

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="username" value="${requestScope.contact.username}"
                   readonly="readonly" placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="sex" value="男" ${requestScope.contact.sex=="男"?"checked":""} />男
            <input type="radio" name="sex" value="女"  ${requestScope.contact.sex=="女"?"checked":""} />女

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${requestScope.contact.age}" id="age" name="age"
                   placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id="address" class="form-control">
                <c:if test="${requestScope.contact.address == '深圳'}">
                    <option value="深圳" selected>深圳</option>
                    <option value="广州">广州</option>
                    <option value="上海">上海</option>
                    <option value="珠海">珠海</option>
                </c:if>

                <c:if test="${requestScope.contact.address == '上海'}">
                    <option value="深圳">深圳</option>
                    <option value="广州">广州</option>
                    <option value="上海" selected>上海</option>
                    <option value="珠海">珠海</option>
                </c:if>

                <c:if test="${requestScope.contact.address == '广州'}">
                    <option value="深圳">深圳</option>
                    <option value="广州" selected>广州</option>
                    <option value="上海">上海</option>
                    <option value="珠海">珠海</option>
                </c:if>

                <c:if test="${requestScope.contact.address == '珠海'}">
                    <option value="深圳">深圳</option>
                    <option value="广州">广州</option>
                    <option value="上海">上海</option>
                    <option value="珠海" selected>珠海</option>
                </c:if>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" value="${requestScope.contact.QQ}" name="QQ"
                   placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${requestScope.contact.email}" name="email"
                   placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>