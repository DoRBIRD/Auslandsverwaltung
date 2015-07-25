<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Student"/>
</jsp:include>
<form action="student">
    <select name="studentId">
        <c:forEach var="s" items="${studenten}">
            <option value="${s.id}">${s.id}- ${s.vorname} - ${s.nachname}></option>
        </c:forEach>
    </select>
    <input type="submit" value="Sign in">
</form>
<jsp:include page="fragments/footer.jsp"/>