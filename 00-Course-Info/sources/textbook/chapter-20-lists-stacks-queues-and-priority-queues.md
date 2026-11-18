# Chapter 20 Lists, Stacks, Queues, and Priority Queues

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 784

<details>
<summary>Page text</summary>

```text
LISTS,S TACKS,
QUEUES, AND
PRIORITY QUEUES
Objectives
■ To explore the relationship between interfaces and classes in the Java 
Collections Framework hierarchy (§20.2).
■ To use the common methods defined in the Collection interface for 
operating collections (§20.2).
■ To use the Iterator interface to traverse the elements in a collection 
(§20.3).
■ To use a foreach loop to traverse the elements in a collection (§20.3).
■ To explore how and when to use ArrayList or LinkedList to store 
a list of elements (§20.4).
■ To compare elements using the Comparable interface and the 
Comparator interface (§20.5).
■ To use the static utility methods in the Collections class for sorting, 
searching, shuffling lists, and finding the largest and smallest element 
in collections (§20.6).
■ To develop a multiple bouncing balls application using ArrayList
(§20.7).
■ To distinguish between Vector and ArrayList and to use the Stack
class for creating stacks (§20.8).
■ To explore the relationships among Collection, Queue,
LinkedList, and PriorityQueue and to create priority queues 
using the PriorityQueue class (§20.9).
■ To use stacks to write a program to evaluate expressions (§20.10).
CHAPTER
20
```

</details>


## PDF page 785

<details>
<summary>Page text</summary>

```text
762 Chapter 20  Lists, Stacks, Queues, and Priority Queues
20.1 Introduction
Choosing the best data structures and algorithms for a particular task is one of the 
keys to developing high-performance software.
A data structure is a collection of data organized in some fashion. The structure not only 
stores data but also supports operations for accessing and manipulating the data.
In object-oriented thinking, a data structure, also known as a container or container object,
is an object that stores other objects, referred to as data or elements. To define a data structure 
is essentially to define a class. The class for a data structure should use data fields to store data 
and provide methods to support such operations as search, insertion, and deletion. To create a 
data structure is therefore to create an instance from the class. You can then apply the methods 
on the instance to manipulate the data structure, such as inserting an element into or deleting 
an element from the data structure.
Section 11.11 introduced the ArrayList class, which is a data structure to store elements 
in a list. Java provides several more data structures that can be used to organize and manipu-
late data efficiently. These are commonly known as Java Collections Framework . We will 
introduce the applications of lists, vectors, stacks, queues, and priority queues in this chapter
and sets and maps in the next chapter. The implementation of these data structures will be 
discussed in Chapters 24–27.
20.2 Collections
TheCollection interface defines the common operations for lists, vectors, stacks, 
queues, priority queues, and sets.
The Java Collections Framework supports two types of containers:
 ■ One for storing a collection of elements is simply called a collection.
 ■ The other, for storing key/value pairs, is called a map.
Maps are efficient data structures for quickly searching an element using a key. We will intro-
duce maps in the next chapter. Now we turn our attention to the following collections.
 ■ Sets store a group of nonduplicate elements.
 ■ Lists store an ordered collection of elements.
 ■ Stacks store objects that are processed in a last-in, first-out fashion.
 ■ Queues store objects that are processed in a first-in, first-out fashion.
 ■ PriorityQueues store objects that are processed in the order of their priorities.
The common features of these collections are defined in the interfaces, and implementa-
tions are provided in concrete classes, as shown in Figure 20.1.
Note
All the interfaces and classes defined in the Java Collections Framework are grouped in 
thejava.util package.
Design Guide
The design of the Java Collections Framework is an excellent example of using interfaces, 
abstract classes, and concrete classes. The interfaces define the framework. The abstract 
classes provide partial implementation. The concrete classes implement the interfaces 
with concrete data structures. Providing an abstract class that partially implements an 
interface makes it convenient for the user to write the code. The user can simply define 
Key
Point
data structure
container
Java Collections Framework
Key
Point
collection
map
Set
List
Stack
Queue
PriorityQueue
```

</details>


## PDF page 786

<details>
<summary>Page text</summary>

```text
20.2 Collections 763
a concrete class that extends the abstract class rather implements all the methods in 
the interface. The abstract classes such as AbstractCollection are provided for 
convenience. For this reason, they are called convenience abstract classes.
TheCollection interface is the root interface for manipulating a collection of objects. Its 
public methods are listed in Figure  20.2. The AbstractCollection class provides partial 
implementation for the Collection interface. It implements all the methods in Collection
except the add, size, and iterator methods. These are implemented in appropriate concrete 
subclasses.
TheCollection interface provides the basic operations for adding and removing elements
in a collection. The add method adds an element to the collection. The addAll method adds 
all the elements in the specified collection to this collection. The remove method removes an 
element from the collection. The removeAll method removes the elements from this collec-
tion that are present in the specified collection. The retainAll method retains the elements 
in this collection that are also present in the specified collection. All these methods return 
boolean. The return value is true if the collection is changed as a result of the method 
execution. The clear() method simply removes all the elements from the collection.
Note
The methods addAll, removeAll, and retainAll are similar to the set union, 
difference, and intersection operations.
TheCollection interface provides various query operations. The size method returns 
the number of elements in the collection. The contains method checks whether the collec-
tion contains the specified element. The containsAll method checks whether the collection 
contains all the elements in the specified collection. The isEmpty method returns true if the 
collection is empty.
TheCollection interface provides the toArray() method, which returns an array rep-
resentation for the collection.
Design Guide
Some of the methods in the Collection interface cannot be implemented 
in the concrete subclass. In this case, the method would throw java.lang
convenience abstract class
basic operations
set operations
query operations
FIGURE 20.1 A collection is a container that stores objects.
SortedSet
Collection
TreeSet
Vector
LinkedList
PriorityQueueAbstractQueue
AbstractCollection
Stack
LinkedHashSet
Interfaces Abstract Classes Concrete Classes
ArrayList
NavigableSet
Deque
HashSetSet
List
Queue
AbstractList
AbstractSet
AbstractSequentialList
```

</details>


## PDF page 787

<details>
<summary>Page text</summary>

```text
764 Chapter 20  Lists, Stacks, Queues, and Priority Queues
.UnsupportedOperationException, a subclass of RuntimeException.
This is a good design that you can use in your project. If a method has no meaning in 
the subclass, you can implement it as follows:
public void someMethod() {
throw new UnsupportedOperationException
    ("Method not supported");
}
Listing 20.1 gives an example to use the methods defined in the Collection interface.
LISTING 20.1 TestCollection.java
 1 import java.util.*;
 2
 3 public class TestCollection {
 4 public static void main(String[] args) {
 5 ArrayList<String> collection1 = new ArrayList<>();
 6 collection1.add( "New York");
 7      collection1.add("Atlanta");
 8      collection1.add("Dallas");
 9      collection1.add("Madison");
unsupported operations
create an array list
add elements
FIGURE 20.2 TheCollection interface contains the methods for manipulating the elements in a collection, and you 
can obtain an iterator object for traversing elements in the collection.
+add(o: E): boolean
+addAll(c: Collection<? extends E>): boolean
+clear(): void
+contains(o: Object): boolean
+containsAll(c: Collection<?>): boolean
+equals(o: Object): boolean
+hashCode(): int
+isEmpty(): boolean
+remove(o: Object): boolean
+removeAll(c: Collection<?>): boolean
+retainAll(c: Collection<?>): boolean
+size(): int
+toArray(): Object[]
Adds a new element o to this collection.
Adds all the elements in the collection c to this collection.
Removes all the elements from this collection.
Returns true if this collection contains the element o.
Returns true if this collection contains all the elements in c.
Returns true if this collection is equal to another collection o.
Returns the hash code for this collection.
Returns true if this collection contains no elements.
Removes the element o from this collection.
Removes all the elements in c from this collection.
Retains the elements that are both in c and in this collection.
Returns the number of elements in this collection.
Returns an array of Object for the elements in this collection.
Returns true if this iterator has more elements to traverse.
Returns the next element from this iterator.
Removes the last element obtained using the next method.
java.util.Collection<E>
«interface»
+hasNext(): boolean
+next(): E
+remove(): void
java.util.Iterator<E>
«interface»
+iterator(): Iterator<E>
java.lang.Iterable<E>
«interface»
Returns an iterator for the elements in this collection.
```

</details>


## PDF page 788

<details>
<summary>Page text</summary>

```text
20.2 Collections 765
10
11      System.out.println("A list of cities in collection1:");
12      System.out.println(collection1);
13
14      System.out.println("\nIs Dallas in collection1? "
15        + collection1.contains("Dallas"));
16
17 collection1.remove( "Dallas");
18      System.out.println("\n" + collection1.size() + 
19 " cities are in collection1 now");
20
21 Collection<String> collection2 = new ArrayList<>();
22      collection2.add("Seattle");
23      collection2.add("Portland");
24      collection2.add("Los Angeles");
25      collection2.add("Atlanta");
26
27      System.out.println("\nA list of cities in collection2:");
28      System.out.println(collection2);
29
30      ArrayList<String> c1 = (ArrayList<String>)(collection1.clone());
31 c1.addAll(collection2);
32      System.out.println("\nCities in collection1 or collection2: ");
33      System.out.println(c1);
34
35      c1 = (ArrayList<String>)(collection1.clone());
36 c1.retainAll(collection2);
37      System.out.print("\nCities in collection1 and collection2: ");
38      System.out.println(c1);
39
40      c1 = (ArrayList<String>)(collection1.clone());
41 c1.removeAll(collection2);
42      System.out.print("\nCities in collection1, but not in 2: ");
43      System.out.println(c1);
44    }
45  }
contains?
size?
clone
addAll
retainAll
removeAll
A list of cities in collection1:
[New York, Atlanta, Dallas, Madison]
Is Dallas in collection1? true
3 cities are in collection1 now
A list of cities in collection2:
[Seattle, Portland, Los Angeles, Atlanta]
Cities in collection1 or collection2: 
[New York, Atlanta, Madison, Seattle, Portland, Los Angeles, Atlanta]
Cities in collection1 and collection2: [Atlanta]
Cities in collection1, but not in 2: [New York, Madison]
The program creates a concrete collection object using ArrayList (line 5), and invokes 
the Collection interface’s contains method (line 15), remove method (line 17), size
method (line 18), addAll method (line 31), retainAll method (line 36), and removeAll
method (line 41).
For this example, we use ArrayList. You can use any concrete class of Collection
such as HashSet, LinkedList, Vector, and Stack to replace ArrayList to test these 
methods defined in the Collection interface.
```

