# Unit 10 · Exceptions & Debugging

[Course home](../README.md) · [Progress](../PROGRESS.md) · [← Previous](../09-Inheritance-and-Polymorphism/README.md) · [Next →](../11-JavaFX/README.md)

**Read → trace → code → test → explain**

[Source library](sources/README.md) · [Practice guide](PRACTICE.md)

[Liang Ch. 12](../00-Course-Info/sources/textbook/chapter-12-exception-handling-and-text-i-o.md)

<details>
<summary>On this page</summary>

- [Start here: Handle failure at a useful boundary](#start-here-handle-failure-at-a-useful-boundary)
- [Learning outcomes](#learning-outcomes)
- [1. Three kinds of errors](#1-three-kinds-of-errors)
- [2. What is an exception?](#2-what-is-an-exception)
- [3. Common exceptions](#3-common-exceptions)
- [4. `try` / `catch` / `finally`](#4-try--catch--finally)
- [5. Robust input: the program must not crash](#5-robust-input-the-program-must-not-crash)
- [6. Throwing your own: `throw` and `throws`](#6-throwing-your-own-throw-and-throws)
- [7. Debugging concepts and techniques (JFo 8-4)](#7-debugging-concepts-and-techniques-jfo-8-4)
- [8. Exercises](#8-exercises)
- [9. Practice questions](#9-practice-questions)
- [10. Summary](#10-summary)

</details>

## Start here: Handle failure at a useful boundary

Liang §§12.3–12.9 distinguishes checked exceptions, runtime exceptions, propagation and custom exception classes. A checked exception must be handled or declared. A declaration with `throws` passes responsibility to the caller; it does not handle the failure.

Catch a specific exception where you can recover, explain the problem, or add useful context. An empty catch block hides failures. Catching `Exception` around an entire application can also disguise programming errors.

Use try-with-resources for resources that implement `AutoCloseable`. It closes resources when the block exits, including exceptional exits. `finally` is useful for cleanup but is not an absolute guarantee if the process is terminated; avoid returning from it because that can replace an earlier result or exception.

**Debugging task:** the existing `ShoppingCart` exercise calls integer division with a zero divisor. Predict the exception before running it. Also inspect `divide(15, 2)`: because division occurs between two integers, a `double` return type alone cannot preserve the fraction. Decide and document the method's intended contract before fixing it.

> **Oracle JFo:** 8-3 Exception Handling, 8-4 Debugging Concepts and Techniques (the Section 8 practice, *The Soccer League*, is in [8-5 Practice](../07-Arrays-and-ArrayLists/sources/oracle-jfo/8-5-practice.md); it says "the program should not crash because of user input", which is exactly what this unit teaches)
> **Class:** the debugging parts of Weeks 3–5 (trace tables, debugger), and Week 2's warnings about `InputMismatchException` / `NumberFormatException` ("covered in later weeks")

---

## Learning outcomes

1. Explain what an exception is and read a **stack trace**.
2. Tell **compile-time errors**, **runtime exceptions** and **logic errors** apart.
3. Handle exceptions with `try` / `catch` / `finally` so a program doesn't crash.
4. Name common exceptions and what causes each.
5. Throw exceptions with `throw`, and declare them with `throws`.
6. Debug systematically: print statements, breakpoints, stepping, trace tables, **boundary testing**.

---

## 1. Three kinds of errors

| Kind | When it shows up | Example | Who catches it |
|------|------------------|---------|----------------|
| **Compile-time (syntax)** | before the program runs | missing `;`, `int x = "hi";` | the compiler (`javac`) |
| **Runtime (exception)** | while it runs; the program crashes | dividing by zero, a bad array index, `parseInt("abc")` | the JVM (throws an exception) |
| **Logic error** | it runs fine but gives the **wrong answer** | `x1 - x1` instead of `x2 - x1` | only **you**, through testing and debugging |

---

## 2. What is an exception?

An **exception** is an object Java creates when something goes wrong at runtime. If nothing **catches** it, the program stops and prints a **stack trace**:

```java
public class ExceptionEx1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 6, 1};
        badUse(nums);
    }
    public static void badUse(int[] vals) {
        int total = 0;
        for (int i = 0; i < vals.length; i++) {
            int index = vals[i];
            total += vals[index];          // when vals[i] is 6, there's no vals[6]!
        }
        System.out.println(total);
    }
}
```
```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 4
	at ExceptionEx1.badUse(ExceptionEx1.java:14)
	at ExceptionEx1.main(ExceptionEx1.java:6)
```
(Line numbers are from the actual `exercises/ExceptionEx1/ExceptionEx1.java` file.)

**Reading a stack trace:**
1. **Type:** `ArrayIndexOutOfBoundsException`
2. **Message:** `Index 6 out of bounds for length 4`
3. **Where:** the **top** `at` line is where it happened (`badUse`, line 14); the lines below show who called it (`main`, line 6).

---

## 3. Common exceptions

| Exception | Cause | Example |
|-----------|-------|---------|
| `ArithmeticException` | integer division by zero | `10 / 0` |
| `ArrayIndexOutOfBoundsException` | index < 0 or ≥ length | `arr[arr.length]` |
| `StringIndexOutOfBoundsException` | bad index into a String | `"abc".charAt(5)` |
| `NullPointerException` | calling a method on `null` | `String s = null; s.length();` |
| `NumberFormatException` | parsing text that isn't a number | `Integer.parseInt("abc")` |
| `InputMismatchException` | Scanner got the wrong type | `nextInt()` when the user types "hello" |
| `IndexOutOfBoundsException` | bad ArrayList index | `list.get(10)` on a list of 3 |
| `ClassCastException` | invalid cast | `(Circle) aRectangleShape` |
| `FileNotFoundException` | the file doesn't exist | `new Scanner(new File("x.txt"))` |

Note: `10.0 / 0` doesn't throw; it gives `Infinity`. Only **integer** division by zero throws.

### Checked vs unchecked
- **Unchecked** (subclasses of `RuntimeException`): usually programming mistakes, as in the table above. The compiler doesn't force you to handle them.
- **Checked** (e.g. `IOException`, `FileNotFoundException`): things outside your control. The compiler **requires** you to catch them or declare `throws`.

```
Throwable
├── Error                (serious JVM problems, e.g. OutOfMemoryError; don't catch these)
└── Exception
    ├── IOException, FileNotFoundException ...     ← checked
    └── RuntimeException                           ← unchecked
        ├── ArithmeticException
        ├── NullPointerException
        ├── IndexOutOfBoundsException → ArrayIndexOutOfBounds…, StringIndexOutOfBounds…
        └── IllegalArgumentException → NumberFormatException
```

---

## 4. `try` / `catch` / `finally`

```java
try {
    // code that might throw
} catch (ExceptionType e) {
    // what to do if it does
} finally {
    // ALWAYS runs, with or without an exception (cleanup: close Scanners, files)
}
```

### Example: the Calculator divide-by-zero (exercises `Calculator` + `ShoppingCart`)
```java
public class Calculator {
    public int add(int x, int y) { return x + y; }
    public double divide(int x, int y) { return x / y; }   // throws ArithmeticException when y == 0
}
```
```java
public class ShoppingCart {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Add Result: " + calc.add(43, 79));
        try {
            double divResult = calc.divide(15, 0);
            System.out.println("Division Result: " + divResult);   // skipped if divide throws
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
        }
        System.out.println("Program continues.");
    }
}
```
```
Add Result: 122
Cannot divide by zero: / by zero
Program continues.
```

**Flow:** when an exception is thrown inside `try`, Java jumps **straight** to the matching `catch` and skips the rest of `try`. If no exception happens, `catch` is skipped. Either way, the program carries on after the try/catch.

(There's another bug in `divide`: `x / y` with two ints is integer division, so `divide(7, 2)` returns `3.0`. Fix it with `(double) x / y`.)

### Several catch blocks: put the most specific first
```java
try {
    int[] data = {1, 2, 3};
    int i = Integer.parseInt(input);
    System.out.println(10 / data[i]);
} catch (NumberFormatException e) {
    System.out.println("Not a number.");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("No such position.");
} catch (Exception e) {                          // general fallback: always LAST
    System.out.println("Something went wrong: " + e);
}
```
You can also catch several types in one block: `catch (NumberFormatException | ArithmeticException e)`.

### Useful methods on the exception object
`e.getMessage()` (the message), `e.toString()` (type + message), `e.printStackTrace()` (the full trace, for debugging).

---

## 5. Robust input: the program must not crash

```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int age = -1;
        while (age < 0) {
            System.out.print("Enter your age: ");
            try {
                age = in.nextInt();
                if (age < 0) System.out.println("Age can't be negative.");
            } catch (InputMismatchException e) {
                System.out.println("Please enter a whole number.");
                in.nextLine();               // IMPORTANT: discard the bad input, or the loop never ends
            }
        }
        System.out.println("Age: " + age);
        in.close();
    }
}
```

With `parseInt` (e.g. JOptionPane input or a whole line):
```java
try {
    int temp = Integer.parseInt(text.trim());
} catch (NumberFormatException e) {
    System.out.println("'" + text + "' is not a valid temperature.");
}
```

**Try-with-resources** closes the Scanner or file automatically:
```java
try (Scanner sc = new Scanner(new java.io.File("data.txt"))) {
    while (sc.hasNextLine()) System.out.println(sc.nextLine());
} catch (java.io.FileNotFoundException e) {
    System.out.println("File not found.");
}
```

---

## 6. Throwing your own: `throw` and `throws`

**`throw`** creates and throws an exception (validation inside your own methods):
```java
public void withdraw(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("Amount must be positive");
    }
    if (amount > balance) {
        throw new IllegalStateException("Insufficient funds");
    }
    balance -= amount;
}
```

**`throws`** in a method header **declares** that the method may pass a (checked) exception up to its caller:
```java
public static String readFirstLine(String path) throws java.io.FileNotFoundException {
    Scanner sc = new Scanner(new java.io.File(path));
    return sc.nextLine();
}
```

**A custom exception** (preview):
```java
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) { super(msg); }
}
```

| `throw` | `throws` |
|---------|----------|
| a statement inside a method | part of the method's header |
| throws **one** exception object | **declares** which types might be thrown |
| `throw new X("msg");` | `void m() throws X, Y` |

**Don't** catch an exception and ignore it (`catch (Exception e) {}`). That hides bugs.

---

## 7. Debugging concepts and techniques (JFo 8-4)

### 7.1 The process
1. **Reproduce** the bug reliably (which input causes it?).
2. **Locate** it: read the stack trace, or narrow it down with prints and breakpoints.
3. **Understand** why it happens (form a hypothesis).
4. **Fix** it.
5. **Retest**, including the cases that worked before (regression).

### 7.2 Techniques

| Technique | How |
|-----------|-----|
| **Print statements** | `System.out.println("DEBUG x=" + x);` at key points to see values and the path taken |
| **Breakpoints** | Click the margin; run in **Debug** mode; execution pauses there |
| **Step Over / Into / Out** | Run one line / go inside a method / finish the current method |
| **Watch variables** | Look at the Variables panel, or hover over a variable |
| **Trace table** | Track every variable's value, pass by pass, on paper |
| **Rubber-duck** | Explain the code line by line, out loud; the bug often reveals itself |
| **Divide and conquer** | Comment out half the code to find which half contains the bug |

### 7.3 Boundary testing
Bugs hide **at the edges** of valid ranges. For each condition, test: just below, exactly on, and just above the boundary, plus extreme and invalid values.

**Exercise `BoundaryTesting`:**
```java
int CALENDAR_START = 1583;
int year = 1582, month = 1;
if ((year < CALENDAR_START) || (month < 1) || (month > 12)) {
    System.out.println("Bad request: " + year + " " + month);
}
```
| Test | year | month | Expect |
|------|------|-------|--------|
| just below the year | 1582 | 6 | Bad request |
| on the boundary | 1583 | 6 | OK |
| month low edge | 2026 | 0 / 1 | Bad / OK |
| month high edge | 2026 | 12 / 13 | OK / Bad |

### 7.4 Logic bugs in the exercises
- **`ComputeTime`**: `getDistance` computes `(x1 - x1) * (x1 - x2)`, but the formula is `(x2 - x1)²`. It should be:
  ```java
  return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
  ```
  It's found by testing with points whose distance you already know (e.g. (0,0) to (3,4) = 5).
- **`MaxIntegers`**: with `num1 = num2 = num3 = 3`, every strict `>` comparison is false, so `max` stays **0**. The boundary case "all equal" exposes it. Fix with `>=`, or more simply:
  ```java
  int max = num1;
  if (num2 > max) max = num2;
  if (num3 > max) max = num3;
  ```
- **`ComputeAvg`** (to write): read numbers, average them, and handle a non-numeric entry and **zero entries** (dividing by a count of 0).

---

## 8. Exercises

| Exercise | Task |
|----------|------|
| `Calculator` + `ShoppingCart` | Run it and read the crash; add try/catch; fix integer division in `divide` |
| `ExceptionEx1` | Read the stack trace; explain why index 6 is used; fix the logic |
| `BoundaryTesting` | Write the boundary test table and test each row |
| `ComputeTime` | Find and fix the distance-formula bug |
| `MaxIntegers` | Find the "all equal" bug and fix it |
| `ComputeAvg` | Write it with a Scanner, input validation, and no divide-by-zero |
| Soccer League ([8-5 Practice](../07-Arrays-and-ArrayLists/sources/oracle-jfo/8-5-practice.md)) | Arrays + ArrayLists + classes + "must not crash on user input" |

---

## 9. Practice questions

1. What's the difference between a compile-time error, a runtime exception and a logic error?
2. Name the exception: (a) `int[] a = new int[3]; a[3] = 1;` (b) `Integer.parseInt("12a")` (c) `String s = null; s.trim();` (d) `5 / 0`
3. In a stack trace, which line tells you where the error happened?
4. What does `finally` do, and when would you use it?
5. Why must `catch (Exception e)` come after more specific catch blocks?
6. Why do you need `in.nextLine()` inside the `catch` of an input-validation loop?
7. What's the difference between `throw` and `throws`?
8. Checked vs unchecked: give an example of each.
9. What does `10.0 / 0` give in Java?
10. Choose boundary test values for "a discount applies to orders of 1,000 to 5,000 KSh inclusive".

<details>
<summary><b>Answers</b></summary>

1. Compile-time: the code breaks Java's rules and won't compile. Runtime: it compiles but crashes while running (an exception). Logic: it runs without crashing but gives wrong results.
2. (a) `ArrayIndexOutOfBoundsException` (b) `NumberFormatException` (c) `NullPointerException` (d) `ArithmeticException`.
3. The first `at …` line under the exception message (the top of the stack).
4. It always runs after try/catch, whether or not an exception occurred. Use it for cleanup such as closing Scanners, files and connections.
5. Catch blocks are checked in order, and `Exception` matches everything, so the specific blocks after it would never be reached (that's a compile error).
6. The invalid token is still sitting in the Scanner's buffer. Without discarding it, `nextInt()` fails on it again forever (an infinite loop).
7. `throw` is a statement that throws one exception object. `throws` is in a method header and declares the exception types the method may pass to its caller.
8. Checked: `FileNotFoundException`/`IOException` (the compiler forces you to handle them). Unchecked: `NullPointerException`, `ArithmeticException` (subclasses of RuntimeException).
9. `Infinity` (floating-point division doesn't throw).
10. 999, 1000, 1001, 4999, 5000, 5001, plus 0, a negative value and a non-numeric input.
</details>

---

## 10. Summary

- **Compile errors** stop compilation, **exceptions** crash at runtime, and **logic errors** give wrong answers.
- Read stack traces from the top: exception type, message, then the line where it happened.
- `try { risky } catch (Specific e) { handle } finally { cleanup }`. Specific catches go first; never swallow exceptions silently.
- Validate input with a loop plus try/catch, and clear bad Scanner input with `nextLine()`.
- `throw new X("msg")` to signal a problem; `throws X` to pass a checked exception up.
- Debug: reproduce → locate (stack trace, prints, breakpoints) → understand → fix → retest. Always test the **boundaries**.
