<%@ page import="java.util.*, jakarta.servlet.http.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обчислення</title>
</head>
<body>

<%
    String start = "0";
    String end = "11";
    String step = "2";

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("start".equals(cookie.getName())) {
                start = cookie.getValue();
            }
            if ("end".equals(cookie.getName())) {
                end = cookie.getValue();
            }
            if ("step".equals(cookie.getName())) {
                step = cookie.getValue();
            }
        }
    }
%>
<form action="calculator" method="post">
    Початкове значення: <input type="text" name="start" value=<%=start%>><br>
    Кінцеве значення: <input type="text" name="end" value=<%=end%>><br>
    Крок: <input type="text" name="step" value=<%=step%>><br>
    <input type="submit" value="Обчислити">
</form>

<%
    // Отримання повідомлення про помилку та результатів з сесії

    List<Double[]> results = (List<Double[]>) request.getSession().getAttribute("results");



    if (results != null && !results.isEmpty()) {
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