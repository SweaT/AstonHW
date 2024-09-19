<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<html>
<head>
  <title>Students</title>
</head>
<body>
<h1>Students</h1>
<ul>
  <c:forEach var="student" items="${students}">
    <li>
      ${student.id} ${student.name} ${student.classID}
    </li>
  </c:forEach>
</ul>
</body>
</html>