# Chapter 23 Sorting

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 884

<details>
<summary>Page text</summary>

```text
SORTING
Objectives
■ To study and analyze time complexity of various sorting algorithms 
(§§23.2–23.7).
■ To design, implement, and analyze insertion sort (§23.2).
■ To design, implement, and analyze bubble sort (§23.3).
■ To design, implement, and analyze merge sort (§23.4).
■ To design, implement, and analyze quick sort (§23.5).
■ To design and implement a binary heap (§23.6).
■ To design, implement, and analyze heap sort (§23.6).
■ To design, implement, and analyze bucket sort and radix sort (§23.7).
■ To design, implement, and analyze external sort for files that have a 
large amount of data (§23.8).
CHAPTER
23
```

</details>


## PDF page 885

<details>
<summary>Page text</summary>

```text
862 Chapter 23 Sorting
23.1 Introduction
Sorting algorithms are good examples for studying algorithm design and analysis.
When presidential candidate Barack Obama visited Google in 2007, Google CEO Eric 
Schmidt asked Obama the most efficient way to sort a million 32-bit integers ( www.youtube
.com/watch?v=k4RRi_ntQc8). Obama answered that the bubble sort would be the wrong way to 
go. Was he right? We will examine different sorting algorithms in this chapter and see if he 
was correct.
Sorting is a classic subject in computer science. There are three reasons to study sorting 
algorithms.
 ■ First, sorting algorithms illustrate many creative approaches to problem solving, and 
these approaches can be applied to solve other problems.
 ■ Second, sorting algorithms are good for practicing fundamental programming tech-
niques using selection statements, loops, methods, and arrays.
 ■ Third, sorting algorithms are excellent examples to demonstrate algorithm 
performance.
The data to be sorted might be integers, doubles, characters, or objects. Section 7.11, Sorting 
Arrays, presented selection sort. The selection sort algorithm was extended to sort an array of 
objects in Section 19.5, Case Study: Sorting an Array of Objects. The Java API contains several 
overloaded sort methods for sorting primitive type values and objects in the java.util.Arrays
andjava.util.Collections classes. For simplicity, this chapter assumes:
1. data to be sorted are integers,
2. data are stored in an array, and
3. data are sorted in ascending order.
The programs can be easily modified to sort other types of data, to sort in descending order, 
or to sort data in an ArrayList or a LinkedList.
There are many algorithms for sorting. You have already learned selection sort. This chap-
ter introduces insertion sort, bubble sort, merge sort, quick sort, bucket sort, radix sort, and 
external sort.
23.2 Insertion Sort
The insertion-sort algorithm sorts a list of values by repeatedly inserting a new 
element into a sorted sublist until the whole list is sorted.
Figure 23.1 shows how to sort the list {2,9,5,4,8,1,6} using insertion sort.
The algorithm can be described as follows:
for (int i = 1; i < list.length; i++) {
  insert list[i] into a sorted sublist list[0..i-1] so that 
  list[0..i] is sorted.
}
To insert list[i] into list[0..i-1], save list[i] into a temporary variable, say 
currentElement. Move list[i-1] to list[i] if list[i-1] > currentElement,
move list[i-2] to list[i-1] if list[i-2] > currentElement, and so on, until 
list[i-k] <= currentElement or k>i  (we pass the first element of the sorted list). 
AssigncurrentElement to list[i-k+1]. For example, to insert 4 into {2,5,9} in Step 
4 in Figure 23.2, move list[2] (9) to list[3] since 9>4 , and move list[1] (5) to 
list[2] since 5 > 4. Finally, move currentElement (4) to list[1].
Key
Point
why study sorting?
what data to sort?
Key
Point
insertion sort animation on 
Companion Website
```

</details>


## PDF page 886

<details>
<summary>Page text</summary>

```text
23.2 Insertion Sort  863
The algorithm can be expanded and implemented as in Listing 23.1.
LISTING 23.1 InsertionSort.java
 1 public class InsertionSort {
 2 /** The method for sorting the numbers */
 3 public static void insertionSort(int[] list) {
 4 for (int i = 1; i < list.length; i++) {
 5 /** Insert list[i] into a sorted sublist list[0..i-1] so that
 6             list[0..i] is sorted. */
 7 int currentElement = list[i];
 8 int k;
 9 for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
10          list[k + 1] = list[k];
shift
FIGURE 23.1 Insertion sort repeatedly inserts a new element into a sorted sublist.
Step 1: Initially, the sorted sublist contains the
first element in the list. Insert 9 into the sublist.
Step 2: The sorted sublist is {2, 9}. Insert 5 into
the sublist.
Step 3: The sorted sublist is {2, 5, 9}. Insert 4
into the sublist.
Step 4: The sorted sublist is {2, 4, 5, 9}. Insert 8
into the sublist.
Step 5: The sorted sublist is {2, 4, 5, 8, 9}.
Insert 1 into the sublist.
Step 6: The sorted sublist is {1, 2, 4, 5, 8, 9}.
Insert 6 into the sublist.
Step 7: The entire list is now sorted.
2
2
2
2
2
1
1
9
9
5
4
4
2
2
5
5
9
5
5
4
4
4
4
4
9
8
5
5
8
8
8
8
9
8
6
1
1
1
1
1
9
8
6
6
6
6
6
6
9
FIGURE 23.2 A new element is inserted into a sorted sublist.
[0][1][2][3][4][5]
2list 594
[6]
[0][1][2][3][4][5]
2list 459
[6]
[6][0][1][2][3][4][5]
[6][0][1][2][3][4][5]
2list 59
25 9list
Step 1: Save 4 to a temporary variable currentElement
currentElement: 4
Step 2: Movelist[2] tolist[3]
Step 3: Movelist[1] tolist[2]
Step 4: AssigncurrentElement tolist[1]
```

</details>


## PDF page 887

<details>
<summary>Page text</summary>

```text
864 Chapter 23 Sorting
11        }
12
13 // Insert the current element into list[k + 1]
14 list[k + 1] = currentElement;
15      }
16    }
17  }
TheinsertionSort(int[] list) method sorts any array of int elements. The method 
is implemented with a nested for loop. The outer loop (with the loop control variable i) (line 
4) is iterated in order to obtain a sorted sublist, which ranges from list[0] to list[i]. The 
inner loop (with the loop control variable k) inserts list[i] into the sublist from list[0]
tolist[i-1].
To better understand this method, trace it with the following statements:
int[] list = {1, 9, 4, 6, 5, -4};
InsertionSort.insertionSort(list);
The insertion sort algorithm presented here sorts a list of elements by repeatedly inserting a 
new element into a sorted partial array until the whole array is sorted. At the kth iteration, to 
insert an element into an array of size k, it may take k comparisons to find the insertion posi-
tion, and k moves to insert the element. Let T(n) denote the complexity for insertion sort and 
c denote the total number of other operations such as assignments and additional comparisons 
in each iteration. Thus,
T(n) = (2 + c) + (2 * 2 + c) + g + (2 * (n - 1) + c)
= 2(1 + 2 + g + n - 1) + c(n - 1)
= 2 (n - 1)n2 + cn - c = n2 - n + cn - c
= O(n2)
Therefore, the complexity of the insertion sort algorithm is O(n2). Hence, the selection sort 
and insertion sort are of the same time complexity.
23.1 Describe how an insertion sort works. What is the time complexity for an insertion 
sort?
23.2 Use Figure 23.1 as an example to show how to apply a bubble sort on {45, 11, 50, 59, 
60, 2, 4, 7, 10}.
23.3 If a list is already sorted, how many comparisons will the insertionSort method 
perform?
23.3 Bubble Sort
A bubble sort sorts the array in multiple phases. Each pass successively swaps the 
neighboring elements if the elements are not in order.
The bubble sort algorithm makes several passes through the array. On each pass, successive 
neighboring pairs are compared. If a pair is in decreasing order, its values are swapped; oth-
erwise, the values remain unchanged. The technique is called a bubble sort or sinking sort,
because the smaller values gradually “bubble” their way to the top and the larger values sink 
to the bottom. After the first pass, the last element becomes the largest in the array. After the 
second pass, the second-to-last element becomes the second largest in the array. This process 
is continued until all elements are sorted.
insert
insertion sort time complexity
✓Point✓
Check
Key
Point
bubble sort
```

</details>


## PDF page 888

<details>
<summary>Page text</summary>

