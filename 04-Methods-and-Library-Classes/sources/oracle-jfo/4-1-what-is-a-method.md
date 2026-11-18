# 4-1 What is a Method

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 4-1 What is a Method.pdf

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
4-1
What Is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Structure code within a class
- Instantiate an object
- Understand the benefits of methods
- Use the dot operator (.)  to access an object’s fields and methods
- Supply arguments to a method
- Return values from a method
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Classes Y ou’ll Encounter, 1 of 2
• In Java development, you’ll encounter many classes for many 
di
fferent object types, including …
- Classes you’ll write yourself
- Classes written by someone else
- Classes belonging to Java
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Classes Y ou’ll Encounter, 2 of 2
• These classes outline objects’ …
- Properties (fields)
- Behaviors (methods)
• The goal of this lesson is to give you an understanding of how to 
w
ork with any class, its fields, and its methods
• The remaining lessons of this section explore important classes 
pr
ovided by Java
• We’ll start by exploring classes and methods a little deeper
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 1
• Let’s look at a scenario and see how we can model the 
compone
nts involved:
- It’s Alex’s birthday! You’ve arranged a group of eight friends to 
ce
lebrate at a local restaurant. When your party receives their bill, 
nobody is quite sure what they owe. You only know everyone’s 
total before tax (5%) and tip (15%). But lucky you!  You brought 
your laptop and are asked to write a program that calculates 
everybody’s total
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 2
• Create a new project and add the Tip01.java fi le to the project
• This is what everyone owes before tax (5%) and tip (15%):
Person 1: $10 
Person 2: $12 
Person 3: $9 
Person 4: $8 
Person 5: $7 
Person 6: $15 (Alex)
Person 7: $11 
Person 8: $30
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, Part 3
• Your program should produce the following output:
person1: $12.0
person2: $14.4
person3: $10.8
person4: $9.6
person5: $8.4
person6: $18.0
person7: $13.2
person8: $36.0
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Modeling Objects
• You may have been tempted to model each person’s total by 
w
riting this:
public class Tip01{
    public static void main(String args[]){
        double person1 = 10;
        double total1  = person1*(1 +.05 +.15);
        System.out.println(total1);
    }//end method main
} //end class Tip01
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Modeling More Objects
• When you needed to model two dinner guests, you may have 
b
een tempted to copy, paste, and rename:
public class Tip01{
    public static void main(String args[]){
        
        double person1 = 10;
        double total1  = person1*(1 +.05 +.15);
        System.out.println(total1);
        double person2 = 12;
        double total2  = person2*(1 +.05 +.15);
        System.out.println(total2);
    }//end method main
}//end class Tip01
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Modeling Many Objects
• What if you needed to figure 1,000 guests?
//You might think …   
//Do I really have to copy, paste, and rename 1,000
//times?
• What if one of your friends forgets their wallet? What if you made 
a 
mistake with your formula?
//You might think …
//Do I need to make 1,000 edits?!
//There has to be a better way!!!
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Variables Offer Flexibility
• If the tax rate or tip percentage needs to change …
- We don’t need to make 1,000 edits
- We simply edit each variable once
double tax = 0.05;
double tip = 0.15;
double person1 = 10;
double total1  = person1*(1 +tax +tip);
System.out.println(total1);
double person2 = 12;
double total2  = person2*(1 +tax +tip);
System.out.println(total2);
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Methods Offer Similar Flexibility
• The same math and printing behaviors are repeated
• Instead, this logic can be written once in a method
double tax = 0.05;
double tip = 0.15;
double person1 = 10;
double total1  = person1*(1 +tax +tip);
System.out.println(total1);
double person2 = 12;
double total2  = person2*(1 +tax +tip);
System.out.println(total2);
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
When to Use Methods
• It’s a good idea to write a method if you …
• Find yourself repeating very similar lines of code, including 
c
alculations
• Need to describe an object’s behavior
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
How to Use a main Method
• The main  method is known as a driver
- Use it to drive the events of a program
- Use it to access fields and methods or other classes
• The main  method doesn’t describe the behavior of any particular 
object
- Keep it separate from your object classes
- Use only one main method for each application
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Do Object Classes Look Like?
• We will change the code to fit the following format
• Let’s see how we can get our code to look like this:
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Step 1
Move Fields from the main Method
public class Calculator{
    //Fields
    public double tax = 0.05;
    public double tip = 0.15;
    public double originalPrice = 10;
        public static void main(String args[]){
           //double tax = 0.05;
           //double tip = 0.15;
           //double person1 = 10;
           double total1 = person1*(1 + tax + tip);
           System.out.println(total1);
        }//end method main
 }//end class Calculator
