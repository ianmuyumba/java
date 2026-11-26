# Java OOP: Practical Sessions (RBCS 7121)

One folder per weekly practical session. Each folder has:

| File | What's in it |
|---|---|
| `README.md` | The tasks: objective, steps, expected output, answers to the questions |
| `*.java` | The finished solution for each task |
| `NOTES.md` | Short explainer on the week's topic, with examples (Oracle Java Foundations + general Java) |

## Weeks

| Week | Topic | Folder |
|---|---|---|
| 1 | Introduction to Java and OOP | [week-01-intro-to-java](week-01-intro-to-java/) |
| 2 | Variables, data types and operators | [week-02-variables-and-operators](week-02-variables-and-operators/) |
| 3 | Conditionals | [week-03-conditionals](week-03-conditionals/) |
| 4 | Loops | [week-04-loops](week-04-loops/) |
| 5 | Arrays and ArrayLists | [week-05-arrays-and-arraylists](week-05-arrays-and-arraylists/) |
| 6 | Classes and objects | [week-06-classes-and-objects](week-06-classes-and-objects/) |
| 7 | Inheritance and method overriding | coming next |
| 8 | Polymorphism and abstract classes | |
| 9 | Interfaces and exception handling | |
| 10 | Collections framework and file I/O | |

## Running a solution

Needs JDK 17+. From inside a week folder:

```bash
java HelloWorld.java                  # single-file program
javac -d ../build *.java && java -cp ../build BookTest   # programs split over several files
```
