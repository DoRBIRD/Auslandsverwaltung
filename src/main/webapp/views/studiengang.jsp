<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='fragments/header.jsp'>
  <jsp:param name="pageName" value="Studiengang"/>
</jsp:include>

<table class="table">
  <caption>Studiengang:</caption>
  <thead>
  <tr>
    <th>#</th>
    <th>Fakultaet</th>
    <th>Bezeichnung</th>
  </tr>
  </thead>

    <tr>
      <td><a class="btn btn-default" href="/studiengang?studiengang=${studiengang.id}" role="button">${studiengang.id}</a> </td>
      <td>${studiengang.fakultaet}</td>
      <td>${studiengang.bezeichnung}</td>
    </tr>
</table>

<jsp:include page="fragments/footer.jsp"/>
