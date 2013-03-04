<%@ page import="com.hqtc.model.Customer" %>
<%--
  Created by IntelliJ IDEA.
  User: He Qing
  Date: 13-2-19
  Time: 下午8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的账户</title>
    <script type="text/javascript" src="../js/jslib/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../js/jslib/jquery.artDialog.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/dialog-twitter.css">
    <link rel="stylesheet" type="text/css" href="../css/layout.css">
    <link rel="stylesheet" type="text/css" href="../css/header.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
</body>
账号：<%=((Customer) session.getAttribute("user")).getAccount()%>
</html>