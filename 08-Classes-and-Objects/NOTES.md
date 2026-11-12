# Unit 08 · Classes & Objects (Encapsulation)

> **Class:** RBCS 7121 Week 6 (Deep Dive into Classes and Objects)
> **Oracle JFo:** Section 7 (7-1 Creating a Class, 7-2 Instantiating Objects, 7-3 Constructors, 7-4 Overloading Methods, 7-5 Object Interaction and Encapsulation, 7-6 static Variables and Methods, 7-7 Practice)
> **Files in this folder**
> - `class-notes/`: Week 6 comprehensive notes, Practical Session 6, achievement summary
> - `oracle-jfo/`: lessons 7-1 to 7-7
> - `exercises/`: the Prison project, which grows lesson by lesson: `Prisoner_Student_7_3…7_6`, `PrisonTest_Student_7_3…7_6`, `Cell_Student_7_6`

---

## Learning outcomes

1. **Analyse** a class design to find encapsulation violations, and propose fixes.
2. **Create** a well-encapsulated class with private fields, constructors and public methods.
3. **Evaluate** whether each field really needs a getter and/or setter.
4. **Design** a simple domain model (e.g. `BankAccount`, `Student`) with the right fields and methods.
5. Use constructors, `this`, overloading, object references, object interaction and `static` correctly.

---

## 1. Classes and objects

- A **class** is a **blueprint**. It defines **fields** (data, i.e. what an object *knows*) and **methods** (behaviour, i.e. what an object *does*).
- An **object** is one **instance** built from that blueprint with `new`. Each object has its **own copy** of the fields.

```java
public class Prisoner {
    // Fields (instance variables)
    String name;
    double height;
    int sentence;

    // Method (behaviour)
    void think() {
        System.out.println("I'll have my revenge.");
    }
}
```
```java
public class PrisonTest {
    public static void main(String[] args) {
        Prisoner p01 = new Prisoner();   // instantiate
        p01.name = "Bubba";               // dot operator → field
        p01.height = 2.08;
        p01.sentence = 4;

        Prisoner p02 = new Prisoner();    // a separate object with its own fields
        p02.name = "Twitch";

        p01.think();                      // dot operator → method
        System.out.println(p01.name + " vs " + p02.name);
    }
}
```

**Main class vs blueprint class:** a "test" or "driver" class holds `main` and *uses* objects; the blueprint class (`Prisoner`) usually has no `main`.

---

## 2. Instantiating objects: references, stack and heap (JFo 7-2)

```java
Prisoner p01 = new Prisoner();
```
1. `new Prisoner()` creates the object on the **heap** (memory for objects).
2. `p01` is a **reference variable** on the **stack**: it holds the object's *address*, not the object itself.

```
   STACK                HEAP
  p01  ●───────────►  [ Prisoner: name="Bubba", height=2.08, sentence=4 ]
  p02  ●───────────►  [ Prisoner: name="Twitch", height=0.0, sentence=0 ]
```

```java
Prisoner p03 = p01;   // copies the reference, so p03 and p01 are the SAME object
p03.name = "Changed";
System.out.println(p01.name);   // Changed
```

- `==` on objects compares **references** (is this the same object?), not contents.
- A reference that points nowhere is **`null`**. Calling a method on it throws a `NullPointerException`.
- Objects that nothing refers to any more are removed automatically by the **garbage collector**.

---

## 3. Default field values (JFo 7-3)

Fields you don't initialise get default values (local variables don't, so they must be assigned before use):

| Field type | Default |
|------------|---------|
| `int`, `long`, `double`… | `0` / `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| any object (`String`, `Cell`…) | `null` |

---

## 4. Constructors (JFo 7-3)

A **constructor** runs **once**, automatically, when `new` creates the object. Its job is to put the object into a valid starting state.

**Rules:**
1. Its name is **exactly** the class name.
2. It has **no return type**, not even `void`.
3. If you write **no** constructor, Java supplies a hidden **default no-argument constructor**. As soon as you write **any** constructor, that default disappears.

```java
public class Prisoner {
    private String name;
    private double height;
    private int sentence;

