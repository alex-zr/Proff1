<%@ page import="java.time.LocalDate" %>
<html>
    <body>
        <h2>Hello World!</h2>

        <form action="/serv" method="get">
            <input type="text" name="login" value="man"/>
            <br>
            <input type="password" name="password" value="man"/>
            <br>
            <input type="submit" value="Login">

        </form>


        <%
            LocalDate date = LocalDate.now();
        %>
        <%= date %>
    </body>
</html>
