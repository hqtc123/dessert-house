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
    <script type="text/javascript" src="static/js/jquery-1.9.1.min.js"></script>
    <link href="static/bootstrap/lib.min.css" rel="stylesheet" type="text/css"/>
    <link href="static/bootstrap/lib-resp.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/index.css" rel="stylesheet" type="text/css">
    <link href="static/css/layout.css" rel="stylesheet" type="text/css">
    <style>
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
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
<div class="container-fluid">
    <h1>欢迎光临环球探测甜品屋</h1>

    <div class="row-fluid">

        <div class="span9">
            <div class="hero-unit">
                <img class="logo-img" src="static/images/logo.png"/>
                <table class="table">
                    <tbody>
                    <tr><a href="toCustomer.action">
                        <button class="brand btn-large">顾客登陆页面</button>
                    </a></tr>
                    <tr><a href="toMember.action">
                        <button class="brand btn-large">工作人员登陆页面</button>
                    </a></tr>
                    <tr><a href="toAdmin.action">
                        <button class="brand btn-large">管理员登陆页面</button>
                    </a></tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>