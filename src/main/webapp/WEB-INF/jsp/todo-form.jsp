<%--
  Created by IntelliJ IDEA.
  User: roman.pogorelov
  Date: 09.12.2019
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <form method="post">
        <fieldset class="form-group">
            <label>Description
                <input name="desc" type="text" class="form-control" required="required"/>
            </label>
        </fieldset>
        <button type="submit" class="btn btn-success">Add</button>
    </form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
