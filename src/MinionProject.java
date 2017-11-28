/*  Import  */
import java.util.*;
/*/ Import /*/

//------ CLASS --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public class MinionProject {



//------ MainMethode --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[]args){


        //Variablen
        int linkeSeite = ((int)(Math.random() * 11) + 1);
        int rechteSeite = linkeSeite - 10;
        boolean gameover = false;
        boolean player = false;
        boolean neustart = false;

        while (!neustart) {
            // Spielstart: Um das Spiel zu Starten wird eine Eingabe benötigt, ist die Eingabe falsch, gibt es erneut eine abfrage
            System.out.println(
                    "#-#################################################################################################################-# \n" +
                    "------------------------------------------------ PRESS 'n' TO START ------------------------------------------------- \n" +
                    "#-#################################################################################################################-# \n"
            );


            // Ruft die Methode ab, für die Eingabe und Abfrage, ob das Spiel gestarten werden soll
            spielStartMethode();
            while (!gameover) {

                //printMethode();
                if (player) {
                    System.out.println("Von welcher Seite (links 'l' oder rechts 'r') möchtest du deine Minions wählen?.");
                    eingabeEinsMethode();
                    System.out.println("Wie viele Minions möchtest du wählen, einen, zwei oder drei?");
                    eingabeZweiMethode();

                    System.out.println("Sie haben die " + "" + " Seite und " + "" + " Minions gewählt.");

                    player = true;
                } else {
                    System.out.println("Der Computer ist am Zug.");
                    int computerAnzahl = ((int) (Math.random() * 3) + 1);
                    int computerSeite = ((int) (Math.random() * 1) + 1);

                    if (linkeSeite > 0 && linkeSeite >= 3) {
                        linkeSeite = computerAnzahl - linkeSeite;
                        System.out.println("Der Computer nimmt " + computerAnzahl + " Minion von der linken Seite");
                    } else if (rechteSeite > 0 && rechteSeite >= 3) {
                        rechteSeite = computerAnzahl - rechteSeite;
                        System.out.println("Der Computer nimmt " + computerAnzahl + " Minion von der rechten Seite");
                    }
                    //printMethode();
                    player = false;
                }

                if (linkeSeite == 0 && rechteSeite == 0) {
                    gameover = true;
                }
            }

            if (player) {
                System.out.println("Du hast gewonnen! :)");
            } else {
                System.out.println("Der Computer hat gewonnen! :(");
            }

            if(player){
                System.out.println("Wollen Sie das Spiel neustarten geben Sie 'n' ein!");
                spielStartMethode();
                neustart = true;
            }else {
                System.out.println("Das Spiel wird beendet!" +
                        "#-#################################################################################################################-# \n" +
                        "------------------------------------------------------- ENDE -------------------------------------------------------- \n" +
                        "#-#################################################################################################################-# \n"
                );

            }


        }

    }
//------// MainMethode \\--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------





// --- Methode fragt die Eingabe für den Start des Spiels ab. -------------------------------------------------------------------------------------------------------------------------------------------
    static boolean spielStartMethode(){

        Scanner hans = new Scanner(System.in);  // Fügt die Methode Scanner hinzu, um eine Eingabe machen zu können
        boolean start = false;                  // Variable um zu sagen ob die Eingabe zutrifft(true) oder falsch(false) ist

        System.out.print("Eingabe: ");          // Aufforderung für die Eingabe

        // Die Schleife überprüft die Eingabe und bei richtiger Eingabe wird ein Text für den Start und die Spielregeln angezeigt
        while(!start) {
            if (hans.next().equals("n")) {
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

                start = true;
            }else {
                System.out.println("Geben Sie 'n' ein: ");
            }
        }
        return start;
    }




/*/ --- Methode zum Anzeigen der Minions und Norbert --------------------------------------------------------------------------------------------------------------------
    static int printMethode (linkeSeite,rechteSeite){
        for (int i = 1; i <= linkeSeite; i++){ System.out.print(" M "); }
        System.out.print(" O ");
        for (int k = 1; k <= rechteSeite; k++){ System.out.print(" M "); }
        return;
    }
*/



// --- Methode zum abrufen welche Seite gewählt werden soll --------------------------------------------------------------------------------------------------------------------

    public static boolean eingabeEinsMethode(){

        Scanner hans = new Scanner(System.in);              // Fügt die Methode Scanner hinzu, um eine Eingabe machen zu können
        boolean eingabeEins = false;                        // ist für die Seitenwahl definiert, von welcher Seite die Minions gewählt werden

        System.out.print("Eingabe: ");                      // Aufforderung für die Eingabe

        while (!eingabeEins){
            if ( (hans.next().equals("r")) && (hans.next().equals("l")) ) {
                eingabeEins = true;
            }else{
                System.out.print("Gebe für links 'l' und für rechts 'r' ein!");
            }
        }
        return eingabeEins;
    }




// --- Methode zum prüfen der Eingabe für die Anzahl der Minions --------------------------------------------------------------------------------------------------------------------
    public static int eingabeZweiMethode(){

        Scanner hans = new Scanner(System.in);              // Fügt die Methode Scanner hinzu, um eine Eingabe machen zu können
        int eingabeZwei = hans.nextInt();                   // ist für die Anzahl(eins,zwei oder drei) der Minions definiert, die gewählt werden sollen

        System.out.print("Eingabe: ");                      // Aufforderung für die Eingabe

        while (eingabeZwei > 3){

            if (hans.nextInt() <= 3){
                System.out.print("Eingabe: ");              // Aufforderung für die Eingabe
            }else {
                System.out.println("Bitte gebe eine Zahl zwischen 1 und 3 ein!");
            }
        }
        return eingabeZwei;
    }





}
//------/ CLASS \-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------