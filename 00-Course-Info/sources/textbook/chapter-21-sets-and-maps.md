# Chapter 21 Sets and Maps

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 820

<details>
<summary>Page text</summary>

```text
SETS AND MAPS
Objectives
■ To store unordered, nonduplicate elements using a set (§21.2).
■ To explore how and when to use HashSet (§21.2.1), LinkedHashSet
(§21.2.2), or TreeSet (§21.2.3) to store a set of elements.
■ To compare the performance of sets and lists (§21.3).
■ To use sets to develop a program that counts the keywords in a Java 
source file (§21.4).
■ To tell the differences between Collection and Map and describe 
when and how to use HashMap, LinkedHashMap, or TreeMap to 
store values associated with keys (§21.5).
■ To use maps to develop a program that counts the occurrence of the 
words in a text (§21.6).
■ To obtain singleton sets, lists, and maps, and unmodifiable sets, lists, 
and maps, using the static methods in the Collections class (§21.7).
CHAPTER
21
```

</details>


## PDF page 821

<details>
<summary>Page text</summary>

```text
798 Chapter 21  Sets and Maps
21.1 Introduction
A set is an efficient data structure for storing and processing nonduplicate elements. 
A map is like a dictionary that provides a quick lookup to retrieve a value using a key.
The “No-Fly” list is a list, created and maintained by the U.S. government’s Terrorist Screen-
ing Center, of people who are not permitted to board a commercial aircraft for travel in or out 
of the United States. Suppose we need to write a program that checks whether a person is on 
the No-Fly list. You can use a list to store names in the No-Fly list. However, a more efficient 
data structure for this application is a set.
Suppose your program also needs to store detailed information about terrorists in the 
No-Fly list. The detailed information such as gender, height, weight, and nationality can be 
retrieved using the name as the key. A map is an efficient data structure for such a task.
This chapter introduces sets and maps in the Java Collections Framework.
21.2 Sets
You can create a set using one of its three concrete classes: HashSet,
LinkedHashSet, or TreeSet.
The Set interface extends the Collection interface, as shown in Figure 20.1. It does not 
introduce new methods or constants, but it stipulates that an instance of Set contains no 
duplicate elements. The concrete classes that implement Set must ensure that no duplicate 
elements can be added to the set. That is, no two elements e1 and e2 can be in the set such 
thate1.equals(e2) is true.
The AbstractSet class extends AbstractCollection and partially implements Set.
The AbstractSet class provides concrete implementations for the equals method and 
the hashCode method. The hash code of a set is the sum of the hash codes of all the ele-
ments in the set. Since the size method and iterator method are not implemented in the 
AbstractSet class, AbstractSet is an abstract class.
Three concrete classes of Set are HashSet, LinkedHashSet, and TreeSet, as shown 
in Figure 21.1.
21.2.1 HashSet
The HashSet class is a concrete class that implements Set. You can create an empty hash
set using its no-arg constructor or create a hash set from an existing collection. By default, 
the initial capacity is 16 and the load factor is 0.75. If you know the size of your set, you can 
specify the initial capacity and load factor in the constructor. Otherwise, use the default set-
ting. The load factor is a value between 0.0 and 1.0.
The load factor measures how full the set is allowed to be before its capacity is increased. 
When the number of elements exceeds the product of the capacity and load factor, the capacity is 
automatically doubled. For example, if the capacity is 16 and load factor is 0.75, the capacity will 
be doubled to 32 when the size reaches 12 (16*0.75 = 12). A higher load factor decreases the 
space costs but increases the search time. Generally, the default load factor 0.75 is a good trade-
off between time and space costs. We will discuss more on the load factor in Chapter 27, Hashing.
A HashSet can be used to store duplicate-free elements. For efficiency, objects added 
to a hash set need to implement the hashCode method in a manner that properly disperses 
the hash code. Recall that hashCode is defined in the Object class. The hash codes of two 
objects must be the same if the two objects are equal. Two unequal objects may have the 
same hash code, but you should implement the hashCode method to avoid too many such 
cases. Most of the classes in the Java API implement the hashCode method. For example, 
thehashCode in the Integer class returns its int value. The hashCode in the Character
class returns the Unicode of the character. The hashCode in the String class returns 
s0 *31(n - 1) + s1 *31(n - 2) + c + sn - 1, where si is s.charAt(i).
Key
Point
why set?
why map?
Key
Point
set
no duplicates
AbstractSet
hash set
load factor
hashCode()
```

</details>


## PDF page 822

<details>
<summary>Page text</summary>

```text
21.2 Sets  799
Listing 21.1 gives a program that creates a hash set to store strings and uses a foreach loop 
to traverse the elements in the set.
LISTING 21.1 TestHashSet.java
 1 import java.util.*;
 2
 3 public class TestHashSet {
 4 public static void main(String[] args) {
 5 // Create a hash set
6 Set<String> set = new HashSet<>();
 7
 8 // Add strings to the set
 9 set.add( "London");
10      set.add("Paris");
11      set.add("New York");
12      set.add("San Francisco");
13      set.add("Beijing");
create a set
add element
FIGURE 21.1 The Java Collections Framework provides three concrete set classes.
java.util.AbstractSet<E>
+HashSet()
+HashSet(c: Collection<? extends E>)
+HashSet(initialCapacity: int)
+HashSet(initialCapacity: int, loadFactor: float) 
java.util.TreeSet<E>
+TreeSet()
+TreeSet(c: Collection<? extends E>)
+TreeSet(comparator: Comparator<?
  super E>)
+TreeSet(s: SortedSet<E>) 
+first(): E
+last(): E
+headSet(toElement: E): SortedSet<E>
+tailSet(fromElement: E): SortedSet<E>
«interface»
java.util.Set<E>
java.util.HashSet<E>
«interface»
java.util.SortedSet<E>
+pollFirst(): E
+pollLast(): E
+lower(e: E): E
+higher(e: E):E
+floor(e: E): E
+ceiling(e: E): E
«interface»
java.util.NavigableSet<E>
«interface»
java.util.Collection<E>
java.util.LinkedHashSet<E>
+LinkedHashSet()
+LinkedHashSet(c: Collection<? extends E>)
+LinkedHashSet(initialCapacity: int)
+LinkedHashSet(initialCapacity: int, loadFactor: float)
```

</details>


## PDF page 823

<details>
<summary>Page text</summary>

