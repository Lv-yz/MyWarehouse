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
            if(message == "该货物已存在!"){
                alert("该货物已存在!");
            }else if(message == "货物新建成功!"){
                alert("货物新建成功!");
            }else if(message == "货物创建失败!"){
                alert("货物创建失败!");
            }
        }
    </script>

    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">新建货物</span></div>
        </div>
        <div class="result-wrap">
            <form action="${pageContext.request.contextPath}/newgood" method="post" id="myform" name="myform">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>货物信息</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tbody>
                            <tr>
                                <th width="15%"><i class="require-red">*</i>货物id：</th>
                                <td><input type="text" id="goodsId" placeholder="id" size="85" name="goodsId" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物名：</th>
                                <td><input type="text" id="goodsName" placeholder="name" size="85" name="goodsName" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物类型：</th>
                                <td><input type="text" id="goodsType" placeholder="type" size="85" name="goodsType" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物库存：</th>
                                <td><input type="text" id="goodsValue" placeholder="value" size="85" name="goodsValue" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物单位：</th>
                                <td><input type="text" id="goodsPaper" placeholder="paper" size="85" name="goodsPaper" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input type="submit" value="添加" class="btn btn-primary btn6 mr10">
                                    <input type="button" value="重置" onClick="reset()" class="btn btn6">
                                </td>
                                <script>
                                    function reset() {
                                        document.getElementById("goodsId").innerText = '';
                                        document.getElementById("goodsName").innerText = '';
                                        document.getElementById("goodsType").innerText = '';
                                        document.getElementById("goodsValue").innerText = '';
                                        document.getElementById("goodsPaper").innerText = '';
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

