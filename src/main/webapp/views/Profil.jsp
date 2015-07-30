<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Mein Profil"/>
</jsp:include>

<c:if test="${student.id == sessionScope.user.id}">
<c:if test="${student != null}">
    ${student.id} - ${student.vorname} - ${student.nachname} - ${student.username} - ${student.email} - ${student.matrikelNummer}
</c:if>
belegt folgende Studiengänge<br>
<c:forEach var="sg" items="${studiengaenge}">
    ${sg.id}- ${sg.bezeichnung} - ${sg.fakultaet}
</c:forEach>
<br>
${uni.name} - ${uni.standort}
</c:if>
<jsp:include page="fragments/footer.jsp"/>

