<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Обчислення формули</title>
</head>
<body>

<img src="images/first.jpg">
<form id="calculationForm" action="calculator">
    Початкове значення (first): <input type="text" name="first" value="0"><br>
    Початкове значення ДО: <input type="text" name="firstTo" value="2"><br>
    Початкове значення КРОК: <input type="text" name="firstStep" value="1"><br>

    <br>

    Друге значення (second): <input type="text" name="second" value="0"><br>
    Друге значення ДО: <input type="text" name="secondTo" value="2"><br>
    Друге значення КРОК: <input type="text" name="secondStep" value="1"><br>

    <br>

    Третє значення (third): <input type="text" name="third" value="0"><br>
    Третє значення ДО: <input type="text" name="thirdTo" value="2"><br>
    Третє значення КРОК: <input type="text" name="thirdStep" value="1"><br>

    <br>

    Четверте значення (fourth): <input type="text" name="fourth" value="0"><br>
    Четверте значення ДО: <input type="text" name="fourthTo" value="2"><br>
    Четверте значення КРОК: <input type="text" name="fourthStep" value="1"><br>

    <br>
    <input type="button" onclick="calculate()" value="Обчислити">
</form>

<div id="result"></div>

<script>

    function calculate() {
        var form = document.getElementById("calculationForm");
        var formData = new FormData(form);

        var xhr = new XMLHttpRequest();
        xhr.open("GET", "calculate.jsp?" + new URLSearchParams(formData).toString(), true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                document.getElementById("result").innerHTML = xhr.responseText;
            }
        };
        xhr.send();
    }
</script>

</body>
</html>