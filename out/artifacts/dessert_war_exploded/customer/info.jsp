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
                        <a href="customerIndex.action">首页</a>
                    </li>
                    <li>
                        <a href="viewCart.action">购物车</a>
                    </li>
                    <li class="active">
                        <a href="#">个人资料</a>
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
                <table class="table info-table">
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
                        <td id="age-td"><s:property value="customer.age"></s:property></td>
                        <td>
                            <button class="btn btn-cha-age">修改</button>
                        </td>
                    </tr>
                    <tr>
                        <td><label>性别:</label></td>
                        <td><s:if test="customer.sex==0">男</s:if><s:else>女</s:else></td>
                    </tr>
                    <tr>
                        <td><label>地址:</label></td>
                        <td id="addr-td"><s:property value="customer.address"></s:property></td>
                        <td>
                            <button class="btn btn-cha-addr">修改</button>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="mem-label">会员卡状态:</label></td>
                        <td><s:if test="card.state==0">未激活</s:if><s:else>已激活</s:else></td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="mem-label">会员卡余额:</label></td>
                        <td><s:property value="card.money"></s:property></td>
                        <td>
                            <button class="btn cha-money">充值</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%--modal--%>
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">充值</h3>
        </div>
        <div class="modal-body">
            <input class="input-medium" id="modal-input">
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            <button class="btn btn-primary btn-re-primary">确认</button>
        </div>
    </div>


    <div id="my-cha-addr-Modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="addr-Label">输入新的地址</h3>
        </div>
        <div class="modal-body">
            <input class="input-medium" id="modal-cha-addr-input">
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            <button class="btn btn-primary btn-cha-addr-primary">确认</button>
        </div>
    </div>


    <div id="my-cha-age-Modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="age-Label">输入年龄</h3>
        </div>
        <div class="modal-body">
            <input class="input-medium" id="modal-cha-age-input">
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            <button class="btn btn-primary btn-cha-age-primary">确认</button>
        </div>
    </div>
</div>
</body>
</html>