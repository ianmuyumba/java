# Chapter 27 Hashing

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1008

<details>
<summary>Page text</summary>

```text
HASHING
Objectives
■ To understand what hashing is and what hashing is used for (§27.2).
■ To obtain the hash code for an object and design the hash function to 
map a key to an index (§27.3).
■ To handle collisions using open addressing (§27.4).
■ To know the differences among linear probing, quadratic probing, and 
double hashing (§27.4).
■ To handle collisions using separate chaining (§27.5).
■ To understand the load factor and the need for rehashing (§27.6).
■ To implement MyHashMap using hashing (§27.7).
■ To implement MyHashSet using hashing (§27.8).
CHAPTER
27
```

</details>


## PDF page 1009

<details>
<summary>Page text</summary>

```text
986 Chapter 27 Hashing
27.1 Introduction
Hashing is superefficient. It takes O(1) time to search, insert, and delete an element 
using hashing.
The preceding chapter introduced binary search trees. An element can be found in O(log n)
time in a well-balanced search tree. Is there a more efficient way to search for an element in a 
container? This chapter introduces a technique called hashing. You can use hashing to imple-
ment a map or a set to search, insert, and delete an element in O(1) time.
27.2 What Is Hashing?
Hashing uses a hashing function to map a key to an index.
Before introducing hashing, let us review map, which is a data structure that is implemented 
using hashing. Recall that a map (introduced in Section 21.5) is a container object that stores 
entries. Each entry contains two parts: a key and a value. The key, also called a search key, is 
used to search for the corresponding value. For example, a dictionary can be stored in a map, 
in which the words are the keys and the definitions of the words are the values.
Note
A map is also called a dictionary, a hash table, or an associative array.
The Java Collections Framework defines the java.util.Map interface for modeling maps. 
Three concrete implementations are java.util.HashMap,java.util.LinkedHashMap,
and java.util.TreeMap. java.util.HashMap is implemented using hashing, java.
util.LinkedHashMap using LinkedList, and java.util.TreeMap using red-black 
trees. (Bonus Chapter 41 introduces red-black trees.) You will learn the concept of hashing 
and use it to implement a hash map in this chapter.
If you know the index of an element in the array, you can retrieve the element using the 
index in O(1) time. So does that mean we can store the values in an array and use the key as 
the index to find the value? The answer is yes—if you can map a key to an index. The array 
that stores the values is called a hash table. The function that maps a key to an index in the 
hash table is called a hash function. As shown in Figure 27.1, a hash function obtains an index 
from a key and uses the index to retrieve the value for the key. Hashing is a technique that 
retrieves the value using the index obtained from the key without performing a search.
Key
Point
why hashing?
Key
Point
map
key
value
dictionary
hash table
associative array
hash table
hash function
hashing
FIGURE 27.1  A hash function maps a key to an index in the hash table.
Hash function
i = hash(key) 
0
1
2
i
N – 1
key value
An entry
.
.
.
.
.
How do you design a hash function that produces an index from a key? Ideally, we would 
like to design a function that maps each search key to a different index in the hash table. Such 
a function is called a perfect hash function . However, it is difficult to find a perfect hash perfect hash function
```

</details>


## PDF page 1010

<details>
<summary>Page text</summary>

```text
27.3 Hash Functions and Hash Codes  987
function. When two or more keys are mapped to the same hash value, we say that a collision
has occurred. Although there are ways to deal with collisions, which are discussed later in this 
chapter, it is better to avoid collisions in the first place. Thus, you should design a fast and 
easy-to-compute hash function that minimizes collisions.
27.1 What is a hash function? What is a perfect hash function? What is a collision?
27.3 Hash Functions and Hash Codes
A typical hash function first converts a search key to an integer value called a hash 
code, then compresses the hash code into an index to the hash table.
Java’s root class Object has the hashCode method, which returns an integer hash code. By 
default, the method returns the memory address for the object. The general contract for the 
hashCode method is as follows:
1. You should override the hashCode method whenever the equals method is overridden 
to ensure that two equal objects return the same hash code.
2. During the execution of a program, invoking the hashCode method multiple times 
returns the same integer, provided that the object’s data are not changed.
3. Two unequal objects may have the same hash code, but you should implement the 
hashCode method to avoid too many such cases.
27.3.1 Hash Codes for Primitive Types
For search keys of the type byte,short,int, and char, simply cast them to int. Therefore, 
two different search keys of any one of these types will have different hash codes.
For a search key of the type float, use Float.floatToIntBits(key) as the hash 
code. Note that floatToIntBits(float f) returns an int value whose bit representation 
is the same as the bit representation for the floating number f. Thus, two different search keys 
of the float type will have different hash codes.
For a search key of the type long, simply casting it to int would not be a good choice, 
because all keys that differ in only the first 32 bits will have the same hash code. To take the 
first 32 bits into consideration, divide the 64 bits into two halves and perform the exclusive-
or operation to combine the two halves. This process is called folding. The hash code for a 
long key is
int hashCode = (int)(key ^ (key >> 32));
Note that >> is the right-shift operator that shifts the bits 32 positions to the right. For exam-
ple,1010110 >> 2  yields 0010101. The ^ is the bitwise exclusive-or operator. It operates 
on two corresponding bits of the binary operands. For example, 1010110 ^ 0110111 yields 
1100001. For more on bitwise operations, see Appendix G, Bitwise Operations.
For a search key of the type double, first convert it to a long value using the 
Double.doubleToLongBits method, and then perform a folding as follows:
long bits = Double.doubleToLongBits(key);
int hashCode = (int)(bits ^ (bits >> 32));
27.3.2 Hash Codes for Strings
Search keys are often strings, so it is important to design a good hash function for strings. An 
intuitive approach is to sum the Unicode of all characters as the hash code for the string. This 
approach may work if two search keys in an application don’t contain the same letters, but 
collision
✓Point✓
Check
Key
Point
hash code
hashCode()
byte, short, int, char
float
long
folding
double
folding
```

</details>


## PDF page 1011

<details>
<summary>Page text</summary>

```text
988 Chapter 27 Hashing
it will produce a lot of collisions if the search keys contain the same letters, such as tod and 
dot.
A better approach is to generate a hash code that takes the position of characters into con-
sideration. Specifically, let the hash code be
s0*b(n - 1) + s1*b(n - 2) + c + sn-1
where si is s.charAt(i). This expression is a polynomial for some positive b, so this is called 
a polynomial hash code. Using Horner’s rule for polynomial evaluation (see Section 6.7), the 
hash code can be calculated efficiently as follows:
(c((s0*b + s1)b + s2)b + c + sn-2)b + sn-1
This computation can cause an overflow for long strings, but arithmetic overflow is ignored 
in Java. You should choose an appropriate value b to minimize collisions. Experiments show 
that good choices for b are 31, 33, 37, 39, and 41. In the String class, the hashCode is over-
ridden using the polynomial hash code with b being 31.
27.3.3 Compressing Hash Codes
The hash code for a key can be a large integer that is out of the range for the hash-table index, 
so you need to scale it down to fit in the index’s range. Assume the index for a hash table is 
between0 and N-1. The most common way to scale an integer to between 0 and N-1 is to use
h(hashCode) = hashCode % N
To ensure that the indices are spread evenly, choose N to be a prime number greater than 2.
Ideally, you should choose a prime number for N. However, it is time consuming to find 
a large prime number. In the Java API implementation for java.util.HashMap, N is set 
to a value of the power of 2. There is a good reason for this choice. When N is a value of the 
power of 2,
h(hashCode) = hashCode % N
is the same as
h(hashCode) = hashCode & (N – 1)
The ampersand, &, is a bitwise AND operator (see Appendix G, Bitwise Operations). The 
AND of two corresponding bits yields a 1 if both bits are 1. For example, assume N = 4 and 
hashCode = 11,11 % 4 = 3, which is the same as 01011 & 00011 = 11. The & operator 
can be performed much faster than the % operator.
To ensure that the hashing is evenly distributed, a supplemental hash function is also used 
along with the primary hash function in the implementation of java.util.HashMap. This 
function is defined as:
private static int supplementalHash(int h) {
  h ^= (h >>> 20) ^ (h >>> 12);
return h ^ (h >>> 7) ^ (h >>> 4);
}
^ and >>> are bitwise exclusive-or and unsigned right-shift operations (also introduced in 
Appendix G). The bitwise operations are much faster than the multiplication, division, and 
remainder operations. You should replace these operations with the bitwise operations when-
ever possible.
The complete hash function is defined as:
h(hashCode) = supplementalHash(hashCode) % N
polynomial hash code
```

