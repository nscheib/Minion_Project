import java.util.*;

public class MinionSpiel {

    public static void main(String[] args) {


        // ------------------------------------------------------------------------------------------
        //
        //      Variablen deklarieren
        //
        // ------------------------------------------------------------------------------------------


        final int ANZAHLMINIONS = 11;               // Anzahl der gesamten Minions im Spiel

        final int MENSCH = 1;                       // Spieler "Mensch"
        final int COMPUTER = 2;                     // Spieler "Computer"
        final char LINKS = 'l';                     // Linke Seite
        final char RECHTS = 'r';                    // Rechte Seite

        int leerePlaetzeLinks = 0;                  // Anzahl leerer Plätze links von Norbert
        int belegtePlaetzeLinks;                    // Anzahl belegter Plätze links von Norbert
        int norbert;                                // Norberts Position
        int belegtePlaetzeRechts;                   // Anzahl belegter Plätze rechts von Norbert
        int leerePlaetzeRechts = 0;                 // Anzahl leerer Plätze rechts von Norbert
        int auslosungBeginner;                      // Auslosung des zu startenden Spielers
        int aktiverSpieler;                         // Zuweisung des aktuellen Spielers


        boolean gameOver = false;

        char seitenWahl = '0';                      // 'r' oder 'l' für die Wahl der Seite

        int computerSeitenWahl;
        int anzahlGewaehlteMinions = 0;                 // Anzahl der gewählten Minions 1, 2 oder 3

        int minionCounterMensch = 0;                // Minion-Counter für den Spieler
        int minionCounterComputer = 0;              // Minion-Counter für den Computer
        int winner = 1;




        // Norbert zufällige Position zuweisen


        norbert = ((int) (Math.random() * ANZAHLMINIONS) + 1);            // weist Norbert einen zufälligen Wert zwischen 1 und 11 zu

        belegtePlaetzeLinks = norbert - 1;                                // berechnet die Plätze auf der linken Seite von Norbert
        belegtePlaetzeRechts = ANZAHLMINIONS - norbert;                   // berechnet die Plätze auf der rechten Seite von Norbert



        System.out.println(

                "\n\n############################################################################################################################ \n " +
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
                        "Minion möchtest und gib dafür für rechts " + RECHTS + " oder für links " + LINKS + " ein. Danach wirst du aufgefordert die Anzahl der  \n " +
                        "Minion anzugeben, welche du gern im Team hättest. Du kannst zwischen einem, zwei oder drei Minion wählen, aber nur von      \n " +
                        "einer Seite aus!                                                                                                            \n " +
                        "Wir wünschen dir viel Spaß, dein Banana-Team.                                                                               \n " +
                        "                                                                                                                            \n " +
                        "---------------------------------------------------------- RULES ---------------------------------------------------------- \n " );

        System.out.println("\n\n!!  Das Spiel beginnt  !!\n");
        System.out.println("Norbert wurde folgende Position zufällig zugewiesen: " + norbert + "\n");


        // Anfangspositionen der Minions "graphisch" darstellen


        printPositions(leerePlaetzeLinks, leerePlaetzeRechts, norbert, belegtePlaetzeLinks, belegtePlaetzeRechts, ANZAHLMINIONS, seitenWahl, LINKS);



        // Auslosung, wer das Spiel beginnt

        auslosungBeginner = ((int) (Math.random() * 2) + 1);


        if (auslosungBeginner == 1) {

            aktiverSpieler = MENSCH;
        } else {
            aktiverSpieler = COMPUTER;
        }

        if (aktiverSpieler == MENSCH) {
            System.out.println("\n\nDie Auslosung hat ergeben, dass Du beginnst!");
        } else {
            System.out.println("\n\nDie Auslosung hat ergeben, dass der Computer beginnt!");
        }



        // Spiel-Schleife: Spieler wählen abwechselnd 1-3 Minions ins Team, bis Norbert gewählt wird.


        // initialisiere den Scanner
        Scanner scanner = new Scanner(System.in);


        // führe die Schleife so lange aus, bis gameOver = true ist
        while (!gameOver) {

            System.out.println("\n\n\n================================================\n\n");

            if (aktiverSpieler == MENSCH) {

                System.out.println("Du bist dran.");


                // Seite wählen

                System.out.print("\nVon welcher Seite möchtest du deine Minions wählen? \nGib " + LINKS + " für links oder " + RECHTS + " für rechts ein: ");
                seitenWahl = scanner.next().charAt(0);

                while (seitenWahl != RECHTS && seitenWahl != LINKS) {
                    System.out.print("\nFalsche Eingabe! \nGib " + LINKS + " für links oder " + RECHTS + " für rechts ein: ");
                    seitenWahl = scanner.next().charAt(0);
                }


                // Anzahl der Minions wählen
                System.out.print("\nWie viele Minions möchtest du wählen? \nGib 1, 2 oder 3 ein: ");
                anzahlGewaehlteMinions = scanner.nextInt();

                while (anzahlGewaehlteMinions > 3 || anzahlGewaehlteMinions < 1) {
                    System.out.print("\nFalsche Eingabe! \nGib 1, 2 oder 3 ein: ");
                    anzahlGewaehlteMinions = scanner.nextInt();
                }


                // aktiverSpieler = Computer
            } else {

                System.out.println("Der Computer ist am Zug.");


                // Seite zufällig wählen
                computerSeitenWahl = ((int) (Math.random() * 2) + 1);
                if (computerSeitenWahl == 1) {
                    seitenWahl = LINKS;
                } else {
                    seitenWahl = RECHTS;
                }

                // Anzahl der Minion zufällig wählen
                anzahlGewaehlteMinions = ((int) (Math.random() * 3) + 1);

            }


            System.out.println("");

            // Ausgabe der zufälligen Seitenwahl und Anzahl der gewählten Minion
            if (aktiverSpieler == COMPUTER) {
                System.out.print("Der Computer wählt " + anzahlGewaehlteMinions + " Minion von ");

                if (seitenWahl == LINKS) {
                    System.out.print("links.\n\n");
                } else {
                    System.out.print("rechts.\n\n");
                }
            }



            // 'leere Plätze' hinzufügen und 'belegte Plätze' jeweils abziehen
            if (seitenWahl == LINKS) {
                leerePlaetzeLinks = leerePlaetzeLinks + anzahlGewaehlteMinions;
                belegtePlaetzeLinks = belegtePlaetzeLinks - anzahlGewaehlteMinions;
            } else {
                leerePlaetzeRechts = leerePlaetzeRechts + anzahlGewaehlteMinions;
                belegtePlaetzeRechts = belegtePlaetzeRechts - anzahlGewaehlteMinions;
            }


            // Ausgabe der neuen Positionen der Minions

            printPositions(leerePlaetzeLinks, leerePlaetzeRechts, norbert, belegtePlaetzeLinks, belegtePlaetzeRechts, ANZAHLMINIONS, seitenWahl, LINKS);


            // Überprüfen, ob Norbert gewählt wurde und somit das Spiel verloren ist


            // gameOver wird gleich "true" gesetzt, wenn ein Spieler Norbert gewählt hat
            if ((seitenWahl == LINKS && norbert <= leerePlaetzeLinks) || (seitenWahl == RECHTS && norbert > ANZAHLMINIONS - leerePlaetzeRechts)) {

                System.out.println("\n\n\n================================================\n\n");

                if (aktiverSpieler == MENSCH) {
                    System.out.println("!!  Du hast verloren, da du Norbert ins Team gewählt hast.  !!\n");
                } else {
                    System.out.println("!!  Du hast gewonnen, da der Computer Norbert ins Team gewählt hat.  !!\n");
                }
                gameOver = true;

            }


            // Minion zählen pro Team
            if (aktiverSpieler == MENSCH) {
                minionCounterMensch = minionCounterMensch + anzahlGewaehlteMinions;
            } else {
                minionCounterComputer = minionCounterComputer + anzahlGewaehlteMinions;
            }



            // Spielerwechsel, damit beim nächsten Durchlauf der Schleife der andere Spieler dran ist


            if (aktiverSpieler == MENSCH) {
                aktiverSpieler = COMPUTER;
            } else {
                aktiverSpieler = MENSCH;
            }


        } // end while



        // Ausgabe nach Beendigung der Spiel-Schleife


        System.out.println("Du hast insgesamt " + minionCounterMensch + " Minion in dein Team gewählt.");
        System.out.println("Der Computer hat " + minionCounterComputer + " Minion in sein Team gewählt.");

        if (aktiverSpieler == winner) {
            System.out.println("Glücklicherweise ist Norbert nicht in deinem Team.");
        } else {
            System.out.println("Norbert ist leider in deinem Team.");
        }


    }  // end main method




    private static void printPositions(int leerePlaetzeLinks, int leerePlaetzeRechts, int norbert, int belegtePlaetzeLinks, int belegtePlaetzeRechts, int ANZAHLMINIONS, char seitenWahl, char LINKS) {

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
        if (seitenWahl == LINKS) {
            if (leerePlaetzeLinks < norbert) {
                System.out.print(" O ");
            } else {
                System.out.print(" = ");
            }

        } else {

            if (leerePlaetzeRechts <= ANZAHLMINIONS - norbert) {
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
            if (i > ANZAHLMINIONS - norbert) {
                System.out.print("");
            } else {
                System.out.print(" - ");
            }
        }


    } // end printPositions method



} // end class