</details>


## PDF page 789

<details>
<summary>Page text</summary>

```text
766 Chapter 20  Lists, Stacks, Queues, and Priority Queues
The program creates a copy of an array list (lines 30, 35, 40). The purpose of this is to keep 
the original array list intact and use its copy to perform addAll,retainAll, and removeAll
operations.
Note
All the concrete classes in the Java Collections Framework implement the java.lang.
Cloneable  and java.io.Serializable  interfaces except that 
java.util.PriorityQueue does not implement the Cloneable interface. Thus, 
all instances of Cloneable except priority queues can be cloned and all instances of 
Cloneable can be serialized.
20.1 What is a data structure?
20.2 Describe the Java Collections Framework. List the interfaces, convenience abstract 
classes, and concrete classes under the Collection interface.
20.3 Can a collection object be cloned and serialized?
20.4 What method do you use to add all the elements from one collection to another 
collection?
20.5 When should a method throw an UnsupportedOperationException?
20.3 Iterators
Each collection is Iterable. You can obtain its Iterator object to traverse all the 
elements in the collection.
Iterator is a classic design pattern for walking through a data structure without having to 
expose the details of how data is stored in the data structure.
The Collection interface extends the Iterable interface. The Iterable interface 
defines the iterator method, which returns an iterator. The Iterator interface provides a 
uniform way for traversing elements in various types of collections. The iterator() method 
in the Iterable interface returns an instance of Iterator, as shown in Figure 20.2, which 
provides sequential access to the elements in the collection using the next() method. You 
can also use the hasNext() method to check whether there are more elements in the iterator, 
and the remove() method to remove the last element returned by the iterator.
Listing 20.2 gives an example that uses the iterator to traverse all the elements in an array list.
LISTING 20.2 TestIterator.java
 1 import java.util.*;
 2
 3 public class TestIterator {
 4 public static void main(String[] args) {
 5 Collection<String> collection = new ArrayList<>();
 6      collection.add("New York");
 7      collection.add("Atlanta");
 8      collection.add("Dallas");
 9      collection.add("Madison");
10
11 Iterator<String> iterator = collection.iterator();
12 while (iterator.hasNext()) {
13        System.out.print(iterator.next().toUpperCase() + " ");
14      }
15      System.out.println();
16    }
17  }
Cloneable
Serializable
✓Point✓
Check
Key
Point
create an array list
add elements
iterator
hasNext()
next()
```

</details>


## PDF page 790

<details>
<summary>Page text</summary>

```text
20.4 Lists 767
The program creates a concrete collection object using ArrayList (line 5) and adds four 
strings into the list (lines 6–9). The program then obtains an iterator for the collection (line 11) 
and uses the iterator to traverse all the strings in the list and displays the strings in uppercase 
(lines 12–14).
Tip
You can simplify the code in lines 11–14 using a foreach loop without using an iterator, 
as follows:
for (String element: collection)
  System.out.print(element.toUpperCase() + " ");
This loop is read as “for each element in the collection, do the following.” The foreach 
loop can be used for arrays (see Section 7.2.7) as well as any instance of Iterable.
20.6 How do you obtain an iterator from a collection object?
20.7 What method do you use to obtain an element in the collection from an iterator?
20.8 Can you use a foreach loop to traverse the elements in any instance of Collection?
20.9 When using a foreach loop to traverse all elements in a collection, do you need to use 
thenext() or hasNext() methods in an iterator?
20.4 Lists
TheList interface extends the Collection interface and defines a collection for 
storing elements in a sequential order. To create a list, use one of its two concrete 
classes:ArrayList or LinkedList.
We used ArrayList to test the methods in the Collection interface in the preceding 
sections. Now we will examine ArrayList in more depth. We will also introduce another 
useful list, LinkedList, in this section.
20.4.1 The Common Methods in the List Interface
ArrayList and LinkedList are defined under the List interface. The List interface 
extends Collection to define an ordered collection with duplicates allowed. The List
interface adds position-oriented operations, as well as a new list iterator that enables the user 
to traverse the list bidirectionally. The methods introduced in the List interface are shown 
in Figure 20.3.
Theadd(index, element) method is used to insert an element at a specified index, and 
theaddAll(index, collection) method to insert a collection of elements at a specified 
index. The remove(index) method is used to remove an element at the specified index from 
the list. A new element can be set at the specified index using the set(index, element)
method.
The indexOf(element) method is used to obtain the index of the specified element’s 
first occurrence in the list, and the lastIndexOf(element) method to obtain the index of 
its last occurrence. A sublist can be obtained by using the subList(fromIndex, toIndex)
method.
foreach loop
✓Point✓
Check
Key
Point
NEW YORK ATLANTA DALLAS MADISON
```

</details>


## PDF page 791

<details>
<summary>Page text</summary>

```text
768 Chapter 20  Lists, Stacks, Queues, and Priority Queues
ThelistIterator() or listIterator(startIndex) method returns an instance of 
ListIterator. The ListIterator interface extends the Iterator interface to add bidi-
rectional traversal of the list. The methods in ListIterator are listed in Figure 20.4.
FIGURE 20.3 TheList interface stores elements in sequence and permits duplicates.
«interface»
java.util.List<E>
+add(index: int, element: Object): boolean
+addAll(index: int, c: Collection<? extends E>) 
 : boolean
+get(index: int): E
+indexOf(element: Object): int
+lastIndexOf(element: Object): int
+listIterator(): ListIterator<E>
+listIterator(startIndex: int): ListIterator<E>
+remove(index: int): E
+set(index: int, element: Object): Object
+subList(fromIndex: int, toIndex: int): List<E>
«interface»
java.util.Collection<E>
Adds a new element at the specified index.
Adds all the elements in c to this list at the specified
index.
Returns the element in this list at the specified index.
Returns the index of the first matching element.
Returns the index of the last matching element.
Returns the list iterator for the elements in this list.
Returns the iterator for the elements from startIndex.
Removes the element at the specified index.
Sets the element at the specified index.
Returns a sublist from fromIndex to toIndex-1.
FIGURE 20.4 ListIterator enables traversal of a list bidirectionally.
+add(element: E): void
+hasPrevious(): boolean
+nextIndex(): int
+previous(): E
+previousIndex(): int
+set(element: E): void
Adds the specified object to the list.
Returns true if this list iterator has more elements
     when traversing backward.
Returns the index of the next element.
Returns the previous element in this list iterator.
Returns the index of the previous element.
Replaces the last element returned by the previous or
     next method with the specified element.
«interface»
java.util.Iterator<E>
«interface»
java.util.ListIterator<E>
The add(element) method inserts the specified element into the list. The element is 
inserted immediately before the next element that would be returned by the next() method 
defined in the Iterator interface, if any, and after the element that would be returned by 
the previous() method, if any. If the list doesn’t contain any elements, the new element 
becomes the sole element in the list. The set(element) method can be used to replace 
the last element returned by the next method or the previous method with the specified 
element.
ThehasNext() method defined in the Iterator interface is used to check whether the 
iterator has more elements when traversed in the forward direction, and the hasPrevious()
```

</details>


## PDF page 792

<details>
<summary>Page text</summary>

```text
20.4 Lists 769
method to check whether the iterator has more elements when traversed in the backward 
direction.
The next() method defined in the Iterator interface returns the next element in 
the iterator, and the previous() method returns the previous element in the iterator. 
The nextIndex() method returns the index of the next element in the iterator, and the 
previousIndex() returns the index of the previous element in the iterator.
The AbstractList  class provides a partial implementation for the List interface. 
The AbstractSequentialList  class extends AbstractList  to provide support for 
linked lists.
20.4.2 The ArrayList and LinkedList Classes
The ArrayList class and the LinkedList class are two concrete implementations of the 
List interface. ArrayList stores elements in an array. The array is dynamically created. If 
the capacity of the array is exceeded, a larger new array is created and all the elements from 
the current array are copied to the new array. LinkedList stores elements in a linked list.
Which of the two classes you use depends on your specific needs. If you need to support 
random access through an index without inserting or removing elements at the beginning 
of the list, ArrayList offers the most efficient collection. If, however, your application 
requires the insertion or deletion of elements at the beginning of the list, you should choose 
LinkedList. A list can grow or shrink dynamically. Once it is created, an array is fixed. If 
your application does not require the insertion or deletion of elements, an array is the most 
efficient data structure.
ArrayList is a resizable-array implementation of the List interface. It also provides 
methods for manipulating the size of the array used internally to store the list, as shown 
in Figure 20.5. Each ArrayList instance has a capacity, which is the size of the array used 
to store the elements in the list. It is always at least as large as the list size. As elements 
are added to an ArrayList, its capacity grows automatically. An ArrayList does not 
automatically shrink. You can use the trimToSize() method to reduce the array capac-
ity to the size of the list. An ArrayList can be constructed using its no-arg constructor, 
ArrayList(Collection), or ArrayList(initialCapacity).
ArrayList vs. LinkedList
linked list
trimToSize()
FIGURE 20.5 ArrayList implements List using an array.
java.util.ArrayList<E>
+ArrayList()
+ArrayList(c: Collection<? extends E>)
+ArrayList(initialCapacity: int)
+trimToSize(): void
java.util.AbstractList<E>
Creates an empty list with the default initial capacity. 
Creates an array list from an existing collection.
Creates an empty list with the specified initial capacity.
Trims the capacity of this ArrayList instance to be
   the list’s current size.
LinkedList is a linked list implementation of the List interface. In addition to imple-
menting the List interface, this class provides the methods for retrieving, inserting, and 
removing elements from both ends of the list, as shown in Figure 20.6. A LinkedList can be 
constructed using its no-arg constructor or LinkedList(Collection).
```