</details>


## PDF page 1012

<details>
<summary>Page text</summary>

```text
27.4 Handling Collisions Using Open Addressing  989
This is the same as
h(hashCode) = supplementalHash(hashCode) & (N – 1)
sinceN is a value of the power of 2.
27.2 What is a hash code? What is the hash code for Byte, Short, Integer, and 
Character?
27.3 How is the hash code for a Float object computed?
27.4 How is the hash code for a Long object computed?
27.5 How is the hash code for a Double object computed?
27.6 How is the hash code for a String object computed?
27.7 How is a hash code compressed to an integer representing the index in a hash table?
27.8 IfN is a value of the power of 2, is N / 2 same as N >> 1?
27.9 IfN is a value of the power of 2, is m % N same as m & (N – 1) for any integer m?
27.4 Handling Collisions Using Open Addressing
A collision occurs when two keys are mapped to the same index in a hash table. 
Generally, there are two ways for handling collisions: open addressing and separate 
chaining.
Open addressing is the process of finding an open location in the hash table in the event of 
a collision. Open addressing has several variations: linear probing, quadratic probing, and 
double hashing.
27.4.1 Linear Probing
When a collision occurs during the insertion of an entry to a hash table, linear probing finds 
the next available location sequentially. For example, if a collision occurs at hashTable[k % 
N], check whether hashTable[(k+1) % N] is available. If not, check hashTable[(k+2)
% N] and so on, until an available cell is found, as shown in Figure 27.2.
Note
When probing reaches the end of the table, it goes back to the beginning of the table. 
Thus, the hash table is treated as if it were circular.
✓Point✓
Check
Key
Point
open addressing
add entry
linear probing
circular hash table
FIGURE 27.2  Linear probing finds the next available location sequentially.
0
1
2
3
4
5
6
7
8
9
10
key: 44
key: 4
key: 16
key: 28
key: 21
For simplicity, only the keys are
shown and the values are not
shown.  Here N is 11 and 
index = key % N.
New element with
key 26 to be inserted
Probe 3 times before
finding an empty
cell
```

</details>


## PDF page 1013

<details>
<summary>Page text</summary>

```text
990 Chapter 27 Hashing
To search for an entry in the hash table, obtain the index, say k, from the hash function 
for the key. Check whether hashTable[k % N]  contains the entry. If not, check whether 
hashTable[(k+1) % N] contains the entry, and so on, until it is found, or an empty cell is 
reached.
To remove an entry from the hash table, search the entry that matches the key. If the entry 
is found, place a special marker to denote that the entry is available. Each cell in the hash table 
has three possible states: occupied, marked, or empty. Note that a marked cell is also available 
for insertion.
Linear probing tends to cause groups of consecutive cells in the hash table to be occupied. 
Each group is called a cluster. Each cluster is actually a probe sequence that you must search 
when retrieving, adding, or removing an entry. As clusters grow in size, they may merge into even 
larger clusters, further slowing down the search time. This is a big disadvantage of linear probing.
Pedagogical Note
For an interactive GUI demo to see how linear probing works, go to www.cs.armstrong.edu/
liang/animation/HashingLinearProbingAnimation.html, as shown in Figure 27.3.
27.4.2 Quadratic Probing
Quadratic probing can avoid the clustering problem that can occur in linear probing. Linear 
probing looks at the consecutive cells beginning at index k. Quadratic probing, on the other 
hand, looks at the cells at indices (k + j2) % N, for j Ú 0, that is, k % N,( k + 1)% N,( k + 4)
% n,( k + 9)% N, and so on, as shown in Figure 27.4.
search entry
remove entry
cluster
linear probing animation on 
Companion Website
quadratic probing
FIGURE 27.3  The animation tool shows how linear probing works.
```

</details>


## PDF page 1014

<details>
<summary>Page text</summary>

```text
27.4 Handling Collisions Using Open Addressing  991
Quadratic probing works in the same way as linear probing except for a change in the 
search sequence. Quadratic probing avoids linear probing’s clustering problem, but it has its 
own clustering problem, called secondary clustering; that is, the entries that collide with an 
occupied entry use the same probe sequence.
Linear probing guarantees that an available cell can be found for insertion as long as the 
table is not full. However, there is no such guarantee for quadratic probing.
Pedagogical NOTE
For an interactive GUI demo to see how quadratic probing works, go to www.cs.armstrong.
edu/liang/animation/HashingQuadraticProbingAnimation.html, as shown in Figure 27.5.
27.4.3 Double Hashing
Another open addressing scheme that avoids the clustering problem is known as double hash-
ing. Starting from the initial index k, both linear probing and quadratic probing add an incre-
ment to k to define a search sequence. The increment is 1 for linear probing and j2 for quadratic 
probing. These increments are independent of the keys. Double hashing uses a secondary hash 
function h′(key) on the keys to determine the increments to avoid the clustering problem. Spe-
cifically, double hashing looks at the cells at indices (k + j* h′(key)) % N, for j Ú 0, that is, 
k % N,( k + h′(key))% N, (k + 2*h ′(key)) % N, (k + 3*h ′(key)) % N, and so on.
For example, let the primary hash function h and secondary hash function h' on a hash 
table of size 11 be defined as follows:
h(key) = key % 11;
h'(key) = 7 – key % 7;
For a search key of 12, we have
h(12) = 12 % 11 = 1;
h'(12) = 7 – 12 % 7 = 2;
Suppose the elements with the keys 45,58,4,28, and 21 are already placed in the hash table. 
We now insert the element with key 12. The probe sequence for key 12 starts at index 1. Since 
the cell at index 1 is already occupied, search the next cell at index 3 (1 + 1 * 2) . Since 
the cell at index 3 is already occupied, search the next cell at index 5 (1 + 2 * 2). Since the 
cell at index 5 is empty, the element for key 12 is now inserted at this cell. The search process 
is illustrated in Figure 27.6.
The indices of the probe sequence are as follows: 1, 3, 5, 7, 9, 0, 2, 4, 6, 8, 10. This sequence 
reaches the entire table. You should design your functions to produce a probe sequence that 
secondary clustering
quadratic probing animation 
on Companion Website
double hashing
FIGURE 27.4  Quadratic probing increases the next index in the sequence by j2 for 
j = 1 ,2 ,3 ,....
0
1
2
3
4
5
6
7
8
9
10
key: 44
key: 4
key: 16
key: 28
key: 21
.
.
.
For simplicity, only the keys are
shown and not the values. Here 
N is 11 and index = key % N.
New element with
key 26 to be inserted
Quadratic probe 2
times before finding
an empty cell
```

</details>


## PDF page 1015

<details>
<summary>Page text</summary>

