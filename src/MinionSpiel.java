import java.util.*;

public class MinionSpiel {

    public static void main(String[] args) {


        // ------------------------------------------------------------------------------------------
        //
        //      Variablen deklarieren
        //
        // ------------------------------------------------------------------------------------------


        int anzahlMinions = 11;                     // Anzahl der gesamten Minions im Spiel
        int maximalWaehlbareMinions = 3;



        int leerePlaetzeLinks = 0;                  // Anzahl leerer Plätze links von Norbert
        int belegtePlaetzeLinks;                    // Anzahl belegter Plätze links von Norbert
        int norbert;                                // Norberts Position
        int belegtePlaetzeRechts;                   // Anzahl belegter Plätze rechts von Norbert
        int leerePlaetzeRechts = 0;                 // Anzahl leerer Plätze rechts von Norbert

        boolean spielStartEingabe = true;           // Für die Startbedingungseingabe des Spiels

        int auslosungBeginner;                      // Auslosung des zu startenden Spielers

        int aktiverSpieler;                         // Zuweisung des aktuellen Spielers
        int computer;                               // Spieler "Computer"
        int mensch;                                 // Spieler "Mensch"

        boolean gameOver = false;

        char seitenWahl = 'l';                      // 'r' oder 'l' für die Wahl der Seite
        int computerSeitenWahl;
        int anzahlGewaehlteMinions;                 // Anzahl der gewählten Minions 1, 2 oder 3

        int minionCounterMensch = 0;                // Minion-Counter für den Spieler
        int minionCounterComputer = 0;              // Minion-Counter für den Computer
        int winner = 1;



        Scanner scanner = new Scanner(System.in);   // initialisiere den Scanner



        // ------------------------------------------------------------------------------------------
        //
        //      Norbert zufällige Position zuweisen
        //
        // ------------------------------------------------------------------------------------------


        norbert = ((int) (Math.random() * anzahlMinions) + 1);                              // weist Norbert einen zufälligen Wert zwischen 1 und 11 zu

        belegtePlaetzeLinks = norbert - 1;                                                  // berechnet die Plätze auf der linken Seite von Norbert
        belegtePlaetzeRechts = anzahlMinions - norbert;                                     // berechnet die Plätze auf der rechten Seite von Norbert



        System.out.println(
                "\n\n########################################################################################################################### \n " +
                "# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # \n " +
                "# # #                                                                                                                 # # # \n " +
                "# # #     #########            ####         #####       ##         ####         #####       ##         ####           # # # \n " +
                "# # #     ###     ##          ######        ### ##      ##        ######        ### ##      ##        ######          # # # \n " +
                "# # #     ###    ###         ###   ##       ###  ##     ##       ###   ##       ###  ##     ##       ###   ##         # # # \n " +
                "# # #     #########         ###     ##      ###   ##    ##      ###     ##      ###   ##    ##      ###     ##        # # # \n " +
                "# # #     ###      ##      ####      ##     ###    ##   ##     ####      ##     ###    ##   ##     ####      ##       # # # \n " +
                "# # #     ###      ###    ### # # # # ##    ###     ##  ##    ### # # # # ##    ###     ##  ##    ### # # # # ##      # # # \n " +
                "# # #     ###     ####   ####         ###   ###      ## ##   ####         ###   ###      ## ##   ####         ###     # # # \n " +
                "# # #     ###########   ####           ###  ###       ####  ####           ###  ###       ####  ####           ###    # # # \n " +
                "# # #                                                                                                                 # # # \n " +
                "# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # \n " +
                "########################################################################################################################### \n " +
                "                                                                                                                            \n " +
                "---------------------------------------------------------- RULES ---------------------------------------------------------- \n " +
                "                                                                                                                            \n " +
                "Bitte lies dir die Spieleanleitung genau durch. Das Spiel 'Banana' ist ein einfaches strategisches Spiel, bei dem es darum  \n " +
                "geht, ein Team aus Minion zu wählen. Einer der Minion ist Norbert, er ist derjenige, den keiner in seinem Team haben        \n " +
                "möchte, denn mit Norbert ist die Niederlage sicher!                                                                         \n " +
                "                                                                                                                            \n " +
                "Zu Beginn wird zufällig ermittelt, wer anfängt, Du oder der Computer. Bist du am Zug, wähle aus, von welcher Seite du einen \n " +
                "Minion möchtest und gib dafür für rechts 'r' oder für links 'l' ein. Danach wirst du aufgefordert die Anzahl der            \n " +
                "Minion anzugeben, welche du gern im Team hättest. Du kannst zwischen einem, zwei oder drei Minion wählen, aber nur von      \n " +
                "einer Seite aus!                                                                                                            \n " +
                "Wir wünschen dir viel Spaß, dein Banana-Team.                                                                               \n " +
                "                                                                                                                            \n " +
                "---------------------------------------------------------- RULES ---------------------------------------------------------- \n " );



        // ------------------------------------------------------------------------------------------
        //
        //      Spiel startet durch Tastendruck
        //
        // ------------------------------------------------------------------------------------------


        System.out.println(" ------------------------------------------- Gib zum starten des Spiels 's' ein -------------------------------------------");


        while (spielStartEingabe){
            if (scanner.next().charAt(0) == 's') {
                spielStartEingabe = false;
            } else {
                spielStartEingabe = true;
            }
        }

        System.out.println("\n\n!!  Das Spiel beginnt  !!\n");
        System.out.println("Norbert wurde folgende Position zufällig zugewiesen: " + norbert + "\n");



        // ------------------------------------------------------------------------------------------
        //
        //      Anfangspositionen der Minions "graphisch" darstellen
        //
        // ------------------------------------------------------------------------------------------


        printPositions(belegtePlaetzeLinks, belegtePlaetzeRechts, leerePlaetzeLinks, leerePlaetzeRechts, norbert, seitenWahl, anzahlMinions);



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



        // führe die Schleife so lange aus, bis gameOver = true ist
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
                } while (anzahlGewaehlteMinions > maximalWaehlbareMinions || anzahlGewaehlteMinions < 1);


