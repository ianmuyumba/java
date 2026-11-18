# Chapter 19 Generics

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 760

<details>
<summary>Page text</summary>

```text
GENERICS
Objectives
■ To descriibe the benefits of generics (§19.2).
■ To use generic classes and interfaces (§19.2).
■ To define generic classes and interfaces (§19.3).
■ To explain why generic types can improve reliability and readability 
(§19.3).
■ To define and use generic methods and bounded generic types (§19.4).
■ To develop a generic sort method to sort an array of Comparable
objects (§19.5).
■ To use raw types for backward compatibility (§19.6).
■ To explain why wildcard generic types are necessary (§19.7).
■ To describe generic type erasure and list certain restrictions and 
limitations on generic types caused by type erasure (§19.8).
■ To design and implement generic matrix classes (§19.9).
CHAPTER
19
```

</details>


## PDF page 761

<details>
<summary>Page text</summary>

```text
738 Chapter 19 Generics
19.1 Introduction
Generics enable you to detect errors at compile time rather than at runtime.
You have used a generic class ArrayList in Chapter 11 and generic interface Comparable
in Chapter 13. Generics let you parameterize types. With this capability, you can define a 
class or a method with generic types that the compiler can replace with concrete types. For 
example, Java defines a generic ArrayList class for storing the elements of a generic type. 
From this generic class, you can create an ArrayList object for holding strings and an 
ArrayList object for holding numbers. Here, strings and numbers are concrete types that 
replace the generic type.
The key benefit of generics is to enable errors to be detected at compile time rather than 
at runtime. A generic class or method permits you to specify allowable types of objects that 
the class or method can work with. If you attempt to use an incompatible object, the compiler 
will detect that error.
This chapter explains how to define and use generic classes, interfaces, and methods and 
demonstrates how generics can be used to improve software reliability and readability. It can 
be intertwined with Chapter 13, Abstract Classes and Interfaces.
19.2 Motivations and Benefits
The motivation for using Java generics is to detect errors at compile time.
Java has allowed you to define generic classes, interfaces, and methods since JDK 1.5. Several 
interfaces and classes in the Java API were modified using generics. For example, prior to 
JDK 1.5 the java.lang.Comparable interface was defined as shown in Figure 19.1a, but 
since JDK 1.5 it is modified as shown in Figure 19.1b.
Key
Point
what is generics?
why generics?
Key
Point
package java.lang;
public interface Comparable {
  public int compareTo(Object o)
}
(a) Prior to JDK 1.5
package java.lang;
public interface Comparable<T> {
  public int compareTo(T o)
}
(b) JDK 1.5 
FIGURE 19.1 Thejava.lang.Comparable interface was modified in JDK 1.5 with a 
generic type 
Here, <T> represents a formal generic type , which can be replaced later with an actual
concrete type. Replacing a generic type is called a generic instantiation. By convention, a 
single capital letter such as E or T is used to denote a formal generic type.
To see the benefits of using generics, let us examine the code in Figure 19.2. The statement 
in Figure 19.2a declares that c is a reference variable whose type is Comparable and invokes 
thecompareTo method to compare a Date object with a string. The code compiles fine, but 
it has a runtime error because a string cannot be compared with a date.
formal generic type
actual concrete type
generic instantiation
Comparable c = new Date();
System.out.println(c.compareTo("red"));
(a) Prior to JDK 1.5
Comparable<Date> c = new Date();
System.out.println(c.compareTo("red"));
(b) JDK 1.5
FIGURE 19.2 The new generic type detects possible errors at compile time.
The statement in Figure  19.2b declares that c is a reference variable whose type is 
Comparable<Date> and invokes the compareTo method to compare a Date object with a 
string. This code generates a compile error, because the argument passed to the compareTo
```

</details>


## PDF page 762

<details>
<summary>Page text</summary>

```text
19.2 Motivations and Benefits  739
method must be of the Date type. Since the errors can be detected at compile time rather than 
at runtime, the generic type makes the program more reliable. 
ArrayList was introduced in Section 11.11, The ArrayList Class. This class has been a 
generic class since JDK 1.5. Figure 19.3 shows the class diagram for ArrayList before and 
since JDK 1.5, respectively.
reliable
FIGURE 19.3 ArrayList is a generic class since JDK 1.5.
(a)ArrayList before JDK 1.5
+ArrayList()
+add(o: Object): void
+add(index: int, o: Object): void
+clear(): void
+contains(o: Object): boolean
+get(index:int): Object
+indexOf(o: Object): int
+isEmpty(): boolean
+lastIndexOf(o: Object): int
+remove(o: Object): boolean
+size(): int
+remove(index: int): boolean
+set(index: int, o: Object): Object
java.util.ArrayList
(b)ArrayList since JDK 1.5
+ArrayList()
+clear(): void
+contains(o: Object): boolean
+indexOf(o: Object): int
+isEmpty(): boolean
+lastIndexOf(o: Object): int
+remove(o: Object): boolean
+size(): int
+remove(index: int): boolean
java.util.ArrayList<E>
+add(o: E): void
+add(index: int, o: E): void
+get(index:int): E
+set(index: int, o: E): E
For example, the following statement creates a list for strings:
ArrayList<String> list = new ArrayList<>();
You can now add only strings into the list. For instance,
list.add("Red");
If you attempt to add a nonstring, a compile error will occur. For example, the following state-
ment is now illegal, because list can contain only strings.
list.add(new Integer(1));
Generic types must be reference types. You cannot replace a generic type with a primitive 
type such as int,double, or char. For example, the following statement is wrong:
ArrayList<int> intList = new ArrayList<>();
To create an ArrayList object for int values, you have to use:
ArrayList<Integer> intList = new ArrayList<>();
You can add an int value to intList. For example,
intList.add(5);
Java automatically wraps 5 into new Integer(5) . This is called autoboxing , as intro-
duced in Section  10.8, Automatic Conversion between Primitive Types and Wrapper 
Class Types.
only strings allowed
generic reference type
autoboxing
```

</details>


## PDF page 763

<details>
<summary>Page text</summary>