Local variables 
become fields
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Step 2
Move Repeated Behaviors from the main Method
public class Calculator{
    //Fields
    public double tax = 0.05;
    public double tip = 0.15;
    public double originalPrice = 10;
    //Methods
    public void findTotal(){
          //Calculate total after tax and tip
         //Print this value
    }//end method findTotal
    public static void main(String args[]){
         //double total1 = person1*(1 + tax + tip);
         //System.out.println(total1);
    } //end method main
 } //end class Calculator
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Step 3
Remove the main Method
public class Calculator{
    //Fields
    public double tax = 0.05;
    public double tip = 0.15;
    public double originalPrice = 10;
    //Methods
    public void findTotal(){
    //Calculate total after tax and tip
    //Print this value
    }//end method findTotal
    //public static void main(String args[]){
         //double total1 = person1*(1 + tax + tip);
         //System.out.println(total1);
    //}//end method main
 } //end class Calculator
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Success!
public class Calculator{
        //Fields
    public double tax = 0.05;
        public double tip = 0.15;
    public double originalPrice = 10;
      
    //Methods
        public void findTotal(){
              //Calculate total after tax and tip
      //Print this value
                  }//end method findTotal
} //end class Calculator
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Where Do I Put the main Method?
public class CalculatorTest {
        public static void main(String args[]){
           //Create Calculator object instance
           Calculator calc = new Calculator();
           calc.tip = 0.10; //Altering a field
           calc.findTotal();    //Calling a method  
        }//end method main
}//end class CalculatorTest
• Put the main m ethod in another class, such as a test class
• The main  method drives the action of the program:
- It creates instances of objects
- It calls an instance’s fields and methods by using the dot operator (.)
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Variables for Objects
int  age  = 22;
String str  = "Happy Birthday!";
Scanner sc   = new Scanner();
Calculator calc = new Calculator();
• Objects, like primitives, are represented by variables
• Most objects require the new keyword when they’re initialized to 
c
reate new instances
- This is called instantiating an object
- There are some exceptions, like String  objects, that don’t require 
the new keyword
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the Dot Operator, 1 of 2
• Place the dot operator (.) after a variable’s name to access its 
fields or methods
public class CalculatorTest {
    public static void main(String args[]){
       Calculator calc = new Calculator();
       calc.printTip();     //prints 0.15
       calc.tip = 0.10;  
       calc.printTip();     //prints 0.10
    }//end method main
}//end class CalculatorTest
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using the Dot Operator, 2 of 2
• Place the dot operator (.) after a variable’s name to access its 
fields or methods
public class Calculator{
    public double tip = 0.15;   //initialized value 0.15
    public void printTip(){
       System.out.println(tip);
    }//end method printTip
}//end class Calculator 
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 1
• Create a new project and add the CalculatorTest2.java an d 
Calculator2.java files to the project
• Complete the findTota l() method, which should:
- Calculate a total based on the tax , tip, and originalPrice 
fields
- Print a person’s total
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, Part 2
• From the main  method:
- Instantiate a Calculator  object named calc
- Observe your IDE after typing "calc "
- Access this object’s fields and methods to print the total for each 
p
erson at the birthday party
• Change tip and tax if you prefer different values
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Y ou May Have Written
• You may have written your program like this:
- Two lines are required for each person
- And more if you decide to print names or change tax/tip values
public class CalculatorTest{
    public static void main(String args[]){
        Calculator calc = new Calculator();
        
        calc.originalPrice = 10;
        calc.findTotal();
        calc.originalPrice = 12;
        calc.findTotal();
    }//end method main
}//end class CalculatorTest
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Becoming More Flexible
• But it’s possible to do the same work in a single line
• It’s also dangerous to write programs that access fields directly
- You’ll learn about this later
- The goal of this lesson is just to prepare you to work with 
i
mportant Java-provided classes
calc.originalPrice = 10;            //Dangerous
 calc.findTotal();
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Remember the JOptionPane
• When we add the String  literal "type something:" to the 
method call, we’re supplying arguments to the method
• This argument alters the resulting JOptionP ane
JOptionPane.showInputDialog("Type something:");
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
When Can Methods Accept Arguments?
• You’ll find that many methods are affected by arguments
- But methods must be written in a way to accept arguments
- Otherwise, the compiler complains
- The calculate()  method is written to accept no arguments
Calculator calc = new Calculator();
calc.calculate();           //Good
calc.calculate(3, 2.0);     //Fail
public void calculate(){
    //How do I calculate?
}//end method calculate
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Method Argument, 1 of 2
• But this calculate() me thod is written to accept two 
arguments:
- The first argument must be an int
- The second argument must be a double
Calculator calc = new Calculator();
calc.calculate(3, 2.0); 
public void calculate(int x, double y){
    System.out.println(x/y);        //prints 1.5
}//end method calculate
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Method Argument, 2 of 2
• The variable int x is assigned a value of 3
• The variable double y is assigned a value of 2.0
Calculator calc = new Calculator();
calc.calculate(3, 2.0); 
public void calculate(int x, double y){
    System.out.println(x/y);        //prints 1.5
}//end method calculate
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Argument Order Matters
• What happens if we reverse the order of our arguments?
Calculator calc = new Calculator();
calc.calculate(2.0, 3); 
• We get a compiler error:
-int x c annot be assigned a double value
- The first argument must be an int
public void calculate(int x, double y){
    System.out.println(x/y);
}//end method calculate
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 1
• Create a new project and add the CalculatorTest3.java an d 
Calculator3.java files to the project
• From the main  method:
- Use a Calculator  object instance and supply arguments to 
findTotal() to print the total for each person
- Hint:  Observe the findTotal() method in the Calculator class 
to figure out how many arguments this method accepts
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3, Part 2
• Who does each total belong to?
• Modify the findTotal() method to accept an additional 
String name argument
• Concatenate the print  statement to include name
• Observe your IDE’s complaint in the main me thod and revise 
your findTotal() method calls
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Method Arguments and Parameters 
• An argument is a value that’s passed during a method call:
Calculator calc = new Calculator();
calc.calculate(3, 2.0);
• A parameter is a variable that’s defined in the method 
de
claration:
public void calculate(int x, double y){
    System.out.println(x/y);
}//end method calculate
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Method Parameters: Examples
• Methods may have any number or type of parameters:
public void calculate0(){
    System.out.println("No parameters");
}//end method calculate0
public void calculate1(int x){
    System.out.println(x/2.0);
}//end method calculate1
public void calculate2(int x, double y){
    System.out.println(x/y);
}//end method calculate2
public void calculate3(int x, double y, int z){
    System.out.println(x/y +z);
}//end method calculate3
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Scope of Parameters
• Methods need to be told what to do with the arguments they 
re
ceive
• You do that by using method parameters
- Method parameters are variables that exist within the entire scope 
of
 a method
