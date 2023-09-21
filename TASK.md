# ffm-java-32-1-todo-frontend

## Setup: Frontend clonen

Heute widmen wir uns dem ToDo-Backend. Folge den Schritten, um die Aufgabe zu erledigen.

Clont das ToDo-Repository von https://github.com/neuefische/java-todo-frontend

In IntelliJ unter "Git", "Manage Remotes" entfernt die bisherige Verknüpfung zum Original-Repository. Dann mit "Git", "GitHub", "Share Project on GitHub" ladet das Projekt in einen Eurer GitHub-Accounts hoch.


## Setup: Vorberitungen

ertselle ein neues Spring-Boot Module und nenne es 'backend'

Installiert 'node', um das Frontend bauen zu können

Baut das Frontend mithilfe des shell scripts

Startet den Server und rufe ihn im Browser auf
(Wenn ihr alles richtig gemacht habt dann seht ihr im Browser jetzt das Frontend)


## Recherche: Zugriffe analysieren

Nutzt die Entwicklertools in Eurem Browser (den "Netzwerk"-Tab), um die Zugriffe des Frontends zu analysieren. Welche Endpunkte werden angesprochen (URLs und HTTP-Methoden)? Welche Daten werden an den Server gesendet?


## Coding: Backend entwickeln

Implementiert die HTTP-Endpunkte, die Euer Frontend benötigt.
Geht dabei Schritt für Schritt die Endpunkte durch und schreibt auch Tests für eure Methoden.


## Bonus: ChatGPT-API

Lasst ChatGPT bei jedem neuen ToDo-Item eine Rechtschreib- und Grammatikkorrektur der Ticket-Texte durchführen.

Schreibt auch dafür Integrationtests (die ChatGPT mit MockWebServer mocken!).


## Bonus: Monitoring

Fügt eine aktuelle Dependency zu JavaMelody zu Eurem Backend hinzu. Eurer Backend sollte nun unter /monitoring ein Dashboard anzeigen, das Euch über die Performance Eures Backends informiert.

Klickt einige Male im Frontend herum und schaut Euch die Messwerte Eures Backends an.

Könnt Ihr Euch eine Situation vorstellen, in der das Monitoring Eures Backends hilfreich sein könnte?


## Bonus: ChatGPT-Initialisierung

Schreibt einen neuen Endpunkt "POST /initialize/{Themengebiet}" um ca 20-30 neue Todo-Items von der ChatGPT-API generieren zu lassen.

Schreibt auch hier Integrationstests (die ChatGPT mit MockWebServer mocken!).


## Bonus: Undo-Endpunkt

Implementiert einen HTTP-Endpunkt im Backend unter /undo, der die letzte Änderung rückgängig macht.

Eine Anpassung im Frontend ist nicht notwendig. Ruft den Endpunkt einfach via Postman auf und schaut, ob die letzte Änderung rückgängig gemacht wurde.

Schreibt gute Integrationstests für diesen Endpunkt.

Es soll auch möglich sein den Endpunkt mehrfach aufzurufen, um mehrere Änderungen rückgängig zu machen.



## Bonus: Redo-Endpunkt

Schreibt nun auch einen /redo-Endpunkt um ein vorheriges Undo wieder rückgängig zu machen.