```text
740 Chapter 19 Generics
Casting is not needed to retrieve a value from a list with a specified element type, because 
the compiler already knows the element type. For example, the following statements create a 
list that contains strings, add strings to the list, and retrieve strings from the list.
1  ArrayList<String> list = new ArrayList<>();
2  list.add("Red");
3  list.add("White");
4  String s = list.get(0); // No casting is needed
Prior to JDK 1.5, without using generics, you would have had to cast the return value to 
String as:
String s = (String)(list.get(0)); // Casting needed prior to JDK 1.5
If the elements are of wrapper types, such as Integer, Double, and Character, you can 
directly assign an element to a primitive type variable. This is called autounboxing, as intro-
duced in Section 10.8. For example, see the following code: 
1  ArrayList<Double> list = new ArrayList<>();
2  list.add(5.5); // 5.5 is automatically converted to new Double(5.5)
3  list.add(3.0); // 3.0 is automatically converted to new Double(3.0)
4  Double doubleObject = list.get(0); // No casting is needed
5 double d = list.get(1); // Automatically converted to double
In lines 2 and 3, 5.5 and 3.0 are automatically converted into Double objects and added to 
list. In line 4, the first element in list is assigned to a Double variable. No casting is nec-
essary, because list is declared for Double objects. In line 5, the second element in list is 
assigned to a double variable. The object in list.get(1) is automatically converted into 
a primitive type value.
19.1 Are there any compile errors in (a) and (b)?
no casting needed
autounboxing
✓Point✓
Check
ArrayList dates = new ArrayList();
dates.add(new Date());
dates.add(new String());
(a) Prior to JDK 1.5
ArrayList<Date> dates = 
new ArrayList<>();
dates.add(new Date());
dates.add(new String());
(b) Since JDK 1.5
19.2 What is wrong in (a)? Is the code in (b) correct? 
ArrayList dates = new ArrayList();
dates.add(new Date());
Date date = dates.get(0);
(a) Prior to JDK 1.5
ArrayList<Date> dates = 
new ArrayList<>();
dates.add(new Date());
Date date = dates.get(0);
 (b) Since JDK 1.5
19.3 What are the benefits of using generic types?
19.3 Defining Generic Classes and Interfaces
A generic type can be defined for a class or interface. A concrete type must be 
specified when using the class to create an object or using the class or interface to 
declare a reference variable.
Key
Point
```

</details>


## PDF page 764

<details>
<summary>Page text</summary>

```text
19.3 Defining Generic Classes and Interfaces  741
Let us revise the stack class in Section 11.13, Case Study: A Custom Stack Class, to gener-
alize the element type with a generic type. The new stack class, named GenericStack, is 
shown in Figure 19.4 and is implemented in Listing 19.1.
FIGURE 19.4 TheGenericStack class encapsulates the stack storage and provides the 
operations for manipulating the stack.
Creates an empty stack.
Returns the number of elements in this stack.
Returns the top element in this stack.
Returns and removes the top element in this stack.
Adds a new element to the top of this stack.
Returns true if the stack is empty.
An array list to store elements.
GenericStack<E>
-list: java.util.ArrayList<E>
+GenericStack()
+getSize(): int
+peek(): E
+pop(): E
+push(o: E): void
+isEmpty(): boolean
LISTING 19.1 GenericStack.java
 1 public class GenericStack<E> {
 2 private java.util.ArrayList<E> list = new java.util.ArrayList<>();
 3
 4 public int getSize() {
 5 return list.size();
 6    }
 7
 8 public E peek() {
 9 return list.get(getSize() - 1);
10    }
11
12 public void push(E o) {
13      list.add(o);
14    }
15
16 public E pop() {
17      E o = list.get(getSize() - 1);
18      list.remove(getSize() - 1);
19 return o;
20    }
21
22 public boolean isEmpty() {
23 return list.isEmpty();
24    }
25
26    @Override
27 public String toString() {
28 return "stack: " + list.toString();
29    }
30  }
The following example creates a stack to hold strings and adds three strings to the stack:
GenericStack<String> stack1 = new GenericStack<>();
stack1.push("London");
stack1.push("Paris");
stack1.push("Berlin");
generic type E declared
generic array list
getSize
peek
push
pop
isEmpty
```

</details>


## PDF page 765

<details>
<summary>Page text</summary>

```text
742 Chapter 19 Generics
This example creates a stack to hold integers and adds three integers to the stack:
GenericStack<Integer> stack2 = new GenericStack<>();
stack2.push(1); // autoboxing 1 to new Integer(1)
stack2.push(2);
stack2.push(3);
Instead of using a generic type, you could simply make the type element Object, which can 
accommodate any object type. However, using generic types can improve software reliability 
and readability, because certain errors can be detected at compile time rather than at runtime. 
For example, because stack1 is declared GenericStack<String>, only strings can be 
added to the stack. It would be a compile error if you attempted to add an integer to stack1.
Caution
To create a stack of strings, you use new GenericStack<String>() or new
GenericStack<>(). This could mislead you into thinking that the constructor of 
GenericStack should be defined as
public GenericStack<E>() 
This is wrong. It should be defined as
public GenericStack()
Note
Occasionally, a generic class may have more than one parameter. In this case, place 
the parameters together inside the brackets, separated by commas—for example, 
<E1, E2, E3>.
Note
You can define a class or an interface as a subtype of a generic class or interface. For 
example, the java.lang.String class is defined to implement the Comparable
interface in the Java API as follows: 
public class String implements Comparable<String>
19.4 What is the generic definition for java.lang.Comparable in the Java API?
19.5 Since you create an instance of ArrayList of strings using new
ArrayList<String>(), should the constructor in the ArrayList class be 
defined as
public ArrayList<E>()
19.6 Can a generic class have multiple generic parameters?
19.7 How do you declare a generic type in a class?
19.4 Generic Methods
A generic type can be defined for a static method.
You can define generic interfaces (e.g., the Comparable interface in Figure  19.1b) and 
classes (e.g., the GenericStack class in Listing 19.1). You can also use generic types to 
define generic methods. For example, Listing 19.2 defines a generic method print (lines 
10–14) to print an array of objects. Line 6 passes an array of integer objects to invoke the 
genericprint method. Line 7 invokes print with an array of strings.
benefits of using generic types
generic class constructor
multiple generic parameters
inheritance with generics
✓Point✓
Check
Key
Point
generic method
```

</details>


## PDF page 766

<details>
<summary>Page text</summary>

