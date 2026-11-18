# Goal project · Original Oracle starter

[JavaFX guide](../../ORACLE_REVIEW.md) · [Practice](../../PRACTICE.md)

Keep these source files unchanged for the starting task; make your own completed copy under `my-work/`.

| File | Purpose |
|---|---|
| `Goal_Student_9_3.java` | Add the goal's ImageView, sound and interactions |
| `GoalTest_Student_9_3.java` | Application driver; instantiate goal objects in `start()` |
| `Duke.png`, `Glove.png` | Supplied graphics |
| `Note5.wav` | Supplied sound |

The Java files are in the default package. For a completed version using `getResource("Images/Duke.png")` and `getResource("Audio/Note5.wav")`, place resources on the runtime classpath as follows:

```text
build/goal/
├── Goal_Student_9_3.class
├── GoalTest_Student_9_3.class
├── Images/
│   ├── Duke.png
│   └── Glove.png
└── Audio/
    └── Note5.wav
```

From the repository root, after installing/configuring a compatible JavaFX SDK, adjust the SDK path and use:

```powershell
$javafxLib = 'C:\javafx-sdk\lib'
javac --module-path $javafxLib --add-modules javafx.controls,javafx.media -d build/goal 11-JavaFX/exercises/GoalTestStudent/Goal_Student_9_3.java 11-JavaFX/exercises/GoalTestStudent/GoalTest_Student_9_3.java
New-Item -ItemType Directory -Force build/goal/Images,build/goal/Audio
Copy-Item 11-JavaFX/exercises/GoalTestStudent/Duke.png,11-JavaFX/exercises/GoalTestStudent/Glove.png build/goal/Images/
Copy-Item 11-JavaFX/exercises/GoalTestStudent/Note5.wav build/goal/Audio/
java --module-path $javafxLib --add-modules javafx.controls,javafx.media -cp build/goal GoalTest_Student_9_3
```

The raw starter opens an empty scene because instantiation and node creation are not completed. Follow the Student Guide's exercises before expecting graphics and sound. Do not confuse an incomplete exercise with a verified finished application.
