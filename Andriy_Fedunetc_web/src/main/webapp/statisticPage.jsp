<%@ page import="ua.kiev.prog.chekAnket" %>
<%@ page import="java.util.Map" %>
<%@ page import="ua.kiev.prog.MyBDinClass" %>
<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 23.12.2018
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Круговая диаграмма</title>
    <script src="https://www.google.com/jsapi"></script>
    <script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Тварини', 'Кількість'],
                <% if (MyBDinClass.animalMap.size() > 0){  %>
                <%int count = 0;%>
                <% for(Map.Entry<String,Integer> entry : MyBDinClass.animalMap.entrySet()){%>
                <%count++; String temp =",";if(count >= MyBDinClass.animalMap.size())temp = "";%>
                <% String s = "['" + entry.getKey() + "'," + entry.getValue() + "]"+temp;%>
                    <%=s%>
                    <% }} %>


            ]);
            var options = {
                title: 'Тварини',
                is3D: true,
                pieResidueSliceLabel: 'Остальное'
            };
            var chart = new google.visualization.PieChart(document.getElementById('animal'));
            chart.draw(data, options);
        }
    </script>
    <script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Колір', 'Кількість'],
                <% if (MyBDinClass.colorMap.size() > 0){  %>
                <%int count = 0;%>
                <% for(Map.Entry<String,Integer> entry : MyBDinClass.colorMap.entrySet()){%>
                <%count++; String temp =",";if(count >= MyBDinClass.colorMap.size())temp = "";%>
                <% String s = "['" + entry.getKey() + "'," + entry.getValue() + "]"+temp;%>
                <%=s%>
                <% }} %>


            ]);
            var options = {
                title: 'Кольори',
                is3D: true,
                slices: {
                   // 0 : {color: '#000000'},
                    <% if (MyBDinClass.colorMap.size() > 0){  %>
                    <%int count = -1;%>
                    <% for(Map.Entry<String,Integer> entry : MyBDinClass.colorMap.entrySet()){%>
                    <%count++; String temp =",";if(count >= MyBDinClass.colorMap.size()-1)temp = "";%>
                    <% String s = (count) + ":{'color': '" + entry.getKey() + "'}"+temp;%>
                    <%=s%>
                    <% }} %>

                },
                pieResidueSliceLabel: 'Остальное'

            };
            var chart = new google.visualization.PieChart(document.getElementById('color'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>

<div id="color" style="width: 500px; height: 400px;"></div>
<br>
<div id="animal" style="width: 500px; height: 400px;"></div>

</body>
</html>