```text
19.4 Generic Methods  743
LISTING 19.2 GenericMethodDemo.java
 1 public class GenericMethodDemo {
 2 public static void main(String[] args ) {
 3      Integer[] integers = {1, 2, 3, 4, 5};
 4      String[] strings = {"London", "Paris", "New York", "Austin"};
 5
 6      GenericMethodDemo.<Integer>print(integers);
 7      GenericMethodDemo.<String>print(strings);
 8    }
 9
10 public static <E> void print(E[] list) {
11 for (int i = 0; i < list.length; i++) 
12        System.out.print(list[i] + " ");
13      System.out.println();
14    }
15  }
To declare a generic method, you place the generic type <E> immediately after the keyword 
static in the method header. For example,
public static <E> void print(E[] list)
To invoke a generic method, prefix the method name with the actual type in angle brackets. 
For example,
GenericMethodDemo.<Integer>print(integers);
GenericMethodDemo.<String>print(strings);
or simply invoke it as follows:
print(integers);
print(strings);
In the latter case, the actual type is not explicitly specified. The compiler automatically dis-
covers the actual type.
A generic type can be specified as a subtype of another type. Such a generic type is 
called bounded. For example, Listing 19.3 revises the equalArea method in Listing 13.4, 
TestGeometricObject.java, to test whether two geometric objects have the same area. The 
bounded generic type <E extends GeometricObject> (line 7) specifies that E is a generic 
subtype of GeometricObject. You must invoke equalArea by passing two instances of 
GeometricObject.
LISTING 19.3 BoundedTypeDemo.java
 1 public class BoundedTypeDemo {
 2 public static void main(String[] args ) {
 3      Rectangle rectangle = new Rectangle(2, 2);
 4      Circle circle = new Circle(2);
 5
 6      System.out.println("Same area? " +
 7        equalArea(rectangle, circle));
 8    }
 9
10 public static <E extends GeometricObject> boolean equalArea(
11        E object1, E object2) {
12 return object1.getArea() == object2.getArea();
13    }
14  } 
generic method
declare a generic method
invoke generic method
bounded generic type
Rectangle in Listing 13.3
Circle in Listing 13.2
bounded generic type
```

</details>


## PDF page 767

<details>
<summary>Page text</summary>

```text
744 Chapter 19 Generics
Note
An unbounded generic type <E> is the same as <E extends Object>.
Note
To define a generic type for a class, place it after the class name, such as 
GenericStack<E>. To define a generic type for a method, place the generic type 
before the method return type, such as <E> void max(E o1, E o2).
19.8 How do you declare a generic method? How do you invoke a generic method?
19.9 What is a bounded generic type?
19.5 Case Study: Sorting an Array of Objects
You can develop a generic method for sorting an array of Comparable objects.
This section presents a generic method for sorting an array of Comparable objects. The 
objects are instances of the Comparable interface, and they are compared using the 
compareTo method. To test the method, the program sorts an array of integers, an array of 
double numbers, an array of characters, and an array of strings. The program is shown in 
Listing 19.4.
LISTING 19.4 GenericSort.java
 1 public class GenericSort {
 2 public static void main(String[] args) {
 3 // Create an Integer array
 4      Integer[] intArray = {new Integer(2), new Integer(4),
 5 new Integer(3)};
 6
 7 // Create a Double array
 8      Double[] doubleArray = {new Double(3.4), new Double(1.3),
 9 new Double(-22.1)};
10
11 // Create a Character array
12      Character[] charArray = {new Character('a'),
13 new Character('J'), new Character('r')};
14
15 // Create a String array
16      String[] stringArray = {"Tom", "Susan", "Kim"};
17
18 // Sort the arrays
19 sort(intArray);
20 sort(doubleArray);
21 sort(charArray);
22 sort(stringArray);
23
24 // Display the sorted arrays
25      System.out.print("Sorted Integer objects: ");
26      printList(intArray);
27      System.out.print("Sorted Double objects: ");
28      printList(doubleArray);
29      System.out.print("Sorted Character objects: ");
30      printList(charArray);
31      System.out.print("Sorted String objects: ");
32      printList(stringArray);
33    }
34
generic class parameter vs. 
generic method parameter
✓Point✓
Check
Key
Point
sortInteger objects
sortDouble objects
sortCharacter objects
sortString objects
```

</details>


## PDF page 768

<details>
<summary>Page text</summary>

```text
19.5 Case Study: Sorting an Array of Objects  745
35 /** Sort an array of comparable objects */
36 public static <E extends Comparable<E>> void sort(E[] list) {
37      E currentMin;
38 int currentMinIndex;
39
40 for (int i = 0; i < list.length - 1; i++) {
41 // Find the minimum in the list[i+1..list.length-2]
42        currentMin = list[i];
43        currentMinIndex = i;
44
45 for (int j = i + 1; j < list.length; j++) {
46 if (currentMin.compareTo(list[j]) > 0) {
47            currentMin = list[j];
48            currentMinIndex = j;
49          }
50        }
51
52 // Swap list[i] with list[currentMinIndex] if necessary;
53 if (currentMinIndex != i) {
54          list[currentMinIndex] = list[i];
55          list[i] = currentMin;
56        }
57      }
58    }
59
60 /** Print an array of objects */
61 public static void printList(Object[] list) {
62 for (int i = 0; i < list.length; i++)
63        System.out.print(list[i] + " ");
64      System.out.println();
65    }
66  }
generic sort method
compareTo
Sorted Integer objects: 2 3 4 
Sorted Double objects: -22.1 1.3 3.4 
Sorted Character objects: J a r 
Sorted String objects: Kim Susan Tom
The algorithm for the sort method is the same as in Listing 7.8, SelectionSort.java. The 
sort method in that program sorts an array of double values. The sort method in this 
example can sort an array of any object type, provided that the objects are also instances of 
theComparable interface. The generic type is defined as <E extends Comparable<E>>
(line 36). This has two meanings. First, it specifies that E is a subtype of Comparable. Second,
it specifies that the elements to be compared are of the E type as well. 
The sort method uses the compareTo method to determine the order of the objects in 
the array (line 46). Integer, Double, Character, and String implement Comparable,
so the objects of these classes can be compared using the compareTo method. The program 
creates arrays of Integer objects, Double objects, Character objects, and String objects 
(lines 4–16) and invoke the sort method to sort these arrays (lines 19–22).
19.10 Given int[] list = {1, 2, -1}, can you invoke sort(list) using the sort
method in Listing 19.4?
19.11 Given int[] list = {new Integer(1), new Integer(2), new Inte-
ger(-1)}, can you invoke sort(list) using the sort method in Listing 19.4?
✓Point✓
Check
```

