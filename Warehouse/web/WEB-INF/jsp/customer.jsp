<%@ page import="com.lv.pojo.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/7 0007
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
<%@include file="comment.jsp"%>
    <div class="main-wrap">
        <%
            pageContext.getSession().setAttribute("man",pageContext.getAttribute("man"));
        %>
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">客户信息</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">筛选条件:</th>
                            <td>
                                <select name="search-sort" id="selected">
                                    <option value="1">全部</option>
                                    <option value="2">客户id</option>
                                    <option value="3">客户名</option>
                                </select>
                            </td>

                            <th width="70">id:</th>
                            <td><input class="common-text" placeholder="id" name="keywords" value="" id="keyword" type="text"></td>
                            <td><input onclick="search()" class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                            <a hidden id="search_a" href=""></a>
                            <script>
                                function search() {
                                    let select = document.getElementById("selected");
                                    let type = select.options[select.selectedIndex].value;
                                    let keyword = document.getElementById("keyword").value;
                                    document.getElementById("search_a").setAttribute("href","${pageContext.request.contextPath}/searchcustomer?type="+type+"&keyword="+keyword+"&currentpage=1");
                                    document.getElementById("search_a").click();
                                }
                            </script>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="${pageContext.request.contextPath}/tonewcustomer"><i class="icon-font"></i>新建客户</a>
                    </div>
                </div>
<%--                <%--%>
<%--                    Customer[] customers = (Customer[]) pageContext.findAttribute("customers");--%>
<%--                    pageContext.setAttribute("length",customers.length);--%>
<%--                    int currentpage = request.getParameter("currentpage") == null ? 1 : Integer.parseInt(request.getParameter("currentpage"));--%>
<%--                    pageContext.setAttribute("currentpage",currentpage);--%>
<%--                    int pagecount = customers.length%10 == 0 ? customers.length/10 : customers.length/10+1;--%>
<%--                    pageContext.setAttribute("pagecount",pagecount);--%>
<%--                %>--%>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>客户ID</th>
                            <th>客户名</th>
                            <th>客户电话</th>
                            <th>客户地址</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="item" items="${customers}">
                            <tr>
                                <td class="tc"><input name="id[]" value="58" type="checkbox"></td>
                                <td>${item.customerId}</td>
                                <td>${item.customerName}</td>
                                <td>${item.customerTel}</td>
                                <td>${item.customerAddress}</td>
                                <td>
                                    <a class="link-update" href="${pageContext.request.contextPath}/toupdatecustomer?id=${item.customerId}" onclick="change()">修改</a>
                                    <a class="link-del" href="javascript:if(window.confirm('确认删除?')){window.location.href = '${pageContext.request.contextPath}/deletecustomer?id=${item.customerId}'}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                    <div class="list-page">
                        <a id="front" href="#" onclick="front()">上一页</a>
                        <span id="length">${length}</span> 条
                        <span id="currentpage">${currentpage}</span>/
                        <span id="pagecount">${pagecount}</span> 页
                        <a id="late" href="#" onclick="late()">下一页</a>
                        <script>
                            function front() {
                                if(Number(document.querySelector("#currentpage").innerText)-1 <= 0)
                                    return;
                                let currentpage =Number(document.querySelector("#currentpage").innerText)-1;
                                let select = document.getElementById("selected");
                                let type = select.options[select.selectedIndex].value;
                                let keyword = document.getElementById("keyword").value;
                                document.getElementById("front").setAttribute("href","${pageContext.request.contextPath}/searchcustomer?type="+type+"&keyword="+keyword+"&currentpage="+currentpage);
                                document.getElementById("front").click();
                            }
                            function late() {
                                if(Number(document.querySelector("#currentpage").innerText)+1 > Number(document.querySelector("#pagecount").innerText))
                                    return;
                                let currentpage = Number(document.querySelector("#currentpage").innerText)+1;
                                let select = document.getElementById("selected");
                                let type = select.options[select.selectedIndex].value;
                                let keyword = document.getElementById("keyword").value;
                                document.getElementById("late").setAttribute("href","${pageContext.request.contextPath}/searchcustomer?type="+type+"&keyword="+keyword+"&currentpage="+currentpage);
                                document.getElementById("late").click();
                            }
                        </script>
                    </div>
                </div>
            </form>
        </div>
    </div>
<%--    <!--/main-->--%>
</div>
</body>
</html>
