import java.util.*;

public class MinionProject {

    public static void main(String[] args) {


        // ------------------------------------------------------------------------------------------
        //
        //      Variablen deklarieren
        //
        // ------------------------------------------------------------------------------------------


        int anzahlMinions = 11;                     // Anzahl der gesamten Minions im Spiel

        int leerePlaetzeLinks = 0;                  // Anzahl leerer Plätze links von Norbert
        int belegtePlaetzeLinks;                    // Anzahl belegter Plätze links von Norbert
        int norbert;                                // Norberts Position
        int belegtePlaetzeRechts;                   // Anzahl belegter Plätze rechts von Norbert
        int leerePlaetzeRechts = 0;                 // Anzahl leerer Plätze rechts von Norbert

        int auslosungBeginner;                      // Auslosung des zu startenden Spielers

        int aktiverSpieler;                         // Zuweisung des aktuellen Spielers
        int computer;                               // Spieler "Computer"
        int mensch;                                 // Spieler "Mensch"

        boolean gameOver = false;

        char seitenWahl;                            // 'r' oder 'l' für die Wahl der Seite
        int computerSeitenWahl;
        int anzahlGewaehlteMinions;                 // Anzahl der gewählten Minions 1, 2 oder 3

        int minionCounterMensch = 0;                // Minion-Counter für den Spieler
        int minionCounterComputer = 0;              // Minion-Counter für den Computer
        int winner = 1;



        // ------------------------------------------------------------------------------------------
        //
        //      Norbert zufällige Position zuweisen
        //
        // ------------------------------------------------------------------------------------------


        norbert = ((int) (Math.random() * anzahlMinions) + 1);                              // weist Norbert einen zufälligen Wert zwischen 1 und 11 zu

        belegtePlaetzeLinks = norbert - 1;                                                  // berechnet die Plätze auf der linken Seite von Norbert
        belegtePlaetzeRechts = anzahlMinions - norbert;                                     // berechnet die Plätze auf der rechten Seite von Norbert


        System.out.println("\n\n!!  Das Spiel beginnt  !!\n");
        System.out.println("Norbert wurde folgende Position zufällig zugewiesen: " + norbert + "\n");



        // ------------------------------------------------------------------------------------------
        //
        //      Anfangspositionen der Minions "graphisch" darstellen
        //
        // ------------------------------------------------------------------------------------------


        // Minions links von Norbert
        for (int i = 1; i <= belegtePlaetzeLinks; i++) {
            System.out.print(" M ");
        }

        // Norbert
        System.out.print(" O ");

        // Minion rechts von Norbert
        for (int i = 1; i <= belegtePlaetzeRechts; i++) {
            System.out.print(" M ");
        }



        // ------------------------------------------------------------------------------------------
        //
        //      Auslosung, wer das Spiel beginnt
        //
        // ------------------------------------------------------------------------------------------


        auslosungBeginner = ((int) (Math.random() * 2) + 1);
        mensch = 1;
        computer = 2;

        if (auslosungBeginner == 1) {
            aktiverSpieler = mensch;
        } else {
            aktiverSpieler = computer;
        }

        if (aktiverSpieler == mensch) {
            System.out.println("\n\nDie Auslosung hat ergeben, dass Du beginnst!");
        } else {
            System.out.println("\n\nDie Auslosung hat ergeben, dass der Computer beginnt!");
        }



        // ------------------------------------------------------------------------------------------
        //
        //      Spiel-Schleife: Spieler wählen abwechselnd 1-3 Minions ins Team, bis Norbert gewählt wird.
        //
        // ------------------------------------------------------------------------------------------


        Scanner scanner = new Scanner(System.in);


        while (!gameOver) {

            System.out.println("\n\n\n================================================\n\n");

            if (aktiverSpieler == mensch) {

                System.out.println("Du bist dran.");


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

                System.out.println("Der Computer ist am Zug.");


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

            if (aktiverSpieler == computer) {
                System.out.print("Der Computer wählt " + anzahlGewaehlteMinions + " Minion von ");

                if (seitenWahl == 'l') {
                    System.out.print("links.\n\n");
                } else {
                    System.out.print("rechts.\n\n");
                }
            }



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


            // leere Plätze links von Norbert darstellen
            for (int i = 1; i <= leerePlaetzeLinks; i++) {
                if (i >= norbert) {
                    System.out.print("");
                } else {
                    System.out.print(" - ");
                }
            }


            // belegte Plätze links von Norbert darstellen
            for (int i = 1; i <= belegtePlaetzeLinks; i++) {
                System.out.print(" M ");
            }


            // Norbert
            if (seitenWahl == 'l') {
                if (leerePlaetzeLinks < norbert) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" = ");
                }
            } else {
                if (leerePlaetzeRechts < anzahlMinions - norbert) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" = ");
                }
            }


            // belegte Plätze rechts von Norbert darstellen
            for (int i = 1; i <= belegtePlaetzeRechts; i++) {
                System.out.print(" M ");
            }


            // leere Plätze rechts von Norbert darstellen
            for (int i = 1; i <= leerePlaetzeRechts; i++) {
                if (i > anzahlMinions - norbert) {
                    System.out.print("");
                } else {
                    System.out.print(" - ");
                }
            }



        // ------------------------------------------------------------------------------------------
        //
        //      Überprüfen, ob Norbert gewählt wurde und somit das Spiel verloren ist
        //          -> gameOver wird gleich "true" gesetzt
        //
        // ------------------------------------------------------------------------------------------


            if ((seitenWahl == 'l' && norbert <= leerePlaetzeLinks) || (seitenWahl == 'r' && anzahlMinions - norbert <= leerePlaetzeRechts)) {

                System.out.println("\n\n\n================================================\n\n");

                if (aktiverSpieler == 1) {
                    System.out.println("!!  Du hast verloren, da du Norbert ins Team gewählt hast.  !!\n");
                } else {
                    System.out.println("!!  Du hast gewonnen, da der Computer Norbert ins Team gewählt hat.  !!\n");
                }
                gameOver = true;
            }


            // Minion zählen pro Team

            if (aktiverSpieler == 1) {
                minionCounterMensch = minionCounterMensch + anzahlGewaehlteMinions;
            } else {
                minionCounterComputer = minionCounterComputer + anzahlGewaehlteMinions;
            }



        // ------------------------------------------------------------------------------------------
        //
        //      Spielerwechsel
        //
        // ------------------------------------------------------------------------------------------


            if (aktiverSpieler == mensch) {
                aktiverSpieler = computer;
            } else {
                aktiverSpieler = mensch;
            }


        } // end while



        // ------------------------------------------------------------------------------------------
        //
        //      Ausgabe nach Beendigung der Spiel-Schleife
        //
        // ------------------------------------------------------------------------------------------


        System.out.println("Du hast insgesamt " + minionCounterMensch + " Minion in dein Team gewählt.");
        System.out.println("Der Computer hat " + minionCounterComputer + " Minion in sein Team gewählt.");

        if (aktiverSpieler == winner) {
            System.out.println("Glücklicherweise ist Norbert nicht in deinem Team.");
        } else {
            System.out.println("Norbert ist leider in deinem Team.");
        }


    }  // end main method


} // end class