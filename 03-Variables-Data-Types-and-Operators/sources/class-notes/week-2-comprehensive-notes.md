# Week 2 - Comprehensive Notes

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 2 - Comprehensive Notes.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 2 – Java Fundamentals 
Course: Object-Oriented Programming (Java) 
Module 2: Java Fundamentals 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Choose appropriate data types for variables based on problem requirements (e.g., using 
double vs int for currency). 
2. Predict the output of expressions involving operator precedence and type conversion. 
3. Analyze a program to identify potential type mismatch errors before compilation. 
4. Construct a simple interactive program that accepts user input using Scanner and 
performs calculations. 
 
PART 1: Variables and Data Types 
1.1 What is a Variable? 
A variable is a named storage location in the computer's memory that holds a value. Think of it 
as a labeled box where you can store data. The label is the variable name, and the contents are 
the value. 
Real-World Analogy 
Imagine a warehouse with many boxes: 
• Each box has a label (variable name) – e.g., "CustomerName" 
• Each box holds something (value) – e.g., "Alice Wanjiku" 
• Each box has a size (data type) – e.g., small box for a name, large box for a population 
count 
Variable Declaration and Initialization 
java 
// Declaration: creating the variable (the box)
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
int age; 
 
// Initialization: assigning a value (putting something in the box) 
age = 20; 
 
// Declaration + Initialization in one statement 
int studentAge = 20; 
 
// Multiple variables of the same type 
int x = 10, y = 20, z = 30; 
 
1.2 Primitive Data Types in Java 
Java has eight primitive data types. These are the most basic types built into the language. 
Integer Types (Whole Numbers) 
Type Size Range Example When to Use 
byte 8 bits -128 to 127 byte age = 20; Small numbers to save memory 
short 16 bits -32,768 to 32,767 short year = 2026; Medium numbers 
int 32 bits -2.1 billion to 2.1 billion int population = 54000000; Most common integer type 
long 64 bits Very large long worldPop = 8000000000L; Very large numbers (note the 'L')
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Important: For long values, you must add an L suffix. Without it, Java treats the number as an 
int and may cause an error if the value exceeds the int range. 
java 
// Correct 
long worldPopulation = 8000000000L; 
 
// Incorrect - causes compilation error 
// long worldPopulation = 8000000000; 
Decimal Types (Floating-Point Numbers) 
Type Size Precision Example When to Use 
float 32 bits ~7 decimal digits float rate = 7.5f; Less precise decimals (note the 'f') 
double 64 bits ~15 decimal digits double balance = 15000.75; Most common decimal type 
Important: For float values, you must add an f suffix. Without it, Java treats the number as a 
double. 
java 
// Correct 
float interestRate = 7.5f; 
 
// Incorrect - causes compilation error 
// float interestRate = 7.5; 
 
// Correct - double is the default 
double accountBalance = 15000.75;
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Character Type 
Type Size Range Example When to Use 
char 16 bits 0 to 65,535 (Unicode) char grade = 'A'; Single characters 
Important: char values are enclosed in single quotes ('A'), not double quotes. 
java 
// Correct 
char grade = 'A'; 
char currencySymbol = 'K'; 
 
// Incorrect - double quotes create a String 
// char grade = "A"; 
Boolean Type 
Type Size Values Example When to Use 
boolean 1 bit true or false boolean isActive = true; True/false conditions 
java 
boolean isActive = true; 
boolean isVerified = false; 
boolean isEligible = (age >= 18); 
 
1.3 Reference Data Types 
String 
String is a reference type (not primitive) used for text. 
java
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
String studentName = "Alice Wanjiku"; 
String courseName = "Object-Oriented Programming"; 
String emptyString = ""; 
Key Difference: String starts with an uppercase 'S' because it is a class, not a primitive type. 
String vs char 
Aspect char String 
Quotes Single quotes 'A' Double quotes "A" 
Length Exactly one character Zero or more characters 
Type Primitive Reference (class) 
Example char grade = 'A'; String name = "Alice"; 
 
