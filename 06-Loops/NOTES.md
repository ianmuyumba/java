# Unit 06 · Loops

> **Class:** RBCS 7121 Week 4 (Control Flow: Loops), plus the Week 5 "10 Real-Life Critical Thinking Problems" and the Boda Boda assignment
> **Oracle JFo:** Section 6 (6-1 for Loops, 6-2 while and do-while Loops, 6-3 Using break and continue, 6-4 Practice)
> **Files in this folder**
> - `class-notes/`: Week 4 comprehensive notes, Practical Session 4, achievement summary, Week 5 critical-thinking problems
> - `oracle-jfo/`: lessons 6-1 to 6-4
> - `exercises/`: Countdown, ScopeTest, InfiniteLoop, LoopShape + LoopShapeTest, ComputeSum, DisplayMultiples, SumofNums, SquareRootWhile, ValidatePin, Divisors, CountChar, BreakContinue
> - `my-work/`: `BodaBodaFare.java` (the assignment: Scanner + if-else + a sentinel while loop)

---

## Learning outcomes

1. **Analyse** loop efficiency (linear vs nested) by counting iterations.
2. **Choose** the right loop (`for`, `while`, `do-while`, for-each) for a repetition task.
3. **Debug** infinite loops by tracing how the loop variable and condition change.
4. **Create** nested loops that draw patterns (triangle, pyramid, multiplication table).

---

## 1. What a loop is

A **loop** repeats a block of code while a condition is true. Think of a washing machine: *while the clothes are dirty → wash, rinse, spin.*

Without loops, processing 1,000 M-Pesa transactions would mean copying the same code 1,000 times. With a loop, you write it once and it runs 1,000 times.

### The four parts of every loop

| Part | Purpose | Example |
|------|---------|---------|
| **Initialisation** | the starting value | `int i = 1;` |
| **Condition** | when to keep going | `i <= 10` |
| **Body** | the code that repeats | `System.out.println(i);` |
| **Update** | move towards the end | `i++` |

> **Golden rule:** the update must move the loop variable **towards** making the condition false. If it doesn't, you get an infinite loop.

Each pass through the body is called an **iteration**.

---

## 2. The `while` loop: checks first, may run zero times

```java
int i = 1;                      // initialise
while (i <= 5) {                // condition, checked BEFORE each pass
    System.out.println("Number: " + i);
    i++;                        // update. Forget this and it never stops!
}
```

**Trace table:**

| Iteration | `i` before | `i <= 5` | Output | `i` after |
|-----------|-----------|----------|--------|-----------|
| 1 | 1 | true | 1 | 2 |
| 2 | 2 | true | 2 | 3 |
| 3 | 3 | true | 3 | 4 |
| 4 | 4 | true | 4 | 5 |
| 5 | 5 | true | 5 | 6 |
| — | 6 | **false** | (loop ends) | |

**Use `while` when you don't know how many times it will repeat**: input validation, reading until a sentinel value, games.

```java
// Keep asking until the user gives a valid amount
Scanner scanner = new Scanner(System.in);
int deposit = 0;
while (deposit <= 0) {
    System.out.print("Enter positive deposit amount: ");
    deposit = scanner.nextInt();
    if (deposit <= 0) {
        System.out.println("Error: Amount must be positive!");
    }
}
System.out.println("Deposit successful: KSh " + deposit);
```

---

## 3. The `do-while` loop: runs at least once

```java
do {
    // body
} while (condition);     // ← note the semicolon
```

The body runs **first**, and the condition is checked **afterwards**. That makes it perfect for **menus**, which must appear at least once:

```java
import java.util.Scanner;

public class MenuDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== M-PESA MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Send Money");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: System.out.println("Balance: KSh 10,000"); break;
                case 2: System.out.println("Send Money selected"); break;
                case 3: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 3);
        scanner.close();
    }
}
```

| | `while` | `do-while` |
|-|---------|------------|
| Condition checked | **before** the body | **after** the body |
| Minimum runs | 0 | **1** |
| Syntax | `while (c) { }` | `do { } while (c);` |
| Typical use | unknown number of repeats, validation | menus, "play again?" |

---

