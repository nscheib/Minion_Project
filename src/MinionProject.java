/*  Import  */
import java.util.*;
/*/ Import /*/

//------ CLASS --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public class MinionProject {



//------ MainMethode --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[]args){


        //Variablen
        int linkeSeite = ((int)(Math.random() * 11) + 1);                           //  Diese Variable "zeigt" eine zufällige Zahl an Minions an, die links neben Norbert stehen.

        int rechteSeite = 11 - linkeSeite - 1;                                      //  Diese Variable "zeigt" eine zufällige Zahl an Minions an, die rechts neben norbert stehen. Es wird die Anzahl
                                                                                    //  der linken Seite (die zufällig gewürfelt wird) genommen und von der maximalen Anzahl Minions abgezogen.
                                                                                    //  Der Platz von Norbert wird ebenfalls abgezogen.

        int linkeSeiteRest;                                                         //  Gibt die Anzahl der schon gewählen Minions für die linke Seite an
        int rechteSeiteRest;                                                        //  Gibt die Anzahl der schon gewählen Minions für die rechte Seite an

        boolean gameover = false;                                                   //  Setzt die Schleife auf false, sodass diese beginnt und erst mit der richtigen Eigenschaft wird diese beendet.
        boolean player = false;                                                     //  Setzt den
        boolean neustart = false;                                                   //  Dient der Abfrage, ob der Spieler das Spiel noch einmal spielen möchte

        while (!neustart) {                                                         //  Schleife die einen Neustart des Spiels ermöglicht

            gameover = false;                                                       //  Setzt die Schleife, nach einem Neustart, auf false zurück.

            /** Spielstart: Um das Spiel zu Starten wird eine Eingabe benötigt, ist die Eingabe falsch, gibt es erneut eine Abfrage */
            System.out.println(
                    "#-#################################################################################################################-# \n" +
                    "------------------------------------------------ PRESS 'n' TO START ------------------------------------------------- \n" +
                    "#-#################################################################################################################-# \n"
            );


            spielStartMethode();                                                    //  Ruft die Methode ab, für die Eingabe und Abfrage, ob das Spiel gestarten werden soll

            printMethode(rechteSeite, linkeSeite);

            int randomBeginner = (int)(Math.random() * 1) + 1;
            if (randomBeginner == 1){
                player = true;
                System.out.println("Du beginnst das Spiel!");
            } else {
                player = false;
                System.out.println("Der Computer beginnt das Spiel");
            }

            /** Schleifenbegin */
            while (!gameover) {

                if (player) {
                    spielerwaehlt(rechteSeite, linkeSeite);                         //  spielerwaehlt ist eine methode die die Eingaben des Spielers aufnimmt und verarbeitet.
                    player = false;
                    printMethode(rechteSeite, linkeSeite);                          //  PrintMethode zeigt die Minions als 'M' und Norbert als 'O' an.
                } else {
                    System.out.println("Der Computer ist am Zug.");
                    computerWaehlt(rechteSeite, linkeSeite);
                    printMethode(rechteSeite, linkeSeite);
                    player = true;
                }
            }

            if (linkeSeite == 0 && rechteSeite == 0 && player == true) {
                System.out.println(" ");
                System.out.println("Der Computer hat gewonnen! :(");
                gameover = true;
            }else {
                System.out.println(" ");
                System.out.println("Du hast gewonnen! :)");
                gameover = true;
            }

            gameOverMethode(gameover);
        }
    }

//------// MainMethode \\--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




/** ___ Methode fragt die Eingabe für den Start des Spiels ab. ________________________________________________________________________________________________________________ */
    static boolean spielStartMethode(){

        Scanner hans = new Scanner(System.in);                                      //  Methode Scanner wird abgerufen, um eine Eingabe in der Konsole zu ermöglichen

        boolean start = false;                                                      //  Variable um zu sagen ob die Eingabe zutrifft(true) oder falsch(false) ist

        System.out.print("Eingabe: ");                                              //  Aufforderung für die Eingabe


        /**  Die Schleife überprüft die Eingabe und bei richtiger Eingabe wird ein Text für den Start und die Spielregeln angezeigt */
        while(!start) {
            if (hans.next().equals("n")) {                                          //  Trifft die Eingabe n zu, geben den folgenden Text in der Konsole aus
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
                start = true;                                                       //  Setze den Start auf richtig und beginne das Spiel
            }else {
                System.out.println("Geben Sie 'n' ein: ");                          //  Falls der Spieler eine falsche Eingabe macht, wird erneut gefragt.
            }
        }
        return start;
    }




