<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Result</h2>
    <% List<String> list = (List<String>) request.getAttribute("list"); %>
    <ul>
        <% for (String model : list) { %>
            <li>
                <%= model %>
            </li>
        <% } %>
    </ul>
    <%--${list}--%>
</body>
</html>
