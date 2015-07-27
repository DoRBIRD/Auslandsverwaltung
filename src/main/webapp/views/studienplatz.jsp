<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Studienplatz"/>
</jsp:include>

<table class="table">
  <caption>Studienplatz:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Start Datum</th>
    <th>End Datum</th>
    <th>Verfuegbarkeit</th>
    <th>Student</th>
  </tr>
  </thead>
  <tr><td><a class="btn btn-default" href="studienplatz?studienplatzId=${studienplatz.id}" role="button">${studienplatz.id}</a> </td>
    <td>${studienplatz.startDatum}</td>
    <td>${studienplatz.endDatum}</td>
    <td>${studienplatz.verfuegbarkeit}</td>
    <td><a class="btn btn-default" href="student?studentenId=${studienplatz.student_id}" role="button">${studienplatz.student_id}</a></td>
  </tr>
</table>

<jsp:include page="fragments/footer.jsp" />