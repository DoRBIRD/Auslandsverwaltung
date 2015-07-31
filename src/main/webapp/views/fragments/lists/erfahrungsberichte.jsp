<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 25.07.2015
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table">
  <caption>Liste aller Erfahrungsberichte:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>betreff</th>

    <th>Link</th>
    <th>student</th>
  </tr>
  </thead>
  <c:forEach var="eb" items="${erfahrungsberichtliste}">
    <tr><td><a class="btn btn-default" href="/erfahrungsbericht?erfahrungsberichtId=${eb.id}" role="button">${eb.id}</a> </td>
      <td>${eb.betreff}</td>

      <td>${eb.link}</td>
      <td><a class="btn btn-default" href="/student?studentenId=${eb.student_id}" role="button">${eb.student_id}</a></td>
    </tr>
  </c:forEach>
</table>