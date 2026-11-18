# Week 10 - Comprehensive Notes - Collections Framework and File IO

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 10 - Comprehensive Notes - Collections Framework and File IO.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 10 – Collections Framework & File I/O 
Course: Object-Oriented Programming (Java) 
Module 11: Collections and Data Persistence 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Analyze the time complexity of operations on different collection types (ArrayList vs 
HashSet vs HashMap). 
2. Evaluate which collection type is most appropriate for a given data storage requirement. 
3. Create an application that reads data from a file, processes it using collections, and 
writes results to a new file. 
4. Debug file I/O code that fails due to unhandled IOException or resource leaks. 
 
PART 1: The Java Collections Framework (LO1 & LO2) 
1.1 What is a Collection? 
A Collection is an object that groups multiple elements into a single unit. While arrays have a 
fixed size, the Java Collections Framework provides dynamic, resizable data structures with 
built-in algorithms for searching, sorting, and manipulating data. 
The framework is built around three main interfaces: 
1. List (Ordered, allows duplicates) 
2. Set (Unordered, NO duplicates) 
3. Map (Key-Value pairs, NO duplicate keys) 
 
1.2 List (e.g., ArrayList) 
A List is an ordered collection (also known as a sequence). It maintains the insertion order and 
allows duplicate elements. 
• Implementation: ArrayList (backed by a resizable array) or LinkedList (backed by a 
doubly-linked list).
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
• Time Complexity: 
o get(index): O(1) (Instant access by index). 
o contains(element): O(n) (Must search item by item). 
o add(element): O(1) amortized (adds to the end). 
o remove(index): O(n) (Must shift all subsequent elements left). 
java 
import java.util.ArrayList; 
import java.util.List; 
 
List<String> names = new ArrayList<>(); 
names.add("Alice"); 
names.add("Bob"); 
names.add("Alice"); // Duplicates allowed 
System.out.println(names.get(1)); // Output: Bob 
 
1.3 Set (e.g., HashSet) 
A Set is a collection that contains no duplicate elements. It is unordered (does not care about 
insertion order). 
• Implementation: HashSet (backed by a HashMap) or TreeSet (sorted). 
• Time Complexity (HashSet): 
o add(element): O(1) (Instant). 
o contains(element): O(1) (Instant). 
o remove(element): O(1) (Instant). 
java 
import java.util.HashSet; 
import java.util.Set;
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Set<String> uniqueNames = new HashSet<>(); 
uniqueNames.add("Alice"); 
uniqueNames.add("Bob"); 
uniqueNames.add("Alice"); // Duplicate! Will be ignored. 
System.out.println(uniqueNames.size()); // Output: 2 
 
1.4 Map (e.g., HashMap) 
A Map is an object that maps Keys to Values. A Map cannot contain duplicate keys; each key 
can map to at most one value. 
• Implementation: HashMap (unordered, fast) or TreeMap (sorted by key). 
• Time Complexity (HashMap): 
o put(key, value): O(1) (Instant). 
o get(key): O(1) (Instant). 
o containsKey(key): O(1) (Instant). 
java 
import java.util.HashMap; 
import java.util.Map; 
 
Map<Integer, String> studentMap = new HashMap<>(); 
studentMap.put(101, "Alice"); 
studentMap.put(102, "Bob"); 
studentMap.put(101, "Charlie"); // Key 101 exists! "Alice" is overwritten. 
System.out.println(studentMap.get(101)); // Output: Charlie
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
1.5 Evaluating Collection Types (Decision Guide) 
When designing your application, evaluate your data requirements to pick the right tool: 
Requirement Best Choice Why? 
I need to store a list of items in the exact 
order they were added (e.g., chat history). ArrayList Maintains insertion order and index access. 
I need to ensure every item is 100% unique 
(e.g., national ID numbers). HashSet Automatically rejects duplicates, O(1) lookup. 
I need to search for an item extremely fast by 
its unique identifier (e.g., a barcode lookup). HashMap Direct key-to-value lookup, O(1) access. 
I am dealing with very large datasets and 
need to know if a specific item exists. HashSet O(1) contains() is infinitely faster than O(n) loop. 
 
