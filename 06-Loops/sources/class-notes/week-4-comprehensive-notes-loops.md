# Week 4 - Comprehensive Notes - Loops

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 4 - Comprehensive Notes - Loops.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 4 – Control Flow: Loops 
Course: Object-Oriented Programming (Java) 
Module 3: Controlling Program Flow (Loops) 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Analyze the loop efficiency of different algorithms (linear vs nested loops) by counting 
iterations. 
2. Choose the appropriate loop type (for, while, do-while) for different repetition scenarios. 
3. Debug infinite loops by tracing variable updates and loop conditions. 
4. Create a program that uses nested loops to generate complex patterns (e.g., triangle, 
pyramid, multiplication table). 
 
PART 1: Introduction to Loops 
1.1 What is a Loop? 
A loop is a control structure that repeats a block of code multiple times based on a condition. 
Loops are fundamental to programming because they allow you to perform repetitive tasks 
efficiently without duplicating code. 
Real-World Analogy 
Think of a loop like a washing machine cycle: 
• Condition: Is the clothes still dirty? 
• Action: Wash, rinse, spin 
• Repeat: Until clothes are clean (condition becomes false) 
Or like stirring a pot of food: 
• Condition: Is the food mixed well enough? 
• Action: Stir once 
• Repeat: Until well mixed
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Why Loops Matter in Fintech 
Scenario Without Loops With Loops 
Process 1,000 M-Pesa transactions Copy-paste code 1,000 times One loop, 1,000 iterations 
Validate user input until correct Multiple if-else statements One while loop 
Generate monthly statements for all 
customers Manual repetition One loop through customer list 
Calculate interest for 12 months Write 12 calculations One for loop, 12 iterations 
The Four Components of Every Loop 
Every loop must have: 
Component Purpose Example 
Initialization Set starting value int i = 1; 
Condition Determine when to stop i <= 10; 
Body Code to repeat System.out.println(i); 
Update Change loop variable i++; 
Critical Rule: The update must move the loop variable toward the termination condition. If not, 
you get an infinite loop.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
PART 2: The while Loop 
2.1 Syntax and Structure 
java 
while (condition) { 
    // Code to repeat 
    // Update statement(s) 
} 
How It Works 
1. Check the condition. 
2. If true, execute the loop body. 
3. After the body, go back to step 1. 
4. If false, exit the loop. 
Key Point: The condition is checked before each iteration. If it's initially false, the loop body may 
not execute at all. 
Flowchart 
 
2.2 Example: Print Numbers 1 to 5 
java 
// Declare a variable to control the loop.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
int i = 1; 
 
// Check if i is less than or equal to 5. 
while (i <= 5) { 
    // Print the current value of i. 
    System.out.println("Number: " + i); 
     
    // Increment i by 1. 
    // This is CRITICAL - without it, the loop runs forever. 
    i++; 
} 
Output: 
Number: 1 
Number: 2 
Number: 3 
Number: 4 
Number: 5 
Trace Table 
Iteration i (before) Condition Output i (after) 
1 1 true 1 2 
2 2 true 2 3 
3 3 true 3 4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
Iteration i (before) Condition Output i (after) 
4 4 true 4 5 
5 5 true 5 6 
6 6 false - - 
 
