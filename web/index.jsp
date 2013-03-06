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
    <title>环球探测饼屋</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() +
                ":" + request.getServerPort() + path + "/";
    %>
    <script type="text/javascript" src="<%=basePath%>static/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/jquery.artDialog.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/index.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/dialog-twitter.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/layout.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/header.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
</body>
</html>