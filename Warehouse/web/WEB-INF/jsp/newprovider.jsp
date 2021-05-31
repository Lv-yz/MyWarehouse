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
            if(message == "该供应商已存在"){
                alert("该供应商已存在");
            }else if(message == "供应商创建成功!"){
                alert("供应商创建成功!");
            }else if(message == "供应商创建失败!"){
                alert("供应商创建失败!");
            }
        }
    </script>

    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">新建供应商</span></div>
        </div>
        <div class="result-wrap">
            <form action="${pageContext.request.contextPath}/newprovider" method="post" id="myform" name="myform">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>供应商信息</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tbody><tr>
                                <th width="15%"><i class="require-red">*</i>供应商id：</th>
                                <td><input type="text" id="providerId" placeholder="id" size="85" name="providerId" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>供应商名：</th>
                                <td><input type="text" id="providerName" placeholder="name" size="85" name="providerName" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>供应商电话：</th>
                                <td><input type="text" id="providerTel" placeholder="telephone" size="85" name="providerTel" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>供应商地址：</th>
                                <td><input type="text" id="providerAddress" placeholder="address" size="85" name="providerAddress" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input type="submit" value="添加" onclick="tip()" class="btn btn-primary btn6 mr10">
                                    <input type="button" value="重置" onClick="reset()" class="btn btn6">
                                </td>
                                <script>
                                    function reset() {
                                        document.getElementById("providerId").innerText = '';
                                        document.getElementById("providerName").innerText = '';
                                        document.getElementById("providerAddress").innerText = '';
                                        document.getElementById("providerTel").innerText = '';
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

