# Unit 05 · Conditionals (Decision Making)

> **Class:** RBCS 7121 Week 3 (Control Flow: Conditionals)
> **Oracle JFo:** Section 5 (5-1 Boolean Expressions and if/else Constructs; 5-2 Conditional Execution and 5-3 switch are covered here from the class notes)
> **Files in this folder**
> - `class-notes/`: Week 3 comprehensive notes, Practical Session 3 (Mastering Conditionals), "Your Learning Journey"
> - `oracle-jfo/`: lesson 5-1
> - `exercises/`: AgeCheck, AgeValidity, ChkOddEven, StringEquality
> - `my-work/`: `PositiveNegativeZero.java`, `StudentGrade.java`

---

## Learning outcomes

1. **Design** a decision structure for several conditions using if-else-if, nested if or `switch`, whichever fits best.
2. **Analyse** complex boolean expressions and work out every possible execution path.
3. **Evaluate** which conditional structure is the most readable and efficient for a given piece of logic.
4. **Debug** a faulty conditional by tracing it with test inputs.

---

## 1. Why programs make decisions

| Application | Decision |
|-------------|----------|
| M-Pesa | Is the balance enough? → approve or decline |
| ATM | Is the PIN correct? → allow or deny |
| Online shop | Is the item in stock? → add to cart, or show "out of stock" |
| Hospital system | Temperature > 37.5? → alert a doctor |

Every decision is based on a **boolean expression**: something that evaluates to `true` or `false`.

```java
age >= 18                     // relational: == != > < >= <=
balance >= amount && pinOk    // logical: && || !
!isBlocked
```

**Boolean variables** can hold the result of an expression: `boolean canVote = age >= 18;`.

---

## 2. The `if` family

### 2.1 Simple `if`: do something only when the condition is true
```java
int temperature = 38;
if (temperature > 37.5) {
    System.out.println("Warning: Patient has a fever!");
}
```
```
        temperature > 37.5 ?
         /yes          \no
  print warning     (skip)
```

### 2.2 `if-else`: two paths, exactly one of which runs
```java
int age = 16;
if (age >= 18) {
    System.out.println("You are eligible to vote.");
} else {
    System.out.println("You are NOT eligible to vote.");
}
```

### 2.3 `if-else-if` ladder: many mutually exclusive options
```java
int marks = 75;
if (marks >= 70) {
    System.out.println("Grade: A");
} else if (marks >= 60) {
    System.out.println("Grade: B");
} else if (marks >= 50) {
    System.out.println("Grade: C");
} else if (marks >= 40) {
    System.out.println("Grade: D");
} else {
    System.out.println("Grade: F (Fail)");
}
// Grade: A
```
Conditions are checked **top to bottom**. The **first** true one runs and the rest are skipped. So **order matters**: check from the highest threshold down. If `marks >= 40` came first, 75 would get a D.

### 2.4 Nested `if`: a decision inside a decision
Use it when a second question only makes sense once the first has passed (validation first, then classification). This is exactly what `my-work/StudentGrade.java` does:

```java
double gpa = 3.8;
int kcpeScore = 350;

if (gpa >= 2.5) {
    if (kcpeScore >= 300) {
        System.out.println("Admitted: both GPA and KCPE meet requirements.");
    } else {
        System.out.println("Not admitted: KCPE score below 300.");
    }
} else {
    System.out.println("Not admitted: GPA below 2.5.");
}
```

**Nested vs `&&`:** `if (a) { if (b) {...} }` is the same as `if (a && b) {...}`, *unless* you need different messages for each failure, as above.

### 2.5 Always use braces
```java
if (x > 0)
    System.out.println("A");
    System.out.println("B");   // ⚠️ ALWAYS prints: only the first line belongs to the if
```
Without `{ }`, only the **one** statement straight after the `if` is controlled. Always use braces.

**The "dangling else":** an `else` belongs to the **nearest** unmatched `if`, whatever the indentation suggests. Braces remove the ambiguity.

---

## 3. Logical operators in depth

| `A` | `B` | `A && B` | `A \|\| B` | `!A` |
|-----|-----|----------|-----------|------|
| T | T | **T** | T | F |
| T | F | F | T | F |
| F | T | F | T | T |
| F | F | F | **F** | T |

**Precedence:** `!` → `&&` → `||` (NOT first, then AND, then OR). Relational operators (`>`, `==`) are evaluated before all of these.

```java
boolean r = true || false && false;   // && first: true || false → true
```

### Tracing a complex expression

`(5 > 3) && (4 < 2) || (10 == 10)`

| Step | Expression | Result |
|------|-----------|--------|
| 1 | `5 > 3` | true |
| 2 | `4 < 2` | false |
| 3 | `true && false` | false |
| 4 | `10 == 10` | true |
| 5 | `false \|\| true` | **true** |

