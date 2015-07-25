<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 25.07.2015
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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