</details>


## PDF page 769

<details>
<summary>Page text</summary>

```text
746 Chapter 19 Generics
19.6 Raw Types and Backward Compatibility
A generic class or interface used without specifying a concrete type, called a raw type, 
enables backward compatibility with earlier versions of Java.
You can use a generic class without specifying a concrete type like this:
GenericStack stack = new GenericStack(); // raw type
This is roughly equivalent to
GenericStack<Object> stack = new GenericStack<Object>(); 
A generic class such as GenericStack and ArrayList used without a type parameter is 
called a raw type. Using raw types allows for backward compatibility with earlier versions of 
Java. For example, a generic type has been used in java.lang.Comparable since JDK 1.5, 
but a lot of code still uses the raw type Comparable, as shown in Listing 19.5:
LISTING 19.5 Max.java
1 public class Max {
2 /** Return the maximum of two objects */
3 public static Comparable max(Comparable o1, Comparable o2) {
4 if (o1.compareTo(o2) > 0)
5 return o1;
6 else
7 return o2;
8    }
9  }
Comparable o1 and Comparable o2 are raw type declarations. Be careful: raw types are 
unsafe. For example, you might invoke the max method using
Max.max("Welcome", 23); // 23 is autoboxed into new Integer(23)
This would cause a runtime error, because you cannot compare a string with an inte-
ger object. The Java compiler displays a warning on line 3 when compiled with the option 
–Xlint:unchecked, as shown in Figure 19.5. 
Key
Point
raw type
backward compatibility
raw type
Xlint:unchecked
FIGURE 19.5 The unchecked warnings are displayed using the compiler option 
–Xlint:unchecked.
A better way to write the max method is to use a generic type, as shown in Listing 19.6.
LISTING 19.6 MaxUsingGenericType.java
1 public class MaxUsingGenericType {
2 /** Return the maximum of two objects */
3 public static <E extends Comparable<E>> E max(E o1, E o2) {
4 if (o1.compareTo(o2) > 0)
5 return o1;
6 else
bounded type
```

</details>


## PDF page 770

<details>
<summary>Page text</summary>

```text
19.7 Wildcard Generic Types  747
7 return o2;
8    }
9  }
If you invoke the max method using
// 23 is autoboxed into new Integer(23)
MaxUsingGenericType.max("Welcome", 23);
a compile error will be displayed, because the two arguments of the max method in 
MaxUsingGenericType must have the same type (e.g., two strings or two integer objects). 
Furthermore, the type E must be a subtype of Comparable<E>.
As another example, in the following code you can declare a raw type stack in line 1, 
assignnew GenericStack<String> to it in line 2, and push a string and an integer object 
to the stack in lines 3 and 4.
1  GenericStack stack;
2  stack = new GenericStack<String>();
3  stack.push("Welcome to Java");
4  stack.push(new Integer(2));
However, line 4 is unsafe because the stack is intended to store strings, but an Integer object 
is added into the stack. Line 3 should be okay, but the compiler will show warnings for both 
line 3 and line 4, because it cannot follow the semantic meaning of the program. All the com-
piler knows is that stack is a raw type, and performing certain operations is unsafe. Therefore, 
warnings are displayed to alert potential problems.
Tip
Since raw types are unsafe, this book will not use them from here on.
19.12 What is a raw type? Why is a raw type unsafe? Why is the raw type allowed in Java?
19.13 What is the syntax to declare an ArrayList reference variable using the raw type 
and assign a raw type ArrayList object to it?
19.7 Wildcard Generic Types
You can use unbounded wildcards, bounded wildcards, or lower-bound wildcards to 
specify a range for a generic type.
What are wildcard generic types and why are they needed? Listing 19.7 gives an example to 
demonstrate the needs. The example defines a generic max method for finding the maximum 
in a stack of numbers (lines 12–22). The main method creates a stack of integer objects, adds 
three integers to the stack, and invokes the max method to find the maximum number in the 
stack.
LISTING 19.7 WildCardNeedDemo.java
 1 public class WildCardNeedDemo {
 2 public static void main(String[] args ) {
3      GenericStack<Integer> intStack = new GenericStack<>();
 4      intStack.push(1); // 1 is autoboxed into new Integer(1)
 5      intStack.push(2);
 6      intStack.push(-2);
 7
 8      System.out.print("The max number is " + max(intStack));
 9    } 
10
✓Point✓
Check
Key
Point
GenericStack<Integer>
type
```

</details>


## PDF page 771

<details>
<summary>Page text</summary>

```text
748 Chapter 19 Generics
11 /** Find the maximum in a stack of numbers */
12 public static double max(GenericStack<Number> stack) {
13 double max = stack.pop().doubleValue(); // Initialize max
14
15 while (!stack.isEmpty()) {
16 double value = stack.pop().doubleValue();
17 if (value > max) 
18          max = value;
19      }
20
21 return max;
22    }
23  }
The program in Listing 19.7 has a compile error in line 8 because intStack is not an instance 
ofGenericStack<Number>. Thus, you cannot invoke max(intStack).
The fact is that Integer is a subtype of Number, but GenericStack<Integer> is not 
a subtype of GenericStack<Number>. To circumvent this problem, use wildcard generic 
types. A wildcard generic type has three forms: ? and ? extends T, as well as ? super T,
whereT is a generic type.
The first form, ?, called an unbounded wildcard, is the same as ? extends Object. The 
second form, ? extends T, called a bounded wildcard, represents T or a subtype of T. The 
third form, ? super T, called a lower-bound wildcard, denotes T or a supertype of T.
You can fix the error by replacing line 12 in Listing 19.7 as follows:
public static double max(GenericStack<? extends Number> stack) {
<? extends Number> is a wildcard type that represents Number or a subtype of Number,
so it is legal to invoke max(new GenericStack<Integer>())  or max(new
GenericStack<Double>()).
Listing 19.8 shows an example of using the ? wildcard in the print method that prints 
objects in a stack and empties the stack. <?> is a wildcard that represents any object type. It 
is equivalent to <? extends Object> . What happens if you replace GenericStack<?>
with GenericStack<Object>? It would be wrong to invoke print(intStack),
because intStack is not an instance of GenericStack<Object>. Please note that 
GenericStack<Integer> is not a subtype of GenericStack<Object>, even though 
Integer is a subtype of Object.
LISTING 19.8 AnyWildCardDemo.java
 1 public class AnyWildCardDemo {
 2 public static void main(String[] args ) {
 3      GenericStack<Integer> intStack = new GenericStack<>();
 4      intStack.push(1); // 1 is autoboxed into new Integer(1)
 5      intStack.push(2);
 6      intStack.push(-2);
 7
 8      print(intStack);
 9    }
10
11 /** Prints objects and empties the stack */
12 public static void print(GenericStack<?> stack) {
13 while (!stack.isEmpty()) {
14        System.out.print(stack.pop() + " ");
15      }
16    }
17  }
GenericStack<Number>
type
unbounded wildcard
bounded wildcard
lower-bound wildcard
GenericStack<Integer>
type
wildcard type
```

