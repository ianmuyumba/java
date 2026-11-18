# Chapter 11 Inheritance and Polymorphism

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 432

<details>
<summary>Page text</summary>

```text
INHERITANCE
AND POLYMORPHISM
Objectives
■ To define a subclass from a superclass through inheritance (§11.2).
■ To invoke the superclass’s constructors and methods using the super
keyword (§11.3).
■ To override instance methods in the subclass (§11.4).
■ To distinguish differences between overriding and overloading 
(§11.5).
■ To explore the toString() method in the Object class (§11.6).
■ To discover polymorphism and dynamic binding (§§11.7–11.8).
■ To describe casting and explain why explicit downcasting is necessary 
(§11.9).
■ To explore the equals method in the Object class (§11.10).
■ To store, retrieve, and manipulate objects in an ArrayList (§11.11).
■ To construct an array list from an array, to sort and shuffle a list, and 
to obtain max and min element from a list (§11.12).
■ To implement a Stack class using ArrayList (§11.13).
■ To enable data and methods in a superclass accessible from subclasses 
using the protected visibility modifier (§11.14).
■ To prevent class extending and method overriding using the final
modifier (§11.15).
CHAPTER
11
```

</details>


## PDF page 433

<details>
<summary>Page text</summary>

```text
410 Chapter 11  Inheritance and Polymorphism
11.1 Introduction
Object-oriented programming allows you to define new classes from existing classes. 
This is called inheritance.
As discussed earlier in the book, the procedural paradigm focuses on designing methods and 
the object-oriented paradigm couples data and methods together into objects. Software design 
using the object-oriented paradigm focuses on objects and operations on objects. The object-
oriented approach combines the power of the procedural paradigm with an added dimension 
that integrates data with operations into objects.
Inheritance is an important and powerful feature for reusing software. Suppose you need 
to define classes to model circles, rectangles, and triangles. These classes have many common 
features. What is the best way to design these classes so as to avoid redundancy and make the 
system easy to comprehend and easy to maintain? The answer is to use inheritance.
11.2 Superclasses and Subclasses
Inheritance enables you to define a general class (i.e., a superclass) and later extend it 
to more specialized classes (i.e., subclasses).
You use a class to model objects of the same type. Different classes may have some com-
mon properties and behaviors, which can be generalized in a class that can be shared by other 
classes. You can define a specialized class that extends the generalized class. The specialized 
classes inherit the properties and methods from the general class. 
Consider geometric objects. Suppose you want to design the classes to model geometric 
objects such as circles and rectangles. Geometric objects have many common properties and 
behaviors. They can be drawn in a certain color and be filled or unfilled. Thus a general class 
GeometricObject can be used to model all geometric objects. This class contains the proper-
tiescolor and filled and their appropriate getter and setter methods. Assume that this class 
also contains the dateCreated property and the getDateCreated() and toString()
methods. The toString() method returns a string representation of the object. Since a circle 
is a special type of geometric object, it shares common properties and methods with other 
geometric objects. Thus it makes sense to define the Circle class that extends the Geomet-
ricObject class. Likewise, Rectangle can also be defined as a subclass of GeometricOb-
ject. Figure 11.1 shows the relationship among these classes. A triangular arrow pointing to 
the superclass is used to denote the inheritance relationship between the two classes involved.
In Java terminology, a class C1 extended from another class C2 is called a subclass, and C2
is called a superclass. A superclass is also referred to as a parent class or a base class, and a 
subclass as a child class, an extended class, or a derived class. A subclass inherits accessible 
data fields and methods from its superclass and may also add new data fields and methods.
TheCircle class inherits all accessible data fields and methods from the GeometricObject
class. In addition, it has a new data field, radius, and its associated getter and setter methods. 
The Circle class also contains the getArea(), getPerimeter(), and getDiameter()
methods for returning the area, perimeter, and diameter of the circle.
The Rectangle class inherits all accessible data fields and methods from the Geomet-
ricObject class. In addition, it has the data fields width and height and their associated 
getter and setter methods. It also contains the getArea() and getPerimeter() methods for 
returning the area and perimeter of the rectangle.
The GeometricObject, Circle, and Rectangle classes are shown in Listings 11.1, 
11.2, and 11.3.
Note
To avoid a naming conflict with the improved GeometricObject, Circle,
and Rectangle classes introduced in Chapter  13, we’ll name these classes 
Key
Point
inheritance
why inheritance?
Key
Point
Geometric class hierarchy
VideoNote
subclass
superclass
avoid naming conflicts
```

</details>


## PDF page 434

<details>
<summary>Page text</summary>

```text
11.2 Superclasses and Subclasses  411
SimpleGeometricObject,CircleFromSimpleGeometricObject, and Rec-
tangleFromSimpleGeometricObject in this chapter. For simplicity, we will still 
refer to them in the text as GeometricObject, Circle, and Rectangle classes. 
The best way to avoid naming conflicts is to place these classes in different packages. 
However, for simplicity and consistency, all classes in this book are placed in the default 
package.
LISTING 11.1 SimpleGeometricObject.java
 1 public class SimpleGeometricObject {
 2 private String color = "white";
 3 private boolean filled;
 4 private java.util.Date dateCreated;
 5
 6 /** Construct a default geometric object */
 7 public SimpleGeometricObject() {
8 dateCreated = new java.util.Date();
 9    }
data fields
constructor
date constructed
FIGURE 11.1 TheGeometricObject class is the superclass for Circle and Rectangle.
The color of the object (default: white).
Indicates whether the object is filled with a color (default: false).
The date when the object was created.
Creates a GeometricObject.
Returns the color.
Sets a new color.
Returns the filled property.
Sets a new filled property.
Returns the dateCreated.
Returns a string representation of this object.
GeometricObject
-color: String
-filled: boolean
-dateCreated: java.util.Date
+GeometricObject()
Creates a GeometricObject with the specified color and filled
  values.
+GeometricObject(color: String,
 filled: boolean)
+getColor(): String
+setColor(color: String): void
+isFilled(): boolean
+setFilled(filled: boolean): void
+getDateCreated(): java.util.Date
+toString(): String
Circle
-radius: double 
+Circle()
+Circle(radius: double)
+Circle(radius: double, color: String,
 filled: boolean)
+getRadius(): double
+getArea(): double
+setRadius(radius: double): void
+printCircle(): void
+getPerimeter(): double
+getDiameter(): double
Rectangle
-height: double
+Rectangle()
+Rectangle(width: double, height: double)
+Rectangle(width: double, height: double
 color: String, filled: boolean)
+getWidth(): double
+getHeight(): double
+setHeight(height: double): void
+setWidth(width: double): void
+getArea(): double
+getPerimeter(): double
-width: double
```

</details>


## PDF page 435

<details>
<summary>Page text</summary>

```text
412 Chapter 11  Inheritance and Polymorphism
10
11 /** Construct a geometric object with the specified color
12 *  and filled value */
13 public SimpleGeometricObject(String color, boolean filled) {
14 dateCreated = new java.util.Date();
15 this.color = color;
16 this.filled = filled;
17    }
18
19 /** Return color */
20 public String getColor() {
21 return color;
22    }
23
24 /** Set a new color */
25 public void setColor(String color) {
26 this.color = color;
27    }
28
29 /** Return filled. Since filled is boolean,
30 its getter method is named isFilled */
31 public boolean isFilled() {
32 return filled;
33    }
34
35 /** Set a new filled */
36 public void setFilled(boolean filled) {
37 this.filled = filled;
38    }
39
40 /** Get dateCreated */
41 public java.util.Date getDateCreated() {
42 return dateCreated;
43    }
44
45 /** Return a string representation of this object */
46 public String toString() {
47 return "created on " + dateCreated + "\ncolor: " + color + 
48 " and filled: " + filled;
49    }
50  }
LISTING 11.2 CircleFromSimpleGeometricObject.java
 1 public class CircleFromSimpleGeometricObject 
 2 extends SimpleGeometricObject
 3 private double radius; 
 4
 5 public CircleFromSimpleGeometricObject() {
 6    }
 7
 8 public CircleFromSimpleGeometricObject(double radius) {
 9 this.radius = radius;
10    }
11
12 public CircleFromSimpleGeometricObject(double radius, 
13        String color, boolean filled) {
14 this.radius = radius;
15      setColor(color);
16      setFilled(filled);
extends superclass
data fields
constructor
```

</details>


## PDF page 436

<details>
<summary>Page text</summary>

```text
11.2 Superclasses and Subclasses  413
17    }
18
19 /** Return radius */
20 public double getRadius() {
21 return radius;
22    }
23
24 /** Set a new radius */
25 public void setRadius(double radius) {
26 this.radius = radius;
27    }
28
29 /** Return area */
30 public double getArea() {
31 return radius * radius * Math.PI;
32    }
33
34 /** Return diameter */
35 public double getDiameter() {
36 return 2 * radius;
37    }
38
39 /** Return perimeter */
40 public double getPerimeter() {
41 return 2 * radius * Math.PI;
42    }
43
44 /** Print the circle info */
45 public void printCircle() {
46      System.out.println("The circle is created " + getDateCreated() +
47 " and the radius is " + radius);
48    }
49  }
The Circle class (Listing 11.2) extends the GeometricObject class (Listing 11.1) using 
the following syntax: 
methods
The keyword extends (lines 1–2) tells the compiler that the Circle class extends the 
GeometricObject class, thus inheriting the methods getColor, setColor, isFilled,
setFilled, and toString.
The overloaded constructor Circle(double radius, String color, boolean 
filled) is implemented by invoking the setColor and setFilled methods to set the color
andfilled properties (lines 12–17). These two public methods are defined in the superclass 
GeometricObject and are inherited in Circle, so they can be used in the Circle class.
You might attempt to use the data fields color and filled directly in the constructor as 
follows:
public CircleFromSimpleGeometricObject(
double radius, String color, boolean filled) {
this.radius = radius;
this.color = color; // Illegal 
this.filled = filled; // Illegal
}
private member in superclass
Subclass Superclass
public class Circle extends GeometricObject
```

</details>


## PDF page 437

<details>
<summary>Page text</summary>

