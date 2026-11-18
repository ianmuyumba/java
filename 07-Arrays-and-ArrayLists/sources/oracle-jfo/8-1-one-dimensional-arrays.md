# 8-1 One-dimensional Arrays

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 8-1 One-dimensional Arrays.pdf

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
8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives: 
- Create and initialize one-di mensional arrays
- Modify an array element
- Traverse a one-di mensional array by using a for loop
- Identify the cause of an ArrayIndexOutOfBoundsExcept ion 
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Can a Variable Hold More Than One Value?
• So far we have used many types of variables, but each variable 
s
tores one value at a time: 
- one int or one String or one double
• Here’s an example of a String variable, r ockBand, that can hold 
any value – Joe, Paul, Ed, Rob:
- Since there are only 4 possible values, it isn’t too difficult to change 
th
e variable’s value manually
String rockBand = "Joe"; 
String rockBand = "Paul"; 
String rockBand = "Ed"; 
String rockBand = "Rob"; 
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Number of Variables Required
• But there are times when you’ll need to hold more than one value 
i
n a variable
• What if you wanted to set aside a variable for each one of the 
R
ockBand songs? (That would be 300 variables for each song!)
• However, it can be time-consuming and tedious to create 
hu
ndreds of variables
String rockBandSong1 = "Rainy day"; 
String rockBandSong2 = "Forever"; 
String rockBandSong3 = "Something about you"; 
String rockBandSong4 = "Love you always"; 
…… 
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Arrays Can Provide a Solution, 1 of 2
• In Java, an array is an indexed container that holds a set of 
v
alues of a single type
• Arrays allow you to create a single identifier to organize many 
i
tems of the same date type
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Arrays Can Provide a Solution, 2 of 2
• Each item in an array is called an element
• Arrays make storing and accessing a large number of values 
s
imple and easy
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Arrays Are Accessed by Their Index
• You can access each element in an array by its numerical index
• The index of the first element is 0
• A 10-element array has 0 to 9 indices
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Array Data Types, 1 of 2
• Arrays can be of any data type, but all elements have to share the 
s
ame type, such as:
- Primitive:
• Example: Array of int types
- Predefined objects:
• Example: Array of Strings
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Array Data Types, 2 of 2
• Arrays can be of any data type, but all elements have to share the 
s
ame type, such as:
- Programmer-d efined objects:
• (such as instances of a class that you create)
• Example: Array of objects of the Student class
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Declaring an Array
• Arrays, like all variables, must be declared prior to use
• You can declare an array by using the following syntax: 
type[] arrayIdentifier; 
• Notice the bracket notation [ ] after the data type
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Declaring an Array of Temperature Values
• Suppose you want to store different temperature readings in an 
a
rray
• You can declare an array as follows:
double[] temperature; 
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Declaring an Array: Two Methods
• You can declare an array in two ways:
int[] prime; 
int prime[]; 
• Both syntaxes are equivalent
• The first format generally is more readable and should be used
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Is Declaring an Array Sufficient? 1 of 2
• Declaring an array isn’t enough to begin using it in your program
• Before you use an array, you need to tell Java to create space in 
m
emory for the elements that it will hold 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Is Declaring an Array Sufficient? 2 of 2
• Use the following syntax:
data_type[] variable_name = new data_type[size]; 
variable_name[index] = value; //repeat for each element 
• The size value determines the number of items that your array 
c
an hold
• Arrays can’t grow beyond this size
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Creating an Array
• For example, if you want to create an array to hold 100 integers, 
y
ou could do the following:
int[] myIntArray; 
myIntArray = new int[100]; 
• Alternatively, you could perform these two lines in one step:
int[] myIntArray = new int[100]; 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Do the Code Snippets Do?
int[] ages = new int[3]; 
ages[0] = 19; 
ages[1] = 42; 
ages[2] = 92; 
String[] names = new String[3]; 
names[0] = "Mary"; 
names[1] = "Bob"; 
names[2] = "Carlos"; 
2
Variable Name Index Value
1
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What About Declaring and Initializing an Array in a 
Single Step? 1 of 2
• You can also declare and initialize the array in a single step with 
kno
wn values:
type[] arrayIdentifier = {comma-separated list of values}; 
• For example, declare arrays of types String and int:
String[] names = {"Mary", "Bob", "Carlos"}; 
int[] ages = {25, 27, 48}; 
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What About Declaring and Initializing an Array in a 
Single Step? 2 of 2
• Notice that this method doesn’t specify size
• It’s assigned a size based on the number of elements between 
t
he braces ( { } )
String[] names = {"Mary", "Bob", "Carlos"}; 
int[] ages = {25, 27, 48}; 
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing Array Elements
• Arrays are sequential structures, meaning that items are stored 
o
ne after another in an array
• You can access an individual element of an array by using a 
br
acket notation
• For example, here’s how you get values from the ages array: 
int[] ages = {25, 27, 48}; 
int myAge = ages[0]; 
int yourAge = ages[1]; 
System.out.println("My age is " + ages[0]); 
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Y ou Set the Value of an Array Element?
• You can set values to the array’s elements like this:
String[] names = {"Mary", "Bob", "Carlos"}; 
names[0] = "Gary"; 
names[1] = "Rob"; 
• After you set the values to the elements at indices 0 and 1, the 
nam
es array looks like this:
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Can you identify the three components of an array declaration 
f
or each of these arrays of primitive data types?
- Data Type
- Name
- Size
int[] myArray; 
myArray = new int[20]; 
char[] sentence = new char[100]; 
double[] teamPoints = new double[5]; 
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Default Initialization of Arrays 
• When arrays are declared but not yet initialized, the elements are 
gi
ven the default value associated with the data type
•  Here’s an example:
int[] myArray = new int[5]; 
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Y ou Access the Length of an Array?
• So far, you created an array with a certain number of elements
• After creation, you can’t change the length of an array. They can’t 
gr
ow beyond this size
• You can access the size of any array by using the array’s length 
pr
operty
int primes[] = {2, 3, 5, 7, 11, 13, 17}; 
System.out.println("Array length: " + primes.length); 
//prints 7 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Array Indices and Length
• For example, the following code snippet displays the size of the 
a
ges array:
int ages[] = {27, 12, 82, 70, 54, 1, 30, 34}; 
System.out.println(ages.length); //prints 8 
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Create a new project ArrayEx  and add the ArrayEx1.java file 
to the project
• Examine ArrayEx1.java
• Modify the program to implement …
- Declare a one-di mensional array named score of type int that can 
hold 9 values
- Declare and initialize a one-di mensional byte array named values 
of size 10 so that all entries contain 1
- Uncomment the two lines that are commented out and then 
r
esolve the syntax errors
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Traversing an Array
• To iterate through, or traverse, an array means to process 
t
hrough each element of the array by index number
• You can access each element of an array to …
- Print the elements
- Search for an element
- Initialize the elements of an array with the same value
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using a for Loop to Traverse Arrays
• You can use a for loop to traverse arrays
• The for loop lets you easily iterate over a known range
• You can visit every array element by using the length property of 
t
he array in the iteration condition
int[] array = { -20, 19, 1, 5, -1, 27, 19, 5 } ; 
int min = array[0]; // initialize the current minimum 
for (int index=0; index < array.length; index++ ) 
 if (array[index] < min) 
  min =  array[index] ; 