</details>


## PDF page 772

<details>
<summary>Page text</summary>

```text
19.7 Wildcard Generic Types  749
When is the wildcard <? super T>  needed? Consider the example in Listing 19.9. The 
example creates a stack of strings in stack1 (line 3) and a stack of objects in stack2 (line 4), 
and invokes add(stack1, stack2)  (line 8) to add the strings in stack1 into stack2.
GenericStack<? super T>  is used to declare stack2 in line 13. If <? super T>  is 
replaced by <T>, a compile error will occur on add(stack1, stack2)  in line 8, because 
stack1’s type is GenericStack<String> and stack2’s type is GenericStack<Object>.
<? super T> represents type T or a supertype of T.Object is a supertype of String.
LISTING 19.9 SuperWildCardDemo.java
 1 public class SuperWildCardDemo {
 2 public static void main(String[] args) {
 3      GenericStack<String> stack1 = new GenericStack<>();
 4      GenericStack<Object> stack2 = new GenericStack<>();
 5      stack2.push("Java");
 6      stack2.push(2);
 7      stack1.push("Sun");
 8      add(stack1, stack2);
 9      AnyWildCardDemo.print(stack2);
10    }
11
12 public static <T> void add(GenericStack<T> stack1,
13        GenericStack<? super T> stack2) {
14 while (!stack1.isEmpty())
15        stack2.push(stack1.pop());
16    }
17  }
This program will also work if the method header in lines 12–13 is modified as follows:
public static <T> void add(GenericStack<? extends T> stack1,
    GenericStack<T> stack2) 
The inheritance relationship involving generic types and wildcard types is summarized in 
Figure 19.6. In this figure, A and B represent classes or interfaces, and E is a generic type 
parameter.
why<? Super T>
GenericStack<String>
type
<? Super T> type
FIGURE 19.6 The relationship between generic types and wildcard types.
E
? super E
Object
E’s subclass ? extends E
A<? extends B> A<? super B>
A<?>
Object
A<B>A<B’s subclass> A<B’s subclass>
? E’s superclass
19.14 IsGenericStack the same as GenericStack<Object>?
19.15 What are an unbounded wildcard, a bounded wildcard, and a lower-bound wildcard?
19.16 What happens if lines 12–13 in Listing 19.9 are changed to
public static <T> void add(GenericStack<T> stack1,
      GenericStack<T> stack2) 
✓Point✓
Check
```

</details>


## PDF page 773

<details>
<summary>Page text</summary>

```text
750 Chapter 19 Generics
19.17 What happens if lines 12–13 in Listing 19.9 are changed to
public static <T> void add(GenericStack<? extends T> stack1,
      GenericStack<T> stack2) 
19.8 Erasure and Restrictions on Generics
The information on generics is used by the compiler but is not available at runtime. 
This is called type erasure.
Generics are implemented using an approach called type erasure : The compiler uses the 
generic type information to compile the code, but erases it afterward. Thus, the generic infor-
mation is not available at runtime. This approach enables the generic code to be backward 
compatible with the legacy code that uses raw types.
The generics are present at compile time. Once the compiler confirms that a generic type 
is used safely, it converts the generic type to a raw type. For example, the compiler checks 
whether the following code in (a)  uses generics correctly and then translates it into the equiva-
lent code in (b) for runtime use. The code in (b) uses the raw type.
Key
Point
type erasure
erase generics
ArrayList<String> list = new ArrayList<>();
list.add("Oklahoma");
String state = list.get(0);
(a)
ArrayList list = new ArrayList();
list.add("Oklahoma");
String state = (String)(list.get(0));
(b)
When generic classes, interfaces, and methods are compiled, the compiler replaces the generic 
type with the Object type. For example, the compiler would convert the following method 
in (a) into (b). 
replace generic type
public static <E> void print(E[] list) {
for (int i = 0; i < list.length; i++) 
    System.out.print(list[i] + " ");
  System.out.println();
}
(a)
public static void print(Object[] list) {
for (int i = 0; i < list.length; i++) 
    System.out.print(list[i] + " ");
  System.out.println();
}
(b)
If a generic type is bounded, the compiler replaces it with the bounded type. For example, the 
compiler would convert the following method in (a) into (b). 
replace bounded type
public static <E extends GeometricObject>
boolean equalArea(
E object1, 
E object2) {
return object1.getArea() == 
    object2.getArea();
}
(a)
public static
boolean equalArea(
GeometricObject object1, 
GeometricObject object2) {
return object1.getArea() == 
    object2.getArea();
}
(b)
It is important to note that a generic class is shared by all its instances regardless of its actual 
concrete type. Suppose list1 and list2 are created as follows:
ArrayList<String> list1 = new ArrayList<>();
ArrayList<Integer> list2 = new ArrayList<>();
important fact
```

</details>


## PDF page 774

<details>
<summary>Page text</summary>

