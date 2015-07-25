<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Land"/>
</jsp:include>


${land.name}

<table class="table">
  <caption>Liste aller Hochschulen in ${land.name}:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Name</th>
    <th>Standort</th>
  </tr>
  </thead>
  <c:forEach var="u" items="${hochschulListe}">
    <tr>
      <td><a class="btn btn-default" href="/hochschule?hochschulId=${u.id}" role="button">${u.id}</a> </td>
      <td>${u.name}</td>
      <td><a class="btn btn-default" href="/land?landId=${u.standort}" role="button">${u.standort}</a></td>
    </tr>
  </c:forEach>
</table>


<jsp:include page="fragments/footer.jsp" />