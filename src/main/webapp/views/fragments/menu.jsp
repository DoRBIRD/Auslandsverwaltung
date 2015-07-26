<ul id="navi">
    <li><a href="/">Home</a></li>

    <c:if test="${sessionScope.UserName != null}">
        <li>
            <hr/>
        </li>

        <li><a href="/hochschulliste">Liste aller Hochschulen</a></li>
        <li><a href="/studentenliste">Liste aller Studenten</a></li>
        <li><a href="/laenderliste">Liste aller L&auml;nder</a></li>

        <li>
            <hr/>
        </li>

        <li><a href="/student">Student</a></li>
        <li><a href="/hochschule">Hochschule</a></li>
        <li><a href="/land">Land</a></li>
        <li><a href="/allData">allData</a></li>

        <li>
            <hr/>
        </li>

        <li><a href="/user/logout">Logout</a></li>
    </c:if>

</ul>