```text
19.8 Erasure and Restrictions on Generics  751
AlthoughArrayList<String> and ArrayList<Integer> are two types at compile time, 
only one ArrayList class is loaded into the JVM at runtime. list1 and list2 are both 
instances of ArrayList, so the following statements display true:
System.out.println(list1 instanceof ArrayList);
System.out.println(list2 instanceof ArrayList);
However, the expression list1 instanceof ArrayList<String>  is wrong. Since 
ArrayList<String> is not stored as a separate class in the JVM, using it at runtime makes 
no sense.
Because generic types are erased at runtime, there are certain restrictions on how generic 
types can be used. Here are some of the restrictions:
Restriction 1: Cannot Usenew E()
You cannot create an instance using a generic type parameter. For example, the following 
statement is wrong: 
E object = new E();
The reason is that new E() is executed at runtime, but the generic type E is not available 
at runtime.
Restriction 2: Cannot Usenew E[]
You cannot create an array using a generic type parameter. For example, the following 
statement is wrong: 
E[] elements = new E[capacity];
You can circumvent this limitation by creating an array of the Object type and then cast-
ing it to E[], as follows: 
E[] elements = (E[])new Object[capacity];
However, casting to (E[]) causes an unchecked compile warning. The warning occurs 
because the compiler is not certain that casting will succeed at runtime. For example, if 
E is String and new Object[]  is an array of Integer objects, (String[])(new
Object[]) will cause a ClassCastException. This type of compile warning is a limi-
tation of Java generics and is unavoidable.
Generic array creation using a generic class is not allowed, either. For example, the fol-
lowing code is wrong:
ArrayList<String>[] list = new ArrayList<String>[10];
You can use the following code to circumvent this restriction:
ArrayList<String>[] list = (ArrayList<String>[])new
ArrayList[10];
However, you will still get a compile warning.
Restriction 3: A Generic Type Parameter of a Class Is Not Allowed in a Static 
Context
Since all instances of a generic class have the same runtime class, the static variables and 
methods of a generic class are shared by all its instances. Therefore, it is illegal to refer to 
nonew E()
nonew E[capacity]
unavoidable compile warning
```

</details>


## PDF page 775

<details>
<summary>Page text</summary>

```text
752 Chapter 19 Generics
a generic type parameter for a class in a static method, field, or initializer. For example, the 
following code is illegal:
public class Test<E> {
public static void m(E o1) { // Illegal
  }
public static E o1; // Illegal
static {
    E o2; // Illegal
  }
}
Restriction 4: Exception Classes Cannot Be Generic
A generic class may not extend java.lang.Throwable, so the following class declara-
tion would be illegal:
public class MyException<T> extends Exception {
}
Why? If it were allowed, you would have a catch clause for MyException<T> as follows:
try {
  ...
}
catch (MyException<T> ex) {
  ...
}
The JVM has to check the exception thrown from the try clause to see if it matches the 
type specified in a catch clause. This is impossible, because the type information is not 
present at runtime.
19.18 What is erasure? Why are Java generics implemented using erasure?
19.19 If your program uses ArrayList<String> and ArrayList<Date>, does the JVM 
load both of them?
19.20 Can you create an instance using new E() for a generic type E? Why?
19.21 Can a method that uses a generic class parameter be static? Why?
19.22 Can you define a custom generic exception class? Why?
19.9 Case Study: Generic Matrix Class
This section presents a case study on designing classes for matrix operations using 
generic types.
The addition and multiplication operations for all matrices are similar except that their ele-
ment types differ. Therefore, you can design a superclass that describes the common opera-
tions shared by matrices of all types regardless of their element types, and you can define 
subclasses tailored to specific types of matrices. This case study gives implementations for 
two types: int and Rational. For the int type, the wrapper class Integer should be used 
to wrap an int value into an object, so that the object is passed in the methods for operations.
The class diagram is shown in Figure  19.7. The methods addMatrix  and 
multiplyMatrix  add and multiply two matrices of a generic type E[][]. The static 
method printResult  displays the matrices, the operator, and their result. The methods 
add, multiply, and zero are abstract, because their implementations depend on the 
specific type of the array elements. For example, the zero() method returns 0 for the 
✓Point✓
Check
Key
Point
```

</details>


## PDF page 776

<details>
<summary>Page text</summary>

```text
19.9 Case Study: Generic Matrix Class  753
Integer type and 0/1 for the Rational type. These methods will be implemented in the 
subclasses in which the matrix element type is specified.
IntegerMatrix and RationalMatrix are concrete subclasses of GenericMatrix.
These two classes implement the add, multiply, and zero methods defined in the 
GenericMatrix class.
Listing 19.10 implements the GenericMatrix class. <E extends Number>  in line 1 
specifies that the generic type is a subtype of Number. Three abstract methods—add,multiply,
andzero—are defined in lines 3, 6, and 9. These methods are abstract because we cannot imple-
ment them without knowing the exact type of the elements. The addMaxtrix (lines 12–30) and 
multiplyMatrix (lines 33–57) methods implement the methods for adding and multiplying 
two matrices. All these methods must be nonstatic, because they use generic type E for the class. 
TheprintResult method (lines 60–84) is static because it is not tied to specific instances.
The matrix element type is a generic subtype of Number. This enables you to use an object 
of any subclass of Number as long as you can implement the abstract add, multiply, and 
zero methods in subclasses.
The addMatrix and multiplyMatrix methods (lines 12–57) are concrete methods. 
They are ready to use as long as the add,multiply, and zero methods are implemented in 
the subclasses.
TheaddMatrix and multiplyMatrix methods check the bounds of the matrices before 
performing operations. If the two matrices have incompatible bounds, the program throws an 
exception (lines 16, 36).
LISTING 19.10 GenericMatrix.java
 1 public abstract class GenericMatrix<E extends Number> {
 2 /** Abstract method for adding two elements of the matrices */
 3 protected abstract E add(E o1, E o2); 
 4
 5 /** Abstract method for multiplying two elements of the matrices */
 6 protected abstract E multiply(E o1, E o2); 
 7
 8 /** Abstract method for defining zero for the matrix element */
 9 protected abstract E zero();
10
11 /** Add two matrices */
12 public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
13 // Check bounds of the two matrices
14 if ((matrix1.length != matrix2.length) ||
15          (matrix1[0].length != matrix2[0].length)) {
16 throw new RuntimeException(
17 "The matrices do not have the same size");
18      }
19
bounded generic type
abstract method
abstract method
abstract method
add two matrices
FIGURE 19.7 TheGenericMatrix class is an abstract superclass for IntegerMatrix and 
RationalMatrix.
#add(element1: E, element2: E): E
#multiply(element1: E, element2: E): E
#zero(): E
+addMatrix(matrix1: E[][], matrix2: E[][]): E[][]
+multiplyMatrix(matrix1: E[][], matrix2: E[][]): E[][]
+printResult(m1: Number[][], m2: Number[][],
GenericMatrix<E extends Number> IntegerMatrix
RationalMatrixm3: Number[][], op: char): void
```

