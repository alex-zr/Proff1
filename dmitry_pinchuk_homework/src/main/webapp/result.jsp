<%--
  Created by IntelliJ IDEA.
  User: Dmitry Pinchuk
  Date: 16.01.2019
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.concurrent.atomic.AtomicIntegerArray" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<% List<AtomicIntegerArray> list = (List<AtomicIntegerArray>) request.getAttribute("list"); %>
<ul>
    <% for (AtomicIntegerArray model : list) { %>
        <%--<%if (model.equals("questionSexMale")){%>--%>

   <li>
       <p>Question 1: male = <%= model%></p>
   </li>
    <% } %>

            <%--<% for (AtomicIntegerArray moda : list) { %>--%>
            <%--<%if (moda.equals("questionSexFemale")){%>--%>
        <%--<li>--%>
            <%--<p>Question 1: female = <%= moda%></p>--%>
        <%--</li>--%>
            <%--<% } %>--%>
            <%--<% } %>--%>
            <%--<% for (AtomicIntegerArray modb : list) { %>--%>
            <%--<%if (modb.equals("questionLanguageJavaScript")){%>--%>
        <%--<li>--%>
            <%--<p>Question 2: JavaScript ="<%= modb%></p>--%>
        <%--</li>--%>
            <%--<% } %>--%>
            <%--<% } %>--%>
            <%--<% for (AtomicIntegerArray modc : list) { %>--%>
            <%--<%if (modc.equals("questionLanguageJava")){%>--%>
        <%--<li>--%>
            <%--<p>Question 2: JavaScript ="<%= modc%></p>--%>
        <%--</li>--%>
            <%--<% for (AtomicIntegerArray modd : list) { %>--%>
            <%--<%if (modd.equals("questionLanguagePython")){%>--%>
        <%--<li>--%>
            <%--<p>Question 2: JavaScript ="<%= modd%></p>--%>
        <%--</li>--%>
            <%--<% } %>--%>
            <%--<% } %>--%>
            <%--<%}%>--%>
            <%--<%}%>--%>
       <%--<% } %>--%>



</body>
</html>
