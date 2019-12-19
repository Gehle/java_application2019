# Pongspiel:

Programmieren II / Software Engineering Projekt



Mitglieder: Matthieu Doerler, Jules Beyel, Emilie Gehl


### Inhaltsverzeichnis

1. [Einleitung](#einleitung)
    + [Ziele](#ziele)
    + [Randbedingungen](#randbedingungen)
1. [Build-Anleitung](#build-anleitung)
1. [Bedienungsanleitung](#bedienungsanleitung)
1. [Userstories](#userstories)
1. [Releaseplan](#releaseplan)
1. [Dokumentation Sprint 1](#dokumentation-sprint-1)
    + [Taskliste für die Umsetzung der Userstories](#taskliste-für-die-umsetzung-der-userstories)
    + [Dokumentation wichtiger Code Snippets](#dokumentation-wichtiger-code-snippets)
    + [Testfaelle in Bezug auf Akzeptanzkritierium](#testfaelle-in-bezug-auf-akzeptanzkritierium)
    
1. [Dokumentation Sprint 2](#dokumentation-sprint-2)
    + [Taskliste für die Umsetzung der Userstories](#taskliste-für-die-umsetzung-der-userstories)
    + [Dokumentation wichtiger Code Snippets](#dokumentation-wichtiger-code-snippets)
    + [Testfaelle in Bezug auf Akzeptanzkritierium](#testfaelle-in-bezug-auf-akzeptanzkritierium)
1. [Ergebnisse nach Umsetzung der Userstories](#ergebnisse-nach-umsetzung-der-userstories)
1. [Klassendiagramm](#klassendiagramm)

# Software Engineering

## 1. Einleitung
Willkommen zu unserem Projekt. Wir haben ein Spiel für Menschen im Alter von 5 bis 99 Jahren entwickelt. Es kann einzeln abgespielt werden und es ist keine Internetverbindung erforderlich. Es ist eine tolle Möglichkeit, die Zeit zu verbringen und gleichzeitig Spaß zu haben.
### Ziele
Das Ziel ist es die erlernten Fähigkeiten und Kompetenzen im Bereich Programmieren und Software Engineering innerhalb eines einzigen Projektes in Verbindung zu bringen. Hierfür wollen wir das Spiel Pong programmieren. Auf einer graphischen Oberfläche soll unser Hauptprogramm (Das Spiel) originalgetreu dargestellt werden und unser Spiel darauf gespielt werden. Wir planen für dieses Projekt 2 Sprints.

### Randbedingungen
- Die Programmierung der Anwendung soll in JAVA erfolgen.
- Die Klassen des Programms sollen über die entsprechenden Unit-Tests verfügen.
- Das Projekt soll auf GitHub veröffentlich werden.
- Die Buildautomatisierung soll mit MAVEN erfolgen.
- Das Programm soll mittels einer dafür erstellten JAR-Datei und dem Befehl java-jar xxxxx.jar ausgeführt werden können.

## 2. Build-Anleitung

Git clone:  https://github.com/Gehle/java_application2019
In Git program: 
1. Speichern Sie Ihre src Datei von Ihre Git Projekt auf Ihre Rechner.
2. Löschen Sie Ihre src Datei von Ihre Git Projekt.
3. Fügen Sie die pom.xml Datei mit die geeignete Initialiesierung in das Git Projekt.
4. Fügen Sie die src Ordner von einen Maven Projekt in das Git Projekt.
5. Klicken Sie auf den rechten Maus Taste in " java_application2019": ->Configure ->Convert to Maven.
6. Fügen Sie Ihr eigenes Package in das Ordner src/main/java.
7. Klicken Sie auf den rechten Maus Taste in " java_application2019": ->Run as ->Maven clean.
8. Klicken Sie auf den rechten Maus Taste in "java_application2019": ->Run as ->Maven install.
9. Prüfen Sie in das Ordner "target" ob Sie eine Datei .jar haben.

## 3. Bedienungsanleitung

Nach dem Start unserer App entdecken Sie die Startseite. Nachdem Sie sich über die Spielregeln informiert haben oder nicht, klicken Sie auf "Start" und das Spiel beginnt. Der Ball darf nicht fallen, also bewegen Sie das Rechteck mit der Maus, um den Ball zu prallen. Ihr Ergebnis wird am Ende des Spiels angezeigt. Das ist, wie oft du es geschafft hast, den Ball zurückzuschicken. Viel Erfolg beim spielen !

## 4. Userstories

| **Userstory Nr.** |   **Userstories / Akzeptanzkriterien**  | **Storypoints**  |  **Priorität** |
|:-:|-----|:-:|:-:|
| 1 | Als Benutzer möchte ich verschiedene Schwierigkeitsgrade <br/>AK: Die Geschwindigkeit der Kugel beschleunigt sich. | 8 | 2 |
| 2 | Als Benutzer möchte ich das Spiel neustarten und verlassen können.<br/>AK: Neustart und Exit durch Buttons. | 2 | 2 |
| 3 | Als Benutzer möchte ich Hintergrundmusik mit einstellbarer Lautstärke.<br/>AK: SLider für die Musikstärke und Buttons für on/off. | 5 | 3 |
| 4 | Als Benutzer möchte ich meinen Punktestand sobald das Spiel fertig ist wissen.<br/>AK: Das Punktestand ist während Spiel gezeigt. | 5 | 2 |
| 5 | Als Benutzer möchte ich ohne Internetverbindung spielen.<br/> AK: Das Spiel soll offline gespielt werden können. | 5 | 2 |
| 6 | Als Programmierer möchte ich das Programm einfach nachvollziehen können um es nachbauen, warten und neue Features einfügen zu können.<br/>AK: Kommentare im Code. Logische Struktur (Klassen, Methoden, Variablen). | 3 | 1 |
| 7 | Als Benutzer möchte ich, dass das Spiel an meinen Computer angepasst ist.<br/>AK: Das Spiel ist für alle Bildschirmgrößen geeignet. | 3 | 1 |
| 8 | Als Benutzer möchte ich die Spielregeln kennenlernen.<br/> AK: Neue Fenster mit Spielregeln mit ein Button erreichbar. | 3 | 2 |

Legende : AK = Akzeptanzkriterium

## 5. Releaseplan
|  Release 1 | Release 2  |
|:-:|:-:|
|  US 2 | US 6  |
|  US 3 | US 4  |
|  US 5 | US 7  |
|  US 1 | US 8  |

Legende : US = Userstory

## 6. Dokumentation Sprint 1
###  Taskliste für die Umsetzung der Userstories
| Tasknummer | Tasks | Userstory | Geschätzter Aufwand |
|:-:|-----|:-:|:-:|
| 1 | Grafisches Layout erstellen |  |  |
| 2 | 4 Button für das Starten, Exit, Credit, Spielregel |  |  |
| 3 | Erstellen von 2 Fenster für Spielregeln und Credits mit je ein Button return |  |  |
| 4 | Neue Klasse Vue |  |  |
| 5 |  |  |  |
| 6 |  |  |  |
| 7 | Geschwindigkeitsteuerung  |  |  |
| 8 | 3 Button und ein Slider für der Musiksteuerung |  |  |
| 9 |  |  |  |
| 10 | Inbetriebnahme aller setOnAction (Mouse,Taste) |  |  |

### Dokumentation wichtiger Code Snippets



### Testfälle in Bezug auf Akzeptanzkriterium
| Testfall | Aus US/AK | Vorbedingung | Ablauf | Resultat |
|:-:|:-:|-----|-----|-----|
| 1 | 2 |  |  |  |
| 2 | 3 |  |  |  |
| 3 | 5 |  |  |  |
| 4 | 6 |  |  |  |

## 7. Dokumentation Sprint 2
###  Taskliste für die Umsetzung der Userstories
| Tasknummer | Tasks | Userstory | Geschätzter Aufwand |
|:-:|-----|:-:|:-:|
| 1 |  |  |  |
| 2 |  |  |  |
| 3 |  |  |  |
| 4 | Klassendiagramm auf Eclipse erstellen | 6 | 20 Minuten |
| 5 | Dokumentation in Markdown Format in der README Datei schreiben (Projektbeschreiben) | 6 | 5 Stunden |
| 6 | Dokumentation in Markdown Format in der README Datei schreiben (Sprint 1) | 6 | 4 Studen |
| 7 | Dokumentation in Markdown Format in der README Datei schreiben (Sprint 2) | 6 | 4 Studen |
| 8 | Kommentare in Programm hinzufügen | 6 | 1 Stude |
| 9 | Testklasse schreiben (JUnit) | 6 | 1,5 STuden |
| 10 |  |  |  |

### Dokumentation wichtiger Code Snippets

créer une balle
positionner la balle
rectangle créer et positionner
prendre un input (souris) et lier au rectangle
animation de la balle dans un timelineloop
collision de la balle sur les bords de la fenêtre
collision sur le rectangle
accélération de la balle dès que ça touche le rectangle
message final (perdu)
affichage du score

### Testfälle in Bezug auf Akzeptanzkriterium
| Testfall | Aus US/AK | Vorbedingung | Ablauf | Resultat |
|:-:|:-:|-----|-----|-----|
| 1 | 1 |  |  |  |
| 2 | 4 |  |  |  |
| 3 | 7 |  |  |  |
| 4 | 8 |  |  |  |

## 8. Ergebnisse nach Umsetzung der Userstories



## 9. Klassendiagramm