</details>


## PDF page 793

<details>
<summary>Page text</summary>

```text
770 Chapter 20  Lists, Stacks, Queues, and Priority Queues
Listing 20.3 gives a program that creates an array list filled with numbers and inserts new 
elements into specified locations in the list. The example also creates a linked list from the 
array list and inserts and removes elements from the list. Finally, the example traverses the 
list forward and backward.
LISTING 20.3 TestArrayAndLinkedList.java
 1 import java.util.*;
 2
 3 public class TestArrayAndLinkedList {
 4 public static void main(String[] args) {
 5 List<Integer> arrayList = new ArrayList<>();
 6      arrayList.add(1); // 1 is autoboxed to new Integer(1)
 7      arrayList.add(2);
 8      arrayList.add(3);
 9      arrayList.add(1);
10      arrayList.add(4);
11      arrayList.add(0, 10);
12      arrayList.add(3, 30);
13
14      System.out.println("A list of integers in the array list:");
15      System.out.println(arrayList);
16
17 LinkedList<Object> linkedList = new LinkedList<>(arrayList);
18      linkedList.add(1, "red");
19      linkedList.removeLast();
20      linkedList.addFirst("green");
21
22      System.out.println("Display the linked list forward:");
23 ListIterator<Object> listIterator = linkedList.listIterator();
24 while (listIterator.hasNext()) {
25        System.out.print(listIterator.next() + " ");
26      }
27      System.out.println();
28
29      System.out.println("Display the linked list backward:");
30 listIterator = linkedList.listIterator(linkedList.size());
31 while (listIterator.hasPrevious()) {
32        System.out.print(listIterator.previous() + " ");
33      }
34    }
35  }
array list
linked list
list iterator
list iterator
FIGURE 20.6 LinkedList provides methods for adding and inserting elements at both ends of the list.
Creates a default empty linked list.
Creates a linked list from an existing collection.
Adds the element to the head of this list.
Adds the element to the tail of this list.
Returns the first element from this list.
Returns the last element from this list.
Returns and removes the first element from this list.
Returns and removes the last element from this list.
+LinkedList()
+LinkedList(c: Collection<? extends E>)
+addFirst(element: E): void
+addLast(element: E): void
+getFirst(): E
+getLast(): E
+removeFirst(): E
+removeLast(): E
java.util.LinkedList<E>
java.util.AbstractSequentialList<E>
```

</details>


## PDF page 794

<details>
<summary>Page text</summary>

```text
20.4 Lists 771
A list can hold identical elements. Integer 1 is stored twice in the list (lines 6, 9). ArrayList
andLinkedList operate similarly. The critical difference between them pertains to internal 
implementation, which affects their performance. ArrayList is efficient for retrieving ele-
ments and LinkedList is efficient for inserting and removing elements at the beginning of 
the list. Both have the same performance for inserting and removing elements in the middle 
or at the end of the list.
Theget(i) method is available for a linked list, but it is a time-consuming operation. Do 
not use it to traverse all the elements in a list as shown in (a). Instead you should use an iterator 
as shown in (b). Note that a foreach loop uses an iterator implicitly. You will know the reason 
when you learn how to implement a linked list in Chapter 24.
A list of integers in the array list:
[10, 1, 2, 30, 3, 1, 4]
Display the linked list forward:
green 10 red 1 2 30 3 1 
Display the linked list backward:
1 3 30 2 1 red 10 green
Tip
Java provides the static asList method for creating a list from a variable-length list of 
arguments. Thus you can use the following code to create a list of strings and a list of 
integers:
List<String> list1 = Arrays.asList("red", "green", "blue");
List<Integer> list2 = Arrays.asList(10, 20, 30, 40, 50);
20.10 How do you add and remove elements from a list? How do you traverse a list in both 
directions?
20.11 Suppose that list1 is a list that contains the strings red,yellow, and green, and 
thatlist2 is another list that contains the strings red,yellow, and blue. Answer 
the following questions:
a. What are list1 and list2 after executing list1.addAll(list2)?
b. What are list1 and list2 after executing list1.add(list2)?
c. What are list1 and list2 after executing list1.removeAll(list2)?
d. What are list1 and list2 after executing list1.remove(list2)?
e. What are list1 and list2 after executing list1.retainAll(list2)?
f. What is list1 after executing list1.clear()?
20.12 What are the differences between ArrayList and LinkedList? Which list should 
you use to insert and delete elements at the beginning of a list?
20.13 Are all the methods in ArrayList also in LinkedList? What methods are in 
LinkedList but not in ArrayList?
20.14 How do you create a list from an array of objects?
Arrays.asList(T... a)
method
✓Point✓
Check
for (int i = 0; i < list.size(); i++) {
  process list.get(i);
}
(a) Very inefficient
for (listElementType s: list) {
  process s;
}
(b) Efficient
```

</details>


## PDF page 795

<details>
<summary>Page text</summary>

```text
772 Chapter 20  Lists, Stacks, Queues, and Priority Queues
20.5 The Comparator Interface
Comparator can be used to compare the objects of a class that doesn’t implement 
Comparable.
You have learned how to compare elements using the Comparable interface (introduced 
in Section  13.6). Several classes in the Java API, such as String, Date, Calendar,
BigInteger, BigDecimal, and all the numeric wrapper classes for the primitive types, 
implement the Comparable interface. The Comparable interface defines the compareTo
method, which is used to compare two elements of the same class that implement the 
Comparable interface.
What if the elements’ classes do not implement the Comparable interface? Can these 
elements be compared? You can define a comparator to compare the elements of different 
classes. To do so, define a class that implements the java.util.Comparator<T> interface 
and overrides its compare method. 
  public int compare(T element1, T element2)
  Returns a negative value if element1 is less than element2, a positive value if 
element1 is greater than element2, and zero if they are equal.
The GeometricObject class was introduced in Section  13.2, Abstract Classes. The 
GeometricObject class does not implement the Comparable interface. To compare the 
objects of the GeometricObject class, you can define a comparator class, as shown in 
Listing 20.4.
LISTING 20.4 GeometricObjectComparator.java
 1 import java.util.Comparator;
 2
 3 public class GeometricObjectComparator 
 4 implements Comparator<GeometricObject>, java.io.Serializable {
 5 public int compare(GeometricObject o1, GeometricObject o2) {
 6 double area1 = o1.getArea();
 7 double area2 = o2.getArea();
 8
 9 if (area1 < area2)
10 return -1;
11 else if (area1 == area2)
12 return 0;
13 else
14 return 1;
15    }
16  }
Line 4 implements Comparator<GeometricObject>. Line 5 overrides the compare
method to compare two geometric objects. The class also implements Serializable. It is 
generally a good idea for comparators to implement Serializable, as they may be used 
as ordering methods in serializable data structures. In order for the data structure to serialize 
successfully, the comparator (if provided) must implement Serializable.
Listing 20.5 gives a method that returns a larger object between two geometric objects. The 
objects are compared using the GeometricObjectComparator.
LISTING 20.5 TestComparator.java
 1 import java.util.Comparator;
 2
 3 public class TestComparator {
 4 public static void main(String[] args) {
Key
Point
comparator
implementsComparator
implementscompare
```

</details>


## PDF page 796

<details>
<summary>Page text</summary>

```text
20.6 Static Methods for Lists and Collections  773
 5      GeometricObject g1 = new Rectangle(5, 5);
 6      GeometricObject g2 = new Circle(5);
 7
 8      GeometricObject g = 
 9 max(g1, g2, new GeometricObjectComparator());
10
11      System.out.println("The area of the larger object is " + 
12        g.getArea());
13    }
14
15 public static GeometricObject max(GeometricObject g1, 
16        GeometricObject g2, Comparator<GeometricObject> c) {
17 if (c.compare(g1, g2) > 0)
18 return g1;
19 else
20 return g2;
21    }
22  }
invokemax
themax method
invokecompare
The area of the larger object is 78.53981633974483
The program creates a Rectangle and a Circle object in lines 5–6 (the Rectangle and 
Circle classes were defined in Section 13.2, Abstract Classes). They are all subclasses of 
GeometricObject. The program invokes the max method to obtain the geometric object 
with the larger area (lines 8–9).
TheGeometricObjectComparator is created and passed to the max method (line 9) and 
this comparator is used in the max method to compare the geometric objects in line 17.
Note
Comparable is used to compare the objects of the class that implement Comparable.
Comparator can be used to compare the objects of a class that doesn’t implement 
Comparable.
Comparing elements using the Comparable interface is referred to as comparing using 
natural order, and comparing elements using the Comparator interface is referred to 
as comparing using comparator.
20.15 What are the differences between the Comparable interface and the Comparator
interface? In which package is Comparable, and in which package is Comparator?
20.16 How do you define a class A that implements the Comparable interface? Are two 
instances of class A comparable? How do you define a class B that implements the 
Comparator interface and override the compare method to compare to objects of 
typeB1? How do you invoke the sort method to sort a list of objects of the type B1?
20.6 Static Methods for Lists and Collections
TheCollections class contains static methods to perform common operations in a 
collection and a list.
Section 11.12 introduced several static methods in the Collections class for array lists. 
TheCollections class contains the sort,binarySearch,reverse,shuffle,copy, and 
fill methods for lists, and max,min,disjoint, and frequency methods for collections, 
as shown in  Figure 20.7.
Comparable vs. Comparator
natural order
using comparator
✓Point✓
Check
Key
Point
```

