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
  <jsp:param name="pageName" value="Hochschulliste"/>
</jsp:include>
<form action="hochschule.jsp">
  <select name="universities">
    <c:forEach var="u" items="${universities}">
      <option value="${u.id}">${u.id}- ${u.name} - ${u.standort}</option>
    </c:forEach>
    <input type="submit" value="Choose">
  </select>
</form>
<jsp:include page="fragments/footer.jsp" />