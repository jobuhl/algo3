import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * Created by Rackenrotz on 12.10.15.
 */
public class person {

    //Attribute
    private String name;
    private String telefonnumber;
    private String birthday;

    //Konstruktor
    public person(String name, String telefonnumber, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.telefonnumber = telefonnumber;
    }

    // getter-Methoden
    public String getName() {
        return name;
    }

    public String getTelefonnumber() {
        return telefonnumber;
    }

    public String getBirthday() {
        return birthday;
    }

    //setter-Methoden
    public void setName(String name) {
        this.name = name;
    }

    public void setTelefonnumber(String telefonnumber) {
        this.telefonnumber = telefonnumber;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /*Methode zum ändern des Geburtstages bei falscher Eingabe springt bei falscheingabe in
    eine Rekursion bis alles richtig eingegeben wurde*/
    public void settingBirthday() {

        do {
            System.out.println("Bitte Geburtstagsdatum in der Form TT/MM/JJJJ eingeben:");
            Scanner scan3 = new Scanner(System.in);
            this.birthday = scan3.next();
            //Setzt das Sonderzleichen immer auf /
            this.birthday = this.birthday.replaceAll("\\p{Punct}", "/");
            //ueberprüft das Format auf TT/MM/JJJJ zeichen können leider nicht so geprueft werden
        } while (Pattern.matches("\\d\\d\\p{Punct}\\d\\d\\p{Punct}\\d\\d\\d\\d", this.birthday) != true);
        dateTest();


    }

    //Methode die eine Tastatureingabe erzwingt
    public void read() {
        Scanner scan = new Scanner(System.in);
        //Schleife bei falscher Eingabe, erster Buschstabe muss groß sein und Zahlen sind nicht erlaubt
        do {
            System.out.println("Bitte geben sie einen Namen ein der mit einem Großbuchstaben beginnt und keine Zahlen enthält:");
            this.name = scan.nextLine();

        } while (
                Pattern.matches("\\D*\\p{Upper}\\p{Lower}*", this.name) != true);


        //Schleife bei falscher Eingabe, nur Zahlen erlaubt
        do {
            System.out.println("Bitte eine Telefonnummer eingeben, bitte nur Ziffern eingeben:");
            this.telefonnumber = scan.nextLine();

        } while (Pattern.matches("\\d*", this.telefonnumber) != true);

        //Schleife bei falscher Eingabe nur das Vorgegebene Format erlaubt TT/MM/JJJJ, zeichen müssen extra überprüft werden
        do {
            System.out.println("Bitte Geburtstagsdatum in der Form TT/MM/JJJJ eingeben:");
            this.birthday = scan.nextLine();

            //Trennzeichen zu / umschreiben
            this.birthday = this.birthday.replaceAll("\\p{Punct}", "/");


        } while (Pattern.matches("\\d\\d\\p{Punct}\\d\\d\\p{Punct}\\d\\d\\d\\d", this.birthday) != true);
    }


    //Ueberpruefung ob das Datum richtig eingegeben wurde
    public void dateTest() {

        //Tage pro Monat von Jan - Dez
        int[] arrlist = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] arrlist2 = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //Tag,Monat,Jahr in integer Umwandeln
        int day = Integer.parseInt(this.birthday.substring(0, 2));
        int month = Integer.parseInt(this.birthday.substring(3, 5));
        int year = Integer.parseInt(this.birthday.substring(6, 10));

        // geburtsjahr prüfen ob Schaltjahr vorliegt
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        int current_year = cal.get(GregorianCalendar.YEAR);
        boolean leap = cal.isLeapYear(year);


        //Prueft ob der Monat existiert
        if (month > 0 && month <= 12) {

            //Prueft ob Tag im angegebenen Monat existiert einschließlich Schaltjahr
            if (leap == false && day <= arrlist[month] && day > 0 || leap == true && day <= arrlist2[month] && day > 0) {

                //alles Korrekt
                System.out.println("Ihr Geburtstag wurde korrekt eingegeben");
                System.out.println(this.name + " " + this.birthday);


            } else {
                //nicht existierender Tag im Monat
                System.out.println("Ihr Tag existiert nicht, erneut eingeben");
                System.out.println(this.name + " " + this.birthday);
                settingBirthday();
            }
        } else {
            // nicht existierender Monat
            System.out.println("Dieser Monat existiert nicht, erneut eingeben");
            System.out.println(this.name + " " + this.birthday);
            settingBirthday();

        }


    }

    // Wiedergabe des Kompletten Profils
    @Override
    public String toString() {

        return "Name: " + this.name + "    " + "Geburtstag: " + this.birthday + "      " + "Telefonnummer: " + this.telefonnumber;

    }


}
