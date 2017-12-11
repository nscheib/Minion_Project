!!! --->  Minion Spiel geht soweit wieder  <--- !!!
-aktuelle Version auf Branch develop-

# Minion_Spiel

### Programm

##### Funktionen:

- 10 Minions und 1 Norbert
- Random Position von Norbert
- Random Beginner Pc/Spieler
- Anzeige aller Positionen (M) inkl. Norbert(O)
- Anzeige, welcher Spieler beginnt

##### Schleife:
- Abfrage ob Spieler oder Pc dran ist
- Frage: Anzahl der Minions 1-3
- Frage: Von links oder rechts
- Anzahl/Seite von Minions abziehen
- Anzeige der restlichen Minions
- Prüfen, ob Norbert gewählt wurde
    wenn ja: Spiel verloren
    wenn nein: Spielerwechsel und Schleife neu starten
    


###  Git / Github

clone:

`git clone git@github.com:Smorlord/Minion_Project.git`

ODER: in IntelliJ IDEA:  VCS  ->  Git  ->  clone...  ->  `git@github.com:Smorlord/Minion_Project.git`


branch:

- `git branch` lokale Branches anzeigen
- `git branch -a` alle Branches anzeigen (lokal und remote) 
- `git checkout branch_name` branch wechseln (lokal)
    
 
status, add, commit, push:

- um lokale Änderungen zu pushen:
  - `git status` untracked file anzeigen (werden in rot dargestellt), untracked = bearbeitete files
  - `git add [file_name]` untracked files hinzufügen
  - `git commit -m"Commit message here"` hinzugefügte files committen
  - `git push` commits pushen
  - `git push -u remote [branch_name]` falls branch noch nicht remote existiert
                
pull:

  - `git pull` Projekt updaten
