# 3-1 What is a Variable

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 3-1 What is a Variable.pdf

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
3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Understand the benefits of variables
- Identify four main types of variables:
• boolean,  int ,  double,  String
- Declare and assign values to variables
- Name variables according to conventions
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Run Ja vaLibs.jar
• Consider the types of data this program asks for
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What is a Variable?
• Consider the variable x i n an equation
• We can assign any value to x
𝑦𝑦 = −2𝑥𝑥 + 5
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is a Variable in Java?
• Similarly, we can assign values to Java variables
- Writing t he line String x = "Alex" is like we're assigning a 
variable x a value of “Alex”
- Writing ("My  name is " + x) is equivalent to writing, “My name 
is Alex”
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Disadvantage Without Variables
• Code isn’t flexible
• To replace the name “Alex ,” you must make many changes in 
many places
- Tedious editing
- Risk of missing an “Alex”
System.out.println("My name is Alex");
System.out.println("Alex is so cool!"); 
System.out.println("Hooray Alex!"); 
System.out.println("Please enjoy Alex Appreciation " 
+ "Day! My name is Alex. I know how excited " 
+ "everyone is to start appreciating Alex on Alex" 
+ "Appreciation Day! Alex, Alex, Alex! Yay " 
+ "Alex!!! That's me! Alex is the best date ever!");
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Advantage with Variables
• Code becomes flexible
- Remember and manipulate values
• To replace the name “Alex, ” you make one change
- Efficient editing
- No risk of 
mi
ssing 
an “Alex” 
String x = "Sam";
System.out.println("My name is " + x );
System.out.println(x + " is so cool!"); 
System.out.println("Hooray " + x +"!"); 
System.out.println("Please enjoy " + x + " Appreciation " 
+ "Day! My name is " + x + ". I know how excited " 
+ "everyone is to start appreciating " + x 
+ " on " + x + "Appreciation Day! " + x + "," + x + "," 
+ x + "! Yay " + x + "!!! That's me! " + x 
+ " is the best date ever!");
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
More Advantage with Variables
• Manipulate values many times in several ways:
- Directly change values yourself (shown below)
- Programmatically change calculated values
- Change based on user input
5  String x = "Alex"; 
6  x = "Sam"; 
7  x = "Nicky"; 
8  x = "Mystery Date"; 
9 
10 "backwards" = x; //Can't do this
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Create a new project and add the Variables02.java fi le to the 
project
• Follow the steps in the exercise
• Run the program between each step and observe the output
• Your program should produce the following outputs:
- After Step 1) puppypuppy
- After Step 2) kittykitty
- After Step 3) kittybunny
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Line-by-Line Nature of Programs
• From line 8 onward, x always equals "kitty" until …
• Line 14  onward where x always equal "bunny"
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Many Variable Types
• Variables can exist for many different data types in Java
• Here are the variables that you’ve seen:
Type Keyword Example Values
Boolean boolean true, false
Integer int 1, -10, 20000, 123_456_789
Double double 1.0, -10.0005, 3.141
String String "Alex", "I ate too much dinner."
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Declaring a Variable
• Java is a “strongly typed language”
- You must declare what type of data your variable will handle by 
us
ing keywords
boolean bool;
int x;
double y;
String z;
• After you declare a variable …
- That variable exists
- There’s no need to declare it again
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Options for Declaring and Assigning Values
• Declare and assign a variable in a single line
boolean bool = true;
• Declare a variable in one line and assign a value later
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Assigning Bad Values
• Assigned values must be appropriate for the data type you've 
de
clared
int x = 3; //Correct data type   
int z = "Puppies!"; //Incorrect data type
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Inappropriate Math Values
• We can assign any number value to x
• We can’t assign a String value to x
- This doesn’t make sense!
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 1
• Create a new project and add the Variables03.java fi le to the 
project
- There are six mistakes in this program
- Can you fix these mistakes so that the program produces the 
f
ollowing output? bool = true
intVar1 = 1
intVar2 = 2
intVar3 = 3
doubleVar1 = 1.1
doubleVar2 = 2.1
doubleVar3 = 3.1
doubleVar4 = 4.1
stringVar1 = 11
stringVar2 = 22
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Hints 1
• Your IDE underlines problematic code
- Hold the cursor over the code or icon in the left margin for details
- Your IDE may hint at possible solutions
- Click the icon in the left margin
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Hints 2
• Your IDE’s s uggested solutions are sometimes bad
- Don’t rely entirely on your IDE’s hinted solutions
• Your own problem-solving skills can be a wonderful resource
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mistakes with Variables, 1 of 2
• Assigning inappropriate values for a variable type
int intVar1 = true; 
• Forgetting to declare a variable’s type
intVar3 = 3;
• Misspelling a variable
double doubleVar2; 
doublevAr2 = 2.1; //Java is case-sensitive 
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mistakes with Variables, 2 of 2
• Declaring the same variable twice
double doubleVar3;
double doubleVar3 = 3.1;
• Forgetting to assign a value before using a variable
double doubleVar4;
System.out.println(doubleVar4);
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Y ou May Have Noticed …
• It’s possible to declare many variables in a single line
double doubleVar1, doubleVar2, doubleVar3;
• It’s possible to assign values when declaring many variables
double doubleVar1, doubleVar2, doubleVar3 = 3.1;
• It’s a matter of personal preference either to …
• Declare every variable on separate lines
• Declare all variables of a given type in a single line
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Bad Variable Naming, 1 of 2
• You can name a variable almost anything you want
int dsfdsfspoop = 20; //Ha ha!
- This might be funny, but …
- Wi
ll you or a friend understand what data dsfdsfspoop 
represents when you read the code?
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Bad Variable Naming, 2 of 2
• Tiny names are usually discouraged
int x = 20;
- This is useful for testing …
- And commonly found in small loops (covered later), but …
- Will you or a friend understand what data x r epresents when you 
read the code?
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Very Bad Variable Naming
• Variables can’t share the same name
int x = 20; 
double x = 22.0; 
System.out.println(x); //Which x? 
• Variables can’t start with numbers
boolean 1337Hacker = true;
• Keywords can’t be used for variables names
int continue = 20;
- Keywords turn blue in NetBeans
- Keywords have special meanings in Java
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Variable Naming Conventions
• Begin each variable with a lowercase letter
•  Subsequent words should be capitalized: 
-  myVariable
• Choose names that are mnemonic and that indicate the intent of 
the variable to the casual observer
• Remember that …
- Names are case-sensitive
- Names can’t include white space
int studentAge = 20; 
String myCatchPhrase = "Enjoy Alex Appreciation Day!"; 
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 3-1
What Is a Variable?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Understand the benefits of variables
- Identify four main types of variables:
• (boolean ,  int,  double,  String)
- Declare and assign values to variables
- Name variables according to conventions
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text

```

</details>
