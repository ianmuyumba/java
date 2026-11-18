# Week 1 - Comprehensive Notes

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 1 - Comprehensive Notes.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 1 – Introduction to Java & OOP Fundamentals 
Course: Object-Oriented Programming (Java) 
Module 1: Getting Started with Java 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Explain the differences between procedural and object-oriented programming 
paradigms using real-world analogies. 
2. Classify Java syntax elements (class, main method, statements, comments) in a given 
code snippet. 
3. Demonstrate the ability to compile and run a Java program independently. 
4. Compare the roles of JVM, JRE, and JDK in executing Java programs. 
 
PART 1: Procedural vs Object-Oriented Programming 
1.1 What is a Programming Paradigm? 
A programming paradigm is a style or approach to writing computer programs. Think of it as a 
mindset or philosophy for solving problems with code. Just as there are different ways to build a 
house (brick by brick, prefabricated modules, etc.), there are different ways to struct ure a 
program. 
The two most common paradigms you will encounter are: 
1. Procedural Programming - Focuses on actions (what the program does). 
2. Object-Oriented Programming (OOP)- Focuses on objects (what the program is about). 
 
1.2 Procedural Programming 
Definition 
Procedural programming organizes code around functions (also called procedures or methods). 
Data is stored in variables, and functions operate on that data. The programmer writes a sequence 
of steps (a procedure) to solve a problem.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Real-World Analogy: A Recipe 
Think of a recipe for baking a cake: 
• Ingredients = Data (flour, sugar, eggs) 
• Steps = Functions (mix, bake, frost) 
• The recipe itself = The program 
In procedural programming, the ingredients (data) are separate from the steps (functions). You 
follow the steps in order to produce the cake. 
Example: Procedural Rectangle Area Calculator 
java 
// Procedural approach: data and methods are separate. 
public class RectangleProcedural { 
 
    // A function that calculates area. 
    // It takes two parameters: length and width. 
    // It returns the area as a double. 
    public static double calculateArea(double length, double width) { 
        // Multiply length and width, return the result. 
        return length * width; 
    } 
 
    // A function that calculates perimeter. 
    public static double calculatePerimeter(double length, double width) { 
        // Formula: 2 * (length + width) 
        return 2 * (length + width); 
    }
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
// The main method – entry point. 
    public static void main(String[] args) { 
 
        // Declare variables for length and width. 
        double length = 5.0; 
        double width = 3.0; 
 
        // Call the function and store the result. 
        double area = calculateArea(length, width); 
 
        // Call the perimeter function. 
        double perimeter = calculatePerimeter(length, width); 
 
        // Print the results. 
        System.out.println("Procedural Approach:"); 
        System.out.println("Length: " + length); 
        System.out.println("Width: " + width); 
        System.out.println("Area: " + area); 
        System.out.println("Perimeter: " + perimeter); 
    } 
} 
Output: 
Procedural Approach: 
Length: 5.0 
Width: 3.0 
Area: 15.0
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Perimeter: 16.0 
Characteristics of Procedural Programming 
Characteristic Description 
Data Stored in separate variables, often global or passed as arguments 
Functions Standalone blocks of code that perform specific tasks 
Focus On the steps (algorithms) needed to solve a problem 
Reusability Functions can be reused, but data coupling is loose 
Modification Changing data structure requires updating all functions that use it 
Examples C, Pascal, FORTRAN, early BASIC 
Problems with Procedural Programming 
1. Data is exposed – Any function can modify any variable, leading to bugs. 
2. Hard to maintain – Changing one data structure affects many functions. 
3. Poor modeling of real world – Real-world entities have both data and behavior. 
4. Limited reusability – Functions are tied to specific data structures. 
 
