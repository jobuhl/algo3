import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Rackenrotz on 13.10.15.
 */
// Unterklasse von Person
public class student extends person {




    //Attribute
    private String matrikelnumber;

    public student(String name, String telefonnumber, String birthday, String matrikelnumber) {
        super(name, telefonnumber, birthday);
        this.matrikelnumber = matrikelnumber;
    }
    //vererbte getter Methoden


    public String getMatrikelnumber() {
        return matrikelnumber;
    }

    //setter Methode für Matrikelnummer
    public void setMatrikelnumber(String matrikelnumber) {
        this.matrikelnumber = matrikelnumber;
    }



    //vererbte read() Methoden, überschrieben mit Matrikelnummer
    @Override
    public void read() {
        super.read();

        do {
            System.out.println("Bitte eine Matrikelnummer eingeben. Dabei nur Zahlen eingeben:");
            Scanner scan4 = new Scanner(System.in);
            this.matrikelnumber = scan4.nextLine();

        } while (Pattern.matches("\\d*", this.matrikelnumber) != true);

        System.out.println("");
    }

    @Override
    public void dateTest() {
        super.dateTest();

        int year = Integer.parseInt(getBirthday().substring(6, 10));

        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        int current_year = cal.get(GregorianCalendar.YEAR);
        boolean leap = cal.isLeapYear(year);

        //Prüft auf realistisches Geburtsjahr
        if (year < current_year && year > current_year - 150) {
        }
        else {
            // Zu alt oder in der zukunft geboren
            System.out.println("Es ist unmöglich das sie in diesem Jahr geboren sind, erneut eingeben");
            System.out.println(getName() + " " + getBirthday());
            settingBirthday();
        }

    }

    //vererbte toString Methode, überschrieben mit Matrikelnummer
    @Override
    public String toString() {

        return "Matr.Nr.: " + this.matrikelnumber + "   " + super.toString();
    }
}
