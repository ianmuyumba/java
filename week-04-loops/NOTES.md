# Week 4 notes: loops

[Tasks](README.md) · Sources: Oracle Java Foundations §6-1 (for loops), §6-2 (while and do-while) and §6-3 (break and continue)

## 1. Every loop has four parts
```
initialise → test condition → body → update → test again …
   int i = 0      i < 5        print    i++
```
If the update never moves the variable toward making the condition false, the loop is **infinite**.

## 2. The three loops
```java
// for: when you KNOW how many times
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}

// while: repeat WHILE a condition holds (may run 0 times)
int balance = 100;
while (balance > 0) {
    balance -= 30;
}

// do-while: body runs FIRST, then the test (runs at least once)
int choice;
do {
    choice = askMenu();
} while (choice != 4);
```
| Loop | Checks condition | Minimum runs | Typical use |
|---|---|---|---|
| `for` | before each pass | 0 | counting, indexes, fixed ranges |
| `while` | before each pass | 0 | unknown count: input validation, games |
| `do-while` | **after** each pass | **1** | menus, "ask again?" prompts |

## 3. Enhanced for (for-each)
```java
String[] names = {"Ann", "Ben"};
for (String n : names) {
    System.out.println(n);
}
```
It is read-only and has no index. You can't skip elements or modify the array's slots through it.

## 4. Common loop patterns
```java
int sum = 0;                                  // accumulator
for (int i = 1; i <= n; i++) sum += i;

int count = 0;                                // counter
for (int i = 1; i <= n; i++) if (i % 3 == 0) count++;

int pin;                                      // input validation
do {
    pin = in.nextInt();
} while (pin < 1000 || pin > 9999);

int sentinel;                                 // sentinel: stop on a special value
while ((sentinel = in.nextInt()) != -1) { ... }
```

## 5. break and continue (Oracle §6-3)
```java
for (int i = 1; i <= 10; i++) {
    if (i == 3) continue;   // skip the rest of THIS pass
    if (i == 6) break;      // leave the loop entirely
    System.out.print(i + " ");   // 1 2 4 5
}
```
Use them sparingly: a clear loop condition is usually better than several `break`s.

## 6. Nested loops
The outer loop chooses the **row**, and the inner loop prints that row's **columns**.
```java
for (int row = 1; row <= 3; row++) {
    for (int col = 1; col <= row; col++) {
        System.out.print("*");
    }
    System.out.println();          // newline after each row
}
```
**Pattern design:** write down what row `i` contains (for example "`rows − i` spaces then `2i − 1` stars") and make each count an inner loop.

## 7. Loop efficiency (Big-O)
Count how the number of iterations grows with the input size `n`:

| Shape | Iterations | Big-O |
|---|---|---|
| one loop to n | n | O(n), linear |
| loop inside loop, both to n | n × n | O(n²), quadratic |
| inner loop starts at `i` | n(n+1)/2 | still O(n²), about half the work |
| halving each time (`i *= 2`) | log₂ n | O(log n) |

Doubling `n` doubles O(n) work but **quadruples** O(n²) work.

## 8. Variable scope
A variable declared inside a loop, including `int i` in a `for`, exists **only inside that loop**.
```java
for (int i = 0; i < 3; i++) { }
System.out.println(i);   // ❌ cannot find symbol
```

## 9. Debugging loops
| Symptom | Likely cause |
|---|---|
| Never stops | no update, update in the wrong direction, `;` after `while (...)` |
| Runs one time too many or too few (off-by-one) | `<=` vs `<`, starting at 0 vs 1 |
| Never runs | condition false at the start |

Print the loop variable each pass, or step through with the debugger.

## Quick check
- [ ] Which loop guarantees one run?
- [ ] How many times does `for (int i = 0; i < 10; i += 3)` run? (4: 0, 3, 6, 9)
- [ ] What's wrong with `while (x < 10); { x++; }`?
- [ ] How many stars does a 10-row right triangle print? (55)
