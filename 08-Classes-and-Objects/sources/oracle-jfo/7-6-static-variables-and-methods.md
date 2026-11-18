# 7-6 static Variables and Methods

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 7-6 static Variables and Methods.pdf

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
7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Describe a static variable and demonstrate its use within a program
- Describe a static method and demonstrate its use within a program
- Understand how to use the final keyword with static variables
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Review of Object References
• An object must be instantiated before its fields and methods can 
b
e accessed
• Instantiation provides us with an object reference
• An object reference is used to access an object’s fields and 
me
thods
Prisoner p01 = new Prisoner() 
p01.name  //Accessing a field 
p01.display() //Calling a method 
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Math Class Is Different
• It would be tedious to create a new Math object every time we 
w
anted to do a little math
• Thankfully, we never need to instantiate a Math object
• Math fields and methods are accessed by directly referencing the 
M
ath class
• These are known as static variables and static methods 
   //Nothing instantiated 
Math.PI  //Accessing a static field 
Math.sin(0)  //Calling a static method 
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Does This Mean?
• Why are these two facts important?
- An object reference is used to access an object’s fields and 
me
thods
- Static fields and methods are accessed by directly referencing the 
c
lass
• There’s more to it than just the convenience of not having to 
i
nstantiate an object
• The next exercise lets you explore a use-case for static data
- Then we’ll debrief you on what you may have noticed
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Play Basic Puzzles 8 through 11
- https://objectstorage.uk-london-
1.oraclecloud.com/n/lrvrlgaqj8dd/b/Games/o/JavaPuzzleBall/in
dex.html
- Consider the following:
- What happens when you rotate the BlueWheel?
- How else can you affect the rotation of bumpers?
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Java Puzzle Ball Debriefing
• What happens when you rotate the BlueWheel?
- The orientation of all Blue Bumpers change
- All Blue Bumpers share the orientation property
- Orientation can be represented by a static variable
• How else can you affect the rotation of bumpers?
- After the ball strikes a rotation wall, the rotation of an individual 
b
umper changes
- Rotation can be represented by an instance variable
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Static Variable: Orientation
• This static variable is shared by all instances
• Static variables belong to the class, not to any individual instance
• Therefore, a static variable needs to be changed only once for 
ev
ery instance to be affected
• In Basic Puzzle 11, rotating the R edWheel changes the 
orientation of all RedBumper objects
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Static Variables with No Instances
• Static variables can be accessed, even if no objects have been 
i
nstantiated
• In Basic Puzzle 11, the Blu eWheel can be rotated to change the 
orientation property of all BlueBumpers
- There just aren’t any Blue Bumpers to show the effects of this 
change
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Instance Variables: Rotation
• Unique instance variables exist for every instance of an object
• Therefore, instance variables need to be changed for each 
i
ndividual object
• In Basic Puzzle 11, an individual R edBumper's rotation changes 
after being struck by the ball
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
When Should a Field Be Static?
• Here are a few points to consider:
- Will the value of this field be different for each individual object? Or 
w
ill it be the same for all objects?
- Does the field describe the class more than it describes any 
i
ndividual object?
- Do you find yourself repeating the same value throughout the 
c
lass? 
- Is this value a constant that will be used in calculations?
- Will this value need to be accessed before any objects are 
i
nstantiated?
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Creating Static Variables, 1 of 2
• A variable becomes static when its declaration includes the static 
ke
yword
• Initialize static variables as they’re declared
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Creating Static Variables, 2 of 2
- Otherwise, repeated constructor calls could “initialize” the same 
s
tatic variable many times
public class RedBumper{ 
 //Fields 
 public static  int orientation = 45; //Static variable 
 public int rotation ;   //Instance variable 
 