```text
800 Chapter 21  Sets and Maps
14      set.add("New York");
15
16      System.out.println(set);
17
18 // Display the elements in the hash set
19 for (String s: set) {
20        System.out.print(s.toUpperCase() + " ");
21      }
22    }
23  }
traverse elements
[San Francisco, New York, Paris, Beijing, London]
SAN FRANCISCO NEW YORK PARIS BEIJING LONDON
The strings are added to the set (lines 9–14). New York is added to the set more than once, but 
only one string is stored, because a set does not allow duplicates.
As shown in the output, the strings are not stored in the order in which they are inserted 
into the set. There is no particular order for the elements in a hash set. To impose an order 
on them, you need to use the LinkedHashSet class, which is introduced in the next section.
Recall that the Collection interface extends the Iterable interface, so the elements in 
a set are iterable. A foreach loop is used to traverse all the elements in the set (lines 19–21).
Since a set is an instance of Collection, all methods defined in Collection can be used 
for sets. Listing 21.2 gives an example that applies the methods in the Collection interface 
on sets.
LISTING 21.2 TestMethodsInCollection.java
 1 public class TestMethodsInCollection {
 2 public static void main(String[] args) {
 3 // Create set1
 4 java.util.Set<String> set1 = new java.util.HashSet<>();
 5
 6 // Add strings to set1
 7 set1.add( "London");
 8      set1.add("Paris");
 9      set1.add("New York");
10      set1.add("San Francisco");
11      set1.add("Beijing");
12
13      System.out.println("set1 is " + set1);
14      System.out.println(set1.size() + " elements in set1");
15
16 // Delete a string from set1
17 set1.remove( "London");
18      System.out.println("\nset1 is " + set1);
19      System.out.println(set1.size() + " elements in set1");
20
21 // Create set2
22 java.util.Set<String> set2 = new java.util.HashSet<>();
23
24 // Add strings to set2
25 set2.add( "London");
26      set2.add("Shanghai");
27      set2.add("Paris");
28      System.out.println("\nset2 is " + set2);
29      System.out.println(set2.size() + " elements in set2");
create a set
add element
get size
remove element
create a set
add element
```

</details>


## PDF page 824

<details>
<summary>Page text</summary>

```text
21.2 Sets  801
30
31      System.out.println("\nIs Taipei in set2? "
32        + set2.contains("Taipei"));
33
34 set1.addAll(set2);
35      System.out.println("\nAfter adding set2 to set1, set1 is "
36        + set1);
37
38 set1.removeAll(set2);
39      System.out.println("After removing set2 from set1, set1 is "
40        + set1);
41
42 set1.retainAll(set2);
43      System.out.println("After removing common elements in set2 "
44        + "from set1, set1 is " + set1);
45    }
46  }
contains element?
addAll
removeAll
retainAll
set1 is [San Francisco, New York, Paris, Beijing, London]
5 elements in set1
set1 is [San Francisco, New York, Paris, Beijing]
4 elements in set1
set2 is [Shanghai, Paris, London]
3 elements in set2
Is Taipei in set2? false
After adding set2 to set1, set1 is 
  [San Francisco, New York, Shanghai, Paris, Beijing, London]
After removing set2 from set1, set1 is 
  [San Francisco, New York, Beijing]
After removing common elements in set2 from set1, set1 is [] 
The program creates two sets (lines 4, 22). The size() method returns the number of the 
elements in a set (line 14). Line 17
set1.remove("London");
removesLondon from set1.
Thecontains method (line 32) checks whether an element is in the set.
Line 34
set1.addAll(set2);
addsset2 to set1. Therefore, set1 becomes [San Francisco, New York, Shanghai, 
Paris, Beijing, London].
Line 38
set1.removeAll(set2);
removesset2 from set1. Thus, set1 becomes [San Francisco, New York, Beijing].
Line 42
set1.retainAll(set2);
```

</details>


## PDF page 825

<details>
<summary>Page text</summary>

```text
802 Chapter 21  Sets and Maps
retains the common elements in set1. Since set1 and set2 have no common elements, 
set1 becomes empty.
21.2.2 LinkedHashSet
LinkedHashSet extends HashSet with a linked-list implementation that supports an order-
ing of the elements in the set. The elements in a HashSet are not ordered, but the elements 
in a LinkedHashSet can be retrieved in the order in which they were inserted into the set. A 
LinkedHashSet can be created by using one of its four constructors, as shown in Figure 21.1. 
These constructors are similar to the constructors for HashSet.
Listing 21.3 gives a test program for LinkedHashSet. The program simply replaces 
HashSet by LinkedHashSet in Listing 21.1.
LISTING 21.3 TestLinkedHashSet.java
 1 import java.util.*;
 2
 3 public class TestLinkedHashSet {
 4 public static void main(String[] args) {
 5 // Create a hash set
 6 Set<String> set = new LinkedHashSet<>();
 7
 8 // Add strings to the set
 9      set.add("London");
10      set.add("Paris");
11      set.add("New York");
12      set.add("San Francisco");
13      set.add("Beijing");
14      set.add("New York");
15
16      System.out.println(set);
17
18 // Display the elements in the hash set
19 for (Object element: set)
20 System.out.print(element.toLowerCase() + " ");
21    }
22  }
linked hash set
create linked hash set
add element
display elements
[London, Paris, New York, San Francisco, Beijing]
london paris new york san francisco beijing 
ALinkedHashSet is created in line 6. As shown in the output, the strings are stored in the order 
in which they are inserted. Since LinkedHashSet is a set, it does not store duplicate elements.
TheLinkedHashSet maintains the order in which the elements are inserted. To impose a 
different order (e.g., increasing or decreasing order), you can use the TreeSet class, which is 
introduced in the next section.
Tip
If you don’t need to maintain the order in which the elements are inserted, use HashSet,
which is more efficient than LinkedHashSet.
21.2.3 TreeSet
SortedSet is a subinterface of Set, which guarantees that the elements in the set are sorted. 
Additionally, it provides the methods first() and last() for returning the first and last 
elements in the set, and headSet(toElement) and tailSet(fromElement) for returning
```

</details>


## PDF page 826

<details>
<summary>Page text</summary>

```text
21.2 Sets  803
a portion of the set whose elements are less than toElement and greater than or equal to 
fromElement, respectively.
NavigableSet extends SortedSet to provide navigation methods lower(e),
floor(e), ceiling(e), and higher(e) that return elements respectively less than, less 
than or equal, greater than or equal, and greater than a given element and return null if there 
is no such element. The pollFirst() and pollLast() methods remove and return the first 
and last element in the tree set, respectively.
TreeSet implements the SortedSet interface. To create a TreeSet, use a constructor, 
as shown in Figure 21.1. You can add objects into a tree set as long as they can be compared 
with each other.
As discussed in Section  20.5, the elements can be compared in two ways: using the 
Comparable interface or the Comparator interface.
Listing 21.4 gives an example of ordering elements using the Comparable interface. The 
preceding example in Listing 21.3 displays all the strings in their insertion order. This example 
rewrites the preceding example to display the strings in alphabetical order using the TreeSet class.
LISTING 21.4 TestTreeSet.java
 1 import java.util.*;
 2
 3 public class TestTreeSet {
 4 public static void main(String[] args) {
 5 // Create a hash set
 6 Set<String> set = new HashSet<>();
 7
 8 // Add strings to the set
 9      set.add("London");
10      set.add("Paris");
11      set.add("New York");
12      set.add("San Francisco");
13      set.add("Beijing");
14      set.add("New York");
15
16 TreeSet<String> treeSet = new TreeSet<>(set);
17      System.out.println("Sorted tree set: " + treeSet);
18
19 // Use the methods in SortedSet interface
20      System.out.println("first(): " + treeSet.first());
21      System.out.println("last(): " + treeSet.last());
22      System.out.println("headSet(\"New York\"): " + 
23        treeSet.headSet("New York"));
24      System.out.println("tailSet(\"New York\"): " + 
25        treeSet.tailSet("New York"));
26
27 // Use the methods in NavigableSet interface
28      System.out.println("lower(\"P\"): " + treeSet.lower("P"));
29      System.out.println("higher(\"P\"): " + treeSet.higher("P"));
30      System.out.println("floor(\"P\"): " + treeSet.floor("P"));
31      System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));
32      System.out.println("pollFirst(): " + treeSet.pollFirst());
33      System.out.println("pollLast(): " + treeSet.pollLast());
34      System.out.println("New tree set: " + treeSet);
35    }
36  }
tree set
create hash set
create tree set
display elements
Sorted tree set: [Beijing, London, New York, Paris, San Francisco]
first(): Beijing
last(): San Francisco
```

