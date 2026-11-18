# 4-5 The Random Class

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 4-5 The Random Class.pdf

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
4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives: 
- Describe the purpose and uses of random numbers in Java 
pr
ogramming
- Identify methods of the Random class that obtain random 
n
umbers
- Obtain random numbers in a range of numbers
- Understand the purpose of the 
r
andom number seed
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Purpose of Random Number Generation in Java
• A software application often needs to perform a task based on 
s
ome randomly obtained value
• Several applications need generation of random numbers
• Let’s look at some applications that use random number 
ge
neration
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Applications Based on Random Number Generation
• A card game application needs to shuffle a deck of 
c
ards randomly and then randomly distribute the 
cards to the players
• A lottery application requires a randomly generated 
nu
mber that’s based on an algorithm
- The person wins if his number matches the randomly 
g
enerated number
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Generating Random Numbers in Java
• So far in the previous lessons, you saw that Java comes with a 
v
ariety of classes that support almost all basic application 
development features
• For example:
- String provides the capability for manipulating strings
- Scanner provides capability for obtaining input from the console
• Another important class in Java is the Random class that’s used 
t
o obtain random numbers
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is the Random Class in Java?
• In Java, you use the Random class to obtain random numbers
• The class is located in the java.util pa ckage
• It contains several methods that return randomly obtained 
i
nteger, double, boolean, float, and long type values
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do You Use the Random Class in a Java 
Program
• Import the Random class from the ja va.util package
• Create an instance of the Random class, like this:
import java.util.Random; 
public class RandomIntNums { 
 public static void main(String[] args) { 
  Random rndNumber = new Random(); 
 }//end method main 
}//end class RandomIntNums 
import statement to import 
the Random class from the 
java.util package
Creates an instance of Random class, 
rndNumber
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Methods Provided by the Random Class
• You can obtain random values by invoking the following methods 
pr
ovided in the Random class:
Method Produces
boolean nextBoolean(); A true or false value
int nextInt()
An integral value 
between Integer.MIN_VALUEand 
Integer.MAX_VALUE
long nextLong() A long integral value between Long.MIN_VALUE and Long.MAX_VALUE
float nextFloat() A decimal number between 0.0 (included) and 1.0 (excluded)
double nextDouble() A decimal number between 0.0 (included) and 1.0 (excluded)
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do Y ou Obtain a Random Number?
• You can obtain a random number of integer type by using the 
ne
xtInt method
• For example:
import java.util.Random; 
public class RandomNum { 
 public static  void main(String[] args) { 
  Random rndNum  = new Random(); 
  int  randomNum = rndNum.nextInt(); 
  System.out. println("Random Number: " + randomNum); 
 }//end method main 
}//end class RandomNum 
• Output: Random Number: 1660093261
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How Do You Obtain a Series of Random Numbers?
• You can obtain a series of random numbers by calling the nextInt 
met
hod several times
• For example:
public class RandomNumSeries { 
 public static void main(String[] args) { 
  Random num = new Random(); 
  System.out.println("Random Number 1: " + num.nextInt()); 
  System.out.println("Random Number 2: " + num.nextInt()); 
  System.out.println("Random Number 3: " + num.nextInt()); 
  System.out.println("Random Number 4: " + num.nextInt()); 
  System.out.println("Random Number 5: " + num.nextInt()); 
 } //end method main 
}//end class RandomNumSeries 
nextInt() is called 5 times and so 
5 random numbers are generated
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Generating Random Numbers of Double Type
• You can obtain random numbers of double type by using the 
nextDouble
() method, like this: 
public class RandomDouble { 
 public static  void main(String[] args) { 
  Random num = new Random(); 
  double randomDouble =  num.nextDouble(); 
  System.out. println("Random Number: " + randomDouble); 
 }//end method main 
}//end class RandomDouble 
• In this example, the nextDouble() met hod returns numbers of 
the type double in the range of 0.0 to 1.0 
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new project and add the FlipCoin.java fi le
• Examine FlipCoin .java:
- Execute the following program and observe the random number 
t
hat chance generated
- If chance < 0.5, record the result as "heads"; else record the result 
as
 "tails"
