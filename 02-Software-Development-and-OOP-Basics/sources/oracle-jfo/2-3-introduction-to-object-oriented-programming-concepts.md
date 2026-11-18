# 2-3 Introduction to Object-Oriented Programming Concepts

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 2-3 Introduction to Object-Oriented Programming Concepts.pdf

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
2-3
Introduction to Object-Oriented 
Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Differentiate between procedural and object-or iented 
programming
- Understand a class a s a blueprint for an object
- Understand a class is  used to create instances of an object
- Model objects as a combination of …
• Properties (data fields)
• Behaviors (methods)
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Review
• So far, we've taken …
- Decades of computer science innovation
- Gigabytes of modern computing power
• And much like the Internet … 
- We've made a cat!
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Java Can Do More!
• Procedural languages …
- Read one line at a time
- The C language is procedural
• Object- oriented languages…
- Read one line at a time
- Model objects through code
- Emphasize object interaction
- Allow interaction without a prescribed order
- Java and C++ are object-or iented languages
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Object-Oriented Programming
• Interaction of objects
• No prescribed sequence
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Go to Java Puzzle Ball
• Play Basic Puzzles 1 through 5
- Your Goal: Design a solution that deflects the ball to Duke
• Consider the following:
- What objects do you find on the field of play?
- What happens when you put a triangle wall or simple wall icon on 
the b
lue wheel?
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
About Java Puzzle Ball
• Play a set of puzzles
• Become familiar with the game mechanics
• Consider questions as you play
• Listen to the lesson's debriefing on what you’ve observed
• Apply your observations to understand Java concepts
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Object Types
• What objects did you find on the field of play?
- Ball
- Duke
- Level Geometry
-RedBumper
-BlueBumper
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Object Interaction
• Interaction of objects
• No prescribed sequence
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
BlueBumper Objects
• What happens when you put a triangle wall or simple wall icon 
on a b
lue wheel?
• A wall appears on every instance of a BlueBumper  object
• Walls give bumpers behaviors that deflect and interact with the 
ball
• Al
l BlueBumper i nstances share these same behaviors
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Describing a BlueBumper
• Properties:
- Color
- Shape
- x-pos ition
- y-pos ition
• Behaviors:
- Make ping sound
- Flash
- Deflect ball (via Simple Wall)
- Deflect ball (via Triangle Wall)
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Describing a Ball
• Properties:
- Direction
- x-pos ition
- y-pos ition
• Behaviors:
- Make ping sound
- Change direction
- Change x-pos ition
- Change y-pos ition
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
BlueBumper and Ball Interaction
• Interaction occurs when the BlueBumper de flects the Ball
• When this happens …
- The Ball’s properties change:
• The Ball travels in a different direction
• The Ball’s future x-po sition and y-position 
change
- The BlueBumper p erforms behaviors:
• Makes ping sound
• Flashes
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Why Does This Matter?
• We've observed important aspects of object- oriented 
programming
• Remember these observations as lessons and exercises become 
i
ncreasingly technical
- Objects can be described as a combination of properties and 
be
haviors
- There may be many instances of the same object type
- All instances of an object share the same behaviors
- Objects may interact with each other, possibly affecting each 
ot
her's properties and triggering other behaviors
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
A Different Example
• Properties:
- Name
- Age
- Breed
- Favorite Food
• Behaviors:
- Make meow sound
- Play
- Wash
- Eat
- Hunt
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Classes and Instances, 1 of 2
• The combination of properties and behaviors is …
- Called a class
- A blueprint or recipe for an object
- Used to create object instances
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Creating New Instances from a Blueprint
Class Cat
Properties
name
age
favorite Food
Behaviors
meow()
play()
eat
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Object-Oriented Strategy
• How do you write programs that achieve this level of flexibility?
• When you have an idea or requirement for a program …
- Consider what type of objects may exist in this program
- Consider the properties and behaviors of these object types
- Consider how objects interact
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Duke's Choice Online Shopping
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Characteristics of Objects
• Objects are physical or conceptual
• Objects have properties:
- Size
- Price
- Color
• Objects have behaviors:
- Shop
- Put item in cart
- Pay
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Classes and Instances, 2 of 2
• Remember, a clas s …
- Is a blueprint or recipe for an object
- Describes an object’s properties and behaviors
- Is used to create Object instances
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 1
• Given the following scenario, what objects could you potentially 
mode
l to complete your program? 
- Design a program for a coin-s orting machine
- This machine should measure, count, and sort coins based on their 
s
ize or value
- It should also print a receipt
• List at least 3 objects you would need to model for this example
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 2
• Chose an object from Part 1
• What properties and behaviors of this object could you include in 
y
our program?
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Customer Properties and Behaviors
• Properties:
- Name
- Address
- Age
- Order number
- Customer number
• Behaviors:
- Shop
- Set address
- Add item to cart
- Ask for a discount
- Display customer details
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Translating into Java Syntax
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Java Terminology
public class Customer {
      public String name = "Junior Duke";
      public int    custID = 1205;
      public String address;
      public int    orderNum;
      public int    age;
      
      public void displayCustomer(){
          System.out.println("Customer: "+name);
    }//end method displayCustomer   
 }//end class Customer
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Modeling Properties and Behaviors
Customer class
name
address
billing info
age
customer number
order number
requestDiscount()
setAddress()
shop()
displayCustomer()
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Data Fields, 1 of 2
• Fields or Data Fields are the official Java terminology
• They’re also called:
- Properties
- Attributes
- Data Members
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Data Fields, 2 of 2
• Java has particular ways of representing data
- Section 3 will take a closer look at data
- We’ll use the main me thod for this investigation
- For now, it’s alright to include a lot of code in the main  method
- BUT a large main  method is strongly discouraged
- Section 4 explores how to avoid this scenario
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 2-3
Introduction to Object-Oriented Programming Concepts
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Differentiate between procedural and object-or iented 
programming
- Understand a class as a blueprint for an object
- Understand a class is used to create instances of an object
- Model objects as a combination of …
• Properties (data fields)
• Behaviors (methods)
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text

```

</details>
