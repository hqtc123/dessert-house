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
    <script type="text/javascript" src="<%=basePath%>static/js/index.js"></script>
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
                    <li class="active">
                        <a href="customer/toLogin.action">登录</a>
                    </li>
                    <li>
                        <a href="customer/toRegister.action">注册</a>
                    </li>
                    <li>
                        <a href="about">关于</a>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<div class="container">
    <h1>欢迎光临环球探测甜品屋</h1>
    <a href="toCustomer.action"><h1>顾客登陆页面</h1></a>
    <a href="toMember.action"><h1>内部工作人员登陆页面</h1></a>

    <p>Use this document as a way to quick start any new project.
        <br>All you get is this message and a barebones HTML document.</p>
</div>
<input type="text" class="input-large">
<button class="btn">Button</button>
<!-- /container -->
<!-- Le javascript==================================================-
->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</body>
</html>