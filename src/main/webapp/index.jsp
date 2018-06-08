<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student list</title>
</head>
<body>
<ul>
    <c:forEach items="${list}" var="student">
        <li>${student.fullName}</li>
    </c:forEach>
</ul>
</body>
</html>