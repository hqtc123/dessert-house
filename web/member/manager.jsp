<%@ taglib prefix="s" uri="/struts-tags" %>
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
                        <a href="#">甜品店经理</a>
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
                    <li class="nav-header">选项</li>
                    <li id="cus-card-menu" class="active">
                        <a href="#">统计顾客信息</a>
                    </li>
                    <li id="cus-order-menu">
                        <a href="#">统计订单信息</a>
                    </li>
                    <li id="cus-dessert-menu">
                        <a href="#">统计热卖产品</a>
                    </li>
                </ul>
            </div>
            <!--/.well -->
        </div>

        <div class="span9">
            <div class="hero-unit hero-customer">
                <table class="table cus-card-table">
                    <tbody>
                    <tr>
                        <th>会员ID</th>
                        <th>会员账号</th>
                        <th>会员年龄</th>
                        <th>卡状态</th>
                        <th>卡余额</th>
                    </tr>
                    <s:iterator value="cusCards">
                        <tr>
                            <td><s:property value="customer.id"></s:property></td>
                            <td><s:property value="customer.account"></s:property></td>
                            <td><s:property value="customer.age"></s:property></td>
                            <td><s:if test="card.state==1">
                                激活
                            </s:if><s:elseif test="card.state==2">
                                暂停
                            </s:elseif><s:else>
                                未激活
                            </s:else>
                            </td>
                            <td><s:property value="card.money"></s:property></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            合计总人数： <s:property value="cusCards.size"></s:property>
                        </td>
                    </tr>

                </table>
            </div>

            <div class="hero-unit hero-order">
                <table class="table">
                    <thead><label>店铺1</label></thead>
                    <tbody>
                    <tr>
                        <th>订单ID</th>
                        <th>会员ID</th>
                        <th>订单状态</th>
                        <th>总价</th>
                    </tr>
                    <s:iterator value="torders1">
                        <tr>
                            <td><s:property value="id"></s:property></td>
                            <td><s:property value="customerid"></s:property></td>
                            <td><s:if test="salerid!=0">
                                已发货
                            </s:if><s:else>
                                未发货
                            </s:else>
                            </td>
                            <td><s:property value="money"></s:property></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            合计订单数： <s:property value="torders1.size"></s:property>
                        </td>
                    </tr>

                </table>
            </div>

            <div class="hero-unit hero-order">
                <table class="table">
                    <thead><label>店铺2</label></thead>
                    <tbody>
                    <tr>
                        <th>订单ID</th>
                        <th>会员ID</th>
                        <th>订单状态</th>
                        <th>总价</th>
                    </tr>
                    <s:iterator value="torders2">
                        <tr>
                            <td><s:property value="id"></s:property></td>
                            <td><s:property value="customerid"></s:property></td>
                            <td><s:if test="salerid!=0">
                                已发货
                            </s:if><s:else>
                                未发货
                            </s:else>
                            </td>
                            <td><s:property value="money"></s:property></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            合计订单数： <s:property value="torders2.size"></s:property>
                        </td>
                    </tr>

                </table>
            </div>

            <div class="hero-unit hero-dessert-num">
                <table class="table">
                    <thead><label>热卖产品</label></thead>
                    <tbody>
                    <tr>
                        <th>产品ID</th>
                        <th>产品名称</th>
                        <th>卖出数量</th>
                    </tr>
                    <s:bean name="com.hqtc.util.NumComparator" var="numComparator"></s:bean>
                    <s:sort comparator="#numComparator" source="dessertNums">
                        <s:iterator>
                            <tr>
                                <td><s:property value="dessert.id"></s:property></td>
                                <td><s:property value="dessert.name"></s:property></td>
                                <td><s:property value="num"></s:property></td>
                            </tr>
                        </s:iterator>
                    </s:sort>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
</body>
</html>