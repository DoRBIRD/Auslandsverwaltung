<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Hochschulliste"/>
</jsp:include>
<form action="hochschule">
  <select name="universities">
    <c:forEach var="u" items="${universities}">
      <option value="${u.id}">${u.id}- ${u.name} - ${u.standort}</option>
    </c:forEach>
    <input type="submit" value="Choose">
  </select>
</form>
<jsp:include page="fragments/footer.jsp" />