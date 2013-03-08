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
<jsp:include page="header.jsp"></jsp:include>
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