1.4 Choosing the Right Data Type 
Decision Guide 
If you need to store... Use... Example 
A person's age int int age = 25; 
A bank balance double double balance = 15000.75; 
A single letter grade char char grade = 'A'; 
Whether a customer is active boolean boolean isActive = true; 
A customer's name String String name = "Alice";
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
If you need to store... Use... Example 
World population long long population = 8000000000L; 
A percentage (less precise) float float rate = 7.5f; 
A phone number String String phone = "0712345678"; 
Why Phone Numbers Should Be String 
Phone numbers look like numbers, but they should be stored as String because: 
1. They can have leading zeros (e.g., "0712345678") 
2. They are not used in arithmetic calculations 
3. They may contain special characters (e.g., "+254712345678") 
java 
// Correct 
String phoneNumber = "0712345678"; 
// Incorrect - loses leading zero 
// int phoneNumber = 0712345678; // This is actually 712345678 
 
1.5 Variable Naming Rules and Conventions 
Rules (Must Follow) 
1. Must start with a letter, underscore (_), or dollar sign ($) 
2. Cannot start with a digit 
3. Cannot contain spaces or special characters (except _ and $) 
4. Cannot be a Java keyword (e.g., class, public, static) 
5. Case-sensitive (age and Age are different)
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
Conventions (Should Follow)] 
Element Convention Example 
Class PascalCase StudentRecord 
Method camelCase calculateArea() 
Variable camelCase studentName 
Constant UPPER_SNAKE_CASE MAX_VALUE 
Package Lowercase com.example 
Valid vs Invalid Variable Names 
Valid Invalid Reason 
studentName 2ndStudent Starts with digit 
_count my-variable Contains hyphen 
$price class Java keyword 
Age student name Contains space 
 
PART 2: Operators and Expressions 
2.1 What is an Operator? 
An operator is a symbol that performs an operation on one or more values (called operands). 
java 
int sum = 10 + 5;
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
//  + is the operator 
//  10 and 5 are operands 
//  sum is the result 
 
2.2 Arithmetic Operators 
Operator Name Example Result 
+ Addition 10 + 5 15 
- Subtraction 10 - 5 5 
* Multiplication 10 * 5 50 
/ Division 10 / 5 2 
% Modulus (remainder) 10 % 3 1 
Integer Division vs Decimal Division 
java 
// Integer division - decimal part is truncated 
int a = 17; 
int b = 5; 
int result1 = a / b; // 17 / 5 = 3 (not 3.4) 
 
// Decimal division - uses double 
double x = 17.0; 
double y = 5.0; 
double result2 = x / y; // 17.0 / 5.0 = 3.4
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
Modulus Operator (%) 
The modulus operator returns the remainder of a division. 
java 
int remainder = 17 % 5; // 17 ÷ 5 = 3 remainder 2 
System.out.println(remainder); // Output: 2 
Common uses of modulus: 
• Check if a number is even: num % 2 == 0 
• Check if a number is odd: num % 2 != 0 
• Cycle through values: index % arrayLength 
 
2.3 Relational Operators 
Relational operators compare two values and return a boolean (true or false). 
Operator Name Example Result 
== Equal to 10 == 5 false 
!= Not equal to 10 != 5 true 
> Greater than 10 > 5 true 
< Less than 10 < 5 false 
>= Greater than or equal 10 >= 10 true 
<= Less than or equal 10 <= 5 false
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Important: == vs = 
Operator Meaning Example 
= Assignment int x = 10; (assign 10 to x) 
== Comparison x == 10 (check if x equals 10) 
java 
int x = 10;      // Assignment 
boolean result = (x == 10); // Comparison - result is true 
 
2.4 Logical Operators 
Logical operators combine boolean expressions. 
Operator Name Example Result 
&& Logical AND true && false false 
|| Logical OR true || false True 
! Logical NOT !true False 
Truth Tables 
AND (&&) 
A B A && B 
true True true 
true false false
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
A B A && B 
false true False 
false false False 
OR (||) 
A B A || B 
True true True 
true false True 
false true True 
false false False 
NOT (!) 
A !A 
true False 
false True 
Short-Circuit Evaluation 
Java uses short-circuit evaluation for && and ||: 
• &&: If the left side is false, the right side is not evaluated 
• ||: If the left side is true, the right side is not evaluated 
java 
int x = 5;
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
boolean result = (x > 10) && (x++ > 0); 
// x > 10 is false, so x++ is NOT evaluated 
System.out.println(x); // Output: 5 (not 6) 
 
