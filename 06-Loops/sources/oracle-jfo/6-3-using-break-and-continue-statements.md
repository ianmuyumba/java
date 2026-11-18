# 6-3 Using break and continue Statements

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 6-3 Using break and continue Statements.pdf

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
6-3
Using break and continue 
Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
3
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Use a break statement to exit a loop
- Use a continue statement to skip part of a loop
- Explain the need for loop comments
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
4
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mission to Saturn’s Rings
• Let’s consider another scenario for this mission
- As the spaceship is rotating around Saturn and taking snapshots, 
the robotic arm or camera breaks
• How would you solve this problem?
- If you were to write a Java program, which construct would you 
use?
- Let’s see whether Java has a statement that enables you to end a 
loop immediately
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
5
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do You Exit a Loop Early? 1 of 2
• Usually, the only way to exit a loop is for the loop condition to 
evaluate to false
• However, it’s often convenient to terminate a loop early when 
certain conditions are met
• In such cases, continuing to loop would be a waste of processor 
time
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
6
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do You Exit a Loop Early? 2 of 2
• You can use two Java statements to terminate a loop early:
-break
-continue
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
7
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using break in a Loop
• When a break statement is executed inside a loop, the loop 
statement is terminated immediately
• The program continues to execute with the statement following 
the loop statement
• Syntax: break; 
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
8
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using break in a while Loop
while(condition){ 
 statement1; 
 statement2; 
 break; 
 statement3; 
 statement4 
} 
statement;   [statement outside the while loop] 
Control passes to the 
statement outside the 
loop
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
9
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using break in a while Loop: Example
• Output: 0 1 2 3
- Execution of the loop is terminated when the loop counter is equal 
to 4
public static void main(String[] args) { 
 int i = 0; 
 while (i < 10) { 
  System.out.println(i + "\t"); 
  i++; 
  if (i == 4) { 
   break; 
  }//endif 
 }//end while 
}//end method main 
9
In the code example, although the loop is declared to run 10 times, the break statement 
exits the loop after only 4 iterations. The last value of i is output to the console after the 
loop is terminated.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
10
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using break in a for Loop
• Let’s write a program to demonstrate a break statement in a for 
loop
• The program must …
- Read 10 numbers from the console
- Compute the sum of the numbers that the user enters
- If the user enters 999, terminate the loop regardless of the value of 
the loop counter and without adding to the sum
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
11
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using break in a for Loop: Example
public static void main(String[] args) { 
 Scanner in = new Scanner(System.in); 
 int numInputs = 10, input = 0, sum = 0, stopLoop = 999; 
System.out.println("Enter 10 numbers"); 
 for (int i = 0; i < numInputs; i++) { 
  input = in.nextInt(); 
  if (input == stopLoop){ 
   break; 
  } 
  else { 
   sum += input; 
  }//endif 
 }//end for 
 System.out.println("The sum of the numbers:" + sum); 
}//end method main 
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
12
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mission to Saturn’s Rings: 
Implementing the Conditions, 1 of 2
• Let’s use a while loop and a break statement to implement the 
conditions specified at the beginning of the lesson
public static void main(String[] args) { 
 long distTravelled = 0; 
 long maxDistance = 50000000; 
 while (distTravelled <= maxDistance) { 
  if (isCameraBroken()) { 
   break; 
  } 
  else { 
   cameraSnap(); 
  }//endif 
 }//end while 
 shipRotate(); 
} //end method main 
12
Assume that there are methods available as follows:
isCameraBroken() – returns true or false
cameraSnap() – takes a picture
shipRotate() – the spaceship rotates around Saturn
In this example, if the camera is broken, the remaining statements within the while loop 
are skipped, and the control goes to the statement outside the while loop. 
That is, the spaceship continues to rotate around Saturn.
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
13
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new project and add the ComputeSum.java file to the 
project
• Examine ComputeSum.java
• Implement the following:
- Accept 10 numbers from the user
- Compute the sum of the numbers entered
- When 0 is entered, the program must exit and display the sum of 
the numbers
13
Expected output:
Please enter 10 numbers.
Enter 0 to exit.
1
2
3
0
The sum of the numbers entered is 6.
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
14
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mission to Saturn’s Rings: 
Another Scenario
• Let’s consider another scenario for this mission
- As the spaceship is rotating around Saturn and taking snapshots 
of Saturn’s rings …
• If the visibility is zero, do not take snapshots
• Otherwise, continue to take the snapshots
• How would you solve this problem? 
- If you were to write a Java program, which construct would you 
use?
- Let’s see whether Java has a statement that enables you to skip the 
current iteration of the loop
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
15
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using continue in a Loop
• Sometimes, you may want to skip the current iteration in a loop 
and not terminate the loop itself
• You can use a continue statement to skip the current iteration 
in a loop:
- That is, the rest of the loop body is skipped to the end of the loop
- However, it doesn’t end the loop
- When the program reaches the end of the loop, the program jumps 
back to test the loop continuation condition
• Syntax: continue; 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
16
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using continue in a while Loop
while(condition){ 
 statement1; 
 statement2; 
 continue; 
 statement3; 
 statement4 
} 
statement;    [statement outside the while loop ] 
Control passes to the loop condition
These statements are skipped in the current iteration
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
17
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using continue in a for Loop, 1 of 2
for (i = 0; i < 10; i++) { 
 statement1; 
 statement2; 
 continue; 
 statement3; 
 statement4; 
}//end for 
Control passes to the loop condition
These statements are skipped in the current iteration
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
18
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using continue in a for Loop, 2 of 2
• Output: 0 1 2 3 5 6 7 8 9
- The output doesn’t include 4
- Because of the continue statement, the loop execution is skipped 
when the loop counter is 4
public static void main(String[] args) { 
 for (int i = 0; i < 10; i++) { 
  if (i == 4) { 
   continue; //control jumps to update i++ 
  }//endif 
  System.out.print(i + "\t"); 
 }//end for 
}//end method main 
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
19
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Putting It All Together
• Let’s write a program using the while loop and the continue 
statement
• The program must …
- Compute the sum of numbers between 1 and 99 using the while 
loop
- If the number is a multiple of 10, the current iteration must be 
skipped and the number must not be added to the sum
- Display the sum to the console
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
20
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Computing the Sum of Numbers 
public static void main(String[] args) { 
 int counter = 0; 
 int sum = 0; 
 while (counter < 100) { 
  counter++; 
  if (counter % 10 == 0) { 
   continue; 
  } 
  else { 
   sum += counter; 
  }//endif 
 }//end while 
 System.out.println("Sum of 1 - 99: " + sum); 
}//end method main 
Is this a multiple of 10? 
If yes, then skip the 
current iteration
20
The output for this example is:
Sum of 1 - 99: 4500
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
21
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mission to Saturn’s Rings: 
Implementing the Conditions, 2 of 2
• Let’s use a while loop and a continue statement to implement 
the conditions specified at the beginning of this topic
public static void main(String[] args) { 
 long distTravelled = 0; 
 long maxDistance=50000000; 
 while (distTravelled <= maxDistance) { 
  if (getVisibility() == 0) { 
   continue; 
  } 
  else { 
   cameraSnap(); 
  }//endif 
 }//end while 
 shipRotate(); 
}//end method main
21
Assume that there are methods available as follows:
getVisibility() = the number of miles of visibility from the spaceship to Saturn
isCameraBroken() – returns true or false
cameraSnap() – takes a picture
Ship Rotate() the spaceship rotates around Saturn
In this example, if the visibility is zero, snapshots of Saturn’s rings aren’t taken, 
control is transferred back to the condition, and the program continues to execute 
with the next iteration.
These actions happen because you used the continue statement.
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
22
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Add the file CountChar.java to the project you created for 
exercise 1
• Examine CountChar.java
- The program is used to count the number of occurrences of the 
char ‘w’ in the string
- Modify the program to …
• Resolve the syntax error 
• Print the count of char ‘w’
- Expected Output:
• Number of w : 3
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
23
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Add the file BreakContinue.java to the project you created for 
exercise 1
• Examine BreakContinue.java
• Modify the program by using break and continue statements …
- If the number is even, the number should not be printed
- Execution of the loop should stop when the value of the loop 
counter is 7
23
Expected Output:
The number is 1
The number is 3
The number is 5
The number is 7
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
24
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Writing Loop Comments, 1 of 2
• It’s a good practice to add appropriate comments to loops
• Otherwise …
- Code tends to be confusing to look at
- You won’t be able to understand the logic very easily
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
25
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Writing Loop Comments, 2 of 2
• It helps to understand …
- Loop variables used and their purpose
- Logic of the loop
- Number of iterations
- Execution of the statements in the loop depending on the 
condition or criteria or both
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
26
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Writing Loop Comments: Example
public static void main(String[] args) { 
 Scanner in = new Scanner(System.in); 
 int numInputs = 10, input = 0; 
 //This loop is executed 10 times 
 for (int i = 0; i < numInputs; i++) { 
  input = in.nextInt(); //user inputs a number 
  if (input % 2 == 0) { //if the number is even skip the 
   continue;  //remaining code and restart the loop 
  }//endif
 
  System.out.println("That number was odd"); 
 }//end for 
}//end method main 
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
27
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, 1 of 2
• Add the file Divisors.java to the project you created for 
exercise 1
• Examine Divisors.java
• The program finds all divisors of a number
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
28
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, 2 of 2
• Modify the program to include comments for the loop about …
- Loop variables used
- Logic of the loop
- Number of iterations
- Condition used 
- Control flow in the loop
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
29
JFo 6-3
Using break and continue Statements
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Use a break statement to exit a loop
- Use a continue statement to skip part of a loop
- Explain the need for loop comments
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
30
Oracle Academy – End of Lesson
```

</details>
