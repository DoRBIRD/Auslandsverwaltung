<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 21.07.2015
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Hochschule"/>
</jsp:include>

  ${university.id} - ${university.name} - ${university.standort} <br>
  Bietet folgende Studiengänge: <br>
  <c:forEach var="sg" items="${studiengangListe}">
    ${sg.id}- ${sg.fakultaet} - ${sg.bezeichnung}
  </c:forEach>

<jsp:include page="fragments/footer.jsp" />