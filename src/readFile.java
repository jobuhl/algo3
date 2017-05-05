import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Rackenrotz on 08.11.15.
 */
public class readFile {


    //File muss von Hand umgeändert werden, da es nicht über eine seperate Eingabe funktioniert
    File check;
    public readFile() throws FileNotFoundException{
        check = new File("src/comments.txt");
        if (check.exists() && check.canRead())

        {
            System.out.println("File exists and can be read");

        } else

        {
            System.out.println("File not found or can't be read");
        }

        Scanner scan = new Scanner(check);
        while (scan.hasNextLine())

        {
            System.out.println(scan.nextLine());
        }
    }


}