```text
992 Chapter 27 Hashing
FIGURE 27.5  The animation tool shows how quadratic probing works.
FIGURE 27.6  The secondary hash function in a double hashing determines the increment of the next index in the probe 
sequence.
0
1
2
3
4
5
6
7
8
9
10
key: 45
key: 4
key: 58
key: 28
key: 21
h(12)
0
1
2
3
4
5
6
7
8
9
10
key: 45
key: 4
key: 58
key: 28
key: 21
h(12) + h'(12)
0
1
2
3
4
5
6
7
8
9
10
key: 45
key: 4
key: 58
key: 28
key: 21
h(12) + 2*h'(12)
.
.
.
.
.
.
reaches the entire table. Note that the second function should never have a zero value, since 
zero is not an increment.
27.10 What is open addressing? What is linear probing? What is quadratic probing? What 
is double hashing?
27.11 Describe the clustering problem for linear probing.
✓Point✓
Check
```

</details>


## PDF page 1016

<details>
<summary>Page text</summary>

```text
27.6 Load Factor and Rehashing  993
27.12 What is secondary clustering?
27.13 Show the hash table of size 11 after inserting entries with keys 34, 29, 53, 44, 120, 
39, 45, and 40, using linear probing.
27.14 Show the hash table of size 11 after inserting entries with keys 34, 29, 53, 44, 120, 
39, 45, and 40, using quadratic probing.
27.15 Show the hash table of size 11 after inserting entries with keys 34, 29, 53, 44, 120, 
39, 45, and 40, using double hashing with the following functions:
h(k) = k % 11;
h'(k) = 7 – k % 7;
27.5 Handling Collisions Using Separate Chaining
The separate chaining scheme places all entries with the same hash index in the same 
location, rather than finding new locations. Each location in the separate chaining 
scheme uses a bucket to hold multiple entries.
You can implement a bucket using an array, ArrayList, or LinkedList. We will use 
LinkedList for demonstration. You can view each cell in the hash table as the reference to 
the head of a linked list, and elements in the linked list are chained starting from the head, as 
shown in Figure 27.7.
Key
Point
separate chaining
implementing bucket
FIGURE 27.7  Separate chaining scheme chains the entries with the same hash index in a 
bucket.
0
1
2
3
4
5
6
7
8
9
10
key: 44
key: 28
key: 21
key: 26key: 4
key: 16
New element with
key 26 to be inserted
For simplicity, only the keys are
shown, and not the values. Here 
N is 11 and index = key % N.
.
.
.
27.16 Show the hash table of size 11 after inserting entries with the keys 34, 29, 53, 44, 
120, 39, 45, and 40, using separate chaining.
27.6 Load Factor and Rehashing
The load factor measures how full a hash table is. If the load factor is exceeded, 
increase the hash-table size and reload the entries into a new larger hash table. This 
is called rehashing.
Load factor l (lambda) measures how full a hash table is. It is the ratio of the number of 
elements to the size of the hash table, that is, l = nN, where n denotes the number of elements and N the number of locations in the hash table.
Note that l is zero if the hash table is empty. For the open addressing scheme, l is between 
0 and 1; l is 1 if the hash table is full. For the separate chaining scheme, l can be any value. 
✓Point✓
Check
Key
Point
rehashing
load factor
```

</details>


## PDF page 1017

<details>
<summary>Page text</summary>

```text
994 Chapter 27 Hashing
As l increases, the probability of a collision increases. Studies show that you should maintain 
the load factor under 0.5 for the open addressing scheme and under 0.9 for the separate 
chaining scheme.
Keeping the load factor under a certain threshold is important for the performance of hash-
ing. In the implementation of the java.util.HashMap class in the Java API, the threshold 
0.75 is used. Whenever the load factor exceeds the threshold, you need to increase the hash-
table size and rehash all the entries in the map into a new larger hash table. Notice that you 
need to change the hash functions, since the hash-table size has been changed. To reduce the 
likelihood of rehashing, since it is costly, you should at least double the hash-table size. Even 
with periodic rehashing, hashing is an efficient implementation for map.
Pedagogical Note
For an interactive GUI demo to see how separate chaining works, go to www.cs.armstrong
.edu/liang/animation/HashingUsingSeparateChainingAnimation.html, as shown in Figure 27.8.
threshold
rehash
separate chaining animation 
on Companion Website
FIGURE 27.8  The animation tool shows how separate chaining works.
27.17 What is load factor? Assume the hash table has the initial size 4 and its load factor is 
0.5; show the hash table after inserting entries with the keys 34, 29, 53, 44, 120, 39, 
45, and 40, using linear probing.
27.18 Assume the hash table has the initial size 4 and its load factor is 0.5; show the hash 
table after inserting entries with the keys 34, 29, 53, 44, 120, 39, 45, and 40, using 
quadratic probing.
✓Point✓
Check
```

</details>


## PDF page 1018

<details>
<summary>Page text</summary>

```text
27.7 Implementing a Map Using Hashing  995
27.19 Assume the hash table has the initial size 4 and its load factor is 0.5; show the hash 
table after inserting entries with the keys 34, 29, 53, 44, 120, 39, 45, and 40, using 
separate chaining.
27.7 Implementing a Map Using Hashing
A map can be implemented using hashing.
Now you understand the concept of hashing. You know how to design a good hash function 
to map a key to an index in a hash table, how to measure performance using the load factor, 
and how to increase the table size and rehash to maintain the performance. This section dem-
onstrates how to implement a map using separate chaining.
We design our custom Map interface to mirror java.util.Map and name the interface 
MyMap and a concrete class MyHashMap, as shown in Figure 27.9.
Key
Point
FIGURE 27.9 MyHashMap implements the MyMap interface.
MyHashMap<K, V>
+clear(): void
+containsKey(key: K): boolean
+containsValue(value: V): boolean
+entrySet(): Set<Entry<K, V>>
+get(key: K): V
+isEmpty(): boolean
+keySet(): Set<K>
+put(key: K, value: V): V
+remove(key: K): void
+size(): int
+values(): Set<V>
Removes all entries from this map.
Returns true if this map contains an entry for the
     specified key.
Returns true if this map maps one or more keys to the
     specified value.
Returns a set consisting of the keys in this map.
Returns a set consisting of the entries in this map.
Returns a value for the specified key in this map.
Returns true if this map contains no mappings.
Puts a mapping in this map.
Removes the entries for the specified key.
Returns the number of mappings in this map.
Returns a set consisting of the values in this map.
Creates an empty map with default capacity 4 and
    default load factor threshold 0.75f.
+MyHashMap()
Creates a map with a specified capacity and
    default load factor threshold 0.75f.
+MyHashMap(capacity: int)
Creates a map with a specified capacity and
    load factor threshold.
+MyHashMap(capacity: int,
  loadFactorThreshold: float)
Constructs an entry with the specified key and value.
Returns the key in the entry.
Returns the value in the entry.
-key: K
-value: V
+Entry(key: K, value: V)
+getkey(): K
+getValue(): V
MyMap.Entry<K, V>
«interface»
MyMap<K, V>
```

</details>


## PDF page 1019

<details>
<summary>Page text</summary>