1.3 Object-Oriented Programming (OOP) 
Definition 
Object-oriented programming organizes code around objects. An object bundles together: 
• Attributes (data) – What the object knows 
• Methods (behaviors) – What the object can do 
Objects are created from classes, which act as blueprints. 
Real-World Analogy: A Car
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
Think of a car: 
• Attributes = color, model, speed, fuel level 
• Behaviors = start(), accelerate(), brake(), honk() 
In OOP , you create a Car class (blueprint) and then create individual Car objects (your car, my 
car, their car). Each car has its own data but shares the same behaviors. 
Example: OOP Rectangle Area Calculator 
java 
// Object-oriented approach: data and methods are bundled together in a class. 
public class RectangleOOP { 
 
    // Private fields (attributes) – encapsulated. 
    // They can only be accessed through methods. 
    private double length; 
    private double width; 
 
    // Constructor: initializes the fields when an object is created. 
    public RectangleOOP(double length, double width) { 
        // 'this' refers to the current object. 
        // It distinguishes the field from the parameter. 
        this.length = length; 
        this.width = width; 
    } 
 
    // Public getter for length. 
    public double getLength() { 
        return length;
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
} 
 
    // Public getter for width. 
    public double getWidth() { 
        return width; 
    } 
 
    // Method to calculate area. 
    public double getArea() { 
        return length * width; 
    } 
 
    // Method to calculate perimeter. 
    public double getPerimeter() { 
        return 2 * (length + width); 
    } 
 
    // Main method – entry point. 
    public static void main(String[] args) { 
 
        // Create an object of RectangleOOP . 
        // The constructor is called with arguments 5.0 and 3.0. 
        RectangleOOP rect = new RectangleOOP(5.0, 3.0); 
 
        // Call methods on the object. 
        System.out.println("OOP Approach:");
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
System.out.println("Length: " + rect.getLength()); 
        System.out.println("Width: " + rect.getWidth()); 
        System.out.println("Area: " + rect.getArea()); 
        System.out.println("Perimeter: " + rect.getPerimeter()); 
    } 
} 
Output: 
OOP Approach: 
Length: 5.0 
Width: 3.0 
Area: 15.0 
Perimeter: 16.0 
Characteristics of OOP 
Characteristic Description 
Data Stored inside objects as private fields 
Methods Attached to objects as behaviors 
Focus On the objects (entities) in the problem 
Reusability Classes can be extended through inheritance 
Modification Changes to one class rarely affect others 
Examples Java, C++, Python, C#, Ruby
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
The Four Pillars of OOP 
Pillar Definition Real-World Analogy 
Encapsulation Bundling data and methods, hiding internal details A car's engine is hidden under the hood; you use pedals and steering wheel 
Inheritance Creating new classes based on existing ones A sports car inherits from a generic car 
Polymorphism One interface, many implementations A "start" button works on a car, bike, or computer 
Abstraction Hiding complex details, showing only essentials You drive a car without knowing how the engine works 
 
1.4 Procedural vs OOP: Side-by-Side Comparison 
Aspect Procedural Object-Oriented 
Basic unit Function Object 
Data location Separate from functions Bundled inside objects 
Data access Often public/global Usually private (encapsulated) 
Problem-solving Top-down (break into steps) Bottom-up (identify objects) 
Reusability Through functions Through inheritance and composition
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
Aspect Procedural Object-Oriented 
Maintenance Harder as program grows Easier due to modularity 
Real-world 
modeling Poor Excellent 
Examples C, Pascal Java, C++, Python 
Why OOP for Fintech (M-Pesa)? 
In fintech applications like M-Pesa: 
• Transactions are objects (with amount, sender, receiver, timestamp) 
• Accounts are objects (with balance, owner, transaction history) 
• Agents are objects (with location, float balance, commission rate) 
OOP allows developers to: 
• Model real-world entities naturally 
• Protect sensitive data (encapsulation) 
• Extend systems easily (e.g., add new transaction types) 
• Maintain large codebases 
 
PART 2: Java Syntax Elements 
2.1 The Structure of a Java Program 
Every Java program follows a specific structure. Let's break down the basic elements. 
Example: Complete Annotated Program 
java 
// This is a single-line comment. The compiler ignores it. 
// It is used to explain what the code does.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
/* 
 * This is a multi-line comment. 
 * It can span multiple lines. 
 * Used for longer explanations or documentation. 
 */ 
 
