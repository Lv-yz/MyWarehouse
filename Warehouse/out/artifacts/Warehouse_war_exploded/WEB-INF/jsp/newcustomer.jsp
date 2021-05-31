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
            if(message == "该客户已存在!"){
                alert("该客户已存在!");
            }else if(message == "客户新建成功!"){
                alert("客户新建成功!");
            }else if(message == "客户新建失败!"){
                alert("客户新建失败!");
            }
        }
    </script>

    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">新建客户</span></div>
        </div>
        <div class="result-wrap">
            <form action="${pageContext.request.contextPath}/newcustomer" method="post" id="myform" name="myform">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>客户信息</h1>
                    </div>
                    <div class="result-content">
                        <form action="${pageContext.request.contextPath}/newcustomer">
                            <table width="100%" class="insert-tab">
                                <tbody>
                                <tr>
                                    <th width="15%"><i class="require-red">*</i>客户id：</th>
                                    <td><input type="text" id="customerId" placeholder="id" size="85" name="customerId" class="common-text" required></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red">*</i>客户名：</th>
                                    <td><input type="text" id="customerName" placeholder="name" size="85" name="customerName" class="common-text" required></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red">*</i>客户电话：</th>
                                    <td><input type="text" id="customerTel" placeholder="telephone" size="85" name="customerTel" class="common-text" required></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red">*</i>客户地址：</th>
                                    <td><input type="text" id="customerAddress" placeholder="address" size="85" name="customerAddress" class="common-text" required></td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <td>
                                        <input type="submit" value="添加" class="btn btn-primary btn6 mr10">
                                        <input type="button" value="重置" onClick="reset()" class="btn btn6">
                                        <script>
                                            function reset() {
                                                document.getElementById("customerId").innerText = "";
                                                document.getElementById("customerName").innerText = "";
                                                document.getElementById("customerTel").innerText = "";
                                                document.getElementById("customerAddress").innerText = "";
                                            }
                                        </script>
                                        ${tip}
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

