# Unit 07 · Arrays & ArrayLists

> **Class:** RBCS 7121 Week 5 (Arrays and ArrayLists). Note: the file ODEL called "Comprehensive Notes for week 6" is actually these Week 5 notes; it has been renamed here.
> **Oracle JFo:** 8-1 One-dimensional Arrays, 8-2 ArrayLists, 8-5 Practice
> **Files in this folder**
> - `class-notes/`: Week 5 comprehensive notes, Practical Session 5, achievement summary
> - `oracle-jfo/`: lessons 8-1, 8-2, 8-5
> - `exercises/`: ArrayEx1, ArrayEx2, ArrayListEx1, ArrayListEx2

---

## Learning outcomes

1. **Analyse** array algorithms for time complexity (linear O(n) vs quadratic O(n²)).
2. **Evaluate** the trade-offs between arrays and ArrayLists (memory, speed, flexibility).
3. **Debug** `ArrayIndexOutOfBoundsException` by tracing loop conditions.
4. **Design** an application that uses both arrays and ArrayLists (e.g. a student roster).

---

## 1. What is an array?

An **array** is a container that holds a **fixed number** of values of **one type**. Picture a row of numbered lockers: each locker holds one item, and you reach it by its number (the **index**).

| Property | Meaning |
|----------|---------|
| **Fixed size** | Create it with 5 slots and it always has 5. It can't grow or shrink |
| **One type** | An `int[]` holds only ints; a `String[]` holds only Strings |
| **Zero-indexed** | The first element is `[0]` and the last is `[length - 1]` |
| **Contiguous** | Elements sit side by side in memory, so `arr[i]` is very fast: O(1) |
| **An object** | An array lives on the heap; the variable holds a **reference** to it |

```
index:   [0]  [1]  [2]  [3]  [4]
scores:   85   92   78   95   88        scores.length == 5
```

---

## 2. Creating arrays

```java
// 1. Declare a size, then fill it in
int[] numbers = new int[5];      // [0, 0, 0, 0, 0]
numbers[0] = 10;
numbers[4] = 50;

// 2. Declare and initialise in one line (the size is worked out for you)
int[] scores = {85, 92, 78, 95, 88};
String[] names = {"Alice", "Bob", "Charlie"};

// 3. Declare now, create later
double[] prices;
prices = new double[]{120.0, 45.5, 300.0};
```

**Default values** (when you use `new` without assigning anything):

| Type | Default |
|------|---------|
| `int`, `long`, `short`, `byte` | `0` |
| `double`, `float` | `0.0` |
| `char` | `'\u0000'` (the null character) |
| `boolean` | `false` |
| `String` and other objects | `null` |

**Length:** `arr.length` is a **field**, so it has no brackets. (Strings use `.length()`; ArrayLists use `.size()`.)

---

## 3. Looping through an array

```java
int[] numbers = {10, 20, 30, 40, 50};

// Traditional for: you get the index, and you can change elements
for (int i = 0; i < numbers.length; i++) {
    System.out.println("Element at index " + i + ": " + numbers[i]);
}

// Enhanced for: cleaner, read-only
for (int n : numbers) {
    System.out.println(n);
}

// Print the whole array quickly
System.out.println(java.util.Arrays.toString(numbers));   // [10, 20, 30, 40, 50]
```

---

## 4. Arrays are references (exercise `ArrayEx1`)

```java
long[] primes = new long[20];
primes[0] = 2;
long[] primes2 = primes;        // copies the REFERENCE, not the array
primes2[0] = 5;
System.out.println(primes[0]);  // 5: both names point at the SAME array
```
```
primes  ──┐
          ├──►  [5, 3, 0, 0, ...]     (one array on the heap)
primes2 ──┘
```
For a genuinely separate copy, use `int[] copy = Arrays.copyOf(original, original.length);` or `original.clone()`.

The commented-out lines in `ArrayEx1` are type errors: `int[] x = new long[20];` won't compile (the types must match), and neither will `int even = new int[5];` (an array isn't an int).

**Passing an array to a method** passes the reference, so the method **can change** the caller's array:
```java
static void doubleAll(int[] arr) {
    for (int i = 0; i < arr.length; i++) arr[i] *= 2;
}
```

---

## 5. Common array algorithms

```java
int[] scores = {85, 92, 78, 95, 88};

// Sum and average
int sum = 0;
for (int s : scores) sum += s;
double average = (double) sum / scores.length;          // 87.6

// Maximum (and minimum): start with the FIRST element, not 0
int max = scores[0];
for (int i = 1; i < scores.length; i++) {
    if (scores[i] > max) max = scores[i];
}                                                        // 95

// Linear search: return the index, or -1 if it isn't there
int target = 78, foundIndex = -1;
for (int i = 0; i < scores.length; i++) {
    if (scores[i] == target) { foundIndex = i; break; }
}                                                        // 2

// Count matches
int passes = 0;
for (int s : scores) if (s >= 80) passes++;             // 4

// Reverse in place
for (int i = 0, j = scores.length - 1; i < j; i++, j--) {
    int temp = scores[i]; scores[i] = scores[j]; scores[j] = temp;
}
```