2.5 Increment and Decrement Operators 
Operator Name Meaning 
++ Increment Add 1 
- - Decrement Subtract 1 
Postfix vs Prefix 
Expression Name Behavior 
x++ Post-increment Use current value, then increment 
++x Pre-increment Increment first, then use new value 
x- - Post-decrement Use current value, then decrement 
- -x Pre-decrement Decrement first, then use new value 
Example 
java 
int x = 5; 
 
int a = x++; // a = 5, then x becomes 6 
System.out.println("a = " + a + ", x = " + x); // a = 5, x = 6
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
int b = ++x; // x becomes 7, then b = 7 
System.out.println("b = " + b + ", x = " + x); // b = 7, x = 7 
 
2.6 Operator Precedence 
Operator precedence determines the order in which operators are evaluated. 
Precedence Table (Highest to Lowest) 
Precedence Operators Associativity 
1 () [] . Left to right 
2 ++ -- ! ~ (unary) Right to left 
3 * / % Left to right 
4 + - Left to right 
5 << >> >>> Left to right 
6 < <= > >= instanceof Left to right 
7 == != Left to right 
8 & Left to right 
9 ^ Left to right 
10 | Left to right 
11 && Left to right
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
Precedence Operators Associativity 
12 || Left to right 
13 ? : (ternary) Right to left 
14 = += -= etc. Right to left 
Examples 
java 
// Example 1: Multiplication before addition 
int result1 = 10 + 5 * 2; 
// Step 1: 5 * 2 = 10 
// Step 2: 10 + 10 = 20 
System.out.println(result1); // 20 
 
// Example 2: Parentheses override precedence 
int result2 = (10 + 5) * 2; 
// Step 1: 10 + 5 = 15 
// Step 2: 15 * 2 = 30 
System.out.println(result2); // 30 
 
// Example 3: Modulus and multiplication 
int result3 = 20 % 3 + 4 * 2; 
// Step 1: 20 % 3 = 2 
// Step 2: 4 * 2 = 8 
// Step 3: 2 + 8 = 10
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
System.out.println(result3); // 10 
 
// Example 4: Relational and logical 
boolean result4 = 10 > 5 && 3 < 4; 
// Step 1: 10 > 5 = true 
// Step 2: 3 < 4 = true 
// Step 3: true && true = true 
System.out.println(result4); // true 
Best Practice: Use Parentheses 
Even when you know the precedence, use parentheses to make your intentions clear: 
java 
// Confusing 
int result = 10 + 5 * 2; 
 
// Clear 
int result = 10 + (5 * 2); 
 
PART 3: Type Conversion 
3.1 What is Type Conversion? 
Type conversion (also called type casting) is the process of converting a value from one data 
type to another. 
Two Types of Conversion 
1. Implicit casting (widening) - Automatic, no data loss 
2. Explicit casting (narrowing) - Manual, may cause data loss
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
3.2 Implicit Casting (Widening) 
Implicit casting happens automatically when converting from a smaller type to a larger type. 
Conversion Order (Small to Large) 
text 
byte → short → int → long → float → double 
      char → int 
Examples 
java 
// int to double (automatic) 
int intValue = 100; 
double doubleValue = intValue; // 100.0 
System.out.println(doubleValue); // 100.0 
 
// int to long (automatic) 
long longValue = intValue; // 100 
System.out.println(longValue); // 100 
 
// float to double (automatic) 
float floatValue = 3.14f; 
double doubleFromFloat = floatValue; // 3.14 
System.out.println(doubleFromFloat); // 3.14 
 
// char to int (automatic - uses Unicode value) 
char letter = 'A'; 
int asciiValue = letter; // 65 
System.out.println(asciiValue); // 65
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
3.3 Explicit Casting (Narrowing) 
Explicit casting is required when converting from a larger type to a smaller type. You must use 
the cast operator (type). 
Syntax 
java 
targetType variableName = (targetType) value; 
Examples 
java 
// double to int (manual - decimal part truncated) 
double pi = 3.14159; 
int truncatedPi = (int) pi; // 3 
System.out.println(truncatedPi); // 3 
 
