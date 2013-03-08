<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: He Qing
  Date: 13-2-5
  Time: 下午12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <jsp:include page="resource.jsp"></jsp:include>
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
                    <li>
                        <a href="toLogin.action">登录</a>
                    </li>
                    <li class="active">
                        <a href="#">注册</a>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<div id="content">
    <div id="pad">

    </div>
    <div id="logo">
        <a href="../index.jsp"><img src="../static/images/logo.png" title="返回首页"></a>
    </div>
    <div id="boxArea">
        <h3>免费注册</h3>

        <s:form id="register_form" action="registerAction" method="POST">
            <s:textfield id="accountField" label="账户名" cssClass="textField"
                         required="true" name="customer.account"></s:textfield>

            <s:password required="true"
                        id="passwordField" cssClass="textField" name="customer.password" label="密 码"></s:password>
            <s:password id="rePasswordField" cssClass="textField" name="rePassword" label="确认密码"></s:password>
            <s:textfield id="ageField" cssClass="textField" name="customer.age" label="年 龄"></s:textfield> <br>
            <s:radio label="性别" list="#{'1':'男','0':'女'}" name="sex" value="1"/>
            <s:textfield id="addressField" cssClass="textField" name="customer.address" label="住 址"></s:textfield>
            <br>

            <div class="sub">
                <s:submit cssClass="btn" type="button" value="注册"/>
            </div>
        </s:form>
    </div>
</div>

</body>
</html>