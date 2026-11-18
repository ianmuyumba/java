# 5-2 Understanding Conditional Execution

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 5-2 Understanding Conditional Execution.pdf

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
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
When Multiple Conditions Apply
• What if a particular action is to be taken only if several conditions
a
re true?
• Consider the scenario where a student is eligible for scholarship
i
f the following two conditions are met:
- Grade should be >= 88
- Number of days absent = 0
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Handling Multiple Conditions
• Relational operators are fine when you’re checking only one
con
dition
• You can use a sequence ofif  statements to test more than one
condition
if (grade >= 88) {
 if (numberDaysAbsent == 0) {
  System.out. println("You qualify for the scholarship.");
 }//endif
}//endif
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Handling Multiple Conditions: Example
• As demonstrated in the example:
- The sequence ofif  statements is hard to write, harder to read, and
becomes even more difficult as you add more conditions
- Fortunately, Java has an easy way to handle multiple conditions:
lo
gical operators
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Java’s Logical Operators
• You can use Java’s three logical operators to combine multiple
bo
olean expressions into one boolean expression
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
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Applying Logical Operators
• You can write the previous example by using the logical AND
oper
ator as:
int grade >= 88 && numberDaysAbsent == 0
• The logical operator allows you to test multiple conditions more
eas
ily, and the code is more readable
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical AND Operator: Example
public static void main(String[] args) {
 int  numberDaysAbsent = 0;
 int  grade = 95;
 if (grade >= 88 && numberDaysAbsent == 0) {
  System.out. println("You qualify for the scholarship.");
 }
 else {
  System.out. println("You do not qualify for the "
  + "scholarship.");
 }//endif
}//end method main
Evaluates to true if both
boolean expressions
are true
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical OR Operators
• Consider a scenario where a student is eligible for a sports team
if
 one of the following two conditions are met:
- Grade >= 70
- Number of days absent < 5
• In this case, you can use the logical OR operator to connect the
mult
iple boolean expressions
grade >=70 || numberDaysAbsent < 5
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical OR Operators: Example
public static void main(String[] args) {
 int  numberDaysAbsent = 3;
 int  grade = 85;
 if (grade >= 70 || numberDaysAbsent < 5) {
  System.out. println("You qualify for a sports team");
 }
 else {
  System.out. println("You do not qualify for a sports"
  + " team");
 }//endif
}//end method main
Evaluates to true if either of
the boolean expressions
evaluates to true
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical NOT Operators, 1 of 2
• Consider a scenario where a student is eligible for free tutoring if
t
he following two conditions are met:
- Grade < 88
- Number of days absent < 3
• Use the ! l ogical operator
!madeFreeTutor && numberDaysAbsent < 3
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Logical NOT Operators, 2 of 2
public static void main(String args[]) {
 int  numberDaysAbsent = 2;
 int  grade = 65;
 boolean madeFreeTutor = grade >= 88;
 if (!madeFreeTutor && numberDaysAbsent < 3) {
  System.out. println("You qualify for free tutoring "
  + " help");
 }//endif
}//end method main
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new project and add the WatchMovie.java fi le to the
project
• Modify WatchMovi e.java to watch a movie that meets the
following two conditions:
• The movie price is greater than or equal to $12
• The movie rating is equal to 5
- Display the output as “I’m interested in watching the movie”
- Else display the output as “I am not interested in watching the
m
ovie”
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Skipping the Second AND Test, 1 of 2
• The && and ||  operators are short-circuit operators
• If the 1st expression (on the left) is false, there is no need to
ev
aluate the 2nd expression (on the right)
b = (x != 0) && ((y / x) > 2);
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Skipping the Second AND Test, 2 of 2
• If x is 0 then (x != 0)is false
• For the && ope rator, because it doesn’t matter whether
((y/x)>2)is true or false, the result of this expression is false
• So Java doesn’t continue evaluating ((y/x)>2 )
b = (x != 0) && ((y / x) > 2);
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Skipping the Second OR Test
• If the 1st expression (on the left) is true, there is no need to
e
valuate the 2nd expression (on the right)
• Consider this example:
boolean b = (x <= 10) || (x > 20);
• If (x<=10 ) is true, then (x>20) is not evaluated because it doesn’t
matter if (x>20) is true or false
• The result of this expression is true
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
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
 z =x;
}
else{
 z =y;
}//endif
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Ternary Conditional Operator: Scenario
• Assume that you’re playing a soccer game and you’re tracking
th
e goals as follows:
public static void main(String args[]) {
 int  numberOfGoals = 5;
 String s ;
 if (numberOfGoals == 1) {
  s =  "goal";
 }
 else {
  s =  "goals";
 }//endif
 System.out. println("I scored " + numberOfGoals + " " + s);
}//end method main
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Ternary Conditional Operator: Example, 1 of 2
• A similar result is achieved with the ternary operator by replacing
t
he entire if/else statement with a single line
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
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Add the file TernaryOperator.java to the project you created
for exercise 1
• Modify TernaryOp erator.java to duplicate the logic given in
the if/else statement by using the ternary operator
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Handling Complex Conditions with a Chained if
Construct
• The chained if  statement:
- Connects multiple conditions together into a single construct
- Tends to be confusing to read and hard to maintain
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
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
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Chaining if/else Constructs: Example
public static void main(String args[]) {
 double income = 30000, tax;
 if (income <= 15000) {
  tax =  0;
 }
 else if (income <= 25000) {
  tax =  0.05 * (income - 15000);
 }
 else {
  tax =  0.05 * (income - (25000 - 15000));
  tax +=  0.10 * (income - 25000);
 }//endif
}//end method main
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Can if Statements Be Nested?
• In Java, an if st atement can be present inside the body of
another if statement
if (tvType == "color") {
 if (size == 14) {
  discPercent = 8;
 }
 else {
  discPercent = 10;
 }//endif
}//endif
• In this example, the else st atement is paired with the if
statement (size==14)
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Understanding Nested if Statements
• In this example, the else s tatement is paired with the outer if
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
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, 1 of 2
• Add the file ComputeFare.java t o the project you created for
exercise 1
• Examine ComputeF are.java
• Implement the following using if/else constructs:
-  D eclare an integer variable, age
-  Ha ve the user enter the value for age
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, 2 of 2
• Using a chained if  construct, compute the fare based on  the
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
JFo 5 -2
Understanding Conditional Execution
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
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

```

</details>
