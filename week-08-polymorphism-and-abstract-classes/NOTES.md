# Week 8 notes: polymorphism and abstract classes

[Tasks](README.md) · Sources: class comprehensive notes (week 8) and standard Java

## 1. Polymorphism means "many forms"
A **parent-type reference** can point to **any subclass object**, and calling an overridden method runs the *object's* version.
```java
Animal a = new Dog();   // upcast: automatic, always safe
a.makeSound();          // "Woof!": Dog's version, chosen at RUNTIME
```
```
reference type  (left side)  → decides WHICH methods you may call   (compile time)
object type     (right side) → decides WHICH VERSION runs          (runtime)
```
This is called **dynamic binding** (or late binding / dynamic method dispatch).

**Why it matters:** you write code against the parent type once, and it works for every current and future subclass.
```java
void feedAll(Animal[] zoo) {
    for (Animal a : zoo) a.makeSound();   // no if-else on the type
}
```

## 2. What a reference can "see"
```java
Animal a = new Dog();
a.makeSound();   // ✅ declared in Animal
a.fetch();       // ❌ compile error: Animal has no fetch(), even though the object is a Dog
```
To use child-only methods you must **downcast**.

## 3. Upcasting and downcasting
| | Direction | Syntax | Safe? |
|---|---|---|---|
| **Upcast** | child → parent | `Animal a = dog;` | always, automatic |
| **Downcast** | parent → child | `Dog d = (Dog) a;` | only if the object really is a Dog |

A wrong downcast compiles but throws **`ClassCastException`** at runtime. Check first:
```java
if (a instanceof Dog) {
    Dog d = (Dog) a;
    d.fetch();
}

if (a instanceof Dog d) {   // Java 16+ pattern matching
    d.fetch();
}
```
Frequent downcasting is a design smell; usually the method belongs in the parent so polymorphism can handle it.

## 4. Abstract classes
An abstract class is a class that is **too general to instantiate**. It exists to be extended.
```java
abstract class Shape {
    protected String name;
    Shape(String name) { this.name = name; }   // constructors allowed (called via super)
    abstract double area();                    // no body: subclasses MUST implement it
    void describe() {                          // concrete methods allowed
        System.out.println(name + " area " + area());
    }
}

class Square extends Shape {
    private double s;
    Square(double s) { super("Square"); this.s = s; }
    @Override double area() { return s * s; }
}
```
**Rules:**
- `new Shape(...)` is a compile error.
- A class with any `abstract` method must itself be `abstract`.
- A concrete subclass must implement **every** inherited abstract method, or be declared abstract itself.
- An abstract class can have fields, constructors, concrete methods, and `static` / `final` members.

## 5. Abstract vs concrete base class
| Use an **abstract** base when… | Use a **concrete** base when… |
|---|---|
| the parent is a general idea (Shape, Payment, Account) | the parent is a real, usable thing by itself |
| there's no sensible default for some behaviour | a default implementation makes sense |
| you want the compiler to **force** subclasses to implement it | overriding is optional |

`abstract` also beats a dummy `return 0;`: forgetting to override becomes a compile error instead of a silent bug.

## 6. Polymorphism in practice (the payment example)
```java
abstract class PaymentMethod {
    abstract void pay(double amt);
}
class Mpesa extends PaymentMethod { void pay(double a) { /* STK push */ } }
class Card  extends PaymentMethod { void pay(double a) { /* charge card */ } }

PaymentMethod[] cart = { new Mpesa(), new Card() };
for (PaymentMethod p : cart) p.pay(1500);   // each pays its own way
```
To add `PayPal`, write one new class. The loop never changes (the **open/closed principle**).

## 7. The four pillars of OOP (summary so far)
| Pillar | Meaning | Week |
|---|---|---|
| Encapsulation | hide data, expose safe methods | 6 |
| Inheritance | reuse and specialise via `extends` | 7 |
| Polymorphism | one interface, many behaviours | 8 |
| Abstraction | show *what*, hide *how* (abstract classes and interfaces) | 8–9 |

## Quick check
- [ ] `Animal a = new Cat(); a.makeSound();`: whose method runs?
- [ ] Why does `a.climbTree()` fail to compile if only Cat has it?
- [ ] What's printed by `Vehicle v = new Bike(); Car c = (Car) v;`? (`ClassCastException`)
- [ ] Can an abstract class have a constructor? (yes, called through `super(...)`)