2.3 Example: Validating User Input 
java 
// Import Scanner for user input. 
import java.util.Scanner; 
public class InputValidation { 
    public static void main(String[] args) { 
        // Create a Scanner object. 
        Scanner scanner = new Scanner(System.in); 
         
        // Declare a variable for the balance. 
        int balance = 0; 
         
        // Continue asking until a positive amount is entered. 
        while (balance <= 0) { 
            // Prompt the user for a deposit amount. 
            System.out.print("Enter positive deposit amount: "); 
             
            // Read the user's input.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
balance = scanner.nextInt(); 
             
            // Check if the input is invalid. 
            if (balance <= 0) { 
                // Display error message. 
                System.out.println("Error: Amount must be positive!"); 
            } 
        } 
         
        // Display success message. 
        System.out.println("Deposit successful: KSh " + balance); 
         
        // Close the scanner. 
        scanner.close(); 
    } 
} 
When to Use while 
Scenario Why while is Appropriate 
Unknown number of iterations You don't know how many attempts the user needs 
Condition checked before execution Avoid running the loop if not needed 
Input validation Continue until valid input is received 
Reading from a file until EOF Don't know how many lines exist
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
PART 3: The do-while Loop 
3.1 Syntax and Structure 
java 
do { 
    // Code to repeat 
    // Update statement(s) 
} while (condition); 
How It Works 
1. Execute the loop body once. 
2. Check the condition. 
3. If true, go back to step 1. 
4. If false, exit the loop. 
Key Point: The loop body executes at least once, even if the condition is initially false. 
Flowchart 
  
 
3.2 Example: Menu-Driven Program 
java 
// Import Scanner for user input. 
import java.util.Scanner;
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
public class MenuDemo { 
    public static void main(String[] args) { 
        // Create a Scanner object. 
        Scanner scanner = new Scanner(System.in); 
         
        // Declare a variable for the user's choice. 
        int choice; 
         
        // Display menu at least once, then repeat until exit. 
        do { 
            // Display menu options. 
            System.out.println("\n=== M-PESA MENU ==="); 
            System.out.println("1. Check Balance"); 
            System.out.println("2. Send Money"); 
            System.out.println("3. Withdraw"); 
            System.out.println("4. Exit"); 
            System.out.print("Enter choice: "); 
             
            // Read the user's choice. 
            choice = scanner.nextInt(); 
             
            // Handle the choice using switch. 
            switch (choice) { 
                case 1: 
                    System.out.println("Balance: KSh 10,000");
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
break; 
                case 2: 
                    System.out.println("Send Money selected"); 
                    break; 
                case 3: 
                    System.out.println("Withdraw selected"); 
                    break; 
                case 4: 
                    System.out.println("Goodbye!"); 
                    break; 
                default: 
                    System.out.println("Invalid choice"); 
            } 
        } while (choice != 4); // Continue until user chooses 4. 
         
        // Close the scanner. 
        scanner.close(); 
    } 
}
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Difference Between while and do-while 
Aspect while do-while 
Condition checked Before body After body 
Minimum executions 0 1 
Syntax while (cond) { } do { } while (cond); 
Best for Unknown iterations Menu systems 
 
3.3 When to Use do-while 
Scenario Why do-while is Appropriate 
Menu systems Menu must appear at least once 
Input validation with retry Ask for input, then check if valid 
Game loops Play game, then ask if player wants to continue 
Processing at least one item At least one item must be processed 
 
PART 4: The for Loop 
4.1 Syntax and Structure 
java 
for (initialization; condition; update) { 
    // Code to repeat 
}
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
Components 
Component Purpose Example 
Initialization Runs once at the beginning int i = 1 
Condition Checked before each iteration i <= 10 
Update Runs after each iteration i++ 
How It Works 
1. Execute initialization (once). 
2. Check condition. 
3. If true, execute body. 
4. Execute update. 
5. Go back to step 2. 
6. If false, exit loop. 
Flowchart
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
4.2 Example: Print Numbers 1 to 5 
java 
// for (initialization; condition; update) 
for (int i = 1; i <= 5; i++) { 
    // Print the current value of i. 
    System.out.println("Number: " + i); 
} 
Output: 
Number: 1 
Number: 2 
Number: 3 
Number: 4 
Number: 5 
 
