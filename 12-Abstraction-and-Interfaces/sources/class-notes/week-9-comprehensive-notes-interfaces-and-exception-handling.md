# Week 9 - Comprehensive Notes - Interfaces and Exception Handling

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 9 - Comprehensive Notes - Interfaces and Exception Handling.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 9 – Interfaces & Exception Handling 
Course: Object-Oriented Programming (Java) 
Module 10: Interfaces and Exception Handling 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Evaluate when to use an interface vs. an abstract class in a given design scenario. 
2. Create a class that implements multiple interfaces to achieve polymorphic behavior. 
3. Analyze exception handling code to determine if exceptions are properly caught or 
propagated. 
4. Design a custom exception hierarchy for a domain-specific problem. 
 
PART 1: Interfaces 
1.1 What is an Interface? 
An interface in Java is a completely abstract reference type. It acts as a contract or a capability. 
It defines what a class must do, but not how it does it. 
Think of it like a job description. A job posting for a "Driver" says the person must be able to 
drive. It doesn't specify if they drive a manual or automatic, a car or a truck. The "Driver" 
interface just guarantees the capability to drive. 
Interface Syntax 
java 
// Defining an interface 
public interface Flyable { 
    // Methods in an interface are implicitly public and abstract. 
    void fly(); 
}
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Implementing an Interface 
A class uses the implements keyword to adopt an interface. 
java 
// A class implementing the interface 
public class Bird implements Flyable { 
    // The class MUST provide the implementation for fly() 
    @Override 
    public void fly() { 
        System.out.println("The bird is flapping its wings."); 
    } 
} 
1.2 Evaluating Interfaces vs. Abstract Classes (LO1) 
Before Java 8, interfaces could only have abstract methods, making them similar to abstract 
classes. How do you evaluate which one to use? 
Use an Abstract Class when: 
• You have an "IS-A" relationship. 
• You want to share code (state and concrete methods) among closely related classes. 
• The classes are tightly related (e.g., Dog and Cat are both Animal). 
Use an Interface when: 
• You have a "CAN-DO" capability. 
• You want to define a contract for classes that may be completely unrelated. 
• You need "multiple inheritance" of type (a class can only extend one parent class, but it 
can implement multiple interfaces).
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Comparison Table 
Feature Abstract Class Interface 
Keyword abstract class interface 
Inheritance extends (One only) implements (Multiple) 
State (Fields) Can have instance variables Can only have constants (public static final) 
Methods Abstract and Concrete Abstract, default, and static methods 
Constructor Yes No 
Relationship "IS-A" (e.g., A Car IS A Vehicle) "CAN-DO" (e.g., A Car CAN-DO Drive) 
 
1.3 Multiple Interfaces (LO2) 
Unlike class inheritance, where a class can only have one parent class, a class can implement 
multiple interfaces. This is how Java handles multiple inheritance safely. 
java 
// Three different interfaces 
interface Camera { void takePhoto(); } 
interface MusicPlayer { void playMusic(); } 
interface Phone { void makeCall(String number); } 
 
// A class implementing all three! 
class Smartphone implements Camera, MusicPlayer, Phone {
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
@Override 
    public void takePhoto() { System.out.println("Taking photo"); } 
     
    @Override 
    public void playMusic() { System.out.println("Playing music"); } 
     
    @Override 
    public void makeCall(String num) { System.out.println("Calling " + num); } 
} 
Polymorphic Behavior: Because the Smartphone implements all three interfaces, a Smartphone 
object can be referenced as a Camera, a MusicPlayer, or a Phone. 
 
