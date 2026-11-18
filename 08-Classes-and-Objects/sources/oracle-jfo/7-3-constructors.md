# 7-3 Constructors

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 7-3 Constructors.pdf

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
7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Understand default values
- Crash the program with a null reference
- Understand the default constructor
- Write a constructor that accepts arguments
- Initialize fields with a constructor
- Use this as an object reference
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Remember the Prisoner Class
• It may have looked like this code
• It contains fields and methods
public class Prisoner { 
 //Fields 
 public String name; 
 public double height; 
 public int sentence; 
 
 //Methods 
 public void think (){ 
  System.out. println("I'll have my revenge."); 
 }//end method think 
}//end class Prisoner 
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Fields Are Variables
• Variables hold values
• The values can be accessed.
• Code may need to access variables to …
- Make calculations
- Check current values
- Change a value
• What might happen if a field is accessed before it’s assigned a 
v
alue?
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Continue editing with the PrisonTes t project
- A version of this program is provided for you in the files 
PrisonTest_Student_7_3.jav
a and 
Prisoner_Student_7_3.java 
• Investigate what happens when fields are accessed before they’re 
as
signed values
- Instantiate a Prisoner
- Try printing the value of each field
Variable:  p01
Name:      ???
Height:    ???
Sentence:  ???
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing Uninitialized Fields
• If fields aren’t initialized, they take on a default value
• Java provides the following default values:
Data Type Default Value
boolean false
int 0
double 0.0
String null 
Any Object type null 
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Null Object References
• Objects can have a null  value
• A null  object points to an empty location in memory
• If an Object has another Object as a field (such as a String), its 
d
efault value is null
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing Null Objects Is Dangerous
• What if a null o bject contains a field or method that needs to be 
accessed?
- This causes the program to crash!
- The specific error is a NullPointerException
public static void main(String[] args){ 
 String test = null; 
 System.out. println(test.length()); 
}//end method main 
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Importance of Initializing Fields
• It’s always good to minimize the chances that your program will 
c
rash
• And sometimes, Java’s default values aren’t desirable
• The remaining topics in this lesson examine helpful alternatives 
f
or initializing fields
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Setting Prisoner Fields, 1 of 2
• Currently, we need a line of code to set each field
• Four lines are required for each Prisoner object
public class PrisonTest { 
 public static  void main(String[] args){ 
  Prisoner p01 =  new Prisoner(); 
  Prisoner p02 =  new Prisoner(); 
  p01 .name = "Bubba"; 
  p01 .height = 2.08; 
  p01 .sentence = 4; 
  p02 .name = "Twitch"; 
  p02 .height = 1.73; 
 p02 .sentence = 3; 
 }//end method main 
}//end class PrisonTest 
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Methods Make Code More Efficient 
• If you find yourself repeating similar lines of code …
- Programming can become tedious
- It may be possible to do the same work in fewer lines
- Try to write that code as part of a method instead
p01.name = "Bubba"; 
p01.height = 2.08; 
p01.sentence = 4; 
p02.name = "Twitch"; 
p02.height = 1.73; 
p02.sentence = 3; 
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Continue editing with the PrisonTes t project
• Can fields be set more efficiently?
- Add a setFields () method to the Prisoner class
- This method should take three arguments, which are used to set 
t
he values for every field
- Replace code in the main method with calls to this method
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Writing a Method to Set Fields
• Your solution may have looked something like this:
public class Prisoner { 
 public String name;  
 public double  height; 
 public int sentence ; 
 public void setFields (String n, double h, int s){ 
  name = n; 
  height =  h; 
  sentence =  s; 
 }//end method setFields 
}//end class Prisoner 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Setting Prisoner Fields, 2 of 2
• Two lines are required for each Prisoner object
• But it’s possible to do the same work in even fewer lines!
public class PrisonTest { 
 public static  void main(String[] args){ 
  Prisoner p01 =  new Prisoner(); 
  Prisoner p02 =  new Prisoner(); 
  p01 .setFields("Bubba", 2.08, 4); 
  p02 .setFields("Twitch", 1.73, 3); 
 }//end method main 
}//end class PrisonTest 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Calling a Constructor
• A constructor is a special method
• Its goal is to “construct” an object by setting the initial field 
v
alues
• An object’s constructor is called once
- This occurs during instantiation
- And is never called again
• We’ve been calling constructors this whole time
Prisoner p01 = new Prisoner(); 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Default Constructor
• Java automatically provides a constructor for every class
• It’s never explicitly written in a class
• This is called the default constructor
• It’s considered a zero-argument constructor
Prisoner p01 = new Prisoner(); 
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Writing a Constructor Method
• You can replace the default constructor with a constructor that 
y
ou wrote yourself
• Constructors are written like any other method, except: 
- They have no return type (not even vo id)
- They’re named the s ame as the class
//Constructor 
public Prisoner(){ 
 System.out. println("This is a constructor"); 
}//end constructor 
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 1
• Continue editing with the PrisonTes t project
• Copy the constructor into the Prisoner c lass
- Run the program
- Observe how the code in this method is executed when Prisoner 
o
bjects are instantiated
//Constructor 
public Prisoner(){ 
 System.out. println("This is a constructor"); 
}//end constructor 
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 2
• How could you modify this constructor so that it sets every field 
i
n the class?
- Use your understanding of methods to find a solution 
- Remember, constructors are methods
- Remove the setFields() me thod
- Your solution should make this method redundant
• Your IDE will complain in the main method:
- How could these issues be fixed?
- Run the program after you have a solution
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Y ou May Have Noticed …
• Constructors can be written so that they accept arguments that 
s
et initial field values
• When you write your own constructor, the default constructor is 
no
 longer available
