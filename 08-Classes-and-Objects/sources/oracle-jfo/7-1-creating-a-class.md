# 7-1 Creating a Class

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 7-1 Creating a Class.pdf

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
7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Create a Java test/main class
- Create a Java class in your IDE
- Use conditionals in methods
- Translate specifications or a description into fields and behaviors
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Object-Oriented Concepts 
• We’ve been experimenting with conditional statements and 
l
oops for a while
• Now would be a good time to review object- oriented 
programming concepts and its benefits
• The rest of this section describes object-oriented programming 
i
n greater detail
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Play Basic Puzzles 6 and 7
- https://objectstorage.uk-london-
1.oraclecloud.com/n/lrvrlgaqj8dd/b/Games/o/JavaPuzzleBall/in
dex.html
- Your Goal: Design a solution that deflects the ball to Duke
• Consider the following:
- What happens when you put an icon on the blue wheel?
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Java Puzzle Ball Debrief
• What happens when you put icons within a blue wheel?
- A wall appears on every instance of a blue bumper object
- Walls give bumpers behaviors that deflect and interact with the ball
- All blue bumper instances share these same behaviors
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Describing a Blue Bumper
• Properties:
- Color
- Shape
- x-pos ition
- x-pos ition
(Fields)
• Behaviors:
- Make ping sound
- Flash
- Deflect ball
- Get destroyed
(Methods)
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Conditional Logic and Loops in Classes
• Conditionals and loops can play an important role in the 
me
thods you write for a class
• The main method was a convenient place to experiment and 
le
arn conditional logic and loops
• But remember …
- The main method is meant to be a driver class
- Your entire program shouldn’t be written in the main method
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What If the Ball Collides with a Bumper?
• A method with the following logic is called:
public void onCollisionWithBall(Ball ball){ 
 if( ball.isBlade == true){  //Ball is blade 
  getDestroyed();  
 } 
 else{      //Ball is not blade 
  deflectBall (); 
 }//endif 
}//end method main 
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Modeling a Savings Account
• You could model one savings account like this:
public class SavingsAccount{ 
 public static void main(String args[]){ 
  int balance = 1000; 
  String name = "Damien"; 
 }//end method main 
}//end class SavingsAccount 
• And two accounts like this:
int balance1 = 1000; 
String name1 = "Damien"; 
int balance2 = 2000; 
String name2 = "Bill"; //Copy, Paste, Rename 
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Modeling Many Accounts
• How would you model 1000 accounts?
…
 //You think …
 //Do I really have to copy and paste 1000 times?
• How would you add a parameter for each account?
…
 //You think …
 //There has to be a better way!
• There is a better way: 
- Use a class
- And not the main method
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How to Structure a Class, 1 of 2
• Code should fit this format:
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How to Structure a Class, 2 of 2
• Code should fit this format:
1 public class SavingsAccount { 
2 public double balance; 
3 public double interestRate = 0.01; 
4 public String name; 
5 
6 public void displayCustomer(){ 
7  System.out. println("Customer: "+ name); 
8 }//end method displayCustomer 
9 }//end class SavingsAccount 
• With one simple line of code(line 3), all 1000 accounts have an 
i
nterest rate
- And we can change the rate at any time for any account
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Main Method as a Driver Class
• Place the main method in a test class
- The main method is often used for instantiation
public class AccountTest { 
 public static  void main(String[] args){ 
  SavingsAccount sa0001 = new SavingsAccount(); 
  sa0001.balance =  1000; 
  sa0001.name = "Damien"; 
  sa0001.interestRate =  0.02; 
  SavingsAccount sa0002 = new SavingsAccount(); 
  sa0002.balance =  2000; 
  sa0002.name = "Bill"; 
 }//end method main 
}//end class AccountTest 
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Create a new Java project
• Create an AccountTest class with a main method
• Create a CheckingAc count class
- Include fields for balance and name
• Instantiate a Checking Account object from the main method
- Assign values for this object’s balance and name fields
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Variable Scope, 1 of 2
• Fields are accessible anywhere in a class
- This includes within methods
public class SavingsAccount { 
 public double  balance; 
 public double  interestRate; 
 public String name;  
 public void displayCustomer (){ 
  System.out. println("Customer: " + name); 
  System.out. println("Balance: " + balance); 
  System.out. println("Rate: " + interestRate); 
 }//end method displayCustomer 
}//end class SavingsAccount 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Variable Scope, 2 of 2
• Variables created within a method cannot be accessed outside 
t
hat method
- This includes methods parameters
public class SavingsAccount { 
 public double balance; 
 public double interestRate; 
 public String name; 
 public void deposit(int x){ 
  balance += x; 
 } //end method deposit 
 
public void badMethod(){ 
  System.out.println(x); 
 } //end method badMethod 
}//end class SavingsAccount
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Accessing Fields and Methods from Another Class
1. Create an instance
2. Use the dot operator (.)
public class AccountTest { 
 public static void main(String[] args){ 
  SavingsAccount sa0001 = new SavingsAccount(); 
  sa0001.name = "Damien"; 
  sa0001.deposit(1000); 
}//end class AccountTest
public class SavingsAccount { 
 public String name; 
 public double balance; 
 public void deposit(int x){ 
  balance += x; 
 }//end method deposit 
}//end class SavingsAccount 
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Passing Values to Methods
• 1000 is passed to the deposit() method
• The value of x becomes 1000
public class AccountTest { 
 public static void main(String[] args){ 
  SavingsAccount sa0001 = new SavingsAccount(); 
  sa0001.name = "Damien"; 
  sa0001.deposit(1000); 
}//end class AccountTest
public class SavingsAccount { 
 public String name; 
 public double balance; 
 public void deposit(int x){ 
  balance += x; 
 }//end method deposit 
}//end class SavingsAccount 
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Continue editing the AccountTes t project
• Write a withdraw() method for checking accounts that:
- Accepts a double argument for the amount to be withdrawn
- Prints a warning if the balance is too low to make the withdrawal
- Prints a warning if the withdrawal argument is negative
- If there are no warnings, the withdrawal amount is subtracted from 
t
he balance. Print the new balance
• Test this method with the instance from Exercise 2
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What if I Need a Value from a Method?
• Variables are restricted by their scope
• But it’s still possible to get the value of these variables out of a 
me
thod
public class SavingsAccount { 
 public double  balance; 
 public double  interestRate; 
 public String name;
 
