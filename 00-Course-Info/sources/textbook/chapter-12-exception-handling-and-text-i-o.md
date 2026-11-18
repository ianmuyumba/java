# Chapter 12 Exception Handling and Text I/O

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 472

<details>
<summary>Page text</summary>

```text
EXCEPTION HANDLING
AND TEXT I/O
Objectives
■ To get an overview of exceptions and exception handling (§12.2).
■ To explore the advantages of using exception handling (§12.2).
■ To distinguish exception types: Error (fatal) vs. Exception (nonfatal) 
and checked vs. unchecked (§12.3).
■ To declare exceptions in a method header (§12.4.1).
■ To throw exceptions in a method (§12.4.2).
■ To write a try-catch block to handle exceptions (§12.4.3).
■ To explain how an exception is propagated (§12.4.3).
■ To obtain information from an exception object (§12.4.4).
■ To develop applications with exception handling (§12.4.5).
■ To use the finally clause in a try-catch block (§12.5).
■ To use exceptions only for unexpected errors (§12.6).
■ To rethrow exceptions in a catch block (§12.7).
■ To create chained exceptions (§12.8).
■ To define custom exception classes (§12.9).
■ To discover file/directory properties, to delete and rename files/
directories, and to create directories using the File class (§12.10).
■ To write data to a file using the PrintWriter class (§12.11.1).
■ To use try-with-resources to ensure that the resources are closed 
automatically (§12.11.2).
■ To read data from a file using the Scanner class (§12.11.3).
■ To understand how data is read using a Scanner (§12.11.4).
■ To develop a program that replaces text in a file (§12.11.5).
■ To read data from the Web (§12.12).
■ To develop a Web crawler (§12.13).
CHAPTER
12
```

</details>


## PDF page 473

<details>
<summary>Page text</summary>

```text
450 Chapter 12  Exception Handling and Text I/O
12.1 Introduction
Exception handling enables a program to deal with exceptional situations and 
continue its normal execution.
Runtime errors  occur while a program is running if the JVM detects an operation that is 
impossible to carry out. For example, if you access an array using an index that is out of 
bounds, you will get a runtime error with an ArrayIndexOutOfBoundsException. If you 
enter a double value when your program expects an integer, you will get a runtime error with 
anInputMismatchException.
In Java, runtime errors are thrown as exceptions. An exception is an object that represents 
an error or a condition that prevents execution from proceeding normally. If the exception is 
not handled, the program will terminate abnormally. How can you handle the exception so 
that the program can continue to run or else terminate gracefully? This chapter introduces this 
subject and text input and output.
12.2 Exception-Handling Overview
Exceptions are thrown from a method. The caller of the method can catch and handle 
the exception. 
To demonstrate exception handling, including how an exception object is created and thrown, 
let’s begin with the example in Listing 12.1, which reads in two integers and displays their 
quotient.
LISTING 12.1 Quotient.java
 1 import java.util.Scanner;
 2
 3 public class Quotient {
 4 public static void main(String[] args) {
 5      Scanner input = new Scanner(System.in);
 6
 7 // Prompt the user to enter two integers
 8      System.out.print("Enter two integers: ");
 9 int number1 = input.nextInt();
10 int number2 = input.nextInt();
11
12      System.out.println(number1 + " / " + number2 + " is " +
13        (number1 / number2));
14    }
15  }
Key
Point
exception
Key
Point
Exception-handling
advantages
VideoNote
read two integers
integer division
Enter two integers: 5 2
5 / 2 is 2
Enter two integers: 3 0
Exception in thread "main" java.lang.ArithmeticException: / by zero
at Quotient.main(Quotient.java:11)
If you entered 0 for the second number, a runtime error would occur, because you cannot 
divide an integer by 0. (Note that a floating-point number divided by 0 does not raise an 
exception.) A simple way to fix this error is to add an if statement to test the second number, 
as shown in Listing 12.2.
```

</details>


## PDF page 474

<details>
<summary>Page text</summary>

```text
12.2 Exception-Handling Overview  451
LISTING 12.2 QuotientWithIf.java
 1 import java.util.Scanner;
 2
 3 public class QuotientWithIf {
 4 public static void main(String[] args) {
 5      Scanner input = new Scanner(System.in);
 6
 7 // Prompt the user to enter two integers
 8      System.out.print("Enter two integers: ");
 9 int number1 = input.nextInt();
10 int number2 = input.nextInt();
11
12 if (number2 != 0)
13        System.out.println(number1 + " / " + number2 
14          + " is " + (number1 / number2));
15 else
16        System.out.println("Divisor cannot be zero ");
17    }
18  }
read two integers
testnumber2
Enter two integers: 5 0
Divisor cannot be zero 
Before introducing  exception handling, let us rewrite Listing 12.2 to compute a quotient using 
a method, as shown in Listing 12.3.
LISTING 12.3 QuotientWithMethod.java
 1 import java.util.Scanner;
 2
 3 public class QuotientWithMethod { 
 4 public static int quotient(int number1, int number2) {
 5 if (number2 == 0) {
 6        System.out.println("Divisor cannot be zero");
 7 System.exit( 1);
 8      }
 9
10 return number1 / number2;
11    }
12
13 public static void main(String[] args) {
14      Scanner input = new Scanner(System.in);
15
16 // Prompt the user to enter two integers
17      System.out.print("Enter two integers: ");
18 int number1 = input.nextInt();
19 int number2 = input.nextInt();
20
21 int result = quotient(number1, number2);
22      System.out.println(number1 + " / " + number2 + " is "
23        + result);
24    }
25  }
quotient method
terminate the program
read two integers
invoke method
```

</details>


## PDF page 475

<details>
<summary>Page text</summary>

```text
452 Chapter 12  Exception Handling and Text I/O
The method quotient (lines 4–11) returns the quotient of two integers. If number2 is 0, it 
cannot return a value, so the program is terminated in line 7. This is clearly a problem. You 
should not let the method terminate the program—the caller should decide whether to termi-
nate the program.
How can a method notify its caller an exception has occurred? Java enables a method to 
throw an exception that can be caught and handled by the caller. Listing 12.3 can be rewritten, 
as shown in Listing 12.4.
LISTING 12.4 QuotientWithException.java
 1 import java.util.Scanner;
 2
 3 public class QuotientWithException { 
 4 public static int quotient(int number1, int number2) {
 5 if (number2 == 0)
 6 throw new ArithmeticException("Divisor cannot be zero");
 7
 8 return number1 / number2;
 9    }
10
11 public static void main(String[] args) {
12      Scanner input = new Scanner(System.in);
13
14 // Prompt the user to enter two integers
15      System.out.print("Enter two integers: ");
16 int number1 = input.nextInt();
17 int number2 = input.nextInt();
18
19 try {
20 int result = quotient(number1, number2);
21        System.out.println(number1 + " / " + number2 + " is "
22          + result);
23      }
24 catch (ArithmeticException ex) {
25        System.out.println("Exception: an integer " + 
26 "cannot be divided by zero ");
27      }
28
29      System.out.println("Execution continues ...");
30    }
31  }
quotient method
throw exception
read two integers
try block
invoke method
catch block
Enter two integers: 5 3
5 / 3 is 1
Execution continues ... 
Enter two integers: 5 3
5 / 3 is 1
Enter two integers: 5 0
Divisor cannot be zero
If an 
Arithmetic
Exception
occurs
```

</details>


## PDF page 476

<details>
<summary>Page text</summary>

```text
12.2 Exception-Handling Overview  453
Ifnumber2 is 0, the method throws an exception (line 6) by executing
throw new ArithmeticException("Divisor cannot be zero");
The value thrown, in this case new ArithmeticException("Divisor cannot be zero"),
is called an exception. The execution of a throw statement is called throwing an exception.
The exception is an object created from an exception class. In this case, the exception class is 
java.lang.ArithmeticException. The constructor ArithmeticException(str) is 
invoked to construct an exception object, where str is a message that describes the exception.
When an exception is thrown, the normal execution flow is interrupted. As the name sug-
gests, to “throw an exception” is to pass the exception from one place to another. The state-
ment for invoking the method is contained in a try block and a catch block. The try block 
(lines 19–23) contains the code that is executed in normal circumstances. The exception is 
caught by the catch block. The code in the catch block is executed to handle the exception.
Afterward, the statement (line 29) after the catch block is executed.
Thethrow statement is analogous to a method call, but instead of calling a method, it calls 
acatch block. In this sense, a catch block is like a method definition with a parameter that 
matches the type of the value being thrown. Unlike a method, however, after the catch block 
is executed, the program control does not return to the throw statement; instead, it executes 
the next statement after the catch block.
The identifier ex in the catch–block header
catch (ArithmeticException ex)
acts very much like a parameter in a method. Thus, this parameter is referred to as a 
catch–block parameter. The type (e.g., ArithmeticException ) preceding ex specifies 
what kind of exception the catch block can catch. Once the exception is caught, you can 
access the thrown value from this parameter in the body of a catch block.
In summary, a template for a try-throw-catch block may look like this:
try {
  Code to run;
  A statement or a method that may throw an exception;
  More code to run;
}
catch (type ex) {
  Code to process the exception;
}
An exception may be thrown directly by using a throw statement in a try block, or by invok-
ing a method that may throw an exception.
The main method invokes quotient (line 20). If the quotient method executes normally, 
it returns a value to the caller. If the quotient method encounters an exception, it throws the 
exception back to its caller. The caller’s catch block handles the exception.
Now you can see the advantage of using exception handling: It enables a method to throw 
an exception to its caller, enabling the caller to handle the exception. Without this capability, 
the called method itself must handle the exception or terminate the program. Often the called 
method does not know what to do in case of error. This is typically the case for the library 
methods. The library method can detect the error, but only the caller knows what needs to be 
throw statement
exception
throw exception
handle exception
catch–block parameter
advantage
Enter two integers: 5 0
Exception: an integer cannot be divided by zero 
Execution continues ...
```

</details>


## PDF page 477

<details>
<summary>Page text</summary>

```text
454 Chapter 12  Exception Handling and Text I/O
done when an error occurs. The key benefit of exception handling is separating the detection 
of an error (done in a called method) from the handling of an error (done in the calling 
method).
Many library methods throw exceptions. Listing 12.5 gives an example that handles an 
InputMismatchException when reading an input.
LISTING 12.5 InputMismatchExceptionDemo.java
 1 import java.util.*;
 2
 3 public class InputMismatchExceptionDemo {
 4 public static void main(String[] args) {
 5      Scanner input = new Scanner(System.in);
 6 boolean continueInput = true;
 7
 8 do {
 9 try {
10          System.out.print("Enter an integer: ");
11 int number = input.nextInt();
12
13 // Display the result
14          System.out.println(
15 "The number entered is " + number);
16
17          continueInput = false;
18        } 
19 catch (InputMismatchException ex) {
20          System.out.println("Try again. (" + 
21 "Incorrect input: an integer is required)");
22          input.nextLine(); // Discard input 
23        }
24      } while (continueInput);
25    }
26  }
create a Scanner
try block
catch block
Enter an integer: 3.5
Try again. (Incorrect input: an integer is required)
Enter an integer: 4
The number entered is 4
If an
InputMismatch
Exception
occurs
When executing input.nextInt() (line 11), an InputMismatchException occurs if 
the input entered is not an integer. Suppose 3.5 is entered. An InputMismatchException
occurs and the control is transferred to the catch block. The statements in the catch block 
are now executed. The statement input.nextLine() in line 22 discards the current input 
line so that the user can enter a new line of input. The variable continueInput controls the 
loop. Its initial value is true (line 6), and it is changed to false (line 17) when a valid input 
is received. Once a valid input is received, there is no need to continue the input. 
12.1 What is the advantage of using exception handling?
12.2 Which of the following statements will throw an exception?
System.out.println(1 / 0);
System.out.println(1.0 / 0);
✓Point✓
Check
```

</details>


## PDF page 478

<details>
<summary>Page text</summary>

