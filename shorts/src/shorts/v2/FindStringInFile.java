package shorts.v2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 21. How can you find a string in a text file in Java?
 */
public class FindStringInFile {

    public static void main(String[] args) {

    }

    static boolean findStringInFile(String filePath, String str) throws FileNotFoundException {
        File file = new File(filePath);

        Scanner scanner = new Scanner(file);

        // read the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(str)) {
                scanner.close();
                return true;
            }
        }
        scanner.close();

        return false;
    }

}
