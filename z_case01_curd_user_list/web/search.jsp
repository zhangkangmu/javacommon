<%--
  Created by IntelliJ IDEA.
  User: 洪
  Date: 2020/2/18
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        .content {
            width: 643px;
            margin: 50px auto;
            text-align: center;
        }

        input[type='text'] {

            width: 530px;
            height: 40px;
            font-size: 14px;
        }

        input[type='button'] {
            width: 100px;
            height: 46px;
            background: #38f;
            border: 0;
            color: #fff;
            font-size: 15px
        }

        /*文字的*/
        .result {
            /*position: absolute;*/
            width: 535px;
            text-align: start;
            border: 1px solid #999;
            border-top: 0;
        }

        .result div:hover {
            background-color: #ccc;
            cursor: pointer;
        }
    </style>
    <script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        <!-- 入口函数 -->
        $(function () {
                $(".result").empty().hide();
                $("#searchWord").keyup(function () {
                    // $("#searchWord").change(function () {
                    // alert(this.innerHTML);  --?这个为什么获取不到值
                    var inputConten = $(this).val();
                    if (inputConten === "") {
                        $(".result").empty().hide();
                        return;
                    }
                    $.ajax({
                        url: "/searchKeyWordServlet",
                        type: "get",
                        data: {username: inputConten},
                        success: function (successdata) {
                            if (successdata != null && successdata.length > 0) {


                                $(".result").empty().show();
                                //请求成功了,让div显示出来
                                // alert(successdata);
                                for (var item of successdata) {
                                    $("<div onclick='select(this)'></div>").html(item.username).appendTo($(".result"));
                                    // alert(item.username);
                                }
                            } else {
                                $(".result").empty().hide();
                            }
                        },
                        error: function () {
                            alert("请求失败");
                        },
                        dataType: "json"
                    });
                });
            }
        );

        function select(obj) {
            var jQuery = $(obj).text();
            $("#searchWord").val(jQuery);

            $(".result").empty().hide();
        }

        function login() {
            window.location.href="/login.jsp";
        }
        
        function selectUser() {
            window.location.href="${pageContext.request.contextPath}/contactsServlet?action=queryAll";
        }
    </script>
</head>
<body >
<input onclick="login()" type="button"value="登录" style="width: 70px;height: 30px">
<input onclick="selectUser()" type="button"value="查询所用用户" style="width: 140px;height: 30px">
<div class="content">
    <img alt="" src="img/logo.png"><br/><br/>
    <input type="text" name="word" id="searchWord">
    <input type="button" value="搜索一下">
    <div class="result">
        <div>张三</div>
        <div>张三丰</div>
    </div>
</div>
</body>
</html>