# Week 6 - Comprehensive Notes - Deep Dive into Classes and Objects

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 6 - Comprehensive Notes - Deep Dive into Classes and Objects.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Comprehensive Notes: Week 6 – Deep Dive into Classes and Objects 
Course: Object-Oriented Programming (Java) 
Module 5: Deep Dive into Methods and Encapsulation 
 
Learning Outcomes Covered 
By the end of this week, you should be able to: 
1. Analyze a class design to identify encapsulation violations and propose fixes. 
2. Create a well-encapsulated class with private fields, constructors, and public access 
methods. 
3. Evaluate the necessity of getters/setters when fields could be made public. 
4. Design a simple domain model (e.g., BankAccount, Student) with appropriate fields and 
methods. 
 
PART 1: The Core of OOP – Classes and Objects 
1.1 What is a Class? 
A class is a blueprint or template for creating objects. It defines two things: 
• Fields (Attributes): The data the object holds (e.g., a BankAccount has a balance and an 
accountNumber). 
• Methods (Behaviors): The actions the object can perform (e.g., deposit(), withdraw()). 
1.2 What is an Object? 
An object is a specific instance of a class. 
• Dog is a class. 
• myDog = new Dog(); is an object.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
PART 2: Encapsulation (LO1 & LO2) 
2.1 What is Encapsulation? 
Encapsulation is the principle of bundling data (fields) and the methods that operate on that 
data into a single unit (a class), while hiding the internal state of the object from the outside 
world. 
Think of it as a protective capsule. You cannot change the state of the object directly; you must 
use the methods provided by the class. 
The Problem: Public Fields (Encapsulation Violation) 
If you make fields public, any other class can change them to invalid values. 
java 
class BadAccount { 
    public double balance = 1000.0; 
} 
 
public class Main { 
    public static void main(String[] args) { 
        BadAccount acc = new BadAccount(); 
        acc.balance = -5000.0; // No validation! The system is corrupted. 
    } 
} 
The Fix: Private Fields 
We make fields private. A private field can only be accessed within the same class. 
Access Modifiers Recap 
Modifier Same Class Same Package Subclass World 
public Yes Yes Yes Yes
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Modifier Same Class Same Package Subclass World 
protected Yes Yes Yes No 
default Yes Yes No No 
private Yes No No No 
 
2.2 Constructors (Initializing the Object) 
A constructor is a special method that runs exactly once when you create an object using the 
new keyword. Its job is to initialize the object's fields. 
Rules of Constructors: 
1. The name must be exactly the same as the class name. 
2. It cannot have a return type (not even void). 
3. If you don't write one, Java provides a default no-argument constructor. 
Using Constructors for Validation 
You can use a constructor to ensure the object is never created with invalid data. 
java 
public class Student { 
    private String name; 
    private int age; 
 
    // Parameterized Constructor 
    public Student(String name, int age) { 
        this.name = name; 
        // Validation in the constructor 
        if (age >= 0 && age <= 150) {
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
this.age = age; 
        } else { 
            this.age = 0; // Default safe value 
        } 
    } 
} 
2.3 The this Keyword 
The this keyword refers to the current object. 
It is most commonly used to resolve "shadowing" conflicts when a parameter has the same 
name as a field. 
java 
public void setName(String name) { 
    // "this.name" refers to the field. "name" refers to the parameter. 
    this.name = name;  
} 
Constructor Chaining (this()) 
You can call one constructor from another constructor within the same class using this(). This 
must be the first statement in the constructor. It prevents code duplication. 
java 
public class Employee { 
    private String name; 
    private double salary; 
 
    // Master Constructor 
    public Employee(String name, double salary) { 
        this.name = name; 
        this.salary = salary;
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
} 
 
    // Overloaded Constructor (gives default salary) 
    public Employee(String name) { 
        this(name, 25000.0); // Calls the master constructor 
    } 
} 
 