// double to float (manual - precision lost) 
double largeDouble = 123.456789; 
float smallFloat = (float) largeDouble; // 123.45679 
System.out.println(smallFloat); // 123.45679 
 
// long to int (manual - may lose data if value too large) 
long bigNumber = 1000000L; 
int smallNumber = (int) bigNumber; // 1000000 
System.out.println(smallNumber); // 1000000 
Data Loss Warning 
java 
double value = 3.9999;
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
int result = (int) value; // 3 (not 4 - truncation, not rounding) 
System.out.println(result); // 3 
To round instead of truncate: 
java 
double value = 3.9999; 
int result = (int) Math.round(value); // 4 
System.out.println(result); // 4 
 
3.4 Type Mismatch Errors 
A type mismatch error occurs when you try to assign a value of one type to a variable of an 
incompatible type. 
Common Type Mismatch Errors 
Error Example Why It's Wrong Fix 
Double to 
int 
int x = 
3.14; 
Cannot assign double 
to int without cast int x = (int) 3.14; 
String to 
int 
int y = 
"100"; 
Cannot assign String to 
int int y = Integer.parseInt("100"); 
Boolean to 
int 
int z = 
true; 
Cannot assign boolean 
to int Use if statement 
Char to 
String 
String s = 
'A'; 
Cannot assign char to 
String 
String s = "A"; or String s = 
Character.toString('A'); 
Int to 
boolean 
boolean b 
= 1; 
Cannot assign int to 
boolean boolean b = (1 == 1);
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
How to Fix Type Mismatch Errors 
1. Read the error message – It tells you exactly what's wrong 
2. Check the types – Look at both sides of the assignment 
3. Use casting – If converting between compatible types 
4. Use parsing methods – If converting from String to number 
5. Change the variable type – If the data type is wrong 
 
3.5 String Conversion 
Converting Numbers to Strings 
java 
// Using concatenation 
int number = 42; 
String numberString = "" + number; // "42" 
 
// Using String.valueOf() 
String numberString2 = String.valueOf(42); // "42" 
 
// Using Integer.toString() 
String numberString3 = Integer.toString(42); // "42" 
Converting Strings to Numbers 
java 
// String to int using Integer.parseInt() 
String numericString = "123"; 
int parsedInt = Integer.parseInt(numericString); // 123 
 
// String to double using Double.parseDouble()
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
String decimalString = "45.67"; 
double parsedDouble = Double.parseDouble(decimalString); // 45.67 
 
// String to long using Long.parseLong() 
String longString = "8000000000"; 
long parsedLong = Long.parseLong(longString); // 8000000000 
Error Handling 
Parsing can fail if the String is not a valid number: 
java 
String invalid = "abc"; 
// int value = Integer.parseInt(invalid); // Throws NumberFormatException 
 
PART 4: User Input with Scanner 
4.1 What is the Scanner Class? 
The Scanner class is part of the java.util package and is used to read user input from various 
sources, including the keyboard. 
Importing Scanner 
java 
import java.util.Scanner; 
 
4.2 Creating a Scanner Object 
java 
// Create a Scanner object to read from the keyboard 
Scanner scanner = new Scanner(System.in); 
// System.in represents the standard input stream (keyboard)
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
4.3 Scanner Methods 
Method Reads Example 
nextLine() Entire line (including spaces) String name = scanner.nextLine(); 
next() Next token (word up to whitespace) String word = scanner.next(); 
nextInt() Integer value int age = scanner.nextInt(); 
nextDouble() Double value double price = scanner.nextDouble(); 
nextBoolean() Boolean value boolean flag = scanner.nextBoolean(); 
nextLong() Long value long population = scanner.nextLong(); 
nextFloat() Float value float rate = scanner.nextFloat(); 
 
4.4 Reading Different Data Types 
Example: Reading Multiple Inputs 
java 
import java.util.Scanner; 
 
