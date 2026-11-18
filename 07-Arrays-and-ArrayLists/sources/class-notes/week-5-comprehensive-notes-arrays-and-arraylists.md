# Week 5 - Comprehensive Notes - Arrays and ArrayLists

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 5 - Comprehensive Notes - Arrays and ArrayLists.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 5 – Arrays and ArrayLists 
Course: Object-Oriented Programming (Java) 
Module 6: Arrays and Collections Basics 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Analyze array algorithms to determine their time complexity (linear vs. quadratic). 
2. Evaluate the trade-offs between using arrays and ArrayLists for different scenarios 
(memory, performance, flexibility). 
3. Debug array index out-of-bounds errors by simulating loop conditions. 
4. Design an application that uses both arrays and ArrayLists to manage a collection (e.g., a 
student roster). 
 
PART 1: Introduction to Arrays 
1.1 What is an Array? 
An array is a container object that holds a fixed number of values of a single type. Think of it as 
a row of numbered lockers. Each locker holds one item, and you access the item by its locker 
number (the index). 
Key Characteristics of Arrays: 
• Fixed Size: Once you create an array of size 5, it will always hold exactly 5 elements. It 
cannot grow or shrink. 
• Same Data Type: An array of int can only hold integers. An array of String can only hold 
strings. 
• Zero-Indexed: The first element is at index 0. The last element is at index length - 1. 
• Stored in Contiguous Memory: Elements are stored right next to each other in the 
computer's memory, which makes accessing them very fast.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
1.2 Declaring and Initializing Arrays 
There are two main ways to create an array in Java: 
Method 1: Declare with a size, then assign values 
java 
// Create an array of 5 integers. All elements are initialized to 0 by default. 
int[] numbers = new int[5]; 
 
// Assign values using indices 
numbers[0] = 10; 
numbers[1] = 20; 
numbers[2] = 30; 
numbers[3] = 40; 
numbers[4] = 50; 
Method 2: Declare and initialize in one line 
java 
// Java automatically determines the size based on the number of values. 
int[] scores = {85, 92, 78, 95, 88};  
String[] names = {"Alice", "Bob", "Charlie"}; 
Default Values 
If you create an array but don't assign values immediately, Java fills it with default values: 
• int, long, short, byte: 0 
• double, float: 0.0 
• boolean: false 
• String and Objects: null
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
1.3 Accessing and Iterating Through Arrays 
Using a Traditional for loop 
The traditional for loop gives you control over the index. Use this when you need to know the 
position of the element or if you need to skip elements. 
java 
int[] numbers = {10, 20, 30, 40, 50}; 
 
for (int i = 0; i < numbers.length; i++) { 
    System.out.println("Element at index " + i + ": " + numbers[i]); 
} 
Using an Enhanced for loop (For-Each) 
The enhanced for loop is cleaner and easier to read. Use this when you just want to read every 
element from start to finish. 
java 
String[] fruits = {"Apple", "Banana", "Orange"}; 
 
for (String fruit : fruits) { 
    System.out.println(fruit); 
} 
 
PART 2: Array Algorithms and Time Complexity (LO1) 
2.1 Introduction to Time Complexity 
Time Complexity (often written in Big-O notation) is a way to measure how long an algorithm 
takes to run as the size of the input (n) grows. 
• O(1) - Constant Time: The algorithm takes the exact same amount of time regardless of 
input size (e.g., accessing arr[5]).
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
• O(n) - Linear Time: The time grows directly with the input size. If you have 10 items, it 
does 10 operations; 100 items, 100 operations. 
• O(n^2) - Quadratic Time: The time grows with the square of the input size. This is typical 
of nested loops. If you have 10 items, it does 100 operations; 100 items, it does 10,000 
operations. 
2.2 Linear Array Algorithms (O(n)) 
If an algorithm requires you to look at every single element in the array, its time complexity is 
O(n). 
Example 1: Finding the Maximum 
java 
int[] scores = {85, 92, 78, 95, 88}; 
int max = scores[0]; // Assume first is max 
 
// We must check every element to ensure we found the real max. 
for (int i = 1; i < scores.length; i++) { 
    if (scores[i] > max) { 
        max = scores[i]; 
    } 
} 
// Time Complexity: O(n) because we iterate n times. 
Example 2: Linear Search 
java 
int[] numbers = {10, 20, 30, 40, 50}; 
int target = 40; 
int foundIndex = -1; 
 
