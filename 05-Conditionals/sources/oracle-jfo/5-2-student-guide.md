# 5-2 Student Guide

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 5-2 Student Guide.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
1
Oracle Academy – Begin Lesson
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
2
Java Foundations
5-2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates.
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
3
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Describe conditional execution
- Describe logical operators
- Understand “short circuit” evaluation of logical operators
- Build chained if constructs
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
4
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
When Multiple Conditions Apply
• What if a particular action is to be taken only if several conditions
are true?
• Consider the scenario where a student is eligible for scholarship
if the following two conditions are met:
- Grade should be >= 88
- Number of days absent = 0
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
5
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Handling Multiple Conditions
• Relational operators are fine when you’re checking only one
condition
• You can use a sequence ofif statements to test more than one
condition
if (grade >= 88) {
 if (numberDaysAbsent == 0) {
  System.out.println("You qualify for the scholarship.");
 }//endif
}//endif
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
6
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Handling Multiple Conditions: Example
• As demonstrated in the example:
- The sequence ofif statements is hard to write, harder to read, and
becomes even more difficult as you add more conditions
- Fortunately, Java has an easy way to handle multiple conditions:
logical operators
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
7
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Java’s Logical Operators
• You can use Java’s three logical operators to combine multiple
boolean expressions into one boolean expression
Logic Operator Meaning
&& AND
|| OR
! NOT
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
8
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Three Logical Operators
Operation Operator Example
If one condition AND another
condition
&& int i = 2;
int j = 8;
((i < 1) && (j > 6))
If either one condition OR
both conditions
|| int i = 2;
int j = 8;
((i < 1) || (j > 10))
NOT ! int i = 2;
(!(i < 3))
8
The table in the slide lists the logical operators in the Java programming language. All
examples yield a boolean result of false.
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
9
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Applying Logical Operators
• You can write the previous example by using the logical AND
operator as:
int grade >= 88 && numberDaysAbsent == 0
• The logical operator allows you to test multiple conditions more
easily, and the code is more readable
9
In this example, you use the logical AND operator because both boolean expressions
must be true to make the student eligible for a scholarship.
Logical AND operator:
Combined condition is true if and only if both boolean expressions are true.
Combined condition is false if either or both of the boolean expressions are
false.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
10
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical AND Operator: Example
public static void main(String[] args) {
 int numberDaysAbsent = 0;
 int grade = 95;
 if (grade >= 88 && numberDaysAbsent == 0) {
  System.out.println("You qualify for the scholarship.");
 }
 else {
  System.out.println("You do not qualify for the "
  + "scholarship.");
 }//endif
}//end method main
Evaluates to true if both
boolean expressions
are true
10
This example illustrates the logical AND operator. For the output to be displayed as "You
qualify for the scholarship," the two conditions must be true. That is, the grade must be
greater than or equal to 88, and the number of days absent must be equal to zero.
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
11
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical OR Operators
• Consider a scenario where a student is eligible for a sports team
if one of the following two conditions are met:
- Grade >= 70
- Number of days absent < 5
• In this case, you can use the logical OR operator to connect the
multiple boolean expressions
grade >=70 || numberDaysAbsent < 5
11
Combined condition is true if either or both of the boolean expressions are true.
Combined condition is false if both of the boolean expressions are false.
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
12
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical OR Operators: Example
public static void main(String[] args) {
 int numberDaysAbsent = 3;
 int grade = 85;
 if (grade >= 70 || numberDaysAbsent < 5) {
  System.out.println("You qualify for a sports team");
 }
 else {
  System.out.println("You do not qualify for a sports"
  + " team");
 }//endif
}//end method main
Evaluates to true if either of
the boolean expressions
evaluates to true
12
This example illustrates using the logical OR operator. In this example, "You qualify for a
sports team" is displayed even if one of the conditions is true. That is, the grade must be
>= 70 or the number of days absent must be less than five.
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
13
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical NOT Operators, 1 of 2
• Consider a scenario where a student is eligible for free tutoring if
the following two conditions are met:
- Grade < 88
- Number of days absent < 3
• Use the ! logical operator
!madeFreeTutor && numberDaysAbsent < 3
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
14
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical NOT Operators, 2 of 2
public static void main(String args[]) {
 int numberDaysAbsent = 2;
 int grade = 65;
 boolean madeFreeTutor = grade >= 88;
 if (!madeFreeTutor && numberDaysAbsent < 3) {
  System.out.println("You qualify for free tutoring "
  + " help");
 }//endif
}//end method main
14
This example illustrates the logical ! operator. Because the grade is equal to 65,
!madeFreeTutor is true because madeFreeTutor is false.
The combined expression evaluates to true and the following output is displayed: "You
qualify for free tutoring help."
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
15
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new project and add the WatchMovie.java file to the
project
• Modify WatchMovie.java to watch a movie that meets the
following two conditions:
• The movie price is greater than or equal to $12
• The movie rating is equal to 5
- Display the output as “I’m interested in watching the movie”
- Else display the output as “I am not interested in watching the
movie”
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
16
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Skipping the Second AND Test, 1 of 2
• The && and || operators are short-circuit operators
• If the 1st expression (on the left) is false, there is no need to
evaluate the 2nd expression (on the right)
b = (x != 0) && ((y / x) > 2);
16
The evaluation is performed in left-to-right order and halts as soon as the result is
known. This means that the expression on the right side won’t be evaluated if it isn’t
necessary.
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
17
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Skipping the Second AND Test, 2 of 2
• If x is 0 then (x != 0)is false
• For the && operator, because it doesn’t matter whether
((y/x)>2)is true or false, the result of this expression is false
• So Java doesn’t continue evaluating ((y/x)>2)
b = (x != 0) && ((y / x) > 2);
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
18
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Skipping the Second OR Test
• If the 1st expression (on the left) is true, there is no need to
evaluate the 2nd expression (on the right)
• Consider this example:
boolean b = (x <= 10) || (x > 20);
• If (x<=10) is true, then (x>20) is not evaluated because it doesn’t
matter if (x>20) is true or false
• The result of this expression is true
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
19
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
What Is a Ternary Conditional Operator?
Operation Operator Example
If condition is true, assign result
= value1
Otherwise, assign result = value2
Note: value1 and value2 must
be the same data type
?: result=condition ? value1 :
value2
Example:
int x = 2, y = 5, z = 0;
z = (y < x) ? x : y;
Equivalent statements
z = (y < x) ? x : y;
if(y<x){
 z=x;
}
else{
 z=y;
}//endif
19
The ternary operator is a conditional operator that requires three operands. It has a more
compact syntax than an if/else statement.
Use the ternary operator instead of an if/else statement if you want to make your code
shorter.
There are three operands in the slide example:
(y < x): This boolean expression (condition) is being evaluated
? x : If (y < x) is true, z will be assigned the value of x
: y : If (y < x) is false, z will be assigned the value of y.
In the slide example, z = 5.
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
20
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Ternary Conditional Operator: Scenario
• Assume that you’re playing a soccer game and you’re tracking
the goals as follows:
public static void main(String args[]) {
 int numberOfGoals = 5;
 String s;
 if (numberOfGoals == 1) {
  s = "goal";
 }
 else {
  s = "goals";
 }//endif
 System.out.println("I scored " + numberOfGoals + " " + s);
}//end method main
20
Based on the number of goals scored, these examples will print the appropriate singular
or plural form of “goal.” The operation is compact because it can yield only two results
based on a boolean expression.
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
21
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Ternary Conditional Operator: Example, 1 of 2
• A similar result is achieved with the ternary operator by replacing
the entire if/else statement with a single line
int numberOfGoals = 1;
System.out.println("I scored " + numberOfGoals + " "
   + (numberOfGoals == 1 ? "goal" : "goals")
);
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
22
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Ternary Conditional Operator: Example, 2 of 2
• Advantage: Place the operation directly within an expression
int numberOfGoals = 1;
System.out.println("I scored " + numberOfGoals + " "
   + (numberOfGoals == 1 ? "goal" : "goals")
);
• Disadvantage: Can have only two potential results
(numberOfGoals==1 ? "goal" : "goals" : "More goals");
22
As you can see, the ternary operator can be useful to reduce the number of lines of code,
but it can make your code difficult to read and so it isn’t ideal for nested statements.
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
23
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Add the file TernaryOperator.java to the project you created
for exercise 1
• Modify TernaryOperator.java to duplicate the logic given in
the if/else statement by using the ternary operator
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
24
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Handling Complex Conditions with a Chained if
Construct
• The chained if statement:
- Connects multiple conditions together into a single construct
- Tends to be confusing to read and hard to maintain
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
25
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Chaining if/else Constructs
• You can chain if and else constructs together to state multiple
outcomes for several different expressions
• Syntax:
if (<condition1>) {
 //code_block1
}
else if (<condition2>) {
 // code_block2
}
else {
 // default_code
}//endif
25
The syntax for a chained if/else construct is shown in the slide example.
Each of the conditions is a boolean expression:
code_block1 represents the lines of code that are executed if condition1 is true
code_block2 represents the lines of code that are executed if condition1 is false
and condition2 is true
default_code represents the lines of code that are executed if both conditions
evaluate to false
Note: Multiple else if statements can be evaluated. The else statement is optional.
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
26
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Chaining if/else Constructs: Example
public static void main(String args[]) {
 double income = 30000, tax;
 if (income <= 15000) {
  tax = 0;
 }
 else if (income <= 25000) {
  tax = 0.05 * (income - 15000);
 }
 else {
  tax = 0.05 * (income - (25000 - 15000));
  tax += 0.10 * (income - 25000);
 }//endif
}//end method main
26
This example demonstrates chaining if/else constructs to test multiple conditions. The
else statement is executed if all conditions are false.
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
27
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Can if Statements Be Nested?
• In Java, an if statement can be present inside the body of
another if statement
if (tvType == "color") {
 if (size == 14) {
  discPercent = 8;
 }
 else {
  discPercent = 10;
 }//endif
}//endif
• In this example, the else statement is paired with the if
statement (size==14)
27
In a nested if statement, it’s very important to be sure which else construct goes with
which if construct. This indentation greatly aids the clarity of the code for a reader.
In this example, if the outer if statement is true, then the inner if statement is executed.
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
28
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Understanding Nested if Statements
• In this example, the else statement is paired with the outer if
statement (TVType=="color")
if (tvType == "color") {
 if (size == 14) {
  discPercent = 8;
 }//endif
}
else { discPercent = 10;
}//endif
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
29
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, 1 of 2
• Add the file ComputeFare.java to the project you created for
exercise 1
• Examine ComputeFare.java
• Implement the following using if/else constructs:
-  Declare an integer variable, age
-  Have the user enter the value for age
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
30
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, 2 of 2
• Using a chained if construct, compute the fare based on  the
age according to these conditions:
- If age is less than 11, then fare=3$
- If age is greater than 11 and less than 65, then fare=5$
- Else for all other ages, then fare=3$
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
31
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
JFo 5 -2
Understanding Conditional Execution
Summary
• In this lesson, you should have learned how to:
- Describe conditional execution
- Describe logical operators
- Understand “short circuit” evaluation of logical operators
- Build chained if constructs
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
32
Oracle Academy – End of Lesson
```

</details>
