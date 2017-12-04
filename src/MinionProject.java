import java.util.*;

public class MinionProject {


    public static void main(String[] args) {


        // ------------------------------------------------------------------------------------------
        // Variablen deklarieren
        // ------------------------------------------------------------------------------------------

        int anzahlMinions = 11;
        int positionenVorNorbert;
        int positionenHinterNorbert;
        int norbert;
        int auslosungBeginner;
        int aktiverSpieler;
        int computer;
        int spieler;
        boolean gameover = false;
        char seitenWahl;
        int computerSeitenWahl;
        int anzahlGewaehlteMinions;
        int computerAnzahlGewaehlteMinions;


        // ------------------------------------------------------------------------------------------
        // Norbert zufällige Position zuweisen
        // ------------------------------------------------------------------------------------------

        norbert = ((int) (Math.random() * anzahlMinions) + 1);
        System.out.println("\nNorberts Position: " + norbert);

        positionenVorNorbert = norbert - 1;
        positionenHinterNorbert = anzahlMinions - norbert;

        System.out.println("Positionen vor Norbert: " + positionenVorNorbert);
        System.out.println("Positionen hinter Norbert: " + positionenHinterNorbert + "\n");


        // Positionen der Minions und von Norbert "graphisch" darstellen

        for (int i = 1; i <= positionenVorNorbert; i++) {
            System.out.print("M ");
        }

        System.out.print("O ");

        for (int i = 1; i <= positionenHinterNorbert; i++) {
            System.out.print("M ");
        }


        // ------------------------------------------------------------------------------------------
        // Auslosung, wer das Spiel beginnt
        // ------------------------------------------------------------------------------------------

        auslosungBeginner = ((int) (Math.random() * 2) + 1);

        spieler = 1;
        computer = 2;

        if (auslosungBeginner == spieler) {

            aktiverSpieler = spieler;
            System.out.println("\n\n" + "Du fängst an!\n");

        } else {

            aktiverSpieler = computer;
            System.out.print("\n\n" + "Der Computer fängt an!\n");

        }


        // ------------------------------------------------------------------------------------------
        // Spiel-Schleife: Spieler wählen abwechselnd 1-3 Minions ins Team, bis Norbert gewählt wird.
        // ------------------------------------------------------------------------------------------


        while (!gameover) {


            // ------------------------------------------------------------------------------------------
            // Wenn Spieler = aktiver Spieler:
            // ------------------------------------------------------------------------------------------

            if (aktiverSpieler == spieler ) {

                // Seite wählen (rechts oder links)

                Scanner scanner = new Scanner(System.in);

                do {
                    System.out.print("\nVon welcher Seite möchtest du deine Minions wählen? \nGib 'l' für links oder 'r' für rechts ein: ");
                    seitenWahl = scanner.next().charAt(0);
                } while (seitenWahl != 'r' && seitenWahl != 'l');


                // Anzahl der Minions wählen

                do {
                    System.out.print("\nWie viele Minions möchtest du wählen? \nGib 1, 2 oder 3 ein: ");
                    anzahlGewaehlteMinions = scanner.nextInt();
                } while (anzahlGewaehlteMinions > 3 || anzahlGewaehlteMinions < 1);



                // Positionen der restlichen Minions darstellen

                if (seitenWahl == 'l') {

                    // Gewählte Minions (als Strich (-) dargestellt)

                    for (int i = 1; i <= anzahlGewaehlteMinions; i++) {
                        System.out.print("- ");
                    }

                    positionenVorNorbert = positionenVorNorbert - anzahlGewaehlteMinions;   // neuer Wert für positionenVorNorbert setzen

                    // restliche Minions vor Norbert

                    for (int i = 1; i <= positionenVorNorbert; i++) {
                        System.out.print("M ");
                    }

                    // Norbert (falls noch da)

                    if (norbert <= anzahlGewaehlteMinions) {
                        //System.out.println("Du hast verloren, denn du hast Norbert in dein Team gewählt!");
                        gameover = true;
                        break;
                    } else {
                        System.out.print("O ");
                    }

                    // Minions hinter Norbert

                    for (int i = 1; i <= positionenHinterNorbert; i++) {
                        System.out.print("M ");
                    }


                } else {

                    // Minions vor Norbert

                    for (int i = 1; i <= positionenVorNorbert; i++) {
                        System.out.print("M ");
                    }

                    // Norbert (falls noch da)

                    if (norbert >= anzahlMinions - anzahlGewaehlteMinions) {
                        System.out.println("\nDu hast verloren, denn du hast Norbert in dein Team gewählt!");
                    } else {
                        System.out.print("O ");
                    }

                    positionenHinterNorbert = positionenHinterNorbert - anzahlGewaehlteMinions;     // neuer Wert für positionenHinterNorbert setzen

                    // restliche Minions hinter Norbert

                    for (int i = 1; i <= positionenHinterNorbert; i++) {
                        System.out.print("M ");
                    }

                    // Gewählte Minions (als Strich (-) dargestellt)

                    for (int i = 1; i <= anzahlGewaehlteMinions; i++) {
                        System.out.print("- ");
                    }

                }


            // ------------------------------------------------------------------------------------------
            // Wenn Computer = aktiver Spieler:
            // ------------------------------------------------------------------------------------------

            } else {

                // Seite (rechts oder links) und Anzahl der Minions zufällig wählen

                computerSeitenWahl = ((int) (Math.random() * 2) + 1);
                computerAnzahlGewaehlteMinions = ((int) (Math.random() * 3) + 1);

                if (computerSeitenWahl == 1) {
                    seitenWahl = 'l';
                } else {
                    seitenWahl = 'r';
                }

                if (computerAnzahlGewaehlteMinions == 1) {
                    anzahlGewaehlteMinions = 1;
                } else if (computerAnzahlGewaehlteMinions == 2) {
                    anzahlGewaehlteMinions = 2;
                } else {
                    anzahlGewaehlteMinions = 3;
                }

                System.out.println("\nDer Computer hat " + anzahlGewaehlteMinions + " Minions von " + seitenWahl + " gewählt.");


                // Positionen der restlichen Minions darstellen

                if (seitenWahl == 'l') {

                    // Gewählte Minions (als Strich (-) dargestellt)

                    for(int i = 1; i <= anzahlGewaehlteMinions; i++) {
                        System.out.print("- ");
                    }

                    positionenVorNorbert = positionenVorNorbert - anzahlGewaehlteMinions;   // neuer Wert für positionenVorNorbert setzen

                    // restliche Minions vor Norbert

                    for(int i = 1; i <= positionenVorNorbert; i++) {
                        System.out.print("M ");
                    }

                    // Norbert (falls noch da)

                    if (norbert <= anzahlGewaehlteMinions) {
                        System.out.println("O ");
                    } else {
                        System.out.print("");
                    }

                    // Minions hinter Norbert

                    for (int i = 1; i <= positionenHinterNorbert; i++) {
                        System.out.print("M ");
                    }


                } else {

                    // Minions vor Norbert

                    for (int i = 1; i <= positionenVorNorbert; i++) {
                        System.out.print("M ");
                    }

                    // Norbert (falls noch da)

                    if (norbert > (anzahlMinions - anzahlGewaehlteMinions)) {
                        System.out.print("O ");
                    } else {
                        System.out.print("");
                    }

                    positionenHinterNorbert = positionenHinterNorbert - anzahlGewaehlteMinions;     // neuer Wert für positionenHinterNorbert setzen

                    // restliche Minions hinter Norbert

                    for (int i = 1; i <= positionenHinterNorbert; i++) {
                        System.out.print("M ");
                    }

                    // Gewählte Minions (als Strich (-) dargestellt)

                    for (int i = 1; i <= anzahlGewaehlteMinions; i++) {
                        System.out.print("- ");
                    }

                }


            }


            // ------------------------------------------------------------------------------------------
            // Checken, ob Gameover, ansonsten Spielerwechsel
            // ------------------------------------------------------------------------------------------

            if (aktiverSpieler == computer) {

                if (seitenWahl == 'l' && norbert <= anzahlGewaehlteMinions) {

                    System.out.println("Der Computer hat verloren, denn er hat Norbert in sein Team gewaehlt.");
                    gameover = true;

                } else if (seitenWahl == 'r' && norbert >= (anzahlMinions - anzahlGewaehlteMinions)) {

                    System.out.println("Der Computer hat verloren, denn er hat Norbert in sein Team gewaehlt.");
                    gameover = true;

                }

            } else {

                if (seitenWahl == 'l' && norbert <= anzahlGewaehlteMinions) {

                    System.out.println("Du hast verloren, denn du hast Norbert in dein Team gewaehlt.");
                    gameover = true;

                } else if (seitenWahl == 'r' && norbert >= (anzahlMinions - anzahlGewaehlteMinions)) {

                    System.out.println("Du hast verloren, denn du hast Norbert in dein Team gewaehlt.");
                    gameover = true;

                }

            }


            // ------------------------------------------------------------------------------------------
            // Spielerwechsel
            // ------------------------------------------------------------------------------------------

            if (aktiverSpieler == spieler) {

                aktiverSpieler = computer;

            } else if (aktiverSpieler == computer) {

                aktiverSpieler = spieler;

            }


        } // while Spiel-Schleife




    }  // main method




} // class