```text
414 Chapter 11  Inheritance and Polymorphism
This is wrong, because the private data fields color and filled in the GeometricObject
class cannot be accessed in any class other than in the GeometricObject class itself. The 
only way to read and modify color and filled is through their getter and setter methods.
TheRectangle class (Listing 11.3) extends the GeometricObject class (Listing 11.1) 
using the following syntax:
Subclass Superclass
public class Rectangle extends GeometricObject
The keyword extends (lines 1–2) tells the compiler that the Rectangle class extends the 
GeometricObject class, thus inheriting the methods getColor, setColor, isFilled,
setFilled, and toString.
LISTING 11.3 RectangleFromSimpleGeometricObject.java
 1 public class RectangleFromSimpleGeometricObject 
 2 extends SimpleGeometricObject {
 3 private double width; 
 4 private double height;
 5
 6 public RectangleFromSimpleGeometricObject() {
 7    }
 8
 9 public RectangleFromSimpleGeometricObject(
10 double width, double height) {
11 this.width = width;
12 this.height = height;
13    }
14
15 public RectangleFromSimpleGeometricObject(
16 double width, double height, String color, boolean filled) {
17 this.width = width;
18 this.height = height;
19      setColor(color);
20      setFilled(filled);
21    }
22
23 /** Return width */
24 public double getWidth() {
25 return width;
26    }
27
28 /** Set a new width */
29 public void setWidth(double width) {
30 this.width = width;
31    }
32
33 /** Return height */
34 public double getHeight() {
35 return height;
36    }
37
38 /** Set a new height */
39 public void setHeight(double height) {
40 this.height = height;
41    }
extends superclass
data fields
constructor
methods
```

</details>


## PDF page 438

<details>
<summary>Page text</summary>

```text
11.2 Superclasses and Subclasses  415
42
43 /** Return area */
44 public double getArea() {
45 return width * height;
46    }
47
48 /** Return perimeter */
49 public double getPerimeter() {
50 return 2 * (width + height);
51    }
52  }
The code in Listing 11.4 creates objects of Circle and Rectangle and invokes the methods 
on these objects. The toString() method is inherited from the GeometricObject class 
and is invoked from a Circle object (line 5) and a Rectangle object (line 13).
LISTING 11.4 TestCircleRectangle.java
 1 public class TestCircleRectangle {
 2 public static void main(String[] args) {
 3 CircleFromSimpleGeometricObject circle =
 4 new CircleFromSimpleGeometricObject(1);
 5      System.out.println("A circle " + circle.toString());
 6      System.out.println("The color is " + circle.getColor());
 7      System.out.println("The radius is " + circle.getRadius());
 8      System.out.println("The area is " + circle.getArea());
 9      System.out.println("The diameter is " + circle.getDiameter());
10
11 RectangleFromSimpleGeometricObject rectangle =
12 new RectangleFromSimpleGeometricObject(2, 4);
13      System.out.println("\nA rectangle " + rectangle.toString());
14      System.out.println("The area is " + rectangle.getArea());
15      System.out.println("The perimeter is " + 
16 rectangle.getPerimeter());
17    }
18  }
Circle object
invoketoString
invokegetColor
Rectangle object
invoketoString
A circle created on Thu Feb 10 19:54:25 EST 2011
color: white and filled: false
The color is white
The radius is 1.0
The area is 3.141592653589793
The diameter is 2.0
A rectangle created on Thu Feb 10 19:54:25 EST 2011
color: white and filled: false
The area is 8.0
The perimeter is 12.0
Note the following points regarding inheritance:
 ■ Contrary to the conventional interpretation, a subclass is not a subset of its superclass. 
In fact, a subclass usually contains more information and methods than its superclass.
 ■ Private data fields in a superclass are not accessible outside the class. Therefore, 
they cannot be used directly in a subclass. They can, however, be accessed/mutated 
through public accessors/mutators if defined in the superclass.
more in subclass
private data fields
```

</details>


## PDF page 439

<details>
<summary>Page text</summary>

```text
416 Chapter 11  Inheritance and Polymorphism
 ■ Not all is-a relationships should be modeled using inheritance. For example, a square 
is a rectangle, but you should not extend a Square class from a Rectangle class, 
because the width and height properties are not appropriate for a square. Instead, 
you should define a Square class to extend the GeometricObject class and define 
theside property for the side of a square.
 ■ Inheritance is used to model the is-a relationship. Do not blindly extend a class just 
for the sake of reusing methods. For example, it makes no sense for a Tree class to 
extend a Person class, even though they share common properties such as height 
and weight. A subclass and its superclass must have the is-a relationship.
 ■ Some programming languages allow you to derive a subclass from several classes. 
This capability is known as multiple inheritance. Java, however, does not allow mul-
tiple inheritance. A Java class may inherit directly from only one superclass. This 
restriction is known as single inheritance. If you use the extends keyword to define 
a subclass, it allows only one parent class. Nevertheless, multiple inheritance can be 
achieved through interfaces, which will be introduced in Section 13.4.
11.1 True or false? A subclass is a subset of a superclass.
11.2 What keyword do you use to define a subclass?
11.3 What is single inheritance? What is multiple inheritance? Does Java support multiple 
inheritance?
11.3 Using the super Keyword
The keyword super refers to the superclass and can be used to invoke the super-
class’s methods and constructors.
A subclass inherits accessible data fields and methods from its superclass. Does it inherit 
constructors? Can the superclass’s constructors be invoked from a subclass? This section 
addresses these questions and their ramifications.
Section 9.14, The this Reference, introduced the use of the keyword this to reference 
the calling object. The keyword super refers to the superclass of the class in which super
appears. It can be used in two ways:
 ■ To call a superclass constructor.
 ■ To call a superclass method.
11.3.1 Calling Superclass Constructors
A constructor is used to construct an instance of a class. Unlike properties and methods, the 
constructors of a superclass are not inherited by a subclass. They can only be invoked from 
the constructors of the subclasses using the keyword super.
The syntax to call a superclass’s constructor is:
super(), or super(parameters);
The statement super() invokes the no-arg constructor of its superclass, and the statement 
super(arguments) invokes the superclass constructor that matches the arguments. The 
statementsuper() or super(arguments) must be the first statement of the subclass’s con-
structor; this is the only way to explicitly invoke a superclass constructor. For example, the 
constructor in lines 12–17 in Listing 11.2 can be replaced by the following code:
public CircleFromSimpleGeometricObject(
double radius, String color, boolean filled) {
nonextensible is-a
no blind extension
multiple inheritance
single inheritance
✓Point✓
Check
Key
Point
```

</details>


## PDF page 440

<details>
<summary>Page text</summary>

```text
11.3 Using the super Keyword  417
super(color, filled);
this.radius = radius;
}
Caution
You must use the keyword super to call the superclass constructor, and the call must 
be the first statement in the constructor. Invoking a superclass constructor’s name in a 
subclass causes a syntax error.
11.3.2 Constructor Chaining
A constructor may invoke an overloaded constructor or its superclass constructor. If neither 
is invoked explicitly, the compiler automatically puts super() as the first statement in the 
constructor. For example:
public ClassName() {
  // some statements
}
public ClassName() {
super();
  // some statements
}
public ClassName(double d) {
  // some statements
}
public ClassName(double d) {
super();
  // some statements
}
Equivalent
Equivalent
In any case, constructing an instance of a class invokes the constructors of all the superclasses 
along the inheritance chain. When constructing an object of a subclass, the subclass construc-
tor first invokes its superclass constructor before performing its own tasks. If the superclass 
is derived from another class, the superclass constructor invokes its parent-class constructor 
before performing its own tasks. This process continues until the last constructor along the 
inheritance hierarchy is called. This is called constructor chaining.
Consider the following code:
 1 public class Faculty extends Employee {
 2 public static void main(String[] args) {
 3 new Faculty();
 4    }
 5
 6 public Faculty() {
 7      System.out.println("(4) Performs Faculty's tasks");
 8    }
 9  }
10
11 class Employee extends Person {
12 public Employee() {
13 this("(2) Invoke Employee's overloaded constructor");
14      System.out.println("(3) Performs Employee's tasks ");
15    }
16
17 public Employee(String s) {
18      System.out.println(s);
19    }
20  }
21
22 class Person {
constructor chaining
invoke overloaded 
constructor
```

</details>


## PDF page 441

<details>
<summary>Page text</summary>

```text
418 Chapter 11  Inheritance and Polymorphism
23 public Person() {
24      System.out.println("(1) Performs Person's tasks");
25    }
26  }
(1) Performs Person's tasks
(2) Invoke Employee's overloaded constructor
(3) Performs Employee's tasks
(4) Performs Faculty's tasks
The program produces the preceding output. Why? Let us discuss the reason. In line 3, 
new Faculty()  invokes Faculty’s no-arg constructor. Since Faculty is a subclass of 
Employee, Employee’s no-arg constructor is invoked before any statements in Faculty’s
constructor are executed. Employee’s no-arg constructor invokes Employee’s second con-
structor (line 13). Since Employee is a subclass of Person,Person’s no-arg constructor is 
invoked before any statements in Employee’s second constructor are executed. This process 
is illustrated in the following figure.
Faculty() {
 Performs Faculty's
    tasks;
}
Employee() {
this("(2) ...");
  Performs Employee's
    tasks;
}
Employee(String s) {
  Performs Employee's
    tasks;
}
Person() {
  Performs Person's
    tasks;
}
Caution
If a class is designed to be extended, it is better to provide a no-arg constructor to avoid 
programming errors. Consider the following code:
1 public class Apple extends Fruit {
2  }
3
4 class Fruit {
5 public Fruit(String name) {
6      System.out.println("Fruit's constructor is invoked");
7    }
8  }
Since no constructor is explicitly defined in Apple,Apple’s default no-arg constructor 
is defined implicitly. Since Apple is a subclass of Fruit,Apple’s default constructor 
automatically invokes Fruit’s no-arg constructor. However, Fruit does not have a 
no-arg constructor, because Fruit has an explicit constructor defined. Therefore, the 
program cannot be compiled.
Design Guide
If possible, you should provide a no-arg constructor for every class to make the class 
easy to extend and to avoid errors.
11.3.3 Calling Superclass Methods
The keyword super can also be used to reference a method other than the constructor in the 
superclass. The syntax is:
super.method(parameters);
no-arg constructor
no-arg constructor
```

</details>


## PDF page 442

<details>
<summary>Page text</summary>

