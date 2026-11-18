# Week 6 - Understanding What You Have Achieved

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 6 - Understanding What You Have Achieved.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Understanding What You Have Achieved 
Your Learning Journey: Week 6 Practical Session 
Dear Student, 
You have just completed a major milestone in your programming journey. In Week 6, you didn't 
just learn new syntax—you learned the core philosophy of Object-Oriented Programming: 
protecting data and modeling the real world. 
You built secure classes, prevented data corruption, and designed a real-world banking system. 
This is the exact type of thinking that separates a beginner coder from a professional software 
engineer. 
Here is a look at what you have achieved and why it matters in the real world. 
 
✓ Your Achievement Map
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
✓ Learning Outcome 1: Analyze a class design to identify encapsulation violations and 
propose fixes 
What You Did: 
In Task 1, you compared a BadStudent class (where fields were public) with a GoodStudent 
class (where fields were private). You saw firsthand how BadStudent allowed impossible data, 
like an age of -100 or a GPA of 15.5. 
What You Learned: 
Encapsulation is the act of hiding the internal state of an object and requiring all interaction to 
happen through methods. If you leave fields public, you lose control over your data. 
Real-Life Scenario: 
Imagine you are building the backend for an M-Pesa Agent App. 
If the balance field of an account is public, a malicious user could simply run account.balance = 
9999999; and give themselves millions of shillings. By making it private and forcing all changes 
through a deposit() or withdraw() method, you protect the bank and the customer. 
 
✓ Learning Outcome 2: Create a well-encapsulated class with private fields, 
constructors, and public access methods 
What You Did: 
In Task 2, you built a Book class from scratch. You made the fields private, created a constructor 
to initialize the book, and added getters and setters. You also added validation inside your setter 
so that the price of a book could never be negative. 
What You Learned: 
A well-designed class acts like a fortress. The constructor is the main gate that ensures the 
object starts in a valid state. The getters are the viewing windows, and the setters are the 
secure transaction windows where rules (validation) are enforced. 
Real-Life Scenario: 
Think of an ATM machine. 
You cannot reach directly into the vault to take money (private field). You must use the buttons 
on the screen (public methods). The ATM enforces rules: you can't withdraw KSh 5,000 if you 
only have KSh 2,000 (validation). This is exactly how your Java classes should be built.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
✓ Learning Outcome 3: Evaluate the necessity of getters/setters when fields could be 
made public 
What You Did: 
In Task 4, you built the BankAccount class. A critical design choice you made here was creating a 
getter for balance, but NOT creating a setBalance() method. You forced the balance to be 
changed only through deposit() and withdraw(). 
What You Learned: 
Not every field needs a getter, and not every field should have a setter. Blindly generating 
getters and setters for everything (which many IDEs do automatically) can be a security flaw. You 
learned to evaluate the business rules of the system. 
Real-Life Scenario: 
Look at your M-Pesa statement. You have a "read-only" view of your transaction history and 
your account balance. There is no button that says "Set my balance to 0". If you want to change 
the balance, you must perform an action (Deposit or Withdraw). This is why we omit setters for 
sensitive data. 
 
✓ Learning Outcome 4: Design a simple domain model with appropriate fields and 
methods 
What You Did: 
In Task 4, you didn't just write code; you designed a Domain Model (BankAccount). You mapped 
a real-world concept (a bank account) to a Java class. You decided what attributes it needs 
(account number, name, balance) and what behaviors it has (deposit, withdraw). 
What You Learned: 
Good software starts with good design. Before writing a single line of code, you must 
understand the entities in your system, their properties, and the rules they follow. 
Real-Life Scenario: 
When companies like Safaricom, Equity Bank, or Google build massive systems, they don't just 
start typing code. Software architects spend weeks designing the "Domain Model"—deciding 
what a User, Transaction, or Account looks like. You are now doing exactly what senior engineers 
do during the planning phase of a project.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
➢ Your Progress: Where You Started vs. Where You Are Now 
Before Week 6 After Week 6 
You knew how to group variables in a 
class. 
You know how to secure those variables using 
encapsulation. 
You initialized objects without much 
thought. 
You use constructors to guarantee objects are 
created correctly. 
You didn't know what this meant. You can use this to resolve naming conflicts and chain constructors. 
You could write classes, but they were 
vulnerable to bad data. 
You can write classes that enforce business rules 
and reject invalid data. 
You had a basic Book or Student class. You can design a secure, real-world BankAccount domain model. 
 
       How to Prove You've Achieved These Outcomes 
Here are the artifacts (proof) you now have in your GitHub repository (week6 folder): 
1. EncapsulationDemo.java (Demonstrates data protection). 
2. Book.java & BookTest.java (Demonstrates encapsulation with validation). 
3. Employee.java & EmployeeTest.java (Demonstrates this keyword and constructor 
chaining). 
4. BankAccount.java & BankTest.java (Demonstrates a complete domain model with strict 
business logic). 
These are not just homework files; they are proof that you can write secure, professional 
code.
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
✓ Student Reflection: In Your Own Words 
Answer these questions in your notebook: 
1. Why is it dangerous to make all class fields public? 
2. In the BankAccount class, why did we choose not to create a setBalance() method? 
3. How does the this keyword help when writing constructors? 
4. If you were to design a Student domain model for a university system, what private 
fields would it have? What business rules (validation) would you put in the setters? 
 
✓ What's Next? 
In Week 7, you will unlock the next pillar of OOP: Inheritance. 
You will learn how to create a Vehicle class and have a Car class inherit its features. You will 
discover how to reuse code instead of rewriting it, which is a massive time-saver in the software 
industry. 
Before you move on, make sure you can say YES to these: 
• □ I can explain why fields should be private. 
• □ I can write getters and setters with validation. 
• □ I know when to omit a setter (like for a bank balance). 
• □ I can use this() to chain constructors. 
• □ I have pushed my Week 6 code to GitHub. 
• □ I am ready to learn about Inheritance! 
Keep coding. You are doing great! 
 
END OF ACHIEVEMENT GUIDE FOR WEEK 6
```

</details>
