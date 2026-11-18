# 7-5 Object Interaction and Encapsulation

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 7-5 Object Interaction and Encapsulation.pdf

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
7-5
Object Interaction and 
Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Understand object interaction in greater detail
- Use the private modifier to define class variables
- Understand the purpose of getter methods
- Understand the purpose of setter methods
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Object Interaction
• Section 2 introduced the idea of object interaction
- No prescribed sequence for how object must interact
• This lesson explores how to program interactions
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is Object Interaction?
• An object reference is a memory address
- A reference directs one object to another
- A reference allows one object to interact with another
• Objects interact by …
- Accessing another object’s fields
- Calling another object’s methods
• If the main method instantiates every object …
- The main method contains every object reference
- The main method can access every objects’ fields and methods
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Example Program
• Consider a program that models Prisoner, Cell, and Guard objects
• The main method may look like this:
public class PrisonTest{ 
 public static  void main(String[] args){ 
  Prison p01 = new Prisoner(); 
  Cell c01 =  new Cell(); 
  Guard g01 =  new Guard(); 
  p01 .name = "Bubba"; 
  c01 .name = "A1"; 
  g01 .name = "Boss Man"; 
 }//end method main 
}//end class PrisonTest 
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Interactions from the Main Method
• The main method contains all the object references
• Therefore, the main method controls all interactions in this 
sy
stem
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Interactions Between Objects
• However, sometimes you’ll want a program where objects 
i
nteract with each other
• To do this, objects must know about each other
- One object must know a reference to the other object
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Objects Know About Each Other?
• Object references must be shared:
- One object may contain another object as a field
- One object’s method may accept another object as an argument
• For example:
- A way to describe a Prisoner is by their Cell number
- It could be argued that a Cell is a property of a Prisoner object
- The Prisoner class would contain a Cell field
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Continue editing the PrisonTest pr oject
- A version of this program is provided for you in the files PrisonTest.java 
a
nd Prisoner.java
• Create a Cell class that includes the following:
- String name of the cell
- Boolean describing whether the door is open
- Two-a rgument constructor that sets both fields
• Modify the Prisoner class so that it:
- Includes a Cell field
- Sets the Cell field based on a constructor parameter
- Prints the cell’s name as part of the display() me thod
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• Write an openDoor() me thod in the Prisoner class
- Access and modify the corresponding field in the Cell object so 
th
at:
• If the door is closed, open it
• If the door is open, close it
- Print whether the door opens or closes
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 3
• From the main method:
- Instantiate a Cell and a Prisoner object
- Call the prisoner’s display() me thod once
- Call the openDoor () method a few times
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Oops!
• The guards are panicking!
• Your program allows prisoners to access their cell doors
• Considering Bubba’s plans for revenge, this type of interaction 
s
hould not be allowed!
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Think About Potential Object Interactions
• Consider which objects must know about each other
- Some objects have no business modifying another’s fields
- Try to minimize their knowledge of each other …
- This prevents unwanted results and make code less complicated
• Consider which direction the interactions might occur and which 
ob
jects should be properties of each other
- Should a Prisoner have a Cell property?
- Should a Cell have a Prisoner property?
- Or should neither know about each other?
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Think About How to Distribute Behaviors
• Cells are designed to open and close
- Someone must have access to perform these interactions
- Prisoners should not be capable of this behavior
- Guards should be capable of this behavior
• Deciding how to distribute behaviors between objects is an 
i
mportant challenge of object-oriented programming
- But don’t worry. You already have experience doing this
- A major goal of Java Puzzle Ball was to create situations where 
p
layers needed to think carefully about distributing behaviors 
between different object types
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Introducing Encapsulation
• Sometimes objects must know about each other
• Encapsulation provides techniques for limiting one class’s 
v
isibility of another
• It’s possible to restrict which fields and methods other classes 
c
an see
• Special methods can be written to decide how data should be 
a
ccessed and modified
• Access and visibility should be limited as much as possible
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Access Modifiers
• The public keyword is one of several access modifiers
• Access modifiers limit the visibility of fields and methods 
be
tween classes
public class Cell { 
 //Fields 
 public String name;  
 public boolean isOpen ; 
 //Constructor 
 public Cell(String name, boolean isOpen){ 
  this. name = name; 
  this. isOpen = isOpen; 
 }//end constructor 
}//end class Cell 
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Access Modifier Details
• public:  Visible to any class
- It’s the least secure
- Methods are typically public
• Package:  Visible to the current package
- There’s no keyword for this level of access
• private:  Visible only to the current class
- It’s the most secure
- Fields are typically private
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Continue editing the PrisonTest pr oject
• Modify the Cell  class:
- Change its fields to private
- Save the file
• Does your IDE have any complaints?
- What are the complaints?
- Where do they occur?
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Effects of Private Data
• The following private fields can’t be accessed outside the Cell 
c
lass:
-isOpen
-name
• Even the main method can’t access this data
• It’s good that prisoners can’t open their cell doors
• It’s bad that prisoners don’t know the names of their cells
- The next topic discusses how to address this issue
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Introducing Getter Methods
• When a field is inaccessible, it can’t be:
- Read
- Modified
• However, in many cases it’s desirable for one class to at least 
kno
w the value of another class’s fields
- A prisoner should at least know their cell name
- This requires a prisoner to read the value of a Cell’s name field
• Getter methods provide a solution
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Getter Methods, 1 of 2
• Getters are also called accessors
• Getters are public
• Getters usually accept no arguments
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Getter Methods, 2 of 2
• Getters return the value of a particular variable
- Most private variables require a getter method
public class Cell { 
 … 
 public String getName(){ 
  return name; 
 }//end method getName 
 public boolean getIsOpen (){ 
  return isOpen ; 
 }//end method getIsOpen 
}//end class Cell 
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Introducing Setter Methods
• In other cases, it’s desirable for one class to modify another 
c
lass’s field
• However, this must be done safely
• For example:
- A guard should be able to open a door, but a prisoner should not
- A bank account balance should not drop below zero
• Setter methods provide a solution
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Setter Methods
• Setters are also called mutators
• Setters are usually public
• Setters usually accept arguments
• Setters are void type methods
public class Cell { 
 … 
 public void setName(String name){ 
  this.name = name; 
 } //end method setName 
 public void setIsOpen(boolean isOpen){ 
  this.isOpen = isOpen; 
 } //end method setIsOpen 
}//end class Cell 
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Designing Setters
• Be careful when you write setters like those shown on the 
pr
evious slide
- Prisoners would again have access to their doors
• Sometimes a little thought needs to go into designing a setter 
me
thod
- A security door may ask for a security code
- Banking software may check whether a withdrawal amount would 
r
esult in a balance less than zero or if the withdrawal amount is 
negative
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 1, 1 of 2
• Continue editing the PrisonTest pr oject
• Modify the Cell class so that …
- Getters exist for the name and isOpen f ields
- There’s a private 4-d igit security code field, it’s initialized from the 
constructor and has no getter method
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 1, 2 of 2
- There’s a setter for opening/closing the door, and it does the 
f
ollowing:
• Accepts a security code as an argument
• Prints if the code is incorrect
• If the code is correct and the door is closed, opens it
• If the code is correct and the door is open, closes it
• Prints if the door is opened or closed
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 2
• Modify the Prisoner  class so that …
- The display() me thod prints the cell name
- The openDoor () method is removed
• Modify the main method so that …
- The Cell is instantiated properly
- The prisoner no longer tries to open the cell door
- It tests a cell class’s ability to open and close its door
• Try supplying both correct and incorrect security codes
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Continuing to Develop This Software, 1 of 2
• Currently, the main method tests a Cell door’s ability to open and 
clos
e based on a security code
• Testing allows us to confirm that this feature is implemented 
prope
rly
- If the feature doesn’t work, it should be fixed
- If the feature does work, it’s safe to include this feature as part of 
ano
ther feature
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Continuing to Develop This Software, 2 of 2
• A possible next step would be to develop a Guard class with a 
met
hod for inputting a security code
- Ultimately a guard, not the main method, would be responsible for 
in
putting a security code
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Role of the Main Method
• Some programs are driven by physical objects
• Some programs are driven by buttons
• In this exercise, the main method models actions that would 
dr
ive the program
- Calling bubba.openDoor () models a prisoner trying to open 
their cell door
- Calling cellA1.setIsOpen(1234)  models a person who entered 
a security code
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4
• Continue editing the PrisonTest pr oject
• Encapsulate the Prisoner  class
- Make its fields private
- Provide getters and setters for every field
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
That Exercise Wasn’t Fun!
• Was Exercise 4 tedious and did it make you groan?
• Some programmers prefer the control of encapsulating fields 
t
hemselves
• Other programmers would rather have their IDE do the work for 
t
hem
- Your IDE can encapsulate fields for you
- The following slides show how to do this in NetBeans
- If you are using a different IDE, consult the documentation for how 
t
o do this
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
NetBeans Encapsulation Trick, 1 of 2
1. Highlight t he fields that you want to encapsulate
2. Right- click and select Refactor >> Encapsulate Fields
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
NetBeans Encapsulation Trick, 2 of 2
3. Adjust the settings as you 
l
ike
4. Click R efactor
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary of Encapsulation
• Encapsulation offers techniques for limiting the visibility of a 
c
lass
• Access and visibility should be limited as much as possible
• Most fields should be private
• Provide getter methods to return the value of fields 
• Provide setter methods to safely modify fields
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 7-5
Object Interaction and Encapsulation
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Understand object interaction in greater detail
- Use the private modifier to define class variables
- Understand the purpose of getter methods
- Understand the purpose of setter methods
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text

```

</details>
