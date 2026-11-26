import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Task 3: read a file line by line, and fail gracefully if it is missing.
// Pass a different file name to test the error path:  java FileReadDemo.java missing.txt
public class FileReadDemo {
    public static void main(String[] args) {
        String fileName = (args.length > 0) ? args[0] : "transactions.txt";

        // try-with-resources: the Scanner is closed even if reading fails halfway.
        // (The handout's version calls close() manually, which is skipped if an exception occurs.)
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            System.out.println("=== READING FILE: " + fileName + " ===");
            int lineNumber = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lineNumber++;
                System.out.println(lineNumber + ": " + line);
            }
            System.out.println("=== FILE READING COMPLETE ===");
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + fileName + "' was not found.");
        }
    }
}
