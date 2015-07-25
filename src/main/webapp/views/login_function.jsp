<%@ page import="auslandsverwaltung.StudentEntity" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% StudentEntity student = null; %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Login Function"/>
</jsp:include>
    ${testVar}
    ${testVar2}

        <c:if test="${student != null}">
        <p>erfolg<p>
        </c:if>
<jsp:include page="fragments/footer.jsp" />