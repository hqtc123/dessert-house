<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hqtc
  Date: 13-3-14
  Time: 下午7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>环球探测甜品屋</title>
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
                        <a href="customerIndex.action">首页</a>
                    </li>
                    <li>
                        <a href="viewCart.action">购物车</a>
                    </li>
                    <li>
                        <a href="getInfoAction.action">个人资料</a>
                    </li>
                    <li class="active">
                        <a href="viewRecords.action">消费记录</a>
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
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">分店查询</li>
                    <li class="active order-menu">
                        <a href="#">消费记录</a>
                    </li>
                    <li class="recharge-menu">
                        <a href="#">充值记录</a>
                    </li>

                </ul>
            </div>
            <!--/.well -->
        </div>
        <!--/span-->
        <div class="span9">
            <div class="hero-unit">
                <table class="table order-table">
                    <tbody>
                    <tr>
                        <th>订单ID</th>
                        <th>订单总价</th>
                        <th>订单日期</th>
                    </tr>
                    <s:iterator value="torders">
                    <tr>
                        <td><s:property value="id"></s:property></td>
                        <td><s:property value="money"></s:property></td>
                        <td><s:property value="date"></s:property></td>
                    </tr>
                    </s:iterator>
                </table>
                <table class="table recharge-table">
                    <tbody>
                    <tr>
                        <th>充值ID</th>
                        <th>充值金额</th>
                        <th>充值日期</th>
                    </tr>
                    <s:iterator value="recharges">
                    <tr>
                        <td><s:property value="id"></s:property></td>
                        <td><s:property value="money"></s:property></td>
                        <td><s:property value="date"></s:property></td>
                    </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </div>
    <hr>
    <footer>
        <p class="">© Company 2013 &nbsp;&nbsp; 环球探测甜品屋</p>
    </footer>
</div>
</body>
</html>