# Week 7 - Understanding What You Have Achieved

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 7 - Understanding What You Have Achieved.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Understanding What You Have Achieved 
Your Learning Journey: Week 7 Practical Session 
Dear Student, 
Congratulations! You have just unlocked one of the most powerful superpowers in Object-
Oriented Programming: Inheritance. 
In Week 7, you learned how to stop writing repetitive code and start creating relationships 
between classes. You moved from building isolated objects to designing entire systems where 
classes share, extend, and customize behaviors. This is the exact architectural thinking used by 
software engineers building massive systems like M-Pesa, banking apps, and e-commerce 
platforms. 
Here is a look at exactly what you have achieved and why it matters in the real world. 
 
✓ Your Achievement Map
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
✓ Learning Outcome 1: Analyze inheritance hierarchies to determine which 
fields/methods are inherited vs newly added 
What You Did: 
In Task 1, you created a parent class called Animal and a child class called Dog. You saw that 
when Dog used the extends keyword, it magically gained the name field and the eat() and 
sleep() methods from Animal, even though you didn't rewrite them inside the Dog class. 
What You Learned: 
Inheritance allows a child class to inherit allViewController attributes and behaviors from a 
parent class. The child can then focus only on writing its unique behaviors (like bark()). 
Real-Life Scenario: 
Think about Safaricom's billing system. They have different types of customers: 
PrepaidCustomers and PostpaidCustomers. 
Instead of writing code to collect a customer's name, ID, and phone number twice, Safaricom's 
developers created a parent class called Customer with those fields. Both Prepaid and Postpaid 
extend Customer. They inherit the basic data, but add their own unique features (like 
checkAirtimeBalance() for Prepaid, or generateMonthlyInvoice() for Postpaid). 
 
✓ Learning Outcome 2: Create a subclass that extends a superclass, overriding methods 
appropriately 
What You Did: 
In Task 2, you created an Employee class with a calculateSalary() method. Then you created a 
Manager subclass. You used Method Overriding to change how the Manager's salary is 
calculated (by adding a bonus), while using the super keyword to reuse the base calculation 
from the Employee class. 
What You Learned: 
Overriding allows a child class to provide a specific implementation of a method that is already 
provided by its parent class. The @Override annotation ensures you are actually overriding a 
method and haven't made a typo. 
Real-Life Scenario: 
Imagine building the checkout system for Jumia or Kilimall. 
You have a StandardShipping class with a method calculateCost(). Later, the company introduces
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
ExpressShipping. You don't need to rewrite the entire shipping class. You just create an 
ExpressShipping subclass and override the calculateCost() method to return a higher price for 
faster delivery. Everything else (like package tracking and address validation) is inherited 
automatically. 
 
✓ Learning Outcome 3: Evaluate whether inheritance or composition is more suitable 
for a given relationship 
What You Did: 
In Task 4, you learned a crucial rule: "Is-a" vs. "Has-a". 
You learned that a Car should NOT extend Engine (a car is not an engine). Instead, a Car HAS-A 
Engine. You implemented this using Composition (creating an Engine object inside the Car 
class). 
What You Learned: 
Inheritance should only be used for strict "Is-A" relationships (A Dog IS AN Animal). Composition 
is used for "Has-A" relationships (A BankAccount HAS A TransactionHistory). Choosing wrong 
can lead to fragile, broken code. 
Real-Life Scenario: 
Suppose you are coding an Equity Bank App. 
You have a Customer class and an Address class. 
• Wrong: class Customer extends Address (A customer is not an address). 
• Right (Composition): class Customer { Address homeAddress; }. 
By using composition, if the customer moves to a new house, you simply update their 
Address object without destroying the Customer object. This keeps systems stable and 
secure. 
 
✓ Learning Outcome 4: Design a class hierarchy for a real-world scenario 
What You Did: 
In Task 5, you designed a complete hierarchy: Shape as the parent, and Circle and Rectangle as 
children. You also overrode the toString() method to ensure the shapes displayed their 
properties properly. 
What You Learned:
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Good design starts with a blueprint. By creating a common parent (Shape), you can group 
related objects together. Later in Week 8, you will learn that you can put all Shapes into a single 
list and process them together, which is incredibly powerful. 
Real-Life Scenario: 
Consider a Hospital Management System in Nairobi. 
You design a parent class Person (with name, age, and ID). 
• The Doctor subclass inherits Person but adds a specialization field. 
• The Patient subclass inherits Person but adds an admissionDate and bloodGroup. 
This hierarchy makes it incredibly easy for the hospital software to manage different 
types of people without creating a chaotic, unorganized mess of code. 
 
✓ Your Progress: Where You Started vs. Where You Are Now 
Before Week 7 After Week 7 
You wrote separate, unconnected 
classes. 
You can make classes inherit from each other using 
extends. 
You duplicated code if two classes 
had similar features. You can push shared code up to a parent class. 
You didn't know what super meant. You can use super to call parent constructors and methods. 
You thought inheritance was the 
answer to everything. 
You can evaluate and choose between Composition 
("Has-a") and Inheritance ("Is-a"). 
You had basic, standalone objects. You can design complex, hierarchical systems. 
 
       How to Prove You've Achieved These Outcomes 
Here are the artifacts (proof) you now have in your GitHub repository (week7 folder):
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
1. InheritanceDemo.java (Shows basic extends and inherited methods). 
2. OverridingDemo.java (Shows @Override, super, and custom methods). 
3. CompositionDemo.java (Shows how to build classes using "Has-a" relationships). 
4. ShapeHierarchy.java (Shows a complete, designed class hierarchy). 
These files prove you understand how to architect software, not just write scripts. 
 
   Student Reflection: In Your Own Words 
Answer these questions in your notebook: 
1. What is the difference between a superclass and a subclass? 
2. Why did we use super() inside the constructor of the subclass? 
3. If a parent class has a private field, can a subclass access it directly? (Hint: No. What 
should you do instead?) 
4. Come up with one example of an "Is-a" relationship and one "Has-a" relationship from 
your daily life. 
 
✓ What's Next? 
In Week 8, you will learn the magic that happens when Inheritance meets Overriding: 
Polymorphism. 
You will discover how to write code that can handle a Dog, a Cat, and a Cow all at the same time 
without knowing exactly which animal it is until the program runs! 
Before you move on, make sure you can say YES to these: 
• □ I know how to use the extends keyword. 
• □ I can override a method and use @Override. 
• □ I understand when to use Composition instead of Inheritance. 
• □ I have pushed my Week 7 code to GitHub. 
• □ I am ready to learn about Polymorphism! 
Keep coding. You are doing great!
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text

```

</details>
