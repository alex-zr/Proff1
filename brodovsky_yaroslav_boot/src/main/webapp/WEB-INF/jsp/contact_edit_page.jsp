<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Edit Contact</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form role="form" class="form-horizontal" action="/contact/edit" method="post">
                        <h3>Edit contact</h3>
                        <input class="form-control form-group" type="text" name="group" value="${group}">
                        <input class="form-control form-group" type="text" name="name" value="${name}">
                        <input class="form-control form-group" type="text" name="surname" value="${surname}">
                        <input class="form-control form-group" type="text" name="phone" value="${phone}">
                        <input class="form-control form-group" type="text" name="email" value="${email}">
                    <input type="submit" class="btn btn-primary" value="Save">
            </form>
        </div>
    </body>
</html>