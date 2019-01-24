<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Contact</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/contact/change" method="post">
        <h3>Change contact</h3>
        <select class="selectpicker form-control form-group" name="group">
            <option value="-1">Default</option>
            <c:forEach items="${groups}" var="group">
                <option value="${group.id}">${group.name}</option>
            </c:forEach>
        </select>
        <input class="form-control form-group" type="text" name="contact_id" value="id">
        <input class="form-control form-group" type="text" name="contact_name" value="name">
        <input class="form-control form-group" type="text" name="contact_surname" value="surname">
        <input class="form-control form-group" type="text" name="contact_phone" value="phone">
        <input class="form-control form-group" type="text" name="contact_email" value="email">
        <input type="submit" class="btn btn-primary" value="Submit">
    </form>
</div>

<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>