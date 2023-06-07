<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>${action}</h1>
<a href="/product?action=create">Create Customer</a>
<form action="/product" method="get">
    <input type="text" name="search" id="search" placeholder="Search...">
    <button type="submit">Search</button>
</form>
<c:if test="${requestScope['product'].size() != 0}">
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Price</td>
            <td>Quantity</td>
            <td>Category</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>${product.category}</td>
                <td><a href="/product?action=update&id=${product.id}">Edit</a> </td>
                <td><a href="/product?action=delete&id=${product.id}" onclick="return confirm('Do you want to remove ${customer.name}?')">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>