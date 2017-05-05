import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Rackenrotz on 08.11.15.
 */
public class testAandB {

    public static void main(String[] args) throws FileNotFoundException {

        // erstellen von Objekten
        Stack a = new Stack(6);
        readFile b = new readFile();

        // erstelllen des Wortlesers
        Scanner scan = new Scanner(b.check);
        // Einlesen aller Worte der File
        boolean fine = true;
        while (scan.hasNext() && fine == true) {

            // einzelne Zeichenkette
            String next = scan.next();

            // Wiedergabe jedes einzelnen Zeichens der Zeichenkette
            for (int i = 0; i < next.length(); i++) {

                char letter = next.charAt(i);
                System.out.println(letter);
                if (letter == '{' || letter == '[' || letter == '(') {

                    a.push(letter);
                    System.out.println(a.toString());

                } else {

                    if (letter == '}' || letter == ']' || letter == ')') {

                        //f üllen des Stacks mit bestimmten Zeichen, falls ein gegenzeichen existiert werden beide gelöscht
                        if (letter == ')') {
                            //a.push(')'); // füllt den Stack mit Zeichen
                            //System.out.println(a.toString());
                            if (a.getStackArray(0) == '(') {
                                //  a.pop(); // löscht das oberste Zeichen
                                a.pop(); // löscht das oberste Zeichen
                                System.out.println(a.toString());
                            } else {
                                // Keine passende Klammer auf beendet das Programm
                                System.out.println("Die Klammern sind fehlerhaft gesetzt" + letter + "!=" + a.getStackArray(0));
                                fine = false;
                                break;

                            }
                        }

                        // füllen des Stacks mit bestimmten Zeichen, falls ein gegenzeichen existiert werden beide gelöscht
                        else if (letter == ']') {
                            //a.push(']'); // füllt den Stack
                            //System.out.println(a.toString());
                            if (a.getStackArray(0) == '[') {
                                //a.pop(); // löscht das oberste Zeichen
                                a.pop(); // löscht das oberste Zeichen
                                System.out.println(a.toString());
                            } else {
                                // Keine passende Klammer auf beendet das Programm
                                System.out.println("Die Klammern sind fehlerhaft gesetzt" + letter + "!=" + a.getStackArray(0));
                                fine = false;
                                break;

                            }
                        }
                        // füllen des Stacks mit bestimmten Zeichen, falls ein gegenzeichen existiert werden beide gelöscht
                        else if (letter == '}') {
                            //a.push('}'); // füllt den Stack
                            //System.out.println(a.toString());
                            if (a.getStackArray(0) == '{') {
                                //a.pop(); // löscht das oberste Zeichen
                                a.pop(); // löscht das oberste Zeichen
                                System.out.println(a.toString());
                            } else {
                                // Keine passende Klammer auf beendet das Programm
                                System.out.println("Die Klammern sind fehlerhaft gesetzt    " + letter + " != " + a.getStackArray(0));
                                fine = false;
                                break;

                            }
                        }
                    }
                }

            }
        }

        // Überprüfung ob alle Zeichen entfernt worden sind um so die Syntax zu bestätigen
        if (a.isEmpty() == true) {// prüft ob Stack leer ist
            System.out.println("Alle Klammern sind richtig gesetzt");
        }


    }
}
