<%--
  Created by IntelliJ IDEA.
  User: Coder Wang
  Date: 2020/7/28
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/login" method="get" autocomplete="off">
    用户名：<input type="number" name="username" placeholder="在此输入用户名"/><br/>
    密码：<input type="password" name="password" placeholder="在此输入密码"><br/>
    <button type="submit">登录</button>
</form>
</body>
</html>
