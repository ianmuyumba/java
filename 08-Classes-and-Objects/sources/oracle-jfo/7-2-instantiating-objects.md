# 7-2 Instantiating Objects

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 7-2 Instantiating Objects.pdf

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
7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Understand the memory consequences of instantiating objects
- Understand object references
- Understand the difference between stack and heap memory
- Understand how Strings are special objects
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Scenario, 1 of 3
Thank you for developing 
software for my bank! It 
would be an honor to 
shake your hand.
Thanks to you, our clients are 
opening more accounts than 
ever before.
And the children have 
never been happier!
Later that night …
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Scenario, 2 of 3
Ha! Ha! Ha! Stealing is fun!
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Scenario, 3 of 3
Halt, thieves!
Thank you, stranger. Will you 
develop software for our prison?
I can’t … 
But I know someone 
who can.
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Describing a Prisoner
• Properties:
- Name
- Height
- Years Sentenced
• Behaviors:
- Think about what they’ve 
don
e
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Create a new Java project
• Create a PrisonTest clas s with a main method
• Create a Prisoner c lass based on the description in the 
previous slide
• Instantiate two prisoners and assign them the following 
prope
rties:
Variable:  bubba
Name:      Bubba
Height:    6'10"(2.08m)
Sentence:  4 years
Variable:  twitch
Name:      Twitch
Height:    5’8"(1.73m)
Sentence:  3 years
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• Can prisoners fool security by impersonating each other?
- Write a print statement with a b oolean expression that tests if 
bubba == twitch
- Change the properties of twitch so that they match bubba
- Then test the equality of these objects again
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Programming the Prisoner Class
• Your class may look something like this:
public class Prisoner { 
 public String name;  
 public double  height; 
 public int sentence ;
 
 public void think (){ 
  System.out. println("I'll have my revenge."); 
 }//end method think 
}//end class Prisoner 
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Prisoner Impersonation
• The bo olean bubba == twitch is false
- Security wasn’t fooled by prisoners who share the same properties
- Security understood that each prisoner was a unique object
• How is this possible?
public class PrisonTest { 
 public static  void main(String[] args){ 
  Prisoner bubba =  new Prisoner(); 
  Prisoner twitch = new Prisoner(); 
  … 
  System.out. println(bubba == twitch); //false 
 }//end method main 
}//end class PrisonTest 
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Prisoner Locations
• Prisoners live in cells
• New prisoners are assigned an available cell for living quarters
• If a prisoner lives in a unique cell, he’s a unique object
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Prisoner Object Locations
• Cells are like locations in memory
• Instantiating a Prisoner fills an available location in memory with 
t
he new Prisoner object
public class PrisonTest { 
 public static void main(String[] args){ 
  Prisoner bubba = new Prisoner(); 
  Prisoner twitch = new Prisoner(); 
 } //end method main 
}//end class PrisonTest 
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The new Keyword, 1 of 2
• The new keyword allocates available memory to store a newly 
cr
eated object
• Java developers don’t need to know an object’s location in 
me
mory
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The new Keyword, 2 of 2
- We only need to know the variable for the object
- But we can still print memory addresses
public class PrisonTest { 
 public static  void main(String[] args){ 
  Prisoner bubba =  new Prisoner(); 
  Prisoner twitch = new Prisoner(); 
  System.out. println(bubba); //prisontest.Prisoner@15db9742 
  System.out. println(twitch); //prisontest.Prisoner@6d06d69c 
 }//end method main 
}//end class PrisonTest 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objects with the Same Properties
• Objects may share the same properties
• But it doesn’t mean that these objects are equal
• As long as you use the new  keyword during instantiation …
- You’ll have unique objects
- Each object will have a different location in memory
Variable:  bubba
Name:      Bubba
Height:    6'10"(2.08m)
Sentence:  4 years
Memory Address: 
@15db9742
Variable:  twitch
Name:      Twitch
Height:    5’8"(1.73m)
Sentence:  3 years
Memory Address: 
@6d06d69c
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Comparing Objects, 1 of 2
• If you compare two objects using the == operator …
- You’re checking if their memory addresses are equal
- You're not checking if their fields are equal
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Comparing Objects, 2 of 2
• The bo olean bubba == twitch is false because …
- Memory addresses @15db9742 and @6d06d69c are different
- It doesn’t matter if bubba and twitch share the same properties
public class PrisonTest { 
public static void main(String[] args){ 
Prisoner bubba = new Prisoner(); 
Prisoner twitch = new Prisoner(); 
… 
System.out.println(bubba == twitch); //false 
}//end method main 
}//end class PrisonTest 
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing Objects by Using a Reference
The camera is like the object that’s 
accessed by using a reference
The remote is like the reference 
that’s used to access the camera
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Working with Object References
1. Pick up remote to gain 
acce
ss to the camera
2. Press remote control buttons 
to h
ave the camera do 
something
1. Create a Camera object and 
get a reference to it
Camera remote1 = new Camera();
2. Create a Camera object and 
ge
t a reference to it
remote1.play(); 
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Working with Object References: Example 1
remote1
 remote2
