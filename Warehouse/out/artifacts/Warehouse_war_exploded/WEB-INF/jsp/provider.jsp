<%@ page import="com.lv.pojo.Provider" %>
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
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">供应商信息</span></div>
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
                                    <option value="2">供应商id</option>
                                    <option value="3">供应商名</option>
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
                                    document.getElementById("search_a").setAttribute("href","${pageContext.request.contextPath}/searchprovider?type="+type+"&keyword="+keyword+"&currentpage=1");
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
                        <a href="${pageContext.request.contextPath}/tonewprovider"><i class="icon-font"></i>新增供应商</a>
<%--                        <!-- <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a> -->--%>
<%--                        <!-- <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->--%>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>供应商ID</th>
                            <th>供应商名</th>
                            <th>供应商电话</th>
                            <th>供应商地址</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="item" items="${providers}">
                            <tr>
                                <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                                <td>${item.providerId}</td>
                                <td>${item.providerName}</td>
                                <td>${item.providerTel}</td>
                                <td>${item.providerAddress}</td>
                                <td>
                                    <a class="link-update" href="${pageContext.request.contextPath}/toupdateprovider?id=${item.providerId}">修改</a>
                                    <a class="link-del" href="javascript:if(window.confirm('确认删除?')){window.location.href = '${pageContext.request.contextPath}/deleteprovider?id=${item.providerId}'}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <%
                        Provider[] providers = (Provider[]) pageContext.findAttribute("providers");
                        pageContext.setAttribute("length",providers.length);
                    %>
<%--                    <div class="list-page"> ${length} 条 1/1 页</div>--%>

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
                                document.getElementById("front").setAttribute("href","${pageContext.request.contextPath}/searchprovider?type="+type+"&keyword="+keyword+"&currentpage="+currentpage);
                                document.getElementById("front").click();
                            }
                            function late() {
                                if(Number(document.querySelector("#currentpage").innerText)+1 > Number(document.querySelector("#pagecount").innerText))
                                    return;
                                let currentpage = Number(document.querySelector("#currentpage").innerText)+1;
                                let select = document.getElementById("selected");
                                let type = select.options[select.selectedIndex].value;
                                let keyword = document.getElementById("keyword").value;
                                document.getElementById("late").setAttribute("href","${pageContext.request.contextPath}/searchprovider?type="+type+"&keyword="+keyword+"&currentpage="+currentpage);
                                document.getElementById("late").click();
                            }
                        </script>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
