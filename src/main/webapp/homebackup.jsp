<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Auslandsverwaltung</title>
</head>
<body>

  <h2>moin!</h2>
  <h1>Liste aller Studenten</h1>

  <ul>
    <c:forEach var="s" items="${studenten}">
      <li>${s.id}- ${s.vorname} - ${s.nachname}</li>
    </c:forEach>
  </ul>

  <h4>${string}</h4>
  <h2>
    Click To | <a href="<c:url value="j_spring_security_logout" />">Logout</a>
  </h2>

</body>
</html>