# Week 8 - Comprehensive Notes - Polymorphism and Abstract Classes

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 8 - Comprehensive Notes - Polymorphism and Abstract Classes.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 8 – Polymorphism and Abstract Classes 
Course: Object-Oriented Programming (Java) 
Module 8: Core OOP Concepts (Part 2) 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Analyze polymorphic code to predict which overridden method executes at runtime. 
2. Evaluate situations where abstract classes are preferable to concrete base classes. 
3. Design an abstract class hierarchy that enforces subclasses to implement specific 
behaviors. 
4. Debug ClassCastException issues by correctly using instanceof before downcasting. 
 
PART 1: The Magic of Polymorphism 
1.1 What is Polymorphism? 
Polymorphism comes from Greek words meaning "many forms." In Java, it is the ability of an 
object to take on many forms. Specifically, it means that a superclass reference variable can 
hold a subclass object. 
This allows you to write code that doesn't need to change when you introduce new subclasses. 
You can write a single method that handles a generic parent type, and it will automatically work 
for any child type. 
1.2 Upcasting (The Safe Way) 
Upcasting is assigning a subclass object to a superclass reference. 
• It is implicit (automatic) and safe. 
• Because a Dog is an Animal, it's perfectly fine to treat a Dog as an Animal. 
java 
class Animal { } 
class Dog extends Animal { }
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
public class Main { 
    public static void main(String[] args) { 
        // Upcasting: Dog object assigned to Animal reference 
        Animal myAnimal = new Dog(); // This is safe and allowed! 
    } 
} 
1.3 Dynamic Method Dispatch (Runtime Polymorphism) 
When you call an overridden method using an upcasted reference, the Java Virtual Machine 
(JVM) decides at runtime which version of the method to execute based on the actual object 
type, not the reference type. 
• Reference Type (Left side): Determines what methods you are allowed to call. 
• Object Type (Right side): Determines which specific implementation of the method will 
run. 
java 
class Animal { 
    public void makeSound() { System.out.println("Animal sound"); } 
} 
class Dog extends Animal { 
    @Override 
    public void makeSound() { System.out.println("Woof"); } 
} 
class Cat extends Animal { 
    @Override 
    public void makeSound() { System.out.println("Meow"); } 
}
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
public class Main { 
    public static void main(String[] args) { 
        Animal a1 = new Dog(); 
        Animal a2 = new Cat(); 
         
        a1.makeSound(); // Output: Woof (JVM knows a1 is actually a Dog) 
        a2.makeSound(); // Output: Meow (JVM knows a2 is actually a Cat) 
    } 
} 
1.4 Why Polymorphism is Powerful 
If you have 100 different types of animals, you don't need 100 different methods to make them 
speak. You just need one: 
java 
// One method handles all subclasses 
public static void triggerSound(Animal a) { 
    a.makeSound(); // Polymorphism in action! 
} 
 
PART 2: Abstract Classes (Evaluating the Need) 
2.1 What is an Abstract Class? 
An abstract class is a class that cannot be instantiated (you cannot use the new keyword on it). 
It is a template or a blueprint that is meant to be extended by subclasses. 
java 
// The 'abstract' keyword makes the class abstract 
abstract class Shape { 
    // Class body 
}
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
java 
// ERROR: Cannot instantiate an abstract class 
// Shape s = new Shape();  
2.2 Why Use Abstract Classes? (LO2: Evaluate) 
Why not just make Shape a regular (concrete) class with an empty calculateArea() method that 
returns 0? 
Evaluation: 
1. Logical Reality: In the real world, there is no such thing as a generic "Shape." Shapes are 
always specific (Circle, Square, Triangle). Creating a generic Shape object is a logical 
error. Abstract classes prevent this. 
2. Enforcing Contracts: If Shape is a regular class with a dummy method, a lazy 
programmer might create class Circle extends Shape and forget to override the 
calculateArea() method. The program would compile, but circle.calculateArea() would 
return 0, causing a silent bug. Abstract classes prevent this by throwing a compilation 
error if a subclass forgets to implement required methods. 
When to use an Abstract Class: 
• When you want to share code (fields and concrete methods) among closely related 
classes, but the base class itself is too generic to exist on its own. 
• When you want to force subclasses to implement specific behaviors (abstract methods). 
 
PART 3: Designing Abstract Class Hierarchies (LO3) 
3.1 Abstract Methods 
An abstract method is a method with no body (no implementation). It forces the subclass to 
provide the implementation. 
java 
abstract class Shape { 
    protected String name; 
 
