<%--
  Created by IntelliJ IDEA.
  User: Windows 10
  Date: 08/06/2023
  Time: 10:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CreateCustomer</title>
</head>
<body>
<c:if test="${requestScope['message'] != null}">
    <span>${message}</span>
</c:if>
<a href="/students">Back</a>
<form action="/students?action=create" method="post">
    <label for="name">Name</label>
    <input type="text" name="name" id="name"/>
    <label for="dob">Date of Birth</label>
    <input type="date" name="dob" id="dob" />
    <label for="gender">Gender</label>

    <select name="gender" id="gender" >
        <option value="">--None--</option>
        <c:forEach items="${genders}" var="gender">
            <option value="${gender.id}">${gender.gender}</option>
        </c:forEach>
    </select>
    <label for="class">Class</label>

    <select name="classId" id="class" >
        <option value="">--None--</option>
        <c:forEach items="${studentClasses}" var="studentClass">
            <option value="${studentClass.id}">${studentClass.name}</option>
        </c:forEach>
    </select>

    <button type="submit">Create</button>
</form>
</body>
</html>