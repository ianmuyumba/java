# Unit 03 Â· Variables, Data Types & Operators

[Course home](../README.md) · [Progress](../PROGRESS.md) · [← Previous](../02-Software-Development-and-OOP-Basics/README.md) · [Next →](../04-Methods-and-Library-Classes/README.md)

**Read → trace → code → test → explain**

[Source library](sources/README.md) · [Practice guide](PRACTICE.md)

[Liang Ch. 2](../00-Course-Info/sources/textbook/chapter-2-elementary-programming.md) · [Liang Ch. 4](../00-Course-Info/sources/textbook/chapter-4-mathematical-functions-characters-and-strings.md)

<details>
<summary>On this page</summary>

- [Start here: Representation affects the answer](#start-here-representation-affects-the-answer)
- [Learning outcomes](#learning-outcomes)
- [1. Variables](#1-variables)
- [2. The eight primitive types](#2-the-eight-primitive-types)
- [3. Numeric data and operators (JFo 3-2)](#3-numeric-data-and-operators-jfo-3-2)
- [4. Textual data (JFo 3-3)](#4-textual-data-jfo-3-3)
- [5. Converting between types (JFo 3-4)](#5-converting-between-types-jfo-3-4)
- [6. Keyboard input (JFo 3-5)](#6-keyboard-input-jfo-3-5)
- [7. Worked example: an interactive calculator](#7-worked-example-an-interactive-calculator)
- [8. Exercises](#8-exercises)
- [9. Common mistakes](#9-common-mistakes)
- [10. Practice questions](#10-practice-questions)
- [11. Summary](#11-summary)

</details>

## Start here: Representation affects the answer

Liang §§2.9–2.15 connects type choice, numeric literals, expression evaluation and conversion. Java evaluates an integer division before assigning its result to a `double`: `double mean = 11 / 2;` stores `5.0`. Convert an operand first: `11 / 2.0`.

```java
int cents = 1250;
int quantity = 3;
int totalCents = cents * quantity;
System.out.printf("%d.%02d%n", totalCents / 100, totalCents % 100);
```

For small monetary exercises, integer minor units avoid binary floating-point rounding. Larger products can overflow `int`; choose ranges deliberately. An explicit cast may lose information—it does not validate the input.

`char` represents one UTF-16 code unit; some visible characters require two code units. Consequently `String.length()` counts code units, not necessarily visible characters.

**Check yourself:** explain why `(double)(7 / 2)` differs from `(double)7 / 2`. Test 0, a negative value and a value near the maximum chosen integer range.

> **Class:** RBCS 7121 Week 2 (Java Fundamentals)
> **Oracle JFo:** Section 3 (3-1 What is a Variable, 3-2 Numeric Data, 3-3 Textual Data, 3-4 Converting Between Data Types, 3-5 Keyboard Input, 3-6 Practice)

---

## Learning outcomes

1. **Choose** the right data type for a value (e.g. `double` vs `int` for money, `String` for phone numbers).
2. **Predict** the result of expressions that involve operator precedence, integer division and type conversion.
3. **Spot** type-mismatch errors before compiling.
4. **Build** an interactive program that reads input with `Scanner` and does calculations.

---

## 1. Variables

A **variable** is a named box in memory that holds a value.
- The **label** is the variable name (`customerName`)
- The **contents** are the value (`"Alice Wanjiku"`)
- The **size and shape of the box** is the data type (a small box for an age, a big one for a world population)

```java
int age;                   // declaration: create the box
age = 20;                  // assignment / initialisation: put a value in
int studentAge = 20;       // declare and initialise in one step
int x = 10, y = 20, z = 30; // several of the same type
age = 21;                  // a variable's value can change
```

**Rules for names:** start with a letter, `_` or `$`; no spaces or hyphens; no keywords; case-sensitive. **Convention:** `camelCase` for variables (`totalPrice`) and `UPPER_SNAKE_CASE` for constants:

```java
final double VAT_RATE = 0.16;   // final = a constant; it can't be reassigned
```

Use names that say what the value means: `monthlyProfit`, not `mp` or `x`.

---

## 2. The eight primitive types

| Type | Size | Range / precision | Example | Use for |
|------|------|-------------------|---------|---------|
| `byte` | 8 bits | âˆ’128 to 127 | `byte age = 20;` | Tiny numbers (saving memory) |
| `short` | 16 bits | âˆ’32,768 to 32,767 | `short year = 2026;` | Medium numbers |
| **`int`** | 32 bits | about Â±2.1 billion | `int population = 54_000_000;` | **The default whole-number type** |
| `long` | 64 bits | about Â±9.2 Ã— 10Â¹â¸ | `long worldPop = 8_000_000_000L;` | Very large whole numbers. **Needs `L`** |
| `float` | 32 bits | ~7 significant digits | `float rate = 7.5f;` | Less precise decimals. **Needs `f`** |
| **`double`** | 64 bits | ~15 significant digits | `double balance = 15000.75;` | **The default decimal type** |
| `char` | 16 bits | one Unicode character (0â€“65,535) | `char grade = 'A';` | A single character, in **single quotes** |
| `boolean` | â€” | `true` / `false` | `boolean isActive = true;` | Yes/no conditions |

```java
long worldPopulation = 8000000000L;   // âœ… without L: "integer number too large"
float interestRate = 7.5f;            // âœ… without f: "possible lossy conversion from double to float"
int big = 1_000_000;                  // underscores make big numbers readable (Java 7+)
```

### Reference type: `String`
`String` is a **class** (capital `S`), not a primitive. It holds text in **double quotes**.

| | `char` | `String` |
|-|--------|----------|
| Quotes | `'A'` | `"A"` |
| Length | exactly 1 character | 0 or more characters |
| Kind | primitive | reference (object) |

### Choosing the right type

| To storeâ€¦ | Use | Why |
|-----------|-----|-----|
| Age, count, number of items | `int` | Whole numbers |
| Money, GPA, temperature | `double` | Has decimals |
| A letter grade | `char` | One character |
| Is the account active? | `boolean` | Yes/no |
| Name, address, ID number | `String` | Text |
| **Phone number** | **`String`** | Keeps the leading zero (`"0712345678"`), may contain `+`, and you never do arithmetic on it |
| World population | `long` | Bigger than `int` can hold |

---

## 3. Numeric data and operators (JFo 3-2)

### 3.1 Arithmetic operators

| Operator | Meaning | `17 ? 5` |
|----------|---------|----------|
| `+` | add | 22 |
| `-` | subtract | 12 |
| `*` | multiply | 85 |
| `/` | divide | **3** (integer division!) |
| `%` | remainder (modulus) | 2 |

**Integer division truncates:** when both operands are `int`, the result is an `int`, and the decimal part is simply chopped off.

```java
System.out.println(17 / 5);      // 3
System.out.println(17.0 / 5);    // 3.4  (one double makes the whole thing double)
System.out.println(17 % 5);      // 2
System.out.println(7 / 2 * 2);   // 6, not 7!
```

**Uses of `%`:** even/odd check (`n % 2 == 0`), last digit (`n % 10`), wrapping round in a cycle (`index % length`).

### 3.2 Compound assignment and increment/decrement

```java
int total = 10;
total += 5;    // total = total + 5  â†’ 15
total -= 3;    // â†’ 12
total *= 2;    // â†’ 24
total /= 4;    // â†’ 6
total %= 4;    // â†’ 2
```

| Expression | Name | Behaviour |
|------------|------|-----------|
| `x++` | post-increment | use the current value, *then* add 1 |
| `++x` | pre-increment | add 1 *first*, then use the new value |
| `x--` / `--x` | decrement | the same, subtracting 1 |

```java
int x = 5;
int a = x++;   // a = 5, x = 6
int b = ++x;   // x = 7, b = 7
```

### 3.3 Relational operators (they return a `boolean`)
`==` equal Â· `!=` not equal Â· `>` Â· `<` Â· `>=` Â· `<=`

> âš ï¸ `=` **assigns** a value; `==` **compares**. `if (x = 5)` is a compile error in Java.

### 3.4 Logical operators

| Operator | Meaning | True whenâ€¦ |
|----------|---------|------------|
| `&&` | AND | **both** sides are true |
| `\|\|` | OR | **at least one** side is true |
| `!` | NOT | flips the value |

**Short-circuit evaluation:** with `&&`, if the left side is `false` the right side is never evaluated. With `||`, if the left side is `true` the right side is skipped.

```java
int x = 5;
boolean r = (x > 10) && (x++ > 0);   // left is false, so x++ never runs
System.out.println(x);               // 5
```

### 3.5 Operator precedence (highest first)

| Level | Operators |
|-------|-----------|
| 1 | `()` parentheses, `.` member access, `[]` |
| 2 | unary: `++` `--` `!` `-` (negation), casts `(int)` |
| 3 | `*` `/` `%` |
| 4 | `+` `-` |
| 5 | `<` `<=` `>` `>=` |
| 6 | `==` `!=` |
| 7 | `&&` |
| 8 | `\|\|` |
| 9 | `? :` (ternary) |
| 10 | `=` `+=` `-=` â€¦ (assignment, evaluated right to left) |

Operators on the same level are evaluated **left to right** (except assignment).

```java
10 + 5 * 2        // 20   (* first)
(10 + 5) * 2      // 30   (brackets first)
20 % 3 + 4 * 2    // 2 + 8 = 10
10 > 5 && 3 < 4   // true && true = true
```

**Tip:** when in doubt, add brackets. They cost nothing and make the meaning obvious.

---

## 4. Textual data (JFo 3-3)

### 4.1 Concatenation with `+`
When either side of `+` is a `String`, `+` joins rather than adds. **Evaluation goes left to right:**

```java
System.out.println("Total: " + 5 + 3);    // Total: 53   (string first, then joining)
System.out.println("Total: " + (5 + 3));  // Total: 8    (brackets add first)
System.out.println(5 + 3 + " items");     // 8 items     (numbers add first, then join)
```

### 4.2 Escape sequences
Special characters inside a string start with a backslash `\`:

| Sequence | Produces |
|----------|----------|
| `\n` | new line |
| `\t` | tab |
| `\"` | a double quote |
| `\'` | a single quote |
| `\\` | a backslash |

```java
System.out.println("She said \"Hello\"\nPath: C:\\Users\\Ian\tDone");
```
Output:
```
She said "Hello"
Path: C:\Users\Ian	Done
```

### 4.3 `print`, `println` and `printf`

```java
System.out.print("No newline after this. ");
System.out.println("This ends the line.");
System.out.printf("Balance: KSh %.2f%n", 15000.756);   // Balance: KSh 15000.76
System.out.printf("%-10s|%5d|%n", "Ian", 42);         // left-aligned name, right-aligned number
```
`printf` format codes: `%d` int Â· `%f` decimal (`%.2f` = 2 decimal places) Â· `%s` String Â· `%c` char Â· `%b` boolean Â· `%n` new line Â· a number gives the width (`%5d`) Â· `-` left-aligns.

### 4.4 `char` is really a number
A `char` stores a Unicode code, so you can do arithmetic on it:
```java
char c = 'A';
int code = c;              // 65
char next = (char)(c + 1); // 'B'
```

---

## 5. Converting between types (JFo 3-4)

### 5.1 Widening (implicit, automatic, safe)
From a smaller type to a bigger one:
```
byte â†’ short â†’ int â†’ long â†’ float â†’ double
               char â†—
```
```java
int i = 100;
double d = i;          // 100.0
char letter = 'A';
int ascii = letter;    // 65
```

**Promotion in expressions:** in a calculation, every operand is promoted to the widest type present. Also, `byte`, `short` and `char` are always promoted to at least `int`:

```java
byte b1 = 10, b2 = 20;
// byte sum = b1 + b2;     // âŒ b1 + b2 is an int
byte sum = (byte)(b1 + b2); // âœ…
```

### 5.2 Narrowing (explicit casting, may lose data)

```java
double pi = 3.99;
int whole = (int) pi;                 // 3  (truncates, does NOT round)
int rounded = (int) Math.round(pi);   // 4
long big = 1_000_000L;
int small = (int) big;                // fine, because it fits
```

**Overflow:** casting a value that doesn't fit wraps it round:
```java
short s = 128;
System.out.println((byte) s);   // -128   (byte only goes up to 127)
byte b = 127;
b++;                            // b is now -128
```

> **Watch the timing of a cast.** `(double)(7 / 2)` â†’ `3.0` (the integer division already happened). `(double) 7 / 2` â†’ `3.5` (the cast happens first, then double division).

### 5.3 Parsing Strings into numbers

```java
int n      = Integer.parseInt("123");      // 123
double p   = Double.parseDouble("45.67");  // 45.67
long pop   = Long.parseLong("8000000000");
boolean ok = Boolean.parseBoolean("true");

Integer.parseInt("abc");   // âŒ NumberFormatException at runtime
Integer.parseInt("12.5");  // âŒ NumberFormatException (not a whole number)
```

### 5.4 Numbers into Strings
```java
String s1 = "" + 42;
String s2 = String.valueOf(42);
String s3 = Integer.toString(42);
```

### 5.5 Type-mismatch errors (catch them before compiling)

| Wrong | Why | Fix |
|-------|-----|-----|
| `int x = 3.14;` | double â†’ int needs a cast | `int x = (int) 3.14;` |
| `int y = "100";` | a String isn't a number | `int y = Integer.parseInt("100");` |
| `int z = true;` | boolean isn't numeric | use the right type |
| `String s = 'A';` | char isn't a String | `String s = "A";` |
| `boolean b = 1;` | Java has no 1/0 for true/false | `boolean b = true;` |
| `long l = 8000000000;` | literal too big for int | add `L` |
| `float f = 7.5;` | 7.5 is a double | add `f` |

---

## 6. Keyboard input (JFo 3-5)

### 6.1 `Scanner` (console input)

```java
import java.util.Scanner;                       // 1. import

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // 2. create; System.in = keyboard

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();          // 3. read a whole line

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your GPA: ");
        double gpa = scanner.nextDouble();

        System.out.println("\n" + name + " is " + age + " with GPA " + gpa);
        scanner.close();                           // 4. close when done
    }
}
```

| Method | Reads |
|--------|-------|
| `nextLine()` | the whole line, including spaces |
| `next()` | the next **token** (word, up to whitespace) |
| `nextInt()` / `nextDouble()` / `nextLong()` / `nextBoolean()` | the next token, converted to that type |
| `hasNextInt()` | `true` if the next token *is* an int (useful for validation) |

**Tokens and delimiters:** Scanner splits input at whitespace (the **delimiter**). For the input `128 3.141 Puppies!`, `nextInt()` â†’ 128, `nextDouble()` â†’ 3.141, `next()` â†’ `"Puppies!"`. `findInLine("BlueBumper")` searches the current line for that text.

**Scanner can read a file too** (exercise `Input04`): `new Scanner(Input04.class.getResourceAsStream("input04text.txt"))`.

### 6.2 Classic pitfall: `nextLine()` after `nextInt()`
`nextInt()` leaves the Enter key (`\n`) in the buffer, so the next `nextLine()` returns an empty string straight away.

```java
int age = scanner.nextInt();
scanner.nextLine();                  // âœ… swallow the leftover newline
String name = scanner.nextLine();    // now this waits for the user
```

Typing `abc` when `nextInt()` expects a number throws `InputMismatchException` (handled properly in Unit 10).

### 6.3 `JOptionPane` (pop-up dialog input)

```java
import javax.swing.JOptionPane;

String input = JOptionPane.showInputDialog("Enter your age");   // always returns a String
int age = Integer.parseInt(input);                              // so parse it
JOptionPane.showMessageDialog(null, "Next year you'll be " + (age + 1));

// In one line:
int n = Integer.parseInt(JOptionPane.showInputDialog("Number?"));
```

---

## 7. Worked example: an interactive calculator

```java
import java.util.Scanner;

public class InteractiveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("\nRESULTS FOR " + name.toUpperCase());
        System.out.println("Addition:       " + (num1 + num2));
        System.out.println("Subtraction:    " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        if (num2 != 0) {
            System.out.println("Division:       " + (num1 / num2));
        } else {
            System.out.println("Division:       cannot divide by zero!");
        }
        System.out.printf("Average:        %.2f%n", (num1 + num2) / 2);
        scanner.close();
    }
}
```
Sample run (input `Ian`, `25`, `4`):
```
RESULTS FOR IAN
Addition:       29.0
Subtraction:    21.0
Multiplication: 100.0
Division:       6.25
Average:        14.50
```

---

## 8. Exercises

| Exercise | What to do | Concept |
|----------|-----------|---------|
| `Variables01` | Run it, then change `x` once and see every line update | Why variables exist |
| `Variables02` | Follow the steps in the comments | Reassigning variables |
| `Variables03` | **Fix all the compile errors** (wrong types, undeclared and misspelt variables, a variable used before it's initialised) | Type mismatch, declaration |
| `Chickens01/02` | Declare the variables for the egg farm and calculate the totals, daily/monthly averages and profit | Arithmetic, choosing types |
| `ShoppingCart01/02` | Build a message string, then add price, tax, quantity and total | Concatenation, operators |
| `Casting01` | `byte` = 128, then cast a `short` 128 to `byte`, then 127 + 1 | Overflow, casting |
| `Casting02` | Fix the population program (int overflow, the `long` literal, double â†’ long) | Widening, narrowing |
| `Parsing01` | Parse `shirtPrice` and `taxRate`, then try parsing gibberish | `parseInt`, `parseDouble`, NumberFormatException |
| `Input01/02` | `JOptionPane` input, parse it, add 1 | Dialog input |
| `Input03` | Read three ints with Scanner and print the sum | Scanner |
| `Input04` | Read tokens from `input04text.txt` and find `BlueBumper`'s x/y | Tokens, `findInLine` |
| `JavaLibs` / `JavaLibsPractice` | Use a class from an external `.jar` library | Libraries |
| `my-work/TypeConversion.java` | **To do:** demonstrate widening, narrowing, parsing and `String.valueOf` | All of Â§5 |

Run one: `java 03-Variables-Data-Types-and-Operators/exercises/Variables01/Variables01.java`

---

## 9. Common mistakes

| Mistake | Fix |
|---------|-----|
| `int avg = total / count;` gives 3 instead of 3.4 | Make one operand a double: `(double) total / count` |
| `"Sum: " + a + b` prints `Sum: 23` | Use brackets: `"Sum: " + (a + b)` |
| `char c = "A";` | Single quotes: `'A'` |
| Forgetting `L` / `f` on literals | `8_000_000_000L`, `7.5f` |
| Phone number stored as `int` | Use `String` |
| Empty name after reading an age | Add `scanner.nextLine()` after `nextInt()` |
| `(int) 3.9` expected to give 4 | Casting truncates. Use `Math.round` |
| Using a variable before giving it a value | "variable might not have been initialized": assign it first |

---

## 10. Practice questions

1. Which type would you use for: a student's age, a bank balance, an M-Pesa phone number, the world's population, a yes/no "isPaid" flag?
2. What do `17 / 5`, `17.0 / 5`, `17 % 5` and `-17 % 5` give?
3. Evaluate `20 % 3 + 4 * 2 - 10 / 4`.
4. `int x = 5; int y = x++ + ++x;` What are `x` and `y`?
5. What does `System.out.println("Result: " + 4 + 6);` print? How do you make it print `Result: 10`?
6. What is the difference between implicit and explicit casting? Give an example of each.
7. What does `(int) 3.99` give? How would you round it instead?
8. Why doesn't `float f = 3.5;` compile?
9. What happens when you run `Integer.parseInt("12.5")`?
10. Why does `nextLine()` return an empty string straight after `nextInt()`? How do you fix it?
11. Which of these compile? (a) `long l = 3000000000;` (b) `double d = 5;` (c) `int i = 5.0;` (d) `byte b = 100;`
12. What does `(byte) 130` give, and why?
13. Write the `printf` call that prints `Total: KSh 1,234.50`-style output with exactly 2 decimals for `double total = 1234.5;`.

<details>
<summary><b>Answers</b></summary>

1. `int`, `double`, `String`, `long`, `boolean`.
2. `3`, `3.4`, `2`, `-2` (the remainder takes the sign of the left operand).
3. `2 + 8 - 2 = 8` (10/4 is integer division, which gives 2).
4. `x++` gives 5 (x becomes 6). `++x` makes x 7 and gives 7. So y = 12 and x = 7.
5. `Result: 46`. Write `"Result: " + (4 + 6)` instead.
6. Implicit (widening) happens automatically from small to large: `double d = 10;`. Explicit (narrowing) needs a cast operator: `int i = (int) 9.7;`.
7. `3`. Use `(int) Math.round(3.99)` â†’ `4`.
8. `3.5` is a `double` literal, and double â†’ float is narrowing. Write `3.5f`.
9. It throws a `NumberFormatException`, because "12.5" isn't an integer.
10. `nextInt()` leaves the newline in the buffer, and `nextLine()` reads up to that newline straight away. Call an extra `scanner.nextLine()` after `nextInt()`.
11. (a) âŒ needs `L`. (b) âœ… widening. (c) âŒ needs a cast. (d) âœ… 100 fits in a byte.
12. `-126`. A byte holds âˆ’128 to 127, and 130 wraps round: 130 âˆ’ 256 = âˆ’126.
13. `System.out.printf("Total: KSh %.2f%n", total);` (or `%,.2f` to add thousands separators).
</details>

---

## 11. Summary

- A variable is a typed, named box: `type name = value;`. Use `final` for constants.
- There are **8 primitives**: `byte`, `short`, `int`, `long` (L), `float` (f), `double`, `char` ('x'), `boolean`. **`String`** ("x") is a reference type.
- `int / int` truncates. `%` gives the remainder. `*`, `/` and `%` come before `+` and `-`. Brackets override everything.
- `x++` uses the value and then increments; `++x` increments first. `&&` and `||` short-circuit.
- Widening is automatic; narrowing needs `(type)` and may truncate or overflow. Parse strings with `Integer.parseInt` and `Double.parseDouble`.
- `Scanner(System.in)`: `nextLine`, `next`, `nextInt`, `nextDouble`. Clear the newline after `nextInt`. Close the scanner when done.