```text
11.4 Overriding Methods  419
You could rewrite the printCircle() method in the Circle class as follows:
public void printCircle() {
  System.out.println("The circle is created " + 
super.getDateCreated() + " and the radius is " + radius);
}
It is not necessary to put super before getDateCreated() in this case, however, because 
getDateCreated is a method in the GeometricObject class and is inherited by the Circle
class. Nevertheless, in some cases, as shown in the next section, the keyword super is needed.
11.4 What is the output of running the class C in (a)? What problem arises in compiling the 
program in (b)? ✓Point✓
Check
class A {
public A() {
    System.out.println(
"A's no-arg constructor is invoked");
  }
}
class B extends A {
}
public class C {
public static void main(String[] args) {
    B b = new B();
  }
}
(a)
class A {
public A(int x) {
  }
}
class B extends A {
public B() {
  }
}
public class C {
public static void main(String[] args) {
    B b = new B();
  }
}
(b)
11.5 How does a subclass invoke its superclass’s constructor?
11.6 True or false? When invoking a constructor from a subclass, its superclass’s no-arg 
constructor is always invoked.
11.4 Overriding Methods
To override a method, the method must be defined in the subclass using the same sig-
nature and the same return type as in its superclass.
A subclass inherits methods from a superclass. Sometimes it is necessary for the subclass to modify 
the implementation of a method defined in the superclass. This is referred to as method overriding.
The toString method in the GeometricObject class (lines 46–49 in Listing  11.1) 
returns the string representation of a geometric object. This method can be overridden to 
return the string representation of a circle. To override it, add the following new method in the 
Circle class in Listing 11.2.
1 public class CircleFromSimpleGeometricObject 
2 extends SimpleGeometricObject {
3  // Other methods are omitted
4
5 // Override the toString method defined in the superclass
6 public String toString() {
7 return super.toString() + "\nradius is " + radius;
8    }
9  } 
Key
Point
method overriding
toString in superclass
```

</details>


## PDF page 443

<details>
<summary>Page text</summary>

```text
420 Chapter 11  Inheritance and Polymorphism
ThetoString() method is defined in the GeometricObject class and modified in the Circle
class. Both methods can be used in the Circle class. To invoke the toString method defined in 
theGeometricObject class from the Circle class, use super.toString() (line 7).
Can a subclass of Circle access the toString method defined in the GeometricOb-
ject class using syntax such as super.super.toString()? No. This is a syntax error.
Several points are worth noting:
 ■ An instance method can be overridden only if it is accessible. Thus a private method can-
not be overridden, because it is not accessible outside its own class. If a method defined 
in a subclass is private in its superclass, the two methods are completely unrelated.
 ■ Like an instance method, a static method can be inherited. However, a static method 
cannot be overridden. If a static method defined in the superclass is redefined in a 
subclass, the method defined in the superclass is hidden. The hidden static methods 
can be invoked using the syntax SuperClassName.staticMethodName.
11.7 True or false? You can override a private method defined in a superclass.
11.8 True or false? You can override a static method defined in a superclass.
11.9 How do you explicitly invoke a superclass’s constructor from a subclass?
11.10 How do you invoke an overridden superclass method from a subclass?
11.5 Overriding vs. Overloading
Overloading means to define multiple methods with the same name but different signa-
tures. Overriding means to provide a new implementation for a method in the subclass.
You learned about overloading methods in Section 6.8. To override a method, the method 
must be defined in the subclass using the same signature and the same return type.
Let us use an example to show the differences between overriding and overloading. In (a) 
below, the method p(double i) in class A overrides the same method defined in class B. In 
(b), however, the class A has two overloaded methods: p(double i)  and p(int i) . The 
methodp(double i) is inherited from B.
no super.super.methodName()
override accessible instance 
method
cannot override static method
✓Point✓
Check
Key
Point
public class Test {
public static void main(String[] args) {
    A a = new A();
    a.p(10);
    a.p(10.0);
  }
}
class B {
public void p(double i) {
    System.out.println(i * 2);
  }
}
class A extends B {
  // This method overrides the method in B
public void p(double i) {
    System.out.println(i); 
  }
}
(a)
public class Test {
public static void main(String[] args) {
    A a = new A();
    a.p(10);
    a.p(10.0);
  }
}
class B {
public void p(double i) {
    System.out.println(i * 2);
  }
}
class A extends B {
  // This method overloads the method in B
public void p(int i) {
    System.out.println(i); 
  }
}
(b)
```

</details>


## PDF page 444

<details>
<summary>Page text</summary>

```text
11.5 Overriding vs. Overloading  421
When you run the Test class in (a), both a.p(10) and a.p(10.0) invoke the p(double
i) method defined in class A to display 10.0. When you run the Test class in (b), a.p(10)
invokes the p(int i) method defined in class A to display 10, and a.p(10.0) invokes the 
p(double i) method defined in class B to display 20.0.
Note the following:
 ■ Overridden methods are in different classes related by inheritance; overloaded meth-
ods can be either in the same class or different classes related by inheritance.
 ■ Overridden methods have the same signature and return type; overloaded methods 
have the same name but a different parameter list.
To avoid mistakes, you can use a special Java syntax, called override annotation , to place 
@Override before the method in the subclass. For example:
1 public class CircleFromSimpleGeometricObject 
2 extends SimpleGeometricObject {
3  // Other methods are omitted
4
5 @Override
6 public String toString() {
7 return super.toString() + "\nradius is " + radius;
8    }
9  } 
This annotation denotes that the annotated method is required to override a method in the 
superclass. If a method with this annotation does not override its superclass’s method, the 
compiler will report an error. For example, if toString  is mistyped as tostring, a compile 
error is reported. If the override annotation isn’t used, the compile won’t report an error. Using 
annotation avoids mistakes.
11.11 Identify the problems in the following code:
 1 public class Circle {
 2 private double radius;
 3
 4 public Circle(double radius) {
 5      radius = radius;
 6    }
 7
 8 public double getRadius() {
 9 return radius;
10    }
11
12 public double getArea() {
13 return radius * radius * Math.PI;
14    }
15  }
16
17 class B extends Circle {
18 private double length;
19
20    B(double radius, double length) {
21      Circle(radius);
22      length = length;
23    }
24
25    @Override 
override annotation
toString in superclass
✓Point✓
Check
```

</details>


## PDF page 445

<details>
<summary>Page text</summary>

```text
422 Chapter 11  Inheritance and Polymorphism
26 public double getArea() {
27 return getArea() * length;
28    }
29  }
11.12 Explain the difference between method overloading and method overriding.
11.13 If a method in a subclass has the same signature as a method in its superclass with the 
same return type, is the method overridden or overloaded?
11.14 If a method in a subclass has the same signature as a method in its superclass with a 
different return type, will this be a problem?
11.15 If a method in a subclass has the same name as a method in its superclass with differ-
ent parameter types, is the method overridden or overloaded?
11.16 What is the benefit of using the @Override annotation?
11.6 The Object Class and Its toString() Method
Every class in Java is descended from the java.lang.Object class.
If no inheritance is specified when a class is defined, the superclass of the class is Object by 
default. For example, the following two class definitions are the same:
Key
Point
 public class  ClassName {
   ... 
 }
Equivalent
 public class  ClassName  extends  Object {
   ... 
 }
Classes such as String , StringBuilder , Loan, and GeometricObject  are implic-
itly subclasses of Object  (as are all the main classes you have seen in this book so far). 
It is important to be familiar with the methods provided by the Object  class so that 
you can use them in your classes. This section introduces the toString  method in the 
Object  class.
The signature of the toString() method is:
public String toString()
Invoking toString() on an object returns a string that describes the object. By default, it 
returns a string consisting of a class name of which the object is an instance, an at sign ( @),
and the object’s memory address in hexadecimal. For example, consider the following code 
for the Loan class defined in Listing 10.2:
Loan loan = new Loan();
System.out.println(loan.toString());
The output for this code displays something like Loan@15037e5. This message is not very 
helpful or informative. Usually you should override the toString method so that it returns 
a descriptive string representation of the object. For example, the toString method in the 
Object class was  overridden in the GeometricObject class in lines 46–49 in Listing 11.1 
as follows:
public String toString() {
return "created on " + dateCreated + "\ncolor: " + color + 
" and filled: " + filled;
 }
toString()
string representation
```

</details>


## PDF page 446

<details>
<summary>Page text</summary>

```text
11.7 Polymorphism  423
Note
You can also pass an object to invoke System.out.println(object) or 
System.out.print(object). This is equivalent to invoking System.out
.println(object.toString()) or System.out.print(object.
toString()). Thus, you could replace System.out.println(loan
.toString()) with System.out.println(loan).
11.7 Polymorphism
Polymorphism means that a variable of a supertype can refer to a subtype object.
The three pillars of object-oriented programming are encapsulation, inheritance, and poly-
morphism. You have already learned the first two. This section introduces polymorphism.
First, let us define two useful terms: subtype and supertype. A class defines a type. A 
type defined by a subclass is called a subtype, and a type defined by its superclass is called 
a supertype. Therefore, you can say that Circle is a subtype of GeometricObject and 
GeometricObject is a supertype for Circle.
The inheritance relationship enables a subclass to inherit features from its superclass with 
additional new features. A subclass is a specialization of its superclass; every instance of a 
subclass is also an instance of its superclass, but not vice versa. For example, every circle 
is a geometric object, but not every geometric object is a circle. Therefore, you can always 
pass an instance of a subclass to a parameter of its superclass type. Consider the code in 
Listing 11.5.
LISTING 11.5 PolymorphismDemo.java
 1 public class PolymorphismDemo { 
 2 /** Main method */
 3 public static void main(String[] args) { 
 4 // Display circle and rectangle properties
 5 displayObject( new CircleFromSimpleGeometricObject
 6( 1, "red", false));
 7 displayObject( new RectangleFromSimpleGeometricObject
 8( 1, 1, "black", true));
 9    } 
10
11 /** Display geometric object properties */
12 public static void displayObject(SimpleGeometricObject object) { 
13      System.out.println("Created on " + object.getDateCreated() + 
14 ". Color is " + object.getColor()); 
15    } 
16  }
print object
Key
Point
subtype
supertype
polymorphic call
polymorphic call
Created on Mon Mar 09 19:25:20 EDT 2011. Color is red
Created on Mon Mar 09 19:25:20 EDT 2011. Color is black
The method displayObject (line 12) takes a parameter of the GeometricObject type. 
You can invoke displayObject by passing any instance of GeometricObject (e.g., new
CircleFromSimpleGeometricObject(1, "red", false)  and new Rectangle-
FromSimpleGeometricObject(1, 1, "black", false)  in lines 5–8). An object of 
a subclass can be used wherever its superclass object is used. This is commonly known as 
polymorphism (from a Greek word meaning “many forms”). In simple terms, polymorphism 
means that a variable of a supertype can refer to a subtype object.
what is polymorphism?
```

</details>


## PDF page 447

<details>
<summary>Page text</summary>

