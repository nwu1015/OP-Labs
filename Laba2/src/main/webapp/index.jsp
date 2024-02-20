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
    <input type="text" name="firstParam" value="">
    /
    <input type="text" name="secondParam" value="">|)
    +
    sqrt(cos(
    <input type="text" name="thirdParam" value="">
    )
    + e^
    <input type="text" name="fourthParam" value="">
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
    <input type="text" name="firstParam" value="">
    |)^lg(
    <input type="text" name="secondParam" value="">|)
    )
    +
    sqrt(
    <input type="text" name="thirdParam" value="">
    * ch(-1 *
    <input type="text" name="fourthParam" value="">
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
    <input type="text" name="firstParam" value="">
    ) + cos(|
    <input type="text" name="secondParam" value="">|)
    * sqrt(
    <input type="text" name="thirdParam" value="">
    )|)^
    <input type="text" name="fourthParam" value="">
    <input type="submit" value="=">
    <input type="hidden" name="formNumber" value="3">
</form>
<br>
</body>
</html>