```text
23.3 Bubble Sort  865
Figure 23.3a shows the first pass of a bubble sort on an array of six elements (2 9 5 4 8 1). 
Compare the elements in the first pair (2 and 9), and no swap is needed because they are already 
in order. Compare the elements in the second pair (9 and 5), and swap 9 with 5 because 9 is 
greater than 5. Compare the elements in the third pair (9 and 4), and swap 9 with 4. Compare 
the elements in the fourth pair (9 and 8), and swap 9 with 8. Compare the elements in the fifth 
pair (9 and 1), and swap 9 with 1. The pairs being compared are highlighted and the numbers 
already sorted are italicized in Figure 23.3.
bubble sort illustration
bubble sort on the 
Companion Website
FIGURE 23.3 Each pass compares and orders the pairs of elements sequentially.
(a) 1st pass (b) 2nd pass (c) 3rd pass (d) 4th pass (e) 5th pass
2 5 9 4 8 1
248 159
249 158
241 958
258 194
25 8941
25 8941
21 894 5
2 48 91 5
21 894 5 148 925241 958
2 4 5 8 1 9
2 4 5 8 1 9
2 4 5 1 8 9
The first pass places the largest number (9) as the last in the array. In the second pass, as 
shown in Figure 23.3b, you compare and order pairs of elements sequentially. There is no 
need to consider the last pair, because the last element in the array is already the largest. In the 
third pass, as shown in Figure 23.3c, you compare and order pairs of elements sequentially 
except the last two elements, because they are already in order. So in the kth pass, you don’t 
need to consider the last k - 1 elements, because they are already ordered.
The algorithm for a bubble sort is described in Listing 23.2.
LISTING 23.2 Bubble Sort Algorithm
1 for (int k = 1; k < list.length; k++) {
2 // Perform the kth pass
3 for (int i = 0; i < list.length - k; i++) {
4 if (list[i] > list[i + 1])
5        swap list[i] with list[i + 1];
6    }
7  }
Note that if no swap takes place in a pass, there is no need to perform the next pass, because all 
the elements are already sorted. You can use this property to improve the algorithm in Listing 
23.2 as in Listing 23.3.
LISTING 23.3 Improved Bubble Sort Algorithm
 1 boolean needNextPass = true;
 2 for (int k = 1; k < list.length && needNextPass; k++) {
 3 // Array may be sorted and next pass not needed
 4 needNextPass = false;
 5 // Perform the kth pass
 6 for (int i = 0; i < list.length – k; i++) {
 7 if (list[i] > list[i + 1]) {
 8        swap list[i] with list[i + 1];
 9 needNextPass = true; // Next pass still needed
10      }
11    }
12  }
algorithm
```

</details>


## PDF page 889

<details>
<summary>Page text</summary>

```text
866 Chapter 23 Sorting
The algorithm can be implemented in Listing 23.4.
LISTING 23.4 BubbleSort.java
 1 public class BubbleSort {
 2 /** Bubble sort method */
 3 public static void bubbleSort(int[] list) {
 4 boolean needNextPass = true;
 5
 6 for (int k = 1; k < list.length && needNextPass; k++) {
 7 // Array may be sorted and next pass not needed
 8        needNextPass = false;
 9 for (int i = 0; i < list.length - k; i++) {
10 if (list[i] > list[i + 1]) {
11 // Swap list[i] with list[i + 1]
12 int temp = list[i];
13            list[i] = list[i + 1];
14            list[i + 1] = temp;
15
16            needNextPass = true; // Next pass still needed
17          }
18        }
19      }
20    }
21
22 /** A test method */
23 public static void main(String[] args) {
24 int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
25 bubbleSort(list);
26 for (int i = 0; i < list.length; i++)
27        System.out.print(list[i] + " ");
28    }
29  }
perform one pass
-2 1 2 2 3 3 5 6 12 14
In the best case, the bubble sort algorithm needs just the first pass to find that the array is 
already sorted—no next pass is needed. Since the number of comparisons is n - 1 in the first 
pass, the best-case time for a bubble sort is O(n).
In the worst case, the bubble sort algorithm requires n - 1 passes. The first pass makes 
n - 1 comparisons; the second pass makes n - 2 comparisons; and so on; the last pass 
makes 1 comparison. Thus, the total number of comparisons is:
(n - 1) + (n - 2) + g + 2 + 1
= (n - 1)n2 = n22 - n2 = O(n2)
Therefore, the worst-case time for a bubble sort is O(n2).
23.4 Describe how a bubble sort works. What is the time complexity for a bubble sort?
23.5 Use Figure 23.3 as an example to show how to apply a bubble sort on {45, 11, 50, 59, 
60, 2, 4, 7, 10}. 
23.6 If a list is already sorted, how many comparisons will the bubbleSort method 
perform?
bubble sort time complexity
✓Point✓
Check
```

</details>


## PDF page 890

<details>
<summary>Page text</summary>

```text
23.4 Merge Sort  867
23.4 Merge Sort
The merge sort algorithm can be described recursively as follows: The algorithm 
divides the array into two halves and applies a merge sort on each half recursively. 
After the two halves are sorted, merge them.
The algorithm for a merge sort is given in Listing 23.5.
LISTING 23.5 Merge Sort Algorithm
1 public static void mergeSort(int[] list) {
2 if (list.length > 1) {
3      mergeSort(list[0 ... list.length / 2]);
4      mergeSort(list[list.length / 2 + 1 ... list.length]); 
5      merge list[0 ... list.length / 2] with 
6        list[list.length / 2 + 1 ... list.length];
7    }
8  }
Figure 23.4 illustrates a merge sort of an array of eight elements (2 9 5 4 8 1 6 7). The original 
array is split into (2 9 5 4) and (8 1 6 7). Apply a merge sort on these two subarrays recursively 
to split (2 9 5 4) into (2 9) and (5 4) and (8 1 6 7) into (8 1) and (6 7). This process continues 
until the subarray contains only one element. For example, array (2 9) is split into the subar-
rays (2) and (9). Since array (2) contains a single element, it cannot be further split. Now 
merge (2) with (9) into a new sorted array (2 9); merge (5) with (4) into a new sorted array 
(4 5). Merge (2 9) with (4 5) into a new sorted array (2 4 5 9), and finally merge (2 4 5 9) with 
(1 6 7 8) into a new sorted array (1 2 4 5 6 7 8 9).
Key
Point
merge sort
base condition
sort first half
sort second half
merge two halves
merge sort illustration
FIGURE 23.4 Merge sort employs a divide-and-conquer approach to sort the array.
split
split
2
split
9 5 4 8 1 6 7
merge
81 67
17 8
1 4 6789
merge
merge
divide
conquer
2 5 816794
8167
2549
29
29
2594
54
45
25
81 6 7
6
The recursive call continues dividing the array into subarrays until each subarray contains 
only one element. The algorithm then merges these small subarrays into larger sorted subar-
rays until one sorted array results.
The merge sort algorithm is implemented in Listing 23.6.
LISTING 23.6 MergeSort.java
 1 public class MergeSort {
 2 /** The method for sorting the numbers */
 3 public static void mergeSort(int[] list) {
 4 if (list.length > 1) { base case
```

</details>


## PDF page 891

<details>
<summary>Page text</summary>

```text
868 Chapter 23 Sorting
 5 // Merge sort the first half
 6 int[] firstHalf = new int[list.length / 2];
 7        System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
 8 mergeSort(firstHalf);
 9
10 // Merge sort the second half
11 int secondHalfLength = list.length - list.length / 2;
12 int[] secondHalf = new int[secondHalfLength];
13        System.arraycopy(list, list.length / 2,
14          secondHalf, 0, secondHalfLength);
15 mergeSort(secondHalf);
16
17 // Merge firstHalf with secondHalf into list
18 merge(firstHalf, secondHalf, list);
19      }
20    }
21
22 /** Merge two sorted lists */
23 public static void merge(int[] list1, int[] list2, int[] temp) {
24 int current1 = 0; // Current index in list1
25 int current2 = 0; // Current index in list2
26 int current3 = 0; // Current index in temp
27
28 while (current1 < list1.length && current2 < list2.length) {
29 if (list1[current1] < list2[current2])
30 temp[current3++] = list1[current1++];
31 else
32 temp[current3++] = list2[current2++];
33      }
34
35 while (current1 < list1.length) 
36 temp[current3++] = list1[current1++];
37
38 while (current2 < list2.length) 
39 temp[current3++] = list2[current2++];
40    }
41
42 /** A test method */
43 public static void main(String[] args) {
44 int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
45 mergeSort(list);
46 for (int i = 0; i < list.length; i++)
47        System.out.print(list[i] + " ");
48    }
49  }
The mergeSort method (lines 3–20) creates a new array firstHalf, which is a copy of 
the first half of list (line 7). The algorithm invokes mergeSort recursively on firstHalf
(line 8). The length of the firstHalf is list.length/2  and the length of the secondHalf
islist.length - list.length / 2. The new array secondHalf was created to contain 
the second part of the original array list. The algorithm invokes mergeSort recursively on 
secondHalf (line 15). After firstHalf and secondHalf are sorted, they are merged to 
list (line 18). Thus, array list is now sorted.
The merge method (lines 23–40) merges two sorted arrays list1 and list2 into array 
temp.current1 and current2 point to the current element to be considered in list1 and 
list2 (lines 24–26). The method repeatedly compares the current elements from list1
and list2 and moves the smaller one to temp. current1 is increased by 1 (line 30) if 
the smaller one is in list1 and current2 is increased by 1 (line 32) if the smaller one is 
sort first half
sort second half
merge two halves
list1 to temp
list2 to temp
rest of list1 to temp
rest of list2 to temp
```

</details>


## PDF page 892

<details>
<summary>Page text</summary>