public class ScannerDemo { 
    public static void main(String[] args) { 
        // Create Scanner object
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
Scanner scanner = new Scanner(System.in); 
         
        // Read a String (full line) 
        System.out.print("Enter your name: "); 
        String name = scanner.nextLine(); 
         
        // Read an int 
        System.out.print("Enter your age: "); 
        int age = scanner.nextInt(); 
         
        // Read a double 
        System.out.print("Enter your GPA: "); 
        double gpa = scanner.nextDouble(); 
         
        // Read a boolean 
        System.out.print("Are you a student? (true/false): "); 
        boolean isStudent = scanner.nextBoolean(); 
         
        // Display the collected information 
        System.out.println("\n=== YOUR INFORMATION ==="); 
        System.out.println("Name: " + name); 
        System.out.println("Age: " + age); 
        System.out.println("GPA: " + gpa); 
        System.out.println("Is Student: " + isStudent); 
         
        // Close the scanner
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
scanner.close(); 
    } 
} 
Sample Interaction: 
Enter your name: Alice Wanjiku 
Enter your age: 20 
Enter your GPA: 3.8 
Are you a student? (true/false): true 
 
=== YOUR INFORMATION === 
Name: Alice Wanjiku 
Age: 20 
GPA: 3.8 
Is Student: true 
 
4.5 Common Scanner Issues 
Issue 1: nextLine() After nextInt() 
When you use nextInt() or nextDouble(), the newline character (\n) remains in the input buffer. 
The next nextLine() reads this leftover newline instead of the user's input. 
Solution: Add an extra scanner.nextLine() to consume the newline. 
java 
System.out.print("Enter age: "); 
int age = scanner.nextInt(); 
 
// Consume the leftover newline 
scanner.nextLine();
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
System.out.print("Enter name: "); 
String name = scanner.nextLine(); // Now works correctly 
Issue 2: InputMismatchException 
This occurs when the user enters the wrong type of input. 
java 
System.out.print("Enter a number: "); 
int num = scanner.nextInt(); // If user enters "abc", this throws InputMismatchException 
Solution: Validate input or use try-catch (covered in later weeks). 
Issue 3: Closing Scanner 
Always close the Scanner when done to free resources. 
java 
scanner.close(); 
 
4.6 Building an Interactive Calculator 
java 
import java.util.Scanner; 
 
public class InteractiveCalculator { 
    public static void main(String[] args) { 
        // Create Scanner object 
        Scanner scanner = new Scanner(System.in); 
         
        // Display welcome message 
        System.out.println("========================================"); 
        System.out.println("     INTERACTIVE CALCULATOR");
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
System.out.println("========================================"); 
         
        // Read user's name 
        System.out.print("Enter your name: "); 
        String name = scanner.nextLine(); 
        System.out.println("\nHello, " + name + "! Let's do some calculations.\n"); 
         
        // Read first number 
        System.out.print("Enter first number: "); 
        double num1 = scanner.nextDouble(); 
         
        // Read second number 
        System.out.print("Enter second number: "); 
        double num2 = scanner.nextDouble(); 
         
        // Perform calculations 
        double sum = num1 + num2; 
        double difference = num1 - num2; 
        double product = num1 * num2; 
         
        // Check for division by zero 
        double quotient = 0; 
        boolean divisionValid = false; 
        if (num2 != 0) { 
            quotient = num1 / num2; 
            divisionValid = true;
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
} 
         
        // Display results 
        System.out.println("\n========================================"); 
        System.out.println("           RESULTS FOR " + name.toUpperCase()); 
        System.out.println("========================================"); 
        System.out.println("First Number: " + num1); 
        System.out.println("Second Number: " + num2); 
        System.out.println("----------------------------------------"); 
        System.out.println("Addition: " + num1 + " + " + num2 + " = " + sum); 
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + difference); 
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + product); 
         
        if (divisionValid) { 
            System.out.println("Division: " + num1 + " / " + num2 + " = " + quotient); 
        } else { 
            System.out.println("Division: Cannot divide by zero!"); 
        } 
         
        // Calculate average 
        double average = (num1 + num2) / 2; 
        System.out.println("Average: " + average); 
         
        System.out.println("========================================"); 
         
        // Close the scanner
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
scanner.close(); 
         
        System.out.println("\nThank you for using the calculator, " + name + "!"); 
    } 
} 
Sample Interaction: 
======================================== 
     INTERACTIVE CALCULATOR 
======================================== 
Enter your name: John Otieno 
 
