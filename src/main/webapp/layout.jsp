<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 23.07.2015
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Layout test</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

  <div id="contentbereich"><%@ include file="LoginBereich.jsp" %></div>
  <div id="menubreich"><%@ include file="menu.jsp" %></div>
  <div id="headerbereich"><jsp:include page="header.jsp"><jsp:param name="pageName" value="Home"/></jsp:include></div>
  <div id="footerbereich"></div>
</body>
</html>
