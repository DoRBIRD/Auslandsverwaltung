<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 21.07.2015
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>My Web App</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
  </head>

  <body>
  <ul>
    <c:forEach var="s" items="${studenten}">
      <li>${s.id}- ${s.vorname} - ${s.nachname}</li>
    </c:forEach>
  </ul>
    Hello World
  </body>
</html>
