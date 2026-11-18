# Week 7 - Comprehensive Notes - Inheritance and Method Overriding

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 7 - Comprehensive Notes - Inheritance and Method Overriding.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 7 – Inheritance and Method Overriding 
Course: Object-Oriented Programming (Java) 
Module 7: Inheritance and Polymorphism (Part 1) 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Analyze inheritance hierarchies to determine which fields/methods are inherited vs. 
newly added. 
2. Create a subclass that extends a superclass, overriding methods appropriately. 
3. Evaluate whether inheritance or composition is more suitable for a given relationship. 
4. Design a class hierarchy for a real-world scenario. 
 
PART 1: Introduction to Inheritance 
1.1 What is Inheritance? 
Inheritance is a fundamental Object-Oriented Programming (OOP) concept where one class (the 
subclass or child) acquires the properties (fields) and behaviors (methods) of another class (the 
superclass or parent). 
Think of it as a family tree. Just as a child inherits traits from their parents, a subclass inherits 
code from its superclass. 
Why use Inheritance? 
1. Code Reusability: You don't have to rewrite code that already exists in the parent class. 
2. Extensibility: You can add new features to a subclass without modifying the parent class. 
3. Maintainability: If you need to fix a bug in a shared behavior, you only fix it in the parent 
class. 
4. Polymorphism: It sets the stage for treating different subclasses as the same type of 
parent class (covered in Week 8).
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
1.2 The extends Keyword 
In Java, we use the extends keyword to establish an inheritance relationship. 
Syntax: 
java 
class Superclass { 
    // fields and methods 
} 
 
class Subclass extends Superclass { 
    // additional fields and methods 
} 
Example: Animal and Dog 
Every Dog is an Animal. Therefore, a Dog can inherit general animal traits (like eating and 
sleeping) and add its own specific traits (like barking). 
java 
// SUPERCLASS (Parent) 
class Animal { 
    String name; // Inherited by all subclasses 
 
    public void eat() { 
        System.out.println(name + " is eating."); 
    } 
} 
 
// SUBCLASS (Child) 
class Dog extends Animal {
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
// The Dog class automatically gets the 'name' field and the 'eat()' method. 
     
    // Unique behavior only for Dog 
    public void bark() { 
        System.out.println(name + " says Woof!"); 
    } 
} 
 
public class Main { 
    public static void main(String[] args) { 
        Dog myDog = new Dog(); 
        myDog.name = "Buddy"; // Using inherited field 
        myDog.eat();          // Calling inherited method 
        myDog.bark();         // Calling subclass-specific method 
    } 
} 
 
1.3 Analyzing Hierarchies: What is Inherited? (LO1) 
When a subclass extends a superclass, the subclass inherits: 
• All public and protected fields and methods. 
• It does not inherit private members directly (they are hidden). 
• It does not inherit constructors (but it must call them using super()). 
The protected Access Modifier 
If a parent class has a private field, the child class cannot access it directly. To allow inheritance 
while still keeping data hidden from the outside world, Java provides the protected access 
modifier.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Modifier Same Class Same Package Subclass (different package) World 
public Yes Yes Yes Yes 
protected Yes Yes Yes No 
(default) Yes Yes No No 
private Yes No No No 
 
PART 2: Constructors and the super Keyword 
2.1 Constructors in Inheritance 
Constructors are not inherited. However, when you create a subclass object, the superclass 
constructor is always called first. This ensures the parent part of the object is fully initialized 
before the child part. 
If you don't explicitly call a superclass constructor, Java automatically inserts a call to the 
superclass's no-argument constructor (super()). 
Using super() 
If the parent class does not have a no-argument constructor, you must explicitly call the parent's 
parameterized constructor using super(arguments). This must be the very first line in the 
subclass constructor. 
java 
class Employee { 
    protected String name; 
 
    // Parent constructor with parameters 
    public Employee(String name) { 
        this.name = name;
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
} 
} 
 
class Manager extends Employee { 
    private double bonus; 
 
    public Manager(String name, double bonus) { 
        // MUST call parent constructor first 
        super(name);  
        this.bonus = bonus; 
    } 
} 
 
PART 3: Method Overriding (LO2) 
3.1 What is Overriding? 
Method Overriding occurs when a subclass provides a specific implementation for a method 
that is already defined in its superclass. The method signature (name and parameters) must be 
exactly the same. 
The @Override Annotation 
It is best practice to use the @Override annotation above the overriding method. It tells the 
compiler: "I intend to override a parent method." If you make a typo (e.g., calculateAera() 
instead of calculateArea()), the compiler will catch it and throw an error. 
Using super to access parent methods 
You can use the super keyword to call the superclass's version of the overridden method. This is 
useful when you want to add to the parent's behavior rather than completely replace it. 
Example: 
java
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
class Vehicle { 
    public void start() { 
        System.out.println("Vehicle is starting..."); 
    } 
} 
 