```text
23.4 Merge Sort  869
in list2. Finally, all the elements in one of the lists are moved to temp. If there are still 
unmoved elements in list1, copy them to temp (lines 35–36). If there are still unmoved ele-
ments in list2, copy them to temp (lines 38–39).
Figure 23.5 illustrates how to merge the two arrays list1 (2 4 5 9) and list2 (1 6 7 8). 
Initially the current elements to be considered in the arrays are 2 and 1. Compare them and 
move the smaller element 1 to temp, as shown in Figure 23.5a. current2 and current3
are increased by 1. Continue to compare the current elements in the two arrays and move the 
smaller one to temp until one of the arrays is completely moved. As shown in Figure 23.5b, 
all the elements in list2 are moved to temp and current1 points to element 9 in list1.
Copy 9 to temp, as shown in Figure 23.5c.
merge animation on 
Companion Website
FIGURE 23.5 Two sorted arrays are merged into one sorted array.
(a) After moving 1 to temp
25 9
current1 current2
current3
4 17 86
1
current1 current2
current3
25
5
94
4
17
7
8
8
6
612
current1 current2
25 9
current3
4 17 86
547 8 9 612
 (b) After moving all the
elements in list2 to temp
 (c) After moving 9 to
temp
FIGURE 23.6 Temporary arrays are created to support a merge sort.
(a)
Divide Copy second halfCopy first half
Merge to list
Recursive sort
Merge
secondHalf
(temporary array)
firstHalf
(temporary array)
New sorted list
Original list
(b)
Divide
Copy this to the
original list
Recursively sort
Merge
Sort second half of
the original array
Sort first half of
the original array
New sorted temporary list
Original list
The mergeSort method creates two temporary arrays (lines 6, 12) during the divid-
ing process, copies the first half and the second half of the array into the temporary arrays 
(lines 7, 13), sorts the temporary arrays (lines 8, 15), and then merges them into the original 
array (line 18), as shown in Figure 23.6a. You can rewrite the code to recursively sort the first 
half of the array and the second half of the array without creating new temporary arrays, and 
then merge the two arrays into a temporary array and copy its contents to the original array, as 
shown in Figure 23.6b. This is left for you to do in Programming Exercise 23.20.
Note
A merge sort can be implemented efficiently using parallel processing. See Section 30.16, 
Parallel Programming, for a parallel implementation of a merge sort.
```

</details>


## PDF page 893

<details>
<summary>Page text</summary>

```text
870 Chapter 23 Sorting
Let T(n) denote the time required for sorting an array of n elements using a merge sort. With-
out loss of generality, assume n is a power of 2. The merge sort algorithm splits the array into 
two subarrays, sorts the subarrays using the same algorithm recursively, and then merges the 
subarrays. Therefore,
T(n) = T¢ n2≤ + T¢ n2≤ + mergetime
The first T¢ n2≤ is the time for sorting the first half of the array, and the second T¢ n2≤ is the
time for sorting the second half. To merge two subarrays, it takes at most n - 1 comparisons 
to compare the elements from the two subarrays and n moves to move elements to the tempo-
rary array. Thus, the total time is 2n - 1. Therefore,
T(n) = T¢ n2≤ + T¢ n2≤ + 2n - 1 = O(n logn)
The complexity of a merge sort is O(n logn). This algorithm is better than selection sort, insertion 
sort, and bubble sort, because the time complexity of these algorithms is O(n2). The sort method 
in the java.util.Arrays class is implemented using a variation of the merge sort algorithm.
23.7 Describe how a merge sort works. What is the time complexity for a merge sort?
23.8 Use Figure 23.4 as an example to show how to apply a merge sort on {45, 11, 50, 59, 
60, 2, 4, 7, 10}. 
23.9 What is wrong if lines 6–15 in Listing 23.6, MergeSort.java, are replaced by the fol-
lowing code?
// Merge sort the first half
int[] firstHalf = new int[list.length / 2 + 1];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2 + 1);
      mergeSort(firstHalf);
// Merge sort the second half
int secondHalfLength = list.length - list.length / 2 - 1;
int[] secondHalf = new int[secondHalfLength];
      System.arraycopy(list, list.length / 2 + 1,
        secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);
23.5 Quick Sort
A quick sort works as follows: The algorithm selects an element, called the pivot, in 
the array. It divides the array into two parts, so that all the elements in the first part 
are less than or equal to the pivot and all the elements in the second part are greater 
than the pivot. The quick sort algorithm is then recursively applied to the first part and 
then the second part.
The quick sort algorithm, developed by C.A.R. Hoare in 1962, is described in Listing 23.7.
LISTING 23.7 Quick Sort Algorithm
 1 public static void quickSort(int[] list) {
 2 if (list.length > 1) {
 3      select a pivot; 
4      partition list into list1 and list2 such that 
merge sort time complexity
O(n logn) merge sort
✓Point✓
Check
Key
Point
quick sort
base condition
select the pivot
partition the list
```

</details>


## PDF page 894

<details>
<summary>Page text</summary>

```text
23.5 Quick Sort  871
list2
pivot
list1
 5        all elements in list1 <= pivot and 
 6        all elements in list2 > pivot;
 7      quickSort(list1); 
 8      quickSort(list2); 
 9    }
10  }
Each partition places the pivot in the right place. The selection of the pivot affects the perfor-
mance of the algorithm. Ideally, the algorithm should choose the pivot that divides the two 
parts evenly. For simplicity, assume the first element in the array is chosen as the pivot. (Pro-
gramming Exercise 23.4 proposes an alternative strategy for selecting the pivot.)
Figure 23.7 illustrates how to sort an array (5 2 9 3 8 4 0 1 6 7) using quick sort. Choose the 
first element, 5, as the pivot. The array is partitioned into two parts, as shown in Figure 23.7b. 
The highlighted pivot is placed in the right place in the array. Apply quick sort on two partial 
arrays (4 2 1 3 0) and then (8 9 6 7). The pivot 4 partitions (4 2 1 3 0) into just one partial array 
(0 2 1 3), as shown in Figure 23.7c. Apply quick sort on (0 2 1 3). The pivot 0 partitions it into 
just one partial array (2 1 3), as shown in Figure 23.7d. Apply quick sort on (2 1 3). The pivot 
2 partitions it into (1) and (3), as shown in Figure 23.7e. Apply quick sort on (1). Since the 
array contains just one element, no further partition is needed.
sort first part
sort second part
how to partition
quick sort illustration
FIGURE 23.7 The quick sort algorithm is recursively applied to partial arrays.
(a) The original array
pivot
57 61048392
(b) The original array is partitioned
pivotpivot
47 69850312
(d) The partial array (0 2 1 3) is
      partitioned
pivot
0213
(e) The partial array (2 1 3) is
      partitioned123
(c) The partial array (4 2 1 3 0) is
      partitioned
pivot
02134
The quick sort algorithm is implemented in Listing 23.8. There are two overloaded 
quickSort methods in the class. The first method (line 2) is used to sort an array. The second 
is a helper method (line 6) that sorts a partial array with a specified range.
LISTING 23.8 QuickSort.java
 1 public class QuickSort {
 2 public static void quickSort(int[] list) {
 3      quickSort(list, 0, list.length - 1);
 4    }
 5
 6 public static void quickSort(int[] list, int first, int last) {
 7 if (last > first) {
 8 int pivotIndex = partition(list, first, last);
 9        quickSort(list, first, pivotIndex - 1);
10        quickSort(list, pivotIndex + 1, last);
11      }
sort method
helper method
recursive call
```

</details>


## PDF page 895

<details>
<summary>Page text</summary>

```text
872 Chapter 23 Sorting
12    }
13
14 /** Partition the array list[first..last] */
15 public static int partition(int[] list, int first, int last) {
16 int pivot = list[first]; // Choose the first element as the pivot
17 int low = first + 1; // Index for forward search
18 int high = last; // Index for backward search
19
20 while (high > low) {
21 // Search forward from left
22 while (low <= high && list[low] <= pivot) 
23 low++;
24
25 // Search backward from right
26 while (low <= high && list[high] > pivot) 
27 high--;
28
29 // Swap two elements in the list
30 if (high > low) {
31 int temp = list[high]; 
32 list[high] = list[low];
33          list[low] = temp;
34        }
35      }
36
37 while (high > first && list[high] >= pivot)
38        high--;
39
40 // Swap pivot with list[high]
41 if (pivot > list[high]) {
42        list[first] = list[high];
43        list[high] = pivot; 
44 return high;
45      }
46 else {
47 return first;
48      }
49    }
50
51 /** A test method */
52 public static void main(String[] args) {
53 int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
54      quickSort(list);
55 for (int i = 0; i < list.length; i++)
56        System.out.print(list[i] + " ");
57    }
58  }
forward
backward
swap
place pivot
pivot’s new index
pivot’s original index
-2 1 2 2 3 3 5 6 12 14
The partition method (lines 15–49) partitions the array list[first..last] using the 
pivot. The first element in the partial array is chosen as the pivot (line 16). Initially low points 
to the second element in the partial array (line 17) and high points to the last element in the 
partial array (line 18).
Starting from the left, the method searches forward in the array for the first element that is 
greater than the pivot (lines 22–23), then searches from the right backward for the first ele-
ment in the array that is less than or equal to the pivot (lines 26–27). It then swaps these two
```

</details>


## PDF page 896

<details>
<summary>Page text</summary>

