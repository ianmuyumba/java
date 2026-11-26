# Week 6 notes: classes and objects

[Tasks](README.md) · Sources: Oracle Java Foundations §7-1 to §7-6 (creating a class, instantiating objects, constructors, overloading, encapsulation, static)

## 1. Class vs object
- A **class** is a blueprint: it declares the fields (data) and methods (behaviour).
- An **object** is one instance built from the blueprint, with its own copy of the fields.
```java
public class Dog {
    private String name;              // field (instance variable)
    public Dog(String name) {         // constructor
        this.name = name;
    }
    public void bark() {              // method
        System.out.println(name + ": Woof");
    }
}

Dog d1 = new Dog("Rex");   // new: allocate an object, run the constructor, return a reference
Dog d2 = new Dog("Bo");
d1.bark();                 // Rex: Woof
```

## 2. References (Oracle §7-2)
A variable of a class type holds a **reference** (an address), not the object itself.
```
d1 ──► [Dog name="Rex"]
d3 = d1;   d3 ──┘          // both point to the SAME object
d1 = null;                 // d1 points nowhere; d1.bark() → NullPointerException
```
- An object with no references left is cleaned up by the **garbage collector**.
- `==` on objects asks "same object?". Use `.equals()` to compare content.

## 3. Constructors (Oracle §7-3)
- A constructor has the same name as the class and **no return type**.
- It runs once, at `new`, to give the object a valid starting state.
- If you write none, Java supplies a no-arg **default constructor**. Once you write any constructor, that default disappears.
- **Chaining** with `this(...)` reuses another constructor; it must be the first statement.
```java
public Employee(int id, String name) {
    this(id, name, 25000.0);
}
```

## 4. `this`
```java
public void setName(String name) {
    this.name = name;     // this.name = field, name = parameter
}
```
`this` also lets an object pass itself to another method: `register(this)`.

## 5. Overloading (Oracle §7-4)
Overloading means the same method name with a **different parameter list** (number, type or order). The return type alone doesn't count.
```java
double area(double side)              { return side * side; }
double area(double length, double w)  { return length * w; }
```
Constructors are often overloaded too, which is what makes chaining useful.

## 6. Encapsulation (Oracle §7-5)
Hide the data and expose safe operations.
```java
private double balance;                    // hidden
public double getBalance() {               // read access
    return balance;
}
public void deposit(double amt) {          // controlled write
    if (amt <= 0) throw new IllegalArgumentException("Deposit must be positive");
    balance += amt;
}
```
| Access modifier | Visible to |
|---|---|
| `private` | the same class only |
| *(none)* | the same package |
| `protected` | the same package + subclasses (week 7) |
| `public` | everyone |

**Getters and setters:**
- Add a getter only if outsiders need to read the field.
- Add a setter only if outsiders may change it freely, and validate it.
- Prefer behaviour methods (`deposit`, `borrowBook`) over raw setters.
- Fields that never change should be `final`.

## 7. static: belongs to the class, not an object (Oracle §7-6)
```java
public class Student {
    private static int count = 0;    // ONE shared copy
    private final int id;            // one per object
    public Student() {
        id = ++count;
    }
    public static int getCount() {   // call as Student.getCount()
        return count;
    }
}
```
- A `static` method has no `this`, so it can't use instance fields directly.
- **Typical uses:** counters, constants (`static final double PI`), utility methods (`Math.sqrt`).

## 8. Objects working together
Objects hold references to other objects and call each other's methods. A `Library` might have an `ArrayList<Book>`, and `Library.lend(title)` would find the book and call `book.borrowBook()`. Each class guards its own rules.

## 9. toString()
Override `toString()` to control how an object prints:
```java
@Override
public String toString() {
    return "Book[" + title + ", KSh " + price + "]";
}
System.out.println(myBook);   // uses toString() automatically
```

## Quick check
- [ ] What's printed by `System.out.println(new Dog("Rex"))` without a `toString()`? (something like `Dog@1b6d3586`)
- [ ] Why does adding `Dog(String name)` break `new Dog()`?
- [ ] Can a static method read `this.name`? (no)
- [ ] When should a field have no setter?