for (int i = 0; i < numbers.length; i++) {
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
if (numbers[i] == target) { 
        foundIndex = i; 
        break; // Optimization: stop searching once found 
    } 
} 
// Time Complexity: O(n). Best case is O(1) (if target is first), worst case is O(n). 
2.3 Quadratic Array Algorithms (O(n^2)) 
When you place a loop inside another loop, you get quadratic time complexity. For every 
iteration of the outer loop, the inner loop runs completely. 
java 
int[ ] arr = {1, 2, 3, 4, 5}; 
 
// Comparing every element with every other element 
for (int i = 0; i < arr.length; i++) { 
    for (int j = 0; j < arr.length; j++) { 
        System.out.println(arr[i] + " " + arr[j]); 
    } 
} 
// If n=5, the inner loop runs 5 times for each of the 5 outer loops. 5 * 5 = 25 operations. 
// Time Complexity: O(n^2). 
Why this matters in Fintech: 
If you process 10,000 M-Pesa transactions: 
• An O(n) algorithm takes 10,000 operations (milliseconds). 
• An O(n^2) algorithm takes 100,000,000 operations (could take seconds or minutes, 
causing a system timeout!).
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
PART 3: Multidimensional Arrays 
3.1 2D Arrays 
A 2D array is an "array of arrays." It is used to represent tables, grids, or matrices (like an Excel 
spreadsheet). 
java 
// Create a 3x3 grid (3 rows, 3 columns) 
int[][] matrix = { 
    {1, 2, 3}, // Row 0 
    {4, 5, 6}, // Row 1 
    {7, 8, 9}  // Row 2 
}; 
 
// Access the number 6 (Row 1, Column 2) 
System.out.println(matrix[1][2]);  
To iterate through a 2D array, you need nested loops: 
java 
for (int row = 0; row < matrix.length; row++) {         // Outer loop for rows 
    for (int col = 0; col < matrix[row].length; col++) { // Inner loop for columns 
        System.out.print(matrix[row][col] + " "); 
    } 
    System.out.println(); // Move to next line after each row 
} 
 
PART 4: Introduction to ArrayLists 
4.1 What is an ArrayList? 
While arrays have a fixed size, an ArrayList is a dynamic data structure that can grow and shrink 
automatically as you add or remove elements. It is part of the java.util package.
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
java 
import java.util.ArrayList; 
4.2 ArrayLists vs. Primitives (Wrapper Classes) 
Important Rule: ArrayLists cannot store primitive types (int, double, char). They can only store 
Objects. To store numbers, you must use Wrapper Classes: 
• int → Integer 
• double → Double 
• char → Character 
• boolean → Boolean 
(Note: Java handles the conversion between int and Integer automatically. This is called 
Autoboxing). 
java 
// WRONG: ArrayList<int> numbers = new ArrayList<>(); 
// CORRECT: 
ArrayList<Integer> numbers = new ArrayList<>(); 
4.3 Common ArrayList Methods 
Method Description Example 
add(element) Adds to the end list.add("Alice"); 
add(index, element) Inserts at a specific index list.add(0, "Bob"); 
get(index) Retrieves the element list.get(1); 
set(index, element) Replaces an element list.set(1, "Charlie"); 
remove(index) Removes element at index list.remove(0);
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
Method Description Example 
remove(Object) Removes first matching object list.remove("Bob"); 
size() Returns number of elements list.size(); 
contains(Object) Checks if element exists list.contains("Alice"); 
 
PART 5: Arrays vs. ArrayLists – Trade-offs (LO2) 
You must evaluate when to use an Array and when to use an ArrayList. 
Feature Array ArrayList 
Size Fixed (must know upfront) Dynamic (grows/shrinks) 
Data Types Primitives and Objects Objects only (Wrapper classes) 
Length Property .length .size() 
Performance Faster (less memory overhead) Slightly slower (resizing costs) 
Search 
Methods Must write custom loop Built-in methods like .contains() 
Memory Usage Less memory More memory (maintains internal array) 
When to use an Array: 
1. You know exactly how many elements you need. 
2. You are storing primitive types (to save memory and boost speed).
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
3. You are dealing with multi-dimensional data (matrices, grids). 
When to use an ArrayList: 
1. You don't know how many elements you will have (e.g., user input). 
2. You need to frequently add or remove items from the middle of the list. 
3. You want to take advantage of built-in methods like .sort(), .contains(), .remove(). 
 
