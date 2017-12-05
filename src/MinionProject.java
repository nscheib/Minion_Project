import java.util.*;

public class MinionProject {


    public static void main(String[] args) {


        // ------------------------------------------------------------------------------------------
        //
        //      Variablen deklarieren
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

        int minionCounterSpieler = 0;
        int minionCounterComputer = 0;
        int winner = 1;

        System.out.println("\n!!  Das Spiel beginnt  !!\n");

        // ------------------------------------------------------------------------------------------
        //
        //      Norbert zufällige Position zuweisen
        //
        // ------------------------------------------------------------------------------------------


        norbert = ((int) (Math.random() * anzahlMinions) + 1);                              // weist Norbert einen zufälligen Wert zwischen 1 und 11 zu

        belegtePlaetzeLinks = norbert - 1;                                                  // berechnet die Plätze auf der linken Seite von Norbert
        belegtePlaetzeRechts = anzahlMinions - norbert;                                     // berechnet die Plätze auf der rechten Seite von Norbert


        System.out.println("Norbert wurde folgende Position zufällig zugewiesen: " + norbert + "\n");



        // Anfangspositionen der Minions "graphisch" darstellen

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
        spieler = 1;
        computer = 2;

        if (auslosungBeginner == 1) {
            aktiverSpieler = spieler;
        } else {
            aktiverSpieler = computer;
        }

        if (aktiverSpieler == spieler) {
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


        while (!gameover) {

            System.out.println("\n\n================================================\n\n");

            if (aktiverSpieler == spieler) {

                // System.out.println("\n\nAktiver Spieler: " + aktiverSpieler);
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

                // System.out.println("\n\nAktiver Spieler: " + aktiverSpieler);
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


            System.out.print("\n\nSeite: " + seitenWahl + "\nAnzahl der Minions: " + anzahlGewaehlteMinions);



            // ------------------------------------------------------------------------------------------
            //
            //      Überprüfen, ob Norbert gewählt wurde und somit das Spiel verloren ist
            //
            // ------------------------------------------------------------------------------------------


            if ((seitenWahl == 'l' && norbert <= leerePlaetzeLinks) || (seitenWahl == 'r' && anzahlMinions - norbert <= leerePlaetzeRechts)) {

                System.out.println("\n\n================================================\n\n");

                if (aktiverSpieler == 1) {
                    System.out.println("!!  Du hast verloren, da du Norbert ins Team gewählt hast.  !!\n");
                } else {
                    System.out.println("!!  Du hast gewonnen, da der Computer Norbert ins Team gewählt hat.  !!\n");
                }
                gameover = true;
            }

            // Minion zählen

            if (aktiverSpieler == 1) {
                minionCounterSpieler = minionCounterSpieler + anzahlGewaehlteMinions;
            } else {
                minionCounterComputer = minionCounterComputer + anzahlGewaehlteMinions;
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


        System.out.println("Du hast insgesamt " + minionCounterSpieler + " Minion in dein Team gewählt.");
        System.out.println("Der Computer hat " + minionCounterComputer + " Minion in sein Team gewählt.");

        if (aktiverSpieler == winner) {
            System.out.println("Glücklicherweise ist Norbert nicht in deinem Team.");
        } else {
            System.out.println("Norbert ist leider in deinem Team.");
        }

    }  // main method


//    for (int i = 1; i <= leerePlaetzeLinks; i++) {
//        if (i >= norbert) {
//            System.out.print("");
//        } else {
//            System.out.print("- ");
//        }
//    }

//    // Norbert
//            if (leerePlaetzeLinks < norbert && leerePlaetzeRechts < anzahlMinions - norbert) {
//        System.out.print("O ");
//    } else {
//        System.out.print("= ");
//    }


} // class