```text
424 Chapter 11  Inheritance and Polymorphism
11.8 Dynamic Binding
A method can be implemented in several classes along the inheritance chain. The JVM 
decides which method is invoked at runtime.
A method can be defined in a superclass and overridden in its subclass. For example, the 
toString() method is defined in the Object class and overridden in GeometricObject.
Consider the following code:
Object o = new GeometricObject();
System.out.println(o.toString());
Which toString() method is invoked by o? To answer this question, we first introduce 
two terms: declared type and actual type. A variable must be declared a type. The type that 
declares a variable is called the variable’s declared type. Here o’s declared type is Object. A 
variable of a reference type can hold a null value or a reference to an instance of the declared 
type. The instance may be created using the constructor of the declared type or its subtype. 
The actual type of the variable is the actual class for the object referenced by the variable. 
Hereo’s actual type is GeometricObject, because o references an object created using new
GeometricObject(). Which toString() method is invoked by o is determined by o’s
actual type. This is known as dynamic binding.
Dynamic binding works as follows: Suppose an object o is an instance of classes C1,C2, . . . , 
Cn-1, and Cn, where C1 is a subclass of C2,C2 is a subclass of C3, . . . , and Cn-1 is a subclass of Cn,
as shown in Figure 11.2. That is, Cn is the most general class, and C1 is the most specific class. In 
Java,Cn is the Object class. If o invokes a method p, the JVM searches for the implementation 
of the method p in C1,C2, . . . , Cn-1, and Cn, in this order, until it is found. Once an implementa-
tion is found, the search stops and the first-found implementation is invoked.
Key
Point
declared type
actual type
dynamic binding
FIGURE 11.2 The method to be invoked is dynamically bound at runtime.
.....
java.lang.Object
Ifo is an instance of C1,o is also an
instance of C2,C3,… ,Cn-1, andCn
Cn Cn-1 C2 C1
Listing 11.6 gives an example to demonstrate dynamic binding. 
LISTING 11.6 DynamicBindingDemo.java
 1 public class DynamicBindingDemo { 
 2 public static void main(String[] args) { 
 3m ( new GraduateStudent());
 4      m(new Student()); 
 5      m(new Person()); 
 6      m(new Object()); 
 7    } 
 8
 9 public static void m(Object x) { 
10      System.out.println(x.toString()); 
11    } 
12  } 
13
14 class GraduateStudent extends Student { 
15  } 
16
17 class Student extends Person { 
18    @Override 
19 public String toString() { 
Polymorphism and dynamic 
binding demo
VideoNote
polymorphic call
dynamic binding
overridetoString()
```

</details>


## PDF page 448

<details>
<summary>Page text</summary>

```text
11.8 Dynamic Binding 425
20 return "Student" ; 
21    } 
22  } 
23
24 class Person extends Object { 
25    @Override 
26 public String toString() { 
27 return "Person" ; 
28    } 
29  }
overridetoString()
Student
Student
Person
java.lang.Object@130c19b
Methodm (line 9) takes a parameter of the Object type. You can invoke m with any object 
(e.g.,new GraduateStudent(),new Student(),new Person(), and new Object())
in lines 3–6).
When the method m(Object x)  is executed, the argument x’s toString method is 
invoked. x may be an instance of GraduateStudent, Student, Person, or Object. The 
classesGraduateStudent,Student,Person, and Object have their own implementations 
of the toString method. Which implementation is used will be determined by x’s actual type 
at runtime. Invoking m(new GraduateStudent()) (line 3) causes the toString method 
defined in the Student class to be invoked.
Invokingm(new Student()) (line 4) causes the toString method defined in the Stu-
dent class to be invoked; invoking m(new Person()) (line 5) causes the toString method 
defined in the Person class to be invoked; and invoking m(new Object()) (line 6) causes 
thetoString method defined in the Object class to be invoked.
Matching a method signature and binding a method implementation are two separate 
issues. The declared type of the reference variable decides which method to match at com-
pile time. The compiler finds a matching method according to the parameter type, number of 
parameters, and order of the parameters at compile time. A method may be implemented in 
several classes along the inheritance chain. The JVM dynamically binds the implementation 
of the method at runtime, decided by the actual type of the variable.
11.17 What is polymorphism? What is dynamic binding?
11.18 Describe the difference between method matching and method binding.
11.19 Can you assign new int[50] , new Integer[50] , new String[50] , or new
Object[50], into a variable of Object[] type?
11.20 What is wrong in the following code?
 1 public class Test {
 2 public static void main(String[] args) {
 3       Integer[] list1 = {12, 24, 55, 1};
 4       Double[] list2 = {12.4, 24.0, 55.2, 1.0};
 5 int[] list3 = {1, 2, 3};
 6       printArray(list1);
 7       printArray(list2);
 8       printArray(list3);
 9     }
10
11 public static void printArray(Object[] list) {
12 for (Object o: list)
matching vs. binding
✓Point✓
Check
```

</details>


## PDF page 449

<details>
<summary>Page text</summary>

```text
426 Chapter 11  Inheritance and Polymorphism
13         System.out.print(o + " ");
14       System.out.println();
15     }
16  }
11.21 Show the output of the following code:
public class Test {
public static void main(String[] args) {
new Person().printPerson();
new Student().printPerson();
  }
}
class Student extends Person {
  @Override
public String getInfo() {
return "Student";
  }
}
class Person {
public String getInfo() {
return "Person";
  }
public void printPerson() {
    System.out.println(getInfo());
  }
}
(a)
public class Test {
public static void main(String[] args) {
new Person().printPerson();
new Student().printPerson();
  }
}
class Student extends Person {
private String getInfo() {
return "Student";
  }
}
class Person {
private String getInfo() {
return "Person";
  }
public void printPerson() {
    System.out.println(getInfo());
  }
}
(b)
11.22 Show the output of following program:
 1 public class Test {
 2 public static void main(String[] args) {
 3      A a = new A(3);
 4    }
 5  }
 6
 7 class A extends B {
 8 public A(int t) { 
 9      System.out.println("A's constructor is invoked");
10    }
11  }
12
13 class B {
14 public B() {
15      System.out.println("B's constructor is invoked");
16    }
17  }
  Is the no-arg constructor of Object invoked when new A(3) is invoked?
11.23 Show the output of following program:
public class Test {
public static void main(String[] args) {
new A();
new B();
  }
}
```

</details>


## PDF page 450

<details>
<summary>Page text</summary>

```text
class A {
int i = 7;
public A() {
    setI(20);
    System.out.println("i from A is " + i);
  }
public void setI(int i) {
this.i = 2 * i;
  }
}
class B extends A {
public B() {
    System.out.println("i from B is " + i);
  }
public void setI(int i) {
this.i = 3 * i;
  }
}
11.9 Casting Objects and the instanceof Operator
One object reference can be typecast into another object reference. This is called cast-
ing object.
In the preceding section, the statement
m(new Student());
assigns the object new Student()  to a parameter of the Object type. This statement is 
equivalent to
Object o = new Student(); // Implicit casting
m(o);
The statement Object o = new Student(), known as implicit casting, is legal because an 
instance of Student is an instance of Object.
Suppose you want to assign the object reference o to a variable of the Student type using 
the following statement:
Student b = o;
In this case a compile error would occur. Why does the statement Object o = new Stu-
dent() work but Student b = o doesn’t? The reason is that a Student object is always an 
instance of Object, but an Object is not necessarily an instance of Student. Even though 
you can see that o is really a Student object, the compiler is not clever enough to know it. To 
tell the compiler that o is a Student object, use explicit casting. The syntax is similar to the 
one used for casting among primitive data types. Enclose the target object type in parentheses 
and place it before the object to be cast, as follows:
Student b = (Student)o; // Explicit casting
It is always possible to cast an instance of a subclass to a variable of a superclass (known as 
upcasting), because an instance of a subclass is always an instance of its superclass. When 
casting an instance of a superclass to a variable of its subclass (known as downcasting), explicit 
Key
Point
casting object
implicit casting
explicit casting
upcasting
downcasting
11.9 Casting Objects and the instanceof Operator  427
```

</details>


## PDF page 451

<details>
<summary>Page text</summary>

```text
428 Chapter 11  Inheritance and Polymorphism
casting must be used to confirm your intention to the compiler with the (SubclassName)
cast notation. For the casting to be successful, you must make sure that the object to be cast is 
an instance of the subclass. If the superclass object is not an instance of the subclass, a runtime 
ClassCastException occurs. For example, if an object is not an instance of Student, it 
cannot be cast into a variable of Student. It is a good practice, therefore, to ensure that the 
object is an instance of another object before attempting a casting. This can be accomplished 
by using the instanceof operator. Consider the following code:
Object myObject = new Circle();
... // Some lines of code
/** Perform casting if myObject is an instance of Circle */
if (myObject instanceof Circle) {
  System.out.println("The circle diameter is " + 
    ((Circle)myObject).getDiameter());
  ...
}
You may be wondering why casting is necessary. The variable myObject is declared 
Object. The declared type  decides which method to match at compile time. Using 
myObject.getDiameter()  would cause a compile error, because the Object
class does not have the getDiameter method. The compiler cannot find a match for 
myObject.getDiameter(). Therefore, it is necessary to cast myObject into the Circle
type to tell the compiler that myObject is also an instance of Circle.
Why not define myObject as a Circle type in the first place? To enable generic program-
ming, it is a good practice to define a variable with a supertype, which can accept an object 
of any subtype.
Note
instanceof is a Java keyword. Every letter in a Java keyword is in lowercase.
Tip
To help understand casting, you may also consider the analogy of fruit, apple, and 
orange, with the Fruit class as the superclass for Apple and Orange. An apple is 
a fruit, so you can always safely assign an instance of Apple to a variable for Fruit.
However, a fruit is not necessarily an apple, so you have to use explicit casting to assign 
an instance of Fruit to a variable of Apple.
Listing  11.7 demonstrates polymorphism and casting. The program creates two objects 
(lines 5–6), a circle and a rectangle, and invokes the displayObject method to display them 
(lines 9–10). The displayObject method displays the area and diameter if the object is a 
circle (line 15), and the area if the object is a rectangle (lines 21–22).
LISTING 11.7 CastingDemo.java
 1 public class CastingDemo {
 2 /** Main method */
 3 public static void main(String[] args) {
 4 // Create and initialize two objects
 5      Object object1 = new CircleFromSimpleGeometricObject(1);
 6      Object object2 = new RectangleFromSimpleGeometricObject(1, 1);
 7
 8 // Display circle and rectangle
 9 displayObject(object1);
10 displayObject(object2);
11    }
12
ClassCastException
instanceof
lowercase keywords
casting analogy
```

</details>


## PDF page 452

<details>
<summary>Page text</summary>

