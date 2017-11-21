/*  Import  */
import java.util.*;
// Import //


public class MinionProject {


    public static void main(String[] args) {


        // Variablen
        int norbert;

        int MinionPosition;

        int auslosungDesBeginners;

        int minionWahlAnzahl;
        char minionWahlSeite;

        int auswahlDesComputers;
        int anzahlMinionDesComputers;

        int minionsRechts;
        int minionsLinks;

        // Befehl für Scanner 'hans'
        Scanner hans = new Scanner(System.in);


        // Random Platzierung von Norbert zwischen 1 und 11.
        norbert = (int)(Math.random() * 10) + 1;


        // Auslosung, ob Spieler oder Computer startet
        auslosungDesBeginners = (int)(Math.random() * 2+1);
        if (auslosungDesBeginners == 1){
            System.out.println("Der Computer fängt an.");
        }else {
            System.out.println("Du fängst an.");
        }



//------??????----------------------------------------------------------------------------------------------------------------------------------------------

        // Ausgabe für Position Minion und Norbert
//        System.out.println("Norbert steht an Stelle: " + norbert);
//        for (int i=1; i<=11; i++) {
//                if (i == norbert) {
//                    System.out.print(" O ");
//                } else {
//                    System.out.print(" M ");
//                }
//        }
//        System.out.println("");

        //minionsLinks = norbert <
        while (norbert != 0);{
            if(norbert == norbert){
                System.out.print(" O ");
            }else if (minionsLinks == minionsLinks && minionsRechts == minionsRechts){
                System.out.print(" M ");
            }else if (minionsLinks != minionsLinks && minionsRechts  != minionsRechts){
                System.out.print(" - ");
            }

            //Abfrage von welcher Seiten begonnen wird
           if(minionWahlSeite != 'r' || minionWahlSeite != 'l' && minionWahlAnzahl <= 3) {
                System.out.println("Von welcher Seite möchten Sie wählen? Rechts(r) oder Links (l)");
                minionWahlSeite = hans.next().charAt(0);

                if (minionWahlSeite != 'r' || minionWahlSeite != 'l') {
                    System.out.println("Geben Sie für Rechts 'r' oder für Links 'l' ein!");
                    return;
                } else {
                    System.out.println("Wie viele Minions möchten Sie wählen?");
                    minionWahlAnzahl = hans.nextInt();
                    if (minionWahlAnzahl > 3) {
                        System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 3 an!");
                        return;
                    } else {
                        System.out.println("Test");
                    }

                }
            }
        }


        //Abfrage von Minion Anzahl und Seitenbeginn
        System.out.println("Von welcher Seite möchten Sie wählen? Rechts(r) oder Links (l)");
        minionWahlSeite = hans.next().charAt(0);

        System.out.println("Wie viele Minions möchten Sie wählen?");
        minionWahlAnzahl = hans.nextInt();


//------??????----------------------------------------------------------------------------------------------------------------------------------------------
    }

}

