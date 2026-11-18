# 4-4 The String Class

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 4-4 The String Class.pdf

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
4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives: 
- Locate the String c lass in the Java API documentation
- Understand the methods of the String class
- Compare two String objects lexicographically
- Find the location of a substring in a String object
- Extract a substring from a String object
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What’s a String?
• A string is a sequence of characters including alphabet letters, 
s
pecial characters, and white space
• For example:
- “How are you?” is a string that contains letters, white space, and a 
s
pecial character (‘?’)
• In Java, strings are not a primitive data type
• Instead, they are objects of the String c lass
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Representing Strings in Java, 1 of 2
• In Java, strings are objects of the class named 
jav
a.lang.String
• Example: 
- String s1= “Hello, World”;
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Representing Strings in Java, 2 of 2
• A string in Java is more abstract
• That is, you aren’t supposed to know about its internal structure, 
w
hich makes it easy to use
• Its methods allow a programmer to perform operations on it
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the String Class
• The String  class:
- Is one of the many classes included in the Java class libraries. 
- Is part of java.lang.package
- Provides you with the ability to hold a sequence of characters of 
d
ata
• You will use the String  class frequently throughout your 
programs
• Therefore, it’s important to understand some of the special 
c
haracteristics of strings in Java
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Documentation of the String Class
• You can access the documentation of the Java String c lass 
from here:
- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/
module-summary.html
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Java Platform SE 17 Documentation for the String 
Class
Scroll down 
and select 
packages 
here
Search for a package here. Type String in the search box 
and from the Types displayed, select java.lang.String
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Class Documentation: Method Summary
•public int charAt(int index)
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Class Documentation: Method Detail
Click here to get the detailed 
description of the method
Detailed description of the 
indexOf() method
Further details about 
parameters and return 
value are shown in the 
method list
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Methods: length
• You can compute the length of a string by using the length 
me
thod defined in the String class:
- Method: name.length ()
- Returns the length, or the number of characters, in name as an 
i
nteger value
• Example:
String name = "Mike.W"; 
System.out.println(name.length()); //6 
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing Each Character in a String
• You can access each character in a string by its numerical index
• The first character of the string is at index 0, the next is at index 
1
, and so on
• For example:
-String str = "Hello, World";
- str has 0 to 11 indexes; that is, between 0 to str.length()-1
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Methods: indexOf(), 1 of 2
• Each character of a string has an index
• You can retrieve the index value of a character in the string by 
us
ing the indexOf method:
Method Description
str.indexOf(char c) Returns the index value of the 
first occurrence of c in String 
str
s1.indexOf(char c, int beginIdx) Returns the index value of the 
first occurrence of c in String 
s1, starting from beginIdx to 
the end of the string
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Methods: indexOf(), 2 of 2
public static void main(String args[]){ 
 String phoneNum  = "404-543-2345"; 
 int  idx1 = phoneNum.indexOf('-'); 
 System.out. println("index of first dash: "+ idx1); //3 
 int  idx2 = phoneNum.indexOf('-', indx1+1); 
 System.out. println("second dash idx: "+ idx2); // 7 
}//end method main 
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Methods: charAt
• Returns the character of the string located at the index passed as 
t
he parameter
• Method: str.charA t(int index)
String str = "Susan"; 
System.out.println(str.charAt(0)); //S  
System.out.println(str.charAt(3)); //a 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Methods: substring(), 1 of 2
• You can extract a substring from a given string
• Java provides two methods for this operation:
Method Description
str.substring(int beginIdx) Returns the substring from beginIdx 
to the end of the string
str.substring(int beginIdx, 
int endIdx)
Returns the substring from beginIdx 
up to, but not including, endIdx
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Methods: substring(), 2 of 2
public static void main(String args[]){ 
 String greeting = "Hello, World!"; 
 String sub = greeting.substring(0, 5); // "Hello" 
 String w =  greeting.substring(7, 11); // "Worl" 
 String tail = greeting.substring(7); // "World!" 
}//end method main 
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Methods: replace()
• This method replaces all occurrences of matching characters in a 
s
tring
• Method: replace(c har oldChar,char newChar)
• Example:
public static void main(String args[]) { 
 String str = "Using String replace to replace character"; 
 String newString = str.replace("r", "R"); 
 System.out. println(newString); 
}//end method main 
- Output: Using String Replace to Replace C haRacteR
- All occurrences of a lowercase “r” are replaced with a capital "R"
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Methods: replaceFirst(), 1 of 2
• This method replaces only the first occurrence of a matching 
c
haracter pattern in a string
• Method: replaceFi rst(String pattern, String 
replacement)
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
String Methods: replaceFirst(), 2 of 2
• Example:
public static void main(String args[]) { 
 String replace =  "String replace with replaceFirst"; 
 String newString = replace.replaceFirst("re", "RE"); 
System.out.println(newString); 
}//end method main 
• Output: 
- String RE place with replaceFirst
• Only the first occurrence of "re" is replaced with "RE" 
• The second occurrence isn’t changed
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Create a new project and add the ShoppingCart.ja va and 
NameMaker.java files to the project
• Examine ShoppingCar t.java
• Perform the following:
- Use the indexOf me thod to get the index for the space character (" ") 
within custName
- Assign it to spa ceIdx
- Use the substring method and spa ceIdx to get the first name portion 
of custName
- Assign it to fi rstName and print firstName
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• You might notice that this project has two 
.j
ava files with main methods
- This could seem like a contradiction because 
we s
aid never to write more than one main 
method!
• Sometimes programmers do this when they're testing small bits 
of
 code and they want to keep all their files neatly in one project
