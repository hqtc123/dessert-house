<%@ taglib prefix="S" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hqtc
  Date: 13-3-8
  Time: 下午9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员，您好</title>
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
                        <a href="#">系统管理员</a>
                    </li>
                    <li>
                        <a href="logoutAction.action">退出登录</a>
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
                    <li id="mem-menu">
                        <a href="#">管理员工</a>
                    </li>
                    <li id="strategy-menu">
                        <a href="#">制定优惠策略</a>
                    </li>
                </ul>
            </div>
            <!--/.well -->
        </div>
        <!--/span-->
        <div class="span9">
            <div class="hero-unit">
                <table class="table" id="man-mem-table">
                    <tbody>
                    <tr>
                        <th>员工号</th>
                        <th>账户</th>
                        <th>职位</th>
                        <th>店铺号</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <S:iterator value="members">
                        <tr>
                            <td><S:property value="id"></S:property></td>
                            <td><S:property value="account"></S:property></td>
                            <td><S:property value="position"></S:property></td>
                            <td><S:property value="shop.id"></S:property></td>
                            <td>
                                <button class="btn change-mem">修改</button>
                            </td>
                            <td>
                                <button class="btn delete-mem">删除</button>
                            </td>
                        </tr>
                    </S:iterator>
                    <tr id="add-mem-tr">
                        <td></td>
                        <td><input class="input-mini" id="add-acc"></td>
                        <td><input class="input-mini" id="add-pos"></td>
                        <td><input class="input-mini" id="add-shop-id"></td>
                        <td>
                            <button class="btn" id="add-sure">添加</button>
                            <button class="btn" id="add-cancel">取消</button>
                        </td>
                    </tr>
                    <tr id="add-btn-tr">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>
                            <button id="add-mem-btn" class="btn">添加员工</button>
                        </td>
                    </tr>
                    </tbody>

                </table>
                <table class="table" id="man-strategy-table">
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
                                <button class="btn delete-strategy-mem">删除</button>
                            </td>
                        </tr>
                    </S:iterator>
                    <tr id="add-strategy-tr">
                        <td></td>
                        <td><input class="input-mini" id="add-sco"></td>
                        <td><input class="input-mini" id="add-dis"></td>
                        <td>
                            <button class="btn" id="add-strategy-sure">添加</button>
                            <button class="btn" id="add-strategy-cancel">取消</button>
                        </td>
                    </tr>
                    <tr id="add-btn-strategy">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>
                            <button id="add-strategy-btn" class="btn">添加策略</button>
                        </td>
                    </tr>
                    </tbody>

                </table>
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