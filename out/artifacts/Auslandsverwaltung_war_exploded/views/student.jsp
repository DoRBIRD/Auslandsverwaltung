<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 21.07.2015
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Student</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<jsp:include page="header.jsp"><jsp:param name="pageName" value="Student"/></jsp:include>
<%@ include file="menu.jsp" %>


  <c:if test="${student != null}">
    ${student.id}- ${student.vorname} - ${student.nachname}
  </c:if>
  belegt folgende Studiengänge<br>
  <c:forEach var="sg" items="${studiengaenge}">
    ${sg.id}- ${sg.bezeichnung} - ${sg.fakultaet}
  </c:forEach>
  <br>
  ${uni.name} - ${uni.standort}



</body>
</html>
