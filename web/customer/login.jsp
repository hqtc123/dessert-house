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
                    <li class="active">
                        <a href="#">登录</a>
                    </li>
                    <li>
                        <a href="toRegister.action">注册</a>
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

    <div id="boxArea2">
        <h3>快速登录</h3>
        <s:form id="login_form" action="loginAction" method="POST">
            <s:textfield required="true" id="accountField" label="账户名" cssClass="textField"
                         name="customer.account"></s:textfield>

            <s:password required="true" id="passwordField" cssClass="input-large" name="customer.password"
                        label="密 码"></s:password>
            <br>
            <s:submit cssClass="btn" type="button" value="登录"/>
        </s:form>
    </div>
</div>

</body>
</html>