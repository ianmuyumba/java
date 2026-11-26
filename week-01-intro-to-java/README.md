# Week 1: Introduction to Java and OOP

[Home](../README.md) · [Explainer notes](NOTES.md)

**Learning outcomes:** compare procedural and OOP code, name the parts of a Java program, compile and run a program yourself, and explain the JVM, JRE and JDK.

Run any task from this folder with `java FileName.java`.

---

## Part 0: Lab 1 setup (JDK, VS Code, Git, GitHub)

- [ ] Install a JDK (LTS) from https://adoptium.net and tick **Set JAVA_HOME**
- [ ] Install VS Code and the **Extension Pack for Java**
- [ ] Install Git (default options)
- [ ] Create a GitHub account
- [ ] Configure Git: `git config --global user.name "Your Name"` and `git config --global user.email "you@example.com"`, then check with `git config --list`
- [ ] Sign in to GitHub from VS Code (Accounts icon → *Sign in with GitHub*)
- [ ] Create a `java-course/week1` folder, add `HelloWorld.java`, then commit and push

Check with `java -version`, `javac -version` and `git --version`.

---

## Task 1: Hello World
Write, compile and run a program that prints a greeting and your details.

**Solution:** [HelloWorld.java](HelloWorld.java)

```text
Hello, World!
My name is: Ian Muyumba
I am learning Java in RBCS 7121 Object-Oriented Programming
Today's date is: 2026-11-26
```

## Task 2: Exploring Java syntax elements
Write a program that declares one variable of each basic type and prints them all. Then identify the syntax elements.

**Solution:** [SyntaxExplorer.java](SyntaxExplorer.java)

```text
Name: Alice
Age: 20
Height: 1.75
Grade: A
Is Student: true
```

**Answers** (for the course's original listing):
1. 13 single-line comments (every `// …` line in the original listing).
2. One multi-line comment (`/* … */`).
3. The class is `SyntaxExplorer`.
4. The method is `main`.
5. The data types are `int`, `double`, `char`, `boolean` and `String`.
6. `System.out.println` prints to the console. It is a method call, not a keyword.

## Task 3: Procedural vs OOP (rectangle area)
Calculate a rectangle's area and perimeter twice: once with plain static functions and once with a class.

**Solutions:** [RectangleProcedural.java](RectangleProcedural.java) · [RectangleOOP.java](RectangleOOP.java)

```text
Procedural Approach:        OOP Approach:
Length: 5.0                 Length: 5.0
Width: 3.0                  Width: 3.0
Area: 15.0                  Area: 15.0
Perimeter: 16.0             Perimeter: 16.0
```

**Comparison:**
1. **Procedural:** the data sits in local variables inside `main` and is passed to every function.
2. **OOP:** the data sits in the object's private fields, `length` and `width`.
3. **OOP hides data better.** The fields are `private`, so they can only be reached through methods.
4. **OOP is easier to extend.** To add colour you add one field and a getter, and every method can use it. In the procedural version every function signature would need a new parameter.

## Task 4: JVM, JRE and JDK
Run `java -version` and `javac -version`, then print runtime information from code.

**Solution:** [JavaInfo.java](JavaInfo.java). Your output will differ:

```text
Java Version: 21.0.1
Java Home: C:\Program Files\Java\jdk-21
Operating System: Windows 11
```

**Answers:**
1. `javac` **compiles** `.java` source into `.class` bytecode. `java` **runs** bytecode on the JVM.
2. The **JVM** (Java Virtual Machine) loads, verifies and executes bytecode, turning it into machine instructions.
3. The **JRE** (Java Runtime Environment) is the JVM plus the standard class libraries. It is everything needed to *run* Java.
4. The **JDK** (Java Development Kit) is the JRE plus development tools (`javac`, `jar`, `javadoc`, the debugger), so JDK ⊃ JRE ⊃ JVM.
5. Java runs on any platform because it compiles to platform-neutral **bytecode**, and every OS has its own JVM. This is "write once, run anywhere".

## Task 5: Push to GitHub
- [ ] Stage all files
- [ ] Commit: `Week 1: Java basics and OOP introduction`
- [ ] Push and check that the files appear on GitHub
