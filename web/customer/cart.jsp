<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: He Qing
  Date: 13-3-10
  Time: 下午9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="resource.jsp"></jsp:include>
    <title>我的购物车</title>
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
                        <a class="active" href="#">购物车</a>
                    </li>
                    <li>
                        <a href="getInfoAction.action">个人资料</a>
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
                        <th>名称</th>
                        <th>单价</th>
                        <th>数量</th>
                    </tr>
                    <s:iterator value="superItems">
                        <tr>
                            <td><s:property value="dessert.name"></s:property></td>
                            <td><s:property value="dessert.price"></s:property></td>
                            <td><s:property value="orderitem.num"></s:property></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            总价： <label id="sum-label"><s:property value="moneySum"></s:property></label>
                        </td>
                    </tr>
                    <s:submit type="button" cssClass="btn pay-btn">付款</s:submit>
                    <s:submit type="button" cssClass="btn pay-cancel-btn">取消订单</s:submit>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>