</details>


## PDF page 827

<details>
<summary>Page text</summary>

```text
804 Chapter 21  Sets and Maps
The example creates a hash set filled with strings, then creates a tree set for the same strings. The 
strings are sorted in the tree set using the compareTo method in the Comparable interface.
The elements in the set are sorted once you create a TreeSet object from a HashSet
object using new TreeSet<String>(set)  (line 16). You may rewrite the program to 
create an instance of TreeSet using its no-arg constructor, and add the strings into the 
TreeSet object.
treeSet.first() returns the first element in treeSet (line 20), and treeSet.last()
returns the last element in treeSet (line 21). treeSet.headSet("New York") returns the 
elements in treeSet before New York (lines 22–23). treeSet.tailSet("New York")
returns the elements in treeSet after New York, including New York (lines 24–25).
treeSet.lower("P") returns the largest element less than P in treeSet (line 28). 
treeSet.higher("P") returns the smallest element greater than P in treeSet (line 29). 
treeSet.floor("P") returns the largest element less than or equal to P in treeSet
(line 30). treeSet.ceiling("P") returns the smallest element greater than or equal to P
in treeSet (line 31). treeSet.pollFirst() removes the first element in treeSet and 
returns the removed element (line 32). treeSet.pollLast() removes the last element in 
treeSet and returns the removed element (line 33).
Note
All the concrete classes in Java Collections Framework (see Figure 20.1) have at least 
two constructors. One is the no-arg constructor that constructs an empty collection. 
The other constructs instances from a collection. Thus the TreeSet class has the con-
structorTreeSet(Collection c) for constructing a TreeSet from a collection c.
In this example, new TreeSet<>(set)  creates an instance of TreeSet from the 
collectionset.
Tip
If you don’t need to maintain a sorted set when updating a set, you should use a hash 
set, because it takes less time to insert and remove elements in a hash set. When you 
need a sorted set, you can create a tree set from the hash set.
If you create a TreeSet using its no-arg constructor, the compareTo method is used to com-
pare the elements in the set, assuming that the class of the elements implements the Comparable
interface. To use a comparator, you have to use the constructor TreeSet(Comparator 
comparator) to create a sorted set that uses the compare method in the comparator to order 
the elements in the set.
Listing 21.5 gives a program that demonstrates how to sort elements in a tree set using the 
Comparator interface.
LISTING 21.5 TestTreeSetWithComparator.java
 1 import java.util.*;
 2
headSet("New York"): [Beijing, London]
tailSet("New York"): [New York, Paris, San Francisco]
lower("P"): New York
higher("P"): Paris
floor("P"): New York
ceiling("P"): Paris
pollFirst(): Beijing
pollLast(): San Francisco
New tree set: [London, New York, Paris]
```

</details>


## PDF page 828

<details>
<summary>Page text</summary>

```text
21.2 Sets  805
 3 public class TestTreeSetWithComparator {
 4 public static void main(String[] args) {
 5 // Create a tree set for geometric objects using a comparator
 6      Set<GeometricObject> set = 
 7 new TreeSet<>(new GeometricObjectComparator());
 8      set.add(new Rectangle(4, 5));
 9      set.add(new Circle(40));
10      set.add(new Circle(40));
11      set.add(new Rectangle(4, 1));
12
13 // Display geometric objects in the tree set
14      System.out.println("A sorted set of geometric objects");
15 for (GeometricObject element: set)
16        System.out.println("area = " + element.getArea());
17    }
18  }
tree set
display elements
A sorted set of geometric objects
area = 4.0
area = 20.0
area = 5021.548245743669
The GeometricObjectComparator class is defined in Listing 20.4. The program creates 
a tree set of geometric objects using the GeometricObjectComparator for comparing the 
elements in the set (lines 6–7).
TheCircle and Rectangle classes were defined in Section 13.2, Abstract Classes. They 
are all subclasses of GeometricObject. They are added to the set (lines 8–11).
Two circles of the same radius are added to the tree set (lines 9–10), but only one is stored, 
because the two circles are equal and the set does not allow duplicates.
21.1 How do you create an instance of Set? How do you insert a new element in a set? 
How do you remove an element from a set? How do you find the size of a set?
21.2 If two objects o1 and o2 are equal, what is o1.equals(o2) and o1.hashCode()
== o2.hashCode()?
21.3 What are the differences between HashSet,LinkedHashSet, and TreeSet?
21.4 How do you traverse the elements in a set?
21.5 How do you sort the elements in a set using the compareTo method in the 
Comparable interface? How do you sort the elements in a set using the Comparator
interface? What would happen if you added an element that could not be compared 
with the existing elements in a tree set?
21.6 Suppose that set1 is a set that contains the strings red, yellow, and green, and 
thatset2 is another set that contains the strings red,yellow, and blue. Answer the 
following questions:
■ What are in set1 and set2 after executing set1.addAll(set2)?
■ What are in set1 and set2 after executing set1.add(set2)?
■ What are in set1 and set2 after executing set1.removeAll(set2)?
■ What are in set1 and set2 after executing set1.remove(set2)?
■ What are in set1 and set2 after executing set1.retainAll(set2)?
■ What is in set1 after executing set1.clear()?
✓Point✓
Check
```

</details>


## PDF page 829

<details>
<summary>Page text</summary>

