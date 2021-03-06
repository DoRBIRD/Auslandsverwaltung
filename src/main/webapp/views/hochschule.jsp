<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="Hochschule"/>
</jsp:include>
<table class="table">
    <caption>Ausgewählte Hochschule:</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>name</th>
        <th>standort</th>
    </tr>
    </thead>
    <tr>
        <td>${university.id}</td>
        <td>${university.name}</td>
        <td>${university.land.name}</td>
        <td><a class="btn btn-default" href="/land?landId=${university.standort}"
               role="button">${university.standort}</a></td>
    </tr>
</table>

<br>
<table class="table">
    <caption>Bietet folgende Studiengänge:</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>Fakultaet</th>
        <th>Bezeichnung</th>
    </tr>
    </thead>
    <c:forEach var="sg" items="${studiengangListe}">
        <tr>
            <td><a class="btn btn-default" href="/studiengang?studiengang=${sg.id}" role="button">${sg.id}</a></td>
            <td>${sg.fakultaet}</td>
            <td>${sg.bezeichnung}</td>
            <td>${sg.bezeichnung}</td>
        </tr>
    </c:forEach>
</table>

<br>
<table class="table">
    <caption>Liste aller verfügbaren Studienplätze:</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>Start Datum</th>
        <th>End Datum</th>
        <th>Universität</th>
        <c:if test="${sessionScope.user.id > 0}">
            <th>Studienplatz sichern</th>
        </c:if>
    </tr>
    </thead>



    <c:forEach var="sp" items="${studienplatzListe}">
        <c:if test="${sp.verfuegbarkeit}">
            <tr>
                <td><a class="btn btn-default" href="studienplatz?studienplatzId=${sp.id}" role="button">${sp.id}</a> </td>
                <td>${sp.startDatum}</td>
                <td>${sp.endDatum}</td>
                <td><a class="btn btn-default" href="hochschule?hochschulId=${sp.universitaet_id}&studentId=${sessionScope.user.id}" role="button">${dao.findUniversityById(sp.universitaet_id).name}</a></td>
                <c:if test="${sessionScope.user.id > 0}">
                    <td><a class="btn btn-default" href="studienplatzsichern?studienplatzId=${sp.id}&studentId=${sessionScope.user.id}" role="button">Studienplatz sichern</a></td>
                </c:if>
            </tr>
        </c:if>
    </c:forEach>

</table>
<br>
<table class="table">
    <caption>Folgende Studenten studieren hier:</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>Vorname</th>
        <th>Nachname</th>
        <th>MatrikelNummer</th>
    </tr>
    </thead>
    <c:forEach var="s" items="${studentenListe}">
        <tr>
            <td><a class="btn btn-default" href="/student?studentId=${s.id}" role="button">${s.id}</a></td>
            <td>${s.vorname}</td>
            <td>${s.nachname}</td>
            <td>${s.matrikelNummer}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="fragments/footer.jsp"/>