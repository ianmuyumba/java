# Week 10 - Practical Session - Collections Framework and File IO

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 10 - Practical Session - Collections Framework and File IO.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Practical Session 10: Collections Framework & File I/O 
Student-Centered, Self-Paced Lab 
 
       Learning Outcomes Covered 
By the end of this practical session, you will be able to: 
1. Analyze the time complexity of operations on different collection types (ArrayList vs 
HashSet vs HashMap). 
2. Evaluate which collection type is most appropriate for a given data storage requirement. 
3. Create an application that reads data from a file, processes it using collections, and 
writes results to a new file. 
4. Debug file I/O code that fails due to unhandled IOException or resource leaks. 
Time Required: 120–150 minutes 
Instructor Intervention: None – you will figure it out yourself! 
 
         Before You Begin 
Ensure you have completed Week 9. You will need: 
• VS Code open 
• Your java-course folder with a new subfolder named week10 
• Git configured and connected to GitHub
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Your Roadmap 
 
TASK 1: The Big Three Collections 
Objective 
Evaluate when to use an ArrayList (List), a HashSet (Set), and a HashMap (Map) based on their 
properties. 
Step 1.1: Create the File 
1. Create a folder named week10 in your java-course directory. 
2. Create a file named CollectionsDemo.java. 
Step 1.2: Write the Code 
java 
// This program demonstrates the three main collection types in Java: 
// List (ArrayList), Set (HashSet), and Map (HashMap). 
 
// Import all necessary collection classes. 
import java.util.ArrayList;
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
import java.util.HashSet; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Set; 
import java.util.Map; 
 
public class CollectionsDemo { 
    public static void main(String[] args) { 
 
        // ============================================================ 
        // 1. LIST (ArrayList) - Ordered, allows duplicates, index-based 
        // ============================================================ 
        System.out.println("=== LIST (ArrayList) ==="); 
         
        // Create an ArrayList to store names. 
        List<String> nameList = new ArrayList<>(); 
         
        // Add elements. Notice we add "Alice" twice. 
        nameList.add("Alice"); 
        nameList.add("Bob"); 
        nameList.add("Alice"); // Duplicates are allowed! 
         
        // Print the list (maintains insertion order). 
        System.out.println("List contents: " + nameList); 
         
        // Access by index (O(1) time complexity).
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
System.out.println("Element at index 1: " + nameList.get(1)); 
 
        // ============================================================ 
        // 2. SET (HashSet) - Unordered, NO duplicates 
        // ============================================================ 
        System.out.println("\n=== SET (HashSet) ==="); 
         
        // Create a HashSet to store names. 
        Set<String> nameSet = new HashSet<>(); 
         
        // Add elements. 
        nameSet.add("Alice"); 
        nameSet.add("Bob"); 
        nameSet.add("Alice"); // Duplicate! This will be ignored. 
        nameSet.add("Charlie"); 
         
        // Print the set. Notice it is NOT in insertion order. 
        System.out.println("Set contents: " + nameSet); 
         
        // Check if an element exists (O(1) time complexity). 
        System.out.println("Does the set contain Bob? " + nameSet.contains("Bob")); 
 
        // ============================================================ 
        // 3. MAP (HashMap) - Key-Value pairs, NO duplicate keys 
        // ============================================================ 
        System.out.println("\n=== MAP (HashMap) ===");
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
// Create a HashMap to store Student IDs (Key) and Names (Value). 
        Map<Integer, String> studentMap = new HashMap<>(); 
         
        // Add key-value pairs using put(). 
        studentMap.put(101, "Alice"); 
        studentMap.put(102, "Bob"); 
        studentMap.put(103, "Charlie"); 
        studentMap.put(101, "David"); // Key 101 already exists! Value is overwritten. 
         
        // Print the map. 
        System.out.println("Map contents: " + studentMap); 
         
        // Access a value by its key (O(1) time complexity). 
        System.out.println("Student with ID 102: " + studentMap.get(102)); 
         
        // Iterate through a map using a for-each loop over entrySet(). 
        System.out.println("Iterating through the Map:"); 
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) { 
            // getKey() returns the ID, getValue() returns the Name. 
            System.out.println("ID: " + entry.getKey() + " | Name: " + entry.getValue()); 
        } 
    } 
}
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
Step 1.3: Evaluate the Collections 
Answer these questions in your notebook: 
1. Which collection would you use to store a list of a customer's past orders where the 
order of purchase matters? (List) 
2. Which collection would you use to store the unique ID numbers of students who 
attended a class? (Set) 
3. Which collection would you use to store a dictionary where you look up a word to find 
its definition? (Map) 
   Task 1 Complete 
• □ I created CollectionsDemo.java 
• □ I ran the code and observed the differences. 
 