- They’re created within the method declaration
- Scope refers to the {b lock of code} belonging to a method 
following its declaration
public void calculate(int x, double y){
    System.out.println(x/y);
}//end method calculate
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Referencing Method Parameters
• A variable may be referenced anywhere within its current block 
af
ter being declared
• A variable can’t be referenced outside the block where it was 
de
clared or before being declared
public void calculate(int x, double y){
    System.out.println(x/y);
} //end method calculate
public void calculate2(){
    System.out.println(2*x);  //What is x?
} //end method calculate2
39
```

</details>


## PDF page 40

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Finding the Grand Total: Scenario
• Your friends are impressed with how much you’re learning from 
th
e Java Foundations course! Alex asks, “What should the entire 
table’s total be?” Knowing the answer to this question would help 
make sure everyone has contributed and that the server has 
received the correct amount
• How can this be included in your code?
40
```

</details>


## PDF page 41

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Adding Totals, 1 of 3
• Another way to think about this:
- I’ve calculated a value within a method …
- But it’s stored as a variable that can’t exist outside the scope of its 
me
thod block …
- How do I get this value out of there?
public void findTotal(double price, String name){
    double total = price * (1 + tax + tip);
    System.out.println(name + ": $ " + total);
} //end method findTotal
41
```

</details>


## PDF page 42

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Adding Totals, 2 of 3
42
```

