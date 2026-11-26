# Week 10: Collections framework and file I/O

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** compare the costs of operations on ArrayList, HashSet and HashMap; choose the right collection for a job; read a file, process it and write results; and debug I/O failures and resource leaks.

**Run from inside this folder**, because the programs read and write files relative to the current directory:
```bash
java CollectionsDemo.java
java FileWriteDemo.java      # creates transactions.txt
java FileReadDemo.java       # reads it back
java DataProcessor.java      # students.csv -> report.txt
```
The files in this folder are the evidence the handout asks you to commit: [students.csv](students.csv) (input) and [transactions.txt](transactions.txt) and [report.txt](report.txt) (generated).

---

## Task 1: The big three collections
List, Set and Map side by side: duplicates, uniqueness and key → value lookup.

**Solution:** [CollectionsDemo.java](CollectionsDemo.java)
```text
List contents: [Alice, Bob, Alice]           <- keeps duplicates and order
Set contents: [Bob, Alice, Charlie]          <- duplicate rejected, order not guaranteed
Map contents: {101=David, 102=Bob, 103=Charlie}   <- put(101, "David") replaced Alice
Student with ID 102: Bob
```
**Answers:**
1. **A customer's past orders, in purchase order:** a **List** (`ArrayList`), which keeps insertion order and allows repeat purchases.
2. **The unique IDs of students who attended:** a **Set** (`HashSet`). Duplicates are ignored automatically, and `contains` is O(1).
3. **A dictionary from word to definition:** a **Map** (`HashMap<String, String>`), with O(1) lookup by key.

**Complexity** (typical):

| Operation | ArrayList | HashSet | HashMap |
|---|---|---|---|
| add / put | O(1)* | O(1) | O(1) |
| get by index | O(1) | — | — |
| contains / get by key | **O(n)** | **O(1)** | **O(1)** |
| remove | O(n) | O(1) | O(1) |

\*amortised: occasionally the backing array is resized.

## Task 2: Writing data to a file
Write four transaction lines with `PrintWriter`, using try-with-resources.

**Solution:** [FileWriteDemo.java](FileWriteDemo.java) → creates [transactions.txt](transactions.txt)
```text
Writing to file: transactions.txt
Data written successfully!
```
**Resource analysis:** both writers are declared in the `try ( … )` header, so Java closes them automatically, in reverse order, even if an exception occurs. Closing **flushes** the buffer. Forget it, and the file can end up empty.

## Task 3: Reading data from a file
Read the file line by line with `Scanner`, and handle a missing file.

**Solution:** [FileReadDemo.java](FileReadDemo.java)
```text
=== READING FILE: transactions.txt ===
1: TRX001, DEPOSIT, 5000, SUCCESS
...
4: TRX004, TRANSFER, 1000, FAILED
```
**Debug test** (the rename experiment): `java FileReadDemo.java missing.txt`
```text
Error: The file 'missing.txt' was not found.
```
The program reports the problem instead of crashing. The solution also uses try-with-resources: the handout's manual `fileScanner.close()` would be skipped if an exception happened mid-read, which is a resource leak.

## Task 4: Integrated project (data-processing pipeline)
Turn `students.csv` into PASSED/FAILED results in a `Map` and write `report.txt`.

**Solution:** [DataProcessor.java](DataProcessor.java) with input [students.csv](students.csv) and output [report.txt](report.txt)
```text
=== EXAMINATION REPORT ===
Total Students Processed: 5
Class Average: 67.60
--------------------------
Student: Alice | Result: PASSED
Student: Bob | Result: FAILED
Student: Charlie | Result: PASSED
Student: Diana | Result: PASSED
Student: Eve | Result: FAILED
```
**Improvements over the handout:**
- `LinkedHashMap` keeps the report in file order. `HashMap` order is unpredictable.
- Each value is `trim()`med, so stray spaces in the CSV don't break `parseInt`.
- A bad row is **skipped and counted** instead of aborting the whole run.
- The average is guarded against division by zero and formatted to 2 decimal places.
- Both files use try-with-resources.

## Task 5: Push to GitHub
- [ ] Commit `Week 10: Collections Framework & File I/O`, including the `.java`, `.csv` and `.txt` files, then push and verify
