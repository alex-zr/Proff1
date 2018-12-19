<%@ page import="java.time.LocalTime" %>
<html>
<body>
<h2>New profile</h2>
<form action="/profileServlet" method="post">

    <input type="text" name="Name" value="man"/> <br/>
    <input type="text" name="Surname" value="man"/> <br/>
    <input type="text" name="Age" value="man"/> <br/>


    Do you want to be a java junior developer?
    <input type="radio" name="question1" value="yes">
    <input type="radio" name="question1" value="no"><br/>
    What do you prefer: intellij Idea or Eclipse?
    <input type="radio" name="question2" value="idea">
    <input type="radio" name="question2" value="eclipse">
    <input type="submit" value="Login">
    <a href="/profileServlet">Goto first servlet</a>

</form>
</body>
</html>
