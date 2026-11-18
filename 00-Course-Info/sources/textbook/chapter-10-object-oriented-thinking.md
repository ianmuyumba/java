# Chapter 10 Object-Oriented Thinking

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 388

<details>
<summary>Page text</summary>

```text
OBJECT-ORIENTED
THINKING
Objectives
■ To apply class abstraction to develop software (§10.2).
■ To explore the differences between the procedural paradigm and 
object-oriented paradigm (§10.3).
■ To discover the relationships between classes (§10.4).
■ To design programs using the object-oriented paradigm (§§10.5–10.6).
■ To create objects for primitive values using the wrapper classes (Byte,
Short,Integer,Long,Float,Double,Character, and Boolean)
(§10.7).
■ To simplify programming using automatic conversion between 
primitive types and wrapper class types (§10.8).
■ To use the BigInteger and BigDecimal classes for computing very 
large numbers with arbitrary precisions (§10.9).
■ To use the String class to process immutable strings (§10.10).
■ To use the StringBuilder and StringBuffer classes to process 
mutable strings (§10.11).
CHAPTER
10
```

</details>


## PDF page 389

<details>
<summary>Page text</summary>

```text
366 Chapter 10  Object-Oriented Thinking
10.1 Introduction
The focus of this chapter is on class design and explores the differences between 
procedural programming and object-oriented programming.
The preceding chapter introduced objects and classes. You learned how to define classes, 
create objects, and use objects from several classes in the Java API (e.g., Circle, Date,
Random, and Point2D). This book’s  approach is to teach problem solving and fundamental 
programming techniques before object-oriented programming. This chapter shows how pro-
cedural and object-oriented programming differ. You will see the benefits of object-oriented 
programming and learn to use it effectively.
Our focus here is on class design. We will use several examples to illustrate the advantages 
of the object-oriented approach. The examples involve designing new classes and using them 
in applications and introducing new classes in the Java API. 
10.2 Class Abstraction and Encapsulation
Class abstraction is the separation of class implementation from the use of a class. 
The details of implementation are encapsulated and hidden from the user. This is 
known as class encapsulation.
In Chapter 6, you learned about method abstraction and used it in stepwise refinement. Java
provides many levels of abstraction, and class abstraction  separates class implementation 
from how the class is used. The creator of a class describes the functions of the class and lets 
the user know how the class can be used. The collection of methods and fields that are accessi-
ble from outside the class, together with the description of how these members are expected to 
behave, serves as the class’s contract. As shown in Figure 10.1, the user of the class does not 
need to know how the class is implemented. The details of implementation are encapsulated 
and hidden from the user. This is called class encapsulation. For example, you can create a 
Circle object and find the area of the circle without knowing how the area is computed. For 
this reason, a class is also known as an abstract data type (ADT).
Key
Point
Key
Point
class abstraction
class’s contract
class encapsulation
abstract data type
FIGURE 10.1 Class abstraction separates class implementation from the use of the class.
Class Contract
(signatures of
public methods and
public constants)
Class
Class implementation
is like a black box
hidden from the clients
Clients use the
class through the
contract of the class
Class abstraction and encapsulation are two sides of the same coin. Many real-life exam-
ples illustrate the concept of class abstraction. Consider, for instance, building a computer 
system. Your personal computer has many components—a CPU, memory, disk, motherboard, 
fan, and so on. Each component can be viewed as an object that has properties and methods. 
To get the components to work together, you need know only how each component is used 
and how it interacts with the others. You don’t need to know how the components work 
internally. The internal implementation is encapsulated and hidden from you. You can build a 
computer without knowing how a component is implemented.
The computer-system analogy precisely mirrors the object-oriented approach. Each com-
ponent can be viewed as an object of the class for the component. For example, you might 
have a class that models all kinds of fans for use in a computer, with properties such as fan 
size and speed and methods such as start and stop. A specific fan is an instance of this class 
with specific property values.
As another example, consider getting a loan. A specific loan can be viewed as an object 
of a Loan class. The interest rate, loan amount, and loan period are its data properties, and
```

</details>


## PDF page 390

<details>
<summary>Page text</summary>

```text
10.2 Class Abstraction and Encapsulation  367
computing the monthly payment and total payment are its methods. When you buy a car, a 
loan object is created by instantiating the class with your loan interest rate, loan amount, and 
loan period. You can then use the methods to find the monthly payment and total payment 
of your loan. As a user of the Loan class, you don’t need to know how these methods are 
implemented.
Listing 2.9, ComputeLoan.java, presented a program for computing loan payments. That 
program cannot be reused in other programs because the code for computing the payments is 
in the main method. One way to fix this problem is to define static methods for computing 
the monthly payment and total payment. However, this solution has limitations. Suppose you 
wish to associate a date with the loan. There is no good way to tie a date with a loan without 
using objects. The traditional procedural programming paradigm is action-driven, and data are 
separated from actions. The object-oriented programming paradigm focuses on objects, and 
actions are defined along with the data in objects. To tie a date with a loan, you can define a 
loan class with a date along with the loan’s other properties as data fields. A loan object now 
contains data and actions for manipulating and processing data, and the loan data and actions 
are integrated in one object. Figure 10.2 shows the UML class diagram for the Loan class.
TheLoan class
VideoNote
FIGURE 10.2 TheLoan class models the properties and behaviors of loans.
Loan
The annual interest rate of the loan (default: 2.5).
Returns the annual interest rate of this loan.
Sets a new annual interest rate for this loan.
Sets a new number of years for this loan.
Sets a new amount for this loan.
Returns the monthly payment for this loan.
The number of years for the loan (default: 1).
The loan amount (default: 1000).
The date this loan was created.
Constructs a loan with specified interest rate, years,
 and loan amount.
Returns the number of the years of this loan.
Returns the amount of this loan.
Returns the date of the creation of this loan.
Returns the total payment for this loan.
+Loan(annualInterestRate: double,
numberOfYears: int,loanAmount:
   double)
+getAnnualInterestRate(): double
+setNumberOfYears(
numberOfYears: int): void
+setLoanAmount(
loanAmount: double): void
+getMonthlyPayment(): double
+setAnnualInterestRate(
annualInterestRate: double): void
+Loan()
+getNumberOfYears(): int
+getLoanAmount(): double
+getLoanDate(): java.util.Date
+getTotalPayment(): double
Constructs a default Loan object.
-annualInterestRate: double
-numberOfYears: int
-loanAmount: double
-loanDate: java.util.Date
The UML diagram in Figure 10.2 serves as the contract for the Loan class. Throughout this 
book, you will play the roles of both class user and class developer. Remember that a class 
user can use the class without knowing how the class is implemented. 
Assume that the Loan class is available. The program in Listing 10.1 uses that class.
LISTING 10.1 TestLoanClass.java
 1 import java.util.Scanner;
 2
 3 public class TestLoanClass {
 4 /** Main method */
 5 public static void main(String[] args) {
```

</details>


## PDF page 391

<details>
<summary>Page text</summary>

```text
368 Chapter 10  Object-Oriented Thinking
 6 // Create a Scanner
 7      Scanner input = new Scanner(System.in);
 8
 9 // Enter annual interest rate
10      System.out.print(
11 "Enter annual interest rate, for example, 8.25: ");
12 double annualInterestRate = input.nextDouble();
13
14 // Enter number of years
15      System.out.print("Enter number of years as an integer: ");
16 int numberOfYears = input.nextInt();
17
18 // Enter loan amount
19      System.out.print("Enter loan amount, for example, 120000.95: ");
20 double loanAmount = input.nextDouble();
21
22 // Create a Loan object
23      Loan loan =
24 new Loan(annualInterestRate, numberOfYears, loanAmount);
25
26 // Display loan date, monthly payment, and total payment
27      System.out.printf("The loan was created on %s\n" +
28 "The monthly payment is %.2f\nThe total payment is %.2f\n",
29        loan.getLoanDate().toString(), loan.getMonthlyPayment(),
30        loan.getTotalPayment());
31    }
32  }
createLoan object
invoke instance method
invoke instance method
Enter annual interest rate, for example, 8.25: 2.5
Enter number of years as an integer: 5
Enter loan amount, for example, 120000.95: 1000
The loan was created on Sat Jun 16 21:12:50 EDT 2012
The monthly payment is 17.75
The total payment is 1064.84
Themain method reads the interest rate, the payment period (in years), and the loan amount; 
creates a Loan object; and then obtains the monthly payment (line 29) and the total payment 
(line 30) using the instance methods in the Loan class.
TheLoan class can be implemented as in Listing 10.2.
LISTING 10.2 Loan.java
 1 public class Loan {
 2 private double annualInterestRate;
 3 private int numberOfYears;
 4 private double loanAmount;
 5 private java.util.Date loanDate;
 6
 7 /** Default constructor */
 8 public Loan() {
 9 this(2.5, 1, 1000);
10    }
11
12 /** Construct a loan with specified annual interest rate,
no-arg constructor
```

</details>


## PDF page 392

<details>
<summary>Page text</summary>

```text
10.2 Class Abstraction and Encapsulation  369
13 number of years, and loan amount
14 */
15 public Loan(double annualInterestRate, int numberOfYears,
16 double loanAmount) {
17 this.annualInterestRate = annualInterestRate;
18 this.numberOfYears = numberOfYears;
19 this.loanAmount = loanAmount;
20      loanDate = new java.util.Date();
21    }
22
23 /** Return annualInterestRate */
24 public double getAnnualInterestRate() {
25 return annualInterestRate;
26    }
27
28 /** Set a new annualInterestRate */
29 public void setAnnualInterestRate(double annualInterestRate) {
30 this.annualInterestRate = annualInterestRate;
31    }
32
33 /** Return numberOfYears */
34 public int getNumberOfYears() {
35 return numberOfYears;
36    }
37
38 /** Set a new numberOfYears */
39 public void setNumberOfYears(int numberOfYears) {
40 this.numberOfYears = numberOfYears;
41    }
42
43 /** Return loanAmount */
44 public double getLoanAmount() {
45 return loanAmount;
46    }
47
48 /** Set a new loanAmount */
49 public void setLoanAmount(double loanAmount) {
50 this.loanAmount = loanAmount;
51    }
52
53 /** Find monthly payment */
54 public double getMonthlyPayment() {
55 double monthlyInterestRate = annualInterestRate / 1200;
56 double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
57        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
58 return monthlyPayment;
59    }
60
61 /** Find total payment */
62 public double getTotalPayment() {
63 double totalPayment = getMonthlyPayment() * numberOfYears * 12;
64 return totalPayment;
65    }
66
67 /** Return loan date */
68 public java.util.Date getLoanDate() {
69 return loanDate;
70    }
71  }
constructor
```

</details>


## PDF page 393

<details>
<summary>Page text</summary>

