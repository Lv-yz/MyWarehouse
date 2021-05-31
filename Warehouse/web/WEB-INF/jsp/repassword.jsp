<%@ page import="com.lv.pojo.Manager" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/13 0013
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <%@include file="comment.jsp"%>

    <span id="tip" hidden>${tip}</span>

    <script>
        function tip() {
            let message = document.getElementById("tip").innerText;
            if(message == "密码修改成功!"){
                alert("密码修改成功!");
            }else if(message == "密码修改失败!"){
                alert("密码修改失败!");
            }else if(message == "原密码错误!"){
                alert("原密码错误!");
            }
        }
    </script>

    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">新建货物</span></div>
        </div>
        <div class="result-wrap">
            <form action="${pageContext.request.contextPath}/repassword" method="post" id="myform" name="myform">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>管理员信息</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tbody>
                            <tr>
                                <th width="15%"><i class="require-red">*</i>旧密码:</th>
                                <td>
                                    <input value="${man.managerId}" name="id" hidden>
                                    <input name="oldPassword" type="password" id="oldPassword" placeholder="oldPassword" size="85" class="common-text" required>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>新密码:</th>
                                <td><input onblur="checkvalue()" type="password" id="newPassword1" placeholder="newPassword" size="85" name="newPassword" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>确认密码:</th>
                                <td>
                                    <input onblur="checkvalue()" type="password" id="newPassword2" placeholder="newPassword" size="85" name="newPassword1" class="common-text" required>
                                    <span style="color: red" id="check"></span>
                                    <script>
                                        function checkvalue() {
                                            var pw1 = document.getElementById("newPassword1").value;
                                            var pw2 = document.getElementById("newPassword2").value;
                                            if(pw1 != pw2){
                                                document.getElementById("check").innerText = "两次密码不一致！";
                                            }else {
                                                document.getElementById("check").innerText = '';
                                                document.getElementById("sub").disabled = false;
                                            }
                                        }
                                    </script>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input type="submit" disabled id="sub" value="修改" class="btn btn-primary btn6 mr10">
                                    <input type="button" value="重置" onClick="reset()" class="btn btn6">
                                </td>
                                <script>
                                    function reset() {
                                        document.getElementById("oldPassword").innerText = '';
                                        document.getElementById("newPassword1").innerText = '';
                                        document.getElementById("newPassword2").innerText = '';
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

