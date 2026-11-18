# Front matter

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
[No extractable text on this page.]
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
INTRODUCTION TO
JAVA
PROGRAMMING
COMPREHENSIVE VERSION
Tenth Edition
Y. Daniel Liang
Armstrong Atlantic State University
®
Boston   Columbus   Indianapolis New Y ork   San Francisco Upper Saddle River
Amsterdam   Cape T own   Dubai   London Madrid   Milan  Munich Paris Montreal T oronto
Delhi Mexico City  Sao Paulo Sydney Hong Kong  Seoul  Singapore  Taipei T okyo
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
To Samantha, Michael, and Michelle
Credits and acknowledgments borrowed from other sources and reproduced, with permission, in this textbook 
appear on the appropriate page within text.
Microsoft® and Windows® are registered trademarks of the Microsoft Corporation in the U.S.A. and other 
countries. Screen shots and icons reprinted with permission from the Microsoft Corporation. This book is not 
sponsored or endorsed by or affiliated with the Microsoft Corporation.
Copyright © 2015, 2013, 2011 Pearson Education, Inc., publishing as Prentice Hall, 1 Lake Street, Upper Saddle 
River, New Jersey, 07458. All rights reserved. Printed in the United States of America. This publication is protected 
by Copyright, and permission should be obtained from the publisher prior to any prohibited reproduction, storage in 
a retrieval system, or transmission in any form or by any means, electronic, mechanical, photocopying, recording,
or likewise. To obtain permission(s) to use material from this work, please submit a written request to Pearson 
Education, Inc., Permissions Department, One Lake Street, Upper Saddle River, New Jersey 07458, or you may fax 
your request to 201-236-3290.
Many of the designations by manufacturers and sellers to distinguish their products are claimed as trademarks. 
Where those designations appear in this book, and the publisher was aware of a trademark claim, the designations 
have been printed in initial caps or all caps.
Library of Congress Cataloging-in-Publication Data available upon request.
Editorial Director, ECS: Marcia Horton
Executive Editor: Tracy Johnson (Dunkelberger)
Editorial Assistant: Jenah Blitz-Stoehr
Director of Marketing: Christy Lesko
Marketing Manager: Yez Alayan
Marketing Assistant: Jon Bryant
Director of Program Management: Erin Gregg
Program Management-Team Lead: Scott Disanno
Program Manager: Carole Snyder
Project Management-Team Lead: Laura Burgess
Project Manager: Robert Engelhardt
Procurement Specialist: Linda Sager
Cover Designer: Marta Samsel
Permissions Supervisor: Michael Joyce
Permissions Administrator: Jenell Forschler
Director, Image Asset Services: Annie Atherton
Manager, Visual Research: Karen Sanatar
Image Permission Coordinator:
Cover Art: © Blend Images—PBNJ Productions/Getty 
Images
Media Project Manager: Renata Butera
Full-Service Project Management: Haseen Khan, 
Laserwords Pvt Ltd
10  9  8  7  6  5  4  3  2  1
ISBN 10: 0-13-376131-2
ISBN 13: 978-0-13-376131-3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
iii
PREFACE
Dear Reader,
Many of you have provided feedback on earlier editions of this book, and your comments and 
suggestions have greatly improved the book. This edition has been substantially enhanced in 
presentation, organization, examples, exercises, and supplements. The new edition:
■ Replaces Swing with JavaFX. JavaFX is a new framework for developing Java GUI pro-
grams. JavaFX greatly simplifies GUI programming and is easier to learn than Swing.
■ Introduces exception handling, abstract classes, and interfaces before GUI programming to 
enable the GUI chapters to be skipped completely if the instructor chooses not to cover GUI.
■ Covers introductions to objects and strings earlier in Chapter 4 to enable students to use 
objects and strings to develop interesting programs early.
■ Includes many new interesting examples and exercises to stimulate student interests. More 
than 100 additional programming exercises are provided to instructors only on the Com-
panion Website.
Please visit www.pearsonhighered.com/liang for a complete list of new features as well as 
correlations to the previous edition.
The book is fundamentals first by introducing basic programming concepts and techniques 
before designing custom classes. The fundamental concepts and techniques of selection 
statements, loops, methods, and arrays are the foundation for programming. Building this 
strong foundation prepares students to learn object-oriented programming and advanced Java 
programming.
This book teaches programming in a problem-driven way that focuses on problem solv-
ing rather than syntax. We make introductory programming interesting by using thought-
provoking problems in a broad context. The central thread of early chapters is on problem 
solving. Appropriate syntax and library are introduced to enable readers to write programs for 
solving the problems. To support the teaching of programming in a problem-driven way, the 
book provides a wide variety of problems at various levels of difficulty to motivate students. 
To appeal to students in all majors, the problems cover many application areas, including 
math, science, business, financial, gaming, animation, and multimedia.
The book seamlessly integrates programming, data structures, and algorithms into one text. 
It employs a practical approach to teach data structures. We first introduce how to use various 
data structures to develop efficient algorithms, and then show how to implement these data 
structures. Through implementation, students gain a deep understanding on the efficiency of 
data structures and on how and when to use certain data structures. Finally we design and 
implement custom data structures for trees and graphs.
The book is widely used in the introductory programming, data structures, and algorithms 
courses in the universities around the world. This comprehensive version covers fundamentals 
of programming, object-oriented programming, GUI programming, data structures, algorithms, 
concurrency, networking, database, and Web programming. It is designed to prepare students 
to become proficient Java programmers. A brief version (Introduction to Java Programming,
Brief Version, Tenth Edition) is available for a first course on programming, commonly known 
as CS1. The brief version contains the first 18 chapters of the comprehensive version. The first 
13 chapters are appropriate for preparing the AP Computer Science exam.
The best way to teach programming is by example, and the only way to learn program-
ming is by doing. Basic concepts are explained by example and a large number of exercises 
what is new?
fundamentals-first
problem-driven
comprehensive version
brief version
AP Computer Science
examples and exercises
data structures
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
iv Preface
with various levels of difficulty are provided for students to practice. For our programming 
courses, we assign programming exercises after each lecture.
Our goal is to produce a text that teaches problem solving and programming in a broad 
context using a wide variety of interesting examples. If you have any comments on and sug-
gestions for improving the book, please email me.
Sincerely,
Y. Daniel Liang
y.daniel.liang@gmail.com
www.cs.armstrong.edu/liang
www.pearsonhighered.com/liang
ACM/IEEE Curricular 2013 and ABET 
Course Assessment
The new ACM/IEEE Computer Science Curricular 2013 defines the Body of Knowledge 
organized into 18 Knowledge Areas. To help instructors design the courses based on this book, 
we provide sample syllabi to identify the Knowledge Areas and Knowledge Units. The sample 
syllabi are for a three semester course sequence and serve as an example for institutional cus-
tomization. The sample syllabi are available to instructors at www.pearsonhighered.com/liang.
Many of our users are from the ABET-accredited programs. A key component of the ABET 
accreditation is to identify the weakness through continuous course assessment against the course 
outcomes. We provide sample course outcomes for the courses and sample exams for measuring 
course outcomes on the instructor Website accessible from www.pearsonhighered.com/liang.
What’s New in This Edition?
This edition is completely revised in every detail to enhance clarity, presentation, content, 
examples, and exercises. The major improvements are as follows:
■ Updated to Java 8.
■ Since Swing is replaced by JavaFX, all GUI examples and exercises are revised using 
JavaFX.
■ Lambda expressions are used to simplify coding in JavaFX and threads.
■ More than 100 additional programming exercises with solutions are provided to the 
instructor on the Companion Website. These exercises are not printed in the text.
■ Math methods are introduced earlier in Chapter 4 to enable students to write code using 
math functions.
■ Strings are introduced earlier in Chapter 4 to enable students to use objects and strings to 
develop interesting programs early.
■ The GUI chapters are moved to after abstract classes and interfaces so that these chapters 
can be easily skipped if the instructor chooses not to cover GUI.
■ Chapters 4, 14, 15, and 16 are brand new chapters.
■ Chapters 28 and 29 have been substantially revised with simpler implementations for min-
imum spanning trees and shortest paths.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
Preface v
Pedagogical Features
The book uses the following elements to help students get the most from the material:
■ The Objectives at the beginning of each chapter list what students should learn from the 
chapter. This will help them determine whether they have met the objectives after completing 
the chapter.
■ The Introduction opens the discussion with representative problems to give the reader an 
overview of what to expect from the chapter.
■ Key Points highlight the important concepts covered in each section.
■ Check Points provide review questions to help students track their progress as they read 
through the chapter and evaluate their learning.
■ Problems and Case Studies , carefully chosen and presented in an easy-to-follow style, 
teach problem solving and programming concepts. The book uses many small, simple, and 
stimulating examples to demonstrate important ideas.
■ The Chapter Summary  reviews the important subjects that students should under-
stand and remember. It helps them reinforce the key concepts they have learned in the 
chapter.
■ Quizzes are accessible online, grouped by sections, for students to do self-test on pro-
gramming concepts and techniques.
■ Programming Exercises are grouped by sections to provide students with opportunities 
to apply the new skills they have learned on their own. The level of difficulty is rated as 
easy (no asterisk), moderate ( *), hard (**), or challenging ( ***). The trick of learning 
programming is practice, practice, and practice. To that end, the book provides a great 
many exercises. Additionally, more than 100 programming exercises with solutions are 
provided to the instructors on the Companion Website. These exercises are not printed in 
the text.
■ Notes, Tips, Cautions, and Design Guides are inserted throughout the text to offer valu-
able advice and insight on important aspects of program development.
Note
Provides additional information on the subject and reinforces important concepts.
Tip
Teaches good programming style and practice.
Caution
Helps students steer away from the pitfalls of programming errors.
Design Guide
Provides guidelines for designing programs.
Flexible Chapter Orderings
The book is designed to provide flexible chapter orderings to enable GUI, exception handling, 
recursion, generics, and the Java Collections Framework to be covered earlier or later. The 
diagram on the next page shows the chapter dependencies.
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
vi Preface
Chapter 39 Web Services
Chapter 42 Testing Using JUnit
Chapter 38 JavaServer Pages
Chapter 25 Binary Search Trees
Chapter 26 AVL Trees
Chapter 29 Weighted Graphs
and Applications
Chapter 28 Graphs and
Applications
Chapter 21 Sets and Maps
Chapter 22 Developping
Efficient Algorithms
Chapter 1 Introduction to
Computers, Programs, and
Java
Chapter 2 Elementary
Programming
Chapter 5 Loops
Chapter 7 Single-Dimensional
Arrays
Chapter 8 Multidimensional
Arrays
Chapter 4 Mathematical
Functions, Characters,
and Strings
Part I: Fundamentals of
Programming
Chapter 3 Selections
Chapter 9 Objects and Classes
Chapter 17 Binary I/O
Note: Chapters 1–18 are in the
brief version of this book.
Note: Chapters 1–33 are in the
comprehensive version.
Note: Chapters 34–42 are bonus
chapters available from the
Companion Website.
Chapter 10 Thinking in Objects
Chapter 11 Inheritance and
Polymorphism
Chapter 12 Exception
Handling and Text I/O
Chapter 13 Abstract Classes
and Interfaces
Chapter 6 Methods
Part II: Object-Oriented
Programming
Chapter 30 Multithreading and
Parallel Programming
Chapter 36 Internationalization
Chapter 31 Networking
Chapter 32 Java Database
Programming
Chapter 33 JavaServer Faces
Chapter 35 Advanced Database
Programming
Chapter 37 Servlets
Part V: Advanced Java
Programming
Chapter 14 JavaFX Basics
Chapter 15 Event-Driven
Programming and
Animations
Chapter 20 Lists, Stacks, Queues,
and Priority Queues
Chapter 16 JavaFX Controls
and Multimedia
Chapter 34 Advanced GUI
Programming
Part III: GUI Programming
Chapter 18 RecursionCh 7
Chapter 19 Generics
Chapter 24 Implementing Lists,
Stacks, Queues, and Priority
Queues
Part IV: Data Structures and
Algorithms
Ch 13
Ch 16
Ch 9
Chapter 40 2-4 Trees and B-
Trees
Chapter 41 Red-Black Trees
Chapter 27 Hashing
Chapter 23 Sorting
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
Preface vii
Organization of the Book
The chapters can be grouped into five parts that, taken together, form a comprehensive introduc-
tion to Java programming, data structures and algorithms, and database and Web programming. 
Because knowledge is cumulative, the early chapters provide the conceptual basis for under-
standing programming and guide students through simple examples and exercises; subsequent 
chapters progressively present Java programming in detail, culminating with the development 
of comprehensive Java applications. The appendixes contain a mixed bag of topics, including an 
introduction to number systems, bitwise operations, regular expressions, and enumerated types.
Part I: Fundamentals of Programming (Chapters 1–8)
The first part of the book is a stepping stone, preparing you to embark on the journey of learning 
Java. You will begin to learn about Java (Chapter 1) and fundamental programming techniques 
with primitive data types, variables, constants, assignments, expressions, and operators (Chapter 2), 
selection statements (Chapter 3), mathematical functions, characters, and strings (Chapter 4), loops 
(Chapter 5), methods (Chapter 6), and arrays (Chapters 7–8). After Chapter 7, you can jump to 
Chapter 18 to learn how to write recursive methods for solving inherently recursive problems.
Part II: Object-Oriented Programming (Chapters 9–13, and 17)
This part introduces object-oriented programming. Java is an object-oriented programming 
language that uses abstraction, encapsulation, inheritance, and polymorphism to provide 
great flexibility, modularity, and reusability in developing software. You will learn program-
ming with objects and classes (Chapters 9–10), class inheritance (Chapter 11), polymorphism 
(Chapter 11), exception handling (Chapter 12), abstract classes (Chapter 13), and interfaces 
(Chapter 13). Text I/O is introduced in Chapter 12 and binary I/O is discussed in Chapter 17.
Part III: GUI Programming (Chapters 14–16 and Bonus Chapter 34)
JavaFX is a new framework for developing Java GUI programs. It is not only useful for 
developing GUI programs, but also an excellent pedagogical tool for learning object-oriented 
programming. This part introduces Java GUI programming using JavaFX in Chapters 14–16. 
Major topics include GUI basics (Chapter 14), container panes (Chapter 14), drawing shapes 
(Chapter 14), event-driven programming (Chapter 15), animations (Chapter 15), and GUI 
controls (Chapter 16), and playing audio and video (Chapter 16). You will learn the architec-
ture of JavaFX GUI programming and use the controls, shapes, panes, image, and video to 
develop useful applications. Chapter 34 covers advanced features in JavaFX.
Part IV: Data Structures and Algorithms (Chapters 18–29 and Bonus Chapters 40–41)
This part covers the main subjects in a typical data structures and algorithms course. Chapter 18 
introduces recursion to write methods for solving inherently recursive problems. Chapter 19 
presents how generics can improve software reliability. Chapters 20 and 21 introduce the 
Java Collection Framework, which defines a set of useful API for data structures. Chapter 22 
discusses measuring algorithm efficiency in order to choose an appropriate algorithm for 
applications. Chapter 23 describes classic sorting algorithms. You will learn how to implement 
several classic data structures lists, queues, and priority queues in Chapter 24. Chapters 25 and 
26 introduce binary search trees and AVL trees. Chapter 27 presents hashing and implement-
ing maps and sets using hashing. Chapters 28 and 29 introduce graph applications. The 2-4 
trees, B-trees, and red-black trees are covered in Bonus Chapters 40–41.
Part V: Advanced Java Programming (Chapters 30–33 and Bonus Chapters 35–39, 42)
This part of the book is devoted to advanced Java programming. Chapter 30 treats the use 
of multithreading to make programs more responsive and interactive and introduces parallel 
programming. Chapter 31 discusses how to write programs that talk with each other from 
different hosts over the Internet. Chapter 32 introduces the use of Java to develop database
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
viii Preface
projects. Chapter 33 introduces modern Web application development using JavaServer Faces. 
Chapter 35 delves into advanced Java database programming. Chapter 36 covers the use of 
internationalization support to develop projects for international audiences. Chapters 37 and 
38 introduce how to use Java servlets and JavaServer Pages to generate dynamic content from 
Web servers. Chapter 39 discusses Web services. Chapter 42 introduces testing Java programs 
using JUnit.
Appendixes
This part of the book covers a mixed bag of topics. Appendix A lists Java keywords. 
Appendix B gives tables of ASCII characters and their associated codes in decimal and in 
hex. Appendix C shows the operator precedence. Appendix D summarizes Java modifiers and 
their usage. Appendix E discusses special floating-point values. Appendix F introduces num-
ber systems and conversions among binary, decimal, and hex numbers. Finally, Appendix G 
introduces bitwise operations. Appendix H introduces regular expressions. Appendix I covers 
enumerated types.
Java Development Tools
You can use a text editor, such as the Windows Notepad or WordPad, to create Java programs 
and to compile and run the programs from the command window. You can also use a Java 
development tool, such as NetBeans or Eclipse. These tools support an integrated develop-
ment environment (IDE) for developing Java programs quickly. Editing, compiling, building, 
executing, and debugging programs are integrated in one graphical user interface. Using these 
tools effectively can greatly increase your programming productivity. NetBeans and Eclipse 
are easy to use if you follow the tutorials. Tutorials on NetBeans and Eclipse can be found 
under Tutorials on the Student Companion Website at www.pearsonhighered.com/liang.
Student Resource Website
The Student Resource Website www.pearsonhighered.com/liang provides access to some of the 
following resources. Other resources are available using the student access code printed on the 
inside front cover of this book. (For students with a used copy of this book, you can purchase 
access to the premium student resources through www.pearsonhighered.com/liang.)
■ Answers to review questions
■ Solutions to even-numbered programming exercises
■ Source code for the examples in the book
■ Interactive quiz (organized by sections for each chapter)
■ Supplements
■ Debugging tips
■ Algorithm animations
■ Errata
Instructor Resource Website
The Instructor Resource Website, accessible from www.pearsonhighered.com/liang, provides 
access to the following resources: 
■ Microsoft PowerPoint slides with interactive buttons to view full-color, syntax-highlighted 
source code and to run programs without leaving the slides.
■ Solutions to all programming exercises. Students will have access to the solutions of even-
numbered programming exercises.
IDE tutorials
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Preface ix
■ More than 100 additional programming exercises organized by chapters. These exercises 
are available only to the instructors. Solutions to these exercises are provided.
■ Web-based quiz generator. (Instructors can choose chapters to generate quizzes from a 
large database of more than two thousand questions.)
■ Sample exams. Most exams have four parts:
■ Multiple-choice questions or short-answer questions
■ Correct programming errors
■ Trace programs
■ Write programs
■ ACM/IEEE Curricula 2013. The new ACM/IEEE Computer Science Curricula 2013 
defines the Body of Knowledge organized into 18 Knowledge Areas. To help instructors 
design the courses based on this book, we provide sample syllabi to identify the Knowl-
edge Areas and Knowledge Units. The sample syllabi are for a three semester course 
sequence and serve as an example for institutional customization. Instructors can access 
the syllabi at www.pearsonhighered.com/liang.
■ Sample exams with ABET course assessment.
■ Projects. In general, each project gives a description and asks students to analyze, design, 
and implement the project.
Some readers have requested the materials from the Instructor Resource Website. Please 
understand that these are for instructors only. Such requests will not be answered.
Online Practice and Assessment 
with MyProgrammingLab
MyProgrammingLab helps students fully grasp the logic, semantics, and syntax of pro-
gramming. Through practice exercises and immediate, personalized feedback, MyProgram-
mingLab improves the programming competence of beginning students who often struggle 
with the basic concepts and paradigms of popular high-level programming languages.
A self-study and homework tool, a MyProgrammingLab course consists of hundreds of 
small practice problems organized around the structure of this textbook. For students, the sys-
tem automatically detects errors in the logic and syntax of their code submissions and offers 
targeted hints that enable students to figure out what went wrong—and why. For instructors, 
a comprehensive gradebook tracks correct and incorrect answers and stores the code inputted 
by students for review.
MyProgrammingLab is offered to users of this book in partnership with Turing’s Craft, the 
makers of the CodeLab interactive programming exercise system. For a full demonstration, 
to see feedback from instructors and students, or to get started using MyProgrammingLab in 
your course, visit www.myprogramminglab.com.
VideoNotes
We are excited about the new VideoNotes feature that is found in this new edition. These 
videos provide additional help by presenting examples of key topics and showing how to 
solve problems completely, from design through coding. VideoNotes are available from 
www.pearsonhighered.com/liang.
VideoNote
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
x Preface
Algorithm Animations
We have provided numerous animations for algorithms. These are valuable pedagogical tools 
to demonstrate how algorithms work. Algorithm animations can be accessed from the Com-
panion Website.
Acknowledgments
I would like to thank Armstrong Atlantic State University for enabling me to teach what I 
write and for supporting me in writing what I teach. Teaching is the source of inspiration for 
continuing to improve the book. I am grateful to the instructors and students who have offered 
comments, suggestions, bug reports, and praise.
This book has been greatly enhanced thanks to outstanding reviews for this and previous 
editions. The reviewers are: Elizabeth Adams (James Madison University), Syed Ahmed (North 
Georgia College and State University), Omar Aldawud (Illinois Institute of Technology), Stefan 
Andrei (Lamar University), Yang Ang (University of Wollongong, Australia), Kevin Bierre 
(Rochester Institute of Technology), David Champion (DeVry Institute), James Chegwidden 
(Tarrant County College), Anup Dargar (University of North Dakota), Charles Dierbach (Towson 
University), Frank Ducrest (University of Louisiana at Lafayette), Erica Eddy (University of 
Wisconsin at Parkside), Deena Engel (New York University), Henry A.  Etlinger (Rochester Institute 
of Technology), James Ten Eyck (Marist College), Myers Foreman (Lamar University), Olac 
Fuentes (University of Texas at El Paso), Edward F. Gehringer (North Carolina State University), 
Harold Grossman (Clemson University), Barbara Guillot (Louisiana State University), Stuart 
Hansen (University of Wisconsin, Parkside), Dan Harvey (Southern Oregon University), Ron 
Hofman (Red River College, Canada), Stephen Hughes (Roanoke College), Vladan Jovanovic 
(Georgia Southern University), Edwin Kay (Lehigh University), Larry King (University of 
Texas at Dallas), Nana Kofi (Langara College, Canada), George Koutsogiannakis (Illinois 
Institute of Technology), Roger Kraft (Purdue University at Calumet), Norman Krumpe (Miami 
University), Hong Lin (DeVry Institute), Dan Lipsa (Armstrong Atlantic State University), 
James Madison (Rensselaer Polytechnic Institute), Frank Malinowski (Darton College), 
Tim Margush (University of Akron), Debbie Masada (Sun Microsystems), Blayne Mayfield 
(Oklahoma State University), John McGrath (J.P. McGrath Consulting), Hugh McGuire (Grand 
Valley State), Shyamal Mitra (University of Texas at Austin), Michel Mitri (James Madison 
University), Kenrick Mock (University of Alaska Anchorage), Frank Murgolo (California 
State University, Long Beach), Jun Ni (University of Iowa), Benjamin Nystuen (University of 
Colorado at Colorado Springs), Maureen Opkins (CA State University, Long Beach), Gavin 
Osborne (University of Saskatchewan), Kevin Parker (Idaho State University), Dale Parson 
(Kutztown University), Mark Pendergast (Florida Gulf Coast University), Richard Povinelli 
(Marquette University), Roger Priebe (University of Texas at Austin), Mary Ann Pumphrey (De 
Anza Junior College), Pat Roth (Southern Polytechnic State University), Amr Sabry (Indiana 
University), Ben Setzer (Kennesaw State University), Carolyn Schauble (Colorado State 
University), David Scuse (University of Manitoba), Ashraf Shirani (San Jose State University), 
Daniel Spiegel (Kutztown University), Joslyn A. Smith (Florida Atlantic University), Lixin 
Tao (Pace University), Ronald F. Taylor (Wright State University), Russ Tront (Simon Fraser 
University), Deborah Trytten (University of Oklahoma), Michael Verdicchio (Citadel), Kent 
Vidrine (George Washington University), and Bahram Zartoshty (California State University 
at Northridge).
It is a great pleasure, honor, and privilege to work with Pearson. I would like to thank Tracy 
Johnson and her colleagues Marcia Horton, Yez Alayan, Carole Snyder, Scott Disanno, Bob 
Engelhardt, Haseen Khan, and their colleagues for organizing, producing, and promoting this 
project.
As always, I am indebted to my wife, Samantha, for her love, support, and encouragement.
Animation
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
xi
1 Introduction to Computers, Programs, 
  and Java 1
