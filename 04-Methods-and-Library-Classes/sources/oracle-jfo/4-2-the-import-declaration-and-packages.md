# 4-2 The import Declaration and Packages

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 4-2 The import Declaration and Packages.pdf

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
4-2
The import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives: 
- Access a class by using its fully qualified name
- Describe the function of the import s tatement
- Use the import  statement to access a class in a package
- Understand the purpose of an asterisk in an import s tatement
- Identify packages that are automatically imported 
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Why Should Y ou Reinvent the Wheel?
• Frequently, you may rewrite the same Java code for different 
pr
ograms
• As an alternative to rewriting the same code, you can use the 
J
ava-provided library, which organizes frequently used code
• This library is called the Java class library
• The Java class library documentation is available here:
- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/
module-summary.html
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Packages in the Java Class Library, 1 of 2
• The classes of the Java class library are organized into packages
• A package contains a group of related classes 
• With a package, it becomes easier to locate the related classes
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Packages in the Java Class Library, 2 of 2
Package Purpose
java.lang Provides classes that are fundamental to the design of the 
Java language
javax.swing Provides classes to build GUI components
java.net Provides classes for networking applications
java.time Provides classes for dates, times, instants, and durations
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Are the Packages Organized?
• The vast collection of classes are organized into a tree- like 
hierarchy, which allows packages to be divided into subpackages, 
like this:
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Javadoc Tutorial 
• From Oracle Academy Education Byte 
– 
Java – Hands on Lab:
- Access and complete the Java API 
D
ocumentation (Javadoc) Tutorial
- https://docs.oracle.com/en/java/java
se/15/docs/api/index.html
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using a Class from a Package
• To use a class from a package in your program, you need to 
s
pecify its fully qualified name
• For example, to use the Scanner cl ass to read a keyboard input, 
the fully qualified name for the Scanner class, which is defined 
in the java.util package, is:                    
java.util.Scanner
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the Fully Qualified Class Name 
• As you can see, using the fully qualified name cr eates very long 
names for classes
• Long names reduce t he readability of the code and also make 
coding difficult
public static void main(String[] args) { 
 int num; 
 java. util.Scanner keyboard = new java.util.Scanner(System.in); 
 System.out. print("Enter a number"); 
 num =  keyboard.nextInt(); 
 System.out. print("The number you entered is" + num); 
}//end method main 
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Is There an Alternative to the Fully Qualified Name?
• Suppose that you have a friend whose name is Santi Inez Luis 
Vid
al
- How tedious is it to call him by his full name every time?
- If you could simply refer to him as “Santi,” it would be so much 
mor
e convenient
• Similarly, accessing Java classes by using fully qualified names is 
e
qually tedious in your programs
• Let’s see if there’s a way to specify only the name of the class 
i
nstead of its fully qualified name
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the import Statement
• You can avoid the fully qualified class name by using the import  
statement
• You place the import s tatement above your class definition. It 
looks like this:
-import package .className
- Example:
import java.util.Scanner; 
public class AddNums { 
 //class code goes here }
//end class AddNums 
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Y ou Import a Single Class?
• You can import a single class or an entire package
• To import a single class into your program, you write an import 
s
tatement like this:
import javax.swing.JOptionPane; 
import keyword 
followed by the name 
of the package dot, the 
name of the class
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
javax.swing Package 
• Java has an extensive library for constructing GUIs 
• This library, called swing , can be imported into your program to 
give you access to Java’s GUI functionality
• The swing  library is in the javax.swing package
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing a Class from the swing Package
• The swing  package has a JOptionPane class
• This class creates a pop- up window that can be used to display 
strings of text to the user
• To use the JOptionPa ne class, you must first import it into 
your class:
import javax.swing.JOptionPane; 
public class Welcome { 
 //class code to go here 
}//end class Welcome 
import statement that imports a 
single class, JOptionPane, from 
the swing package 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Importing the JOptionPane Class
• You can then use JOptionPan e to display text by calling the 
showMessageDialog method inside the JOptionPane class
import javax.swing.JOptionPane; 
public class Welcome { 
 public static void main(String[] args) { 
  JOptionPane .showMessageDialog(null, "Hello!"); 
 }//end method main 
}//end class Welcome 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Output Looks Like This!
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Y ou Import All Classes in a Package? 
1 of 2
• You can import all classes in a particular package by using the * 
w
ildcard character in the import statement
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Y ou Import All Classes in a Package? 
2 of 2
• Let’s say you want to extend the previous example by creating an 
i
nstance of the JFrame class and add its reference to 
JOptionPane, like this:
import javax.swing.JOptionPane; 
import javax.swing.JFrame; 
public class Welcome { 
 public static void main(String[] args) { 
 JFrame frame =  new JFrame(); 
 JOptionPane .showMessageDialog(frame, "Hello!"); 
 }//end method main 
}//end class Welcome 
Importing 2 classes from 
the swing package
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing All Classes from the swing Package, 
1 of 2
• As you access more classes from the swing  package in your 
program, the number of import statements also increases
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing All Classes from the swing Package, 
2 of 2
• To avoid this, you can import all classes from the swing pa ckage 
by using the * wildcard character in the import statement, like 
this:
import javax.swing.*; 
public class Welcome { 
 public static void main(String[] args) { 
 JFrame frame =  new JFrame(); 
 JOptionPane .showMessageDialog(frame, "Hello!"); 
 }//end method main 
}//end class Welcome 
Replace all import statements of the previous 
example with one import statement
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Including Multiple import Statements
• You can include multiple import  statements in a Java program 
to access classes in the same package or in different packages
• For example:
import java.util.Date; 
import java.util.Calendar; 
import javax.swing.*; 
public class DisplayDate { 
 //class definition here 
}//end class DisplayDate 
Importing classes from the 
same package
Importing classes  from 
different packages
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Identify Packages That Are Automatically Imported
• So far, you have used System.out.println( ) to print text to 
the console
public class DisplayOutput { 
 public static void main(String[] args) { 
 System.out. println("Hello, how are you today?"); 
 }//end method main 
}//end class DisplayOutput 
• However, you didn’t import a package for using this method in 
y
our program
•  So how does Java know what to do when you call it? 
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
java.lang Package
• If you look at the Java library, you’ll see that the System c lass is 
organized in the java.lang package
• By default, the java.lan g package is automatically imported 
into all Java programs
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new project and add the AddImport.java fi le to the 
project
• Examine AddImpor t.java
- Perform the following:
- Replace the fully qualified name to access the JLabel c omponent 
with an import statement
- To import  classes from the util package, replace multiple 
import statements with a single import statement
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 4-2
The Import Declaration and Packages
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Access a class by using its fully qualified name
- Describe the function of the import s tatement
- Use the import  statement to access a class in a package
- Understand the purpose of an asterisk in an import s tatement
- Identify packages that are automatically imported 
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text

```

</details>
