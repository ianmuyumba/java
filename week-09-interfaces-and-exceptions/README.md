# Week 9: Interfaces and exception handling

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** choose between an interface and an abstract class, implement several interfaces at once, trace whether an exception is caught or propagated, and design a custom exception for a domain.

Each file holds all of its classes, so run any of them with `java FileName.java`.

---

## Task 1: Interface vs abstract class
`Bird extends Animal implements Flyable`.

**Solution:** [InterfaceVsAbstract.java](InterfaceVsAbstract.java)
```text
Tweety is sleeping.
Tweety says: Tweet! Tweet!
Tweety is flying up to 10000 feet.
=== ANYTHING FLYABLE ===
Tweety is flying up to 10000 feet.
Airplane cruising below 10000 feet.
```
**Answers:**
1. **Animal is an abstract class** because it carries **state** (the `name` field), a **constructor**, and **ready-made behaviour** (`sleep()`) for every subclass. Interfaces can't hold instance fields or constructors, and an abstract class is the natural home for a shared "is-a" base.
2. **Flyable is an interface** because flying is a **capability** that unrelated things share: birds, airplanes, insects. An `Airplane` isn't an Animal, and a class can extend only one class but implement many interfaces. The solution adds an `Airplane implements Flyable` to show this.

## Task 2: Multiple interfaces
`Smartphone implements Camera, MusicPlayer, Phone`.

**Solution:** [MultipleInterfaces.java](MultipleInterfaces.java)
```text
Samsung Galaxy is taking a photo... Click!
Samsung Galaxy is playing music...
Samsung Galaxy is calling 0712345678...
=== POLYMORPHISM WITH INTERFACES ===
Samsung Galaxy is taking a photo... Click!
```
The same object can be referenced as a `Camera`, a `MusicPlayer` or a `Phone`, and each reference type exposes only that interface's methods.

## Task 3: Exception handling (try-catch)
Catch division by zero, an out-of-bounds index and bad number parsing, and keep running.

**Solution:** [ExceptionHandlingDemo.java](ExceptionHandlingDemo.java)
```text
Error caught: You cannot divide by zero!
Java says: / by zero
Finally block executed (cleaning up resources).
Program continues safely...
Error caught: The array index is out of bounds!
Error caught: Invalid number format.
main() caught what parseOrThrow() threw: For input string: "abc"
Program finished.
```
**Analysis:**
- **The statement after the failing line is skipped.** "Result:" never prints, because control jumps straight to `catch`.
- **`finally` always runs**, whether or not an exception occurred, so it's used for clean-up.
- **The handout's "propagation" example actually catches inside the method.** The exception never leaves `performRiskyOperation()`. The solution adds **3b**, where `parseOrThrow()` has no try/catch, so the exception *propagates* up to `main`, which handles it. If `main` didn't catch it either, the program would crash with a stack trace.

## Task 4: Custom exceptions (banking system)
`InsufficientFundsException` (checked) carries the shortfall amount.

**Solution:** [BankingSystem.java](BankingSystem.java)
```text
Attempting to withdraw KSh 10000.0...
TRANSACTION DECLINED!
Error Message: Withdrawal failed. Insufficient funds.
You are short by: KSh 5000.0
Attempting to withdraw KSh 2000.0...
Successfully withdrew: KSh 2000.0
Attempting to withdraw KSh -50.0...
INVALID REQUEST: Amount must be positive
Checking final balance: KSh 3000.0
```
**Answers:**
1. **Why `Exception` rather than `RuntimeException`:** subclasses of `Exception` are **checked**. Any code calling `withdraw()` must either catch `InsufficientFundsException` or declare `throws`, so a declined withdrawal can never be silently ignored. Insufficient funds is an expected business situation the caller must plan for. (A programming mistake, like a negative amount, is better as an unchecked `IllegalArgumentException`, which the solution also shows.)
2. **What `throw` does:** it creates and raises the exception immediately. The rest of `withdraw()` (the balance deduction) is skipped, and control jumps to the nearest matching `catch` up the call stack. `throws` in the method signature only *declares* that this can happen.

## Task 5: Push to GitHub
- [ ] Commit `Week 9: Interfaces & Exception Handling`, then push and verify