2 Elementary Programming 33
3 Selections 75
4 Mathematical Functions, Characters,
  and Strings 119
5 Loops 157
6 Methods 203
7 Single-Dimensional Arrays 245
8 Multidimensional Arrays 287
9 Objects and Classes 321
10 Object-Oriented Thinking 365
11 Inheritance and Polymorphism 409
12 Exception Handling and Text I/O 449
13 Abstract Classes and Interfaces 495
14 JavaFX Basics 535
15 Event-Driven Programming 
  and Animations 585
16 JavaFX UI Controls and Multimedia 629
17 Binary I/O 677
18 Recursion 705
19 Generics 737
20 Lists, Stacks, Queues, 
  and Priority Queues 761
21 Sets and Maps 797
22 Developing Efficient Algorithms 821
23 Sorting 861
24 Implementing Lists, Stacks, Queues, 
  and Priority Queues 895
25 Binary Search Trees 929
26 AVL Trees 965
27 Hashing 985
28 Graphs and Applications 1015
BRIEF CONTENTS
29 Weighted Graphs and Applications 1061
30 Multithreading and Parallel Programming 1097
31 Networking 1139
32 Java Database Programming 1173
33 JavaServer Faces 1213
Chapters 34–42 are bonus Web chapters
34 Advanced JavaFX 34-1
35 Advanced Database Programming 35-1
36 Internationalization 36-1
37 Servlets 37-1
38 JavaServer Pages 38-1
39 Web Services 39-1
40 2-4 Trees and B-Trees 40-1
41 Red-Black Trees 41-1
42 Testing Using JUnit 42-1
Appendixes
A Java Keywords 1263
B The ASCII Character Set 1266
C Operator Precedence Chart 1268
D Java Modifiers 1270
E Special Floating-Point Values 1272
F Number Systems 1273
G Bitwise Operatoirns 1277
H Regular Expressions 1278
I Enumerated Types 1283
Index 1289
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
xii
 Chapter 1 Introduction to Computers, Programs, 
  and Java 1