Camera remote1 = new Camera(); 
Camera remote2 = new Camera(); 
remote1.play(); 
remote2.play(); 
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Working with Object References: Example 2
Camera remote1 = new Camera(); 
Camera remote2 = remote1; 
remote1.play(); 
remote2.stop(); 
There’s only one 
Camera object
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
References to Different Objects
Camcorder
Camcorder remote
Television
Television remote
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
References to Different Objects: Example, 
1 of 2
Camera remote1 = new Camera(); 
remote1.menu(); 
TV remote2 = new TV(); 
remote2.menu(); 
Prisoner bubba = new Prisoner(); 
bubba.think(); 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
References to Different Objects: Example, 
2 of 2
• The following example isn’t allowed because …
- The Reference Type doesn’t match the Object Type
- A prisoner and a TV are completely different things
Prisoner twitch = new TV(); 
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Continue experimenting with the PrisonTes t class
• Is security fooled when reference variables change?
- Instantiate two prisoners and assign them the properties below
- Test the equality of these objects
- Then set the reference variable for bubba equal to twitch
- Test the equality of these objects again
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Stack Memory and Heap Memory
• Understanding the results of Exercise 2 requires an 
un
derstanding of the types of memory that Java uses
• Stack memory is used to store …
- Local variables
- Primitives
- References to locations in the heap memory
• Heap memory is used to store …
- Objects
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
References and Objects in Memory
int x = 1; 
int y = 2; 
Prisoner bubba = new Prisoner(); Prisoner twitch = new Prisoner(); 
… 
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Assigning a Reference to Another Reference
bubba = twitch; 
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Two References, One Object
• As of line 14, bubba and twitch reference the same object
• Either reference variable could be used to access the same data
11 Prisoner bubba = new Prisoner(); 
12 Prisoner twitch = new Prisoner(); 
13 
14 bubba = twitch; 
15 
16 bubba.name = "Bubba"; 
17 twitch.name = "Twitch"; 
18 
19 System.out.println(bubba.name); //Twitch 
20 System.out.println(bubba == twitch); //true 
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Two References, Two Primitives
• Primitives are always separate variables
• Primitive values always occupy different locations in the stack 
me
mory
• Line 14 briefly makes primitive values x and y equal
11 int x; 
12 int y; 
13 
14 x = y; 
15 
16 x = 1; 
17 y = 2; 
18 
19 System.out.println(x); //1 
20 System.out.println(x == y); //false 
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Happened to Bubba?
• If no more reference variables point to an object …
• Java automatically clears the memory once occupied by that 
obj
ect
- This is called Garbage Collection
- The data associated with this object is lost forever
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Strings Are Special Objects
• Printing a String reference prints the actual String instead of the 
ob
ject’s memory address
• Strings can be instantiated with the new keyword
- But you shouldn’t do this
String s1 = new String("Test");
• Strings should be instantiated without new
- This is more memory-e fficient
- We’ll explore why in the next few slides
String s2 = "Test"; 
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Continue experimenting with the PrisonTes t class
• See the memory consequences of Strings for yourself
- Instantiate two prisoners with the names shown below
- Set their names by using the ne w keyword and test the equality of 
these Strings by using ==
- Set their names without using the new k eyword and test the 
equality of these Strings by using ==
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Instantiating Strings with the new Keyword
• Using the new keyword creates two different references to two 
d
ifferent objects
String s1 = new String("Test"); 
String s2 = new String("Test"); 
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Instantiating Strings Without the new Keyword
• Java automatically recognizes identical Strings and saves 
me
mory by storing the object only once
• This creates two different references to one object
String s1 = "Test"; 
String s2 = "Test"; 
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String References
• Altering a String using one reference won’t affect other 
r
eferences
• Java allocates new memory for a different String
String s1 = "Test"; 
String s2 = "Test"; 
s1 = "Different"; 
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 7-2
Instantiating Objects
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Understand the memory consequences of instantiating objects
- Understand object references
- Understand the difference between stack and heap memory
- Understand how Strings are special objects
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text

```

</details>
