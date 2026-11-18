# 3-2 Numeric Data

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 3-2 Numeric Data.pdf

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
3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Differentiate integer data types (byte , short, int, long)
- Differentiate floating point data types (float , double)
- Manipulate and do math with numeric data
- Use parentheses and order of operations
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
A Bit About Data
• In the early days of computing, data was stored on punch cards
• Each slot had 2 possible states:
- Punched
- Not punched
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Reading Punch Card Data
• An A utoPiano reads punch cards
• A column represents a key on the piano
• The punch card scrolls through the piano, triggering keys
• Each slot has 2 possible states with 2 possible results:
An 1800s piano roll
State Result
Punched Play note
Not punched Don’t play note
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
A Bit About Modern Computing
• Modern data processing still needs to represent 2 states:
- This is interpreted as binary code: 10011101
- A single 1 o r 0 is called a bit
Binary Digit AutoPiano Modern Computing
Bit Hole punched/Not punched 1/0
Bits are 
instructions for …
Mechanical components The processor
Medium Mechanical Electro-Magnetism
Bits store data 
about…
Piano keys Numbers
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Bits of Data
• One A utoPiano key is represented by 1 bit
- 0: Don’t play
- 1: Play
• Two keys require 2 bits
- There are 4 possible combinations of keys
- We can calculate this as 2^2
A key B key
0 0
0 1
1 0
1 1
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Bigger Bits of Data
• Three keys require 3 bits
- There are 8 possible combinations of keys
- We can calculate this as 2^3
• Eight keys require 8 bits
- There are 256 possible combinations
- We can calculate this as 2^8
A key B key C key
0 0 0
0 0 1
0 1 0
0 1 1
1 0 0
1 0 1
1 1 0
1 1 1
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Bits and Bytes
• Eight bits are called a byte
• A Java byte can store 256 possible values
• Possible values are from - 128 to 127
- 128 values below 0
- 127 values above 0
- 1 value equal to 0
byte x = 127; 
byte z = 128; //Too high
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Some New Integral Primitive Types
Type Length Number of 
Possible Values
Minimum Value Maximum Value
Byte 8 bits 28, or…
256
–27, or…
 –128 