```text
996 Chapter 27 Hashing
How do you implement MyHashMap? If you use an ArrayList and store a new entry at 
the end of the list, the search time will be O(n). If you implement MyHashMap using a binary 
tree, the search time will be O(log n) if the tree is well balanced. Nevertheless, you can imple-
mentMyHashMap using hashing to obtain an O(1) time search algorithm. Listing 27.1 shows 
theMyMap interface and Listing 27.2 implements MyHashMap using separate chaining.
LISTING 27.1 MyMap.java
 1 public interface MyMap<K, V> {
 2 /** Remove all of the entries from this map */ 
 3 public void clear();
 4
 5 /** Return true if the specified key is in the map */
 6 public boolean containsKey(K key); 
 7
 8 /** Return true if this map contains the specified value */ 
 9 public boolean containsValue(V value); 
10
11 /** Return a set of entries in the map */
12 public java.util.Set<Entry<K, V>> entrySet();
13
14 /** Return the value that matches the specified key */
15 public V get(K key); 
16
17 /** Return true if this map doesn't contain any entries */
18 public boolean isEmpty();
19
20 /** Return a set consisting of the keys in this map */
21 public java.util.Set<K> keySet();
22
23 /** Add an entry (key, value) into the map */
24 public V put(K key, V value); 
25
26 /** Remove an entry for the specified key */
27 public void remove(K key); 
28
29 /** Return the number of mappings in this map */
30 public int size();
31
32 /** Return a set consisting of the values in this map */
33 public java.util.Set<V> values();
34
35 /** Define an inner class for Entry */
36 public static class Entry<K, V> {
37      K key;
38      V value;
39
40 public Entry(K key, V value) {
41 this.key = key;
42 this.value = value;
43      }
44
45 public K getKey() {
46 return key;
47      }
48
49 public V getValue() {
50 return value;
51      }
52
interfaceMyMap
clear
containsKey
containsValue
entrySet
get
isEmpty
keySet
put
remove
size
values
Entry inner class
```

</details>


## PDF page 1020

<details>
<summary>Page text</summary>

```text
27.7 Implementing a Map Using Hashing  997
53      @Override
54 public String toString() {
55 return "[" + key + ", " + value + "]";
56      }
57    }
58  }
LISTING 27.2 MyHashMap.java
  1 import java.util.LinkedList;
  2
  3 public class MyHashMap<K, V> implements MyMap<K, V> {
  4 // Define the default hash-table size. Must be a power of 2
  5 private static int DEFAULT_INITIAL_CAPACITY = 4;
  6
  7 // Define the maximum hash-table size. 1 << 30 is same as 2^30
  8 private static int MAXIMUM_CAPACITY = 1 << 30;
  9
 10 // Current hash-table capacity. Capacity is a power of 2
 11 private int capacity; 
 12
 13 // Define default load factor
 14 private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
 15
 16 // Specify a load factor used in the hash table
 17 private float loadFactorThreshold; 
 18
 19 // The number of entries in the map
 20 private int size = 0;
 21
 22 // Hash table is an array with each cell being a linked list
 23    LinkedList<MyMap.Entry<K,V>>[] table; 
 24
 25 /** Construct a map with the default capacity and load factor */
 26 public MyHashMap() {
 27 this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
 28    }
 29
 30 /** Construct a map with the specified initial capacity and 
 31     * default load factor */
 32 public MyHashMap(int initialCapacity) {
 33 this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
 34    }
 35
 36 /** Construct a map with the specified initial capacity 
 37     * and load factor */
 38 public MyHashMap(int initialCapacity, float loadFactorThreshold) {
 39 if (initialCapacity > MAXIMUM_CAPACITY)
 40 this.capacity = MAXIMUM_CAPACITY;
 41 else
 42 this.capacity = trimToPowerOf2(initialCapacity);
 43
 44 this.loadFactorThreshold = loadFactorThreshold;
 45      table = new LinkedList[capacity];
 46    }
 47
 48    @Override /** Remove all of the entries from this map */ 
 49 public void clear() {
 50      size = 0;
 51      removeEntries();
 52    }
classMyHashMap
default initial capacity
maximum capacity
current capacity
default load factor
load-factor threshold
size
hash table
no-arg constructor
constructor
constructor
clear
```

</details>


## PDF page 1021

<details>
<summary>Page text</summary>

```text
998 Chapter 27 Hashing
 53
 54    @Override /** Return true if the specified key is in the map */
 55 public boolean containsKey(K key) {
 56 if (get(key) != null)
 57 return true;
 58 else
 59 return false;
 60    }
 61
 62    @Override /** Return true if this map contains the value */ 
 63 public boolean containsValue(V value) {
 64 for (int i = 0; i < capacity; i++) {
 65 if (table[i] != null) {
 66          LinkedList<Entry<K, V>> bucket = table[i]; 
 67 for (Entry<K, V> entry: bucket)
 68 if (entry.getValue().equals(value)) 
 69 return true;
 70        }
 71      }
 72
 73 return false;
 74    }
 75
 76    @Override /** Return a set of entries in the map */
 77 public java.util.Set<MyMap.Entry<K,V>> entrySet() {
 78      java.util.Set<MyMap.Entry<K, V>> set = 
 79 new java.util.HashSet<>();
 80
 81 for (int i = 0; i < capacity; i++) {
 82 if (table[i] != null) {
 83          LinkedList<Entry<K, V>> bucket = table[i]; 
 84 for (Entry<K, V> entry: bucket)
 85            set.add(entry); 
 86        }
 87      }
 88
 89 return set;
 90    }
 91
 92    @Override /** Return the value that matches the specified key */
 93 public V get(K key) {
 94 int bucketIndex = hash(key.hashCode());
 95 if (table[bucketIndex] != null) {
 96        LinkedList<Entry<K, V>> bucket = table[bucketIndex]; 
 97 for (Entry<K, V> entry: bucket)
 98 if (entry.getKey().equals(key)) 
 99 return entry.getValue();
100      }
101
102 return null;
103    }
104
105    @Override /** Return true if this map contains no entries */
106 public boolean isEmpty() {
107 return size == 0;
108    }
109
110    @Override /** Return a set consisting of the keys in this map */
111 public java.util.Set<K> keySet() {
112      java.util.Set<K> set = new java.util.HashSet<K>();
containsKey
containsValue
entrySet
get
isEmpty
keySet
```

</details>


## PDF page 1022

<details>
<summary>Page text</summary>

```text
27.7 Implementing a Map Using Hashing  999
113
114 for (int i = 0; i < capacity; i++) {
115 if (table[i] != null) {
116          LinkedList<Entry<K, V>> bucket = table[i]; 
117 for (Entry<K, V> entry: bucket)
118            set.add(entry.getKey()); 
119        }
120      }
121
122 return set;
123    }
124
125    @Override /** Add an entry (key, value) into the map */
126 public V put(K key, V value) {
127 if (get(key) != null) { // The key is already in the map
128 int bucketIndex = hash(key.hashCode());
129        LinkedList<Entry<K, V>> bucket = table[bucketIndex]; 
130 for (Entry<K, V> entry: bucket)
131 if (entry.getKey().equals(key)) {
132            V oldValue = entry.getValue();
133 // Replace old value with new value
134            entry.value = value; 
135 // Return the old value for the key
136 return oldValue;
137          }
138      }
139
140 // Check load factor
141 if (size >= capacity * loadFactorThreshold) {
142 if (capacity == MAXIMUM_CAPACITY)
143 throw new RuntimeException("Exceeding maximum capacity");
144
145        rehash();
146      }
147
148 int bucketIndex = hash(key.hashCode());
149
150 // Create a linked list for the bucket if not already created
151 if (table[bucketIndex] == null) {
152        table[bucketIndex] = new LinkedList<Entry<K, V>>();
153      }
154
155 // Add a new entry (key, value) to hashTable[index]
156      table[bucketIndex].add(new MyMap.Entry<K, V>(key, value));
157
158      size++; // Increase size
159
160 return value;
161    } 
162
163    @Override /** Remove the entries for the specified key */
164 public void remove(K key) {
165 int bucketIndex = hash(key.hashCode());
166
167 // Remove the first entry that matches the key from a bucket
168 if (table[bucketIndex] != null) {
169        LinkedList<Entry<K, V>> bucket = table[bucketIndex]; 
170 for (Entry<K, V> entry: bucket)
171 if (entry.getKey().equals(key)) {
172            bucket.remove(entry);
put
remove
```

