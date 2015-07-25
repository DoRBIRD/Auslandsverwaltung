<%--
  Created by IntelliJ IDEA.
  User: steven
  Date: 25.07.15
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String pageName = request.getParameter("pageName");%>
<html>
<head>
  <title><%=pageName%></title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div id="menubreich"><%@ include file="menu.jsp" %></div>
<div id="headerbereich"><h1 id="menu">Auslandsverwaltung ~ <%=pageName%></h1></div>
<div id="footerbereich"></div>
<div id="contentbereich">