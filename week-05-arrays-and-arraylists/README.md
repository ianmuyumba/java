# Week 5: Arrays and ArrayLists

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** work out the time complexity of array algorithms, weigh arrays against ArrayLists, debug out-of-bounds errors, and build an app that uses both.

Run any task from this folder with `java FileName.java`.

---

## Task 1: Introduction to arrays
Declare, fill, read and loop over arrays, and see their default values.

**Solution:** [ArrayBasics.java](ArrayBasics.java)
```text
First number: 10
Last number: 50
Length of numbers array: 5
numbers[0] = 10 ... numbers[4] = 50
Default int: 0
Default boolean: false
Default String: null
```
**Answers:**
1. The first element is at index **0**.
2. The last index of a length-5 array is **4** (`length − 1`).
3. Use `array.length`, which is a field, so there are no brackets.
4. An `int` element defaults to `0`. (`double` → 0.0, `boolean` → false, objects → `null`.)
5. The traditional `for` gives you the index, so you can modify slots, go backwards or skip. The enhanced `for` gives each value in turn, is read-only, and has no index.

## Task 2: Array algorithms (search, max, min, average)
Find the max, min, average, a linear search result and a threshold count over 10 marks, counting the iterations.

**Solution:** [ArrayAlgorithms.java](ArrayAlgorithms.java)
```text
Maximum mark: 91   Minimum mark: 48
Sum: 700   Average: 70.00
Found 83 at index 5   Iterations: 6
Marks above or equal to 70: 5 of 10
```
**Answers:**
1. The search took 6 iterations because 83 sits at index 5, and `break` stops the loop as soon as it is found.
2. All of these are O(n): each visits every element at most once, so the work grows linearly with the array size.
3. If the target were at the last index, the search would take **10** iterations (worst case).
4. If the target is missing, the search still takes **10** iterations: every element is checked, and the result is −1 ("not found").

## Task 3: Multidimensional arrays
A 3×3 matrix with element access, row and column sums, and a student-marks table.

**Solution:** [MatrixDemo.java](MatrixDemo.java)
```text
1 2 3        Sum of all elements: 45
4 5 6        Row sums: 6, 15, 24
7 8 9        Column sums: 12, 15, 18

Student   Math     English  Science  Average
Alice     85       90       78       84.33
Bob       72       88       91       83.67
Charlie   65       75       80       73.33
```
**Answers:**
1. Row 2, column 1 is `matrix[2][1]`.
2. `matrix.length` is the number of **rows**.
3. The number of columns in row 0 is `matrix[0].length`.
4. **Uses:** grade books (students × subjects), game boards (chess, tic-tac-toe), seating plans, image pixels and spreadsheets.

## Task 4: Introduction to ArrayLists
Practise `add`, `add(index)`, `get`, `size`, `contains`, `indexOf`, `remove`, `set` and `clear`, plus an `ArrayList<Integer>`.

**Solution:** [ArrayListBasics.java](ArrayListBasics.java)
```text
After adding Diana at index 1: [Alice, Diana, Bob, Charlie]
Index of Charlie: 3     Index of Eve: -1
After removing Bob: [Alice, Diana, Charlie]
After setting index 0 to Eve: [Eve, Charlie]
Scores: [85, 92, 78]  Total: 255
```
**Answers:**
1. `add(value)` appends; `add(index, value)` inserts.
2. `remove(int index)` removes by index.
3. `size()` returns the number of elements.
4. Generics only accept **object** types, so you use the wrapper `Integer`. Java converts automatically (*autoboxing* and *unboxing*).
5. `add` **inserts** a new element, so the size grows by 1. `set` **replaces** an existing element, so the size stays the same.

## Task 5: ArrayList vs array (trade-off analysis)
Do the same student list both ways and compare.

**Solution:** [ArrayVsArrayList.java](ArrayVsArrayList.java)

**Answers:**
1. Arrays have a **fixed size**. Adding or removing means creating a new array and copying.
2. An ArrayList **resizes automatically** and comes with methods (`add`, `remove`, `contains`, …).
3. Arrays are a little faster and leaner: no wrapper objects, no spare capacity, and no method call per access. Both give O(1) access by index.
4. Prefer an array when the size is known and fixed, or for large amounts of primitive data (days of the week, a game board, sensor readings).
5. Prefer an ArrayList when the count changes at runtime (a shopping cart, a class roster, search results).

## Task 6: Debugging array index errors
Fix three `ArrayIndexOutOfBoundsException`s.

**Solution:** [FixedArrays.java](FixedArrays.java). The buggy code is kept as comments.

| Bug | Cause | Fix |
|---|---|---|
| 1 | `i <= numbers.length` reaches index 5 | `i < numbers.length` |
| 2 | hard-coded `numbers[5]` | `numbers[numbers.length - 1]` |
| 3 | `numbers[-1]` | `numbers[0]` |

**Answers:**
1. The valid range is **0 to n − 1**.
2. An invalid index throws `ArrayIndexOutOfBoundsException` (for an ArrayList, `IndexOutOfBoundsException`).
3. Get the last element with `arr[arr.length - 1]`, after checking the array isn't empty.
4. The loop condition is `for (int i = 0; i < arr.length; i++)`.
5. **Prevention:**
   - use `.length` instead of hard-coded numbers
   - prefer the enhanced `for`
   - check `index >= 0 && index < arr.length` before accessing user-supplied indexes

## Task 7: Integrated project (student roster)
A menu-driven roster that can add, view, average, search and remove students. It uses an array for subjects and ArrayLists for students.

**Solution:** [StudentRoster.java](StudentRoster.java)
```text
Student     Math        English     Science     Average
Alice       85          90          78          84.33
Bob         72          88          91          83.67
Charlie     65          75          80          73.33
Class Average: 80.33        (after adding Diana 90/80/70)
Student 'Zed' not found.
```
**Answers:**
1. Subjects are an array because there are always exactly three and they never change, so a fixed size fits.
2. Names are an ArrayList because students are added and removed while the program runs.
3. **Adding a student:** read the name, fill a new `int[3]` from input, then `add` the name and the marks to their lists at the **same index**.
4. **Searching for a missing name:** `indexOf` returns −1 and the program prints "not found".
5. **Multiple classes:** keep an `ArrayList<String> classNames` with matching lists of rosters, or better, create a `Student` class and use `ArrayList<ArrayList<Student>>` or a `Map<String, ArrayList<Student>>` (weeks 6 and 10).

## Task 8: Push to GitHub
- [ ] Commit `Week 5: Arrays and ArrayLists - basics, algorithms, 2D arrays, comparison`, then push and verify