PART 3: Getters and Setters (LO3) 
To allow the outside world to interact with our private fields, we use Getter (accessor) and 
Setter (mutator) methods. 
3.1 Getters 
A getter returns the value of a private field. 
java 
public double getBalance() { 
    return balance; 
} 
3.2 Setters 
A setter allows you to update a private field. Setters are where you put your validation logic. 
java 
public void setAge(int age) { 
    if (age > 0 && age < 150) { 
        this.age = age; 
    } else { 
        System.out.println("Invalid age!"); 
    }
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
} 
3.3 Evaluating the Necessity of Getters/Setters 
Do you need a getter and setter for every field? No. You must evaluate the business rules. 
Field Getter? Setter? Why? 
Student Name Yes Yes Names can change (marriage, etc.) 
Student ID Yes No IDs are assigned once and never change. 
Bank Balance Yes No Balance should only change via deposit() or withdraw(). 
Account 
Password No Yes You should never be able to read a password, but you should be able to change it. 
Key Evaluation Concept: Omitting a setter makes a field read-only from the outside. This is 
critical for security. If there is no setBalance() method, a hacker cannot set your balance to 
1,000,000. They must go through the strict logic of the deposit() method. 
 
PART 4: Designing a Domain Model (LO4) 
A Domain Model is a representation of the real-world entities in your system. 
4.1 Designing the BankAccount Class 
When designing a domain model, follow these steps: 
1. Identify Attributes: What data does it need? (Account Number, Holder Name, Balance). 
2. Apply Encapsulation: Make all fields private. 
3. Identify Business Rules: What are the constraints? (Balance cannot be negative, deposit 
amount must be positive). 
4. Create Behaviors: Create methods that enforce these rules (deposit, withdraw).
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
Complete Domain Model Example: 
java 
public class BankAccount { 
    // 1. Private Fields 
    private String accountNumber; 
    private String accountHolderName; 
    private double balance; 
 
    // 2. Constructor with validation 
    public BankAccount(String accountNumber, String accountHolderName, double 
initialBalance) { 
        this.accountNumber = accountNumber; 
        this.accountHolderName = accountHolderName; 
         
        if (initialBalance >= 0) { 
            this.balance = initialBalance; 
        } else { 
            this.balance = 0; 
        } 
    } 
 
    // 3. Getters (Read-only access) 
    public String getAccountNumber() { return accountNumber; } 
    public String getAccountHolderName() { return accountHolderName; } 
    public double getBalance() { return balance; }
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
// NO SETTER for balance! (Evaluated as a security risk) 
 
    // 4. Business Logic Methods 
    public void deposit(double amount) { 
        if (amount > 0) { 
            balance += amount; 
        } else { 
            System.out.println("Error: Deposit amount must be positive."); 
        } 
    } 
 
    public void withdraw(double amount) { 
        if (amount <= 0) { 
            System.out.println("Error: Withdrawal amount must be positive."); 
        } else if (amount > balance) { 
            System.out.println("Error: Insufficient funds."); 
        } else { 
            balance -= amount; 
        } 
    } 
} 
 
PART 5: Summary and Key Takeaways 
1. Encapsulation is hiding your data (private fields) and forcing interaction through 
methods. 
2. Constructors initialize objects and can enforce validation rules at the moment of 
creation.
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
3. The this keyword refers to the current object and is used to resolve variable shadowing. 
4. Getters and Setters provide controlled access to private data. Setters should contain 
validation. 
5. Evaluate necessity: Not every field needs a getter and setter. Omit setters for fields that 
shouldn't change (like a balance). 
6. Domain Modeling is the process of mapping real-world entities and business rules into 
Java classes. 
 
✓ Key Terms Glossary 
Term Definition 
Class A blueprint for creating objects. 
Object An instance of a class. 
Encapsulation Hiding internal state and requiring all interaction to be performed through methods. 
Access 
Modifier 
Keywords (public, private, protected) that set the visibility of classes and 
members. 
Constructor A special method used to initialize an object. 
this A reference to the current object. 
Getter A method used to retrieve the value of a private field. 
Setter A method used to modify the value of a private field, often with validation. 
Domain Model A conceptual model of a system that incorporates data and behavior.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Self-Assessment Questions 
1. Why is making a field public considered a bad practice? 
2. What is the primary purpose of a constructor? 
3. Explain the difference between a getter and a setter. 
4. Why would you intentionally NOT write a setter for a field? 
5. How does the this keyword help resolve naming conflicts? 
6. What is constructor chaining and how is it achieved?
```

</details>