System.out.println("The minimum of this array is: " + min); 
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Y ou Print the Values of a names Array?
• Consider an array of Strings, names:
String names[] = {"Tom", "David", "Mike"}; 
• Traverse the names array by using the for loop:
for (int idx = 0; idx < names.length; idx++){ 
System.out.println(names[idx]); 
}//end for 
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using a for-each Loop to Traverse an Array, 
1 of 2
• You can use a for- each loop, an alternative to using the for loop, 
to iterate through an array
• The for- each loop … 
- Works the same way as the for loop, but it’s implemented in a 
si
mpler way
- Is also called an enhanced for loop
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using a for-each Loop to Traverse an Array, 
2 of 2
• Syntax:
for (<type> <iteration variable> : <array name>) { 
 <code_block to be performed for each array element> 
}//end for 
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do You Print the Values of a names Array by 
Using a for-each Loop? 1 of 2
• Here’s an example of traversing the names array by using a for-
e
ach loop:
for(String name: names){ 
 System.out. println(name); 
}//end for
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do You Print the Values of a names Array by 
Using a for-each Loop? 2 of 2
• For each iteration of the loop, the next element in the array is 
r
etrieved and stored in an iteration-variable
• The type must be the same as the elements stored in the 
co
llection
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
for-each Loop vs. for Loop
• for- each loop
for(String name: names){ 
 System.out. println(name); 
}//end for 
• for loop
for (int idx = 0; idx < names.length; idx++){ 
 System.out. println(names[idx]); 
}//end for 
• The output of both loops is the same
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Processing a String Array
Loop accesses 
each element in 
turn
for(String name : names ) { 
 System.out. println("Name is " + name); 
} //end for 
Each iteration returns 
the next element of 
the array
• Output:
Name is George
Name is Jill
Name is Xinyi
Name is Ravi
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Putting It All Together
• Let’s look at an example where you need to …
- Enter the scores of 10 students by using a Scanner object
- Display the scores that you entered
- Calculate the average of the scores that you entered
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Let’s Compute the Average Score 
public class StudentScores { 
 public static void main(String args[]) { 
  double scores[] = new double[10]; 
  double sum = 0.0, avg = 0.0; 
  Scanner keyboard = new Scanner(System.in); 
  System.out.println("Enter scores of 10 students"); 
  for(int i = 0; i < scores.length; i++) { 
   scores[i] = keyboard.nextInt(); 
  }//end for 
  System.out.println("Display the scores of 10 students"); 
  for(int i = 0; i < scores.length; i++) { 
  System.out.println(scores[i]); 
  }//end for 
  for(int i = 0; i < scores.length; i++) { 
   sum = sum + scores[i]; 
   avg = sum / scores.length; 
  }//end for 
  System.out.println("The average score of the class: " + avg); 
 }//end method main 
}//end class StudentScores 
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Add the file ComputeAvg.j ava to the project you created for 
exercise 2
• Examine ComputeA vg.java
• Modify the program to implement …
-  I n a certain class, there are five tests, each worth 100 points
-  I nput five test scores from the console
-  S tore the test scores in an array
-  C alculate the student’s average scores
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What is an ArrayIndexOutOfBoundsException?
• As you already know, an array has a fixed size
• The index must be in a range interval [ 0, n-1], where n is the size 
of the array
• If an index is either negative or greater than or equal to the size 
o
f the array, then the array index is out of bounds
• If an array index is out of bounds, the JVM throws an 
Arr
ayIndexOutOfBoundsException
• This is called automatic bounds checking
39
```

</details>


## PDF page 40

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Happens When This Exception Occurs?
• The ArrayInd exOutOfBoundsException is thrown only at 
run time
• The Java compiler doesn’t check for this exception when a 
pr
ogram is being compiled
• The program is terminated if this exception isn’t handled
40
```

