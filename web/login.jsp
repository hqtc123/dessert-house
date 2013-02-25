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
    <script type="text/javascript" src="js/jslib/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/jslib/jquery.artDialog.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <link rel="stylesheet" type="text/css" href="css/dialog-twitter.css">
    <link rel="stylesheet" type="text/css" href="css/reglog.css">
</head>
<body>
<div id="content">
    <div id="pad">

    </div>
    <div id="logo">
        <a href="index.jsp"><img src="images/logo.png" title="返回首页"></a>
    </div>
    <div id="boxArea2">
        <h3>登录</h3>

        <div id="login_form">
            <div class="textDiv">
                <s:textfield id="accountField" label="账户名" cssClass="textField" name="customer.account"></s:textfield>
            </div>

            <div class="textDiv">
                <s:password id="passwordField" cssClass="textField" name="customer.password" label="密 码"></s:password>
                <br>
            </div>
            <input id="loginBtn" type="button" value="登录"/>
        </div>
    </div>
</div>

</body>
</html>