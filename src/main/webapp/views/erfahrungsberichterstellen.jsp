<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Ehrfahrungsbericht schreiben"/>
</jsp:include>


<h1>Schreibe deinen Ehrfarungsbericht</h1>

<form action="submitbericht" method="get">
  <div class="form-group">
    <label for="betreff">Betreff des Berichtes</label>
    <input name="betreff" type="betreff" class="form-control" id="betreff" placeholder="Betreff">
  </div>
  <div class="form-group">
    <label for="student">Eigentümer</label>
    <select name="student" id="student" class="form-control">
      <option value="${sessionScope.user.id}">ICH ${sessionScope.user.getVorname()}</option>
      <c:forEach var="s" items="${studentenlist}">
        <option value="${s.id}s.id">${s.vorname} ${s.nachname} - ${s.matrikelNummer}</option>
      </c:forEach>
    </select>
  </div>
  <div class="form-group">
    <label for="link">externer link</label>
    <input name="link" type="link" class="form-control" id="link" placeholder="http//:www.example.com">
  </div>
  <div class="form-group">
    <label for="inhalt">Inhalt</label>
    <textarea name="inhalt" class="form-control" id="inhalt" rows="10"></textarea>
  </div>

  <button type="submit" class="btn btn-default">Submit</button>
</form>


<jsp:include page="fragments/footer.jsp"/>
