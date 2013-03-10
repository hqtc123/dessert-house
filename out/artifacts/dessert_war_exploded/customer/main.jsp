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
                        <a href="#">购物车</a>
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
                    <li class="active">
                        <a href="#">店铺一</a>
                    </li>
                    <li>
                        <a href="#">店铺二</a>
                    </li>
                    <li>
                        <a href="#">店铺三</a>
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
                        <th>甜品名称</th>
                        <th>单价</th>
                        <th>剩余数量</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td>row 1,col 1</td>
                        <td>row 1,col 2</td>
                        <td>row 1,col 3</td>
                        <td>
                            <button class="btn">购买</button>
                        </td>
                    </tr>
                    <tr>
                        <td>row 2,col 1</td>
                        <td>row 2,col 2</td>
                        <td>row 2,col 3</td>
                        <td>
                            <button class="btn">购买</button>
                        </td>
                    </tr>
                    <tr>
                        <td>row 3,col 1</td>
                        <td>row 3,col 2</td>
                        <td>row 3,col 3</td>
                        <td>
                            <button class="btn">购买</button>
                        </td>

                    </tr>
                    <tr>
                        <td>row 3,col 1</td>
                        <td>row 3,col 2</td>
                        <td>row 3,col 3</td>
                        <td>
                            <button class="btn">购买</button>
                        </td>
                    </tr>
                    <tr>
                        <td>row 3,col 1</td>
                        <td>row 3,col 2</td>
                        <td>row 3,col 3</td>
                        <td>
                            <button class="btn">购买</button>
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