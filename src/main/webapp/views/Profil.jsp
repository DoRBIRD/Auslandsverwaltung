<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Mein Profil"/>
</jsp:include>

<c:if test="${student.id == sessionScope.user.id}">
<table class="table">
    <caption>Meine Daten</caption>
    <thead>
    <tr>
        <th>Vorname</th>
        <th>Nachname</th>
        <th>MatrikelNummer</th>
        <th>Email</th>
    </tr>
    </thead>
        <tr>
            <td>${student.vorname}</td>
            <td>${student.nachname}</td>
            <td>${student.matrikelNummer}</td>
            <td>${student.email}</td>
        </tr>
</table>

<c:if test="${studiengaenge != null}">

    <table class="table">
        <caption>Meine Studiengänge:</caption>
        <thead>
        <tr>
            <th>#</th>
            <th>Fakultaet</th>
            <th>Bezeichnung</th>
        </tr>
        </thead>
        <c:forEach var="sg" items="${studiengaenge}">
            <tr>
                <td><a class="btn btn-default" href="/studiengang?studiengang=${sg.id}" role="button">${sg.id}</a> </td>
                <td>${sg.fakultaet}</td>
                <td>${sg.bezeichnung}</td>
                <td><a class="btn btn-default" href="/hochschule?hochschulId=${sg.universitaet_id}" role="button">${sg.universitaet_id}</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>

</c:if>
<jsp:include page="fragments/footer.jsp"/>