// public: access modifier – this class is accessible from anywhere. 
// class: keyword to define a class. 
// HelloWorld: the name of the class (must match the file name). 
public class HelloWorld { 
 
    // public: accessible from anywhere. 
    // static: this method belongs to the class, not an object. 
    // void: this method does not return any value. 
    // main: the entry point of any Java program. 
    // String[] args: an array of strings for command-line arguments. 
    public static void main(String[] args) { 
 
        // System.out.println: prints a line of text to the console. 
        // The text inside the double quotes is called a string literal. 
        System.out.println("Hello, World!"); 
 
        // Print another line. 
        System.out.println("My name is: John Otieno"); 
 
        // Print another line.
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
System.out.println("I am learning Java at University of Nairobi"); 
 
        // Print another line with the date. 
        System.out.println("Today's date is: 2026-01-15"); 
    } 
} 
 
2.2 Class Declaration 
Definition 
A class is a blueprint for creating objects. It defines: 
• Fields (attributes) – Data the object will hold 
• Methods (behaviors) – Actions the object can perform 
Syntax 
java 
accessModifier class ClassName { 
    // fields 
    // methods 
} 
Example 
java 
// public: this class is accessible from anywhere. 
// class: keyword to define a class. 
// Student: the name of the class. 
public class Student { 
    // Class body – fields and methods go here 
}
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
Rules for Class Names 
1. Must match the file name (e.g., Student class must be in Student.java) 
2. Start with an uppercase letter (PascalCase) 
3. No spaces or special characters 
4. Cannot be a Java keyword (e.g., class, public, static) 
 
2.3 The Main Method 
Definition 
The main method is the entry point of every Java program. When you run a Java program, the 
JVM looks for the main method and starts executing from there. 
Syntax 
java 
public static void main(String[] args) { 
    // code to execute 
} 
Breaking Down the Main Method 
Keyword Meaning Why It's Needed 
public Access modifier – accessible from anywhere JVM must be able to call it from outside the class 
static Belongs to the class, not an object JVM calls it before any objects are created 
void Returns nothing The main method doesn't return a value
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
Keyword Meaning Why It's Needed 
main Method name The JVM specifically looks for this name 
String[] 
args Array of strings Stores command-line arguments 
Example 
java 
public class MainDemo { 
    public static void main(String[] args) { 
        // This is the first line that executes. 
        System.out.println("Program started!"); 
         
        // Print command-line arguments if any. 
        if (args.length > 0) { 
            System.out.println("Arguments received:"); 
            for (String arg : args) { 
                System.out.println(" - " + arg); 
            } 
        } else { 
            System.out.println("No arguments provided."); 
        } 
         
        System.out.println("Program ended."); 
    } 
}
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
Running with arguments: 
bash 
java MainDemo hello world 
Output: 
text 
Program started! 
Arguments received: 
 - hello 
 - world 
Program ended. 
 
2.4 Statements 
Definition 
A statement is a single instruction that tells the computer to do something. In Java, every 
statement ends with a semicolon (;). 
Types of Statements 
Type Example Purpose 
Declaration int age; Declares a variable 
Assignment age = 20; Assigns a value 
Method call System.out.println("Hello"); Calls a method 
Control flow if (age > 18) { ... } Makes decisions 
Loop for (int i = 0; i < 5; i++) { ... } Repeats code
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
Example 
java 
public class StatementsDemo { 
    public static void main(String[] args) { 
        // Declaration statement 
        int age; 
         
        // Assignment statement 
        age = 20; 
         
        // Declaration + initialization in one statement 
        String name = "Alice"; 
         
        // Method call statement 
        System.out.println("Name: " + name); 
         
        // Another method call statement 
        System.out.println("Age: " + age); 
    } 
} 
 
2.5 Comments 
Definition 
Comments are notes in the code that the compiler ignores. They are used to: 
• Explain what the code does 
• Document complex logic
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
• Leave notes for yourself and other developers 
Types of Comments 
Type Syntax Use Case 
Single-line // comment Short explanations 
Multi-line /* comment */ Longer explanations 
Javadoc /** comment */ Documentation (generates HTML) 
Examples 
java 
// This is a single-line comment 
 