```text
370 Chapter 10  Object-Oriented Thinking
From a class developer’s perspective, a class is designed for use by many different customers. 
In order to be useful in a wide range of applications, a class should provide a variety of ways 
for customization through constructors, properties, and methods.
The Loan class contains two constructors, four getter methods, three setter methods, 
and the methods for finding the monthly payment and the total payment. You can con-
struct a Loan object by using the no-arg constructor or the constructor with three param-
eters: annual interest rate, number of years, and loan amount. When a loan object is created, 
its date is stored in the loanDate field. The getLoanDate method returns the date. The 
methods—getAnnualInterest, getNumberOfYears, and getLoanAmount—return the 
annual interest rate, payment years, and loan amount, respectively. All the data properties 
and methods in this class are tied to a specific instance of the Loan class. Therefore, they are 
instance variables and methods.
Important Pedagogical Tip
Use the UML diagram for the Loan class shown in Figure 10.2 to write a test program 
that uses the Loan class even though you don’t know how the Loan class is imple-
mented. This has three benefits:
 ■ It demonstrates that developing a class and using a class are two separate tasks.
 ■ It enables you to skip the complex implementation of certain classes without inter-
rupting the sequence of this book.
 ■ It is easier to learn how to implement a class if you are familiar with it by using the class.
For all the class examples from now on, create an object from the class and try using its 
methods before turning your attention to its implementation.
10.1 If you redefine the Loan class in Listing 10.2 without setter methods, is the class 
immutable?
10.3 Thinking in Objects
The procedural paradigm focuses on designing methods. The object-oriented 
paradigm couples data and methods together into objects. Software design using the 
object-oriented paradigm focuses on objects and operations on objects.
Chapters  1–8 introduced fundamental programming techniques for problem solving using 
loops, methods, and arrays. Knowing these techniques lays a solid foundation for object-
oriented programming. Classes provide more flexibility and modularity for building reusable 
software. This section improves the solution for a problem introduced in Chapter 3 using the 
object-oriented approach. From these improvements, you will gain insight into the differences 
between procedural and object-oriented programming and see the benefits of developing reus-
able code using objects and classes.
Listing 3.4, ComputeAndInterpretBMI.java, presented a program for computing body 
mass index. The code cannot be reused in other programs, because the code is in the main
method. To make it reusable, define a static method to compute body mass index as follows:
public static double getBMI(double weight, double height)
This method is useful for computing body mass index for a specified weight and height. How-
ever, it has limitations. Suppose you need to associate the weight and height with a person’s 
name and birth date. You could declare separate variables to store these values, but these 
values would not be tightly coupled. The ideal way to couple them is to create an object that 
contains them all. Since these values are tied to individual objects, they should be stored in 
instance data fields. You can define a class named BMI as shown in Figure 10.3.
✓Point✓
Check
Key
Point
TheBMI class
VideoNote
```

</details>


## PDF page 394

<details>
<summary>Page text</summary>

```text
10.3 Thinking in Objects 371
Assume that the BMI class is available. Listing 10.3 gives a test program that uses this class.
LISTING 10.3 UseBMIClass.java
 1 public class UseBMIClass {
 2 public static void main(String[] args) {
 3 BMI bmi1 = new BMI("Kim Yang", 18, 145, 70);
 4      System.out.println("The BMI for " + bmi1.getName() + " is "
 5        + bmi1.getBMI() + " " + bmi1.getStatus());
 6
 7 BMI bmi2 = new BMI("Susan King", 215, 70);
 8      System.out.println("The BMI for " + bmi2.getName() + " is "
 9        + bmi2.getBMI() + " " + bmi2.getStatus());
10    }
11  }
create an object
invoke instance method
create an object
invoke instance method
FIGURE 10.3 TheBMI class encapsulates BMI information.
BMI
-name: String
-age: int 
-weight: double
-height: double
+BMI(name: String, age: int, weight:
double, height: double)
+BMI(name: String, weight: double,
height: double)
+getBMI(): double
+getStatus(): String
The name of the person.
The age of the person.
The weight of the person in pounds. 
The height of the person in inches.
Creates a BMI object with the specified 
   name, age, weight, and height. 
Creates a BMI object with the specified
name, weight, height, and a default age 20.
Returns the BMI. 
Returns the BMI status (e.g., normal, 
   overweight, etc.). 
The getter methods for these data fields
are provided in the class, but omitted in the
UML diagram for brevity.
The BMI for Kim Yang is 20.81 Normal 
The BMI for Susan King is 30.85 Obese
Line 3 creates the object bmi1 for Kim Yang and line 7 creates the object bmi2 for Susan
King. You can use the instance methods getName(), getBMI(), and getStatus() to 
return the BMI information in a BMI object.
TheBMI class can be implemented as in Listing 10.4.
LISTING 10.4 BMI.java
 1 public class BMI {
 2 private String name;
 3 private int age;
 4 private double weight; // in pounds
 5 private double height; // in inches
 6 public static final double KILOGRAMS_PER_POUND = 0.45359237;
 7 public static final double METERS_PER_INCH = 0.0254;
 8
 9 public BMI(String name, int age, double weight, double height) {
10 this.name = name;
constructor
```

</details>


## PDF page 395

<details>
<summary>Page text</summary>

```text
372 Chapter 10  Object-Oriented Thinking
11 this.age = age;
12 this.weight = weight;
13 this.height = height;
14    }
15
16 public BMI(String name, double weight, double height) {
17 this(name, 20, weight, height);
18    }
19
20 public double getBMI() {
21 double bmi = weight * KILOGRAMS_PER_POUND / 
22        ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
23 return Math.round(bmi * 100) / 100.0;
24    }
25
26 public String getStatus() {
27 double bmi = getBMI();
28 if (bmi < 18.5)
29 return "Underweight";
30 else if (bmi < 25)
31 return "Normal";
32 else if (bmi < 30)
33 return "Overweight";
34 else
35 return "Obese";
36    }
37
38 public String getName() {
39 return name;
40    }
41
42 public int getAge() {
43 return age;
44    }
45
46 public double getWeight() {
47 return weight;
48    }
49
50 public double getHeight() {
51 return height;
52    }
53  }
The mathematical formula for computing the BMI using weight and height is given in 
Section 3.8. The instance method getBMI() returns the BMI. Since the weight and height are 
instance data fields in the object, the getBMI() method can use these properties to compute 
the BMI for the object.
The instance method getStatus() returns a string that interprets the BMI. The interpre-
tation is also given in Section 3.8.
This example demonstrates the advantages of the object-oriented paradigm over the proce-
dural paradigm. The procedural paradigm focuses on designing methods. The object-oriented 
paradigm couples data and methods together into objects. Software design using the object-
oriented paradigm focuses on objects and operations on objects. The object-oriented approach 
combines the power of the procedural paradigm with an added dimension that integrates data 
with operations into objects.
In procedural programming, data and operations on the data are separate, and this meth-
odology requires passing data to methods. Object-oriented programming places data and 
constructor
getBMI
getStatus
procedural vs. object-oriented 
paradigms
```

</details>


## PDF page 396

<details>
<summary>Page text</summary>

```text
10.4 Class Relationships  373
the operations that pertain to them in an object. This approach solves many of the problems 
inherent in procedural programming. The object-oriented programming approach organizes 
programs in a way that mirrors the real world, in which all objects are associated with both 
attributes and activities. Using objects improves software reusability and makes programs 
easier to develop and easier to maintain. Programming in Java involves thinking in terms of 
objects; a Java program can be viewed as a collection of cooperating objects.
10.2 Is the BMI class defined in Listing 10.4 immutable?
10.4 Class Relationships
To design classes, you need to explore the relationships among classes. The common 
relationships among classes are association, aggregation, composition, and 
inheritance.
This section explores association, aggregation, and composition. The inheritance relationship 
will be introduced in the next chapter.
10.4.1 Association
Association is a general binary relationship that describes an activity between two classes. 
For example, a student taking a course is an association between the Student class and the 
Course class, and a faculty member teaching a course is an association between the Faculty
class and the Course class. These associations can be represented in UML graphical notation, 
as shown in Figure 10.4.
✓Point✓
Check
Key
Point
association
FIGURE 10.4 This UML diagram shows that a student may take any number of courses, a 
faculty member may teach at most three courses, a course may have from five to sixty stu-
dents, and a course is taught by only one faculty member.
Teach
Teacher
Take
FacultyStudent
5..60 0..3 1
Course
An association is illustrated by a solid line between two classes with an optional label that 
describes the relationship. In Figure 10.4, the labels are Take and Teach. Each relationship 
may have an optional small black triangle that indicates the direction of the relationship. In 
this figure, the direction indicates that a student takes a course (as opposed to a course taking 
a student).
Each class involved in the relationship may have a role name that describes the role it plays 
in the relationship. In Figure 10.4, teacher is the role name for Faculty.
Each class involved in an association may specify a multiplicity, which is placed at the 
side of the class to specify how many of the class’s objects are involved in the relationship 
in UML. A multiplicity could be a number or an interval that specifies how many of the 
class’s objects are involved in the relationship. The character * means an unlimited number 
of objects, and the interval m..n indicates that the number of objects is between m and n,
inclusively. In Figure 10.4, each student may take any number of courses, and each course 
must have at least five and at most sixty students. Each course is taught by only one faculty 
member, and a faculty member may teach from zero to three courses per semester.
In Java code, you can implement associations by using data fields and methods. For exam-
ple, the relationships in Figure 10.4 may be implemented using the classes in Figure 10.5. The 
multiplicity
```

</details>


## PDF page 397

<details>
<summary>Page text</summary>

```text
374 Chapter 10  Object-Oriented Thinking
relation “a student takes a course” is implemented using the addCourse method in the Stu-
dent class and the addStuent method in the Course class. The relation “a faculty teaches 
a course” is implemented using the addCourse method in the Faculty class and the set-
Faculty method in the Course class. The Student class may use a list to store the courses 
that the student is taking, the Faculty class may use a list to store the courses that the faculty 
is teaching, and the Course class may use a list to store students enrolled in the course and a 
data field to store the instructor who teaches the course. 
FIGURE 10.6 Each student has a name and an address.
Aggregation
AddressName
Composition
1 1 1..3 1
Student
public class Student {
private Course[]
courseList;
public void addCourse(
    Course s) { ... }
}
public class Course {
private Student[]
classList;
private Faculty faculty;
public void addStudent(
    Student s) { ... }
public void setFaculty(
    Faculty faculty) { ... }
}
public class Faculty {
private Course[]
courseList;
public void addCourse(
    Course c) { ... }
}
FIGURE 10.5 The association relations are implemented using data fields and methods in classes.
Note
There are many possible ways to implement relationships. For example, the student 
and faculty information in the Course class can be omitted, since they are already in 
the Student and Faculty class. Likewise, if you don’t need to know the courses a 
student takes or a faculty member teaches, the data field courseList and the add-
Course method in Student or Faculty can be omitted.
10.4.2 Aggregation and Composition
Aggregation is a special form of association that represents an ownership relationship between 
two objects. Aggregation models has-a relationships. The owner object is called an aggregating 
object, and its class is called an aggregating class. The subject object is called an aggregated
object, and its class is called an aggregated class.
An object can be owned by several other aggregating objects. If an object is exclusively 
owned by an aggregating object, the relationship between the object and its aggregating object 
is referred to as a composition. For example, “a student has a name” is a composition relation-
ship between the Student class and the Name class, whereas “a student has an address” is an 
aggregation relationship between the Student class and the Address class, since an address 
can be shared by several students. In UML, a filled diamond is attached to an aggregating 
class (in this case, Student) to denote the composition relationship with an aggregated class 
(Name), and an empty diamond is attached to an aggregating class ( Student) to denote the 
aggregation relationship with an aggregated class (Address), as shown in Figure 10.6.
many possible 
implementations
aggregation
aggregating object
aggregating class
aggregated object
aggregated class
composition
In Figure 10.6, each student has only one multiplicity—address—and each address can 
be shared by up to 3 students. Each student has one name, and a name is unique for each 
student.
```

</details>


## PDF page 398

<details>
<summary>Page text</summary>

```text
10.4 Class Relationships  375
An aggregation relationship is usually represented as a data field in the aggregating class. 
For example, the relationships in Figure  10.6 may be implemented using the classes in 
Figure 10.7. The relation “a student has a name” and “a student has an address” are imple-
mented in the data field name and address in the Student class.
FIGURE 10.8 A person may have a supervisor.
1
1 Supervisor
Person
FIGURE 10.9 A person can have several supervisors.
Person
Supervisor
1
(a) (b)
m
public class Person {
  ...
private Person[] supervisors;
}
Aggregation may exist between objects of the same class. For example, a person may have a 
supervisor. This is illustrated in Figure 10.8.
public class Name {
  ...
}
Aggregated class
public class Student {
private Name name;
private Address address;
  ...
}
Aggregating class
public class Address {
  ...
}
Aggregated class
FIGURE 10.7 The composition relations are implemented using data fields in classes.
In the relationship “a person has a supervisor,” a supervisor can be represented as a data 
field in the Person class, as follows:
public class Person {
// The type for the data is the class itself
private Person supervisor;
  ...
}
If a person can have several supervisors, as shown in Figure 10.9a, you may use an array to 
store supervisors, as shown in Figure 10.9b.
Note
Since aggregation and composition relationships are represented using classes in the 
same way, we will not differentiate them and call both compositions for simplicity.
10.3 What are common relationships among classes?
10.4 What is association? What is aggregation? What is composition?
10.5 What is UML notation of aggregation and composition?
10.6 Why both aggregation and composition are together referred to as composition?
aggregation or composition
✓Point✓
Check
```

