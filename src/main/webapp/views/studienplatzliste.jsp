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
  <jsp:param name="pageName" value="Studienplätze"/>
</jsp:include>

<table class="table">
  <caption>Liste aller Studienplätze:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Start Datum</th>
    <th>End Datum</th>
    <th>Verfuegbarkeit</th>
    <th>Student</th>
  </tr>
  </thead>
  <c:forEach var="sp" items="${studienplatzliste}">
    <tr><td><a class="btn btn-default" href="/studienplatz?studienplatzId=${sp.id}" role="button">${sp.id}</a> </td>
      <td>${sp.startDatum}</td>
      <td>${sp.endDatum}</td>
      <td>${sp.verfuegbarkeit}</td>
      <td><a class="btn btn-default" href="/student?studentenId=${ao.findStudentById(sp.id).id}" role="button">${dao.findStudentById(sp.id).vorname}</td>
    </tr>
  </c:forEach>
</table>

<jsp:include page="fragments/footer.jsp" />