```text
13 /** A method for displaying an object */
14 public static void displayObject(Object object) {
15 if (object instanceof CircleFromSimpleGeometricObject) {
16        System.out.println("The circle area is " +
17          ((CircleFromSimpleGeometricObject)object).getArea());
18        System.out.println("The circle diameter is " +
19          ((CircleFromSimpleGeometricObject)object).getDiameter());
20      }
21 else if (object instanceof
22 RectangleFromSimpleGeometricObject) {
23        System.out.println("The rectangle area is " +
24          ((RectangleFromSimpleGeometricObject)object).getArea());
25      }
26    }
27  }
polymorphic call
polymorphic call
11.9 Casting Objects and the instanceof Operator  429
The circle area is 3.141592653589793
The circle diameter is 2.0
The rectangle area is 1.0
ThedisplayObject(Object object) method is an example of generic programming. It 
can be invoked by passing any instance of Object.
The program uses implicit casting to assign a Circle object to object1 and a Rectangle
object to object2 (lines 5–6), then invokes the displayObject method to display the infor-
mation on these objects (lines 9–10).
In the displayObject method (lines 14–26), explicit casting is used to cast the object to 
Circle if the object is an instance of Circle, and the methods getArea and getDiameter
are used to display the area and diameter of the circle.
Casting can be done only when the source object is an instance of the target class. The 
program uses the instanceof operator to ensure that the source object is an instance of the 
target class before performing a casting (line 15).
Explicit casting to Circle (lines 17, 19) and to Rectangle (line 24) is necessary because 
thegetArea and getDiameter methods are not available in the Object class.
Caution
The object member access operator (.) precedes the casting operator. Use parentheses 
to ensure that casting is done before the . operator, as in
        ((Circle)object).getArea();
Casting a primitive type value is different from casting an object reference. Casting a primi-
tive type value returns a new value. For example:
int age = 45;
byte newAge = (byte)age; // A new value is assigned to newAge
However, casting an object reference does not create a new object. For example:
Object o = new Circle();
Circle c = (Circle)o; // No new object is created
Now reference variables o and c point to the same object.
precedes casting
```

</details>


## PDF page 453

<details>
<summary>Page text</summary>

```text
430 Chapter 11  Inheritance and Polymorphism
11.24 Indicate true or false for the following statements:
■ You can always successfully cast an instance of a subclass to a superclass.
■ You can always successfully cast an instance of a superclass to a subclass.
11.25 For the GeometricObject and Circle classes in Listings 11.1 and 11.2, answer the 
following questions:
a. Assume are circle and object created as follows:
Circle circle = new Circle(1);
GeometricObject object = new GeometricObject(); 
  Are the following Boolean expressions true or false?
(circle instanceof GeometricObject)
(object instanceof GeometricObject)
(circle instanceof Circle)
(object instanceof Circle)
b. Can the following statements be compiled?
Circle circle = new Circle(5);
GeometricObject object = circle; 
c. Can the following statements be compiled?
GeometricObject object = new GeometricObject();
Circle circle = (Circle)object;
11.26 Suppose that Fruit, Apple, Orange, GoldenDelicious, and McIntosh are 
defined in the following inheritance hierarchy:
✓Point✓
Check
Fruit
Apple
McIntosh
Orange
GoldenDelicious
  Assume that the following code is given:
Fruit fruit = new GoldenDelicious();
Orange orange = new Orange();
  Answer the following questions:
a. Is fruit instanceof Fruit?
b. Is fruit instanceof Orange?
c. Is fruit instanceof Apple?
d. Is fruit instanceof GoldenDelicious?
e. Is fruit instanceof McIntosh?
f. Is orange instanceof Orange?
```

</details>


## PDF page 454

<details>
<summary>Page text</summary>

```text
g. Is orange instanceof Fruit?
h. Is orange instanceof Apple?
i. Suppose the method makeAppleCider is defined in the Apple class. Can fruit
invoke this method? Can orange invoke this method?
j. Suppose the method makeOrangeJuice is defined in the Orange class. Can 
orange invoke this method? Can fruit invoke this method?
k. Is the statement Orange p = new Apple() legal?
l. Is the statement McIntosh p = new Apple() legal?
m. Is the statement Apple p = new McIntosh() legal?
11.27 What is wrong in the following code?
 1 public class Test {
 2 public static void main(String[] args) {
 3      Object fruit = new Fruit();
 4      Object apple = (Apple)fruit;
 5    }
 6  }
 7
 8 class Apple extends Fruit {
 9  }
10
11 class Fruit {
12  }
11.10 The Object’s equals Method
Like the toString() method, the equals(Object) method is another useful 
method defined in the Object class.
Another method defined in the Object class that is often used is the equals method. Its 
signature is
public boolean equals(Object o)
This method tests whether two objects are equal. The syntax for invoking it is:
object1.equals(object2);
The default implementation of the equals method in the Object class is:
public boolean equals(Object obj) {
return (this == obj);
}
This implementation checks whether two reference variables point to the same object using 
the == operator. You should override this method in your custom class to test whether two 
distinct objects have the same content.
The equals method is overridden in many classes in the Java API, such as java.lang
.String and java.util.Date, to compare whether the contents of two objects are equal. 
You have already used the equals method to compare two strings in Section  4.4.7, The 
String Class. The equals method in the String class is inherited from the Object class 
and is overridden in the String class to test whether two strings are identical in content. 
Key
Point
11.10 The Object’s equals Method  431
```

</details>


## PDF page 455

<details>
<summary>Page text</summary>

```text
432 Chapter 11  Inheritance and Polymorphism
You can override the equals method in the Circle class to compare whether two circles 
are equal based on their radius as follows:
public boolean equals(Object o) {
if (o instanceof Circle)
return radius == ((Circle)o).radius;
else
return this == o;
}
Note
The == comparison operator is used for comparing two primitive data type values or 
for determining whether two objects have the same references. The equals method is 
intended to test whether two objects have the same contents, provided that the method 
is overridden in the defining class of the objects. The == operator is stronger than the 
equals method, in that the == operator checks whether the two reference variables 
refer to the same object.
Caution
Using the signature equals(SomeClassName obj) (e.g., equals(Circle c))
to override the equals method in a subclass is a common mistake. You should use 
equals(Object obj). See CheckPoint Question 11.29.
11.28 Does every object have a toString method and an equals method? Where do they 
come from? How are they used? Is it appropriate to override these methods?
11.29 When overriding the equals method, a common mistake is mistyping its signature
in the subclass. For example, the equals method is incorrectly written as 
equals(Circle circle), as shown in (a) in following the code; instead, it should 
be equals(Object circle) , as shown in (b). Show the output of running class 
Test with the Circle class in (a) and in (b), respectively. 
== vs. equals
equals(Object)
✓Point✓
Check
public class Test {
public static void main(String[] args) {
    Object circle1 = new Circle();
    Object circle2 = new Circle();
    System.out.println(circle1.equals(circle2)); 
  }
}
class Circle {
double radius; 
public boolean equals(Circle circle) {
return this.radius == circle.radius;
  }
}
(a)
class Circle {
double radius; 
public boolean equals(Object circle) {
return this.radius == 
      ((Circle)circle).radius;
  }
}
(b)
11.11 The ArrayList Class
AnArrayList object can be used to store a list of objects. 
Now we are ready to introduce a very useful class for storing objects. You can create an array 
to store objects. But, once the array is created, its size is fixed. Java provides the ArrayList
Key
Point
TheArrayList class
VideoNote
IfObject is replaced by Circle in the Test class, what would be the output to 
runTest using the Circle class in (a) and (b), respectively?
```

</details>


## PDF page 456

<details>
<summary>Page text</summary>

```text
class, which can be used to store an unlimited number of objects. Figure 11.3 shows some 
methods in ArrayList.
11.11 The ArrayList Class 433
FIGURE 11.3 AnArrayList stores an unlimited number of objects.
java.util.ArrayList<E>
+ArrayList()
+add(o: E): void
+add(index: int, o: E): void
+clear(): void
+contains(o: Object): boolean
+get(index: int): E
+indexOf(o: Object): int
+isEmpty(): boolean
+lastIndexOf(o: Object): int
+remove(o: Object): boolean
+size(): int
+remove(index: int): boolean
+set(index: int, o: E): E
Appends a new element o at the end of this list.
Adds a new element o at the specified index in this list.
Removes all the elements from this list.
Returns true if this list contains the element o.
Returns the element from this list at the specified index.
Returns the index of the first matching element in this list.
Returns true if this list contains no elements.
Returns the index of the last matching element in this list.
Removes the first element o from this list. Returns true
     if an element is removed.
Returns the number of elements in this list.
Removes the element at the specified index. Returns true
     if an element is removed.
Sets the element at the specified index.
Creates an empty list.
ArrayList is known as a generic class with a generic type E. You can specify a concrete 
type to replace E when creating an ArrayList. For example, the following statement creates 
anArrayList and assigns its reference to variable cities. This ArrayList object can be 
used to store strings.
ArrayList<String> cities = new ArrayList<String>();
The following statement creates an ArrayList and assigns its reference to variable 
dates. This ArrayList object can be used to store dates.
ArrayList<java.util.Date> dates = new ArrayList<java.util.Date> ();
Note
Since JDK 7, the statement
ArrayList<AConcreteType> list = new ArrayList<AConcreteType>();
can be simplified by
ArrayList<AConcreteType> list = new ArrayList<>();
The concrete type is no longer required in the constructor thanks to a feature called 
type inference. The compiler is able to infer the type from the variable declaration. More
discussions on generics including how to define custom generic classes and methods 
will be introduced in Chapter 19, Generics.
Listing 11.8 gives an example of using ArrayList to store objects. 
LISTING 11.8 TestArrayList.java
 1 import java.util.ArrayList;
 2
type inference
importArrayList
```

</details>


## PDF page 457

<details>
<summary>Page text</summary>

