<%--
  Created by IntelliJ IDEA.
  User: mikalai
  Date: 23.11.14
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Persons</title>
</head>
<body>
<c:forEach items="${persons}" var="person">
  <c:out value="${person.name}"/>
  <c:out value="${person.surname}"/><br/>
</c:forEach>
</body>
</html>