/* 
 * This is a multi-line comment. 
 * It can span several lines. 
 */ 
 
/** 
 * This is a Javadoc comment. 
 * It is used to generate documentation. 
 * @author John Otieno 
 * @version 1.0 
 */ 
public class CommentsDemo {
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
/** 
     * This method adds two numbers. 
     * @param a The first number 
     * @param b The second number 
     * @return The sum of a and b 
     */ 
    public static int add(int a, int b) { 
        return a + b; // Return the sum 
    } 
     
    public static void main(String[] args) { 
        // Call the add method and print the result 
        int result = add(5, 3); 
        System.out.println("Result: " + result); 
    } 
} 
Best Practices for Comments 
1. Explain WHY , not WHAT – The code shows what; comments explain why. 
2. Keep comments up to date – Outdated comments are worse than no comments. 
3. Don't over-comment – Don't comment every line; use meaningful variable names 
instead. 
4. Use Javadoc for public methods – Helps generate documentation. 
 
2.6 Identifiers 
Definition 
Identifiers are names given to classes, methods, variables, and packages.
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
Rules for Identifiers 
1. Must start with a letter, underscore (_), or dollar sign ($) 
2. Cannot start with a digit 
3. Cannot contain spaces or special characters (except _ and $) 
4. Cannot be a Java keyword (e.g., class, public, static) 
5. Case-sensitive (age and Age are different) 
Valid vs Invalid Identifiers 
Valid Invalid Reason 
studentName 2ndStudent Starts with digit 
_count my-variable Contains hyphen 
$price class Java keyword 
Age student name Contains space 
 
 
 
 
Naming Conventions 
Element Convention Example 
Class PascalCase StudentRecord 
Method camelCase calculateArea()
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
Element Convention Example 
Variable camelCase studentName 
Constant UPPER_SNAKE_CASE MAX_VALUE 
Package lowercase com.example 
 
PART 3: Compiling and Running Java Programs 
3.1 The Java Compilation Process 
Java is both compiled and interpreted. Here's the process:
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
3.2 Setting Up Your Environment 
Step 1: Install JDK 
1. Go to https://adoptium.net/ 
2. Download the latest LTS version 
3. Run the installer and check "Set JAVA_HOME" 
Step 2: Verify Installation 
Open terminal and run: 
bash 
java -version 
javac -version 
Expected output: 
text 
openjdk version "21.0.1" 2024-10-15 
javac 21.0.1 
Step 3: Install VS Code 
1. Go to https://code.visualstudio.com/ 
2. Download and install 
3. Install "Extension Pack for Java" from Extensions marketplace 
 
3.3 Writing Your First Program 
Step 1: Create a File 
Create a file named HelloWorld.java 
Step 2: Write the Code 
java 
// This is a single-line comment 
public class HelloWorld {
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
public static void main(String[] args) { 
        // Print a greeting 
        System.out.println("Hello, World!"); 
    } 
} 
Step 3: Compile 
Open terminal and navigate to the file location: 
bash 
cd path/to/your/file 
javac HelloWorld.java 
If successful, a HelloWorld.class file is created. 
Step 4: Run 
bash 
java HelloWorld 
Output: 
text 
Hello, World! 
 
3.4 Common Compilation Errors and Solutions 
Error Message Cause Solution 
class HelloWorld is public, should be 
declared in a file named 
HelloWorld.java 
File name doesn't 
match class name 
Rename the file to 
match the class name 
';' expected Missing semicolon Add a semicolon at the end of the statement
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
Error Message Cause Solution 
cannot find symbol Misspelled variable/method name Check spelling and case 
illegal start of expression Syntax error Check for missing braces or parentheses 
reached end of file while parsing Missing closing brace Add the missing } 
java: command not found Java not installed or PATH not set Reinstall JDK and check "Set JAVA_HOME" 
 
