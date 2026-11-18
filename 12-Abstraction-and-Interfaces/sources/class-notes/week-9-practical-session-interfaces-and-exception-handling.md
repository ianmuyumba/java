# Week 9 - Practical Session - Interfaces and Exception Handling

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 9 - Practical Session - Interfaces and Exception Handling.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Practical Session 9: Interfaces & Exception Handling 
Student-Centered, Self-Paced Lab 
 
       Learning Outcomes Covered 
By the end of this practical session, you will be able to: 
1. Evaluate when to use an interface vs. an abstract class in a given design scenario. 
2. Create a class that implements multiple interfaces to achieve polymorphic behavior. 
3. Analyze exception handling code to determine if exceptions are properly caught or 
propagated. 
4. Design a custom exception hierarchy for a domain-specific problem (e.g., a banking 
system). 
Time Required: 120–150 minutes 
Instructor Intervention: None – you will figure it out yourself! 
 
         Before You Begin 
Ensure you have completed Week 8. You will need: 
• VS Code open 
• Your java-course folder with a new subfolder named week9 
• Git configured and connected to GitHub
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Your Roadmap 
 
 
TASK 1: Interface vs Abstract Class 
Objective 
Evaluate when to use an interface (a 100% abstract contract) versus an abstract class (a partial 
implementation). 
Step 1.1: Create the File 
1. Create a folder named week9 in your java-course directory. 
2. Create a file named InterfaceVsAbstract.java. 
Step 1.2: Write the Code 
java 
// This program demonstrates the difference between an Abstract Class and an Interface. 
 
// ============================================================ 
// ABSTRACT CLASS
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
// ============================================================ 
// Represents an "IS-A" relationship with shared code (state/behavior). 
abstract class Animal { 
    // Abstract classes can have fields (state). 
    protected String name; 
 
    public Animal(String name) { 
        this.name = name; 
    } 
 
    // Concrete method: Shared by all animals. 
    public void sleep() { 
        System.out.println(name + " is sleeping."); 
    } 
 
    // Abstract method: Must be implemented by subclasses. 
    public abstract void makeSound(); 
} 
 
// ============================================================ 
// INTERFACE 
// ============================================================ 
// Represents a "CAN-DO" capability. It defines a contract with NO state (fields). 
// By default, all methods in an interface are public and abstract. 
interface Flyable { 
    // Interfaces cannot have instance fields like 'name'.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
// They can only have constants (public static final). 
    int MAX_ALTITUDE = 10000;  
 
    // Abstract method: Must be implemented by any class that implements this interface. 
    void fly(); 
} 
 
// ============================================================ 
// SUBCLASS IMPLEMENTING BOTH 
// ============================================================ 
// A Bird IS-AN Animal, and it CAN-DO Fly. 
// Note: We use 'extends' for the class and 'implements' for the interface. 
class Bird extends Animal implements Flyable { 
     
    public Bird(String name) { 
        super(name); // Call the abstract class constructor. 
    } 
 
    // Implementing the abstract method from Animal. 
    @Override 
    public void makeSound() { 
        System.out.println(name + " says: Tweet! Tweet!"); 
    } 
 
    // Implementing the method from the Flyable interface. 
    @Override
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
public void fly() { 
        System.out.println(name + " is flying up to " + MAX_ALTITUDE + " feet."); 
    } 
} 
 
