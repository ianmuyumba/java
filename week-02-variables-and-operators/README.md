# Week 2: Variables, data types and operators

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** choose suitable data types, predict expressions that involve precedence and type conversion, spot type-mismatch errors before compiling, and build an interactive program with `Scanner`.

Run any task from this folder with `java FileName.java`.

---

## Task 1: Exploring data types
Declare one variable of every primitive type plus `String`, each chosen to fit its purpose, and print them.

**Solution:** [DataTypesDemo.java](DataTypesDemo.java)

```text
=== INTEGER TYPES ===
Student Age (byte): 20
Year of Birth (short): 2006
Kenya Population (int): 54000000
World Population (long): 8000000000
=== DECIMAL TYPES ===
Interest Rate (float): 7.5%
Account Balance (double): KSh 15000.75
...
```

**Answers:**
1. World population (8 billion) is larger than `int`'s maximum (about 2.1 billion), so it needs `long`. Kenya's 54 million fits in `int`.
2. `double` has about 15 significant digits against `float`'s 7, and it is Java's default decimal type. (For real money, production code uses `BigDecimal`.)
3. `char` is one 16-bit character in single quotes (`'A'`). `String` is an object holding a sequence of characters in double quotes (`"A"`).
4. A `long` literal takes `L`: `8000000000L`.
5. A `float` literal takes `f`: `7.5f`.

## Task 2: Operators and expressions
Predict the results first, then run and compare.

**Solution:** [OperatorsDemo.java](OperatorsDemo.java)

| Expression | Prediction / result |
|---|---|
| `10 + 5 * 2` | **20** |
| `(10 + 5) * 2` | **30** |
| `20 % 3 + 4 * 2` | **10** (2 + 8) |
| `a > b` (17, 5) | **true** |
| `x && y` (true, false) | **false** |

Full output includes `a / b = 3`, `a % b = 2`, `counter++ → 5`, `++counter → 7`, and a final counter of 7.

**Answers:**
1. `a / b` gives the quotient. With two ints the decimal part is dropped: 17 / 5 = 3. `a % b` gives the remainder: 17 % 5 = 2.
2. `*` has higher precedence than `+`, so `5 * 2` is evaluated first.
3. `counter++` uses the value and then adds 1 (post-increment). `++counter` adds 1 and then uses the value (pre-increment).
4. `!` is logical NOT. It flips `true` ↔ `false`.
5. `true || false` is `true`.

## Task 3: Type conversion and analysis
Show widening and narrowing casts, compile-time mismatches, and String ↔ number conversion.

**Solution:** [TypeConversion.java](TypeConversion.java)

```text
double value (from float): 3.140000104904175   <- float can't store 3.14 exactly
int pi (truncated): 3
float value (cast): 123.45679
Parsed int: 123
Parsed double: 45.67
```

**Error snippets:**
| Snippet | Verdict |
|---|---|
| A `int x = 3.14;` | ❌ **Error.** Narrowing double → int needs an explicit `(int)` cast |
| B `double y = 100;` | ✅ **Fine.** int → double widens automatically (y = 100.0) |
| C `int z = (int) 3.99;` | ✅ **Compiles.** z = **3**, because casting truncates rather than rounding |
| D `String s = 'A';` | ❌ **Error.** `'A'` is a `char`. Use `"A"` or `String.valueOf('A')` |

**Answers:**
1. **Implicit (widening)** casts happen automatically from a smaller type to a larger one, such as `double d = 100;`.
2. **Explicit (narrowing)** casts need you to write the type, such as `int i = (int) 9.7;`.
3. The decimal part is **truncated** (cut off): `(int) 3.99` → 3, `(int) -3.99` → -3.
4. String to int: `Integer.parseInt("123")`.
5. int to String: `String.valueOf(42)`, `Integer.toString(42)` or `"" + 42`.

## Task 4: Interactive calculator with Scanner
Read a name and two numbers, then show +, −, ×, ÷, %, the average and the square. Guard against division by zero.

**Solution:** [InteractiveCalculator.java](InteractiveCalculator.java)

```text
Enter your name: John Otieno
Enter first number: 25
Enter second number: 4
           RESULTS FOR JOHN OTIENO
Addition: 25.0 + 4.0 = 29.0
Division: 25.0 / 4.0 = 6.25
Modulus: 25 % 4 = 1
Average of 25.0 and 4.0 = 14.5
Square of 25.0 = 625.0
```

**Experiments:**
1. **Second number 0:** the division and modulus lines both print "Cannot divide by zero!".
2. **Negative number:** works normally, and the sign follows the usual rules (`-7 % 3 = -1`).
3. **Decimal number:** works because `nextDouble()` accepts decimals, but modulus uses the truncated ints (7.9 → 7).

**Answers:**
1. `nextLine()` reads a full line, spaces included.
2. `nextDouble()` reads a decimal number.
3. Integer `% 0` (and `/ 0`) throws an `ArithmeticException`, and double `/ 0` silently gives `Infinity`. The check prevents both.
4. Typing a whole number like `25` works, because it is read as `25.0`. Typing text throws an `InputMismatchException`.
5. Closing the Scanner releases the input stream it holds (good habit; IDEs warn about leaks).

## Task 5: Push to GitHub
- [ ] Stage, commit `Week 2: Variables, data types, operators, and Scanner`, then push and verify
