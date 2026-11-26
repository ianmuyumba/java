# Week 5 notes: arrays and ArrayLists

[Tasks](README.md) · Sources: Oracle Java Foundations §8-1 (one-dimensional arrays) and §8-2 (ArrayLists)

## 1. Arrays: fixed-size, indexed, one type
```
int[] marks = {65, 72, 48};
index:          0   1   2        marks.length == 3
```
```java
int[] a = new int[5];              // 5 slots, all 0
String[] names = {"Ann", "Ben"};   // literal: size inferred
a[0] = 10;                         // write
int x = a[0];                      // read
int last = a[a.length - 1];        // last element
```
| Default values | |
|---|---|
| `int`, `long`, `double` | `0` / `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| objects (`String`, …) | `null` |

**Arrays are objects.** The variable holds a *reference*, so `int[] b = a;` shares the same array, and changing `b[0]` changes `a[0]`. To copy one, use `Arrays.copyOf(a, a.length)`.

## 2. Looping
```java
for (int i = 0; i < a.length; i++) a[i] *= 2;   // need the index, or need to modify
for (int v : a) System.out.println(v);          // just read every value
```

## 3. Standard algorithms (all O(n))
```java
int max = a[0];                       // max (start with an element, not 0!)
for (int v : a) if (v > max) max = v;

int sum = 0;                          // average (cast before dividing)
for (int v : a) sum += v;
double avg = (double) sum / a.length;

int idx = -1;                         // linear search (-1 = not found)
for (int i = 0; i < a.length; i++) {
    if (a[i] == target) { idx = i; break; }
}
```
**Helpers in `java.util.Arrays`:** `toString(a)`, `sort(a)`, `fill(a, 0)`, `copyOf(a, n)`, `equals(a, b)`.
Printing an array directly gives gibberish like `[I@1b6d3586`. Use `Arrays.toString(a)` instead.

## 4. 2D arrays: arrays of rows
```java
int[][] grid = { {1, 2, 3}, {4, 5, 6} };   // 2 rows × 3 columns
grid[1][2];          // row 1, column 2 → 6
grid.length;         // rows → 2
grid[0].length;      // columns in row 0 → 3

for (int r = 0; r < grid.length; r++) {
    for (int c = 0; c < grid[r].length; c++) {
        System.out.print(grid[r][c] + " ");
    }
    System.out.println();
}
```
Rows can have different lengths ("jagged" arrays), so use `grid[r].length` rather than assuming every row matches row 0.

## 5. ArrayList: a resizable list of objects (Oracle §8-2)
```java
import java.util.ArrayList;

ArrayList<String> list = new ArrayList<>();
list.add("Ann");            // [Ann]
list.add("Ben");            // [Ann, Ben]
list.add(0, "Zoe");         // [Zoe, Ann, Ben]   insert, others shift right
list.get(1);                // "Ann"
list.set(1, "Amy");         // [Zoe, Amy, Ben]   replace
list.remove("Ben");         // by value
list.remove(0);             // by index → [Amy]
list.size();                // 1
list.contains("Amy");       // true
list.indexOf("Xyz");        // -1
list.isEmpty(); list.clear();
System.out.println(list);   // prints nicely: [Amy]
```
**Primitives need wrapper classes:** `ArrayList<Integer>`, `ArrayList<Double>`, `ArrayList<Character>`. Java *autoboxes* `int` ↔ `Integer` for you.

⚠️ With `ArrayList<Integer> nums`, `nums.remove(1)` removes **index 1**. Use `nums.remove(Integer.valueOf(1))` to remove the value 1.

⚠️ Don't `add`/`remove` inside a for-each over the same list, or you get a `ConcurrentModificationException`. Use an index loop running backwards, or `list.removeIf(...)`.

## 6. Array vs ArrayList
| | Array | ArrayList |
|---|---|---|
| Size | fixed at creation | grows and shrinks |
| Holds | primitives or objects | objects only (wrappers) |
| Length | `a.length` | `list.size()` |
| Access | `a[i]` | `list.get(i)` |
| Insert/delete in the middle | manual shifting | `add(i, x)` / `remove(i)` (still O(n) shifting inside) |
| Speed/memory | best | small overhead |

**Rule of thumb:** use an array for a fixed count of items or raw performance; use an ArrayList whenever the count changes.

## 7. Index errors
- `ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5` means you used index ≥ length, or a negative index.
- **Usual causes:** `<=` in a loop condition, a hard-coded index, or forgetting arrays start at 0.
- `NullPointerException` on `names[0].length()` means the slot was never filled (still `null`).

## Quick check
- [ ] Last valid index of `new int[8]`? (7)
- [ ] What does `int[] b = a; b[0] = 99;` do to `a`? (changes it too: same array)
- [ ] Why `ArrayList<Integer>` and not `ArrayList<int>`?
- [ ] `list.add(2, x)` vs `list.set(2, x)`?
