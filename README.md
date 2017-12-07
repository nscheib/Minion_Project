# Minion_Project

Programm mit folgenden Funktionen:
- 10 Minions und 1 Norbert
- Random Position von N
- Random Beginner Pc/Spieler
- Anzeige von N. Position
- Anzeige wer beginnt

Schleife:
- Abfrage ob Spieler oder Pc dran ist
- Frage: Anzahl der Minions 1-3
- Frage: Von links oder rechts
- Anzahl/Seite von Minions abziehen
- Anzeige der restlichen Minions
- Prüfen ob Norbert gewählt wurde
    wenn ja: Spiel verloren
        If Spieler/Computer verloren
    wenn nein: schleife neu
    





#  Git / Github

Projekt clonen:

git clone git@github.com:Smorlord/Minion_Project.git

ODER: in IntelliJ IDEA:  VCS  ->  Git  ->  clone...  ->  git@github.com:Smorlord/Minion_Project.git


Branches:

    -  lokale Branches anzeigen:  git branch
    
    -  alle Branches anzeigen (lokal und remote):  git branch -a
    
    -  branch wechseln (lokal):  git checkout branch_name
    
 
status, add, commit, push:

    -  um lokale Änderungen zu pushen:
    
        -  untracked file anzeigen:  git status  (untracked files in rot dargestellt)
        
        -  untracked files hinzufügen:  git add file_name
        
        -  hinzugefügte files committen:  git commit -m"Commit message here"
        
        -  commits pushen:  git push 
            -> falls branch noch nicht remote existiert:
                git push -u remote branch_name
                
pull:

    -  Projekt updaten:  git pull