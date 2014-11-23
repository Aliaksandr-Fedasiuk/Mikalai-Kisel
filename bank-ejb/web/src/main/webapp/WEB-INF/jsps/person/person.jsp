<%--
  Created by IntelliJ IDEA.
  User: mikalai
  Date: 23.11.14
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="SavePersonServlet.do">
    <label for="name">Name:</label>
    <input name="name" type="text"/>
    <label for="surname">Surname</label>
    <input name="surname" type="text">
    <input type="submit" value="Save"/>
</form>