4.3 Variations of the for Loop 
Counting Down 
java 
// Start at 10, end at 1, decrement by 1 
for (int i = 10; i >= 1; i--) { 
    System.out.print(i + " "); 
} 
// Output: 10 9 8 7 6 5 4 3 2 1 
Incrementing by 2 
java 
// Print even numbers from 2 to 20 
for (int i = 2; i <= 20; i += 2) {
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
System.out.print(i + " "); 
} 
// Output: 2 4 6 8 10 12 14 16 18 20 
Multiple Variables 
java 
// Two variables in one loop 
for (int i = 0, j = 10; i < j; i++, j--) { 
    System.out.println("i = " + i + ", j = " + j); 
} 
// Output: 
// i = 0, j = 10 
// i = 1, j = 9 
// i = 2, j = 8 
// i = 3, j = 7 
// i = 4, j = 6 
Infinite for Loop 
java 
// Infinite loop (avoid unless intentional) 
for (;;) { 
    System.out.println("Forever"); 
} 
 
4.4 Enhanced for Loop (for-each) 
The enhanced for loop simplifies iteration through arrays and collections.
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
Syntax 
java 
for (Type variable : collection) { 
    // Code to repeat for each element 
} 
Example 
java 
// Declare and initialize an array of names. 
String[] students = {"Alice", "Bob", "Charlie", "Diana"}; 
 
// Enhanced for loop: for each student in students 
for (String student : students) { 
    System.out.println("Student: " + student); 
} 
Output: 
Student: Alice 
Student: Bob 
Student: Charlie 
Student: Diana 
Traditional vs Enhanced for Loop 
Aspect Traditional for Enhanced for 
Syntax for (int i = 0; i < arr.length; i++) for (String s : arr) 
Access to index Yes (i) No
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
Aspect Traditional for Enhanced for 
Modify elements Yes (arr[i] = ...) No (read-only) 
Readability Less readable More readable 
Best for When index is needed Simple iteration 
 
4.5 When to Use for 
Scenario Why for is Appropriate 
Known number of iterations Counter-controlled repetition 
Iterating through arrays Enhanced for is clean 
Counting up or down Natural with initialization, condition, update 
Processing a fixed range Clear and concise 
 
PART 5: Nested Loops 
5.1 What are Nested Loops? 
A nested loop is a loop inside another loop. The inner loop completes all its iterations for each 
single iteration of the outer loop. 
Syntax 
java 
for (int i = 0; i < 3; i++) { 
    for (int j = 0; j < 2; j++) { 
        System.out.println("i=" + i + ", j=" + j);
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
} 
} 
Output: 
i=0, j=0 
i=0, j=1 
i=1, j=0 
i=1, j=1 
i=2, j=0 
i=2, j=1 
How Nested Loops Work 
Outer Iteration Inner Iterations Total 
i=0 j=0, j=1 2 
i=1 j=0, j=1 2 
i=2 j=0, j=1 2 
Total  6 
Formula: Total iterations = Outer count × Inner count = 3 × 2 = 6 
 
5.2 Pattern 1: Right Triangle 
java 
// Print a right triangle of stars. 
int rows = 5; 
// Outer loop controls the number of rows. 
for (int i = 1; i <= rows; i++) {
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
// Inner loop prints stars for the current row. 
    for (int j = 1; j <= i; j++) { 
        System.out.print("*"); 
    } 
    // Move to the next line. 
    System.out.println(); 
} 
Output: 
* 
** 
*** 
**** 
***** 
Analysis 
Row (i) Stars Printed Inner Loop Iterations 
1 * 1 
2 ** 2 
3 *** 3 
4 **** 4 
5 ***** 5 
Total  15
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
5.3 Pattern 2: Inverted Right Triangle 
java 
// Print an inverted right triangle. 
int rows = 5; 
// Outer loop counts down from rows to 1. 
for (int i = rows; i >= 1; i--) { 
    // Inner loop prints i stars. 
    for (int j = 1; j <= i; j++) { 
        System.out.print("*"); 
    } 
    System.out.println(); 
} 
Output: 
***** 
**** 
*** 
** 
* 
 
5.4 Pattern 3: Pyramid 
java 
// Print a pyramid. 
int rows = 5; 
// Outer loop controls the number of rows. 
for (int i = 1; i <= rows; i++) { 
    // First inner loop: print spaces for alignment.
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
// Number of spaces = rows - i 
    for (int j = 1; j <= rows - i; j++) { 
        System.out.print(" "); 
    } 
     
    // Second inner loop: print stars. 
    // Number of stars = 2 * i - 1 
    for (int k = 1; k <= 2 * i - 1; k++) { 
        System.out.print("*"); 
    } 
    System.out.println(); 
} 
Output: 
    * 
   *** 
  ***** 
 ******* 
