/*  Import  */
import java.util.*;
// Import //


public class MinionProject {


    public static void main(String[] args) {


        // Variablen
        int norbert;
        int auslosungDesBeginners;
        int auslosungDesSpielers;
        int spielerMinionWahlAnzahl;
        char spielerMinionWahlSeite;
        int auswahlDesComputers;

        // Befehl für Scanner 'hans'
        Scanner hans = new Scanner(System.in);


        // Random Platzierung von Norbert zwischen 2 und 10. Dargestellt als O
        norbert = (int)(Math.random() * 8) + 2;


        // Auslosung, ob Spieler oder Computer startet
        System.out.println("Um zu ermitteln, ob Sie oder der Computer beginnt, wählen Sie zwischen der Zahl 1 und 2 und geben Sie diese ein:");
        auslosungDesBeginners = (int)(Math.random() * 2+1);
        auslosungDesSpielers = hans.nextInt();
        // Test der Random-Funktion
        System.out.println("Test: RandomFunktion = " + auslosungDesBeginners);


//------??????----------------------------------------------------------------------------------------------------------------------------------------------

        if (auslosungDesSpielers == auslosungDesBeginners || auslosungDesSpielers <= auslosungDesBeginners ){

            // Anweisung für Spieler / Eingabe des Spielers
            System.out.println("Wählen Sie einen, zwei oder drei Minions von der linken oder rechten Seite ausgehend aus.");
            System.out.println("Geben Sie die Anzahl der Minions an: ");
            spielerMinionWahlAnzahl = hans.nextInt();
            System.out.println("Von welcher Seite aus soll gezählt werden? Geben Sie für rechts ein r und für links ein l ein: ");
            spielerMinionWahlSeite = hans.next().charAt(0);

        }else{

            //Computer beginnt und wählt eine zufällige Anzahl an Minions.
            System.out.println("Der Computer wählt: ");
            auswahlDesComputers =(int)(Math.random()*3+1);

        }/*else if(auslosungDesSpielers >= 2) {

            //return und frage erneut nach einer Zahl zwischen 1 und 2
            return;

        }*/
//------??????----------------------------------------------------------------------------------------------------------------------------------------------

        System.out.println("Test: hier steht Hubert: " + norbert);


    }

}

