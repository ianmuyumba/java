# 5-3 switch Statement

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 5-3 switch Statement.pdf

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
5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates.
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Create a switch control structure
- Compare if/else constructs with switch control structures
- Understand the purpose of the break keyword
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
What About Using an if/else Statement?
• Consider the scenario where you need to write a Java program to
i
mplement the following:
- User enters a school grade between 9 to 12 and the program prints
t
he name of the grade
• First, let’s start with a solution using an if/else s tatement
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Solution: if/else Statement
Scanner in = new Scanner(System.in);
System.out.println("Enter your grade");
int grade = in.nextInt();
if (grade == 9){
 System.out.println("You are a freshman");
}
else if (grade == 10) {
 System.out.println("You are a sophomore");
}
else if (grade == 11) {
 System.out.println("You are a junior");
}
else if (grade == 12) {
 System.out.println("You are a senior");
}
else { System.out.println("Invalid grade");
}//endif
Complex
conditions with a
chained if
construct tend to
be confusing to
read and hard to
maintain
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
The switch Statement, 1 of 2
• The switch s tatement provides more efficient syntax for
choosing among several alternatives
switch (<variable or expression>) {
 case <literal value>: //code_block1
    [break;]
 case <literal value>: // code_block2
    [break;]
 default: //default_code
}//end switch
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Solution: switch Statement
Scanner in = new Scanner(System.in);
System.out.println("What grade are you in?");
int grade = in.nextInt();
switch (grade) {
 case 9:
  System.out.println("You are a freshman");
  break;
 case 10:
  System.out.println("You are a sophomore");
  break;
 case 11:
  System.out.println("You are a junior");
  break;
 case 12:
  System.out.println("You are a senior");
  break;
 default:
  System.out.println("Invalid grade");
}//end switch
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
The switch statement, 2 of 2
• Compared with the if/else s tatement the switch statement:
- Is more streamlined than chained if statements
- Is easier to read and maintain
- Simplifies the organization of the various branches of code that
ca
n be executed
- Offers better performance
- Can be used for complex conditions
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
When to Use switch Constructs
• Use when you are testing:
- Equality (not a range)
- A single value
- For fixed known values at compile time
-int, short, byte , char, or String
int month = 8;
month = in.nextInt();
switch (month) {
case 1: case 3: case 5: case 7:
case 8: case 10: case 12: System.out.print("31 days");
    break;
case 2: if(isLeapYear)){
 ..
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
String in a switch Statement: Example
String typeOfDay;
String dayOfWeekArg = "Thursday";

switch (dayOfWeekArg) {
 case "Monday": typeOfDay = "Start of work week";
   break;
 case "Tuesday":
 case "Wednesday":
 case "Thursday": typeOfDay = "Midweek";
   break;
 case "Friday": typeOfDay = "End of work week";
   break;
 case "Saturday":
 case "Sunday": typeOfDay = "Weekend";
   break;
 default: System.out.print("Invalid");
}//end switch
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new project and add the SwitchEx1.java fi le to the
project
• Modify SwitchEx1 .java to implement the following with the
switch statement
- The user enters the month as a number
- The corresponding month name must be displayed
- For any invalid month, the output must be displayed as “Invalid
mon
th”
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
switch Statement: Keywords
• The following keywords are used in a switch statement:
- switch: Specifies the variable to test for value
- case: Compares the value of the switch variable
- default:  When the input doesn’t match the cases, then the default
statement is executed, however, the default statement is optional
- break:  Is used as the last statement in each case statement list, a
break statement causes control to transfer to the end of the switch
statement
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
What Is a break Keyword? 1 of 2
• Is used as the last statement in each case statement list and it
ca
uses control to transfer outside the switch
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
What Is a break Keyword? 2 of 2
char option = 'A’;
int aCount = 0, bCount = 0, cCount = 0;

switch (option) {
 case 'A': aCount++;
  System.out. println("Count of A " + aCount);
  break;
 case 'B': bCount++;
  System.out. println("Count of B " + bCount);
  break;
 case 'C': cCount++;
  System.out. println("Count of C " + cCount);
  break;
}//end switch
//additional code . . .
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 1 of 2
• Add the file SwitchEx2.java t o the project you created for
exercise 1
• Observe SwitchEx2.java and execute the program
• Observe the output
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 2 of 2
• Modify the switch statement as follows:
• Remove the break statements for case ‘A’
- Execute the program
- Observe the output
• Remove the break statements for case ‘A’ and case ‘B’
- Execute the program
- Observe the output
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
What Is switch Fall Through?
•switch f all through is a condition that occurs if there are no
break statements at the end of each case statement
• All statements after the matching ca se label are executed in
sequence, regardless of the expression of
subsequent case labels, until abreak statement is encountered.
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Understanding switch Fall Through
• Expected Output:
- The values of the count variables are incremented by 1
char option = 'A’;
int aCount = 0, bCount = 0, cCount = 0;
switch (option) {
 case 'A': aCount++;
  System.out.println("Count of A " + aCount);
 case 'B': bCount++;
  System.out.println("Count of B " + bCount);
  break;
 case 'C': cCount++;
  System.out.println("Count of C " + cCount);
  break;
}//end switch
No break statement, so it
continues execution with the
next case statement
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
switch Fall Through: Example
int month = 12;
switch (month) {
 case 2: System.out.println("28 days (29 in leap years)");
  break;
 case 4:
 case 6:
 case 9:
 case 11: System.out.println("30 days");
  break;
 case 1:
 case 3:
 case 5:
 case 7:
 case 8:
 case 12: System.out.println("31 days");
  break;
 default: System.out.println("Illegal month number");
  break;
}//end switch
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 5-3
switch Statement
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Create a switch control structure
- Compare if/else constructs with switch control structures
- Understand the purpose of the break keyword
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text

```

</details>
