# Week 8 - Practical Session - Polymorphism and Abstract Classes

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 8 - Practical Session - Polymorphism and Abstract Classes.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Practical Session 8: Polymorphism & Abstract Classes 
Student-Centered, Self-Paced Lab 
 
       Learning Outcomes Covered 
By the end of this practical session, you will be able to: 
1. Analyze polymorphic code to predict which overridden method executes at runtime. 
2. Evaluate situations where abstract classes are preferable to concrete base classes. 
3. Design an abstract class hierarchy that enforces subclasses to implement specific 
behaviors. 
4. Debug ClassCastException issues by correctly using instanceof before downcasting. 
Time Required: 120–150 minutes 
Instructor Intervention: None – you will figure it out yourself! 
 
         Before You Begin 
Ensure you have completed Week 7. You will need: 
• VS Code open 
• Your java-course folder with a new subfolder named week8 
• Git configured and connected to GitHub
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Your Roadmap 
 
TASK 1: The Magic of Polymorphism 
Objective 
Analyze how a single parent reference can hold different child objects and execute their specific 
behaviors at runtime. 
Step 1.1: Create the File 
1. Create a folder named week8 in your java-course directory. 
2. Create a file named PolymorphismDemo.java. 
Step 1.2: Write the Code 
java 
// This program demonstrates Polymorphism ("Many Forms"). 
// It shows how a superclass reference can point to a subclass object. 
 
// Superclass 
class Animal {
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
public void makeSound() { 
        // Default sound for a generic animal. 
        System.out.println("Some generic animal sound"); 
    } 
} 
 
// Subclass 1 
class Dog extends Animal { 
    // Overriding the makeSound method. 
    @Override 
    public void makeSound() { 
        // Specific sound for a Dog. 
        System.out.println("Woof! Woof!"); 
    } 
} 
 
// Subclass 2 
class Cat extends Animal { 
    // Overriding the makeSound method. 
    @Override 
    public void makeSound() { 
        // Specific sound for a Cat. 
        System.out.println("Meow!"); 
    } 
}
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
// Subclass 3 
class Cow extends Animal { 
    // Overriding the makeSound method. 
    @Override 
    public void makeSound() { 
        // Specific sound for a Cow. 
        System.out.println("Moo!"); 
    } 
} 
 
public class PolymorphismDemo { 
    public static void main(String[] args) { 
         
        // We create an array of type 'Animal'. 
        // This array can hold Dogs, Cats, and Cows because they are all Animals. 
        Animal[] myAnimals = new Animal[3]; 
         
        // Upcasting: Assigning a subclass object to a superclass reference. 
        myAnimals[0] = new Dog(); // A Dog IS-AN Animal. 
        myAnimals[1] = new Cat(); // A Cat IS-AN Animal. 
        myAnimals[2] = new Cow(); // A Cow IS-AN Animal. 
         
        System.out.println("=== ANIMAL SOUNDS ==="); 
         
        // Loop through the array. 
        for (int i = 0; i < myAnimals.length; i++) {
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
// This is Polymorphism in action! 
            // The JVM looks at the ACTUAL object type (Dog, Cat, Cow) at runtime, 
            // not the reference type (Animal), and calls the correct method. 
            myAnimals[i].makeSound(); 
        } 
    } 
} 
Step 1.3: Run and Analyze 
Run the program. Notice how myAnimals[i].makeSound() calls the specific method for each 
animal, even though the array is of type Animal. 
   Task 1 Complete 
• □ I created PolymorphismDemo.java 
• □ I ran the code and saw the different sounds. 
• □ I understand that the JVM decides which method to run at runtime. 
 
TASK 2: Abstract Classes (Enforcing Rules) 
Objective 
Evaluate why abstract classes are preferable to concrete base classes when you want to force 
subclasses to implement specific behaviors. 
Step 2.1: Create the File 
Create a file named AbstractDemo.java. 
Step 2.2: Write the Code 
java 
// This program demonstrates Abstract Classes. 
// An abstract class cannot be instantiated (you cannot do 'new Shape()'). 
// It acts as a strict contract for subclasses.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
// Abstract Superclass 
abstract class Shape { 
    protected String name; 
 
    public Shape(String name) { 
        this.name = name; 
    } 
 
    // Abstract method: Has no body! 
    // Any concrete (non-abstract) subclass MUST implement this method. 
    public abstract double calculateArea(); 
 
