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
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() +
                ":" + request.getServerPort() + path + "/";
    %>
    <title>登录</title>
    <script type="text/javascript" src="<%=basePath%>static/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/bootstrap/js/bootstrap.min.js"></script>
    <link href="<%=basePath%>static/bootstrap/lib.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>static/bootstrap/lib-resp.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/reglog.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
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