```text
23.5 Quick Sort  873
elements and repeats the same search and swap operations until all the elements are searched 
in a while loop (lines 20–35).
The method returns the new index for the pivot that divides the partial array into two parts if 
the pivot has been moved (line 44). Otherwise, it returns the original index for the pivot (line 47).
Figure 23.8 illustrates how to partition an array (5 2 9 3 8 4 0 1 6 7). Choose the first ele-
ment, 5, as the pivot. Initially low is the index that points to element 2 and high points to ele-
ment 7, as shown in Figure 23.8a. Advance index low forward to search for the first element 
(9) that is greater than the pivot and move index high backward to search for the first element 
(1) that is less than or equal to the pivot, as shown in Figure 23.8b. Swap 9 with 1, as shown 
in Figure 23.8c. Continue the search and move low to point to element 8 and high to point 
to element 0, as shown in Figure 23.8d. Swap element 8 with 0, as shown in Figure 23.8e. 
Continue to move low until it passes high, as shown in Figure 23.8f. Now all the elements 
are examined. Swap the pivot with element 4 at index high. The final partition is shown in 
Figure 23.8g. The index of the pivot is returned when the method is finished. 
partition illustration
partition animation on 
Companion Website
FIGURE 23.8 Thepartition method returns the index of the pivot after it is put in the cor-
rect place.
5
pivot low high
(b) Search forward and backward
The index of the pivot is returned
293840167
5
pivot low high
(a) Initialize pivot, low, and high293840167
5
pivot low high
(c) 9 is swapped with 1213840967
5
pivot low high
(d) Continue search213840967
5
pivot low high
(e) 8 is swapped with 0213048967
5
pivot low high
(f) When high < low, search is over213048967
4
pivot
(g) Pivot is in the right place213058967
To partition an array of n elements, it takes n comparisons and n moves in the worst case. 
Thus, the time required for partition is O(n).
In the worst case, the pivot divides the array each time into one big subarray with the other 
array empty. The size of the big subarray is one less than the one before divided. The algo-
rithm requires (n - 1) + (n - 2) + g + 2 + 1 = O(n2) time.
O(n) partition time
O(n2) worst-case time
```

</details>


## PDF page 897

<details>
<summary>Page text</summary>

```text
874 Chapter 23 Sorting
In the best case, the pivot divides the array each time into two parts of about the same size. 
Let T(n) denote the time required for sorting an array of n elements using quick sort. Thus,
recursive quick sort on partition time 
two subarrays
O(n logn) best-case time
FIGURE 23.9 A binary heap is a special complete binary tree.
(a) A heap (b) (c) (d)
22 29
32
39
14
42
22
32
42
14 3322 29
32
42
14 33
39 39
22 29
32
42
Similar to the merge sort analysis, T(n) = O(n logn).
On the average, the pivot will not divide the array into two parts of the same size or one 
empty part each time. Statistically, the sizes of the two parts are very close. Therefore, the 
average time is O(n logn). The exact average-case analysis is beyond the scope of this book.
Both merge sort and quick sort employ the divide-and-conquer approach. For merge sort, 
the bulk of the work is to merge two sublists, which takes place after the sublists are sorted. 
For quick sort, the bulk of the work is to partition the list into two sublists, which takes place 
before the sublists are sorted. Merge sort is more efficient than quick sort in the worst case, 
but the two are equally efficient in the average case. Merge sort requires a temporary array 
for sorting two subarrays. Quick sort does not need additional array space. Thus, quick sort is 
more space efficient than merge sort.
23.10 Describe how quick sort works. What is the time complexity for a quick sort?
23.11 Why is quick sort more space efficient than merge sort?
23.12 Use Figure    23.7 as an example to show how to apply a quick sort on 
{45, 11, 50, 59, 60, 2, 4, 7, 10}.
23.6 Heap Sort
A heap sort uses a binary heap. It first adds all the elements to a heap and then 
removes the largest elements successively to obtain a sorted list.
Heap sorts use a binary heap, which is a complete binary tree. A binary tree is a hierarchical 
structure. It either is empty or it consists of an element, called the root, and two distinct binary 
trees, called the left subtree and right subtree. The length of a path is the number of the edges 
in the path. The depth of a node is the length of the path from the root to the node.
A binary heap is a binary tree with the following properties:
 ■ Shape property: It is a complete binary tree.
 ■ Heap property: Each node is greater than or equal to any of its children.
A binary tree is complete if each of its levels is full, except that the last level may not be full 
and all the leaves on the last level are placed leftmost. For example, in Figure 23.9, the binary 
trees in (a) and (b) are complete, but the binary trees in (c) and (d) are not complete. Further, 
the binary tree in (a) is a heap, but the binary tree in (b) is not a heap, because the root (39) is 
less than its right child (42).
O(n logn) average-case time
quick sort vs. merge sort
✓Point✓
Check
Key
Point
heap sort
root
left subtree
right subtree
length
depth
complete binary tree
T(n) = T¢ n2≤ + T¢ n2≤ + n.
```

</details>


## PDF page 898

<details>
<summary>Page text</summary>

```text
23.6 Heap Sort  875
Note
Heap is a term with many meanings in computer science. In this chapter, heap means 
a binary heap. 
Pedagogical Note
A heap can be implemented efficiently for inserting keys and for deleting the root. For an 
interactive demo on how a heap works, go to www.cs.armstrong.edu/liang/animation/web/
Heap.html, as shown in Figure 23.10.
heap
heap animation on 
Companion Website
FIGURE 23.10 The heap animation tool enables you to insert a key and delete the root visually.
FIGURE 23.11 A binary heap can be implemented using an array.
22 29
32
42
62
14 33
39
30 17
44
59
9
13
(a) A heap
62
[0]
42 59 32 39 44 13 22 29 14 33 30 17
[12]
9
[13][11][10][9][8][7][6][5][4][3][2][1]
(b) A heap stored in an array
parent left
right
23.6.1 Storing a Heap
A heap can be stored in an ArrayList or an array if the heap size is known in advance. The 
heap in Figure 23.11a can be stored using the array in Figure 23.11b. The root is at position 0, 
and its two children are at positions 1 and 2. For a node at position i, its left child is at position 
2i + 1, its right child is at position 2i + 2, and its parent is (i - 1)/2. For example, the node 
for element 39 is at position 4, so its left child (element 14) is at 9 (2 * 4 + 1), its right child 
(element 33) is at 10 (2 * 4 + 2), and its parent (element 42) is at 1 ((4 - 1)/2).
23.6.2 Adding a New Node
To add a new node to the heap, first add it to the end of the heap and then rebuild the tree as follows:
Let the last node be the current node;
while (the current node is greater than its parent) {
```

</details>


## PDF page 899

<details>
<summary>Page text</summary>

```text
876 Chapter 23 Sorting
  Swap the current node with its parent;
  Now the current node is one level up;
}
Suppose a heap is initially empty. That heap is shown in Figure 23.12, after adding numbers 
3, 5, 1, 19, 11, and 22 in this order.
FIGURE 23.12 Elements 3, 5, 1, 19, 11, and 22 are inserted into the heap.
(a) After adding 3 (b) After adding 5 (c) After adding 1
(d) After adding 19 (e) After adding 11 (f) After adding 22
3
5
19
1
35
11
19
1
35
11
22
1
19
3
3
5
3
5
1
FIGURE 23.13 Rebuild the heap after adding a new node.
(a) Add 88 to a heap (b) After swapping 88 with 19 (c) After swapping 88 with 22
11
22
19
1 8835 35
11
22
11 9
88
11 935
11
88
22
Now consider adding 88 into the heap. Place the new node 88 at the end of the tree, as shown 
in Figure 23.13a. Swap 88 with 19, as shown in Figure 23.13b. Swap 88 with 22, as shown in 
Figure 23.13c.
23.6.3 Removing the Root
Often you need to remove the maximum element, which is the root in a heap. After the root is 
removed, the tree must be rebuilt to maintain the heap property. The algorithm for rebuilding 
the tree can be described as follows:
Move the last node to replace the root;
Let the root be the current node;
while (the current node has children and the current node is 
       smaller than one of its children) {
  Swap the current node with the larger of its children;
  Now the current node is one level down;
}
Figure 23.14 shows the process of rebuilding a heap after the root 62 is removed from 
Figure 23.11a. Move the last node, 9, to the root, as shown in Figure 23.14a. Swap 9 with 59, 
as shown in Figure 23.14b; swap 9 with 44, as shown in Figure 23.14c; and swap 9 with 30, 
as shown in Figure 23.14d.
```

</details>


## PDF page 900

<details>
<summary>Page text</summary>

```text
23.6 Heap Sort  877
Figure 23.15 shows the process of rebuilding a heap after the root, 59, is removed from 
Figure 23.14d. Move the last node, 17, to the root, as shown in Figure 23.15a. Swap 17 with 
44, as shown in Figure 23.15b, and then swap 17 with 30, as shown in Figure 23.15c.
FIGURE 23.14 Rebuild the heap after the root 62 is removed.
22 29 14 33 30 17
32 39 44 13
42 59
9
(a) After moving 9 to the root
22 29 14 33 30 17
32 39 44 13
42 9
59
(b) After swapping 9 with 59
22 29 14 33 30 17
32 39 9 13
42 44
59
(c) After swapping 9 with 44
22 29 14 33 17 9
32 39 30 13
42 44
59
(d) After swapping 9 with 30
FIGURE 23.15 Rebuild the heap after the root, 59, is removed.
(a) After moving 17 to the root (b) After swapping 17 with 44
22 29 14 33 9
32 39 30 13
42
44
17
22 29 14 33 9
32 39 13
3042
44
17
(c) After swapping 17 with 30
22 29 14 33 9
32 39 30 13
42 44
17
23.6.4 The Heap Class
Now you are ready to design and implement the Heap class. The class diagram is shown in 
Figure 23.16. Its implementation is given in Listing 23.9.
```

</details>


## PDF page 901

<details>
<summary>Page text</summary>

