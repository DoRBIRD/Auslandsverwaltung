<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 25.07.2015
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<table class="table">
  <caption>Länder</caption>
  <thead>
  <tr>
    <th>name</th>
  </tr>
  </thead>
  <c:forEach var="l" items="${param.liste}">
    <tr>
      <td><a class="btn btn-default" href="/land?landId=${l.name}" role="button">${l.name}</a> </td>
    </tr>
  </c:forEach>
</table>