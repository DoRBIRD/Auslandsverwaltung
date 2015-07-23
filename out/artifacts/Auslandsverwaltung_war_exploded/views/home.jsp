<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Auslandsverwaltung</title>
    <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />-->
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"><jsp:param name="pageName" value="Home"/></jsp:include>
<%@ include file="menu.jsp" %>
<%@ include file="LoginBereich.jsp" %>
<h2>moin!</h2>
<h1>Liste aller Studenten</h1>


<ul>
    <c:forEach var="s" items="${studenten}">
        <li>${s.id}- ${s.vorname} - ${s.nachname}</li>
    </c:forEach>
</ul>

<h4>${string}</h4>
<h2>
    <%@ include file="hochschulliste.jsp" %>
    <%@ include file="chooseStudent.jsp" %>
</h2>

</body>
</html>