3.5 Using VS Code to Compile and Run 
1. Open your .java file in VS Code 
2. Click the Run button (  ) at the top-right 
3. The output appears in the terminal panel at the bottom 
VS Code handles compilation and execution automatically. 
 
PART 4: JVM, JRE, and JDK 
4.1 The Java Ecosystem
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
4.2 JVM – Java Virtual Machine 
Definition 
The JVM is an abstract machine that executes Java bytecode. It is the engine that runs Java 
programs. 
Responsibilities 
1. Load code – Reads .class files 
2. Verify code – Ensures bytecode is valid and safe 
3. Execute code – Interprets or JIT-compiles bytecode 
4. Manage memory – Allocates and frees memory (garbage collection) 
5. Provide security – Sandboxing, bytecode verification
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
Platform Independence 
The JVM is platform-specific, but it allows the same bytecode to run on any platform: 
• Windows JVM runs on Windows 
• Mac JVM runs on macOS 
• Linux JVM runs on Linux 
"Write Once, Run Anywhere" (WORA) is possible because bytecode is platform-independent. 
Analogy 
The JVM is like a translator at the United Nations: 
• The speaker (Java program) speaks one language (bytecode) 
• The translator (JVM) converts it to the listener's language (machine code) 
• Different translators (JVMs) work for different countries (operating systems) 
 
4.3 JRE – Java Runtime Environment 
Definition 
The JRE is the environment needed to run Java applications. It includes the JVM and core 
libraries. 
Components 
1. JVM – Executes bytecode 
2. Core Libraries – Pre-written code (e.g., java.lang, java.util) 
3. Other Files – Configuration files, property files 
Who Needs JRE? 
• End users who want to run Java applications 
• Not developers – developers need JDK 
Analogy 
The JRE is like a DVD player: 
• It can play DVDs (run Java programs)
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
• It cannot create DVDs (write Java code) 
 
4.4 JDK – Java Development Kit 
Definition 
The JDK is the complete toolkit for developing Java applications. It includes the JRE plus 
development tools. 
Components 
1. JRE – To run programs 
2. javac – Compiler (source code → bytecode) 
3. java – Launcher (runs bytecode) 
4. javadoc – Documentation generator 
5. jar – Archive tool 
6. jdb – Debugger 
7. jconsole – Monitoring tool 
Who Needs JDK? 
• Developers who write Java code 
• Students learning Java 
• Anyone who needs to compile Java programs 
Analogy 
The JDK is like a DVD player + DVD burner + editing software: 
• You can play DVDs (run programs) 
• You can create DVDs (write code) 
• You can edit DVDs (debug code)
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
4.5 Comparison Table 
Feature JVM JRE JDK 
Full Name Java Virtual Machine Java Runtime Environment Java Development Kit 
Purpose Execute bytecode Run Java applications Develop Java applications 
Contains Bytecode interpreter JVM + libraries JRE + dev tools 
Who Needs 
It Everyone End users Developers 
Key Tools None (runtime) java javac, java, javadoc, jar 
Analogy Car engine Car Car + mechanic's tools 
 
4.6 How They Work Together 
          JAVA EXECUTION FLOW
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
4.7 Practical Exercise: JavaInfo.java 
java 
// This program prints information about the Java runtime. 
public class JavaInfo { 
    public static void main(String[] args) { 
        // System.getProperty() retrieves system properties. 
        // "java.version" returns the Java version. 
        String version = System.getProperty("java.version"); 
 
        // "java.home" returns the installation directory of Java. 
        String javaHome = System.getProperty("java.home");
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
// "os.name" returns the operating system name. 
        String osName = System.getProperty("os.name"); 
 
        // "java.vendor" returns the Java vendor. 
        String vendor = System.getProperty("java.vendor"); 
 
        // Print the collected information. 
        System.out.println("=== Java Environment Info ==="); 
        System.out.println("Java Version: " + version); 
        System.out.println("Java Home: " + javaHome); 
        System.out.println("Java Vendor: " + vendor); 
        System.out.println("Operating System: " + osName); 
    } 
} 
Sample Output: 
=== Java Environment Info === 
Java Version: 21.0.1 
Java Home: C:\Program Files\Java\jdk-21 
Java Vendor: Eclipse Adoptium 
Operating System: Windows 11 
 