```text
806 Chapter 21  Sets and Maps
21.7 Show the output of the following code:
import java.util.*;
public class Test {
public static void main(String[] args) {
    LinkedHashSet<String> set1 = new LinkedHashSet<>();
    set1.add("New York");
    LinkedHashSet<String> set2 = set1;
    LinkedHashSet<String> set3 = 
      (LinkedHashSet<String>)(set1.clone());
    set1.add("Atlanta");
    System.out.println("set1 is " + set1);
    System.out.println("set2 is " + set2);
    System.out.println("set3 is " + set3);
  }
}
21.8 Show the output of the following code:
import java.util.*;
import java.io.*;
public class Test {
public static void main(String[] args) throws Exception {
    ObjectOutputStream output = new ObjectOutputStream(
new FileOutputStream("c:\\test.dat"));
    LinkedHashSet<String> set1 = new LinkedHashSet<>();
    set1.add("New York");
    LinkedHashSet<String> set2 = 
      (LinkedHashSet<String>)set1.clone();
    set1.add("Atlanta");
    output.writeObject(set1);
    output.writeObject(set2);
    output.close();
    ObjectInputStream input = new ObjectInputStream(
new FileInputStream("c:\\test.dat"));
    set1 = (LinkedHashSet<String>)input.readObject();
    set2 = (LinkedHashSet<String>)input.readObject();
    System.out.println(set1);
    System.out.println(set2);
    output.close();
  }
}
21.9 What will the output be if lines 6–7 in Listing 21.5 is replaced by the following 
code:
Set<GeometricObject> set = new HashSet<>();
21.3 Comparing the Performance of Sets and Lists
Sets are more efficient than lists for storing nonduplicate elements. Lists are useful for 
accessing elements through the index.
The elements in a list can be accessed through the index. However, sets do not support index-
ing, because the elements in a set are unordered. To traverse all elements in a set, use a foreach 
loop. We now conduct an interesting experiment to test the performance of sets and lists. 
Listing 21.6 gives a program that shows the execution time of (1) testing whether an element 
Key
Point
```

</details>


## PDF page 830

<details>
<summary>Page text</summary>

```text
21.3 Comparing the Performance of Sets and Lists  807
is in a hash set, linked hash set, tree set, array list, and linked list, and (2) removing elements 
from a hash set, linked hash set, tree set, array list, and linked list.
LISTING 21.6 SetListPerformanceTest.java
 1 import java.util.*;
 2
 3 public class SetListPerformanceTest {
 4 static final int N = 50000;
 5
 6 public static void main(String[] args) {
 7 // Add numbers 0, 1, 2, ..., N - 1 to the array list
 8 List<Integer> list = new ArrayList<>();
 9 for (int i = 0; i < N; i++)
10 list.add(i);
11      Collections.shuffle(list); // Shuffle the array list
12
13 // Create a hash set, and test its performance
14 Collection<Integer> set1 = new HashSet<>(list);
15      System.out.println("Member test time for hash set is " +
16        getTestTime(set1) + " milliseconds");
17      System.out.println("Remove element time for hash set is " +
18        getRemoveTime(set1) + " milliseconds");
19
20 // Create a linked hash set, and test its performance
21 Collection<Integer> set2 = new LinkedHashSet<>(list);
22      System.out.println("Member test time for linked hash set is " +
23        getTestTime(set2) + " milliseconds");
24      System.out.println("Remove element time for linked hash set is "
25        + getRemoveTime(set2) + " milliseconds");
26
27 // Create a tree set, and test its performance
28 Collection<Integer> set3 = new TreeSet<>(list);
29      System.out.println("Member test time for tree set is " +
30        getTestTime(set3) + " milliseconds");
31      System.out.println("Remove element time for tree set is " +
32        getRemoveTime(set3) + " milliseconds");
33
34 // Create an array list, and test its performance
35 Collection<Integer> list1 = new ArrayList<>(list);
36      System.out.println("Member test time for array list is " +
37        getTestTime(list1) + " milliseconds");
38      System.out.println("Remove element time for array list is " +
39        getRemoveTime(list1) + " milliseconds");
40
41 // Create a linked list, and test its performance
42 Collection<Integer> list2 = new LinkedList<>(list);
43      System.out.println("Member test time for linked list is " +
44        getTestTime(list2) + " milliseconds");
45      System.out.println("Remove element time for linked list is " +
46        getRemoveTime(list2) + " milliseconds");
47    }
48
49 public static long getTestTime(Collection<Integer> c) {
50 long startTime = System.currentTimeMillis();
51
52 // Test if a number is in the collection
53 for (int i = 0; i < N; i++)
54 c.contains(( int)(Math.random() * 2 * N));
55
56 return System.currentTimeMillis() - startTime; 
create test data
shuffle
a hash set
a linked hash set
a tree set
an array list
a linked list
start time
test membership
return execution time
```

</details>


## PDF page 831

<details>
<summary>Page text</summary>

```text
808 Chapter 21  Sets and Maps
57    }
58
59 public static long getRemoveTime(Collection<Integer> c) {
60 long startTime = System.currentTimeMillis();
61
62 for (int i = 0; i < N; i++)
63 c.remove(i);
64
65 return System.currentTimeMillis() - startTime; 
66    }
67  }
remove from container
return execution time
Member test time for hash set is 20 milliseconds
Remove element time for hash set is 27 milliseconds
Member test time for linked hash set is 27 milliseconds
Remove element time for linked hash set is 26 milliseconds
Member test time for tree set is 47 milliseconds
Remove element time for tree set is 34 milliseconds
Member test time for array list is 39802 milliseconds
Remove element time for array list is 16196 milliseconds
Member test time for linked list is 52197 milliseconds
Remove element time for linked list is 14870 milliseconds
The program creates a list for numbers from 0 to N-1 (for N = 50000) (lines 8–10) and shuf-
fles the list (line 11). From this list, the program creates a hash set (line 14), a linked hash set 
(line 21), a tree set (line 28), an array list (line 35), and a linked list (line 42). The program 
obtains the execution time for testing whether a number is in the hash set (line 16), linked hash 
set (line 23), tree set (line 30), array list (line 37), and linked list (line 44), and obtains the 
execution time for removing the elements from the hash set (line 18), linked hash set (line 25), 
tree set (line 32), array list (line 39), and linked list (line 46).
The getTestTime method invokes the contains method to test whether a number is 
in the container (line 54) and the getRemoveTime method invokes the remove method to 
remove an element from the container (line 63).
As these runtimes illustrate, sets are much more efficient than lists for testing whether 
an element is in a set or a list. Therefore, the No-Fly list should be implemented using a set 
instead of a list, because it is much faster to test whether an element is in a set than in a list.
You may wonder why sets are more efficient than lists. The questions will be answered in 
Chapters 24 and 27 when we introduce the implementations of lists and sets.
21.10 Suppose you need to write a program that stores unordered non-duplicate elements, 
what data structure should you use?
21.11 Suppose you need to write a program that stores non-duplicate elements in the order 
of insertion, what data structure should you use?
21.12 Suppose you need to write a program that stores non-duplicate elements in increasing 
order of the element values, what data structure should you use?
21.13 Suppose you need to write a program that stores a fixed number of the elements (pos-
sibly duplicates), what data structure should you use?
21.14 Suppose you need to write a program that stores the elements in a list with frequent opera-
tions to add and insert elements at the end of the list, what data structure should you use?
21.15 Suppose you need to write a program that stores the elements in a list with frequent 
operations to add and insert elements at the beginning of the list, what data structure 
should you use?
sets are better
✓Point✓
Check
```

</details>


## PDF page 832

<details>
<summary>Page text</summary>

