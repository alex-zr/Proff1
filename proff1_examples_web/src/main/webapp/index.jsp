<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<html>
<body>
    <h2>Hello World!</h2>

    <form action="/serv" method="get">
        <input type="text" name="login" value="man"/> <br/>
        <input type="password" name="password" value="man"/> <br/>
        <input type="submit" value="Login">
    </form>

    <a href="/serv">Goto first servlet</a>

    <%
        LocalTime localDate = LocalTime.now();
    %>

    <%= localDate %>
</body>
</html>
