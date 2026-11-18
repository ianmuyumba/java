# 2-2 What is my Program Doing

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 2-2 What is my Program Doing.pdf

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
2-2
What is my Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Understand how Java is read line by line
- Set and use breakpoints
- End statements with semicolons (;)
- Organize code using whitespace and other conventions
- Create comments
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Reading a Program Line by Line
• Each line in a program is read one at a time
• In the example…
- Line 1 is read…
- Then Line 2…
- Then Line 3…
- Then Line 4...
- Then Line 5…
1  System.out.println("Line 1");
2  System.out.println("Line 2");
3  System.out.println("Line 3");
4  System.out.println("Line 4");
5  System.out.println("Line 5");
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Reading Line by Line, 1 of 2
• Java is mostly read line by line
• But there are a few additional points to consider
• We’ll investigate using…
- A breakpoint
- Other features of a Java IDE
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Breakpoints
• Set a breakpoint in your code to
- Pause code execution
- Check the current state of the program
- Help debug
• Breakpoints affect code execution …
- When code is run with the debugger
• Breakpoints can’t affect code execution …
- When code is run normally
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Setting a Breakpoint Animation
• To set a breakpoint …
- Place your cursor over a number in the left margin
- Click …  and you have a breakpoint!
- Click again to remove a breakpoint
- You can set many breakpoints
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Create a new project and add the Text01.java f ile to the project
• Set a breakpoint at Line 5 (the line with the first print 
s
tatement)
• Run t he program normally
- Breakpoints should have no affect
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• Run the program with the debugger:
- Make sure the Output win dow is showing
- Press Step Over t o go to each next line
• Observe the cat appear one line at a time
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 3
• Modify the code so that the first three print s tatements all 
appear on Line 5 (This is called removing whitespace)
• Run the program with the debugger:
- Make sure the Output win dow is showing
- Press Step Over Expression t o go to each next line
- Ignore the complicated code at the end of debugging
• Observe the cat appear one line at a time
• Try removing a semicolon while debugging the program
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Investigation Results, Part 1
• You could say Java reads code line by line …
• But if multiple statements are on a single line, it’s more accurate 
t
o say Java reads statement by statement
• A semicolon (;)  is required to end a statement
- Forgetting a semicolon is a common mistake
- Other languages (Python) may not care about semicolons
System.out.println("Meow") ;
• Editing code has no affect while the program is running
• You must recompile for changes to take affect
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Investigation Results, Part 2
• Java isn’t precise about whitespace
• Other languages (Python) may be extremely precise
• You could write an entire program in a single line
- But this is messy and almost impossible to work with
- Use whitespace to keep code organized
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Whitespace
• Whitespace is any spacing without code:
- Space between words
- Blank lines 
- Indentation before a line of code
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Effects of Whitespace
• Whitespace helps keep code organized
• Whitespace doesn’t affect how code runs
• You can use whitespace however you prefer
• But proper indentation is strongly encouraged because it …
- Prevents readability difficulties
- Prevents mistakes while programming
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Indentation and Curly Braces 
• Indent by an additional tab (4 spaces) following an opening curly 
br
ace ( { )
• Stop indenting by an additional tab (4 spaces) prior to a closing 
c
urly brace ( } )
• Code within curly braces is called a block of code
- When you add an opening curly brace ( { ) …
- You’ll eventually need a closing curly brace ( } )
- Mismatching or forgetting a curly brace is a common mistake
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Block Example
public class Example
{
    public static void main (String[] arg){
        System.out.println("Inner code");
        System.out.println("Inner code");
        {
            System.out.println("Inner-inner code");
        }
    }
}
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
IDE Indentation Assistance
• An IDE may…
- Color-code the scope of a block (G reenfoot, BlueJ)
- Automatically indent following a curly brace
- Highlight a matching curly brace (shown below)
• Some Java commands 
re
quire curly braces, 
although you can 
always add more
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Create a new project and add the Text02.java f ile to the project
• Can you fix this program and produce the following output?
1
2
3
4
• Hints:
- Your IDE underlines problematic code
- Your IDE can highlight matching curly braces
- Your IDE has a shortcut to correct indentation
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Comments
• Neatly spaced programs can grow large and become difficult to 
re
ad
• You can add comments to code to …
- Provide an explanation or additional information to the 
pr
ogrammer (Commenting code)
- Disable code and prevent it from executing without erasing it 
(
Commenting out code)
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Adding Comments to Code, 1 of 2
• Single- line comments …
- Start with two slashes //
- End when the line ends
//A single line comment automatically ends when the line ends
System.out.println("This line prints");
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Adding Comments to Code, 2 of 2
• Multi- line comments …
- Start with a slash-s tar /*
- End with a star-sl ash */
/*A multi line comment... 
continues for many lines... 
System.out.println("This line does not print"); 
until the star-slash appears*/ 
System.out.println("This line prints");
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Reading Line by Line, 2 of 2
• We can do a little more investigating
• We’ll investigate using …
- Code blocks
- Comments
- Breakpoints
- Other features of your IDE
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Create a new project and add the T ext03.java file to the project
• Set a breakpoint at Line 11
• Run the program with the debugger:
- Be sure to have the Output window selected
- Press Ste p Over  to go to each next line
• Observe the cat face appear, but the legs don’t appear
• Type drawLegs (); in Line 19 and debug the program
- Where could you add a breakpoint to see the legs drawn one line at a 
t
ime?
- What happens to the output when lines are commented out?
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Investigation Results, Part 3
• When Java reads line by line …
• It starts within the special block of code known as the main 
me
thod public static void main(String[] args){
}//end method main
• No other code executes unless it’s called
- In this exercise, the main  method must specifically call the block of 
code that prints legs
• Commented code is ignored
- Comments are removed in bytecode
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Program’s Flow
1. All Java programs start in the main me thod
2. No other code executes unless it’s called
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The main Method
• The main  method is a special block of code
• All Java programs start in the main me thod
• Your programs should have only 1 main  method
• Methods are discussed more in the next lesson
-drawLegs() i s an example of a method
public static void main(String[] args){
//your program starts here
}//end method main
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary, 1 of 2
• Common mistakes: 
- Missing semicolon (;)
System.out.println("Meow")
- Mismatched {cu rly braces}
{
   System.out.println("Meow");
• Keep code organized using:
- Whitespace
- Curly Braces ( { } )
- Comments
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 2-2
What is My Program Doing?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary, 2 of 2
• In this lesson, you should have learned how to:
- Understand how Java is read line by line
- Set and use breakpoints
- End statements with semicolons (;)
- Organize code using whitespace and other conventions
- Create comments
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text

```

</details>
