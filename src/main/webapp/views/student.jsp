<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Student"/>
</jsp:include>
<table class="table">
    <caption>Studenten Infos:</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>Vorname</th>
        <th>Nachname</th>
        <th>MatrikelNummer</th>
        <th>Email</th>
    </tr>
    </thead>
        <tr>
            <td><a class="btn btn-default" href="/student?studentId=${student.id}" role="button">${student.id}</a> </td>
            <td>${student.vorname}</td>
            <td>${student.nachname}</td>
            <td>${student.matrikelNummer}</td>
            <td>${student.email}</td>
        </tr>
</table>

<table class="table">
    <caption>Bietet folgende Studiengänge:</caption>
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
        </tr>
    </c:forEach>
</table>

<table class="table">
    <caption>Liste aller Hochschulen:</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Standort</th>
    </tr>
    </thead>
    <c:forEach var="u" items="${unis}">
        <tr>
            <td><a class="btn btn-default" href="/hochschule?hochschulId=${u.id}" role="button">${u.id}</a> </td>
            <td>${u.name}</td>
            <td><a class="btn btn-default" href="/land?landId=${u.standort}" role="button">${u.standort}</a></td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="fragments/footer.jsp"/>