TASK 2: Writing Data to a File 
Objective 
Create an application that writes data to a file, analyzing the code to ensure resources are 
properly closed to prevent leaks. 
Step 2.1: Create the File 
Create a file named FileWriteDemo.java. 
Step 2.2: Write the Code 
java 
// This program demonstrates how to write data to a text file. 
// It uses 'try-with-resources' to ensure the file is closed automatically. 
 
// Import necessary I/O classes. 
import java.io.FileWriter; 
import java.io.PrintWriter; 
import java.io.IOException;
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
public class FileWriteDemo { 
    public static void main(String[] args) { 
 
        // Define the file name we want to create. 
        String fileName = "transactions.txt"; 
 
        // ============================================================ 
        // TRY-WITH-RESOURCES 
        // ============================================================ 
        // By placing the FileWriter and PrintWriter inside the try parentheses, 
        // Java guarantees they will be CLOSED automatically when the block finishes  
        // (even if an exception occurs). This prevents memory/resource leaks! 
        try (FileWriter fw = new FileWriter(fileName); 
             PrintWriter pw = new PrintWriter(fw)) { 
 
            System.out.println("Writing to file: " + fileName); 
 
            // Write lines of text to the file using println(). 
            pw.println("TRX001, DEPOSIT, 5000, SUCCESS"); 
            pw.println("TRX002, WITHDRAW , 2000, SUCCESS"); 
            pw.println("TRX003, DEPOSIT, 15000, SUCCESS"); 
            pw.println("TRX004, TRANSFER, 1000, FAILED"); 
 
            // Check if an error occurred during writing. 
            if (pw.checkError()) {
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
System.out.println("An error occurred while writing."); 
            } else { 
                System.out.println("Data written successfully!"); 
            } 
 
        } catch (IOException e) { 
            // Catch and handle any file-related errors (e.g., permission denied). 
            System.out.println("Error writing to file: " + e.getMessage()); 
        } 
 
        // The file is now safely closed and saved in your 'week10' folder. 
    } 
} 
Step 2.3: Run the Program 
After running, go to your week10 folder in VS Code. You will see a new file called 
transactions.txt. Open it to see the text you wrote! 
   Task 2 Complete 
• □ I created FileWriteDemo.java 
• □ I ran the code and verified the file was created. 
 
TASK 3: Reading Data from a File 
Objective 
Read data from a file line-by-line and handle potential IOException errors.
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
Step 3.1: Create the File 
Create a file named FileReadDemo.java.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Step 3.2: Write the Code 
java 
// This program demonstrates how to read data from a file line-by-line. 
// It uses Scanner to read the file and handles missing file errors. 
 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
 
public class FileReadDemo { 
    public static void main(String[] args) { 
 
        // We will read the file we created in Task 2. 
        String fileName = "transactions.txt"; 
 
        // ============================================================ 
        // READING THE FILE 
        // ============================================================ 
        try { 
            // Create a File object pointing to the file. 
            File file = new File(fileName); 
             
            // Create a Scanner to read from the File object (not System.in). 
            Scanner fileScanner = new Scanner(file); 
 
            System.out.println("=== READING FILE: " + fileName + " ===");
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
// Loop until there are no more lines to read. 
            while (fileScanner.hasNextLine()) { 
                // Read the next line and store it in a String. 
                String line = fileScanner.nextLine(); 
                 
                // Print the line to the console. 
                System.out.println(line); 
            } 
 
            // Close the scanner to free resources. 
            fileScanner.close(); 
            System.out.println("=== FILE READING COMPLETE ==="); 
 
        } catch (FileNotFoundException e) { 
            // If the file doesn't exist (e.g., you deleted it or misspelled the name),  
            // this catch block prevents the program from crashing. 
            System.out.println("Error: The file '" + fileName + "' was not found."); 
        } 
    } 
} 
Step 3.3: Debug File I/O (Test the Error) 
1. Run the program. It should read and print the 4 lines from the text file. 
2. Now, go to your folder and rename transactions.txt to transactions_old.txt. 
3. Run the program again. Instead of crashing, it should print: Error: The file 
'transactions.txt' was not found.
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
4. Rename it back to transactions.txt. 
   Task 3 Complete 
• □ I created FileReadDemo.java 
• □ I ran the code and saw it read the file. 
• □ I tested the FileNotFoundException and saw it didn't crash. 
 
