<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Questionnaire</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<form action="/question?action=stat" method="POST">
    <div class="container">
        <label for="firstName">Enter your first name:</label>
        <input type="text" id="firstName" name="firstName" placeholder="First name" required/>
        <label for="secondName">Enter your second name:</label>
        <input type="text" id="secondName" name="lastName" placeholder="Last name" required/>

        <label for="age">Enter your age:</label>
        <input type="number" id="age" name="age" min="0" max="120" placeholder="Age" required/>
        <label>Do you like Java?</label>
        <input type="hidden" value="Do you like Java?" name="question1body" />
        <br>
        <label class="radio_container">Yes
            <input type="radio" name="question1" value="Yes" checked="checked">
            <span class="checkmark"></span>
        </label>
        <label class="radio_container">No
            <input type="radio" name="question1" value="No">
            <span class="checkmark"></span>
        </label>
        <label>Do you like .NET?</label>
        <input type="hidden" value="Do you like .NET?" name="question2body" />
        <br>
        <label class="radio_container">Yes
            <input type="radio" name="question2" value="Yes" checked="checked">
            <span class="checkmark"></span>
        </label>

        <label class="radio_container">No
            <input type="radio" name="question2" value="No">
            <span class="checkmark"></span>
        </label>
        <div class="clearfix">
            <input type="submit"/>
        </div>
    </div>
</form>
</body>
<html>
