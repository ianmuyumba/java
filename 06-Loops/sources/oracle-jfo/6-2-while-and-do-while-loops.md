# 6-2 while and do-while Loops

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 6-2 while and do-while Loops.pdf

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
6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives: 
- Use a while  loop in a Java program (pre-test)
- Use a do -while loop in a Java program (post-test)
- Understand when one loop type may be more beneficial than 
a
nother
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Many Times to Repeat? 1 of 2
• In some situations, you don’t know how many times to repeat 
s
omething 
• That is, you may need to repeat some code until a particular 
con
dition occurs
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Many Times to Repeat? 2 of 2
• Let’s look at an example: 
- Let’s say you have to write a program to enter exam marks and find 
t
heir average, but you may not know how many exams are involved
- Instead of forcing users to count them all ahead of time, you can 
a
llow them to enter the marks one at a time and then enter -1 to 
indicate the completion of the entries
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
while Loop
• In such situations, you have to use the easier while l oop
• It works like this: 
- Thewhile loop continually executes a block of statements while a 
particular condition is true
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
while Loop Syntax
• The while statement evaluates  bo olean expression
• The statement(s) within the curly braces execute as long as 
bo
olean expression is true
while (<boolean expression>) { 
 <statement(s)> ; 
}//end while 
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Pre-Test Loop
• A pre- test loop evaluates the condition before the loop executes
• If the condition is false, the loop stops or may never execute
• for and while loops are pre- test loops
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Countdown Scenario
• Let’s write the Countdown scenario discussed in the previous 
le
sson by using the while loop:
What we know Technical Name Code
When the loop starts 
…
Initialization 
Expression
int i = 10;
Continue looping if 
…
Condition Expression i >= 0;
After each loop … Update Expression i--;
Code to repeat Code Statements System.out.println(i); 
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Countdown Scenario: while Loop
public class CountDownWhile { 
 public static void main(String[] args) { 
  int i = 10; 
  System.out. println("Countdown to Launch!"); 
  while (i >= 0) { 
   System.out. println(i); 
   i--; 
  }//end while 
  System.out.println("Blast Off!"); 
 }//end method main 
}//end class CountDownWhile 
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Some while Loops Never Run
• It’s possible that the loop body will never run if the conditions are 
su
ch that the boolean expression was already false, for example:
public class WhileLoopExample { 
 public static void main(String args[]) { 
  int  num = 0; 
  System.out. println("Let's count to 10!"); 
   while  (num > 10) { 
    num =  num + 1; 
    System.out. println("Number: " + num); 
   }//end while 
  System.out. println("We have counted to 10! Hurrah!"); 
 }//end method main 
}//end class WhileLoopExample 
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Getting Stuck in an Infinite Loop
• You’ll get stuck in a while  loop if you write a boolean condition 
that will never evaluate to false
• We call this an infinite loop because it never stops executing
• If this happens, your loop will execute forever or until you send 
a
n interrupt command
• You should avoid writing infinite loops and always verify the 
bo
olean expression to ensure that the loops terminate normally
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Let’s Return to the Countdown Scenario
• What if we had accidentally written i++ i nstead of i-- within 
thewhile loop?
int i = 10; 
System.out.println("Countdown to Launch!"); 
while (i >= 0) { 
 System.out.println(i); 
 i ++; 
}//end while 
System.out.println("Blast Off!"); 
• It would continue adding 1 to i, k eeping its value more than 10 
forever
• This is an infinite loop because the bo olean condition always 
remains true, and this program continues to execute
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using while Loop and Scanner Class, 1 of 2
•while loops are often used with input by using the Scanner class
public static void main(String[] args) { 
 Scanner console = new Scanner(System.in); 
 int  sum = 0; 
 System.out. println("Enter a number (-1 to quit): "); 
 int  num = console.nextInt(); 
 while  (num != -1) { 
  sum =  sum + num; 
  System.out. println("Enter a number (-1 to quit): "); 
  num =  console.nextInt(); 
 }//end while 
 System.out. println("The sum is " + sum); 
}//end method main 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using while Loop and Scanner Class, 2 of 2
• Example: 
- A program that prompts users for numbers until they type -1, a nd 
then outputs their sum
public static void main(String[] args) { 
 Scanner console = new Scanner(System.in); 
 int sum = 0; 
 System.out.println("Enter a number (-1 to quit): "); 
 int num = console.nextInt(); 
 while (num != -1) { 
  sum = sum + num; 
  System.out.println("Enter a number (-1 to quit): "); 
  num = console.nextInt(); 
 }//end while 
 System.out.println("The sum is " + sum); 
}//end method main 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new project and add the SquareRootWhile.java fi le 
to the project
• Modify SquareRoo tWhile.java to use a while loop to 
repeatedly prompt users to type a number until they type a non-
negative number, and then computes the square root
• Expected output: Type a non-negative integer: -5
Invalid number, try again: -1
Invalid number, try again: 11
The square root of 11 is 3.166
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Post-Test Loop
• A post- test loop evaluates its condition at the bottom of the loop 
instead of the top
• The do -while loop is a post-test loop
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
do-while Loop
• Thedo-while l oop is a modified while loop that allows you to 
execute the loop once, before testing the boolean condition 
• Syntax:
do{ 
<statement(s)> 
}while(<condition>); 
The do-while loop requires a semicolon after the 
condition at the end of the loop
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Countdown Scenario: do-while Loop
public static void main(String[] args) { 
 int  i = 10; 
 System.out. println("Countdown to Launch!"); 
 do { 
  System.out. println(i); 
  i--; 
 }while  (i >= 0); 
 System.out. println("Blast Off!"); 
}//end method main 
Executed once before 
evaluating the 
condition
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Add the file SumofNums.ja va to the project you created for 
exercise 1 
• Examine the SumofNum s.java, which sums up a sequence of 10 
integers that are input by the user 
• Can you implement the same by using a do-while loop?
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Standard for Loop Compared with while Loop, 
1 of 2
• Differences between these two loops:
•  In a for  loop:
- Initialization, condition, and increment statements are all put 
t
ogether in one line, which makes the loop easier to understand 
and implement
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Standard for Loop Compared with while Loop, 
2 of 2
• Differences between these two loops:
• In a while l oop:
- Initialization is done before the beginning of the loop
- The conditional statement is always put at the start of the loop
- Increment statements can be either combined with condition or 
emb
edded into the body of the loop
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Comparing the  Initialization Counter
Loop while
int i = 10; 
while (i >= 0) { 
 System.out. println(i); 
 i--; 
}//end while 
System.out.println("Blast Off!"); 
Loop for 
for (int i = 10; i >= 0; i--) { 
 System.out. println(i); 
}//end for 
System.out.println("Blast Off!"); 
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Comparing the  Boolean Expression
Loop while
int i = 10; 
while (i >= 0) { 
 System.out. println(i); 
 i--; 
}//end while 
System.out.println("Blast Off!"); 
Loop for 
for (int i = 10; i >= 0; i--) { 
 System.out. println(i); 
}//end for 
System.out.println("Blast Off!"); 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Comparing the Increment Counter
Loop while
int i = 10; 
while (i >= 0) { 
 System.out. println(i); 
 i--; 
}//end while 
System.out.println("Blast Off!"); 
Loop for 
for (int i = 10; i >= 0; i--) { 
 System.out. println(i); 
}//end for 
System.out.println("Blast Off!"); 
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Which Loop Do I Use?
Loop Type Definition When to Use 
while
Pre-test loop that repeats until a 
specified condition is false
Use when you are not certain the 
number of times the loop should be 
executed or even if it should at all
do-while
Post-test loop that executes the loop 
before testing the condition, then 
repeats until the condition is false
Use when you know that the code 
must be executed at least once and 
possibly more times depending on 
the condition
for
Loop that contains an initialized 
counter and increments the counter 
with each run through the loop.  
Repeats until the condition is false
Use when you need to execute a 
loop a specific number of times, or 
when you need to increment 
through a set of data. The counter 
can also be used as an index for 
accessing data one item at a time
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 6-2
while and do-while loops
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Use a while loop in a Java program (pre-te st)
- Use a do-w hile loop in a Java program (post-test)
- Understand when one loop type may be more beneficial than 
a
nother
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text

```

</details>
