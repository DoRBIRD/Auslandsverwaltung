<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 21.07.2015
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Studentenliste"/>
</jsp:include>
<ul>
  <c:forEach var="s" items="${studenten}">
    <li>${s.id}- ${s.vorname} - ${s.nachname}</li>
  </c:forEach>
</ul>
<jsp:include page="fragments/footer.jsp" />