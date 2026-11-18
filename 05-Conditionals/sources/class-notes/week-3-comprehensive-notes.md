# Week 3 - Comprehensive Notes

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 3 - Comprehensive Notes.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 3 – Control Flow: Conditionals 
Course: Object-Oriented Programming (Java) 
Module 3: Controlling Program Flow 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Design a decision structure that handles multiple conditions using nested if-else or 
switch appropriately. 
2. Analyze complex boolean expressions to determine all possible execution paths. 
3. Evaluate the readability and efficiency of different conditional structures for the same 
logic. 
4. Debug a faulty conditional statement by tracing execution with various test inputs. 
 
PART 1: Introduction to Decision Making 
1.1 Why Programs Need to Make Decisions 
A program that always does the same thing regardless of input is not very useful. Real-world 
applications must respond differently to different situations: 
Application Decision 
M-Pesa Is the balance sufficient? → Approve or decline transaction 
Bank ATM Is the PIN correct? → Allow or deny access 
E-commerce Is the item in stock? → Add to cart or show out of stock 
Hospital System Is the patient's temperature high? → Alert doctor or no action 
Conditional statements allow programs to make these decisions.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
1.2 Boolean Expressions: The Foundation of Decisions 
Every decision in Java is based on a boolean expression – an expression that evaluates to either 
true or false. 
Relational Operators 
Operator Meaning Example Result 
== Equal to 5 == 5 true 
!= Not equal to 5 != 3 true 
> Greater than 5 > 3 true 
< Less than 5 < 3 false 
>= Greater than or equal 5 >= 5 true 
<= Less than or equal 5 <= 3 false 
Logical Operators 
Operator Name Rule Example Result 
&& AND True only if BOTH are true true && false false 
|| OR True if AT LEAST ONE is true true || false true 
! NOT Reverses the value !true false
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Truth Tables 
AND (&&) 
A B A && B 
true true true 
true false false 
false true false 
false false false 
OR (||) 
A B A || B 
true true true 
true false true 
false true true 
false false false 
NOT (!) 
A !A 
true false 
false true
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
PART 2: The if Statement 
2.1 Simple if Statement 
The if statement executes a block of code only if a condition is true. 
Syntax 
java 
if (condition) { 
    // Code to execute if condition is true 
} 
Example 
java 
// Declare a variable for temperature. 
int temperature = 38; 
 
// Check if temperature is above 37.5 (fever). 
if (temperature > 37.5) { 
    // This line only runs if the condition is true. 
    System.out.println("Warning: Patient has a fever!"); 
} 
Output: Warning: Patient has a fever! 
Flowchart
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
2.2 if-else Statement 
The if-else statement provides an alternative path when the condition is false. 
Syntax 
java 
if (condition) { 
    // Code to execute if condition is true 
} else { 
    // Code to execute if condition is false 
} 
Example 
java 
// Declare a variable for age. 
int age = 16; 
 
// Check if age is 18 or above.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
if (age >= 18) { 
    // This runs if age >= 18. 
    System.out.println("You are eligible to vote."); 
} else { 
    // This runs if age < 18. 
    System.out.println("You are NOT eligible to vote."); 
} 
Output: You are NOT eligible to vote. 
Flowchart 
 
 
 
2.3 if-else-if Ladder 
The if-else-if ladder handles multiple mutually exclusive conditions. 
Syntax 
java
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
if (condition1) { 
    // Code if condition1 is true 
} else if (condition2) { 
    // Code if condition1 is false AND condition2 is true 
} else if (condition3) { 
    // Code if condition1 and condition2 are false AND condition3 is true 
} else { 
    // Code if all conditions are false 
} 
Example: Grade Calculator 
java 
// Declare a variable for marks. 
int marks = 75; 
 
// Check conditions in order from highest to lowest. 
if (marks >= 70) { 
    System.out.println("Grade: A"); 
} else if (marks >= 60) { 
    System.out.println("Grade: B"); 
} else if (marks >= 50) { 
    System.out.println("Grade: C"); 
} else if (marks >= 40) { 
    System.out.println("Grade: D"); 
} else { 
    System.out.println("Grade: F (Fail)"); 
}
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
Output: Grade: B 
Important: Order Matters! 
Conditions are checked top to bottom. Once a condition is true, the rest are skipped. 
Wrong Order: 
java 
if (marks >= 40) {        // This catches 75 first! 
    System.out.println("Grade: D"); 
} else if (marks >= 70) { // Never reached for 75 
    System.out.println("Grade: A"); 
} 
// Output for marks=75: Grade D (WRONG!) 
Correct Order: 
java 
if (marks >= 70) {        // Check highest first 
    System.out.println("Grade: A"); 
} else if (marks >= 60) { 
    System.out.println("Grade: B"); 
} 
// Output for marks=75: Grade A (CORRECT!) 
 
