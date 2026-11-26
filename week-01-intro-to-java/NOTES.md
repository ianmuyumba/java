# Week 1 notes: Java, the JDK and OOP

[Tasks](README.md) · Sources: Oracle Java Foundations §1 (history, setup), §2-2 (what a program does) and §2-3 (OOP concepts)

## 1. How a Java program runs
```
HelloWorld.java ──javac──► HelloWorld.class ──java──► JVM ──► your OS / CPU
   (source)               (bytecode, portable)       (one per platform)
```
- **Compile:** `javac HelloWorld.java` creates `HelloWorld.class`.
- **Run:** `java HelloWorld` runs the bytecode.
- **Shortcut** (Java 11+): `java HelloWorld.java` compiles in memory and runs a single file.

| Part | What it is | You need it to… |
|---|---|---|
| **JVM** | The engine that executes bytecode | run (built into the JRE) |
| **JRE** | JVM + standard libraries (`java.lang`, `java.util`, …) | run programs |
| **JDK** | JRE + tools (`javac`, `jar`, `javadoc`, debugger) | write programs |

**Why "write once, run anywhere":** bytecode is the same on every OS, and only the JVM differs.

## 2. Anatomy of a program
```java
// single-line comment
/* multi-line comment */
public class Greeter {                       // class name == file name (Greeter.java)
    public static void main(String[] args) { // entry point: exact signature
        System.out.println("Hi");            // statement: ends with ;
    }                                        // { } mark a block
}
```
| Element | Rule |
|---|---|
| `class` | One `public` class per file, and the name must match the filename (case-sensitive) |
| `main` | `public static void main(String[] args)`, which the JVM calls first |
| Statement | One instruction, ending in `;` |
| Comment | Ignored by the compiler. `/** … */` is a Javadoc comment |
| `println` / `print` | Print with or without a newline afterwards |

Java is **case-sensitive**: `System` ≠ `system`, `Main` ≠ `main`.

## 3. Procedural vs object-oriented
| Procedural | Object-oriented |
|---|---|
| Program = list of functions acting on data | Program = objects that hold data **and** behaviour |
| Data passed around in variables and parameters | Data stored in an object's fields |
| Any code can change the data | Fields are `private`, so changes go through methods (**encapsulation**) |
| A new attribute means changing many functions | A new attribute means one field and one method |

**OOP vocabulary (Oracle §2-3):**
- **Class:** a blueprint, such as `Car`.
- **Object:** one instance built from it: `new Car()`.
- **Properties (fields):** what an object *has*: colour, speed.
- **Behaviours (methods):** what it *does*: `accelerate()`, `brake()`.
- **Encapsulation:** hide the fields, expose methods.

```java
RectangleOOP r = new RectangleOOP(5, 3);  // create an object (instance)
r.getArea();                              // ask the object to do something
```

## 4. Software development process (Oracle §2-1)
1. **Requirements:** what must it do?
2. **Design:** plan the classes and steps (pseudocode).
3. **Implement:** write the code.
4. **Test:** normal, boundary and invalid inputs.
5. **Maintain:** fix bugs and add features.

Repeat in small loops; don't write everything and test only at the end.

## 5. Common errors
| Message | Cause |
|---|---|
| `';' expected` | A statement is missing its semicolon |
| `cannot find symbol` | A misspelt or undeclared name (check upper/lower case) |
| `class X is public, should be declared in a file named X.java` | The filename and class name don't match |
| `java: command not found` | JDK not installed, or not on the PATH |

## 6. Git in four commands
```bash
git add .                     # stage changes
git commit -m "message"       # snapshot them
git push                      # upload to GitHub
git status                    # see what changed
```

## Quick check
- [ ] Can I explain javac vs java?
- [ ] Can I say what JDK ⊃ JRE ⊃ JVM means?
- [ ] Can I name the class, method, statement and comment in a program?
- [ ] Can I give one advantage of OOP over procedural code?