- Repeat this many times
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Generating Random Numbers in a Range of 
Numbers, 1 of 2
• So far, you have generated a random number within the range of 
an i
nteger data type
• Sometimes, you may want to restrict the range of numbers that 
c
an be generated
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Generating Random Numbers in a Range of 
Numbers, 2 of 2
• To implement this, you can use another version of 
t
he nextInt method:
-nextInt(int ma xValue);
• The argument determines the highest integer that can be obtained 
b
y the nextInt() method
• You can obtain random positive numbers from 0 (included) to a 
ma
ximum (excluded) of your choice
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Generating Random Numbers in a Range of 
Numbers: Example
• Here’s an example that obtains random numbers in the range of 
0 to
 19:
public class RandomNumRange { 
 public static  void main(String[] args) { 
  Random num = new Random(); 
  int  randomnum = num.nextInt(20); 
  System.out. println("Random Number: " + randomnum); 
 }//end method main 
}//end class RandomNumRange 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Generating a Range Starting from 1
• To specify a range that starts with 1, add 1 to the result of the 
nextInt
() method
• For example, to pick a number between 1 and 40 inclusively, add 
1 t
o the result:
Random rand = new Random(); 
int randomnum = rand.nextInt(40) + 1; 
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Generating a Range Starting from a Higher Number 
Than 1
• If the range starts from a higher number than 1:
- Subtract the starting number from the upper-li mit number and 
then add 1
- Add the starting number to the result of the ne xtInt() method
• For example, to pick a number from 5 to 35, inclusively:
-  T he upper limit number will be 35 -5+1=31 and 5 needs to be 
added to the result:
Random rand = new Random(); 
int randomnum = rand.nextInt(31) + 5; 
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Program for Lottery Application
public class Lottery { 
 public static  void main(String[] args) { 
  Scanner numberScanner = new Scanner(System.in); 
  System.out. print("Enter a number between 1 and 10: "); 
  int  userNum = numberScanner.nextInt(); 
  Random rnd = new Random(); 
  int  winningNum = rnd.nextInt(10) + 1; 
  System.out. println("Your Number: " + userNumber); 
  System.out. println("The winning number is: " + winningNum); 
 }//end method main
 
}//end class RandomNumRange 
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 1 of 2
• Create a new project and add the RockPaperScissor.java 
f
ile to the project
• Examine RockPape rScissor.java
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 2 of 2
• Perform the following:
- Simulate the R ockPaperScissor game by generating a random 
integer number in the range of 0 to 3
- Compare the generated number with the following numbers:
- if number=0 : "rock"
- if number=1: "paper"
- if number=2: "scissors"
- Record the result and repeat many times
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Is the Same Random Number Generated Every 
Time?
• When you executed the previous examples multiple times, notice 
t
hat the random number sequence is different each time
• Sometimes you may need to generate the same random number 
s
equence every time
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is a Seed of a Random Number?
• You can achieve this by using a constant value called a seed
• When you create an instance of the Random class, pass a 
cons
tant integer to specify the seed
Random rndNumbers = new Random(20L); 
• You can change the seed by calling the setSeed() met hod
• Each time you pass the same seed, the same random sequence 
is r
eturned
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Obtaining a Random Sequence by Using a Seed: 
Example
public static void main(String[] args) { 
 Random rand = new Random(20L); 
 System.out.println("Random Number 1: " + rand.nextInt(100)); 
System.out.println("Random Number 2: " + rand.nextInt(100)); 
System.out.println("Random Number 3: " + rand.nextInt(100)); 
 System.out.println("Changing seed to change to sequence"); 
 rand.setSeed(5L); 
 System.out.println("Random Number 4: " + rand.nextInt(100)); 
System.out.println("Random Number 5: " + rand.nextInt(100)); 
System.out.println("Random Number 6: " + rand.nextInt(100)); 
 System.out.println("Setting seed 20 produce previous sequence"); 
rand.setSeed(20L); 
 System.out.println("Random Number 7: " + rand.nextInt(100)); 
System.out.println("Random Number 8: " + rand.nextInt(100)); 
System.out.println("Random Number 9: " + rand.nextInt(100)); 
}//end method main 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Alternative to Random Class: Math.random()
• The java.lang. Math.random() method returns a 
pseudorandom (double type) number greater than or equal to 
0.0 and less than 1.0
• When this method is called, it creates a new pseudorandom-
num
ber generator, the same as if using the Random class
• Enter the code from the slide note below
• Run the code several times to see how the results differ
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 4-4
The Random Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Describe the purpose and uses of random numbers in Java 
pr
ogramming
- Identify methods of the Random class that obtain random 
n
umbers
- Obtain random numbers in a range of numbers
- Understand the purpose of the random number seed
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text

```

</details>
