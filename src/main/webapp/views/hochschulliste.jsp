<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 21.07.2015
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>hoschschulliste</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<jsp:include page="header.jsp"><jsp:param name="pageName" value="Student"/></jsp:include>
<%@ include file="menu.jsp" %>

<form action="hochschule.jsp">>
  <select name="universities">
    <c:forEach var="u" items="${universities}">
      <option value"${u.id}">${u.id}- ${u.name} - ${u.standort}></option>
    </c:forEach>
  </select>
</form>



</body>
</html>
