<%--
  Created by IntelliJ IDEA.
  User: hqtc
  Date: 13-3-8
  Time: 下午8:38
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() +
            ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/admin/main.js"></script>
<link href="<%=basePath%>static/bootstrap/lib.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>static/bootstrap/lib-resp.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/reglog.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/color.css">