`!(5 > 3) || (4 < 2) && (10 == 10)` → `false || (false && true)` → `false || false` → **false**

### Short-circuit evaluation
- `&&`: if the left side is **false**, the right side is skipped (the answer must be false).
- `||`: if the left side is **true**, the right side is skipped (the answer must be true).

This is used for **safety**:
```java
String name = null;
if (name != null && name.length() > 0) {   // length() is never called on null
    System.out.println("Name is not empty");
}
if (count != 0 && total / count > 50) { ... }   // avoids dividing by zero
```

### Ranges
```java
if (age >= 18 && age <= 65)  { ... }   // inside the range: AND
if (age < 18 || age > 65)    { ... }   // outside the range: OR
// ❌ 18 <= age <= 65 is NOT valid Java
```

---

## 4. Comparing Strings

```java
String answer = "yes";
if (answer.equals("yes")) { ... }             // ✅ compares the content
if (answer.equalsIgnoreCase("YES")) { ... }   // ✅ ignores case (as in BodaBodaFare)
if (answer == "yes") { ... }                  // ❌ compares references and may fail
```
Compare **characters** (`char`) with `==`: `if (grade == 'A')`.

`compareTo` gives alphabetical order: `"apple".compareTo("banana") < 0`.

---

## 5. The `switch` statement

Picks one branch based on the **exact value** of an expression. It's ideal for menus.

```java
int choice = 2;
switch (choice) {
    case 1:
        System.out.println("Check Balance selected.");
        break;
    case 2:
        System.out.println("Send Money selected.");
        break;
    case 3:
        System.out.println("Withdraw Cash selected.");
        break;
    case 4:
        System.out.println("Buy Airtime selected.");
        break;
    default:
        System.out.println("Invalid choice.");
}
// Send Money selected.
```

**How it works:** evaluate the expression once → jump to the matching `case` → run until `break` → if nothing matches, run `default`.

### Fall-through
Without `break`, execution **falls through** into the following cases:
```java
int day = 2;
switch (day) {
    case 1: System.out.println("Monday");
    case 2: System.out.println("Tuesday");
    case 3: System.out.println("Wednesday");
    default: System.out.println("Other day");
}
```
```
Tuesday
Wednesday
Other day
```

Fall-through is useful when **several values share the same code**:
```java
char grade = 'B';
switch (grade) {
    case 'A':
    case 'B':
    case 'C':
        System.out.println("Pass");
        break;
    case 'D':
    case 'F':
        System.out.println("Fail");
        break;
    default:
        System.out.println("Invalid grade");
}
// Pass
```

### Types allowed in `switch`
✅ `int`, `char`, `byte`, `short`, **`String`** (Java 7+), enums. ❌ `long`, `float`, `double`, `boolean`.

### Modern arrow-style switch (Java 14+): no `break` needed, no fall-through
```java
String dayType = switch (day) {
    case 1, 7 -> "Weekend";
    case 2, 3, 4, 5, 6 -> "Weekday";
    default -> "Invalid";
};
```

### `switch` vs `if-else-if`

| | `switch` | `if-else-if` |
|-|----------|--------------|
| Tests | exact values only | any boolean expression |
| Ranges (`marks >= 70`) | ❌ | ✅ |
| Types | int, char, String, byte, short | any |
| Readability | cleaner for many fixed values | better for complex logic |
| Best for | menus, day names, categories | grades, ranges, combined conditions |

---

## 6. The ternary operator `? :`

A one-line `if-else` that **produces a value**:
```java
String eligibility = (age >= 18) ? "Eligible" : "Not eligible";
int max = (a > b) ? a : b;
System.out.println(n + " is " + (n % 2 == 0 ? "even" : "odd"));
```
Use it for simple either/or values. Use `if-else` when either branch needs several statements.

---

## 7. Debugging conditionals

### Common bugs

| Bug | Example | Fix |
|-----|---------|-----|
| `=` instead of `==` | `if (x = 5)` | `if (x == 5)` |
| `\|\|` where `&&` was meant | `if (x > 0 \|\| x < 10)` is always true | `&&` |
| Missing braces | the second line always runs | add `{ }` |
| Off-by-one at a boundary | `age > 18` when 18 should qualify | `age >= 18` |
| Wrong order in a ladder | `>= 40` checked before `>= 70` | highest first |
| Missing `break` | unwanted fall-through | add `break` |
| Overlapping `if`s instead of `else if` | `AgeCheck`: age 16 prints **both** messages | use `else` |
| Stray `;` after `if` | `if (x > 5);  { ... }`: the block always runs | delete the `;` |

### The process: read → trace → identify → fix → retest
Make a **trace table** with test inputs, including the **boundaries**:

