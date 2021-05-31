<%--
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
            <form action="${pageContext.request.contextPath}/updategood" method="post" id="myform" name="myform">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>货物信息</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tbody>
                            <tr>
                                <th width="15%"><i class="require-red">*</i>货物id：</th>
                                <td>
                                    <input value="${goods.goodsId}" disabled type="text" id="goodsId" placeholder="id" size="85" class="common-text" required>
                                    <input value="${goods.goodsId}" type="text" name="goodsId">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物名：</th>
                                <td><input value="${goods.goodsName}" type="text" id="goodsName" placeholder="name" size="85" name="goodsName" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物类型：</th>
                                <td><input value="${goods.goodsType}" type="text" id="goodsType" placeholder="type" size="85" name="goodsType" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物库存：</th>
                                <td><input value="${goods.goodsValue}" disabled type="text" id="goodsValue" placeholder="value" size="85" name="goodsValue" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>货物单位：</th>
                                <td><input value="${goods.goodsPaper}" type="text" id="goodsPaper" placeholder="paper" size="85" name="goodsPaper" class="common-text" required></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input type="submit" value="修改" class="btn btn-primary btn6 mr10">
                                    <input type="button" value="重置" onClick="reset()" class="btn btn6">
                                </td>
                                <script>
                                    function reset() {
                                        // document.getElementById("goodsId").innerText = '';
                                        document.getElementById("goodsName").innerText = ${goods.goodsName};
                                        document.getElementById("goodsType").innerText = ${goods.goodsType};
                                        <%--document.getElementById("goodsValue").innerText = ${goods.goodsValue};--%>
                                        document.getElementById("goodsPaper").innerText = ${goods.goodsPaper};
                                    }
                                </script>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>
    </body>
</html>
