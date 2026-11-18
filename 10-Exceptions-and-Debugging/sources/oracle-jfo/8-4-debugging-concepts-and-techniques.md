# 8-4 Debugging Concepts and Techniques

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 8-4 Debugging Concepts and Techniques.pdf

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
8-4
Debugging Concepts and 
Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives: 
- Test and debug a Java program
- Identify the three types of errors
- Apply debugging techniques
• print s tatements
• Using your IDE’s debugger
- Apply some debugging tips and 
t
echniques
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Testing a Java Program, 1 of 2
• Richie wrote a Java program to find the maximum among three 
i
ntegers: public static void main(String[] args) {
    int num1 = 3, num2 = 3, num3 = 3;
    int max = 0;
    if (num1 > num2 && num1 > num3) {
        max = num1;
    }//endif
    if (num2 > num1 && num2 > num3) {
        max = num2;
    }//endif
    if (num3 > num1 && num3 > num2) {
        max = num3;
    }//endif
    System.out.println("The max of 3 numbers is " + max);
}//end method main
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Testing a Java Program, 2 of 2
• Richie tested it on many sets of data, such as <3,5,9 >, 
<12,1,6>, and <2,7,4> 
• The program works for all data
• However, he was told that the program doesn’t work, and he 
coul
dn’t figure out why
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new project and add the MaxIntegers.java fi le to the 
project
• Observe MaxIntegers.java
- Can you identify what Richie missed in his testing?
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Identify the Error
• The program fails when it’s tested with duplicate values, such as 
<3,3,3
> and <7,2,7>, and it displays the output as zero
- You identified the error
- The next step is to fix the error
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Fix the Error
• Modify the program and test it on many data sets, including 
dup
licate values
public static void main(String[] args) {
    int num1 = 3, num2 = 3, num3 = 3;
    int max = 0;
    if (num1 > max) {
        max = num1;
    }//endif
    if (num2 > max) {
        max = num2;
    }//endif
    if (num3 > max) {
        max = num3;
    }//endif
    System.out.println("The max of 3 numbers is " + max);
}//end method main
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Testing and Debugging, 1 of 2
• As you observed from the previous example, testing and 
de
bugging are important activities in software development
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Testing and Debugging, 2 of 2
• T esting:
- To determine if a code contains errors
• Debugging: 
- To identify an error and fix it
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Three Types of Errors
• Errors
- Compilation errors
- Logic errors
- Runtime errors
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Compilation Errors
• Syntax error
• Easiest type of errors to fix
• Examples:
- Example 1: Mi ssing semicolon
int a = 5 // semicolon is missing
- Example 2: E rrors in expression
x = ( 3 + 5; // missing closing parenthesis 
y = 3 + * 5;// missing argument between '+' and '*' 
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Logic Errors
• Program runs but produces incorrect result
• Hard to characterize, and so it’s hardest to fix
• Example: Noninitialized variable
int i; 
i++; // the variable i isn’t initialized
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Runtime Errors
• These errors occur at run time
• Java’s exception handling mechanism can catch such errors
• Some of the common exceptions:
-ArrayIndexOutOfBounds
-NullPointerException
-ArithmeticException 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Debugging Techniques
• Let’s look at two debugging techniques:
- Using print  statements
- Using an IDE debugger
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
print Statements: Advantages
• Easy to add
• Provide information
- Which methods have been called
- The value of parameters
- The order in which methods have been called
- The values of local variables and fields at strategic points
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
print Statements: Disadvantages
• It isn’t practical to add print  statements to every method
• Too many print s tatements lead to information overload
• Removal of print  statements is tedious
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
print Statements: Example
• Consider this Java code:
int n = 10;
int sum = 10; 
while (n > 1){
    sum = sum + n;
    n--;
}//end while
System.out.println("The sum of the integers 1 to 10 is " + sum);
• On running this program, it doesn’t work correctly
• To find out what’s wrong, you can trace the value of the n and 
s
um variables by inserting print statements
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Modified Program with Additional print 
Statements for Debugging
int n = 10; 
int sum = 10; 
while (n > 1) {
   
  System.out.println("At the beginning of the loop: n = " + n); 
  System.out.println("At the beginning of the loop:sum= " + sum); 
  n--; 
  System.out.println("At the end of the loop: n = " + n); 
  System.out.println("At the end of the loop: sum = " + sum);
}
System.out.println("The sum of the integers 1 to 10 is " + sum);
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Output, 1 of 2
• Here are the first four lines of the output after the first iteration 
of
 the loop: 
- At the beginning of the loop: n = 10
- At the beginning of the loop: sum = 10
- At the end of the loop: n = 9
- At the end of the loop: sum = 20
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Output, 2 of 2
• You can see that something is wrong:
- The variable sum  has been set to 20
- Because it was initialized to 10, it’s set to 10 + 10, which is 
i
ncorrect if you want to add the numbers from 1 to 10
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The IDE Debugger 
• You have already used the IDE graphical- based debugging 
environment
• You have used the following features of the debugger:
- Set breakpoints
- Trace through a program one line at a time
• Let’s use another very important feature to view the contents of 
v
ariables
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Variables Window
• When you reach a set breakpoint, you can use the V ariables 
window to see the value of the variables at that moment
• You can find out values of variables without having to put a lot of 
pr
int statements in your program
• The following slides demonstrate using the debugger in 
N
etBeans 
• If you are using a different IDE, consult the documentation for 
h
ow to do this
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing the Variables Window
• To see the V ariables window, in the NetBeans main menu:
-  C lick Window > Debugging > Variables
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2: Scenario
• Let’s assume you have a car, and you want to go to the gas 
s
tation, you have the following details:
- Car’s current position: x1  and y1
- Gas station’s location: x2 an d y2
- Speed of the car
• You want to compute the time it will take for the car from its 
cur
rent position (x1,y1) to reach the gas station (x2,y2)
• A Java program to compute the time by using the 
t
ime=distance/speed formula is available in the ComputeTime 
project
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Add the file ComputeTime.java to the project you created for 
Exercise 1
• Observe ComputeTime.java
• Run the program with your IDE’s debugger to debug this program: 
- Set the breakpoint in the getDistance() me thod 
- Press St ep I n to go to the next line       
- Observe the values of the x1 , x2, y1, y2, speed, distance, and 
time variables
• Can you identify the bug?
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Observe the Value of distance
• In the previous exercise using your IDE’s debugging features, you 
i
dentified the bug:
• As you can see, distance  is 0.0, the formula for computing 
distance was wrong, and it caused an incorrect return value for 
the distance variable
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Identifying the Potential Bug
public static void main(String[] args) {
   double x1 = 20;
   double x2 = 30;
   double y1 = 10;
   double y2 = 10;
   double speed = 0.3;
   double distance = getDistance(x1, x2, y1, y2);
   double time = distance/speed;
   System.out.println("Time taken to reach the gas station is " + time);
}//end method main
    
static double getDistance(double x1, double x2, double y1,double y2){
   return Math.sqrt((x1 - x1) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}//end method getDistance
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Fixing the Bug
• Because you identified the bug, you can change the location of 
t
he breakpoint to where the getDistance() method is called
• This saves having to step through code that you already looked 
at
• So let’s modify the code and rerun the debugger with the new 
br
eakpoint to see what we get
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Rerunning the Debugger
public static void main(String[] args) {
   double x1 = 20;
   double x2 = 30;
   double y1 = 10;
   double y2 = 10;
   double speed = 0.3;
   double distance = getDistance(x1, x2, y1, y2);
   double time = distance/speed;
   System.out.println("Time taken to reach the gas station is " + time);
}//end method main
    
static double getDistance(double x1, double x2, double y1,double y2){
   return Math.sqrt((x1 – x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}//end method getDistance
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Observing the Variables
• We fixed the bug!
- The distance  variable is now reporting a value of 10.0, and the 
time variable is now reporting a value of 33.33
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Single Versus Double Equals Operator
• Assignment (=)  versus Comparison (==) Operator
- 1. Comparison operator
if( x = 0)
instead of 
if(x == 0)
• Look for it in if , for, and while statements
- 2. Assignment operator
int x == 1; 
instead of 
int x = 1;
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Misplaced Semicolon
• Check for the semicolon after the if statement or the 
for
/while loop statements
if (x == 0); {
 <statements>
} 
instead of
    
if(x == 0) {
 <statements>
} 
while(<boolean expression>); {
 <statements>
}
instead of
while(<boolean expression>) {
 <statements>
}
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Invoking Methods with Wrong Arguments
• Method call parameter types must match method definition 
pa
rameter types
• For example: 
- Given a method definition:
void methodName(int x, char y) 
- Invoke this method:
methodName(a, b);
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Boundary Conditions
• It’s important to test the boundary conditions
• The rationale behind testing them is that errors tend to occur 
ne
ar the boundary values of an input variable
• For example, boundary condition for:
- Input data (test with valid versus invalid)
- Loops (beginning and ending of loops)
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Testing Boundary Conditions for Loops
• This allows for boundary case tests like “less than” and “greater 
t
han” for loop iteration conditions to be accurately tested
• For example, given this loop:
if ( num >= 50 && num <= 100 ) { 
   //do stuff 
}//endif
• To test boundary conditions, you would test with numbers near 
50 a
nd 100, that is, 49, 50, 51, 99, 100 and 101
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Add the file BoundaryTesting.java t o the project you created for 
Exercise 1
• Observe BoundaryTesting.java
• Validate the input by executing the program with the following 
bo
undary test values for year and month: Year Month
1582 2
1583 0
1583 13
1583 1
1583 12
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 8-4
Debugging Concepts and Techniques
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Test and debug a Java program
- Identify the three types of errors
- Apply debugging techniques
• print s tatements
• Using your IDE’s debugger
- Apply some debugging tips and techniques
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text

```

</details>