## 4. The `for` loop: when you know how many times

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Number: " + i);
}
```

**Order of execution:** ① initialise (once) → ② check the condition → ③ run the body → ④ update → back to ②.

### Variations
```java
for (int i = 10; i >= 1; i--)        // count down: 10 9 8 ... 1
for (int i = 2; i <= 20; i += 2)     // step by 2: 2 4 6 ... 20
for (int k = 2; k <= 64; k *= 2)     // multiply: 2 4 8 16 32 64
for (int i = 64; i > 0; i /= 2)      // halve: 64 32 16 8 4 2 1
for (int i = 0, j = 10; i < j; i++, j--)   // two variables
for (;;) { }                         // infinite (exercise InfiniteLoop: stop with Ctrl+C)
```

### Exercise `Countdown`
```java
System.out.println("Countdown to Launch: ");
for (int i = 5; i >= 0; i--) {
    System.out.print(i + " ");
}
System.out.println("Blast Off!");
```
```
Countdown to Launch: 
5 4 3 2 1 0 Blast Off!
```

### Variable scope in loops (exercise `ScopeTest`)
A variable declared **in** the `for` header (`int i`) exists only **inside** that loop.
```java
int i = 0;
for (int i = 64; i > 0; i /= 2) { }   // ❌ compile error: variable i is already defined
```
Fix: give the loop variable a different name, or reuse the existing `i` without re-declaring it: `for (i = 64; i > 0; i /= 2)`.

### Enhanced `for` (for-each): every element of an array or collection
```java
String[] students = {"Alice", "Bob", "Charlie"};
for (String student : students) {
    System.out.println("Student: " + student);
}
```

| | Traditional `for` | Enhanced `for` |
|-|-------------------|----------------|
| Index available | yes (`i`) | no |
| Can change elements | yes (`arr[i] = …`) | no (read-only copy) |
| Readability | lower | higher |
| Use when | you need the index or want to modify | you just visit each item |

---

## 5. Choosing the right loop

| Situation | Loop |
|-----------|------|
| Fixed number of repeats (12 months, 1 to 100) | `for` |
| Repeat until something happens (valid input, a sentinel) | `while` |
| Must run at least once (menu, "play again?") | `do-while` |
| Visit every element of an array or list | for-each |

### Loop design patterns
- **Counter-controlled**: you know the count: `for (int i = 1; i <= 100; i++)`
- **Sentinel-controlled**: a special value stops the loop. In `SumofNums`, entering `-1` stops it; in `BodaBodaFare`, distance `0` stops it.
- **Flag-controlled**: a `boolean` decides: `while (!found && i < arr.length)`

```java
// Sentinel: sum numbers until -1 (exercise SumofNums)
int sum = 0;
System.out.print("Enter a number (-1 to quit): ");
int number = console.nextInt();          // "priming read" before the loop
while (number != -1) {
    sum += number;
    System.out.print("Enter a number (-1 to quit): ");
    number = console.nextInt();          // read the next one at the END of the body
}
System.out.println("The sum is " + sum);
```

### Accumulators and counters
```java
int total = 0;      // accumulator: start at 0 and add to it
int count = 0;      // counter: start at 0 and add 1
for (int i = 1; i <= 10; i++) {
    total += i;
    count++;
}
// total = 55, count = 10
```

---

## 6. `break` and `continue` (JFo 6-3)

| Statement | Effect | Use for |
|-----------|--------|---------|
| `break` | leave the loop **immediately** | found what you were searching for; user cancels; error |
| `continue` | skip the **rest of this iteration** and go on to the next one | skip invalid data |

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) break;
    System.out.print(i + " ");          // 1 2 3 4
}

for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) continue;
    System.out.print(i + " ");          // 1 3 5 7 9
}
```

**Exercise `CountChar`: count the 'w's in "www.oracle.com"**
```java
String str = "www.oracle.com";
int count = 0;
for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) != 'w')
        continue;          // not a 'w', so skip to the next character
    count++;
}
System.out.println("Counting w : " + count);   // 3
```

**Exercise `Divisors`** prints every divisor of a number, using `continue` to skip the numbers that don't divide it evenly:
```java
for (int i = 1; i <= num; i++) {
    if (num % i != 0) continue;
    System.out.print(i + " ");
}
```

In a nested loop, `break` exits only the **innermost** loop.

---

## 7. Nested loops and patterns

The **inner loop runs completely for every single pass of the outer loop**. Total iterations = outer × inner.

```java
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 2; j++) {
        System.out.println("i=" + i + ", j=" + j);    // 3 × 2 = 6 lines
    }
}
```

