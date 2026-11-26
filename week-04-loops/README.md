# Week 4: Loops

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** compare loop efficiency by counting iterations, choose between `for`, `while` and `do-while`, debug infinite loops, and use nested loops to draw patterns.

Run any task from this folder with `java FileName.java`.

---

## Task 1: while loop (guessing game)
Keep asking for guesses until the user finds a random number from 1 to 100, giving "too high" or "too low" hints.

**Solution:** [GuessingGame.java](GuessingGame.java)
```text
Attempt 1 - Enter your guess: 50
Too low! Try again.
Attempt 2 - Enter your guess: 75
Too high! Try again.
...
Congratulations! You guessed it!
The number was: 68
You took 4 attempt(s).
```
**Answers:**
1. The loop body runs **once** for a correct first guess.
2. If the user never guesses right, the loop never ends (the user has to stop the program).
3. `guess` must have a value before the condition is first checked. `0` can never be the secret (1–100), so the loop is guaranteed to start.
4. Without `attempts++` the game still ends, but it prints "Attempt 0" every time and "You took 0 attempt(s)".

## Task 2: do-while loop (menu system)
A student-management menu that repeats until the user chooses 4 (Exit).

**Solution:** [MenuSystem.java](MenuSystem.java)
```text
Enter your choice (1-4): 1
Enter student name: Alice Wanjiku
Student 'Alice Wanjiku' added successfully.
...
Enter your choice (1-4): 4
Thank you for using the Student Management System.
Goodbye!
```
**Answers:**
1. A menu must be shown **at least once** before there is a choice to test. `do-while` checks its condition *after* the body, so that is guaranteed.
2. If the user enters 4 straight away, the menu displays **once**.
3. An invalid number like 5 hits `default`, which prints "Invalid choice", and the loop shows the menu again.
4. With `while`, `choice` would need a dummy starting value so the first check passes. Starting it at 4 would mean the menu never shows at all.

## Task 3: for loop (counter-controlled)
Six examples: counting, summing, a countdown, a step of 2, a times table, and the enhanced for loop.

**Solution:** [ForLoopDemo.java](ForLoopDemo.java)
```text
Sum of numbers 1 to 100 = 5050
10 9 8 7 6 5 4 3 2 1 Blast off!
2 4 6 8 10 12 14 16 18 20
7 x 1 = 7 ... 7 x 10 = 70
Student: Alice / Bob / Charlie / Diana
```
**Answers:**
1. Example 1 runs **5** times.
2. `sum` ends at **5050** (= 100 × 101 / 2).
3. `i++` adds 1 and `i--` subtracts 1.
4. `i += 2` means `i = i + 2`.
5. Use the enhanced for loop to visit **every element** of an array or collection when you don't need the index and won't modify the structure.

## Task 4: nested loops (pattern generator)
Read a row count, then print a triangle, an inverted triangle, a pyramid, a number triangle and a multiplication table.

**Solution:** [PatternGenerator.java](PatternGenerator.java) (input `5`)
```text
*          *****          *        1
**         ****          ***       1 2
***        ***          *****      1 2 3
****       **          *******     1 2 3 4
*****      *          *********    1 2 3 4 5
```
**Experiment:** 3 or 7 rows scale every shape and the table to 3×3 or 7×7.

**Answers** (rows = 5):
1. The inner loop runs `i` times on row `i` (1, 2, 3, 4, 5), which is **15** times in total.
2. **15** stars are printed.
3. The first pyramid row has `rows − 1` = **4** spaces.
4. The last pyramid row has `2 × 5 − 1` = **9** stars.
5. To print numbers instead of stars, print `j` (or `i`): replace `System.out.print("*")` with `System.out.print(j + " ")`.

## Task 5: loop efficiency analysis
Count the iterations of four loop shapes and compare their growth.

**Solution:** [LoopEfficiency.java](LoopEfficiency.java). Run `java LoopEfficiency.java 20` to change n.

| n | Linear | Nested | Triangular | Condition (counted) |
|---|---|---|---|---|
| 5 | 5 | 25 | 15 | 5 (3) |
| 10 | 10 | 100 | 55 | 10 (5) |
| 20 | 20 | 400 | 210 | 20 (10) |
| 100 | 100 | 10,000 | 5,050 | 100 (50) |

**Answers:**
1. The nested loop does 10 inner iterations for each of 10 outer ones: 10 × 10 = **100**.
2. The triangular loop's inner loop starts at `i`, so it runs 10 + 9 + … + 1 = n(n+1)/2 = **55** times.
3. The **linear** loops (1 and 4) are the most efficient. Their work grows in step with n, while the nested ones grow with n².
4. With n = 100 the nested loop runs **10,000** times.
5. Doubling the input of an O(n²) algorithm quadruples its work. Something that is fast on 10 items can be unusable on a million.

## Task 6: debugging infinite loops
Find and fix three loops that never stop.

**Solution:** [FixedLoops.java](FixedLoops.java). The buggy code is kept as comments.

| Bug | Cause | Fix |
|---|---|---|
| 1 | `x` never updated | add `x++` |
| 2 | `i++` moves away from `i >= 1` | use `i--` |
| 3 | `y` never updated | add `y--` |

**Answers:**
1. An **infinite loop** is one whose condition never becomes false.
2. **Common causes:**
   - a missing update
   - an update in the wrong direction
   - a wrong condition (`!=` that jumps over its target, or `||` instead of `&&`)
   - a stray `;` after `while (…)`
3. **Signs:** the program never finishes, output repeats endlessly, or CPU usage stays high. Add a print of the loop variable to watch it.
4. **Fix** it so the variable is updated on every pass and moves toward the exit condition.
5. Tracing shows exactly where the loop variable stops changing or goes the wrong way.

## Task 7: Push to GitHub
- [ ] Commit `Week 4: Loops - while, do-while, for, nested loops, debugging`, then push and verify