</details>


## PDF page 399

<details>
<summary>Page text</summary>

```text
376 Chapter 10  Object-Oriented Thinking
10.5 Case Study: Designing the Course Class
This section designs a class for modeling courses.
This book’s philosophy is teaching by example and learning by doing . The book provides a 
wide variety of examples to demonstrate object-oriented programming. This section and the 
next offer additional examples on designing classes.
Suppose you need to process course information. Each course has a name and has students 
enrolled. You should be able to add/drop a student to/from the course. You can use a class to 
model the courses, as shown in Figure 10.10.
Key
Point
FIGURE 10.10 TheCourse class models the courses.
Course
-courseName: String
-students: String[]
-numberOfStudents: int
+Course(courseName: String)
+getCourseName(): String
+addStudent(student: String): void
+dropStudent(student: String): void
+getStudents(): String[]
+getNumberOfStudents(): int
The name of the course.
An array to store the students for the course.
The number of students (default: 0).
Creates a course with the specified name.
Returns the course name.
Adds a new student to the course.
Drops a student from the course.
Returns the students for the course.
Returns the number of students for the course.
ACourse object can be created using the constructor Course(String name) by passing 
a course name. You can add students to the course using the addStudent(String student)
method, drop a student from the course using the dropStudent(String student) method, 
and return all the students in the course using the getStudents() method. Suppose the Course
class is available; Listing 10.5 gives a test class that creates two courses and adds students to them.
LISTING 10.5 TestCourse.java
 1 public class TestCourse {
 2 public static void main(String[] args) {
 3 Course course1 = new Course("Data Structures");
 4 Course course2 = new Course("Database Systems");
 5
 6 course1.addStudent( "Peter Jones");
 7      course1.addStudent("Kim Smith");
 8      course1.addStudent("Anne Kennedy");
 9
10 course2.addStudent( "Peter Jones");
11      course2.addStudent("Steve Smith");
12
13      System.out.println("Number of students in course1: "
14        + course1.getNumberOfStudents());
15      String[] students = course1.getStudents();
16 for (int i = 0; i < course1.getNumberOfStudents(); i++)
17        System.out.print(students[i] + ", ");
18
19      System.out.println();
20      System.out.print("Number of students in course2: "
21        + course2.getNumberOfStudents());
22    }
23  }
create a course
add a student
number of students
return students
```

</details>


## PDF page 400

<details>
<summary>Page text</summary>

```text
10.5 Case Study: Designing the Course Class 377
TheCourse class is implemented in Listing 10.6. It uses an array to store the students in the 
course. For simplicity, assume that the maximum course enrollment is 100. The array is cre-
ated using new String[100] in line 3. The addStudent method (line 10) adds a student to 
the array. Whenever a new student is added to the course, numberOfStudents is increased 
(line 12). The getStudents method returns the array. The dropStudent method (line 27) 
is left as an exercise.
LISTING 10.6 Course.java
 1 public class Course {
 2 private String courseName;
 3 private String[] students = new String[100];
 4 private int numberOfStudents;
 5
 6 public Course(String courseName) {
 7 this.courseName = courseName;
 8    }
 9
10 public void addStudent(String student) {
11      students[numberOfStudents] = student;
12      numberOfStudents++;
13    }
14
15 public String[] getStudents() {
16 return students;
17    }
18
19 public int getNumberOfStudents() {
20 return numberOfStudents;
21    }
22
23 public String getCourseName() {
24 return courseName;
25    }
26
27 public void dropStudent(String student) {
28 // Left as an exercise in Programming Exercise 10.9
29    }
30  }
The array size is fixed to be 100 (line 3), so you cannot have more than 100 students in the 
course. You can improve the class by automatically increasing the array size in Programming 
Exercise 10.9.
When you create a Course object, an array object is created. A Course object contains a 
reference to the array. For simplicity, you can say that the Course object contains the array.
The user can create a Course object and manipulate it through the public methods 
addStudent, dropStudent, getNumberOfStudents, and getStudents. However, the 
user doesn’t need to know how these methods are implemented. The Course class encapsu-
lates the internal implementation. This example uses an array to store students, but you could 
use a different data structure to store students. The program that uses Course does not need 
to change as long as the contract of the public methods remains unchanged.
createstudents
add a course
returnstudents
number of students
Number of students in course1: 3
Peter Jones, Kim Smith, Anne Kennedy, 
Number of students in course2: 2
```

</details>


## PDF page 401

<details>
<summary>Page text</summary>

```text
378 Chapter 10  Object-Oriented Thinking
10.6 Case Study: Designing a Class for Stacks
This section designs a class for modeling stacks.
Recall that a stack is a data structure that holds data in a last-in, first-out fashion, as shown in 
Figure 10.11.
Key
Pointstack
FIGURE 10.12 TheStackOfIntegers class encapsulates the stack storage and provides 
the operations for manipulating the stack.
StackOfIntegers
-elements: int[]
-size: int
+StackOfIntegers()
+StackOfIntegers(capacity: int)
+empty(): boolean
+peek(): int
+push(value: int): void
+pop(): int
+getSize(): int
An array to store integers in the stack.
The number of integers in the stack.
Constructs an empty stack with a default capacity of 16.
Constructs an empty stack with a specified capacity.
Returns true if the stack is empty.
Returns the integer at the top of the stack without
    removing it from the stack.
Stores an integer into the top of the stack.
Removes the integer at the top of the stack and returns it.
Returns the number of elements in the stack.
FIGURE 10.11 A stack holds data in a last-in, first-out fashion.
Data1
Data2
Data1
Data3
Data3
Data2
Data1
Data1
Data1
Data2
Data1
Data2
Data2
Data1
Data3
Stacks have many applications. For example, the compiler uses a stack to process method 
invocations. When a method is invoked, its parameters and local variables are pushed into a 
stack. When a method calls another method, the new method’s parameters and local variables 
are pushed into the stack. When a method finishes its work and returns to its caller, its associ-
ated space is released from the stack. 
You can define a class to model stacks. For simplicity, assume the stack holds the int
values. So name the stack class StackOfIntegers. The UML diagram for the class is shown 
in Figure 10.12.
TheStackOfIntegers class
VideoNote
Suppose that the class is available. The test program in Listing 10.7 uses the class to cre-
ate a stack (line 3), store ten integers 0,1,2, . . . , and 9 (line 6), and displays them in reverse 
order (line 9).
LISTING 10.7 TestStackOfIntegers.java
 1 public class TestStackOfIntegers {
 2 public static void main(String[] args) {
3 StackOfIntegers stack = new StackOfIntegers();create a stack
```

</details>


## PDF page 402

<details>
<summary>Page text</summary>

```text
10.6 Case Study: Designing a Class for Stacks  379
 4
 5 for (int i = 0; i < 10; i++)
 6 stack.push(i);
 7
 8 while (!stack.empty())
 9        System.out.print(stack.pop() + " ");
10    }
11  }
push to stack
pop from stack
9 8 7 6 5 4 3 2 1 0
FIGURE 10.13 TheStackOfIntegers class encapsulates the stack storage and provides 
the operations for manipulating the stack.
.
.
.
.
.
.
elements[0]
elements[1]
elements[size /H11002 1]
capacity
top
bottom
size
elements[capacity /H11002 1]
How do you implement the StackOfIntegers class? The elements in the stack are stored 
in an array named elements. When you create a stack, the array is also created. The no-arg 
constructor creates an array with the default capacity of 16. The variable size counts the 
number of elements in the stack, and size – 1 is the index of the element at the top of the 
stack, as shown in Figure 10.13. For an empty stack, size is 0.
The StackOfIntegers class is implemented in Listing 10.8. The methods empty(),
peek(),pop(), and getSize() are easy to implement. To implement push(int value),
assignvalue to elements[size] if size < capacity (line 24). If the stack is full (i.e., 
size >= capacity), create a new array of twice the current capacity (line 19), copy the con-
tents of the current array to the new array (line 20), and assign the reference of the new array 
to the current array in the stack (line 21). Now you can add the new value to the array (line 24).
LISTING 10.8 StackOfIntegers.java
 1 public class StackOfIntegers {
 2 private int[] elements;
 3 private int size;
 4 public static final int DEFAULT_CAPACITY = 16;
 5
 6 /** Construct a stack with the default capacity 16 */
 7 public StackOfIntegers() {
 8 this (DEFAULT_CAPACITY);
 9    }
10
11 /** Construct a stack with the specified maximum capacity */
12 public StackOfIntegers(int capacity) {
13      elements = new int[capacity];
14    }
15
max capacity 16
```

</details>


## PDF page 403

<details>
<summary>Page text</summary>

```text
380 Chapter 10  Object-Oriented Thinking
16 /** Push a new integer to the top of the stack */
17 public void push(int value) {
18 if (size >= elements.length) {
19 int[] temp = new int[elements.length * 2];
20        System.arraycopy(elements, 0, temp, 0, elements.length);
21        elements = temp;
22      }
23
24      elements[size++] = value; 
25    }
26
27 /** Return and remove the top element from the stack */
28 public int pop() {
29 return elements[——size];
30    }
31
32 /** Return the top element from the stack */
33 public int peek() {
34 return elements[size - 1];
35    }
36
37 /** Test whether the stack is empty */
38 public boolean empty() {
39 return size == 0;
40    }
41
42 /** Return the number of elements in the stack */
43 public int getSize() {
44 return size;
45    }
46  }
10.7 Processing Primitive Data Type Values as Objects
A primitive type value is not an object, but it can be wrapped in an object using a 
wrapper class in the Java API.
Owing to performance considerations, primitive data type values are not objects in Java. 
Because of the overhead of processing objects, the language’s performance would be 
adversely affected if primitive data type values were treated as objects. However, many Java 
methods require the use of objects as arguments. Java offers a convenient way to incorporate, 
or wrap, a primitive data type into an object (e.g., wrapping int into the Integer class, 
wrappingdouble into the Double class, and wrapping char into the Character class,). By 
using a wrapper class, you can process primitive data type values as objects. Java provides 
Boolean,Character,Double,Float,Byte,Short,Integer, and Long wrapper classes 
in the java.lang package for primitive data types. The Boolean class wraps a Boolean 
valuetrue or false. This section uses Integer and Double as examples to introduce the 
numeric wrapper classes. 
Note
Most wrapper class names for a primitive type are the same as the primitive data type 
name with the first letter capitalized. The exceptions are Integer and Character.
Numeric wrapper classes are very similar to each other. Each contains the methods 
doubleValue(), floatValue(), intValue(), longValue(), shortValue(), and 
byteValue(). These methods “convert” objects into primitive type values. The key features 
ofInteger and Double are shown in Figure 10.14.
double the capacity
add to stack
Key
Point
why wrapper class?
naming convention
```

</details>


## PDF page 404

<details>
<summary>Page text</summary>