**Rule of thumb for patterns:** the outer loop controls the **rows**; the inner loop(s) control **what goes on each row**. Use `print` inside, then `println()` after the inner loop to end the row.

### Right triangle
```java
int rows = 5;
for (int i = 1; i <= rows; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("*");
    }
    System.out.println();
}
```
```
*
**
***
****
*****
```

### Inverted triangle: the outer loop counts down
```java
for (int i = rows; i >= 1; i--) {
    for (int j = 1; j <= i; j++) System.out.print("*");
    System.out.println();
}
```

### Pyramid: spaces, then stars
```java
for (int i = 1; i <= rows; i++) {
    for (int j = 1; j <= rows - i; j++) System.out.print(" ");      // rows - i spaces
    for (int k = 1; k <= 2 * i - 1; k++) System.out.print("*");     // 2i - 1 stars
    System.out.println();
}
```
```
    *
   ***
  *****
 *******
*********
```
| Row i | Spaces (5 − i) | Stars (2i − 1) |
|-------|----------------|----------------|
| 1 | 4 | 1 |
| 3 | 2 | 5 |
| 5 | 0 | 9 |

### Number triangle
```java
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= i; j++) System.out.print(j + " ");
    System.out.println();
}
```
```
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 
```

### Multiplication table
```java
int n = 5;
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
        System.out.printf("%4d", i * j);    // %4d = right-aligned in 4 spaces
    }
    System.out.println();
}
```
```
   1   2   3   4   5
   2   4   6   8  10
   3   6   9  12  15
   4   8  12  16  20
   5  10  15  20  25
```

### Exercise `LoopShape`: rectangle and triangle as methods
```java
public class LoopShape {
    static void createRectangle(int width, int height) {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) System.out.print("#");
            System.out.println();
        }
    }
    static void createTriangle(int leg) {
        for (int r = 1; r <= leg; r++) {
            for (int c = 0; c < r; c++) System.out.print("#");
            System.out.println();
        }
    }
}
```

---

## 8. Loop efficiency (counting iterations)

| Structure | n = 10 | n = 100 | n = 1,000 | Complexity |
|-----------|--------|---------|-----------|------------|
| One loop to n | 10 | 100 | 1,000 | **O(n)** linear |
| Triangular (`j` from `i` to n) | 55 | 5,050 | 500,500 | O(n²), with n(n+1)/2 iterations |
| Two nested loops to n | 100 | 10,000 | 1,000,000 | **O(n²)** quadratic |
| Three nested loops | 1,000 | 1,000,000 | 10⁹ | O(n³) cubic |

**Why it matters:** checking 1,000 transactions against each other with a nested loop is 1,000,000 operations, which could make a system time out. A single pass is 1,000. Avoid nesting when one loop will do.

Triangular count for n = 5: 5 + 4 + 3 + 2 + 1 = **15** = 5 × 6 / 2.

---

## 9. Debugging infinite loops

| Cause | Example | Fix |
|-------|---------|-----|
| Missing update | `while (x <= 5) { print(x); }` | add `x++` |
| Wrong direction | `for (int i = 5; i >= 1; i++)` | use `i--` |
| Condition never becomes false | `while (x != 10)` with x starting at 11 and going up | use `x < 10` |
| Semicolon after the header | `while (x < 5);` ← the empty `;` is the body! | delete the `;` |
| Loop variable reset inside the body | `i = 0;` inside the loop | don't reassign it |
| Sentinel never read again | forgot `number = console.nextInt()` at the end of the body | read the next value inside the loop |

**Process:** read → **trace table** (write down the variable values each pass; if the value never changes, the loop never ends) → fix → retest. In the debugger, set a breakpoint inside the loop and Step Over (F10) while watching the variable. To stop a runaway program, press **Ctrl + C** in the terminal.

---

## 10. Worked example: the Boda Boda fare calculator (my assignment)

`my-work/BodaBodaFare.java` brings together Scanner, if/else-if/else and a **sentinel-controlled while loop**:
- **Sentinel:** distance `0` ends the day.
- **Validation:** a negative distance or invalid hour prints an error, then asks for the next ride.
- **Fare rules:** base KSh 50 for the first 2 km, plus KSh 20 per extra km; a night surcharge of 50% (22:00–05:59) **or** a rush-hour surcharge of 25% (7–9, 17–19); KSh 30 extra if it's raining.
- **Accumulator:** `dailyEarnings += totalFare` adds up the day's total.

