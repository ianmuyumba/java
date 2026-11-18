# 12 · Abstraction & Interfaces

[Course home](../README.md) · [Progress](../PROGRESS.md) · [← JavaFX](../11-JavaFX/README.md) · [Collections & File I/O →](../13-Collections-Framework-and-File-IO/README.md)

**Design a contract. Supply an implementation. Use both through one type.**

Riara Week 9 combines interfaces and exception handling. Read [Unit 09](../09-Inheritance-and-Polymorphism/README.md) for Week 8 polymorphism and [Unit 10](../10-Exceptions-and-Debugging/README.md) for exception fundamentals.

[Source library](sources/README.md) · [Practice guide](PRACTICE.md) · [Liang Ch. 13](../00-Course-Info/sources/textbook/chapter-13-abstract-classes-and-interfaces.md) · [Liang Ch. 12](../00-Course-Info/sources/textbook/chapter-12-exception-handling-and-text-i-o.md)

## Learning goals

- Choose an abstract class or interface for a concrete design problem.
- Implement a contract in more than one class and call it polymorphically.
- Explain how constructors work in an abstract hierarchy.
- Distinguish validation failures from failures that callers must recover from.
- Compare objects using a deliberate ordering rule.

## 1. Abstraction starts with the caller

A caller should need to know **what an operation promises**, rather than all the details of how it works. A receipt printer, for example, needs a payment description without needing to know the fields of every payment type.

Liang §13.2 uses abstract classes to express a shared concept whose concrete behaviour belongs to subclasses. The abstract parent can contain fields, constructors, implemented methods and abstract methods. Its constructor runs when a concrete child is constructed.

```java
abstract class Payment {
    private final int amount;

    protected Payment(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        this.amount = amount;
    }

    public int getAmount() { return amount; }
    public abstract String description();
}
```

You cannot write `new Payment(500)`. A concrete subclass must provide `description()`, or inherit a concrete implementation of it. An abstract class may also have no abstract methods; the modifier still prevents direct instantiation.

## 2. Interfaces describe capabilities

```java
interface Receiptable {
    String receipt();
}
```

The declaration above is implicitly `public abstract`. An implementing method must be public. An interface can be used as a variable or parameter type, enabling unrelated implementations to satisfy the same caller.

> [!NOTE]
> The book's older wording describes interfaces as containing only constants and abstract methods. Java also supports default and static interface methods, and private helper methods. Interface fields are implicitly `public static final`; interfaces do not have instance constructors or per-object fields.

| Requirement | Typical choice | Reason |
|---|---|---|
| Share state and constructor validation | Abstract class | One shared implementation of the invariant |
| Expose a capability across unrelated classes | Interface | Callers depend on a small contract |
| Support multiple capabilities | Several interfaces | A class can implement multiple interfaces |
| Reuse a collaborator's behaviour | Composition | Delegate to an owned or supplied object |

A class extends one class, but can implement several interfaces. “Is-a” is a useful first check, not a complete design test: a subtype must also honour the behaviour clients expect from its parent.

## 3. Complete example

Save this as `ReceiptDemo.java`, or run [the provided example](examples/ReceiptDemo.java).

```java
public class ReceiptDemo {
    interface Receiptable {
        String receipt();
    }

    static abstract class Payment implements Receiptable {
        private final int amount;
        Payment(int amount) {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
            this.amount = amount;
        }
        public int getAmount() { return amount; }
        protected abstract String channel();
        public String receipt() { return channel() + ": KES " + amount; }
    }

    static final class CashPayment extends Payment {
        CashPayment(int amount) { super(amount); }
        protected String channel() { return "Cash"; }
    }

    static final class CardPayment extends Payment {
        CardPayment(int amount) { super(amount); }
        protected String channel() { return "Card"; }
    }

    public static void main(String[] args) {
        Receiptable[] payments = {new CashPayment(500), new CardPayment(800)};
        for (Receiptable payment : payments) System.out.println(payment.receipt());
    }
}
```

Expected output:

```text
Cash: KES 500
Card: KES 800
```

The loop knows only `Receiptable`. Shared validation lives in `Payment`; each concrete subtype supplies its channel. Adding another channel does not require a type check inside the loop.

## 4. Ordering objects

Liang §13.6 introduces `Comparable<T>` for a class's natural ordering. `compareTo` returns a negative number, zero or a positive number. It does not have to return exactly -1 or 1.

Use `Integer.compare(a, b)` rather than `a - b`, which can overflow. Use a `Comparator<T>` when the same objects need different orderings, such as sorting students by name or score. Decide how ties work and document whether ordering agrees with `equals`.

## 5. Contracts include failures

If an amount must be positive, reject an invalid value at construction. `IllegalArgumentException` is unchecked: callers are not forced to catch it. A domain-specific checked exception is useful when callers are expected to make a recovery decision, such as retrying an operation after insufficient credit.

An override cannot add a broader checked exception than the parent contract permits. Otherwise code using the parent type could unexpectedly receive a checked failure it was never required to handle.

Do not catch an exception simply to return a plausible-looking success value. Recover explicitly, report failure or propagate it with useful context.

## 6. Predict before running

1. Can `Payment` have a constructor even though it is abstract?
2. Which method runs when `receipt()` calls `channel()` on a `CardPayment`?
3. Can `CashPayment.receipt()` be private?
4. Can a class implement both `Receiptable` and `Comparable<CashPayment>`?
5. What happens if the example constructs `new CashPayment(0)`?

<details>
<summary>Check your reasoning</summary>

1. Yes. The child calls it during construction.
2. The overridden `CardPayment.channel()` method.
3. No. It would weaken the public interface contract.
4. Yes; it must satisfy both contracts.
5. Construction throws `IllegalArgumentException`, preventing an invalid payment object.

</details>

## Ready to move on?

- [ ] I can justify a class/interface/composition choice with a concrete requirement.
- [ ] I can add a subtype without rewriting the caller.
- [ ] I can explain validation, checked exceptions and override restrictions.
- [ ] I have completed the [practice ladder](PRACTICE.md).
