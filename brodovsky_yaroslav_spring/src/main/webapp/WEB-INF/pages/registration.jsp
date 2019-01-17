<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <div align="center">
        <h1>${regMes}</h1>
        <form action="/registration" method="POST">
            Login:  <input type="text" name="login"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit">
        </form>
    </div>
</body>
</html>
