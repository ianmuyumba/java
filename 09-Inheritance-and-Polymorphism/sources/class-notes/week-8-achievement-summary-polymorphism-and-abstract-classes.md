# Week 8 - Achievement Summary - Polymorphism and Abstract Classes

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 8 - Achievement Summary - Polymorphism and Abstract Classes.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Week 8 Achievement Summary: Polymorphism & Abstract Classes 
Dear Student, 
In Week 8, you leveled up your Object-Oriented Programming skills. You moved beyond just 
inheriting code and learned how to make your programs dynamic, flexible, and intelligent. 
You unlocked the magic of Polymorphism (which means "many forms") and learned how to 
enforce strict rules using Abstract Classes. Here is a summary of what you achieved and how it 
is used in the real world. 
 
    Learning Outcome 1: Analyze polymorphic code to predict which overridden method 
executes at runtime. 
What You Learned: 
You learned how to use a single parent reference (e.g., Animal a) to hold different child objects 
(e.g., new Dog(), new Cat()). You discovered that the Java Virtual Machine (JVM) looks at the 
actual object at runtime, not the reference type, to decide which method to run. 
Real-Life Application: 
Think about M-Pesa or PayPal checkout systems. The system has a parent class called 
PaymentMethod with a method processPayment(). It has child classes like MpesaPayment, 
CardPayment, and PayPalPayment. The checkout loop simply calls payment.processPayment(). It 
doesn't need a giant if-else statement to check which payment type it is; polymorphism ensures 
the correct processing logic is executed automatically at runtime. 
 
    Learning Outcome 2: Evaluate situations where abstract classes are preferable to concrete 
base classes. 
What You Learned: 
You learned that an abstract class cannot be instantiated (you cannot do new Animal() or new 
Shape()). You evaluated that if a concept is too generic or doesn't exist in reality, it should be 
abstract. It provides a common template while preventing logical errors. 
Real-Life Application: 
Consider a University HR System. You have a parent class called StaffMember. Can you hire a 
generic StaffMember? No! They must be a specific type, like a Professor, Janitor, or 
Administrator. By making StaffMember an abstract class, the software architects prevent the 
system from creating invalid, generic employee records.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Learning Outcome 3: Design an abstract class hierarchy that enforces subclasses to 
implement specific behaviors. 
What You Learned: 
You used abstract methods to create a strict contract. If a parent class declares public abstract 
void calculateArea();, every single child class must write the code for it, or the program won't 
compile. 
Real-Life Application: 
Think of an E-commerce or SaaS billing system. You have an abstract class Subscription with an 
abstract method calculateMonthlyBill(). When developers create new subscription types (e.g., 
NetflixPremium, NetflixBasic, SpotifyFamily), the compiler forces them to write the exact billing 
logic for each one. This guarantees that no developer can ever forget to add the pricing logic for 
a new product. 
 
    Learning Outcome 4: Debug ClassCastException issues by correctly using instanceof before 
downcasting. 
What You Learned: 
You learned that while you can put a Dog into an Animal reference (Upcasting), forcing an 
Animal reference back into a Dog (Downcasting) is dangerous. If the object is actually a Cat, the 
program will crash with a ClassCastException. You learned to use the instanceof operator as a 
safety check before downcasting. 
Real-Life Application: 
Imagine a School Portal where the system loads a mixed list of Users (Admins, Teachers, and 
Students). The system loops through the list. Before granting access to the "Grade Book" 
feature, the system checks if (user instanceof Teacher). If it is, it safely downcasts and opens the 
grade book. If it's a student, it skips the downcast, preventing the whole portal from crashing. 
 
        The Big Picture 
You are no longer just writing code that works; you are writing code that is adaptable. In the 
software industry, requirements change every week. Polymorphism and Abstract Classes allow 
you to add new features (like a new payment method or a new employee type) without 
breaking the existing code.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Before class starts, make sure your Week 8 code is pushed to GitHub! See you in Week 9 
(Interfaces & Exception Handling)!
```

</details>