1.1 Introduction 2
1.2 What Is a Computer? 2
1.3 Programming Languages 7
1.4 Operating Systems 9
1.5 Java, the World Wide Web, and Beyond 10
1.6 The Java Language Specification, API, JDK, and IDE 11
1.7 A Simple Java Program 12
1.8 Creating, Compiling, and Executing a Java Program 15
1.9 Programming Style and Documentation 18
1.10 Programming Errors 20
1.11 Developing Java Programs Using NetBeans 23
1.12 Developing Java Programs Using Eclipse 25
 Chapter 2 Elementary Programming 33
2.1 Introduction 34
2.2 Writing a Simple Program 34
2.3 Reading Input from the Console 37
2.4 Identifiers 39
2.5 Variables 40
2.6 Assignment Statements and Assignment Expressions 41
2.7 Named Constants 43
2.8 Naming Conventions 44
2.9 Numeric Data Types and Operations 44
2.10 Numeric Literals 48
2.11 Evaluating Expressions and Operator Precedence 50
2.12 Case Study: Displaying the Current Time 52
2.13 Augmented Assignment Operators 54
2.14 Increment and Decrement Operators 55
2.15 Numeric Type Conversions 56
2.16 Software Development Process 59
2.17 Case Study: Counting Monetary Units 63
2.18 Common Errors and Pitfalls 65
 Chapter 3 Selections 75