 public void calcInterest(){ 
  double interest = balance*interestRate/12; 
 }//end method calcInterest
 
}//end class SavingsAccount 
Scope of 
interest
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Returning Values from Methods
• If you want to get a value from a method … 
- Write a return statement
- Change the method type from void to the type that you want 
r
eturned
public class SavingsAccount { 
public double balance; 
public double interestRate; 
public String name; 
//This method has a double return type 
public double calcInterest(){ 
double interest = balance * interestRate / 12; 
return interest; 
}//end method calcInterest 
}//end class SavingsAccount
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Returning Values: Example, 1 of 2
• When getIntere st() returns a value …
public class AccountTest { 
 public static  void main(String[] args){ 
  SavingsAccount sa0001 = new SavingsAccount(); 
  sa0001.balance =  1000; 
  sa0001.balance +=  sa0001.calcInterest(); 
}//end class AccountTest
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Returning Values: Example, 2 of 2
• It’s the equivalent of writing …
public class AccountTest { 
public static void main(String[] args){ 
SavingsAccount 
sa0001 = new SavingsAccount(); 
sa0001.balance = 1000; 
sa0001.balance += 0.83; 
}//end class AccountTest
- But it’s better and more flexible because the value is calculated 
i
nstead of hard-coded
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary About Methods
public double calculate(int x, double y){ 
 double quotient = x/y; 
 return quotient ; 
}//end method calculate
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Limiting the Main Method, 1 of 2
• The main method should be as small as possible
• The example below isn’t very good because …
- Increasing an account’s balance based on interest is a typical 
be
havior of accounts
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Limiting the Main Method, 2 of 2
- The code for this behavior should instead be written as a method 
w
ithin the SavingsAccount class
- It’s also dangerous to have an account program where the balance 
f
ield can be freely manipulated
public class AccountTest { 
 public static  void main(String[] args){ 
  SavingsAccount sa0001 = new SavingsAccount(); 
  sa0001.balance =  1000; 
  sa0001.balance +=  sa0001.calcInterest(); 
}//end method main
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Rest of This Section
• We’ll learn how to avoid these problematic scenarios when 
de
veloping a class
• But for this lesson, just focus on understanding how to:
- Interpret a description or specification
- Break it into properties and behaviors
- Translate those properties and behaviors into fields and methods
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, 1 of 2
• Continue editing the AccountTes t project
• Create a new class according to the description
• Be sure to instantiate this class and test its methods
- Create a Savings Bond
- A person may purchase a bond for any term between 1 and 60 
mon
ths
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, 2 of 2
- A bond earns interest every month until its term matures (0 
m
onths remaining)
- The term and interest rate are set at the same time
- The bond's interest rate is based on its term according to the 
f
ollowing tier system: 0–11 months : 0.5%
12–23 months : 1.0%
24–35 months : 1.5%
36–47 months : 2.0%
48–60 months : 2.5%
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Describing a Savings Bond
• Properties:
- Name
- Balance
- Term
- Months Remaining
- Interest Rate
• Behaviors:
- Set Interest Rate Based on 
Te
rm
- Earn Interest
- Mature (0 months remaining)
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Translating to Java Code: Part 1
• Your Bond c lass may have represented fields like this:
public class Bond{ 
   public String name; 
   public double balance, rate; 
   public int term, monthsRemaining;
 Code continued on next slide…
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Translating to Java Code: Part 2
• And include the following methods:
public void setTermAndRate(int t){ 
 if(t>=0 && t<12) 
  rate = 0.005; 
 else if(t>=12 && t<24) 
  rate = 0.010; 
 else if(t>=24 && t<36) 
  rate = 0.015; 
 else if(t>=36 && t<48) 
  rate = 0.020; 
 else if(t>=48 && t<=60) 
  rate = 0.025; 
 else{ 
  System.out.println("Invalid Term"); 
  t = 0; 
 } 
 term = t; 
 monthsRemaining = t; 
}//end method setTermAndRate Code continued on next slide…
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Translating to Java Code: Part 3
public void earnInterest(){ 
 if( monthsRemaining > 0){ 
  balance += balance * rate / 12; 
  monthsRemaining-- ; 
  System.out. println("Balance: $" + balance); 
  System.out. println("Rate: " + rate); 
  System.out. println("Months Remaining: " + monthsRemaining); 
 } 
 else{  
  System.out. println("Bond Matured"); 
 }//endif 
}//end method earnInterest 
}//end class Bond
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 7-1
Creating a Class
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Create a Java test/main class
- Create a Java class in your IDE
- Use conditionals in methods
- Translate specifications or a description into fields and behaviors
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text

```

</details>
