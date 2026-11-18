# 5-1 Boolean Expressions and if-else Constructs

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 5-1 Boolean Expressions and if-else Constructs.pdf

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
5-1
Boolean Expressions and if/else 
Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives: 
- Declare, initialize, and use b oolean variables
- Compare b oolean expressions using relational operators
- Create an if statement
- Create if/else constructs
- Compare Strings
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Making Decisions, 1 of 3
• So far in the previous lessons, you saw different data types 
s
upported in Java
• boolean i s another data type in Java that helps to add logic to a 
program
• It helps to make decisions
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Making Decisions, 2 of 3
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Making Decisions, 3 of 3
• Let’s say that you’re driving to the school
• You stop at an intersection
• And now you have to make a logical decision:
- If I turn left, will it take me to the school?
- If I go straight, will it take me to the school?
- If I turn right, will it take me to the school?
• There are only two answers to each of these questions: 
- yes or no
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Java’s boolean Data Type 
• It’s basically the same in Java, where bo oleans will tell the 
program which is the best course of action to take 
• In Java the values for the boolean d ata type are true and false, 
instead of yes and no
• You declare the boolean da ta type by using the boolean keyword
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using Java’s boolean Data Type: Example 
• Note: The value of a boo lean variable is displayed as true or false
public static void main(String args[]) { 
 boolean passed , largeVenue, grade; 
 passed =  true;
 largeVenue = false;
 grade = passed ; 
 System.out. println(passed); 
 System.out. println(largeVenue); 
 System.out. println(grade); 
}//end method main 
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
boolean Data Type: Scenario, 1 of 2
• What if you were driving a car that has an installed GPS system 
r
unning on Java? 
• Before you leave home, you ask the GPS system to take you to 
t
he school
• What simple code would you write to help you decide which way 
t
o turn?
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
boolean Data Type: Scenario, 2 of 2 
• Let’s start
public static void main(String args[]) { 
 String left = "museum"; 
 String straight = "gym"; 
 String right =  "restaurant"; 
 boolean isLeft =  false; 
 boolean isStraight = true; 
 boolean isRight = false; 
 System.out. println("Go straight ahead"); 
}//end method main 
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Expressions and Variables, 1 of 2
• Mathematical expressions can be …
- Printed
- Assigned to an int or double variable
System.out.println(2 + 2); 
int x = 2 + 2; 
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Expressions and Variables, 2 of 2
• boolean expressions can be …
- Printed
- Assigned to a boo lean variable
System.out.println(x == 5); 
boolean isFive = x == 5; 
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Equality and Assignment, 1 of 2
• == is a relational operator
• This operator tests to see if both sides of a boolean e xpression 
equal each other
• A bo olean expression returns a value of true or false
x == 5 
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Equality and Assignment, 2 of 2
• = is an assignment operator
• This operator assigns a value to a variable
• A bo olean variable can be assigned whichever value a boolean 
expression returns
int x = 4; 
boolean isFive = x == 5; 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Values in boolean Expressions, 1 of 2
• Use == to test equality between primitive values
• boolean e xpressions may contain variables or hard -coded values
boolean res1 = 24 == 15; 
System.out.println("res1: " + res1); 
int value1 = 15; 
int value2 = 24; 
boolean res2 = value1 == value2; 
System.out.println("res2: " + res2); 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Values in boolean Expressions, 2 of 2
• Both expressions below return the same value:
- If value1 and value2 hold the same value, the expression returns a 
t
rue result
- Otherwise, the expression returns false
boolean res1 = 24 == 15; 
System.out.println("res1: " + res1); 
int value1 = 15; 
int value2 = 24; 
boolean res2 = value1 == value2; 
System.out.println("res2: " + res2); 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Relational Operators, 1 of 2
• Use relational operators in bo olean expressions that are used to 
evaluate if/else statements
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Relational Operators, 2 of 2
Condition Operator Example
Is equal to == int i=1;
(i == 1)
Is not equal to != int i=2;
(i != 1)
Is less than < int i=0;
(i < 1)
Is less than or equal to <= int i=1;
(i <= 1)
Is greater than > int i=2;
(i > 1)
Is greater than or equal to >= int i=1;
(i >= 1)
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Relational Operators: Example
• Note: Use the equal sign (=) to make an assignment and use the 
==
 sign to make a comparison and return a boolean