PART 5: Summary and Key Takeaways 
5.1 Learning Outcome 1 Summary
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
Concept Key Point 
Procedural Programming Focuses on functions and steps; data is separate 
OOP Focuses on objects; data and methods are bundled 
Real-World Analogy Recipe (procedural) vs Car (OOP) 
Why OOP for Fintech Models real-world entities; protects data; extensible 
 
5.2 Learning Outcome 2 Summary 
Syntax Element Example Purpose 
Class public class HelloWorld Blueprint for objects 
Main Method public static void main(String[] args) Entry point 
Statement System.out.println("Hello"); Instruction 
Comment // This is a comment Explanation 
Identifier studentName Name for class/method/variable 
 
5.3 Learning Outcome 3 Summary 
Action Command Result 
Compile javac HelloWorld.java Creates HelloWorld.class
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
Action Command Result 
Run java HelloWorld Executes program 
Verify Java java -version Shows version 
Verify Compiler javac -version Shows compiler version 
 
5.4 Learning Outcome 4 Summary 
Component Full Name What It Does 
JVM Java Virtual Machine Executes bytecode 
JRE Java Runtime Environment JVM + libraries (to run apps) 
JDK Java Development Kit JRE + tools (to develop apps) 
 
5.5 Key Terms Glossary 
Term Definition 
Bytecode Intermediate code generated by Java compiler 
Class Blueprint for creating objects 
Object Instance of a class 
Method Block of code that performs a task
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
Term Definition 
Field Variable inside a class 
Compiler Translates source code to bytecode 
JVM Executes bytecode 
JRE Environment to run Java apps 
JDK Toolkit to develop Java apps 
Encapsulation Hiding data inside objects 
Inheritance Creating new classes from existing ones 
Polymorphism One interface, many implementations 
Abstraction Hiding complex details 
 
5.6 Self-Assessment Questions 
Answer these in your notebook to test your understanding: 
1. Explain the difference between procedural and OOP using your own analogy. 
2. What are the four pillars of OOP? Give an example of each. 
3. Identify the class, main method, and comments in the following code: 
java 
// My first program 
public class Test { 
    public static void main(String[] args) {
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
System.out.println("Hello"); 
    } 
} 
4. What is the correct signature of the main method? 
5. What command compiles a Java program? 
6. What command runs a Java program? 
7. What is the difference between JVM, JRE, and JDK? 
8. Why can Java run on any platform? 
9. What is bytecode? 
10. What is the purpose of comments in code? 
 
5.7 Practical Checklist 
Before moving to Week 2, ensure you can: 
• □ Explain procedural vs OOP with an analogy 
• □ Identify class, main method, comments, and statements in code 
• □ Compile a Java program using javac 
• □ Run a Java program using java 
• □ Explain the roles of JVM, JRE, and JDK 
• □ Create a simple Java program in VS Code 
• □ Push code to GitHub 
 
5.8 Additional Resources 
Topic Resource 
Java Basics https://docs.oracle.com/javase/tutorial/java/nutsandbolts/
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
Topic Resource 
OOP Concepts https://docs.oracle.com/javase/tutorial/java/concepts/ 
JVM Guide https://docs.oracle.com/javase/specs/jvms/se21/html/ 
VS Code Java https://code.visualstudio.com/docs/java/java-tutorial 
Git Basics https://git-scm.com/book/en/v2/Getting-Started-Git-Basics 
 
 
END OF WEEK 1 COMPREHENSIVE NOTES 
"The only way to learn a new programming language is by writing programs in it." – Dennis 
Ritchie 
 
Instructor Note: These notes are designed for self-paced learning. You should read each section, 
run the code examples, and complete the self-assessment questions before moving to Week 2. I 
encourage you to experiment with the code and change values, add print statements, and see 
what happens. Learning by doing is the most effective approach.
```

</details>