```text
434 Chapter 11  Inheritance and Polymorphism
 3 public class TestArrayList {
 4 public static void main(String[] args) {
 5 // Create a list to store cities
 6 ArrayList<String> cityList = new ArrayList<>();
 7
 8 // Add some cities in the list
 9 cityList.add( "London");
10 // cityList now contains [London]
11      cityList.add("Denver");
12 // cityList now contains [London, Denver]
13      cityList.add("Paris");
14 // cityList now contains [London, Denver, Paris]
15      cityList.add("Miami");
16 // cityList now contains [London, Denver, Paris, Miami]
17      cityList.add("Seoul");
18 // Contains [London, Denver, Paris, Miami, Seoul]
19      cityList.add("Tokyo");
20 // Contains [London, Denver, Paris, Miami, Seoul, Tokyo]
21
22      System.out.println("List size? " + cityList.size());
23      System.out.println("Is Miami in the list? " +
24 cityList.contains( "Miami"));
25      System.out.println("The location of Denver in the list? "
26        + cityList.indexOf("Denver"));
27      System.out.println("Is the list empty? " +
28 cityList.isEmpty()); // Print false
29
30 // Insert a new city at index 2
31      cityList.add(2, "Xian");
32 // Contains [London, Denver, Xian, Paris, Miami, Seoul, Tokyo]
33
34 // Remove a city from the list
35 cityList.remove( "Miami");
36 // Contains [London, Denver, Xian, Paris, Seoul, Tokyo]
37
38 // Remove a city at index 1
39      cityList.remove(1);
40 // Contains [London, Xian, Paris, Seoul, Tokyo]
41
42 // Display the contents in the list
43      System.out.println(cityList.toString());
44
45 // Display the contents in the list in reverse order
46 for (int i = cityList.size() - 1; i >= 0; i––)
47        System.out.print(cityList.get(i) + " ");
48      System.out.println();
49
50 // Create a list to store two circles
51      ArrayList<CircleFromSimpleGeometricObject> list 
52        = new ArrayList<>(); 
53
54 // Add two circles
55      list.add(new CircleFromSimpleGeometricObject(2));
56      list.add(new CircleFromSimpleGeometricObject(3));
57
58 // Display the area of the first circle in the list
59      System.out.println("The area of the circle? " +
60        list.get(0).getArea());
61    }
62  }
createArrayList
add element
list size
contains element?
element index
is empty?
remove element
remove element
toString()
get element
createArrayList
```

</details>


## PDF page 458

<details>
<summary>Page text</summary>

```text
Since the ArrayList is in the java.util package, it is imported in line 1. The program 
creates an ArrayList of strings using its no-arg constructor and assigns the reference to 
cityList (line 6). The add method (lines 9–19) adds strings to the end of list. So, after 
cityList.add("London") (line 9), the list contains
[London]
AftercityList.add("Denver") (line 11), the list contains
[London, Denver]
After adding Paris,Miami,Seoul, and Tokyo (lines 13–19), the list contains
[London, Denver, Paris, Miami, Seoul, Tokyo]
Invoking size() (line 22) returns the size of the list, which is currently 6. Invoking 
contains("Miami") (line 24) checks whether the object is in the list. In this case, it returns 
true, since Miami is in the list. Invoking indexOf("Denver") (line 26) returns the index of 
Denver in the list, which is 1. If Denver were not in the list, it would return -1. The isEmpty()
method (line 28) checks whether the list is empty. It returns false, since the list is not empty.
The statement cityList.add(2, "Xian") (line 31) inserts an object into the list at the 
specified index. After this statement, the list becomes
[London, Denver, Xian, Paris, Miami, Seoul, Tokyo]
The statement cityList.remove("Miami") (line 35) removes the object from the list. 
After this statement, the list becomes
[London, Denver, Xian, Paris, Seoul, Tokyo]
The statement cityList.remove(1) (line 39) removes the object at the specified index 
from the list. After this statement, the list becomes
[London, Xian, Paris, Seoul, Tokyo]
The statement in line 43 is same as
System.out.println(cityList);
The toString() method returns a string representation of the list in the form of 
[e0.toString(), e1.toString(), ..., ek.toString()] , where e0,e1, . . . , and 
ek are the elements in the list.
Theget(index) method (line 47) returns the object at the specified index.
ArrayList objects can be used like arrays, but there are many differences. Table 11.1 lists 
their similarities and differences.
Once an array is created, its size is fixed. You can access an array element using the 
square-bracket notation (e.g., a[index]). When an ArrayList is created, its size is 0.
add(Object)
size()
add(index, Object)
remove(Object)
remove(index)
toString()
get(index)
array vs. ArrayList
List size? 6
Is Miami in the list? True
The location of Denver in the list? 1
Is the list empty? false
[London, Xian, Paris, Seoul, Tokyo]
Tokyo Seoul Paris Xian London
The area of the circle? 12.566370614359172 
11.11 The ArrayList Class 435
```

</details>


## PDF page 459

<details>
<summary>Page text</summary>

```text
436 Chapter 11  Inheritance and Polymorphism
You cannot use the get(index) and set(index, element) methods if the element is not 
in the list. It is easy to add, insert, and remove elements in a list, but it is rather complex to 
add, insert, and remove elements in an array. You have to write code to manipulate the array 
in order to perform these operations. Note that you can sort an array using the java.util.
Arrays.sort(array) method. To sort an array list, use the java.util.Collections.
sort(arraylist) method.
Suppose you want to create an ArrayList for storing integers. Can you use the following 
code to create a list?
ArrayList<int> list = new ArrayList<>();
No. This will not work because the elements stored in an ArrayList must be of an object 
type. You cannot use a primitive data type such as int to replace a generic type. However, 
you can create an ArrayList for storing Integer objects as follows:
ArrayList<Integer> list = new ArrayList<>();
Listing 11.9 gives a program that prompts the user to enter a sequence of numbers and 
displays the distinct numbers in the sequence. Assume that the input ends with 0 and 0 is not 
counted as a number in the sequence.
LISTING 11.9 DistinctNumbers.java
 1 import java.util.ArrayList;
 2 import java.util.Scanner;
 3
 4 public class DistinctNumbers {
 5 public static void main(String[] args) {
 6      ArrayList<Integer> list = new ArrayList<>(); 
 7
 8      Scanner input = new Scanner(System.in);
 9      System.out.print("Enter integers (input ends with 0): ");
10 int value;
11
12 do {
13        value = input.nextInt(); // Read a value from the input
14
15 if (!list.contains(value) && value != 0)
16 list.add(value); // Add the value if it is not in the list
17      } while (value != 0);
create an array list
contained in list?
add to list
Operation Array ArrayList
Creating an array/ArrayList String[] a = new String[10] ArrayList<String> list = new ArrayList<>();
Accessing an element a[index] list.get(index);
Updating an element a[index] = "London"; list.set(index, "London");
Returning size a.length list.size();
Adding a new element list.add("London");
Inserting a new element list.add(index, "London");
Removing an element list.remove(index);
Removing an element list.remove(Object);
Removing all elements list.clear();
TABLE 11.1  Differences and Similarities between Arrays and ArrayList
```

</details>


## PDF page 460

<details>
<summary>Page text</summary>

```text
18
19 // Display the distinct numbers
20 for (int i = 0; i < list.size(); i++) 
21        System.out.print(list.get(i) + " ");
22    }
23  }
Enter numbers (input ends with 0): 1 2 3 2 1 6 3 4 5 4 5 1 2 3 0
The distinct numbers are: 1 2 3 6 4 5
11.11 The ArrayList Class 437
The program creates an ArrayList for Integer objects (line 6) and repeatedly reads a value in 
the loop (lines 12–17). For each value, if it is not in the list (line 15), add it to the list (line 16). You 
can rewrite this program using an array to store the elements rather than using an ArrayList.
However, it is simpler to implement this program using an ArrayList for two reasons. 
 ■ First, the size of an ArrayList is flexible so you don’t have to specify its size in 
advance. When creating an array, its size must be specified. 
 ■ Second, ArrayList contains many useful methods. For example, you can test 
whether an element is in the list using the contains method. If you use an array, 
you have to write additional code to implement this method.
You can traverse the elements in an array using a foreach loop. The elements in an array list 
can also be traversed using a foreach loop using the following syntax:
for (elementType element: arrayList) {
// Process the element
}
For example, you can replace the code in lines 20-21 using the following code:
for (int number: list)
  System.out.print(number + “ “);
11.30 How do you do the following?
a. Create an ArrayList for storing double values?
b. Append an object to a list? 
c. Insert an object at the beginning of a list? 
d. Find the number of objects in a list?
e. Remove a given object from a list? 
f. Remove the last object from the list?
g. Check whether a given object is in a list? 
h. Retrieve an object at a specified index from a list?
11.31 Identify the errors in the following code. 
ArrayList<String> list = new ArrayList<>();
list.add("Denver");
list.add("Austin");
list.add(new java.util.Date());
String city = list.get(0);
list.set(3, "Dallas");
System.out.println(list.get(3));
✓Point✓
Check
```

</details>


## PDF page 461

<details>
<summary>Page text</summary>

```text
438 Chapter 11  Inheritance and Polymorphism
11.32 Suppose the ArrayList list  contains {"Dallas", "Dallas", "Houston", 
"Dallas"}. What is the list after invoking list.remove("Dallas") one time? 
Does the following code correctly remove all elements with value "Dallas" from 
the list? If not, correct the code.
for (int i = 0; i < list.size(); i++)
  list.remove("Dallas");
11.33 Explain why the following code displays [1, 3] rather than [2, 3].
ArrayList<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
list.remove(1);
System.out.println(list);
11.34 Explain why the following code is wrong.
ArrayList<Double> list = new ArrayList<>();
list.add(1);
11.12 Useful Methods for Lists
Java provides the methods for creating a list from an array, for sorting a list, and 
finding maximum and minimum element in a list, and for shuffling a list.
Often you need to create an array list from an array of objects or vice versa. You can write the 
code using a loop to accomplish this, but an easy way is to use the methods in the Java API. 
Here is an example to create an array list from an array:
String[] array = {"red", "green", "blue"};
ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
The static method asList in the Arrays class returns a list that is passed to the ArrayList
constructor for creating an ArrayList. Conversely, you can use the following code to create 
an array of objects from an array list.
String[] array1 = new String[list.size()];
list.toArray(array1);
Invokinglist.toArray(array1) copies the contents from list to array1.
If the elements in a list are comparable such as integers, double, or strings, you can use the 
static sort method in the java.util.Collections class to sort the elements. Here are 
examples:
Integer[] array = {3, 5, 95, 4, 15, 34, 3, 6, 5};
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
java.util.Collections.sort(list);
System.out.println(list);
You can use the static max and min in the java.util.Collections class to return the 
maximum and minimal element in a list. Here are examples:
Integer[] array = {3, 5, 95, 4, 15, 34, 3, 6, 5};
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
System.out.println(java.util.Collections.max(list));
System.out.println(java.util.Collections.min(list));
Key
Point
array to array list
array list to array
sort a list
max and min methods
```

</details>


## PDF page 462

<details>
<summary>Page text</summary>