```text
21.4 Case Study: Counting Keywords  809
21.4 Case Study: Counting Keywords
This section presents an application that counts the number of the keywords in a Java 
source file.
For each word in a Java source file, we need to determine whether the word is a keyword. To 
handle this efficiently, store all the keywords in a HashSet and use the contains method to 
test if a word is in the keyword set. Listing 21.7 gives this program.
LISTING 21.7 CountKeywords.java
 1 import java.util.*;
 2 import java.io.*;
 3
 4 public class CountKeywords {
 5 public static void main(String[] args) throws Exception {
 6      Scanner input = new Scanner(System.in);
 7      System.out.print("Enter a Java source file: ");
 8      String filename = input.nextLine();
 9
10      File file = new File(filename);
11 if (file.exists()) {
12        System.out.println("The number of keywords in " + filename 
13          + " is " + countKeywords(file));
14      }
15 else {
16        System.out.println("File " + filename + " does not exist");
17      }
18    }
19
20 public static int countKeywords(File file) throws Exception {
21 // Array of all Java keywords + true, false and null
22      String[] keywordString = {"abstract", "assert", "boolean",
23 "break", "byte", "case", "catch", "char", "class", "const",
24 "continue", "default", "do", "double", "else", "enum",
25 "extends", "for", "final", "finally", "float", "goto",
26 "if", "implements", "import", "instanceof", "int",
27 "interface", "long", "native", "new", "package", "private",
28 "protected", "public", "return", "short", "static",
29 "strictfp", "super", "switch", "synchronized", "this",
30 "throw", "throws", "transient", "try", "void", "volatile",
31 "while", "true", "false", "null"};
32
33      Set<String> keywordSet = 
34 new HashSet<>(Arrays.asList(keywordString));
35 int count = 0;
36
37      Scanner input = new Scanner(file);
38
39 while (input.hasNext()) {
40        String word = input.next();
41 if (keywordSet.contains(word))
42          count++;
43      }
44
45 return count;
46    }
47  }
Key
Point
enter a filename
file exists?
count keywords
keywords
keyword set
is a keyword?
```

</details>


## PDF page 833

<details>
<summary>Page text</summary>

```text
810 Chapter 21  Sets and Maps
FIGURE 21.2 The entries consisting of key/value pairs are stored in a map.
Corresponding
element value
Entry
Search key
A map
Corresponding
value
Entry
Search key
(b)(a)
111-34-3434 John
132-56-6290 Peter
Enter a Java source file: c:\TTT.java
File c:\TTT.java does not exist 
Enter a Java source file: c:\Welcome.java
The number of keywords in c:\Welcome.java is 5 
The program prompts the user to enter a Java source filename (line 7) and reads the filename 
(line 8). If the file exists, the countKeywords method is invoked to count the keywords in 
the file (line 13).
The countKeywords method creates an array of strings for the keywords (lines 22–31) 
and creates a hash set from this array (lines 33–34). It then reads each word from the file and 
tests if the word is in the set (line 41). If so, the program increases the count by 1 (line 42).
You may rewrite the program to use a LinkedHashSet, TreeSet, ArrayList, or 
LinkedList to store the keywords. However, using a HashSet is the most efficient for this 
program.
21.16 Will the CountKeywords program work if lines 33–34 are changed to
Set<String> keywordSet = 
new LinkedHashSet<>(Arrays.asList(keywordString));
21.17 Will the CountKeywords program work if lines 33–34 are changed to
List<String> keywordSet = 
new ArrayList<>(Arrays.asList(keywordString));
21.5 Maps
You can create a map using one of its three concrete classes: HashMap,
LinkedHashMap, or TreeMap.
A map is a container object that stores a collection of key/value pairs. It enables fast retrieval, 
deletion, and updating of the pair through the key. A map stores the values along with the keys. 
The keys are like indexes. In List, the indexes are integers. In Map, the keys can be any objects. 
A map cannot contain duplicate keys. Each key maps to one value. A key and its correspond-
ing value form an entry stored in a map, as shown in Figure 21.2a. Figure 21.2b shows a map 
in which each entry consists of a Social Security number as the key and a name as the value.
✓Point✓
Check
Key
Point
map
```

</details>


## PDF page 834

<details>
<summary>Page text</summary>

```text
21.5 Maps 811
There are three types of maps: HashMap, LinkedHashMap, and TreeMap. The com-
mon features of these maps are defined in the Map interface. Their relationship is shown in 
Figure 21.3.
FIGURE 21.3 A map stores key/value pairs.
SortedMap
HashMap LinkedHashMap
TreeMap
Interfaces Abstract Classes Concrete Classes
Map
NavigableMap
AbstractMap
FIGURE 21.4 TheMap interface maps keys to values.
+clear(): void Removes all entries from this map.
+containsKey(key: Object): boolean
+containsValue(value: Object): boolean
+isEmpty(): boolean
+keySet(): Set<K>
+put(key: K, value: V): V
+putAll(m: Map<? extends K,? extends
 V>): void
+get(key: Object): V
+entrySet(): Set<Map.Entry<K,V>>
Returns true if this map contains an entry for the
     specified key.
Returns true if this map maps one or more keys to the
     specified value.
Returns a set consisting of the entries in this map.
Returns the value for the specified key in this map.
Returns true if this map contains no entries.
Returns a set consisting of the keys in this map.
Puts an entry into this map.
Removes the entries for the specified key.
Returns the number of entries in this map.
Returns a collection consisting of the values in this map.
Adds all the entries from m to this map.
+remove(key: Object): V
+size(): int
+values(): Collection<V>
«interface»
java.util.Map<K,V>
TheMap interface provides the methods for querying, updating, and obtaining a collection 
of values and a set of keys, as shown in Figure 21.4.
The update methods include clear, put, putAll, and remove. The clear() method 
removes all entries from the map. The put(K key, V value) method adds an entry for the 
specified key and value in the map. If the map formerly contained an entry for this key, the 
old value is replaced by the new value and the old value associated with the key is returned. 
TheputAll(Map m) method adds all entries in m to this map. The remove(Object key)
method removes the entry for the specified key from the map.
The query methods include containsKey, containsValue, isEmpty, and size. The 
containsKey(Object key)  method checks whether the map contains an entry for the 
specified key. The containsValue(Object value) method checks whether the map con-
tains an entry for this value. The isEmpty() method checks whether the map contains any 
entries. The size() method returns the number of entries in the map.
update methods
query methods
```

</details>


## PDF page 835

<details>
<summary>Page text</summary>

