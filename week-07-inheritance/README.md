# Week 7: Inheritance and method overriding

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** work out which members a subclass inherits, override methods properly, choose between inheritance and composition, and design a class hierarchy.

Each file holds all of its classes, so run any of them with `java FileName.java`.

---

## Task 1: The basics of inheritance (`extends`)
`Dog extends Animal`: Dog gets `eat()` and `sleep()` without rewriting them, and adds `bark()`.

**Solution:** [InheritanceDemo.java](InheritanceDemo.java)
```text
Buddy is eating.
Buddy is sleeping.
Buddy is barking: Woof! Woof!
```

## Task 2: Method overriding and `super`
`Manager` overrides `calculateSalary()` and `displayInfo()`, reusing the parent versions through `super`.

**Solution:** [OverridingDemo.java](OverridingDemo.java)
```text
=== MANAGER ===
Name: Bob
Base Salary: KSh 80000.0
Bonus: KSh 20000.0
Total Salary: KSh 100000.0
```
**Answers:**
1. `@Override` asks the compiler to **check** that the method really overrides a parent method. A typo like `calculateSalery()` becomes a compile error instead of a silent new method.
2. `super.calculateSalary()` reuses the parent's base-salary logic instead of duplicating it. If the base calculation changes, Manager picks up the change automatically.
3. Without `super.displayInfo()`, the Manager output would lose the "Name" and "Base Salary" lines and show only the bonus and total.

## Task 3: The `protected` access modifier
`printNameDirectly()` in `Manager` reads the inherited `protected` field `name` directly (see OverridingDemo).
```text
Direct access to name: Bob
```
- A `private` field: `Manager` could **not** access `name` (compile error).
- A `public` field: **any** class could change it, which breaks encapsulation.
- `protected` is the middle ground: visible to subclasses and to the same package.

## Task 4: Inheritance vs composition
A `Car` **has an** `Engine`, so it holds one as a field rather than extending it.

**Solution:** [CompositionDemo.java](CompositionDemo.java)
```text
Car is starting...
Engine started.
```
**Answers:**
1. **Why composition here:**
   - A car is not a kind of engine, so `Car extends Engine` would expose engine methods as car methods.
   - It would tie Car to one engine forever.
   - It would waste Car's single inheritance slot.
   - With composition the engine can be swapped (petrol → electric) and its details stay hidden.
2. **Use inheritance** when the **is-a** test passes and the subclass truly is a specialised version: `SportsCar extends Car` and `Truck extends Vehicle`. The demo includes a `SportsCar` for this.

## Task 5: Designing a class hierarchy (shapes)
`Shape` holds the shared `name` and `toString()`; `Circle` and `Rectangle` override `calculateArea()`.

**Solution:** [ShapeHierarchy.java](ShapeHierarchy.java)
```text
Shape: My Circle | Radius: 5.0
Area: 78.54
Shape: My Rectangle | Length: 4.0, Width: 6.0
Area: 24.00
```

## Reflection answers
1. It is called an "is-a" relationship because a subclass object *is* a full instance of its superclass: every Dog is an Animal and can be used anywhere an Animal is expected.
2. **Overriding vs overloading:** overriding uses the **same signature** in a subclass and replaces the behaviour, decided at runtime. Overloading uses the **same name with different parameters** in the same class, decided at compile time.
3. The **subclass's** version runs. Java uses the object's actual type, so even `Parent p = new Child(); p.doSomething();` runs Child's version (this is polymorphism, week 8).
4. Composition is looser: you can swap the parts, hide them, and combine several. Inheritance locks a class into one parent and exposes everything the parent exposes.

## Task 6: Push to GitHub
- [ ] Commit `Week 7: Inheritance - extends, super, overriding, composition`, then push and verify
