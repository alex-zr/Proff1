<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Questionnaire</title>
</head>
<body>
<form action="/alina_sergeeva_web_war_exploded/serv" method="post">
    <p>
        <b>Your name:</b><br>
        <input type="text" size="40"><br>
    </p>
    <p>
        <b>Your surname:</b><br>
        <input type="text" size="40"><br>
    </p>
    <p>
        <b>Your age:</b><br>
        <input type="text" size="40"><br>
    </p>
    <p><b>Choose what kind of operating system you use::</b><br>
        <input type="radio" name="os" value="windows"> WINDOWS<br>
        <input type="radio" name="os" value="linux"> LINUX<br>
        <input type="radio" name="os" value="macOs"> MacOS<br>

    </p>
    <p><b>Choose what brand of smartphone you have :</b><br>
        <input type="radio" name="phone" value="samsung"> SAMSUNG<br>
        <input type="radio" name="phone" value="iPhone"> IPHONE<br>
        <input type="radio" name="phone" value="meizu"> MEIZU<br>
        <input type="radio" name="phone" value="lenovo"> LENOVO<br>
        <input type="radio" name="phone" value="other"> OTHER<br>
    </p>
    <p><input type="submit" value="Send">
        </p>
</form>
</body>
</html>