********* 
Analysis 
Row (i) Spaces (rows-i) Stars (2i-1) Output 
1 4 1 * 
2 3 3 *** 
3 2 5 *****
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
Row (i) Spaces (rows-i) Stars (2i-1) Output 
4 1 7 ******* 
5 0 9 ********* 
 
5.5 Pattern 4: Number Triangle 
java 
// Print a number triangle. 
int rows = 5; 
// Outer loop controls the number of rows. 
for (int i = 1; i <= rows; i++) { 
    // Inner loop prints numbers from 1 to i. 
    for (int j = 1; j <= i; j++) { 
        System.out.print(j + " "); 
    } 
    System.out.println(); 
} 
Output: 
1  
1 2  
1 2 3  
1 2 3 4  
1 2 3 4 5
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
5.6 Pattern 5: Multiplication Table 
java 
// Print a multiplication table. 
int n = 5; 
// Print header row. 
System.out.print("    "); 
for (int i = 1; i <= n; i++) { 
    System.out.printf("%4d", i); 
} 
System.out.println(); 
// Print separator. 
System.out.print("    "); 
for (int i = 1; i <= n; i++) { 
    System.out.print("----"); 
} 
System.out.println(); 
 
// Print each row. 
for (int i = 1; i <= n; i++) { 
    // Print row header. 
    System.out.printf("%3d|", i); 
     
    // Print products. 
    for (int j = 1; j <= n; j++) { 
        System.out.printf("%4d", i * j); 
    }
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
System.out.println(); 
} 
Output: 
       1   2   3   4   5 
    -------------------- 
  1|   1   2   3   4   5 
  2|   2   4   6   8  10 
  3|   3   6   9  12  15 
  4|   4   8  12  16  20 
  5|   5  10  15  20  25 
 
5.7 Loop Efficiency Analysis 
Linear vs Nested Loops 
Loop Type Structure Iterations (n=10) Iterations (n=100) Complexity 
Linear One loop 10 100 O(n) 
Nested 
(Square) 
Two nested loops, 
both n 100 10,000 O(n²) 
Triangular Inner loop depends on i 55 5,050 O(n² /2) 
Cubic Three nested loops 1,000 1,000,000 O(n³) 
Counting Iterations
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
Linear Loop: 
java 
for (int i = 0; i < n; i++) { } // n iterations 
Nested Loop (Square): 
java 
for (int i = 0; i < n; i++) { 
    for (int j = 0; j < n; j++) { } // n × n = n² iterations 
} 
Triangular Loop: 
java 
for (int i = 0; i < n; i++) { 
    for (int j = i; j < n; j++) { } // n + (n-1) + ... + 1 = n(n+1)/2 iterations 
} 
Why This Matters 
n O(n) O(n²) O(n³) 
10 10 100 1,000 
100 100 10,000 1,000,000 
1,000 1,000 1,000,000 1,000,000,000 
In fintech: Processing 1,000 transactions with a nested loop takes 1,000,000 operations. This 
could cause a timeout. A linear loop would take only 1,000 operations.
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
PART 6: break and continue Statements 
6.1 The break Statement 
The break statement exits the loop immediately, skipping all remaining iterations. 
Syntax 
java 
for (int i = 1; i <= 10; i++) { 
    if (i == 5) { 
        break; // Exit loop when i equals 5 
    } 
    System.out.println(i); 
} 
// Output: 1, 2, 3, 4 
Example: Finding a Value 
java 
// Array of numbers. 
int[] numbers = {10, 20, 30, 40, 50}; 
int target = 30; 
boolean found = false; 
 
