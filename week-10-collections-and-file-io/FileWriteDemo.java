import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Task 2: write lines to a text file. try-with-resources closes (and flushes) the
// writers automatically, even if an exception occurs, so there are no resource leaks.
public class FileWriteDemo {
    public static void main(String[] args) {
        String fileName = "transactions.txt";     // created in the current folder

        try (FileWriter fw = new FileWriter(fileName);     // overwrites; new FileWriter(f, true) appends
             PrintWriter pw = new PrintWriter(fw)) {

            System.out.println("Writing to file: " + fileName);
            pw.println("TRX001, DEPOSIT, 5000, SUCCESS");
            pw.println("TRX002, WITHDRAW, 2000, SUCCESS");
            pw.println("TRX003, DEPOSIT, 15000, SUCCESS");
            pw.println("TRX004, TRANSFER, 1000, FAILED");

            if (pw.checkError()) {                 // PrintWriter hides IOExceptions; ask it
                System.out.println("An error occurred while writing.");
            } else {
                System.out.println("Data written successfully!");
            }
        } catch (IOException e) {                  // e.g. folder is read-only
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