Hello, John Otieno! Let's do some calculations. 
 
Enter first number: 25 
Enter second number: 4 
 
======================================== 
           RESULTS FOR JOHN OTIENO 
======================================== 
First Number: 25.0 
Second Number: 4.0 
---------------------------------------- 
Addition: 25.0 + 4.0 = 29.0 
Subtraction: 25.0 - 4.0 = 21.0 
Multiplication: 25.0 * 4.0 = 100.0 
Division: 25.0 / 4.0 = 6.25
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
Average: 14.5 
======================================== 
 
Thank you for using the calculator, John Otieno! 
 
PART 5: Summary and Key Takeaways 
5.1 Learning Outcome 1 Summary 
Concept Key Point 
Primitive types 8 built-in types: byte, short, int, long, float, double, char, boolean 
Choosing data types Use int for whole numbers, double for decimals, String for text 
Special cases Phone numbers should be String (leading zeros) 
Suffixes L for long, f for float 
 
5.2 Learning Outcome 2 Summary 
Concept Key Point 
Arithmetic +, -, *, /, % 
Integer division Truncates decimal part (17/5 = 3) 
Modulus Returns remainder (17%5 = 2) 
Precedence *, /, % before +, -; parentheses override
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
Concept Key Point 
Increment/Decrement x++ (post) vs ++x (pre) 
 
5.3 Learning Outcome 3 Summary 
Concept Key Point 
Implicit casting Automatic (int → double) 
Explicit casting Manual (double → int) 
Data loss Narrowing loses data (3.99 → 3) 
String conversion Integer.parseInt(), Double.parseDouble() 
Type mismatch Cannot assign incompatible types 
 
5.4 Learning Outcome 4 Summary 
Concept Key Point 
Scanner import import java.util.Scanner; 
Creating Scanner Scanner scanner = new Scanner(System.in); 
Reading methods nextLine(), nextInt(), nextDouble(), etc. 
Closing scanner.close();
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
Concept Key Point 
Common issue nextLine() after nextInt() – consume newline 
 
5.5 Key Terms Glossary 
Term Definition 
Variable Named storage location for data 
Data Type Defines what kind of data a variable can hold 
Primitive Type Basic data type built into Java 
Reference Type Data type that refers to an object 
Operator Symbol that performs an operation 
Operand Value that an operator acts upon 
Precedence Order in which operators are evaluated 
Implicit Casting Automatic type conversion (widening) 
Explicit Casting Manual type conversion (narrowing) 
Scanner Class for reading user input 
Type Mismatch Error when assigning incompatible types
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
Term Definition 
Truncation Cutting off decimal part when casting 
 
5.6 Self-Assessment Questions 
Answer these in your notebook to test your understanding: 
1. What is the difference between int and double? 
2. Why should phone numbers be stored as String? 
3. What is the output of 17 / 5? What about 17.0 / 5? 
4. What is the output of 17 % 5? 
5. What is operator precedence? Give an example. 
6. What is the difference between x++ and ++x? 
7. What is implicit casting? Give an example. 
8. What is explicit casting? Give an example. 
9. What happens when you cast 3.99 to an int? 
10. How do you read a full line of text using Scanner? 
 
5.7 Practical Checklist 
Before moving to Week 3, ensure you can: 
• □ Choose the right data type for any variable 
• □ Predict the output of expressions with multiple operators 
• □ Perform implicit and explicit casting 
• □ Convert between Strings and numbers 
• □ Read user input using Scanner 
• □ Build an interactive program 
• □ Push code to GitHub
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
5.8 Additional Resources 
Topic Resource 
Data Types https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html 
Operators https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html 
Scanner Class https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html 
Type Conversion https://docs.oracle.com/javase/specs/jls/se21/html/jls-5.html 
 
END OF WEEK 2 COMPREHENSIVE NOTES 
"The only way to learn a new programming language is by writing programs in it." - Dennis 
Ritchie 
 
Instructor Note: These notes are designed for self-paced learning. you should read each section, 
run the code examples, and complete the self-assessment questions before moving to Week 3. I 
encourage you to experiment with the code - change values, add new variables, and see what 
happens. Learning by doing is the most effective approach.
```

</details>
