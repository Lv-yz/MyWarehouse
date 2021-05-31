<%@ page import="com.lv.pojo.Manager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>后台管理</title>
    <%
        String contextPath=request.getContextPath();
        //替代 ${pageContext.request.contextPath }写法；
        //js和css是不能放在WEB-INFX下的。否则会访问不到
    %>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/static/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/static/css/main.css"/>
</head>
<body onload="tip()">
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li>小型仓库管理系统</li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <%
//                    Manager man = (Manager) pageContext.getAttribute("man");
//                    pageContext.setAttribute("man",man);

                    Manager manager = (Manager) pageContext.getSession().getAttribute("manager");
                    pageContext.setAttribute("man",manager);
                %>
                <li>${man.managerName}</li>
                <li><a href="${pageContext.request.contextPath}/torePassword">修改密码</a></li>
                <li><a href="${pageContext.request.contextPath}/exit">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>操作</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath}/tocustomer"><i class="icon-font">&#xe008;</i>客户信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/toprovider"><i class="icon-font">&#xe005;</i>供应商信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/togood"><i class="icon-font">&#xe006;</i>货物信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/tostackinorder"><i class="icon-font">&#xe004;</i>入库单</a></li>
                        <li><a href="${pageContext.request.contextPath}/tostackoutorder"><i class="icon-font">&#xe012;</i>出库单</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