2.4 Nested if-else 
A nested if-else is an if-else statement inside another if-else statement. Used when decisions 
depend on multiple factors. 
Syntax 
java 
if (outerCondition) {
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
// Outer condition is true 
    if (innerCondition) { 
        // Both outer and inner are true 
    } else { 
        // Outer is true, inner is false 
    } 
} else { 
    // Outer condition is false 
} 
Example: Student Admission 
java 
// Declare variables for student scores. 
double gpa = 3.8; 
int kcpeScore = 350; 
 
// Outer if: check if GPA meets minimum requirement. 
if (gpa >= 2.5) { 
    // GPA is sufficient. Now check KCPE score. 
    if (kcpeScore >= 300) { 
        System.out.println("Admitted: Both GPA and KCPE score meet requirements."); 
    } else { 
        System.out.println("Not admitted: KCPE score below 300."); 
    } 
} else { 
    System.out.println("Not admitted: GPA below 2.5."); 
}
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Output: Admitted: Both GPA and KCPE score meet requirements. 
 
PART 3: The switch Statement 
3.1 What is switch? 
The switch statement is a multi-way branch that selects one of many code blocks based on the 
exact value of a variable. 
Syntax 
java 
switch (expression) { 
    case value1: 
        // Code for value1 
        break; 
    case value2: 
        // Code for value2 
        break;
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
default: 
        // Code if no case matches 
        break; 
} 
How It Works 
1. The expression is evaluated once. 
2. Its value is compared with each case value. 
3. If a match is found, execution jumps to that case. 
4. break exits the switch (prevents fall-through). 
5. If no match, default executes (if present). 
 
3.2 Example: M-Pesa Menu 
java 
// Declare a variable for the user's menu choice. 
int choice = 2; 
 
// Use switch to handle the choice. 
switch (choice) { 
    case 1: 
        System.out.println("Check Balance selected."); 
        break; 
    case 2: 
        System.out.println("Send Money selected."); 
        break; 
    case 3: 
        System.out.println("Withdraw Cash selected.");
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
break; 
    case 4: 
        System.out.println("Buy Airtime selected."); 
        break; 
    default: 
        System.out.println("Invalid choice."); 
        break; 
} 
Output: Send Money selected. 
 
3.3 Important: break and fall-through 
Without break, execution falls through to the next case. 
Example Without break (Fall-through) 
java 
int day = 2; 
switch (day) { 
    case 1: 
        System.out.println("Monday"); 
    case 2: 
        System.out.println("Tuesday"); 
    case 3: 
        System.out.println("Wednesday"); 
    default: 
        System.out.println("Other day"); 
}
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
Output: 
text 
Tuesday 
Wednesday 
Other day 
Why? No break after case 2, so it continued to case 3 and default. 
When Fall-through is Useful 
Fall-through can be intentional when multiple cases share the same code: 
java 
char grade = 'B'; 
switch (grade) { 
    case 'A': 
    case 'B': 
    case 'C': 
        System.out.println("Pass"); 
        break; 
    case 'D': 
    case 'F': 
        System.out.println("Fail"); 
        break; 
    default: 
        System.out.println("Invalid grade"); 
} 
Output: Pass (because 'B' falls through to the same code as 'A' and 'C')
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
3.4 Supported Data Types for switch 
Data Type Supported? Example 
int    Yes switch (number) 
char    Yes switch (letter) 
String    Yes (Java 7+) switch (name) 
byte    Yes switch (smallNumber) 
short    Yes switch (mediumNumber) 
long   No Use if-else instead 
double   No Use if-else instead 
boolean   No Use if-else instead 
 