27–1, or…
127
short 16 bits 216, or…
65,535
–215, or…
–32,768
215–1, or…
32,767
int 32 bits 232,or… 
4,294,967,296
–231, or… 
–2,147,483,648 
231–1, or…
2,147,483,647
long 64 bits 264, or… 
18,446,744,073,709,
551,616
–263, or… 
–9,223,372,036, 
854,775,808L 
263–1, or…
9,223,372,036, 
854,775,807L
Note the L
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
When Will I Use Each Data Type?
•byte and short  types are used to save memory consumption 
on older or smaller devices
• But modern desktops contain abundant memory
• Of these 4 types, we’ll mostly use ints i n this course
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Find x, 1 of 2
int x = 20; 
x = 25; x = 5 + 3;
System.out.println(x); 
•x always equals 20 …
- Until you assign x a different value
•x could be assigned a calculated value
Values for x:          20      25       8
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Find x, 2 of 2
int x = 20; 
x = 25; 
x = 5 + 3; 
x = x + 1; 
x += 1; 
x++; 
System.out.println(x); 
•x could be assigned a new value based on its current value:
- Java provides the shorthand +=  operator to do this
- Adding 1 to a variable is so common that Java provides the 
s
horthand ++ operator
Values for x:     20        25        8        9        49       11
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Find x Again
•x could be assigned the value of another variable:
- Changing y doesn’t change x
- y and x are separate variables
int y = 20; 
int x = y; 
y++; 
System.out.println(x); System.out.println(y); 
• Output: 
x 20
y 21
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Standard Mathematical Operators, 1 of 2
Purpose Operator Example Comments
Addition + int sum = 0;
int num1 = 10;
int num2 = 2;
sum = num1 + num2;
If num1 is 10 and num2 is 
2, sum is 12
Subtraction – int diff = 0;
int num1 = 10;
int num2 = 2
diff = num1 – num2;
If num1 is 10 and num2 is 
2, diff is 8
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Standard Mathematical Operators, 2 of 2
Purpose Operator Example Comments
Multiplication * int prod = 0;
int num1 = 10;
int num2 = 2;
prod = num1 * num2;
If num1 is 10 and num2 is 
2, prod is 20
Division / int quot = 0;
int num1 = 31;
int num2 = 2;
quot = num1 / num2;
If num1 is 31 and num2 is 
6, quot is 5
The remainder portion is 
discarded
Note:
Division by 0 returns an 
error
Since int data types are whole numbers only, the decimal remainder will be 
discarded.  You will see how to change this behavior later in this lesson.
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using Java Shorthand Operators to Make 
Assignments, 1 of 2
• A shorthand operator is a shorter way to express something that 
i
s already available in the Java programming language
Purpose Operator Shorthand 
Operator 
Examples
Equivalent
Construct
Result
Add to and assign += int a = 6;
int b = 2;
a  +=  b;
int a = 6;
int b = 2;
a  = a + b;
a = 8
Subtract from and 
assign
-= int a = 6;
int b = 2;
a  -=  b;
int a = 6;
int b = 2;
a  = a - b;
a =  4
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using Java Shorthand Operators to Make 
Assignments, 2 of 2
Purpose Operator Shorthand 
Operator 
Examples
Equivalent
Construct
Result
Multiply by and 
assign
*= int a = 6;
int b = 2;
a *= b;
int a = 6;
int b = 2;
a  = a * b;
a = 12 
Divide by and 
assign
/= int a = 6;
int b = 2;
a  /= b;
int a = 6;
int b = 2;
a  = a / b;
a = 3
Get remainder and 
assign
%= int a = 6;
int b = 2;
a %= b;
int a = 6;
int b = 2;
a  = a % b;
a = 0
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Modulus Operator
Purpose Operator Example Comments
Remainder %
(modulus)
num1 = 31;
num2 = 6; 
mod = num1 % 
num2;
(mod = 1)
Modulus finds the 
remainder of the 
first number 
divided by the 
second number.
Modulus always 
gives an answer 
with the same sign 
as the first 
operand.
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Increment and Decrement Operators (++ and --), 
1 of 3
• The long way:
• age = age + 1;
or 
• count =
 count – 1;
• The short way:
• age++;
or
• count--;
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
More on Increment and Decrement Operators, 
2 of 3 
Operator Purpose Example
++ Pre-increment (++variable) int id = 6; int 
newId = ++id; 
id is 7, newId is 7
++ Post-increment (variable++) int id = 6; int 
newId = id++; 
id is 7, newId is 6
-- Pre-decrement (--variable) (Same principle applies)
-- Post-decrement (variable--) (Same principle applies)
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Increment and Decrement Operators (++ and ––),
 3 of 3