    // Concrete method: Has a body. Inherited by subclasses. 
    public void displayName() { 
        System.out.println("Shape: " + name); 
    } 
} 
 
// Concrete Subclass 1 
class Circle extends Shape { 
    private double radius; 
 
    public Circle(double radius) { 
        // Call the abstract parent constructor. 
        super("Circle");
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
this.radius = radius; 
    } 
 
    // IMPLEMENTING the abstract method. 
    @Override 
    public double calculateArea() { 
        return Math.PI * radius * radius; 
    } 
} 
 
// Concrete Subclass 2 
class Rectangle extends Shape { 
    private double length; 
    private double width; 
 
    public Rectangle(double length, double width) { 
        super("Rectangle"); 
        this.length = length; 
        this.width = width; 
    } 
 
    // IMPLEMENTING the abstract method. 
    @Override 
    public double calculateArea() { 
        return length * width; 
    }
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
} 
 
public class AbstractDemo { 
    public static void main(String[] args) { 
         
        // Shape s = new Shape("Test"); // ERROR! Cannot instantiate an abstract class. 
         
        // Polymorphism again: We use the abstract class as a reference type. 
        Shape myCircle = new Circle(5.0); 
        Shape myRect = new Rectangle(4.0, 6.0); 
         
        myCircle.displayName(); 
        System.out.println("Area: " + myCircle.calculateArea()); 
         
        System.out.println(); 
         
        myRect.displayName(); 
        System.out.println("Area: " + myRect.calculateArea()); 
    } 
} 
Step 2.3: Evaluate Abstract vs Concrete 
Question to consider: Why not just make Shape a regular (concrete) class with a dummy 
calculateArea() method that returns 0? 
Answer: If it were concrete, someone could write Shape s = new Shape();. A generic "Shape" 
doesn't exist in reality (it's always a specific shape like a circle or square). Abstract classes 
prevent this logical error. They say: "You must be a specific type of shape to be created."
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
Task 2 Complete 
• □ I created AbstractDemo.java 
• □ I understand why new Shape() is illegal. 
• □ I can explain why abstract classes are useful. 
 
TASK 3: Upcasting, Downcasting & instanceof 
Objective 
Debug ClassCastException by correctly identifying an object's type before downcasting. 
Step 3.1: Create the File 
Create a file named CastingDemo.java. 
Step 3.2: Write the Code 
java 
// This program demonstrates Upcasting, Downcasting, and how to prevent 
// the dreaded ClassCastException using the 'instanceof' operator. 
 
class Vehicle { } 
class Car extends Vehicle { 
    public void openTrunk() { 
        System.out.println("Trunk opened."); 
    } 
} 
class Bike extends Vehicle { } 
 
public class CastingDemo { 
    public static void main(String[] args) {
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
// UPCASTING (Implicit): Assigning a subclass to a superclass reference. 
        // This is always safe. 
        Vehicle v1 = new Car();  
        Vehicle v2 = new Bike(); 
         
        System.out.println("Upcasting successful."); 
         
        // DOWNCASTING (Explicit): Assigning a superclass reference back to a subclass. 
        // This is DANGEROUS if you don't check the actual type! 
         
        // THE BUG: v2 is actually a Bike, but we are trying to force it to be a Car. 
        // If you uncomment the line below, the program will CRASH with a ClassCastException. 
        // Car myCar = (Car) v2;  
        // myCar.openTrunk(); 
         
        // THE FIX: Always use the 'instanceof' operator to check the type BEFORE downcasting. 
        System.out.println("\nChecking types safely..."); 
         
        if (v1 instanceof Car) { 
            // It is safe to cast because v1 is actually a Car. 
            Car c1 = (Car) v1; 
            c1.openTrunk(); // Works perfectly. 
        } 
         
        if (v2 instanceof Car) { 
            // This block will NOT execute because v2 is a Bike, not a Car.
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
System.out.println("This will not print."); 
        } else { 
            System.out.println("v2 is not a Car, it is a Bike. Downcasting prevented!"); 
        } 
    } 
} 
Step 3.3: Experiment 
1. Run the code as is. Read the output. 
2. Uncomment the buggy lines (lines 23-24). Run it again. Read the error message: 
ClassCastException. 
3. Re-comment those lines and ensure you understand how instanceof saved the program 
from crashing. 
   Task 3 Complete 
• □  I created CastingDemo.java 
• □  I saw the ClassCastException and fixed it using instanceof. 
 
