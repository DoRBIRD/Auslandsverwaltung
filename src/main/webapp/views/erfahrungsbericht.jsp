
<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 25.07.2015
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Erfahrungsbericht"/>
</jsp:include>

<table class="table">
    <caption>Erfahrungsbericht:</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>Betreff</th>
        <th>Inhalt</th>
        <th>Link</th>
        <th>student</th>
    </tr>
    </thead>
    <tr><td><a class="btn btn-default" href="/erfahrungsbericht?erfahrungsberichtId=${erfahrungsbericht.id}" role="button">${erfahrungsbericht.id}</a> </td>
        <td>${erfahrungsbericht.betreff}</td>
        <td>${erfahrungsbericht.inhalt}</td>
        <td>${erfahrungsbericht.link}</td>
        <td><a class="btn btn-default" href="/student?studentId=${erfahrungsbericht.student_id}" role="button">${erfahrungsbericht.student_id}</td>
    </tr>
</table>

<jsp:include page="fragments/footer.jsp" />