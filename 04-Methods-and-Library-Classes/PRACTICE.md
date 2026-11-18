# Practice · Methods and Library Classes

[Lesson](README.md) · [Course home](../README.md) · [Progress](../PROGRESS.md)

## Practice ladder

| Stage | Task | Evidence to keep |
|---|---|---|
| 1 · Trace a call | Explain a primitive argument and an array argument passed to a method. | Prediction and a short explanation |
| 2 · Implement | Extract tax and discount calculations into returning methods. | Working code and expected output |
| 3 · Extend | Build a receipt from small methods and test calculations without console input. | Test cases and a design explanation |

## Working routine

1. Write the expected behaviour before coding.
2. Attempt the exercise before reading a worked solution.
3. Test ordinary input, a boundary and an invalid case where applicable.
4. Save your attempt under `my-work/` with a descriptive class name.
5. Record what failed and why the correction works.

Existing `exercises/` files are supplied practice material and may intentionally be incomplete or faulty. Their presence does not indicate completion. `my-work/` contains your existing work; `examples/` contains worked demonstrations.

## Existing Java files

| File | Location |
|---|---|
| [AddImport.java](exercises/AddImport/AddImport.java) | `exercises` |
| [Calculator2.java](exercises/Calculator2/Calculator2.java) | `exercises` |
| [Calculator3.java](exercises/Calculator3/Calculator3.java) | `exercises` |
| [Calculator4.java](exercises/Calculator4/Calculator4.java) | `exercises` |
| [CalculatorTest2.java](exercises/CalculatorTest2/CalculatorTest2.java) | `exercises` |
| [CalculatorTest3.java](exercises/CalculatorTest3/CalculatorTest3.java) | `exercises` |
| [CalculatorTest4.java](exercises/CalculatorTest4/CalculatorTest4.java) | `exercises` |
| [ComputeBMI.java](exercises/ComputeBMI/ComputeBMI.java) | `exercises` |
| [ComputeMethods.java](exercises/ComputeMethods/ComputeMethods.java) | `exercises` |
| [FlipCoin.java](exercises/FlipCoin/FlipCoin.java) | `exercises` |
| [NameMaker.java](exercises/NameMaker/NameMaker.java) | `exercises` |
| [ProcessName.java](exercises/ProcessName/ProcessName.java) | `exercises` |
| [RockPaperScissor.java](exercises/RockPaperScissor/RockPaperScissor.java) | `exercises` |
| [TestClass.java](exercises/TestClass/TestClass.java) | `exercises` |
| [Tip01.java](exercises/Tip01/Tip01.java) | `exercises` |

## Source exercises

[Browse the class and Oracle source materials](sources/README.md). [Liang Ch. 4](../00-Course-Info/sources/textbook/chapter-4-mathematical-functions-characters-and-strings.md) · [Liang Ch. 6](../00-Course-Info/sources/textbook/chapter-6-methods.md)

## Completion check

- [ ] I can explain the result without reading the solution.
- [ ] I tested relevant boundaries and failure cases.
- [ ] My class name matches its filename.
- [ ] I recorded the run command and expected output.

## Restored companion and source mismatch

`CalculatorTest4` requires `Calculator4`. Compile both files together into an isolated output directory. Complete its names and table-total task; changing the return contract requires changes to both caller and calculator. Oracle’s live Section 4 ShoppingCart download currently matches the exception task in Unit 10, rather than a separate String exercise. See [the audit](../ORACLE_AUDIT.md).