```
Enter distance in km (0 to stop): 5
Enter hour of day (0-23): 18
Is it raining? (yes/no): yes

--- Ride Fare Breakdown ---
Base fare: KSh 50.00
Distance charge: KSh 60.00
Time surcharge: KSh 27.50
Rain charge: KSh 30.00
Total fare: KSh 167.50

Enter distance in km (0 to stop): 0

Total daily earnings: KSh 167.50
Fare calculator stopped.
```

---

## 11. Exercises

| Exercise | Task | Loop type |
|----------|------|-----------|
| `Countdown` | Run it; then count down from 10 in steps of 2 | for |
| `ScopeTest` | Fix the "already defined" error; predict each line's output | for, scope |
| `InfiniteLoop` | Run it, stop it with Ctrl+C, then explain `for(;;)` | infinite |
| `ComputeSum` | Sum 1 to n (n from the user) | for + accumulator |
| `DisplayMultiples` | Print the first 10 multiples of a number | for |
| `SumofNums` | Sentinel −1 (done for you; trace it) | while |
| `SquareRootWhile` | Keep asking until the number is non-negative, then print `Math.sqrt` | while validation |
| `ValidatePin` | Keep asking for a PIN until it's correct (or 3 attempts) | do-while |
| `Divisors` | Print all divisors (fix: `i <= num` so the number itself is included) | for + continue |
| `CountChar` | Count the 'w's (add the missing `for` header) | for + continue |
| `BreakContinue` | Skip evens with `continue`; stop at 7 with `break` | break/continue |
| `LoopShape` + `LoopShapeTest` | Rectangle and right triangle | nested |
| Week 5 critical-thinking problems | `class-notes/Week 5 - 10 Real-Life Critical Thinking Problems.pdf` | mixed |

---

## 12. Practice questions

1. Name the four parts of a loop.
2. How do `while` and `do-while` differ? Give a use for each.
3. When would you use `for` instead of `while`?
4. What is a for-each loop? What *can't* it do?
5. How many times does the inner statement run? `for (i=0;i<4;i++) for (j=0;j<3;j++) {...}`
6. Give three causes of infinite loops.
7. What do `break` and `continue` do?
8. How many iterations does a triangular loop do when n = 5? When n = 100?
9. Write a `for` loop that prints even numbers from 2 to 20.
10. Write nested loops for a 5-row right triangle.
11. What does `for (int i = 0; i < 5; i++); { System.out.println(i); }` do?
12. What's the output? `int x = 10; while (x > 0) { x -= 3; } System.out.println(x);`

<details>
<summary><b>Answers</b></summary>

1. Initialisation, condition, body, update.
2. `while` checks the condition first (it may run 0 times), e.g. input validation. `do-while` checks afterwards (it always runs at least once), e.g. menus.
3. When the number of iterations is known in advance (counting, ranges, arrays).
4. A loop that visits each element of an array or collection in turn. It gives you no index and can't change the elements in place.
5. 4 × 3 = 12.
6. A missing update, an update in the wrong direction, a stray `;` after the header, or a condition that can never become false (e.g. `!=` jumping past the target).
7. `break` exits the loop completely. `continue` skips the rest of the current iteration and moves on to the next one.
8. 5·6/2 = 15. 100·101/2 = 5,050.
9. `for (int i = 2; i <= 20; i += 2) System.out.print(i + " ");`
10. `for (int i = 1; i <= 5; i++) { for (int j = 1; j <= i; j++) System.out.print("*"); System.out.println(); }`
11. It's a compile error: the `;` makes the loop's body empty, so `i` doesn't exist inside the `{ }` block that follows. (If `i` were declared outside, the loop would do nothing five times, and the block would then run once.)
12. 10 → 7 → 4 → 1 → −2, so it prints `-2`.
</details>

---

## 13. Summary

| Loop | Checks | Min runs | Best for |
|------|--------|----------|----------|
| `while` | before | 0 | unknown count, validation |
| `do-while` | after | 1 | menus |
| `for` | before | 0 | known count |
| for-each | — | 0 | every element of an array or list |

- Every loop needs an initialisation, a condition, a body and an update that moves towards the end.
- `break` leaves the loop; `continue` skips to the next iteration.
- Nested loops: outer = rows, inner = columns. They cost n² iterations, so use them carefully.
- Debug infinite loops with a trace table: if the variable never moves towards the exit condition, the loop never ends.