            // aktiverSpieler = Computer
            } else {

                System.out.println("Der Computer ist am Zug.");


                // Seite zufällig wählen
                computerSeitenWahl = ((int) (Math.random() * 2) + 1);
                if (computerSeitenWahl == 1) {
                    seitenWahl = 'l';
                } else {
                    seitenWahl = 'r';
                }

                // Anzahl der Minion zufällig wählen
                anzahlGewaehlteMinions = ((int) (Math.random() * maximalWaehlbareMinions) + 1);

            }


            System.out.println("");

            // Ausgabe der zufälligen Seitenwahl und Anzahl der gewählten Minion
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

            // 'leere Plätze' hinzufügen und 'belegte Plätze' jeweils abziehen
            if (seitenWahl == 'l') {
                leerePlaetzeLinks = leerePlaetzeLinks + anzahlGewaehlteMinions;
                belegtePlaetzeLinks = belegtePlaetzeLinks - anzahlGewaehlteMinions;
            } else {
                leerePlaetzeRechts = leerePlaetzeRechts + anzahlGewaehlteMinions;
                belegtePlaetzeRechts = belegtePlaetzeRechts - anzahlGewaehlteMinions;
            }


            printPositions(belegtePlaetzeLinks, belegtePlaetzeRechts, leerePlaetzeLinks, leerePlaetzeRechts, norbert, seitenWahl, anzahlMinions);



        // ------------------------------------------------------------------------------------------
        //
        //      Überprüfen, ob Norbert gewählt wurde und somit das Spiel verloren ist
        //
        // ------------------------------------------------------------------------------------------

            // gameOver wird gleich "true" gesetzt, wenn ein Spieler Norbert gewählt hat
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
        //      Spielerwechsel, damit beim nächsten Durchlauf der Schleife der andere Spieler dran ist
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








// ----------------------------------------------------------------------------------------------------------------
//
//      Methods
//
// ----------------------------------------------------------------------------------------------------------------



    private static void printPositions (int belegtePlaetzeLinks, int belegtePlaetzeRechts, int leerePlaetzeLinks, int leerePlaetzeRechts, int norbert, char seitenWahl, int anzahlMinions) {

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


        // Norbert darstellen als "0", wenn er noch nicht gewählt wurde, ansonsten als "="
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

    } // end printPositions method









} // end class