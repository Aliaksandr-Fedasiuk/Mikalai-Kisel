<%--
  Created by IntelliJ IDEA.
  User: mikalai
  Date: 11.02.15
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Save person</title>
</head>
<body>
<form action="SaveServlet.do">
    <label for="name">Name:</label>
    <input name="name" type="text"/>
    <label for="password">Password</label>
    <input name="password" type="password">
    <label for="place">Place:</label>
    <input name="place" type="text">
    <input type="submit" value="Save"/>
</form>
</body>
</html>