3.1 Introduction 76
3.2 boolean Data Type 76
3.3 if Statements 78
3.4 Two-Way if-else Statements 80
3.5 Nested if and Multi-Way if-else Statements 81
3.6 Common Errors and Pitfalls 83
3.7 Generating Random Numbers 87
3.8 Case Study: Computing Body Mass Index 89
3.9 Case Study: Computing Taxes 90
3.10 Logical Operators 93
3.11 Case Study: Determining Leap Year 97
3.12 Case Study: Lottery 98
3.13 switch Statements 100
3.14 Conditional Expressions 103
CONTENTS
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
xiii
3.15 Operator Precedence and Associativity 104
3.16 Debugging 106
 Chapter 4 Mathematical Functions, Characters, 
  and Strings 119
4.1 Introduction 120
4.2 Common Mathematical Functions 120
4.3 Character Data Type and Operations 125
4.4 The String Type 130
4.5 Case Studies 139
4.6 Formatting Console Output 145
 Chapter 5 Loops 157
5.1 Introduction 158
5.2 The while Loop 158
5.3 The do-while Loop 168
5.4 The for Loop 170
5.5 Which Loop to Use? 174
5.6 Nested Loops 176
5.7 Minimizing Numeric Errors 178
5.8 Case Studies 179
5.9 Keywords break and continue 184
5.10 Case Study: Checking Palindromes 187
5.11 Case Study: Displaying Prime Numbers 188
 Chapter 6 Methods 203