 //Constructor 
 public RedBumper(int  rotation){ 
  this. rotation = rotation; 
 }//end constructor 
}//end class RedBumper 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing Static Variables in Their Class
• Even if static variables aren’t initialized in the constructor, they 
c
an still be accessed
• Like any other variable, static variables are accessible within their 
c
lass
public class RedBumper{ 
 //Fields 
 public static int orientation = 45;  //Static variable 
 public int rotation;    //Instance variable 
 … 
 //Methods 
 public void display(){ 
  System.out.println(orientation); //Access static var 
  System.out.println(rotation); //Access instance var 
 } //end method display 
}//end class RedBumper 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing Static Variables Elsewhere
• Static variables can appear in constructors, methods, or outside 
t
heir class
• Calling static variables outside their class relies on referencing 
t
he class’s name rather than a specific reference variable
public class TestClass { 
 public static  void main(String[] args){ 
  int  x; 
  x =  RedBumper.orientation; //Access static variable 
  RedBumper rb01 = new RedBumper(90); //Instance 
  int  y; 
  y =  rb01.rotation;   //Access instance variable 
 }//end method main 
}//end class TestClass 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 1 of 2
• Continue editing the Pr isonTest project
- A version of this program is provided for you in the files 
PrisonTest_Student_7_6.jav
a, 
Prisoner_Student_7_6.java, and Cell_Student_7_6.java
• Modify the Prisoner  class:
- Include a static integer pr isonerCount field
- This field counts the total number of prisoners instantiated 
- Initialize this field to 0
- Increase this field every time a prisoner is instantiated
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 2 of 2
- Include an integer b ookingNumber field
- This field is initialized with the current value of pr isonerCount
- Print the bookingNumber an d prisonerCount as part of the 
display() method
• Instantiate a few prisoners and display their info.
You don’t need to write getters for this exercise
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Introducing Static Methods
• You may have noticed from the previous exercise:
- The display() m ethod can access a static variable
- Static variables are accessible from nonstatic me thods
• Most methods you’ve written in this course (excluding the main 
me
thod) are considered instance methods
- Instance methods are no nstatic methods
• Methods can also be made static
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
When Should a Method Be Static?
• Here are a few points to consider:
- Will the method read or modify static fields?
- Will the method not read or modify the fields of any particular 
o
bject?
- Will the method need to be called before any objects are 
i
nstantiated?
• Static methods are for dealing with static data
- Static variables are accessible from static methods
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Creating Static Methods
• A method becomes static when its declaration includes the static 
ke
yword
public class Prisoner{ 
 //Fields 
 private static int prisonerCount = 0;  //Static variable 
 private int bookingNumber;   //Instance variable 
 //Methods 
 public static  void displayPrisonerCount(){ //Static method 
  System.out. println(prisonerCount); 
 }//end method displayPrisonerCount 
}//end class Prisoner 
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Calling Static Methods in Their Class
• Like any other method, static methods are callable within their 
c
lass
• Static or instance methods may call a static method
public class Prisoner{ 
 private static int prisonerCount = 0;  //Static variable 
 private int bookingNumber;   //Instance variable 
 public static  void displayPrisonerCount(){ //Static method 
  System.out. println(prisonerCount); 
 }//end method displayPrisonerCount 
 public void callAnotherMethod(){   //Instance method 
  displayPrisonerCount();  
 }//end method callAnotherMethod 
}//end class Prisoner 
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Calling Static Methods Elsewhere
• Static methods can be called from constructors, other methods, 
or
 outside their class
• Calling static methods outside their class relies on referencing 
t
he class’s name rather than a specific reference variable
public class TestClass { 
 public static  void main(String[] args){ 
  Prisoner .displayPrisonerCount(); //Call static method 
  Cell cA1 = new Cell("A1", false, 1234); 
  Prisoner bubba =  new Prisoner("Bubba", 2.08, 4, cA1); 
  bubba .display();   //Call instance method 
 }//end method main 
}//end class TestClass 
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Continue editing the PrisonTest pr oject
• Modify the Prisoner  class:
- Encapsulate the pr isonerCount field. Make this field private and 
create a static getter method
- Try making the display method static
- What are your IDE’s complaints?
• From the main method:
- Call the getter method that you just created and print the returned 
v
alue
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Why Did your IDE Complain? 1 of 2
• Static fields and static methods can be called without 
i
nstantiating an object
• But instance variables must be associated with a specific 
i
nstance
• A paradox is created if a static method tries to access information 
abo
ut an instance before it’s created
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Why Did your IDE Complain? 2 of 2
• Therefore, Java doesn’t allow static methods to contain instance 
v
ariables or instance methods
public static void display(){ 
 System.out. println(prisonerCount); 
 System.out. println(bookingNumber); 
}//end method display 
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Writing static final Fields
• You’re encouraged to make static variables final
- But the reasons are beyond the scope of this course
• Remember, the names of final variables …
- Are capitalized by convention
- Use an underscore (_) to separate words
public class Prisoner{ 
 //Fields 
 … 
 private int bookingNumber; 
 private static int prisonerCount = 0; 
 public static  final int MAX_PRISONER_COUNT = 100; 
}//end class Prisoner 
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Making static final Primitive Fields public
• Encapsulation prevents variables from being manipulated in an 
u
ndesirable way
• But there’s no risk of public static final primitives being tampered 
w
ith because it’s impossible for their values to change
• This is useful for constants such as π,  e, or other values 
constantly used in calculations
• These variables are called directly instead of through getters
System.out.println(Math.PI); 
System.out.println(Math.E); 
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 7-6
Static Variables and Methods
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Describe a static variable and demonstrate its use within a program
- Describe a static method and demonstrate its use within a program
- Understand how to use the final keyword with static variables
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text

```

</details>
