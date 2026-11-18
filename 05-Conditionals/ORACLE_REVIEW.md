# Oracle Section 5 · Lesson and practice alignment

[Lesson](README.md) · [Practice](PRACTICE.md) · [Audit](../ORACLE_AUDIT.md) · [Exam preparation](../EXAM_PREP.md)

The live course lists 5-1 Boolean Expressions and if/else Constructs, 5-2 Understanding Conditional Execution, 5-3 switch Statement, and a section practice sheet. The missing 5-2 and 5-3 slides and practice sheet are now in the [source library](sources/oracle-jfo/README.md), along with the expanded 5-2 Student Guide.

## Match the exact requirements

| Task | Required behaviour | Boundary checks |
|---|---|---|
| WatchMovie | Interested when price is **at least 12** AND rating is **5** | 11.99/5, 12/5, 12/4 |
| TernaryOperator | Express the supplied either/or selection with `?:` | Both outcomes; preserve the selected value's type |
| ComputeFare | Literal slide rule: age < 11 costs 3; age > 11 and < 65 costs 5; otherwise 3 | 10, **11**, 12, 64, 65 |
| SwitchEx1/2 | Trace cases, breaks and the default path | Every case, an unmatched selector, deliberate omitted break |
| ColorRange | Choose a colour from a wavelength in nanometres | Every lower and upper endpoint |
| TrafficLightChecker | Use `if` to cycle 1 → Green, 2 → Yellow, 3 → Red | 0, 1, 2, 3, 4 |
| TrafficLightSwitch | Implement the same mapping with `switch` | Same cases as the `if` version |

The movie price rule may seem unusual: practise the stated condition before inventing a different requirement. The fare wording leaves **age 11 in the otherwise branch**, so its literal result is 3. If an instructor intends ages 11–64 to pay 5, ask for clarification and change the contract and tests together. Our worked example rejects negative ages as an additional input-validation rule.

## Half-open wavelength ranges

| Colour | Included values |
|---|---|
| Violet | 380 ≤ wavelength < 450 |
| Blue | 450 ≤ wavelength < 495 |
| Green | 495 ≤ wavelength < 570 |
| Yellow | 570 ≤ wavelength < 590 |
| Orange | 590 ≤ wavelength < 620 |
| Red | 620 ≤ wavelength < 750 |

**750 is outside the specified spectrum.** Do not include both endpoints of adjacent intervals: 450 must select Blue once. Test a value immediately below, exactly at, and immediately above each cutoff. Our worked implementation also treats non-finite doubles as outside the spectrum.

## Read source examples critically

- Use `"color".equals(tvType)` for textual content. The slides' nested-TV example uses `==`, which compares references.
- The slide fragment `int grade >= 88 && numberDaysAbsent == 0` is not a valid declaration. Use a Boolean expression in `if (...)` or assign it to a `boolean` variable.
- The conditional operator's two alternatives need compatible typing; they need not always have identical types. For example, `true ? 1 : 2.5` has a numeric result of type `double`.
- Parenthesise a conditional expression inside string concatenation: `"Goals: " + (count == 1 ? "one" : "many")`.
- An `else` binds to the nearest unmatched `if`. Indentation does not change the parse.
- In a traditional colon-style switch, execution continues into subsequent cases until a `break`, return or end of switch. The default label is not required to be last.

The `switch` selector rules in the main lesson describe the traditional forms used by Oracle Foundations. Reference-type pattern matching and preview language features are outside this course baseline.

## Attempt before checking

The original starters are in `exercises/`; some are intentionally unfinished. `ComputeFare.java`, for example, uses `Scanner` without importing it. Adding the import is part of making the starter compile, followed by completing and testing the calculation.

[DecisionRules.java](examples/DecisionRules.java) is a separate worked solution for the key decision rules. Run from the repository root:

```powershell
java 05-Conditionals/examples/DecisionRules.java
```

Its normal output is:

```text
450.0 nm: Blue
750.0 nm: Outside spectrum
Light 1: Green
Fare at 11: 3
Movie at 12 with rating 5: true
```

Explain each boundary before reading or modifying that solution.