3.5 switch vs if-else-if: When to Use Which 
Criteria switch if-else-if 
Condition type Exact values only Any boolean expression 
Data types int, char, String, byte, short Any 
Ranges Not supported Supported (e.g., marks >= 70)
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
Criteria switch if-else-if 
Readability Cleaner for many values Better for complex conditions 
Performance Often faster (jump table) Sequential checks 
Best for Menus, day names, categories Ranges, complex logic 
 
PART 4: The Ternary Operator 
4.1 What is the Ternary Operator? 
The ternary operator (? :) is a shorthand for a simple if-else statement. 
Syntax 
java 
variable = (condition) ? valueIfTrue : valueIfFalse; 
Example 
java 
// Using if-else 
String eligibility; 
if (age >= 18) { 
    eligibility = "Eligible"; 
} else { 
    eligibility = "Not eligible"; 
} 
 
// Using ternary operator (same logic, one line) 
String eligibility = (age >= 18) ? "Eligible" : "Not eligible";
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
When to Use Ternary 
Use Ternary When... Use if-else When... 
The logic is simple (one condition) The logic is complex (multiple conditions) 
Both outcomes are simple values The outcomes involve multiple statements 
You want concise code You want maximum readability 
 
PART 5: Analyzing Boolean Expressions 
5.1 Operator Precedence for Booleans 
When multiple boolean operators appear in one expression, they are evaluated in this order: 
1. ! (NOT) – highest 
2. && (AND) 
3. || (OR) – lowest 
Example 
java 
boolean result = true || false && false; 
// Step 1: false && false = false (AND before OR) 
// Step 2: true || false = true 
// Result: true 
Using Parentheses for Clarity 
java 
// Confusing 
boolean result1 = a && b || c && d;
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
// Clear - same logic, but explicit 
boolean result2 = (a && b) || (c && d); 
 
5.2 Short-Circuit Evaluation 
Java uses short-circuit evaluation: 
• &&: If the left side is false, the right side is NOT evaluated. 
• ||: If the left side is true, the right side is NOT evaluated. 
Example 
java 
int x = 5; 
 
// x > 10 is false, so x++ is NOT evaluated 
boolean result = (x > 10) && (x++ > 0); 
 
System.out.println(x); // Output: 5 (not 6) 
Why Short-Circuit Matters 
1. Performance – Skips unnecessary evaluations. 
2. Safety – Prevents errors (e.g., null pointer exceptions). 
java 
String name = null; 
 
// Safe: if name is null, the second condition is not evaluated 
if (name != null && name.length() > 0) { 
    System.out.println("Name is not empty"); 
}
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
5.3 Tracing Complex Boolean Expressions 
Step-by-Step Analysis 
java 
boolean result = (5 > 3) && (4 < 2) || (10 == 10); 
Step Expression Result 
1 5 > 3 true 
2 4 < 2 false 
3 (true) && (false) false 
4 10 == 10 true 
5 false || true true 
Final result: true 
Another Example 
java 
boolean result = !(5 > 3) || (4 < 2) && (10 == 10); 
Step Expression Result 
1 5 > 3 true 
2 !(true) false 
3 4 < 2 false 
4 10 == 10 true
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
Step Expression Result 
5 false && true false 
6 false || false false 
Final result: false 
 
PART 6: Debugging Conditional Statements 
6.1 Common Conditional Errors 
Error Example Problem Fix 
= instead 
of == if (x = 5) Assignment, not comparison if (x == 5) 
&& vs || if (x > 0 || x < 10) Always true if (x > 0 && x < 10) 
Missing 
braces 
if (x > 0) System.out.println("A"); 
System.out.println("B"); "B" always prints Add { } 
Off-by-
one if (x > 18) should be >= 18 Boundary error Use correct operator 
Wrong 
order if (marks >= 40) before >= 70 Wrong grade Check highest first 
Missing 
break case 1: ... case 2: ... Fall-through Add break
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
6.2 Debugging Process 
Step 1: Read the Code Carefully 
Understand what the code is supposed to do. 
Step 2: Trace with Test Inputs 
Use a trace table to track variable values. 
Example: 
java 
int age = 20; 
if (age >= 18 || age <= 65) { 
    System.out.println("Working age"); 
} else { 
    System.out.println("Not working age"); 
} 
Input Condition Result Correct? 
age = 10 10 >= 18 || 10 <= 65 true   No 
age = 20 20 >= 18 || 20 <= 65 true    Yes 
age = 70 70 >= 18 || 70 <= 65 true   No 
Bug identified: Used || instead of &&. 
Step 3: Fix the Error 
java 
if (age >= 18 && age <= 65) { 
    System.out.println("Working age"); 
} else {
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
System.out.println("Not working age"); 
} 
Step 4: Re-test 
Verify the fix with all test inputs. 
 