public static void main(String args[]) { 
 int  a = 10; 
 int  b = 20; 
 System.out. println(a == b); 
 System.out. println(a != b); 
 System.out. println(a > b); 
 System.out. println(a < b); 
 System.out. println(b >= a); 
 System.out. println(b <= a); 
}//end method main 
For primitive values ==  
checks for equality testing
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1 
• Create a new project and add the AgeValidity.java fi le to 
the project
• Modify AgeValidi ty.java to implement the following:
- Have users enter their age
- Declare a b oolean variable, drivingUnderAge
- Initialize dr ivingUnderAge to false
- Write a boolean ex pression to check if the age entered by the user 
is less than or equal to 18, and then set drivingUnderAge to true
- Print the value of dr ivingUnderAge
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Conditional Statements
• Conditional statements let us choose which statement are 
e
xecuted next
• These decisions are based on boolean e xpressions (or 
conditions) that evaluate to true or false
• Conditional statements in Java are:
- if statement
- if/else statement
- switch statement
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Understanding the if Statement, 1 of 2
• An if statement consists of a boolean expression followed by 
one or more statements
• Syntax:
if ( <some condition is true> ){ 
 //Statements will execute if the boolean 
 //expression is true 
}//endif 
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Understanding the if Statement, 2 of 2
The boolean expression must 
evaluate to either true or false
If boolean expression is true:
Statement is executed
If boolean expression is false:
Statement is skipped
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using boolean Expressions in if Statements
public static void main(String args[]) { 
 String left = "museum"; 
 String straight = "gym"; 
 String right =  "restaurant"; 
 if (left == "gym") { 
  System.out. println("Turn Left"); 
 }//endif 
 if (straight== "gym") { 
  System.out. println("Drive Straight"); 
 }//endif 
 if (right == "gym") { 
  System.out. println("Turn Right"); 
}//endif 
}//end method main 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Executing a Block of Code, 1 of 2
1. A code block isn’t needed for one statement to be executed by 
an if
 statement. 
- Here’s an example:
daysInFeb = 28; 
if(isLeapYear) 
 daysInFeb = 29; 
 System.out. println(year + " is a leap year"); 
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Executing a Block of Code, 2 of 2
2. However, it’s always recommended that you use code blocks, 
even
 if there’s only one statement to execute in the block
daysInFeb = 28; 
 if( isLeapYear){ 
  daysInFeb = 29; 
  System.out. println(year + " is a leap year"); 
 }//endif 
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
if Statement: Examples
public static void main(String args[]) { 
 int  grade = 85; 
 if (grade > 88) { 
  System.out. println("You made the Honor Roll."); 
 }//endif 
 if (grade <=88) { 
  System.out. println("You are eligible for tutoring."); 
 }//endif 
}//end method main 
• Output: You are eligible for tutoring.
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2 
• Add the file ChkOddEven.java to the project you created for 
exercise 1
• Modify the ChkOddEve n.java to implement the following:
- Input a number between 1 and 10
- Use if statements
- Test whether a number is odd or even
• The program should generate the following output:
- Enter a number: 7
- The num is odd 7
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Choosing  Between Two Alternatives
• If you want to choose between two alternatives you use the 
if/else st
atement 
• Syntax:
if ( <some condition is true> ) { 
 // do something 
} 
else { 
 // do something different 
}//endif 
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Understanding if/else Statements
If boolean expression is true: Statement1 is executed
If boolean expression is false: Statement2 is skipped
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
if/else Statements: Example 1
String forecast; 
double temperature = getTemperature(); 
if (temperature <= 32.0) { 
 forecast =  "SNOW"; 
} 
else { 
 forecast =  "RAIN"; 
}//endif 
30.3 °F 
 
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
if/else Statements: Example 2
String forecast; 
double temperature = getTemperature(); 
if (temperature <= 32.0) { 
 forecast =  "SNOW"; 
} 
else { 
 forecast =  "RAIN"; 
}//endif 
40.2 °F
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
if/else Statements: Example 3
• You can replace the two if statements with an if/else statement
• The if/else statement is more efficient because only one 
compa
rison is being made
public static void main(String args[]) { 
 int  grade = 85; 
 if (grade > 88){
  System.out.println("You made the Honor Roll."); 
 } 
 else { 
  System.out.println("You passed."); 
 }//endif 
}//end method main 
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3 
• Add the file AgeCheck.java to the project you created for 
exercise 1
• Examine AgeCheck .java:
- The program has a logic problem
- For some values, it prints the wrong answer
- Find the problems and fix them. (You may need to run the program 
a
 few times and try different values to see which ones fail)
