import java.util.*;

public class MinionProject {


    public static void main(String[] args) {


        // ------------------------------------------------------------------------------------------
        //
        // Variablen deklarieren
        //
        // ------------------------------------------------------------------------------------------


        int anzahlMinions = 11;                     // Anzahl der gesamten Minions im Spiel

        int leerePlaetzeLinks = 0;                  // Anzahl leerer Plätze vor Norbert
        int belegtePlaetzeLinks;                    // Anzahl belegter Plätze vor Norbert
        int norbert;                                // Norberts Position
        int belegtePlaetzeRechts;                   // Anzahl belegter Plätze hinter Norbert
        int leerePlaetzeRechts = 0;                 // Anzahl leerer Plätze hinter Norbert

        int auslosungBeginner;                      // Auslosung des zu startenden Spielers: random 1 oder 2
        int aktiverSpieler;                         // Zuweisung des aktuellen Spielers
        int computer;
        int spieler;
        boolean gameover = false;
        char seitenWahl;                            // 'r' oder 'l' für die Wahl der Seite
        int computerSeitenWahl;
        int anzahlGewaehlteMinions;                 // Anzahl der gewählten Minions 1, 2 oder 3





        // ------------------------------------------------------------------------------------------
        //
        //      Norbert zufällige Position zuweisen
        //
        // ------------------------------------------------------------------------------------------


        norbert = ((int) (Math.random() * anzahlMinions) + 1);                              // weist Norbert einen zufälligen Wert zwischen 1 und 11 zu
        System.out.println("\nNorberts Position: " + norbert);

        belegtePlaetzeLinks = norbert - 1;                                                  // berechnet die Plätze auf der linken Seite von Norbert
        belegtePlaetzeRechts = anzahlMinions - norbert;                                     // berechnet die Plätze auf der rechten Seite von Norbert

        System.out.println("Positionen vor Norbert: " + belegtePlaetzeLinks);
        System.out.println("Positionen hinter Norbert: " + belegtePlaetzeRechts + "\n");


        // Anfangspositionen der Minions "graphisch" darstellen

        // Minions links von Norbert
        for (int i = 1; i <= belegtePlaetzeLinks; i++) {
            System.out.print("M ");
        }

        // Norbert
        System.out.print("O ");

        // Minion rechts von Norbert
        for (int i = 1; i <= belegtePlaetzeRechts; i++) {
            System.out.print("M ");
        }



        // ------------------------------------------------------------------------------------------
        //
        //      Auslosung, wer das Spiel beginnt
        //
        // ------------------------------------------------------------------------------------------


        auslosungBeginner = ((int) (Math.random() * 2) + 1);
        spieler = 1;
        computer = 2;

        if (auslosungBeginner == 1) {
            aktiverSpieler = spieler;
        } else {
            aktiverSpieler = computer;
        }



        // ------------------------------------------------------------------------------------------
        //
        //      Spiel-Schleife: Spieler wählen abwechselnd 1-3 Minions ins Team, bis Norbert gewählt wird.
        //
        // ------------------------------------------------------------------------------------------


        Scanner scanner = new Scanner(System.in);


        while (!gameover) {

            if (aktiverSpieler == spieler) {

                System.out.println("\n\nDu bist dran.");


                // Seite wählen
                do {
                    System.out.print("\nVon welcher Seite möchtest du deine Minions wählen? \nGib 'l' für links oder 'r' für rechts ein: ");
                    seitenWahl = scanner.next().charAt(0);
                } while (seitenWahl != 'r' && seitenWahl != 'l');


                // Anzahl der Minions wählen
                do {
                    System.out.print("\nWie viele Minions möchtest du wählen? \nGib 1, 2 oder 3 ein: ");
                    anzahlGewaehlteMinions = scanner.nextInt();
                } while (anzahlGewaehlteMinions > 3 || anzahlGewaehlteMinions < 1);


            } else {

                System.out.println("\n\nDer Computer ist am Zug.");


                // Seite zufällig wählen
                computerSeitenWahl = ((int) (Math.random() * 2) + 1);
                if (computerSeitenWahl == 1) {
                    seitenWahl = 'l';
                } else {
                    seitenWahl = 'r';
                }

                // Anzahl der Minions zufällig wählen
                anzahlGewaehlteMinions = ((int) (Math.random() * 3) + 1);

            }

            System.out.println("");



            // ------------------------------------------------------------------------------------------
            //
            //      Ausgabe der neuen Positionen der Minions
            //
            // ------------------------------------------------------------------------------------------


            if (seitenWahl == 'l') {
                leerePlaetzeLinks = leerePlaetzeLinks + anzahlGewaehlteMinions;
                belegtePlaetzeLinks = belegtePlaetzeLinks - anzahlGewaehlteMinions;
            } else {
                leerePlaetzeRechts = leerePlaetzeRechts + anzahlGewaehlteMinions;
                belegtePlaetzeRechts = belegtePlaetzeRechts - anzahlGewaehlteMinions;
            }

            // leere Plätze links von Norbert
            for (int i = 1; i <= leerePlaetzeLinks; i++) {
                System.out.print("- ");
            }

            // belegte Plätze links von Norbert
            for (int i = 1; i <= belegtePlaetzeLinks; i++) {
                System.out.print("M ");
            }

            // Norbert
            System.out.print("O ");

            // belegte Plätze rechts von Norbert
            for (int i = 1; i <= belegtePlaetzeRechts; i++) {
                System.out.print("M ");
            }

            // leere Plätze rechts von Norbert
            for (int i = 1; i <= leerePlaetzeRechts; i++) {
                System.out.print("- ");
            }

            System.out.print("\n\nSeite: " + seitenWahl + "\nAnzahl der Minions: " + anzahlGewaehlteMinions);



            // ------------------------------------------------------------------------------------------
            //
            // Überprüfen, ob Norbert gewählt wurde und somit das Spiel verloren ist
            //
            // ------------------------------------------------------------------------------------------


            if ((seitenWahl == 'l' && norbert <= leerePlaetzeLinks) || (seitenWahl == 'r' && anzahlMinions - norbert <= leerePlaetzeRechts)) {
                if (aktiverSpieler == 2) {
                    System.out.println("\nDu hast verloren, da du Norbert ins Team gewählt hast.");
                } else {
                    System.out.println("\nDu hast gewonnen, da der Computer Norbert ins Team gewählt hat.");
                }
                gameover = true;
            }


            // ------------------------------------------------------------------------------------------
            //
            //      Spielerwechsel
            //
            // ------------------------------------------------------------------------------------------


            if (aktiverSpieler == spieler) {

                aktiverSpieler = computer;

            } else {

                aktiverSpieler = spieler;

            }

        } // while



    }  // main method



} // class