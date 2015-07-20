<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Auslandsverwaltung</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<table id = "loginSignin" width="30%" align="center">
    <tr>

        <td id = "login" align="left" margin="0px">
            <form action="login_function">
                First name:<br>
                <input type="text" name="username">
                <br>
                Last name:<br>
                <input type="password" name="password">
                <br><br>
                <input type="submit" value="Login">
            </form>
        </td>
        <td id="signin" align="left" margin="0px">
            <form action="signin_function">
                First name:<br>
                <input type="text" name="firstname" value="Mickey">
                <br>
                Last name:<br>
                <input type="text" name="lastname" value="Mouse">
                <br><br>
                <input type="text" name="lastname" value="Mouse">
                <br><br>
                <input type="submit" value="Sign in">
            </form>
        </td>
    </tr>
</table>
<h2>moin!</h2>
<h1>Liste aller Studenten</h1>

<ul>
    <c:forEach var="s" items="${studenten}">
        <li>${s.id}- ${s.vorname} - ${s.nachname}</li>
    </c:forEach>
</ul>

<h4>${string}</h4>
<h2>
    Click To | <a href="<c:url value="j_spring_security_logout" />">Logout</a>
</h2>

</body>
</html>