    public Prisoner(String name, double height, int sentence) {
        this.name = name;          // this.name = the FIELD; name = the PARAMETER
        this.height = height;
        this.sentence = sentence;
    }
}

Prisoner bubba = new Prisoner("Bubba", 2.08, 4);   // must now pass all three
// new Prisoner();  ❌ no no-arg constructor any more
```

### Validation in the constructor
Guarantee that no object is ever created in an invalid state:
```java
public Student(String name, int age) {
    this.name = name;
    if (age >= 0 && age <= 150) {
        this.age = age;
    } else {
        this.age = 0;             // safe default
    }
}
```

---

## 5. The `this` keyword

`this` means **"the current object"** (the one whose method or constructor is running).

| Use | Example |
|-----|---------|
| Tell a field apart from a parameter with the same name (**shadowing**) | `this.name = name;` |
| Call another constructor of the same class (**constructor chaining**). Must be the **first** line | `this(name, 25000.0);` |
| Pass the current object to another method | `cell.assign(this);` |

```java
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {    // the "master" constructor
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name) {
        this(name, 25000.0);                         // reuse the master, with a default salary
    }
}
```

---

## 6. Overloading methods and constructors (JFo 7-4)

**Overloading** means the same name with **different parameter lists** (number, types or order). The **method signature** is the name plus the parameter types; the return type is **not** part of it.

```java
public class Calculator {
    public int add(int a, int b)            { return a + b; }
    public double add(double a, double b)   { return a + b; }
    public int add(int a, int b, int c)     { return a + b + c; }
    // public double add(int a, int b)      ❌ same signature as the first, only the return type differs
}
```
Java chooses which version to run from the **arguments** at the call site. Constructors are often overloaded to offer several ways of creating an object, as in `Employee` above.

**Exercise `Prisoner_Student_7_5`** asks for an overloaded `display()`: one version without parameters, and one `display(boolean think)` that also calls `think()`.

---

## 7. Encapsulation (JFo 7-5, Week 6)

**Encapsulation** means bundling data and the methods that use it into one class, and **hiding the data** so that outside code must go through those methods. Think of a protective capsule.

### The problem: public fields
```java
class BadAccount {
    public double balance = 1000.0;
}
BadAccount acc = new BadAccount();
acc.balance = -5000.0;          // nothing stops this, so the data is now corrupt
```

### The fix: `private` fields plus controlled methods

**Access modifiers:**

| Modifier | Same class | Same package | Subclass | Everywhere |
|----------|-----------|--------------|----------|-----------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| *(default, nothing written)* | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

**Rule of thumb:** fields are `private`; methods that other classes need are `public`; helper methods are `private`.

### Getters and setters
- A **getter** (accessor) returns a field: `public double getBalance() { return balance; }`. For booleans the convention is `isOpen()`.
- A **setter** (mutator) changes a field, and **it's where validation goes**:
```java
public void setAge(int age) {
    if (age > 0 && age < 150) {
        this.age = age;
    } else {
        System.out.println("Invalid age!");
    }
}
```

### Does every field need a getter *and* a setter? No.

| Field | Getter? | Setter? | Why |
|-------|---------|---------|-----|
| Student name | ✅ | ✅ | names can change |
| Student ID | ✅ | ❌ | assigned once, never changes |
| Bank balance | ✅ | ❌ | should change **only** through `deposit()` / `withdraw()` |
| Password | ❌ | ✅ | you should be able to change it, never read it |

Leaving out a setter makes the field **read-only** from outside. With no `setBalance()`, nobody can set a balance to 1,000,000; they have to go through the rules in `deposit()`.

### Object interaction (exercise `Cell_Student_7_6`)
Objects can hold references to **other** objects and call their methods. A `Prisoner` has a `Cell`; the `Cell` controls its own door through a security code:
```java
public void setIsOpen(int code) {
    if (code != securityCode) {
        System.out.println("Incorrect code");
    } else {
        isOpen = !isOpen;                       // toggle
        System.out.println("Cell " + name + (isOpen ? " Open" : " Closed"));
    }
}
```
```java
Cell_Student_7_6 cellA1 = new Cell_Student_7_6("A1", false, 1234);
Prisoner_Student_7_6 bubba = new Prisoner_Student_7_6("Bubba", 2.08, 4, cellA1);
bubba.display();           // ... Cell: A1   (the prisoner asks its cell for its name)
cellA1.setIsOpen(1111);    // Incorrect code
cellA1.setIsOpen(1234);    // Cell A1 Open
```
Note: the starter `Prisoner_Student_7_6` declares its field as type `Cell`, but the starter class is called `Cell_Student_7_6`. Rename one of them so they match before compiling.

---

## 8. `static` variables and methods (JFo 7-6)

| | Instance member (no `static`) | `static` member |
|-|-------------------------------|-----------------|
| Belongs to | each **object** | the **class** (one shared copy) |
| Access | `object.field` | `ClassName.field` |
| Example | each prisoner's `name` | `Prisoner.prisonerCount` (the total for the whole prison) |

```java
public class Prisoner {
    private static int prisonerCount = 0;   // shared by ALL prisoners
    private final int id;                    // final = set once, never changed
    private String name;

