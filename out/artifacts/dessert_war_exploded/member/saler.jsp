<%@ taglib prefix="S" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hqtc
  Date: 13-3-9
  Time: 下午5:14
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
                        <a href="#">售货员</a>
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
                    <li class="nav-header">选项</li>
                    <li id="dessert-menu">
                        <a href="#">管理甜品</a>
                    </li>
                    <li id="weeknum-menu">
                        <a href="#">管理每日可售数量</a>
                    </li>
                </ul>
            </div>
            <!--/.well -->
        </div>
        <!--/span-->
        <div class="span9">
            <div class="hero-unit">
                <table class="table" id="man-dessert-table">
                    <tbody>
                    <tr>
                        <th>甜品ID</th>
                        <th>品名</th>
                        <th>价格</th>
                        <th></th>
                    </tr>
                    <S:iterator value="desserts">
                        <tr>
                            <td><S:property value="id"></S:property></td>
                            <td><S:property value="name"></S:property></td>
                            <td><S:property value="price"></S:property></td>
                            <td>
                                <button class="btn change-dessert">修改</button>
                                <button class="btn delete-dessert">删除</button>
                            </td>
                        </tr>
                    </S:iterator>
                    <tr id="add-dessert-tr">
                        <td></td>
                        <td><input class="input-mini" id="add-name"></td>
                        <td><input class="input-mini" id="add-price"></td>
                        <td>
                            <button class="btn" id="add-dessert-sure">添加</button>
                            <button class="btn" id="add-dessert-cancel">取消</button>
                        </td>
                    </tr>
                    <tr id="add-btn-tr">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>
                            <button id="add-dessert-btn" class="btn">添加甜品</button>
                        </td>
                    </tr>
                    </tbody>

                </table>
                <table class="table" id="man-weeknum-table">
                    <tbody>
                    <tr>
                        <th>策略号</th>
                        <th>积分</th>
                        <th>折扣</th>
                        <th></th>
                    </tr>
                    <S:iterator value="strategies">
                        <tr>
                            <td><S:property value="id"></S:property></td>
                            <td><S:property value="score"></S:property></td>
                            <td><S:property value="discount"></S:property></td>
                            <td>
                                <button class="btn delete-weeknum-mem">删除</button>
                            </td>
                        </tr>
                    </S:iterator>
                    <tr id="add-weeknum-tr">
                        <td></td>
                        <td><input class="input-mini" id="add-sco"></td>
                        <td><input class="input-mini" id="add-dis"></td>
                        <td>
                            <button class="btn" id="add-weeknum-sure">添加</button>
                            <button class="btn" id="add-weeknum-cancel">取消</button>
                        </td>
                    </tr>
                    <tr id="add-btn-weeknum">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>
                            <button id="add-weeknum-btn" class="btn">添加策略</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!--/span-->
    </div>
    <hr>
    <footer>
        <p class="">© Company 2013 &nbsp;&nbsp; 环球探测甜品屋</p>
    </footer>
</div>
</body>
</html>