```text
812 Chapter 21  Sets and Maps
You can obtain a set of the keys in the map using the keySet() method, and a collection 
of the values in the map using the values() method. The entrySet() method returns a set 
of entries. The entries are instances of the Map.Entry<K, V> interface, where Entry is an 
inner interface for the Map interface, as shown in Figure 21.5. Each entry in the set is a key/
value pair in the underlying map.
keySet()
values()
entrySet()
FIGURE 21.5 TheMap.Entry interface operates on an entry in the map.
+getKey(): K
+getValue(): V
+setValue(value: V): void
Returns the key from this entry.
Returns the value from this entry.
Replaces the value in this entry with a new value.
«interface»
java.util.Map.Entry<K,V>
FIGURE 21.6 The Java Collections Framework provides three concrete map classes.
java.util.AbstractMap<K,V>
java.util.HashMap<K,V>
java.util.LinkedHashMap<K,V>
+LinkedHashMap()
+LinkedHashMap(m: Map<? extends K,? extends V>)
+LinkedHashMap(initialCapacity: int,
loadFactor: float, accessOrder: boolean)
java.util.TreeMap<K,V>
+TreeMap()
+TreeMap(m: Map<? extends K,? extends V>)
+TreeMap(c: Comparator<? super K>)
«interface»
java.util.SortedMap<K,V>
+firstKey(): K
+lastKey(): K
+comparator(): Comparator<? super K>)
+headMap(toKey: K): SortedMap<K,V>
+tailMap(fromKey: K): SortedMap<K,V>
«interface»
java.util.Map<K, V>
«interface»
java.util.NavigableMap<K, V>
+floorKey(key: K): K
+ceilingKey(key: K): K
+lowerKey(key: K): K
+higherKey(key: K): K
+pollFirstEntry(): Map.EntrySet<K, V>
+pollLastEntry(): Map.EntrySet<K, V>
+HashMap()
+HashMap(m: Map<? extends K, ? extends V>)
+HashMap(initialCapacity: int,loadFactor: float)
TheAbstractMap class is a convenience abstract class that implements all the methods in 
theMap interface except the entrySet() method.
TheHashMap,LinkedHashMap, and TreeMap classes are three concrete implementations
of the Map interface, as shown in Figure 21.6.
AbstractMap
concrete implementations
```

</details>


## PDF page 836

<details>
<summary>Page text</summary>

```text
21.5 Maps 813
TheHashMap class is efficient for locating a value, inserting an entry, and deleting an entry.
LinkedHashMap extends HashMap with a linked-list implementation that supports an 
ordering of the entries in the map. The entries in a HashMap are not ordered, but the entries 
in a LinkedHashMap can be retrieved either in the order in which they were inserted into the 
map (known as the insertion order) or in the order in which they were last accessed, from 
least recently to most recently accessed ( access order). The no-arg constructor constructs a 
LinkedHashMap with the insertion order. To construct a LinkedHashMap with the access 
order, use LinkedHashMap(initialCapacity, loadFactor, true).
The TreeMap class is efficient for traversing the keys in a sorted order. The keys can 
be sorted using the Comparable interface or the Comparator interface. If you create a 
TreeMap using its no-arg constructor, the compareTo method in the Comparable interface 
is used to compare the keys in the map, assuming that the class for the keys implements the 
Comparable interface. To use a comparator, you have to use the TreeMap(Comparator
comparator) constructor to create a sorted map that uses the compare method in the com-
parator to order the entries in the map based on the keys.
SortedMap is a subinterface of Map, which guarantees that the entries in the map are 
sorted. Additionally, it provides the methods firstKey() and lastKey() for returning the 
first and last keys in the map, and headMap(toKey) and tailMap(fromKey) for returning 
a portion of the map whose keys are less than toKey and greater than or equal to fromKey,
respectively.
NavigableMap extends SortedMap to provide the navigation methods lowerKey(key),
floorKey(key),ceilingKey(key), and higherKey(key) that return keys respectively 
less than, less than or equal, greater than or equal, and greater than a given key and return 
null if there is no such key. The pollFirstEntry() and pollLastEntry() methods 
remove and return the first and last entry in the tree map, respectively.
Note
Prior to Java 2, java.util.Hashtable was used for mapping keys with values. 
Hashtable was redesigned to fit into the Java Collections Framework with all its methods 
retained for compatibility. Hashtable implements the Map interface and is used in the 
same way as HashMap, except that the update methods in Hashtable are synchronized.
Listing 21.8 gives an example that creates a hash map, a linked hash map, and a tree map for 
mapping students to ages. The program first creates a hash map with the student’s name as 
its key and the age as its value. The program then creates a tree map from the hash map and 
displays the entries in ascending order of the keys. Finally, the program creates a linked hash 
map, adds the same entries to the map, and displays the entries.
LISTING 21.8 TestMap.java
 1 import java.util.*;
 2
 3 public class TestMap {
 4 public static void main(String[] args) {
 5 // Create a HashMap
 6 Map<String, Integer> hashMap = new HashMap<>();
 7 hashMap.put( "Smith", 30);
 8      hashMap.put("Anderson", 31);
 9      hashMap.put("Lewis", 29);
10      hashMap.put("Cook", 29);
11
12      System.out.println("Display entries in HashMap");
13      System.out.println(hashMap + "\n");
14
15 // Create a TreeMap from the preceding HashMap
16 Map<String, Integer> treeMap =
HashMap
LinkedHashMap
insertion order
access order
TreeMap
SortedMap
NavigableMap
Hashtable
hash map
linked hash map
tree map
create map
add entry
tree map
```

</details>


## PDF page 837

<details>
<summary>Page text</summary>

```text
814 Chapter 21  Sets and Maps
17 new TreeMap<>(hashMap);
18      System.out.println("Display entries in ascending order of key");
19      System.out.println(treeMap);
20
21 // Create a LinkedHashMap
22 Map<String, Integer> linkedHashMap =
23 new LinkedHashMap<>(16, 0.75f, true);
24      linkedHashMap.put("Smith", 30);
25      linkedHashMap.put("Anderson", 31);
26      linkedHashMap.put("Lewis", 29);
27      linkedHashMap.put("Cook", 29);
28
29 // Display the age for Lewis
30      System.out.println("\nThe age for " + "Lewis is " +
31        linkedHashMap.get("Lewis"));
32
33      System.out.println("Display entries in LinkedHashMap");
34      System.out.println(linkedHashMap);
35    }
36  }
linked hash map
Display entries in HashMap
{Cook=29, Smith=30, Lewis=29, Anderson=31}
Display entries in ascending order of key
{Anderson=31, Cook=29, Lewis=29, Smith=30}
The age for Lewis is 29
Display entries in LinkedHashMap
{Smith=30, Anderson=31, Cook=29, Lewis=29} 
As shown in the output, the entries in the HashMap are in random order. The entries in the 
TreeMap are in increasing order of the keys. The entries in the LinkedHashMap are in the 
order of their access, from least recently accessed to most recently.
All the concrete classes that implement the Map interface have at least two constructors. 
One is the no-arg constructor that constructs an empty map, and the other constructs a map 
from an instance of Map. Thus, new TreeMap<String, Integer>(hashMap) (lines 16–17) 
constructs a tree map from a hash map.
You can create an insertion-ordered or access-ordered linked hash map. An access-ordered 
linked hash map is created in lines 22–21. The most recently accessed entry is placed at the 
end of the map. The entry with the key Lewis is last accessed in line 31, so it is displayed last 
in line 34.
Tip
If you don’t need to maintain an order in a map when updating it, use a HashMap.
When you need to maintain the insertion order or access order in the map, use a 
LinkedHashMap. When you need the map to be sorted on keys, use a TreeMap.
21.18 How do you create an instance of Map? How do you add an entry to a map consisting 
of a key and a value? How do you remove an entry from a map? How do you find the 
size of a map? How do you traverse entries in a map?
21.19 Describe and compare HashMap,LinkedHashMap, and TreeMap.
✓Point✓
Check
```

