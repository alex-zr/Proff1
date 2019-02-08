<%--
  Created by IntelliJ IDEA.
  User: Dmitry Pinchuk
  Date: 15.01.2019
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
    <% if (request.getAttribute("errors") != null) { %>
    ${errors}
    <% } %>

    <% String login = (String)session.getAttribute("user_login");%>
    <% if(login==null || "".equals(login)){ %>
    <form action="/dmitry_pinchuk_web_war_exploded/authen">
        <input type="text" name="login" placeholder = "Input your login"/><br/>
        <input type="text" name="password" placeholder = "Input your password"/><br/>
        <input type="submit" value="Login"/>
    </form>
    Click here to <a href = "dmitry_pinchuk_web_war_exploded/registration.jsp">Registrate</a>
    <% }else{%>
    <h1>You are login as: <%=login%></h1><br>
    Click here to <a href ="dmitry_pinchuk_web_war_exploded/test.jsp">get Test</a><br>
    Click here to <a href="dmitry_pinchuk_web_war_exploded/authen/?a=exit"> logout</a>
    <% }%>
</body>
</html>