# Unit 01 · Introduction to Java

> **Class:** RBCS 7121 Week 1 (Introduction to Java & OOP Fundamentals)
> **Oracle JFo:** Section 1 (1-1 About the Course, 1-2 A Brief History, 1-3 Setting up Java, 1-4 Practices)
> **Files in this folder**
> - `class-notes/`: Week 1 welcome letter, comprehensive notes, Practical Lab 1 (VS Code/Git/GitHub), Practical Session 1, achievement summary
> - `oracle-jfo/`: lessons 1-1 to 1-4
> - `exercises/HelloWorld/`: Oracle starter project (NetBeans layout; the code is in `src/HelloWorld.java`)
> - `my-work/`: `HelloWorld.java`, `AboutMe.java` (my Week 1 programs)

---

## Learning outcomes

By the end of this unit I should be able to:

1. **Explain** how procedural programming differs from object-oriented programming (OOP), using a real-world analogy.
2. **Classify** the syntax elements of a Java program: class, main method, statements, comments, identifiers.
3. **Compile and run** a Java program on my own, both from the terminal and in an IDE.
4. **Compare** the roles of the JVM, JRE and JDK, and explain why Java is platform-independent.
5. Explain where Java came from, and name the four Java product groups.
6. Use Git and GitHub to save and publish my code.

---

## 1. What Java is and why it matters

Java is one of the most widely used programming languages in the world.

| Fact | Why it matters |
|------|----------------|
| M-Pesa, banks (Equity, KCB), Safaricom, Google, Netflix and Amazon use Java | These are real jobs. Java is used for critical systems |
| Android apps are built with Java (and Kotlin, which runs on the same JVM) | It runs on the phones in your pocket |
| Java is consistently a top-3 most in-demand skill | It's good for your career |
| **"Write Once, Run Anywhere"** | The same program runs on Windows, macOS, Linux and phones without changes |

### A brief history (JFo 1-2)

| Year | Event |
|------|-------|
| 1991 | At Sun Microsystems, the **Green Team** led by **James Gosling** (the "father of Java") builds a language for consumer devices such as TVs and set-top boxes. It is first called **Oak** |
| — | The device market doesn't take off, so the team pivots to the new **World Wide Web** (small in-browser programs called *applets*) |
| 1995 | Java is announced, and **Netscape** builds Java into its browser |
| 1996 | **JDK 1.0** released |
| 2010 | **Oracle** acquires Sun Microsystems |
| 2014 | Java 8: lambdas and streams (a big modern update) |
| 2018 → | A new release every 6 months. **LTS** (Long-Term Support) versions: 8, 11, 17, 21, 25 |

The mascot is **Duke** 🟥⚫.

### The four Java product groups

| Edition | Used for |
|---------|----------|
| **Java SE** (Standard Edition) | Desktop and general applications. **This course uses Java SE** |
| **Jakarta EE** (formerly Java EE, Enterprise Edition) | Large server and web applications (banking back-ends, e-commerce) |
| **Java ME** (Micro Edition) | Small devices: set-top boxes, Raspberry Pi, older feature phones |
| **Java Card** | Smart cards and SIM cards (identity, payments, security) |

---

## 2. Programming paradigms: procedural vs object-oriented

A **programming paradigm** is a *style* of organising a program. Think of building a house brick by brick versus putting it together from ready-made modules.

| Paradigm | Focuses on | Analogy |
|----------|-----------|---------|
| **Procedural** | *Actions*: what the program **does** | A **recipe**. The ingredients (data) are separate from the steps (functions) |
| **Object-oriented** | *Things*: what the program is **about** | A **car**. It has data (colour, speed, fuel) **and** behaviours (`start()`, `brake()`) built in |

### 2.1 Procedural version

Data lives in separate variables. Standalone methods receive the data as parameters.

```java
// Procedural approach: data and methods are separate.
public class RectangleProcedural {

    // A method that calculates area from two values passed in.
    public static double calculateArea(double length, double width) {
        return length * width;
    }

    public static double calculatePerimeter(double length, double width) {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        double length = 5.0;          // data lives in main's variables
        double width = 3.0;

        double area = calculateArea(length, width);           // pass the data in
        double perimeter = calculatePerimeter(length, width);

        System.out.println("Procedural Approach:");
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}
```
Output:
```
Procedural Approach:
Area: 15.0
Perimeter: 16.0
```

