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
            let message = document.getElementById("tip").innerText;
            if(message != ""){
                alert("入库单创建成功!");
            }
            // if(message == "该入库单号已存在!"){
            //     alert("该入库单号已存在!");
            // }else if(message == "入库单创建成功!"){
            //     alert("入库单创建成功!");
            // }else if(message == "入库单创建失败!"){
            //     alert("入库单创建失败!");
            // }
        }
    </script>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">新建入库单</span></div>
        </div>
        <div class="result-wrap">
            <form action="${pageContext.request.contextPath}/newgoodin" method="post" id="myform" name="myform">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>入库单信息</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tbody>
                            <tr>
                                <th width="15%"><i class="require-red">*</i>入库单号：</th>
                                <td><input type="text" id="goodsInId" placeholder="id" size="85" name="goodsInId" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物信息：</th>
                                <td>
                                    <select name="goodsId" required>
                                        <c:forEach var="item" items="${goods}">
                                            <option value="${item.goodsId}">${item.goodsId} : ${item.goodsName} : 库存 : ${item.goodsValue}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>供应商信息：</th>
                                <td>
                                    <select name="providerId" required>
                                        <c:forEach var="item" items="${providers}">
                                            <option value="${item.providerId}">${item.providerId} : ${item.providerName} : ${item.providerTel} : ${item.providerAddress}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>入库单价:</th>
                                <td><input type="number" id="StackInOrderValue" placeholder="入库单价" size="85" name="StackInOrderValue" class="common-text" required></td>
                            </tr>

                            <tr>
                                <th><i class="require-red">*</i>入库数量:</th>
                                <td><input min="0" type="number" placeholder="入库数量" name="StackInOrderNum" required/></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input type="submit" value="添加" class="btn btn-primary btn6 mr10">
                                    <input type="button" value="重置" onClick="reset()" class="btn btn6">
                                </td>
                                <script>
                                    function reset() {
                                        document.getElementById("goodsInId").innerText = '';
                                        document.getElementById("goodsId").innerText = '';
                                        document.getElementById("goodsName").innerText = '';
                                        document.getElementById("providerName").innerText = '';
                                        document.getElementById("goodsType").innerText = '';
                                        document.getElementById("StackInOrderValue").innerText = '';
                                        document.getElementById("StackInOrderNum").innerText = '';
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