    public Prisoner(String name) {
        this.name = name;
        prisonerCount++;                     // every new prisoner bumps the shared counter
        this.id = prisonerCount;             // a unique ID for each prisoner
    }

    public static int getPrisonerCount() {   // static method: call it on the class
        return prisonerCount;
    }
}

new Prisoner("Bubba");
new Prisoner("Twitch");
System.out.println(Prisoner.getPrisonerCount());   // 2
```

- A `static` method **can't** use instance fields or `this` directly, because there's no "current object". That's why `main` (which is static) has to create objects before using instance members.
- `Math.sqrt()` and `Integer.parseInt()` are static: you never need a `Math` object.
- **Constants:** `public static final double VAT_RATE = 0.16;` gives one shared copy that can never change, named in UPPER_SNAKE_CASE.

---

## 9. Designing a domain model: BankAccount

**Steps:** ① identify the attributes → ② make them all `private` → ③ list the business rules → ④ write methods that enforce those rules.

```java
public class BankAccount {
    private final String accountNumber;      // never changes
    private String accountHolderName;
    private double balance;                  // changed only by deposit/withdraw
    private static int accountsOpened = 0;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = (initialBalance >= 0) ? initialBalance : 0;
        accountsOpened++;
    }

    public BankAccount(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0);      // constructor chaining
    }

    // getters (read-only access)
    public String getAccountNumber()     { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance()           { return balance; }
    public static int getAccountsOpened(){ return accountsOpened; }

    // a setter only where a change is allowed
    public void setAccountHolderName(String name) {
        if (name != null && !name.isBlank()) this.accountHolderName = name;
    }

    // NO setBalance(): a deliberate security decision

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

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC001", "Ian", 1000);
        acc.deposit(500);
        acc.withdraw(2000);          // Error: Insufficient funds.
        acc.withdraw(300);
        acc.deposit(-50);            // Error: Deposit amount must be positive.
        System.out.println(acc.getAccountHolderName() + ": KSh " + acc.getBalance());
        System.out.println("Accounts opened: " + BankAccount.getAccountsOpened());
    }
}
```
```
Error: Insufficient funds.
Error: Deposit amount must be positive.
Ian: KSh 1200.0
Accounts opened: 1
```

---

## 10. Exercises: the Prison project (it grows with each lesson)

| Exercise | Lesson | Task |
|----------|--------|------|
| `Prisoner_Student_7_3` + `PrisonTest_Student_7_3` | 7-3 | Create 2 prisoners with `new`, set their fields with the dot operator, call `think()`, and print their fields |
| `Prisoner_Student_7_4` + `PrisonTest_Student_7_4` | 7-4 | Use the 3-argument constructor; add an overloaded constructor |
| `Prisoner_Student_7_5` + `PrisonTest_Student_7_5` | 7-5 | Make the fields `private`; add getters and setters; finish the overloaded `display(boolean)` |
| `Cell_Student_7_6` + `Prisoner_Student_7_6` + `PrisonTest_Student_7_6` | 7-6 | Give each prisoner a Cell (object interaction); add a `static` prisoner count and a `final` ID |
| Week 6 practical | — | `class-notes/Week 6 - Practical Session 6.pdf` |
| Extra | — | Design a `Student` class: private fields, a validated constructor, getters, setters only where they make sense, `calculateAverage()` |

Compile and run several files together:
```
cd 08-Classes-and-Objects/exercises
javac -d out Prisoner_Student_7_4/*.java PrisonTest_Student_7_4/*.java
java -cp out PrisonTest_Student_7_4
```

---

## 11. Common mistakes

| Mistake | Fix |
|---------|-----|
| `this.name = name` written as `name = name` | Without `this.`, the parameter is assigned to itself and the field stays `null` |
| A constructor with a return type: `public void Prisoner(...)` | That's a method, not a constructor. Remove `void` |
| `new Prisoner()` fails after adding a constructor | The default constructor is gone; add a no-arg one if you need it |
| Using an instance field inside `static main` | Create an object first |
| Public fields | Make them `private` and add methods |
| A setter with no validation for an important field | Validate, or don't provide the setter at all |
| Overloads that differ only by return type | The parameter lists must differ |
| `NullPointerException` | The reference was never assigned an object (`new`) |

---

## 12. Practice questions

1. Why is a `public` field considered bad practice?
2. What is the main job of a constructor? List its rules.
3. What's the difference between a getter and a setter?
4. Why might you deliberately **not** write a setter for a field? Give an example.
5. How does `this` solve naming conflicts?
6. What is constructor chaining, and how do you do it?
7. Which of these are valid overloads of `void print(int x)`? (a) `void print(double x)` (b) `int print(int y)` (c) `void print(int x, int y)`
8. After `Prisoner a = new Prisoner(); Prisoner b = a; b.name = "X";`, what is `a.name`? How many objects exist?
9. What is the difference between a static field and an instance field? Give an example of each from the Prison project.
10. Why can't a static method use `this`?
11. A class has only `public Box(int size)`. Does `new Box()` compile?
12. Identify the encapsulation problems and fix them:
    ```java
    public class Account { public double balance; public String pin; }
    ```

<details>
<summary><b>Answers</b></summary>

1. Any code can put an invalid value into it (e.g. a negative balance), with no validation and no control.
2. It initialises a new object into a valid state. Rules: same name as the class, no return type, runs on `new`; Java provides a default one only if you write none.
3. A getter returns a field's value; a setter changes it, ideally after validating the new value.
4. To make the field read-only from outside or to force changes through business methods. E.g. `balance` (only `deposit`/`withdraw` may change it) or `id` (never changes).
5. `this.x` refers to the field, so it's distinguished from a parameter or local variable also called `x`.
6. One constructor calling another in the same class with `this(...)` as its first statement, to avoid duplicating code.
7. (a) and (c). (b) has the same parameter list (`int`), so it isn't a valid overload.
8. `"X"`. There's one object with two references to it.
9. A static field has one copy shared by the class (e.g. `prisonerCount`). An instance field has one copy per object (e.g. `name`, `sentence`).
10. Static methods belong to the class and run without any object, so there's no "current object" for `this` to refer to.
11. No. Writing a constructor removes the default no-arg one.
12. Make both fields `private`. Add `getBalance()` (with no setter) plus `deposit()` and `withdraw()` with validation. Don't add a getter for `pin`; add `changePin(oldPin, newPin)` and `verifyPin(pin)` instead.
</details>

---

## 13. Summary

- Class = blueprint (fields + methods). Object = an instance made with `new`. A variable holds a **reference** to an object on the heap.
- A constructor has the class's name and no return type, and runs on `new`. Validate inside it, and use `this(...)` to chain constructors.
- `this` = the current object. `this.field = param;`
- Overloading = same name, different parameter lists.
- **Encapsulation:** `private` fields, `public` methods, validation in setters, and getters/setters only where the business rules allow them.
- `static` = one copy per class (counters, utility methods, constants with `final`). Instance = one copy per object.
- Domain modelling: attributes → private → business rules → methods that enforce them.
