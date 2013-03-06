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
    <script type="text/javascript" src="../static/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../static/js/jquery.artDialog.js"></script>
    <script type="text/javascript" src="../static/js/register.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/css/dialog-twitter.css">
    <link rel="stylesheet" type="text/css" href="../static/css/reglog.css">
</head>
<body>
<div id="content">
    <div id="pad">

    </div>
    <div id="logo">
        <a href="../../index.jsp"><img src="../static/images/logo.png" title="返回首页"></a>
    </div>
    <div id="boxArea">
        <h3>免费注册</h3>

        <s:form id="register_form" action="registerAction" method="POST">
                <s:textfield id="accountField" label="账户名" cssClass="textField" name="customer.account"></s:textfield>

                <s:password id="passwordField" cssClass="textField" name="customer.password" label="密 码"></s:password>
                <s:password id="rePasswordField" cssClass="textField" label="确认密码"></s:password>
                <s:textfield id="ageField" cssClass="textField" name="customer.age" label="年 龄"></s:textfield> <br>
                <s:radio label="性别" list="#{'1':'男','0':'女'}" name="sex" value="1"/>
                <s:textfield id="addressField" cssClass="textField" name="customer.address" label="住 址"></s:textfield>
                <br>
            <div class="sub">
                <s:submit id="registerBtn" type="button" value="注册"/>
            </div>
        </s:form>
    </div>
</div>

</body>
</html>