</details>


## PDF page 1023

<details>
<summary>Page text</summary>

```text
1000 Chapter 27 Hashing
173            size—–; // Decrease size
174 break; // Remove just one entry that matches the key
175          }
176      }
177    }
178
179    @Override /** Return the number of entries in this map */
180 public int size() {
181 return size;
182    }
183
184    @Override /** Return a set consisting of the values in this map */
185 public java.util.Set<V> values() {
186      java.util.Set<V> set = new java.util.HashSet<>();
187
188 for (int i = 0; i < capacity; i++) {
189 if (table[i] != null) {
190          LinkedList<Entry<K, V>> bucket = table[i]; 
191 for (Entry<K, V> entry: bucket)
192            set.add(entry.getValue()); 
193        }
194      }
195
196 return set;
197    }
198
199 /** Hash function */
200 private int hash(int hashCode) {
201 return supplementalHash(hashCode) & (capacity - 1);
202    }
203
204 /** Ensure the hashing is evenly distributed */
205 private static int supplementalHash(int h) {
206      h ^= (h >>> 20) ^ (h >>> 12);
207 return h ^ (h >>> 7) ^ (h >>> 4);
208    }
209
210 /** Return a power of 2 for initialCapacity */
211 private int trimToPowerOf2(int initialCapacity) {
212 int capacity = 1;
213 while (capacity < initialCapacity) {
214        capacity <<= 1; // Same as capacity *= 2. <= is more efficient
215      }
216
217 return capacity;
218    }
219
220 /** Remove all entries from each bucket */
221 private void removeEntries() {
222 for (int i = 0; i < capacity; i++) {
223 if (table[i] != null) {
224          table[i].clear();
225        }
226      }
227    }
228
229 /** Rehash the map */
230 private void rehash() {
231      java.util.Set<Entry<K, V>> set = entrySet(); // Get entries
232      capacity <<= 1; // Same as capacity *= 2. <= is more efficient
size
values
hash
supplementalHash
trimToPowerOf2
removeEntries
rehash
```

</details>


## PDF page 1024

<details>
<summary>Page text</summary>

```text
27.7 Implementing a Map Using Hashing  1001
233      table = new LinkedList[capacity]; // Create a new hash table
234      size = 0; // Reset size to 0
235
236 for (Entry<K, V> entry: set) {
237        put(entry.getKey(), entry.getValue()); // Store to new table
238      }
239    }
240
241    @Override /** Return a string representation for this map */
242 public String toString() {
243      StringBuilder builder = new StringBuilder("[");
244
245 for (int i = 0; i < capacity; i++) {
246 if (table[i] != null && table[i].size() > 0)
247 for (Entry<K, V> entry: table[i])
248            builder.append(entry);
249      }
250
251      builder.append("]");
252 return builder.toString();
253    }
254  }
TheMyHashMap class implements the MyMap interface using separate chaining. The param-
eters that determine the hash-table size and load factors are defined in the class. The default 
initial capacity is 4 (line 5) and the maximum capacity is 2 30 (line 8). The current hash-table 
capacity is designed as a value of the power of 2 (line 11). The default load-factor threshold 
is0.75f (line 14). You can specify a custom load-factor threshold when constructing a map. 
The custom load-factor threshold is stored in loadFactorThreshold (line 17). The data 
fieldsize denotes the number of entries in the map (line 20). The hash table is an array. Each 
cell in the array is a linked list (line 23).
Three constructors are provided to construct a map. You can construct a default map with 
the default capacity and load-factor threshold using the no-arg constructor (lines 26–28), a 
map with the specified capacity and a default load-factor threshold (lines 32–34), and a map 
with the specified capacity and load-factor threshold (lines 38–46).
The clear method removes all entries from the map (lines 49–52). It invokes 
removeEntries(), which deletes all entries in the buckets (lines 221–227). The 
removeEntries() method takes O(capacity) time to clear all entries in the table.
The containsKey(key) method checks whether the specified key is in the map 
by invoking the get method (lines 55–60). Since the get method takes O(1) time, the 
containsKey(key) method takes O(1) time.
The containsValue(value) method checks whether the value is in the map (lines 
63–74). This method takes O(capacity + size) time. It is actually O(capacity), since 
capacity 7 size.
TheentrySet() method returns a set that contains all entries in the map (lines 77–90). 
This method takes O(capacity) time.
The get(key) method returns the value of the first entry with the specified key (lines 
93–103). This method takes O(1) time.
The isEmpty() method simply returns true if the map is empty (lines 106–108). This 
method takes O(1) time.
ThekeySet() method returns all keys in the map as a set. The method finds the keys from 
each bucket and adds them to a set (lines 111–123). This method takes O(capacity) time.
Theput(key, value) method adds a new entry into the map. The method first tests if 
the key is already in the map (line 127), if so, it locates the entry and replaces the old value 
with the new value in the entry for the key (line 134) and the old value is returned (line 136). If 
toString
hash-table parameters
three constructors
clear
containsKey
containsValue
entrySet
get
isEmpty
keySet
put
```

</details>


## PDF page 1025

<details>
<summary>Page text</summary>

```text
1002 Chapter 27 Hashing
the key is new in the map, the new entry is created in the map (line 156). Before inserting the 
new entry, the method checks whether the size exceeds the load-factor threshold (line 141). If 
so, the program invokes rehash() (line 145) to increase the capacity and store entries into 
the new larger hash table.
Therehash() method first copies all entries in a set (line 231), doubles the capacity (line 
232), creates a new hash table (line 233), and resets the size to 0 (line 234). The method then cop-
ies the entries into the new hash table (lines 236–238). The rehash method takes O(capacity)
time. If no rehash is performed, the put method takes O(1) time to add a new entry.
The remove(key) method removes the entry with the specified key in the map (lines 
164–177). This method takes O(1) time.
Thesize() method simply returns the size of the map (lines 180–182). This method takes 
O(1) time.
The values() method returns all values in the map. The method examines each entry 
from all buckets and adds it to a set (lines 185–197). This method takes O(capacity) time.
Thehash() method invokes the supplementalHash to ensure that the hashing is evenly 
distributed to produce an index for the hash table (lines 200–208). This method takes O(1) time.
Table 27.1 summarizes the time complexities of the methods in MyHashMap.
rehash
remove
size
values
hash
Methods Time
clear() O(capacity)
containsKey(key: Key) O(1)
containsValue(value: V) O(capacity)
entrySet() O(capacity)
get(key: K) O(1)
isEmpty() O(1)
keySet() O(capacity)
put(key: K, value: V) O(1)
remove(key: K) O(1)
size() O(1)
values() O(capacity)
rehash() O(capacity)
TABLE 27.1  Time Complexities for Methods in 
MyHashMap
Since rehashing does not happen very often, the time complexity for the put method is 
O(1). Note that the complexities of the clear, entrySet, keySet, values, and rehash
methods depend on capacity, so to avoid poor performance for these methods you should 
choose an initial capacity carefully.
Listing 27.3 gives a test program that uses MyHashMap.
LISTING 27.3 TestMyHashMap.java
 1 public class TestMyHashMap {
 2 public static void main(String[] args) {
 3 // Create a map
4      MyMap<String, Integer> map = new MyHashMap<>(); 
 5      map.put("Smith", 30);
 6      map.put("Anderson", 31);
 7      map.put("Lewis", 29);
 8      map.put("Cook", 29);
create a map
put entries
```

</details>


## PDF page 1026

<details>
<summary>Page text</summary>

