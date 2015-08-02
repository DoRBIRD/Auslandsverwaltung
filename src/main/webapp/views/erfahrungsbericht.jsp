
<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 25.07.2015
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Erfahrungsbericht"/>
</jsp:include>

    <h1>${erfahrungsbericht.betreff}</h1><br>
    <a class="btn btn-default" href="${erfahrungsbericht.link}" role="button">Online lesen</a> <a class="btn btn-default" href="hochschule?hochschulId=${uni.id}" role="button">${uni.name} in ${uni.standort}</a><br><br>
    <p>${erfahrungsbericht.inhalt}</p>
    <a class="btn btn-default" href="/student?studentId=${student.id}" role="button">Autor: ${student.vorname} ${student.nachname} Email: ${student.email}</a>


<jsp:include page="fragments/footer.jsp" />