# Week 10 notes: collections and file I/O

[Tasks](README.md) · Sources: class comprehensive notes (week 10), standard Java (`java.util`, `java.io`, `java.nio.file`), and Oracle Java Foundations §8-2 (ArrayList) as background

## Part A: The collections framework

### 1. The main interfaces
```
Collection
├── List   ordered, indexed, duplicates OK       → ArrayList, LinkedList
├── Set    no duplicates                         → HashSet, LinkedHashSet, TreeSet
└── Queue  process in order (FIFO / priority)    → ArrayDeque, PriorityQueue
Map        key → value pairs, keys unique        → HashMap, LinkedHashMap, TreeMap
```
**Declare by interface, create by class:** `List<String> names = new ArrayList<>();`. That way you can swap the implementation later without touching the rest of the code.

### 2. List
```java
List<String> list = new ArrayList<>();
list.add("A"); list.add("B"); list.add("A");   // [A, B, A]
list.get(0); list.set(1, "C"); list.remove("A");
list.size(); list.contains("C");               // contains is O(n): it scans
Collections.sort(list);                        // or list.sort(null)
```

### 3. Set
```java
Set<Integer> ids = new HashSet<>();
ids.add(101); ids.add(101);   // second add returns false, set stays {101}
ids.contains(101);            // O(1): uses hashing
```
| Implementation | Order |
|---|---|
| `HashSet` | none (fastest) |
| `LinkedHashSet` | insertion order |
| `TreeSet` | sorted |

**Dedupe a list:** `new HashSet<>(list)`.

### 4. Map
```java
Map<String, Integer> stock = new HashMap<>();
stock.put("milk", 10);
stock.put("milk", 12);                  // same key: value replaced
stock.get("milk");                      // 12
stock.get("eggs");                      // null (missing key)
stock.getOrDefault("eggs", 0);          // 0
stock.containsKey("milk");
stock.merge("bread", 1, Integer::sum);  // count / increment pattern

for (Map.Entry<String, Integer> e : stock.entrySet()) {
    System.out.println(e.getKey() + " = " + e.getValue());
}
```
Ordering works the same way as sets: `HashMap` (none), `LinkedHashMap` (insertion), `TreeMap` (sorted by key).

### 5. Choosing a collection
| Need | Use |
|---|---|
| ordered list, access by position, duplicates OK | `ArrayList` |
| "Have I seen this before?" / unique items | `HashSet` |
| look up a value by a key (ID → student, word → meaning) | `HashMap` |
| sorted unique items or keys | `TreeSet` / `TreeMap` |
| first in, first out | `ArrayDeque` |

**Speed:** `list.contains(x)` checks every element (O(n)); `set.contains(x)` and `map.get(k)` jump straight to the item (O(1)). For lookups in big data, sets and maps win.

### 6. Iterating safely
```java
for (String s : list) { ... }                   // read
list.removeIf(s -> s.startsWith("x"));          // remove while iterating (the safe way)
// list.remove(...) inside a for-each throws ConcurrentModificationException
```

## Part B: File I/O

### 7. Writing text
```java
try (PrintWriter out = new PrintWriter(new FileWriter("out.txt"))) {   // true as 2nd arg to append
    out.println("Hello");
    out.printf("Total: %.2f%n", 99.5);
} catch (IOException e) {
    System.out.println("Write failed: " + e.getMessage());
}
```

### 8. Reading text
```java
try (Scanner in = new Scanner(new File("data.txt"))) {
    while (in.hasNextLine()) {
        String line = in.nextLine();
        ...
    }
} catch (FileNotFoundException e) {
    System.out.println("File not found");
}
```
The modern one-liner reads a whole (small) file at once:
```java
List<String> lines = java.nio.file.Files.readAllLines(java.nio.file.Path.of("data.txt"));
```

### 9. try-with-resources
Anything that implements `AutoCloseable`, declared inside `try ( … )`, is **closed automatically**, even on errors.
- **Why it matters:**
  - unclosed writers may never **flush**, so the file stays empty
  - open files hold OS handles, which is a **resource leak**
  - on Windows an open file can't be deleted or renamed
- Prefer it to calling `close()` manually, because a manual `close()` is skipped if an exception happens first.

### 10. Parsing CSV lines
```java
String[] p = "101, Alice ,85".split(",");
String name = p[1].trim();                 // "Alice": trim the spaces
int marks = Integer.parseInt(p[2].trim()); // may throw NumberFormatException
```
**Validate every row:** check `p.length` and catch `NumberFormatException` per row so one bad line doesn't kill the whole run.

### 11. The pipeline pattern
```
read file → parse each line → validate → store in a collection → compute → write report
   Scanner      split/parse     skip bad     Map/List/Set        sum/avg   PrintWriter
```

### 12. Common I/O errors
| Error | Cause and fix |
|---|---|
| `FileNotFoundException` | wrong name or folder. Relative paths resolve from the **working directory** (where you ran `java`), not where the `.java` file is |
| Empty output file | writer never closed or flushed. Use try-with-resources |
| `NumberFormatException` | non-numeric text or spaces. Use `trim()` and validate |
| `NoSuchElementException` | read past the end. Check `hasNextLine()` first |

## Quick check
- [ ] Which collection removes duplicates automatically?
- [ ] What does `map.put(k, v)` do if `k` already exists?
- [ ] Why can a program "write" a file but leave it empty?
- [ ] `list.contains(x)` vs `set.contains(x)`: which is faster on a million items, and why?