- Replace the two if statements with an if/else statement
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4 
• Add the file ShoppingCart.java t o the project you created for 
exercise 1 
• Examine Shopping Cart.java
• Use an if/else statement to implement the following: 
- Declare and initialize a b oolean variable, outOfStock
- If quantity > 1, change the message variable to indicate plural
- If an item is out of stock, inform the user that the item is 
un
available, else print the message and the total cost
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Comparing Variables
• When you compare values by using boolean e xpressions, you 
need to understand the nuances of certain data types
• Relational operators such as == are …
- Great for comparing primitives
- Terrible for comparing Strings (and other objects)
• Let’s examine why
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Comparing Primitives
• The value z is set to be the sum of x + y
• When a bo olean expression tests the equality between z and the 
sum of x + y, the result is true
int x = 3; 
int y = 2; 
int z = x + y; 
boolean test = (z == x + y); 
System.out.println(test); //true 
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Comparing Strings
• The value z is set to be the concatenation of x + y
• When a bo olean expression tests the equality between z and the 
concatenation of x + y, the result is false
String x = "Ora"; 
String y = "cle"; 
String z = x + y; 
boolean test = (z == x + y); 
System.out.println(test); //false 
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Why Are There Contradictory Results?
• Primitives and objects are stored differently in memory
- Strings are given special treatment
- This is discussed later in the course
• As a result …
- == compares the values of primitives
- == compares the objects’ locations in memory
• It’s much more likely that you’ll need to compare the content of 
S
trings and not their locations in memory
39
```

</details>


## PDF page 40

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Should Y ou Compare Strings?
• You should almost never compare Strings using ==
• Instead, compare Strings using the equals() me thod
- This method is part of the String cl ass
- It accepts one String argument, checks whether the contents of 
Str
ings are equal, and then returns a boolean
- There is also a similar method, equalsIgnoreCase()
String x = "Ora"; 
String y = "cle"; 
String z = x + y; 
boolean test = z.equals(x + y); 
System.out.println(test); //true 
40
```

</details>


## PDF page 41

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 5, 1 of 2
• Add the file StringEquality.java t o the project you created 
for exercise 1
• Examine StringEq uality.java
41
```

</details>


## PDF page 42

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 5, 2 of 2
• Use an if and  an if/else statement: 
-  D eclare a String variable name
-  Ha ve the user input a value for the name
-  C heck whether the name is “Moe,” and then print “You are the 
king of rock and roll”
-  Ot herwise print “You are not the king”
-  D on’t use ==
42
```

</details>


## PDF page 43

<details>
<summary>Page text</summary>

```text
JFo 5-1
Boolean Expressions and if/else Constructs
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Declare, initialize, and use b oolean variables
- Compare primitive values using relational operators
- Create an if statement
- Create if/else constructs
- Compare Strings
43
```

</details>


## PDF page 44

<details>
<summary>Page text</summary>

```text

```

</details>
