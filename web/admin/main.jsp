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
                    <li class="active">
                        <a href="#">管理员工</a>
                    </li>
                    <li>
                        <a href="#">制定优惠策略</a>
                    </li>
                </ul>
            </div>
            <!--/.well -->
        </div>
        <!--/span-->
        <div class="span9">
            <div class="hero-unit">
                <table class="table">
                    <tbody>
                    <tr>
                        <th>员工号</th>
                        <th>账户</th>
                        <th>店铺号</th>
                        <th></th>

                    </tr>
                    <S:iterator value="customers">
                        <s:property></s:property>
                    </S:iterator>
                    <tr>
                        <td>row 1,col 1</td>
                        <td>row 1,col 2</td>
                        <td>row 1,col 3</td>
                        <td>
                            <button class="btn">修改</button>
                        </td>
                    </tr>
                    <tr>
                        <td>row 2,col 1</td>
                        <td>row 2,col 2</td>
                        <td>row 2,col 3</td>
                        <td>
                            <button class="btn">修改</button>
                        </td>
                    </tr>
                    <tr>
                        <td>row 3,col 1</td>
                        <td>row 3,col 2</td>
                        <td>row 3,col 3</td>
                        <td>
                            <button class="btn">修改</button>
                        </td>

                    </tr>
                    <tr>
                        <td>row 3,col 1</td>
                        <td>row 3,col 2</td>
                        <td>row 3,col 3</td>
                        <td>
                            <button class="btn">修改</button>
                        </td>
                    </tr>
                    <tr>
                        <td>row 3,col 1</td>
                        <td>row 3,col 2</td>
                        <td>row 3,col 3</td>
                        <td>
                            <button class="btn">修改</button>
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