6.1 Introduction 204
6.2 Defining a Method 204
6.3 Calling a Method 206
6.4 void Method Example 209
6.5 Passing Arguments by Values 212
6.6 Modularizing Code 215
6.7 Case Study: Converting Hexadecimals to Decimals 217
6.8 Overloading Methods 219
6.9 The Scope of Variables 222
6.10 Case Study: Generating Random Characters 223
6.11 Method Abstraction and Stepwise Refinement 225
 Chapter 7 Single-Dimensional Arrays 245
7.1 Introduction 246
7.2 Array Basics 246
7.3 Case Study: Analyzing Numbers 253
7.4 Case Study: Deck of Cards 254
7.5 Copying Arrays 256
7.6 Passing Arrays to Methods 257
7.7 Returning an Array from a Method 260
7.8 Case Study: Counting the Occurrences of Each Letter 261
7.9 Variable-Length Argument Lists 264
7.10 Searching Arrays 265
7.11 Sorting Arrays 269
7.12 The Arrays Class 270
7.13 Command-Line Arguments 272
 Chapter 8 Multidimensional Arrays 287
8.1 Introduction 288
8.2 Two-Dimensional Array Basics 288
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
xiv Contents
8.3 Processing Two-Dimensional Arrays 291
8.4 Passing Two-Dimensional Arrays to Methods 293
8.5 Case Study: Grading a Multiple-Choice Test 294
8.6 Case Study: Finding the Closest Pair 296
8.7 Case Study: Sudoku 298
8.8 Multidimensional Arrays 301
 Chapter 9 Objects and Classes 321
