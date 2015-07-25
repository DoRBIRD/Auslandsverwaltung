<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 21.07.2015
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String pageName = "Home";%>
<html>
<head>
  <title>Student</title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div id="contentbereich">

  <form action="student">>
    <select name="studentId">
      <c:forEach var="s" items="${studenten}">
        <option value="${s.id}">${s.id}- ${s.vorname} - ${s.nachname}></option>
      </c:forEach>
      <!--<option value="1">1 Jonas Oja (Test student)</option>
      <option value="2">2 niklas Hinte(Test student)</option>-->
    </select>
    <input type="submit" value="Sign in">
  </form>
</div>

<div id="headerbereich"><h1 id="menu">Auslandsverwaltung - <%=pageName%></h1></div>
<div id="footerbereich"></div>
</body>
</html>