```text
27.7 Implementing a Map Using Hashing  1003
 9      map.put("Smith", 65);
10
11      System.out.println("Entries in map: " + map); 
12
13      System.out.println("The age for Lewis is " +
14        map.get("Lewis"));
15
16      System.out.println("Is Smith in the map? " + 
17        map.containsKey("Smith"));
18      System.out.println("Is age 33 in the map? " + 
19        map.containsValue(33));
20
21      map.remove("Smith");
22      System.out.println("Entries in map: " + map);
23
24      map.clear();
25      System.out.println("Entries in map: " + map);
26    }
27  } 
display entries
get value
is key in map?
is value in map?
remove entry
Entries in map: [[Anderson, 31][Smith, 65][Lewis, 29][Cook, 29]]
The age for Lewis is 29
Is Smith in the map? true
Is age 33 in the map? false
Entries in map: [[Anderson, 31][Lewis, 29][Cook, 29]]
Entries in map: [] 
The program creates a map using MyHashMap (line 4) and adds five entries into the map 
(lines 5–9). Line 5 adds key Smith with value 30 and line 9 adds Smith with value 65. The 
latter value replaces the former value. The map actually has only four entries. The program 
displays the entries in the map (line 11), gets a value for a key (line 14), checks whether the 
map contains the key (line 17) and a value (line 19), removes an entry with the key Smith
(line 21), and redisplays the entries in the map (line 22). Finally, the program clears the map 
(line 24) and displays an empty map (line 25).
27.20 What is 1 << 30 in line 8 in Listing 27.2? What are the integers resulted from 1 << 1,
1 << 2, and 1 << 3?
27.21 What are the integers resulted from 32 >> 1,32 >> 2,32 >> 3, and 32 >> 4?
27.22 In Listing 27.2, will the program work if LinkedList is replaced by ArrayList?
In Listing 27.2, how do you replace the code in lines 55–59 using one line of code?
27.23 Describe how the put(key, value)  method is implemented in the MyHashMap
class.
27.24 In Listing 27.5, the supplementalHash method is declared static, can the hash
method be declared static? 
27.25 Show the output of the following code.
MyMap<String, String> map = new MyHashMap<>();
map.put("Texas", "Dallas");
map.put("Oklahoma", "Norman");
map.put("Texas", "Austin");
map.put("Oklahoma", "Tulsa");
System.out.println(map.get("Texas"));
System.out.println(map.size());
✓Point✓
Check
```

</details>


## PDF page 1027

<details>
<summary>Page text</summary>

```text
1004 Chapter 27 Hashing
27.8 Implementing Set Using Hashing
A hash set can be implemented using a hash map.
A set (introduced in Chapter 21) is a data structure that stores distinct values. The Java Collections 
Framework defines the java.util.Set interface for modeling sets. Three concrete implemen-
tations arejava.util.HashSet,java.util.LinkedHashSet, and java.util.TreeSet.
java.util.HashSet is implemented using hashing, java.util.LinkedHashSet using 
LinkedList, and java.util.TreeSet using red-black trees.
You can implement MyHashSet using the same approach as for implementing MyHashMap.
The only difference is that key/value pairs are stored in the map, while elements are stored in 
the set.
We design our custom Set interface to mirror java.util.Set and name the interface 
MySet and a concrete class MyHashSet, as shown in Figure 27.10.
Key
Point
hash set
hash map
set
MySet
MyHashSet
FIGURE 27.10 MyHashSet implements the MySet interface.
Removes all elements from this set.
Returns true if the element is in the set.
Adds the element to the set and returns true if the element is added
successfully.
Removes the element from the set and returns true if the set
    contained the element.
Returns true if this set does not contain any elements.
Returns the number of elements in this set.
MyHashSet<E>
+clear(): void
«interface»
MySet<E>
+size(): int
+isEmpty(): boolean
+remove(e: E): boolean
+add(e: E): boolean
+contains(e: E): boolean
«interface»
java.lang.Iterable<E>
Creates an empty set with default capacity 4 and default load
    factor threshold 0.75f.
+MyHashSet()
Creates a set with a specified capacity and default load factor
    threshold 0.75f.
+MyHashMap(capacity: int)
Creates a set with a specified capacity and load factor threshold.+MyHashMap(capacity: int,
  loadFactorThreshold: float)
+iterator(): java.util.Iterator<E>
Listing 27.4 shows the MySet interface and Listing 27.5 implements MyHashSet using 
separate chaining.
LISTING 27.4 MySet.java
 1 public interface MySet<E> extends java.lang.Iterable<E> {
 2 /** Remove all elements from this set */
 3 public void clear();
 4
 5 /** Return true if the element is in the set */
clear
```

</details>


## PDF page 1028

<details>
<summary>Page text</summary>

```text
27.8 Implementing Set Using Hashing  1005
 6 public boolean contains(E e); 
 7
 8 /** Add an element to the set */
 9 public boolean add(E e); 
10
11 /** Remove the element from the set */
12 public boolean remove(E e); 
13
14 /** Return true if the set doesn't contain any elements */
15 public boolean isEmpty();
16
17 /** Return the number of elements in the set */
18 public int size();
19  } 
LISTING 27.5 MyHashSet.java
  1 import java.util.LinkedList;
  2
  3 public class MyHashSet<E> implements MySet<E> {
  4 // Define the default hash-table size. Must be a power of 2
  5 private static int DEFAULT_INITIAL_CAPACITY = 4;
  6
  7 // Define the maximum hash-table size. 1 << 30 is same as 2^30
  8 private static int MAXIMUM_CAPACITY = 1 << 30;
  9
 10 // Current hash-table capacity. Capacity is a power of 2
 11 private int capacity; 
 12
 13 // Define default load factor
 14 private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
 15
 16 // Specify a load-factor threshold used in the hash table
 17 private float loadFactorThreshold; 
 18
 19 // The number of elements in the set
 20 private int size = 0;
 21
 22 // Hash table is an array with each cell being a linked list
 23 private LinkedList<E>[] table; 
 24
 25 /** Construct a set with the default capacity and load factor */
 26 public MyHashSet() {
 27 this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
 28    }
 29
 30 /** Construct a set with the specified initial capacity and 
 31     * default load factor */
32 public MyHashSet(int initialCapacity) {
 33 this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
 34    }
 35
 36 /** Construct a set with the specified initial capacity 
 37     * and load factor */
 38 public MyHashSet(int initialCapacity, float loadFactorThreshold) {
 39 if (initialCapacity > MAXIMUM_CAPACITY)
 40 this.capacity = MAXIMUM_CAPACITY;
 41 else
 42 this.capacity = trimToPowerOf2(initialCapacity);
contains
add
remove
isEmpty
size
classMyHashSet
default initial capacity
maximum capacity
current capacity
default max load factor
load-factor threshold
size
hash table
no-arg constructor
constructor
constructor
```

</details>


## PDF page 1029

<details>
<summary>Page text</summary>