// Search for the target value. 
for (int i = 0; i < numbers.length; i++) { 
    if (numbers[i] == target) { 
        System.out.println("Found " + target + " at index " + i); 
        found = true; 
        break; // Stop searching once found 
    }
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
} 
 
if (!found) { 
    System.out.println("Not found"); 
} 
Output: Found 30 at index 2 
When to Use break 
Scenario Why break is Useful 
Searching for an item Stop once found 
Error condition Exit loop immediately on error 
User cancels Exit menu loop when user exits 
 
6.2 The continue Statement 
The continue statement skips the current iteration and continues with the next one. 
Syntax 
java 
for (int i = 1; i <= 10; i++) { 
    if (i % 2 == 0) { 
        continue; // Skip even numbers 
    } 
    System.out.println(i); 
} 
// Output: 1, 3, 5, 7, 9
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
Example: Skipping Invalid Data 
java 
// Array with some invalid values. 
int[] values = {10, -5, 20, -3, 30, -1}; 
// Process only positive values. 
for (int value : values) { 
    if (value < 0) { 
        continue; // Skip negative numbers 
    } 
    System.out.println("Processing: " + value); 
} 
Output: 
Processing: 10 
Processing: 20 
Processing: 30 
break vs continue 
Statement Effect Example 
break Exits the loop entirely Found item; stop searching 
continue Skips to next iteration Skip invalid data; continue processing 
 
PART 7: Debugging Infinite Loops 
7.1 What is an Infinite Loop? 
An infinite loop is a loop that never terminates because its condition never becomes false. 
Why Infinite Loops Are Dangerous
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
• CPU usage: Consumes 100% CPU 
• Memory: May consume memory if allocating objects 
• Freezing: Application becomes unresponsive 
• Crashes: System may become unstable 
 
7.2 Common Causes of Infinite Loops 
Cause Example Fix 
Missing update while (x <= 5) { } Add x++ 
Wrong direction for (int i = 5; i >= 1; i++) Change to i-- 
Wrong condition while (x != 10) when x starts at 11 Use x < 10 
Semicolon after while while (x < 5); Remove semicolon 
Reassigning loop variable i = 0 inside loop Don't reassign 
 
7.3 Debugging Process 
Step 1: Read the Code 
Understand what the code is supposed to do. 
Step 2: Trace with Test Inputs 
Use a trace table to track variable values. 
Example Buggy Code: 
java 
int x = 1; 
while (x <= 5) {
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
System.out.println(x); 
    // Missing x++; 
} 
Trace Table: 
Iteration x (before) Condition Output x (after) 
1 1 true 1 1 
2 1 true 1 1 
3 1 true 1 1 
... ... ... ... ... 
Problem Identified: x never changes → condition always true → infinite loop. 
Step 3: Fix the Error 
java 
int x = 1; 
while (x <= 5) { 
    System.out.println(x); 
    x++; // Now x increments 
} 
Step 4: Re-test 
Verify the loop terminates correctly. 
 
7.4 Using a Debugger 
A debugger allows you to: 
• Set breakpoints
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
• Step through code line by line 
• Inspect variable values 
• Evaluate expressions 
In VS Code: 
1. Click to the left of a line number to set a breakpoint (red dot) 
2. Click Run and Debug 
3. Use Step Over (F10) to execute line by line 
4. Hover over variables to see their values 
 
PART 8: Loop Design Patterns 
8.1 Counter-Controlled Loop 
Used when you know exactly how many times to iterate. 
java 
// Print numbers 1 to 100 
for (int i = 1; i <= 100; i++) { 
    System.out.println(i); 
} 
 
8.2 Sentinel-Controlled Loop 
Used when you don't know how many times to iterate, and a special value terminates the loop. 
java 
// Read numbers until -1 is entered 
Scanner scanner = new Scanner(System.in); 
int input; 
do { 
    System.out.print("Enter a number (-1 to quit): ");
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
input = scanner.nextInt(); 
    if (input != -1) { 
        System.out.println("You entered: " + input); 
    } 
} while (input != -1); 
 
