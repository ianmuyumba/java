# My Java Course

**Ian · Riara University · RBCS 7121 Object-Oriented Programming**
Plus Oracle Academy **Java Foundations** (NetAcad), which I'm doing alongside it.

All my Java material is in one place, sorted by topic rather than by week.
Track what I've finished in **[PROGRESS.md](PROGRESS.md)**.

## Topics

| # | Folder | Class weeks (ODEL) | Oracle JFo sections |
|---|--------|--------------------|---------------------|
| 00 | [Course Info](00-Course-Info/) | Course outline | 0 (course map, objectives, final project, software) |
| 01 | [Introduction to Java](01-Introduction-to-Java/) | Week 1 | 1 |
| 02 | [Software Development & OOP Basics](02-Software-Development-and-OOP-Basics/) | | 2 |
| 03 | [Variables, Data Types & Operators](03-Variables-Data-Types-and-Operators/) | Week 2 | 3 |
| 04 | [Methods & Library Classes](04-Methods-and-Library-Classes/) | | 4 |
| 05 | [Conditionals](05-Conditionals/) | Week 3 | 5 |
| 06 | [Loops](06-Loops/) | Week 4 | 6 |
| 07 | [Arrays & ArrayLists](07-Arrays-and-ArrayLists/) | Week 5 | 8-1, 8-2 |
| 08 | [Classes & Objects](08-Classes-and-Objects/) | Week 6 | 7 |
| 09 | [Inheritance & Polymorphism](09-Inheritance-and-Polymorphism/) | Week 7 | |
| 10 | [Exceptions & Debugging](10-Exceptions-and-Debugging/) | | 8-3, 8-4 |
| 11 | [JavaFX](11-JavaFX/) | | 9 |

Still to come in the class outline: Abstraction & Interfaces, the Collections Framework, File I/O and the final project. Each gets its own folder when its material arrives.

## Inside each topic folder

```
NN-Topic/
  NOTES.md        my study notes for the unit: explanations, code examples, practice questions
  class-notes/    PDFs from the Riara online platform (ODEL), named by week
  oracle-jfo/     Oracle Academy Java Foundations PDFs, named by lesson (e.g. 3-1)
  exercises/      Oracle starter code, unzipped
  my-work/        programs I wrote myself
```

## Running the code

The JDK is installed, so a single-file program can be run directly:

```
java 03-Variables-Data-Types-and-Operators/exercises/Casting01/Casting01.java
```

Or compile first, then run:

```
cd 06-Loops/my-work
javac BodaBodaFare.java     # makes BodaBodaFare.class (bytecode)
java BodaBodaFare           # the JVM runs it
```

`.class` files are ignored by git (see `.gitignore`).

## Note
`02-Software-Development-and-OOP-Basics/videos/` holds the Spiral Model demo videos. They stay on this computer only: `*.mp4` is gitignored to keep the repo small.
