<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Erfahrungsberichte"/>
</jsp:include>

<table class="table">
  <caption>Liste aller Erfahrungsberichte:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Betreff</th>
    <th>Link</th>
    <th>Student</th>
  </tr>
  </thead>
  <c:forEach var="eb" items="${erfahrungsberichtliste}">
    <tr><td><a class="btn btn-default" href="/erfahrungsbericht?erfahrungsberichtId=${eb.id}" role="button">${eb.id}</a> </td>
      <td>${eb.betreff}</td>
      <td><a class="btn btn-default" href="${eb.link}" role="button">externer link</a></td>
      <td><a class="btn btn-default" href="/student?studentenId=${eb.studentId}" role="button">${eb.studentId}</a></td>
    </tr>
  </c:forEach>
</table>

<jsp:include page="fragments/footer.jsp"/>