9.1 Introduction 322
9.2 Defining Classes for Objects 322
9.3 Example: Defining Classes and Creating Objects 324
9.4 Constructing Objects Using Constructors 329
9.5 Accessing Objects via Reference Variables 330
9.6 Using Classes from the Java Library 334
9.7 Static Variables, Constants, and Methods 337
9.8 Visibility Modifiers 342
9.9 Data Field Encapsulation 344
9.10 Passing Objects to Methods 347
9.11 Array of Objects 351
9.12 Immutable Objects and Classes 353
9.13 The Scope of Variables 355
9.14 The this Reference 356
 Chapter 10 Object-Oriented Thinking 365
10.1 Introduction 366
10.2 Class Abstraction and Encapsulation 366
10.3 Thinking in Objects 370
10.4 Class Relationships 373
10.5 Case Study: Designing the Course Class 376
10.6 Case Study: Designing a Class for Stacks 378
10.7 Processing Primitive Data Type Values as Objects 380
10.8 Automatic Conversion between Primitive Types 
and Wrapper Class Types 383
10.9 The BigInteger and BigDecimal Classes 384
10.10 The String Class 386
10.11 The StringBuilder and StringBuffer Classes 392
 Chapter 11 Inheritance and Polymorphism 409
11.1 Introduction 410
11.2 Superclasses and Subclasses 410
11.3 Using the super Keyword 416
11.4 Overriding Methods 419
11.5 Overriding vs. Overloading 420
11.6 The Object Class and Its toString() Method 422
11.7 Polymorphism 423
11.8 Dynamic Binding 424
11.9 Casting Objects and the instanceof Operator 427
11.10 The Object’sequals Method 431
11.11 The ArrayList Class 432
11.12 Useful Methods for Lists 438
11.13 Case Study: A Custom Stack Class 439
11.14 The protected Data and Methods 440
11.15 Preventing Extending and Overriding 442
 Chapter 12 Exception Handling and Text I/O 449
12.1 Introduction 450
12.2 Exception-Handling Overview 450
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
Contents xv
12.3 Exception Types 455
12.4 More on Exception Handling 458
12.5 The finally Clause 466
12.6 When to Use Exceptions 467
12.7 Rethrowing Exceptions 468
12.8 Chained Exceptions 469
12.9 Defining Custom Exception Classes 470
12.10 The File Class 473
12.11 File Input and Output 476
12.12 Reading Data from the Web 482
12.13 Case Study: Web Crawler 484
 Chapter 13 Abstract Classes and Interfaces 495
13.1 Introduction 496
13.2 Abstract Classes 496
13.3 Case Study: the Abstract Number Class 501
13.4 Case Study: Calendar and GregorianCalendar 503
13.5 Interfaces 506
13.6 The Comparable Interface 509
13.7 The Cloneable Interface 513
13.8 Interfaces vs. Abstract Classes 517
13.9 Case Study: The Rational Class 520
13.10 Class Design Guidelines 525
 Chapter 14 JavaFX Basics 535
14.1 Introduction 536
14.2 JavaFX vs Swing and AWT 536
14.3 The Basic Structure of a JavaFX Program 536
14.4 Panes, UI Controls, and Shapes 539
14.5 Property Binding 542
14.6 Common Properties and Methods for Nodes 545
14.7 The Color Class 546
14.8 The Font Class 547
14.9 The Image and ImageView Classes 549
14.10 Layout Panes 552
14.11 Shapes 560
14.12 Case Study: The ClockPane Class 572
 Chapter 15 Event-Driven Programming 
  and Animations 585
15.1 Introduction 586
15.2 Events and Event Sources 588
15.3 Registering Handlers and Handling Events 589
15.4 Inner Classes 593
15.5 Anonymous Inner Class Handlers 594
15.6 Simplifying Event Handling Using Lambda Expressions 597
15.7 Case Study: Loan Calculator 600
15.8 Mouse Events 602
15.9 Key Events 603
15.10 Listeners for Observable Objects 606
15.11 Animation 608
15.12 Case Study: Bouncing Ball 616
 Chapter 16 JavaFX UI Controls and Multimedia 629
