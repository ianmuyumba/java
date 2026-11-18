# Oracle Java Foundations · Exam preparation

[Course home](README.md) · [Audit and coverage](ORACLE_AUDIT.md) · [Progress](PROGRESS.md)

These are original revision questions, not copied Oracle exam questions. Use them to find gaps before opening a graded attempt. The course lists a Midterm (S1–S5), Final (S6–S9), and Cumulative Final (S1–S9). Availability, time limits, attempts and pass marks depend on the actual exam instructions; they have not been inferred from the course progress percentages.

## Choose the right revision scope

| Exam | Revise these repo units | Focus |
|---|---|---|
| Midterm S1–S5 | 01, 02, 03, 04, 05 | Execution, types, operators, methods, libraries and decisions |
| Final S6–S9 | 06, 08, 07, 10, 11 | Loops, classes, arrays, ArrayLists, exceptions and JavaFX |
| Cumulative S1–S9 | All of the above | Combine concepts and distinguish compile errors from runtime behaviour |

Units 09, 12 and 13 contain valuable Riara/textbook extensions. They are not extra Oracle Foundations sections; do not let advanced material crowd out the listed Oracle objectives.

## How we can work through preparation

1. Answer the diagnostic without running code or opening the key.
2. Send your answer **and a reason**. For code, include a short trace.
3. We identify the exact misconception and work through a similar example.
4. You solve a fresh variation before moving on.
5. Review the actual exam's own instructions before starting its graded attempt.

A useful first revision session is Section 5 because it had the largest resource gap. The portal's completion percentage measures course progress; it is not evidence of your mastery or an exam score.

## Diagnostic A · Midterm topics

Assume ordinary Java statements are inside a valid `main` method unless a complete class or method is shown. Use the traditional Java forms taught in the course.

1. Which tool compiles `Hello.java`, what file does it normally produce, and which command runs the compiled class?
2. A program compiles and prints the wrong total. Is this necessarily a runtime exception? Explain the error category.
3. Predict `double result = 9 / 2; System.out.println(result);` and give one change that preserves the fraction.
4. Predict `System.out.println("Total " + 2 + 3);` and `System.out.println(2 + 3 + " total");`.
5. Does `int count; System.out.println(count);` compile when `count` is a local variable? How is an instance field different?
6. For `String a = new String("Java"); String b = new String("Java");`, predict `a == b` and `a.equals(b)`.
7. Given `String s = "PROGRAM";`, what are `s.substring(1, 4)` and `s.indexOf("Z")`?
8. `new Random(7).nextInt(6) + 1` can produce which integers? What does using the same seed reproduce?
9. Can a class overload `int size(int n)` with `double size(int n)`? Explain.
10. Predict `int x = 0; boolean ok = x != 0 && 20 / x > 2; System.out.println(ok);`. Is division evaluated?
11. Under the literal Oracle fare rule in the [decision review](05-Conditionals/ORACLE_REVIEW.md), what fare applies at ages 11, 12 and 65? Which colour applies at 450 nm and 750 nm?
12. Predict this output and explain what changing `x` to 9 does:

```java
int x = 1;
switch (x) {
    case 1: System.out.print("A");
    case 2: System.out.print("B"); break;
    default: System.out.print("C");
}
```

## Diagnostic B · Final topics

