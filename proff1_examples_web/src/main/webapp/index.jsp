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
    <% if (request.getAttribute("errors") != null) { %>
        ${errors}
    <% } %>

    <form action="/proff1_examples_web_war_exploded/auth">
        <input type="text" name="login" value="bill"/><br/>
        <input type="text" name="password" value="gates"/><br/>
        <input type="submit" value="Login"/>
    </form>
    <a href="/proff1_examples_web_war_exploded/registration.jsp">Registration</a>
</body>
</html>
