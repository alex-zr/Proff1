<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR MESSAGE</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<form align="center" role="form" class="form-horizontal" action="/registration">
    <H1 class=".label-danger"> User with this login already exists!!!</H1>
    <br>
    <H1 class=".label-danger"> Try to use another nickname!!!</H1>
    <input type="submit" class="btn btn-primary" value="Okey:)">
</form>
</body>
</html>