```text
12.3 Exception Types  455
12.3 Point out the problem in the following code. Does the code throw any exceptions?
long value = Long.MAX_VALUE + 1;
System.out.println(value);
12.4 What does the JVM do when an exception occurs? How do you catch an exception?
12.5 What is the output of the following code?
public class Test {
public static void main(String[] args) {
try {
int value = 30;
if (value < 40)
throw new Exception("value is too small");
    }
catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    System.out.println("Continue after the catch block");
  }
}
What would be the output if the line
int value = 30;
were changed to
int value = 50;
12.6 Show the output of the following code.
public class Test {
public static void main(String[] args) {
for (int i = 0; i < 2; i++) {
      System.out.print(i + " ");
try {
        System.out.println(1 / 0);
      }
catch (Exception ex) {
      }
    }
  }
}
(a)
public class Test {
public static void main(String[] args) {
try {
for (int i = 0; i < 2; i++) {
        System.out.print(i + " ");
        System.out.println(1 / 0);
      }
    }
catch (Exception ex) {
    }
  }
}
(b)
12.3 Exception Types
Exceptions are objects, and objects are defined using classes. The root class for 
exceptions is java.lang.Throwable.
The preceding section used the classes ArithmeticException and InputMismatch-
Exception. Are there any other types of exceptions you can use? Can you define your 
own exception classes? Yes. There are many predefined exception classes in the Java API. 
Figure 12.1 shows some of them, and in Section 12.9 you will learn how to define your own 
exception classes.
Key
Point
```

</details>


## PDF page 479

<details>
<summary>Page text</summary>

```text
456 Chapter 12  Exception Handling and Text I/O
Note
The class names Error,Exception, and RuntimeException are somewhat con-
fusing. All three of these classes are exceptions, and all of the errors occur at runtime.
The Throwable class is the root of exception classes. All Java exception classes inherit 
directly or indirectly from Throwable. You can create your own exception classes by extend-
ingException or a subclass of Exception.
The exception classes can be classified into three major types: system errors, exceptions, 
and runtime exceptions.
 ■ System errors are thrown by the JVM and are represented in the Error class. The 
Error class describes internal system errors, though such errors rarely occur. If one 
does, there is little you can do beyond notifying the user and trying to terminate the 
program gracefully. Examples of subclasses of Error are listed in Table 12.1.
system error
exception
FIGURE 12.1 Exceptions thrown are instances of the classes shown in this diagram, or of subclasses of one of these classes.
Error
ClassNotFoundException
Many more classes
Many more classes
IOException
RuntimeException
LinkageError
VirtualMachineError
Object Throwable
Exception
Many more classes
ArithmeticException
NullPointerException
IndexOutOfBoundsException
IllegalArgumentException
Class Reasons for Exception
LinkageError A class has some dependency on another class, but the latter class has 
  changed incompatibly after the compilation of the former class.
VirtualMachineError The JVM is broken or has run out of the resources it needs in order to 
continue operating.
TABLE 12.1  Examples of Subclasses of Error
Class Reasons for Exception
ClassNotFoundException Attempt to use a class that does not exist. This exception would occur, for example, if you tried to 
  run a nonexistent class using the java command, or if your program were composed of, say, 
  three class files, only two of which could be found.
IOException Related to input/output operations, such as invalid input, reading past the end of a file, and opening
  a nonexistent file. Examples of subclasses of IOException are InterruptedIOException,
EOFException (EOF is short for End of File), and FileNotFoundException.
TABLE 12.2  Examples of Subclasses of Exception
 ■ Exceptions are represented in the Exception class, which describes errors caused by 
your program and by external circumstances. These errors can be caught and handled 
by your program. Examples of subclasses of Exception are listed in Table 12.2.
```

</details>


## PDF page 480

<details>
<summary>Page text</summary>

```text
12.3 Exception Types  457
 ■ Runtime exceptions  are represented in the RuntimeException class, which 
describes programming errors, such as bad casting, accessing an out-of-bounds 
array, and numeric errors. Runtime exceptions are generally thrown by the JVM. 
Examples of subclasses are listed in Table 12.3.
runtime exception
Class Reasons for Exception
ArithmeticException Dividing an integer by zero. Note that floating-point arithmetic 
  does not throw exceptions (see Appendix E, Special Floating-  
Point Values). 
NullPointerException Attempt to access an object through a null reference variable.
IndexOutOfBoundsException Index to an array is out of range.
IllegalArgumentException A method is passed an argument that is illegal or inappropriate.
TABLE 12.3  Examples of Subclasses of RuntimeException
RuntimeException, Error, and their subclasses are known as unchecked exceptions. All 
other exceptions are known as checked exceptions , meaning that the compiler forces the 
programmer to check and deal with them in a try-catch block or declare it in the method 
header. Declaring an exception in the method header will be covered in Section 12.4.
In most cases, unchecked exceptions reflect programming logic errors that are unrecover-
able. For example, a NullPointerException is thrown if you access an object through a 
reference variable before an object is assigned to it; an IndexOutOfBoundsException is 
thrown if you access an element in an array outside the bounds of the array. These are logic 
errors that should be corrected in the program. Unchecked exceptions can occur anywhere in 
a program. To avoid cumbersome overuse of try-catch blocks, Java does not mandate that 
you write code to catch or declare unchecked exceptions.
12.7 Describe the Java Throwable class, its subclasses, and the types of exceptions.
12.8 WhatRuntimeException will the following programs throw, if any? 
unchecked exception
checked exception
✓Point✓
Check
public class Test {
public static void main(String[] args) {
    System.out.println(1 / 0);
  }
}
(a)
public class Test {
public static void main(String[] args) {
int[] list = new int[5];
    System.out.println(list[5]);
  }
}
(b)
public class Test {
public static void main(String[] args) {
    String s = "abc";
    System.out.println(s.charAt(3));
  }
}
(c)
public class Test {
public static void main(String[] args) {
    Object o = new Object();
    String d = (String)o;
  }
}
(d)
public class Test {
public static void main(String[] args) {
    Object o = null;
    System.out.println(o.toString());
  }
}
(e)
public class Test {
public static void main(String[] args) {
    System.out.println(1.0 / 0);
  }
}
(f)
```

</details>


## PDF page 481

<details>
<summary>Page text</summary>

```text
458 Chapter 12  Exception Handling and Text I/O
12.4 More on Exception Handling
A handler for an exception is found by propagating the exception backward through a 
chain of method calls, starting from the current method.
The preceding sections gave you an overview of exception handling and introduced sev-
eral predefined exception types. This section provides an in-depth discussion of exception 
handling.
Java’s exception-handling model is based on three operations: declaring an exception ,
throwing an exception, and catching an exception, as shown in Figure 12.2.
Key
Point
FIGURE 12.2 Exception handling in Java consists of declaring exceptions, throwing exceptions, and catching and 
processing exceptions.
Catch exception
Declare exception
Throw exception
method1() {
try {
invoke method2;
}
catch (Exception ex) {
Process exception;
}
}
method2() throws Exception {
if (an error occurs) {
throw new Exception();
}
}
12.4.1 Declaring Exceptions
In Java, the statement currently being executed belongs to a method. The Java interpreter 
invokes the main method to start executing a program. Every method must state the types of 
checked exceptions it might throw. This is known as declaring exceptions. Because system 
errors and runtime errors can happen to any code, Java does not require that you declare 
Error and RuntimeException (unchecked exceptions) explicitly in the method. However, 
all other exceptions thrown by the method must be explicitly declared in the method header so 
that the caller of the method is informed of the exception.
To declare an exception in a method, use the throws keyword in the method header, as in 
this example:
public void myMethod() throws IOException
Thethrows keyword indicates that myMethod might throw an IOException. If the method 
might throw multiple exceptions, add a list of the exceptions, separated by commas, after 
throws:
public void myMethod()
  throws Exception1, Exception2, ..., ExceptionN
Note
If a method does not declare exceptions in the superclass, you cannot override it to 
declare exceptions in the subclass.
12.4.2 Throwing Exceptions
A program that detects an error can create an instance of an appropriate exception type and 
throw it. This is known as throwing an exception. Here is an example: Suppose the program 
detects that an argument passed to the method violates the method contract (e.g., the argument 
declare exception
throw exception
```

</details>


## PDF page 482

<details>
<summary>Page text</summary>

```text
12.4 More on Exception Handling  459
must be nonnegative, but a negative argument is passed); the program can create an instance 
ofIllegalArgumentException and throw it, as follows:
IllegalArgumentException ex = 
new IllegalArgumentException("Wrong Argument");
throw ex;
Or, if you prefer, you can use the following:
throw new IllegalArgumentException("Wrong Argument");
Note
IllegalArgumentException  is an exception class in the Java API. In general, 
each exception class in the Java API has at least two constructors: a no-arg con-
structor, and a constructor with a String argument that describes the exception. 
This argument is called the exception message , which can be obtained using 
getMessage() .
Tip
The keyword to declare an exception is throws, and the keyword to throw an exception
isthrow.
12.4.3 Catching Exceptions
You now know how to declare an exception and how to throw an exception. When an excep-
tion is thrown, it can be caught and handled in a try-catch block, as follows: 
try {
  statements; // Statements that may throw exceptions
}
catch (Exception1 exVar1) {
  handler for exception1;
}
catch (Exception2 exVar2) { 
  handler for exception2;
}
...
catch (ExceptionN exVarN) {
  handler for exceptionN;
}
If no exceptions arise during the execution of the try block, the catch blocks are skipped.
If one of the statements inside the try block throws an exception, Java skips the remain-
ing statements in the try block and starts the process of finding the code to handle the 
exception. The code that handles the exception is called the exception handler ; it is found 
by propagating the exception  backward through a chain of method calls, starting from the 
current method. Each catch block is examined in turn, from first to last, to see whether 
the type of the exception object is an instance of the exception class in the catch block. 
If so, the exception object is assigned to the variable declared, and the code in the catch
block is executed. If no handler is found, Java exits this method, passes the exception to 
the method that invoked the method, and continues the same process to find a handler. If 
no handler is found in the chain of methods being invoked, the program terminates and 
prints an error message on the console. The process of finding a handler is called catching 
an exception .
exception message
throws vs. throw
catch exception
exception handler
exception propagation
```

</details>


## PDF page 483

<details>
<summary>Page text</summary>

```text
460 Chapter 12  Exception Handling and Text I/O
Suppose the main method invokes method1, method1 invokes method2, method2
invokesmethod3, and method3 throws an exception, as shown in Figure 12.3. Consider the 
following scenario:
 ■ If the exception type is Exception3, it is caught by the catch block for han-
dling exception ex3 in method2. statement5 is skipped, and statement6 is 
executed.
 ■ If the exception type is Exception2,method2 is aborted, the control is returned to 
method1, and the exception is caught by the catch block for handling exception 
ex2 in method1.statement3 is skipped, and statement4 is executed.
 ■ If the exception type is Exception1, method1 is aborted, the control is returned 
to the main method, and the exception is caught by the catch block for handling 
exception ex1 in the main method. statement1 is skipped, and statement2 is 
executed.
 ■ If the exception type is not caught in method2, method1, or main, the program 
terminates, and statement1 and statement2 are not executed.
FIGURE 12.3 If an exception is not caught in the current method, it is passed to its caller. The process is repeated until 
the exception is caught or passed to the main method.
main method {
...
try {
    ...
invoke method1;
statement1;
}
catch (Exception1 ex1) {
Process ex1;
}
statement2;
}
method1 {
...
try {
    ...
invoke method2;
statement3;
}
catch (Exception2 ex2) {
Process ex2;
}
statement4;
}
method2 {
...
try {
    ...
invoke method3;
statement5;
}
catch (Exception3 ex3) {
Process ex3;
}
statement6;
}
An exception
is thrown in
method3
Call stack
main method main method
method1
main method
method1
main method
method1
method2 method2
method3
Note
Various exception classes can be derived from a common superclass. If a catch block 
catches exception objects of a superclass, it can catch all the exception objects of the 
subclasses of that superclass.
Note
The order in which exceptions are specified in catch blocks is important. A compile 
error will result if a catch block for a superclass type appears before a catch block for a 
subclass type. For example, the ordering in (a) on the next page is erroneous, because 
RuntimeException is a subclass of Exception. The correct ordering should be as 
shown in (b).
catch block
order of exception handlers
```

