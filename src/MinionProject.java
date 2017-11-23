/*  Import  */
import java.util.*;
// Import //


public class MinionProject {

    //------MainMethode----------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        // Variablen
        int norbert;
        int rechteSeite;
        int linkeSeite;
        int beginner;
        boolean playerstart = false;
        char seitenEingabe;
        int zahlEingabe;
        int ausgabeLinks;
        int ausgabeRechts;

        // Position von Norbert
        norbert = (int) (Math.random() * 11) + 1;

        // Scanner
        Scanner hans = new Scanner(System.in);

        //* Test Ausgabe Position Norbert *//
        System.out.println("Test PositionNorbert: " + norbert);

        // Anzahl der Minions von der rechten Seite
        rechteSeite = norbert - 1;

        // Anzahl der Minions von der linken Seite
        linkeSeite = 11 - norbert;

        //* Test Ausgabe links/rechts
        System.out.println("Test links/rechts: " + linkeSeite + " " + rechteSeite);

        for (int k = 1; k < rechteSeite; k++){
            System.out.print("X");
        }
        System.out.print("O");
        for (int j = 1; j < linkeSeite; j++){
            System.out.print("X");
        }

        // Ermittlung des Beginners
        beginner = (int)(Math.random() * 2) + 1;

        //Begin der Schleife
        while (norbert != 0) {

            // Anzeige, ob Pc oder Spieler anfängt
            if (beginner != 1) {
                System.out.println("Der Computer beginnt das Match!");
                playerstart = false;
            } else {
                System.out.println("Der Spieler beginnt das Match!");
                playerstart = true;
            }

            // Wenn der Spieler am Zug ist, starte folgenden Ablauf
            if (playerstart == true) {

                // Spielereingabe mit welcher Seite er beginnen möchte
                seitenEingabe = hans.next().charAt(0);
                // Spielereingabe wie viele Minions er wählen möchte
                zahlEingabe = hans.nextInt();

                // Eingabe des Spielers mit Neueingabe, falls keine richtige Bezeichnung ('r' oder 'l')
                if (seitenEingabe != 'r' && seitenEingabe != 'l'){
                    System.out.println("Geben Sie die gewünschte Seite mit 'l' für links und 'r' für rechts: ");
                    //return seitenEingabe;
                }
                // Eingabe des Spielers mit Neueingabe, falls keine richtige Zahl (1 bis 3)
                if (zahlEingabe <= 3){
                    System.out.println("Geben Sie die Anzahl an Minions an, mindestens einen und maximal drei: ");
                    //return zahlEingabe;
                }
                // Abziehen der Minions je nach gewählter Seite
                if (seitenEingabe == 'r'){
                    ausgabeRechts = zahlEingabe - rechteSeite;
                }else {
                    ausgabeLinks = zahlEingabe - linkeSeite;
                }
                // Anzeige der Minions
                for (int i = 1; i < ausgabeLinks; i++) {
                    if (i == norbert) {
                        System.out.print("O");
                    } else {
                        System.out.print("X");
                    }
                }
            // Wenn der Pc am Zug ist, starte folgenden Ablauf
            }else if (playerstart == false){
                if (linkeSeite <= 0){

                }
            }

            if (norbert == 0) {
                if (playerstart == true) {
                    System.out.println("Sie sind der Gewinner! :)");
                }else if (playerstart == false) {
                    System.out.println("Der Computer ist der Gewinner! :(");
                }
            }else{
                    return;
            }

        }


    }
//------MainMethode----------------------------------------------------------------------------------------------------------------------------------------------
}