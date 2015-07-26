<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Error ${errorCode}"/>
</jsp:include>

<h2>Error ${errorCode}</h2>
<p>Sorry, ein Fehler ist aufgetreten!</p>
<p>${message}</p>

<jsp:include page="fragments/footer.jsp" />