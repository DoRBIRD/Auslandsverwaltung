<%--
  Created by IntelliJ IDEA.
  User: Jonas
  Date: 20.07.2015
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<table id = "loginSignin" width="30%" align="center">
  <tr>

    <td id = "login" align="left" margin="0px">
      <form action="login_function" method="post">
        Username:<br>
        <input type="text" name="username">
        <br>
        Password:<br>
        <input type="password" name="password">
        <br><br>
        <input type="submit" value="Login">
      </form>
    </td>
    <td id="signin" align="left" margin="0px">
      <form action="signin_function" method="post">
        First name:<br>
        <input type="text" name="firstname" >
        <br>
        Last name:<br>
        <input type="text" name="lastname" >
        <br>Password<br>
        <input type="password" name="Passwort" >
        <br>repeat Password<br>
        <input type="password" name="rPasswort">
        <input type="submit" value="Sign in">
      </form>
    </td>
  </tr>
</table>