16.1 Introduction 630
16.2 Labeled and Label 630
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
xvi Contents
16.3 Button 632
16.4 CheckBox 634
16.5 RadioButton 637
16.6 TextField 639
16.7 TextArea 641
16.8 ComboBox 644
16.9 ListView 647
16.10 ScrollBar 651
16.11 Slider 654
16.12 Case Study: Developing a Tic-Tac-Toe Game 657
16.13 Video and Audio 662
16.14 Case Study: National Flags and Anthems 665
 Chapter 17 Binary I/O 677
17.1 Introduction 678
17.2 How Is Text I/O Handled in Java? 678
17.3 Text I/O vs. Binary I/O 679
17.4 Binary I/O Classes 680
17.5 Case Study: Copying Files 691
17.6 Object I/O 692
17.7 Random-Access Files 697
 Chapter 18 Recursion 705
18.1 Introduction 706
18.2 Case Study: Computing Factorials 706
18.3 Case Study: Computing Fibonacci Numbers 709
18.4 Problem Solving Using Recursion 712
18.5 Recursive Helper Methods 714
18.6 Case Study: Finding the Directory Size 717
18.7 Case Study: Tower of Hanoi 719
18.8 Case Study: Fractals 722
18.9 Recursion vs. Iteration 726
18.10 Tail Recursion 727
 Chapter 19 Generics 737
19.1 Introduction 738
19.2 Motivations and Benefits 738
19.3 Defining Generic Classes and Interfaces 740
19.4 Generic Methods 742
19.5 Case Study: Sorting an Array of Objects 744
19.6 Raw Types and Backward Compatibility 746
19.7 Wildcard Generic Types 747
19.8 Erasure and Restrictions on Generics 750
19.9 Case Study: Generic Matrix Class 752
 Chapter 20 Lists, Stacks, Queues, 
  and Priority Queues 761
20.1 Introduction 762
20.2 Collections 762
20.3 Iterators 766
20.4 Lists 767
20.5 The Comparator Interface 772
20.6 Static Methods for Lists and Collections 773
20.7 Case Study: Bouncing Balls 777
20.8 Vector and Stack Classes 781
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
Contents xvii
20.9 Queues and Priority Queues 783
20.10 Case Study: Evaluating Expressions 786
 Chapter 21 Sets and Maps 797
21.1 Introduction 798
21.2 Sets 798
21.3 Comparing the Performance of Sets and Lists 806
21.4 Case Study: Counting Keywords 809
21.5 Maps 810
21.6 Case Study: Occurrences of Words 815
21.7 Singleton and Unmodifiable Collections and Maps 816
 Chapter 22 Developing Efficient Algorithms 821
22.1 Introduction 822
22.2 Measuring Algorithm Efficiency Using Big O Notation 822
22.3 Examples: Determining Big O 824
22.4 Analyzing Algorithm Time Complexity 828
22.5 Finding Fibonacci Numbers Using Dynamic Programming 831
22.6 Finding Greatest Common Divisors Using Euclid’s Algorithm 833
22.7 Efficient Algorithms for Finding Prime Numbers 837
22.8 Finding the Closest Pair of Points Using Divide-and-Conquer 843
22.9 Solving the Eight Queens Problem Using Backtracking 846
22.10 Computational Geometry: Finding a Convex Hull 849
 Chapter 23 Sorting 861
23.1 Introduction 862
23.2 Insertion Sort 862
23.3 Bubble Sort 864
23.4 Merge Sort 867
23.5 Quick Sort 870
23.6 Heap Sort 874
23.7 Bucket Sort and Radix Sort 881
23.8 External Sort 883
 Chapter 24 Implementing Lists, Stacks, Queues, 
  and Priority Queues 895
24.1 Introduction 896
24.2 Common Features for Lists 896
24.3 Array Lists 900
24.4 Linked Lists 906
24.5 Stacks and Queues 920
24.6 Priority Queues 924
 Chapter 25 Binary Search Trees 929
25.1 Introduction 930
25.2 Binary Search Trees 930
25.3 Deleting Elements from a BST 943
25.4 Tree Visualization and MVC 949
25.5 Iterators 952
25.6 Case Study: Data Compression 954
 Chapter 26 AVL Trees 965
26.1 Introduction 966
26.2 Rebalancing Trees 966
26.3 Designing Classes for AVL Trees 969
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
xviii Contents
26.4 Overriding the insert Method 970
26.5 Implementing Rotations 971
26.6 Implementing the delete Method 972
26.7 The AVLTree Class 972
26.8 Testing the AVLTree Class 978
26.9 AVL Tree Time Complexity Analysis 981
 Chapter 27 Hashing 985
27.1 Introduction 986
27.2 What Is Hashing? 986
27.3 Hash Functions and Hash Codes 987
27.4 Handling Collisions Using Open Addressing 989
27.5 Handling Collisions Using Separate Chaining 993
27.6 Load Factor and Rehashing 993
27.7 Implementing a Map Using Hashing 995
27.8 Implementing Set Using Hashing 1004
 Chapter 28 Graphs and Applications 1015
28.1 Introduction 1016
28.2 Basic Graph Terminologies 1017
28.3 Representing Graphs 1019
28.4 Modeling Graphs 1024
28.5 Graph Visualization 1034
28.6 Graph Traversals 1037
28.7 Depth-First Search (DFS) 1038
28.8 Case Study: The Connected Circles Problem 1042
28.9 Breadth-First Search (BFS) 1045
28.10 Case Study: The Nine Tails Problem 1048
 Chapter 29 Weighted Graphs and Applications 1061
29.1 Introduction 1062
29.2 Representing Weighted Graphs 1063
29.3 The WeightedGraph Class 1065
29.4 Minimum Spanning Trees 1072
29.5 Finding Shortest Paths 1078
29.6 Case Study: The Weighted Nine Tails Problem 1086
 Chapter 30 Multithreading and Parallel 
  Programming 1097
