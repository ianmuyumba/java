import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// Task 4: a data pipeline:  students.csv  ->  parse and process with a Map  ->  report.txt
public class DataProcessor {
    public static void main(String[] args) {
        String inputFile = "students.csv";
        String outputFile = "report.txt";

        // LinkedHashMap keeps insertion order, so the report lists students in file order.
        // (The handout's HashMap works too, but prints in an unpredictable order.)
        Map<String, String> results = new LinkedHashMap<>();
        double totalMarks = 0;
        int studentCount = 0;
        int skipped = 0;

        // ---- 1. READ and PROCESS ----
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;                 // ignore blank lines

                String[] parts = line.split(",");
                if (parts.length != 3) {                      // malformed row
                    skipped++;
                    continue;
                }
                try {
                    String name = parts[1].trim();
                    int marks = Integer.parseInt(parts[2].trim());
                    totalMarks += marks;
                    studentCount++;
                    results.put(name, marks >= 50 ? "PASSED" : "FAILED");
                } catch (NumberFormatException e) {           // bad row: skip it, keep going
                    skipped++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file '" + inputFile + "' not found.");
            return;
        }

        if (studentCount == 0) {                              // avoid dividing by zero
            System.out.println("No valid student rows found.");
            return;
        }

        // ---- 2. WRITE the report ----
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("=== EXAMINATION REPORT ===");
            writer.println("Total Students Processed: " + studentCount);
            writer.printf("Class Average: %.2f%n", totalMarks / studentCount);
            if (skipped > 0) writer.println("Rows skipped (invalid): " + skipped);
            writer.println("--------------------------");
            for (Map.Entry<String, String> entry : results.entrySet()) {
                writer.println("Student: " + entry.getKey() + " | Result: " + entry.getValue());
            }
            System.out.println("Data processing complete! Check " + outputFile + " for results.");
        } catch (IOException e) {
            System.out.println("Error writing report file: " + e.getMessage());
        }
    }
}