```text
10.7 Processing Primitive Data Type Values as Objects  381
You can construct a wrapper object either from a primitive data type value or from a string 
representing the numeric value—for example, new Double(5.0),new Double("5.0"),
new Integer(5), and new Integer("5").
The wrapper classes do not have no-arg constructors. The instances of all wrapper classes 
are immutable; this means that, once the objects are created, their internal values cannot be 
changed.
Each numeric wrapper class has the constants MAX_VALUE and MIN_VALUE.MAX_VALUE
represents the maximum value of the corresponding primitive data type. For Byte, Short,
Integer, and Long, MIN_VALUE represents the minimum byte, short, int, and long
values. For Float and Double, MIN_VALUE represents the minimum positive float and 
double values. The following statements display the maximum integer (2,147,483,647), 
the minimum positive float (1.4E–45), and the maximum double floating-point number 
(1.79769313486231570e + 308d).
System.out.println("The maximum integer is " + Integer.MAX_VALUE);
System.out.println("The minimum positive float is " +
  Float.MIN_VALUE);
System.out.println(
"The maximum double-precision floating-point number is " +
  Double.MAX_VALUE);
Each numeric wrapper class contains the methods doubleValue(), floatValue(),
intValue(), longValue(), and shortValue() for returning a double, float, int,
long, or short value for the wrapper object. For example,
new Double(12.4).intValue() returns 12;
new Integer(12).doubleValue() returns 12.0;
Recall that the String class contains the compareTo method for comparing two strings. 
The numeric wrapper classes contain the compareTo method for comparing two numbers 
constructors
no no-arg constructor
immutable
constants
conversion methods
compareTo method
FIGURE 10.14 The wrapper classes provide constructors, constants, and conversion methods for manipulating various 
data types.
-value: int
+MAX_VALUE: int
+MIN_VALUE: int
+Integer(value: int)
+Integer(s: String)
+byteValue(): byte
+shortValue(): short
+intValue(): int
+longValue(): long
+floatValue(): float
+doubleValue(): double
+compareTo(o: Integer): int 
+toString(): String
+valueOf(s: String): Integer
+valueOf(s: String, radix: int): Integer
+parseInt(s: String): int
+parseInt(s: String, radix: int): int
java.lang.Integer java.lang.Double
-value: double
+MAX_VALUE: double
+MIN_VALUE: double
+Double(value: double)
+Double(s: String)
+byteValue(): byte
+shortValue(): short
+intValue(): int
+longValue(): long
+floatValue(): float
+doubleValue(): double
+compareTo(o: Double): int 
+toString(): String
+valueOf(s: String): Double
+valueOf(s: String, radix: int): Double
+parseDouble(s: String): double
+parseDouble(s: String, radix: int): double
```

</details>


## PDF page 405

<details>
<summary>Page text</summary>

```text
382 Chapter 10  Object-Oriented Thinking
and returns 1,0, or -1, if this number is greater than, equal to, or less than the other number. 
For example, 
new Double(12.4).compareTo(new Double(12.3)) returns 1;
new Double(12.3).compareTo(new Double(12.3)) returns 0;
new Double(12.3).compareTo(new Double(12.51)) returns -1;
The numeric wrapper classes have a useful static method, valueOf (String s). This 
method creates a new object initialized to the value represented by the specified string. For 
example,
Double doubleObject = Double.valueOf("12.4");
Integer integerObject = Integer.valueOf("12");
You have used the parseInt method in the Integer class to parse a numeric string into 
anint value and the parseDouble method in the Double class to parse a numeric string into 
adouble value. Each numeric wrapper class has two overloaded parsing methods to parse a 
numeric string into an appropriate numeric value based on 10 (decimal) or any specified radix 
(e.g.,2 for binary, 8 for octal, and 16 for hexadecimal). 
// These two methods are in the Byte class
public static byte parseByte(String s) 
public static byte parseByte(String s, int radix) 
// These two methods are in the Short class
public static short parseShort(String s)
public static short parseShort(String s, int radix)
// These two methods are in the Integer class
public static int parseInt(String s)
public static int parseInt(String s, int radix)
// These two methods are in the Long class
public static long parseLong(String s)
public static long parseLong(String s, int radix)
// These two methods are in the Float class
public static float parseFloat(String s)
public static float parseFloat(String s, int radix)
// These two methods are in the Double class
public static double parseDouble(String s)
public static double parseDouble(String s, int radix)
For example,
Integer.parseInt("11", 2) returns 3;
Integer.parseInt("12", 8) returns 10;
Integer.parseInt("13", 10) returns 13;
Integer.parseInt("1A", 16) returns 26;
Integer.parseInt("12", 2)  would raise a runtime exception because 12 is not a 
binary number.
Note that you can convert a decimal number into a hex number using the format method. 
For example,
String.format("%x", 26) returns 1A;
staticvalueOf methods
static parsing methods
converting decimal to hex
```

</details>


## PDF page 406

<details>
<summary>Page text</summary>

```text
10.8 Automatic Conversion between Primitive Types and Wrapper Class Types  383
10.7 Describe primitive-type wrapper classes.
10.8 Can each of the following statements be compiled?
a. Integer i = new Integer("23");
b. Integer i = new Integer(23);
c. Integer i = Integer.valueOf("23");
d. Integer i = Integer.parseInt("23", 8);
e. Double d = new Double();
f. Double d = Double.valueOf("23.45");
g. int i = (Integer.valueOf("23")).intValue();
h. double d = (Double.valueOf("23.4")).doubleValue();
i. int i = (Double.valueOf("23.4")).intValue();
j. String s = (Double.valueOf("23.4")).toString();
10.9 How do you convert an integer into a string? How do you convert a numeric string 
into an integer? How do you convert a double number into a string? How do you 
convert a numeric string into a double value?
10.10 Show the output of the following code.
public class Test {
public static void main(String[] args) {
    Integer x = new Integer(3);
    System.out.println(x.intValue());
    System.out.println(x.compareTo(new Integer(4)));
  }
}
10.11 What is the output of the following code?
public class Test {
public static void main(String[] args) {
    System.out.println(Integer.parseInt("10"));
    System.out.println(Integer.parseInt("10", 10));
    System.out.println(Integer.parseInt("10", 16));
    System.out.println(Integer.parseInt("11"));
    System.out.println(Integer.parseInt("11", 10));
    System.out.println(Integer.parseInt("11", 16));
  }
}
10.8 Automatic Conversion between Primitive Types 
and Wrapper Class Types
A primitive type value can be automatically converted to an object using a wrapper 
class, and vice versa, depending on the context.
Converting a primitive value to a wrapper object is called boxing. The reverse conversion is 
called unboxing. Java allows primitive types and wrapper classes to be converted automati-
cally. The compiler will automatically box a primitive value that appears in a context requir-
ing an object, and will unbox an object that appears in a context requiring a primitive value.  
This is called autoboxing and autounboxing.
✓Point✓
Check
Key
Point
boxing
unboxing
autoboxing
autounboxing
```

</details>


## PDF page 407

<details>
<summary>Page text</summary>

```text
384 Chapter 10  Object-Oriented Thinking
For instance, the following statement in (a) can be simplified as in (b) due to autoboxing.
Integer intObject = new Integer (2); Integer intObject = 2;
(a)
Equivalent
autoboxing
(b)
Consider the following example:
1  Integer[] intArray = {1, 2, 3};
2  System.out.println(intArray[0] + intArray[1] + intArray[2]);
In line 1, the primitive values 1,2, and 3 are automatically boxed into objects new Integer(1),
new Integer(2), and new Integer(3). In line 2, the objects intArray[0],intArray[1],
andintArray[2] are automatically unboxed into int values that are added together.
10.12 What are autoboxing and autounboxing? Are the following statements correct?
a. Integer x = 3 + new Integer(5);
b. Integer x = 3;
c. Double x = 3;
d. Double x = 3.0;
e. int x = new Integer(3);
f. int x = new Integer(3) + new Integer(4);
10.13 Show the output of the following code?
public class Test {
public static void main(String[] args) {
    Double x = 3.5;
    System.out.println(x.intValue());
    System.out.println(x.compareTo(4.5));
  }
}
10.9 The BigInteger and BigDecimal Classes
The BigInteger  and BigDecimal  classes can be used to represent integers or 
decimal numbers of any size and precision. 
If you need to compute with very large integers or high-precision floating-point val-
ues, you can use the BigInteger and BigDecimal classes in the java.math pack-
age. Both are immutable. The largest integer of the long type is Long.MAX_VALUE (i.e., 
9223372036854775807). An instance of BigInteger can represent an integer of any size. 
You can use new BigInteger(String)  and new BigDecimal(String)  to create an 
instance of BigInteger and BigDecimal, use the add, subtract, multiply, divide,
andremainder methods to perform arithmetic operations, and use the compareTo method 
to compare two big numbers. For example, the following code creates two BigInteger
objects and multiplies them.
BigInteger a = new BigInteger("9223372036854775807");
BigInteger b = new BigInteger("2");
BigInteger c = a.multiply(b); // 9223372036854775807 * 2
System.out.println(c);
✓Point✓
Check
Key
Point
Process large numbers
VideoNote
immutable
```

</details>


## PDF page 408

<details>
<summary>Page text</summary>

```text
10.9 The BigInteger and BigDecimal Classes 385
The output is 18446744073709551614.
There is no limit to the precision of a BigDecimal object. The divide method may throw 
an ArithmeticException if the result cannot be terminated. However, you can use the 
overloadeddivide(BigDecimal d, int scale, int roundingMode) method to spec-
ify a scale and a rounding mode to avoid this exception, where scale is the maximum number 
of digits after the decimal point. For example, the following code creates two BigDecimal
objects and performs division with scale 20 and rounding mode BigDecimal.ROUND_UP.
BigDecimal a = new BigDecimal(1.0);
BigDecimal b = new BigDecimal(3);
BigDecimal c = a.divide(b, 20, BigDecimal.ROUND_UP);
System.out.println(c);
The output is 0.33333333333333333334.
Note that the factorial of an integer can be very large. Listing 10.9 gives a method that can 
return the factorial of any integer.
LISTING 10.9 LargeFactorial.java
 1 import java.math.*;
 2
 3 public class LargeFactorial {
 4 public static void main(String[] args) {
 5      System.out.println("50! is \n" + factorial(50));
 6    }
 7
 8 public static BigInteger factorial(long n) {
 9 BigInteger result = BigInteger.ONE;
10 for (int i = 1; i <= n; i++)
11 result = result.multiply( new BigInteger(i + ""));
12
13 return result;
14    }
15  }
constant
multiply
50! is
30414093201713378043612608166064768844377641568960512000000000000      
BigInteger.ONE (line 9) is a constant defined in the BigInteger class. BigInteger.ONE
is the same as new BigInteger("1").
A new result is obtained by invoking the multiply method (line 11).
10.14 What is the output of the following code?
public class Test {
public static void main(String[] args) {
    java.math.BigInteger x = new java.math.BigInteger("3");
    java.math.BigInteger y = new java.math.BigInteger("7");
    java.math.BigInteger z = x.add(y);
    System.out.println("x is " + x);
    System.out.println("y is " + y);
    System.out.println("z is " + z);
  }
}
✓Point✓
Check
```

</details>


## PDF page 409

<details>
<summary>Page text</summary>

```text
386 Chapter 10  Object-Oriented Thinking
10.10 The String Class
AString object is immutable: Its content cannot be changed once the string is 
created.
Strings were introduced in Section 4.4. You know strings are objects. You can invoke the 
charAt(index) method to obtain a character at the specified index from a string, the 
length() method to return the size of a string, the substring method to return a substring 
in a string, and the indexOf and lastIndexOf methods to return the first or last index of a 
matching character or a substring. We will take a closer look at strings in this section.
TheString class has 13 constructors and more than 40 methods for manipulating strings. 
Not only is it very useful in programming, but it is also a good example for learning classes 
and objects.
10.10.1 Constructing a String
You can create a string object from a string literal or from an array of characters. To create a 
string from a string literal, use the syntax:
String newString = new String(stringLiteral);
The argument stringLiteral is a sequence of characters enclosed inside double quotes. 
The following statement creates a String object message for the string literal "Welcome
to Java":
String message = new String("Welcome to Java");
Java treats a string literal as a String object. Thus, the following statement is valid:
String message = "Welcome to Java";
You can also create a string from an array of characters. For example, the following state-
ments create the string "Good Day":
char[] charArray = {'G', 'o', 'o', 'd', ' ', 'D', 'a', 'y'};
String message = new String(charArray);
Note
A String variable holds a reference to a String object that stores a string value. 
Strictly speaking, the terms String variable, String object, and string value  are 
different, but most of the time the distinctions between them can be ignored. For sim-
plicity, the term string will often be used to refer to String variable, String object, 
and string value.
10.10.2 Immutable Strings and Interned Strings
A String object is immutable; its contents cannot be changed. Does the following code 
change the contents of the string?
String s = "Java";
s = "HTML";
The answer is no. The first statement creates a String object with the content "Java" and 
assigns its reference to s. The second statement creates a new String object with the content 
"HTML" and assigns its reference to s. The first String object still exists after the assign-
ment, but it can no longer be accessed, because variable s now points to the new object, as 
shown in Figure 10.15.
Key
Point
TheString class
VideoNote
string literal object
String variable, String
object, string value
immutable
```