### 2.2 Object-oriented version

The data (**fields**) and the methods that use it are bundled together inside a **class**. You create **objects** from the class with `new`.

```java
// OOP approach: data and behaviour bundled in one class.
public class RectangleOOP {

    // Fields (attributes). private = hidden from outside code (encapsulation).
    private double length;
    private double width;

    // Constructor: runs when an object is created with 'new'.
    public RectangleOOP(double length, double width) {
        this.length = length;   // this.length = the object's field
        this.width = width;     // width       = the parameter
    }

    // Methods (behaviours). They use the object's own fields, so no parameters are needed.
    public double getArea()      { return length * width; }
    public double getPerimeter() { return 2 * (length + width); }

    public static void main(String[] args) {
        RectangleOOP rect = new RectangleOOP(5.0, 3.0);  // create an object

        System.out.println("OOP Approach:");
        System.out.println("Area: " + rect.getArea());           // ask the object
        System.out.println("Perimeter: " + rect.getPerimeter());
    }
}
```
Output:
```
OOP Approach:
Area: 15.0
Perimeter: 16.0
```

**Same answer, different organisation.** To add a colour to the rectangle in OOP, you add one field and one getter to the class. In the procedural version you would have to change every function that handles rectangles.

### 2.3 Comparison

| Aspect | Procedural | Object-oriented |
|--------|-----------|-----------------|
| Basic unit | Function | Object |
| Where data lives | Separate variables, passed around | Inside objects, as `private` fields |
| Data protection | Often open to any code, so bugs creep in | Hidden; reached only through methods |
| Problem-solving style | Top-down: break the task into steps | Bottom-up: identify the *things* in the problem |
| Reuse | By calling functions | By inheritance and composition |
| Growing / maintaining | Harder as the program grows | Easier: changes stay inside one class |
| Examples | C, Pascal, FORTRAN | **Java**, C++, C#, Python |

**Problems with procedural code as it grows:** data is exposed, one change ripples through many functions, and it models the real world poorly.

### 2.4 The four pillars of OOP (preview; each gets its own unit later)

| Pillar | Meaning | Car analogy |
|--------|---------|-------------|
| **Encapsulation** | Bundle data and methods together, and hide the internals | The engine is under the hood; you use the pedals and steering wheel |
| **Inheritance** | Build new classes from existing ones | A sports car *is a* car, plus extras |
| **Polymorphism** | One interface, many implementations | "Start" works on a car, a motorbike or a computer |
| **Abstraction** | Show only the essentials and hide the complexity | You drive without knowing how fuel injection works |

**Why fintech (M-Pesa) uses OOP:** transactions, accounts and agents are natural *objects*. Each one has its own data (amount, balance, location) and its own behaviour. Encapsulation protects sensitive data such as balances.

---

## 3. Anatomy of a Java program

```java
// Single-line comment: the compiler ignores it.

/*
 * Multi-line comment:
 * for longer explanations.
 */

/**
 * Javadoc comment: used to generate HTML documentation.
 * @author Ian
 */
public class HelloWorld {                        // ① class declaration

    public static void main(String[] args) {     // ② main method = entry point
        System.out.println("Hello, World!");     // ③ statement, ends with ;
        System.out.println("I am learning Java at Riara");
    }                                            // closes main
}                                                // closes the class
```

### 3.1 Class
A **class** is a blueprint for objects. It holds **fields** (data) and **methods** (behaviour). Every Java program lives inside at least one class.

```java
accessModifier class ClassName {
    // fields
    // methods
}
```

**Rules for class names:**
1. A `public` class must be in a file with **exactly the same name**: `HelloWorld` → `HelloWorld.java` (case matters!)
2. Use **PascalCase**: `StudentRecord`, `BankAccount`
3. No spaces, no special characters, and no keywords (`class`, `public`, …)

### 3.2 The `main` method, word by word

```java
public static void main(String[] args)
```

| Word | Meaning | Why it's needed |
|------|---------|-----------------|
| `public` | Accessible from anywhere | The JVM calls it from outside the class |
| `static` | Belongs to the class, not to an object | The JVM calls it **before any objects exist** |
| `void` | Returns nothing | `main` doesn't give a value back |
| `main` | The method's name | The JVM looks for exactly this name |
| `String[] args` | An array of text values | Holds any **command-line arguments** |