PART 2: File I/O (Input/Output) (LO3) 
2.1 What is File I/O? 
All data in Java's memory (variables, arrays, collections) is lost when the program terminates. To 
make data permanent, we must write it to a file (like .txt, .csv, or .dat) and read it back later. 
2.2 Writing Data to a File 
To write data, we use FileWriter wrapped in a PrintWriter (which gives us familiar methods like 
print() and println()). 
java 
import java.io.FileWriter; 
import java.io.PrintWriter; 
import java.io.IOException;
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
public class WriterDemo { 
    public static void main(String[] args) { 
        try { 
            // Open the file for writing (creates it if it doesn't exist). 
            FileWriter fw = new FileWriter("data.txt"); 
            PrintWriter pw = new PrintWriter(fw); 
 
            // Write data 
            pw.println("Line 1: Hello"); 
            pw.println("Line 2: World"); 
 
            // Must close the writer to save changes and prevent leaks! 
            pw.close();  
             
        } catch (IOException e) { 
            System.out.println("Error writing to file: " + e.getMessage()); 
        } 
    } 
} 
2.3 Reading Data from a File 
To read data, we use a File object to point to the file, and a Scanner to read it line by line. 
java 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
public class ReaderDemo { 
    public static void main(String[] args) { 
        try { 
            File file = new File("data.txt"); 
            // Pass the File object to the Scanner (instead of System.in) 
            Scanner scanner = new Scanner(file); 
 
            while (scanner.hasNextLine()) { 
                String line = scanner.nextLine(); 
                System.out.println(line); 
            } 
            scanner.close(); 
             
        } catch (FileNotFoundException e) { 
            System.out.println("Error: The file was not found."); 
        } 
    } 
} 
2.4 Creating a Data Processing Pipeline 
A standard architectural pattern in software is: 
1. Read raw data from a file (e.g., CSV). 
2. Process it using a Collection (e.g., HashMap). 
3. Write the result to a new file (e.g., a Report). 
Note: CSV (Comma Separated Values) is a common file format where columns are separated by 
commas (e.g., 101,Alice,85). 
java
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
// Reading a line and splitting it into an array 
String line = "101,Alice,85"; 
String[] parts = line.split(",");  
int id = Integer.parseInt(parts[0]); // Parse String to int 
String name = parts[1]; 
int score = Integer.parseInt(parts[2]); 
 
PART 3: Debugging File I/O (LO4) 
3.1 The Danger of Unhandled IOException 
File operations interact with the operating system (hard drives, USB drives). These are highly 
unpredictable environments (the file might be deleted, locked by another program, or the disk 
might be full). 
IOException is a Checked Exception. The Java compiler forces you to handle it. 
java 
// COMPILER ERROR: unreported exception IOException 
FileWriter fw = new FileWriter("data.txt");  
3.2 Resource Leaks 
When you open a file, the Operating System locks it. If your program crashes (or you forget to 
call .close()), the file remains locked. This is called a Resource Leak. 
To fix this, we use the finally block to guarantee closure: 
java 
FileWriter fw = null; 
try { 
    fw = new FileWriter("data.txt"); 
    fw.write("Hello"); 
} catch (IOException e) { 
    System.out.println("Error!");
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
} finally { 
    try { 
        if (fw != null) fw.close(); // Guarantees the file closes 
    } catch (IOException e) { 
        e.printStackTrace(); 
    } 
} 
3.3 The Best Solution: try-with-resources 
Java 7 introduced try-with-resources. If you declare the resource inside the parentheses of the 
try block, Java will automatically close it when the block finishes (even if an exception occurs). 
This is the modern, safe, and clean way to handle File I/O. 
java 
// The FileWriter is safely closed automatically! 
try (FileWriter fw = new FileWriter("data.txt"); 
     PrintWriter pw = new PrintWriter(fw)) { 
     
    pw.println("Data is safe."); 
     
} catch (IOException e) { 
    System.out.println("Caught: " + e.getMessage()); 
} 
 
PART 4: Summary and Key Takeaways 
1. Collections provide dynamic data structures. 
2. Lists are ordered and allow duplicates. Searching is O(n). 
3. Sets ensure uniqueness. Searching is O(1) (very fast).
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
4. Maps store Key-Value pairs. Retrieving a value by key is O(1). 
5. FileWriter/PrintWriter write data to a file. 
6. Scanner/File read data from a file. 
7. try-with-resources guarantees that files are closed automatically, preventing 
memory/resource leaks. 
8. IOException must be caught using a try-catch block. 
 
             Key Terms Glossary 
Term Definition 
Collection A framework for storing and manipulating groups of objects. 
List Ordered collection that allows duplicates (e.g., ArrayList). 
Set Unordered collection that does not allow duplicates (e.g., HashSet). 
Map Collection that maps unique keys to values (e.g., HashMap). 
Time Complexity A measure (Big-O) of how an algorithm's execution time scales with data size. 
CSV Comma Separated Values (a common file format for data). 
IOException A checked exception thrown when an I/O (Input/Output) operation fails. 
Resource Leak A bug caused by failing to close a resource (like a file) after use. 
try-with-
resources 
A syntax that automatically closes resources declared in the try 
parentheses.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Self-Assessment Questions 
1. Why is retrieving an item from a HashMap faster (O(1)) than searching for an item in an 
ArrayList (O(n))? 
2. You are building a system to store the unique National ID numbers of all Kenyans. Should 
you use a List, Set, or Map? Why? 
3. What is the difference between FileWriter and PrintWriter? 
4. Why is try-with-resources better than the old finally block method for closing files? 
5. Write a snippet of code that uses try-with-resources to write "Hello File" to a file named 
test.txt.
```

</details>
