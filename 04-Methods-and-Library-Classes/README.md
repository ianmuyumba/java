# Unit 04 · Methods & Library Classes

[Course home](../README.md) · [Progress](../PROGRESS.md) · [← Previous](../03-Variables-Data-Types-and-Operators/README.md) · [Next →](../05-Conditionals/README.md)

**Read → trace → code → test → explain**

[Source library](sources/README.md) · [Practice guide](PRACTICE.md)

[Liang Ch. 4](../00-Course-Info/sources/textbook/chapter-4-mathematical-functions-characters-and-strings.md) · [Liang Ch. 6](../00-Course-Info/sources/textbook/chapter-6-methods.md)

<details>
<summary>On this page</summary>

- [Start here: Methods as contracts and small steps](#start-here-methods-as-contracts-and-small-steps)
- [Learning outcomes](#learning-outcomes)
- [1. What is a method? (JFo 4-1)](#1-what-is-a-method-jfo-4-1)
- [2. Packages and `import` (JFo 4-2)](#2-packages-and-import-jfo-4-2)
- [3. Reading the API documentation (Oracle BYTE tutorial)](#3-reading-the-api-documentation-oracle-byte-tutorial)
- [4. The `String` class (JFo 4-3)](#4-the-string-class-jfo-4-3)
- [5. The `Random` class (JFo 4-4)](#5-the-random-class-jfo-4-4)
- [6. The `Math` class (JFo 4-5)](#6-the-math-class-jfo-4-5)
- [7. Worked example: ComputeMethods + TestClass (Oracle Section 4 Practice, Problem 1)](#7-worked-example-computemethods--testclass-oracle-section-4-practice-problem-1)
- [8. Exercises](#8-exercises)
- [9. Common mistakes](#9-common-mistakes)
- [10. Practice questions](#10-practice-questions)
- [11. Summary](#11-summary)

</details>

## Start here: Methods as contracts and small steps

Liang §§6.5 and 6.11 explain pass-by-value and stepwise refinement. Start with the main task, name its subtasks, and implement one method per responsibility. Prefer returning a calculated result to printing inside every method: callers can then reuse and test the calculation.

Java always copies argument values. For an object argument, that value is a reference. A method can mutate the referenced object, but assigning a new object to the parameter does not replace the caller's reference.

```java
static void change(int[] values) {
    values[0] = 9;             // visible to the caller
    values = new int[] {100};  // only changes this local parameter
}
```

Given `int[] scores = {4};`, calling `change(scores)` leaves `scores[0]` equal to 9. Draw both references pointing to the same array before the reassignment.

**Try it:** split a receipt program into input, subtotal, discount and formatting methods. Test the calculation without keyboard input. Define whether negative quantities are rejected before implementing the calculation.

> **Oracle JFo:** Section 4 (4-1 What is a Method?, 4-2 The import Declaration and Packages, BYTE Java API tutorial, 4-3 The String Class, 4-4 The Random Class, 4-5 The Math Class, Section 4 Practice)
> **Class:** RBCS 7121 outline Week 4 (Methods and Arrays: defining and calling methods, parameters and return types, overloading). Arrays are in Unit 07.

---

## Learning outcomes

1. Explain what a method is and why we use methods (reuse, organisation, fewer bugs).
2. Write methods with **parameters** and **return values**, and call them correctly.
3. Call methods on objects with the **dot operator**, and call `static` methods on a class.
4. Use `import` and understand **packages**.
5. Read the **Java API documentation** to find out how to use a library class.
6. Use the **String**, **Random** and **Math** classes.

---

## 1. What is a method? (JFo 4-1)

A **method** is a named block of code that does one job. You **define** it once and **call** it as many times as you like.

**Why bother?** Look at exercise `Tip01`: calculating the total after tax and tip for 8 people means writing the same formula 8 times. With a method you write it once, and fixing a mistake means fixing one place.

### 1.1 Anatomy of a method

```java
public static double calculateTotal(double price, double taxRate) {
//  ①     ②      ③         ④               ⑤
    double total = price * (1 + taxRate);
    return total;                                          // ⑥
}
```

| Part | Meaning |
|------|---------|
| ① **access modifier** | `public` (anyone can call it) or `private` (only this class can) |
| ② **`static`** (optional) | Belongs to the class, so you can call it without creating an object |
| ③ **return type** | The type of value it gives back. **`void`** means it gives nothing back |
| ④ **name** | camelCase verb: `calculateTotal`, `printReceipt`, `isValid` |
| ⑤ **parameters** | Inputs, each with a type. `()` if there are none |
| ⑥ **`return`** | Sends a value back and ends the method. Required unless the return type is `void` |

**Method signature** = name + parameter types, e.g. `calculateTotal(double, double)`.

### 1.2 Parameters vs arguments

```java
double t = calculateTotal(100.0, 0.16);   // 100.0 and 0.16 are ARGUMENTS (the actual values)
// inside the method, price = 100.0 and taxRate = 0.16 are the PARAMETERS (the variables)
```

- Arguments must match the parameters in **number, order and type**.
- Java is **pass-by-value**: the method gets a *copy* of each argument. Changing a parameter inside the method doesn't change the caller's variable.

### 1.3 `void` vs returning a value

```java
public static void printLine() {              // does something, returns nothing
    System.out.println("--------------");
}

public static int square(int n) {             // computes and returns a value
    return n * n;
}

printLine();                    // just call it
int s = square(7);              // capture the result: 49
System.out.println(square(3));  // or use it directly: 9
```

### 1.4 Static methods vs instance methods

```java
// static: call it on the CLASS, no object needed
double r = Math.sqrt(25);
int n = Integer.parseInt("42");

// instance: create an OBJECT with new, then call the method on it with the dot operator
Calculator3 calc = new Calculator3();
calc.findTotal(10);             // object.method(arguments)
```

The **dot operator `.`** means "go inside this object or class and use this member": `calc.tax`, `calc.findTotal(10)`, `System.out.println()`.

### 1.5 A complete example with an object (exercises Calculator3 + CalculatorTest3)

```java
public class Calculator3 {
    public double tax = .05;
    public double tip = .15;

    public void findTotal(double price) {
        double total = price * (1 + tax + tip);
        System.out.println("$" + total);
    }
}
```
```java
public class CalculatorTest3 {
    public static void main(String[] args) {
        Calculator3 calc = new Calculator3();   // instantiate
        calc.findTotal(10);                     // $12.0
        calc.findTotal(12);                     // $14.399999999999999 (double rounding; format with printf("%.2f"))
        calc.tip = .20;                         // change a field through the object
        calc.findTotal(30);                     // $37.5
    }
}
```
The supplied files are in separate exercise folders. Use the repository-root compile command in the [exercise guide](../EXERCISES.md).

### 1.6 Variable scope
A variable exists only inside the `{ }` block where it's declared. Variables declared inside a method (**local variables**) disappear when the method ends, and other methods can't see them.

### 1.7 Method overloading (preview; more in Unit 08)
Several methods can share a name as long as their **parameter lists differ**:
```java
static int add(int a, int b)          { return a + b; }
static double add(double a, double b) { return a + b; }
static int add(int a, int b, int c)   { return a + b + c; }
```
Java picks the right one from the arguments you pass. The return type alone is **not** enough to tell overloads apart.

---

## 2. Packages and `import` (JFo 4-2)

A **package** is a folder of related classes, such as `java.util` (utilities: `Scanner`, `Random`, `ArrayList`), `java.io` (files), `javax.swing` (GUI: `JOptionPane`) or `java.lang` (core: `String`, `Math`, `System`, `Integer`).

```java
import java.util.Scanner;    // import one class (preferred: clear and explicit)
import java.util.*;          // import every class in java.util (wildcard)
```

- `import` statements go **at the top of the file**, before the class.
- **`java.lang` is imported automatically**, which is why `String`, `Math` and `System` need no import.
- Without an import you can still use the **fully-qualified name**: `javax.swing.JLabel label = new javax.swing.JLabel("hello");` (exercise `AddImport`).
- Unused imports compile fine; IDEs just grey them out.
- Your own classes can go in a package too: put `package week2;` on the first line, and the file belongs in a `week2/` folder.

---

## 3. Reading the API documentation (Oracle BYTE tutorial)

The **Java API docs** (search "Java 21 API String" or go to docs.oracle.com/en/java/javase/) describe every library class. For each class you'll find:
- the **package** it's in (so you know what to import)
- a description
- **constructors**: how to create objects (`new Random()`, `new Random(long seed)`)
- **method summary**: each method's return type, name, parameters and description
- **fields**: constants such as `Math.PI`

**Javadoc** comments (`/** ... */` with `@param` and `@return`) in *your* code produce the same style of documentation. Run `javadoc MyClass.java` to generate HTML.

```java
/**
 * Converts Fahrenheit to Celsius.
 * @param degreesF temperature in °F
 * @return temperature in °C
 */
public double fToC(double degreesF) { ... }
```

---

## 4. The `String` class (JFo 4-3)

A `String` is an **object**. Strings are **immutable**: their contents cannot change. Methods that transform text return a String result, which may reuse an existing instance.

```java
String s = "Java Programming";
//          0123456789...      ← indexes start at 0
```

| Method | Returns | `s = "Java Programming"` |
|--------|---------|--------------------------|
| `length()` | number of characters | `16` |
| `charAt(i)` | the char at index i | `charAt(0)` → `'J'` |
| `indexOf(str)` | first position of str, or **-1** if missing | `indexOf("a")` → `1`; `indexOf("x")` → `-1` |
| `lastIndexOf(str)` | last position | `lastIndexOf("a")` → `10` |
| `substring(start)` | from start to the end | `substring(5)` → `"Programming"` |
| `substring(start, end)` | from start up to **but not including** end | `substring(0, 4)` → `"Java"` |
| `toUpperCase()` / `toLowerCase()` | changed case | `"JAVA PROGRAMMING"` |
| `trim()` | removes spaces at both ends | `"  hi ".trim()` → `"hi"` |
| `replace(a, b)` | every a replaced by b | `replace("a", "4")` → `"J4v4 Progr4mming"` |
| `contains(str)` | boolean | `contains("Pro")` → `true` |
| `startsWith` / `endsWith` | boolean | `endsWith("ing")` → `true` |
| `equals(other)` | **same content?** | `"abc".equals("abc")` → `true` |
| `equalsIgnoreCase(other)` | same content, ignoring case | `"YES".equalsIgnoreCase("yes")` → `true` |
| `compareTo(other)` | 0 if equal, negative if this comes first alphabetically, positive if after | `"apple".compareTo("banana")` < 0 |
| `isEmpty()` | length == 0 | |

> ⚠️ **Compare Strings with `.equals()`, never `==`.** `==` checks whether two variables point to the *same object*, not whether the text is the same. Two Strings can hold the same text and still be different objects.

```java
String a = "hello";
String b = new String("hello");
System.out.println(a == b);       // false (different objects)
System.out.println(a.equals(b));  // true  (same text)
```

### Worked example: ProcessName (Oracle Section 4 Practice, Problem 2)

```java
import java.util.Scanner;

public class ProcessName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Type your name: ");
        String name = console.nextLine().trim();          // "Jenny Weaver"

        int space = name.indexOf(" ");                    // 5
        String first = name.substring(0, space);          // "Jenny"
        String last = name.substring(space + 1);          // "Weaver"

        System.out.println("Your name is: " + last + ", " + first.charAt(0) + ".");
        console.close();
    }
}
```
```
Type your name: Jenny Weaver
Your name is: Weaver, J.
```

---

## 5. The `Random` class (JFo 4-4)

```java
import java.util.Random;

Random rand = new Random();
int a = rand.nextInt(6);          // 0 to 5   (the bound is EXCLUSIVE)
int die = rand.nextInt(6) + 1;    // 1 to 6
int n = rand.nextInt(11) + 10;    // 10 to 20
double d = rand.nextDouble();     // 0.0 (inclusive) to 1.0 (exclusive)
boolean b = rand.nextBoolean();
```

**Range formula:** a random int from `min` to `max` inclusive is `rand.nextInt(max - min + 1) + min`.

**Seeds:** `new Random(42)` produces the **same sequence every run**. That's useful for testing and for repeating results. Without a seed, the sequence is different each run.

**Coin flip (exercise `FlipCoin`):**
```java
Random rand = new Random();
if (rand.nextDouble() < 0.5) {
    System.out.println("Heads");
} else {
    System.out.println("Tails");
}
```

`Math.random()` also returns a double from 0.0 up to (but not including) 1.0. `(int)(Math.random() * 6) + 1` gives a die roll.

---

## 6. The `Math` class (JFo 4-5)

Every method is `static`: call them as `Math.method(...)`. No import is needed (`java.lang`).

| Method / field | Result | Example |
|----------------|--------|---------|
| `Math.PI`, `Math.E` | constants | `3.14159…` |
| `Math.sqrt(x)` | square root | `Math.sqrt(25)` → `5.0` |
| `Math.pow(a, b)` | a to the power b | `Math.pow(2, 10)` → `1024.0` |
| `Math.abs(x)` | absolute value | `Math.abs(-7)` → `7` |
| `Math.max(a, b)` / `Math.min(a, b)` | larger / smaller | `Math.max(3, 9)` → `9` |
| `Math.round(x)` | nearest whole number (long) | `Math.round(2.5)` → `3` |
| `Math.ceil(x)` / `Math.floor(x)` | round up / down (double) | `ceil(2.1)` → `3.0`, `floor(2.9)` → `2.0` |
| `Math.random()` | 0.0 ≤ r < 1.0 | |

**BMI (exercise `ComputeBMI`):** `bmi = weightKg / Math.pow(heightM, 2);`

---

## 7. Worked example: ComputeMethods + TestClass (Oracle Section 4 Practice, Problem 1)

```java
import java.util.Random;

public class ComputeMethods {

    public double fToC(double degreesF) {
        return 5.0 / 9 * (degreesF - 32);      // 5.0, not 5: 5/9 would be integer division = 0!
    }

    public double hypotenuse(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public int roll() {
        Random rand = new Random();
        int die1 = rand.nextInt(6) + 1;
        int die2 = rand.nextInt(6) + 1;
        return die1 + die2;
    }
}
```
```java
public class TestClass {
    public static void main(String[] args) {
        ComputeMethods cm = new ComputeMethods();
        System.out.println("Temp in celsius is " + cm.fToC(100.4));
        System.out.println("Hypotenuse is " + cm.hypotenuse(6, 9));
        System.out.println("The sum of the dice values is " + cm.roll());
    }
}
```
```
Temp in celsius is 38.00000000000001      ← tiny floating-point rounding error, which is normal
Hypotenuse is 10.816653826391969
The sum of the dice values is 9           ← random, 2 to 12
```

---

## 8. Exercises

| Exercise | Task |
|----------|------|
| `Tip01` | Compute each of 8 people's total (+5% tax, +15% tip) **without** methods. Notice how repetitive it is |
| `Calculator2` + `CalculatorTest2` | Write `findTotal()` using the `originalPrice` field; create the object, set the price, call it for each person |
| `Calculator3` + `CalculatorTest3` | The same, but pass the price as a **parameter** |
| `Calculator4` | Add a `String name` parameter; make it **return** the total; handle Alex's and Forgetful's meals |
| `ComputeMethods` + `TestClass` | `fToC`, `hypotenuse`, `roll` (§7) |
| `ProcessName` | "Jenny Weaver" → "Weaver, J." (§4) |
| `NameMaker` | Build names or usernames with String methods (`substring`, `toUpperCase`, concatenation) |
| `ComputeBMI` | Read weight and height with Scanner, then use `Math.pow` |
| `FlipCoin` | Heads/tails from `nextDouble()` |
| `RockPaperScissor` | Random computer move (`nextInt(3)`) against the user's move |
| `AddImport` | Replace the fully-qualified `javax.swing.JLabel` with an `import` |

---

## 9. Common mistakes

| Mistake | Fix |
|---------|-----|
| `5 / 9 * (f - 32)` always gives 0 | Integer division: use `5.0 / 9` |
| Calling an instance method from static `main` without an object (`non-static method … cannot be referenced from a static context`) | Create an object first, or make the method `static` |
| `missing return statement` | Every path through a non-void method must `return` a value |
| Ignoring a return value: `name.toUpperCase();` | Strings are immutable: `name = name.toUpperCase();` |
| `str1 == str2` to compare text | `str1.equals(str2)` |
| `substring(0, 4)` expected to include index 4 | The end index is **exclusive** |
| `nextInt(6)` expected to give 1–6 | It gives 0–5; add 1 |
| Forgetting `import java.util.Random;` | `cannot find symbol: class Random` |

---

## 10. Practice questions

1. Label the parts of: `private static boolean isAdult(int age)`.
2. What's the difference between a parameter and an argument?
3. When does a method need `return`? What does `void` mean?
4. Write a method `average(double a, double b, double c)` that returns the average.
5. How do you call (a) a static method, (b) an instance method?
6. Why doesn't `Math` need an import, but `Scanner` does?
7. For `String s = "M-Pesa Agent";`, what are `s.length()`, `s.indexOf("-")`, `s.substring(2, 6)`, `s.charAt(7)` and `s.toLowerCase()`?
8. Why should Strings be compared with `.equals()`?
9. Write an expression for a random integer from 50 to 100 inclusive.
10. What's the effect of creating `new Random(7)` in two different runs?
11. What do `Math.round(4.5)`, `Math.floor(-2.5)` and `Math.pow(3, 3)` return?
12. Can two methods have the same name? Under what condition?

<details>
<summary><b>Answers</b></summary>

1. `private` = access modifier; `static` = belongs to the class; `boolean` = return type; `isAdult` = name; `int age` = parameter.
2. A parameter is the variable in the method definition. An argument is the actual value passed in the call.
3. Whenever the return type isn't `void`. `void` means the method returns nothing.
4. `public static double average(double a, double b, double c) { return (a + b + c) / 3; }`
5. (a) `ClassName.method()`, e.g. `Math.sqrt(9)`. (b) `objectRef.method()`, e.g. `calc.findTotal(10)`.
6. `Math` is in `java.lang`, which is imported automatically. `Scanner` is in `java.util`.
7. `12`, `1`, `"Pesa"`, `'A'`, `"m-pesa agent"`.
8. `==` compares object references (memory addresses), not the characters. `.equals()` compares the contents.
9. `rand.nextInt(51) + 50`
10. Both runs produce exactly the same sequence of random numbers.
11. `5` (long), `-3.0`, `27.0`.
12. Yes, if their parameter lists differ (number, types or order). This is called overloading.
</details>

---

## 11. Summary

- A method = `modifier [static] returnType name(parameters) { body; return value; }`. Write it once and call it many times.
- Arguments are copied into parameters (pass-by-value). `void` methods return nothing.
- Static methods are called on the class (`Math.sqrt`); instance methods are called on an object (`calc.findTotal`).
- `import package.Class;` goes at the top. `java.lang` is automatic. The API docs tell you a class's package, constructors and methods.
- **String:** immutable; indexes start at 0; `substring(start, end)` excludes end; compare with `.equals()`.
- **Random:** `nextInt(n)` gives 0…n-1; seeds make the sequence repeatable. **Math:** static utilities such as `sqrt`, `pow`, `round` and `PI`.
