<html>
<body>

    <h2> Some question</h2>

    <% if (request.getAttribute("errors") != null) { %>
    ${errors}<br>
    <% } %>

    <form action="chekAnket" method="post">

        First name: <input type = text name="firstName" value="firstName"><br>
        Last name: <input type = text name="lastName" value="lastName"><br>
        Age: <input type = number name="age" value="1"><br><br><br>
        Questions:<br>

        What is your favorite color? <br>
                <input type = color name="color"><br>
        What animal you liked?<br>
                <input type = text name="animal"><br>
        <input type =submit value="send">
    </form>
    <form action="statisticServlet">
        <input type = submit value="Statistic">
    </form>
</body>
</html>