Command-line arguments in action:

```java
public class MainDemo {
    public static void main(String[] args) {
        System.out.println("Program started!");
        if (args.length > 0) {
            System.out.println("Arguments received:");
            for (String arg : args) {
                System.out.println(" - " + arg);
            }
        } else {
            System.out.println("No arguments provided.");
        }
        System.out.println("Program ended.");
    }
}
```
Run with `java MainDemo hello world`:
```
Program started!
Arguments received:
 - hello
 - world
Program ended.
```

### 3.3 Statements
A **statement** is one complete instruction. **Every statement ends with `;`**.

| Type | Example | Purpose |
|------|---------|---------|
| Declaration | `int age;` | Creates a variable |
| Assignment | `age = 20;` | Stores a value |
| Declaration + initialisation | `String name = "Alice";` | Both at once |
| Method call | `System.out.println("Hi");` | Runs a method |
| Control flow | `if (age > 18) { ... }` | Makes a decision (Unit 05) |
| Loop | `for (int i = 0; i < 5; i++) { ... }` | Repeats code (Unit 06) |

`if`, `for` and other statements followed by a `{ }` block don't need a `;` after the closing brace.

### 3.4 Comments

| Type | Syntax | Use |
|------|--------|-----|
| Single-line | `// ...` | Short notes |
| Multi-line | `/* ... */` | Longer explanations |
| Javadoc | `/** ... */` | Documents classes and methods (`@author`, `@param`, `@return`) |

```java
/**
 * Adds two numbers.
 * @param a the first number
 * @param b the second number
 * @return the sum of a and b
 */
public static int add(int a, int b) {
    return a + b;
}
```

**Good comment habits:** explain *why*, not *what* (the code already shows what). Keep comments up to date. Don't comment every line; choose clear names instead.

### 3.5 Identifiers and naming conventions
An **identifier** is any name you choose: for a class, method, variable or package.

**Rules (the compiler enforces these):**
1. Starts with a letter, `_` or `$`, **never a digit**
2. Letters, digits, `_` and `$` only: no spaces, no hyphens
3. Not a keyword (`class`, `int`, `public`, `static`, …)
4. **Case-sensitive**: `age` and `Age` are different

| Valid | Invalid | Why invalid |
|-------|---------|-------------|
| `studentName` | `2ndStudent` | starts with a digit |
| `_count` | `my-variable` | hyphen |
| `$price` | `class` | keyword |
| `Age` | `student name` | space |

**Conventions (style everyone follows):**

| Element | Convention | Example |
|---------|-----------|---------|
| Class | PascalCase | `StudentRecord` |
| Method | camelCase | `calculateArea()` |
| Variable | camelCase | `studentName` |
| Constant | UPPER_SNAKE_CASE | `MAX_VALUE` |
| Package | lowercase | `com.example` |

### 3.6 A first look at variables (covered properly in Unit 03)

```java
public class SyntaxExplorer {
    public static void main(String[] args) {
        int age = 20;              // whole number
        double height = 1.75;      // decimal number
        char grade = 'A';          // one character, in SINGLE quotes
        boolean isStudent = true;  // true or false
        String name = "Alice";     // text, in DOUBLE quotes (a reference type)

        System.out.println("Name: " + name);    // + joins text and values
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Grade: " + grade);
        System.out.println("Is Student: " + isStudent);
    }
}
```
Output:
```
Name: Alice
Age: 20
Height: 1.75
Grade: A
Is Student: true
```

---

## 4. From source code to running program

### 4.1 Why Java needs a compiler, and why it's different (JFo 1-3)

- A computer only understands **machine code** (binary 1s and 0s), and machine code differs between platforms.
- Most languages (C, for example) are compiled **once per platform**. The same C code needs a Windows compiler and linker to make a Windows `.exe`, and a Linux one to make a Linux executable. Each executable runs only on its own platform.
- **Java compiles once, to bytecode.** The `javac` compiler turns `.java` source into `.class` **bytecode**. Bytecode isn't machine code for any real CPU. Each platform has its own **JVM**, which translates the same bytecode for its machine.

```
 You write            JDK compiles             JRE / JVM runs
HelloWorld.java  ──javac──►  HelloWorld.class  ──java──►  Hello, World!
 (source code)                 (bytecode)
       ▲                                         ▲
   written in an IDE                       the same .class runs on
                                           Windows, macOS and Linux JVMs
```

