import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Rackenrotz on 10.11.15.
 */
public class testC {

    public static void main(String[] args) throws FileNotFoundException {

        Stack a = new Stack(10);
        readFile b = new readFile();
        Scanner scan = new Scanner(b.check);

        boolean fine = true;
        boolean slash = false;
        boolean star = false;

        while (scan.hasNext() && fine == true) {

            String next = scan.next();

            //Schleife um alle Zeichen einzeln darzustellen
            for (int i = 0; i < next.length(); i++) {

                char letter = next.charAt(i);
                System.out.println(letter);

                //Prüft Zeichen auf / und * oder auf andere Zeichen
                if (letter == '/' || letter == '*') {

                    //Ist das Zeichen / wird geprüft ob ein Stern direkt davor war oder nicht
                    if (letter == '/') {
                        //Wenn kein Stern wird Slash auf true gesetzt
                        if (star == false) {
                            slash = true;
                            // Ist ein Stern direkt davor wird gepopt,falls es ein /* gibt
                        } else if (star == true && !a.isEmpty()) {
                            a.pop();
                            System.out.println(a.toString());
                            // existiert kein /* tritt ein Fehler auf
                        }else{
                            fine = false;
                            break;
                        }


                        // existiert ein Slash bei Stern wird gepusht
                    } else {
                        if (letter == '*' && slash == true) {
                            a.push('#');
                            System.out.println(a.toString());
                            slash = false;

                            // Ansonsten wird Stern auf true gesetzt
                        } else if (letter == '*' && slash == false) {
                            star = true;
                        }
                    }



                    // Ist das Zeichen weder * noch / wird beides auf False gesetzt um Fehler zu vermeiden
                } else {
                    star = false;
                    slash = false;
                }
            }
        }


        if (a.isEmpty() == true && fine == true)

        {
            System.out.println("Alle Kommentarzeichen sind richtig gesetzt (auch Verschachtelt)");
        } else

        {
            System.out.println("Fehler in der Syntax");
        }


    }
}