### Sorting
```java
import java.util.Arrays;
Arrays.sort(scores);                        // ascending: [78, 85, 88, 92, 95]
```
**Bubble sort** (to understand what's going on; it's O(n²)):
```java
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {          // swap neighbours that are out of order
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```

### Time complexity

| Operation | Complexity | Why |
|-----------|-----------|-----|
| `arr[i]` | **O(1)** constant | jumps straight to the slot |
| sum, max, linear search | **O(n)** linear | visits each element once |
| compare every pair, bubble sort | **O(n²)** quadratic | nested loops |
| `Arrays.sort` | O(n log n) | a clever algorithm |

For 10,000 M-Pesa transactions: O(n) is 10,000 steps (milliseconds); O(n²) is 100,000,000 steps (seconds, possibly a timeout).

---

## 6. 2D arrays: tables and grids

A 2D array is an **array of arrays**: rows × columns.

```java
int[][] matrix = {
    {1, 2, 3},     // row 0
    {4, 5, 6},     // row 1
    {7, 8, 9}      // row 2
};
System.out.println(matrix[1][2]);   // 6  →  [row][column]

int[][] grid = new int[3][4];       // 3 rows, 4 columns, all 0

for (int row = 0; row < matrix.length; row++) {               // number of rows
    for (int col = 0; col < matrix[row].length; col++) {      // columns in this row
        System.out.print(matrix[row][col] + " ");
    }
    System.out.println();
}
```
```
1 2 3 
4 5 6 
7 8 9 
```
Example uses: marks[student][subject], seats[row][seat], a game board.

---

## 7. `ArrayList`: a resizable list

`ArrayList` (in `java.util`) **grows and shrinks automatically**.

```java
import java.util.ArrayList;

ArrayList<String> names = new ArrayList<>();   // <String> = the element type (a "generic")
names.add("Alice");                 // [Alice]
names.add("Bob");                   // [Alice, Bob]
names.add(0, "Zara");               // insert at index 0: [Zara, Alice, Bob]
System.out.println(names.get(1));   // Alice
names.set(1, "Alicia");             // replace: [Zara, Alicia, Bob]
names.remove("Bob");                // remove by value: [Zara, Alicia]
names.remove(0);                    // remove by index: [Alicia]
System.out.println(names.size());   // 1
System.out.println(names.contains("Alicia"));  // true
System.out.println(names.indexOf("Alicia"));   // 0
System.out.println(names);          // [Alicia]  (prints nicely, no loop needed)
names.clear();                      // []
System.out.println(names.isEmpty()); // true
```

| Method | Does |
|--------|------|
| `add(e)` / `add(i, e)` | append / insert (later elements shift right) |
| `get(i)` | read the element at index i |
| `set(i, e)` | replace the element at index i |
| `remove(i)` / `remove(obj)` | delete by index / by value (later elements shift left) |
| `size()` | number of elements |
| `contains(obj)`, `indexOf(obj)` | search |
| `clear()`, `isEmpty()` | empty it / check whether it's empty |

Loop over it with `for (String n : names)` or `for (int i = 0; i < names.size(); i++) names.get(i)`. Sort it with `Collections.sort(names);`.

### Wrapper classes and autoboxing
An ArrayList can hold **objects only**, not primitives. Use the **wrapper class** instead:

| Primitive | Wrapper |
|-----------|---------|
| `int` | `Integer` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

```java
// ArrayList<int> nums = new ArrayList<>();     ❌ won't compile
ArrayList<Integer> nums = new ArrayList<>();    // ✅
nums.add(42);              // autoboxing: int → Integer, automatically
int x = nums.get(0);       // unboxing:   Integer → int
```
⚠️ For an `ArrayList<Integer>`, `nums.remove(1)` removes **index 1**. To remove the *value* 1, write `nums.remove(Integer.valueOf(1))`.

---

## 8. Array vs ArrayList

| Feature | Array | ArrayList |
|---------|-------|-----------|
| Size | fixed when created | grows and shrinks |
| Types | primitives **and** objects | objects only (wrappers) |
| Length | `.length` | `.size()` |
| Access | `arr[i]` | `list.get(i)` |
| Speed and memory | faster, leaner | a little slower, more memory |
| Built-in helpers | few (use `Arrays.*`) | `contains`, `remove`, `indexOf`… |
| Dimensions | easy 2D (`int[][]`) | nested lists are awkward |

**Use an array when** the size is known and fixed, you're storing primitives in bulk, or you need a grid.
**Use an ArrayList when** the number of items is unknown or changes (user input, enrolments), or you need to add and remove items often.

---

## 9. Debugging `ArrayIndexOutOfBoundsException`

**Golden rule:** for length n, the valid indexes are **0 … n−1**. Index `n`, or anything negative, crashes.

