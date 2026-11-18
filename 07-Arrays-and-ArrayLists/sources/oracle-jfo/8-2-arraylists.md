# 8-2 ArrayLists

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 8-2 ArrayLists.pdf

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
8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives: 
- Create an A rrayList
- Manipulate an ArrayList b y using its methods
- Traverse an A rrayList using iterators and for-each loops
- Use wrapper classes and Autoboxing to add primitive data types to 
an
 ArrayList
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Collection of Objects (Real Life)
• In real life, objects often appear in groups
• For example:
- Parking lots contain multiple cars
- Banks contain multiple accounts
- Stores have multiple customers
- A student has multiple assignment grades
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Collection of Objects (Programming)
• When programming, you often gather data (objects)
• This is commonly referred to 
as
 a collection
• In Java, the simplest way of collecting information is by using the 
A
rrayList
• The Java A rrayList  class can store a group of many objects
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Managing Students Enrolled in a Class
• Say a group of students is enrolled in Java Programming 101
• You want to write a Java program to track the enrolled students
• The simplest way would be to create an array, as discussed in the 
pr
evious lesson
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using Arrays to Manage Enrolled Students
• You can write a student array like this:
String[] students={"Mary", "Sue", "Harry", "Rick", "Cindy", "Bob"}; 
• Consider a scenario where, after a week, two students (Mike and 
L
arry) enroll in the course and Sue drops out
• How easy do you think it is to modify the students array to 
a
ccommodate these changes?
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Limitations of Arrays
• Their size is fixed on creation and cannot grow or shrink after 
in
itialization
• You have to create manual methods to manipulate their contents
• For example: insert or delete an item from an array
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
ArrayList Class
• Arrays aren’t the only way to store lists of related data 
• Java provides a special utility class called ArrayList
• The ArrayList  class:
- Is a part of the Java library, like the String and Math classes.
- It can be used to store a list of objects
- Has a set of useful methods for managing its elements:
• add(), get(), remove() , indexOf(), and many others
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Can an ArrayList Contain?
• An ArrayList c an contain only objects, not primitives
- It may contain any object type, including a type that you created by 
writ
ing a class
• For example, an ArrayList can  hold objects of type:
- String 
- Person
- Car
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Importing and Declaring an ArrayList
• You must import java .util.ArrayList to use an ArrayList
import java.util.ArrayList; 
public class ArrayListExample { 
 public static void main (String[] args) { 
  ArrayList< String> states = new ArrayList<>(); 
 }//end method main 
}//end class ArrayListExample 
You can specify an initial 
capacity, but it isn’t mandatory
You may specify any object type, 
called as Type Parameters, specifies 
that it contains only String objects
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Working with an ArrayList, 1 of 2
• You don’t access elements in an ArrayList  by using index 
notation
• Instead, you use a series of methods that are available in the 
ArrayList 
class
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Some ArrayList Methods 
Method Description
add(value) Appends the value to the end of the list
add(index, value) Inserts the given value just before the given index, shifting subsequent values to the right
clear() Removes all elements of the list
indexOf(value) Returns the first index where the given value is found in the list (-1 if not found)
get(index) Returns the value at the given index
remove(index) Removes the value at the given index, shifting subsequent values to the left
set(index, value) Replaces the value at the given index with a given value
size() Returns the number of elements in the list
toString() Returns a string representation of the list,such as "[3, 42, -7, 15]"
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Working with an ArrayList, 2 of 2
• Here’s an example that uses these methods: 
ArrayList<String> names; 
names = new ArrayList(); 
names.add("Jamie"); 
names.add("Gustav"); 
names.add("Alisa"); 
names.add("Jose"); 
names.add(2,"Prashant"); 
String str=names.get(0); 
System.out.println(str); 
names.remove(0); 
names.remove(names.size() - 1); 
names.remove("Gustav"); 
System.out.println(names); 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Benefits of the ArrayList Class
• Dynamic resizing:
- An A rrayList  grows as you add elements
- An A rrayList  shrinks as you remove elements
• Several built- in methods:
- An A rrayList  has several methods to perform operations
- For example, to add, retrieve, or remove an element
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Create a new pr oject and add the ArrayListEx1.java file to the 
project
• Examine ArrayLis tEx1.java
• Modify the program to implement:
- Create an A rrayList of Strings called students
- Add four students to the A rrayList: Amy, Bob,Cindy and David
- Print the elements in the ArrayList a nd display its size
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• Modify the program to implement:
- Add two more students, Nick and Mike, at index 0 and 1
- Remove the student at index 3
- Print the elements in the ArrayList a nd display its size
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Traversing an ArrayList
• You can traverse an A rrayList in the following ways:
- Using the for-e ach loop
- Using an Iterator
- Using a ListIterator
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Traversing an ArrayList: for-each Loop, 1 of 2
• In the previous lesson, you used a for- each loop to traverse an 
array
• You can use a for- each loop to traverse an ArrayList
• The variable i represents a particular name as you loop through 
the names ArrayList
for (String i : names) { 
 System.out. println("Name is " + i); 
}//end for 
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Traversing an ArrayList: for-each Loop, 2 of 2
public class ArrayListTraversal { 
 public static  void main(String[] args) { 
  ArrayList< String> names = new ArrayList<>(); 
  names .add("Tom"); 
  names .add("Mike"); 
  names .add("Matt"); 
  names .add("Nick"); 
  System.out. println(""); 
  for  (String i : names) { 
   System.out. println("Name is " + i); 
  }//end for 
 }//end method main 
}//end class ArrayListTraversal 
Output:
Name is Tom
Name is Mike
Name is Matt
Name is Nick
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Introducing Iterator
• Is a member of the co llections framework
• Enables traversing through all elements in the ArrayList, 
o
btaining or removing elements
• Has the following methods:
-hasNext(),next (),remove()
• Is only used to traverse forward
• You must import java.util.Iterator to use an Iterator
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Traversing an ArrayList: Iterator
• Here’s an example of traversing the names collection by using an 
it
erator
Iterator<String> iterator = names.iterator(); 
while (iterator.hasNext()) 
{ 
 System.out. println("Name is " + iterator.next()); 
}//end while 
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Introducing ListIterator
• ListIterator 
- Is a member of the c ollections framework
- Allows you to traverse the ArrayList in  both directions
- Doesn’t contain the remove method
• You must import java.util.ListIterator to use an ListIterator
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Traversing an ArrayList: ListIterator
• Here’s an example of using L istIterator to traverse the names 
ArrayList in forward and backward directions:
ListIterator<String> litr = names.listIterator(); 
System.out.println("Traversing list forwards: "); 
while (litr.hasNext()) { 
 System.out. println("Name is " + litr.next()); 
}//end while 
System.out.println("Traversing list backwards: "); 
while (litr.hasPrevious()) { 
 System.out. println("Name is " + litr.previous()); 
}//end while 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
ArrayList and Primitives
• An A rrayList  can store only objects, not primitives
ArrayList<int> list = new ArrayList<int>(); 
• But you can still use ArrayList w ith primitive types by using 
special classes called wrapper classes
ArrayList<Integer> list = new ArrayList<Integer>(); 
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Wrapper Classes
• Java provides classes, known as wrapper classes, that 
cor
respond to the primitive types
• These classes encapsulate, or wrap, the primitive types within an 
ob
ject
• The eight wrapper class types correspond to each primitive data 
t
ype
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
List of Wrapper Classes
• Here’s the list of primitive data types and their corresponding 
wr
apper classes:
Primitive Type Wrapper Type
byte Byte
Short Short
int Integer
long Long
float Float
double Double
char Character
boolean Boolean
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Introducing AutoBoxing and Unboxing
• Java has a feature called Autoboxing and Unboxing
• This feature performs automatic conversion of primitive data 
t
ypes to their wrapper classes and vice versa
• It enables you to write leaner and cleaner code, making it easier 
t
o read
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is Autoboxing?
• The automatic conversion that the Java compiler makes between 
t
he primitive types and their corresponding object wrapper 
classes
Double score = 18.58; 
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is Unboxing?
• Converting an object of a wrapper type to its corresponding 
pr
imitive value 
1 Double score = 18.58; 2 
double goal = score; 
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
ArrayList and Wrapper Classes
• Wrapper classes allow an Arr ayList to store primitive values
public static void main(String args[]) { 
 ArrayList< Integer> nums = new ArrayList<>(); 
 for  (int i = 1; i < 50; i++) { 
  nums. add(i); 
 }//end for 
 for(Integer i:nums ){ 
  int nos = i; 
  System.out. println(nos); 
 }//end for 
}//end method main 
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Add the file ArrayListEx2.ja va to the project you created for 
exercise 1
• Examine ArrayLis tEx2.java
• Perform the following:
- Create an A rrayList with a list of numbers
- Display the contents of the A rrayList by using Iterator
- Remove all even numbers
- Display the contents of the A rrayList
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Create an A rrayList
- Manipulate an ArrayList b y using its methods
- Traverse an A rrayList by using iterators and for-each loops
- Use wrapper classes and Autoboxing to add primitive data types to 
an
 ArrayList
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text

```

</details>
