<ul id="navi" class="nav nav-stacked">
    <li><a href="/">Home</a></li>


        <li>
            <hr/>
        </li>

        <li><a href="/hochschulliste">Liste aller Hochschulen</a></li>
        <li><a href="/studentenliste">Liste aller Studenten</a></li>
        <li><a href="/laenderliste">Liste aller L&auml;nder</a></li>
        <li><a href="/studienplatzliste">Liste aller Studienpl&auml;tze</a></li>
        <li><a href="/erfahrungsberichtliste">Liste aller Erfahrungsberichte</a></li>

        <li>
            <hr/>

    <c:if test="${sessionScope.user != null}">
        </li>
        <li>Mein Schreibtisch</li>
        <li><a href="/student">Mein Profil</a></li>
        <li><a href="/hochschule">Meine Hochschule</a></li>
        <!--<li><a href="/land">Land</a></li>-->
        <li><a href="/studienplatz/studId=${sessionScope.user.id}">Mein Studienplatz</a></li>
        <li><a href="/erfahrungsbericht">Mein Erfahrungsbericht</a></li>

        <li>debug</li>
        <li><a href="/allData">allData</a></li>

        <li>
            <hr/>
        </li>

        <li><a href="/user/logout">Logout</a></li>
    </c:if>

</ul>