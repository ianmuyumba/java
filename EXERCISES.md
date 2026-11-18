# Exercise guide

[Course home](README.md) · [Progress](PROGRESS.md)

## Choose a task

| Location | Purpose | How to use it |
|---|---|---|
| `PRACTICE.md` | Unit task ladder and file index | Start here |
| `exercises/` | Course practice/starter files | Expect deliberate errors or unfinished methods |
| `examples/` | Worked demonstrations | Predict output, run, then modify |
| `my-work/` | Your own programs | Record commands, test cases and explanations |

## Run one exercise at a time

Several exercises reuse class names in the default package. Compiling the entire repository together causes duplicate-class errors. Some exercises depend on companion files in neighbouring folders.

For a self-contained file, run from the repository root:

```powershell
java 03-Variables-Data-Types-and-Operators/my-work/DataTypesDemo.java
```

Compile collaborating files together into an isolated directory:

```powershell
javac -d build/calculator3 04-Methods-and-Library-Classes/exercises/Calculator3/Calculator3.java 04-Methods-and-Library-Classes/exercises/CalculatorTest3/CalculatorTest3.java
java -cp build/calculator3 CalculatorTest3
```

The exception exercise deliberately uses a zero divisor. Predict the failure before running:

```powershell
javac -d build/shopping-cart 10-Exceptions-and-Debugging/exercises/Calculator/Calculator.java 10-Exceptions-and-Debugging/exercises/ShoppingCart/ShoppingCart.java
java -cp build/shopping-cart ShoppingCart
```

A runtime failure can be the exercise's subject. Read the task before changing it.

## Keep an exercise log

Copy this into a README beside your own solution:

```text
Task:
Inputs and valid ranges:
Expected output:
Run command:
Normal case:
Boundary case:
Invalid case:
What I changed after testing:
Why this solution works:
```

For GUI work, include resize, repeated submission and invalid text. For file work, include missing input, empty input and existing output.