```text
878 Chapter 23 Sorting
LISTING 23.9 Heap.java
 1 public class Heap<E extends Comparable<E>> {
 2 private java.util.ArrayList<E> list = new java.util.ArrayList<>();
 3
 4 /** Create a default heap */
 5 public Heap() {
 6    }
 7
 8 /** Create a heap from an array of objects */
 9 public Heap(E[] objects) {
10 for (int i = 0; i < objects.length; i++)
11        add(objects[i]);
12    }
13
14 /** Add a new object into the heap */
15 public void add(E newObject) {
16      list.add(newObject); // Append to the heap
17 int currentIndex = list.size() - 1; // The index of the last node
18
19 while (currentIndex > 0) {
20 int parentIndex = (currentIndex - 1) / 2;
21 // Swap if the current object is greater than its parent
22 if (list.get(currentIndex).compareTo(
23            list.get(parentIndex)) > 0) {
24          E temp = list.get(currentIndex); 
25          list.set(currentIndex, list.get(parentIndex));
26          list.set(parentIndex, temp);
27        }
28 else
29 break; // The tree is a heap now
30
31        currentIndex = parentIndex;
32      }
33    }
34
35 /** Remove the root from the heap */
36 public E remove() {
37 if (list.size() == 0) return null;
38
39      E removedObject = list.get(0);
40      list.set(0, list.get(list.size() - 1));
41      list.remove(list.size() - 1);
42
43 int currentIndex = 0;
44 while (currentIndex < list.size()) {
internal heap representation
no-arg constructor
constructor
add a new object
append the object
swap with parent
heap now
remove the root
empty heap
root
new root
remove the last
adjust the tree
FIGURE 23.16 TheHeap class provides operations for manipulating a heap.
Heap<E extends Comparable<E>>
-list: java.util.ArrayList<E>
+Heap()
+Heap(objects: E[])
+remove(): E
+add(newObject: E): void
+getSize(): int
Creates a default empty heap.
Creates a heap with the specified objects.
Removes the root from the heap and returns it.
Adds a new object to the heap.
Returns the size of the heap.
```

</details>


## PDF page 902

<details>
<summary>Page text</summary>

```text
23.6 Heap Sort  879
45 int leftChildIndex = 2 * currentIndex + 1;
46 int rightChildIndex = 2 * currentIndex + 2;
47
48 // Find the maximum between two children
49 if (leftChildIndex >= list.size()) break; // The tree is a heap
50 int maxIndex = leftChildIndex;
51 if (rightChildIndex < list.size()) {
52 if (list.get(maxIndex).compareTo(
53              list.get(rightChildIndex)) < 0) {
54            maxIndex = rightChildIndex;
55          }
56        }
57
58 // Swap if the current node is less than the maximum 
59 if (list.get(currentIndex).compareTo(
60            list.get(maxIndex)) < 0) {
61          E temp = list.get(maxIndex); 
62 list.set(maxIndex, list.get(currentIndex));
63 list.set(currentIndex, temp);
64 currentIndex = maxIndex;
65        }
66 else
67 break; // The tree is a heap
68      }
69
70 return removedObject;
71    }
72
73 /** Get the number of nodes in the tree */
74 public int getSize() {
75 return list.size();
76    }
77  }
A heap is represented using an array list internally (line 2). You can change the array list to 
other data structures, but the Heap class contract will remain unchanged.
The add(E newObject)  method (lines 15–33) appends the object to the tree and then 
swaps the object with its parent if the object is greater than its parent. This process continues 
until the new object becomes the root or is not greater than its parent.
Theremove() method (lines 36–71) removes and returns the root. To maintain the heap 
property, the method moves the last object to the root position and swaps it with its larger 
child if it is less than the larger child. This process continues until the last object becomes a 
leaf or is not less than its children.
23.6.5 Sorting Using the Heap Class
To sort an array using a heap, first create an object using the Heap class, add all the ele-
ments to the heap using the add method, and remove all the elements from the heap using 
the remove method. The elements are removed in descending order. Listing 23.10 gives a 
program for sorting an array using a heap.
LISTING 23.10 HeapSort.java
 1 public class HeapSort {
 2 /** Heap sort method */
 3 public static <E extends Comparable<E>> void heapSort(E[] list) {
 4 // Create a Heap of integers
 5      Heap<E> heap = new Heap<>(); 
 6
compare two children
swap with the larger child
create a Heap
```

</details>


## PDF page 903

<details>
<summary>Page text</summary>

```text
880 Chapter 23 Sorting
 7 // Add elements to the heap
 8 for (int i = 0; i < list.length; i++)
 9        heap.add(list[i]); 
10
11 // Remove elements from the heap
12 for (int i = list.length - 1; i >= 0; i--)
13        list[i] = heap.remove();
14    }
15
16 /** A test method */
17 public static void main(String[] args) {
18      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
19 heapSort(list);
20 for (int i = 0; i < list.length; i++)
21        System.out.print(list[i] + " ");
22    }
23  }
add element
remove element
invoke sort method
-44 -5 -4 -3 0 1 1 2 3 3 4 5 53 
23.6.6 Heap Sort Time Complexity
Let us turn our attention to analyzing the time complexity for the heap sort. Let h denote the 
height for a heap of n elements. The height of a heap is the number of nodes in the longest path 
from the root to a leaf node. Since a heap is a complete binary tree, the first level has 1 node, 
the second level has 2 nodes, the kth level has 2k - 1 nodes, the (h - 1) level has 2h - 2 nodes, 
and the hth level has at least 1 and at most 2h - 1 nodes. Therefore,
1 + 2 + g + 2h - 2 6 n … 1 + 2 + g + 2h - 2 + 2h - 1
That is,
2h - 1 - 1 6 n … 2h - 1
2h - 1 6 n + 1 … 2h
h - 1 6 log(n + 1) … h
Thus, h 6 log(n + 1) + 1 and log( n + 1) … h. Therefore, log( n + 1) … h 6
log(n + 1) + 1. Hence, the height of the heap is O(logn).
Since the add method traces a path from a leaf to a root, it takes at most h steps to add a 
new element to the heap. Thus, the total time for constructing an initial heap is O(n logn) for 
an array of n elements. Since the remove method traces a path from a root to a leaf, it takes 
at most h steps to rebuild a heap after removing the root from the heap. Since the remove
method is invoked n times, the total time for producing a sorted array from a heap is O(n logn).
Both merge sorts and heap sorts require O(n logn) time. A merge sort requires a temporary 
array for merging two subarrays; a heap sort does not need additional array space. Therefore, 
a heap sort is more space efficient than a merge sort.
23.13 What is a complete binary tree? What is a heap? Describe how to remove the root 
from a heap and how to add a new object to a heap.
23.14 What is the return value from invoking the remove method if the heap is empty?
23.15 Add the elements 4,5,1,2,9, and 3 into a heap in this order. Draw the diagrams to 
show the heap after each element is added.
23.16 Show the heap after the root in the heap in Figure 23.15c is removed.
23.17 What is the time complexity of inserting a new element into a heap and what is the 
time complexity of deleting an element from a heap?
height of a heap
O(n logn) worst-case time
heap sort vs. merge sort
✓Point✓
Check
```

</details>


## PDF page 904

<details>
<summary>Page text</summary>

```text
23.7 Bucket Sort and Radix Sort  881
23.18 Show the steps of creating a heap using {45, 11, 50, 59, 60, 2, 4, 7, 10}.
23.19 Given the following heap, show the steps of removing all nodes from the heap.
22 29
32
42
62
14 33
39
17 30
44
59
9
13
23.20 Which of the following statements are wrong?
1  Heap<Object> heap1 = new Heap<>();
2  Heap<Number> heap2 = new Heap<>();
3  Heap<BigInteger> heap3 = new Heap<>();
4  Heap<Calendar> heap4 = new Heap<>();
5  Heap<String> heap5 = new Heap<>();
23.7 Bucket Sort and Radix Sort
Bucket sorts and radix sorts are efficient for sorting integers.
All sort algorithms discussed so far are general sorting algorithms that work for any types of 
keys (e.g., integers, strings, and any comparable objects). These algorithms sort the elements 
by comparing their keys. It has been proven that no sorting algorithms based on comparisons 
can perform better than O(n logn). However, if the keys are integers, you can use a bucket sort 
without having to compare the keys.
The bucket sort algorithm works as follows. Assume the keys are in the range from 0 to t.
We need t + 1 buckets labeled 0,1, . . . , and t. If an element’s key is i, the element is put 
into the bucket i. Each bucket holds the elements with the same key value.
Key
Point
bucket sort
You can use an ArrayList to implement a bucket. The bucket sort algorithm for sorting a list 
of elements can be described as follows:
void bucketSort(E[] list) {
  E[] bucket = (E[])new java.util.ArrayList[t+1];
// Distribute the elements from list to buckets
for (int i = 0; i < list.length; i++) {
int key = list[i].getKey(); // Assume element has the getKey() method
if (bucket[key] == null)
      bucket[key] = new java.util.ArrayList<>(); 
    bucket[key].add(list[i]);
  }
Elements
with key 0
bucket[0]
Elements
with key 1
bucket[1]
Elements
with key 2
bucket[2]
Elements
with key t
bucket[t]
. . .
```

</details>


## PDF page 905

<details>
<summary>Page text</summary>