</details>


## PDF page 410

<details>
<summary>Page text</summary>

```text
10.10 The String Class 387
Because strings are immutable and are ubiquitous in programming, the JVM uses a unique 
instance for string literals with the same character sequence in order to improve efficiency 
and save memory. Such an instance is called an interned string. For example, the following 
statements:
interned string
FIGURE 10.15 Strings are immutable; once created, their contents cannot be changed.
After executing String s = "Java"; After executing s = "HTML";
Contents cannot be changed
String object for "Java"
String object for "HTML"
This string object is
now unreferenced
s
String object for "Java"
s : String : String
: String
String s1 = "Welcome to Java";
String s2 = new String("Welcome to Java");
String s3 = "Welcome to Java";
System.out.println("s1 == s2 is " + (s1 == s2));
System.out.println("s1 == s3 is " + (s1 == s3));
s1
s2
s3
Interned string object for
"Welcome to Java"
: String
A string object for
"Welcome to Java"
: String
display
s1 == s2 is false
s1 == s3 is true
In the preceding statements, s1 and s3 refer to the same interned string— "Welcome to 
Java"—sos1 == s3 is true. However, s1 == s2 is false, because s1 and s2 are two 
different string objects, even though they have the same contents.
10.10.3 Replacing and Splitting Strings
The String class provides the methods for replacing and splitting strings, as shown in 
Figure 10.16.
FIGURE 10.16 TheString class contains the methods for replacing and splitting strings.
java.lang.String
+replace(oldChar: char,
newChar: char): String
+replaceFirst(oldString: String,
newString: String): String
+replaceAll(oldString: String,
newString: String): String
+split(delimiter: String):
String[]
Returns a new string that replaces all matching characters in this
string with the new character.
Returns a new string that replaces the first matching substring in
this string with the new substring.
Returns a new string that replaces all matching substrings in this
string with the new substring.
Returns an array of strings consisting of the substrings split by the
delimiter.
```

</details>


## PDF page 411

<details>
<summary>Page text</summary>

```text
388 Chapter 10  Object-Oriented Thinking
Once a string is created, its contents cannot be changed. The methods replace,
replaceFirst , and replaceAll  return a new string derived from the original string 
(without changing the original string!). Several versions of the replace methods are pro-
vided to replace a character or a substring in the string with a new character or a new 
substring.
For example,
"Welcome".replace('e', 'A') returns a new string, WAlcomA.
"Welcome".replaceFirst("e", "AB") returns a new string, WABlcome.
"Welcome".replace("e", "AB") returns a new string, WABlcomAB.
"Welcome".replace("el", "AB") returns a new string, WABcome.
Thesplit method can be used to extract tokens from a string with the specified delimiters. 
For example, the following code
String[] tokens = "Java#HTML#Perl".split("#");
for (int i = 0; i < tokens.length; i++)
  System.out.print(tokens[i] + " ");
displays
Java HTML Perl
10.10.4 Matching, Replacing and Splitting by Patterns
Often you will need to write code that validates user input, such as to check whether the input 
is a number, a string with all lowercase letters, or a Social Security number. How do you write 
this type of code? A simple and effective way to accomplish this task is to use the regular 
expression.
A regular expression (abbreviated regex) is a string that describes a pattern for matching 
a set of strings. You can match, replace, or split a string by specifying a pattern. This is an 
extremely useful and powerful feature.
Let us begin with the matches method in the String class. At first glance, the matches
method is very similar to the equals method. For example, the following two statements both 
evaluate to true.
"Java".matches("Java");
"Java".equals("Java");
However, the matches method is more powerful. It can match not only a fixed string, but 
also a set of strings that follow a pattern. For example, the following statements all evaluate 
totrue:
"Java is fun".matches("Java.*")
"Java is cool".matches("Java.*")
"Java is powerful".matches("Java.*")
Java.* in the preceding statements is a regular expression. It describes a string pattern that 
begins with Java followed by any zero or more characters. Here, the substring matches any 
zero or more characters.
The following statement evaluates to true.
"440-02-4534".matches("\\d{3}-\\d{2}-\\d{4}")
Here\\d represents a single digit, and \\d{3} represents three digits.
replace
replaceFirst
replace
replace
split
why regular expression?
regular expression
regex
matches(regex)
```

</details>


## PDF page 412

<details>
<summary>Page text</summary>

```text
The replaceAll, replaceFirst, and split methods can be used with a regular 
expression. For example, the following statement returns a new string that replaces $,+, or #
ina+b$#c with the string NNN.
String s = "a+b$#c".replaceAll("[$+#]", "NNN");
System.out.println(s);
Here the regular expression [$+#] specifies a pattern that matches $,+, or #. So, the output 
isaNNNbNNNNNNc.
The following statement splits the string into an array of strings delimited by punctuation marks.
String[] tokens = "Java,C?C#,C++".split("[.,:;?]");
for (int i = 0; i < tokens.length; i++)
  System.out.println(tokens[i]);
In this example, the regular expression [.,:;?] specifies a pattern that matches .,,,:,;, or 
?. Each of these characters is a delimiter for splitting the string. Thus, the string is split into 
Java,C,C#, and C++, which are stored in array tokens.
Regular expression patterns are complex for beginning students to understand. For this 
reason, simple patterns are introduced in this section. Please refer to Appendix H, Regular 
Expressions, to learn more about these patterns.
10.10.5 Conversion between Strings and Arrays
Strings are not arrays, but a string can be converted into an array, and vice versa. To convert a 
string into an array of characters, use the toCharArray method. For example, the following 
statement converts the string Java to an array.
char[] chars = "Java".toCharArray();
Thus,chars[0] is J,chars[1] is a,chars[2] is v, and chars[3] is a.
You can also use the getChars(int srcBegin, int srcEnd, char[] dst, 
int dstBegin)  method to copy a substring of the string from index srcBegin to index 
srcEnd-1 into a character array dst starting from index dstBegin. For example, the fol-
lowing code copies a substring "3720" in "CS3720" from index 2 to index 6-1 into the 
character array dst starting from index 4.
char[] dst = {'J', 'A', 'V', 'A', '1', '3', '0', '1'};
"CS3720".getChars(2, 6, dst, 4);
Thus,dst becomes {'J', 'A', 'V', 'A', '3', '7', '2', '0'}.
To convert an array of characters into a string, use the String(char[]) constructor or 
the valueOf(char[]) method. For example, the following statement constructs a string 
from an array using the String constructor.
String str = new String(new char[]{'J', 'a', 'v', 'a'});
The next statement constructs a string from an array using the valueOf method.
String str = String.valueOf(new char[]{'J', 'a', 'v', 'a'});
10.10.6 Converting Characters and Numeric Values to Strings
Recall that you can use Double.parseDouble(str) or Integer.parseInt(str) to 
convert a string to a double value or an int value and you can convert a character or a 
number into a string by using the string concatenating operator. Another way of converting a 
replaceAll(regex)
split(regex)
further studies
toCharArray
getChars
valueOf
10.10 The String Class 389
```

</details>


## PDF page 413

<details>
<summary>Page text</summary>

```text
390 Chapter 10  Object-Oriented Thinking
number into a string is to use the overloaded static valueOf method. This method can also be 
used to convert a character or an array of characters into a string, as shown in Figure 10.17.
overloadedvalueOf
FIGURE 10.17 TheString class contains the static methods for creating strings from prim-
itive type values.
java.lang.String
+valueOf(c: char): String
+valueOf(data: char[]): String
+valueOf(d: double): String
+valueOf(f: float): String
+valueOf(i: int): String
+valueOf(l: long): String
Returns a string consisting of the character c.
Returns a string consisting of the characters in the array.
Returns a string representing the double value.
Returns a string representing the float value.
Returns a string representing the int value.
Returns a string representing the long value.
+valueOf(b: boolean): String Returns a string representing the boolean value.
For example, to convert a double value 5.44 to a string, use String.valueOf(5.44).
The return value is a string consisting of the characters '5','.','4', and '4'.
10.10.7 Formatting Strings
TheString class contains the static format method to return a formatted string. The syntax 
to invoke this method is:
String.format(format, item1, item2, ..., itemk)
This method is similar to the printf method except that the format method returns a for-
matted string, whereas the printf method displays a formatted string. For example,
String s = String.format("%7.2f%6d%-4s", 45.556, 14, "AB");
System.out.println(s);
displays
45.56 14AB
Note that
System.out.printf(format, item1, item2, ..., itemk);
is equivalent to
System.out.print(
  String.format(format, item1, item2, ..., itemk));
where the square box ( ) denotes a blank space.
10.15 Suppose that s1,s2,s3, and s4 are four strings, given as follows:
String s1 = "Welcome to Java";
String s2 = s1;
String s3 = new String("Welcome to Java");
String s4 = "Welcome to Java";
  What are the results of the following expressions?
a. s1 == s2
b. s1 == s3
✓Point✓
Check
```

</details>


## PDF page 414

<details>
<summary>Page text</summary>

```text
c. s1 == s4
d. s1.equals(s3)
e. s1.equals(s4)
f. "Welcome to Java".replace("Java", "HTML")
g. s1.replace('o', 'T')
h. s1.replaceAll("o", "T")
i. s1.replaceFirst("o", "T")
j. s1.toCharArray()
10.16 To create the string Welcome to Java, you may use a statement like this:
String s = "Welcome to Java";
or:
String s = new String("Welcome to Java");
  Which one is better? Why?
10.17 What is the output of the following code?
String s1 = "Welcome to Java";
String s2 = s1.replace("o", "abc");
System.out.println(s1);
System.out.println(s2);
10.18 Let s1 be "Welcome" and s2 be "welcome". Write the code for the following 
statements:
a. Replace all occurrences of the character e with E in s1 and assign the new string 
tos2.
b. Split Welcome to Java and HTML into an array tokens delimited by a space 
and assign the first two tokens into s1 and s2.
10.19 Does any method in the String class change the contents of the string?
10.20 Suppose string s is created using new String(); what is s.length()?
10.21 How do you convert a char, an array of characters, or a number to a string?
10.22 Why does the following code cause a NullPointerException?
 1 public class Test {
 2 private String text;
 3
 4 public Test(String s) {
 5 String text  = s;
 6    }
 7
 8 public static void main(String[] args) {
 9      Test test = new Test("ABC");
10      System.out.println(test.text.toLowerCase());
11    }
12  }
10.23 What is wrong in the following program?
 1 public class Test {
 2    String text;
 3
10.10 The String Class 391
```

</details>


## PDF page 415

<details>
<summary>Page text</summary>

