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
      <form action="login_function.jsp">
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