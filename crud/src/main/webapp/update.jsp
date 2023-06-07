<%--
  Created by IntelliJ IDEA.
  User: Windows 10
  Date: 06/06/2023
  Time: 9:31 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product">Back</a>
<form action="/product?action=update&id=${product.id}" method="post">
    <label for="name"></label>
    <input type="text" name="name" id="name" value="${product.name}">
    <label for="price"></label>
    <input type="text" name="price" id="price" value="${product.price}">
    <label for="quantity"></label>
    <input type="text" name="quantity" id="quantity"value="${product.quantity}">
    <label for="category"></label>
<%--    <input type="text" name="category" id="category" value="${product.category}">--%>
    <select name="category" id="category">
        <c:forEach items="${categories}" var="item">
            <option value="${item.id}">${item.name}</option>
        </c:forEach>
    </select>
    <button type="submit">edit</button>
</form>

</body>
</html>
