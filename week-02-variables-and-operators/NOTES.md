# Week 2 notes: variables, data types, operators, input

[Tasks](README.md) · Sources: Oracle Java Foundations §3-1 to §3-5 (variables, numeric data, textual data, conversion, keyboard input)

## 1. Variables
A variable is a **named box** that holds one value of one fixed type.
```java
int score;          // declare
score = 90;         // assign
int lives = 3;      // declare + initialise
final double VAT = 0.16;   // constant: can't be reassigned
var count = 10;     // Java 10+: the compiler infers int (local variables only)
```
**Naming rules:** a name starts with a letter, `_` or `$`; contains no spaces; isn't a keyword; and is case-sensitive.
**Conventions:** `camelCase` for variables and methods, `PascalCase` for classes, `UPPER_SNAKE` for constants.

## 2. The eight primitive types (plus String)
| Type | Size | Example | Use for |
|---|---|---|---|
| `byte` | 8-bit | `byte b = 100;` | tiny ints (−128..127) |
| `short` | 16-bit | `short s = 2006;` | rarely used |
| `int` | 32-bit | `int n = 54_000_000;` | **default whole number** (±2.1 billion) |
| `long` | 64-bit | `long big = 8_000_000_000L;` | huge counts and timestamps (needs `L`) |
| `float` | 32-bit | `float f = 7.5f;` | rarely used (needs `f`) |
| `double` | 64-bit | `double d = 15000.75;` | **default decimal** |
| `char` | 16-bit | `char c = 'K';` | one character, `' '` |
| `boolean` | — | `boolean ok = true;` | true / false |
| `String` | object | `String s = "Hi";` | text, `" "` (not a primitive) |

- `_` in a number literal is just for readability.
- Integer overflow wraps around silently: `Integer.MAX_VALUE + 1` gives `-2147483648`.
- Decimals are approximations: `0.1 + 0.2` gives `0.30000000000000004`.

## 3. Operators
| Group | Operators | Notes |
|---|---|---|
| Arithmetic | `+ - * / %` | int / int → int (`7 / 2 = 3`), `%` = remainder |
| Assignment | `= += -= *= /= %=` | `x += 5` means `x = x + 5` |
| Increment | `++ --` | `x++` uses then adds, `++x` adds then uses |
| Relational | `== != > < >= <=` | result is `boolean` |
| Logical | `&& \|\| !` | **short-circuit**: `false && …` skips the right side |

**Precedence (high → low):** `()` → `++ -- !` → `* / %` → `+ -` → relational → `==` → `&&` → `||` → `=`. Operators of equal precedence run left to right.
```java
int r = 2 + 3 * 4;      // 14
int s = (2 + 3) * 4;    // 20
double avg = (7 + 8) / 2;     // 7.0  <- int division happens first!
double avg2 = (7 + 8) / 2.0;  // 7.5  <- make one side a double
```

## 4. Text: char and String (Oracle §3-3)
```java
String full = "Alice" + " " + "Wanjiku";   // concatenation
String mix  = "Total: " + 2 + 3;           // "Total: 23" (left to right, string wins)
String sum  = "Total: " + (2 + 3);         // "Total: 5"
```
**Escape sequences:** `\n` newline, `\t` tab, `\"` quote, `\\` backslash.
**Compare Strings with `.equals()`, never `==`** (more in week 3).

## 5. Converting between types (Oracle §3-4)
```
widening (automatic):  byte → short → int → long → float → double
                                   char ↗
narrowing (needs a cast): the other direction
```
```java
double d = 42;              // widening: 42.0
int i = (int) 9.99;         // narrowing: 9 (truncated, not rounded)
long rounded = Math.round(9.99);  // 10, if you actually want rounding
int n = Integer.parseInt("123");       // String → int
double x = Double.parseDouble("4.5");  // String → double
String s = String.valueOf(77);         // number → String
```
**Promotion:** in `byte + byte`, both operands become `int`, so `byte c = a + b;` fails without a cast.

## 6. Keyboard input with Scanner (Oracle §3-5)
```java
import java.util.Scanner;

Scanner in = new Scanner(System.in);
System.out.print("Age: ");
int age = in.nextInt();
in.nextLine();                      // ← eat the leftover newline!
System.out.print("Full name: ");
String name = in.nextLine();
in.close();
```
| Method | Reads |
|---|---|
| `nextInt()` / `nextDouble()` | one number |
| `next()` | one word (stops at a space) |
| `nextLine()` | the rest of the line |

**Classic bug:** `nextInt()` leaves the Enter key (`\n`) in the buffer, so the next `nextLine()` returns `""`. Fix it with an extra `nextLine()`.
**Wrong input type** throws an `InputMismatchException`.

## Quick check
- [ ] Which type for money, age, a phone number, a yes/no flag? (`double`/`BigDecimal`, `int`, **`String`**, `boolean`)
- [ ] What does `5 / 2 * 2.0` give? (`4.0`: the int division happens first)
- [ ] What is `(int) -7.8`? (`-7`)
- [ ] Why does `nextLine()` after `nextInt()` return empty?
