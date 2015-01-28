<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Spring MVC Task</title>
</head>
<body>
<div id="showHotel">
    <c:if test="${not empty hotels}">
        <table id="table">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>country</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hotels}" var="hotel">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/hotels/${hotel.id}"/>${hotel.id}</td>
                    <td>${hotel.hotelName}</td>
                    <td>${hotel.countryName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>