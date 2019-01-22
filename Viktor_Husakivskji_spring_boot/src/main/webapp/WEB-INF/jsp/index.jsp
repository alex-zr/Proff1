<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prog.kiev.ua</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>

    <table>
        <tr>
            <td>
                <h3><img height="50" width="55" src="<c:url value="/static/logo.png"/>"/></h3>
            </td>
        </tr>
        <tr>
            <td>
                <form action="/login" method="get">
                    <input type="text" name="login" value="man"/> <br/>
                    <input type="password" name="password" value="man"/> <br/>
                    <input type="submit" class="btn btn-default navbar-btn" value="Login">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <button type="button" id="reg" class="btn btn-default navbar-btn">Registration</button>
            </td>
        </tr>
    </table>
    <script>
        $('#reg').click(function(){
            window.location.href='/registration';
        });
    </script>
</body>
</html>
