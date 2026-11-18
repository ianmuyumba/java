# 8-2 Student Guide

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 8-2 Student Guide.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
1
Oracle Academy – Begin Lesson
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
2
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
3
Objectives
• This lesson covers the following objectives:
- Create an ArrayList
- Manipulate an ArrayList by using its methods
- Traverse an ArrayList using iterators and for-each loops
- Use wrapper classes and Autoboxing to add primitive data types to
an ArrayList
3
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
4
Collection of Objects (Real Life)
• In real life, objects often appear in groups
• For example:
- Parking lots contain multiple cars
- Banks contain multiple accounts
- Stores have multiple customers
- A student has multiple assignment grades
4
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
5
Collection of Objects (Programming)
• When programming, you often gather data (objects)
• This is commonly referred to
as a collection
• In Java, the simplest way of collecting information is by using the
ArrayList
• The Java ArrayList class can store a group of many objects
5
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
6
Managing Students Enrolled in a Class
• Say a group of students is enrolled in Java Programming 101
• You want to write a Java program to track the enrolled students
• The simplest way would be to create an array, as discussed in the
previous lesson
6
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
7
Using Arrays to Manage Enrolled Students
• You can write a student array like this:
String[] students={"Mary", "Sue", "Harry", "Rick", "Cindy", "Bob"};
• Consider a scenario where, after a week, two students (Mike and
Larry) enroll in the course and Sue drops out
• How easy do you think it is to modify the students array to
accommodate these changes?
7
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
8
Limitations of Arrays
• Their size is fixed on creation and cannot grow or shrink after
initialization
• You have to create manual methods to manipulate their contents
• For example: insert or delete an item from an array
8
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
9
ArrayList Class
• Arrays aren’t the only way to store lists of related data
• Java provides a special utility class called ArrayList
• The ArrayList class:
- Is a part of the Java library, like the String and Math classes.
- It can be used to store a list of objects
- Has a set of useful methods for managing its elements:
• add(), get(), remove(), indexOf(), and many others
9
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
ArrayList supports dynamic arrays that can grow as needed. In Java, standard arrays are
of a fixed length. After arrays are created, they can’t grow or shrink, which means that
you must know, in advance, the number of elements in an array. But, sometimes, you
may not know precisely how large an array you need until run time.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
10
What Can an ArrayList Contain?
• An ArrayList can contain only objects, not primitives
- It may contain any object type, including a type that you created by
writing a class
• For example, an ArrayList can hold objects of type:
- String
- Person
- Car
10
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
The slide example shows ArrayList, names, to which you are adding two String objects
by using the add method of the ArrayList . You can remove an object from the ArrayList
by using the remove method.
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
11
Importing and Declaring an ArrayList
• You must import java.util.ArrayList to use an ArrayList
import java.util.ArrayList;
public class ArrayListExample {
 public static void main (String[] args) {
  ArrayList<String> states = new ArrayList<>();
 }//end method main
}//end class ArrayListExample
Y ou can specify an initial
capacity, but it isn’t mandatory
Y ou may specify any object type,
called as Type Parameters, specifies
that it contains only String objects
11
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
12
Working with an ArrayList, 1 of 2
• You don’t access elements in an ArrayList by using index
notation
• Instead, you use a series of methods that are available in the
ArrayList class
12
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
13
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
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
14
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
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
When you declare an ArrayList, you use the diamond operator (<>) to indicate the
object type.
In the slide example, there are a number of methods to add data to the ArrayList.
This example uses the add method to add several String objects to the list: The
add(int index, E element) method inserts an element at a specific location.
Using the remove method, you can delete an element by passing the index or by
passing the  item to be deleted.
remove(0) removes the first element at index zero (in this case, "Jamie").
remove(names.size() – 1) removes the last element, which would be “Jose.”
remove("Gustav") removes an element that matches a specific value.
You can pass the ArrayList to System.out.println. The resulting output is [Prashant,
Alisa].
*Note: Removing an item DOES NOT leave a gap in the array.  The array size is reduced.
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
15
Benefits of the ArrayList Class
• Dynamic resizing:
- An ArrayList grows as you add elements
- An ArrayList shrinks as you remove elements
• Several built-in methods:
- An ArrayList has several methods to perform operations
- For example, to add, retrieve, or remove an element
15
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
16
Exercise 1, Part 1
• Create a new project and add the ArrayListEx1.java file to the
project
• Examine ArrayListEx1.java
• Modify the program to implement:
- Create an ArrayList of Strings called students
- Add four students to the ArrayList: Amy, Bob,Cindy and David
- Print the elements in the ArrayList and display its size
16
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
17
Exercise 1, Part 2
• Modify the program to implement:
- Add two more students, Nick and Mike, at index 0 and 1
- Remove the student at index 3
- Print the elements in the ArrayList and display its size
17
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
18
Traversing an ArrayList
• You can traverse an ArrayList in the following ways:
- Using the for-each loop
- Using an Iterator
- Using a ListIterator
18
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
19
Traversing an ArrayList: for-each Loop, 1 of 2
• In the previous lesson, you used a for-each loop to traverse an
array
• You can use a for-each loop to traverse an ArrayList
• The variable i represents a particular name as you loop through
the names ArrayList
for (String i : names) {
 System.out.println("Name is " + i);
}//end for
19
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
20
Traversing an ArrayList: for-each Loop, 2 of 2
public class ArrayListTraversal {
 public static void main(String[] args) {
  ArrayList<String> names = new ArrayList<>();
  names.add("Tom");
  names.add("Mike");
  names.add("Matt");
  names.add("Nick");
  System.out.println("");
  for (String i : names) {
   System.out.println("Name is " + i);
  }//end for
 }//end method main
}//end class ArrayListTraversal
Output:
Name is Tom
Name is Mike
Name is Matt
Name is Nick
20
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
21
Introducing Iterator
• Is a member of the collections framework
• Enables traversing through all elements in the ArrayList,
obtaining or removing elements
• Has the following methods:
-hasNext(),next(),remove()
• Is only used to traverse forward
• You must import java.util.Iterator to use an Iterator
21
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
22
Traversing an ArrayList: Iterator
• Here’s an example of traversing the names collection by using an
iterator
Iterator<String> iterator = names.iterator();
while (iterator.hasNext())
{
 System.out.println("Name is " + iterator.next());
}//end while
22
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
To use an iterator to cycle through the contents of an ArrayList, follow these steps:
Call the collection’s iterator( ) method.
Set up a loop that makes a call to hasNext( ), and have the loop iterate as long as
hasNext( ) returns true.
Within the loop, obtain each element by calling next( ).
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
23
Introducing ListIterator
• ListIterator
- Is a member of the collections framework
- Allows you to traverse the ArrayList in both directions
- Doesn’t contain the remove method
• You must import java.util.ListIterator to use an ListIterator
23
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
24
Traversing an ArrayList: ListIterator
• Here’s an example of using ListIterator to traverse the names
ArrayList in forward and backward directions:
ListIterator<String> litr = names.listIterator();
System.out.println("Traversing list forwards: ");
while (litr.hasNext()) {
 System.out.println("Name is " + litr.next());
}//end while
System.out.println("Traversing list backwards: ");
while (litr.hasPrevious()) {
 System.out.println("Name is " + litr.previous());
}//end while
24
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
25
ArrayList and Primitives
• An ArrayList can store only objects, not primitives
ArrayList<int> list = new ArrayList<int>();
• But you can still use ArrayList with primitive types by using
special classes called wrapper classes
ArrayList<Integer> list = new ArrayList<Integer>();
25
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
26
Wrapper Classes
• Java provides classes, known as wrapper classes, that
correspond to the primitive types
• These classes encapsulate, or wrap, the primitive types within an
object
• The eight wrapper class types correspond to each primitive data
type
26
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
27
List of Wrapper Classes
• Here’s the list of primitive data types and their corresponding
wrapper classes:
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
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
28
Introducing AutoBoxing and Unboxing
• Java has a feature called Autoboxing and Unboxing
• This feature performs automatic conversion of primitive data
types to their wrapper classes and vice versa
• It enables you to write leaner and cleaner code, making it easier
to read
28
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
29
What Is Autoboxing?
• The automatic conversion that the Java compiler makes between
the primitive types and their corresponding object wrapper
classes
Double score = 18.58;
29
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
30
What Is Unboxing?
• Converting an object of a wrapper type to its corresponding
primitive value
1 Double score = 18.58; 2
double goal = score;
30
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
31
ArrayList and Wrapper Classes
• Wrapper classes allow an ArrayList to store primitive values
public static void main(String args[]) {
 ArrayList<Integer> nums = new ArrayList<>();
 for (int i = 1; i < 50; i++) {
  nums.add(i);
 }//end for
 for(Integer i:nums ){
  int nos = i;
  System.out.println(nos);
 }//end for
}//end method main
31
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
The code example demonstrates how you can populate ArrayList with primitive
data by using Autoboxing and Unboxing.
AutoBoxing: int is converted to Integer and is added to ArrayList without
explicitly invoking the wrapper class, Integer
UnBoxing: The Integer object is converted to the primitive int without
invoking any method to do the conversion
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
32
Exercise 2
• Add the file ArrayListEx2.java to the project you created for
exercise 1
• Examine ArrayListEx2.java
• Perform the following:
- Create an ArrayList with a list of numbers
- Display the contents of the ArrayList by using Iterator
- Remove all even numbers
- Display the contents of the ArrayList
32
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
33
Summary
• In this lesson, you should have learned how to:
- Create an ArrayList
- Manipulate an ArrayList by using its methods
- Traverse an ArrayList by using iterators and for-each loops
- Use wrapper classes and Autoboxing to add primitive data types to
an ArrayList
33
JFo 8-2
ArrayLists
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its
affiliates. Other names may be trademarks of their respective owners.
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
34
Oracle Academy – End of Lesson
```

</details>
