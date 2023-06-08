<%--
  Created by IntelliJ IDEA.
  User: Windows 10
  Date: 08/06/2023
  Time: 11:04 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<c:if test="${requestScope['message'] != null}">
  <span>${message}</span>
</c:if>
<a href="/students">Back</a><br>
<form action="/students?action=update&id=${student.id}" method="post">
<%--  <input type="hidden" name="id" value="${student.id}">--%>
  <label for="name">Name</label>
  <input type="text" name="name" id="name" value="${student.name}" />
  <label for="dob">Date of Birth</label>
  <input type="date" name="dob" id="dob" value="${student.dob}" />
  <select name="gender" id="gender">
    <option value="">--None--</option>
    <c:forEach items="${genders}" var="gender">
      <c:if test="${student.gender.id == gender.id}">
        <option selected value="${gender.id}">${gender.gender}</option>
      </c:if>
      <c:if test="${student.gender.id != gender.id}">
        <option value="${gender.id}">${gender.gender}</option>
      </c:if>
    </c:forEach>
  </select>

  <select name="studentClass" id="studentClass">
    <option value="">--None--</option>
    <c:forEach items="${studentClasses}" var="studentClass">
      <c:if test="${student.studentClass.id == studentClass.id}">
        <option selected value="${studentClass.id}">${studentClass.name}</option>
      </c:if>
      <c:if test="${student.studentClass.id != studentClass.id}">
        <option value="${studentClass.id}">${studentClass.name}</option>
      </c:if>
    </c:forEach>
  </select>
  <button type="submit">Edit</button>
</form>
</body>
</html>

</body>
</html>
