# Week 8: Polymorphism and abstract classes

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** predict which overridden method runs at runtime, judge when an abstract class beats a concrete one, design an abstract hierarchy, and avoid `ClassCastException` with `instanceof`.

Each file holds all of its classes, so run any of them with `java FileName.java`.

---

## Task 1: Polymorphism
An `Animal[]` holds a Dog, a Cat and a Cow, and one loop calls `makeSound()` on each.

**Solution:** [PolymorphismDemo.java](PolymorphismDemo.java)
```text
=== ANIMAL SOUNDS ===
Woof! Woof!
Meow!
Moo!
```
**Analysis:** the array's *declared* type is `Animal`, but Java chooses which `makeSound()` to run from each element's *actual* object type at runtime (**dynamic binding**). The generic "Some generic animal sound" never prints, because every subclass overrides the method.

## Task 2: Abstract classes (enforcing rules)
`abstract class Shape` declares `abstract double calculateArea()`, which Circle and Rectangle must implement.

**Solution:** [AbstractDemo.java](AbstractDemo.java)
```text
Shape: Circle
Area: 78.54
Shape: Rectangle
Area: 24.00
```
**Why not a concrete `Shape` with `return 0`?**
1. **No `new Shape()`.** A generic shape doesn't exist, and an abstract class can't be instantiated.
2. **No forgotten overrides.** A subclass that skips `calculateArea()` won't compile, whereas a dummy `return 0` silently gives wrong answers.
3. **Clear contract.** The abstract method tells readers, and the compiler, that *every* shape has an area.

## Task 3: Upcasting, downcasting and `instanceof`
Downcast a `Vehicle` reference to `Car` only after checking its real type.

**Solution:** [CastingDemo.java](CastingDemo.java)
```text
Upcasting successful.
Trunk opened.
v2 is not a Car, it is a Bike. Downcasting prevented!
Without instanceof: ClassCastException
  class Bike cannot be cast to class Car
```
**Experiment:** the handout's "buggy lines" are `Car c2 = (Car) v2; c2.openTrunk();`. They compile, because a `Vehicle` *might* be a Car, but crash at runtime with `ClassCastException`, because `v2` is really a Bike. The solution runs them inside a `try/catch` to show the error. `instanceof` checks the type first, so the bad cast never happens. Java 16+ can test and cast in one step: `if (v instanceof Car car)`.

## Task 4: Integrated fintech system
`abstract PaymentMethod` with `MpesaPayment` and `CardPayment`, processed in one loop.

**Solution:** [FintechSystem.java](FintechSystem.java)
```text
Processing M-Pesa payment of KSh 1500.0 for Alice
  Sending STK push to: 0712345678
Processing Credit Card payment of KSh 1500.0 for Bob
  Charging card ending in: 5678
...
Total Revenue Collected: KSh 6000.0
```
The loop has **no if-else on the payment type**. To prove it extends cleanly, the solution adds a `BankTransferPayment` class without touching the loop (the **open/closed principle**: open to extension, closed to modification).

## Task 5: Push to GitHub
- [ ] Commit `Week 8: Polymorphism, Abstract Classes, and instanceof`, then push and verify
