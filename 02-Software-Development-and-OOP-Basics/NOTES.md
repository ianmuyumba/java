# Unit 02 · Software Development & OOP Basics

> **Oracle JFo:** Section 2 (2-1 The Software Development Process, 2-2 What is my Program Doing?, 2-3 Introduction to Object-Oriented Programming Concepts, 2-4 Practice)
> **Class:** these ideas run through RBCS 7121 Week 1 (procedural vs OOP) and Week 6 (classes and objects)
> **Files in this folder**
> - `oracle-jfo/`: lessons 2-1 to 2-4
> - `exercises/`: `Text01` (ASCII cat), `Text02` (broken code to fix), `Text03` (method call), `ProblemSet2_2` (your own ASCII art)
> - `videos/OldGameVersions/`: 5 clips showing one game evolving across development cycles (local only, not in git)

---

## Learning outcomes

1. Describe the stages of the **software development process** and explain why software is built in repeated cycles (the **Spiral Model**).
2. Read a program **line by line** the way the computer does, and use **breakpoints** to watch it.
3. Apply Java's basic syntax rules: semicolons, braces, whitespace and comments.
4. Explain what a **class** and an **object** are, and identify the **properties** and **behaviours** of objects in a real scenario.

---

## 1. The software development process (JFo 2-1)

Software isn't written in one go. It goes through stages:

| Stage | Question it answers | Example (a school fees app) |
|-------|---------------------|-----------------------------|
| **1. Requirements** | *What* must it do? Who uses it? | "Students must see their balance; the bursar must record payments" |
| **2. Design** | *How* will it be organised? | Sketch the screens; decide on `Student`, `Payment` and `Account` objects |
| **3. Develop (code)** | Build it | Write the Java classes |
| **4. Test** | Does it work? Does it break? | Pay KSh 0, a negative amount, more than the balance… |
| **5. Release / feedback** | What do users think? | Release a beta to one class and collect complaints |

### The Spiral Model
Instead of doing each stage once, you **loop through all of them many times**, adding features and fixing problems each time round:

```
          ┌──── Requirements ◄───┐
          ▼                      │
       Design                 Feedback
          │                      ▲
          ▼                      │
       Develop ───────────►    Test
   (each loop adds features; the spiral grows outwards)
```

- Each loop produces a **working version** that's a bit better than the last.
- Problems are found **early**, when they're cheap to fix.
- The `OldGameVersions` videos (Aug → Nov 2013) show one game growing through these loops: a rough prototype first, then features and polish added cycle by cycle.

**Features** are the things the program can do. They're added gradually, and some ideas get dropped after testing shows they don't work.

---

## 2. What is my program doing? (JFo 2-2)

### 2.1 Code runs line by line, top to bottom
Inside `main`, Java runs one statement after another, in order. Methods run only when they're **called**.

```java
public class Text03 {
    public static void drawLegs() {          // defined here, but NOT run here
        System.out.println("     ||     ||      ");
        System.out.println("    (||)   (||)     ");
    }

    public static void main(String[] args) {
        System.out.println("   /\\         /\\   ");   // 1st
        System.out.println("  /  \\_______/  \\  ");   // 2nd
        drawLegs();                                     // 3rd: jumps into drawLegs, then comes back
        System.out.println("The end");                  // 4th
    }
}
```

In the original `Text03.java`, `drawLegs()` is defined but **never called**, so the legs never print. The fix is to call it at the end of `main`.

### 2.2 Breakpoints and stepping (debugging)
A **breakpoint** pauses the program at a line so you can look around.
1. Click in the margin next to a line number (a red dot appears).
2. Run in **Debug** mode.
3. **Step Over** (F10 in VS Code, F8 in NetBeans) runs one line at a time.
4. **Step Into** goes inside a method call.
5. Watch the **Variables** panel change.

This shows you what the program actually does, which isn't always what you think it does.

### 2.3 Syntax rules that trip beginners up