</details>


## PDF page 797

<details>
<summary>Page text</summary>

```text
774 Chapter 20  Lists, Stacks, Queues, and Priority Queues
FIGURE 20.7 TheCollections class contains static methods for manipulating lists and collections.
java.util.Collections
+sort(list: List): void
+sort(list: List, c: Comparator): void
+binarySearch(list: List, key: Object): int
+binarySearch(list: List, key: Object, c:
Comparator): int
+reverse(list: List): void
+reverseOrder(): Comparator
+shuffle(list: List): void
+shuffle(list: List, rmd: Random): void
+copy(des: List, src: List): void
+nCopies(n: int, o: Object): List
+fill(list: List, o: Object): void
+max(c: Collection): Object
+max(c: Collection, c: Comparator): Object
+min(c: Collection): Object
+min(c: Collection, c: Comparator): Object
+disjoint(c1: Collection, c2: Collection):
  boolean
+frequency(c: Collection, o: Object): int
Sorts the specified list.
Sorts the specified list with the comparator.
Searches the key in the sorted list using binary search.
Searches the key in the sorted list using binary search
with the comparator.
Reverses the specified list.
Returns a comparator with the reverse ordering.
Shuffles the specified list randomly.
Shuffles the specified list with a random object.
Copies from the source list to the destination list.
Returns a list consisting of n copies of the object.
Fills the list with the object.
Returns themax object in the collection.
Returns themax object using the comparator.
Returns the min object in the collection.
Returns themin object using the comparator.
Returns true ifc1 andc2 have no elements in common.
Returns the number of occurrences of the specified
     element in the collection.
List
Collection
You can sort the comparable elements in a list in its natural order with the compareTo
method in the Comparable interface. You may also specify a comparator to sort elements. 
For example, the following code sorts strings in a list.
List<String> list = Arrays.asList("red", "green", "blue");
Collections.sort(list);
System.out.println(list);
The output is [blue, green, red].
The preceding code sorts a list in ascending order. To sort it in descending order, you can 
simply use the Collections.reverseOrder() method to return a Comparator object 
that orders the elements in reverse of their natural order. For example, the following code sorts 
a list of strings in descending order.
List<String> list = Arrays.asList("yellow", "red", "green", "blue");
Collections.sort(list, Collections.reverseOrder());
System.out.println(list);
The output is [yellow, red, green, blue].
You can use the binarySearch method to search for a key in a list. To use this method, 
the list must be sorted in increasing order. If the key is not in the list, the method returns 
-(insertion point +1). Recall that the insertion point is where the item would fall in the list if 
it were present. For example, the following code searches the keys in a list of integers and a 
list of strings.
List<Integer> list1 = 
  Arrays.asList(2, 4, 7, 10, 11, 45, 50, 59, 60, 66);
System.out.println("(1) Index: " + Collections.binarySearch(list1, 7));
sort list
ascending order
descending order
binarySearch
```

</details>


## PDF page 798

<details>
<summary>Page text</summary>

```text
20.6 Static Methods for Lists and Collections  775
System.out.println("(2) Index: " + Collections.binarySearch(list1, 9));
List<String> list2 = Arrays.asList("blue", "green", "red");
System.out.println("(3) Index: " + 
  Collections.binarySearch(list2, "red"));
System.out.println("(4) Index: " + 
  Collections.binarySearch(list2, "cyan"));
The output of the preceding code is:
(1) Index: 2
(2) Index: -4
(3) Index: 2
(4) Index: -2
You can use the reverse method to reverse the elements in a list. For example, the following 
code displays [blue, green, red, yellow].
List<String> list = Arrays.asList("yellow", "red", "green", "blue");
Collections.reverse(list);
System.out.println(list);
You can use the shuffle(List) method to randomly reorder the elements in a list. For 
example, the following code shuffles the elements in list.
List<String> list = Arrays.asList("yellow", "red", "green", "blue");
Collections.shuffle(list);
System.out.println(list);
You can also use the shuffle(List, Random) method to randomly reorder the elements in 
a list with a specified Random object. Using a specified Random object is useful to generate a 
list with identical sequences of elements for the same original list. For example, the following 
code shuffles the elements in list.
List<String> list1 = Arrays.asList("yellow", "red", "green", "blue");
List<String> list2 = Arrays.asList("yellow", "red", "green", "blue");
Collections.shuffle(list1, new Random(20));
Collections.shuffle(list2, new Random(20));
System.out.println(list1);
System.out.println(list2);
You will see that list1 and list2 have the same sequence of elements before and after the 
shuffling.
You can use the copy(det, src) method to copy all the elements from a source list to a 
destination list on the same index. The destination list must be as long as the source list. If it is 
longer, the remaining elements in the source list are not affected. For example, the following 
code copies list2 to list1.
List<String> list1 = Arrays.asList("yellow", "red", "green", "blue");
List<String> list2 = Arrays.asList("white", "black");
Collections.copy(list1, list2);
System.out.println(list1);
reverse
shuffle
copy
```

</details>


## PDF page 799

<details>
<summary>Page text</summary>

```text
776 Chapter 20  Lists, Stacks, Queues, and Priority Queues
The output for list1 is [white, black, green, blue] . The copy method performs a 
shallow copy: only the references of the elements from the source list are copied.
You can use the nCopies(int n, Object o)  method to create an immutable list that 
consists of n copies of the specified object. For example, the following code creates a list with 
fiveCalendar objects.
List<GregorianCalendar> list1 = Collections.nCopies
(5, new GregorianCalendar(2005, 0, 1));
The list created from the nCopies method is immutable, so you cannot add, remove, or 
update elements in the list. All the elements have the same references.
You can use the fill(List list, Object o) method to replace all the elements in the 
list with the specified element. For example, the following code displays [black, black, 
black].
List<String> list = Arrays.asList("red", "green", "blue");
Collections.fill(list, "black");
System.out.println(list);
You can use the max and min methods for finding the maximum and minimum elements 
in a collection. The elements must be comparable using the Comparable interface or the 
Comparator interface. For example, the following code displays the largest and smallest 
strings in a collection.
Collection<String> collection = Arrays.asList("red", "green", "blue");
System.out.println(Collections.max(collection));
System.out.println(Collections.min(collection));
Thedisjoint(collection1, collection2) method returns true if the two collections 
have no elements in common. For example, in the following code, disjoint(collection1, 
collection2) returns false, but disjoint(collection1, collection3) returns true.
Collection<String> collection1 = Arrays.asList("red", "cyan");
Collection<String> collection2 = Arrays.asList("red", "blue");
Collection<String> collection3 = Arrays.asList("pink", "tan");
System.out.println(Collections.disjoint(collection1, collection2));
System.out.println(Collections.disjoint(collection1, collection3));
Thefrequency(collection, element) method finds the number of occurrences of the 
element in the collection. For example, frequency(collection, "red") returns 2 in the 
following code.
Collection<String> collection = Arrays.asList("red", "cyan", "red");
System.out.println(Collections.frequency(collection, "red"));
20.17 Are all the methods in the Collections class static?
20.18 Which of the following static methods in the Collections class are for lists, and 
which are for collections?
sort, binarySearch, reverse, shuffle, max, min, disjoint, frequency
20.19 Show the output of the following code:
import java.util.*;
public class Test {
public static void main(String[] args) {
nCopies
fill
max and min methods
disjoint method
frequency method
✓Point✓
Check
```

</details>


## PDF page 800

<details>
<summary>Page text</summary>

```text
20.7 Case Study: Bouncing Balls  777
    List<String> list =
      Arrays.asList("yellow", "red", "green", "blue");
    Collections.reverse(list);
    System.out.println(list);
    List<String> list1 = 
      Arrays.asList("yellow", "red", "green", "blue");
    List<String> list2 = Arrays.asList("white", "black");
    Collections.copy(list1, list2);
    System.out.println(list1);
    Collection<String> c1 = Arrays.asList("red", "cyan");
    Collection<String> c2 = Arrays.asList("red", "blue");
    Collection<String> c3 = Arrays.asList("pink", "tan");
    System.out.println(Collections.disjoint(c1, c2));
    System.out.println(Collections.disjoint(c1, c3));
    Collection<String> collection = 
      Arrays.asList("red", "cyan", "red");
    System.out.println(Collections.frequency(collection, "red"));
  }
}
20.20 Which method can you use to sort the elements in an ArrayList or a LinkedList?
Which method can you use to sort an array of strings?
20.21 Which method can you use to perform binary search for elements in an ArrayList
or a LinkedList? Which method can you use to perform binary search for an array 
of strings?
20.22 Write a statement to find the largest element in an array of comparable objects.
20.7 Case Study: Bouncing Balls
This section presents a program that displays bouncing balls and enables the user to 
add and remove balls.
Section 15.12 presents a program that displays one bouncing ball. This section presents a pro-
gram that displays multiple bouncing balls. You can use two buttons to suspend and resume 
the movement of the balls, a scroll bar to control the ball speed, and the + or - button add or 
remove a ball, as shown in Figure 20.8.
Key
Point
FIGURE 20.8 Pressing the + or - button adds or removes a ball.
The example in Section 15.12 only had to store one ball. How do you store the multiple balls 
in this example? The Pane’sgetChildren() method returns an ObservableList<Node>, a 
subtype of List<Node>, for storing the nodes in the pane. Initially, the list is empty. When a new 
ball is created, add it to the end of the list. To remove a ball, simply remove the last one in the list.
```

</details>


## PDF page 801

<details>
<summary>Page text</summary>

