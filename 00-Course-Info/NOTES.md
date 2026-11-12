# Unit 00 · Course Info

This folder holds the "about the course" documents for both courses I'm taking.

> **Files in this folder**
> - `class-notes/RBCS 7121 Course Outline - Object-Oriented Programming.pdf`: Riara University course outline
> - `oracle-jfo/0-1 Course Map.pdf`: Oracle Java Foundations pacing guide
> - `oracle-jfo/0-2 Java Foundations Course Objectives.pdf`
> - `oracle-jfo/0-3 Java Foundations Final Project.pdf`
> - `oracle-jfo/0-4 Required Software for Java Courses.pdf`
> - `oracle-jfo/0-5 …Eclipse.pdf`, `0-6 …NetBeans.pdf`: how to create your first project in each IDE

---

## 1. The two courses

| | **RBCS 7121 Object-Oriented Programming** | **Oracle Academy Java Foundations (JFo)** |
|-|-------------------------------------------|-------------------------------------------|
| Where | Riara University, online learning platform (ODEL) | NetAcad / Oracle Academy |
| Material | weekly *Comprehensive Notes*, *Practical Sessions*, *Understanding What You Have Achieved* summaries | lesson slide PDFs + starter-code zips + practice problem sets |
| Assessment | CAT 1 (20%), CAT 2 (20%), final exam (60%) | quizzes, section exams, final project; prepares for the Oracle *Java Foundations* certification (1Z0-811) |
| Language / tools | Java (JDK LTS), VS Code, Git and GitHub | Java SE, NetBeans or Eclipse (any IDE works) |

The two courses overlap heavily, so this repo is organised **by topic**, with both courses' material side by side in each unit.

## 2. How the weeks and sections map onto the units

| Unit | RBCS 7121 week | Oracle JFo section |
|------|----------------|--------------------|
| 01 Introduction to Java | Week 1 | 1 |
| 02 Software Development & OOP Basics | (Week 1 OOP intro) | 2 |
| 03 Variables, Data Types & Operators | Week 2 | 3 |
| 04 Methods & Library Classes | (outline Week 4: methods) | 4 |
| 05 Conditionals | Week 3 | 5 |
| 06 Loops | Week 4 | 6 |
| 07 Arrays & ArrayLists | Week 5 | 8-1, 8-2 |
| 08 Classes & Objects | Week 6 | 7 |
| 09 Inheritance & Polymorphism | Week 7 (Week 8 continues) | — |
| 10 Exceptions & Debugging | (later weeks) | 8-3, 8-4 |
| 11 JavaFX | — | 9 |
| *Coming:* Abstraction & Interfaces, Collections, File I/O, Final Project | later weeks | — |

## 3. Required software (0-4)

| Tool | Notes |
|------|-------|
| **JDK** (LTS: 21 or 25) | Installed: Eclipse Adoptium Temurin 25. Check with `java -version` and `javac -version` |
| **An IDE** | VS Code + *Extension Pack for Java* (used in class), or NetBeans / Eclipse (used in the Oracle guides) |
| **Git + GitHub** | For saving and publishing work (see Unit 01 §7) |
| **JavaFX SDK** | Only needed for Unit 11 (openjfx.io) |

### Opening Oracle starter code (0-5 / 0-6)
The Oracle exercises (already unzipped in each unit's `exercises/` folder) are single `.java` files. Either:
- run them directly: `java 03-Variables-Data-Types-and-Operators/exercises/Variables01/Variables01.java`, or
- **NetBeans:** File → New Project → Java with Ant → Java Application (untick "Create Main Class") → copy the `.java` file into `src/`.
- **Eclipse:** File → New → Java Project → right-click `src` → Import → File System → choose the `.java` file.
- **VS Code:** open the folder and click **Run ▶** above `main`.

## 4. The JFo final project (0-3)

Build an application, game or animation that shows off the foundations. It **must** have:
- **at least 2 classes** besides the test class, **encapsulated**, each with **≥ 2 fields and ≥ 2 methods** (not counting getters and setters)
- **an array or ArrayList**
- **user input at least once, and the program must never crash on bad input** (see Unit 10)
- a short document describing the software

Suggested ideas: an employee database (sort by salary and productivity; fire the above-average-salary, below-average-productivity staff; hire new staff), a calorie-based meal planner, a choose-your-own-adventure text game, or Tic-Tac-Toe. It must be significantly different from the practice problem sets. Plan it with the Spiral Model (Unit 02).

**The RBCS 7121 final project** (from the course outline) is a console-based **library management system**, which will draw on classes, inheritance, collections and file I/O.

## 5. How to study with this repo

1. Read the unit's **NOTES.md** (it merges both courses).
2. Skim the original PDFs in `class-notes/` and `oracle-jfo/` for the details and diagrams.
3. Do the `exercises/` and save your own code in `my-work/`.
4. Answer the practice questions *before* opening the answers.
5. Tick off the topics in **[../PROGRESS.md](../PROGRESS.md)**.
6. Commit and push to GitHub every week.
