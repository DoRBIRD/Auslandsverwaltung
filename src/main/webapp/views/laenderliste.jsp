<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
    <jsp:param name="pageName" value="L&auml;nderliste"/>
</jsp:include>

<%--<caption>Liste aller L&auml;nder:</caption>--%>
<%--<table class="table">--%>
    <%--<thead>--%>
    <%--<tr>--%>
        <%--<th>name</th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<c:forEach var="l" items="${laenderListe}">--%>
        <%--<tr>--%>
            <%--<td><a class="btn btn-default btn-sm" href="/land?landId=${l.name}" role="button">${l.name}</a></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>
<caption>Liste aller L&auml;nder:</caption>
<hr />
<c:forEach var="l" items="${laenderListe}">
    <a class="btn btn-default" href="/land?landId=${l.name}" role="button">${l.name}</a>
</c:forEach>
<jsp:include page="fragments/footer.jsp"/>