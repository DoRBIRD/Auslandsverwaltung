<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Student"/>
</jsp:include>
<c:if test="${student != null}">
  ${student.id}- ${student.vorname} - ${student.nachname}
</c:if>
belegt folgende Studiengänge<br>
<c:forEach var="sg" items="${studiengaenge}">
  ${sg.id}- ${sg.bezeichnung} - ${sg.fakultaet}
</c:forEach>
<br>
${uni.name} - ${uni.standort}
<jsp:include page="fragments/footer.jsp" />