</details>


## PDF page 41

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do You Identify the
ArrayIndexOutOfBoundsException?
public static void main(String[] args) { 
 int primes[] = {2, 3, 5, 7, 11, 13, 17}; 
 System.out.println("Array length: " + primes.length); 
 primes[10] = 20; // 
 System.out.println("The first few prime numbers are:"); 
 for (int i : primes) { 
  System.out.println(i); 
 } //end for 
}//end method main 
The index of the array 
is 0-6, and it’s trying 
to access an element 
at index 10
• Output:
Array length: 7
Exception in thread "main" 
java.lang.ArrayIndexOutOfBoundsException: 10
at arraysdemo.ArraysDemo.main(ArraysDemo.java:21)
Java Result: 1
41
```

</details>


## PDF page 42

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4
• Add the file ArrayEx2.jav a to the project you created for 
exercise 2
• Examine ArrayEx2.java
• Perform the following:
- Run the program and observe the error
- Modify the program to resolve the error
- Using a for-e ach loop, display all browsers that are stored in the 
array
42
```

</details>


## PDF page 43

<details>
<summary>Page text</summary>

```text
JFo 8-1
One-Dimensional Arrays
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Create and initialize one-di mensional arrays
- Modify an array element
- Traverse a one-di mensional array by using a for loop
- Identify the cause of an ArrayIndexOutOfBoundsExcept ion 
43
```

</details>


## PDF page 44

<details>
<summary>Page text</summary>

```text

```

</details>
