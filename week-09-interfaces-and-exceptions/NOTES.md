# Week 9 notes: interfaces and exceptions

[Tasks](README.md) · Sources: Oracle Java Foundations §8-3 (exception handling) and §8-4 (debugging), class comprehensive notes (week 9) and standard Java

## Part A: Interfaces

### 1. What an interface is
An interface is a **contract**: a list of methods a class promises to provide. It describes a *capability* ("can do"), not an identity ("is a").
```java
interface Payable {
    double TAX = 0.16;          // constants only: implicitly public static final
    void pay(double amount);    // implicitly public abstract
}

class Invoice implements Payable {
    @Override
    public void pay(double amount) { ... }   // must be public
}
```

### 2. Multiple interfaces
A class can extend **one** class but implement **many** interfaces.
```java
class Smartphone extends Device implements Camera, MusicPlayer, Phone { ... }
Camera c = new Smartphone();   // interface types work polymorphically
```

### 3. Modern interface features (Java 8+)
```java
interface Greeter {
    void greet(String name);
    default void greetAll(String... names) {   // default: has a body, can be overridden
        for (String n : names) greet(n);
    }
    static Greeter polite() {                  // static helper
        return n -> System.out.println("Good day, " + n);
    }
}
```
An interface with exactly one abstract method is a **functional interface**, so it can be written as a lambda (as in `polite()` above).

### 4. Interface vs abstract class
| | Interface | Abstract class |
|---|---|---|
| Relationship | **can-do** (capability) | **is-a** (family) |
| How many per class | many (`implements A, B`) | one (`extends`) |
| Instance fields | ❌ (constants only) | ✅ |
| Constructors | ❌ | ✅ |
| Method bodies | `default` / `static` only | any |
| Access modifiers | methods are public | any |
| Use when | unrelated classes share behaviour (Flyable, Comparable) | related classes share state and code (Animal, Account) |

They combine well: `class Bird extends Animal implements Flyable`.

## Part B: Exceptions

### 5. What an exception is
An exception is an **object** that signals an error at runtime. If nobody catches it, it travels up the call stack and the program stops with a **stack trace**.
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Demo.divide(Demo.java:8)      ← where it happened
    at Demo.main(Demo.java:3)        ← who called it
```
Read the top line for **what** happened, and the first `at` line in your code for **where**.

### 6. The hierarchy
```
Throwable
├── Error                      (JVM problems: OutOfMemoryError; don't catch)
└── Exception                  CHECKED: compiler forces you to handle (IOException)
    └── RuntimeException       UNCHECKED: usually bugs
        ├── ArithmeticException
        ├── NullPointerException
        ├── ArrayIndexOutOfBoundsException
        ├── NumberFormatException
        ├── InputMismatchException
        └── IllegalArgumentException
```
| | Checked | Unchecked |
|---|---|---|
| Extends | `Exception` | `RuntimeException` |
| Compiler | must catch or declare `throws` | optional |
| Meaning | expected situations outside your control (file missing, insufficient funds) | programming errors (null, bad index) |

### 7. try / catch / finally
```java
try {
    int n = Integer.parseInt(input);
    System.out.println(100 / n);
} catch (NumberFormatException e) {          // most specific first
    System.out.println("Not a number");
} catch (ArithmeticException e) {
    System.out.println("Can't divide by zero");
} catch (Exception e) {                      // general catch-all last
    System.out.println("Unexpected: " + e.getMessage());
} finally {
    System.out.println("Always runs");       // clean-up
}
```
- The first matching `catch` wins, so catching a subclass after its superclass is a compile error.
- You can catch several types at once: `catch (NumberFormatException | ArithmeticException e)`.
- **try-with-resources** closes things automatically (used in week 10):
  `try (Scanner sc = new Scanner(file)) { ... }`

### 8. throw vs throws
```java
public void withdraw(double amt) throws InsufficientFundsException {    // declares
    if (amt > balance) throw new InsufficientFundsException("Short", amt - balance);  // raises
    balance -= amt;
}
```
- **Propagation:** if a method doesn't catch an exception, it passes up to its caller, and so on up to `main`.
- **Where to catch:** where you can actually do something useful about it.

### 9. Custom exceptions
```java
class InsufficientFundsException extends Exception {         // checked
    private final double shortfall;
    InsufficientFundsException(String msg, double shortfall) {
        super(msg);
        this.shortfall = shortfall;
    }
    double getShortfall() { return shortfall; }
}
```
Give them a clear name ending in `Exception`, pass a message to `super`, and add fields for useful details.

### 10. Debugging techniques (Oracle §8-4)
1. **Read the stack trace:** the exception type, the message, then the line number.
2. **Print debugging:** `System.out.println("x=" + x)` before the suspect line.
3. **IDE debugger:**
   - set a **breakpoint**
   - **step over** (next line) or **step into** (enter a method)
   - **watch** variable values
4. **Test edge cases:** 0, negative numbers, empty input, the largest values, and `null`.
5. **Don't swallow exceptions:** an empty `catch {}` hides bugs.

## Quick check
- [ ] Can an interface have a constructor? (no)
- [ ] Is `NumberFormatException` checked or unchecked? (unchecked)
- [ ] What prints if `try` succeeds: does `finally` still run? (yes)
- [ ] Why put `catch (Exception e)` last?