Java is both **compiled** (source → bytecode) **and interpreted / JIT-compiled** (the JVM turns bytecode into machine code as it runs).

### 4.2 Compile and run from the terminal

```bash
cd path/to/folder
javac HelloWorld.java     # compile: creates HelloWorld.class
java HelloWorld           # run: give the CLASS name, no .java and no .class
```

Shortcut (Java 11+): `java HelloWorld.java` compiles and runs a single file in one step without writing a `.class` file.

Check your installation:
```bash
java -version      # e.g. openjdk version "25" ... Temurin
javac -version     # e.g. javac 25
```

### 4.3 Compile and run in an IDE
An **IDE** (Integrated Development Environment) is an editor, compiler, debugger and project manager in one. Examples: **VS Code** (with *Extension Pack for Java*), **NetBeans**, **Eclipse**, IntelliJ, BlueJ, Greenfoot.
- VS Code: open the `.java` file and click **Run ▶**. Output appears in the terminal panel.
- NetBeans/Eclipse: create a Java project, then add the starter `.java` file to it (JFo 1-4 Part 1), or create a new main class (Part 2). Setup guides: `../00-Course-Info/oracle-jfo/0-5 …Eclipse.pdf` and `0-6 …NetBeans.pdf`.

### 4.4 Common compile errors

| Error message | Cause | Fix |
|---------------|-------|-----|
| `class HelloWorld is public, should be declared in a file named HelloWorld.java` | File name ≠ class name | Rename the file or the class so they match exactly |
| `';' expected` | Missing semicolon | Add `;` at the end of the statement |
| `cannot find symbol` | Misspelt or undeclared name (e.g. `system` instead of `System`) | Check spelling **and case** |
| `illegal start of expression` | Syntax error, often a missing `}` or `)` | Check that brackets come in pairs |
| `reached end of file while parsing` | Missing closing `}` | Add the missing brace |
| `java: command not found` / `'javac' is not recognized` | JDK not installed, or PATH not set | Reinstall the JDK with **"Set JAVA_HOME"** ticked, then restart the terminal |
| `Class names … are only accepted if annotation processing is explicitly requested` | You typed `javac HelloWorld` without `.java` | Use `javac HelloWorld.java` |

---

## 5. JVM, JRE and JDK

```
┌─────────────────── JDK (Java Development Kit) ───────────────────┐
│  dev tools: javac (compiler), java, javadoc, jar, jdb (debugger) │
│  ┌────────────── JRE (Java Runtime Environment) ──────────────┐  │
│  │  core libraries: java.lang, java.util, java.io, ...         │  │
│  │  ┌──────────── JVM (Java Virtual Machine) ─────────────┐   │  │
│  │  │  loads, verifies and runs bytecode; manages memory  │   │  │
│  │  │  (garbage collection); provides security            │   │  │
│  │  └─────────────────────────────────────────────────────┘   │  │
│  └─────────────────────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────────────────────┘
                         JDK ⊃ JRE ⊃ JVM
```

| | JVM | JRE | JDK |
|-|-----|-----|-----|
| **Full name** | Java Virtual Machine | Java Runtime Environment | Java Development Kit |
| **Job** | Execute bytecode | *Run* Java applications | *Develop* Java applications |
| **Contains** | Bytecode interpreter / JIT compiler, garbage collector | JVM + class libraries | JRE + compiler + tools |
| **Who needs it** | Everything that runs Java | End users | **Developers (me)** |
| **Key tools** | — | `java` | `javac`, `java`, `javadoc`, `jar`, `jdb` |
| **Car analogy** | The engine | The car (engine + fuel) | The car + a mechanic's tools |
| **DVD analogy** | — | A DVD player (can only play) | Player + burner + editing software |

**The JVM is like a UN translator.** The speaker (your program) speaks one language (bytecode). Each country (operating system) has its own translator (JVM) who converts it into the local language (machine code). The JVM is platform-*specific*, which is exactly what makes the bytecode platform-*independent*.

**What the JVM does:** ① load `.class` files → ② verify the bytecode is safe → ③ execute it (interpret or JIT-compile) → ④ manage memory (garbage collection) → ⑤ enforce security.

### Practical: asking Java about itself