</details>


## PDF page 484

<details>
<summary>Page text</summary>

```text
12.4 More on Exception Handling  461
Note
Java forces you to deal with checked exceptions. If a method declares a checked exception 
(i.e., an exception other than Error or RuntimeException), you must invoke it in a 
try-catch block or declare to throw the exception in the calling method. For example, 
suppose that method p1 invokes method p2, and p2 may throw a checked exception 
(e.g.,IOException); you have to write the code as shown in (a) or (b) below. 
catch or declare checked 
exceptions
FIGURE 12.4 Throwable is the root class for all exception objects.
java.lang.Throwable
+getMessage(): String
+toString(): String
+printStackTrace(): void
+getStackTrace():
StackTraceElement[]
Returns the message that describes this exception object.
Returns the concatenation of three strings: (1) the full name of the exception
class; (2) ":" (a colon and a space); (3) the getMessage() method.
Prints theThrowable object and its call stack trace information on the
console.
Returns an array of stack trace elements representing the stack trace
pertaining to this exception object.
try {
  ...
}
catch (Exception ex) {
  ...
}
catch (RuntimeException ex) {
  ...
}
(a) Wrong order
try {
  ...
}
catch (RuntimeException ex) {
  ...
}
catch (Exception ex) {
  ...
}
(b) Correct order
void p1() {
try {
    p2();
}
catch (IOException ex) {
    ...
}
}
(a) Catch exception
void p1() throws IOException {
  p2();
}
(b) Throw exception
Note
You can use the new JDK 7 multi-catch feature to simplify coding for the exceptions 
with the same handling code. The syntax is:
catch (Exception1 | Exception2 | ... | Exceptionk ex) {
// Same code for handling these exceptions
}
Each exception type is separated from the next with a vertical bar ( |). If one of the 
exceptions is caught, the handling code is executed.
12.4.4 Getting Information from Exceptions
An exception object contains valuable information about the exception. You may use the fol-
lowing instance methods in the java.lang.Throwable class to get information regarding 
the exception, as shown in Figure 12.4. The printStackTrace() method prints stack trace 
JDK 7 multi-catch
methods in Throwable
```

</details>


## PDF page 485

<details>
<summary>Page text</summary>

```text
462 Chapter 12  Exception Handling and Text I/O
information on the console. The getStackTrace() method provides programmatic access 
to the stack trace information printed by printStackTrace().
Listing 12.6 gives an example that uses the methods in Throwable to display exception 
information. Line 4 invokes the sum method to return the sum of all the elements in the array. 
There is an error in line 23 that causes the ArrayIndexOutOfBoundsException, a sub-
class of IndexOutOfBoundsException. This exception is caught in the try-catch block. 
Lines 7, 8, and 9 display the stack trace, exception message, and exception object and mes-
sage using the printStackTrace(),getMessage(), and toString() methods, as shown 
in Figure 12.5. Line 12 brings stack trace elements into an array. Each element represents a 
method call. You can obtain the method (line 14), class name (line 15), and exception line 
number (line 16) for each element.
FIGURE 12.5 You can use the printStackTrace(),getMessage(),toString(), and 
getStackTrace() methods to obtain information from exception objects.
printStackTrace()
getMessage()
toString()
Using
getStackTrace()
LISTING 12.6 TestException.java
 1 public class TestException  {
 2 public static void main(String[] args) {
 3 try {
 4        System.out.println(sum(new int[] {1, 2, 3, 4, 5}));
 5      }
 6 catch (Exception ex) {
 7        ex.printStackTrace();
 8        System.out.println("\n" + ex.getMessage());
 9        System.out.println("\n" + ex.toString());
10
11        System.out.println("\nTrace Info Obtained from getStackTrace");
12        StackTraceElement[] traceElements = ex.getStackTrace();
13 for (int i = 0; i < traceElements.length; i++) {
14          System.out.print("method " + traceElements[i].getMethodName());
15          System.out.print("(" + traceElements[i].getClassName() + ":");
16          System.out.println(traceElements[i].getLineNumber() + ")");
17        }
18      }
19    }
20
21 private static int sum(int[] list) {
22 int result = 0;
23 for (int i = 0; i <= list.length; i++)
getStackTrace()
invokesum
printStackTrace()
getMessage()
toString()
cause an exception
```

</details>


## PDF page 486

<details>
<summary>Page text</summary>

```text
12.4 More on Exception Handling  463
24        result += list[i];
25 return result;
26    }
27  }
12.4.5 Example: Declaring, Throwing, and Catching Exceptions
This example demonstrates declaring, throwing, and catching exceptions by modifying the 
setRadius method in the Circle class in Listing 9.8, CircleWithPrivateDataFields.java.
The new setRadius method throws an exception if the radius is negative.
Listing 12.7 defines a new circle class named CircleWithException, which is the same 
as CircleWithPrivateDataFields except that the setRadius(double newRadius)
method throws an IllegalArgumentException if the argument newRadius is negative.
LISTING 12.7 CircleWithException.java
 1 public class CircleWithException {
 2 /** The radius of the circle */
 3 private double radius;
 4
 5 /** The number of the objects created */
 6 private static int numberOfObjects = 0;
 7
 8 /** Construct a circle with radius 1 */
 9 public CircleWithException() {
10 this(1.0);
11    }
12
13 /** Construct a circle with a specified radius */
14 public CircleWithException(double newRadius) {
15 setRadius(newRadius);
16      numberOfObjects++;
17    }
18
19 /** Return radius */
20 public double getRadius() {
21 return radius;
22    }
23
24 /** Set a new radius */
25 public void setRadius(double newRadius) 
26 throws IllegalArgumentException {
27 if (newRadius >= 0)
28        radius = newRadius;
29 else
30 throw new IllegalArgumentException(
31 "Radius cannot be negative");
32    }
33
34 /** Return numberOfObjects */
35 public static int getNumberOfObjects() {
36 return numberOfObjects;
37    }
38
39 /** Return the area of this circle */
40 public double findArea() {
41 return radius * radius * 3.14159;
42    }
43  }
declare exception
throw exception
```

</details>


## PDF page 487

<details>
<summary>Page text</summary>

```text
464 Chapter 12  Exception Handling and Text I/O
A test program that uses the new Circle class is given in Listing 12.8.
LISTING 12.8 TestCircleWithException.java
 1 public class TestCircleWithException {
 2 public static void main(String[] args) {
 3 try {
 4        CircleWithException c1 = new CircleWithException(5);
 5        CircleWithException c2 = new CircleWithException(-5);
 6        CircleWithException c3 = new CircleWithException(0);
 7}
 8 catch (IllegalArgumentException ex) {
 9        System.out.println(ex); 
10 }
11
12      System.out.println("Number of objects created: " + 
13        CircleWithException.getNumberOfObjects());
14    }
15  }
try
catch
java.lang.IllegalArgumentException: Radius cannot be negative
Number of objects created: 1
The original Circle class remains intact except that the class name is changed to 
CircleWithException, a new constructor CircleWithException(newRadius) is 
added, and the setRadius method now declares an exception and throws it if the radius is 
negative.
The setRadius method declares to throw IllegalArgumentException in the method 
header (lines 25–32 in CircleWithException.java). The CircleWithException class would 
still compile if the throws IllegalArgumentException clause (line 26) were removed from 
the method declaration, since it is a subclass of RuntimeException and every method can 
throwRuntimeException (an unchecked exception) regardless of whether it is declared in the 
method header.
The test program creates three CircleWithException objects—c1, c2, and c3—to test 
how to handle exceptions. Invoking new CircleWithException(-5) (line 5 in Listing 12.8) 
causes the setRadius method to be invoked, which throws an IllegalArgumentException,
because the radius is negative. In the catch block, the type of the object ex is 
IllegalArgumentException, which matches the exception object thrown by the setRadius
method, so this exception is caught by the catch block.
The exception handler prints a short message, ex.toString() (line 9 in Listing 12.8), 
about the exception, using System.out.println(ex).
Note that the execution continues in the event of the exception. If the handlers had not 
caught the exception, the program would have abruptly terminated.
The test program would still compile if the try statement were not used, because the method 
throws an instance of IllegalArgumentException, a subclass of RuntimeException (an 
unchecked exception). If a method throws an exception other than RuntimeException or 
Error, the method must be invoked within a try-catch block.
12.9 What is the purpose of declaring exceptions? How do you declare an exception, and 
where? Can you declare multiple exceptions in a method header?
12.10 What is a checked exception, and what is an unchecked exception?
12.11 How do you throw an exception? Can you throw multiple exceptions in one throw
statement?
12.12 What is the keyword throw used for? What is the keyword throws used for?
✓Point✓
Check
```

</details>


## PDF page 488

<details>
<summary>Page text</summary>

```text
12.4 More on Exception Handling  465
12.13 Suppose that statement2 causes an exception in the following try-catch block:
try {
  statement1;
statement2;
  statement3;
}
catch (Exception1 ex1) {
}
catch (Exception2 ex2) {
}
statement4;
Answer the following questions:
■ Willstatement3 be executed?
■ If the exception is not caught, will statement4 be executed?
■ If the exception is caught in the catch block, will statement4 be executed?
12.14 What is displayed when the following program is run?
public class Test {
public static void main(String[] args) {
try {
int[] list = new int[10];
      System.out.println("list[10] is " + list[10]);
    }
catch (ArithmeticException ex) {
      System.out.println("ArithmeticException");
    }
catch (RuntimeException ex) {
      System.out.println("RuntimeException");
    }
catch (Exception ex) {
      System.out.println("Exception");
    }
  }
}
12.15 What is displayed when the following program is run?
public class Test {
public static void main(String[] args) { 
try {
      method();
      System.out.println("After the method call");
    }
catch (ArithmeticException ex) { 
      System.out.println("ArithmeticException");
    }
catch (RuntimeException ex) { 
      System.out.println("RuntimeException");
    }
catch (Exception e) {
      System.out.println("Exception");
    }
  }
static void method() throws Exception {
```

</details>


## PDF page 489

<details>
<summary>Page text</summary>

```text
466 Chapter 12  Exception Handling and Text I/O
    System.out.println(1 / 0);
  }
}
12.16 What is displayed when the following program is run?
public class Test { 
public static void main(String[] args) {
try {
      method();
      System.out.println("After the method call");
    }
catch (RuntimeException ex) {
      System.out.println("RuntimeException in main");
    }
catch (Exception ex) {
      System.out.println("Exception in main");
    }
  }
static void method() throws Exception {
try {
      String s = "abc";
      System.out.println(s.charAt(3));
    }
catch (RuntimeException ex) {
      System.out.println("RuntimeException in method()");
    }
catch (Exception ex) {
      System.out.println("Exception in method()");
    }
  }
}
12.17 What does the method getMessage() do?
12.18 What does the method printStackTrace() do?
12.19 Does the presence of a try-catch block impose overhead when no exception occurs?
12.20 Correct a compile error in the following code:
public void m(int value) {
if (value < 40)
throw new Exception("value is too small");
}
12.5 The finally Clause
Thefinally clause is always executed regardless whether an exception occurred or not.
Occasionally, you may want some code to be executed regardless of whether an exception 
occurs or is caught. Java has a finally clause that can be used to accomplish this objective. 
The syntax for the finally clause might look like this:
try {
  statements;
}
catch (TheException ex) {
  handling ex;
}
Key
Point
```

</details>


## PDF page 490

<details>
<summary>Page text</summary>