// ============================================================ 
// MAIN CLASS 
// ============================================================ 
public class InterfaceVsAbstract { 
    public static void main(String[] args) { 
        // Create a Bird object. 
        Bird myBird = new Bird("Tweety"); 
 
        // Call methods from Animal (Abstract Class). 
        myBird.sleep(); 
        myBird.makeSound(); 
 
        // Call methods from Flyable (Interface). 
        myBird.fly(); 
    } 
} 
Step 1.3: Evaluate the Design 
Answer these questions in your notebook: 
1. Why did Animal need to be an abstract class instead of an interface? (Hint: It has the 
name field and the sleep() method). 
2. Why did Flyable need to be an interface instead of an abstract class? (Hint: Other 
unrelated things like airplanes or insects can also fly, but they aren't Animals).
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
Task 1 Complete 
• □ I created InterfaceVsAbstract.java 
• □ I ran the program successfully 
• □ I understand the difference between IS-A (Abstract) and CAN-DO (Interface) 
 
TASK 2: Multiple Interfaces 
Objective 
Create a class that implements multiple interfaces to achieve polymorphic behavior. 
Step 2.1: Create the File 
Create a file named MultipleInterfaces.java. 
Step 2.2: Write the Code 
java 
// This program demonstrates how a class can implement multiple interfaces. 
// This is Java's way of achieving "multiple inheritance" of type. 
 
// First Interface 
interface Camera { 
    void takePhoto(); 
} 
 
// Second Interface 
interface MusicPlayer { 
    void playMusic(); 
} 
 
// Third Interface
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
interface Phone { 
    void makeCall(String number); 
} 
 
// ============================================================ 
// A class implementing THREE interfaces 
// ============================================================ 
class Smartphone implements Camera, MusicPlayer, Phone { 
 
    private String model; 
 
    public Smartphone(String model) { 
        this.model = model; 
    } 
 
    // Implementation of Camera interface 
    @Override 
    public void takePhoto() { 
        System.out.println(model + " is taking a photo... Click!"); 
    } 
 
    // Implementation of MusicPlayer interface 
    @Override 
    public void playMusic() { 
        System.out.println(model + " is playing music...  "); 
    }
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
// Implementation of Phone interface 
    @Override 
    public void makeCall(String number) { 
        System.out.println(model + " is calling " + number + "...   "); 
    } 
} 
 
public class MultipleInterfaces { 
    public static void main(String[] args) { 
        // Create a Smartphone object. 
        Smartphone myPhone = new Smartphone("Samsung Galaxy"); 
 
        // You can use the object to call all its methods. 
        myPhone.takePhoto(); 
        myPhone.playMusic(); 
        myPhone.makeCall("0712345678"); 
 
        System.out.println("\n=== POLYMORPHISM WITH INTERFACES ==="); 
 
        // Polymorphism: We can treat the Smartphone as any of its interface types. 
        Camera cam = myPhone; // A Smartphone IS-A Camera 
        MusicPlayer mp = myPhone; // A Smartphone IS-A MusicPlayer 
 
        // cam can only access camera methods. 
        cam.takePhoto();
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
// cam.playMusic(); // ERROR! The Camera interface doesn't know about playMusic(). 
         
        // mp can only access music methods. 
        mp.playMusic(); 
    } 
} 
Step 2.3: Run the Program 
Observe how the Smartphone acts as a Camera, a MusicPlayer, and a Phone depending on the 
reference type used. 
   Task 2 Complete 
• □ I created MultipleInterfaces.java 
• □ I ran the program successfully 
• □ I understand how to implement multiple interfaces 
 
TASK 3: Exception Handling (try-catch) 
Objective 
Analyze exception handling code to determine if exceptions are properly caught or propagated. 
Step 3.1: Create the File 
Create a file named ExceptionHandlingDemo.java. 
Step 3.2: Write the Code 
java 
// This program demonstrates Exception Handling using try-catch-finally blocks. 
 
public class ExceptionHandlingDemo { 
    public static void main(String[] args) {
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
// ============================================================ 
        // EXAMPLE 1: ArithmeticException (Unchecked) 
        // ============================================================ 
        System.out.println("=== EXAMPLE 1: Division by Zero ==="); 
         
        int numerator = 10; 
        int denominator = 0; 
 
        try { 
            // The code inside 'try' is monitored for errors. 
            int result = numerator / denominator;  
            System.out.println("Result: " + result); // This will NOT print 
        }  
        catch (ArithmeticException e) { 
            // If an ArithmeticException occurs in the try block,  
            // the program jumps here. The program does NOT crash. 
            System.out.println("Error caught: You cannot divide by zero!"); 
            // getMessage() prints the specific error from Java. 
            System.out.println("Java says: " + e.getMessage());  
        }  
        finally { 
            // The 'finally' block ALWAYS executes, whether an exception occurred or not. 
            System.out.println("Finally block executed (cleaning up resources)."); 
        } 
 
        System.out.println("Program continues safely...\n");
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
// ============================================================ 
        // EXAMPLE 2: ArrayIndexOutOfBoundsException (Unchecked) 
        // ============================================================ 
        System.out.println("=== EXAMPLE 2: Array Out of Bounds ==="); 
 
        int[] numbers = {1, 2, 3}; 
 
        try { 
            // Trying to access index 5, but the array only goes up to index 2. 
            System.out.println(numbers[5]);  
        }  
        catch (ArrayIndexOutOfBoundsException e) { 
            // Catch the specific error. 
            System.out.println("Error caught: The array index is out of bounds!"); 
        } 
 
        System.out.println("Program continues safely...\n"); 
 
        // ============================================================ 
        // EXAMPLE 3: Finally Block in a Method 
        // ============================================================ 
        System.out.println("=== EXAMPLE 3: Method with Exception Propagation ==="); 
        performRiskyOperation(); 
         
        System.out.println("Program finished.");
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
} 
 
    // A method that handles its own exception. 
    public static void performRiskyOperation() { 
        try { 
            // Convert a String to an Integer. 
            String text = "abc"; 
            int number = Integer.parseInt(text); // This throws NumberFormatException 
            System.out.println(number); 
        }  
        catch (NumberFormatException e) { 
            // Catch the error. 
            System.out.println("Error caught: Invalid number format."); 
        } 
    } 
} 
Step 3.3: Analyze the Output 
Run the program. Notice how the program doesn't crash at the division by zero. It prints the 
error messages and continues to the next example. 
   Task 3 Complete 
• □ I created ExceptionHandlingDemo.java 
• □ I understand that catch prevents the program from crashing 
• □ I understand that finally always runs
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
TASK 4: Custom Exceptions (Banking System) 
Objective 
Design a custom exception hierarchy for a domain-specific problem. 
Step 4.1: Create the File 
Create a file named BankingSystem.java. 
Step 4.2: Write the Code 
java 
// This program demonstrates how to create and use Custom Exceptions 
// in a real-world banking scenario. 
 
// ============================================================ 
// CUSTOM EXCEPTION 
// ============================================================ 
// We extend 'Exception' (Checked Exception) to force the programmer  
// to handle it in a try-catch block. 
class InsufficientFundsException extends Exception { 
     
    private double amount; 
 
    // Constructor 
    public InsufficientFundsException(String message, double amount) { 
        // Pass the message to the parent Exception class. 
        super(message);  
        this.amount = amount; 
    }
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
// A custom method to return the missing amount. 
    public double getShortfall() { 
        return amount; 
    } 
} 
 
// ============================================================ 
// DOMAIN CLASS 
// ============================================================ 
class BankAccount { 
    private double balance; 
 
    public BankAccount(double initialBalance) { 
        this.balance = initialBalance; 
    } 
 
    public double getBalance() { 
        return balance; 
    } 
 
    // Notice the 'throws' keyword. This declares that this method 
    // might throw an InsufficientFundsException. 
    public void withdraw(double amount) throws InsufficientFundsException { 
        // Check for the business rule error. 
        if (amount > balance) { 
            // Calculate how much is missing.
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
double shortfall = amount - balance; 
             
            // Manually throw the custom exception. 
            throw new InsufficientFundsException( 
                "Withdrawal failed. Insufficient funds.", shortfall 
            ); 
        } 
         
        // If no exception is thrown, proceed with the transaction. 
        balance -= amount; 
        System.out.println("Successfully withdrew: KSh " + amount); 
    } 
} 
 
// ============================================================ 
// MAIN CLASS 
// ============================================================ 
public class BankingSystem { 
    public static void main(String[] args) { 
         
        BankAccount account = new BankAccount(5000.0); 
        System.out.println("Current Balance: KSh " + account.getBalance()); 
 
        // We MUST use try-catch because withdraw() declares a checked exception. 
        try { 
            System.out.println("\nAttempting to withdraw KSh 10,000...");
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
// This will trigger the exception. 
            account.withdraw(10000.0); 
             
        }  
        catch (InsufficientFundsException e) { 
            // Catch the custom exception. 
            System.out.println("TRANSACTION DECLINED!"); 
            System.out.println("Error Message: " + e.getMessage()); 
            System.out.println("You are short by: KSh " + e.getShortfall()); 
        } 
 
        System.out.println("\nChecking final balance: KSh " + account.getBalance()); 
    } 
} 
Step 4.3: Evaluate the Design 
1. Why did we make InsufficientFundsException extend Exception instead of 
RuntimeException? (Hint: Exception is a Checked exception, meaning the compiler forces 
the programmer to handle it. This is safer for critical banking operations). 
2. What does the throw keyword do inside the withdraw method? 
   Task 4 Complete 
• □ I created BankingSystem.java 
• □ I understand the throws keyword 
• □ I understand the throw keyword 
• □ I created a custom exception class
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
TASK 5: Push to GitHub 
Step 5.1: Stage and Commit 
1. Open the Source Control panel in VS Code. 
2. Stage all new files in week9. 
3. Commit with message: Week 9: Interfaces & Exception Handling 
4. Push to GitHub. 
   Task 5 Complete 
• □ I committed and pushed all files 
 
       Final Self-Assessment Checklist 
• □ I can explain the difference between an Abstract Class and an Interface. 
• □ I can create a class that implements multiple interfaces. 
• □ I can write a try-catch-finally block to prevent program crashes. 
• □ I can create a custom exception by extending Exception. 
• □ I can use the throw and throws keywords correctly. 
• □ I pushed all Week 9 code to GitHub. 
 
       Troubleshooting Guide 
Problem Solution 
unreported exception ... must be caught 
or declared to be thrown 
You used a method that throws a checked 
exception (like withdraw()) but didn't put it in a 
try-catch block. 
cannot find symbol: class 
InsufficientFundsException 
Ensure the custom exception class is in the same 
folder, or imported correctly.
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
Problem Solution 
class ... is not abstract and does not 
override abstract method 
You forgot to implement a method from an 
interface you are implements-ing. 
 
    What You've Achieved 
You have just: 
• Mastered Interfaces to define strict capabilities (CAN-DO). 
• Used Multiple Interfaces to share behaviors across unrelated classes. 
• Implemented Exception Handling to make your programs crash-proof. 
• Built a Custom Exception system for a banking domain. 
Your code is now flexible, safe, and professional! 
 
        Next Steps 
In Week 10, you will: 
1. Explore the Java Collections Framework (Lists, Sets, Maps). 
2. Learn File I/O to save data permanently. 
3. Put all your skills together for the final project! 
 
END OF PRACTICAL SESSION 9
```

</details>
