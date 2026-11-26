# Week 3: Conditionals

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** design decisions with nested if-else or switch, trace every path through a boolean expression, judge readability vs efficiency, and debug a faulty condition with test inputs.

Run any task from this folder with `java FileName.java`.

---

## Task 1: Simple if-else-if
Classify a number as positive, negative or zero. Try 10, -5 and 0.

**Solution:** [PositiveNegativeZero.java](PositiveNegativeZero.java)
```text
10 is positive.
-5 is negative.
0 is zero.
```

## Task 2: Nested if-else
Validate marks (0–100), then grade them: A ≥ 70, B ≥ 60, C ≥ 50, D ≥ 40, otherwise F.

**Solution:** [StudentGrade.java](StudentGrade.java)
```text
75 -> Grade: A
-10 -> Invalid marks! Please enter a value between 0 and 100.
105 -> Invalid marks! Please enter a value between 0 and 100.
45 -> Grade: D
100 -> Grade: A
```
> ⚠️ The handout says 75 gives "Grade: B", but its own code gives **A** (75 ≥ 70). The code is right; the expected output is a typo.

## Task 3: Switch statement (M-Pesa agent menu)
Read a choice from 1 to 4 and respond with a `switch`. A `default` case handles anything else.

**Solution:** [MpesaMenu.java](MpesaMenu.java)
```text
Enter your choice (1-4): 1
Your balance is KSh 10,000.00
Enter your choice (1-4): 5
Invalid choice. Please enter a number between 1 and 4.
```
**Experiment (removing a `break`):** execution *falls through* into the next case. Delete the `break` after case 1, choose 1, and both "Your balance…" and "Send Money selected." print. A `switch` jumps to the matching label and keeps running until it reaches a `break` or the end.

## Task 4: Ternary operator
Rewrite an if-else as `condition ? a : b`.

**Solution:** [TernaryDemo.java](TernaryDemo.java)
```text
Using if-else: Eligible to vote
Using ternary: Eligible to vote
7 is Odd
```
**Answers:**
1. **Advantages:** one line; it is an *expression*, so it can go straight into an assignment, `return` or `println`; and the variable can be assigned once (even made `final`).
2. **Avoid it** when the branches have side effects or several statements, when it would be nested (`a ? b : c ? d : e`), or whenever it is harder to read than the if-else.

## Task 5: Analysing boolean expressions
Predict first, then check in code. Precedence is `!` → `&&` → `||`.

**Solution:** [BooleanAnalysis.java](BooleanAnalysis.java)

| Expression | Steps | Result |
|---|---|---|
| `(5 > 3) && (4 < 2) \|\| (10 == 10)` | (true && false) \|\| true → false \|\| true | **true** |
| `!(5 > 3) \|\| (4 < 2) && (10 == 10)` | false \|\| (false && true) → false \|\| false | **false** |

## Task 6: Readability and efficiency (if-else-if vs switch)
Print a day name from a number, written both ways.

**Solutions:** [DayIfElse.java](DayIfElse.java) · [DaySwitch.java](DaySwitch.java). Both print `Wednesday`. `DaySwitch` also shows the modern switch expression.

**Answers:**
1. **The switch is more readable.** The value is written once, and every case lines up as a lookup table.
2. **The switch is usually faster.** For dense int cases the compiler emits a jump table (`tableswitch`), so it jumps straight to the right case. An if-else chain tests each condition in turn. For 7 cases the difference is negligible.
3. **For 20 values, use a switch** (or, better, an array or `Map` lookup). A 20-branch if-else chain is long and easy to get wrong.
4. **For ranges** like `marks >= 70`, use **if-else-if**, because a classic `switch` only matches exact constant values.

## Task 7: Debugging a faulty conditional
The intended rule is working age = 18 to 65 inclusive, but the handout's code uses `age >= 18 || age <= 65`.

**Solution:** [FixedConditional.java](FixedConditional.java). It contains the bug analysis, the fix, and a trace table.
```text
age | faulty | fixed
 10 | true   | false   <- bug: 10 <= 65 makes || true
 18 | true   | true
 65 | true   | true
 66 | true   | false
 70 | true   | false   <- bug: 70 >= 18 makes || true
```
**The bug:** `||` is true for every integer. **The fix:** `&&` (`age >= 18 && age <= 65`). Always test values just below, at, and just above each boundary.

## Task 8: Push to GitHub
- [ ] Commit `Week 3: Conditionals - if-else, switch, ternary, debugging`, then push and verify