30.1 Introduction 1098
30.2 Thread Concepts 1098
30.3 Creating Tasks and Threads 1098
30.4 The Thread Class 1102
30.5 Case Study: Flashing Text 1105
30.6 Thread Pools 1106
30.7 Thread Synchronization 1108
30.8 Synchronization Using Locks 1112
30.9 Cooperation among Threads 1114
30.10 Case Study: Producer/Consumer 1119
30.11 Blocking Queues 1122
30.12 Semaphores 1124
30.13 Avoiding Deadlocks 1126
30.14 Thread States 1126
30.15 Synchronized Collections 1127
30.16 Parallel Programming 1128
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
Contents xix
 Chapter 31 Networking 1139
31.1 Introduction 1140
31.2 Client/Server Computing 1140
31.3 The InetAddress Class 1147
31.4 Serving Multiple Clients 1148
31.5 Sending and Receiving Objects 1151
31.6 Case Study: Distributed Tic-Tac-Toe Games 1156
 Chapter 32 Java Database Programming 1173
32.1 Introduction 1174
32.2 Relational Database Systems 1174
32.3 SQL 1178
32.4 JDBC 1189
32.5 PreparedStatement 1197
32.6 CallableStatement 1199
32.7 Retrieving Metadata 1202
 Chapter 33 JavaServer Faces 1213
33.1 Introduction 1214
33.2 Getting Started with JSF 1214
33.3 JSF GUI Components 1222
33.4 Processing the Form 1226
33.5 Case Study: Calculator 1230
33.6 Session Tracking 1233
33.7 Validating Input 1235
33.8 Binding Database with Facelets 1239
33.9 Opening New JSF Pages 1245
Bonus Chapters 34–42 are available from the Companion Website at 
www.pearsonhighered.com/liang:
 Chapter 34 Advanced JavaFX 34-1
 Chapter 35 Advanced Database Programming 35-1
 Chapter 36 Internationalization 36-1
 Chapter 37 Servlets 37-1
 Chapter 38 JavaServer Pages 38-1
 Chapter 39 Web Services 39-1
 Chapter 40 2-4 Trees and B-Trees 40-1
 Chapter 41 Red-Black Trees 41-1
 Chapter 42 Testing Using JUnit 42-1
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
xx Contents
APPENDIXES
Appendix A Java Keywords 1263
 Appendix B The ASCII Character Set 1266
 Appendix C Operator Precedence Chart 1268
 Appendix D Java Modifiers 1270
 Appendix E Special Floating-Point Values 1272
 Appendix F Number Systems 1273
 Appendix G Bitwise Operations 1277
 Appendix H Regular Expressions 1278
 Appendix I Enumerated Types 1283
INDEX 1289
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
xxi
Chapter 1 Introduction to Computers, Programs, 
  and Java 1
Your first Java program 12
Compile and run a Java program 17
NetBeans brief tutorial 23
Eclipse brief tutorial 25
Chapter 2 Elementary Programming 33
Obtain input 37
Use operators / and % 52
Software development process 59
Compute loan payments 60
Compute BMI 72
Chapter 3 Selections 75
Program addition quiz 77
Program subtraction quiz 87
Use multi-way if-else statements 90
Sort three integers 110
Check point location 112
Chapter 4  Mathematical Functions, 
Characters, and Strings 119
Introduce math functions 120
Introduce strings and objects 130
Convert hex to decimal 143
Compute great circle distance 151
Convert hex to binary 153
Chapter 5 Loops 157
Guess a number 161
Multiple subtraction quiz 164
Minimize numeric errors 178
Display loan schedule 194
Sum a series 195
Chapter 6 Methods 203
Define/invokemax method 206
Usevoid method 209
Modularize code 215
Stepwise refinement 225
Reverse an integer 234
Estimate p 237
Chapter 7 Single-Dimensional Arrays 245
Random shuffling 250
Deck of cards 254
Selection sort 269
VideoNotes
Locations of VideoNotes
http://www.pearsonhighered.com/liang
Command-line arguments 272
Coupon collector’s problem 281
Consecutive four 283
Chapter 8 Multidimensional Arrays 287
Find the row with the largest sum 292
Grade multiple-choice test 294
Sudoku 298
Multiply two matrices 307
Even number of 1s 314
Chapter 9 Objects and Classes 321
Define classes and objects 322
Use classes 334
Static vs. instance 337
Data field encapsulation 344
The Fan class 362
Chapter 10 Object-Oriented Thinking 365
TheLoan class 367
TheBMI class 370
TheStackOfIntegers class 378
Process large numbers 384
TheString class 386
TheMyPoint class 400
Chapter 11 Inheritance and Polymorphism 409
Geometric class hierarchy 410
Polymorphism and dynamic binding demo 424
TheArrayList class 432
TheMyStack class 439
NewAccount class 446
Chapter 12 Exception Handling and Text I/O 449
Exception-handling advantages 450
Create custom exception classes 470
Write and read data 476
HexFormatException 489
Chapter 13 Abstract Classes and Interfaces 495
AbstractGeometricObject class 496
Calendar and GregorianCalendar classes 503
The concept of interface 506
Redesign the Rectangle class 530
Chapter 14 JavaFX Basics 535
Understand property binding 542
UseImage and ImageView 549
Use layout panes 552
VideoNote
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
xxii VideoNotes
Use shapes 560
Display a tictactoe board 578
Display a bar chart 580
Chapter 15 Event-Driven Programming 
  and Animations 585
Handler and its registration 592
Anonymous handler 595
Move message using the mouse 602
Animate a rising flag 608
Flashing text 614
Simple calculator 621
Check mouse point location 622
Display a running fan 625
Chapter 16 JavaFX UI Controls and Multimedia 629
UseListView 647
UseSlider 654
TicTacToe 657
Use Media, MediaPlayer, and MediaView 662
Audio and image 666
Use radio buttons and text fields 669
Set fonts 671
Chapter 17 Binary I/O 677
Copy file 691
Object I/O 693
Split a large file 702
Chapter 18 Recursion 705
Binary search 716
Directory size 717
Fractal (Sierpinski triangle) 722
Search a string in a directory 733
Recursive tree 736
```

</details>