```text
778 Chapter 20  Lists, Stacks, Queues, and Priority Queues
Each ball has its state: the x-, y-coordinates, color, and direction to move. You can 
define a class named Ball that extends javafx.scene.shape.Circle . The x-, 
y-coordinates and the color are already defined in Circle . When a ball is created, it 
starts from the upper-left corner and moves downward to the right. A random color is 
assigned to a new ball.
The MultiplBallPane class is responsible for displaying the ball and the 
MultipleBounceBall class places the control components and implements the control. The 
relationship of these classes is shown in Figure 20.9. Listing 20.6 gives the program.
FIGURE 20.9 MultipleBounceBall contains MultipleBallPane, and MultipleBallPane contains Ball.
m1 11Ball
dx: double
dy: double
+Ball (x: double, y: double
   radius: double,
   color: color)
javafx.scene.shape.Circle javafx.scene.layout.Pane javafx.application.Application
MultipleBallPane
-animation: Timeline
+MultipleBallPane()
+play(): void
+pause(): void
+increaseSpeed(): void
+decreaseSpeed(): void
+rateProperty(): Double
   Property
+moveBall(): void
MultipleBounceBall
LISTING 20.6 MultipleBounceBall.java
  1 import javafx.animation.KeyFrame;
  2 import javafx.animation.Timeline;
  3 import javafx.application.Application;
  4 import javafx.beans.property.DoubleProperty;
  5 import javafx.geometry.Pos;
  6 import javafx.scene.Node;
  7 import javafx.stage.Stage;
  8 import javafx.scene.Scene;
  9 import javafx.scene.control.Button;
 10 import javafx.scene.control.ScrollBar;
 11 import javafx.scene.layout.BorderPane;
 12 import javafx.scene.layout.HBox;
 13 import javafx.scene.layout.Pane;
 14 import javafx.scene.paint.Color;
 15 import javafx.scene.shape.Circle;
 16 import javafx.util.Duration;
 17
 18 public class MultipleBounceBall extends Application {
 19    @Override // Override the start method in the Application class
 20 public void start(Stage primaryStage) {
 21      MultipleBallPane ballPane = new MultipleBallPane();
 22      ballPane.setStyle("-fx-border-color: yellow");
 23
 24      Button btAdd = new Button("+");
create a ball pane
set ball pane border
create buttons
```

</details>


## PDF page 802

<details>
<summary>Page text</summary>

```text
20.7 Case Study: Bouncing Balls  779
 25      Button btSubtract = new Button("-");
 26      HBox hBox = new HBox(10);
 27      hBox.getChildren().addAll(btAdd, btSubtract);
 28      hBox.setAlignment(Pos.CENTER);
 29
 30 // Add or remove a ball
 31 btAdd.setOnAction(e -> ballPane.add());
 32 btSubtract.setOnAction(e -> ballPane.subtract());
 33
 34 // Pause and resume animation
 35 ballPane.setOnMousePressed(e -> ballPane.pause());
 36 ballPane.setOnMouseReleased(e -> ballPane.play());
 37
 38 // Use a scroll bar to control animation speed
 39 ScrollBar sbSpeed = new ScrollBar();
 40      sbSpeed.setMax(20);
 41      sbSpeed.setValue(10);
 42 ballPane.rateProperty().bind(sbSpeed.valueProperty());
 43
 44      BorderPane pane = new BorderPane();
 45      pane.setCenter(ballPane);
 46      pane.setTop(sbSpeed);
 47      pane.setBottom(hBox);
 48
 49 // Create a scene and place the pane in the stage
 50      Scene scene = new Scene(pane, 250, 150);
 51      primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
 52      primaryStage.setScene(scene); // Place the scene in the stage
 53      primaryStage.show(); // Display the stage
 54    }
 55
 56 private class MultipleBallPane extends Pane {
 57 private Timeline animation;
 58
 59 public MultipleBallPane() {
 60 // Create an animation for moving the ball
 61        animation = new Timeline(
 62 new KeyFrame(Duration.millis(50), e -> moveBall()));
 63        animation.setCycleCount(Timeline.INDEFINITE);
 64 animation.play(); // Start animation
 65      }
 66
 67 public void add() {
 68        Color color = new Color(Math.random(), 
 69          Math.random(), Math.random(), 0.5);
 70 getChildren().add( new Ball(30, 30, 20, color));
 71      }
 72
 73 public void subtract() {
 74 if (getChildren().size() > 0) {
 75          getChildren().remove(getChildren().size() - 1);
 76        }
 77      }
 78
 79 public void play() {
 80        animation.play();
 81      }
 82
 83 public void pause() {
add buttons to HBox
add a ball
remove a ball
pause animation
resume animation
create a scroll bar
bind animation rate 
add a ball to pane
remove a ball
```

</details>


## PDF page 803

<details>
<summary>Page text</summary>

```text
780 Chapter 20  Lists, Stacks, Queues, and Priority Queues
 84        animation.pause();
 85      }
 86
 87 public void increaseSpeed() {
 88        animation.setRate(animation.getRate() + 0.1);
 89      }
 90
 91 public void decreaseSpeed() {
 92        animation.setRate(
 93          animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
 94      }
 95
 96 public DoubleProperty rateProperty() {
 97 return animation.rateProperty();
 98      }
 99
100 protected void moveBall() {
101 for (Node node: this.getChildren()) {
102 Ball ball = (Ball)node;
103 // Check boundaries
104 if (ball.getCenterX() < ball.getRadius() || 
105              ball.getCenterX() > getWidth() - ball.getRadius()) {
106            ball.dx *= -1; // Change ball move direction
107          }
108 if (ball.getCenterY() < ball.getRadius() || 
109              ball.getCenterY() > getHeight() - ball.getRadius()) {
110            ball.dy *= -1; // Change ball move direction
111          }
112
113 // Adjust ball position
114 ball.setCenterX(ball.dx + ball.getCenterX());
115 ball.setCenterY(ball.dy + ball.getCenterY());
116        }
117      }
118    }
119
120 class Ball extends Circle {
121 private double dx = 1, dy = 1;
122
123      Ball(double x, double y, double radius, Color color) {
124 super(x, y, radius);
125        setFill(color); // Set ball color
126      }
127    }
128  }
The add() method creates a new ball with a random color and adds it to the pane (line 
70). The pane stores all the balls in a list. The subtract() method removes the last ball in 
the list (line 75). 
When the user clicks the + button, a new ball is added to the pane (line 31). When the user 
clicks the - button, the last ball in the array list is removed (line 32).
ThemoveBall() method in the MultipleBallPane class gets every ball in the pane’s 
list and adjusts the balls’ positions (lines 114–115).
20.23 What is the return value from invoking pane.getChildre() for a pane?
move all balls
change x direction
change y direction
adjust ball positions
declare dx and dy
create a ball
✓Point✓
Check
```

</details>


## PDF page 804

<details>
<summary>Page text</summary>

```text
20.8 Vector and Stack Classes 781
20.24 How do you modify the code in the MutilpleBallApp program to remove the first 
ball in the list when the  button is clicked? 
20.25 How do you modify the code in the MutilpleBallApp program so that each ball 
will get a random radius between 10 and 20?
20.8 Vector and Stack Classes
Vector is a subclass of AbstractList, and Stack is a subclass of Vector in the 
Java API.
The Java Collections Framework was introduced in Java 2. Several data structures were sup-
ported earlier, among them the Vector and Stack classes. These classes were redesigned 
to fit into the Java Collections Framework, but all their old-style methods are retained for 
compatibility.
Vector is the same as ArrayList, except that it contains synchronized methods for 
accessing and modifying the vector. Synchronized methods can prevent data corruption 
when a vector is accessed and modified by two or more threads concurrently. We will dis-
cuss synchronization in Chapter 30, Multithreading and Parallel Programming. For the many 
applications that do not require synchronization, using ArrayList is more efficient than 
usingVector.
TheVector class extends the AbstractList class. It also has the methods contained in 
the original Vector class defined prior to Java 2, as shown in Figure 20.10.
Key
Point
FIGURE 20.10 Starting in Java 2, the Vector class extends AbstractList and also retains all the methods in the original 
Vector class.
java.util.Vector<E>
+Vector()
+Vector(c: Collection<? extends E>)
+Vector(initialCapacity: int)
+Vector(initCapacity: int, capacityIncr: int)
+addElement(o: E): void
+capacity(): int
+copyInto(anArray: Object[]): void
+elementAt(index: int): E
+elements(): Enumeration<E>
+ensureCapacity(): void
+firstElement(): E
+insertElementAt(o: E, index: int): void
+lastElement(): E
+removeAllElements(): void
+removeElement(o: Object): boolean
+removeElementAt(index: int): void
+setElementAt(o: E, index: int): void
+setSize(newSize: int): void
+trimToSize(): void
Creates a default empty vector with initial capacity 10.
Creates a vector from an existing collection.
Creates a vector with the specified initial capacity.
Creates a vector with the specified initial capacity and increment.
Appends the element to the end of this vector.
Returns the current capacity of this vector.
Copies the elements in this vector to the array.
Returns the object at the specified index.
Returns an enumeration of this vector.
Increases the capacity of this vector.
Returns the first element in this vector.
Insertso into this vector at the specified index.
Returns the last element in this vector.
Removes all the elements in this vector.
Removes the first matching element in this vector.
Removes the element at the specified index.
Sets a new element at the specified index.
Sets a new size in this vector.
Trims the capacity of this vector to its size.
java.util.AbstractList<E>
```

</details>


## PDF page 805

<details>
<summary>Page text</summary>