```text
11.13 Case Study: A Custom Stack Class  439
You can use the static shuffle method in the java.util.Collections class to perform 
a random shuffle for the elements in a list. Here are examples:
Integer[] array = {3, 5, 95, 4, 15, 34, 3, 6, 5};
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
java.util.Collections.shuffle(list);
System.out.println(list);
11.35 Correct errors in the following statements:
int[] array = {3, 5, 95, 4, 15, 34, 3, 6, 5};
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
11.36 Correct errors in the following statements:
int[] array = {3, 5, 95, 4, 15, 34, 3, 6, 5};
System.out.println(java.util.Collections.max(array));
11.13 Case Study: A Custom Stack Class
This section designs a stack class for holding objects. 
Section 10.6 presented a stack class for storing int values. This section introduces a stack class 
to store objects. You can use an ArrayList to implement Stack, as shown in Listing 11.10. 
The UML diagram for the class is shown in Figure 11.4.
shuffle method
✓Point✓
Check
Key
Point
TheMyStack class
VideoNote
FIGURE 11.4 TheMyStack class encapsulates the stack storage and provides the operations 
for manipulating the stack.
Returns true if this stack is empty.
Returns the number of elements in this stack.
Returns the top element in this stack without removing it.
Returns and removes the top element in this stack.
Adds a new element to the top of this stack.
A list to store elements.
MyStack
+isEmpty(): boolean
+getSize(): int
+peek(): Object
+pop(): Object
+push(o: Object): void
-list: ArrayList<Object>
LISTING 11.10 MyStack.java
 1 import java.util.ArrayList;
 2
 3 public class MyStack {
4 private ArrayList<Object> list = new ArrayList<>();
 5
 6 public boolean isEmpty() {
 7 return list.isEmpty();
 8    }
 9
10 public int getSize() {
11 return list.size();
12    }
13
14 public Object peek() {
15 return list.get(getSize() - 1);
16    }
array list
stack empty?
get stack size
peek stack
```

</details>


## PDF page 463

<details>
<summary>Page text</summary>

```text
440 Chapter 11  Inheritance and Polymorphism
17
18 public Object pop() {
19      Object o = list.get(getSize() - 1);
20      list.remove(getSize() - 1);
21 return o;
22    }
23
24 public void push(Object o) {
25      list.add(o);
26    }
27
28    @Override 
29 public String toString() {
30 return "stack: " + list.toString();
31    }
32  }
An array list is created to store the elements in the stack (line 4). The isEmpty() method (lines 
6–8) returns list.isEmpty(). The getSize() method (lines 10–12) returns list.size().
Thepeek() method (lines 14–16) retrieves the element at the top of the stack without remov-
ing it. The end of the list is the top of the stack. The pop() method (lines 18–22) removes the 
top element from the stack and returns it. The push(Object element) method (lines 24–26) 
adds the specified element to the stack. The toString() method (lines 28–31) defined in the 
Object class is overridden to display the contents of the stack by invoking list.toString().
ThetoString() method implemented in ArrayList returns a string representation of all the 
elements in an array list.
Design Guide
In Listing 11.10, MyStack contains ArrayList. The relationship between MyStack
andArrayList is composition. While inheritance models an is-a relationship, compo-
sition models a has-a relationship. You could also implement MyStack as a subclass of 
ArrayList (see Programming Exercise  11.10). Using composition is better, however, 
because it enables you to define a completely new stack class without inheriting the 
unnecessary and inappropriate methods from ArrayList.
11.14 The protected Data and Methods
A protected member of a class can be accessed from a subclass.
So far you have used the private and public keywords to specify whether data fields and 
methods can be accessed from outside of the class. Private members can be accessed only 
from inside of the class, and public members can be accessed from any other classes.
Often it is desirable to allow subclasses to access data fields or methods defined in the 
superclass, but not to allow nonsubclasses to access these data fields and methods. To accom-
plish this, you can use the protected keyword. This way you can access protected data 
fields or methods in a superclass from its subclasses.
The modifiers private,protected, and public are known as visibility or accessibility
modifiers because they specify how classes and class members are accessed. The visibility of 
these modifiers increases in this order: 
remove
push
composition
is-a
has-a
Key
Point
whyprotected?
Visibility increases
private, default (no modifier), protected, public
Table 11.2 summarizes the accessibility of the members in a class. Figure 11.5 illustrates how 
a public, protected, default, and private datum or method in class C1 can be accessed from a 
classC2 in the same package, from a subclass C3 in the same package, from a subclass C4 in 
a different package, and from a class C5 in a different package.
```

</details>


## PDF page 464

<details>
<summary>Page text</summary>

```text
Your class can be used in two ways: (1) for creating instances of the class and (2) for defin-
ing subclasses by extending the class. Make the members private if they are not intended 
for use from outside the class. Make the members public if they are intended for the users of 
the class. Make the fields or methods protected if they are intended for the extenders of the 
class but not for the users of the class.
The private and protected modifiers can be used only for members of the class. 
The public modifier and the default modifier (i.e., no modifier) can be used on members of 
the class as well as on the class. A class with no modifier (i.e., not a public class) is not acces-
sible by classes from other packages.
FIGURE 11.5 Visibility modifiers are used to control how data and methods are accessed.
public class C1 {
public int x;
protected int y;
int z;
private int u;
protected void m() {
}
}
packagep1;
packagep2;
public class C2 {
C1 o = new C1();
can access o.x;
can access o.y;
can access o.z;
cannot access o.u;
can invoke o.m();
}
public class C3
extends C1 {
can access x;
can access y;
can access z;
cannot access u;
can invoke m();
}
public class C4
extends C1 {
can access x;
can access y;
cannot access z;
cannot access u;
can invoke m();
}
public class C5 {
C1 o = new C1();
can access o.x;
cannot access o.y;
cannot access o.z;
cannot access o.u;
cannot invoke o.m();
}
Modifier
on members 
in a class
Accessed
from the 
same class
Accessed
from the 
same package
Accessed from 
a subclass in a 
different package 
Accessed
from a different 
package
public ✓✓ ✓ ✓
protected ✓✓ ✓ –
default (no modifier) ✓✓ ––
private ✓ –– –
TABLE 11.2  Data and Methods Visibility
11.14 The protected Data and Methods  441
Use the private modifier to hide the members of the class completely so that they cannot 
be accessed directly from outside the class. Use no modifiers (the default) in order to allow 
the members of the class to be accessed directly from any class within the same package but 
not from other packages. Use the protected modifier to enable the members of the class to 
be accessed by the subclasses in any package or classes in the same package. Use the public
modifier to enable the members of the class to be accessed by any class.
```

</details>


## PDF page 465

<details>
<summary>Page text</summary>

```text
442 Chapter 11  Inheritance and Polymorphism
Note
A subclass may override a protected method defined in its superclass and change its 
visibility to public. However, a subclass cannot weaken the accessibility of a method 
defined in the superclass. For example, if a method is defined as public in the superclass, 
it must be defined as public in the subclass.
11.37 What modifier should you use on a class so that a class in the same package can 
access it, but a class in a different package cannot access it?
11.38 What modifier should you use so that a class in a different package cannot access the 
class, but its subclasses in any package can access it?
11.39 In the following code, the classes A and B are in the same package. If the question 
marks in (a) are replaced by blanks, can class B be compiled? If the question marks 
are replaced by private, can class B be compiled? If the question marks are replaced 
byprotected, can class B be compiled?
change visibility
✓Point✓
Check
11.40 In the following code, the classes A and B are in different packages. If the question 
marks in (a) are replaced by blanks, can class B be compiled? If the question marks 
are replaced by private, can class B be compiled? If the question marks are replaced 
byprotected, can class B be compiled?
11.15 Preventing Extending and Overriding
Neither a final class nor a final method can be extended. A final data field is a 
constant.
You may occasionally want to prevent classes from being extended. In such cases, use the 
final modifier to indicate that a class is final and cannot be a parent class. The Math class 
is a final class. The String, StringBuilder, and StringBuffer classes are also final 
classes. For example, the following class A is final and cannot be extended:
public final class A {
// Data fields, constructors, and methods omitted
}
Key
Point
package p1;
public class A {
  ? int i; 
  ? void m() {
    ... 
  }
}
(a)
package p1;
public class B extends A {
public void m1(String[] args) {
    System.out.println(i); 
    m();
  }
}
(b)
package p1;
public class A {
  ? int i; 
  ? void m() {
    ... 
  }
}
(a)
package p2;
public class B extends A {
public void m1(String[] args) {
    System.out.println(i); 
    m();
  }
}
(b)
```

</details>


## PDF page 466

<details>
<summary>Page text</summary>

```text
You also can define a method to be final; a final method cannot be overridden by its 
subclasses.
For example, the following method m is final and cannot be overridden:
public class Test {
// Data fields, constructors, and methods omitted
public final void m() {
// Do something
  }
}
Note
The modifiers public,protected,private,static,abstract, and final are 
used on classes and class members (data and methods), except that the final modifier 
can also be used on local variables in a method. A final local variable is a constant 
inside a method.
11.41 How do you prevent a class from being extended? How do you prevent a method from 
being overridden?
11.42 Indicate true or false for the following statements:
a. A protected datum or method can be accessed by any class in the same package.
b. A protected datum or method can be accessed by any class in different packages.
c. A protected datum or method can be accessed by its subclasses in any package.
d. A final class can have instances.
e. A final class can be extended.
f. A final method can be overridden.
✓Point✓
Check
KEY TERMS
actual type 424
casting objects 427
constructor chaining 417
declared type 424
dynamic binding 424
inheritance 410
instanceof 428
is-a relationship 440
method overriding 419
multiple inheritance 416
override 000
polymorphism 423
protected 440
single inheritance 416
subclass 410
subtype 423
superclass 410
supertype 423
type inference 433
CHAPTER SUMMARY
1. You can define a new class from an existing class. This is known as class inheritance.
The new class is called a subclass, child class, or extended class. The existing class is 
called a superclass, parent class, or base class.
2. A constructor is used to construct an instance of a class. Unlike properties and methods, 
the constructors of a superclass are not inherited in the subclass. They can be invoked 
only from the constructors of the subclasses, using the keyword super.
Chapter Summary  443
```

</details>


## PDF page 467

<details>
<summary>Page text</summary>