| Rule | Detail |
|------|--------|
| **Semicolons** | Every statement ends with `;`. The compiler doesn't care about line breaks, only `;` |
| **Braces `{ }`** | Every `{` needs a matching `}`. They group code into blocks (class body, method body) |
| **Whitespace** | Spaces, tabs and blank lines are ignored by the compiler. Use them to make code readable |
| **Indentation** | Not required by Java, but essential for humans. Indent one level inside every `{` |
| **Case** | `System` ≠ `system`, `Main` ≠ `main` |
| **Comments** | `//` and `/* */` are ignored by the compiler. Use them to explain *why*, or to temporarily disable code ("commenting out") |

These two statements are identical to the compiler:
```java
System.out.println("Hi");
System.out
      .println(  "Hi"  )  ;
```

### 2.4 Exercise `Text02`: find the bugs
```java
public class Text02 {
    public static void main(String[] args) {
        System.out.println("1");
        {
            System.out.println("2")      // ❌ missing ;
        }
        System.out.println("3");
        }                                // ❌ this brace closes main too early...
    System.out.println ("4");            // ...so this statement is outside any method
    }
}
```
**Fixed version:**
```java
public class Text02 {
    public static void main(String[] args) {
        System.out.println("1");
        {
            System.out.println("2");
        }
        System.out.println("3");
        System.out.println("4");
    }
}
```
A bare `{ ... }` block inside a method is legal. It just groups statements.

---

## 3. Introduction to object-oriented programming (JFo 2-3)

### 3.1 Objects are everywhere
An **object** is any *thing* your program needs to represent. It can be:
- **Tangible:** a car, a student, a phone, a snake box
- **Abstract (intangible):** a bank account, an order, a transaction, a course enrolment

Every object has:

| | Also called | Question | Example: a `Car` |
|-|-------------|----------|------------------|
| **Properties** | fields, attributes, state, data | What does it *know* or *have*? | colour, model, speed, fuel level |
| **Behaviours** | methods, actions | What can it *do*? | `start()`, `accelerate()`, `brake()`, `refuel()` |

### 3.2 Class vs object

| Class | Object |
|-------|--------|
| A **blueprint**, template or recipe | A real **instance** built from the blueprint |
| Written once, in code | Many can be created while the program runs |
| `class Car { String colour; ... }` | `new Car()`: my red Toyota, your blue Mazda |
| Like the architect's plan for a house | Like the actual houses built from that plan |

Every object made from the same class has the **same kinds** of properties and behaviours, but **its own values**. Both cars have a `colour`; mine is red and yours is blue.

```java
public class Car {
    // properties (fields)
    String colour;
    int speed;

    // behaviour (method)
    void accelerate() {
        speed = speed + 10;
    }

    public static void main(String[] args) {
        Car myCar = new Car();      // object 1
        myCar.colour = "red";
        Car yourCar = new Car();    // object 2
        yourCar.colour = "blue";

        myCar.accelerate();
        myCar.accelerate();
        yourCar.accelerate();

        System.out.println(myCar.colour + " car speed: " + myCar.speed);     // red car speed: 20
        System.out.println(yourCar.colour + " car speed: " + yourCar.speed); // blue car speed: 10
    }
}
```

(Full detail on classes comes in Unit 08. Here the idea is what matters: **one blueprint, many independent objects**.)

### 3.3 Modelling a scenario: finding objects
Read a problem description and look for:
- **Nouns** → candidate **objects** and **properties**
- **Verbs** → candidate **behaviours**

**Practice (JFo 2-4, Problem 3): the Snake Box Factory.** "We deliver custom-sized cardboard boxes filled with custom-ordered snakes to thousands of accounts…" One possible model:

| Object | 3 properties | 3 behaviours |
|--------|-------------|--------------|
| **Box** | length, width, height | `assemble()`, `fill(snake)`, `ship(address)` |
| **Snake** | species, length, colour | `eat()`, `sleep()`, `moveIntoBox()` |
| **Order** (abstract) | orderNumber, customer, boxSize | `place()`, `cancel()`, `calculatePrice()` |
| **Account / Customer** | name, address, satisfactionRating | `placeOrder()`, `pay()`, `rateService()` |

---

## 4. ASCII art practice (JFo 2-4)

ASCII art uses `println` statements to draw a picture. Remember that **`\` must be written `\\`** inside a string, because a single backslash starts an escape sequence.

```java
public class Smiley {
    public static void main(String[] args) {
        System.out.println("  ####  ");
        System.out.println(" #    # ");
        System.out.println("# #  # #");
        System.out.println("#      #");
        System.out.println("# #  # #");
        System.out.println("#  ##  #");
        System.out.println(" #    # ");
        System.out.println("  ####  ");
    }
}
```

The cat from `Text01`, showing the escaped backslashes:
```java
System.out.println("   /\\         /\\   ");   // prints:    /\         /\
```

---

## 5. Exercises

| Exercise | What to do |
|----------|-----------|
| `exercises/Text01` | Run it and look at how `\\` prints a single `\`. Change the cat's face |
| `exercises/Text02` | Fix the compile errors (missing `;`, misplaced `}`). Read each error message first |
| `exercises/Text03` | Call `drawLegs()` so the cat gets legs. Then add a `drawTail()` method |
| JFo Problem 1 | Recreate the 8×8 smiley face (8 print statements) |
| `exercises/ProblemSet2_2` | Problem 2: your own original ASCII art (≥ 8 lines, ≥ 8 wide, ≥ 20 non-space characters, with comments) |
| JFo Problem 3 | Snake Box Factory: 3 objects × 3 properties × 3 behaviours (write it in a document) |
| Videos | Watch `videos/OldGameVersions/` in date order and note what changed in each cycle |

---

## 6. Practice questions

1. Name the stages of the software development process.
2. What is the Spiral Model, and why is it better than building everything in one go?
3. A method is defined in a class but its output never appears. What's the most likely reason?
4. What is a breakpoint? What's the difference between "step over" and "step into"?
5. Does Java care about indentation and blank lines? Why do we use them anyway?
6. How do you print a single backslash?
7. What is the difference between a class and an object?
8. Give 3 properties and 3 behaviours of an M-Pesa account.
9. Is a "transaction" a tangible or an abstract object?
10. In a problem description, which words usually become objects, and which become behaviours?

<details>
<summary><b>Answers</b></summary>

1. Requirements → design → develop → test → release/feedback (and round again).
2. You go through all the stages repeatedly in cycles, producing a better working version each time. Problems are found early, and the product can adapt to feedback.
3. The method is never **called**. Defining a method doesn't run it.
4. A marker that pauses execution at a line. *Step over* runs the current line, including any method calls, as one step. *Step into* goes inside the called method line by line.
5. No: the compiler ignores whitespace. We use it so humans can read the code and see its structure.
6. `System.out.println("\\");`
7. A class is a blueprint that defines properties and behaviours. An object is one instance created from that class (`new`), with its own values.
8. Properties: phone number, balance, PIN. Behaviours: `sendMoney()`, `withdraw()`, `checkBalance()`.
9. Abstract: it exists as data, not as a physical thing.
10. Nouns become objects (or properties); verbs become behaviours (methods).
</details>

---

## 7. Summary

- Software is built in **cycles** (Spiral Model): requirements → design → code → test → feedback, repeated, with each loop adding features.
- The computer runs statements **in order**. Methods run only when **called**. Breakpoints and stepping let you watch it happen.
- `;` ends statements, `{ }` group blocks, whitespace is for humans, and Java is case-sensitive. Write `\\` to print a backslash.
- A **class** is a blueprint; an **object** is an instance with its own values. Objects have **properties** (fields) and **behaviours** (methods), and they can be tangible or abstract.
