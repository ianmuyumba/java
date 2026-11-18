# 3-3 Textual Data

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 3-3 Textual Data.pdf

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
3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Use the char data type
- Use Strings
- Concatenate Strings
- Understand escape sequences
- Understand print statements better
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Textual Primitive Type
• The only primitive textual data type is char
• It’s used for a single character (16 bits)
• Example:
- char shirtSize =  'M';
Single quotes must be used with char literal values
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Stringing Characters Together
• You can string characters together to create sentences
• Here’s an inefficient way to do it
• One line of code is required for every letter in a sentence
char letter1 = 'H';
char letter2 = 'e'; 
char letter3 = 'l'; 
char letter4 = 'l'; 
char letter5 = 'o'; 
//Long sentences would be painful to code 
System.out.println("" + letter1 + letter2 + letter3 + letter4 + letter5); 
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Stringing Characters Together Efficiently
• Here’s a better way
- Only one line is required for the entire sentence:
String greeting = "Hello World!";
//Notice the double quotes 
System.out.println(greeting); 
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Characters vs. Strings, 1 of 2
•chars ar e for a single character
- Use single quotation marks
char shirt1Size = 'S’; 
char shirt2Size = 'M’; 
char shirt3Size = 'L'; 
• chars can’t handle multiple characters
char shirt4Size = 'XL’; 
char shirt5Size = "XXL"; 
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Characters vs. Strings, 2 of 2
• A String can handle multiple characters
- Use double quotation marks
String shirt6Size = "XXXL"; 
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Primitives
Type Length Data
boolean 1 bit true / false
byte 8 bits Integers
short 16 bits Integers
int 32 bits Integers
long 64 bits Integers
float 32 bits Floating point numbers
double 64 bits Floating point numbers
char 16 bits Single characters
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Let’s Investigate
• Can we spot other differences between a char and String? 
char shirt3Size = 'L'; String shirt6Size = "XXXL"; 
1.  char turns blue
- char is a keyword for a primitive data type
- Keywords turn blue in NetBeans
2.  String is capitalized
- Strings are an object, not a primitive
- Object types are capitalized by convention
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Strings Are Objects
• Java comes with a String class which details
- String properties
- String behaviors
• Strings are special objects
- Strings are handled a little differently than most objects
• More on these points in future sections:
- Objects may have primitives as properties
- Objects may have objects as properties, such as Strings
- Objects are stored differently from primitives in memory
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Declaration and Initialization
• Declare and assign String values like they’re any other primitive
//One variable declared and initialized 
int intVar = 300; 
String stringVar = "Three Hundred";
 