• Code becomes more useful and requires fewer lines
- The next few slides illustrate this increased efficiency
//Constructor 
public Prisoner(String n, double h, int s){ 
 name = n; 
 height =  h; 
 sentence =  s; 
} //end constructor 
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Setting Fields Without a Constructor
• 4 lines are required for each Prisoner object
public class PrisonTest { 
 public static  void main(String[] args){ 
  Prisoner p01 =  new Prisoner(); 
  Prisoner p02 =  new Prisoner(); 
  p01 .name = "Bubba"; 
  p01 .height = 2.08; 
  p01 .sentence = 4; 
  p02 .name = "Twitch"; 
  p02 .height = 1.73; 
  p02 .sentence = 3; 
 }//end method main 
}//end class PrisonTest 
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Setting Fields with a Method
• 2 lines are required for each Prisoner object
public class PrisonTest { 
 public static  void main(String[] args){ 
  Prisoner p01 =  new Prisoner(); 
  Prisoner p02 =  new Prisoner(); 
  p01 .setFields("Bubba", 2.08, 4); 
  p02 .setFields("Twitch", 1.73, 3); 
 }//end method main 
}//end class PrisonTest 
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Setting Fields with a Constructor
• 1 line is required for each Prisoner object
public class PrisonTest { 
 public static  void main(String[] args){ 
  Prisoner p01 =  new Prisoner("Bubba", 2.08, 4); 
  Prisoner p02 =  new Prisoner("Twitch", 1.73, 3); 
 }//end method main 
}//end class PrisonTest 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Naming Parameters, 1 of 2
• Single- character variable names are commonly used …
- If the variable has a very limited scope
- If there aren’t a lot of variables to keep track of
- For testing purposes
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Naming Parameters, 2 of 2
• But earlier in this course, we encouraged giving variables a 
de
scriptive names
- This helps avoid confusion
- Definitely follow this convention for fields
- Some developers like to apply this convention to method 
p
arameters
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Naming Parameters the Same as Fields
• This is also a common practice, especially with constructors
- It’s clearer what your parameters refer to
- But this creates scope complications
• In the following code, is the name field or parameter printed?
public class Prisoner { 
 public String name;  
 public setName(String name){  
  System.out. println(name); 
 }//end method setName 
}//end class Prisoner 
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Which Version of name Is Printed?
• The parameter is printed
- Variables within the most local scope take priority
- In other words, the variables within the most recent scope
• Can the field still be accessed?
- Yes! Fields exist within the scope of their class methods
- But more syntax is required to access to them
public class Prisoner { 
 public String name; 
 public setName(String name){ 
  System.out.println(name); 
 } //end method setName 
}//end class Prisoner 
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The this Keyword
•this i s a reference to the current object
- You can treat it like any other object reference
- Which means you can use the dot operator (.)
•this.name accesses the Prisoner’s field
•this.setName() a ccesses the Prisoner’s method
public class Prisoner { 
 public String name;  
 public setName(String name){  
  System.out. println(name); 
 }//end method setName 
}//end class Prisoner 
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4
• Modify the Prisoner  constructor
- Change the parameters of this method so that each parameter’s 
na
me matches the name of a field
- Set each field’s value by using the this  keyword
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary of Constructors
• Are special methods in a class
• Named the same as the class
• Have no return type (not even void)
• Called only once during object instantiation
• May accept arguments
• Used to set initial values of fields
• If you don’t write your own constructor, Java provides a default 
z
ero-argument constructor
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 7-3
Constructors
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Understand default values
- Crash the program with a null reference
- Understand the default constructor
- Write a constructor that accepts arguments
- Initialize fields with a constructor
- Use this as an object reference
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text

```

</details>
