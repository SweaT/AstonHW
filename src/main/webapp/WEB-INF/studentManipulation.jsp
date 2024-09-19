<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<html>
<head>
    <title>AddStudent</title>
</head>
<body>
<h1>Add a student</h1>
<form method="post" action="studentAdd">
    <label>
        <input type="text" name="name" placeholder="student Name"/>
        <input type="number" name="classID" placeholder="class ID"/>
    </label>
    <button type="submit">Add student</button>
</form>

<h1>Delete student</h1>
<form method="post" action="studentDelete">
    <label>
        <input type="number" name="studentID" placeholder="student ID"/>
    </label>
    <button type="submit">Delete student</button>
</form>

<h1>Update student</h1>

<form method="post" action="studentUpdate">
    <label>
        <input type="number" name="studentID" placeholder="student's ID"/>
    </label>
    If you don't want to update one of the student's data, please keep empty not required strings below.
    <label>
        <input type="text" name="name" placeholder="student Name"/>
        <input type="number" name="classID" placeholder="class ID"/>
    </label>
    <button type="submit">Update student</button>
</form>

</body>
</html>