```text
782 Chapter 20  Lists, Stacks, Queues, and Priority Queues
Most of the methods in the Vector class listed in the UML diagram in Figure 20.10 are 
similar to the methods in the List interface. These methods were introduced before the 
Java Collections Framework. For example, addElement(Object element)  is the same 
as the add(Object element)  method, except that the addElement method is synchro-
nized. Use the ArrayList class if you don’t need synchronization. It works much faster 
thanVector.
Note
The elements() method returns an Enumeration. The Enumeration interface 
was introduced prior to Java 2 and was superseded by the Iterator interface.
Note
Vector is widely used in Java legacy code because it was the Java resizable array imple-
mentation before Java 2.
In the Java Collections Framework, Stack is implemented as an extension of Vector, as 
illustrated in Figure 20.11.
FIGURE 20.11 TheStack class extends Vector to provide a last-in, first-out data 
structure.
java.util.Stack<E>
+Stack()
+empty(): boolean
+peek(): E
+pop(): E
+push(o: E): E
+search(o: Object): int
java.util.Vector<E>
Creates an empty stack.
Returns true if this stack is empty.
Returns the top element in this stack.
Returns and removes the top element in this stack.
Adds a new element to the top of this stack.
Returns the position of the specified element in this stack.
TheStack class was introduced prior to Java 2. The methods shown in Figure 20.11 were 
used before Java 2. The empty() method is the same as isEmpty(). The peek() method 
looks at the element at the top of the stack without removing it. The pop() method removes 
the top element from the stack and returns it. The push(Object element) method adds the 
specified element to the stack. The search(Object element) method checks whether the 
specified element is in the stack.
20.26 How do you create an instance of Vector? How do you add or insert a new element 
into a vector? How do you remove an element from a vector? How do you find the 
size of a vector?
20.27 How do you create an instance of Stack? How do you add a new element to a 
stack? How do you remove an element from a stack? How do you find the size of 
a stack?
20.28 Does Listing 20.1, TestCollection.java, compile and run if all the occurrences of 
ArrayList are replaced by LinkedList,Vector, or Stack?
✓Point✓
Check
```

</details>


## PDF page 806

<details>
<summary>Page text</summary>

```text
20.9 Queues and Priority Queues 783
20.9 Queues and Priority Queues
In a priority queue, the element with the highest priority is removed first.
A queue is a first-in, first-out data structure. Elements are appended to the end of the queue 
and are removed from the beginning of the queue. In a priority queue, elements are assigned 
priorities. When accessing elements, the element with the highest priority is removed first. 
This section introduces queues and priority queues in the Java API.
20.9.1 The Queue Interface
TheQueue interface extends java.util.Collection with additional insertion, extraction, 
and inspection operations, as shown in Figure 20.12.
Key
Point
queue
priority queue
Queue interface
FIGURE 20.12  The Queue interface extends Collection to provide additional insertion, 
extraction, and inspection operations.
«interface»
java.util.Queue<E>
+offer(element: E): boolean
+poll(): E
+remove(): E
+peek(): E
+element(): E
«interface»
java.util.Collection<E>
Inserts an element into the queue.
Retrieves and removes the head of this queue, ornull
if this queue is empty.
Retrieves and removes the head of this queue and
throws an exception if this queue is empty.
Retrieves, but does not remove, the head of this queue,
returningnull if this queue is empty.
Retrieves, but does not remove, the head of this queue,
throws an exception if this queue is empty.
Theoffer method is used to add an element to the queue. This method is similar to the 
add method in the Collection interface, but the offer method is preferred for queues. 
Thepoll and remove methods are similar, except that poll() returns null if the queue is 
empty, whereas remove() throws an exception. The peek and element methods are simi-
lar, except that peek() returns null if the queue is empty, whereas element() throws an 
exception.
20.9.2 Deque and LinkedList
The LinkedList class implements the Deque interface, which extends the Queue inter-
face, as shown in Figure  20.13. Therefore, you can use LinkedList to create a queue. 
LinkedList is ideal for queue operations because it is efficient for inserting and removing 
elements from both ends of a list.
Deque supports element insertion and removal at both ends. The name deque is short for 
“double-ended queue” and is usually pronounced “deck.” The Deque interface extends Queue
with additional methods for inserting and removing elements from both ends of the queue. The 
methods addFirst(e), removeFirst(), addLast(e), removeLast(), getFirst(),
andgetLast() are defined in the Deque interface.
queue operations
```

</details>


## PDF page 807

<details>
<summary>Page text</summary>

```text
784 Chapter 20  Lists, Stacks, Queues, and Priority Queues
Listing 20.7 shows an example of using a queue to store strings. Line 4 creates a queue 
using LinkedList . Four strings are added to the queue in lines 5–8. The size() method 
defined in the Collection  interface returns the number of elements in the queue (line 
10). The remove() method retrieves and removes the element at the head of the queue 
(line 11).
LISTING 20.7 TestQueue.java
 1 public class TestQueue {
 2 public static void main(String[] args) {
 3 java.util.Queue<String> queue = new java.util.LinkedList<>();
 4 queue.offer( "Oklahoma");
 5      queue.offer("Indiana");
 6      queue.offer("Georgia");
 7      queue.offer("Texas");
 8
 9 while (queue.size() > 0)
10        System.out.print(queue.remove() + " ");
11    }
12  }
creates a queue
inserts an element
queue size
remove element
FIGURE 20.13 LinkedList implements List and Deque.
«interface»
java.util.Deque<E>
java.util.LinkedList<E>
«interface»
java.util.Collection<E>
«interface»
java.util.Queue<E>
«interface»
java.util.List<E>
Oklahoma Indiana Georgia Texas
The PriorityQueue class implements a priority queue, as shown in Figure  20.14. 
By default, the priority queue orders its elements according to their natural ordering using 
Comparable. The element with the least value is assigned the highest priority and thus is 
removed from the queue first. If there are several elements with the same highest priority, the 
tie is broken arbitrarily. You can also specify an ordering using Comparator in the construc-
torPriorityQueue(initialCapacity, comparator).
Listing 20.8 shows an example of using a priority queue to store strings. Line 5 creates a pri-
ority queue for strings using its no-arg constructor. This priority queue orders the strings using 
their natural order, so the strings are removed from the queue in increasing order. Lines 16–17 
create a priority queue using the comparator obtained from Collections.reverseOrder(),
which orders the elements in reverse order, so the strings are removed from the queue in decreas-
ing order.
PriorityQueue class
```

</details>


## PDF page 808

<details>
<summary>Page text</summary>

```text
20.9 Queues and Priority Queues 785
LISTING 20.8 PriorityQueueDemo.java
 1 import java.util.*;
 2
 3 public class PriorityQueueDemo {
 4 public static void main(String[] args) {
 5 PriorityQueue<String> queue1 = new PriorityQueue<>();
 6 queue1.offer( "Oklahoma");
 7      queue1.offer("Indiana");
 8      queue1.offer("Georgia");
 9      queue1.offer("Texas");
10
11      System.out.println("Priority queue using Comparable:");
12 while (queue1.size() > 0) {
13        System.out.print(queue1.remove() + " ");
14      }
15
16 PriorityQueue<String> queue2 = new PriorityQueue(
17 4, Collections.reverseOrder());
18      queue2.offer("Oklahoma");
19      queue2.offer("Indiana");
20      queue2.offer("Georgia");
21      queue2.offer("Texas");
22
23      System.out.println("\nPriority queue using Comparator:");
24 while (queue2.size() > 0) {
25        System.out.print(queue2.remove() + " ");
26      }
27    }
28  }
a default queue
inserts an element
a queue with comparator
FIGURE 20.14 ThePriorityQueue class implements a priority queue.
java.util.PriorityQueue<E>
+PriorityQueue()
+PriorityQueue(initialCapacity: int)
+PriorityQueue(c: Collection<? extends
  E>)
+PriorityQueue(initialCapacity: int,
  comparator: Comparator<? super E>)
Creates a default priority queue with initial capacity 11.
Creates a default priority queue with the specified initial
     capacity. 
Creates a priority queue with the specified collection.
Creates a priority queue with the specified initial
capacity and the comparator.
«interface»
java.util.Queue<E>
Priority queue using Comparable:
Georgia Indiana Oklahoma Texas 
Priority queue using Comparator:
Texas Oklahoma Indiana Georgia
20.29 Isjava.util.Queue a subinterface of java.util.Collection,java.util.Set,
orjava.util.List? Does LinkedList implement Queue? ✓Point✓Check
```

</details>


## PDF page 809

<details>
<summary>Page text</summary>

```text
786 Chapter 20  Lists, Stacks, Queues, and Priority Queues
20.30 How do you create a priority queue for integers? By default, how are elements 
ordered in a priority queue? Is the element with the least value assigned the highest 
priority in a priority queue?
20.31 How do you create a priority queue that reverses the natural order of the elements?
20.10 Case Study: Evaluating Expressions
Stacks can be used to evaluate expressions.
Stacks and queues have many applications. This section gives an application that uses stacks 
to evaluate expressions. You can enter an arithmetic expression from Google to evaluate the 
expression, as shown in Figure 20.15.
Key
Point
FIGURE 20.15 You can evaluate an arithmetic expression using a Google search engine.
How does Google evaluate an expression? This section presents a program that evaluates a 
compound expression with multiple operators and parentheses (e.g., (15 + 2) * 34 – 2).
For simplicity, assume that the operands are integers and the operators are of four types: +,
-,*, and /.
The problem can be solved using two stacks, named operandStack and operatorStack,
for storing operands and operators, respectively. Operands and operators are pushed into 
the stacks before they are processed. When an operator is processed , it is popped from 
operatorStack and applied to the first two operands from operandStack (the two oper-
ands are popped from operandStack). The resultant value is pushed back to operandStack.
The algorithm proceeds in two phases:
Phase 1: Scanning the expression
The program scans the expression from left to right to extract operands, operators, and the 
parentheses.
1.1. If the extracted item is an operand, push it to operandStack.
1.2.  If the extracted item is a + or - operator, process all the operators at the top of 
operatorStack and push the extracted operator to operatorStack.
1.3.  If the extracted item is a * or / operator, process the * or / operators at the top of 
operatorStack and push the extracted operator to operatorStack.
compound expression
process an operator
```

