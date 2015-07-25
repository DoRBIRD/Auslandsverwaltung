<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="AllData"/>
</jsp:include>


<table class="table">
  <caption>Liste aller Hochschulen:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Name</th>
    <th>Standort</th>
  </tr>
  </thead>
  <c:forEach var="u" items="${universities}">
    <tr>
      <td><a class="btn btn-default" href="/hochschule?hochschulId=${u.id}" role="button">${u.id}</a> </td>
      <td>${u.name}</td>
      <td><a class="btn btn-default" href="/land?landId=${u.standort}" role="button">${u.standort}</a></td>
    </tr>
  </c:forEach>
</table>

<table class="table">
  <caption>Länder</caption>
  <thead>
  <tr>
    <th>name</th>
  </tr>
  </thead>
  <c:forEach var="l" items="${laenderListe}">
    <tr>
      <td><a class="btn btn-default" href="/land?landId=${l.name}" role="button">${l.name}</a> </td>
    </tr>
  </c:forEach>
</table>
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
  <c:forEach var="s" items="${studentenliste}">
    <tr>
      <td><a class="btn btn-default" href="/student?studentId=${s.id}" role="button">${s.id}</a> </td>
      <td>${s.vorname}</td>
      <td>${s.nachname}</td>
      <td>${s.matrikelNummer}</td>
      <td>${s.email}</td>
    </tr>
  </c:forEach>
</table>
<table class="table">
  <caption>Bietet folgende Studiengänge:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Fakultaet</th>
    <th>Bezeichnung</th>
  </tr>
  </thead>
  <c:forEach var="sg" items="${studiengangliste}">
    <tr>
      <td><a class="btn btn-default" href="/studiengang?studiengang=${sg.id}" role="button">${sg.id}</a> </td>
      <td>${sg.fakultaet}</td>
      <td>${sg.bezeichnung}</td>
    </tr>
  </c:forEach>
</table>
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
  <c:forEach var="sp" items="${studienplatzliste}">
    <tr><td><a class="btn btn-default" href="/studienpaltz?studienplatzId=${sp.id}" role="button">${sp.id}</a> </td>
      <td>${sp.startDatum}</td>
      <td>${sp.endDatum}</td>
      <td>${sp.verfuegbarkeit}</td>
      <td><a class="btn btn-default" href="/student?studentenId=${ao.findStudentById(sp.id).id}" role="button">${dao.findStudentById(sp.id).vorname}</td>
    </tr>
  </c:forEach>
</table>

<jsp:include page="fragments/footer.jsp" />