/** --- Methode berechnet aus der Eingabe, die Seite(links oder Rechts) und der Anzahl an Minions(eins, zwei oder drei), des Spielers, wie viele Minions noch übrig sind. ------------------------------------------------------------------------------------------------------------------------- */

    public static void spielerwaehlt(int rechteSeite, int linkeSeite){

        char eingabeSeite = '0';                                                    //  ist als "leerer" Char definiert, um die Variable "eingabeZahl", von einem Char in ein int umzuwandeln
        char eingabeAnzahl = '0';
        boolean eingabeRichtig = false;                                             //  Wird benötigt, um die Schleife zu beenden

        Scanner hans = new Scanner(System.in);                                      //  Methode Scanner wird abgerufen, um eine Eingabe in der Konsole zu ermöglichen

        System.out.println("");                                                     //  Abstand zur folgenden Konsolenausgabe

        // Schleife 1: Um die Seite zu wählen
        while (eingabeRichtig == false){                                            //  Schleife, falls die Eingabe kein r oder l ist, wird erneut noch einer Eingabe gefragt
            System.out.println("Welche Seite möchtest Du wählen? Gebe für links 'l' und für rechts 'r' ein.");

            eingabeSeite = hans.next().charAt(0);                                   //  Konsolen Eingabe wird in Variable "eingabeSeite" gespeichert

            if (eingabeSeite == 'r' || eingabeSeite == 'l'){                        //  Abfrage, ob die Eingabe r oder l zutrifft
                eingabeRichtig = true;                                              //  Wenn die Eingabe zutrifft, beende die Schleife und gehe den Code weiter
            }
        }

        eingabeRichtig = false;                                                     //  Reset der Aussage "Eingabe war richtig", um die Variable bei der nächsten Schleife noch einmal zu benutzen

        // Schleife 2: Um die Anzahl der Minions zu wählen
        while (eingabeRichtig == false){
            System.out.println("Wie viele Minions wählst du in dein Team? Wähle zwischen einem, zwei oder drei Minions.");

            eingabeAnzahl = hans.next().charAt(0);                                  //  Konsolen Eingabe wird in Variable "eingabeAnzahl" gespeichert

            try {
                int zahlUmwandlung = Integer.parseInt(eingabeAnzahl + "");       //  Da die Eingabe der Anzahl der Minions erst als Char angenommen wurde, um den ersten Schritt zu vereinfachen,
                                                                                    //  wird dieses Char jetzt in ein Int umgewandelt, um mit diesem eine if Abfrage stellen zu können
                if (zahlUmwandlung <= 3 && zahlUmwandlung > 0) {
                    eingabeRichtig = true;
                }
            } catch (NumberFormatException e) {                                     //  Bei Eingabe eines Buchstaben, statt Zahl, wird die Fehlermeldung übersprungen und die Schleife fortgesetzt
                continue;
            }
        }


        // Brechnung der linken oder rechten Seite
        if (eingabeSeite == 'r'){                                                   //  Wenn die Eingabe mit r übereinstimmt, berechne den Rest der rechten Minions
            rechteSeite = rechteSeite - eingabeAnzahl;
        } else {                                                                    //  ansonsten berechne den Rest der linken Minions
            linkeSeite = rechteSeite - eingabeAnzahl;
        }
    }



/** ___ Methode berechnet aus der Eingabe, die Seite(links oder Rechts) und der Anzahl an
 *  ___ Minions(eins, zwei oder drei), des Spielers, wie viele Minions noch übrig sind. ________________________________________________________________________________________________________________ */

    public static void computerWaehlt(int rechts, int links) {                      //  Methode computerWaehlt, wählt eine Seite und die Anzahl der Minions zufällig und zieht diese von den Minions ab.

        int computerAnzahl = ((int) (Math.random() * 3) + 1);                       //  Eine zufällige Zahl zwischen 1 und 3, für die Wahl an Minions.
        int computerSeite = ((int) (Math.random() * 1) + 1);                        //  Eine zufällige Zahl zwischen 0 und 1. Die linke Seite = 0 und die rechte Seite = 1

        if (computerSeite == 0 && computerAnzahl > links) {
            computerWaehlt(rechts, links);                                          //  rekursive Methode, die methode ruft sich solange SELBST auf bis die abbruch Bedingung erfüllt ist. Erst dann wird
                                                                                    //  der Code fortgesetzt.
        } else if (computerSeite == 1 && computerAnzahl > rechts) {
            computerWaehlt(rechts, links);
        } else {
            if (computerSeite == 0) {
                links = links - computerAnzahl;                                     //  Gibt die Anzahl der schon gewählen Minions für die rechte Seite an
            } else {
                rechts = rechts - computerAnzahl;
            }
            String seitenAusgabe = computerSeite == 0 ? "linken" : "rechten";
            System.out.println("Der Computer nimmt " + computerAnzahl + " Minion von der " + seitenAusgabe + " Seite");
        }

    }




/** ___ Methode zum Anzeigen der Minions und Norbert ________________________________________________________________________________________________________________ */
    public static void printMethode (int linkeSeite, int rechteSeite){              //  Druck die Anzahl an Minions und Norbert in der Konsole aus
        System.out.println(" ");
        //for (int h = 1; h <= linkeSeiteRest; h++) { System.out.print(" - "); }
        for (int i = 1; i <= linkeSeite; i++) { System.out.print(" M "); }
        System.out.print(" O ");
        for (int j = 1; j <= rechteSeite; j++) { System.out.print(" M "); }
        //for (int k = 1; k <= rechteSeiteRest; k++) { System.out.print(" - "); }

        System.out.println(" ");
        System.out.println(" ");
    }



/** ___ Methode fragt ab, ob noch einmal gespielt werden soll _________________________________________________________________________________________________________ */
    public static void gameOverMethode(boolean gameover) {                          //  Fragt den Spieler, ob er noch einmal Spielen oder das Programm beendet möchte.

        Scanner hans = new Scanner(System.in);

        if (gameover == true) {
            System.out.println("Wollen Sie das Spiel neustarten geben Sie 'n' ein!");
            char neustartEingabe = hans.next().charAt(0);
            if (neustartEingabe == 'n') {                                           //  ist die Eingabe korrekt, wird gameover zurück gesetzt und das Spiel startet nocheinmal.
                gameover = false;
            } else {
                System.out.println(
                        "                                                                                                                      \n" +
                                "#-#################################################################################################################-# \n" +
                                "------------------------------------------------------- ENDE -------------------------------------------------------- \n" +
                                "#-#################################################################################################################-# \n"
                );
            }
        }
    }


}
/**------/ CLASS \------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
