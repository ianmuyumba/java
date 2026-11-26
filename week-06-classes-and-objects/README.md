# Week 6: Classes and objects

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** spot encapsulation violations, write a well-encapsulated class, judge when getters and setters are needed, and design a small domain model.

These programs span several files, so compile the folder together:
```bash
javac -d ../build/week06 *.java
java -cp ../build/week06 BookTest        # or EncapsulationDemo, EmployeeTest, BankTest
```
(On Java 22+, `java BookTest.java` also works; it finds `Book.java` automatically.)

---

## Task 1: Analysing encapsulation violations
Compare `BadStudent` (public fields) with `GoodStudent` (private fields and validating setters).

**Solution:** [EncapsulationDemo.java](EncapsulationDemo.java)
```text
BadStudent Age: -100 (Corrupted!)
BadStudent GPA: 15.5 (Corrupted!)
...
Error: Invalid age. Age must be between 0 and 150.
Error: Invalid GPA. GPA must be between 0.0 and 4.0.
GoodStudent Age after invalid attempt: 20
GoodStudent GPA after invalid attempt: 3.5
```
**Answers:**
1. **BadStudent** has public fields, so any code can store impossible values (age −100, GPA 15.5). There is no single place to enforce the rules, and the field names can never change without breaking other code.
2. **GoodStudent** hides its fields and routes every change, including from the constructor, through setters that reject invalid values.
3. `private` limits access to code *inside the class*, so outsiders can't bypass the rules.
4. Getters give controlled **read** access. Setters give controlled **write** access, with validation. Together they let a class change its internals without breaking callers.

## Task 2: A well-encapsulated class (Book)
Write a `Book` with private fields, a constructor, getters and setters, price validation, and borrow/return behaviour.

**Solutions:** [Book.java](Book.java) · [BookTest.java](BookTest.java)
```text
Price: KSh 1500.00   Status: Available
Attempting to change price to -500...
Error: Price cannot be negative.
You have borrowed: Java Programming
Sorry, Java Programming is currently out of stock.     <- second borrow refused
Status: Borrowed
You have returned: Java Programming
Status: Available
```
`isAvailable` deliberately has **no setter**: it changes only through `borrowBook()` and `returnBook()`, which keep the rules intact.

## Task 3: The `this` keyword and constructor chaining
Write an `Employee` with three constructors that reuse each other via `this(...)`.

**Solutions:** [Employee.java](Employee.java) · [EmployeeTest.java](EmployeeTest.java)
```text
ID: 101 | Name: Alice | Salary: 50000.0 | Dept: IT
ID: 102 | Name: Bob | Salary: 45000.0 | Dept: Unassigned
ID: 103 | Name: Charlie | Salary: 25000.0 | Dept: Unassigned
Charlie received a raise. New salary: 30000.0
```
- `this.name = name` separates the **field** from the **parameter** with the same name.
- `this(...)` calls another constructor of the same class. It must be the first line.
- Chain: `Employee(id, name)` → `Employee(id, name, 25000.0)` → `Employee(id, name, 25000.0, "Unassigned")`. All the field assignments happen in one place.

## Task 4: Domain model design (BankAccount)
A bank account that never goes negative and accepts only positive deposits and withdrawals.

**Solutions:** [BankAccount.java](BankAccount.java) · [BankTest.java](BankTest.java)
```text
Deposited: KSh 2500.50. New Balance: KSh 7500.50
Error: Deposit amount must be positive.
Withdrew: KSh 2000.00. New Balance: KSh 5500.50
Error: Insufficient funds. Available balance: KSh 5500.50
Error: Withdrawal amount must be positive.
Final Balance: KSh 5500.5
```

## Reflection answers
1. Fields are private so the object controls its own state. Invalid data is blocked, and the internals can change freely.
2. A constructor puts a new object into a **valid starting state**.
3. `this` makes it explicit that you mean *this object's field*, which removes the ambiguity when a parameter has the same name.
4. There is no `setBalance()` because a bank balance must only change through real transactions with rules (positive amounts, no overdraft). A setter would let anyone write any number. Not every field needs a setter.

## Task 5: Push to GitHub
- [ ] Commit `Week 6: Classes & Objects - Encapsulation, Constructors, Getters/Setters`, then push and verify
