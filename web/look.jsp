
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>查</title>
</head>
<body>
<table border="1px" width="600px">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>分数</th>
    </tr>
    <c:forEach items="${students}" var="s">
        <tr align="center">
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.gender}</td>
            <td>${s.score}</td>
        </tr>
    </c:forEach>
</table>
<a href="main.jsp">返回主页</a>
</body>
</html>
