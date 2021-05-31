<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/4 0004
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">
    <title>Signin Template for Bootstrap</title>
    <link href="static/login/bootstrap.min.css" rel="stylesheet">
    <link href="static/login/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="static/login/signin.css" rel="stylesheet">
  </head>
  <body onload="tip()">

  <span id="tip" hidden>${warm}</span>

  <script>
    function tip(){
      var innerText = document.getElementById("tip").innerText;
      let flag = (innerText == "账号或密码有误!");
      if(flag){
        alert("账号或密码有误!");
      }
    }
  </script>

    <div class="container">
      <form method="post" class="form-signin" action="${pageContext.request.contextPath}/login">
        <h2 class="form-signin-heading">小型仓库管理</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="text" name="managerId" id="inputUsername" class="form-control" placeholder="Username" required="">
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="">登陆</button>
      </form>
    </div>
  </body>
</html>
