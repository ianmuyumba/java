# 2-1 The Software Development Process

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 2-1 The Software Development Process.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text

```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Java Foundations
2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Understand the Spiral Model of development
- Recognize tasks and subtasks of the Spiral Model
- Recognize what happens when steps are ignored
- Identify software features
- Understand how features are gradually implemented
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Your buddy, Clinton, has plans for the weekend
• Check out his email and think about what steps would be 
ne
cessary to make these plans happen:
Hey buddy,
There's a special Computer History exhibit at the City 
Museum this month. A few of us are thinking of going 
Friday at 5:00 PM. Would you want to join? I think the 
subway would be the best way to get there.
Clinton
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• Complete the chart by writing at least one item for each section
Requirements
- What is Clinton’s email 
as
king?
Designing a Plan
- What do you need to consider 
b
efore going out?
- What are the Preconditions?
- What are the Postconditions?
Te
s ting
- How do you know the plan 
w
orked?
Implementing the Plan
- What actions do you take?
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Friday at the Museum
• You may have written something similar to this?
Requirements
- What is Clinton’s email asking?
• Be at the City Museum at 5:00 PM on 
Fri
day
Designing a Plan
- What do you need to consider before going out?
• Find a time to meet at the campus subway station 
bef
ore 5:00 PM
• Look up subway and street maps
- What are the Preconditions?
• The subway is not out of service
- What are the Postconditions?
• You return home after visiting the museum
Testing
- How do you know the plan worked?
• Did you get off at the right stop?
• Are the streets and buildings named 
what
 you expect?
• Did you see any computers?
Implementing the Plan
- What actions do you take?
• T ake the red-lin e train to South Station
• Walk east for 3 blocks
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Introducing the Spiral Model of Development 
• Developing software requires a similar thought process
• This is represented by the Spiral Model
• There are other models, but the Spiral Model best reflects what 
y
ou'll be doing in this course
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Requirements
• Carefully read any instructions:
- What should your program do?
- What problems is it trying to solve?
- What features must your program have?
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Design
• Plan your approach:
- Are there data or behaviors your program must model? 
- Will certain parts of your program need to be finished before work 
c
an begin on other parts?
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Develop
• Start coding:
- Create a simplified version of your program
- Focus on a small number of simple or important features
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Te s t
• Test your code:
- Does the program give the results that you expect?
- Can you find scenarios that produce unwanted results?
- Depending on their impact, these bugs may need fixing
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Requirements Iteration
• Check the requirements again:
- Does the program's behavior match the requirements?
- Are there additional requirements or features to build?
- Should some requirements change?
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Design Iteration
• Plan your changes:
- How should you model additional features?
- Should the existing design change to better support expanding 
c
urrent features or adding new features? 
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Development Iteration
• Continue developing:
- Add new features
- Modify or enhance existing features, if necessary
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
More Testing
• Continue testing:
- Does new code work as you expect?
- Will old code still work properly?
- Depending on the severity, bugs may need fixing
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Developing, Testing, and Fixing
• The process of developing, testing, and fixing bugs is sometimes 
f
rustrating:
- Code often doesn't work
- Unexpected bugs reveal themselves
- Solutions seem difficult and elusive
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Programming Is like Solving Puzzles
• It may take time…
- Thinking
- Experimenting
- Researching and iterating
• But it feels very rewarding to…
- See your code finally working (or behaving slightly better)
- Watch your program evolve and become more robust
- Find yourself becoming more skillful
- Mischievously find ways to produce bugs
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How to Research, 1 of 2
• Are you still confused after tinkering? There are many resources 
to h
elp you make progress:
• Lecture notes and completed small exercises
- Do they use commands or techniques you're looking for?
• Oracle's Java documentation
- They outline available Java commands
- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/
module-summary.html
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How to Research, 2 of 2
• Internet
- Other people may have asked questions similar to yours
- You may uncover helpful examples or promising new commands
- But your solutions should be your own, not copied code
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 1
• Here is Clinton's email again, in case you need it for this exercise
Hey buddy,
There's a special Computer History exhibit at the City 
Museum this month. A few of us are thinking of going 
Friday at 5:00 PM. Would you want to join? I think the 
subway would be the best way to get there.
Clinton
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 2
• Complete this chart
- Imagine what might happen to your night at the museum if a 
pa
rticular step were forgotten:
Requirements Designing a Plan
Te s ting Implementing the Plan
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Forgotten Friday
• You may have written something similar to this:
Requirements
- You do something else on 
Fr
iday
Designing a Plan
- Everyone is on the train, but 
no
body knows where they're going
- You ride the train for hours but 
ne
ver reach the museum
Te s ting
- You walk past the museum
- You arrive at the wrong 
b
uilding
- The museum is closed
Implementing the Plan
- Despite a wonderful plan, 
no
body goes to the museum
- Clinton is sad
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Forgetting Steps in the Spiral Model
• Similarly, bad things can happen when a particular step of the 
Spi
ral Model is forgotten
Requirements
- The program works, but 
do
esn't solve the right problem
- Features are missing
Designing a Plan
- Code is messy
- Bugs are difficult to fix
- Features are difficult to enhance
Te s ting
- The program keeps crashing
- The program gives incorrect 
re
sults
- Users are frustrated
- Users can't stop laughing
Implementing the Plan
- There is no program
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is a Software Feature? 1 of 2
• Think of a feature as:
- Something that a program can do
- Something that you can do with a program
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is a Software Feature? 2 of 2
• Examples:
- Printing text
- Playing a sound
- Calculating a value
- Dragging and dropping an icon
- Posting a high score to an online leaderboard
- A new type of enemy in a videogame
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Implementing a Feature
• Some features are easier to implement:
- You can code them in a few simple lines
- For example, printing text to your IDE's output window
• Some features are difficult to implement
- They rely on a combination of 
o
ther features
- For example, being able to 
"dr
ag and drop" an icon
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Implementing "Drag and Drop"
• A "drag and drop" feature requires several smaller features:
- Adding a graphic to the screen
- Finding the mouse position
- Detecting a mouse click
- Detecting a mouse release
- Changing the position of the graphic
• Implementing just one of these items can feel like a big 
a
ccomplishment
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Case Study: Java Puzzle Ball
• This game is written entirely in Jav a FX
• It's designed to teach programming concepts
• We've saved all the old versions of this game so that you can 
ex
plore how features were gradually implemented!
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Game's Development Process
• These are the steps we tried to take:
- Brainstorm and prototype game ideas
- Document goals and requirements for the best idea
- Break requirements into tasks/features and add them to a 
s
chedule
- Develop
- Te s t
- Iterate and reevaluate requirements
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 1
• Download OldGameV ersions.zip, unzip, and play these 
recordings of different versions of the game during its 
development:
- 08-16 -13.mp4 (August 16, 2013)
- 08-22 -13.mp4 (August 22, 2013)
- 09-27 -13.mp4 (September 27, 2013)
- 10-16 -13.mp4 (October 16, 2013)
- 11-21 -13.mp4 (November 21, 2013)
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 2
• Spend a couple minutes reviewing each version
• Note any new features, bugs, or changes between versions
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
August 16, 2013
• Goals of this version:
- Have the developer learn Ja va FX
- Implement a few basic features
• Notable features:
- Display images on screen
- Detect mouse events
- Rotate BlueBumpers
- Drag and drop an icon into slots (N, E)
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
August 22, 2013
• One week later:
- This version still isn't a game
- But it's looking more impressive
• Notable features:
- User Interface (UI) wheels and icons positioned on the right
- A RedBumper
- Colorized attachments
- More icons to drag and drop
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
September 27, 2013 (1 of 2)
• About one month later:
- This version could be called a game
- The goal is to deflect the ball to Duk e
- A different developer created the code
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
September 27, 2013 (2 of 2)
• Notable features:
- A Play b utton and a goal (Duke )
- A ball that can move and be deflected
- More shapes that can be attached
- Yellow lines (for collision detection)
- Wheels that snap to the nearest 45-de gree increment
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
October 16, 2013 (1 of 2)
• A few weeks later, we created additional game modes 
(
Inheritance & Geometry T est)
• There is a pop-up for choosing levels
- Because we didn't know how to unload/swap between levels
- You have to close the program to load a different level
- Levels are for testing features, and aren't quite puzzles for players
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
October 16, 2013 (2 of 2)
• More notable features:
- Level geometry
- A GreenBumper  and GreenWheel
- Level-b uilding instructions are read from a text file (but you 
couldn't have known that)
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
November 21, 2013 (1 of 2)
• Over one month later:
- We figured out how to unload levels!
- Only a single file is necessary to run the game
• Use the O ptions button to choose levels
- It's a temporary solution until we learned to create menus
- Levels are actual puzzles instead of tech demos
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
November 21, 2013 (2 of 2)
• More notable features:
- Fancy new background art
- More levels
- Slots are labeled AB CD instead of NESW (People thought their 
solutions were wrong if the N slot didn’t face north)
39
```

</details>


## PDF page 40

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Current Version
• Development continued several more months into 2014 and 
updat
es were made in 2020+
• You'll notice new features and changes in the latest version of  
Ja
va Puzzle Ball
40
```

</details>


## PDF page 41

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Spiral Model Summary
Requirements
- What the program should do
- What problem the program 
is t
rying to solve
Design
- How to model data and 
beh
avior
- What order to implement 
fea
tures
Te s ting
- Find bugs
- Fix bugs
Im
plementing the Plan
- Add simple versions of new 
fea
tures
- Enhance existing features
41
```

</details>


## PDF page 42

<details>
<summary>Page text</summary>

```text
JFo 2-1
The Software Development Process
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Understand the Spiral Model of development
- Recognize tasks and subtasks of the Spiral Model
- Recognize what happens when steps are ignored
- Identify software features
- Understand how features are gradually implemented
42
```

</details>


## PDF page 43

<details>
<summary>Page text</summary>

```text

```

</details>