```text
1006 Chapter 27 Hashing
 43
 44 this.loadFactorThreshold = loadFactorThreshold;
 45      table = new LinkedList[capacity];
 46    }
 47
 48    @Override /** Remove all elements from this set */ 
 49 public void clear() {
 50      size = 0;
 51      removeElements();
 52    }
 53
 54    @Override /** Return true if the element is in the set */
 55 public boolean contains(E e) {
 56 int bucketIndex = hash(e.hashCode());
 57 if (table[bucketIndex] != null) {
 58        LinkedList<E> bucket = table[bucketIndex]; 
 59 for (E element: bucket)
 60 if (element.equals(e)) 
 61 return true;
 62      }
 63
 64 return false;
 65    }
 66
 67    @Override /** Add an element to the set */
 68 public boolean add(E e) {
 69 if (contains(e)) // Duplicate element not stored
 70 return false;
 71
 72 if (size + 1 > capacity * loadFactorThreshold) {
 73 if (capacity == MAXIMUM_CAPACITY)
 74 throw new RuntimeException("Exceeding maximum capacity");
 75
 76        rehash();
 77      }
 78
 79 int bucketIndex = hash(e.hashCode());
 80
 81 // Create a linked list for the bucket if not already created
 82 if (table[bucketIndex] == null) {
 83        table[bucketIndex] = new LinkedList<E>();
 84      }
 85
 86 // Add e to hashTable[index]
 87      table[bucketIndex].add(e);
 88
 89      size++; // Increase size
 90
 91 return true;
 92    }
 93
 94    @Override /** Remove the element from the set */
 95 public boolean remove(E e) {
 96 if (!contains(e))
 97 return false;
 98
 99 int bucketIndex = hash(e.hashCode());
100
101 // Create a linked list for the bucket if not already created
102 if (table[bucketIndex] != null) {
clear
contains
add
remove
```

</details>


## PDF page 1030

<details>
<summary>Page text</summary>

```text
27.8 Implementing Set Using Hashing  1007
103        LinkedList<E> bucket = table[bucketIndex]; 
104 for (E element: bucket)
105 if (e.equals(element)) {
106            bucket.remove(element);
107 break;
108          }
109      }
110
111      size——; // Decrease size
112
113 return true;
114    }
115
116    @Override /** Return true if the set contain no elements */
117 public boolean isEmpty() {
118 return size == 0;
119    }
120
121    @Override /** Return the number of elements in the set */
122 public int size() {
123 return size;
124    }
125
126    @Override /** Return an iterator for the elements in this set */
127 public java.util.Iterator<E> iterator() {
128 return new MyHashSetIterator(this);
129    }
130
131 /** Inner class for iterator */
132 private class MyHashSetIterator implements java.util.Iterator<E> {
133 // Store the elements in a list
134 private java.util.ArrayList<E> list;
135 private int current = 0; // Point to the current element in list
136 private MyHashSet<E> set;
137
138 /** Create a list from the set */
139 public MyHashSetIterator(MyHashSet<E> set) {
140 this.set = set;
141        list = setToList();
142      }
143
144      @Override /** Next element for traversing? */
145 public boolean hasNext() {
146 if (current < list.size())
147 return true;
148
149 return false;
150      }
151
152      @Override /** Get current element and move cursor to the next */
153 public E next() {
154 return list.get(current++);
155      }
156
157 /** Remove the current element and refresh the list */
158 public void remove() {
159 // Delete the current element from the hash set
160        set.remove(list.get(current)); 
161        list.remove(current); // Remove current element from the list
162      }
isEmpty
size
iterator
inner class
```

</details>


## PDF page 1031

<details>
<summary>Page text</summary>

```text
1008 Chapter 27 Hashing
163    }
164
165 /** Hash function */
166 private int hash(int hashCode) {
167 return supplementalHash(hashCode) & (capacity - 1);
168    }
169
170 /** Ensure the hashing is evenly distributed */
171 private static int supplementalHash(int h) {
172      h ^= (h >>> 20) ^ (h >>> 12);
173 return h ^ (h >>> 7) ^ (h >>> 4);
174    }
175
176 /** Return a power of 2 for initialCapacity */
177 private int trimToPowerOf2(int initialCapacity) {
178 int capacity = 1;
179 while (capacity < initialCapacity) {
180        capacity <<= 1; // Same as capacity *= 2. <= is more efficient
181      }
182
183 return capacity;
184    }
185
186 /** Remove all e from each bucket */
187 private void removeElements() {
188 for (int i = 0; i < capacity; i++) {
189 if (table[i] != null) {
190          table[i].clear();
191        }
192      }
193    }
194
195 /** Rehash the set */
196 private void rehash() {
197      java.util.ArrayList<E> list = setToList(); // Copy to a list
198      capacity <<= 1; // Same as capacity *= 2. <= is more efficient
199      table = new LinkedList[capacity]; // Create a new hash table
200      size = 0;
201
202 for (E element: list) {
203        add(element); // Add from the old table to the new table
204      }
205    }
206
207 /** Copy elements in the hash set to an array list */
208 private java.util.ArrayList<E> setToList() {
209      java.util.ArrayList<E> list = new java.util.ArrayList<>();
210
211 for (int i = 0; i < capacity; i++) {
212 if (table[i] != null) {
213 for (E e: table[i]) {
214            list.add(e);
215          }
216        }
217      }
218
219 return list;
220    }
221
222    @Override /** Return a string representation for this set */
hash
supplementalHash
trimToPowerOf2
rehash
setToList
```

</details>


## PDF page 1032

<details>
<summary>Page text</summary>

```text
27.8 Implementing Set Using Hashing  1009
223 public String toString() {
224      java.util.ArrayList<E> list = setToList();
225      StringBuilder builder = new StringBuilder("[");
226
227 // Add the elements except the last one to the string builder
228 for (int i = 0; i < list.size() - 1; i++) {
229        builder.append(list.get(i) + ", ");
230      }
231
232 // Add the last element in the list to the string builder
233 if (list.size() == 0)
234        builder.append("]");
235 else
236        builder.append(list.get(list.size() - 1) + "]");
237
238 return builder.toString();
239    }
240  }
The MyHashSet class implements the MySet interface using separate chaining. Imple-
menting MyHashSet is very similar to implementing MyHashMap except for the following 
differences:
1. The elements are stored in the hash table for MyHashSet, but the entries (key/value 
pairs) are stored in the hash table for MyHashMap.
2. MySet extends java.lang.Iterable and MyHashSet implements MySet and over-
ridesiterator(). So the elements in MyHashSet are iterable.
Three constructors are provided to construct a set. You can construct a default set with the 
default capacity and load factor using the no-arg constructor (lines 26–28), a set with the 
specified capacity and a default load factor (lines 32–34), and a set with the specified capacity 
and load factor (lines 38–46).
The clear method removes all elements from the set (lines 49–52). It invokes 
removeElements(), which clears all table cells (line 190). Each table cell is a linked list 
that stores the elements with the same hash code. The removeElements() method takes 
O(capacity) time.
Thecontains(element) method checks whether the specified element is in the set by 
examining whether the designated bucket contains the element (lines 55–65). This method 
takes O(1) time.
Theadd(element) method adds a new element into the set. The method first checks if 
the element is already in the set (line 69). If so, the method returns false. The method then 
checks whether the size exceeds the load-factor threshold (line 72). If so, the program invokes 
rehash() (line 76) to increase the capacity and store elements into the new larger hash table.
The rehash() method first copies all elements in a list (line 197), doubles the capacity 
(line 198), creates a new hash table (line 199), and resets the size to 0 (line 200). The method 
then copies the elements into the new larger hash table (lines 202–204). The rehash method 
takes O(capacity) time. If no rehash is performed, the add method takes O(1) time to add a 
new element.
Theremove(element) method removes the specified element in the set (lines 95–114). 
This method takes O(1) time.
Thesize() method simply returns the number of elements in the set (lines 122–124). This 
method takes O(1) time.
The iterator() method returns an instance of java.util.Iterator. The 
MyHashSetIterator class implements java.util.Iterator to create a forward iterator. 
When a MyHashSetIterator is constructed, it copies all the elements in the set to a list 
toString
MyHashSet vs. MyHashMap
three constructors
clear
contains
add
rehash
remove
size
iterator
```

</details>


## PDF page 1033

<details>
<summary>Page text</summary>

