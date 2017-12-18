/** Import **/
import java.util.*;

/** CLASS ------------------------------------------------------------------------------------------------ */
public class MinionSpiel{



/** Main Methode ---------------------------------------------------------------------------------------------------- */

    public static void main(String[]args){


        Scanner hans = new Scanner(System.in);


        int minionLinkeSeite = (int)(Math.random() * 11) +1;
        int minionRechteSeite  = 11 - minionLinkeSeite - 1 ;


        int minionGewaehltRechts = 0;
        int minionGewaehltLinks = 0;


        // Spieler = 1 // Computer = 0
        int randomBeginner = (int) (Math.random() * 2);

        int zahlUmwandlung = 0;

        boolean player = false;
        boolean computerWaehlt = false;

        boolean gameover = false;




        System.out.println(
                "#-#################################################################################################################-# \n" +
                "------------------------------------------------ PRESS 'n' TO START ------------------------------------------------- \n" +
                "#-#################################################################################################################-# \n"
        );


        spielStartMethode();


        System.out.println("Hier siehst du die Minions. Das O steht für Norbert, also wähle weise! ");
        printMethode(minionGewaehltLinks, minionLinkeSeite, minionRechteSeite, minionGewaehltRechts);


        if (randomBeginner == 1){
            player = true;
            System.out.println("");
            System.out.println("Du beginnst das Spiel!");
        } else {
            player = false;
            System.out.println("");
            System.out.println("Der Computer beginnt das Spiel");
        }


        while (!gameover) {


            if (player) {


                System.out.println("");
                System.out.print("Du bist dran, wähle dein Team.");
                System.out.println("");


                System.out.print("Gebe eine Zahl zwischen 1 und 3 ein: ");
                char spielerEingabeAnzahl = hans.next().charAt(0);

                try{
                     zahlUmwandlung  = Integer.parseInt(spielerEingabeAnzahl + "");

                    if (zahlUmwandlung  != 0 && zahlUmwandlung  > 3) {
                        System.out.print("Gebe 1, 2 oder 3 ein: ");
                        zahlUmwandlung  = hans.nextInt();
                    }
                }catch (NumberFormatException e) {
                    continue;
                }


                System.out.print("Welche Seite möchtest Du wählen? Gebe für links 'l' und für rechts 'r' ein: ");
                char spielerEingabeSeite = hans.next().charAt(0);

                if (spielerEingabeSeite == 'r' || spielerEingabeSeite == 'l') {

                    if (spielerEingabeSeite == 'r') {
                        minionRechteSeite = minionRechteSeite - zahlUmwandlung;
                        minionGewaehltRechts = minionGewaehltRechts + zahlUmwandlung;
                    } else if (spielerEingabeSeite == 'l'){
                        minionLinkeSeite = minionLinkeSeite - zahlUmwandlung;
                        minionGewaehltLinks = minionGewaehltLinks + zahlUmwandlung;
                    }

                }


                printMethode(minionGewaehltLinks, minionLinkeSeite, minionRechteSeite, minionGewaehltRechts);

                player = false;


            } else {


                System.out.println("Der Computer macht seinen Zug!\n");


                final int CASENULL = 0;
                final int CASEEINS = 1;
                final int CASEZWEI = 2;
                final int CASEDREI = 3;

                final int COMPUTERWAHLANZAHL = (int) (Math.random() * 3) +1;


                if (COMPUTERWAHLANZAHL <= minionRechteSeite ) {

                    if (minionRechteSeite == CASENULL) {

                        minionRechteSeite = minionRechteSeite - CASEEINS;
                        minionGewaehltRechts = minionGewaehltRechts + CASEEINS;
                        System.out.println("Der Computer wählt Norbert in sein Team");

                    } else if (minionRechteSeite <= CASEEINS) {

                        minionRechteSeite = minionRechteSeite - CASEEINS;
                        minionGewaehltRechts = minionGewaehltRechts + CASEEINS;
                        System.out.println("Der Computer wählt " + CASEEINS + " Mininons von der rechten Seite");

                    } else if (minionRechteSeite == CASEZWEI){

                        minionRechteSeite = minionRechteSeite - CASEZWEI;
                        minionGewaehltRechts = minionGewaehltRechts + CASEZWEI;
                        System.out.println("Der Computer wählt " + CASEZWEI + " Mininons von der rechten Seite");

                    } else if (minionRechteSeite == CASEDREI) {

                        minionRechteSeite = minionRechteSeite - CASEDREI;
                        minionGewaehltRechts = minionGewaehltRechts + CASEDREI;
                        System.out.println("Der Computer wählt " + CASEDREI + " Mininons von der rechten Seite");

                    } else if (minionRechteSeite > CASEDREI){

                        minionRechteSeite = minionRechteSeite - COMPUTERWAHLANZAHL;
                        minionGewaehltRechts = minionGewaehltRechts + COMPUTERWAHLANZAHL;
                        System.out.println("Der Computer wählt " + COMPUTERWAHLANZAHL + " Mininons von der rechten Seite");

                    }
                    computerWaehlt = true;


                } else if (COMPUTERWAHLANZAHL <= minionLinkeSeite ) {
                    if (minionLinkeSeite <= CASENULL) {

                        minionLinkeSeite = minionLinkeSeite - CASEEINS;
                        minionGewaehltLinks = minionGewaehltLinks + CASEEINS;
                        System.out.println("Der Computer wählt Norbert in sein Team");

                    } else if (minionLinkeSeite == CASEEINS) {

                        minionLinkeSeite = minionLinkeSeite - CASEEINS;
                        minionGewaehltLinks = minionGewaehltLinks + CASEEINS;
                        System.out.println("Der Computer wählt " + CASEEINS + " Mininons von der linken Seite");

                    } else if (minionLinkeSeite == CASEZWEI){

                        minionLinkeSeite = minionLinkeSeite - CASEZWEI;
                        minionGewaehltLinks = minionGewaehltLinks + CASEZWEI;
                        System.out.println("Der Computer wählt " + CASEZWEI + " Mininons von der linken Seite");

                    } else if (minionLinkeSeite == CASEDREI) {

                        minionLinkeSeite = minionLinkeSeite - CASEDREI;
                        minionGewaehltLinks = minionGewaehltLinks + CASEDREI;
                        System.out.println("Der Computer wählt " + CASEDREI + " Mininons von der linken Seite");

                    } else if (minionLinkeSeite > CASEDREI){

                        minionLinkeSeite = minionLinkeSeite - COMPUTERWAHLANZAHL;
                        minionGewaehltLinks = minionGewaehltLinks + COMPUTERWAHLANZAHL;
                        System.out.println("Der Computer wählt " + COMPUTERWAHLANZAHL + " Mininons von der linken Seite");

                    }
                    computerWaehlt = true;

                }


                printMethode(minionGewaehltLinks, minionLinkeSeite, minionRechteSeite, minionGewaehltRechts);

                player = true;


            }// Beginner




            if (minionLinkeSeite <= 0 && minionGewaehltLinks > minionLinkeSeite && minionRechteSeite <= 0 && minionGewaehltRechts > minionRechteSeite && player == false ){

                System.out.println("Norbert ist nicht in deinem Team. Du hast gewonnen! :)");
                gameover = true;

            } else if (minionLinkeSeite <= 0 && minionGewaehltLinks > minionLinkeSeite && minionRechteSeite <= 0 && minionGewaehltRechts > minionRechteSeite && player == true ){

                System.out.println("Norbert ist in deinem Team. Du hast verloren! :(");
                gameover = true;

            }else if (zahlUmwandlung > minionRechteSeite && minionLinkeSeite <= 0){

                System.out.println("Du hast Norbert in dein Team gewählt und verloren! :(");
                gameover = true;

            }else if (zahlUmwandlung > minionLinkeSeite && minionRechteSeite <= 0){

                System.out.println("Du hast Norbert in dein Team gewählt und verloren! :(");
                gameover = true;

            }


        } //gameover


        if (gameover == true){

            gameover = false;
            System.out.println("\n" +
                    "#-#################################################################################################################-# \n" +
                    "------------------------------------------------------- ENDE -------------------------------------------------------- \n" +
                    "#-#################################################################################################################-# \n" +
                    "\n"
            );

        }

    } // Main Methode

/** Main Methode ---------------------------------------------------------------------------------------------------- */





/** Print Methode ___________________________________________________________________________________________________ */