```java
public class JavaInfo {
    public static void main(String[] args) {
        String version  = System.getProperty("java.version");  // e.g. 25
        String javaHome = System.getProperty("java.home");     // install folder
        String vendor   = System.getProperty("java.vendor");   // e.g. Eclipse Adoptium
        String osName   = System.getProperty("os.name");       // e.g. Windows 11

        System.out.println("=== Java Environment Info ===");
        System.out.println("Java Version: " + version);
        System.out.println("Java Home: " + javaHome);
        System.out.println("Java Vendor: " + vendor);
        System.out.println("Operating System: " + osName);
    }
}
```

---

## 6. Setting up the environment (Practical Lab 1)

| Tool | What it's for | Get it | Check it works |
|------|---------------|---------|----------------|
| **JDK** (LTS version, e.g. Temurin) | Compile and run Java | adoptium.net. Tick **"Set JAVA_HOME"** | `java -version`, `javac -version` |
| **VS Code** + *Extension Pack for Java* | Editor / IDE | code.visualstudio.com | Run a `.java` file |
| **Git** | Track changes to code | git-scm.com | `git --version` |
| **GitHub** | Store code online (your portfolio) | github.com | Visit `github.com/<username>` |

One-time Git setup. Use the **same email as your GitHub account**:
```bash
git config --global user.name "Your Full Name"
git config --global user.email "you@example.com"
git config --list            # check the settings
```

---

## 7. Git and GitHub workflow

```
working folder ──git add──► staging area ──git commit──► local repo ──git push──► GitHub
   (edit files)            (choose changes)            (saved snapshot)          (online copy)
```

```bash
git init                                  # start tracking a folder (once)
git add .                                 # stage all changes
git commit -m "Week 1: Java basics"       # save a snapshot with a message
git remote add origin https://github.com/<username>/<repo>.git   # link to GitHub (once)
git branch -M main
git push -u origin main                   # upload (later just: git push)
git status                                # what has changed?
git log --oneline                         # history of commits
```

In VS Code: **Source Control** panel → **+** to stage → type a message → **✓ Commit** → **Sync Changes** to push.

- **`.gitignore`** lists files Git should skip, such as `*.class`, `.vscode/` and `*.log`.
- If a push says *Authentication failed*, use a **Personal Access Token** instead of your password.
- Write commit messages that say what changed: `Week 2: add calculator program`.
- **Push every week.** Your GitHub is your portfolio, and employers look at it.

---

## 8. Exercises

| # | Task | Where |
|---|------|-------|
| 1 | Hello World with your own name, university and date | `my-work/HelloWorld.java` ✅ |
| 2 | About Me program (several `println` lines) | `my-work/AboutMe.java` ✅ |
| 3 | `SyntaxExplorer.java`: run it, then count its single-line and multi-line comments, name its class and main method, and list three data types it uses | §3.6 above |
| 4 | `RectangleProcedural.java` and `RectangleOOP.java`: run both, then write a paragraph comparing them | §2 above |
| 5 | `JavaInfo.java`: print your Java version, home, vendor and OS | §5 above |
| 6 | JFo practice Part 1: create a project in an IDE and add the existing starter file | `exercises/HelloWorld/src/HelloWorld.java` |
| 7 | JFo practice Part 3, **break things on purpose**: change the message; change `System` → `system`; delete a `;`; rename the class without renaming the file. Note each error message | any HelloWorld |
| 8 | Push everything to GitHub | — |

**Run the exercises:**
```bash
java 01-Introduction-to-Java/my-work/AboutMe.java
java 01-Introduction-to-Java/exercises/HelloWorld/src/HelloWorld.java
```

---

## 9. Common mistakes

| Mistake | Fix |
|---------|-----|
| Class `Hello` saved in `HelloWorld.java` | A public class name must match its file name exactly |
| `system.out.println` | Java is **case-sensitive**: `System` |
| `"A"` vs `'A'` | Double quotes make a `String`; single quotes make a `char` |
| Forgetting `;` | Every statement ends with `;` |
| Mismatched `{ }` | Indent consistently so each `}` lines up with its opening line |
| `java HelloWorld.class` | Run the **class name**: `java HelloWorld` |
| Editing the file but running the old `.class` | Recompile after every change (or use `java File.java`) |

---

## 10. Practice questions