```text
12.6 When to Use Exceptions  467
finally {
  finalStatements;
}
The code in the finally block is executed under all circumstances, regardless of whether an 
exception occurs in the try block or is caught. Consider three possible cases:
 ■ If no exception arises in the try block, finalStatements is executed, and the next 
statement after the try statement is executed.
 ■ If a statement causes an exception in the try block that is caught in a catch block, the 
rest of the statements in the try block are skipped, the catch block is executed, and the 
finally clause is executed. The next statement after the try statement is executed.
 ■ If one of the statements causes an exception that is not caught in any catch block, 
the other statements in the try block are skipped, the finally clause is executed, 
and the exception is passed to the caller of this method.
The finally block executes even if there is a return statement prior to reaching the 
finally block.
Note
Thecatch block may be omitted when the finally clause is used.
12.21 Suppose that statement2 causes an exception in the following statement:
try {
  statement1;
statement2;
  statement3;
}
catch (Exception1 ex1) {
}
finally {
  statement4;
}
statement5;
Answer the following questions:
■ If no exception occurs, will statement4 be executed, and will statement5 be 
executed?
■ If the exception is of type Exception1, will statement4 be executed, and will 
statement5 be executed?
■ If the exception is not of type Exception1, will statement4 be executed, and 
willstatement5 be executed?
12.6 When to Use Exceptions
A method should throw an exception if the error needs to be handled by its caller.
Thetry block contains the code that is executed in normal circumstances. The catch block 
contains the code that is executed in exceptional circumstances. Exception handling separates 
error-handling code from normal programming tasks, thus making programs easier to read 
and to modify. Be aware, however, that exception handling usually requires more time and 
resources, because it requires instantiating a new exception object, rolling back the call stack, 
and propagating the exception through the chain of methods invoked to search for the handler.
omit catch block
✓Point✓
Check
Key
Point
```

</details>


## PDF page 491

<details>
<summary>Page text</summary>

```text
468 Chapter 12  Exception Handling and Text I/O
An exception occurs in a method. If you want the exception to be processed by its caller, 
you should create an exception object and throw it. If you can handle the exception in the 
method where it occurs, there is no need to throw or use exceptions.
In general, common exceptions that may occur in multiple classes in a project are candi-
dates for exception classes. Simple errors that may occur in individual methods are best han-
dled without throwing exceptions. This can be done by using if statements to check for errors.
When should you use a try-catch block in the code? Use it when you have to deal with 
unexpected error conditions. Do not use a try-catch block to deal with simple, expected 
situations. For example, the following code
try {
  System.out.println(refVar.toString());
}
catch (NullPointerException ex) {
  System.out.println("refVar is null");
}
is better replaced by
if (refVar != null)
  System.out.println(refVar.toString());
else
  System.out.println("refVar is null");
Which situations are exceptional and which are expected is sometimes difficult to decide. The 
point is not to abuse exception handling as a way to deal with a simple logic test.
12.22 The following method checks whether a string is a numeric string:
public static boolean isNumeric(String token) {
try {
    Double.parseDouble(token);
return true;
  }
catch (java.lang.NumberFormatException ex) {
return false;
  }
}
  Is it correct? Rewrite it without using exceptions.
12.7 Rethrowing Exceptions
Java allows an exception handler to rethrow the exception if the handler cannot 
process the exception or simply wants to let its caller be notified of the exception.
The syntax for rethrowing an exception may look like this:
try {
  statements;
}
catch (TheException ex) {
  perform operations before exits;
throw ex;
}
The statement throw ex  rethrows the exception to the caller so that other handlers in the 
caller get a chance to process the exception ex.
✓Point✓
Check
Key
Point
```

</details>


## PDF page 492

<details>
<summary>Page text</summary>

```text
12.8 Chained Exceptions  469
12.23 Suppose that statement2 causes an exception in the following statement:
try {
  statement1;
statement2;
  statement3;
}
catch (Exception1 ex1) {
}
catch (Exception2 ex2) {
throw ex2;
}
finally {
  statement4;
}
statement5;
  Answer the following questions:
■ If no exception occurs, will statement4 be executed, and will statement5 be 
executed?
■ If the exception is of type Exception1, will statement4 be executed, and will 
statement5 be executed?
■ If the exception is of type Exception2, will statement4 be executed, and will 
statement5 be executed?
■ If the exception is not Exception1 nor Exception2, will statement4 be exe-
cuted, and will statement5 be executed?
12.8 Chained Exceptions
Throwing an exception along with another exception forms a chained exception.
In the preceding section, the catch block rethrows the original exception. Sometimes, you 
may need to throw a new exception (with additional information) along with the original 
exception. This is called chained exceptions. Listing 12.9 illustrates how to create and throw 
chained exceptions.
LISTING 12.9 ChainedExceptionDemo.java
 1 public class ChainedExceptionDemo {
 2 public static void main(String[] args) {
 3 try {
 4        method1();
 5      }
 6 catch (Exception ex) {
 7 ex.printStackTrace();
 8      }
 9    }
10
11 public static void method1() throws Exception {
12 try {
13        method2();
14      }
15 catch (Exception ex) {
16 throw new Exception("New info from method1", ex);
17      }
18    }
✓Point✓
Check
Key
Point
chained exception
stack trace
chained exception
```

</details>


## PDF page 493

<details>
<summary>Page text</summary>

```text
470 Chapter 12  Exception Handling and Text I/O
19
20 public static void method2() throws Exception {
21 throw new Exception("New info from method2");
22    }
23  }
throw exception
java.lang.Exception: New info from method1
  at ChainedExceptionDemo.method1(ChainedExceptionDemo.java:16)
  at ChainedExceptionDemo.main(ChainedExceptionDemo.java:4)
Caused by: java.lang.Exception: New info from method2
  at ChainedExceptionDemo.method2(ChainedExceptionDemo.java:21)
  at ChainedExceptionDemo.method1(ChainedExceptionDemo.java:13)
  ... 1 more
The main method invokes method1 (line 4), method1 invokes method2 (line 13), and 
method2 throws an exception (line 21). This exception is caught in the catch block in 
method1 and is wrapped in a new exception in line 16. The new exception is thrown and 
caught in the catch block in the main method in line 6. The sample output shows the output 
from the printStackTrace() method in line 7. The new exception thrown from method1
is displayed first, followed by the original exception thrown from method2.
12.24 What would be the output if line 16 is replaced by the following line? 
throw new Exception(“New info from method1”);
12.9 Defining Custom Exception Classes
You can define a custom exception class by extending the java.lang.Exception
class. 
Java provides quite a few exception classes. Use them whenever possible instead of defining 
your own exception classes. However, if you run into a problem that cannot be adequately 
described by the predefined exception classes, you can create your own exception class, 
derived from Exception or from a subclass of Exception, such as IOException.
In Listing 12.7, CircleWithException.java, the setRadius method throws an exception if 
the radius is negative. Suppose you wish to pass the radius to the handler. In that case, you can 
define a custom exception class, as shown in Listing 12.10.
LISTING 12.10 InvalidRadiusException.java
 1 public class InvalidRadiusException extends Exception { 
 2 private double radius; 
 3
 4 /** Construct an exception */
 5 public InvalidRadiusException(double radius) { 
 6 super("Invalid radius " + radius); 
 7 this.radius = radius; 
 8    } 
 9
10 /** Return the radius */
11 public double getRadius() { 
12 return radius; 
13    } 
14  } 
This custom exception class extends java.lang.Exception (line 1). The Exception class 
extendsjava.lang.Throwable. All the methods (e.g., getMessage(),toString(), and 
✓Point✓
Check
Key
Point
Create custom exception 
classes
VideoNote
extendsException
```

</details>


## PDF page 494

<details>
<summary>Page text</summary>

```text
12.9 Defining Custom Exception Classes  471
printStackTrace()) in Exception are inherited from Throwable. The Exception
class contains four constructors. Among them, the following two constructors are often used:
java.lang.Exception
+Exception()
+Exception(message: String)
Constructs an exception with no message.
Constructs an exception with the specified message.
Line 6 invokes the superclass’s constructor with a message. This message will be set in the 
exception object and can be obtained by invoking getMessage() on the object.
Tip
Most exception classes in the Java API contain two constructors: a no-arg constructor 
and a constructor with a message parameter.
To create an InvalidRadiusException, you have to pass a radius. There-
fore, the setRadius method in Listing 12.7 can be modified as shown in Listing 12.11.
LISTING 12.11 TestCircleWithCustomException.java
 1 public class TestCircleWithCustomException { 
 2 public static void main(String[] args) { 
 3 try { 
 4 new CircleWithCustomException(5);
 5 new CircleWithCustomException(-5);
 6 new CircleWithCustomException(0);
 7      } 
 8 catch (InvalidRadiusException ex) { 
 9        System.out.println(ex); 
10      } 
11
12      System.out.println("Number of objects created: " +
13        CircleWithCustomException.getNumberOfObjects()); 
14    } 
15  } 
16
17 class CircleWithCustomException { 
18 /** The radius of the circle */
19 private double radius; 
20
21 /** The number of objects created */
22 private static int numberOfObjects = 0;
23
24 /** Construct a circle with radius 1 */
25 public CircleWithCustomException() throws InvalidRadiusException { 
26 this(1.0);
27    } 
28
29 /** Construct a circle with a specified radius */
30 public CircleWithCustomException(double newRadius)
31 throws InvalidRadiusException { 
32      setRadius(newRadius); 
33      numberOfObjects++; 
34    } 
35
36 /** Return radius */
37 public double getRadius() { 
declare exception
```

</details>


## PDF page 495

<details>
<summary>Page text</summary>

```text
472 Chapter 12  Exception Handling and Text I/O
38 return radius; 
39    } 
40
41 /** Set a new radius */
42 public void setRadius(double newRadius)
43 throws InvalidRadiusException { 
44 if (newRadius >= 0)
45        radius = newRadius; 
46 else
47 throw new InvalidRadiusException(newRadius);
48    } 
49
50 /** Return numberOfObjects */
51 public static int getNumberOfObjects() { 
52 return numberOfObjects; 
53    } 
54
55 /** Return the area of this circle */
56 public double findArea() { 
57 return radius * radius * 3.14159;
58    } 
59  }
throw exception
InvalidRadiusException: Invalid radius -5.0
Number of objects created: 1
ThesetRadius method in CircleWithCustomException throws an InvalidRadius-
Exception when radius is negative (line 47). Since InvalidRadiusException is a 
checked exception, the setRadius method must declare it in the method header (line 43). 
Since the constructors for CircleWithCustomException invoke the setRadius method 
to a set a new radius and it may throw an InvalidRadiusException, the constructors are 
declared to throw InvalidRadiusException (lines 25, 31).
Invokingnew CircleWithCustomException(-5) (line 5) throws an InvalidRadius-
Exception, which is caught by the handler. The handler displays the radius in the exception 
objectex.
Tip
Can you define a custom exception class by extending RuntimeException? Yes, but 
it is not a good way to go, because it makes your custom exception unchecked. It is bet-
ter to make a custom exception checked, so that the compiler can force these exceptions 
to be caught in your program.
12.25 How do you define a custom exception class?
12.26 Suppose the setRadius method throws the InValidRadiusException defined in 
Listing 12.10. What is displayed when the following program is run?
public class Test { 
public static void main(String[] args) {
try {
      method();
      System.out.println("After the method call");
    }
catch (RuntimeException ex) {
      System.out.println("RuntimeException in main");
    }
checked custom exception
✓Point✓
Check
```

</details>


## PDF page 496

<details>
<summary>Page text</summary>

