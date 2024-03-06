<%@ page import="java.util.*, jakarta.servlet.http.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обчислення</title>
</head>
<body>

<%
    // Значення за замовчуванням
    double start = 0, end = 11, step = 2;
    String exampleType = "1";

    // Перевірка, що запит був відправлений через POST
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        // Отримання параметрів з запиту
        start = Double.parseDouble(request.getParameter("start"));
        end = Double.parseDouble(request.getParameter("end"));
        step = Double.parseDouble(request.getParameter("step"));
        exampleType = request.getParameter("exampleType");
    }

    // Ініціалізація списку для збереження результатів
    List<Double[]> results = new ArrayList<>();

    // Обчислення і додавання результатів до списку
    for (double i = start; i <= end; i += step) {
        double first = i;
        double second = i;
        double third = i;
        double fourth = i;

        double result1 = 3 * (Math.log(Math.abs(first / second))) + Math.sqrt(Math.cos(third) + Math.exp(fourth));
        double result2 = 6 * Math.sin(Math.abs(2 * first)) * Math.log(second) +  Math.sqrt(third * Math.cosh(-1 * fourth));
        double result3 = Math.pow(2 * Math.sin(first) + Math.cos(Math.abs(second)) * Math.sqrt(third), fourth);

        Double[] resultsRow = {first, second, third, fourth, result1, result2, result3};
        results.add(resultsRow);
    }
%>

<form action="calculator" method="post">
    Виберіть приклад:
    <select name="exampleType">
        <option value="1" <%= "1".equals(exampleType) ? "selected" : "" %>>Приклад 1</option>
        <option value="2" <%= "2".equals(exampleType) ? "selected" : "" %>>Приклад 2</option>
        <option value="3" <%= "3".equals(exampleType) ? "selected" : "" %>>Приклад 3</option>
    </select><br>
    Початкове значення: <input type="text" name="start" value="<%= start %>"><br>
    Кінцеве значення: <input type="text" name="end" value="<%= end %>"><br>
    Крок: <input type="text" name="step" value="<%= step %>"><br>
    <input type="submit" value="Обчислити">
</form>

<%
    if (!results.isEmpty()) {
%>
<table border="1">
    <tr>
        <th>First</th>
        <th>Second</th>
        <th>Third</th>
        <th>Fourth</th>
        <th>Result 1</th>
        <th>Result 2</th>
        <th>Result 3</th>
    </tr>
    <%
        for (Double[] row : results) {
    %>
    <tr>
        <%
            for (double cell : row) {
        %>
        <td><%= cell %></td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>
<%
    }
%>

</body>
</html>
