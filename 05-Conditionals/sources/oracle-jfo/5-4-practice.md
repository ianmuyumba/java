# 5-4 Practice

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 5-4 Practice.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other
names may be trademarks of their respective owners.
1
Java Foundations
Practices - Section 5
Practice 5-1: Determining color in the visible spectrum
Overview
Write an interactive Java program, ColorRange.java, which when given a waveLength in
nanometers will return the corresponding color in the visible spectrum.
color waveLength (nm)
Violet 380-450
Blue 450-495
Green 495-570
Yellow 570-590
Orange 590-620
Red 620-750
Tasks
You must implement the following using a suitable if decision statement.
1. Prompt the user to enter the waveLength - the waveLength should be of type double.
2. For each range (e.g., 380-450) the number on the left is included in the range, but the
number on the right is not included in the range.
3. If the input value is not found on the visible spectrum, then state that the waveLength is
not within the visible spectrum.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other
names may be trademarks of their respective owners.
2
Expected Output:
a. Enter a color code
630
The color is Red
b. Enter a color code
25.0
The entered waveLength is not a part of the visible spectrum
c. Enter a color code
750.5
The entered waveLength is not a part of the visible spectrum
The ColorRange.java file is available to help you get started.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other
names may be trademarks of their respective owners.
3
Problem 5-2: Determining the next color for a stop light
Overview
The normal behavior for a stop light is to cycle from Red to Green to Yellow to Red (and continues
with this pattern). Write a java program TrafficLightChecker.java, which will determine the next
color of a stop light in this pattern, Red to Green to Yellow to Red based on the current stop light
provided by the user.

Tasks
You must implement the following using a suitable if decision statement.
1. Have the user enter the value for the currentColor.
2. Compute the next color stop light based on the currentColor.
3. Alert the user for any invalid value of color.
Expected Output:
a. Enter a color code
1
Next Traffic Light is green
b. Enter a color code
3
Next Traffic Light is red
c. Enter a color code
0
Invalid color
d. Enter a color code
4
Invalid color
The TrafficLightChecker.java file is available to help you get started.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other
names may be trademarks of their respective owners.
4
Problem 5-3: Determining the next color for a stop light using
switch
Overview
Re-write practice 5-2 using switch statement.

Tasks
1. Implement practice 5-2 using switch statement and ensure the program alert users if
they’ve entered any invalid value.
The TrafficLightSwitch.java file is available to help you get started.
```

</details>
