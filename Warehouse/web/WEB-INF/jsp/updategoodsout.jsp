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

    <span id="tip" hidden>${tip}</span>

    <script>
        function tip() {
            if(document.getElementById("tip").innerText == "该出库单号已存在!"){
                alert("该出库单号已存在!");
            }else if(document.getElementById("tip").innerText == "出库单创建成功!"){
                alert("出库单创建成功!");
            } else if(document.getElementById("tip").innerText == "库存不足!"){
                alert("出库单创建成功!");
            }else if(document.getElementById("tip").innerText == "出库单创建失败!"){
                alert("出库单创建失败!");
            }
        }
    </script>

    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">新建货物</span></div>
        </div>
        <div class="result-wrap">
            <form action="${pageContext.request.contextPath}/newgoodout" method="post" id="myform" name="myform">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>出库单信息</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tbody>
                            <tr>
                                <th width="15%"><i class="require-red">*</i>出库单号:</th>
                                <td><input type="text" id="goodsOutId" placeholder="id" size="85" name="goodsOutId" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>出库单价:</th>
                                <td><input type="number" id="OutboundOrderValue" placeholder="出库单价" size="85" name="OutboundOrderValue" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>客户信息:</th>
                                <td>
                                    <select name="customerId" required>
                                        <c:forEach var="item" items="${customers}">
                                            <option value="${item.customerId}"> : ${item.customerId} : ${item.customerName} : ${item.customerTel} : ${item.customerAddress}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物名:</th>
                                <td>
                                    <select name="goodsId" id="goodsId" required>
                                        <c:forEach var="item" items="${goods}">
                                            <option name="${item.goodsId}" value="${item.goodsId}">${item.goodsId} : ${item.goodsName} : 库存 : ${item.goodsValue}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>出库数量:</th>
                                <td><input type="number" min="0" placeholder="出库数量" name="OutboundOrderNum" required></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input type="submit" value="添加" class="btn btn-primary btn6 mr10">
                                    <input type="button" value="重置" onClick="reset()" class="btn btn6">
                                </td>
                                <script>
                                    function reset() {
                                        document.getElementById("goodsOutId").innerText = '';
                                        document.getElementById("goodsId").innerText = '';
                                        document.getElementById("goodsName").innerText = '';
                                        document.getElementById("customerName").innerText = '';
                                        document.getElementById("goodsType").innerText = '';
                                        document.getElementById("OutboundOrderValue").innerText = '';
                                        document.getElementById("OutboundOrderNum").innerText = '';
                                    }
                                </script>
                            </tr>
                            </tbody></table>
                    </div>
                </div>
            </form>
        </div>
    </div>
    </body>
</html>