class Car extends Vehicle { 
    @Override 
    public void start() { 
        // Call the parent's start() method first 
        super.start();  
         
        // Then add Car-specific behavior 
        System.out.println("Car engine is running smoothly."); 
    } 
} 
3.2 Overriding vs. Overloading (Crucial Distinction) 
• Overriding (Inheritance): Same method name, same parameters. Happens between a 
superclass and subclass. Resolved at runtime (dynamic binding). 
• Overloading (Compile-time): Same method name, different parameters. Can happen in 
the same class. Resolved at compile-time. 
 
PART 4: Inheritance vs. Composition (LO3) 
A common trap for beginners is using inheritance for everything. You must learn to evaluate the 
relationship. 
4.1 The "Is-A" vs. "Has-A" Rule 
• Inheritance: Represents an "Is-A" relationship.
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
o A Dog is an Animal. 
o A Manager is an Employee. 
o A Circle is a Shape. 
• Composition: Represents a "Has-A" relationship. The class contains an instance of 
another class as a field. 
o A Car has an Engine. 
o A BankAccount has a Customer. 
o A Computer has a Processor. 
4.2 Why Composition is often Preferred 
Inheritance creates a very tight bond (tight coupling) between classes. If the parent class 
changes, it might break the child class. Composition is more flexible because you can easily 
swap out the component at runtime. 
The Wrong Way (Inheritance): 
java 
// WRONG: A Car is NOT an Engine. 
class Car extends Engine {  
    // ... 
} 
The Right Way (Composition): 
java 
// RIGHT: A Car HAS an Engine. 
class Car { 
    private Engine engine; // Composition 
     
    public Car() { 
        this.engine = new Engine(); 
    }
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
} 
 
PART 5: Designing Class Hierarchies (LO4) 
When designing a system, you should look for common traits to pull up into a superclass. 
5.1 The Object Class 
In Java, every class implicitly extends the Object class. This means every class inherits methods 
from Object, such as toString(), equals(), and hashCode(). It is common to override toString() in 
your own classes to provide meaningful output when an object is printed. 
5.2 Design Example: Shapes 
Let's design a hierarchy for a graphics application. 
1. Superclass (Shape): Has a name field. Has a calculateArea() method that returns 0.0 (to 
be overridden). 
2. Subclass (Circle): Extends Shape. Adds a radius field. Overrides calculateArea() to return 
Math.PI * radius * radius. 
3. Subclass (Rectangle): Extends Shape. Adds length and width. Overrides calculateArea() 
to return length * width. 
java 
// Superclass 
class Shape { 
    protected String name; 
 
    public Shape(String name) { 
        this.name = name; 
    } 
 
    public double calculateArea() { 
        return 0.0;
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
} 
 
    @Override 
    public String toString() { 
        return "Shape: " + name; 
    } 
} 
 
// Subclass 1 
class Circle extends Shape { 
    private double radius; 
 
    public Circle(String name, double radius) { 
        super(name); 
        this.radius = radius; 
    } 
 
    @Override 
    public double calculateArea() { 
        return Math.PI * radius * radius; 
    } 
} 
 
// Subclass 2 
class Rectangle extends Shape { 
    private double length;
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
private double width; 
 
    public Rectangle(String name, double length, double width) { 
        super(name); 
        this.length = length; 
        this.width = width; 
    } 
 
    @Override 
    public double calculateArea() { 
        return length * width; 
    } 
} 
 
PART 6: Summary and Key Takeaways 
1. Inheritance allows a subclass to reuse code from a superclass using extends. 
2. protected allows subclasses to access parent fields without making them public to the 
world. 
3. super is used to call the parent constructor (must be the first line) or parent methods. 
4. Method Overriding allows a subclass to redefine a parent method. Always use 
@Override. 
5. "Is-A" (Inheritance) vs. "Has-A" (Composition). Evaluate carefully before choosing 
inheritance. 
6. All classes implicitly inherit from the Object class, meaning they have toString(), equals(), 
etc.
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
✓ Key Terms Glossary 
Term Definition 
Inheritance The mechanism where a new class acquires the properties and methods of an existing class. 
Superclass The parent class being inherited from. 
Subclass The child class that inherits from the superclass. 
extends The Java keyword used to create a subclass. 
super The keyword used to refer to the immediate parent class. 
Method 
Overriding Providing a new implementation for a parent class method in a subclass. 
@Override An annotation that ensures a method is actually overriding a superclass method. 
Composition A "has-a" relationship where a class contains an object of another class as a field. 
 
Self-Assessment Questions 
1. What is the difference between private and protected? 
2. Why must super() be the first statement in a subclass constructor? 
3. Explain the difference between Method Overloading and Method Overriding. 
4. Is a Student an University an "Is-A" or "Has-A" relationship? 
5. If a parent class has a method public void display(), and a subclass overrides it, which 
version is called when you create a subclass object?
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text

```

</details>