PART 2: Exception Handling 
2.1 What is an Exception? 
An exception is an event that disrupts the normal flow of a program. If not handled, an 
exception causes the program to crash. 
Examples: Dividing by zero, accessing a null object, or a missing file. 
2.2 Checked vs. Unchecked Exceptions 
Type Description Examples 
Checked 
Exception 
The compiler forces you to 
handle it (using try-catch or 
throws). It represents 
predictable risks. 
IOException, FileNotFoundException, 
SQLException 
Unchecked 
Exception 
The compiler does not force 
you to handle it. Usually 
caused by programmer error. 
NullPointerException, ArithmeticException, 
ArrayIndexOutOfBoundsException 
2.3 try-catch-finally (LO3: Analyze the Flow)
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
To prevent crashes, we wrap risky code in a try block, handle errors in a catch block, and clean 
up resources in a finally block. 
java 
public void readFile() { 
    try { 
        // 1. RISKY CODE: If this file doesn't exist, it throws an exception. 
        File file = new File("data.txt"); 
        Scanner sc = new Scanner(file);  
        System.out.println("File read successfully."); 
         
    } catch (FileNotFoundException e) { 
        // 2. CATCH BLOCK: Executes ONLY if the specific exception occurs. 
        System.out.println("Error: The file was not found."); 
         
    } finally { 
        // 3. FINALLY BLOCK: ALWAYS executes, even if an exception occurs. 
        // Used for cleanup (closing files, database connections). 
        System.out.println("Cleanup complete."); 
    } 
} 
Analyzing Exception Propagation (throw vs throws) 
• throw: A keyword used inside a method body to explicitly trigger an exception. (e.g., 
throw new Exception();) 
• throws: A keyword used in the method signature to warn the compiler that this method 
might throw an exception, shifting the responsibility of handling it to the method caller. 
java 
// We use 'throws' to propagate the responsibility to the main method.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
public void riskyMethod() throws IOException { 
    if (true) { 
        // We use 'throw' to actually create and fire the exception. 
        throw new IOException("Something went wrong!");  
    } 
} 
 
PART 3: Custom Exceptions (LO4) 
3.1 Why Create Custom Exceptions? 
Java's built-in exceptions (like NullPointerException) are too generic. In a business application, 
you want errors that make sense to the business domain. 
If a user tries to withdraw more money than they have, an ArithmeticException doesn't make 
sense. An InsufficientFundsException makes perfect sense. 
3.2 Designing the Hierarchy 
You create a custom exception by extending Exception (for Checked) or RuntimeException (for 
Unchecked). 
For enterprise applications, it is best practice to create a base domain exception, and then 
specific exceptions that extend it. 
java 
// 1. Base Domain Exception 
class BankingException extends Exception { 
    public BankingException(String message) { 
        super(message); 
    } 
} 
 
// 2. Specific Exception extending the base
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
class InsufficientFundsException extends BankingException { 
    private double shortfall; 
 
    public InsufficientFundsException(String message, double shortfall) { 
        super(message); 
        this.shortfall = shortfall; 
    } 
 
    public double getShortfall() { return shortfall; } 
} 
3.3 Using the Custom Exception 
java 
class BankAccount { 
    private double balance = 5000; 
 
    // Declare that this method throws our custom exception 
    public void withdraw(double amount) throws InsufficientFundsException { 
        if (amount > balance) { 
            // Throw the custom exception with specific data 
            throw new InsufficientFundsException("Insufficient balance!", amount - balance); 
        } 
        balance -= amount; 
    } 
}
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
PART 4: Summary and Key Takeaways 
1. Interfaces define a "CAN-DO" capability (a contract) and allow multiple inheritance of 
type. 
2. Abstract Classes define an "IS-A" relationship and allow sharing of code/state. 
3. A class can implement multiple interfaces but extend only one class. 
4. Exceptions prevent programs from crashing ungracefully. 
5. Checked Exceptions must be handled; Unchecked Exceptions occur at runtime. 
6. throw fires an exception; throws warns the caller. 
7. Custom Exceptions (extending Exception) provide specific, domain-driven error 
messages (e.g., InsufficientFundsException). 
 
             Key Terms Glossary 
Term Definition 
Interface A blueprint of a class that contains only constants and abstract methods. 
implements Keyword used by a class to adopt an interface. 
try-catch Block used to catch and handle exceptions to prevent program crashes. 
finally A block that always executes, used for cleanup. 
Checked Exception An exception the compiler forces you to handle. 
Unchecked 
Exception A runtime error (e.g., NullPointerException).
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
Term Definition 
throw Keyword used to explicitly trigger an exception. 
throws Keyword in a method signature that declares an exception might occur. 
Custom Exception A user-defined exception extending Exception or RuntimeException.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Self-Assessment Questions 
1. Why can't you use the extends keyword to inherit from multiple classes, but you can use 
implements for multiple interfaces? 
2. What is the difference between a Checked Exception and an Unchecked Exception? 
3. If a method uses the throws keyword, who is responsible for handling the exception? 
4. Write a short code snippet showing how to create a custom InvalidAgeException. 
5. If a class implements the Camera interface, what must it do?
```

</details>
