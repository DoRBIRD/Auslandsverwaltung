<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 25.07.2015
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
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