    public static void printMethode(int minionGewaehltLinks, int minionLinkeSeite,int minionRechteSeite, int minionGewaehltRechts){

        System.out.println(" ");

        for (int h = 1; h <= minionGewaehltLinks; h++)  { System.out.print(" - "); }
        for (int i = 1; i <= minionLinkeSeite; i++)     { System.out.print(" M "); }

        System.out.print(" O ");

        for (int j = 1; j <= minionRechteSeite; j++)    { System.out.print(" M "); }
        for (int k = 1; k <= minionGewaehltRechts; k++) { System.out.print(" - "); }

        System.out.println(" ");
    }



/** SpielStart Methode ______________________________________________________________________________________________ */
    static boolean spielStartMethode(){


        Scanner hans = new Scanner(System.in);


        //  Variable um zu sagen ob die Eingabe zutrifft(true) oder falsch(false) ist
        boolean start = false;


        //  Aufforderung für die Eingabe
        System.out.print("Eingabe: ");


        //  Die Schleife überprüft die Eingabe und bei richtiger Eingabe wird ein Text für den Start und die Spielregeln angezeigt
        while(!start) {


            //  Trifft die Eingabe n zu, geben den folgenden Text in der Konsole aus
            if (hans.next().equals("n")) {

                System.out.println("");
                System.out.println(
                                "########################################################################################################################### \n " +
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
                                "Bitte lese dir die Spieleanleitung genau durch. Das Spiel 'Banana' ist ein einfaches Strategisches Spiel, bei dem es darum  \n " +
                                "geht ein Team aus Minions zu wählen. Einer der Minions ist Norbert, er ist derjenige den keiner im seinem Team haben        \n " +
                                "möchte, denn mit Norbert ist die Niederlage sicher!                                                                         \n " +
                                "                                                                                                                            \n " +
                                "Zu Beginn wird Zufällig ermittelt wer anfängt, Du oder der Computer. Bist du am Zug, wähle aus von welcher Seite du einen   \n " +
                                "Minion möchtest und geben Sie dafür für rechts 'r' und für links 'l' ein. Danach wirst du aufgefordert die Anzahl der       \n " +
                                "Minions anzugeben, welche du gern im Team hättest. Du kannst zwischen einem, zwei oder drei Minions wählen, aber nur von    \n " +
                                "einer Seite aus!                                                                                                            \n " +
                                "Wir wünsche dir viel Spaß, dein Banana-Team.                                                                                \n " +
                                "                                                                                                                            \n " +
                                "---------------------------------------------------------- RULES ---------------------------------------------------------- \n " );

                System.out.println(" ");

                //  Setze den Start auf richtig und beginne das Spiel
                start = true;

            } else {

                //  Falls der Spieler eine falsche Eingabe macht, wird erneut gefragt.
                System.out.println("Geben Sie 'n' ein: ");

            }

        }

        return start;
    }




/** GAMEOVER Methode ------------------------------------------------------------------------------------------------ */
/*
//  Fragt den Spieler, ob er noch einmal Spielen oder das Programm beendet möchte.
    public static void gameOverMethode (boolean gameover) {

        Scanner hans = new Scanner(System.in);

        if (gameover == true) {


            System.out.println("Wollen Sie das Spiel neustarten geben Sie 'n' ein!");
            char neustartEingabe = hans.next().charAt(0);


            if (neustartEingabe == 'n') {

                //  ist die Eingabe korrekt, wird gameover zurück gesetzt und das Spiel startet nocheinmal.
                gameover = false;

            } else {

                System.out.println("\n" +
                        "#-#################################################################################################################-# \n" +
                        "------------------------------------------------------- ENDE -------------------------------------------------------- \n" +
                        "#-#################################################################################################################-# \n" +
                        "\n"
                );
            }
        }
    }
*/
/** CLASS ------------------------------------------------------------------------------------------------ */

}