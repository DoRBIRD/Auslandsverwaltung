<ul id="navi" class="nav nav-stacked">
    <li><a href="/">Home</a></li>


        <li>
            <hr/>
        </li>

        <li><a href="/hochschulliste">Liste aller Hochschulen</a></li>
        <li><a href="/studentenliste">Liste aller Studenten</a></li>
        <li><a href="/laenderliste">Liste aller L&auml;nder</a></li>
        <li><a href="/studiengangliste"> Liste aller Studieng&auml;nge</a></li>
        <li><a href="/studienplatzliste">Liste aller verfügbaren Studienpl&auml;tze</a></li>
        <li><a href="/erfahrungsberichtliste">Liste aller Erfahrungsberichte</a></li>


        <li>
            <hr/>

    <c:if test="${sessionScope.user != null}">
        </li>
        <li>Mein Schreibtisch</li>
        <li><a href="/Profil/studId=${sessionScope.user.id}">Mein Profil</a></li>
        <li><a href="/hochschule?studentId=${sessionScope.user.id}">Meine Hochschule</a></li>
        <!--<li><a href="/land">Land</a></li>-->
        <li><a href="/studienplatzliste/studentId=${sessionScope.user.id}">Mein Studienplatz</a></li>
        <li><a href="/erfahrungsberichtliste?studentId=${sessionScope.user.id}">Meine Erfahrungsberichte</a></li>
        <li><a href="/erfahrungsberichterstellen">schreibe einen Erfahrungsbericht</a></li>
        <li>
            <hr/>
        </li>

        <li><a href="/user/logout">Logout</a></li>

        <li>debug</li>
        <li><a href="/allData">allData</a></li>
    </c:if>

</ul>