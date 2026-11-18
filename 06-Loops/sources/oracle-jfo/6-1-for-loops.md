# 6-1 for Loops

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 6-1 for Loops.pdf

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
6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives:
• This lesson covers the following objectives:
- Understand the components of the standard for loop
- Understand how to create and use a for loop
- Understand variable scope
- Understand debugging techniques
- Explain how infinite loops occur in Java
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mission to Saturn’s Rings
• We’re going to launch a rocket ship
• Its mission is to study Saturn’s rings
• Do you have any thoughts on how to program a countdown 
t
imer?
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Countdown, 1 of 3
• Counting down from 10 requires 10 lines of code
System.out.println("Countdown to Launch: "); 
System.out.println(10); 
System.out.println(9); 
System.out.println(8); 
System.out.println(7); 
System.out.println(6); 
System.out.println(5); 
System.out.println(4); 
System.out.println(3); 
System.out.println(2); 
System.out.println(1); 
System.out.println("Blast Off!"); 
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Countdown, 2 of 3
• Counting down from 100 would require 100 lines of code
• That would be painful and tedious to program.
• Is there a more practical way to write this program?
• Can the code easily accommodate any starting value?
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Countdown, 3 of 3
System.out.println("Countdown to Launch: "); 
System.out.println(100); 
System.out.println(99); 
System.out.println(98); 
System.out.println(97); 
System.out.println(96); S
ystem.out.println(95); 
… 
… 
… 
… 
… 
… 
System.out.println(2); 
System.out.println(1); 
System.out.println("Blast Off!"); 
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Can Variables Help?
• Variables are somewhat helpful
• But we still have to copy and paste the same lines of code until 0 
p
rints
System.out.println("Countdown to Launch: "); 
int i = 10; 
System.out.println(i); 
i--; 
System.out.println(i); 
i--; 
System.out.println(i); 
i--; 
… 
System.out.println("Blast Off!"); 
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Repeating Code
• Can we make the same lines of code repeat a variable number of 
t
imes?
• Lines 7–1 0 show the block of code we want to repeat
• Remember the line-by- line nature of programs:
- When the program reaches line 10 …
- We want to loop back to line 7
5 int i = 10; 
6 
7 { 
8    System.out.println(i); 
9    i--; 
10} 
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Loop Statements 
• Loop statements are used to repeat lines of code. 
• Java provides three types of loops:
-for
-while
-do-whil e
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Repeating Behavior
while (!areWeThereYet) { 
 read book; 
 argue with sibling; 
 ask , "Are we there yet?"; 
} 
Woohoo!; 
Get out of car; 
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Loops
• Loops are used in programs for repeated execution of one or 
mo
re statements until a terminating condition is reached
- Until an expression is false
• or
- For a specific number of times:
• I want to print the numbers from 1 to 10
• I want to compute the sum of numbers in a given range
• A for loop executes a known number of times
- for loops are also called definite loops
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What We Know
• In the Countdown scenario, here’s what we know:
What We Know Technical Name Code
When the loop starts … Initialization Expression int i = 10;
Continue looping if … Condition Expression i >= 0;
After each loop … Update Expression i--;
Code to repeat Code Statements System.out.println(i); 
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
for Loop Overview, 1 of 2
• Syntax:
for(initialization; condition; update){ 
 Code statement(s) 
 Code statement(s) 
}//end for 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
for Loop Overview, 2 of 2
• The initialization expression initializes the loop, it’s executed only 
o
nce, as the loop begins
• When the condition expression evaluates to false, the loop 
t
erminates
• The update expression is invoked after each iteration through 
t
he loop, this expression can increment or decrement a value
• Each expression should be separated with a semicolon (;)
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Initialization Expression
• Performed once as the loop begins
• Tells the compiler what variable (called a loop counter) is used in 
t
he loop
• Can start at any value, not just 10
System.out.println("Countdown to Launch: "); 
for(int i = 10; i >= 0; i--) { 
 System.out. println(i); 
}//end for 
System.out.println("Blast Off!"); 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Condition Expression
• Looping continues as long as this boolean expression is true
• It uses comparison operators:
- (== , !=, <, >, <=, >=)
System.out.println("Countdown to Launch: "); 
for(int i = 10; i >= 0; i--) { 
 System.out. println(i); 
}//end for 
System.out.println("Blast Off!"); 
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Update Expression
• This statement is executed after each iteration of the for l oop
• It’s used to update the loop counter
System.out.println("Countdown to Launch: "); 
for(int i = 10; i >= 0; i--) { 
 System.out. println(i); 
}//end for 
System.out.println("Blast Off!"); 
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Create a new project and add the Countdown.java fi le to the 
project
• Set a breakpoint in Countdown .java and observe…
- How the for loop affects code execution
- How the value of i c hanges
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2 
• Can you modify the code to count up from 0 to 5?
• Can you modify the code to count all even numbers from 0 to 
20?
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Do I Need the Update Expression?
• What if I wrote my loop like this?
for(int i = 10; i >= 0; ) { 
 System.out. println(i); 
 i--; 
}//end for 
• This works, too!
• But you may not want to code this way, as your loops may 
b
ecome more complicated
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Omitting Expressions in the for Loop, 1 of 2
• Each expression in the header is optional
• But there are risks when you omit an expression:
- No initialization:
• No initialization is performed
• There may be no loop counter
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Omitting Expressions in the for Loop, 2 of 2
- No condition:
• The loop condition is always considered to be true
• The loop is an infinite loop
- No update:
• No increment operation is performed
• The loop counter keeps the same value
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Omitting All Expressions in the for Loop
• Examine the following code:
- All three expressions in the for loop can be omitted
- The loop repeats infinitely
for(;;){ 
 System.out. println("Welcome to Java"); 
}//end for 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Add the file InfiniteLoop.java t o the project you created for 
exercise 1
• Execute Infinite Loop.java and observe the output
• Modify the fo r loop in InfiniteLoop.java to print “Hello” five 
times
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Multiple statements within a loop body
• To execute multiple statements within a body …
• Enclose the statements within a pair of curly braces
• Otherwise, only the first statement in the body is executed
for(int i = 1; i <= 5; i++)
System.out.println(i);
System.out.println("second line");
• Output: 1
2
3
4
5
second line
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
One Use of the for Loop
• The for loop provides a compact way to iterate over a range of 
v
alues
• Repetition without the for loop:
//Prints the square of 1 through 5 
System.out.println("1 squared = " + 1 * 1); 
System.out.println("2 squared = " + 2 * 2); 
System.out.println("3 squared = " + 3 * 3); 
System.out.println("4 squared = " + 4 * 4); 
System.out.println("5 squared = " + 5 * 5); 
• Repetition with the for loop:
for(int i = 1; i <= 5; i++){ 
 System.out.println("i squared = " + i * i); 
}//end for 
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
i Is the Loop Counter, 1 of 2
• Every example we’ve seen relies on the loop counter
for(int i = 1; i <= 5; i++){ 
 System.out. println("i squared = " + i * i); 
}//end for 
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
i Is the Loop Counter, 2 of 2
• i can:
- Be printed
- Have its value changed
- Be used in calculations
• This is great for:
- Counting
- Calculating values quickly
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Understanding Variable Scope
• But i exists only within the for loop
- This is known as the scope of i
- i no longer exists when the for loop terminates
- If i is used to calculate values, we’ll never get those values out of 
t
he for loop
• Did you observe i disappear when you debugged 
Countdown.jav
a?
for(int i = 1; i <= 5; i++){ 
 System.out. println("i squared = " + i * i); 
}//end for 
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Variable Scope: Example
• Variable i declared in the for loop is a local variable and cannot be 
a
ccessed outside the loop
• Compiler error is generated at line 8
1 public class VariableScopeDemo { 
2 
3 public static void main(String args[]){ 
4 
5  for(int i = 0; i <= 5; i++ ){ 
6   System.out. println("i: " +i); 
7  }//end for 
8  System.out. println("i: " +i); 
9 }//end method main 
10}//end class VariableScopeDemo 
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Variable Scope
• Variables cannot exist before or outside their block of code
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Another Use for Loops, 1 of 2
• Suppose you need to find the sum of four numbers
import java.util.Scanner; 
public class Add4Integers  {
 public static  void main(String[] args){ 
  Scanner in = new Scanner(System.in);
  System.out. println("This program adds four numbers."); 
  System.out. println("Type each number, followed by Enter.");
  int  n1 = in.nextInt();
  int  n2 = in.nextInt();
  int  n3 = in.nextInt();  
  int  n4 = in.nextInt();
  int  total = n1 + n2 + n3 + n4;
  System.out. println("The total is " + total + ".");
 }//end method main
}//end class Add4Integers
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Another Use for Loops, 2 of 2
• This approach is cumbersome to program if you want to add 100 
v
alues
int n1 = in.nextInt(); 
int n2 = in.nextInt(); 
int n3 = in.nextInt(); 
int n4 = in.nextInt();
 … 
