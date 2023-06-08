<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${action}</h1>
<a href="/students?action=create">Create Customer</a>
<c:if test="${requestScope['students'].size() != 0}">
    <form action="/students" method="get">
        <input type="text" name="search" placeholder="Search ...">
        <button type="submit">Submit</button>
    </form>

    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Date of Birth</td>
            <td>Gender</td>
            <td>Class</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.dob}</td>
                <td>${student.gender.gender}</td>
                <td>${student.studentClass.name}</td>
                <td><a href="/students?action=update&id=${student.id}">Edit</a> </td>
                <td><a href="/students?action=delete&id=${student.id}" onclick="return confirm('Do you want to remove ${student.name}?')">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>