</details>


## PDF page 777

<details>
<summary>Page text</summary>

```text
754 Chapter 19 Generics
20      E[][] result =
21        (E[][])new Number[matrix1.length][matrix1[0].length];
22
23 // Perform addition
24 for (int i = 0; i < result.length; i++)
25 for (int j = 0; j < result[i].length; j++) {
26          result[i][j] = add(matrix1[i][j], matrix2[i][j]);
27        }
28
29 return result;
30    }
31
32 /** Multiply two matrices */
33 public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
34 // Check bounds
35 if (matrix1[0].length != matrix2.length) {
36 throw new RuntimeException(
37 "The matrices do not have compatible size");
38      }
39
40 // Create result matrix
41      E[][] result =
42        (E[][])new Number[matrix1.length][matrix2[0].length];
43
44 // Perform multiplication of two matrices
45 for (int i = 0; i < result.length; i++) {
46 for (int j = 0; j < result[0].length; j++) {
47          result[i][j] = zero();
48
49 for (int k = 0; k < matrix1[0].length; k++) {
50            result[i][j] = add(result[i][j],
51              multiply(matrix1[i][k], matrix2[k][j]));
52          }
53        }
54      }
55
56 return result;
57    }
58
59 /** Print matrices, the operator, and their operation result */
60 public static void printResult(
61        Number[][] m1, Number[][] m2, Number[][] m3, char op) {
62 for (int i = 0; i < m1.length; i++) {
63 for (int j = 0; j < m1[0].length; j++)
64          System.out.print(" " + m1[i][j]);
65
66 if (i == m1.length / 2)
67          System.out.print("  " + op + "  ");
68 else
69          System.out.print("     ");
70
71 for (int j = 0; j < m2.length; j++)
72          System.out.print(" " + m2[i][j]);
73
74 if (i == m1.length / 2)
75          System.out.print("  =  ");
76 else
77          System.out.print("     ");
78
79 for (int j = 0; j < m3.length; j++)
multiply two matrices
display result
```

</details>


## PDF page 778

<details>
<summary>Page text</summary>

```text
19.9 Case Study: Generic Matrix Class  755
80          System.out.print(m3[i][j] + " ");
81
82        System.out.println();
83      }
84    }
85  }
Listing 19.11 implements the IntegerMatrix class. The class extends 
GenericMatrix<Integer> in line 1. After the generic instantiation, the add method in 
GenericMatrix<Integer> is now Integer add(Integer o1, Integer o2) . The 
add, multiply, and zero methods are implemented for Integer objects. These methods 
are still protected, because they are invoked only by the addMatrix and multiplyMatrix
methods.
LISTING 19.11 IntegerMatrix.java
 1 public class IntegerMatrix extends GenericMatrix<Integer> {
 2    @Override /** Add two integers */
 3 protected Integer add(Integer o1, Integer o2) {
 4 return o1 + o2;
 5    }
 6
 7    @Override /** Multiply two integers */
 8 protected Integer multiply(Integer o1, Integer o2) {
 9 return o1 * o2;
10    }
11
12    @Override /** Specify zero for an integer */
13 protected Integer zero() {
14 return 0;
15    }
16  }
Listing 19.12 implements the RationalMatrix class. The Rational class was introduced 
in Listing 13.13 Rational.java. Rational is a subtype of Number. The RationalMatrix
class extends GenericMatrix<Rational> in line 1. After the generic instantiation, the 
add method in GenericMatrix<Rational> is now Rational add(Rational r1, 
Rational r2) . The add, multiply, and zero methods are implemented for Rational
objects. These methods are still protected, because they are invoked only by the addMatrix
andmultiplyMatrix methods.
LISTING 19.12 RationalMatrix.java
 1 public class RationalMatrix extends GenericMatrix<Rational> {
 2    @Override /** Add two rational numbers */
 3 protected Rational add(Rational r1, Rational r2) {
 4 return r1.add(r2);
 5    }
 6
 7    @Override /** Multiply two rational numbers */
 8 protected Rational multiply(Rational r1, Rational r2) {
 9 return r1.multiply(r2); 
10    }
11
12 @Override  /** Specify zero for a Rational number */
13 protected Rational zero() {
14 return new Rational(0, 1);
15    }
16  }
extends generic type
implementadd
implementmultiply
implementzero
extends generic type
implementadd
implementmultiply
implementzero
```

</details>


## PDF page 779

<details>
<summary>Page text</summary>

```text
756 Chapter 19 Generics
Listing 19.13 gives a program that creates two Integer matrices (lines 4–5) and an 
IntegerMatrix object (line 8), and adds and multiplies two matrices in lines 12 and 16.
LISTING 19.13 TestIntegerMatrix.java
 1 public class TestIntegerMatrix {
 2 public static void main(String[] args) {
 3 // Create Integer arrays m1, m2
 4      Integer[][] m1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
 5      Integer[][] m2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};
 6
 7 // Create an instance of IntegerMatrix
 8      IntegerMatrix integerMatrix = new IntegerMatrix();
 9
10      System.out.println("\nm1 + m2 is ");
11      GenericMatrix.printResult(
12        m1, m2, integerMatrix.addMatrix(m1, m2), '+');
13
14      System.out.println("\nm1 * m2 is ");
15      GenericMatrix.printResult(
16        m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');
17    }
18  }
create matrices
createIntegerMatrix
add two matrices
multiply two matrices
m1 + m2 is 
 1 2 3     1 1 1     2 3 4 
 4 5 6  +  2 2 2  =  6 7 8 
 1 1 1     0 0 0     1 1 1 
m1 * m2 is 
 1 2 3     1 1 1     5  5  5 
 4 5 6  *  2 2 2  =  14 14 14 
 1 1 1     0 0 0     3  3  3
Listing 19.14 gives a program that creates two Rational matrices (lines 4–10) and a 
RationalMatrix object (line 13) and adds and multiplies two matrices in lines 17 and 19.
LISTING 19.14 TestRationalMatrix.java
 1 public class TestRationalMatrix {
 2 public static void main(String[] args) {
 3 // Create two Rational arrays m1 and m2
 4      Rational[][] m1 = new Rational[3][3];
 5      Rational[][] m2 = new Rational[3][3];
 6 for (int i = 0; i < m1.length; i++)
 7 for (int j = 0; j < m1[0].length; j++) {
 8          m1[i][j] = new Rational(i + 1, j + 5);
 9          m2[i][j] = new Rational(i + 1, j + 6);
10        }
11
12 // Create an instance of RationalMatrix
13      RationalMatrix rationalMatrix = new RationalMatrix();
14
15      System.out.println("\nm1 + m2 is ");
16      GenericMatrix.printResult(
17        m1, m2, rationalMatrix.addMatrix(m1, m2), '+');
18
19      System.out.println("\nm1 * m2 is ");
create matrices
createRationalMatrix
add two matrices
```