</details>


## PDF page 43

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Adding Totals, 3 of 3
• If you thought about writing your program like this:
public class CalculatorTest{
    public static void main(String args[]){
        Calculator calc = new Calculator();
        calc.findTotal(10);
        calc.findTotal(12);
        System.out.println(calc.findTotal(10) + calc.findTotal(12));
    }//end method main
}//end class CalculatorTest
• You’re half correct
• But your IDE gives you the following error: 
-'void' type not allowed here
43
```

</details>


## PDF page 44

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is a void Type?
•showInputDialog() i s a String type method
- It returns a value that can be stored as a String
String input = JOptionPane.showInputDialog("Type something:");
•void t ype methods don’t return any values
- There are no values to store after a void me thod is called
System.out.println("println is a void type method");
44
```

</details>


## PDF page 45

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Method Return Types
• Variables can have values of many different types:
• Method calls also return values of many different types:
• How to make a method return a value:
- Declare the method to be a non-void  return type
- Use the keyword return  within a method, followed by a value
45
```

</details>


## PDF page 46

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Method Return Types: Examples
• Methods must return data that matches their return type:
public void printString(){  
    System.out.println("Hello");
}//end method printString
public String returnString(){
    return("Hello");
}//end method returnString
public int sum(int x, int y){
    return(x + y);
}//end method sum
public boolean isGreater(int x, int y){
    return(x > y);
}//end method isGreater
46
```

</details>


## PDF page 47

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Method Return
• The following code examples produce equivalent results:
public static void main(String[] args){ 
    int num1 = 1, num2 = 2;
    int result = num1 + num2;
    System.out.println(result);
}//end method main
public static void main(String[] args){ 
    int num1 = 1, num2 = 2;
    int result = sum(num1, num2);
    System.out.println(result);
}//end method main
public static int sum(int x, int y){
    return(x + y);
}//end method sum
47
```

</details>


## PDF page 48

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Passing Arguments and Returning Values
48
```

</details>


## PDF page 49

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, Part 1
• Edit your Exe rcise3 solution
- Or create a new project and add the CalculatorTest4.java and  
Calculator4.java files to the project 
• Find and print the entire table’s total, including tax and tip
- You'll need to edit findTotal()  so that it returns its calculated 
value
49
```

</details>


## PDF page 50

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4, Part 2
• Person8 f orgot their wallet
• And Alex’s meal was meant to be a birthday present
• Modify findTotal() so that the cost of their meals are shared 
equally with the rest of the party
• Recalculate the entire table’s total
• This number shouldn’t have changed
50
```

</details>


## PDF page 51

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary About Method Syntax 
public double calculate(int x, double y){
   double quotient = x/y;
   return quotient;
}//end method calculate
51
```

</details>


## PDF page 52

<details>
<summary>Page text</summary>

```text
JFo 4-1
What is a Method?
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Structure code within a class
- Instantiate an object
- Understand the benefits of methods
- Use the dot operator to access an object’s fields and methods
- Supply arguments to a method
- Return values from a method
52
```

</details>


## PDF page 53

<details>
<summary>Page text</summary>

```text

```

</details>
