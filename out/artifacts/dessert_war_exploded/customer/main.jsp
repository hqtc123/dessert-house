<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hqtc
  Date: 13-3-8
  Time: 上午9:30
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
                    <li class="active">
                        <a href="main.jsp">首页</a>
                    </li>
                    <li>
                        <a href="viewCart.action">购物车</a>
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
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">分店查询</li>
                    <li id="shop-menu1" class="active">
                        <a href="#">店铺一</a>
                    </li>
                    <li>
                        <a id="shop-menu2" href="#">店铺二</a>
                    </li>

                </ul>
            </div>
            <!--/.well -->
        </div>
        <!--/span-->
        <div class="span9">
            <div class="hero-unit">
                <table class="table" id="table-shop1">
                    <tbody>
                    <tr>
                        <th></th>
                        <th>甜品ID</th>
                        <th>甜品名称</th>
                        <th>单价</th>
                        <th>今天剩余数量</th>
                        <th></th>
                    </tr>
                    <s:iterator value="super1">
                    <tr>
                        <td><label class="hide-id"><s:property value="weeknum.id"></s:property></label></td>
                        <td><s:property value="weeknum.dessertid"></s:property></td>
                        <td><s:property value="weeknum.dessertname"></s:property></td>
                        <td><s:property value="dessertPrice"></s:property></td>
                        <td><s:property value="weeknum.num"></s:property></td>
                        <td>
                            <button class="btn buy-btn">购买</button>
                        </td>
                    </tr>
                    </s:iterator>
                </table>
                <table class="table" id="table-shop2">
                    <tbody>
                    <tr>
                        <th></th>
                        <th>甜品ID</th>
                        <th>甜品名称</th>
                        <th>单价</th>
                        <th>今天剩余数量</th>
                        <th></th>
                    </tr>
                    <s:iterator value="super2">
                    <tr>
                        <td><label class="hide-id"><s:property value="weeknum.id"></s:property></label></td>
                        <td><s:property value="weeknum.dessertid"></s:property></td>
                        <td><s:property value="weeknum.dessertname"></s:property></td>
                        <td><s:property value="dessertPrice"></s:property></td>
                        <td><s:property value="weeknum.num"></s:property></td>
                        <td>
                            <button class="btn buy-btn">购买</button>
                        </td>
                    </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
        <!--/span-->
        <div id="my-main-Modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">输入购买数量</h3>
            </div>
            <div class="modal-body">
                <input class="input-medium" id="modal-input">
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                <button class="btn btn-main-primary btn-primary">确认</button>
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