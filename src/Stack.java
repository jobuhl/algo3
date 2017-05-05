import java.util.Arrays;

/**
 * Created by Rackenrotz on 08.11.15.
 */
public class Stack {

    // Attribute
    private char[] stackArray; // Stack
    private int top;           // Indexzeiger

    // Konstruktor reserviert Stack speicher und setzt Zeiger auf -1
    public Stack(int arraylength) {
        this.top = -1; //Zeiger auf -1
        stackArray = new char[arraylength]; //reservierter Speicher
    }

    // Füllt den Stack
    public void push(char a) {

        if (isFull() == false) { //prüft ob der Stack voll ist
            top = top + 1;
            stackArray[top] = a;
        } else {
            System.out.println("Der Stack ist voll und muss erweitert werden");
        }

    }

    // löscht oberstes Stack-Element
    public char pop() {

        char remember = 0;
        if (isEmpty() == false) { //prüft ob der Stack Elemente zum löschen hat
            remember = stackArray[top];
            stackArray[top] = 0;
            top = top -1;
        } else {
            System.out.println("Der Stack ist leer");
        }
        return remember;
    }

    // prüft ob der Stack leer ist
    public boolean isEmpty() {


        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
    // prüft ob der Stack voll ist
    public boolean isFull() {
        if (stackArray.length - 1 == top) {
            return true;
        }
        return false;
    }

    // übergibt die n Stelle des Stacks welche zum Vergleichen benötigt wird
    public char getStackArray(int n) {

        char stacks = 0;
        if (top >= 0 && top - n >= 0) {
            stacks = stackArray[top - n];

        }

        return stacks;
    }

    public char getFirstStack(){
        return stackArray[0];
    }

    // Methode zum Ausgeben des Stacks
    @Override
    public String toString() {
        return Arrays.toString(stackArray);
    }
}