- Unfortunately, pressing run in your IDE always runs the same file 
and
 never the others
- You'll have to right-cli ck the alternate file you want to run, a menu 
will appear with an option to run that file
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Declaring and Creating a String
• You can instantiate strings in two ways:
• String literals: 
- Directly assign a string li teral to a string reference
String hisName = "Fred Smith"; 
• new operator: 
- Similar to any other class
- Not commonly used and not recommended
String herName = new String("Anne Smith"); 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Strings Are Immutable, 1 of 2
• A String  object is immutable; that is, after a String object is 
created, its value can’t be changed
• Because strings are immutable, Java can process them very 
effi
ciently
- Consider the following:
String str1 = "Hello"; 
String str2 = "Hello"; 
- We expect this …
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Strings Are Immutable, 2 of 2
• But this is what happens …
• The Java runtime system knows that the two strings are identical 
a
nd allocates the same memory location for the two objects
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Concatenating Strings
• In Java, string concatenation forms a new string that’s t he 
combination of multiple strings 
• You can concatenate strings in Java two ways :
-+ s tring concatenation operator
-concat() me thod
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the + Operator (Before Concatenation)
public static void main(String args[]) { 
 String s1 = "Susan"; 
 String s2 = "Roberts"; 
}//end method main 
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the + Operator (After Concatenation)
public static void main(String args[]) { 
 String s1 = "Susan"; 
 String s2 = "Roberts"; 
 S1 = s1 + s2; 
 System.out. println(s1); 
}//end method main 
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Concatenating Non-String Data with String 
• If one of the operands is a string, Java automatically converts 
non-
string data types to strings prior to concatenation
• Example:
public static void main(String args[]) { 
 String newString = "Learning Java" + 17; 
 System.out. println(newString); //Learning Java 17 
 System.out. println("Total : " + 17 + 17); //Total: 1717 
System.out.println("Total : " + (17 + 17)); //Total: 34 
 String numString1 = "17" + 17; 
 System.out. println(numString1); //1717 
}//end method main 
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the concat() Method (Before Concatenation)
String myString = "Hello"; 
myString = myString.concat(" World"); 
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
Using the concat() Method (After 
Concatenation)
myS
tring = myString.concat(" World"); 
String myString = "Hello"; 
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
myS
tring = myString + "!" 
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 1 of 2
• Open the project you created in Exercise 1
• Examine NameMake r.java
• Perform the following:
- Declare String variables: firstName, middleName, lastName, and 
f
ullName
- Prompt users to enter their first, middle, and last names and read 
t
he names from the keyboard
-  S et and display the fullName as firstName+a blank 
char+middleName+a blank char+lastName
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 2 of 2
• Which do you think is preferable for this scenario? 
• That is, the string concatenation operator or the concat() 
me
thod?
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What’s the Preferred Way to Concatenate Strings?
• As you observed in the previous exercise:
• + operator:
- Can work between a string and a string, char, int, double or float 
da
ta type value
- Converts the value to its string representation before 
co
ncatenation
•concat() me thod:
- Can be called only on strings
- Checks for data type compatibility, and a compile time error is 
pr
oduced if they don't match
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Y ou Compare String Objects?
• You can compare two String objects by using the compareTo() 
me
thod
• This method compares based on the lex icographical order of strings
• Lexicographic comparisons are similar to the ordering found in a 
dic
tionary
• The strings are compared character by character until their order is 
det
ermined or until they prove to be identical
• Syntax: s1.compareTo(s2)
• Returns an integer value that indicates the ordering of the two strings
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Value Returned by compareTo()
• The integer v alue returned by the compareTo() method can be 
interpreted as follows:
- Returns < 0 when then the string calling the method is 
l
exicographically first
- Returns == 0 when the two strings are lexicographically equivalent
- Returns > 0 when the parameter passed to the method is 
l
exicographically first
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the compareTo() Method
• Let’s look at some examples:
-"computer".compareTo("comparison")
• Returns an integer > 0 because the "comparison" parameter is  
l
exicographically first
-"cab".compareTo("car") 
• Returns an integer < 0 because the “cab” string calling the method is 
l
exicographically first
-"car".compareTo("car")
• Returns an integer equal to 0 because both are lexicographically 
e
quivalent
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the compareTo() method: Example
• Let’s write a program to compare names by using the 
compareTo(
) method:
public static void main(String[] args) { 
 String s1 = "Susan"; 
 String s2 = "Susan"; 
 String s3 = "Robert"; 
 //Returns 0 because s1 is identical to s2 
System.out.println(s1.compareTo(s2)); //Output is 0 
 //Returns >0 because ‘S’ follows‘R’ 
 System.out.println(s1.compareTo(s3)); // Output is 1 
 
 //Returns <0 because ‘R’ precedes ‘S’ 
System.out.println(s3.compareTo(s1)); // Output is -1 
}//end method main 
39
```

</details>


## PDF page 40

<details>
<summary>Page text</summary>

```text
JFo 4-3
The String Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Locate the String c lass in the Java API documentation
- Understand the methods of the String  class
- Compare two String objects lexicographically
- Find the location of a substring in a String object
- Extract a substring from a String object
40
```

</details>


## PDF page 41

<details>
<summary>Page text</summary>

```text

```

</details>