```text
882 Chapter 23 Sorting
// Now move the elements from the buckets back to list
int k = 0; // k is an index for list
for (int i = 0; i < bucket.length; i++) {
if (bucket[i] != null) {
for (int j = 0; j < bucket[i].size(); j++)
        list[k++] = bucket[i].get(j);
    }
  }
}
Clearly, it takes O(n + t) time to sort the list and uses O(n + t) space, where n is the list size.
Note that if t is too large, using the bucket sort is not desirable. Instead, you can use a radix 
sort. The radix sort is based on the bucket sort, but a radix sort uses only ten buckets.
It is worthwhile to note that a bucket sort is stable, meaning that if two elements in the 
original list have the same key value, their order is not changed in the sorted list. That is, if 
element e1 and element e2 have the same key and e1 precedes e2 in the original list, e1 still 
precedes e2 in the sorted list.
Assume that the keys are positive integers. The idea for the radix sort is to divide the keys 
into subgroups based on their radix positions. It applies a bucket sort repeatedly for the key 
values on radix positions, starting from the least-significant position.
Consider sorting the elements with the following keys:
331, 454, 230, 34, 343, 45, 59, 453, 345, 231, 9
Apply the bucket sort on the last radix position, and the elements are put into the buckets as follows: 
stable
radix sort
radix sort  on Companion 
Website
queue
After being removed from the buckets, the elements are in the following order:
230, 331, 231, 343, 453, 454, 34, 45, 345, 59, 9
Apply the bucket sort on the second-to-last radix position, and the elements are put into the 
buckets as follows: 
queue
230
bucket[0]
331
231
bucket[1] bucket[2]
343
453
bucket[3]
454
34
bucket[4]
45
345
bucket[5] bucket[6] bucket[7] bucket[8]
59
9
bucket[9]
9
bucket[0] bucket[1] bucket[2]
230
331
231
34
bucket[3]
343
45
345
bucket[4]
453
454
59
bucket[5] bucket[6] bucket[7] bucket[8] bucket[9]
After being removed from the buckets, the elements are in the following order:
9, 230, 331, 231, 34, 343, 45, 345, 453, 454, 59
(Note that 9 is 009.)
Apply the bucket sort on the third-to-last radix position, and the elements are put into the 
buckets as follows: 
queue
9
34
45
59
bucket[0] bucket[1]
230
231
bucket[2]
331
343
345
bucket[3]
453
454
bucket[4] bucket[5] bucket[6] bucket[7] bucket[8] bucket[9]
```

</details>


## PDF page 906

<details>
<summary>Page text</summary>

```text
23.8 External Sort  883
After being removed from the buckets, the elements are in the following order:
9, 34, 45, 59, 230, 231, 331, 343, 345, 453, 454
The elements are now sorted.
Radix sort takes O(dn) time to sort n elements with integer keys, where d is the maximum 
number of the radix positions among all keys.
23.21 Can you sort a list of strings using a bucket sort?
23.22 Show how the radix sort works using the numbers 454,34,23,43,74,86, and 76.
23.8 External Sort
You can sort a large amount data using an external sort.
All the sort algorithms discussed in the preceding sections assume that all the data to be sorted 
are available at one time in internal memory, such as in an array. To sort data stored in an 
external file, you must first bring the data to the memory and then sort it internally. However, 
if the file is too large, all the data in the file cannot be brought to memory at one time. This 
section discusses how to sort data in a large external file. This is called an external sort.
For simplicity, assume that two million int values are stored in a binary file named 
largedata.dat. This file was created using the program in Listing 23.11.
LISTING 23.11 CreateLargeFile.java
 1 import java.io.*;
 2
 3 public class CreateLargeFile {
 4 public static void main(String[] args) throws Exception {
 5 DataOutputStream output = new DataOutputStream(
 6 new BufferedOutputStream(
 7 new FileOutputStream("largedata.dat")));
 8
 9 for (int i = 0; i < 800004; i++)
10 output.writeInt(( int)(Math.random() * 1000000));
11
12 output.close();
13
14 // Display first 100 numbers
15      DataInputStream input = new DataInputStream(
16 new BufferedInputStream(new FileInputStream("largedata.dat")));
17 for (int i = 0; i < 100; i++)
18        System.out.print(input.readInt() + " ");
19
20      input.close();
21    }
22  }
✓Point✓
Check
Key
Point
external sort
a binary output stream
output an int value
close output file
read an int value
close intput file
569193 131317 608695 776266 767910 624915 458599 5010 ... (omitted)
A variation of merge sort can be used to sort this file in two phases:
Phase I: Repeatedly bring data from the file to an array, sort the array using an internal 
sorting algorithm, and output the data from the array to a temporary file. This process is 
shown in Figure 23.17. Ideally, you want to create a large array, but its maximum size 
depends on how much memory is allocated to the JVM by the operating system. Assume 
that the maximum array size is 100,000 int values. In the temporary file, every 100,000
```

</details>


## PDF page 907

<details>
<summary>Page text</summary>

```text
884 Chapter 23 Sorting
int values are sorted. They are denoted as S1, S2, c , and Sk, where the last segment, 
Sk, may contain less than 100000 values.
FIGURE 23.18 Sorted segments are merged iteratively.
S1 S2 S3 S4 S5 S6 S7 S8
S1,S 2 merged
S1,S 2,S 3,S 4 merged S 5,S 6,S 7,S 8 merged
S3,S 4 merged S 5,S 6 merged S 7,S 8 merged
Merge step
Merge step
Merge step
S1,S 2,S 3,S 4,S 5,S 6,S 7,S 8 merged Final sortedsegment
FIGURE 23.17 The original file is sorted in segments.
Program
Array
……
Original file
Temporary file
S1 S2 Sk
Unsorted
Sorted
segment
Sorted
segment
Sorted
segment
Phase II: Merge a pair of sorted segments (e.g., S1with S2, S3 with S4, c , and so on) 
into a larger sorted segment and save the new segment into a new temporary file. Continue 
the same process until only one sorted segment results. Figure 23.18 shows how to merge 
eight segments.
Note
It is not necessary to merge two successive segments. For example, you can merge S 1
with S5, S2 with S6, S3 with S7 and S4 with S8, in the first merge step. This observation is 
useful in implementing Phase II efficiently.
23.8.1 Implementing Phase I
Listing 23.12 gives the method that reads each segment of data from a file, sorts the segment, 
and stores the sorted segments into a new file. The method returns the number of segments.
LISTING 23.12 Creating Initial Sorted Segments
 1  /** Sort original file into sorted segments */
 2 private static int initializeSegments
 3      (int segmentSize, String originalFile, String f1) 
 4 throws Exception {
 5 int[] list = new int[segmentSize];
 6    DataInputStream input = new DataInputStream(
```

</details>


## PDF page 908

<details>
<summary>Page text</summary>

```text
23.8 External Sort  885
 7 new BufferedInputStream(new FileInputStream(originalFile))); 
 8    DataOutputStream output = new DataOutputStream(
 9 new BufferedOutputStream(new FileOutputStream(f1))); 
10
11 int numberOfSegments = 0;
12 while (input.available() > 0) {
13      numberOfSegments++;
14 int i = 0;
15 for ( ; input.available() > 0 && i < segmentSize; i++) {
16        list[i] = input.readInt();
17      }
18
19 // Sort an array list[0..i-1]
20      java.util.Arrays.sort(list, 0, i); 
21
22 // Write the array to f1.dat
23 for (int j = 0; j < i; j++) {
24        output.writeInt(list[j]); 
25      }
26    }
27
28    input.close();
29    output.close();
30
31 return numberOfSegments; 
32  }
The method creates an array with the maximum size in line 5, a data input stream for the 
original file in line 6, and a data output stream for a temporary file in line 8. Buffered streams 
are used to improve performance.
Lines 14–17 read a segment of data from the file into the array. Line 20 sorts the array. 
Lines 23–25 write the data in the array to the temporary file.
The number of segments is returned in line 31. Note that every segment has 
MAX_ARRAY_SIZE number of elements except the last segment, which may have fewer 
elements.
23.8.2 Implementing Phase II
In each merge step, two sorted segments are merged to form a new segment. The size of the 
new segment is doubled. The number of segments is reduced by half after each merge step. A 
segment is too large to be brought to an array in memory. To implement a merge step, copy 
half the number of segments from the file f1.dat to a temporary file f2.dat. Then merge the 
first remaining segment in f1.dat with the first segment in f2.dat into a temporary file named 
f3.dat, as shown in Figure 23.19.
original file
file with sorted segments
sort a segment
output to file
close file
return # of segments
FIGURE 23.19 Sorted segments are merged iteratively.
S1 S2 S3 S4 S5 S6 S7 S8 f1.dat
S1 S2 S3 S4 f2.dat
Copy to f2.dat
f3.datS1,S 5 merged S 2,S 6 merged S 3,S 7 merged S 4,S 8 merged
```

</details>


## PDF page 909

<details>
<summary>Page text</summary>

