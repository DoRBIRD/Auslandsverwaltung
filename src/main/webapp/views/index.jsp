<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Willkommen"/>
</jsp:include>

<c:if test="${flashMessage != null}">
    <div class="alert alert-${flashMessageType}" role="alert">
            ${flashMessage}
    </div>
</c:if>

<c:if test="${sessionScope.UserName == null}">
    <%@ include file="login.jsp" %>
</c:if>

<c:if test="${sessionScope.UserName != null}">
    <p>
        <br>Hallo, ${sessionScope.UserName}<br/>
        bitte wählen Sie aus der Navigation eine Aktion
    </p>
</c:if>

<jsp:include page="fragments/footer.jsp"/>