```text
12.10 The File Class 473
catch (Exception ex) {
      System.out.println("Exception in main");
    }
  }
static void method() throws Exception {
try  {
      Circle c1 = new Circle(1);
      c1.setRadius(-1);
      System.out.println(c1.getRadius());
    }
catch (RuntimeException ex) { 
      System.out.println("RuntimeException in method()");
    }
catch (Exception ex) {
      System.out.println("Exception in method()");
throw ex;
    }
  }
}
12.10 The File Class
TheFile class contains the methods for obtaining the properties of a file/directory 
and for renaming and deleting a file/directory.
Having learned exception handling, you are ready to step into file processing. Data stored in 
the program are temporary; they are lost when the program terminates. To permanently store 
the data created in a program, you need to save them in a file on a disk or other permanent 
storage device. The file can then be transported and read later by other programs. Since data 
are stored in files, this section introduces how to use the File class to obtain file/directory 
properties, to delete and rename files/directories, and to create directories. The next section 
introduces how to read/write data from/to text files.
Every file is placed in a directory in the file system. An absolute file name  (or full 
name) contains a file name with its complete path and drive letter. For example, c:\book\
Welcome.java  is the absolute file name for the file Welcome.java  on the Windows 
operating system. Here c:\book  is referred to as the directory path  for the file. Absolute 
file names are machine dependent. On the UNIX platform, the absolute file name may 
be /home/liang/book/Welcome.java , where /home/liang/book  is the directory path for 
the file Welcome.java .
A relative file name  is in relation to the current working directory. The complete 
directory path for a relative file name is omitted. For example, Welcome.java  is a rela-
tive file name. If the current working directory is c:\book , the absolute file name would 
be c:\book\Welcome.java .
TheFile class is intended to provide an abstraction that deals with most of the machine-
dependent complexities of files and path names in a machine-independent fashion. The File
class contains the methods for obtaining file and directory properties and for renaming and 
deleting files and directories, as shown in Figure 12.6. However, the File class does not 
contain the methods for reading and writing file contents.
The file name is a string. The File class is a wrapper class for the file name and its direc-
tory path. For example, new File("c:\\book")  creates a File object for the directory 
c:\book , and new File("c:\\book\\test.dat")  creates a File  object for the 
file c:\book\test.dat , both on Windows. You can use the File class’s isDirectory()
method to check whether the object represents a directory, and the isFile() method to 
check whether the object represents a file.
Key
Point
why file?
absolute file name
directory path
relative file name
```

</details>


## PDF page 497

<details>
<summary>Page text</summary>

```text
474 Chapter 12  Exception Handling and Text I/O
Caution
The directory separator for Windows is a backslash  (\). The backslash is a special char-
acter in Java and should be written as \\ in a string literal (see Table 4.5).
Note
Constructing a File instance does not create a file on the machine . You can create a 
File instance for any file name regardless whether it exists or not. You can invoke the 
exists() method on a File instance to check whether the file exists.
Do not use absolute file names in your program. If you use a file name such as c:\\book\\
Welcome.java, it will work on Windows but not on other platforms. You should use a file 
name relative to the current directory. For example, you may create a File object using new
File("Welcome.java") for the file Welcome.java in the current directory. You may cre-
ate a File object using new File("image/us.gif") for the file us.gif under the image
directory in the current directory. The forward slash (/) is the Java directory separator, which 
\ in file names
relative file name
Java directory separator (/)
FIGURE 12.6 TheFile class can be used to obtain file and directory properties, to delete and rename files and directories, 
and to create directories.
java.io.File
+File(pathname: String)
+File(parent: String, child: String)
+File(parent: File, child: String)
+exists(): boolean
+canRead(): boolean
+canWrite(): boolean
+isDirectory(): boolean
+isFile(): boolean
+isAbsolute(): boolean
+isHidden(): boolean
+getAbsolutePath(): String
+getCanonicalPath(): String
+getName(): String
+getPath(): String
+getParent(): String
+lastModified(): long
+length(): long
+listFile(): File[]
+delete(): boolean
+renameTo(dest: File): boolean
+mkdir(): boolean
+mkdirs(): boolean
Creates aFile object for the specified path name. The path name may be a
directory or a file.
Creates aFile object for the child under the directory parent. The child may be
a file name or a subdirectory.
Creates aFile object for the child under the directory parent. The parent is a
File object. In the preceding constructor, the parent is a string.
Returns true if the file or the directory represented by the File object exists.
Returns true if the file represented by the File object exists and can be read.
Returns true if the file represented by the File object exists and can be written.
Returns true if the File object represents a directory.
Returns true if the File object represents a file.
Returns true if the File object is created using an absolute path name.
Returns true if the file represented in the File object is hidden. The exact
definition of hidden is system-dependent. On Windows, you can mark a file
hidden in the File Properties dialog box. On Unix systems, a file is hidden if
its name begins with a period(.) character.
Returns the complete absolute file or directory name represented by the File
object.
Returns the same as getAbsolutePath() except that it removes redundant
names, such as "." and "..", from the path name, resolves symbolic links (on
Unix), and converts drive letters to standard uppercase (on Windows).
Returns the last name of the complete directory and file name represented by
theFile object. For example, newFile("c:\\book\\test.dat").getName() returns
test.dat.
Returns the complete directory and file name represented by the File object.
 For example, new File("c:\\book\\test.dat").getPath() returns c:\book\test.dat.
Returns the complete parent directory of the current directory or the file
represented by theFile object. For example, new
File("c:\\book\\test.dat").getParent() returnsc:\book.
Returns the time that the file was last modified.
Returns the size of the file, or 0 if it does not exist or if it is a directory.
Returns the files under the directory for a directory File object.
Deletes the file or directory represented by this File object.The method returns
    true if the deletion succeeds.
Renames the file or directory represented by this File object to the specified name
    represented in dest. The method returns true if the operation succeeds.
Creates a directory represented in this File object. Returns true if the the directory is
    created successfully.
Same as mkdir() except that it creates directory along with its parent directories if
    the parent directories do not exist.
```

</details>


## PDF page 498

<details>
<summary>Page text</summary>

```text
is the same as on UNIX. The statement new File("image/us.gif") works on Windows, 
UNIX, and any other platform. 
Listing 12.12 demonstrates how to create a File object and use the methods in the File
class to obtain its properties. The program creates a File object for the file us.gif. This file is 
stored under the image directory in the current directory.
LISTING 12.12 TestFileClass.java
 1 public class TestFileClass {
 2 public static void main(String[] args) {
 3 java.io.File file = new java.io.File("image/us.gif");
 4      System.out.println("Does it exist? " + file.exists());
 5      System.out.println("The file has " + file.length() + " bytes");
 6      System.out.println("Can it be read? " + file.canRead());
 7      System.out.println("Can it be written? " + file.canWrite());
 8      System.out.println("Is it a directory? " + file.isDirectory());
 9      System.out.println("Is it a file? " + file.isFile());
10      System.out.println("Is it absolute? " + file.isAbsolute());
11      System.out.println("Is it hidden? " + file.isHidden());
12      System.out.println("Absolute path is " +
13        file.getAbsolutePath());
14      System.out.println("Last modified on " +
15 new java.util.Date(file.lastModified()));
16    }
17  }
The lastModified() method returns the date and time when the file was last modified, 
measured in milliseconds since the beginning of UNIX time (00:00:00 GMT, January 1, 
1970). The Date class is used to display it in a readable format in lines 14–15.
Figure 12.7a shows a sample run of the program on Windows, and Figure 12.7b, a sample 
run on UNIX. As shown in the figures, the path-naming conventions on Windows are differ-
ent from those on UNIX.
create a File
exists()
length()
canRead()
canWrite()
isDirectory()
isFile()
isAbsolute()
isHidden()
getAbsolutePath()
lastModified()
FIGURE 12.7 The program creates a File object and displays file properties.
(a) On Windows (b) On UNIX
12.27 What is wrong about creating a File object using the following statement?
new File("c:\book\test.dat");
12.28 How do you check whether a file already exists? How do you delete a file? How do 
you rename a file? Can you find the file size (the number of bytes) using the File
class? How do you create a directory?
12.29 Can you use the File class for I/O? Does creating a File object create a file on the disk?
✓Point✓
Check
12.10 The File Class 475
```

</details>


## PDF page 499

<details>
<summary>Page text</summary>

```text
476 Chapter 12  Exception Handling and Text I/O
12.11 File Input and Output
Use the Scanner class for reading text data from a file and the PrintWriter class 
for writing text data to a file. 
AFile object encapsulates the properties of a file or a path, but it does not contain the meth-
ods for creating a file or for writing/reading data to/from a file (referred to as data input and 
output, or I/O for short). In order to perform I/O, you need to create objects using appropri-
ate Java I/O classes. The objects contain the methods for reading/writing data from/to a file. 
There are two types of files: text and binary. Text files are essentially characters on disk. This 
section introduces how to read/write strings and numeric values from/to a text file using the 
Scanner and PrintWriter classes. Binary files will be introduced in Chapter 17.
12.11.1 Writing Data Using PrintWriter
The java.io.PrintWriter class can be used to create a file and write data to a text file. 
First, you have to create a PrintWriter object for a text file as follows:
PrintWriter output = new PrintWriter(filename);
Then, you can invoke the print,println, and printf methods on the PrintWriter object 
to write data to a file. Figure 12.8 summarizes frequently used methods in PrintWriter.
Key
Point
Write and read data
VideoNote
FIGURE 12.8 ThePrintWriter class contains the methods for writing data to a text file.
java.io.PrintWriter
Creates a PrintWriter object for the specified file-name string.
Writes a string to the file.
Creates a PrintWriter object for the specified file object.
Writes a character to the file.
Writes an array of characters to the file.
Writes an int value to the file.
Writes a long value to the file.
Writes a float value to the file.
Writes a double value to the file.
Writes a boolean value to the file.
Aprintln method acts like a print method; additionally, it
    prints a line separator. The line-separator string is defined
    by the system. It is \r\n on Windows and \n on Unix.
Theprintf method was introduced in §4.6, “Formatting
    Console Output.”
+PrintWriter(filename: String)
+print(s: String): void
+PrintWriter(file: File)
+print(c: char): void
+print(cArray: char[]): void
+print(i: int): void
+print(l: long): void
+print(f: float): void
+print(d: double): void
+print(b: boolean): void
Also contains the overloaded
 println methods.
Also contains the overloaded
 printf methods.
Listing 12.13 gives an example that creates an instance of PrintWriter and writes two 
lines to the file scores.txt. Each line consists of a first name (a string), a middle-name initial 
(a character), a last name (a string), and a score (an integer). 
LISTING 12.13 WriteData.java
throws an exception
createFile object
file exist?
 1 public class WriteData {
 2 public static void main(String[] args) throws IOException {
 3     java.io.File file = new java.io.File("scores.txt");
 4 if (file.exists()) {
 5       System.out.println("File already exists");
 6       System.exit(1);
 7}
8
```

</details>


## PDF page 500

<details>
<summary>Page text</summary>

```text
12.11 File Input and Output  477
Lines 4–7 check whether the file scores.txt exists. If so, exit the program (line 6).
Invoking the constructor of PrintWriter will create a new file if the file does not exist. If the 
file already exists, the current content in the file will be discarded without verifying with the user. 
Invoking the constructor of PrintWriter may throw an I/O exception. Java forces you to write 
the code to deal with this type of exception. For simplicity, we declare throws IOException in 
the main method header (line 2).
You have used the System.out.print, System.out.println, and System.out.
printf methods to write text to the console. System.out is a standard Java object for the 
console output. You can create PrintWriter objects for writing text to any file using print,
println, and printf (lines 13–16). 
Theclose() method must be used to close the file (line 19). If this method is not invoked, 
the data may not be saved properly in the file.
12.11.2 Closing Resources Automatically Using try-with-resources
Programmers often forget to close the file. JDK 7 provides the followings new try-with-
resources syntax that automatically closes the files. 
try (declare and create resources) {
  Use the resource to process the file;
}
Using the try-with-resources syntax, we rewrite the code in Listing 12.13 in Listing 12.14.
LISTING 12.14 WriteDataWithAutoClose.java
 1 public class WriteDataWithAutoClose {
 2 public static void main(String[] args) throws Exception {
 3      java.io.File file = new java.io.File("scores.txt");
 4 if (file.exists()) {
 5        System.out.println("File already exists");
 6        System.exit(0);
 7      }
 8
 9 try (
10 // Create a file
11 java.io.PrintWriter output = new java.io.PrintWriter(file);
12      ) {
13 // Write formatted output to the file
14        output.print("John T Smith ");
15        output.println(90);
16        output.print("Eric K Jones ");
17        output.println(85);
18      }
19    }
20  }
createPrintWriter
print data
close file
create a file
throws IOException
print method
close file
declare/create resource
use the resouce
John T Smith 90 
Eric K Jones 85 
scores.txt
 9 // Create a file
10     java.io.PrintWriter output = new java.io.PrintWriter(file);
11
12 // Write formatted output to the file
13     output.print("John T Smith ");
14     output.println(90);
15     output.print("Eric K Jones ");
16     output.println(85);
17
18 // Close the file
19     output.close();
20 }
21 }
```

