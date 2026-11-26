# Week 7 notes: inheritance

[Tasks](README.md) · Sources: class comprehensive notes (week 7) and standard Java (Oracle Java Foundations covers this only briefly in §7)

## 1. What inheritance is
A **subclass** (child) *extends* a **superclass** (parent) and automatically gets the parent's non-private fields and methods. It can then add new members or change inherited behaviour.
```
        Animal          ← superclass: name, eat(), sleep()
       /      \
     Dog      Cat       ← subclasses: inherit all of the above
   bark()   meow()      ← plus their own extras
```
```java
class Animal {
    protected String name;
    Animal(String n) { name = n; }
    void eat() { System.out.println(name + " eats"); }
}

class Dog extends Animal {
    Dog(String n) { super(n); }
    void bark() { System.out.println("Woof"); }
}
```
- **Why:** reuse code, keep shared logic in one place, and model real "kind of" relationships.
- **Single inheritance only:** a class can extend just **one** class. Every class ultimately extends `Object`, which supplies `toString()`, `equals()` and `hashCode()`.

## 2. What is (and isn't) inherited
| Member | Inherited? |
|---|---|
| `public` / `protected` fields and methods | ✅ |
| package-private (no modifier) | ✅ if in the same package |
| `private` fields and methods | ❌ not accessible (they exist, but only the parent's own methods can use them) |
| constructors | ❌ never inherited, so call them with `super(...)` |
| `static` members | accessible, but not overridden |

## 3. Constructors and `super(...)`
A child's constructor **must** start by running a parent constructor.
```java
class Manager extends Employee {
    private double bonus;
    Manager(String name, double salary, double bonus) {
        super(name, salary);   // must be the first line
        this.bonus = bonus;
    }
}
```
If you leave out `super(...)`, Java inserts `super()`. That fails if the parent has no no-arg constructor.
**Order:** the parent's part of the object is built first, then the child's.

## 4. Overriding
Overriding means the subclass redefines an inherited method with the **same signature**.
```java
@Override
public double calculateSalary() {
    return super.calculateSalary() + bonus;   // extend the parent, don't copy it
}
```
**Rules:**
- The name, parameters and return type must match (a subtype return is allowed).
- Access can't be narrower: a `public` method can't become `protected`.
- `private`, `static` and `final` methods can't be overridden.
- Always write `@Override`, so the compiler catches typos.

| | Overriding | Overloading |
|---|---|---|
| Where | subclass | same class (or subclass) |
| Signature | same | different parameters |
| Decided | at **runtime** (by the object's real type) | at **compile time** |

## 5. `super` vs `this`
| | `this` | `super` |
|---|---|---|
| refers to | the current object | the parent part of the current object |
| `X(...)` | another constructor of this class | a parent constructor |
| `.method()` | this class's version | the parent's version |

## 6. `protected`
`protected` makes a member visible to subclasses (in any package) and to classes in the same package.
**Good practice:** keep fields `private` with `protected` or `public` getters, unless subclasses genuinely need direct access.

## 7. `final`
- `final class String`: cannot be extended.
- `final void pay()`: cannot be overridden.
- `final int MAX = 10`: cannot be reassigned.

## 8. Inheritance vs composition
| Test | Relationship | Code |
|---|---|---|
| "X **is a** Y" | inheritance | `class Car extends Vehicle` |
| "X **has a** Y" | composition | `class Car { private Engine engine; }` |

**Prefer composition when in doubt:** it is flexible (parts can be swapped), hides details, and avoids deep, fragile hierarchies. Use inheritance only for true "kind of" relationships where the subclass can stand in for the parent anywhere.

## 9. Designing a hierarchy
1. List the things involved: Circle, Rectangle, Triangle.
2. Pull the shared state and behaviour up into the parent (`name`, `toString()`).
3. Leave what varies in the children, overriding the parent's methods (`calculateArea()`).
4. Check every child with "is-a".
5. If the parent method has no sensible body (like `return 0.0`), make it `abstract` (week 8).

## Quick check
- [ ] Can a subclass read the parent's `private` field directly? (no; use a getter or `protected`)
- [ ] What happens if a parent has only `Animal(String)` and the child constructor doesn't call `super(...)`? (compile error)
- [ ] Overriding or overloading: `print(int)` and `print(String)` in one class?
- [ ] Car and Wheel: inheritance or composition?
