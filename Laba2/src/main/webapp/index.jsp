<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Шаблон виразів взяти з лабораторної роботи №2 першого семестру.</h1>
<h1>Варіант 3</h1>
<img src="images/first.jpg">
<form action="calculator">
    3(ln(|
    <input type="text" name="firstParam" value="${firstParamSaver}">
    /
    <input type="text" name="secondParam" value="${secondParamSaver}">|)
    +
    sqrt(cos(
    <input type="text" name="thirdParam" value="${thirdParamSaver}">
    )
    + e^
    <input type="text" name="fourthParam" value="${fourthParamSaver}">
    )
    )
    <input type="submit" value="=">
    <input type="hidden" name="formNumber" value="1">
</form>
<br>
<br>
<br>

<img src="images/second.jpg">
<form action="calculator">
    6*sin(|2*
    <input type="text" name="firstParam" value="${firstParamSaver}">
    |)^lg(
    <input type="text" name="secondParam" value="${secondParamSaver}">|)
    )
    +
    sqrt(
    <input type="text" name="thirdParam" value="${thirdParamSaver}">
    * ch(-1 *
    <input type="text" name="fourthParam" value="${fourthParamSaver}">
    )
    <input type="submit" value="=">
    <input type="hidden" name="formNumber" value="2">
</form>
<br>
<br>
<br>

<img src="images/third.jpg">
<form action="calculator">
    (2 * sin(
    <input type="text" name="firstParam" value="${firstParamSaver}">
    ) + cos(|
    <input type="text" name="secondParam" value="${secondParamSaver}">|)
    * sqrt(
    <input type="text" name="thirdParam" value="${thirdParamSaver}">
    )|)^
    <input type="text" name="fourthParam" value="${fourthParamSaver}">
    <input type="submit" value="=">
    <input type="hidden" name="formNumber" value="3">
</form>
<br>
</body>
</html>