<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/13 0013
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">新建客户</span></div>
        </div>
        <div class="result-wrap">
            <form action="${pageContext.request.contextPath}/updatecustomer" method="post" id="myform" name="myform">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>客户信息</h1>
                    </div>
                    <div class="result-content">
                        <form action="${pageContext.request.contextPath}/updatecustomer">
                            <table width="100%" class="insert-tab">
                                <tbody><tr>
                                    <th width="15%"><i class="require-red">*</i>客户id：</th>
                                    <td>
                                        <input value="${customer.customerId}" disabled type="text" id="customerId" placeholder="id" size="85"  class="common-text" required>
                                        <input value="${customer.customerId}" hidden name="customerId">
                                    </td>
                                </tr>
                                <tr>
                                    <th><i class="require-red">*</i>客户名：</th>
                                    <td><input value="${customer.customerName}" type="text" id="customerName" placeholder="name" size="85" name="customerName" class="common-text" required></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red">*</i>客户电话：</th>
                                    <td><input value="${customer.customerTel}" type="text" id="customerTel" placeholder="telephone" size="85" name="customerTel" class="common-text" required></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red">*</i>客户地址：</th>
                                    <td><input value="${customer.customerAddress}" type="text" id="customerAddress" placeholder="address" size="85" name="customerAddress" class="common-text" required></td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <td>
                                        <input type="submit" value="修改" class="btn btn-primary btn6 mr10">
                                        <input type="button" value="重置" onClick="reset()" class="btn btn6">
                                        <script>
                                            function reset() {
                                                // document.getElementById("customerId").innerText = "";
                                                document.getElementById("customerName").innerText = ${customer.customerName};
                                                document.getElementById("customerTel").innerText = ${customer.customerTel};
                                                document.getElementById("customerAddress").innerText = ${customer.customerAddress};
                                            }
                                        </script>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </form>
        </div>
    </div>
    </body>
</html>