TASK 4: Integrated Project - Data Processing Pipeline 
Objective 
Create an application that reads data from a CSV file, processes it using collections, and writes 
the results to a new file. 
Step 4.1: Create the Input File 
In your week10 folder, manually create a file named students.csv. 
Paste this exact text into it and save: 
text 
101,Alice,85 
102,Bob,45 
103,Charlie,92 
104,Diana,78 
105,Eve,38 
Step 4.2: Create the Java File 
Create a file named DataProcessor.java. 
Step 4.3: Write the Code 
java 
// This program reads a CSV file of student marks, uses a Map to process the data, 
// and writes a summary report to a new text file.
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner; 
 
public class DataProcessor { 
    public static void main(String[] args) { 
         
        // We will use a Map to store the processed data. 
        // Key = Student Name, Value = Status (Pass/Fail) 
        Map<String, String> results = new HashMap<>(); 
         
        String inputFile = "students.csv"; 
        String outputFile = "report.txt"; 
         
        double totalMarks = 0; 
        int studentCount = 0; 
 
        // ============================================================ 
        // STEP 1: READ AND PROCESS THE CSV 
        // ============================================================ 
        try {
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
File file = new File(inputFile); 
            Scanner scanner = new Scanner(file); 
             
            // Skip the header if there is one (our file doesn't have one, but good practice). 
            // scanner.nextLine();  
             
            while (scanner.hasNextLine()) { 
                String line = scanner.nextLine(); 
                 
                // Split the line by comma. The result is an array of strings. 
                // Example: "101,Alice,85" becomes ["101", "Alice", "85"] 
                String[] parts = line.split(","); 
                 
                // Ensure the line has exactly 3 parts to prevent errors. 
                if (parts.length == 3) { 
                    String id = parts[0]; 
                    String name = parts[1]; 
                    int marks = Integer.parseInt(parts[2]); // Convert String to int 
                     
                    // Accumulate stats. 
                    totalMarks += marks; 
                    studentCount++; 
                     
                    // Determine pass/fail and store in Map. 
                    if (marks >= 50) { 
                        results.put(name, "PASSED");
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
} else { 
                        results.put(name, "FAILED"); 
                    } 
                } 
            } 
            scanner.close(); 
             
        } catch (FileNotFoundException e) { 
            System.out.println("Error: Input file not found."); 
            return; // Exit the program if we can't read the input. 
        } catch (NumberFormatException e) { 
            System.out.println("Error: The file contains non-numeric marks."); 
            return; 
        } 
 
        // ============================================================ 
        // STEP 2: WRITE THE REPORT TO A NEW FILE 
        // ============================================================ 
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) { 
             
            writer.println("=== EXAMINATION REPORT ==="); 
            writer.println("Total Students Processed: " + studentCount); 
            writer.println("Class Average: " + (totalMarks / studentCount)); 
            writer.println("--------------------------"); 
             
            // Iterate through the Map and write results.
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
for (Map.Entry<String, String> entry : results.entrySet()) { 
                writer.println("Student: " + entry.getKey() + " | Result: " + entry.getValue()); 
            } 
             
            System.out.println("Data processing complete! Check " + outputFile + " for results."); 
             
        } catch (IOException e) { 
            System.out.println("Error writing report file: " + e.getMessage()); 
        } 
    } 
} 
Step 4.4: Run and Verify 
Run the program. Then open report.txt to see the generated summary. You have just built a 
complete data pipeline! 
   Task 4 Complete 
• □ I created students.csv and DataProcessor.java 
• □ I successfully generated the report.txt file. 
 
TASK 5: Push to GitHub 
Step 5.1: Stage and Commit 
1. Open the Source Control panel in VS Code. 
2. Stage all new files in week10 (Include the .java and .txt/.csv files!). 
3. Commit with message: Week 10: Collections Framework & File I/O 
4. Push to GitHub. 
   Task 5 Complete 
• □ I committed and pushed all files
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
Final Self-Assessment Checklist 
• □ I can explain the difference between a List, Set, and Map. 
• □ I can write data to a text file using PrintWriter. 
• □ I can read data from a text file using Scanner. 
• □ I understand why try-with-resources prevents resource leaks. 
• □ I can handle FileNotFoundException and IOException. 
• □ I built a complete data processing pipeline that reads CSV, processes with a Map, and 
writes to a report. 
 
       Troubleshooting Guide 
Problem Solution 
FileNotFoundException Check that students.csv or transactions.txt is in the exact same folder (week10) as your .java file. 
NumberFormatException You tried to parse a String (like "Alice") into an integer. Check your CSV formatting. 
File is empty after 
writing 
Did you call writer.close() or use try-with-resources? If not, the 
data might still be in the memory buffer and not saved. 
 
    What You've Achieved 
You have just: 
• Mastered the Collections Framework (List, Set, Map). 
• Read and written files using File I/O. 
• Built a robust system that handles missing files gracefully.
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
• Processed real-world data formats (CSV). 
You now have all the tools needed to build your final project!
```

</details>
