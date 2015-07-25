<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 25.07.2015
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table">
  <caption>Bietet folgende Studiengänge:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Fakultaet</th>
    <th>Bezeichnung</th>
  </tr>
  </thead>
  <c:forEach var="sg" items="${studiengangListe}">
    <tr>
      <td><a class="btn btn-default" href="/studiengang?studiengang=${sg.id}" role="button">${sg.id}</a> </td>
      <td>${sg.fakultaet}</td>
      <td>${sg.bezeichnung}</td>
    </tr>
  </c:forEach>
</table>