6.3 Using a Debugger 
A debugger allows you to: 
• Set breakpoints 
• Step through code line by line 
• Inspect variable values 
• Evaluate expressions 
In VS Code: 
1. Click to the left of a line number to set a breakpoint (red dot) 
2. Click Run and Debug 
3. Use Step Over (F10) to execute line by line 
4. Hover over variables to see their values 
 
PART 7: Summary and Key Takeaways 
7.1 Learning Outcome 1 Summary 
Structure Best For Example 
if Single condition if (age >= 18) 
if-else Two outcomes if (pass) ... else ... 
if-else-if Multiple ranges Grade calculation
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
Structure Best For Example 
Nested if-else Sequential validation Admission criteria 
switch Exact values Menu options 
Ternary Simple true/false (x > 0) ? "Positive" : "Negative" 
 
7.2 Learning Outcome 2 Summary 
Concept Key Point 
Boolean operators && (AND), || (OR), ! (NOT) 
Precedence ! > && > || 
Short-circuit && stops if left is false; || stops if left is true 
Tracing Use a table to track intermediate results 
 
7.3 Learning Outcome 3 Summary 
Criteria switch if-else-if 
Conditions Exact values Any boolean expression 
Ranges Not supported Supported 
Readability Clean for many values Better for complex logic
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
Criteria switch if-else-if 
Performance Faster (jump table) Sequential 
 
7.4 Learning Outcome 4 Summary 
Debugging Step Action 
1. Read Understand intended behavior 
2. Trace Use test inputs and track values 
3. Identify Find the deviation 
4. Fix Correct the condition 
5. Re-test Verify with all inputs 
 
7.5 Key Terms Glossary 
Term Definition 
Conditional A statement that makes a decision 
Boolean expression Expression that evaluates to true or false 
if Executes code if condition is true 
if-else Executes one block if true, another if false
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
Term Definition 
if-else-if Chain of conditions checked in order 
Nested if-else if-else inside another if-else 
switch Multi-way branch based on exact value 
case A value to match in switch 
default Executes if no case matches 
break Exits the switch 
Fall-through Executing next case without break 
Ternary operator Shorthand for if-else (? :) 
Short-circuit Skipping evaluation when result is known 
Trace Manually following code execution 
Debug Finding and fixing errors 
 
7.6 Self-Assessment Questions 
Answer these in your notebook: 
1. What is the difference between if-else-if and switch? 
2. When would you use nested if-else? 
3. What does the break statement do in a switch?
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
4. What is fall-through? Give an example. 
5. What is the ternary operator? Write an example. 
6. What is short-circuit evaluation? 
7. Evaluate: (5 > 3) && (4 < 2) || (10 == 10) 
8. Evaluate: !(5 > 3) || (4 < 2) && (10 == 10) 
9. What is the bug in: if (x > 0 || x < 10)? 
10. How would you debug a faulty conditional? 
 
7.7 Practical Checklist 
Before moving to Week 4, ensure you can: 
• □ Write if-else-if statements for multiple conditions 
• □ Use nested if-else for validation and decision-making 
• □ Use switch statements for menu-driven programs 
• □ Use the ternary operator for simple conditions 
• □ Analyze complex boolean expressions 
• □ Evaluate the readability and efficiency of different conditional structures 
• □ Debug faulty conditional statements 
• □ Push code to GitHub 
 
7.8 Additional Resources 
Topic Resource 
if-else https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html 
switch https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
Topic Resource 
Operators https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html 
Debugging https://code.visualstudio.com/docs/editor/debugging 
 
END OF WEEK 3 COMPREHENSIVE NOTES 
"First, solve the problem. Then, write the code." – John Johnson 
 
Instructor Note: These notes are designed for self-paced learning. Read each section, run the 
code examples, and complete the self-assessment questions before moving to Week 4. I 
encourage you to experiment with the code – change values, add new conditions, and see what 
happens. Learning by doing is the most effective approach.
```

</details>