</details>


## PDF page 501

<details>
<summary>Page text</summary>

```text
478 Chapter 12  Exception Handling and Text I/O
A resource is declared and created followed by the keyword try. Note that the resources are 
enclosed in the parentheses (lines 9–12). The resources must be a subtype of AutoCloseable
such as a PrinterWriter that has the close() method. A resource must be declared and 
created in the same statement and multiple resources can be declared and created inside the 
parentheses. The statements in the block (lines 12–18) immediately following the resource 
declaration use the resource. After the block is finished, the resource’s close() method 
is automatically invoked to close the resource. Using try-with-resources can not only avoid 
errors but also make the code simpler.
12.11.3 Reading Data Using Scanner
Thejava.util.Scanner class was used to read strings and primitive values from the con-
sole in Section 2.3, Reading Input from the Console. A Scanner breaks its input into tokens 
delimited by whitespace characters. To read from the keyboard, you create a Scanner for 
System.in, as follows:
Scanner input = new Scanner(System.in);
To read from a file, create a Scanner for a file, as follows:
Scanner input = new Scanner(new File(filename));
Figure 12.9 summarizes frequently used methods in Scanner.
FIGURE 12.9 TheScanner class contains the methods for scanning data.
java.util.Scanner
+Scanner(source: File)
+Scanner(source: String)
+close()
+hasNext(): boolean
+next(): String
+nextLine(): String
+nextByte(): byte
+nextShort(): short
+nextInt(): int
+nextLong(): long
+nextFloat(): float
+nextDouble(): double
+useDelimiter(pattern: String):
Scanner
Creates aScanner that scans tokens from the specified file.
Creates aScanner that scans tokens from the specified string.
Closes this scanner.
Returns true if this scanner has more data to be read.
Returns next token as a string from this scanner.
Returns a line ending with the line separator from this scanner.
Returns next token as a byte from this scanner.
Returns next token as a short from this scanner.
Returns next token as an int from this scanner.
Returns next token as a long from this scanner.
Returns next token as a float from this scanner.
Returns next token as a double from this scanner.
Sets this scanner’s delimiting pattern and returns this scanner.
Listing 12.15 gives an example that creates an instance of Scanner and reads data from 
the file scores.txt.
LISTING 12.15 ReadData.java
create a File
create a Scanner
 1 import java.util.Scanner;
2
 3 public class ReadData {
 4 public static void main(String[] args) throws Exception {
 5 // Create a File instance
 6     java.io.File file = new java.io.File("scores.txt");
7
 8 // Create a Scanner for the file
 9     Scanner input = new Scanner(file);
```

</details>


## PDF page 502

<details>
<summary>Page text</summary>

```text
12.11 File Input and Output  479
Note that new Scanner(String) creates a Scanner for a given string. To create a Scanner
to read data from a file, you have to use the java.io.File class to create an instance of the 
File using the constructor new File(filename) (line 6), and use new Scanner(File)
to create a Scanner for the file (line 9).
Invoking the constructor new Scanner(File) may throw an I/O exception, so the main
method declares throws Exception in line 4.
Each iteration in the while loop reads the first name, middle initial, last name, and score 
from the text file (lines 12–19). The file is closed in line 22.
It is not necessary to close the input file (line 22), but it is a good practice to do so to release 
the resources occupied by the file. You can rewrite this program using the try-with-resources 
syntax. See www.cs.armstrong.edu/liang/intro10e/html/ReadDataWithAutoClose.html.
12.11.4 How Does Scanner Work?
The nextByte(), nextShort(), nextInt(), nextLong(), nextFloat(), next-
Double(), and next() methods are known as token-reading methods , because they read 
tokens separated by delimiters. By default, the delimiters are whitespace characters. You 
can use the useDelimiter(String regex)  method to set a new pattern for delimiters.
How does an input method work? A token-reading method first skips any delimiters (whites-
pace characters by default), then reads a token ending at a delimiter. The token is then auto-
matically converted into a value of the byte,short,int,long,float, or double type for 
nextByte(), nextShort(), nextInt(), nextLong(), nextFloat(), and nextDou-
ble(), respectively. For the next() method, no conversion is performed. If the token does 
not match the expected type, a runtime exception java.util.InputMismatchException
will be thrown. 
Both methods next() and nextLine() read a string. The next() method reads a string 
delimited by delimiters, and nextLine() reads a line ending with a line separator.
Note
The line-separator string is defined by the system. It is \r\n on Windows and \n on 
UNIX. To get the line separator on a particular platform, use
String lineSeparator = System.getProperty("line.separator");
If you enter input from a keyboard, a line ends with the Enter key, which corresponds 
to the \n character.
The token-reading method does not read the delimiter after the token. If the nextLine()
method is invoked after a token-reading method, this method reads characters that start from 
this delimiter and end with the line separator. The line separator is read, but it is not part of the 
string returned by nextLine().
has next?
read items
close file
File class
throws Exception
close file
token-reading method
change delimiter
InputMismatchException
next() vs. nextLine()
line separator
behavior of nextLine()
10
11 // Read data from a file
12 while (input.hasNext()) {
13       String firstName = input.next();
14       String mi = input.next();
15       String lastName = input.next();
16 int score = input.nextInt();
17       System.out.println(
18         firstName + ""  + mi + ""  + lastName + ""  + score);
19 }
20
21 // Close the file
22     input.close();
23 }
24 }
John T Smith 90 
Eric K Jones 85
scores.txt
```

</details>


## PDF page 503

<details>
<summary>Page text</summary>

```text
480 Chapter 12  Exception Handling and Text I/O
Suppose a text file named test.txt contains a line
34 567
After the following code is executed,
Scanner input = new Scanner(new File("test.txt"));
int intValue = input.nextInt();
String line = input.nextLine();
intValue contains 34 and line contains the characters ' ',5,6, and 7.
What happens if the input is entered from the keyboard? Suppose you enter 34, press the 
Enter key, then enter 567 and press the Enter key for the following code:
Scanner input = new Scanner(System.in);
int intValue = input.nextInt();
String line = input.nextLine();
You will get 34 in intValue and an empty string in line. Why? Here is the reason. The 
token-reading method nextInt() reads in 34 and stops at the delimiter, which in this case is 
a line separator (the Enter key). The nextLine() method ends after reading the line separa-
tor and returns the string read before the line separator. Since there are no characters before 
the line separator, line is empty.
You can read data from a file or from the keyboard using the Scanner class. You can also 
scan data from a string using the Scanner class. For example, the following code 
Scanner input = new Scanner("13 14");
int sum = input.nextInt() + input.nextInt();
System.out.println("Sum is " + sum);
displays
The sum is 27
12.11.5 Case Study: Replacing Text
Suppose you are to write a program named ReplaceText that replaces all occurrences of a 
string in a text file with a new string. The file name and strings are passed as command-line 
arguments as follows:
java ReplaceText sourceFile targetFile oldString newString
For example, invoking
java ReplaceText FormatString.java t.txt StringBuilder StringBuffer
replaces all the occurrences of StringBuilder by StringBuffer in the file FormatString
.java and saves the new file in t.txt.
Listing 12.16 gives the program. The program checks the number of arguments passed to 
themain method (lines 7–11), checks whether the source and target files exist (lines 14–25), 
creates a Scanner for the source file (line 29), creates a PrintWriter for the target file 
(line 30), and repeatedly reads a line from the source file (line 33), replaces the text (line 34), 
and writes a new line to the target file (line 35).
LISTING 12.16 ReplaceText.java
 1 import java.io.*;
 2 import java.util.*;
 3
input from file
input from keyboard
scan a string
```

</details>


## PDF page 504

<details>
<summary>Page text</summary>

```text
12.11 File Input and Output  481
 4 public class ReplaceText {
 5 public static void main(String[] args) throws Exception {
 6 // Check command line parameter usage
 7 if (args.length != 4) {
 8        System.out.println(
 9 "Usage: java ReplaceText sourceFile targetFile oldStr newStr");
10        System.exit(1);
11      }
12
13 // Check if source file exists
14 File sourceFile = new File(args[0]);
15 if (!sourceFile.exists()) {
16        System.out.println("Source file " + args[0] + " does not exist");
17        System.exit(2);
18      }
19
20 // Check if target file exists
21 File targetFile = new File(args[1]);
22 if (targetFile.exists()) {
23        System.out.println("Target file " + args[1] + " already exists");
24        System.exit(3);
25      }
26
27 try (
28 // Create input and output files
29 Scanner input = new Scanner(sourceFile);
30 PrintWriter output = new PrintWriter(targetFile);
31      ) {
32 while (input.hasNext()) {
33          String s1 = input.nextLine();
34 String s2 = s1.replaceAll(args[ 2], args[3]);
35          output.println(s2);
36        }
37      }
38    }
39  }
In a normal situation, the program is terminated after a file is copied. The program is 
terminated abnormally if the command-line arguments are not used properly (lines 7–11), 
if the source file does not exist (lines 14–18), or if the target file already exists (lines 
22–25). The exit status code 1, 2, and 3 are used to indicate these abnormal terminations 
(lines 10, 17, 24). 
12.30 How do you create a PrintWriter to write data to a file? What is the reason to 
declarethrows Exception in the main method in Listing 12.13, WriteData.java? 
What would happen if the close() method were not invoked in Listing 12.13?
12.31 Show the contents of the file temp.txt after the following program is executed.
public class Test {
public static void main(String[] args) throws Exception {
    java.io.PrintWriter output = new
      java.io.PrintWriter("temp.txt");
    output.printf("amount is %f %e\r\n", 32.32, 32.32);
    output.printf("amount is %5.4f %5.4e\r\n", 32.32, 32.32);
    output.printf("%6b\r\n", (1 > 2));
    output.printf("%6s\r\n", "Java");
    output.close();
  }
}
check command usage
source file exists?
target file exists?
try-with-resources
create a Scanner
create a PrintWriter
has next?
read a line
✓Point✓
Check
```

</details>


## PDF page 505

<details>
<summary>Page text</summary>

```text
482 Chapter 12  Exception Handling and Text I/O
12.32 Rewrite the code in the preceding question using a try-with-resources syntax.  
12.33 How do you create a Scanner to read data from a file? What is the reason to define 
throws Exception  in the main method in Listing 12.15, ReadData.java? What 
would happen if the close() method were not invoked in Listing 12.15?
12.34 What will happen if you attempt to create a Scanner for a nonexistent file? What 
will happen if you attempt to create a PrintWriter for an existing file?
12.35 Is the line separator the same on all platforms? What is the line separator on Windows?
12.36 Suppose you enter 45 57.8 789, then press the Enter key. Show the contents of the 
variables after the following code is executed.
Scanner input = new Scanner(System.in);
int intValue = input.nextInt();
double doubleValue = input.nextDouble();
String line = input.nextLine();
12.37 Suppose you enter 45, press the Enter key, 57.8, press the Enter key, 789, and press 
the Enter key. Show the contents of the variables after the following code is executed.
Scanner input = new Scanner(System.in);
int intValue = input.nextInt();
double doubleValue = input.nextDouble();
String line = input.nextLine();
12.12 Reading Data from the Web
Just like you can read data from a file on your computer, you can read data from a file 
on the Web.
In addition to reading data from a local file on a computer or file server, you can also access 
data from a file that is on the Web if you know the file’s URL (Uniform Resource Locator—
the unique address for a file on the Web). For example, www.google.com/index.html is the URL 
for the file index.html located on the Google Web server. When you enter the URL in a Web 
browser, the Web server sends the data to your browser, which renders the data graphically. 
Figure 12.10 illustrates how this process works.
Key
Point
FIGURE 12.10 The client retrieves files from a Web server.
Internet
Client Server
Web
Server
Local files
Web
Browser
Application
Program
For an application program to read data from a URL, you first need to create a URL object 
using the java.net.URL class with this constructor:
public URL(String spec) throws MalformedURLException
For example, the following statement creates a URL object for http://www.google.com/index.html.
 1 try {
 2    URL url = new URL("http://www.google.com/index.html");
 3  }
```