int n100 = in.nextInt(); 
int total = n1 + n2 + n3 + n4 +… + n100;
• Can a for  loop make this program shorter?
• Can a for  loop help find the sum of a variable number of 
integers?
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using Scope with for Loops
• This can be solved using …
- A for  loop with variables of different scope 
import java.util.Scanner; 
public class PracticeCode { 
public static void main(String[] args){
 Scanner in = new Scanner(System.in);
 int N = 100; 
 int total = 0; 
 System.out.println("This program adds " + N + " numbers.");
 for(int i = 0; i < N; i++){ 
 System.out.println(("Enter your next number:"); 
  int value = in.nextInt();
  total += value;
 } //end for
 System.out.println("The total is " + total + ".");  
}//end method main
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Scope
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Add the file ScopeTest.java t o the project you created for 
exercise 1 
•ScopeTest.java i s broken
• Can you fix it?
• You should get the following output:
-64 32 16 8 4 2 1 
-0 1 2 3 4 5 
-5 4 3 2 1 0 
-2 4 8 16 32 64
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Variable Already Defined
•i is created before the for loop
• Another i can’t exist within the same scope
• One of these variables needs a different name
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Out of Scope
• j can’t exist outside the scope where it was created
• A different j can be created if the scopes don’t overlap
39
```

</details>


## PDF page 40

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Do I Need the Initialization Expression?
• What if I wrote my loop like this?
int i = 10; 
for(; i >= 0; i--){ 
 System.out. println(i); 
}//end for 
• This works, too!
- But i ex ists outside the scope of the for loop
- If i i s only meant to be a loop counter, the variable is wasting 
memory
- Keep the scope narrow (as small as possible)
- Stray variables complicate code and increase the potential for bugs
40
```

</details>


## PDF page 41

<details>
<summary>Page text</summary>

```text
JFo 6-1
for Loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Understand the components of the standard for  loop
- Understand how to create and use a for  loop
- Understand variable scope
- Understand debugging techniques
- Explain how infinite loops occur in Java
41
```

</details>


## PDF page 42

<details>
<summary>Page text</summary>

```text

```

</details>