```text
392 Chapter 10  Object-Oriented Thinking
 4 public void Test(String s) {
 5      text = s;
 6    }
 7
 8 public static void main(String[] args) {
 9      Test test = new Test("ABC");
10      System.out.println(test);
11    }
12  }
10.24 Show the output of the following code.
public class Test {
public static void main(String[] args) {
     System.out.println("Hi, ABC, good".matches("ABC "));
     System.out.println("Hi, ABC, good".matches(".*ABC.*"));
     System.out.println("A,B;C".replaceAll(",;", "#"));
     System.out.println("A,B;C".replaceAll("[,;]", "#"));
     String[] tokens = "A,B;C".split("[,;]");
for (int i = 0; i < tokens.length; i++)
       System.out.print(tokens[i] + " ");
   }
 }
10.25 Show the output of the following code.
public class Test {
public static void main(String[] args) {
     String s = "Hi, Good Morning";
     System.out.println(m(s));
   }
public static int m(String s) {
int count = 0;
for (int i = 0; i < s.length(); i++)
if (Character.isUpperCase(s.charAt(i)))
         count++;
return count;
   }
 }
10.11 The StringBuilder and StringBufferClasses
TheStringBuilder and StringBuffer classes are similar to the String class 
except that the String class is immutable.
In general, the StringBuilder and StringBuffer classes can be used wherever a string 
is used. StringBuilder and StringBuffer are more flexible than String. You can add, 
insert, or append new contents into StringBuilder and StringBuffer objects, whereas 
the value of a String object is fixed once the string is created.
TheStringBuilder class is similar to StringBuffer except that the methods for mod-
ifying the buffer in StringBuffer are synchronized, which means that only one task is 
allowed to execute the methods. Use StringBuffer if the class might be accessed by multi-
ple tasks concurrently, because synchronization is needed in this case to prevent corruptions to 
Key
Point
StringBuilder
```

</details>


## PDF page 416

<details>
<summary>Page text</summary>

```text
10.11 The StringBuilder and StringBuffer Classes 393
StringBuffer. Concurrent programming will be introduced in Chapter 30. Using String-
Builder is more efficient if it is accessed by just a single task, because no synchronization is 
needed in this case. The constructors and methods in StringBuffer and StringBuilder
are almost the same. This section covers StringBuilder. You can replace StringBuilder
in all occurrences in this section by StringBuffer. The program can compile and run with-
out any other changes.
TheStringBuilder class has three constructors and more than 30 methods for managing 
the builder and modifying strings in the builder. You can create an empty string builder or a 
string builder from a string using the constructors, as shown in Figure 10.18.
StringBuilder constructors
FIGURE 10.18 TheStringBuilder class contains the constructors for creating instances 
ofStringBuilder.
java.lang.StringBuilder
+StringBuilder()
+StringBuilder(capacity: int)
+StringBuilder(s: String)
Constructs an empty string builder with capacity 16.
Constructs a string builder with the specified capacity.
Constructs a string builder with the specified string.
FIGURE 10.19 TheStringBuilder class contains the methods for modifying string builders.
java.lang.StringBuilder
+append(data: char[]): StringBuilder
+append(data: char[], offset: int, len: int): 
StringBuilder
+append(v: aPrimitiveType): StringBuilder
+append(s: String): StringBuilder
+delete(startIndex: int, endIndex: int):
StringBuilder
+deleteCharAt(index: int): StringBuilder
+insert(index: int, data: char[], offset: int,
len: int): StringBuilder
+insert(offset: int, data: char[]):
StringBuilder
+insert(offset: int, b: aPrimitiveType):
StringBuilder
+insert(offset: int, s: String): StringBuilder
+replace(startIndex: int, endIndex: int, s:
String): StringBuilder
+reverse(): StringBuilder
+setCharAt(index: int, ch: char): void
Appends a char array into this string builder.
Appends a subarray in data into this string builder.
Appends a primitive type value as a string to this
builder.
Appends a string to this string builder.
Deletes characters fromstartIndex to endIndex-1.
Deletes a character at the specified index.
Inserts a subarray of the data in the array into the builder
at the specified index.
Inserts data into this builder at the position offset.
Inserts a value converted to a string into this builder.
Inserts a string into this builder at the position offset.
Replaces the characters in this builder fromstartIndex
toendIndex-1 with the specified string.
Reverses the characters in the builder.
Sets a new character at the specified index in this
builder.
10.11.1 Modifying Strings in the StringBuilder
You can append new contents at the end of a string builder, insert new contents at a speci-
fied position in a string builder, and delete or replace characters in a string builder, using the 
methods listed in Figure 10.19.
```

</details>


## PDF page 417

<details>
<summary>Page text</summary>

```text
394 Chapter 10  Object-Oriented Thinking
The StringBuilder class provides several overloaded methods to append boolean,
char,char[],double,float,int,long, and String into a string builder. For example, 
the following code appends strings and characters into stringBuilder to form a new string, 
Welcome to Java.
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("Welcome");
stringBuilder.append(' ');
stringBuilder.append("to");
stringBuilder.append(' ');
stringBuilder.append("Java");
TheStringBuilder class also contains overloaded methods to insert boolean,char,char
array,double,float,int,long, and String into a string builder. Consider the following 
code:
stringBuilder.insert(11, "HTML and ");
SupposestringBuilder contains Welcome to Java before the insert method is applied. 
This code inserts "HTML and "  at position 11 in stringBuilder (just before the J). The 
newstringBuilder is Welcome to HTML and Java.
You can also delete characters from a string in the builder using the two delete methods, 
reverse the string using the reverse method, replace characters using the replace method, 
or set a new character in a string using the setCharAt method.
For example, suppose stringBuilder contains Welcome to Java  before each of the 
following methods is applied:
stringBuilder.delete(8, 11) changes the builder to Welcome Java.
stringBuilder.deleteCharAt(8) changes the builder to Welcome o Java.
stringBuilder.reverse() changes the builder to avaJ ot emocleW.
stringBuilder.replace(11, 15, "HTML")changes the builder toWelcome to HTML.
stringBuilder.setCharAt(0, 'w') sets the builder to welcome to Java.
All these modification methods except setCharAt do two things:
■ Change the contents of the string builder
■ Return the reference of the string builder
For example, the following statement
StringBuilder stringBuilder1 = stringBuilder.reverse();
reverses the string in the builder and assigns the builder’s reference to stringBuilder1.
Thus, stringBuilder and stringBuilder1 both point to the same StringBuilder
object. Recall that a value-returning method can be invoked as a statement, if you are not 
interested in the return value of the method. In this case, the return value is simply ignored. 
For example, in the following statement
stringBuilder.reverse();
the return value is ignored.
Tip
If a string does not require any change, use String rather than StringBuilder. Java 
can perform some optimizations for String, such as sharing interned strings.
append
insert
delete
deleteCharAt
reverse
replace
setCharAt
ignore return value
String orStringBuilder?
```

</details>


## PDF page 418

<details>
<summary>Page text</summary>

```text
10.11.2 The toString,capacity,length,setLength,
and charAt Methods
TheStringBuilder class provides the additional methods for manipulating a string builder 
and obtaining its properties, as shown in Figure 10.20.
FIGURE 10.20 TheStringBuilder class contains the methods for modifying string builders.
java.lang.StringBuilder
+toString(): String
+capacity(): int
+charAt(index: int): char
+length(): int
+setLength(newLength: int): void
+substring(startIndex: int): String
+substring(startIndex: int, endIndex: int):
String
+trimToSize(): void
Returns a string object from the string builder.
Returns the capacity of this string builder.
Returns the character at the specified index.
Returns the number of characters in this builder.
Sets a new length in this builder.
Returns a substring starting at startIndex.
Returns a substring from startIndex to endIndex-1.
Reduces the storage size used for the string builder.
Thecapacity() method returns the current capacity of the string builder. The capacity is 
the number of characters the string builder is able to store without having to increase its size.
The length() method returns the number of characters actually stored in the string 
builder. The setLength(newLength) method sets the length of the string builder. If the 
newLength argument is less than the current length of the string builder, the string builder is 
truncated to contain exactly the number of characters given by the newLength argument. If 
thenewLength argument is greater than or equal to the current length, sufficient null char-
acters (\u0000) are appended to the string builder so that length becomes the newLength
argument. The newLength argument must be greater than or equal to 0.
The charAt(index) method returns the character at a specific index in the string 
builder. The index is 0 based. The first character of a string builder is at index 0, the next at 
index1, and so on. The index argument must be greater than or equal to 0, and less than the 
length of the string builder.
Note
The length of the string is always less than or equal to the capacity of the builder. The 
length is the actual size of the string stored in the builder, and the capacity is the current 
size of the builder. The builder’s capacity is automatically increased if more characters 
are added to exceed its capacity. Internally, a string builder is an array of characters, so 
the builder’s capacity is the size of the array. If the builder’s capacity is exceeded, the 
array is replaced by a new array. The new array size is 2 * (the previous array 
size + 1).
Tip
You can use new StringBuilder(initialCapacity) to create a String-
Builder with a specified initial capacity. By carefully choosing the initial capacity, you 
can make your program more efficient. If the capacity is always larger than the actual 
length of the builder, the JVM will never need to reallocate memory for the builder. On 
the other hand, if the capacity is too large, you will waste memory space. You can use 
thetrimToSize() method to reduce the capacity to the actual size.
capacity()
length()
setLength(int)
charAt(int)
length and capacity
initial capacity
trimToSize()
10.11 The StringBuilder and StringBuffer Classes 395
```

</details>


## PDF page 419

<details>
<summary>Page text</summary>

```text
396 Chapter 10  Object-Oriented Thinking
10.11.3 Case Study: Ignoring Nonalphanumeric Characters When 
Checking Palindromes
Listing 5.14, Palindrome.java, considered all the characters in a string to check whether it 
is a palindrome. Write a new program that ignores nonalphanumeric characters in checking 
whether a string is a palindrome.
Here are the steps to solve the problem:
1. Filter the string by removing the nonalphanumeric characters. This can be done by 
creating an empty string builder, adding each alphanumeric character in the string 
to a string builder, and returning the string from the string builder. You can use the 
isLetterOrDigit(ch) method in the Character class to check whether character 
ch is a letter or a digit.
2. Obtain a new string that is the reversal of the filtered string. Compare the reversed string 
with the filtered string using the equals method.
The complete program is shown in Listing 10.10.
LISTING 10.10 PalindromeIgnoreNonAlphanumeric.java
 1 import java.util.Scanner;
 2
 3 public class PalindromeIgnoreNonAlphanumeric {
 4 /** Main method */
 5 public static void main(String[] args) {
 6 // Create a Scanner
 7      Scanner input = new Scanner(System.in);
 8
 9 // Prompt the user to enter a string
10      System.out.print("Enter a string: ");
11      String s = input.nextLine();
12
13 // Display result
14      System.out.println("Ignoring nonalphanumeric characters, \nis "
15        + s + " a palindrome? " + isPalindrome(s));
16    }
17
18 /** Return true if a string is a palindrome */
19 public static boolean isPalindrome(String s) {
20 // Create a new string by eliminating nonalphanumeric chars
21      String s1 = filter(s);
22
23 // Create a new string that is the reversal of s1
24      String s2 = reverse(s1);
25
26 // Check if the reversal is the same as the original string
27 return s2.equals(s1);
28    }
29
30 /** Create a new string by eliminating nonalphanumeric chars */
31 public static String filter(String s) {
32 // Create a string builder
33 StringBuilder stringBuilder = new StringBuilder();
34
35 // Examine each char in the string to skip alphanumeric char
36 for (int i = 0; i < s.length(); i++) {
37 if (Character.isLetterOrDigit(s.charAt(i))) {
38 stringBuilder.append(s.charAt(i));
39        }
check palindrome
add letter or digit
```

</details>


## PDF page 420

<details>
<summary>Page text</summary>

