import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Rackenrotz on 13.10.15.
 */
public class testcase {


    public static void main(String[] args) {


        //Studenten mit Tastatureingabe erstellt nach Aufgabenstellung

/*
        student a = new student();
        a.read();


        student b = new student();
        b.read();

        student c = new student();
        c.read();

        student d = new student();
        d.read();

*/
        //Studenten mit Konstruktor erstellt, für erleichtetes Testen
        student a = new student("Hanns", "07771", "31/10/1970", "2222");
        student b = new student("Kanns", "02345", "02/03/1987", "3333");
        student c = new student("Wanns", "02348", "28/02/2001", "4444");
        student d = new student("Manns", "07563", "29/02/2000", "2222");

        //Beweis das read() richtig funktioniert
        a.read();
        //arrayliste der Studenten
        student[] array = {a, b, c, d};
        //System.out.println(Arrays.toString(array));
        System.out.println("");
        System.out.println("");
        a.dateTest();
        System.out.println("");
        b.dateTest();
        System.out.println("");
        c.dateTest();
        System.out.println("");
        d.dateTest();
        System.out.println("");
        System.out.println("");


        //Matrikelnummer Suchabfrage


        String search_mat;
        do {
            System.out.println("Welche Matrikelnummer suchen Sie? Dabei nur Zahlen eingeben:");
            Scanner scan4 = new Scanner(System.in);
            search_mat = scan4.nextLine();

        } while (Pattern.matches("\\d*", search_mat) != true);
        //Schleife die alle Matrikelnummern auf die Gesuchte überprüft

        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getMatrikelnumber().equals(search_mat)) {
                System.out.println(array[i].toString());
                check = true;

            } else {
                if (i == array.length - 1 && check == false) {
                    System.out.println("Diese Matrikelnummer existiert nicht");
                }
            }

        }

    }
}