```text
886 Chapter 23 Sorting
Note
f1.dat may have one segment more than f2.dat. If so, move the last segment into 
f3.dat after the merge.
Listing 23.13 gives a method that copies the first half of the segments in f1.dat to f2.dat. 
Listing 23.14 gives a method that merges a pair of segments in f1.dat and f2.dat. Listing 23.15 
gives a method that merges two segments.
LISTING 23.13 Copying First Half Segments
1 private static void copyHalfToF2(int numberOfSegments,
2 int segmentSize, DataInputStream f1, DataOutputStream f2) 
3 throws Exception {
4 for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++) {
5      f2.writeInt(f1.readInt());
6    }
7  }
LISTING 23.14 Merging All Segments
 1 private static void mergeSegments(int numberOfSegments,
 2 int segmentSize, DataInputStream f1, DataInputStream f2, 
 3      DataOutputStream f3) throws Exception {
 4 for (int i = 0; i < numberOfSegments; i++) {
 5      mergeTwoSegments(segmentSize, f1, f2, f3); 
 6    }
 7
 8 // If f1 has one extra segment, copy it to f3
 9 while (f1.available() > 0) {
10      f3.writeInt(f1.readInt());
11    }
12  }
LISTING 23.15 Merging Two Segments
 1 private static void mergeTwoSegments(int segmentSize,
 2      DataInputStream f1, DataInputStream f2, 
 3      DataOutputStream f3) throws Exception {
 4 int intFromF1 = f1.readInt();
 5 int intFromF2 = f2.readInt();
 6 int f1Count = 1;
 7 int f2Count = 1;
 8
 9 while (true) {
10 if (intFromF1 < intFromF2) {
11        f3.writeInt(intFromF1); 
12 if (f1.available() == 0 || f1Count++ >= segmentSize) {
13          f3.writeInt(intFromF2);
14 break;
15        }
16 else {
17          intFromF1 = f1.readInt();
18        }
19      }
20 else {
21        f3.writeInt(intFromF2); 
22 if (f2.available() == 0 || f2Count++ >= segmentSize) {
23          f3.writeInt(intFromF1);
24 break;
25        }
input stream f1
output stream f2
segments copied
input stream f1 and f2
output stream f3
merge two segments
extra segment in f1?
input stream f1 and f2
output stream f3
read from f1
read from f2
write to f3
segment in f1 finished
write to f3
segment in f2 finished
```

</details>


## PDF page 910

<details>
<summary>Page text</summary>

```text
23.8 External Sort  887
26 else {
27          intFromF2 = f2.readInt();
28        }
29      }
30    }
31
32 while (f1.available() > 0 && f1Count++ < segmentSize) {
33      f3.writeInt(f1.readInt());
34    }
35
36 while (f2.available() > 0 && f2Count++ < segmentSize) {
37      f3.writeInt(f2.readInt());
38    }
39  }
23.8.3 Combining Two Phases
Listing 23.16 gives the complete program for sorting int values in largedata.dat and storing 
the sorted data in sortedfile.dat.
LISTING 23.16 SortLargeFile.java
  1 import java.io.*;
  2
  3 public class SortLargeFile {
  4 public static final int MAX_ARRAY_SIZE = 100000;
  5 public static final int BUFFER_SIZE = 100000;
  6
  7 public static void main(String[] args) throws Exception {
  8 // Sort largedata.dat to sortedfile.dat
  9      sort("largedata.dat", "sortedfile.dat");
 10
 11 // Display the first 100 numbers in the sorted file
 12      displayFile("sortedfile.dat");
 13    }
 14
 15 /** Sort data in source file into target file */
 16 public static void sort(String sourcefile, String targetfile)
 17 throws Exception {
 18 // Implement Phase 1: Create initial segments
 19 int numberOfSegments =
 20 initializeSegments(MAX_ARRAY_SIZE, sourcefile, "f1.dat");
 21
 22 // Implement Phase 2: Merge segments recursively
 23 merge(numberOfSegments, MAX_ARRAY_SIZE,
 24 "f1.dat", "f2.dat", "f3.dat", targetfile);
 25    }
 26
 27 /** Sort original file into sorted segments */
 28 private static int initializeSegments
 29        (int segmentSize, String originalFile, String f1) 
 30 throws Exception {
 31 // Same as Listing 23.12, so omitted
 32    }
 33
 34 private static void merge(int numberOfSegments, int segmentSize, 
35        String f1, String f2, String f3, String targetfile) 
 36 throws Exception {
 37 if (numberOfSegments > 1) {
 38 mergeOneStep(numberOfSegments, segmentSize, f1, f2, f3);
remainingf1 segment
remainingf2 segment
max array size
I/O stream buffer size
create initial segments
merge recursively
merge one step
```

</details>


## PDF page 911

<details>
<summary>Page text</summary>

```text
888 Chapter 23 Sorting
 39 merge((numberOfSegments + 1) / 2, segmentSize * 2,
 40 f3, f1, f2, targetfile);
 41      }
 42 else { // Rename f1 as the final sorted file
 43        File sortedFile = new File(targetfile); 
 44 if (sortedFile.exists()) sortedFile.delete();
 45 new File(f1).renameTo(sortedFile);
 46      }
 47    }
 48
 49 private static void mergeOneStep(int numberOfSegments, 
 50 int segmentSize, String f1, String f2, String f3) 
 51 throws Exception {
 52      DataInputStream f1Input = new DataInputStream(
 53 new BufferedInputStream(new FileInputStream(f1), BUFFER_SIZE));
 54      DataOutputStream f2Output = new DataOutputStream(
 55        new BufferedOutputStream(new FileOutputStream(f2), BUFFER_SIZE));
 56
 57 // Copy half number of segments from f1.dat to f2.dat
 58 copyHalfToF2(numberOfSegments, segmentSize, f1Input, f2Output);
 59      f2Output.close();
 60
 61 // Merge remaining segments in f1 with segments in f2 into f3
 62      DataInputStream f2Input = new DataInputStream(
 63 new BufferedInputStream(new FileInputStream(f2), BUFFER_SIZE));
 64      DataOutputStream f3Output = new DataOutputStream(
 65        new BufferedOutputStream(new FileOutputStream(f3), BUFFER_SIZE));
 66
 67 mergeSegments(numberOfSegments / 2,
 68 segmentSize, f1Input, f2Input, f3Output);
 69
 70      f1Input.close();
 71      f2Input.close();
 72      f3Output.close();
 73    }
 74
 75 /** Copy first half number of segments from f1.dat to f2.dat */
 76 private static void copyHalfToF2(int numberOfSegments,
 77 int segmentSize, DataInputStream f1, DataOutputStream f2) 
 78 throws Exception {
 79 // Same as Listing 23.13, so omitted
 80    }
 81
 82 /** Merge all segments */
 83 private static void mergeSegments(int numberOfSegments,
 84 int segmentSize, DataInputStream f1, DataInputStream f2,
 85        DataOutputStream f3) throws Exception {
 86 // Same as Listing 23.14, so omitted
 87    }
 88
 89 /** Merges two segments */
 90 private static void mergeTwoSegments(int segmentSize,
 91      DataInputStream f1, DataInputStream f2,
 92      DataOutputStream f3) throws Exception {
 93 // Same as Listing 23.15, so omitted
 94    }
 95
 96 /** Display the first 100 numbers in the specified file */
 97 public static void displayFile(String filename) {
 98 try {
merge recursively
final sorted file
input stream f1Input
output stream f2Output
copy half segments to f2
closef2Output
input stream f2Input
output stream f3Output
merge two segments
close streams
display file
```

</details>


## PDF page 912

<details>
<summary>Page text</summary>

```text
23.8 External Sort  889
 99        DataInputStream input = 
100 new DataInputStream(new FileInputStream(filename));
101 for (int i = 0; i < 100; i++)
102          System.out.print(input.readInt() + " ");
103        input.close();
104      }
105 catch (IOException ex) {
106        ex.printStackTrace();
107      }
108    }
109  }
0 1 1 1 2 2 2 3 3 4 5 6 8 8 9 9 9 10 10 11 . . . (omitted)
Before you run this program, first run Listing 23.11, CreateLargeFile.java, to create the 
file largedata.dat. Invoking sort("largedata.dat", "sortedfile.dat")  (line 9) 
reads data from largedata.dat and writes sorted data to sortedfile.dat. Invoking 
displayFile("sortedfile.dat") (line 12) displays the first 100 numbers in the speci-
fied file. Note that the files are created using binary I/O. You cannot view them using a text 
editor such as Notepad.
The sort method first creates initial segments from the original array and stores the 
sorted segments in a new file, f1.dat (lines 19–20), then produces a sorted file in targetfile
(lines 23–24).
Themerge method
merge(int numberOfSegments, int segmentSize, 
  String f1, String f2, String f3, String targetfile)
merges the segments in f1 into f3 using f2 to assist the merge. The merge method is invoked 
recursively with many merge steps. Each merge step reduces the numberOfSegments by 
half and doubles the sorted segment size. After the completion of one merge step, the next 
merge step merges the new segments in f3 to f2 using f1 to assist the merge. The statement 
to invoke the new merge method is
merge((numberOfSegments + 1) / 2, segmentSize * 2,
  f3, f1, f2, targetfile);
ThenumberOfSegments for the next merge step is (numberOfSegments + 1) / 2. For 
example, if numberOfSegments is 5, numberOfSegments is 3 for the next merge step, 
because every two segments are merged but one is left unmerged.
The recursive merge method ends when numberOfSegments is 1. In this case, f1 con-
tains sorted data. File f1 is renamed to targetfile (line 45).
23.8.4 External Sort Complexity
In the external sort, the dominating cost is that of I/O. Assume n is the number of elements to 
be sorted in the file. In Phase I, n number of elements are read from the original file and output 
to a temporary file. Therefore, the I/O for Phase I is O(n).
In Phase II, before the first merge step, the number of sorted segments is nc, where c is 
MAX_ARRAY_SIZE. Each merge step reduces the number of segments by half. Thus, after the 
first merge step, the number of segments is n2c. After the second merge step, the number of 
segments is n22c, and after the third merge step the number of segments is n23c. After log¢ nc≤
```

</details>


## PDF page 913

<details>
<summary>Page text</summary>

