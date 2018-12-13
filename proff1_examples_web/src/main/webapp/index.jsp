<html>
<body>
    <h2>Hello World!</h2>
    <ol>
        <li>Lexus</li>
        <li>BMW</li>
        <li>Infinity</li>
    </ol>

    <% if (request.getAttribute("errors") != null) { %>
        ${errors}
    <% } %>

    <form action="/proff1_examples_web_war_exploded/auth">
        <input type="text" name="login" value="bill"/><br/>
        <input type="text" name="password" value="gates"/><br/>
        <input type="submit" value="Login"/>
    </form>
    <a href="/proff1_examples_web_war_exploded/serv">Goto first servlet</a>
</body>
</html>
