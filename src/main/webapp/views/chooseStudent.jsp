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
  <title>Student</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<jsp:include page="header.jsp"><jsp:param name="pageName" value="Student"/></jsp:include>
<%@ include file="menu.jsp" %>

 <%    //List<StudentEntity> studenten = findAllStudents();  %>
  <%/*
    List<StudentEntity> studenten = null;
    StudentEntity S1 = new StudentEntity();
    S1.setIdStudent(12);
    S1.setVorname("Test");
    S1.setNachname("1234");
    studenten.add(S1);

    StudentEntity S2 = new StudentEntity();
    S1.setIdStudent(14);
    S1.setVorname("1234");
    S1.setNachname("Test");
    studenten.add(S2);
  */

  %>
<ul>
  <c:forEach var="s" items="${studenten}">
    <li>${s.id}- ${s.vorname} - ${s.nachname}</li>
  </c:forEach>
</ul>

  <form action="student.jsp">>
    <select name="student">
      <c:forEach var="s" items="${studenten}">
        <option value"${s.id}">${s.id}- ${s.vorname} - ${s.nachname}></option>
      </c:forEach>
      <!--<option value="1">1 Jonas Oja (Test student)</option>
      <option value="2">2 niklas Hinte(Test student)</option>-->
    </select>
    <input type="submit" value="Sign in">
  </form>

</body>
</html>
