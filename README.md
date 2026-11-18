# Java · Learn, practise, build

**Ian Muyumba · Riara University · RBCS 7121 Object-Oriented Programming**
With Oracle Academy Java Foundations and Y. Daniel Liang’s *Introduction to Java Programming*, 10th edition.

[Start learning](01-Introduction-to-Java/README.md) · [Track progress](PROGRESS.md) · [Exercise guide](EXERCISES.md) · [Book chapters](00-Course-Info/sources/textbook/README.md) · [Sources and archive](SOURCES.md)

## Your study path

Every unit opens directly to its lesson on GitHub. Read, trace an example, attempt the practice ladder, then explain the result independently.

| Unit | Topic | Book chapters |
|---|---|---|
| 00 | [Course Info](00-Course-Info/README.md) | 1 |
| 01 | [Introduction to Java](01-Introduction-to-Java/README.md) | 1 |
| 02 | [Software Development and OOP Basics](02-Software-Development-and-OOP-Basics/README.md) | 2, 10 |
| 03 | [Variables Data Types and Operators](03-Variables-Data-Types-and-Operators/README.md) | 2, 4 |
| 04 | [Methods and Library Classes](04-Methods-and-Library-Classes/README.md) | 4, 6 |
| 05 | [Conditionals](05-Conditionals/README.md) | 3 |
| 06 | [Loops](06-Loops/README.md) | 5 |
| 07 | [Arrays and ArrayLists](07-Arrays-and-ArrayLists/README.md) | 7, 8, 11 |
| 08 | [Classes and Objects](08-Classes-and-Objects/README.md) | 9, 10 |
| 09 | [Inheritance and Polymorphism](09-Inheritance-and-Polymorphism/README.md) | 11, 13 |
| 10 | [Exceptions and Debugging](10-Exceptions-and-Debugging/README.md) | 12 |
| 11 | [JavaFX](11-JavaFX/README.md) | 14, 15, 16 |
| 12 | [Abstraction and Interfaces](12-Abstraction-and-Interfaces/README.md) | 13, 12 |
| 13 | [Collections Framework and File IO](13-Collections-Framework-and-File-IO/README.md) | 19, 20, 21, 12, 17 |

**Console-first route:** Units 01–10 → 12 → 13. Study JavaFX in Unit 11 when ready for graphical applications. Folder numbers remain stable so existing code paths are easy to recognise.

## Inside each unit

```text
NN-Topic/
├── README.md       Lesson, examples, checkpoints and book connections
├── PRACTICE.md     Practice ladder and linked Java file index
├── sources/        Indexed Markdown transcriptions of course PDFs
├── examples/       Worked runnable demonstrations, where supplied
├── exercises/      Original supplied practice files, where available
└── my-work/        Your programs and future attempts
```

The textbook lives once in `00-Course-Info/sources/textbook/`, split into chapters. Riara Week 8 is in Unit 09, Week 9 in Unit 12, and Week 10 in Unit 13.

## Run an example

Open a terminal at the repository root:

```powershell
java -version
javac -version
java 01-Introduction-to-Java/my-work/HelloWorld.java
java 12-Abstraction-and-Interfaces/examples/ReceiptDemo.java
```

Single-file source launching requires Java 11 or later. Compile collaborating classes together; see [the exercise guide](EXERCISES.md). JavaFX requires additional SDK/dependency configuration.

## Study with evidence

- **Predict:** write the output before running.
- **Build:** attempt the task in your own code.
- **Test:** cover ordinary input, boundaries and invalid cases.
- **Explain:** describe why the result is correct.
- **Track:** tick [progress](PROGRESS.md) when you can do it independently.

> [!NOTE]
> Source transcriptions can contain extraction artefacts or historical instructions. Start with the edited unit READMEs. Original PDFs and pre-migration notes are preserved outside this repository; see [SOURCES.md](SOURCES.md).
