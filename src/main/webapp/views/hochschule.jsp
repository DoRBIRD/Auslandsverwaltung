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
<table>
  <tr>
    <td>
      "from hochschulliste where id = <%= request.getParameter("universities")%>"
    </td>
  </tr>
</table>
<jsp:include page="fragments/footer.jsp" />