1. Explain procedural vs object-oriented programming using your own analogy.
2. Name the four pillars of OOP and give a real-world example of each.
3. In the code below, identify the class, the main method, the comment and the statement.
   ```java
   // My first program
   public class Test {
       public static void main(String[] args) {
           System.out.println("Hello");
       }
   }
   ```
4. Write out the full signature of the main method and explain each word.
5. Which command compiles a Java program, and which runs it? What file does each produce or use?
6. What is bytecode?
7. Explain the difference between the JVM, JRE and JDK. Which one do you need to *write* programs?
8. Why can Java run on any platform, while a C program can't?
9. Why must `HelloWorld` be saved in `HelloWorld.java`?
10. Which of these identifiers are invalid, and why? `total$`, `3rdPlace`, `first-name`, `_temp`, `public`, `MyClass`
11. Name the four Java product groups. Which one does this course use? Which one is used in SIM cards?
12. Who led the team that created Java, and what was the language first called?
13. In `RectangleOOP`, why are `length` and `width` `private`? What does `this.length = length;` do?
14. Put these in order and explain each: `git push`, `git add`, `git commit`.
15. What is an IDE? Name three.

<details>
<summary><b>Answers</b> (try first!)</summary>

1. Procedural code is like a **recipe**: the ingredients (data) are separate from the steps (functions), and you follow the steps in order. OOP is like a **car**: each object carries its own data (colour, speed) and its own behaviours (`start()`, `brake()`).
2. **Encapsulation**: a car's engine is hidden under the hood. **Inheritance**: a sports car is a kind of car. **Polymorphism**: a "start" button works on many devices. **Abstraction**: you drive without knowing how the engine works.
3. Class: `public class Test`. Main method: `public static void main(String[] args)`. Comment: `// My first program`. Statement: `System.out.println("Hello");`.
4. `public static void main(String[] args)`. `public`: the JVM can call it. `static`: no object is needed. `void`: it returns nothing. `main`: the name the JVM looks for. `String[] args`: command-line arguments.
5. `javac HelloWorld.java` compiles `.java` source into `HelloWorld.class` bytecode. `java HelloWorld` runs that `.class` on the JVM.
6. The platform-independent intermediate code (`.class` files) that `javac` produces and the JVM runs.
7. **JVM** runs bytecode. **JRE** = JVM + libraries, enough to *run* Java. **JDK** = JRE + compiler and tools, needed to *write* Java. JDK ⊃ JRE ⊃ JVM. You need the **JDK** to write programs.
8. Java compiles to bytecode rather than machine code, and every platform has its own JVM that runs the same bytecode. C compiles straight to machine code for one platform, so it needs a separate build for each one.
9. A `public` class must be in a file with exactly the same name (case-sensitive), or it won't compile.
10. Invalid: `3rdPlace` (starts with a digit), `first-name` (hyphen) and `public` (keyword). Valid: `total$`, `_temp`, `MyClass`.
11. Java SE, Jakarta EE (formerly Java EE), Java ME and Java Card. This course uses **Java SE**. SIM cards use **Java Card**.
12. **James Gosling** and the Green Team at Sun Microsystems. The language was first called **Oak**.
13. `private` hides them from outside code (encapsulation), so they can only be changed through the class's own methods. `this.length = length;` copies the parameter `length` into the object's field `length`; `this.` tells the field apart from the parameter with the same name.
14. `git add` stages changes → `git commit` saves a snapshot locally → `git push` uploads the commits to GitHub.
15. An Integrated Development Environment: an editor, compiler, debugger and project manager in one. Examples: VS Code, NetBeans, Eclipse, IntelliJ, BlueJ.
</details>

---

## 11. Summary

- Java is a widely used, platform-independent OOP language. It was created by James Gosling at Sun (first called Oak) and is now owned by Oracle. This course uses **Java SE**.
- **Procedural** code keeps data and functions separate. **OOP** bundles them into objects built from classes, with private fields, constructors and methods.
- Every program lives in a **class** and starts at **`public static void main(String[] args)`**. Statements end with `;`. Comments are `//`, `/* */` and `/** */`.
- A public class name must match its file name. Classes use PascalCase; methods and variables use camelCase.
- `javac` compiles `.java` into `.class` bytecode, and `java` runs it on the JVM. **JDK ⊃ JRE ⊃ JVM**.
- Write once, run anywhere: one bytecode file runs on any platform's JVM.
- Git workflow: **add → commit → push**. Use `.gitignore` for `.class` files.
