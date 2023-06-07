<%--
  Created by IntelliJ IDEA.
  User: Windows 10
  Date: 06/06/2023
  Time: 9:00 SA
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
<form action="/product?action=create" method="post">
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="price">Price</label>
    <input type="text" name="price" id="price">
    <label for="quantity">Quantity</label>
    <input type="text" name="quantity" id="quantity">
    <label for="category">Category</label>
<%--    <input type="text" name="category" id="category">--%>
    <select name="category" id="category">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Create</button>
</form>

</body>
</html>