```text
40      }
41
42 // Return a new filtered string
43 return stringBuilder.toString();
44    }
45
46 /** Create a new string by reversing a specified string */
47 public static String reverse(String s) {
48      StringBuilder stringBuilder = new StringBuilder(s);
49 stringBuilder.reverse(); // Invoke reverse in StringBuilder
50 return stringBuilder.toString();
51    }
52  }
Enter a string: ab<c>cb?a
Ignoring nonalphanumeric characters,
is ab<c>cb?a a palindrome? true
Enter a string: abcc><?cab
Ignoring nonalphanumeric characters, 
is abcc><?cab a palindrome? false 
Thefilter(String s) method (lines 31–44) examines each character in string s and cop-
ies it to a string builder if the character is a letter or a numeric character. The filter method 
returns the string in the builder. The reverse(String s)  method (lines 47–51) creates a 
new string that reverses the specified string s. The filter and reverse methods both return 
a new string. The original string is not changed.
The program in Listing 5.14 checks whether a string is a palindrome by comparing pairs 
of characters from both ends of the string.  Listing 10.10 uses the reverse method in the 
StringBuilder class to reverse the string, then compares whether the two strings are equal 
to determine whether the original string is a palindrome.
10.26 What is the difference between StringBuilder and StringBuffer?
10.27 How do you create a string builder from a string? How do you return a string from a 
string builder?
10.28 Write three statements to reverse a string s using the reverse method in the 
StringBuilder class.
10.29 Write three statements to delete a substring from a string s of 20 characters, start-
ing at index 4 and ending with index 10. Use the delete method in the String-
Builder class.
10.30 What is the internal storage for characters in a string and a string builder?
10.31 Suppose that s1 and s2 are given as follows:
StringBuilder s1 = new StringBuilder("Java");
StringBuilder s2 = new StringBuilder("HTML");
  Show the value of s1 after each of the following statements. Assume that the state-
ments are independent.
a. s1.append(" is fun");
b. s1.append(s2);
✓Point✓
Check
10.11 The StringBuilder and StringBuffer Classes 397
```

</details>


## PDF page 421

<details>
<summary>Page text</summary>

```text
398 Chapter 10  Object-Oriented Thinking
c. s1.insert(2, "is fun");
d. s1.insert(1, s2);
e. s1.charAt(2);
f. s1.length();
g. s1.deleteCharAt(3);
h. s1.delete(1, 3);
i. s1.reverse();
j. s1.replace(1, 3, "Computer");
k. s1.substring(1, 3);
l. s1.substring(2);
10.32 Show the output of the following program:
public class Test {
public static void main(String[] args) {
    String s = "Java";
    StringBuilder builder = new StringBuilder(s);
    change(s, builder);
    System.out.println(s);
    System.out.println(builder);
  }
private static void change(String s, StringBuilder builder) {
    s = s + " and HTML";
    builder.append(" and HTML");
  }
}
KEY TERMS
abstract data type (ADT) 366
aggregation 374
boxing 383
class abstraction 366
class encapsulation 366
class’s contract 366
composition 374
has-a relationship 374
multiplicity 373
stack 378
unboxing 383
CHAPTER SUMMARY
1. The procedural paradigm focuses on designing methods. The object-oriented paradigm 
couples data and methods together into objects. Software design using the object-
oriented paradigm focuses on objects and operations on objects. The object-oriented 
approach combines the power of the procedural paradigm with an added dimension that 
integrates data with operations into objects.
2. Many Java methods require the use of objects as arguments. Java offers a convenient 
way to incorporate, or wrap, a primitive data type into an object (e.g., wrapping int into 
theInteger class, and wrapping double into the Double class).
```

</details>


## PDF page 422

<details>
<summary>Page text</summary>

```text
Programming Exercises  399
3. Java can automatically convert a primitive type value to its corresponding wrapper 
object in the context and vice versa.
4. TheBigInteger class is useful for computing and processing integers of any size. The 
BigDecimal class can be used to compute and process floating-point numbers with any 
arbitrary precision.
5. AString object is immutable; its contents cannot be changed. To improve efficiency 
and save memory, the JVM stores two literal strings that have the same character 
sequence in a unique object. This unique object is called an interned string object.
6. A regular expression (abbreviated regex) is a string that describes a pattern for match-
ing a set of strings. You can match, replace, or split a string by specifying a pattern.
7. TheStringBuilder and StringBuffer classes can be used to replace the String
class. The String object is immutable, but you can add, insert, or append new contents 
intoStringBuilder and StringBuffer objects. Use String if the string contents 
do not require any change, and use StringBuilder or StringBuffer if they might 
change.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
Sections 10.2–10.3
*10.1 (TheTime class) Design a class named Time. The class contains:
 ■ The data fields hour,minute, and second that represent a time.
 ■ A no-arg constructor that creates a Time object for the current time. (The 
values of the data fields will represent the current time.)
 ■ A constructor that constructs a Time object with a specified elapsed time 
since midnight, January 1, 1970, in milliseconds. (The values of the data 
fields will represent this time.)
■  A constructor that constructs a Time object with the specified hour, minute, 
and second.
 ■ Three getter methods for the data fields hour, minute, and second,
respectively.
 ■ A method named setTime(long elapseTime)  that sets a new time 
for the object using the elapsed time. For example, if the elapsed time is 
555550000 milliseconds, the hour is 10, the minute is 19, and the second is 
10.
Draw the UML diagram for the class and then implement the class. Write 
a test program that creates two Time objects (using new Time()  and new
Time(555550000)) and displays their hour, minute, and second in the format 
hour:minute:second.
(Hint: The first two constructors will extract the hour, minute, and second 
from the elapsed time. For the no-arg constructor, the current time can be 
obtained using System.currentTimeMillis(), as shown in Listing 2.7, 
ShowCurrentTime.java.)
```

</details>


## PDF page 423

<details>
<summary>Page text</summary>

```text
400 Chapter 10  Object-Oriented Thinking
10.2 (TheBMI class) Add the following new constructor in the BMI class:
/** Construct a BMI with the specified name, age, weight, 
 * feet, and inches
 */
public BMI(String name, int age, double weight, double feet, 
double inches) 
10.3 (TheMyInteger class) Design a class named MyInteger. The class contains:
 ■ Anint data field named value that stores the int value represented by this 
object.
 ■ A constructor that creates a MyInteger object for the specified int value.
 ■ A getter method that returns the int value.
 ■ The methods isEven(),isOdd(), and isPrime() that return true if the 
value in this object is even, odd, or prime, respectively.
 ■ The static methods isEven(int),isOdd(int), and isPrime(int) that 
returntrue if the specified value is even, odd, or prime, respectively.
 ■ The static methods isEven(MyInteger), isOdd(MyInteger), and 
isPrime(MyInteger) that return true if the specified value is even, odd, 
or prime, respectively.
 ■ The methods equals(int) and equals(MyInteger) that return true if 
the value in this object is equal to the specified value.
 ■ A static method parseInt(char[]) that converts an array of numeric 
characters to an int value.
 ■ A static method parseInt(String) that converts a string into an int
value.
Draw the UML diagram for the class and then implement the class. Write a cli-
ent program that tests all methods in the class. 
10.4 (TheMyPoint class) Design a class named MyPoint to represent a point with 
x- and y-coordinates. The class contains:
 ■ The data fields x and y that represent the coordinates with getter 
methods.
 ■ A no-arg constructor that creates a point (0,0).
 ■ A constructor that constructs a point with specified coordinates.
 ■ A method named distance that returns the distance from this point to a 
specified point of the MyPoint type.
 ■ A method named distance that returns the distance from this point to 
another point with specified x- and y-coordinates.
Draw the UML diagram for the class and then implement the class. Write a 
test program that creates the two points (0,0) and (10,30.5) and displays the 
distance between them.
Sections 10.4–10.8
*10.5 (Displaying the prime factors ) Write a program that prompts the user to enter 
a positive integer and displays all its smallest factors in decreasing order. For 
example, if the integer is 120, the smallest factors are displayed as 5,3,2,2,
2. Use the StackOfIntegers class to store the factors (e.g., 2,2,2,3,5) and 
retrieve and display them in reverse order.
*10.6 (Displaying the prime numbers ) Write a program that displays all the prime 
numbers less than 120 in decreasing order. Use the StackOfIntegers class 
to store the prime numbers (e.g., 2,3,5,...) and retrieve and display them in 
reverse order.
TheMyPoint class
VideoNote
```

</details>


## PDF page 424

<details>
<summary>Page text</summary>

```text
Programming Exercises  401
**10.7 (Game: ATM machine) Use the Account class created in Programming Exer-
cise 9.7 to simulate an ATM machine. Create ten accounts in an array with id 
0,1, . . . , 9, and initial balance $100. The system prompts the user to enter an 
id. If the id is entered incorrectly, ask the user to enter a correct id. Once an id 
is accepted, the main menu is displayed as shown in the sample run. You can 
enter a choice 1 for viewing the current balance, 2 for withdrawing money, 3 for 
depositing money, and 4 for exiting the main menu. Once you exit, the system 
will prompt for an id again. Thus, once the system starts, it will not stop.
Enter an id: 4
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 1
The balance is 100.0
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 2
Enter an amount to withdraw: 3
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 1
The balance is 97.0
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 3
Enter an amount to deposit: 10
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 1
The balance is 107.0
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 4
Enter an id:
```

</details>


## PDF page 425

<details>
<summary>Page text</summary>

```text
402 Chapter 10  Object-Oriented Thinking
***10.8 (Financial: the Tax class) Programming Exercise 8.12 writes a program for 
computing taxes using arrays. Design a class named Tax to contain the follow-
ing instance data fields:
 ■ int filingStatus: One of the four tax-filing statuses: 0—single filer, 1—
married filing jointly or qualifying widow(er), 2—married filing separately, 
and3—head of household. Use the public static constants SINGLE_FILER
(0), MARRIED_JOINTLY_OR_QUALIFYING_WIDOW(ER) ( 1), MARRIED_
SEPARATELY (2),HEAD_OF_HOUSEHOLD (3) to represent the statuses.
 ■ int[][] brackets: Stores the tax brackets for each filing status.
 ■ double[] rates: Stores the tax rates for each bracket.
 ■ double taxableIncome: Stores the taxable income.
Provide the getter and setter methods for each data field and the getTax()
method that returns the tax. Also provide a no-arg constructor and the construc-
torTax(filingStatus, brackets, rates, taxableIncome).
Draw the UML diagram for the class and then implement the class. Write a test 
program that uses the Tax class to print the 2001 and 2009 tax tables for taxable 
income from $50,000 to $60,000 with intervals of $1,000 for all four statuses. 
The tax rates for the year 2009 were given in Table 3.2. The tax rates for 2001 
are shown in Table 10.1.
Tax rate Single filers
Married filing jointly 
or qualifying widow(er)
Married filing 
separately Head of household
15% Up to $27,050 Up to $45,200 Up to $22,600 Up to $36,250
27.5% $27,051–$65,550 $45,201–$109,250 $22,601–$54,625 $36,251–$93,650
30.5% $65,551–$136,750 $109,251–$166,500 $54,626–$83,250 $93,651–$151,650
35.5% $136,751–$297,350 $166,501–$297,350 $83,251–$148,675 $151,651–$297,350
39.1% $297,351 or more $297,351 or more $ 148,676 or more $297,351 or more
TABLE 10.1  2001 United States Federal Personal Tax Rates
**10.9 (TheCourse class) Revise the Course class as follows:
 ■ The array size is fixed in Listing 10.6. Improve it to automatically increase 
the array size by creating a new larger array and copying the contents of the 
current array to it.
 ■ Implement the dropStudent method.
 ■ Add a new method named clear() that removes all students from the 
course.
Write a test program that creates a course, adds three students, removes one, 
and displays the students in the course.
*10.10 (TheQueue class) Section 10.6 gives a class for Stack. Design a class named 
Queue for storing integers. Like a stack, a queue holds elements. In a stack, the 
elements are retrieved in a last-in first-out fashion. In a queue, the elements are 
retrieved in a first-in first-out fashion. The class contains:
 ■ An int[] data field named elements that stores the int values in the 
queue.
 ■ A data field named size that stores the number of elements in the queue.
 ■ A constructor that creates a Queue object with default capacity 8.
 ■ The method enqueue(int v) that adds v into the queue.
```