</details>


## PDF page 838

<details>
<summary>Page text</summary>

```text
21.6 Case Study: Occurrences of Words  815
21.20 Show the output of the following code:
public class Test {
public static void main(String[] args) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("123", "John Smith");
    map.put("111", "George Smith");
    map.put("123", "Steve Yao");
    map.put("222", "Steve Yao");
    System.out.println("(1) " + map);
    System.out.println("(2) " + new TreeMap<String, String>(map));
  }
}
21.6 Case Study: Occurrences of Words
This case study writes a program that counts the occurrences of words in a text and 
displays the words and their occurrences in alphabetical order of the words.
The program uses a TreeMap  to store an entry consisting of a word and its count. For 
each word, check whether it is already a key in the map. If not, add an entry to the map 
with the word as the key and value 1. Otherwise, increase the value for the word (key) 
by 1 in the map. Assume the words are case insensitive; e.g., Good is treated the same 
as good.
Listing 21.9 gives the solution to the problem.
LISTING 21.9 CountOccurrenceOfWords.java
 1 import java.util.*;
 2
 3 public class CountOccurrenceOfWords {
 4 public static void main(String[] args) {
 5 // Set text in a string
 6      String text = "Good morning. Have a good class. " +
 7 "Have a good visit. Have fun!";
 8
 9 // Create a TreeMap to hold words as key and count as value
10 Map<String, Integer> map = new TreeMap<>();
11
12      String[] words = text.split("[ \n\t\r.,;:!?(){");
13 for (int i = 0; i < words.length; i++) {
14 String key = words[i].toLowerCase();
15
16 if (key.length() > 0) {
17 if (!map.containsKey(key)) {
18 map.put(key, 1);
19          }
20 else {
21 int value = map.get(key);
22            value++;
23 map.put(key, value);
24          }
25        }
26      }
27
28 // Get all entries into a set
29 Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
30
Key
Point
tree map
split string
add entry
update entry
entry set
```

</details>


## PDF page 839

<details>
<summary>Page text</summary>

```text
816 Chapter 21  Sets and Maps
31 // Get key and value from each entry
32 for (Map.Entry<String, Integer> entry: entrySet)
33        System.out.println(entry.getValue() + "\t" + entry.getKey());
34    }
35  }
display entry
a              2
class          1
fun            1
good           3
have           3
morning        1
visit          1 
The program creates a TreeMap (line 10) to store pairs of words and their occurrence counts. 
The words serve as the keys. Since all values in the map must be stored as objects, the count 
is wrapped in an Integer object.
The program extracts a word from a text using the split method (line 12) in the String
class (see Section 10.10.4). For each word extracted, the program checks whether it is already 
stored as a key in the map (line 17). If not, a new pair consisting of the word and its initial 
count (1) is stored in the map (line 18). Otherwise, the count for the word is incremented by 
1 (lines 21–23).
The program obtains the entries of the map in a set (line 29), and traverses the set to display 
the count and the key in each entry (lines 32–33).
Since the map is a tree map, the entries are displayed in increasing order of words. To 
display them in ascending order of the occurrence counts, see Programming Exercise 21.8.
Now sit back and think how you would write this program without using map. Your new 
program would be longer and more complex. You will find that map is a very efficient and 
powerful data structure for solving problems such as this.
21.21 Will the CountOccurrenceOfWords program work if line 10 is changed to
Map<String, int> map = new TreeMap<>();
21.22 Will the CountOccurrenceOfWords program work if line 17 is changed to
if (map.get(key) == null) {
21.23 Will the CountOccurrenceOfWords program work if lines 32–33 are changed to
for (String key: map)
  System.out.println(key + "\t" + map.getValue(key));
21.7 Singleton and Unmodifiable Collections and Maps
You can create singleton sets, lists, and maps and unmodifiable sets, lists, and maps 
using the static methods in the Collections class.
TheCollections class contains the static methods for lists and collections. It also contains 
the methods for creating immutable singleton sets, lists, and maps, and for creating read-only 
sets, lists, and maps, as shown in Figure 21.7.
The Collections class defines three constants— EMPTY_SET, EMPTY_LIST, and 
EMPTY_MAP—for an empty set, an empty list, and an empty map. These collections are immu-
table. The class also provides the singleton(Object o) method for creating an immutable 
set containing only a single item, the singletonList(Object o)  method for creating 
✓Point✓
Check
Key
Point
```

</details>


## PDF page 840

<details>
<summary>Page text</summary>

```text
Chapter Summary  817
an immutable list containing only a single item, and the singletonMap(Object key, 
Object value) method for creating an immutable map containing only a single entry.
TheCollections class also provides six static methods for returning read-only views for
collections: unmodifiableCollection(Collection c) , unmodifiableList(List
list), unmodifiableMap(Map m) , unmodifiableSet(Set set) ,
unmodifiableSortedMap(SortedMap m) , and unmodifiableSortedSet(Sorted
Set s). This type of view is like a reference to the actual collection. But you cannot modify 
the collection through a read-only view. Attempting to modify a collection through a read-
only view will cause an UnsupportedOperationException.
21.24 What is wrong in the following code?
Set<String> set = Collections.singleton("Chicago");
set.add("Dallas");
21.25 What happens when you run the following code?
List list = Collections.unmodifiableList(Arrays.asList("Chicago",
"Boston"));
list.remove("Dallas");
read-only view
✓Point✓
Check
FIGURE 21.7 TheCollections class contains the static methods for creating singleton and read-only sets, lists, and maps.
java.util.Collections
+singleton(o: Object): Set
+singletonList(o: Object): List
+singletonMap(key: Object, value: Object): Map
+unmodifiableCollection(c: Collection): Collection
+unmodifiableList(list: List): List
+unmodifiableMap(m: Map): Map
+unmodifiableSet(s: Set): Set
+unmodifiableSortedMap(s: SortedMap): SortedMap
+unmodifiableSortedSet(s: SortedSet): SortedSet
Returns an immutable set containing the specified object.
Returns an immutable list containing the specified object.
Returns an immutable map with the key and value pair.
Returns a read-only view of the collection.
Returns a read-only view of the list.
Returns a read-only view of the map.
Returns a read-only view of the set.
Returns a read-only view of the sorted map.
Returns a read-only view of the sorted set.
KEY TERMS
hash map 813
hash set 798
linked hash map 813
linked hash set 802
map 810
set 798
read-only view 817
tree map 813
tree set 803
CHAPTER SUMMARY
1. A set stores nonduplicate elements. To allow duplicate elements to be stored in a collec-
tion, you need to use a list.
2. A map stores key/value pairs. It provides a quick lookup for a value using a key.
3. Three types of sets are supported: HashSet,LinkedHashSet, and TreeSet.HashSet
stores elements in an unpredictable order. LinkedHashSet stores elements in the order
```

