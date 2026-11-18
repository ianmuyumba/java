# 8-3 Exception Handling

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 8-3 Exception Handling.pdf

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
8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives: 
- Explain the purpose of exception handling
- Handle exceptions with a try/catch construct
- Describe common exceptions thrown in Java
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is an Exception?
• To understand exception handling, you need to first understand 
w
hat is an exception
• An exception is an error that occurs during the execution of a 
pr
ogram(run-time) that disrupts the normal flow of the Java 
program
• However, you can handle such conditions within your program 
and
 take necessary corrective actions so that the program can 
continue with its execution(exception handling)
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Why Should Y ou Handle Exceptions?
• If an exception occurs while your program is executing:
- Execution of the program is terminated
- A stack trace, with the details of the exception, is printed in the 
c
onsole
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
When Y ou Don’t Handle Exceptions: Example
• In Java, the following code throws an exception because you 
can
’t divide an integer by zero:
1 public class ExceptionHandling { 
2 
3 public static void main(String args[]) { 
4 int d = 0; 
5 int a = 10 / d; 
6 System.out.print(a); 
7 }//end method main 
8 }//end class ExceptionHandling 
• A stack trace, with the details of the exception, is printed in the 
cons
ole
• Execution of the program is terminated at line 4, and so the 
st
atement at line 5 isn’t executed
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
When Y ou Don’t Handle Exceptions
• When Java encounters an error or condition that prevents 
e
xecution from proceeding normally, Java "throws" an exception
• If the exception isn't "caug ht" by the programmer, the program 
crashes
• The exception description and current stack trace are printed to 
t
he console
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Dealing with Exceptions
• One way to deal with exceptions is to simply avoid them in the 
fi
rst place
• For example, avoid an ArithmeticException b y using 
conditional logic: 
- Test to see if the condition will arise before you attempt the 
pot
entially risky operation
int divisor = 0; 
if(divisor == 0){ 
 System.out.println("Can't be zero!"); 
} 
else { 
 System.out.println(5 / divisor); 
}//endif 
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exception Categories, 1 of 2
• Java exceptions fall into two categories:
• Checked Exceptions: 
- Compiler checks and deals with exceptions
- If the exceptions aren’t handled in the program, it gives a 
c
ompilation error
- Examples: 
• FileNotFoundException, IOException
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exception Categories, 2 of 2
• Unchecked Exceptions:
- Compiler does not check and deal with exceptions
- Examples: 
• ArrayIndexOutOfBoundsException, NullPointerExcep tion, 
ArithmeticException
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new project and add the ExceptionEx1.jav a file to the 
project
• Import and open the ExceptionsEx pr oject
• Examine Exceptio nEx1.java: 
- Execute the program and observe the output: 
- ArrayIndexOutOfBoundsException oc curs
- Is it a good practice to handle the exception for this program?
- Modify the program to compute the sum of the array
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Handling Exceptions with the try/catch Block
• But not all exceptions can be prevented because you don’t always 
kno
w whether a given operation will fail before it’s invoked
• Another strategy is to use the try/catch block for exception 
han
dling
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Understanding the try/catch Block
• For code that’s likely to cause an exception, you can write the 
code
 inside a special "try" block
• You associate exception handlers with a tr y block by providing 
one or more catch blocks after the try block
• Each ca tch block handles the type of exception indicated by its 
argument
• The E xceptionType  argument type declares the type of exception
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Flow Control in try/catch Blocks: Success
• If the try block succeeds, no exception occurs
try { 
 // risky code that is likely to cause 
 // an exception 
} 
catch(ExceptionType ex) { 
 // exception handling code 
} 
System.out.println("We made it"); 
First the try block runs, 
and then the code after 
the catch block runs
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Flow Control in try/catch Blocks: Failure
• If the try block fails, an exception occurs
try { 
 // risky code that is likely to cause 
 // an exception 
} 
catch(ExceptionType ex) { 
 // exception handling code 
} 
System.out.println("We made it"); 
The try block runs, 
an exception occurs, 
and the rest of the 
try block doesn’t run
The catch block 
runs, and then the 
rest of the code runs
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Flow Control in try/catch Blocks: Example
1 public static void main(String args[]) { 
2 int a = 100, res; 
3 try{ 
4  System.out. println("Enter the value for b"); 
5  Scanner console = new Scanner(System.in); 
6  int b = console.nextInt(); 
7  System.out. println("Enter the value for c"); 
8  int c = console.nextInt(); 
9  res =  10 / (b - c); 
10  System.out. println("The result is " + res); 
11 } 
12 catch(Exception e){ 
13  String errMsg  = e.getMessage(); 
14  System.out. println(errMsg); 
15 }//end try catch 
16 System.out. println("After catch block"); 
17 }//end method main 
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Examples of Exceptions
•java.lang.ArrayIndexOutOfBoundsException
- Attempt to access a nonexistent array index
•java.lang.NullPointerException
- Attempt to use an object reference that wasn’t instantiated
•  java.io.IOException
- Failed or interrupted I/O operations
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Understanding Common Exceptions
• Unchecked Exceptions - due to programming mistake : 
- Example: 
-ArrayIndexOutOfBoundsException ex ception
01 int[] intArray = new int[5]; 
02 intArray[5] = 27; 
• Stack trace:
Exception in thread "main" 
java.lang.ArrayIndexOutOfBoundsException: 5
        at TestErrors.main(TestErrors.java:17)
)
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Identifying NullPointerException
• This unchecked exception is thrown when an application 
at
tempts to use null when an object is required
• These include:
- Calling the instance method of a null object
- Accessing or modifying the field of a null object
public static void main(String[] args) { 
String name = null; 
System.out.print("Length of the string " + name.length()); 
}//end method main 
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Identifying IOException
public static void main(String[] args) { 
 try { File testFile = new File("//testFile.txt"); 
 testFile .createNewFile(); 
 System.out. println("testFile exists:“ + testFile.exists()); 
 } 
 catch  (IOException e) { 
  System.out. println(e); 
 }//end try catch 
}//end method main 
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Best Practices for Exception Handling
• Try to be as specific as possible with the type of error you're 
t
rying to catch
• This allows the program to provide you with specific feedback on 
w
hat went wrong
• Catch a generic exception is often too imprecise to be useful, but 
c
an be done as a last resort
catch (Exception e) { 
 System.out. println(e); 
} 
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Example of Bad Practice
public static void main(String[] args) { 
 try  { 
  File testFile = new File("//testFile.txt"); 
  testFile .createNewFile(); 
  System.out. println("testFile exists:" + testFile.exists()); 
 } 
 catch  (Exception e) { 
  System.out. println("Error Creating File"); 
 }//end try catch 
}//end method main 
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Somewhat Better Practice
public static void main(String[] args) { 
 try  { 
  File testFile = new File("//testFile.txt"); 
  testFile .createNewFile(); 
  System.out. println("testFile exists:" + testFile.exists()); 
 } 
 catch  (IOException e) { 
  System.out. println(e); 
 }//end try catch 
}//end method main
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2 
• Add the files Calculator.jav a and ShoppingCart.java to 
the project you created for exercise 1
• Examine Calculat or.java and ShoppingCart.java
• Modify the programs to implement exception handling:
-Calculator.java:
• Identify the exception that might occur
• Change the divide method signature to indicate that it throws an 
ex
ception
-ShoppingCart.java:
• Catch the exception in the class that calls the divide method
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 8-3
Exception Handling
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Explain the purpose of exception handling
- Handle exceptions with a try/catch construct
- Describe common exceptions thrown in Java
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text

```

</details>