</details>


## PDF page 810

<details>
<summary>Page text</summary>

```text
20.10 Case Study: Evaluating Expressions  787
1.4. If the extracted item is a ( symbol, push it to operatorStack.
1.5.  If the extracted item is a ) symbol, repeatedly process the operators from the top 
ofoperatorStack until seeing the ( symbol on the stack.
Phase 2: Clearing the stack
Repeatedly process the operators from the top of operatorStack until operatorStack is 
empty.
Table 20.1 shows how the algorithm is applied to evaluate the expression (1 + 2) * 
4 - 3.
FIGURE 20.16  The program takes an expression as command-line arguments.
Expression Scan Action operandStack operatorStack
(1 + 2)*4 - 3
c
( Phase 1.4 (
(1 + 2)*4 - 3
c
1 Phase 1.1 1 (
(1 + 2)*4 - 3
c
+ Phase 1.2 1 +
(
(1 + 2)*4 - 3
c
2 Phase 1.1 2
1
(
(1 + 2)*4 - 3
c
) Phase 1.5 3
(1 + 2)*4 - 3
c
* Phase 1.3 3 *
(1 + 2)*4 - 3
c
4 Phase 1.1 4
3
*
(1 + 2)*4 - 3
c
- Phase 1.2 12 -
(1 + 2)*4 - 3
c
3 Phase 1.1 3
12
-
(1 + 2)*4 - 3
c
none Phase 2 9
TABLE 20.1  Evaluating an expression
Listing 20.9 gives the program, and Figure 20.16 shows some sample output.
```

</details>


## PDF page 811

<details>
<summary>Page text</summary>

```text
788 Chapter 20  Lists, Stacks, Queues, and Priority Queues
LISTING 20.9 EvaluateExpression.java
  1 import java.util.Stack;
  2
  3 public class EvaluateExpression {
  4 public static void main(String[] args) {
  5 // Check number of arguments passed
  6 if (args.length != 1) {
  7        System.out.println(
  8 "Usage: java EvaluateExpression \"expression\"");
  9        System.exit(1);
 10      }
 11
 12 try {
 13        System.out.println(evaluateExpression(args[0]));
 14      }
 15 catch (Exception ex) {
 16        System.out.println("Wrong expression: " + args[0]);
 17      }
 18    }
 19
 20 /** Evaluate an expression */
 21 public static int evaluateExpression(String expression) {
 22 // Create operandStack to store operands
 23      Stack<Integer> operandStack = new Stack<>();
 24
 25 // Create operatorStack to store operators
 26      Stack<Character> operatorStack = new Stack<>();
 27
 28 // Insert blanks around (, ), +, -, /, and *
 29      expression = insertBlanks(expression); 
 30
 31 // Extract operands and operators
 32 String[] tokens = expression.split( " ");
 33
 34 // Phase 1: Scan tokens
 35 for (String token: tokens) {
 36 if (token.length() == 0) // Blank space
 37 continue; // Back to the while loop to extract the next token
 38 else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
 39 // Process all +, -, *, / in the top of the operator stack 
 40 while (!operatorStack.isEmpty() &&
 41            (operatorStack.peek() == '+' || 
 42             operatorStack.peek() == '-' ||
 43             operatorStack.peek() == '*' ||
 44             operatorStack.peek() == '/')) {
 45            processAnOperator(operandStack, operatorStack);
 46          }
 47
 48 // Push the + or - operator into the operator stack
 49          operatorStack.push(token.charAt(0));
 50        }
 51 else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
 52 // Process all *, / in the top of the operator stack 
 53 while (!operatorStack.isEmpty() &&
 54            (operatorStack.peek() == '*' ||
 55            operatorStack.peek() == '/')) {
 56            processAnOperator(operandStack, operatorStack);
 57          }
 58
check usage
evaluate expression
exception
operandStack
operatorStack
prepare for extraction
extract tokens
process tokens
+ or- scanned
* or / scanned
```

</details>


## PDF page 812

<details>
<summary>Page text</summary>

```text
20.10 Case Study: Evaluating Expressions  789
 59 // Push the * or / operator into the operator stack
 60          operatorStack.push(token.charAt(0));
 61        }
 62 else if (token.trim().charAt(0) == '(') {
 63          operatorStack.push('('); // Push '(' to stack
 64        }
 65 else if (token.trim().charAt(0) == ')') {
 66 // Process all the operators in the stack until seeing '('
 67 while (operatorStack.peek() != '(') {
 68            processAnOperator(operandStack, operatorStack);
 69          }
 70
 71          operatorStack.pop(); // Pop the '(' symbol from the stack
 72        }
 73 else { // An operand scanned
 74 // Push an operand to the stack
 75 operandStack.push( new Integer(token));
 76        }
 77      }
 78
 79 // Phase 2: Process all the remaining operators in the stack 
 80 while (!operatorStack.isEmpty()) {
 81        processAnOperator(operandStack, operatorStack);
 82      }
 83
 84 // Return the result
 85 return operandStack.pop();
 86    }
 87
 88 /** Process one operator: Take an operator from operatorStack and
 89     *  apply it on the operands in the operandStack */
 90 public static void processAnOperator(
 91        Stack<Integer> operandStack, Stack<Character> operatorStack) {
 92 char op = operatorStack.pop();
 93 int op1 = operandStack.pop();
 94 int op2 = operandStack.pop();
 95 if (op == '+')
 96        operandStack.push(op2 + op1);
 97 else if (op == '-')
 98        operandStack.push(op2 - op1);
 99 else if (op == '*')
100        operandStack.push(op2 * op1);
101 else if (op == '/')
102        operandStack.push(op2 / op1);
103    }
104
105 public static String insertBlanks(String s) {
106      String result = "";
107
108 for (int i = 0; i < s.length(); i++) {
109 if (s.charAt(i) == '(' || s.charAt(i) == ')' || 
110            s.charAt(i) == '+' || s.charAt(i) == '-' ||
111            s.charAt(i) == '*' || s.charAt(i) == '/')
112          result += " " + s.charAt(i) + " ";
113 else
114          result += s.charAt(i);
115      }
116
117 return result;
118    }
119  }
( scanned
) scanned
an operand scanned
clearoperatorStack
return result
process+
process-
process*
process/
insert blanks
```

</details>


## PDF page 813

<details>
<summary>Page text</summary>

```text
790 Chapter 20  Lists, Stacks, Queues, and Priority Queues
You can use the GenericStack class provided by the book or the java.util.Stack
class defined in the Java API for creating stacks. This example uses the java.util.Stack
class. The program will work if it is replaced by GenericStack.
The program takes an expression as a command-line argument in one string.
The evaluateExpression method creates two stacks, operandStack and 
operatorStack (lines 23, 26), and extracts operands, operators, and parentheses delimited 
by space (lines 29–32). The insertBlanks method is used to ensure that operands, opera-
tors, and parentheses are separated by at least one blank (line 29).
The program scans each token in the for loop (lines 35–77). If a token is empty, skip it 
(line 37). If a token is an operand, push it to operandStack (line 75). If a token is a + or 
– operator (line 38), process all the operators from the top of operatorStack, if any (lines 
40–46), and push the newly scanned operator into the stack (line 49). If a token is a * or /
operator (line 51), process all the * and / operators from the top of operatorStack, if any 
(lines 53–57), and push the newly scanned operator to the stack (line 60). If a token is a (
symbol (line 62), push it into operatorStack. If a token is a ) symbol (line 65), process all 
the operators from the top of operatorStack until seeing the ) symbol (lines 67–69) and 
pop the ) symbol from the stack.
After all tokens are considered, the program processes the remaining operators in 
operatorStack (lines 80–82).
TheprocessAnOperator method (lines 90–103) processes an operator. The method pops 
the operator from operatorStack (line 92) and pops two operands from operandStack
(lines 93–94). Depending on the operator, the method performs an operation and pushes the 
result of the operation back to operandStack (lines 96, 98, 100, 102).
20.32 Can the EvaluateExpression program evaluate the following expressions "1+2",
"1 +    2", "(1) +    2", "((1)) +    2",  and "(1 +    2)"?
20.33 Show the change of the contents in the stacks when evaluating "3 + (4 + 5) * 
(3 + 5) + 4 * 5" using the EvaluateExpression program.
20.34 If you enter an expression “4 + 5 5 5”, the program will display 10. How do you 
fix this problem?
✓Point✓
Check
KEY TERMS
collection 762
comparator 772
convenience abstract class 762
data structure 762
linked list 769
list 762
priority queue 783
queue 762
CHAPTER SUMMARY
1. The Java Collections Framework supports sets, lists, queues, and maps. They are defined 
in the interfaces Set,List,Queue, and Map.
2. A list stores an ordered collection of elements.
3. All the concrete classes except PriorityQueue in the Java Collections Framework 
implement the Cloneable and Serializable interfaces. Thus, their instances can be 
cloned and serialized.
```

</details>


## PDF page 814

<details>
<summary>Page text</summary>

