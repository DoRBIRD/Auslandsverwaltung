<%--
  Created by IntelliJ IDEA.
  User: Niklas
  Date: 19.07.2015
  Time: 09:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Auslandsverwaltung</title>
  </head>
  <body>
    <h1>Liste aller Studenten</h1>
    <ul>
      <c:forEach var="s" items="${studenten}">
        <li>${s.id}- ${s.vorname} - ${s.nachname}</li>
      </c:forEach>
    </ul>
  </body>
</html>