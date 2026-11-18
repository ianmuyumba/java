# Oracle Academy · Course coverage review

Reviewed on 18 November 2026 against the signed-in **Java Foundations – English** course.

[Course home](README.md) · [Exam preparation](EXAM_PREP.md) · [Starter provenance](00-Course-Info/sources/oracle-starters.json) · [PDF provenance](00-Course-Info/sources/manifest.json)

## What was checked

The live resource lists for Sections 0–9 were inspected and compared with the repository's lesson transcriptions, edited notes and Java exercise inventory. Existing archived slide objectives were checked for alignment. The missing Section 5 slides and practice sheet were downloaded and read. Student Guides were inspected and archived for **5-2, 8-2 and 9-3** to check conditional execution, iterator traversal, and JavaFX resources/events.

This is a lesson-objective and exercise coverage review, not a claim that every currently published Student Guide or every slide revision is archived. Other Student Guides, JavaPuzzleBall activities and demonstration videos remain live course resources. No graded exam questions were used to create the revision material. Course completion percentages were not treated as marks or mastery.

## Findings by section

| Oracle section | Repository units | Finding and update |
|---|---|---|
| 0 · Resources | 00 | Outline, project and software/setup sources already present; keep the live requirements as authority for the class. |
| 1 · Introduction | 01 | Goals, history, editions, JDK/runtime and compilation covered; HelloWorld starter present. |
| 2 · Software development | 02 | Spiral model, tracing, comments and OOP covered; restored missing ProblemSet2_1 starter. JavaPuzzleBall/video activities remain online. |
| 3 · Data types | 03 | Variables, numeric operations, text, conversion, input, tokens and file-Scanner introduction covered; supplied Java starters already present. Added a clearer delimiter exercise and corrected misleading nextLine wording. |
| 4 · Methods/libraries | 04 | Concepts covered but labels were offset by a separately numbered API tutorial; corrected to String 4-3, Random 4-4, Math 4-5. Restored CalculatorTest4. See the ShoppingCart mismatch below. |
| 5 · Decisions | 05 | Only 5-1 slides were archived. Added 5-2, 5-3, section practice and 5-2 Student Guide; restored eight missing starter ZIPs; added exact boundary contracts and separate tested worked examples. |
| 6 · Loops | 06 | for, while/do-while, break/continue, scope and listed starter exercises covered. Added a tracing checkpoint to the practice guide. |
| 7 · Creating classes | 08 | Class design, references, constructors, overloading, encapsulation and static/final covered; the listed Prisoner/PrisonTest/Cell starters are present. |
| 8 · Arrays/exceptions | 07 and 10 | Arrays, wrappers, exception handling and debugging covered; iterator traversal was underdeveloped, so added explanations, exercises and a worked example. ComputeAvg already lives in Unit 10. |
| 9 · JavaFX | 11 | Notes covered the main concepts but lacked all three starter projects. Added them, supplied media, resource-layout guidance, and 9-3 Student Guide. Corrected live numbering to 9-2 Colors/Shapes and 9-3 Graphics/Audio/MouseEvents. |

## Restored official starter archives

| Unit | Archives imported |
|---|---|
| 02 | ProblemSet2_1 |
| 04 | CalculatorTest4 |
| 05 | WatchMovie, TernaryOperator, ComputeFare, SwitchEx1, SwitchEx2, ColorRange, TrafficLightChecker, TrafficLightSwitch |
| 11 | JavaFXMain, JavaFXMainEx1, GoalTestStudent |

That is **13 ZIPs containing 14 Java files**, plus Duke.png, Glove.png and Note5.wav. The original ZIP bytes are preserved in the external archive and checksummed in the starter manifest. Working Java files use LF line endings and trimmed trailing whitespace; their code is unchanged and their local checksums are recorded separately. Intentionally unfinished tasks are not presented as completed solutions.

## ShoppingCart resource mismatch

The Section 4 and Section 5 links labelled `ShoppingCart.zip` both downloaded the same exception-oriented program: it constructs `Calculator`, calls `add(43, 79)`, and calls `divide(15, 0)`. Normalising line endings, both match the existing [Unit 10 ShoppingCart](10-Exceptions-and-Debugging/exercises/ShoppingCart/ShoppingCart.java).

Those downloads were not duplicated into the String or decision units and are not evidence that the intended earlier shopping-cart tasks are present. Use the original lesson's task wording and the local receipt/decision exercises; ask the instructor for the intended starter if it differs. The methods and decisions practice guides flag the mismatch.

## Important source clarifications

- Section 5 fare wording assigns age 11 to its otherwise case. The notes distinguish the literal rule from a possible intended inclusive adult cutoff.
- Wavelength ranges include the left endpoint and exclude the right, so 750 nm is out of range.
- Some slide fragments use string `==` or omit required syntax. The edited notes explain the valid form rather than silently treating fragments as compilable.
- The JavaFX Student Guide uses different class/package naming from the supplied `_Student_9_3` files. The new project guide explains how to keep source, classpath and media locations consistent.
- Historical download filenames are retained for source provenance; live numbering is used in edited notes.

## Validation and limits

Run `python tools/check_course.py` and `python tools/check_oracle_review.py` with the required Python dependencies and a JDK. Checks cover local links, Markdown fences, PDF page coverage, source checksums and console example behaviour including boundary cases.

JavaFX starters have been inspected with their supplied images/audio, but are unfinished and require a compatible JavaFX SDK and manual GUI/media checks. A successful console test does not validate them. The review does not establish exam eligibility, attempt limits, time limits or pass marks.
