<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Studiengangliste"/>
</jsp:include>

<table class="table">
  <caption>Liste aller Studiengänge:</caption>
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
      <td><a class="btn btn-default" href="/hochschule?hochschulId=${sg.universitaet_id}" role="button">${sg.universitaet_id}</a> </td>
    </tr>
  </c:forEach>
</table>

<jsp:include page="fragments/footer.jsp"/>
