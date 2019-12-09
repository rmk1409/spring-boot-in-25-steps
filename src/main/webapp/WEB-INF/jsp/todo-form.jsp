<%--
  Created by IntelliJ IDEA.
  User: roman.pogorelov
  Date: 09.12.2019
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>welcome</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <form:form method="post" modelAttribute="todo">
        <fieldset class="form-group">
            <form:label path="desc">Description
                <form:input path="desc" type="text" class="form-control" required="required"/>
            </form:label>
            <form:errors path="desc" cssClass="text-warning"></form:errors>
        </fieldset>
        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
