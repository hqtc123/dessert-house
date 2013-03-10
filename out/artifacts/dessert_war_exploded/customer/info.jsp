<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.hqtc.model.entity.Customer" %>
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
    <jsp:include page="resource.jsp"></jsp:include>
    <title>我的账户</title>
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
                        <a href="main.jsp">首页</a>
                    </li>
                    <li>
                        <a href="#">购物车</a>
                    </li>
                    <li>
                        <a class="active" href="#">个人资料</a>
                    </li>
                    <li>
                        <a href="logoutAction.action">注销</a>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>


<div class="container-fluid">
    <div class="pad"></div>
    <div class="row-fluid">
        <div class="span9">
            <div class="hero-unit">
                <table class="table">
                    <tbody>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr>
                        <td><label>账号:</label></td>
                        <td><s:property value="customer.account"></s:property></td>
                    </tr>
                    <tr>
                        <td><label>年龄:</label></td>
                        <td><s:property value="customer.age"></s:property></td>
                        <td>
                            <button class="btn cha-age">修改</button>
                        </td>
                    </tr>
                    <tr>
                        <td><label>性别:</label></td>
                        <td><s:if test="customer.sex==0">男</s:if><s:else>女</s:else></td>
                    </tr>
                    <tr>
                        <td><label>地址:</label></td>
                        <td><s:property value="customer.address"></s:property></td>
                        <td>
                            <button class="btn cha-add">修改</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>