1 int count=15; 
2 int a, b, c, d; 
3 a = count++; 
4 b = count; 
5 c = ++count; 
6 d = count; 
7 System.out.println(a + ", " + b + ", " + c + ", " + d); 
• Output:
15, 16, 17, 17
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Create a new project and add the Chickens01.java fi le to the 
project
• Read this story and calculate/print the totalEggs co llected 
between Monday and Wednesday:
- Farmer Brown’s chickens always lay eggsPerChicken e ggs precisely 
at noon, which he collects that day
- On Monday, Farmer Brown has ch ickenCount chickens
- On Tuesday morning, Farmer Brown gains 1 chicken
- On Wednesday morning, a wild beast eats half the chickens!
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• How many eggs did Farmer Brown collect if he starts with …
- eggsPerChicken = 5,  chickenCount = 3 
- eggsPerChicken = 4,  chickenCount = 8 
• Your program should produce the following output:
45 First scenario
84 Second scenario
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Integer Division Deception
• The wild beast ate half the chickens
• When we divide 9 chickens in half, Java thinks 9/2 = 4
- But 9/2 = 4.5
- Shouldn’t Java round up to 5?
- What’s going on here?
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Java Division
• Java integers aren’t rounded
• Java integers are truncated, meaning any numbers after the 
de
cimal point are removed
int x = 9/2; 
System.out.println(x); //prints 4 
• We need other data types if we have scenarios that require 
f
loating point precision!
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Floating Point Primitive Types
Type Float Length When will I use this?
float 32 bits Never
double 64 bits Often
• Example: 
-public float pi  = 3.141592F;
-public double pi = 3.141592; 
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Double Deception, 1 of 2
• The original problem:
int x = 9/2; 
System.out.println(x); //prints 4 
• Shouldn’t a double x fix this?
double x = 9/2;
System.out.println(x); //prints 4.0 
- No?!?!
- Why not?
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Double Deception, 2 of 2
double x = 9/2;
System.out.println(x); //prints 4.0 
• Java solves the expression, truncates the .5, and then turns the 
answ
er into a double
• The expression contains only ints, J ava won’t allocate the 
additional memory that doubles require until it absolutely has to
- Solution: Include a double in the expression
double x = 9/2.0; System.out.println(x); //prints 4.5 
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
One Final Note
• Declare a variable with the final keyword to make its value 
un
changeable (immutable)
final double PI = 3.141592; 
PI = 3.0; //Not Allowed 
• Java complains if you try to change a final variable’s value
• Final variable naming conventions:
- Capitalize every letter
- Separate words with an underscore
• MINIMUM_AGE
• SPEED_OF_LIGHT
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 1
• Create a new project and add the Chickens02.java fi le to the 
project
• Read this story and calculate/print the required values:
- On Monday, Farmer Fred collects 100 eggs
- On Tuesday, Farmer Fred collects 121 eggs
- On Wednesday, Farmer Fred collects 117 eggs
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 2
• What is the d ailyAverage of eggs collected? 
• How many eggs could be expected in a 30- day monthlyAverage?
• If an egg can be sold for a profit of $0.18, what is Farmer Fred’s 
t
otal monthlyProfit for all eggs?
• Your program should produce the following output:
Daily Average:   112.66666666666667
Monthly Average: 3380.0
Profit:          $608.4
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Parentheses in Mathematical Expressions
• This expression without parentheses …
int x = 10 +20 +30 / 3; //x=40 
• Is just like writing this expression with parentheses:
int x = 10 +20 +(30 / 3); //x=40 
• If you want to find an average, use parentheses like this:
int x = (10 +20 +30) / 3; //x=20 
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Operator Precedence
• Here’s an example of the need for rules of precedence: 
int x = 25 - 5 * 4 / 2 - 10 + 4; 
• Is the answer 34 or 9?
• Add parenthesis to enforce precedence
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Rules of Precedence
• Operators within a pair of parentheses
• Increment and decrement operators (+ + or --)
• Multiplication and division operators, evaluated from left to right
• Addition and subtraction operators, evaluated from left to right
• If operators of the same precedence appear successively, the 
ope
rators are evaluated from left to right
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using Parentheses
• Expression are evaluated with the rules of precedence
• However, you should use parentheses to provide the intended 
s
tructure
• Examples:
int x = (((25 - 5) * 4) / (2 - 10)) + 4; 
int x = ((20 * 4) / (2 - 10)) + 4; 
int x = (80 / (2 - 10)) + 4; 
int x = (80 / -8) + 4; 
int x = -10 + 4; 
int x = -6; 
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 3-2
Numeric Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Differentiate integer data types (byte , short, int, long)
- Differentiate floating point data types (float , double)
- Manipulate and do math with numeric data
- Use parentheses and order of operations
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text

```

</details>