TASK 4: Integrated Fintech System 
Objective 
Design an abstract class hierarchy for a real-world scenario and process a list of polymorphic 
objects. 
Step 4.1: Create the File 
Create a file named FintechSystem.java. 
Step 4.2: Write the Code 
java 
// This program applies Abstract Classes and Polymorphism to a Fintech scenario. 
 
// Abstract Superclass
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
abstract class PaymentMethod { 
    protected String accountName; 
 
    public PaymentMethod(String accountName) { 
        this.accountName = accountName; 
    } 
 
    // Abstract method: Forces all payment types to implement their own processing logic. 
    public abstract void processPayment(double amount); 
} 
 
// Subclass 1 
class MpesaPayment extends PaymentMethod { 
    private String phoneNumber; 
 
    public MpesaPayment(String accountName, String phoneNumber) { 
        super(accountName); 
        this.phoneNumber = phoneNumber; 
    } 
 
    @Override 
    public void processPayment(double amount) { 
        System.out.println("Processing M-Pesa payment of KSh " + amount + " for " + 
accountName); 
        System.out.println("  Sending STK push to: " + phoneNumber); 
    }
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
} 
 
// Subclass 2 
class CardPayment extends PaymentMethod { 
    private String cardNumber; 
 
    public CardPayment(String accountName, String cardNumber) { 
        super(accountName); 
        this.cardNumber = cardNumber; 
    } 
 
    @Override 
    public void processPayment(double amount) { 
        System.out.println("Processing Credit Card payment of KSh " + amount + " for " + 
accountName); 
        // Mask the card number for security 
        System.out.println("  Charging card ending in: " + 
cardNumber.substring(cardNumber.length() - 4)); 
    } 
} 
 
public class FintechSystem { 
    public static void main(String[] args) { 
         
        // Create an array of the abstract type 'PaymentMethod'. 
        // This is the power of polymorphism. 
        PaymentMethod[] cart = new PaymentMethod[3];
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
cart[0] = new MpesaPayment("Alice", "0712345678"); 
        cart[1] = new CardPayment("Bob", "1234567812345678"); 
        cart[2] = new MpesaPayment("Charlie", "0798765432"); 
         
        double totalRevenue = 0.0; 
         
        System.out.println("=== PROCESSING TRANSACTIONS ==="); 
         
        // Loop through the array. 
        for (int i = 0; i < cart.length; i++) { 
            double amount = 1500.0; // Assume each pays 1500 
             
            // The specific processPayment method is called based on the actual object. 
            cart[i].processPayment(amount); 
            totalRevenue += amount; 
            System.out.println("-------------------------"); 
        } 
         
        System.out.println("Total Revenue Collected: KSh " + totalRevenue); 
    } 
} 
Step 4.3: Run the Program 
Observe how the loop handles both M-Pesa and Card payments seamlessly without needing if-
else statements to check what type of payment it is.
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
Task 4 Complete 
• □ I created FintechSystem.java 
• □ I ran the program successfully. 
• □ I understand how polymorphism makes the loop clean and extendable. 
 
TASK 5: Push to GitHub 
Step 5.1: Stage and Commit 
1. Open the Source Control panel in VS Code. 
2. Stage all new files in week8. 
3. Commit with message: Week 8: Polymorphism, Abstract Classes, and instanceof 
4. Push to GitHub. 
   Task 5 Complete 
• □  I committed and pushed all files 
 
       Final Self-Assessment Checklist 
• □ I can explain what polymorphism means in Java. 
• □ I understand how an array of a superclass type can hold subclass objects. 
• □ I know why abstract classes cannot be instantiated. 
• □ I can create an abstract method and force subclasses to implement it. 
• □ I know how to use the instanceof operator to prevent ClassCastException. 
• □ I pushed all Week 8 code to GitHub.
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
Troubleshooting Guide 
Problem Solution 
ClassCastException You tried to force a parent object into a child type that it isn't. Use if (obj instanceof ChildType) first. 
Cannot instantiate the type Shape You are trying to do new Shape(). Abstract classes cannot be instantiated. Instantiate a subclass instead. 
The type ... must implement the 
inherited abstract method 
You forgot to write the @Override method in your 
subclass. 
 
    What You've Achieved 
You have just: 
• Mastered Polymorphism (one interface, many behaviors). 
• Used Abstract Classes to enforce contracts. 
• Safely navigated the dangers of Casting using instanceof. 
• Built a Fintech Payment System that handles multiple payment types seamlessly. 
You are now writing code that scales and adapts easily!
```

</details>
