# 3-5 Keyboard Input

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 3-5 Keyboard Input.pdf

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
3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Understand user input
- Create a J OptionPane to collect user input
- Use a Scanner to collect input from the console
- Use a Scanner to collect input from a file
- Understand how a Scanner handles tokens and delimiters
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Why Should Y ou Get User Input?
• When you manually assign values to variables, this is known as 
har
d-coding values:
String input = "This is a String"; 
• You can easily change hard- coded values because you have the 
source code and a Java IDE:
String input = "This is a different String"; 
- But when you distribute software, your users won’t have the same 
lux
ury
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Types of User Input, 1 of 2
• Examples of user input include …
- Pressing a button on a game controller
- Entering an address on a GPS
- Entering numbers and functions into a calculator
- Telling people your name
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Types of User Input, 2 of 2
• But without user input …
- When will the game make your character jump?
- Where will your GPS guide you?
- What numbers will your calculator crunch?
- What will people call you?
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How to Get User Input, 1 of 2
• There are many ways to get user input:
- Buttons (physical or virtual) 
- Wheels and dials
- Voice recognition
- Text dialog boxes
- Property files
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How to Get User Input, 2 of 2
• Java offers many ways of getting user input, including …
- Swing J OptionPane
- JavaFX (a successor of Swing, covered later)
- Scanner
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
JOptionPane
• This is a simple way to get input from users:
JOptionPane.showInputDialog("Type something:"); 
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
JOptionPane Returns Strings
• The input can be stored as a String:
String input = JOptionPane.showInputDialog("Type something:"); 
• This is equivalent to writing:
String input = "This is a String"; 
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Create a new project and add the Input01.java f ile to the project
• Create a J OptionPane:
- NetBeans will complain
- Follow the NetBeans suggestion of importing 
j
avax.swing.JOptionPane
- We’ll cover importing in another section
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• Store this input as a String
• Print the String variable
• Parse the String as a separate int variable
- You’ll need to input a value that can be parsed
- Print this value +1
• Try creating a dialog box, parsing it, and initializing an int in a 
s
ingle line
• You should have only one semicolon (;)
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Condensed Code
• You could spread your input, parsing and calculating across 
s
everal lines:
String inputString = JOptionPane.showInputDialog("??"); 
int input = Integer.parseInt(inputString); 
input++; 
• Or condense this into a single line:
int input = Integer.parseInt(JOptionPane.showInputDialog("??")) +1;
• This choice is a matter of personal preference
- But if you need to reference certain values again later, it would be 
h
elpful to store these values in a variable
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Different InputDialogs
• We created a simple In putDialog:
• With more complicated code, we can customize the In putDialog 
more:
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
More Options with InputDialogs, 1 of 2
• This version of an InputDialog does n’t return a String 
• The result must be cast to a String to be usable:
String input = (String)JOptionPane.showInputDialog(null,
     "Is this a question?", 
     "Dialog Title", 
     2, 
     null, 
     null, 
     "Type something here."); 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
More Options with InputDialogs, 2 of 2
• To avoid unwanted input, it's possible to 
pr
ovide only acceptable values to users
• Some of this syntax is discussed in 
g
reater detail in Section 8
String[] acceptableValues = {"Choice 1", "Choice 2", "Choice 3"}; 
Input2 string= (String)JOptionPane.showInputDialog(null, 
  "Is this a question?", 
  "Dialog Title", 
  2, 
  null, 
  acceptableValues , 
  acceptableValues [1]); 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
showMessageDialog
• A s howMessageDialog doesn't provide 
a field for input
• There are many other variations of JOptionPane
JOptionPane.showMessageDialog( 
 null, 
 "There's no input here, just a message", 
 "Title", 
 0); 
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Create a new project and add the Input02.java fi le to the project
• Experiment with the code and try to change …
- The message title
- The message
- Any default input text
- The dialog box’s icon
• Parse, manipulate, and print any input
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Getting Input with a Scanner
• A Scanner object opens a stream for collecting input:
- System.in readies Scanner to collect input from the console 
- Type your input in y our IDE output window
- It’s also possible to use Scanner without an IDE
• It’s best practice to close the Scanner stream when you’re 
f
inished
public static void main(String[] args) { 
 Scanner sc = new Scanner(System.in); 
 sc. close(); 
}//end method main 
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Reading Input with a Scanner
• The Scanner searches for tokens
• Tokens are separated by a delimiter
- The default delimiter is a space
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Scanner Class
• Scanner, like any other class, has fields and methods
• A few useful Scanner methods …
- nextInt( ) reads the next token as an int
- nextDouble( ) reads the next token as a double
- next() reads the next token as a String
public static void main(String[] args) { 
 Scanner sc = new Scanner(System.in); 
 int x = sc.nextInt(); 
 double y = sc.nextDouble(); 
 String z =  sc.next(); sc.close(); 
}//end method main 
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Create a new project and add the Input03.java f ile to the project
• Create a Scanner:
- Your IDE will complain
- Follow your IDE's suggestion of importing java.util.Scanner
- Remember to close the Scanner
• Use Scanner and System.in to write a program that …
- Finds and prints the sum of three integers entered by the user
• Try entering less than three tokens
• Try entering a token that can’t be parsed as an int
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exceptions: InputMismatchException
• Occurs because the input cannot be parsed as the expected type:
public static void main(String[] args) { 
 Scanner sc = new Scanner(System.in); 
 System.out. println(sc.nextInt()); 
 sc. close(); 
}//end method main 
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exceptions: IllegalStateException
• Occurs because the stream is accessed after it’s been closed:
public static void main(String[] args) { 
 Scanner sc = new Scanner(System.in); 
 sc. close(); 
 System.out. println(sc.nextInt()); 
} //end method main 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exceptions: NullPointerException
• Occurs because "fakeFile.txt" doesn’t exist, it’s also a common 
error to forget the .txt extension
public static void main(String[] args) { 
 Scanner sc = new Scanner(
  Input04.class.getResourceAsStream("fakeFile.txt")); 
 sc. close(); 
} //end method main 
Remember the extension when naming files
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Reading from a File
• Java offers several way to read files
• More useful Scanner methods include:
- nextLine( ) advances this Scanner past the current line and returns 
the input that was skipped
- findInLine("St ringToFind") Attempts to find the next occurrence of 
a pattern constructed from the specified String, ignoring delimiters
public static void main(String[] args) { 
 Scanner sc = new Scanner( 
  Input04.class.getResourceAsStream("fakeFile.txt")); 
 int x = sc.nextInt(); 
 String entireLine = sc.nextLine(); 
 sc.close(); 
} //end method main 
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, Part 1
• Create a new project and add the Input04.java f ile to the project
• Run the code and examine the output
• Read through each next line until you find "B lueBumper"
• The two numbers following "Bl ueBumper" are the object’s 
xPositon and yPosition. Store these coordinates as integers and 
print them
• Examine input04t ext.txt, if necessary
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, Part 2
• Examine Level05 .txt if you’re curious:
- This is how level data is stored for Java Puzzle Ball
- Reading and parsing level data is slightly more complicated than 
w
hat you’ve done in this exercise
- But if you finished this exercise, you’re close to understanding how 
i
t’s done
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 3-5
Keyboard Input
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Understand user input
- Create a J OptionPane to collect user input
- Use a Scanner to collect input from the console
- Use a Scanner to collect input from a file
- Understand how a Scanner handles tokens and delimiters
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text

```

</details>