</details>


## PDF page 506

<details>
<summary>Page text</summary>

```text
12.12 Reading Data from the Web  483
 4 catch (MalformedURLException ex) {
 5    ex.printStackTrace(); 
 6  }
AMalformedURLException is thrown if the URL string has a syntax error. For example, 
the URL string “ http:www.google.com/index.html” would cause a MalformedURLException
runtime error because two slashes (//) are required after the colon (:). Note that the http://
prefix is required for the URL class to recognize a valid URL. It would be wrong if you replace 
line 2 with the following code:
URL url = new URL("www.google.com/index.html");
After a URL object is created, you can use the openStream() method defined in the URL class 
to open an input stream and use this stream to create a Scanner object as follows:
Scanner input = new Scanner(url.openStream());
Now you can read the data from the input stream just like from a local file. The example in 
Listing 12.17 prompts the user to enter a URL and displays the size of the file.
LISTING 12.17 ReadFileFromURL.java
 1 import java.util.Scanner;
 2
 3 public class ReadFileFromURL {
 4 public static void main(String[] args) {
 5      System.out.print("Enter a URL: ");
 6 String URLString = new Scanner(System.in).next();
 7
 8 try {
 9 java.net.URL url = new java.net.URL(URLString);
10 int count = 0;
11 Scanner input = new Scanner(url.openStream());
12 while (input.hasNext()) {
13 String line = input.nextLine();
14          count += line.length();
15        } 
16
17        System.out.println("The file size is " + count + " characters");
18      }
19 catch (java.net.MalformedURLException ex) {
20        System.out.println("Invalid URL");
21      }
22 catch (java.io.IOException ex) {
23        System.out.println("I/O Errors: no such file");
24      }
25    }
26  }
enter a URL
create a URL object
create a Scanner object
more to read?
read a line
MalformedURLException
IOException
Enter a URL: http://cs.armstrong.edu/liang/data/Lincoln.txt
The file size is 1469 characters
Enter a URL: http://www.yahoo.com
The file size is 190006 characters
```

</details>


## PDF page 507

<details>
<summary>Page text</summary>

```text
484 Chapter 12  Exception Handling and Text I/O
The program prompts the user to enter a URL string (line 6) and creates a URL object (line 9). 
The constructor will throw a java.net.MalformedURLException (line 19) if the URL 
isn’t formed correctly. 
The program creates a Scanner object from the input stream for the URL (line 11). If the 
URL is formed correctly but does not exist, an IOException will be thrown (line 22). For 
example, http://google.com/index1.html uses the appropriate form, but the URL itself does not 
exist. An IOException would be thrown if this URL was used for this program.
12.38 How do you create a Scanner object for reading text from a URL?
12.13 Case Study: Web Crawler
This case study develops a program that travels the Web by following hyperlinks.
The World Wide Web, abbreviated as WWW, W3, or Web, is a system of interlinked hyper-
text documents on the Internet. With a Web browser, you can view a document and follow 
the hyperlinks to view other documents. In this case study, we will develop a program that 
automatically traverses the documents on the Web by following the hyperlinks. This type of 
program is commonly known as a Web crawler. For simplicity, our program follows for the 
hyperlink that starts with http://. Figure 12.11 shows an example of traversing the Web. 
We start from a Web page that contains three URLs named URL1,URL2, and URL3. Following 
URL1 leads to the page that contains three URLs named URL11,URL12, and URL13. Follow-
ingURL2 leads to the page that contains two URLs named URL21 and URL22. Following URL3
leads to the page that contains four URLs named URL31, URL32, and URL33, and URL34.
Continue to traverse the Web following the new hyperlinks. As you see, this process may 
continue forever, but we will exit the program once we have traversed 100 pages.
MalformedURLException
✓Point✓
Check
Key
Point
Web crawler
FIGURE 12.11 The client retrieves files from a Web server.
URL1
URL2
URL3
Starting URL
URL11
URL12
URL13
URL1
URL31
URL32
URL33 URL4
URL3
URL21
URL22
URL2
……… … … … … … …
The program follows the URLs to traverse the Web. To ensure that each URL is traversed 
only once, the program maintains two lists of URLs. One list stores the URLs pending for 
traversing and the other stores the URLs that have already been traversed. The algorithm for 
this program can be described as follows:
Add the starting URL to a list named listOfPendingURLs; 
while listOfPendingURLs is not empty and size of listOfTraversedURLs 
<= 100 {
```

</details>


## PDF page 508

<details>
<summary>Page text</summary>

```text
12.13 Case Study: Web Crawler  485
  Remove a URL from listOfPendingURLs;
  if this URL is not in listOfTraversedURLs {
    Add it to listOfTraversedURLs;
    Display this URL;
    Read the page from this URL and for each URL contained in the page {
      Add it to listOfPendingURLs if it is not in listOfTraversedURLs; 
    }
  }
}
Listing 12.18 gives the program that implements this algorithm.
LISTING 12.18 WebCrawler.java
 1 import java.util.Scanner;
 2 import java.util.ArrayList;
 3
 4 public class WebCrawler {
 5 public static void main(String[] args) {
 6      java.util.Scanner input = new java.util.Scanner(System.in);
 7      System.out.print("Enter a URL: ");
 8      String url = input.nextLine();
 9 crawler(url); // Traverse the Web from the a starting url
10    }
11
12 public static void crawler(String startingURL) {
13      ArrayList<String> listOfPendingURLs = new ArrayList<>();
14      ArrayList<String> listOfTraversedURLs = new ArrayList<>();
15
16 listOfPendingURLs.add(startingURL);
17 while (!listOfPendingURLs.isEmpty() && 
18          listOfTraversedURLs.size() <= 100) {
19        String urlString = listOfPendingURLs.remove(0);
20 if (!listOfTraversedURLs.contains(urlString)) {
21 listOfTraversedURLs.add(urlString);
22          System.out.println("Craw " + urlString);
23
24 for (String s: getSubURLs(urlString)) {
25 if (!listOfTraversedURLs.contains(s))
26 listOfPendingURLs.add(s);
27          }
28        }
29      }
30    }
31
32 public static ArrayList<String> getSubURLs(String urlString) {
33      ArrayList<String> list = new ArrayList<>();
34
35 try {
36        java.net.URL url = new java.net.URL(urlString); 
37        Scanner input = new Scanner(url.openStream());
38 int current = 0;
39 while (input.hasNext()) {
40          String line = input.nextLine();
41          current = line.indexOf("http:", current); 
42 while (current > 0) {
43 int endIndex = line.indexOf("\"", current);
44 if (endIndex > 0) { // Ensure that a correct URL is found
45 list.add(line.substring(current, endIndex));
46              current = line.indexOf("http:", endIndex); 
47            }
enter a URL
craw from this URL
list of pending URLs
list of traversed URLs
add starting URL
get the first URL
URL traversed
add a new URL
read a line
search for a URL
end of a URL
extract a URL
search for next URL
URL ends with "
```

</details>


## PDF page 509

<details>
<summary>Page text</summary>

```text
486 Chapter 12  Exception Handling and Text I/O
48 else
49              current = -1;
50          }
51        } 
52      }
53 catch (Exception ex) {
54        System.out.println("Error: " + ex.getMessage());
55      }
56
57 return list;
58    }
59  }
return URLs
KEY TERMS
absolute file name 473
chained exception 469
checked exception 457
declare exception 458
directory path 473
exception 450
exception propagation 459
relative file name 473
throw exception 452
unchecked exception 457
Enter a URL: http://cs.armstrong.edu/liang
Enter a URL: http://www.cs.armstrong.edu/liang
Craw http://www.cs.armstrong.edu/liang
Craw http://www.cs.armstrong.edu
Craw http://www.armstrong.edu
Craw http://www.pearsonhighered.com/liang
...
The program prompts the user to enter a starting URL (lines 7–8) and invokes the 
crawler(url) method to traverse the web (line 9).
Thecrawler(url) method adds the starting url to listOfPendingURLs (line 16) and 
repeatedly processes each URL in listOfPendingURLs in a while loop (lines 17–29). It 
removes the first URL in the list (line 19) and processes the URL if it has not been processed 
(lines 20–28). To process each URL, the program first adds the URL to listOfTraversed-
URLs (line 21). This list stores all the URLs that have been processed. The getSubURLs(url)
method returns a list of URLs in the Web page for the specified URL (line 24). The program 
uses a foreach loop to add each URL in the page into listOfPendingURLs if it is not in  
listOfTraversedURLs (lines 24–26).
The getSubURLs(url) method reads each line from the Web page (line 40) and searches 
for the URLs in the line (line 41). Note that a correct URL cannot contain line break charac-
ters. So it is sufficient to limit the search for a URL in one line of the text in a Web page. For 
simplicity, we assume that a URL ends with a quotation mark " (line 43). The method obtains 
a URL and adds it to a list (line 45). A line may contain multiple URLs. The method continues 
to search for the next URL (line 46). If no URL is found in the line, current is set to -1 (line 
49). The URLs contained in the page are returned in the form of a list (line 57).
The program terminates when the number of traversed URLs reaches to 100 (line 18).
This is a simple program to traverse the Web. Later you will learn the techniques to make 
the program more efficient and robust.
12.39 Before a URL is added to listOfPendingURLs, line 25 checks whether it has been 
traversed. Is it possible that listOfPendingURLs contains duplicate URLs? If so, 
give an example.
✓Point✓
Check
```

</details>


## PDF page 510

<details>
<summary>Page text</summary>

```text
Chapter Summary  487
CHAPTER SUMMARY
1. Exception handling enables a method to throw an exception to its caller.
2. A Java exception is an instance of a class derived from java.lang.Throwable.
Java provides a number of predefined exception classes, such as Error, Exception,
RuntimeException, ClassNotFoundException, NullPointerException, and 
ArithmeticException. You can also define your own exception class by extending 
Exception.
3. Exceptions occur during the execution of a method. RuntimeException and Error
are unchecked exceptions; all other exceptions are checked.
4. When declaring a method, you have to declare a checked exception if the method might 
throw it, thus telling the compiler what can go wrong.
5. The keyword for declaring an exception is throws, and the keyword for throwing an 
exception is throw.
6. To invoke the method that declares checked exceptions, enclose it in a try statement. 
When an exception occurs during the execution of the method, the catch block catches 
and handles the exception.
7. If an exception is not caught in the current method, it is passed to its caller. The process 
is repeated until the exception is caught or passed to the main method.
8. Various exception classes can be derived from a common superclass. If a catch block 
catches the exception objects of a superclass, it can also catch all the exception objects 
of the subclasses of that superclass.
9. The order in which exceptions are specified in a catch block is important. A compile 
error will result if you specify an exception object of a class after an exception object of 
the superclass of that class.
10. When an exception occurs in a method, the method exits immediately if it does not 
catch the exception. If the method is required to perform some task before exiting, you 
can catch the exception in the method and then rethrow it to its caller.
11. The code in the finally block is executed under all circumstances, regardless of whether 
an exception occurs in the try block or whether an exception is caught if it occurs.
12. Exception handling separates error-handling code from normal programming tasks, 
thus making programs easier to read and to modify.
13. Exception handling should not be used to replace simple tests. You should perform 
simple test using if statements whenever possible, and reserve exception handling for 
dealing with situations that cannot be handled with if statements.
14. TheFile class is used to obtain file properties and manipulate files. It does not contain 
the methods for creating a file or for reading/writing data from/to a file.
15. You can use Scanner to read string and primitive data values from a text file and use 
PrintWriter to create a file and write data to a text file.
16. You can read from a file on the Web using the URL class.
```

</details>


## PDF page 511

<details>
<summary>Page text</summary>