```text
890 Chapter 23 Sorting
merge steps, the number of segments is reduced to 1. Therefore, the total number of merge
steps is log¢ nc≤.
In each merge step, half the number of segments are read from file f1 and then written into 
a temporary file f2. The remaining segments in f1 are merged with the segments in f2. The 
number of I/Os in each merge step is O(n). Since the total number of merge steps is log¢ nc≤,the total number of I/Os is
O(n) * log¢ nc≤ = O(n log n)
Therefore, the complexity of the external sort is O(n logn).
23.23 Describe how external sort works. What is the complexity of the external sort algorithm?
23.24 Ten numbers {2, 3, 4, 0, 5, 6, 7, 9, 8, 1} are stored in the external file largedata.dat.
Trace the SortLargeFile program by hand with MAX_ARRAY_SIZE 2.
✓Point✓
Check
KEY TERMS
bubble sort 864
bucket sort 881
complete binary tree 874
external sort 883
heap 875
heap sort 874
height of a heap 880
merge sort 867
quick sort 870
radix sort 882
CHAPTER SUMMARY
1. The worst-case complexity for a selection sort, insertion sort, bubble sort, and quick sort
is O(n2).
2. The average-case and worst-case complexity for a merge sort is O(n logn). The average 
time for a quick sort is also O(n logn).
3. Heaps are a useful data structure for designing efficient algorithms such as sorting. You 
learned how to define and implement a heap class, and how to insert and delete elements 
to/from a heap.
4. The time complexity for a heap sort is O(n logn).
5. Bucket sorts and radix sorts are specialized sorting algorithms for integer keys. These 
algorithms sort keys using buckets rather than by comparing keys. They are more 
efficient than general sorting algorithms.
6. A variation of the merge sort—called an external sort—can be applied to sort large 
amounts of data from external files.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/test.html.
```

</details>


## PDF page 914

<details>
<summary>Page text</summary>

```text
Programming Exercises  891
PROGRAMMING EXERCISES
Sections 23.3–23.5
23.1 (Generic bubble sort ) Write the following two generic methods using bubble 
sort. The first method sorts the elements using the Comparable interface and 
the second uses the Comparator interface.
public static <E extends Comparable<E>> 
void bubbleSort(E[] list)
public static <E> void bubbleSort(E[] list, 
  Comparator<? super E> comparator)
23.2 (Generic merge sort) Write the following two generic methods using merge sort. 
The first method sorts the elements using the Comparable interface and the 
second uses the Comparator interface.
public static <E extends Comparable<E>> 
void mergeSort(E[] list)
public static <E> void mergeSort(E[] list, 
  Comparator<? super E> comparator)
23.3 (Generic quick sort) Write the following two generic methods using quick sort. 
The first method sorts the elements using the Comparable interface and the 
second uses the Comparator interface.
public static <E extends Comparable<E>> 
void quickSort(E[] list)
public static <E> void quickSort(E[] list, 
  Comparator<? super E> comparator)
23.4 (Improve quick sort) The quick sort algorithm presented in the book selects the 
first element in the list as the pivot. Revise it by selecting the median among the 
first, middle, and last elements in the list.
*23.5 (Generic heap sort ) Write the following two generic methods using heap sort. 
The first method sorts the elements using the Comparable interface and the 
second uses the Comparator interface.
public static <E extends Comparable<E>> 
void heapSort(E[] list)
public static <E> void heapSort(E[] list, 
  Comparator<? super E> comparator)
23.6 (Check order) Write the following overloaded methods that check whether an 
array is ordered in ascending order or descending order. By default, the method 
checks ascending order. To check descending order, pass false to the ascend-
ing argument in the method.
public static boolean ordered(int[] list)
public static boolean ordered(int[] list, boolean ascending)
public static boolean ordered(double[] list)
public static boolean ordered
  (double[] list, boolean ascending)
public static <E extends Comparable<E>> 
boolean ordered(E[] list)
public static <E extends Comparable<E>> boolean ordered
  (E[] list, boolean ascending)
public static <E> boolean ordered(E[] list,
```

</details>


## PDF page 915

<details>
<summary>Page text</summary>

```text
892 Chapter 23 Sorting
  Comparator<? super E> comparator)
public static <E> boolean ordered(E[] list, 
  Comparator<? super E> comparator, boolean ascending)
Section 23.6
23.7 (Min-heap) The heap presented in the text is also known as a max-heap, in which 
each node is greater than or equal to any of its children. A min-heap is a heap 
in which each node is less than or equal to any of its children. Min-heaps are 
often used to implement priority queues. Revise the Heap class in Listing 23.9 to 
implement a min-heap.
*23.8 (Sort using a heap) Implement the following sort method using a heap.
public static <E extends Comparable<E>> void sort(E[] list)
*23.9 (GenericHeap using Comparator) Revise Heap in Listing 23.9, using a generic 
parameter and a Comparator for comparing objects. Define a new constructor 
with a Comparator as its argument as follows:
Heap(Comparator<? super E> comparator)
**23.10 (Heap visualization) Write a program that displays a heap graphically, as shown 
in Figure 23.10. The program lets you insert and delete an element from the heap.
23.11 (Heap clone and equals) Implement the clone and equals method in the 
Heap class.
Section 23.7
*23.12 (Radix sort) Write a program that randomly generates 1,000,000 integers and 
sorts them using radix sort.
*23.13 (Execution time for sorting) Write a program that obtains the execution time of 
selection sort, bubble sort, merge sort, quick sort, heap sort, and radix sort for 
input size 50,000, 100,000, 150,000, 200,000, 250,000, and 300,000. Your pro-
gram should create data randomly and print a table like this:
max-heap
min-heap
Array
size
Selection
Sort
Bubble
Sort
Merge
Sort
Quick
Sort
Heap
Sort
Radix
Sort
50,000
100,000
150,000
200,000
250,000
300,000
(Hint: You can use the following code template to obtain the execution time.)
long startTime = System.currentTimeMillis();
perform the task;
long endTime = System.currentTimeMillis();
long executionTime = endTime - startTime;
The text gives a recursive quick sort. Write a nonrecursive version in this exercise.
```

</details>


## PDF page 916

<details>
<summary>Page text</summary>

```text
Programming Exercises  893
Section 23.8
*23.14 (Execution time for external sorting) Write a program that obtains the execution 
time of external sorts for integers of size 5,000,000, 10,000,000, 15,000,000, 
20,000,000, 25,000,000, and 30,000,000. Your program should print a table 
like this:
File size 5,000,000 10,000,000 15,000,000 20,000,000 25,000,000 30,000,000
Time
Comprehensive
*23.15 (Selection sort animation ) Write a program that animates the selection sort 
algorithm. Create an array that consists of 20 distinct numbers from 1 to 20 in 
a random order. The array elements are displayed in a histogram, as shown in 
Figure 23.20a. Clicking the Step button causes the program to perform an itera-
tion of the outer loop in the algorithm and repaints the histogram for the new 
array. Color the last bar in the sorted subarray. When the algorithm is finished, 
display a message to inform the user. Clicking the Reset button creates a new 
random array for a new start. (You can easily modify the program to animate the 
insertion algorithm.)
*23.16 (Bubble sort animation ) Write a program that animates the bubble sort algo-
rithm. Create an array that consists of 20 distinct numbers from 1 to 20 in a 
random order. The array elements are displayed in a histogram, as shown in 
Figure 23.20b. Clicking the Step button causes the program to perform one com-
parison in the algorithm and repaints the histogram for the new array. Color the 
bar that represents the number being considered in the swap. When the algorithm 
is finished, display a message to inform the user. Clicking the Reset button cre-
ates a new random array for a new start.
*23.17 (Radix sort animation) Write a program that animates the radix sort algorithm. 
Create an array that consists of 20 random numbers from 0 to 1,000. The array 
elements are displayed, as shown in Figure  23.21. Clicking the Step button 
causes the program to place a number in a bucket. The number that has just 
been placed is displayed in red. Once all the numbers are placed in the buckets, 
clicking the Step button collects all the numbers from the buckets and moves 
FIGURE 23.20 (a) The program animates selection sort. (b) The program animates bubble sort.
(b)(a)
```

</details>


## PDF page 917

<details>
<summary>Page text</summary>

```text
894 Chapter 23 Sorting
them back to the array. When the algorithm is finished, clicking the Step button 
displays a message to inform the user. Clicking the Reset button creates a new 
random array for a new start.
FIGURE 23.21 The program animates radix sort.
*23.18 (Merge animation) Write a program that animates the merge of two sorted lists. 
Create two arrays, list1 and list2, each of which consists of 8 random num-
bers from 1 to 999. The array elements are displayed, as shown in Figure 23.22a. 
Clicking the Step button causes the program to move an element from list1 or 
list2 to temp. Clicking the Reset button creates two new random arrays for 
a new start. When the algorithm is finished, clicking the Step button displays a 
message to inform the user.
*23.19 (Quick sort partition animation) Write a program that animates the partition for 
a quick sort. The program creates a list that consists of 20 random numbers from 
1 to 999. The list is displayed, as shown in Figure 23.22b. Clicking the Step but-
ton causes the program to move low to the right or high to the left, or swap the 
elements at low and high. Clicking the Reset button creates a new list of random 
numbers for a new start. When the algorithm is finished, clicking the Step button 
displays a message to inform the user.
*23.20 (Modify merge sort) Rewrite the mergeSort method to recursively sort the first 
half of the array and the second half of the array without creating new temporary 
arrays, and then merge the two into a temporary array and copy its contents to the 
original array, as shown in Figure 23.6b.
FIGURE 23.22 The program animates a merge of two sorted lists. (b) The program animates a partition for quick sort.
(b)(a)
```

</details>
