# Oracle Section 8 · Iterator traversal

[Lesson](README.md) · [Practice](PRACTICE.md) · [Student Guide](sources/oracle-jfo/8-2-student-guide.md) · [Audit](../ORACLE_AUDIT.md)

Oracle 8-2 explicitly requires traversal using **iterators and for-each loops**. Our lesson already covered indexed traversal and for-each, but lacked a worked iterator example.

## An iterator has a current position

```java
java.util.Iterator<String> iterator = names.iterator();
while (iterator.hasNext()) {
    String name = iterator.next();
    System.out.println(name);
}
```

`hasNext()` checks whether another element exists without advancing. `next()` returns it and advances. Calling `next()` after the end throws `NoSuchElementException`.

## Remove through the iterator

```java
java.util.Iterator<Integer> iterator = values.iterator();
while (iterator.hasNext()) {
    if (iterator.next() < 0) iterator.remove();
}
```

For an `ArrayList`, this safely removes the element most recently returned by `next()`. Calling `remove()` before `next()`, or twice after one `next()`, violates the iterator's state rules. Other collection implementations may not support removal.

Do not call `values.remove(...)` inside a for-each loop over `values`: structural modification can invalidate its iterator and produce `ConcurrentModificationException`. Fail-fast detection is a bug detector, not a guarantee that all invalid code fails immediately.

## Index and value are different overloads

With `ArrayList<Integer> values`, `remove(1)` removes the element **at index 1**. `remove(Integer.valueOf(1))` removes the first matching **value 1**. Trace the list after every change because subsequent indexes shift.

Assigning to a for-each loop variable does not replace the element in the list. Use `set(index, value)` for replacement, or mutate the referenced object's state deliberately if the elements are mutable objects.

## Practice

1. Traverse the same list with an index, a for-each loop and an iterator. Compare the outputs.
2. Remove every negative number from `[-1, -2, 3, -4, 5]`. Explain why a naive forward-index loop can skip adjacent negative values.
3. Predict the results of `remove(1)` and `remove(Integer.valueOf(1))` on `[1, 2, 1]`.
4. Explain why a list of `Integer` values may contain null, but assigning a null element to an `int` fails.

Run the [worked iterator example](examples/IteratorDemo.java):

```powershell
java 07-Arrays-and-ArrayLists/examples/IteratorDemo.java
```

Expected output: `[3, 5]`. Test an empty list, all-negative values, no negatives and adjacent negatives.

The official `ComputeAvg` starter is already present under Unit 10. Its location is an organisational difference, not a missing download; see the [audit](../ORACLE_AUDIT.md).