```text
1010 Chapter 27 Hashing
(line 141). The variable current points to the element in the list. Initially, current is 0
(line 135), which points to the first element in the list. MyHashSetIterator implements 
the methods hasNext(), next(), and remove() in java.util.Iterator. Invoking 
hasNext() returns true if current < list.size(). Invoking next() returns the current 
element and moves current to point to the next element (line 153). Invoking remove()
removes the current element in the iterator from the set.
Thehash() method invokes the supplementalHash to ensure that the hashing is evenly 
distributed to produce an index for the hash table (lines 166–174). This method takes O(1)
time.
Table 27.2 summarizes the time complexity of the methods in MyHashSet.
hash
Methods Time
clear() O(capacity)
contains(e: E) O(1)
add(e: E) O(1)
remove(e: E) O(1)
isEmpty() O(1)
size() O(1)
iterator() O(capacity)
rehash() O(capacity)
TABLE 27.2  Time Complexities for 
Methods in MyHashSet
Listing 27.6 gives a test program that uses MyHashSet.
LISTING 27.6 TestMyHashSet.java
 1 public class TestMyHashSet {
 2 public static void main(String[] args) {
 3 // Create a MyHashSet
 4      MySet<String> set = new MyHashSet<>();
 5      set.add("Smith");
 6      set.add("Anderson");
 7      set.add("Lewis");
 8      set.add("Cook");
 9      set.add("Smith");
10
11      System.out.println("Elements in set: " + set); 
12      System.out.println("Number of elements in set: " + set.size());
13      System.out.println("Is Smith in set? " + set.contains("Smith"));
14
15      set.remove("Smith");
16      System.out.print("Names in set in uppercase are ");
17 for (String s: set) 
18        System.out.print(s.toUpperCase() + " ");
19
20      set.clear();
21      System.out.println("\nElements in set: " + set);
22    }
23  } 
create a set
add elements
display elements
set size
remove element
foreach loop
clear set
```

</details>


## PDF page 1034

<details>
<summary>Page text</summary>

```text
Chapter Summary  1011
The program creates a set using MyHashSet (line 4) and adds five elements to the set (lines 
5–9). Line 5 adds Smith and line 9 adds Smith again. Since only nonduplicate elements are 
stored in the set, Smith appears in the set only once. The set actually has four elements. The 
program displays the elements (line 11), gets its size (line 12), checks whether the set contains 
a specified element (line 13), and removes an element (line 15). Since the elements in a set 
are iterable, a foreach loop is used to traverse all elements in the set (lines 17–18). Finally, the 
program clears the set (line 20) and displays an empty set (line 21).
27.26 Why can you use a foreach loop to traverse the elements in a set?
27.27 Describe how the add(e) method is implemented in the MyHashSet class.
27.28 In Listing 27.5, the remove method in the iterator removes the current element from 
the set. It also removes the current element from the internal list (line 161):
list.remove(current); // Remove current element from the list 
Is this necessary?
27.29 Replace the code in lines 146-149 In Listing 27.5 using one statement.
✓Point✓
Check
Elements in set: [Cook, Anderson, Smith, Lewis]
Number of elements in set: 4
Is Smith in set? true
Names in set in uppercase are COOK ANDERSON LEWIS 
Elements in set: [] 
KEY TERMS
associative array 986
cluster 990
dictionary 986
double hashing 991
hash code 987
hash function 986
hash map 1004
hash set 1004
hash table 986
linear probing 989
load factor 993
open addressing 989
perfect hash function 986
polynomial hash code 988
quadratic probing 990
rehashing 993
secondary clustering 991
separate chaining 993
CHAPTER SUMMARY
1. A map is a data structure that stores entries. Each entry contains two parts: a key and a 
value. The key is also called a search key, which is used to search for the corresponding 
value. You can implement a map to obtain O(1) time complexity on searching, retrieval, 
insertion, and deletion using the hashing technique.
2. A set is a data structure that stores elements. You can use the hashing technique to imple-
ment a set to achieve O(1) time complexity on searching, insertion, and deletion for a set.
3. Hashing is a technique that retrieves the value using the index obtained from a key 
without performing a search. A typical hash function  first converts a search key to
```

</details>


## PDF page 1035

<details>
<summary>Page text</summary>

```text
1012 Chapter 27 Hashing
an integer value called a hash code, then compresses the hash code into an index to the 
hash table.
4. A collision occurs when two keys are mapped to the same index in a hash table. Gener-
ally, there are two ways for handling collisions: open addressing and separate chaining.
5. Open addressing is the process of finding an open location in the hash table in the event 
of collision. Open addressing has several variations: linear probing, quadratic probing,
and double hashing.
6. The separate chaining  scheme places all entries with the same hash index into the 
same location, rather than finding new locations. Each location in the separate chaining 
scheme is called a bucket. A bucket is a container that holds multiple entries.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
**27.1 (ImplementMyMap using open addressing with linear probing) Create a new con-
crete class that implements MyMap using open addressing with linear probing. 
For simplicity, use f(key) = key % size  as the hash function, where size is 
the hash-table size. Initially, the hash-table size is 4. The table size is doubled 
whenever the load factor exceeds the threshold (0.5).
**27.2 (ImplementMyMap using open addressing with quadratic probing) Create a new 
concrete class that implements MyMap using open addressing with quadratic 
probing. For simplicity, use f(key) = key % size as the hash function, where 
size is the hash-table size. Initially, the hash-table size is 4. The table size is 
doubled whenever the load factor exceeds the threshold (0.5).
**27.3 (Implement MyMap using open addressing with double hashing ) Create a new 
concrete class that implements MyMap using open addressing with double hash-
ing. For simplicity, use f(key) = key % size  as the hash function, where 
size is the hash-table size. Initially, the hash-table size is 4. The table size is 
doubled whenever the load factor exceeds the threshold (0.5).
**27.4 (Modify MyHashMap with duplicate keys ) Modify MyHashMap to allow dupli-
cate keys for entries. You need to modify the implementation for the put(key,
value) method. Also add a new method named getAll(key) that returns a set 
of values that match the key in the map.
**27.5 (Implement MyHashSet using MyHashMap) Implement MyHashSet using 
MyHashMap. Note that you can create entries with (key,key ), rather than (key,
value).
**27.6 (Animate linear probing) Write a program that animates linear probing, as shown 
in Figure 27.3. You can change the initial size of the hash-table in the program. 
Assume the load-factor threshold is 0.75.
**27.7 (Animate separate chaining ) Write a program that animates MyHashMap, as 
shown in Figure 27.8. You can change the initial size of the table. Assume the 
load-factor threshold is0.75.
```

</details>


## PDF page 1036

<details>
<summary>Page text</summary>

```text
Programming Exercises  1013
**27.8 (Animate quadratic probing) Write a program that animates quadratic probing, 
as shown in Figure 27.5. You can change the initial size of the hash-table in pro-
gram. Assume the load-factor threshold is 0.75.
**27.9 (Implement hashCode for string ) Write a method that returns a hash code for 
string using the approach described in Section 27.3.2 with b value 31. The func-
tion header is as follows:
public static int hashCodeForString(String s)
**27.10 (CompareMyHashSet andMyArrayList)MyArrayList is defined in Listing 
24.3. Write a program that generates 1000000 random double values between 0
and999999 and stores them in a MyArrayList and in a MyHashSet. Generate 
a list of 1000000 random double values between 0 and 1999999. For each num-
ber in the list, test if it is in the array list and in the hash set. Run your program to 
display the total test time for the array list and for the hash set.
**27.11 (setToList) Write the following method that returns an ArrayList from a set.
public static <E> ArrayList<E> setToList(Set<E> s)
```

</details>


## PDF page 1037

<details>
<summary>Page text</summary>

```text
This page intentionally left blank
```

</details>
