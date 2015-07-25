<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Willkommen"/>
</jsp:include>
<%@ include file="LoginBereich.jsp" %>
<p>
    Herzlich Willkommen<br />
    bitte wählen Sie aus der Navigation eine Aktion
</p>
<jsp:include page="fragments/footer.jsp" />