</details>


## PDF page 426

<details>
<summary>Page text</summary>

```text
Programming Exercises  403
 ■ The method dequeue() that removes and returns the element from the 
queue.
 ■ The method empty() that returns true if the queue is empty.
 ■ The method getSize() that returns the size of the queue.
Draw an UML diagram for the class. Implement the class with the initial array 
size set to 8. The array size will be doubled once the number of the elements 
exceeds the size. After an element is removed from the beginning of the array, 
you need to shift all elements in the array one position the left. Write a test 
program that adds 20 numbers from 1 to 20 into the queue and removes these 
numbers and displays them.
*10.11 (Geometry: theCircle2D class) Define the Circle2D class that contains:
 ■ Twodouble data fields named x and y that specify the center of the circle 
with getter methods.
 ■ A data field radius with a getter method.
 ■ A no-arg constructor that creates a default circle with (0,0) for (x,y) and 1
forradius.
 ■ A constructor that creates a circle with the specified x,y, and radius.
 ■ A method getArea() that returns the area of the circle.
 ■ A method getPerimeter() that returns the perimeter of the circle.
 ■ A method contains(double x, double y)  that returns true if the 
specified point (x,y) is inside this circle (see Figure 10.21a).
 ■ A method contains(Circle2D circle) that returns true if the speci-
fied circle is inside this circle (see Figure 10.21b).
 ■ A method overlaps(Circle2D circle) that returns true if the speci-
fied circle overlaps with this circle (see Figure 10.21c).
FIGURE 10.21 (a) A point is inside the circle. (b) A circle is inside another circle. (c) A circle 
overlaps another circle.       
(a) (b) (c)
p
Draw the UML diagram for the class and then implement the class. Write a test 
program that creates a Circle2D object c1 (new Circle2D(2, 2, 5.5) ),
displays its area and perimeter, and displays the result of c1.contains(3,
3),c1.contains(new Circle2D(4, 5, 10.5)), and c1.overlaps(new
Circle2D(3, 5, 2.3)).
***10.12 (Geometry: theTriangle2D class) Define the Triangle2D class that contains:
 ■ Three points named p1, p2, and p3 of the type MyPoint with getter and 
setter methods. MyPoint is defined in Programming Exercise 10.4.
 ■ A no-arg constructor that creates a default triangle with the points (0,0), (1,
1), and (2,5).
 ■ A constructor that creates a triangle with the specified points.
 ■ A method getArea() that returns the area of the triangle.
 ■ A method getPerimeter() that returns the perimeter of the triangle.
 ■ A method contains(MyPoint p) that returns true if the specified point 
p is inside this triangle (see Figure 10.22a).
```

</details>


## PDF page 427

<details>
<summary>Page text</summary>

```text
404 Chapter 10  Object-Oriented Thinking
 ■ A method contains(Triangle2D t)  that returns true if the specified 
triangle is inside this triangle (see Figure 10.22b).
 ■ A method overlaps(Triangle2D t)  that returns true if the specified 
triangle overlaps with this triangle (see Figure 10.22c).
FIGURE 10.22 (a) A point is inside the triangle. (b) A triangle is inside another triangle. 
(c) A triangle overlaps another triangle.
(a) (b) (c)
p
FIGURE 10.23 (a) A point is inside the triangle. (b) A point is outside the triangle.
(a) (b)
p
p
Draw the UML diagram for the class and then implement the class. Write 
a test program that creates a Triangle2D objects t1 using the constructor 
new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), 
new MyPoint(5, 3.5)) , displays its area and perimeter, and displays the 
result of t1.contains(3, 3) , r1.contains(new Triangle2D(new 
MyPoint(2.9, 2), new MyPoint(4, 1), MyPoint(1, 3.4))), and t1.
overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, 
-3), MyPoint(2, 6.5))).
(Hint: For the formula to compute the area of a triangle, see Programming Exer-
cise 2.19. To detect whether a point is inside a triangle, draw three dashed lines, 
as shown in Figure  10.23. If the point is inside a triangle, each dashed line 
should intersect a side only once. If a dashed line intersects a side twice, then 
the point must be outside the triangle. For the algorithm of finding the intersect-
ing point of two lines, see Programming Exercise 3.25.)
*10.13 (Geometry: theMyRectangle2D class) Define the MyRectangle2D class that 
contains:
 ■ Two double data fields named x and y that specify the center of the rec-
tangle with getter and setter methods. (Assume that the rectangle sides are 
parallel to x- or y- axes.)
 ■ The data fields width and height with getter and setter methods.
 ■ A no-arg constructor that creates a default rectangle with (0,0) for (x,y) and 
1 for both width and height.
 ■ A constructor that creates a rectangle with the specified x, y, width, and 
height.
```

</details>


## PDF page 428

<details>
<summary>Page text</summary>

```text
Programming Exercises  405
 ■ A method getArea() that returns the area of the rectangle.
 ■ A method getPerimeter() that returns the perimeter of the rectangle.
 ■ A method contains(double x, double y)  that returns true if the 
specified point (x,y) is inside this rectangle (see Figure 10.24a).
 ■ A method contains(MyRectangle2D r) that returns true if the speci-
fied rectangle is inside this rectangle (see Figure 10.24b).
 ■ A method overlaps(MyRectangle2D r) that returns true if the speci-
fied rectangle overlaps with this rectangle (see Figure 10.24c).
FIGURE 10.24 A point is inside the rectangle. (b) A rectangle is inside another rectangle. 
(c) A rectangle overlaps another rectangle. (d) Points are enclosed inside a rectangle.
(a) (b) (c) (d)
p
Draw the UML diagram for the class and then implement the class. Write a test 
program that creates a MyRectangle2D object r1 (new MyRectangle2D(2, 
2, 5.5, 4.9) ), displays its area and perimeter, and displays the result of 
r1.contains(3, 3),r1.contains(new MyRectangle2D(4, 5, 10.5, 
3.2)), and r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)).
*10.14 (TheMyDate class) Design a class named MyDate. The class contains:
 ■ The data fields year, month, and day that represent a date. month is 
0-based, i.e., 0 is for January.
 ■ A no-arg constructor that creates a MyDate object for the current date.
 ■ A constructor that constructs a MyDate object with a specified elapsed time 
since midnight, January 1, 1970, in milliseconds.
 ■ A constructor that constructs a MyDate object with the specified year, 
month, and day.
 ■ Three getter methods for the data fields year,month, and day, respectively.
 ■ A method named setDate(long elapsedTime) that sets a new date for 
the object using the elapsed time.
Draw the UML diagram for the class and then implement the class. Write a 
test program that creates two MyDate objects (using new MyDate() and new
MyDate(34355555133101L)) and displays their year, month, and day.
(Hint: The first two constructors will extract the year, month, and day from 
the elapsed time. For example, if the elapsed time is 561555550000 milli-
seconds, the year is 1987, the month is 9, and the day is 18. You may use the 
GregorianCalendar class discussed in Programming Exercise 9.5 to sim-
plify coding.)
*10.15 (Geometry: the bounding rectangle) A bounding rectangle is the minimum rec-
tangle that encloses a set of points in a two-dimensional plane, as shown in 
Figure 10.24d. Write a method that returns a bounding rectangle for a set of 
points in a two-dimensional plane, as follows:
public static MyRectangle2D getRectangle(double[][] points)
```

</details>


## PDF page 429

<details>
<summary>Page text</summary>

```text
406 Chapter 10  Object-Oriented Thinking
The Rectangle2D class is defined in Programming Exercise 10.13. Write a 
test program that prompts the user to enter five points and displays the bounding 
rectangle’s center, width, and height. Here is a sample run:    
Enter five points: 1.0 2.5 3 4 5 6 7 8 9 10
The bounding rectangle's center (5.0, 6.25), width 8.0, height 7.5
Section 10.9
*10.16 (Divisible by2 or3) Find the first ten numbers with 50 decimal digits that are 
divisible by 2 or 3.
*10.17 (Square numbers ) Find the first ten square numbers that are greater than 
Long.MAX_VALUE. A square number is a number in the form of n2. For exam-
ple, 4, 9, and 16 are square numbers. Find an efficient approach to run your 
program fast.
*10.18 (Large prime numbers) Write a program that finds five prime numbers larger 
thanLong.MAX_VALUE.
*10.19 (Mersenne prime) A prime number is called a Mersenne prime if it can be writ-
ten in the form 2 p - 1 for some positive integer p. Write a program that finds 
all Mersenne primes with p … 100 and displays the output as shown below. 
(Hint: You have to use BigInteger to store the number, because it is too big to 
be stored in long. Your program may take several hours to run.)
      p        2^p – 1
      2           3
      3           7
      5          31
...
*10.20 (Approximate e) Programming Exercise 5.26 approximates e using the following 
series:
e = 1 + 11! + 12! + 13! + 14! + c + 1i!
In order to get better precision, use BigDecimal with 25 digits of precision in 
the computation. Write a program that displays the e value for i = 100,200, . . ., 
and1000.
10.21 (Divisible by5 or6) Find the first ten numbers greater than Long.MAX_VALUE
that are divisible by 5 or 6.
Sections 10.10–10.11
**10.22 (Implement theString class) The String class is provided in the Java library. 
Provide your own implementation for the following methods (name the new 
classMyString1):
public MyString1(char[] chars);
public char charAt(int index);
public int length();
public MyString1 substring(int begin, int end);
public MyString1 toLowerCase();
public boolean equals(MyString1 s);
public static MyString1 valueOf(int i);
```

</details>


## PDF page 430

<details>
<summary>Page text</summary>

```text
Programming Exercises  407
**10.23 (Implement theString class) The String class is provided in the Java library. 
Provide your own implementation for the following methods (name the new 
classMyString2):
public MyString2(String s);
public int compare(String s);
public MyString2 substring(int begin);
public MyString2 toUpperCase();
public char[] toChars();
public static MyString2 valueOf(boolean b);
10.24 (Implement theCharacter class) The Character class is provided in the Java 
library. Provide your own implementation for this class. Name the new class 
MyCharacter.
**10.25 (New stringsplit method) The split method in the String class returns an 
array of strings consisting of the substrings split by the delimiters. However, the 
delimiters are not returned. Implement the following new method that returns 
an array of strings consisting of the substrings split by the matching delimiters, 
including the matching delimiters.
public static String[] split(String s, String regex)
For example, split("ab#12#453", "#")  returns ab, #, 12, #, 453 in an 
array of String, and split("a?b?gf#e", "[?#]") returns a,b,?,b,gf,
#, and e in an array of String.
*10.26 (Calculator) Revise Listing 7.9, Calculator.java, to accept an expression as 
a string in which the operands and operator are separated by zero or more 
spaces. For example, 3+4 and 3 + 4  are acceptable expressions. Here is a 
sample run:
**10.27 (Implement theStringBuilder class) The StringBuilder class is provided 
in the Java library. Provide your own implementation for the following methods 
(name the new class MyStringBuilder1):
public MyStringBuilder1(String s);
public MyStringBuilder1 append(MyStringBuilder1 s);
public MyStringBuilder1 append(int i);
public int length();
public char charAt(int index);
public MyStringBuilder1 toLowerCase();
public MyStringBuilder1 substring(int begin, int end);
public String toString();
```

</details>


## PDF page 431

<details>
<summary>Page text</summary>

```text
408 Chapter 10  Object-Oriented Thinking
**10.28 (Implement theStringBuilder class) The StringBuilder class is provided 
in the Java library. Provide your own implementation for the following methods 
(name the new class MyStringBuilder2):
public MyStringBuilder2();
public MyStringBuilder2(char[] chars);
public MyStringBuilder2(String s);
public MyStringBuilder2 insert(int offset, MyStringBuilder2 s);
public MyStringBuilder2 reverse(); 
public MyStringBuilder2 substring(int begin);
public MyStringBuilder2 toUpperCase();
```

</details>
