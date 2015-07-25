<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 25.07.2015
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table">
  <caption>Bietet folgende Studienplätze:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Start Datum</th>
    <th>End Datum</th>
    <th>Verfuegbarkeit</th>
    <th>Student</th>
  </tr>
  </thead>
  <c:forEach var="sp" items="${studienplatzListe}">
    <tr><td><a class="btn btn-default" href="/studienpaltz?studienplatzId=${sp.id}" role="button">${sp.id}</a> </td>
      <td>${sp.startDatum}</td>
      <td>${sp.endDatum}</td>
      <td>${sp.verfuegbarkeit}</td>
      <td><a class="btn btn-default" href="/student?studentenId=${ao.findStudentById(sp.id).id}" role="button">${dao.findStudentById(sp.id).vorname}</td>
    </tr>
  </c:forEach>
</table>