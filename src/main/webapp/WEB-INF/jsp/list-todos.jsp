<%--
  Created by IntelliJ IDEA.
  User: roman.pogorelov
  Date: 09.12.2019
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todos for ${name}</title>
</head>
<body>
<h1>Your Todos</h1>
<table>
    <thead>
    <tr>
        <th>Desc</th>
        <th>Date</th>
        <th>Done</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="item">
        <tr>
            <td>${item.desc}</td>
            <td>${item.targetDate}</td>
            <td>${item.done}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="/add-todo">Add a Todo</a>
</body>
</html>