13. Predict `int total = 0; for (int i = 1; i < 4; i++) total += i;`.
14. Which loop can execute its body once even when its condition is initially false? Where is its condition tested?
15. Predict `for (int i = 0; i < 5; i++) { if (i == 2) continue; if (i == 4) break; System.out.print(i); }`.
16. If `int[] a = {3, 4}; int[] b = a; b[0] = 9;`, what is `a[0]`? Give one way to create an independent primitive array copy.
17. What happens on `new int[3][0]`? What happens on `int[] a = new int[3]; System.out.println(a[3]);`? Distinguish the array creation from the access.
18. Start with an `ArrayList<Integer>` containing `[1, 2, 1]`. After `remove(1)` and then `remove(Integer.valueOf(1))`, what remains?
19. What is the difference between an iterator's `hasNext()` and `next()`? When may its `remove()` be called for an ArrayList iterator?
20. A class declares only `Account(int openingBalance)`. Can `new Account()` compile? Explain whether the compiler supplies a no-argument constructor.
21. Two objects share one static counter but have separate instance balances. Which values are shared? Can a static method directly use an instance balance without an object reference?
22. A method accepts an account reference, mutates its balance, then assigns a new account to its parameter. Which change can the caller observe through its original reference?
23. Compare the outcomes of integer `10 / 0`, parsing `"ten"` with `Integer.parseInt`, and dereferencing null. Does declaring `throws` handle any of them?
24. Which object is added to a JavaFX scene graph: `Image` or `ImageView`? When does a registered mouse handler run, and what can cause `getResource(...).toString()` to throw a NullPointerException?

## Answer key and explanations

<details>
<summary>Open after attempting the questions</summary>

| # | Answer and reason |
|---|---|
| 1 | `javac Hello.java` normally produces `Hello.class`; run `java Hello` from the appropriate classpath. |
| 2 | It may be a logic error. Compilation checks syntax/types, not whether your formula meets the requirements. |
| 3 | `4.0`. Integer division happens before assignment. Use `9 / 2.0` or cast an operand before dividing. |
| 4 | `Total 23`, then `5 total`. `+` is evaluated left to right; once a String participates, subsequent additions concatenate. |
| 5 | No: the local variable is not definitely assigned. An instance `int` field gets a default value of zero. |
| 6 | `false`, then `true`. The two constructors create different objects with equal content. |
| 7 | `ROG`, then `-1`. The substring end index is excluded; a missing match returns -1. |
| 8 | Integers 1–6 inclusive. The same seed with the same sequence of calls reproduces the pseudorandom sequence. |
| 9 | No. Return type alone does not distinguish signatures; change the parameter list. |
| 10 | `false`; division is skipped because the left side of `&&` is false. |
| 11 | Fares 3, 5, 3. At 450 the colour is Blue; 750 is outside the half-open spectrum. |
| 12 | `AB`: case 1 falls through to case 2. With 9, default prints `C`. |
| 13 | `total` becomes 6 after adding 1, 2 and 3. The loop stops before i = 4 executes the body. |
| 14 | `do-while`; it tests after the body. |
| 15 | `013`. `continue` skips printing 2; `break` exits before printing 4. |
| 16 | 9, because both variables reference the same array. `Arrays.copyOf(a, a.length)` copies the primitive elements to a different array. |
| 17 | `new int[3][0]` creates three empty rows legally. Accessing index 3 of a length-3 array throws ArrayIndexOutOfBoundsException; valid indexes are 0–2. |
| 18 | `[1]`. Index removal first removes 2, leaving `[1, 1]`; value removal removes the first 1. |
| 19 | `hasNext()` checks without advancing; `next()` returns and advances. `remove()` may remove the last returned element once per `next()` for this iterator. |
| 20 | No. Declaring a constructor prevents automatic generation of the default no-argument constructor. |
| 21 | The static counter is shared by instances of the class; balances belong to individual objects. A static method needs an object reference for instance state. |
| 22 | The mutation of the original object. Reassignment affects only the copied parameter reference; Java is always pass-by-value. |
| 23 | ArithmeticException, NumberFormatException, NullPointerException. A `throws` clause declares propagation; it does not catch a failure. |
| 24 | ImageView. The handler runs when the matching event occurs. A missing classpath resource returns null, and invoking `toString()` on null fails. |

</details>

## Use your results

Give yourself one point for a correct result **with a correct explanation**. Do not use the total as a predicted Oracle score. Revisit every topic where you guessed, and solve a changed example without the key. Group mistakes by types/operators, methods, decisions, loops, objects, collections, exceptions and GUI/resources.

The automated [review checker](tools/check_oracle_review.py) tests the new worked examples and selected diagnostic traces. The supplied starters remain unfinished learning tasks, and the JavaFX projects require GUI/SDK checks before they can be described as working applications.
