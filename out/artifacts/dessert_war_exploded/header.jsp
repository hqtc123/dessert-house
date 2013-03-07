<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="navTop">
    <div id="navContent">
        <div id="welcome"><span>欢迎光临环球探测饼屋</span></div>
        <ul id="menu">
            <%if (session.getAttribute("customer") == null) {%>
            <li class="menuItem1"><a class="item">关于</a></li>
            <li class="menuItem"><a class="item" href="user/loginPage.action">登录</a></li>
            <li class="menuItem"><a class="item" href="user/registerPage.action">注册</a></li>
            <%} else {%>
            <li class="menuItem1"><a class="item">关于</a></li>
            <li class="menuItem"><a href="user/info.jsp" class="item">账户</a></li>
            <li class="menuItem"><a class="item">订单</a></li>
            <li class="menuItem"><a class="item" href="user/logoutAction.action" id="logoutLink">注销</a></li>
            <%}%>
        </ul>
    </div>
</div>