```java
int[] arr = {10, 20, 30, 40, 50};

for (int i = 0; i <= arr.length; i++)  // ❌ i reaches 5 → crash
for (int i = 0; i < arr.length; i++)   // ✅

System.out.println(arr[5]);              // ❌ hard-coded index
System.out.println(arr[arr.length - 1]); // ✅ always the last element
```

**Exercise `ArrayEx2`:** `browsers` has length 3 (indexes 0–2), but the code writes `browsers[3] = "firefox"`, which throws:
```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
```
Fix: make the array `new String[4]`, or use an ArrayList if browsers will keep being added.

**Trace it on paper:** `i = 0 → arr[0] ✓ … i = 4 → arr[4] ✓, i = 5 → arr[5] ✗ CRASH`.

Other array errors: a `NullPointerException` from using an element of a `String[]` that was never assigned (it's `null`), and off-by-one errors when starting a loop at 1.

---

## 10. Design example: a student roster (arrays + ArrayLists together)

```java
import java.util.ArrayList;

public class RosterManager {
    // FIXED data: an array
    static final String[] SUBJECTS = {"Math", "English", "Science"};

    // DYNAMIC data: ArrayLists (students come and go)
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<int[]> marks = new ArrayList<>();   // one int[] of marks per student

    static void addStudent(String name, int[] studentMarks) {
        names.add(name);
        marks.add(studentMarks);
    }

    static double average(int[] m) {
        int sum = 0;
        for (int x : m) sum += x;
        return (double) sum / m.length;
    }

    public static void main(String[] args) {
        addStudent("Alice", new int[]{80, 75, 90});
        addStudent("Brian", new int[]{60, 85, 70});

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-6s avg %.1f%n", names.get(i), average(marks.get(i)));
        }
        names.remove(1); marks.remove(1);          // Brian leaves
        System.out.println("Remaining: " + names);
    }
}
```
```
Alice  avg 81.7
Brian  avg 71.7
Remaining: [Alice]
```

---

## 11. Exercises

| Exercise | Task |
|----------|------|
| `ArrayEx1` | Predict both printed values, run it, and explain why (shared reference) |
| `ArrayEx2` | Run it, read the exception, then fix it |
| `ArrayListEx1` | Create an `ArrayList<String>` of 5 names; add, get, set, remove and print the size |
| `ArrayListEx2` | Store numbers in an `ArrayList<Integer>`; compute the sum and max; remove the negatives |
| Extra | Read 5 marks into an array; print the average, highest and lowest, and how many are above average |
| Extra | 2D: `int[3][3]` marks table, printing each row's average |
| Practical Session 5 | `class-notes/Week 5 - Practical Session 5.pdf` |

---

## 12. Practice questions

1. What is the index of the last element in an array of length 10?
2. How do you get the length of an array, a String and an ArrayList?
3. Why can't an ArrayList store `int` directly? What do you use instead?
4. What is the time complexity of finding the maximum? Why?
5. What happens if a loop condition is `i <= arr.length`?
6. Write code to safely print the last element of an array called `data`.
7. When would you choose an array over an ArrayList?
8. What does the enhanced for loop do, and what can't it do?
9. After `int[] a = {1,2,3}; int[] b = a; b[0] = 9;`, what is `a[0]`?
10. What are the default values of `new boolean[3]` and `new String[2]`?
11. In `int[][] m = new int[4][6];`, what are `m.length` and `m[0].length`?
12. `list = [A, B, C, D]`. What is the list after `list.remove(1); list.add(0, "Z");`?

<details>
<summary><b>Answers</b></summary>

1. 9
2. `arr.length`, `str.length()`, `list.size()`.
3. Generics work only with objects. Use the wrapper class (`Integer`); autoboxing converts automatically.
4. O(n): every element has to be checked once.
5. `ArrayIndexOutOfBoundsException` on the last pass, when `i == arr.length`.
6. `if (data.length > 0) System.out.println(data[data.length - 1]);`
7. When the size is fixed and known, you're storing primitives (speed and memory), or the data is a grid or matrix.
8. It visits every element in order without an index. It can't change elements in place, skip around, or tell you the position.
9. `9`: both variables refer to the same array.
10. `[false, false, false]` and `[null, null]`.
11. 4 (rows) and 6 (columns).
12. After removing index 1: `[A, C, D]`. After adding Z at index 0: `[Z, A, C, D]`.
</details>

---

## 13. Summary

- An array is fixed-size and holds one type. Indexes run 0…length−1. Use `arr.length`. Default values are 0, 0.0, false or null.
- Array variables hold **references**: assigning one to another shares the array.
- Algorithms: sum, average, max/min (start at `arr[0]`), linear search (−1 if not found), count. O(n) is good; O(n²) gets slow.
- 2D arrays are `[row][col]` and need nested loops.
- ArrayList: dynamic, `add`/`get`/`set`/`remove`/`size`/`contains`. Objects only (wrapper classes, autoboxing).
- Avoid out-of-bounds errors: loop with `i < arr.length` and get the last element with `arr[arr.length - 1]`.