PART 6: Debugging Array Errors (LO3) 
6.1 The ArrayIndexOutOfBoundsException 
This is the most common error when working with arrays. It occurs when you try to access an 
index that does not exist. 
The Golden Rule: 
If an array has a length of n, the valid indices are 0 to n-1. 
• Valid: 0, 1, 2, ..., n-1 
• Invalid: n, n+1, -1 
6.2 Common Causes and Fixes 
Error 1: Off-by-One in Loop Condition 
java 
int[] arr = {10, 20, 30, 40, 50}; 
 
// BUG: i <= arr.length allows i to reach 5. The last valid index is 4. 
for (int i = 0; i <= arr.length; i++) { 
    System.out.println(arr[i]); // CRASH when i = 5 
} 
 
// FIX: Use strictly less than (<) 
for (int i = 0; i < arr.length; i++) { 
    System.out.println(arr[i]);
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
} 
Error 2: Hardcoding the Length 
java 
// BUG: Hardcoding index 5 when the array might change size. 
System.out.println(arr[5]);  
 
// FIX: Always use arr.length - 1 for the last element. 
System.out.println(arr[arr.length - 1]); 
6.3 Simulating Loop Conditions (Tracing) 
When debugging, write down the state of the loop on paper. 
• i = 0 → arr[0] (OK) 
• i = 4 → arr[4] (OK) 
• i = 5 → arr[5] (CRASH - index out of bounds) 
 
PART 7: Designing Applications with Arrays and ArrayLists (LO4) 
When designing a real-world application, you often mix Arrays (for fixed data) and ArrayLists (for 
dynamic data). 
Design Scenario: Student Roster Manager 
• Fixed Data: The subjects offered (Math, English, Science). This will not change during the 
program. Use a String Array. 
• Dynamic Data: The student names and their marks. Students can be enrolled or 
removed at any time. Use an ArrayList. 
Example Architecture: 
java 
import java.util.ArrayList; 
 
public class RosterManager {
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
// FIXED DATA: Array 
    String[] subjects = {"Math", "English", "Science"}; 
 
    // DYNAMIC DATA: ArrayLists 
    ArrayList<String> studentNames = new ArrayList<>(); 
    ArrayList<int[]> studentMarks = new ArrayList<>(); 
     
    // ... Add methods to add students, remove students, calculate averages, etc. 
} 
 
PART 8: Summary and Key Takeaways 
1. Arrays are fixed-size, memory-efficient, and store primitives/objects. 
2. ArrayLists are dynamic, built for object collections, and have many built-in methods. 
3. O(n) algorithms loop through the array once. O(n^2) algorithms use nested loops. 
Always aim for O(n) when possible. 
4. ArrayIndexOutOfBoundsException happens when you access < 0 or >= length. Always 
use < array.length in loops. 
5. Real-world systems use both: Arrays for fixed configurations and ArrayLists for dynamic 
records. 
 
✓ Key Terms Glossary 
Term Definition 
Array Fixed-size container for elements of the same type 
Index Position of an element (starts at 0)
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
Term Definition 
Length Number of elements in an array (.length) 
2D Array An array of arrays (a grid) 
ArrayList A dynamic-size collection from java.util 
Wrapper Class Object version of a primitive (e.g., Integer for int) 
Autoboxing Auto-conversion of primitive to wrapper class 
O(n) Linear time complexity 
O(n^2) Quadratic time complexity 
ArrayIndexOutOfBoundsException Error thrown for invalid index access 
 
Self-Assessment Questions 
1. What is the index of the last element in an array of length 10? 
2. How do you find the length of an array vs. an ArrayList? 
3. Why can't an ArrayList store int directly? 
4. What is the time complexity of finding the maximum value in an array? Why? 
5. If a loop condition is i <= arr.length, what error will occur? 
6. Write a snippet to safely print the last element of an array named data. 
7. When should you use an Array over an ArrayList? 
8. What is the purpose of the enhanced for loop?
```

</details>