```text
444 Chapter 11  Inheritance and Polymorphism
3. A constructor may invoke an overloaded constructor or its superclass’s constructor. The 
call must be the first statement in the constructor. If none of them is invoked explicitly, 
the compiler puts super() as the first statement in the constructor, which invokes the 
superclass’s no-arg constructor.
4. To override a method, the method must be defined in the subclass using the same sig-
nature and the same return type as in its superclass.
5. An instance method can be overridden only if it is accessible. Thus, a private method 
cannot be overridden because it is not accessible outside its own class. If a method 
defined in a subclass is private in its superclass, the two methods are completely 
unrelated.
6. Like an instance method, a static method can be inherited. However, a static method 
cannot be overridden. If a static method defined in the superclass is redefined in a sub-
class, the method defined in the superclass is hidden.
7. Every class in Java is descended from the java.lang.Object class. If no superclass 
is specified when a class is defined, its superclass is Object.
8. If a method’s parameter type is a superclass (e.g., Object), you may pass an object 
to this method of any of the parameter’s subclasses (e.g., Circle or String). This is 
known as polymorphism.
9. It is always possible to cast an instance of a subclass to a variable of a superclass, 
because an instance of a subclass is always an instance of its superclass. When cast-
ing an instance of a superclass to a variable of its subclass, explicit casting must 
be used to confirm your intention to the compiler with the ( SubclassName ) cast 
notation.
10. A class defines a type. A type defined by a subclass is called a subtype and a type 
defined by its superclass is called a supertype.
11. When invoking an instance method from a reference variable, the actual type of  the 
variable decides which implementation of the method is used at runtime. This is known 
as dynamic binding.
12. You can use obj instanceof AClass  to test whether an object is an instance of a 
class.
13. You can use the ArrayList class to create an object to store a list of objects. 
14. You can use the protected modifier to prevent the data and methods from being 
accessed by nonsubclasses from a different package.
15. You can use the final modifier to indicate that a class is final and cannot be extended 
and to indicate that a method is final and cannot be overridden.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
```

</details>


## PDF page 468

<details>
<summary>Page text</summary>

```text
Programming Exercises  445
PROGRAMMING EXERCISES
Sections 11.2–11.4
11.1 (The Triangle class) Design a class named Triangle that extends 
GeometricObject. The class contains:
 ■ Three double data fields named side1, side2, and side3 with default 
values1.0 to denote three sides of the triangle.
 ■ A no-arg constructor that creates a default triangle.
 ■ A constructor that creates a triangle with the specified side1, side2, and 
side3.
 ■ The accessor methods for all three data fields.
 ■ A method named getArea() that returns the area of this triangle.
 ■ A method named getPerimeter() that returns the perimeter of this triangle.
 ■ A method named toString() that returns a string description for the triangle.
For the formula to compute the area of a triangle, see Programming Exercise 2.19.
ThetoString() method is implemented as follows:
return "Triangle: side1 = " + side1 + " side2 = " + side2 +
" side3 = " + side3;
Draw the UML diagrams for the classes Triangle and GeometricObject and 
implement the classes. Write a test program that prompts the user to enter three 
sides of the triangle, a color, and a Boolean value to indicate whether the triangle 
is filled. The program should create a Triangle object with these sides and set 
thecolor and filled properties using the input. The program should display 
the area, perimeter, color, and true or false to indicate whether it is filled or not.
Sections 11.5–11.14
11.2 (The Person, Student, Employee, Faculty, and Staff classes) Design a 
class named Person and its two subclasses named Student and Employee.
Make Faculty and Staff subclasses of Employee. A person has a name, 
address, phone number, and email address. A student has a class status (freshman,
sophomore, junior, or senior). Define the status as a constant. An employee has 
an office, salary, and date hired. Use the MyDate class defined in Programming 
Exercise 10.14 to create an object for date hired. A faculty member has office 
hours and a rank. A staff member has a title. Override the toString method in 
each class to display the class name and the person’s name.
Draw the UML diagram for the classes and implement them. Write a test pro-
gram that creates a Person, Student, Employee, Faculty, and Staff, and 
invokes their toString() methods.
11.3 (Subclasses ofAccount) In Programming Exercise 9.7, the Account class was 
defined to model a bank account. An account has the properties account number, 
balance, annual interest rate, and date created, and methods to deposit and with-
draw funds. Create two subclasses for checking and saving accounts. A checking 
account has an overdraft limit, but a savings account cannot be overdrawn.
Draw the UML diagram for the classes and then implement them. Write 
a test program that creates objects of Account, SavingsAccount, and 
CheckingAccount and invokes their toString() methods.
11.4 (Maximum element inArrayList) Write the following method that returns the 
maximum value in an ArrayList of integers. The method returns null if the 
list is null or the list size is 0.
public static Integer max(ArrayList<Integer> list)
```

</details>


## PDF page 469

<details>
<summary>Page text</summary>

```text
446 Chapter 11  Inheritance and Polymorphism
Write a test program that prompts the user to enter a sequence of numbers ending 
with0, and invokes this method to return the largest number in the input.
11.5 (TheCourse class) Rewrite the Course class in Listing 10.6. Use an ArrayList
to replace an array to store students. Draw the new UML diagram for the class. 
You should not change the original contract of the Course class (i.e., the defi-
nition of the constructors and methods should not be changed, but the private 
members may be changed.)
11.6 (UseArrayList) Write a program that creates an ArrayList and adds a Loan
object, a Date object, a string, and a Circle object to the list, and use a loop 
to display all the elements in the list by invoking the object’s toString()
method.
11.7 (ShuffleArrayList) Write the following method that shuffles the elements in 
anArrayList of integers. 
public static void shuffle(ArrayList<Integer> list) 
**11.8 (New Account class)A n Account class was specified in Programming 
Exercise 9.7. Design a new Account class as follows:
 ■ Add a new data field name of the String type to store the name of the 
customer.
 ■ Add a new constructor that constructs an account with the specified name, id, 
and balance.
 ■ Add a new data field named transactions whose type is ArrayList
that stores the transaction for the accounts. Each transaction is an instance 
of the Transaction class. The Transaction class is defined as shown in 
Figure 11.6.
New Account class
VideoNote
FIGURE 11.6 TheTransaction class describes a transaction for a bank account.
Transaction
Thegetter and setter methods for these data
fields are provided in the class, but omitted in the UML
diagram for brevity.
The date of this transaction.
The type of the transaction, such as 'W' for withdrawal, 'D'
  for deposit.
The amount of the transaction.
The new balance after this transaction.
Construct a Transaction with the specified date, type,
   balance, and description.
The description of this transaction.
+Transaction(type: char,
amount: double, balance:
double, description: String)
-date: java.util.Date
-type: char
-amount: double
-balance: double
-description: String
 ■ Modify the withdraw and deposit methods to add a transaction to the 
transactions array list.
 ■ All other properties and methods are the same as in Programming Exercise 9.7.
Write a test program that creates an Account with annual interest rate 1.5%,
balance 1000, id 1122, and name George. Deposit $30, $40, and $50 to the 
account and withdraw $5, $4, and $2 from the account. Print an account sum-
mary that shows account holder name, interest rate, balance, and all transactions.
```

</details>


## PDF page 470

<details>
<summary>Page text</summary>

```text
Programming Exercises  447
*11.9 (Largest rows and columns ) Write a program that randomly fills in 0s and 1s
into an n-by-n matrix, prints the matrix, and finds the rows and columns with the 
most1s. (Hint: Use two ArrayLists to store the row and column indices with 
the most 1s.) Here is a sample run of the program:
Enter ten integers: 34 5 3 5 6 4 33 2 2 4
The distinct integers are 34 5 3 6 4 33 2 
Enter the array size n: 4
The random array is
0011
0011
1101
1010
The largest row index: 2
The largest column index: 2, 3 
11.10 (Implement MyStack using inheritance) In Listing 11.10 , MyStack is imple-
mented using composition. Define a new stack class that extends ArrayList.
Draw the UML diagram for the classes and then implement MyStack. Write 
a test program that prompts the user to enter five strings and displays them in 
reverse order.
11.11 (Sort ArrayList) Write the following method that sorts an ArrayList of 
numbers:
public static void sort(ArrayList<Integer> list)
Write a test program that prompts the user to enter 5 numbers, stores them in an 
array list, and displays them in increasing order.
11.12 (SumArrayList) Write the following method that returns the sum of all num-
bers in an ArrayList:
public static double sum(ArrayList<Double> list)
Write a test program that prompts the user to enter 5 numbers, stores them in an 
array list, and displays their sum.
*11.13 (Remove duplicates) Write a method that removes the duplicate elements from 
an array list of integers using the following header:
public static void removeDuplicate(ArrayList<Integer> list)
Write a test program that prompts the user to enter 10 integers to a list and dis-
plays the distinct integers separated by exactly one space. Here is a sample run:
11.14 (Combine two lists) Write a method that returns the union of two array lists of 
integers using the following header:
public static ArrayList<Integer> union(
  ArrayList<Integer> list1, ArrayList<Integer> list2)
```

</details>


## PDF page 471

<details>
<summary>Page text</summary>

```text
448 Chapter 11  Inheritance and Polymorphism
For example, the union of two array lists {2, 3, 1, 5} and {3, 4, 6} is 
{2, 3, 1, 5, 3, 4, 6}. Write a test program that prompts the user to enter two lists, 
each with five integers, and displays their union. The numbers are separated by 
exactly one space in the output. Here is a sample run:
Enter five integers for list1: 3 5 45 4 3
Enter five integers for list2: 33 51 5 4 13
The combined list is 3 5 45 4 3 33 51 5 4 13
Enter the number of the points: 7
Enter the coordinates of the points: 
-12 0 -8.5 10 0 11.4 5.5 7.8 6 -5.5 0 -7 -3.5 -3.5
The total area is 250.075 
What is 5 + 9? 12
Wrong answer. Try again. What is 5 + 9? 34
Wrong answer. Try again. What is 5 + 9? 12
You already entered 12
Wrong answer. Try again. What is 5 + 9? 14
You got it!
Enter an integer m: 1500
The smallest number n for m * n to be a perfect square is 15 
m * n is 22500
Enter an integer m: 63
The smalle
st number n for m * n to be a perfect square is 7 
m * n is 441
*11.15 (Area of a convex polygon) A polygon is convex if it contains any line segments 
that connects two points of the polygon. Write a program that prompts the user to 
enter the number of points in a convex polygon, then enter the points clockwise, 
and display the area of the polygon. Here is a sample run of the program:
**11.16 (Addition quiz) Rewrite Listing 5.1 RepeatAdditionQuiz.java to alert the user 
if an answer is entered again. Hint: use an array list to store answers. Here is a 
sample run: 
**11.17 (Algebra: perfect square) Write a program that prompts the user to enter an inte-
germ and find the smallest integer n such that m * n is a perfect square. (Hint:
Store all smallest factors of m into an array list. n is the product of the factors that 
appear an odd number of times in the array list. For example, consider m = 90,
store the factors 2, 3, 3, 5 in an array list. 2 and 5 appear an odd number of times 
in the array list. So, n is 10.) Here are sample runs:
```

</details>