//Many variables declared 
int x, y, z; 
String xString, yString, zString; 
//A declared variable is initialized later 
x = 1; 
xString = "One"; 
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Variable vs. String Literal
String stringVariable = "This is a String literal."; 
• A String can be created by combining String literals:
String combinedLiterals = "I want to" + " buy a shirt."; 
• A String can be created by combining variables:
String var1 = "This shirt has"; String 
var2 = " too many buttons."; 
String combinedVariables = var1 + var2; 
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Concatenation
• Combining multiple Strings is called concatenation 
• Strings can be combined by using the + operator
- stringVariable1 + stringVariable2
- stringVariable1 + “String literal”
- stringVariable1 + “String literal” + stringVariable2
String greet1 = "Hello"; 
String greet2 = "World"; 
String message1 = greet1 + " " + greet2 + "!"; 
String message2 = greet1 + " " + greet2 + " " + 2020 + "!"; 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Concatenation Output
• Concatenation example:
String greet1 = "Hello"; 
String greet2 = "World"; 
String message1 = greet1 + " " + greet2 + "!"; 
String message2 = greet1 + " " + greet2 + " " + 2020 + "!"; 
• You can concatenate Strings within a print statement:
System.out.println(message2); 
System.out.println(greet1 + " " + greet2 + " " + 2020 + "!"); 
• Output: 
Hello World 2020!
Hello World 2020!
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1 Scenario, 1 of 2
• Think back to the Duke’s Choice clothing catalog:
• The scenario included a ShoppingCart clas s
• A few ShoppingCart pr operties and behaviors are loosely 
examined in this exercise
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1 Scenario, 2 of 2
• ShoppingCart prope rties:
- Who owns it
- The items it contains
- A message/description of the cart
• ShoppingCart beh aviors:
- Prints its message
Represented as Strings
in this exercise
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Create a new project and add the ShoppingCart01.java fi le to 
the project
• Declare and initialize the String variable cus tName
• Declare and initialize the String variable i temDesc
• Declare a String variable message.
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• Assign message a concatenated value that includes cus tName, 
itemDesc, and a String literal, which results in a complete 
sentence: 
- (example: “Alex wants to purchase a Shirt”)  
• Print the message
• Your program should produce similar output:
Alex wants to purchase a Shirt
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mixing Strings and Numbers
• Strings may contain numbers:
String totalPrice = "Total: $" +3; 
System.out.println(totalPrice); //Total: $3 
• But be careful when trying to do math:
String totalPrice = "Total: $" +3 +2 +1; 
System.out.println(totalPrice); //Total: $321 
• Use parentheses for numbers:
String totalPrice = "Total: $" +(3 +2 +1); 
System.out.println(totalPrice); //Total: $6 
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2 Scenario, 1 of 2
• Question:  As customers fill their cart, how much will they pay?
• We need to represent the cart’s items with a little more detail to 
ans
wer this
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2 Scenario, 2 of 2
• A S hoppingCart  may need to know the following properties:
- Item price
- Sales tax rate
- Item quantity
- Calculated total price of all items in the cart
• A S hoppingCart  may need the following 
behaviors:
- Print a message with its total
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 1
• Create a new project and add the ShoppingCart02.java fi le to 
the project
• Declare and initialize numeric fields:
- price (double)
- tax (double)
- quantity (int)
• Declare a double t otalPrice:
- Assign a value, calculated from price , tax , and quantity
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 2
• Change message to include quantity: 
- (example: “Alex wants to purchase 2 Shirts”)
• Print another message showing the total cost
• Your program should produce a similar output:
Alex wants to purchase 2 Shirts
Total cost with tax is: $25.78
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise Notes
• It isn’t best practice to represent properties and behaviors of 
o
bjects entirely within the main method
• We break this rule in this section so we can focus on 
m
anipulating data
• We’ll try to do a better job following the rules in the next section
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Special Characters in Strings
• Remember when we printed the cat?
• The double backslash didn’t actually print:
- Only a single backslash printed
- Why?
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Escape Sequence, 1 of 2
• A character preceded by a backslash is called an escape 
s
equence and has special meaning to the compiler
• The table in the next slide shows Java escape sequences
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Escape Sequence, 2 of 2
Escape Sequence Description
\t Insert a new tab
\b Insert a backspace
\n Insert a new line
\r Insert a carriage return
\f Insert a formfeed
\' Insert a single quote character
\" Insert a double quote character
\\ Insert a backslash character
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Escape Sequence: Example
• If you want to put quotation marks within quotation marks, you 
mus
t use the escape sequence, \", on the interior quotation 
marks
- To print the sentence…
The cat said “Meow!” to me. 
- You would write
System.out.println("The cat said \"Meow!\" to me."); 
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Print Statements
• Writing text on a new line might not print to a new line:
System.out.println("This is the first line."
 + "This is NOT the second line."); 
Output:
This is the first line.This is NOT the second line.
• Escape sequences can help format your output:
System.out.println("This is the first line. \n"
 + "This is the second line."); 
Output:
This is the first line.
This is the second line
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
More Print Statements
• There are two important methods for printing:
System.out.println("Print Line method"); 
System.out.print("Print method"); 
• println w orks as if you’re automatically putting \n at the end of 
the statement
• The following two statements produce equivalent results: 
System.out.println("Printing"); 
System.out.print("Printing\n"); 
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
println() vs. print()
• println() automatically creates a line:
System.out.println("This is the first line."); 
System.out.println("This is the second line."); 
Output:
This is the first line.
This is the second line.
• print() won’t automatically create a line:
System.out.print("This is the first line."); 
System.out.print("This is NOT the second line."); 
Output:
This is the first line This is NOT the second line.
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
NetBeans Shortcut
Print Method How Often Will I Use this?
System.out.println() Often
System.out.print() Not so often
• System.out.println()  is used very often
• But requires a lot of typing to set up
• Your IDE may offer a shortcut, for example in NetBeans
- Type sout
sout 
- Press T ab
System.out.println(""); 
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Printing Lots of Text, Option 1
• Depending on what you’re trying to print, you may find it 
b
eneficial to either:
- Break a single print statement over many lines in your IDE:
System.out.println("This is the first line."
 + "This is the still the first line."
 + "It's just that the line is very long"
 + "and I can't see it all in NetBeans."
 + "\n" + "This is the second line."
 + "\n" + "This is the third line."); 
• OR…
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Printing Lots of Text, Option 2
- Use many print statements:
System.out.println("This is the first line."); 
System.out.println("This is the second line."); 
System.out.println("This is the third line."); 
System.out.println("This is the fourth line."); 
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 3-3
Textual Data
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Use the char data type
- Use Strings
- Concatenate Strings
- Understand escape sequences
- Understand print statements better
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text

```

</details>
