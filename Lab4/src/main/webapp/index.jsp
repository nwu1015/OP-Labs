<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Пошук продуктів</title>
</head>
<body>
<h2>Результати пошуку продуктів</h2>
<form action="search" method="get">
    <label for="productName">Назва продукту:</label>
    <input type="text" id="productName" name="productName" value="${param.productName}">
    <button type="submit">Пошук</button>
</form>

<c:if test="${not empty minPrice and not empty stores}">
    <h3>Мінімальна ціна: ${minPrice} грн</h3>
    <h4>Доступно у магазинах:</h4>
    <ul>
        <c:forEach var="store" items="${stores}">
            <li>${store}</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
