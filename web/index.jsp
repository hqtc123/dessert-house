<%--
  Created by IntelliJ IDEA.
  User: He Qing
  Date: 13-2-4
  Time: 下午3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>环球探测甜品屋</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() +
                ":" + request.getServerPort() + path + "/";
    %>
    <script type="text/javascript" src="<%=basePath%>static/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/bootstrap/js/bootstrap.min.js"></script>
    <link href="<%=basePath%>static/bootstrap/lib.min.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="<%=basePath%>static/bootstrap/lib-resp.min.css"
          rel="stylesheet">
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>

            </a>
            <a class="brand" href="#">环球探测甜品屋</a>

            <div class="nav-collapse collapse">
                <ul class="nav">

                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<div class="container">
    <h1>欢迎光临环球探测甜品屋</h1>
    <br>
    <br>
    <a href="toCustomer.action"><h3>顾客登陆页面>>></h3></a>
    <a href="toMember.action"><h3>内部工作人员登陆页面>>></h3></a>
    <a href="toAdmin.action"><h3>系统管理员登陆页面>>></h3></a>

    <p>环球探测探测甜品屋，人生甜蜜之选.
        <br>甜品，是一个很广的概念，大致分为甜点心和广式的糖水。甜品，顾名思义，是不能做正餐的东西，自然也不用顾忌营养或者其他一些禁锢我们口味偏好的规矩之类，
        只要好吃全部都可饮用甜品以成为点心。名副其实的点心还要恰如其分地点在心头，所谓心水之物就是这个意思了。</p>
</div>
</body>
</html>