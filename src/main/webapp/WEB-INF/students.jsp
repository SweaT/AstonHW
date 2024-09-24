<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<html>
<head>
  <title>Student list</title>
</head>
<body>
<h1>Student list</h1>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Имя</th>
    <th>Класс</th>
  </tr>
  <c:forEach var="student" items="${students}">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.schoolClass.name}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>