```text
Programming Exercises  791
4. To allow duplicate elements to be stored in a collection, you need to use a list. A list 
not only can store duplicate elements but also allows the user to specify where they are 
stored. The user can access elements by an index.
5. Two types of lists are supported: ArrayList and LinkedList. ArrayList is a 
resizable-array implementation of the List interface. All the methods in ArrayList
are defined in List.LinkedList is a linked-list implementation of the List interface. 
In addition to implementing the List interface, this class provides the methods for 
retrieving, inserting, and removing elements from both ends of the list.
6. Comparator can be used to compare the objects of a class that doesn’t implement 
Comparable.
7. TheVector class extends the AbstractList class. Starting with Java 2, Vector has 
been the same as ArrayList, except that the methods for accessing and modifying 
the vector are synchronized. The Stack class extends the Vector class and provides 
several methods for manipulating the stack.
8. TheQueue interface represents a queue. The PriorityQueue class implements Queue
for a priority queue.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
Sections 20.2–20.7
*20.1 (Display words in ascending alphabetical order ) Write a program that reads 
words from a text file and displays all the words (duplicates allowed) in ascend-
ing alphabetical order. The words must start with a letter. The text file is passed 
as a command-line argument.
*20.2 (Store numbers in a linked list ) Write a program that lets the user enter num-
bers from a graphical user interface and displays them in a text area, as shown in 
Figure 20.17a. Use a linked list to store the numbers. Do not store duplicate num-
bers. Add the buttons Sort, Shuffle, and Reverse to sort, shuffle, and reverse the list.
FIGURE 20.17 (a) The numbers are stored in a list and displayed in the text area. (b) The colliding balls are combined.
(a) (b)
```

</details>


## PDF page 815

<details>
<summary>Page text</summary>

```text
792 Chapter 20  Lists, Stacks, Queues, and Priority Queues
*20.3 (Guessing the capitals) Rewrite Programming Exercise 8.37 to store the pairs 
of states and capitals so that the questions are displayed randomly.
*20.4 (Sort points in a plane) Write a program that meets the following requirements:
 ■ Define a class named Point with two data fields x and y to represent a 
point’s x- and y-coordinates. Implement the Comparable interface for com-
paring the points on x-coordinates. If two points have the same x-coordinates,
compare their y-coordinates.
 ■ Define a class named CompareY that implements Comparator<Point>.
Implement the compare method to compare two points on theiry-coordinates.
If two points have the same y-coordinates, compare their x-coordinates.
 ■ Randomly create 100 points and apply the Arrays.sort method to display 
the points in increasing order of their x-coordinates and in increasing order 
of their y-coordinates, respectively.
***20.5 (Combine colliding bouncing balls) The example in Section 20.7 displays mul-
tiple bouncing balls. Extend the example to detect collisions. Once two balls 
collide, remove the later ball that was added to the pane and add its radius to 
the other ball, as shown in Figure 20.17b. Use the Suspend button to suspend 
the animation and the Resume button to resume the animation. Add a mouse 
pressed handler that removes a ball when the mouse is pressed on the ball.
20.6 (Use iterators on linked lists) Write a test program that stores 5 million integers 
in a linked list and test the time to traverse the list using an iterator vs. using 
theget(index) method.
***20.7 (Game: hangman) Programming Exercise 7.35 presents a console version of the 
popular hangman game. Write a GUI program that lets a user play the game. The 
user guesses a word by entering one letter at a time, as shown in Figure 20.18. 
If the user misses seven times, a hanging man swings. Once a word is finished, 
the user can press the Enter key to continue to guess another word.
**20.8 (Game: lottery) Revise Programming Exercise 3.15 to add an additional $2,000 
award if two digits from the user input are in the lottery number. ( Hint: Sort 
the three digits in the lottery number and three digits in the user input into two 
lists, and use the Collection’s containsAll method to check whether the 
two digits in the user input are in the lottery number.)
Sections 20.8–20.10
***20.9 (Remove the largest ball first ) Modify Listing 20.6, MultipleBallApp.java to 
assign a random radius between 2 and 20 when a ball is created. When the -
button is clicked, one of largest balls is removed.
20.10 (Perform set operations on priority queues ) Create two priority queues, 
{"George", "Jim", "John", "Blake", "Kevin", "Michael"} and 
{"George", "Katie", "Kevin", "Michelle", "Ryan"}, and find their 
union, difference, and intersection.
*20.11 (Match grouping symbols) A Java program contains various pairs of grouping 
symbols, such as:
 ■ Parentheses:( and )
 ■ Braces:{ and }
 ■ Brackets:[ and ]
Note that the grouping symbols cannot overlap. For example, (a{b)} is illegal. 
Write a program to check whether a Java source-code file has correct pairs of 
grouping symbols. Pass the source-code file name as a command-line argument.
```

</details>


## PDF page 816

<details>
<summary>Page text</summary>

```text
Programming Exercises  793
FIGURE 20.18 The program displays a hangman game.
```

</details>


## PDF page 817

<details>
<summary>Page text</summary>

```text
794 Chapter 20  Lists, Stacks, Queues, and Priority Queues
20.12 (Clone PriorityQueue) Define MyPriorityQueue class that extends 
PriorityQueue to implement the Cloneable interface and implement the 
clone() method to clone a priority queue.
**20.13 (Game: the 24-point card game ) The 24-point game is to pick any 4 cards 
from 52 cards, as shown in Figure 20.19. Note that the Jokers are excluded. 
Each card represents a number. An Ace, King, Queen, and Jack represent 1,
13,12, and 11, respectively. You can click the Shuffle button to get four new 
cards. Enter an expression that uses the four numbers from the four selected 
cards. Each number must be used once and only once. You can use the opera-
tors (addition, subtraction, multiplication, and division) and parentheses in the 
expression. The expression must evaluate to 24. After entering the expression, 
click the Verify button to check whether the numbers in the expression are cur-
rently selected and whether the result of the expression is correct. Display the 
verification in a label before the Shuffle button. Assume that images are stored 
in files named 1.png, 2.png, . . . , 52.png, in the order of spades, hearts, dia-
monds, and clubs. So, the first 13 images are for spades 1, 2, 3, . . . , and 13.
FIGURE 20.19  The user enters an expression consisting of the numbers in the cards and clicks the Verify button to 
check the answer.
113
2
3
3
12+3* 12+3*
9
scanned scanned
12+3*
scanned
12+3*
scanned
12+3*
scanned
**20.14 (Postfix notation ) Postfix notation is a way of writing expressions without 
using parentheses. For example, the expression (1 + 2) * 3  would be 
written as 1 2 + 3 *. A postfix expression is evaluated using a stack. Scan a 
postfix expression from left to right. A variable or constant is pushed into the 
stack. When an operator is encountered, apply the operator with the top two 
operands in the stack and replace the two operands with the result. The follow-
ing diagram shows how to evaluate 1 2 + 3 *.
```

</details>


## PDF page 818

<details>
<summary>Page text</summary>

```text
Programming Exercises  795
  Write a program to evaluate postfix expressions. Pass the expression as a 
command-line argument in one string.
***20.15 (Game: the 24-point card game ) Improve Programming Exercise 20.13 
to enable the computer to display the expression if one exists, as shown in 
Figure 20.20. Otherwise, report that the expression does not exist. Place the 
label for verification result at the bottom of UI. The expression must use all 
four cards and evaluates to 24. 
FIGURE 20.20 The program can automatically find a solution if one exists.
**20.16 (Convert infix to postfix) Write a method that converts an infix expression into 
a postfix expression using the following header:
public static String infixToPostfix(String expression)
For example, the method should convert the infix expression (1 + 2) * 3 to 
1 2 + 3 * and 2 * (1 + 3) to 2 1 3 + *.
***20.17 (Game: the 24-point card game ) This exercise is a variation of the 24-point 
card game described in Programming Exercise 20.13. Write a program to 
check whether there is a 24-point solution for the four specified numbers. The 
program lets the user enter four values, each between 1 and 13, as shown in 
Figure 20.21. The user can then click the Solve button to display the solution or 
display “No solution” if none exist.
*20.18 (Directory size) Listing 20.7, DirectorySize.java, gives a recursive method for 
finding a directory size. Rewrite this method without using recursion. Your 
FIGURE 20.21 The user enters four numbers and the program finds a solution.
```

</details>


## PDF page 819

<details>
<summary>Page text</summary>

```text
796 Chapter 20  Lists, Stacks, Queues, and Priority Queues
program should use a queue to store the subdirectories under a directory. The 
algorithm can be described as follows:
long getSize(File directory) {
long size = 0;
  add directory to the queue;
while (queue is not empty) {
    Remove an item from the queue into t;
if (t is a file)
      size += t.length();
else
      add all the files and subdirectories under t into the 
        queue;
  }
return size;
}
***20.19 (Game: solution ratio for 24-point game ) When you pick four cards from a 
deck of 52 cards for the 24-point game introduced in Programming Exercise 
20.13, the four cards may not have a 24-point solution. What is the number 
of all possible picks of four cards from 52 cards? Among all possible picks, 
how many of them have 24-point solutions? What is the success ratio—that is, 
(number of picks with solutions)/ (number of all possible picks of four cards)? 
Write a program to find these answers.
*20.20 (Directory size) Rewrite Programming Exercise 18.28 using a stack instead of 
a queue.
*20.21 (Use Comparator) Write the following generic method using selection sort 
and a comparator.
public static <E> void selectionSort(E[] list,
  Comparator<? super E> comparator)
Write a test program that creates an array of 10 GeometricObjects and 
invokes this method using the GeometricObjectComparator introduced in 
Listing 20.4 to sort the elements. Display the sorted elements. Use the follow-
ing statement to create the array.
GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
new Circle(6.5), new Rectangle(4, 5)};
*20.22 (Nonrecursive Tower of Hanoi) Implement the moveDisks method in Listing 
18.8 using a stack instead of using recursion.
**20.23 (Evaluate expression ) Modify Listing 20.9 EvaluateExpression.java to add 
operators ^ for exponent and % for modulus. For example, 3 ^ 2 is9 and 3 % 2 
is1. The ^ operator has the highest precedence and the % operator has the same 
precedence as the * and / operators. Your program should prompt the user to 
enter an expression. Here is a sample run of the program:
Enter an expression: (5 * 2 ^ 3 + 2 * 3 % 2) * 4
(5 * 2 ^ 3 + 2 * 3 % 2) * 4 = 160
```

</details>
