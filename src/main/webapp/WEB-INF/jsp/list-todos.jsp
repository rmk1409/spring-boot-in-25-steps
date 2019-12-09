<%--
  Created by IntelliJ IDEA.
  User: roman.pogorelov
  Date: 09.12.2019
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Todos for ${name}</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <caption>Your todos are</caption>
        <thead>
        <tr>
            <th>Desc</th>
            <th>Date</th>
            <th>Done</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="item">
            <tr>
                <td>${item.desc}</td>
                <td><fmt:formatDate value="${item.targetDate}" pattern="dd/MM/yyyy"/></td>
                <td>${item.done}</td>
                <td><a href="/update-todo?id=${item.id}" type="button" class="btn btn-success">Update</a></td>
                <td><a href="/delete-todo?id=${item.id}" type="button" class="btn btn-warning">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div><a href="/add-todo" class="button">Add a Todo</a></div>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
