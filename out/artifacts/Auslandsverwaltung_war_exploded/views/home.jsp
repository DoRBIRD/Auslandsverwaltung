
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>home</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div id="contentbereich"><%@ include file="LoginBereich.jsp" %></div>
<div id="menubreich"><%@ include file="menu.jsp" %></div>
<div id="headerbereich"><jsp:include page="header.jsp"><jsp:param name="pageName" value="Home"/></jsp:include></div>
<div id="footerbereich"></div>

<h2>
    <jsp:include page="${request.contextPath}/hochschulliste"></jsp:include>
</h2>

</body>
</html>




