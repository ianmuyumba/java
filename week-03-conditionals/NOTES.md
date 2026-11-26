# Week 3 notes: making decisions

[Tasks](README.md) · Sources: Oracle Java Foundations §5-1 (boolean expressions, if/else), §5-2 (conditional execution) and §5-3 (switch)

## 1. Boolean expressions
A condition must evaluate to `true` or `false`. Java will **not** treat `0`/`1` as booleans.

| Operator | Meaning | Example (`x = 7`) |
|---|---|---|
| `== !=` | equal / not equal | `x == 7` → true |
| `< <= > >=` | compare | `x > 10` → false |
| `&&` | AND (both) | `x > 0 && x < 10` → true |
| `\|\|` | OR (either) | `x < 0 \|\| x > 5` → true |
| `!` | NOT | `!(x == 7)` → false |

**Short-circuit:** `&&` stops at the first `false` and `||` at the first `true`, so you can guard:
```java
if (count != 0 && total / count > 50) { ... }   // no divide-by-zero
```
**Precedence:** `!` → relational → `==` → `&&` → `||`. If in doubt, add parentheses.

## 2. if / else-if / else
```java
if (marks >= 70)      grade = 'A';
else if (marks >= 60) grade = 'B';   // reached only when marks < 70
else if (marks >= 50) grade = 'C';
else                  grade = 'F';   // everything left over
```
- **Order matters.** Put the most specific or highest test first, because the first true branch wins and the rest are skipped.
- **Always use `{ }`.** Without them only the *next statement* belongs to the `if`.
- **Dangling else:** an `else` pairs with the *nearest* unmatched `if`.

## 3. Nested if: validate first, then decide
```java
if (marks >= 0 && marks <= 100) {      // guard: is the input valid?
    if (marks >= 50) System.out.println("Pass");
    else             System.out.println("Fail");
} else {
    System.out.println("Invalid marks");
}
```
Deep nesting is hard to read. Return early or combine conditions with `&&` instead.

## 4. switch
Use it to match **one value against exact constants** (`int`, `char`, `String`, `enum`).
```java
switch (choice) {
    case 1:  System.out.println("Balance"); break;
    case 2:  System.out.println("Send");    break;
    case 3:
    case 4:  System.out.println("Cash");    break;   // deliberate fall-through: 3 OR 4
    default: System.out.println("Invalid");
}
```
- If you forget a `break`, execution **falls through** into the next case.
- `default` runs when no case matches. Always include one.
- A classic `switch` cannot test ranges (`case > 70` is illegal); use if-else for those.

**Switch expression (Java 14+):** no `break` and no fall-through, and it returns a value.
```java
String day = switch (n) {
    case 1, 7 -> "Weekend";
    case 2, 3, 4, 5, 6 -> "Weekday";
    default -> "Invalid";
};
```

## 5. Ternary operator
`condition ? valueIfTrue : valueIfFalse` is an *expression* that produces a value.
```java
String status = (age >= 18) ? "Adult" : "Minor";
int max = (a > b) ? a : b;
```
Use it for a simple choice between two values, and not for actions or nested logic.

## 6. Comparing Strings (Oracle §5-1)
```java
String s1 = "yes";
String s2 = scanner.next();      // user types yes
s1 == s2                // may be FALSE: compares references (memory addresses)
s1.equals(s2)           // true: compares content
s1.equalsIgnoreCase("YES")  // true
```
**Rule:** compare objects with `.equals()`. Use `==` only for primitives.

## 7. Choosing a structure
| Situation | Use |
|---|---|
| One yes/no decision | `if` / `if-else` |
| Ranges or mixed conditions | `if-else-if` chain |
| One variable against many exact values (menus) | `switch` |
| Pick one of two values | ternary `?:` |

## 8. Debugging conditions
1. **Trace by hand:** substitute real values into the condition.
2. **Test boundaries:** for 18–65, test 17, 18, 65 and 66, plus a typical value.
3. **Common bugs:**
   - `||` instead of `&&` in range checks
   - `=` instead of `==`
   - wrong branch order (`>= 50` before `>= 70`)
   - a stray `;` after `if (x > 0);`, which makes an empty `if`

## Quick check
- [ ] What does `if (x > 0); { print(); }` do? (it always prints: the `;` ends the `if`)
- [ ] Why does `case 1:` without `break` also run case 2?
- [ ] Rewrite `if (n % 2 == 0) s = "Even"; else s = "Odd";` as a ternary.
- [ ] Why does `"hi" == input` fail even when the user typed "hi"?