```text
488 Chapter 12  Exception Handling and Text I/O
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
Sections 12.2–12.9
*12.1 (NumberFormatException) Listing 7.9, Calculator.java, is a simple command-
line calculator. Note that the program terminates if any operand is nonnumeric.
Write a program with an exception handler that deals with nonnumeric operands; 
then write another program without using an exception handler to achieve the 
same objective. Your program should display a message that informs the user of 
the wrong operand type before exiting (see Figure 12.12).
FIGURE 12.12 The program performs arithmetic operations and detects input errors.
*12.2 (InputMismatchException) Write a program that prompts the user to read 
two integers and displays their sum. Your program should prompt the user to 
read the number again if the input is incorrect.
*12.3 (ArrayIndexOutOfBoundsException) Write a program that meets the fol-
lowing requirements:
■ Creates an array with 100 randomly chosen integers.
■ Prompts the user to enter the index of the array, then displays the corre-
sponding element value. If the specified index is out of bounds, display the 
message Out of Bounds.
*12.4 (IllegalArgumentException) Modify the Loan class in Listing 10.2 to 
throw IllegalArgumentException if the loan amount, interest rate, or 
number of years is less than or equal to zero.
*12.5 (IllegalTriangleException) Programming Exercise 11.1 defined the 
Triangle class with three sides. In a triangle, the sum of any two sides is 
greater than the other side. The Triangle class must adhere to this rule. 
Create the IllegalTriangleException class, and modify the constructor 
of the Triangle class to throw an IllegalTriangleException object if a 
triangle is created with sides that violate the rule, as follows:
/** Construct a triangle with the specified sides */
public Triangle(double side1, double side2, double side3)
throws IllegalTriangleException {
// Implement it
  }
```

</details>


## PDF page 512

<details>
<summary>Page text</summary>

```text
Programming Exercises  489
*12.6 (NumberFormatException) Listing 6.8 implements the hex2Dec(String 
hexString) method, which converts a hex string into a decimal number.
Implement the hex2Dec method to throw a NumberFormatException if the 
string is not a hex string.
*12.7 (NumberFormatException) Write the bin2Dec(String binaryString)
method to convert a binary string into a decimal number. Implement the 
bin2Dec method to throw a NumberFormatException if the string is not a 
binary string.
*12.8 (HexFormatException) Exercise 12.6 implements the hex2Dec method to 
throw a NumberFormatException if the string is not a hex string. Define 
a custom exception called HexFormatException. Implement the hex2Dec
method to throw a HexFormatException if the string is not a hex string.
*12.9 (BinaryFormatException) Exercise 12.7 implements the bin2Dec method 
to throw a BinaryFormatException if the string is not a binary string. 
Define a custom exception called BinaryFormatException. Implement the 
bin2Dec method to throw a BinaryFormatException if the string is not a 
binary string.
*12.10 (OutOfMemoryError) Write a program that causes the JVM to throw an 
OutOfMemoryError and catches and handles this error.
Sections 12.10–12.12
**12.11 (Remove text) Write a program that removes all the occurrences of a specified 
string from a text file. For example, invoking
java Exercise12_11 John filename
  removes the string John from the specified file. Your program should get the 
arguments from the command line.
**12.12 (Reformat Java source code ) Write a program that converts the Java source 
code from the next-line brace style to the end-of-line brace style. For example, 
the following Java source in (a) uses the next-line brace style. Your program 
converts it to the end-of-line brace style in (b).
HexFormatException
VideoNote
public class Test
{
public static void main(String[] args)
  {
// Some statements
  }
}
(a) Next-line brace style
public class Test {
public static void main(String[] args) {
// Some statements
  }
}
(b) End-of-line brace style
  Your program can be invoked from the command line with the Java source-
code file as the argument. It converts the Java source code to a new format. For 
example, the following command converts the Java source-code file Test.java
to the end-of-line brace style.
java Exercise12_12 Test.java
*12.13 (Count characters, words, and lines in a file ) Write a program that will count 
the number of characters, words, and lines in a file. Words are separated by 
whitespace characters. The file name should be passed as a command-line 
argument, as shown in Figure 12.13.
```

</details>


## PDF page 513

<details>
<summary>Page text</summary>

```text
490 Chapter 12  Exception Handling and Text I/O
*12.14 (Process scores in a text file ) Suppose that a text file contains an unspecified 
number of scores separated by blanks. Write a program that prompts the user 
to enter the file, reads the scores from the file, and displays their total and 
average.
*12.15 (Write/read data) Write a program to create a file named Exercise12_15.txt if 
it does not exist. Write 100 integers created randomly into the file using text 
I/O. Integers are separated by spaces in the file. Read the data back from the 
file and display the data in increasing order.
**12.16 (Replace text) Listing 12.16, ReplaceText.java, gives a program that replaces 
text in a source file and saves the change into a new file. Revise the program to 
save the change into the original file. For example, invoking
java Exercise12_16 file oldString newString
  replaces oldString in the source file with newString.
***12.17 (Game: hangman) Rewrite Programming Exercise 7.35. The program reads the 
words stored in a text file named hangman.txt. Words are delimited by spaces.
**12.18 (Add package statement) Suppose you have Java source files under the direc-
torieschapter1,chapter2, . . . , chapter34. Write a program to insert the 
statementpackage chapteri; as the first line for each Java source file under 
the directory chapteri. Suppose chapter1, chapter2, . . . , chapter34
are under the root directory srcRootDirectory. The root directory and 
chapteri directory may contain other folders and files. Use the following 
command to run the program:
java Exercise12_18 srcRootDirectory
*12.19 (Count words) Write a program that counts the number of words in President 
Abraham Lincoln’s Gettysburg address from http://cs.armstrong.edu/liang/data/
Lincoln.txt.
**12.20 (Remove package statement ) Suppose you have Java source files under the 
directories chapter1, chapter2, . . . , chapter34. Write a program to 
remove the statement package chapteri;  in the first line for each Java 
source file under the directory chapteri. Suppose chapter1, chapter2,
. . . , chapter34 are under the root directory srcRootDirectory. The root 
directory and chapteri directory may contain other folders and files. Use 
the following command to run the program:
java Exercise12_20 srcRootDirectory
*12.21 (Data sorted?) Write a program that reads the strings from file SortedStrings.
txt and reports whether the strings in the files are stored in increasing order. 
FIGURE 12.13 The program displays the number of characters, words, and lines in the given 
file.
```

</details>


## PDF page 514

<details>
<summary>Page text</summary>

```text
Programming Exercises  491
If the strings are not sorted in the file, displays the first two strings that are out 
of the order.
**12.22 (Replace text) Revise Programming Exercise 12.16 to replace a string in a file 
with a new string for all files in the specified directory using the command:
java Exercise12_22 dir oldString newString
**12.23 (Process scores in a text file on the Web ) Suppose that the text file on the 
Web http://cs.armstrong.edu/liang/data/Scores.txt contains an unspecified number 
of scores. Write a program that reads the scores from the file and displays their 
total and average. Scores are separated by blanks.
*12.24 (Create large dataset) Create a data file with 1,000 lines. Each line in the file 
consists of a faculty member’s first name, last name, rank, and salary. The 
faculty member’s first name and last name for the ith line are FirstNamei and 
LastNamei. The rank is randomly generated as assistant, associate, and full. 
The salary is randomly generated as a number with two digits after the decimal 
point. The salary for an assistant professor should be in the range from 50,000 
to 80,000, for associate professor from 60,000 to 110,000, and for full professor 
from 75,000 to 130,000. Save the file in Salary.txt. Here are some sample data:
FirstName1 LastName1 assistant 60055.95
FirstName2 LastName2 associate 81112.45
. . .
FirstName1000 LastName1000 full 92255.21
*12.25 (Process large dataset ) A university posts its employees’ salaries at http://
cs.armstrong.edu/liang/data/Salary.txt. Each line in the file consists of a faculty 
member’s first name, last name, rank, and salary (see Programming Exercise 
12.24). Write a program to display the total salary for assistant professors, 
associate professors, full professors, and all faculty, respectively, and display 
the average salary for assistant professors, associate professors, full professors, 
and all faculty, respectively.
**12.26 (Create a directory) Write a program that prompts the user to enter a directory 
name and creates a directory using the File’smkdirs method. The program 
displays the message “Directory created successfully” if a directory is created 
or “Directory already exists” if the directory already exists.
**12.27 (Replace words ) Suppose you have a lot of files in a directory that contain 
words Exercisei_j, where i and j are digits. Write a program that pads a 0 
before i if i is a single digit and 0 before j if j is a single digit. For example, 
the word Exercise2_1 in a file will be replaced by Exercise02_01. In Java, 
when you pass the symbol * from the command line, it refers to all files in 
the directory (see Supplement III.V). Use the following command to run your 
program.
java Exercise12_27 *
**12.28 (Rename files) Suppose you have a lot of files in a directory named Exercisei_j,
where i and j are digits. Write a program that pads a 0 before i if i is a single 
digit. For example, a file named Exercise2_1 in a directory will be renamed to 
Exercise02_1. In Java, when you pass the symbol * from the command line, 
it refers to all files in the directory (see Supplement III.V). Use the following 
command to run your program.
java Exercise12_28 *
```

</details>


## PDF page 515

<details>
<summary>Page text</summary>

```text
492 Chapter 12  Exception Handling and Text I/O
**12.29 (Rename files) Suppose you have a lot of files in a directory named Exercisei_j,
where i and j are digits. Write a program that pads a 0 before j if j is a single 
digit. For example, a file named Exercise2_1 in a directory will be renamed to 
Exercise2_01. In Java, when you pass the symbol * from the command line, 
it refers to all files in the directory (see Supplement III.V). Use the following 
command to run your program.
java Exercise12_29 *
**12.30 (Occurrences of each letter ) Write a program that prompts the user to enter 
a file name and displays the occurrences of each letter in the file. Letters are 
case-insensitive. Here is a sample run:
Enter a filename: Lincoln.txt
Number of A's: 56 
Number of B's: 134 
...
Number of Z's: 9 
1 Jacob 21,875 Isabella 22,731
2 Ethan 17,866 Sophia 20,477
Enter the year: 2010
Enter the gender: M
Enter the name: Javier
Javier is ranked #190 in year 2010
Enter the year: 2010
Enter the gender: F
Enter the name: ABC
The name ABC is not ranked in year 2010
*12.31 (Baby name popularity ranking ) The popularity ranking of baby names from 
years 2001 to 2010 is downloaded from www.ssa.gov/oact/babynames and stored 
in files named babynameranking2001.txt, babynameranking2002.txt, . . . , 
babynameranking2010.txt. Each file contains one thousand lines. Each line 
contains a ranking, a boy’s name, number for the boy’s name, a girl’s name, 
and number for the girl’s name. For example, the first two lines in the file 
babynameranking2010.txt are as follows:
  So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s 
name Ethan and girl’s name Sophia are ranked #2. 21,875 boys are named 
Jacob and 22,731 girls are named Isabella. Write a program that prompts the 
user to enter the year, gender, and followed by a name, and displays the ranking 
of the name for the year. Here is a sample run:
```

</details>


## PDF page 516

<details>
<summary>Page text</summary>

```text
Programming Exercises  493
*12.32 (Ranking summary) Write a program that uses the files described in Program-
ming Exercise 12.31 and displays a ranking summary table for the first five 
girl’s and boy’s names as follows:
Year Rank 1 Rank 2 Rank 3 Rank 4 Rank 5 Rank 1 Rank 2 Rank 3 Rank 4 Rank 5
2010 Isabella Sophia Emma Olivia Ava Jacob Ethan Michael Jayden William
2009 Isabella Emma Olivia Sophia Ava Jacob Ethan Michael Alexander William
...
2001 Emily Madison Hannah Ashley Alexis Jacob Michael Matthew Joshua Christopher
**12.33 (Search Web) Modify Listing 12.18 WebCrawler.java to search for the word 
Computer Programming  starting from the URL http://cs.armstrong.edu/liang.
Your program terminates once the word is found. Display the URL for the page 
that contains the word.
```

</details>


## PDF page 517

<details>
<summary>Page text</summary>

```text
This page intentionally left blank
```

</details>
