<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Laenderliste"/>
</jsp:include>


<table class="table">
  <caption>Lsite aller Länder:</caption>
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
<jsp:include page="fragments/footer.jsp" />