```java
if (age >= 18 || age <= 65) { System.out.println("Working age"); }
```
| Input | Condition | Result | Correct? |
|-------|-----------|--------|----------|
| 10 | `10>=18 \|\| 10<=65` | true | ❌ |
| 20 | `20>=18 \|\| 20<=65` | true | ✅ |
| 70 | `70>=18 \|\| 70<=65` | true | ❌ |

Bug: `||` should be `&&`.

**Good test inputs:** a typical value, each boundary (17, 18, 65, 66), the extremes (0, a negative number, a huge number) and invalid input.

---

## 8. Worked example: a complete menu program

```java
import java.util.Scanner;

public class MpesaMenu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double balance = 5000;

        System.out.println("1. Check balance\n2. Withdraw\n3. Exit");
        System.out.print("Choose: ");
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Balance: KSh " + balance);
                break;
            case 2:
                System.out.print("Amount: ");
                double amount = in.nextDouble();
                if (amount <= 0) {
                    System.out.println("Invalid amount.");
                } else if (amount > balance) {
                    System.out.println("Insufficient funds.");
                } else {
                    balance -= amount;
                    System.out.println("Done. New balance: KSh " + balance);
                }
                break;
            case 3:
                System.out.println("Goodbye.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
        in.close();
    }
}
```

---

## 9. Exercises

| Exercise | Task |
|----------|------|
| `AgeCheck` | Bug: at age 16 both messages print. Fix it with `if-else` and the right boundary |
| `AgeValidity` | Read an age and print valid/invalid (e.g. 0–120) and adult/minor |
| `ChkOddEven` | Read a number and print "even" or "odd" (`num % 2 == 0`) |
| `StringEquality` | Read two strings; compare them with `==` and `.equals()` and explain the difference |
| `my-work/PositiveNegativeZero` | if / else-if / else (done ✅) |
| `my-work/StudentGrade` | Nested if: validate, then grade (done ✅). Try marks −5, 0, 39, 40, 70, 100, 101 |
| Extra | Rewrite the grade ladder as a `switch` on `marks / 10` |

---

## 10. Practice questions

1. What's the difference between `if-else-if` and `switch`? When would you choose each?
2. When should you use a nested `if` rather than `&&`?
3. What does `break` do in a `switch`? What happens without it?
4. Evaluate `(5 > 3) && (4 < 2) || (10 == 10)`.
5. Evaluate `!(5 > 3) || (4 < 2) && (10 == 10)`.
6. What's wrong with `if (x > 0 || x < 10)`?
7. Rewrite with the ternary operator: `if (temp > 30) msg = "Hot"; else msg = "Cool";`
8. `int x = 5; if (x > 10 && ++x > 0) {}` What is `x` afterwards? Why?
9. Why doesn't `switch` work with `double`?
10. What does this print for `marks = 75`?
    ```java
    if (marks >= 40) System.out.println("D");
    else if (marks >= 70) System.out.println("A");
    ```
11. Which test inputs would you use for "free delivery for orders of KSh 2,000 or more"?
12. Why might `if (name == "Ian")` fail even when name holds "Ian"?

<details>
<summary><b>Answers</b></summary>

1. `if-else-if` tests any boolean (ranges, combinations). `switch` matches exact values of int, char or String. Use switch for menus and fixed categories, and if-else-if for ranges and complex logic.
2. When the inner check only makes sense after the outer one has passed, or when each failure needs its own message.
3. It exits the switch. Without it, execution falls through into the next case(s).
4. `true && false` = false; `false || true` = **true**.
5. `false || (false && true)` = `false || false` = **false**.
6. It's always true: every number is either > 0 or < 10. You almost certainly meant `&&`.
7. `msg = (temp > 30) ? "Hot" : "Cool";`
8. `5`. `x > 10` is false, so `&&` short-circuits and `++x` never runs.
9. Floating-point values are imprecise, so exact matches on them are unreliable; Java simply doesn't allow it. Use if-else instead.
10. `D`. The first true condition wins; check from the highest threshold first.
11. 1999, 2000, 2001, 0, a negative amount, a very large amount.
12. `==` compares object references, not content. Use `name.equals("Ian")`.
</details>

---

## 11. Summary

| Structure | Use for | Example |
|-----------|---------|---------|
| `if` | one optional action | fever warning |
| `if-else` | two outcomes | vote / don't vote |
| `if-else-if` | several ranges | grade calculator |
| nested `if` | validate first, then decide | admission criteria |
| `switch` | exact values | menus |
| `? :` | choose between two values | `max = a > b ? a : b` |

- Precedence: `!` > `&&` > `||`. `&&` and `||` short-circuit, so use that to guard against null and divide-by-zero.
- Compare Strings with `.equals()`. Always use braces. Order ladders from the highest threshold down.
- Debug by tracing with boundary inputs.
