<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 25.07.2015
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Studienplätze"/>
</jsp:include>

<table class="table">
  <caption>Liste aller verfügbaren Studienplätze:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Start Datum</th>
    <th>End Datum</th>
    <th>Universität</th>
      <c:if test="${sessionScope.user.id > 0}">
          <th>Studienplatz sichern</th>
      </c:if>
  </tr>
  </thead>



  <c:forEach var="sp" items="${studienplatzliste}">
      <c:if test="${sp.verfuegbarkeit}">
        <tr>
          <td><a class="btn btn-default" href="/studienplatz?studienplatzId=${sp.id}" role="button">${sp.id}</a> </td>
          <td>${sp.startDatum}</td>
          <td>${sp.endDatum}</td>
          <td>${dao.findUniversityById(sp.universitaet_id).name}</td>
          <c:if test="${sessionScope.user.id > 0}">
              <td><a class="btn btn-default" href="/studienplatzsichern?studienplatzId=${sp.id}&studentenId=${sessionScope.user.id}" role="button">Studienplatz sichern</a></td>
          </c:if>
        </tr>
      </c:if>
  </c:forEach>

</table>

<jsp:include page="fragments/footer.jsp" />