    // Abstract method (no curly braces)
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
public abstract double calculateArea(); 
} 
3.2 The Golden Rule of Abstract Classes 
1. If a class contains at least one abstract method, the class itself must be declared 
abstract. 
2. A subclass of an abstract class must implement (override) all inherited abstract methods. 
If it doesn't, the subclass must also be declared abstract. 
3.3 Designing the Hierarchy 
Let's design an abstract hierarchy for a Fintech application. 
java 
// Abstract Superclass 
abstract class PaymentMethod { 
    protected String accountName; 
 
    public PaymentMethod(String accountName) { 
        this.accountName = accountName; 
    } 
 
    // Abstract method: FORCES subclasses to implement their own logic 
    public abstract void processPayment(double amount); 
     
    // Concrete method: Shared by all 
    public void printReceipt() { 
        System.out.println("Receipt printed for " + accountName); 
    } 
}
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
// Subclass 1 
class MpesaPayment extends PaymentMethod { 
    public MpesaPayment(String accountName) { super(accountName); } 
     
    @Override 
    public void processPayment(double amount) { 
        System.out.println("Processing M-Pesa payment of KSh " + amount); 
    } 
} 
 
// Subclass 2 
class CardPayment extends PaymentMethod { 
    public CardPayment(String accountName) { super(accountName); } 
     
    @Override 
    public void processPayment(double amount) { 
        System.out.println("Processing Credit Card payment of KSh " + amount); 
    } 
} 
Notice how processPayment() has no body in the parent class. It is simply a rule. The subclasses 
are forced to define exactly how the payment is processed. 
 
PART 4: Debugging Casting Issues (LO4) 
4.1 Downcasting 
Downcasting is converting a superclass reference back to a subclass reference. 
Unlike Upcasting, Downcasting is explicit and dangerous. 
java
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
Animal a = new Dog(); // Upcasting (Safe) 
Dog d = (Dog) a;      // Downcasting (Explicit cast) 
4.2 The Dreaded ClassCastException 
If you try to downcast an object to a type that it is not, the JVM throws a ClassCastException at 
runtime, and your program crashes. 
java 
Animal a = new Cat(); // Actual object is a Cat 
Dog d = (Dog) a;      // CRASH! ClassCastException (Cat cannot be forced into a Dog) 
4.3 The Solution: The instanceof Operator 
To debug and prevent ClassCastException, you must use the instanceof operator to check the 
actual object type before downcasting. 
java 
Animal myAnimal = new Cat(); 
 
// Check if the object is actually a Dog before casting 
if (myAnimal instanceof Dog) { 
    // Safe to cast! 
    Dog d = (Dog) myAnimal; 
    d.makeSound(); 
} else { 
    System.out.println("This animal is not a dog. Downcast prevented."); 
} 
When to use Downcasting: 
You usually only downcast when you have a generic list of parent objects (e.g., a list of 
PaymentMethods), and you need to access a method that exists only in a specific subclass (e.g., 
CardPayment has a verifyCVV() method that MpesaPayment doesn't have).
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
PART 5: Summary and Key Takeaways 
1. Polymorphism allows a parent reference to hold a child object (Animal a = new Dog();). 
2. Dynamic Binding means the JVM decides which method to run at runtime, based on the 
actual object type. 
3. Abstract Classes cannot be instantiated. They are used to enforce a contract and prevent 
the creation of illogical, generic objects. 
4. Abstract Methods have no body and force subclasses to implement specific logic. 
5. Downcasting (casting a parent back to a child) must be checked with instanceof to avoid 
ClassCastException. 
 
             Key Terms Glossary 
Term Definition 
Polymorphism The ability of a parent class reference to refer to a child class object. 
Upcasting Assigning a subclass object to a superclass reference (implicit and safe). 
Downcasting Assigning a superclass reference back to a subclass reference (explicit and risky). 
Dynamic Binding The process where the JVM resolves overridden method calls at runtime. 
Abstract Class A class that cannot be instantiated and may contain abstract methods. 
Abstract Method A method without a body that must be implemented by subclasses. 
ClassCastException A runtime error thrown when an object is cast to a type it is not.
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
Term Definition 
instanceof An operator used to check an object's actual type before casting. 
 
Self-Assessment Questions 
1. If Car extends Vehicle, is Vehicle v = new Car(); an example of Upcasting or Downcasting? 
Is it safe? 
2. Why can't you do Shape s = new Shape(); if Shape is an abstract class? 
3. How does polymorphism help reduce code duplication in a loop? 
4. What happens if you try to downcast an object without using instanceof?
```

</details>