8.3 Flag-Controlled Loop 
Used when a boolean variable determines when to exit. 
java 
// Search for a value 
boolean found = false; 
int i = 0; 
while (!found && i < array.length) { 
    if (array[i] == target) { 
        found = true; 
    } 
    i++; 
} 
 
PART 9: Summary and Key Takeaways 
9.1 Learning Outcome 1 Summary 
Concept Key Point 
Linear loop (O(n)) Iterations grow proportionally with input 
Nested loop (O(n²)) Iterations grow with square of input
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
Concept Key Point 
Triangular loop n(n+1)/2 iterations 
Efficiency matters Nested loops can be slow for large n 
 
9.2 Learning Outcome 2 Summary 
Loop Type Best For Example 
while Unknown iterations Guessing game 
do-while Must execute at least once Menu system 
for Known iterations Print 1 to 10 
Enhanced for Iterating collections Process array elements 
 
9.3 Learning Outcome 3 Summary 
Debugging Step Action 
1. Read Understand intended behavior 
2. Trace Use test inputs and track values 
3. Identify Find where loop fails to progress 
4. Fix Ensure loop variable moves toward termination
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
Debugging Step Action 
5. Re-test Verify loop terminates 
 
9.4 Learning Outcome 4 Summary 
Pattern Logic Total Iterations 
Right Triangle Outer: rows; Inner: 1 to i n(n+1)/2 
Inverted Triangle Outer: rows down to 1; Inner: 1 to i n(n+1)/2 
Pyramid Outer: rows; Inner: spaces + stars n² 
Number Triangle Outer: rows; Inner: 1 to i n(n+1)/2 
Multiplication Table Outer: rows; Inner: columns n² 
 
9.5 Key Terms Glossary 
Term Definition 
Loop Control structure that repeats code 
Iteration One complete execution of loop body 
while loop Pre-test loop; condition checked before body 
do-while loop Post-test loop; condition checked after body
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
Term Definition 
for loop Counter-controlled loop 
Enhanced for loop Iterates through collections 
Nested loop Loop inside another loop 
Infinite loop Loop that never terminates 
break Exits loop immediately 
continue Skips to next iteration 
Sentinel value Special value that terminates loop 
Trace table Table for tracking variable values 
Time complexity Measure of algorithm performance 
O(n) Linear time 
O(n²) Quadratic time 
 
9.6 Self-Assessment Questions 
Answer these in your notebook: 
1. What are the four components of a loop? 
2. What is the difference between while and do-while? 
3. When would you use a for loop instead of a while loop?
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
4. What is an enhanced for loop? When would you use it? 
5. How many times does a nested loop execute? 
6. What is an infinite loop? How do you fix it? 
7. What does break do? What does continue do? 
8. How many iterations in a triangular loop when n=5? 
9. Write a for loop that prints even numbers from 2 to 20. 
10. Write a nested loop to print a right triangle of 5 rows. 
 
9.7 Practical Checklist 
Before moving to Week 5, ensure you can: 
• □ Write while loops for indefinite repetition 
• □ Write do-while loops for menu systems 
• □ Write for loops for counter-controlled repetition 
• □ Use enhanced for loops for collections 
• □ Create nested loops for patterns 
• □ Analyze loop efficiency (count iterations) 
• □ Debug infinite loops 
• □ Use break and continue appropriately 
• □ Push code to GitHub 
 
9.8 Additional Resources 
Topic Resource 
while loop https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html 
for loop https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
Topic Resource 
break/continue https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html 
Big-O analysis https://www.geeksforgeeks.org/analysis-algorithms-big-o-analysis/ 
 
END OF WEEK 4 COMPREHENSIVE NOTES 
"The best way to learn is by doing." – Anonymous 
 
Instructor Note: These notes are designed for self-paced learning. You should read each section, 
run the code examples, and complete the self-assessment questions before moving to Week 5. I 
encourage you to experiment with the code – change loop bounds, try different patterns, and 
see what happens. Learning by doing is the most effective approach.
```

</details>
