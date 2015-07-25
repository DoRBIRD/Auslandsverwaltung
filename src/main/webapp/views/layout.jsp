<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String pageName = "Home";%>
<html>
<head>
  <title><%=pageName%></title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div id="contentbereich">

</div>
<div id="menubreich"><%@ include file="fragments/menu.jsp" %></div>
<div id="headerbereich"><h1 id="menu">Auslandsverwaltung - <%=pageName%></h1></div>
<div id="footerbereich"></div>
</body>
</html>