</details>


## PDF page 841

<details>
<summary>Page text</summary>

```text
818 Chapter 21  Sets and Maps
they were inserted. TreeSet stores elements sorted. All the methods in HashSet,
LinkedHashSet, and TreeSet are inherited from the Collection interface.
4. The Map interface maps keys to the elements. The keys are like indexes. In List,
the indexes are integers. In Map, the keys can be any objects. A map cannot contain 
duplicate keys. Each key can map to at most one value. The Map interface provides 
the methods for querying, updating, and obtaining a collection of values and a set 
of keys.
5. Three types of maps are supported: HashMap, LinkedHashMap , and TreeMap.
HashMap is efficient for locating a value, inserting an entry, and deleting an entry. 
LinkedHashMap  supports ordering of the entries in the map. The entries in a Hash-
Map are not ordered, but the entries in a LinkedHashMap  can be retrieved either in 
the order in which they were inserted into the map (known as the insertion order )
or in the order in which they were last accessed, from least recently accessed to 
most recently ( access order ).TreeMap is efficient for traversing the keys in a sorted 
order. The keys can be sorted using the Comparable  interface or the Comparator
interface.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
Sections 21.2–21.4
21.1 (Perform set operations on hash sets ) Create two linked hash sets {"George",
"Jim","John","Blake","Kevin","Michael"} and {"George","Katie",
"Kevin","Michelle","Ryan"} and find their union, difference, and intersec-
tion. (You can clone the sets to preserve the original sets from being changed by 
these set methods.)
21.2 (Display nonduplicate words in ascending order ) Write a program that reads 
words from a text file and displays all the nonduplicate words in ascending order. 
The text file is passed as a command-line argument.
**21.3 (Count the keywords in Java source code) Revise the program in Listing 21.7. If 
a keyword is in a comment or in a string, don’t count it. Pass the Java file name 
from the command line. Assume that the Java source code is correct and line 
comments and paragraph comments do not overlap.
*21.4 (Count consonants and vowels) Write a program that prompts the user to enter a 
text file name and displays the number of vowels and consonants in the file. Use 
a set to store the vowels A,E,I,O, and U.
***21.5 (Syntax highlighting) Write a program that converts a Java file into an HTML 
file. In the HTML file, the keywords, comments, and literals are displayed in 
bold navy, green, and blue, respectively. Use the command line to pass a Java file 
and an HTML file. For example, the following command
  java Exercise21_05 Welcome.java Welcome.html
  converts Welcome.java into Welcome.html. Figure 21.8a shows a Java file. The 
corresponding HTML file is shown in Figure 21.8b.
```

</details>


## PDF page 842

<details>
<summary>Page text</summary>

```text
Programming Exercises  819
Sections 21.5–21.7
*21.6 (Count the occurrences of numbers entered ) Write a program that reads an 
unspecified number of integers and finds the one that has the most occurrences. 
The input ends when the input is 0. For example, if you entered 2340354–3
3320 , the number 3 occurred most often. If not one but several numbers have 
the most occurrences, all of them should be reported. For example, since 9 and 3
appear twice in the list 93039324 , both occurrences should be reported.
**21.7 (Revise Listing 21.9, CountOccurrenceOfWords.java ) Rewrite Listing 21.9 to 
display the words in ascending order of occurrence counts.
  ( Hint: Create a class named WordOccurrence that implements the Comparable
interface. The class contains two fields, word and count. The compareTo
method compares the counts. For each pair in the hash set in Listing 21.9, create 
an instance of WordOccurrence and store it in an array list. Sort the array list 
using the Collections.sort method. What would be wrong if you stored the 
instances of WordOccurrence in a tree set?)
**21.8 (Count the occurrences of words in a text file ) Rewrite Listing 21.9 to read the 
text from a text file. The text file is passed as a command-line argument. Words 
are delimited by whitespace characters, punctuation marks ( ,;.:?), quotation 
marks ('"), and parentheses. Count words in case-insensitive fashion (e.g., con-
sider Good and good to be the same word). The words must start with a letter. 
Display the output in alphabetical order of words, with each word preceded by 
its occurrence count.
**21.9 (Guess the capitals using maps ) Rewrite Programming Exercise 8.37 to store 
pairs of each state and its capital in a map. Your program should prompt the user 
to enter a state and should display the capital for the state.
*21.10 (Count the occurrences of each keyword) Rewrite Listing 21.7 CountKeywords.
java to read in a Java source code file and count the occurrence of each keyword 
in the file, but don’t count the keyword if it is in a comment or in a string literal.
**21.11 (Baby name popularity ranking ) Use the data files from Programming 
Exercise 12.31 to write a program that enables the user to select a year, gender, 
and enter a name to display the ranking of the name for the selected year and 
gender, as shown in Figure 21.9. To achieve the best efficiency, create two arrays 
for boy’s names and girl’s names, respectively. Each array has 10 elements for 
10 years. Each element is a map that stores a name and its ranking in a pair 
with the name as the key. Assume the data files are stored at www.cs.armstrong
.edu/liang/data/babynamesranking2001.txt, . . . , and www.cs.armstrong.edu/liang/data/
babynamesranking2010.txt.
FIGURE 21.8 The Java code in plain text in (a) is displayed in HTML with syntax highlighted in (b).
(a) (b)
```

</details>


## PDF page 843

<details>
<summary>Page text</summary>

```text
820 Chapter 21  Sets and Maps
**21.12 (Name for both genders) Write a program that prompts the user to enter one of 
the filenames described in Programming Exercise 12.31 and displays the names 
that are used for both genders in the file. Use sets to store names and find com-
mon names in two sets. Here is a sample run:
FIGURE 21.9 The user selects a year and gender, enters a year, and clicks the Find Ranking button to display the ranking.
Enter a file name for baby name ranking: babynamesranking2001.txt
69 names used for both genders 
They are Tyler Ryan Christian ...
**21.13 (Baby name popularity ranking) Revise Programming Exercise 21.11 to prompt 
the user to enter year, gender, and name and display the ranking for the name. 
Prompt the user to enter another inquiry or exit the program. Here is a sample 
run:
**21.14 (Web crawler) Rewrite Listing 12.18, WebCrawler.java, to improve the perfor-
mance by using appropriate new data structures for listOfPendingURLs and 
listofTraversedURLs.
**21.15 (Addition quiz) Rewrite Programming Exercise 11.16 to store the answers in a 
set rather than a list. 
Enter the year: 2010
Enter the gender: M
Enter the name: Javier
Boy name Javier is ranked #190 in year 2010
Enter another inquiry? Y
Enter the year: 2001
Enter the gender: F
Enter the name: Emily
Girl name Emily is ranked #1 in year 2001
Enter another inquiry? N
```

</details>