</details>


## PDF page 780

<details>
<summary>Page text</summary>

```text
Chapter Summary  757
20      GenericMatrix.printResult(
21        m1, m2, rationalMatrix.multiplyMatrix(m1, m2), '*');
22    }
23  }
multiply two matrices
KEY TERMS
actual concrete type 738
bounded generic type 743
bounded wildcard 
(<? extends E>) 748
formal generic type 738
generic instantiation 738
lower-bound wildcard 
(<? super E>) 748
raw type 746
unbounded wildcard (<?>) 748
m1 + m2 is 
 1/5 1/6 1/7     1/6 1/7 1/8     11/30 13/42 15/56 
 2/5 1/3 2/7  +  1/3 2/7 1/4  =  11/15 13/21 15/28 
 3/5 1/2 3/7     1/2 3/7 3/8     11/10 13/14 45/56 
m1 * m2 is 
 1/5 1/6 1/7     1/6 1/7 1/8     101/630 101/735 101/840 
 2/5 1/3 2/7  *  1/3 2/7 1/4  =  101/315 202/735 101/420 
 3/5 1/2 3/7     1/2 3/7 3/8     101/210 101/245 101/280
19.23 Why are the add, multiple, and zero methods defined abstract in the 
GenericMatrix class?
19.24 How are the add, multiple, and zero methods implemented in the 
IntegerMatrix  class?
19.25 How are the add, multiple, and zero methods implemented in the 
RationalMatrix class?
19.26 What would be wrong if the printResult method defined as follows?
public static void printResult(
      E[][] m1, E[][] m2, E[][] m3, char op) 
✓Point✓
Check
CHAPTER SUMMARY
1. Generics give you the capability to parameterize types. You can define a class or a 
method with generic types, which the compiler replaces with concrete types.
2. The key benefit of generics is to enable errors to be detected at compile time rather than 
at runtime.
3. A generic class or method permits you to specify allowable types of objects that the 
class or method can work with. If you attempt to use a class or method with an incom-
patible object, the compiler will detect the error.
4. A generic type defined in a class, interface, or a static method is called a formal generic 
type, which can be replaced later with an actual concrete type. Replacing a generic type 
is called a generic instantiation.
```

</details>


## PDF page 781

<details>
<summary>Page text</summary>

```text
758 Chapter 19 Generics
5. A generic class such as ArrayList  used without a type parameter is called a raw 
type. Use of raw types is allowed for backward compatibility with the earlier ver-
sions of Java.
6. A wildcard generic type has three forms: ? and ? extends T, and ? super T, where 
T is a generic type. The first form, ?, called an unbounded wildcard, is the same as 
? extends Object . The second form, ? extends T , called a bounded wildcard,
representsT or a subtype of T. The third form, ? super T, called a lower-bound wild-
card, denotes T or a supertype of T.
7. Generics are implemented using an approach called type erasure. The compiler uses 
the generic type information to compile the code but erases it afterward, so the generic 
information is not available at runtime. This approach enables the generic code to be 
backward compatible with the legacy code that uses raw types.
8. You cannot create an instance using a generic type parameter.
9. You cannot create an array using a generic type parameter.
10. You cannot use a generic type parameter of a class in a static context.
11. Generic type parameters cannot be used in exception classes.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
19.1 (Revising Listing 19.1 ) Revise the GenericStack class in Listing 19.1 to imple-
ment it using an array rather than an ArrayList. You should check the array size 
before adding a new element to the stack. If the array is full, create a new array that 
doubles the current array size and copy the elements from the current array to the 
new array.
19.2 (Implement GenericStack using inheritance) In Listing 19.1, GenericStack is 
implemented using composition. Define a new stack class that extends ArrayList.
Draw the UML diagram for the classes and then implement GenericStack.
Write a test program that prompts the user to enter five strings and displays them in 
reverse order.
19.3 (Distinct elements in ArrayList) Write the following method that returns a new 
ArrayList. The new list contains the non-duplicate elements from the original list.
public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
19.4 (Generic linear search) Implement the following generic method for linear search.
public static <E extends Comparable<E>>
int linearSearch(E[] list, E key)
19.5 (Maximum element in an array ) Implement the following method that returns the 
maximum element in an array.
public static <E extends Comparable<E>> E max(E[] list)
```

</details>


## PDF page 782

<details>
<summary>Page text</summary>

```text
Programming Exercises  759
19.6 (Maximum element in a two-dimensional array ) Write a generic method that 
returns the maximum element in a two-dimensional array.
public static <E extends Comparable<E>> E max(E[][] list)
19.7 (Generic binary search) Implement the following method using binary search.
public static <E extends Comparable<E>>
int binarySearch(E[] list, E key)
19.8 (ShuffleArrayList) Write the following method that shuffles an ArrayList:
public static <E> void shuffle(ArrayList<E> list)
19.9 (SortArrayList) Write the following method that sorts an ArrayList:
public static <E extends Comparable<E>>
  void sort(ArrayList<E> list)
19.10 (Largest element inArrayList) Write the following method that returns the largest 
element in an ArrayList:
public static <E extends Comparable<E>> E max(ArrayList<E> list)
19.11 (ComplexMatrix) Use the Complex class introduced in Programming 
Exercise 13.17 to develop the ComplexMatrix class for performing matrix opera-
tions involving complex numbers. The ComplexMatrix class should extend the 
GenericMatrix class and implement the add, multiple, and zero methods. 
You need to modify GenericMatrix and replace every occurrence of Number by 
Object, because Complex is not a subtype of Number. Write a test program that 
creates the following two matrices and displays the result of addition and multiplica-
tion of the matrices by invoking the printResult method.
```

</details>


## PDF page 783

<details>
<summary>Page text</summary>

```text
This page intentionally left blank
```

</details>
