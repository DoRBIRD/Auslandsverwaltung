# Auslandsverwaltung

Habe nun Maven statt Gradle benutzt, da geiler.
Tomcat wird zur Laufzeit konfiguriert und fürt die von Maven gebaute .WAR aus. 
(Tomcat einfach runterladen und in den Run einstellungen den Pfand einstellen)
In der servlet-context.xml wird Hybernate konfiguriert, also DB-Name/Password usw.

Akutell zeigt die Webapp alle Studenten in der Datenbank im Browser an.

