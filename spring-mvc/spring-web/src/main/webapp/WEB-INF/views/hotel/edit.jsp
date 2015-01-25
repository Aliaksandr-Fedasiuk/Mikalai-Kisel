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
<div id="createHotel">
    <form:form modelAttribute="hotel" id="createHotelForm" method="post">
        <c:if test="${empty hotel.hotelName}">
            <h3>Create hotel</h3>
        </c:if>
        <c:if test="${not empty hotel.hotelName }">
            <h3>Update hotel</h3>
        </c:if>
        <p/>
        <label>hotel name:*</label>
        <form:input path="hotelName" value="${hotel.hotelName}"/>

        <p/>
        <label>Country name:*</label>
        <form:input path="countryName" value="${hotel.countryName}"/>

        <p/>
        <button type="submit">Save</button>
    </form:form>
</div>
</body>
</html>