<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 21.07.2015
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Student</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<jsp:include page="header.jsp"><jsp:param name="pageName" value="Student"/></jsp:include>
<%@ include file="menu.jsp" %>
<table>
  <tr>
    <td>

      "from student where id = <%= request.getParameter("student")%>"

    </td>
  </tr>
</table>
</body>
</html>
