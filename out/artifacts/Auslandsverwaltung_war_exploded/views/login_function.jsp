<%@ page import="auslandsverwaltung.StudentEntity" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String pageName = "Login Function";
    StudentEntity student = null;
%>
<html>
<head>
  <title><%=pageName%></title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div id="contentbereich">
    ${testVar}
    ${testVar2}

        <c:if test="${student != null}">
        <p>erfolg<p>
        </c:if>


</div>
<div id="menubreich"><%@ include file="menu.jsp" %></div>
<div id="headerbereich"><h1 id="menu">Auslandsverwaltung - <%=pageName%></h1></div>
<div id="footerbereich"></div>
</body>
</html>




