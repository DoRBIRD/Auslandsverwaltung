<%@ page import="org.springframework.web.servlet.support.SessionFlashMapManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String pageName = request.getParameter("pageName");%>
<!DOCTYPE html>
<html>
<head>
    <title><%=pageName%>
    </title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row page-header">
        <h1 class="headerTitle">
            Auslandsverwaltung
            <small>
                <%=pageName%>
            </small>
        </h1>
    </div>
    <div class="row">
        <div class="col-md-3">
            <%@ include file="menu.jsp" %>
        </div>
        <div class="col-md-9">
