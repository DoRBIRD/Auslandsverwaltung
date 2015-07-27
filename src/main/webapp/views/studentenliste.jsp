<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Studentenliste"/>
</jsp:include>

<table class="table">
    <caption>Liste aller Studenten:</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>Vorname</th>
        <th>Nachname</th>
        <th>MatrikelNummer</th>
        <th>Email</th>
    </tr>
    </thead>
    <c:forEach var="s" items="${studenten}">
        <tr>
            <td><a class="btn btn-default" href="/student?studentId=${s.id}" role="button">${s.id}</a> </td>
            <td>${s.vorname}</td>
            <td>${s.nachname}</td>
            <td>${s.matrikelNummer}</td>
            <td>${s.email}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="fragments/footer.jsp" />