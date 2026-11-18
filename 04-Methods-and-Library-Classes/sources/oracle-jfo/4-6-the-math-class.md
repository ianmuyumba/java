# 4-6 The Math Class

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 4-6 The Math Class.pdf

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
4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objective: 
- Understand the methods of the Math class
- Use methods of the Math class to perform mathematical 
c
alculations
- Use fields of the Math Class
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Performing Mathematical Calculations, 1 of 2
• While developing programs, you may need more advanced 
m
athematical calculations than what the basic Java math 
operators provide
• For example:
-  F inding the maximum or minimum of two values
-  R ounding values
-  L ogarithmic functions
-  S quare root
-  T rigonometric functions
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Performing Mathematical Calculations, 2 of 2
• The Java Math  class contains methods for performing 
mathematical calculations
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Math Class
• Is one of the many classes included in the Java class libraries
• Contains methods that perform various mathematical functions
• Is part of the java.lang pa ckage
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Documentation for the Math Class
• You can access the documentation from here:
- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/
module-summary.html
Scroll to see a list of 
fields and methods 
available in this class 
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Examine the Math  class documentation
• See if you can find a value for PI and a method for computing the 
s
quare root of a number
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Some of the Methods Available in Math Class
Method Name Description
abs(value) absolute value
ceil(value) rounds up
cos(value) cosine, in radians
floor(value) rounds down
log(value) logarithm base e
log10(value) logarithm base 10
max(value1, value2) larger of two values
min(value1, value2) smaller of two values
pow(base, exponent) base to the exponent power
random() random double between 0 and 1
round(value) nearest whole number
sin(value) sine, in radians
sqrt(value) square root
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What's Different About the Math Class?
• The methods of the Math cl ass are static methods
• Static methods can be invoked through the class name
• That means you don’t have to create an object of the Math c lass 
to call the methods
• For example, to invoke the methods of the Random cl ass, you 
have to create an object of the Random class like this: 
Random rndNum = new Random(); 
int randomNum = rndNum.nextInt(); 
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Y ou Call the Methods of the Math 
Class?
• You can call methods of the Math c lass without creating an 
instance of the Math class, like this:
• Syntax: 
-Math.methodName(parameters)
• Example: 
-Math.sqrt(121.0);
Call methods by prefacing them with Math dot operator
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Calling a Method and Observing Its Result
• Let’s see an example of calling a method and observing its result:
public static void main(String[] args) { 
 Math. sqrt(121.0); 
}//end method main 
• Observe the output:
- No output is displayed
- Simply calling these methods produces no visible result
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do the Methods of the Math Class Work?
• The Math methods don’t print the results to the console
• Each method returns a numerical result
• The returning value is more flexible than printing
• You can store, print, or combine it with a larger expression
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Storing and Printing the Results
• To see the result, you must print it or store it in a variable
• For example:
- Print the result:
public static void main(String[] args) { 
 System.out. println("Square root: " + Math.sqrt(121.0)); //11.0 
}//end method main 
• Store the value:
public static void main(String[] args) { 
 double sqroot = Math.sqrt(121.0); 
 System.out. println("Square root: " + sqroot); //11.0 
}//end method main 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Combining the Results
• You can combine the results and use it in a larger expression, like 
th
is:
public static void main(String[] args) { 
 double result = Math.min(3, 7) + Math.abs(-50); 
 System.out. println("Result is " + result); //53 
}//end method main 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• On paper, evaluate the following Java statements and record the 
r
esults:
-Math.abs(-1.23 )
-Math.pow(3, 2)
-Math.sqrt(121.0) - Ma th.sqrt(256.0)
-Math.abs(Math. min(-3, -5))
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Consider an integer variable named age
• Use Math.max an d Math.min methods to answer the 
following questions:
• What expression would replace negative ages with 0?
• What expression would limit the maximum age to 40?
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Fields in the Math Class
• The Math  class contains two constant fields: 
- PI and E
Field Description
Math.E 2.7182818...
Math.PI 3.1415926...
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
PI Field, 1 of 2
• The Math  class contains a constant, PI
• It contains a double value: 
- 3.14159265358979323846
• Remember, Math  class methods are static methods and are 
accessed by using the Math class name
• Similarly, PI is a static variable in the Math  class, and it is 
accessed by using the Math class name
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
PI Field, 2 of 2
• To use PI in a program, specify the class name (Math) and PI, 
s
eparated by the dot operator:
-Math.PI
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Calculating the Area of a Circle
• Suppose that you have to write a Java program to compute the 
ar
ea of a circle
• Here’s the formula to compute the area of a circle:
- Area = PI* radius* radius
- Where PI i s a constant (approximately 3.1416)
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Computing the Area of a Circle
• Using the Math.PI  field for calculating the area yields a more 
accurate result than using a constant value for pi like 3.14
public class AreaOfCircle { 
 public static  void main(String args[]) { 
  Scanner sc = new Scanner(System.in); 
  System.out. print("Enter the radius: "); 
  double radius = sc.nextDouble(); 
  double area = Math. PI * radius * radius; 
  System.out. println("The area of circle is: " + area); 
 }//end method main 
}//end class AreaOfCircle 
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, 1 of 2
• A person’s body mass index (BMI) is computed like this:
7032 × =heightweightBMI
• Create a new project and add the  
ComputeBM
I.java file to the project
• Write a program that computes the BMI and 
r
ounds off the BMI
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, 2 of 2
• Use the methods of the Math cl ass and display the output as:
- Enter the weight in pounds: 132.5
- Enter the height in inches: 62.5
- Your Body Mass Index is 24
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 4-5
The Math Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Understand the methods of the Math  class
- Use methods of the Math  class to perform mathematical 
calculations
- Use fields of the Math  Class
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text

```

</details>
