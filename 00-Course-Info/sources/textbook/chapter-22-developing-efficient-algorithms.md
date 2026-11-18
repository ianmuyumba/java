# Chapter 22 Developing Efficient Algorithms

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 844

<details>
<summary>Page text</summary>

```text
DEVELOPING EFFICIENT
ALGORITHMS
Objectives
■ To estimate algorithm efficiency using the Big O notation (§22.2).
■ To explain growth rates and why constants and nondominating terms 
can be ignored in the estimation (§22.2).
■ To determine the complexity of various types of algorithms (§22.3).
■ To analyze the binary search algorithm (§22.4.1).
■ To analyze the selection sort algorithm (§22.4.2).
■ To analyze the Tower of Hanoi algorithm (§22.4.3).
■ To describe common growth functions (constant, logarithmic, log-
linear, quadratic, cubic, exponential) (§22.4.4).
■ To design efficient algorithms for finding Fibonacci numbers using 
dynamic programming (§22.5).
■ To find the GCD using Euclid’s algorithm (§22.6).
■ To find prime numbers using the sieve of Eratosthenes (§22.7).
■ To design efficient algorithms for finding the closest pair of points 
using the divide-and-conquer approach (§22.8).
■ To solve the Eight Queens problem using the backtracking approach 
(§22.9).
■ To design efficient algorithms for finding a convex hull for a set of 
points (§22.10).
CHAPTER
22
```

</details>


## PDF page 845

<details>
<summary>Page text</summary>

```text
822 Chapter 22  Developing Efficient Algorithms
22.1 Introduction
Algorithm design is to develop a mathematical process for solving a problem. 
Algorithm analysis is to predict the performance of an algorithm.
The preceding two chapters introduced classic data structures (lists, stacks, queues, priority
queues, sets, and maps) and applied them to solve problems. This chapter will use a vari-
ety of examples to introduce common algorithmic techniques (dynamic programming, 
divide-and-conquer, and backtracking) for developing efficient algorithms. Later in the book, 
we will introduce efficient algorithms in Chapters  23–29. Before introducing developing 
efficient algorithms, we need to address the question on how to measure algorithm efficiency.
22.2 Measuring Algorithm Efficiency Using 
Big O Notation
The Big O notation obtains a function for measuring algorithm time complexity based 
on the input size. You can ignore multiplicative constants and nondominating terms in 
the function.
Suppose two algorithms perform the same task, such as search (linear search vs. binary 
search). Which one is better? To answer this question, you might implement these algorithms 
and run the programs to get execution time. But there are two problems with this approach: 
 ■ First, many tasks run concurrently on a computer. The execution time of a particular 
program depends on the system load.
 ■ Second, the execution time depends on specific input. Consider, for example, linear 
search and binary search. If an element to be searched happens to be the first in the 
list, linear search will find the element quicker than binary search.
It is very difficult to compare algorithms by measuring their execution time. To overcome 
these problems, a theoretical approach was developed to analyze algorithms independent of 
computers and specific input. This approach approximates the effect of a change on the size 
of the input. In this way, you can see how fast an algorithm’s execution time increases as the 
input size increases, so you can compare two algorithms by examining their growth rates.
Consider linear search. The linear search algorithm compares the key with the elements in 
the array sequentially until the key is found or the array is exhausted. If the key is not in the 
array, it requires n comparisons for an array of size n. If the key is in the array, it requires n/2 
comparisons on average. The algorithm’s execution time is proportional to the size of the array. 
If you double the size of the array, you will expect the number of comparisons to double. The 
algorithm grows at a linear rate. The growth rate has an order of magnitude of n. Computer 
scientists use the Big O notation to represent the “order of magnitude.” Using this notation, 
the complexity of the linear search algorithm is O(n), pronounced as “order of n.” We call an 
algorithm with a time complexity of O(n) a linear algorithm, and it exhibits a linear growth rate.
For the same input size, an algorithm’s execution time may vary, depending on the input. 
An input that results in the shortest execution time is called the best-case input, and an input 
that results in the longest execution time is the worst-case input.  Best-case analysis and 
worst-case analysis are to analyze the algorithms for their best-case input and worst-case 
input. Best-case and worst-case analysis are not representative, but worst-case analysis is 
very useful. You can be assured that the algorithm will never be slower than the worst case. 
An average-case analysis attempts to determine the average amount of time among all pos-
sible inputs of the same size. Average-case analysis is ideal, but difficult to perform, because 
for many problems it is hard to determine the relative probabilities and distributions of vari-
ous input instances. Worst-case analysis is easier to perform, so the analysis is generally 
conducted for the worst case.
Key
Point
Key
Point
what is algorithm efficiency?
growth rates
Big O notation
best-case input
worst-case input
average-case analysis
```

</details>


## PDF page 846

<details>
<summary>Page text</summary>

```text
22.2 Measuring Algorithm Efficiency Using Big  O Notation  823
The linear search algorithm requires n comparisons in the worst case and n/2 comparisons 
in the average case if you are nearly always looking for something known to be in the list. 
Using the Big O notation, both cases require O(n) time. The multiplicative constant (1/2) can 
be omitted. Algorithm analysis is focused on growth rate. The multiplicative constants have 
no impact on growth rates. The growth rate for n/2 or 100n is the same as for n, as illustrated 
in Table 22.1. Therefore, O(n) = O(n/2) = O(100n).
ignore multiplicative constants
f(n)
n
100
200
100
200
50
100
10000
20000
222 f(200) /H11408 f(100)
nn /2 100 n
TABLE 22.1  Growth Rates
Consider the algorithm for finding the maximum number in an array of n elements. To find 
the maximum number if n is 2, it takes one comparison; if n is 3, two comparisons. In general, 
it takes n - 1 comparisons to find the maximum number in a list of n elements. Algorithm 
analysis is for large input size. If the input size is small, there is no significance in estimating 
an algorithm’s efficiency. As n grows larger, the n part in the expression n - 1 dominates the 
complexity. The Big O notation allows you to ignore the nondominating part (e.g., -1 in the 
expression n - 1) and highlight the important part (e.g., n in the expression n - 1). There-
fore, the complexity of this algorithm is O(n).
The Big O notation estimates the execution time of an algorithm in relation to the input 
size. If the time is not related to the input size, the algorithm is said to take constant time with 
the notation O(1). For example, a method that retrieves an element at a given index in an array 
takes constant time, because the time does not grow as the size of the array increases.
The following mathematical summations are often useful in algorithm analysis: 
1 + 2 + 3 + c + (n - 2) + (n - 1) = n(n - 1)2 = O(n2)
1 + 2 + 3 + c + (n - 1) + n = n(n + 1)2 = O(n2)
a0 + a1 + a2 + a3 + c + a(n - 1) + an = an + 1 - 1a - 1 = O(an)
20 + 21 + 22 + 23 + c + 2(n - 1) + 2n = 2n + 1 - 12 - 1 = 2n + 1 - 1 = O(2n)
Note
Time complexity is a measure of execution time using the Big-O notation. Similarly, you 
can also measure space complexity using the Big-O notation. Space complexity meas-
ures the amount of memory space used by an algorithm. The space complexity for most 
algorithms presented in the book is O(n). i.e., they exibit linear growth rate to the input 
size. For example, the space complexity for linear search is O(n).
22.1 Why is a constant factor ignored in the Big O notation? Why is a nondominating term 
ignored in the Big O notation?
22.2 What is the order of each of the following functions?
(n2 + 1)2
n , (n2 + log2n)2n , n3 + 100n2 + n,2 n + 100n2 + 45n, n2n + n22n
large input size
ignore nondominating terms
constant time
useful summations
time complexity
space complexity
✓Point✓
Check
```

</details>


## PDF page 847

<details>
<summary>Page text</summary>

```text
824 Chapter 22  Developing Efficient Algorithms
22.3 Examples: Determining Big O
This section gives several examples of determining Big O for repetition, sequence, 
and selection statements.
Example 1
Consider the time complexity for the following loop:
for (int i = 1; i <= n; i++) {
  k = k + 5;
}
It is a constant time, c, for executing
k = k + 5;
Since the loop is executed n times, the time complexity for the loop is
T(n) = (a constant c)* n = O(n).
The theoretical analysis predicts the performance of the algorithm. To see how this 
algorithm performs, we run the code in Listing 22.1 to obtain the execution time for 
n = 1000000, 10000000, 100000000, and 100000000.
LISTING 22.1 PerformanceTest.java
 1 public class PerformanceTest {
 2 public static void main(String[] args) {
 3 getTime( 1000000);
 4      getTime(10000000);
 5      getTime(100000000);
 6      getTime(1000000000);
 7    }
 8
 9 public static void getTime (long n) {
10 long startTime = System.currentTimeMillis();
11 long k = 0;
12 for (int i = 1; i <= n; i++) {
13        k = k + 5;
14      }
15 long endTime = System.currentTimeMillis();
16      System.out.println("Execution time for n = " + n
17        + " is " + (endTime - startTime) + " milliseconds");
18    }
19  }
Key
Point
input size 1000000
input size 10000000
input size 100000000
input size 1000000000
time before execution
time after execution
Execution time for n = 1000000 is 6 milliseconds
Execution time for n = 10000000 is 61 milliseconds
Execution time for n = 100000000 is 610 milliseconds
Execution time for n = 1000000000 is 6048 milliseconds 
Our analysis predicts a linear time complexity for this loop. As shown in the sample output, 
when the input size increases 10 times, the runtime increases roughly 10 times. The execution 
confirms to the prediction. 
Example 2
What is the time complexity for the following loop?
for (int i = 1; i <= n; i++) {
for (int j = 1; j <= n; j++) {
```

</details>


## PDF page 848

<details>
<summary>Page text</summary>

```text
22.3 Examples: Determining Big O 825
    k = k + i + j;
  }
}
It is a constant time, c, for executing
k = k + i + j;
The outer loop executes n times. For each iteration in the outer loop, the inner loop is 
executed n times. Thus, the time complexity for the loop is
T(n) = (a constant c)* n*n = O(n2)
An algorithm with the O(n2) time complexity is called a quadratic algorithm  and it 
exhibits a quadratic growth rate. The quadratic algorithm grows quickly as the problem 
size increases. If you double the input size, the time for the algorithm is quadrupled. 
Algorithms with a nested loop are often quadratic.
Example 3
Consider the following loop:
for (int i = 1; i <= n; i++) {
for (int j = 1; j <= i; j++) {
    k = k + i + j;
  }
}
The outer loop executes n times. For i = 1, 2, c , the inner loop is executed one time, 
two times, and n times. Thus, the time complexity for the loop is
T(n) = c + 2c + 3c + 4c + ... + nc
= cn(n + 1)/2
= (c/2) n2 + (c/2)n
= O(n2)
Example 4
Consider the following loop:
for (int i = 1; i <= n; i++) {
for (int j = 1; j <= 20; j++) {
    k = k + i + j;
  }
}
The inner loop executes 20 times, and the outer loop n times. Therefore, the time com-
plexity for the loop is
T(n) = 20* c*n = O(n)
Example 5
Consider the following sequences:
for (int j = 1; j <= 10; j++) {
  k = k + 4;
}
for (int i = 1; i <= n; i++) {
quadratic time
```

</details>


## PDF page 849

<details>
<summary>Page text</summary>

```text
826 Chapter 22  Developing Efficient Algorithms
for (int j = 1; j <= 20; j++) {
    k = k + i + j;
  }
}
The first loop executes 10 times, and the second loop 20 * n times. Thus, the time com-
plexity for the loop is
T(n) = 10* c + 20* c*n = O(n)
Example 6
Consider the following selection statement:
if (list.contains(e)) {
  System.out.println(e);
}
else
for (Object t: list) {
    System.out.println(t);
  }
Suppose the list contains n elements. The execution time for list.contains(e) is 
O(n). The loop in the else clause takes O(n) time. Hence, the time complexity for the 
entire statement is
T(n) = if test time + worst@case time (if clause, else clause)
= O(n) + O(n) = O(n)
Example 7
Consider the computation of an for an integer n. A simple algorithm would multiply an
times, as follows:
result = 1;
for (int i = 1; i <= n; i++)
  result *= a;
The algorithm takes O(n) time. Without loss of generality, assume n = 2k. You can 
improve the algorithm using the following scheme:
result = a;
for (int i = 1; i <= k; i++)
  result = result * result;
The algorithm takes O(logn) time. For an arbitrary n, you can revise the algorithm and 
prove that the complexity is still O(logn). (See Checkpoint Question 22.7.)
Note
For simplicity, since 0(logn) = 0(log2n) = 0(logan), the constant base is omitted. 
22.3 Count the number of iterations in the following loops.
omit base
✓Point✓
Check
int count = 1;
while (count < 30) {
  count = count * 2;
}
(a)
int count = 15;
while (count < 30) {
  count = count * 3;
}
(b)
```

</details>


## PDF page 850

<details>
<summary>Page text</summary>

```text
22.3 Examples: Determining Big O 827
22.4 How many stars are displayed in the following code if n is 10? How many if n is 20? 
Use the Big O notation to estimate the time complexity. 
int count = 1;
while (count < n) {
  count = count * 2;
}
(c)
int count = 15;
while (count < n) {
  count = count * 3;
}
(d)
for (int i = 0; i < n; i++) {
  System.out.print('*');
}
(a)
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
    System.out.print('*');
  }
}
(b)
for (int k = 0; k < n; k++) {
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
      System.out.print('*');
    }
  }
}
 (c) 
for (int k = 0; k < 10; k++) {
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
      System.out.print('*');
    }
  }
}
(d)
22.5 Use the Big O notation to estimate the time complexity of the following methods: 
public static void mA(int n) {
for (int i = 0; i < n; i++) {
    System.out.print(Math.random());
  }
}
(a)
public static void mB(int n) {
for (int i = 0; i < n; i++) {
for (int j = 0; j < i; j++)
      System.out.print(Math.random());
  }
}
(b)
22.6 Design an O(n) time algorithm for computing the sum of numbers from n1 to n2 for 
(n1 6 n2). Can you design an O(1) for performing the same task?
22.7 Example 7 in Section 22.3 assumes n = 2k. Revise the algorithm for an arbitrary n
and prove that the complexity is still O(logn).
public static void mD(int[] m) {
for (int i = 0; i < m.length; i++) {
for (int j = 0; j < i; j++)
      System.out.print(m[i] * m[j]);
    }
}
(d)
public static void mC(int[ ] m) {
for (int i = 0; i < m.length; i++) {
    System.out.print(m[i]);
  }
for (int i = m.length - 1; i >= 0; )
  {
    System.out.print(m[i]);
    i--;
  }
}
(c)
```

</details>


## PDF page 851

<details>
<summary>Page text</summary>

```text
828 Chapter 22  Developing Efficient Algorithms
22.4 Analyzing Algorithm Time Complexity
This section analyzes the complexity of several well-known algorithms: binary search, 
selection sort, and Tower of Hanoi.
22.4.1 Analyzing Binary Search
The binary search algorithm presented in Listing 7.7, BinarySearch.java, searches for a key in 
a sorted array. Each iteration in the algorithm contains a fixed number of operations, denoted 
by c. Let T(n) denote the time complexity for a binary search on a list of n elements. Without 
loss of generality, assume n is a power of 2 and k = logn. Since a binary search eliminates 
half of the input after two comparisons, 
T(n) = T¢ n2≤ + c = T¢ n22≤ + c + c = T¢ n2k≤ + kc
= T(1) + c logn = 1 + (logn)c
= O(logn)
Ignoring constants and nondominating terms, the complexity of the binary search algorithm 
is O(logn). An algorithm with the O(logn) time complexity is called a logarithmic algorithm
and it exhibits a logarithmic growth rate. The base of the log is 2, but the base does not affect 
a logarithmic growth rate, so it can be omitted. The logarithmic algorithm grows slowly as the 
problem size increases. In the case of binary search, each time you double the array size, at most 
one more comparison will be required. If you square the input size of any logarithmic time algo-
rithm, you only double the time of execution. So a logarithmic-time algorithm is very efficient.
22.4.2 Analyzing Selection Sort
The selection sort algorithm presented in Listing 7.8, SelectionSort.java, finds the smallest 
element in the list and swaps it with the first element. It then finds the smallest element 
remaining and swaps it with the first element in the remaning list, and so on until the remain-
ing list contains only one element left to be sorted. The number of comparisons is n - 1 for 
the first iteration, n - 2 for the second iteration, and so on. Let T(n) denote the complexity 
for selection sort and c denote the total number of other operations such as assignments and 
additional comparisons in each iteration. Thus,
T(n) = (n - 1) + c + (n - 2) + c + c + 2 + c + 1 + c
= (n - 1)(n - 1 + 1)2 + c(n - 1) = n22 - n2 + cn - c
= O(n2)
Therefore, the complexity of the selection sort algorithm is O(n2).
22.4.3 Analyzing the Tower of Hanoi Problem
The Tower of Hanoi problem presented in Listing18.8, TowerOfHanoi.java, recursively 
moves n disks from tower A to tower B with the assistance of tower C as follows:
1. Move the first n - 1 disks from A to C with the assistance of tower B.
Key
Point
binary search animation on 
the Companion Website
logarithmic time
selection sort animation on 
the Companion Website
```

</details>


## PDF page 852

<details>
<summary>Page text</summary>

```text
22.4 Analyzing Algorithm Time Complexity  829
2. Move disk n from A to B.
3. Move n - 1 disks from C to B with the assistance of tower A.
The complexity of this algorithm is measured by the number of moves. Let T(n) denote the 
number of moves for the algorithm to move n disks from tower A to tower B with T(1) = 1. 
Thus,
T(n) = T(n - 1) + 1 + T(n - 1)
= 2T(n - 1) + 1
= 2(2T(n - 2) + 1) + 1
= 2(2(2T(n - 3) + 1) + 1) + 1
= 2n - 1T(1) + 2n - 2 + c + 2 + 1
= 2n - 1 + 2n - 2 + c + 2 + 1 = (2n - 1) = O(2n)
An algorithm with O(2n) time complexity is called an exponential algorithm, and it exhibits 
an exponential growth rate. As the input size increases, the time for the exponential algorithm 
grows exponentially. Exponential algorithms are not practical for large input size. Suppose
the disk is moved at a rate of 1 per second. It would take 232/(365*24*60*60) = 136 years 
to move 32 disks and 264/(365*24*60*60) = 585 billion years to move 64 disks. 
22.4.4 Common Recurrence Relations
Recurrence relations  are a useful tool for analyzing algorithm complexity. As shown in 
the preceding examples, the complexity for binary search, selection sort, and the Tower
of Hanoi is T(n) = T¢ n2≤ + O(1), T(n) = T(n - 1) + O(n), and T(n) = 2T(n - 1) + O(1),
respectively. Table 22.2 summarizes the common recurrence relations.
O(2n)
exponential time
Recurrence Relation Result Example
T(n) = T(n/2) + O(1) T(n) = O(logn) Binary search, Euclid’s GCD
T(n) = T(n - 1) + O(1) T(n) = O(n) Linear search
T(n) = 2T(n/2) + O(1) T(n) = O(n) Checkpoint Question 22.20
T(n) = 2T(n/2) + O(n) T(n) = O(n logn) Merge sort (Chapter 23)
T(n) = T(n - 1) + O(n) T(n) = O(n2) Selection sort
T(n) = 2T(n - 1) + O(1) T(n) = O(2n) Tower of Hanoi
T(n) = T(n - 1) + T(n - 2) + O(1) T(n) = O(2n) Recursive Fibonacci algorithm
TABLE 22.2  Common Recurrence Functions
22.4.5 Comparing Common Growth Functions
The preceding sections analyzed the complexity of several algorithms. Table 22.3 lists some 
common growth functions and shows how growth rates change as the input size doubles from 
n = 25 to n = 50.
```

</details>


## PDF page 853

<details>
<summary>Page text</summary>

```text
830 Chapter 22  Developing Efficient Algorithms
These functions are ordered as follows, as illustrated in Figure 22.1.
O(1) 6 O(logn) 6 O(n) 6 O(n logn) 6 O(n2) 6 O(n3) 6 O(2n)
FIGURE 22.1 As the size n increases, the function grows.
O(1)
O(logn)
O(n)
O(nlogn)
O(2n) O(n3) O(n2)f(n)
n
Function Name n = 25 n = 50 f(50)/f(25)
O(1) Constant time 1 1 1
O(logn) Logarithmic time 4.64 5.64 1.21
O(n) Linear time 25 50 2
O(n logn) Log-linear time 116 282 2.43
O(n2) Quadratic time 625 2,500 4
O(n3) Cubic time 15,625 125,000 8
O(2n) Exponential time 3.36 * 107 1.27 * 1015 3.35 * 107
TABLE 22.3  Change of Growth Rates
22.8 Put the following growth functions in order:
5n3
4032,4 4l o gn,1 0n logn, 500, 2n2, 2n45,3 n
22.9 Estimate the time complexity for adding two n * m matrices, and for multiplying an 
n * m matrix by an m * k matrix.
22.10 Describe an algorithm for finding the occurrence of the max element in an array. 
Analyze the complexity of the algorithm.
22.11 Describe an algorithm for removing duplicates from an array. Analyze the complex-
ity of the algorithm.
22.12 Analyze the following sorting algorithm:
for (int i = 0; i < list.length - 1; i++) {
if (list[i] > list[i + 1]) {
    swap list[i] with list[i + 1];
    i = -1;
  }
}
22.13 Analyze the complexity for computing a polynomial f (x) of degree n for a given x
value using a brute-force approach and the Horner’s approach, respectively. A brute-
force approach is to compute each term in the polynomial and add them together. The 
Horner’s approach was introduced in Section 6.7.
f(x) = anxn + an - 1xn - 1 + an - 2xn - 2 + c + a1x1 + a0
✓Point✓
Check
```

</details>


## PDF page 854

<details>
<summary>Page text</summary>

```text
22.5 Finding Fibonacci Numbers Using Dynamic Programming  831
22.5 Finding Fibonacci Numbers Using Dynamic 
Programming
This section analyzes and designs an efficient algorithm for finding Fibonacci 
numbers using dynamic programming.
Section 18.3, Case Study: Computing Fibonacci Numbers, gave a  recursive method for find-
ing the Fibonacci number, as follows:
/** The method for finding the Fibonacci number */
public static long fib(long index) {
if (index == 0) // Base case
return 0;
else if (index == 1) // Base case
return 1;
else // Reduction and recursive calls
return fib(index - 1) + fib(index - 2);
}
We can now prove that the complexity of this algorithm is O(2n). For convenience, let the 
index be n. Let T(n) denote the complexity for the algorithm that finds fib(n) and c denote the 
constant time for comparing the index with 0 and 1; that is, T(1) and T(0) are c. Thus,
T(n) = T(n - 1) + T(n - 2) + c
… 2T(n - 1) + c
… 2(2T(n - 2) + c) + c
= 22T(n - 2) + 2c + c
Similar to the analysis of the Tower of Hanoi problem, we can show that T(n) is O(2n).
However, this algorithm is not efficient. Is there an efficient algorithm for finding a Fibo-
nacci number? The trouble with the recursive fib method is that the method is invoked redun-
dantly with the same arguments. For example, to compute fib(4), fib(3) and fib(2)
are invoked. To compute fib(3), fib(2) and fib(1) are invoked. Note that fib(2) is 
redundantly invoked. We can improve it by avoiding repeatedly calling of the fib method 
with the same argument. Note that a new Fibonacci number is obtained by adding the pre-
ceding two numbers in the sequence. If you use the two variables f0 and f1 to store the two 
preceding numbers, the new number, f2, can be immediately obtained by adding f0 with f1.
Now you should update f0 and f1 by assigning f1 to f0 and assigning f2 to f1, as shown 
in Figure 22.2.
Key
Point
f0 f1 f2
Fibonacci series: 0 1 1 2 3 5 8 13 21 34 55 89 ...
         indices: 0 1 2 3 4 5 6 7 8 9 10 11
f0 f1 f2
Fibonacci series: 0 1 1 2 3 5 8 13 21 34 55 89 ...
         indices: 0 1 2 3 4 5 6 7 8 9 10 11
        f0 f1 f2
Fibonacci series: 0 1 1 2 3 5 8 13 21 34 55 89 ...
         indices: 0 1 2 3 4 5 6 7 8 9 10 11
FIGURE 22.2 Variablesf0,f1, and f2 store three consecutive Fibonacci numbers in the 
series.
```

</details>


## PDF page 855

<details>
<summary>Page text</summary>

```text
832 Chapter 22  Developing Efficient Algorithms
The new method is implemented in Listing 22.2.
LISTING 22.2 ImprovedFibonacci.java
 1 import java.util.Scanner;
 2
 3 public class ImprovedFibonacci {
 4 /** Main method */
 5 public static void main(String args[]) {
 6 // Create a Scanner
 7      Scanner input = new Scanner(System.in);
 8      System.out.print("Enter an index for the Fibonacci number: ");
 9 int index = input.nextInt();
10
11 // Find and display the Fibonacci number
12      System.out.println(
13 "Fibonacci number at index " + index + " is " + fib(index));
14    }
15
16 /** The method for finding the Fibonacci number */
17 public static long fib(long n) {
18 long f0 = 0; // For fib(0)
19 long f1 = 1; // For fib(1)
20 long f2 = 1; // For fib(2)
21
22 if (n == 0)
23 return f0;
24 else if (n == 1)
25 return f1;
26 else if (n == 2)
27 return f2; 
28
29 for (int i = 3; i <= n; i++) {
30        f0 = f1; 
31        f1 = f2;
32 f2 = f0 + f1;
33      }
34
35 return f2;
36    }
37  }
input
invokefib
f0
f1
f2
update f0, f1, f2
Enter an index for the Fibonacci number: 6
Fibonacci number at index 6 is 8 
Enter an index for the Fibonacci number: 7
Fibonacci number at index 7 is 13 
Obviously, the complexity of this new algorithm is O(n). This is a tremendous improvement 
over the recursive O(2n) algorithm.
The algorithm for computing Fibonacci numbers presented here uses an approach known 
as dynamic programming . Dynamic programming is the process of solving subproblems, 
then combining the solutions of the subproblems to obtain an overall solution. This naturally 
leads to a recursive solution. However, it would be inefficient to use recursion, because the 
O(n)
dynamic programming
```

</details>


## PDF page 856

<details>
<summary>Page text</summary>

```text
22.6 Finding Greatest Common Divisors Using Euclid’s Algorithm  833
subproblems overlap. The key idea behind dynamic programming is to solve each subproblem 
only once and store the results for subproblems for later use to avoid redundant computing of 
the subproblems.
22.14 What is dynamic programming? Give an example of dynamic programming.
22.15 Why is the recursive Fibonacci algorithm inefficient, but the nonrecursive Fibonacci 
algorithm efficient?
22.6 Finding Greatest Common Divisors Using 
Euclid’s Algorithm
This section presents several algorithms in the search for an efficient algorithm for 
finding the greatest common divisor of two integers.
The greatest common divisor  (GCD) of two integers is the largest number that can evenly 
divide both integers. Listing 5.9, GreatestCommonDivisor.java, presented a brute-force algo-
rithm for finding the greatest common divisor of two integers m and n. Brute force refers to an 
algorithmic approach that solves a problem in the simplest or most direct or obvious way. As 
a result, such an algorithm can end up doing far more work to solve a given problem than a 
cleverer or more sophisticated algorithm might do. On the other hand, a brute-force algorithm 
is often easier to implement than a more sophisticated one and, because of this simplicity, 
sometimes it can be more efficient.
The brute-force algorithm checks whether k (for k = 2, 3, 4, and so on) is a common 
divisor for n1 and n2, until k is greater than n1 or n2. The algorithm can be described as 
follows:
public static int gcd(int m, int n) {
int gcd = 1;
for (int k = 2; k <= m && k <= n; k++) {
if (m % k == 0 && n % k == 0)
      gcd = k;
  }
return gcd;
}
Assuming m Ú n, the complexity of this algorithm is obviously O(n).
Is there a better algorithm for finding the GCD? Rather than searching a possible divisor 
from1 up, it is more efficient to search from n down. Once a divisor is found, the divisor is 
the GCD. Therefore, you can improve the algorithm using the following loop:
for (int k = n; k >= 1; k--) {
if (m % k == 0 && n % k == 0) {
    gcd = k;
break;
  }
}
This algorithm is better than the preceding one, but its worst-case time complexity is still O(n).
A divisor for a number n cannot be greater than n / 2 , so you can further improve the 
algorithm using the following loop:
for (int k = m / 2; k >= 1; k--) {
if (m % k == 0 && n % k == 0) {
    gcd = k;
✓Point✓
Check
Key
Point
GCD
brute force
assume m Ú n
O(n)
improved solutions
```

</details>


## PDF page 857

<details>
<summary>Page text</summary>

```text
834 Chapter 22  Developing Efficient Algorithms
break;
  }
}
However, this algorithm is incorrect, because n can be a divisor for m. This case must be con-
sidered. The correct algorithm is shown in Listing 22.3.
LISTING 22.3 GCD.java
 1 import java.util.Scanner;
 2
 3 public class GCD {
 4 /** Find GCD for integers m and n */
 5 public static int gcd(int m, int n) {
 6 int gcd = 1;
 7
 8 if (m % n == 0) return n; 
 9
10 for (int k = n / 2; k >= 1; k--) {
11 if (m % k == 0 && n % k == 0) {
12          gcd = k; 
13 break;
14        }
15      }
16
17 return gcd;
18    }
19
20 /** Main method */
21 public static void main(String[] args) {
22 // Create a Scanner
23      Scanner input = new Scanner(System.in);
24
25 // Prompt the user to enter two integers
26      System.out.print("Enter first integer: ");
27 int m = input.nextInt();
28      System.out.print("Enter second integer: ");
29 int n = input.nextInt();
30
31      System.out.println("The greatest common divisor for " + m +
32 " and " + n + " is " + gcd(m, n));
33    }
34  }
check divisor
GCD found
input
input
Enter first integer: 2525
Enter second integer: 125
The greatest common divisor for 2525 and 125 is 25 
Enter first integer: 3
Enter second integer: 3
The greatest common divisor for 3 and 3 is 3 
Assuming m Ú n, the for loop is executed at most n/2 times, which cuts the time by half 
from the previous algorithm. The time complexity of this algorithm is still O(n), but practi-
cally, it is much faster than the algorithm in Listing 5.9.
O(n)
```

</details>


## PDF page 858

<details>
<summary>Page text</summary>

```text
22.6 Finding Greatest Common Divisors Using Euclid’s Algorithm  835
Note
The Big O notation provides a good theoretical estimate of algorithm efficiency. How-
ever, two algorithms of the same time complexity are not necessarily equally efficient. 
As shown in the preceding example, both algorithms in Listings 5.9 and 22.3 have the 
same complexity, but in practice the one in Listing 22.3 is obviously better. 
A more efficient algorithm for finding the GCD was discovered by Euclid around 300 b.c.
This is one of the oldest known algorithms. It can be defined recursively as follows: 
Letgcd(m, n) denote the GCD for integers m and n:
 ■ Ifm % n is 0,gcd (m, n) is n.
 ■ Otherwise,gcd(m, n) is gcd(n, m % n).
It is not difficult to prove the correctness of this algorithm. Suppose m % n = r . Thus, m = 
qn + r, where q is the quotient of m / n. Any number that is divisible by m and n must also 
be divisible by r. Therefore, gcd(m, n) is the same as gcd(n, r), where r = m % n. The 
algorithm can be implemented as in Listing 22.4.
LISTING 22.4 GCDEuclid.java
 1 import java.util.Scanner;
 2
 3 public class GCDEuclid {
 4 /** Find GCD for integers m and n */
 5 public static int gcd(int m, int n) {
 6 if (m % n == 0)
 7 return n;
 8 else
 9 return gcd(n, m % n); 
10    }
11
12 /** Main method */
13 public static void main(String[] args) {
14 // Create a Scanner
15      Scanner input = new Scanner(System.in);
16
17 // Prompt the user to enter two integers
18      System.out.print("Enter first integer: ");
19 int m = input.nextInt();
20      System.out.print("Enter second integer: ");
21 int n = input.nextInt();
22
23      System.out.println("The greatest common divisor for " + m +
24 " and " + n + " is " + gcd(m, n));
25    }
26  }
practical consideration
Euclid’s algorithm
base case
reduction
input
input
Enter first integer: 2525
Enter second integer: 125
The greatest common divisor for 2525 and 125 is 25 
Enter first integer: 3
Enter second integer: 3
The greatest common divisor for 3 and 3 is 3
```

</details>


## PDF page 859

<details>
<summary>Page text</summary>

```text
836 Chapter 22  Developing Efficient Algorithms
In the best case when m % n is 0, the algorithm takes just one step to find the GCD. It is dif-
ficult to analyze the average case. However, we can prove that the worst-case time complexity 
is O(log n).
Assuming m Ú n, we can show that m % n < m / 2, as follows:
 ■ Ifn <= m / 2,m % n < m / 2, since the remainder of m divided by n is always 
less than n.
 ■ Ifn > m / 2,m % n = m – n < m / 2. Therefore, m % n < m / 2.
Euclid’s algorithm recursively invokes the gcd method. It first calls gcd(m, n), then calls 
gcd(n, m % n), and gcd(m % n, n % (m % n)), and so on, as follows:
  gcd(m, n)
= gcd(n, m % n)
= gcd(m % n, n % (m % n))
= ...
Sincem % n < m / 2 and n % (m % n) < n / 2, the argument passed to the gcd method 
is reduced by half after every two iterations. After invoking gcd two times, the second 
parameter is less than n/2. After invoking gcd four times, the second parameter is less than 
n/4. After invoking gcd six times, the second parameter is less than n23. Let k be the number 
of times the gcd method is invoked. After invoking gcd k times, the second parameter is less 
than n2(k/2), which is greater than or equal to 1. That is,
n
2(k/2) Ú 1 = 7 n Ú 2(k/2) = 7 logn Ú k/2 = 7 k … 2l o gn
Therefore, k … 2l o gn. So the time complexity of the gcd method is O(logn).
The worst case occurs when the two numbers result in the most divisions. It turns out that 
two successive Fibonacci numbers will result in the most divisions. Recall that the Fibonacci 
series begins with 0 and 1, and each subsequent number is the sum of the preceding two num-
bers in the series, such as:
0  1  1  2  3  5  8  13  21  34  55  89 . . .
The series can be recursively defined as
fib(0) = 0;
fib(1) = 1;
fib(index) = fib(index - 2) + fib(index - 1); index >= 2
For two successive Fibonacci numbers fib(index) and fib(index - 1),
gcd(fib(index), fib(index - 1)) 
= gcd(fib(index - 1), fib(index - 2)) 
= gcd(fib(index - 2), fib(index - 3)) 
= gcd(fib(index - 3), fib(index - 4)) 
= ... 
= gcd(fib(2), fib(1)) 
= 1 
For example,
gcd(21, 13) 
= gcd(13, 8) 
= gcd(8, 5) 
= gcd(5, 3) 
best case
average case
worst case
```

</details>


## PDF page 860

<details>
<summary>Page text</summary>

```text
22.7 Efficient Algorithms for Finding Prime Numbers  837
= gcd(3, 2) 
= gcd(2, 1) 
= 1 
Therefore, the number of times the gcd method is invoked is the same as the index. We 
can prove that index … 1.44 logn, where n = fib(index - 1). This is a tighter bound than 
index … 2l o gn.
Table 22.4 summarizes the complexity of three algorithms for finding the GCD.
Algorithm Complexity Description
Listing 5.9 O(n) Brute-force, checking all possible divisors
Listing 22.3 O(n) Checking half of all possible divisors
Listing 22.4 O(log n) Euclid’s algorithm
TABLE 22.4  Comparisons of GCD Algorithms
22.16 Prove that the following algorithm for finding the GCD of the two integers m and n
is incorrect.
int gcd = 1;
for (int k = Math.min(Math.sqrt(n), Math.sqrt(m)); k >= 1; k--) {
if (m % k == 0 && n % k == 0) {
    gcd = k;
break;
  }
}
22.7 Efficient Algorithms for Finding Prime Numbers
This section presents several algorithms in the search for an efficient algorithm for 
finding prime numbers.
A $150,000 award awaits the first individual or group who discovers a prime number with at 
least 100,000,000 decimal digits (w2.eff.org/awards/coop-prime-rules.php).
Can you design a fast algorithm for finding prime numbers?
An integer greater than 1 is prime if its only positive divisor is 1 or itself. For example, 2,
3,5, and 7 are prime numbers, but 4,6,8, and 9 are not.
How do you determine whether a number n is prime? Listing 5.15 presented a brute-force 
algorithm for finding prime numbers. The algorithm  checks whether 2,3,4,5, . . . , or n - 1
is divisible by n. If not, n is prime. This algorithm takes O(n) time to check whether n is prime. 
Note that you need to check only whether 2,3,4,5, . . . , and n/2 is divisible by n. If not, n
is prime. This algorithm is slightly improved, but it is still of O(n).
In fact, we can prove that if n is not a prime, n must have a factor that is greater than 
1 and less than or equal to 2n. Here is the proof. Since n is not a prime, there exist two 
numbers p and q such that n = pq with 1 6 p … q. Note that n = 2n 2n. p must be 
less than or equal to 2n. Hence, you need to check only whether 2, 3, 4, 5, . . . , or 2n
is divisible by n. If not, n is prime. This significantly reduces the time complexity of the 
algorithm to O( 2n).
Now consider the algorithm for finding all the prime numbers up to n. A straightforward 
implementation is to check whether i is prime for i = 2,3,4, . . . , n. The program is given 
in Listing 22.5.
✓Point✓
Check
Key
Point
what is prime?
```

</details>


## PDF page 861

<details>
<summary>Page text</summary>

```text
838 Chapter 22  Developing Efficient Algorithms
LISTING 22.5 PrimeNumbers.java
 1 import java.util.Scanner;
 2
 3 public class PrimeNumbers {
 4 public static void main(String[] args) {
 5      Scanner input = new Scanner(System.in);
 6      System.out.print("Find all prime numbers <= n, enter n: ");
 7 int n = input.nextInt();
 8
 9 final int NUMBER_PER_LINE = 10; // Display 10 per line
10 int count = 0; // Count the number of prime numbers
11 int number = 2; // A number to be tested for primeness
12
13      System.out.println("The prime numbers are:");
14
15 // Repeatedly find prime numbers
16 while (number <= n) {
17 // Assume the number is prime
18 boolean isPrime = true; // Is the current number prime?
19
20 // Test if number is prime
21 for (int divisor = 2; divisor <= (int)(Math.sqrt(number));
22 divisor++) {
23 if (number % divisor == 0) { // If true, number is not prime
24            isPrime = false; // Set isPrime to false
25 break; // Exit the for loop
26          }
27        }
28
29 // Print the prime number and increase the count
30 if (isPrime) {
31 count++; // Increase the count
32
33 if (count % NUMBER_PER_LINE == 0) {
34 // Print the number and advance to the new line
35            System.out.printf("%7d\n", number);
36          }
37 else
38            System.out.printf("%7d", number);
39        }
40
41 // Check if the next number is prime
42 number++;
43      }
44
45      System.out.println("\n" + count + 
46 " prime(s) less than or equal to " + n);
47    }
48  }
check prime
increase count
check next number
Find all prime numbers <= n, enter n: 1000
The prime numbers are:
      2    3    5    7   11   13    17   19   23   29
     31   37   41   43   47   53    59   61   67   71
...
...
168 prime(s) less than or equal to 1000
```

</details>


## PDF page 862

<details>
<summary>Page text</summary>

```text
22.7 Efficient Algorithms for Finding Prime Numbers  839
The program is not efficient if you have to compute Math.sqrt(number) for every iteration 
of the for loop (line 21). A good compiler should evaluate Math.sqrt(number) only once 
for the entire for loop. To ensure this happens, you can explicitly replace line 21 with the 
following two lines:
int squareRoot = (int)(Math.sqrt(number));
for (int divisor = 2; divisor <= squareRoot; divisor++) {
In fact, there is no need to actually compute Math.sqrt(number) for every number. You 
need look only for the perfect squares such as 4,9,16,25,36,49, and so on. Note that for all 
the numbers between 36 and 48, inclusively, their (int)(Math.sqrt(number)) is 6. With 
this insight, you can replace the code in lines 16–26 with the following:
...
int squareRoot = 1;
// Repeatedly find prime numbers
while (number <= n) {
// Assume the number is prime
boolean isPrime = true; // Is the current number prime?
if (squareRoot * squareRoot < number) squareRoot++;
// Test if number is prime
for (int divisor = 2; divisor <= squareRoot; divisor++) {
if (number % divisor == 0) { // If true, number is not prime
      isPrime = false; // Set isPrime to false
break; // Exit the for loop
    }
  }
...
Now we turn our attention to analyzing the complexity of this program. Since it takes 2i
steps in the for loop (lines 21–27) to check whether number i is prime, the algorithm takes 
22 + 23 + 24 + c + 2n steps to find all the prime numbers less than or equal to 
n. Observe that
22 + 23 + 24 + c + 2n … n2n
Therefore, the time complexity for this algorithm is O(n2n).
To determine whether i is prime, the algorithm checks whether 2,3,4,5, . . . , and 2i are 
divisible by i. This algorithm can be further improved. In fact, you need to check only whether 
the prime numbers from 2 to 2i are possible divisors for i.
We can prove that if i is not prime, there must exist a prime number p such that i = pq and 
p … q. Here is the proof. Assume that i is not prime; let p be the smallest factor of i. p must 
be prime, otherwise, p has a factor k with 2 … k 6 p. k is also a factor of i, which contradicts 
that p be the smallest factor of i. Therefore, if i is not prime, you can find a prime number from 
2 to 2i that is divisible by i. This leads to a more efficient algorithm for finding all prime 
numbers up to n, as shown in Listing 22.6.
LISTING 22.6 EfficientPrimeNumbers.java
 1 import java.util.Scanner;
 2
 3 public class EfficientPrimeNumbers {
 4 public static void main(String[] args) {
 5      Scanner input = new Scanner(System.in);
 6      System.out.print("Find all prime numbers <= n, enter n: ");
```

</details>


## PDF page 863

<details>
<summary>Page text</summary>

```text
840 Chapter 22  Developing Efficient Algorithms
 7 int n = input.nextInt();
 8
 9 // A list to hold prime numbers
10      java.util.List<Integer> list = 
11 new java.util.ArrayList<>(); 
12
13 final int NUMBER_PER_LINE = 10; // Display 10 per line
14 int count = 0; // Count the number of prime numbers
15 int number = 2; // A number to be tested for primeness
16 int squareRoot = 1; // Check whether number <= squareRoot
17
18      System.out.println("The prime numbers are \n");
19
20 // Repeatedly find prime numbers
21 while (number <= n) {
22 // Assume the number is prime
23 boolean isPrime = true; // Is the current number prime?
24
25 if (squareRoot * squareRoot < number) squareRoot++;
26
27 // Test whether number is prime
28 for (int k = 0; k < list.size()
29                          && list.get(k) <= squareRoot; k++) {
30 if (number % list.get(k) == 0) { // If true, not prime
31            isPrime = false; // Set isPrime to false
32 break; // Exit the for loop
33          }
34        }
35
36 // Print the prime number and increase the count
37 if (isPrime) {
38          count++; // Increase the count
39          list.add(number); // Add a new prime to the list
40 if (count % NUMBER_PER_LINE == 0) {
41 // Print the number and advance to the new line
42            System.out.println(number);
43          }
44 else
45            System.out.print(number + " ");
46        }
47
48 // Check whether the next number is prime
49        number++; 
50      }
51
52      System.out.println("\n" + count + 
53 " prime(s) less than or equal to " + n);
54    }
55  }
check prime
increase count
check next number
Find all prime numbers <= n, enter n: 1000
The prime numbers are:
      2      3      5      7     11     13     17     19     23     29
     31     37     41     43     47     53     59     61     67     71
...
...
168 prime(s) less than or equal to 1000
```

</details>


## PDF page 864

<details>
<summary>Page text</summary>

```text
22.7 Efficient Algorithms for Finding Prime Numbers  841
Let p (i) denote the number of prime numbers less than or equal to i. The primes under 20
are2,3,5,7,11,13,17, and 19. Therefore, p (2) is 1, p (3) is 2, p (6) is 3, and p (20) is 8.
It has been proved that p (i) is approximately ilogi (see primes.utm.edu/howmany.shtml).
For each number i, the algorithm checks whether a prime number less than or equal to 2i
is divisible by i. The number of the prime numbers less than or equal to 2i is
2i
log2i
= 22ilogi
Thus, the complexity for finding all prime numbers up to n is
222
log 2 + 223log 3 + 224log 4 + 225log 5 + 226log 6 + 227log 7 + 228log 8 + c + 22nlogn
Since 2ilogi 6 2nlogn for i 6 n and n Ú 16,
222
log 2 + 223log 3 + 224log 4 + 225log 5 + 226log 6 + 227log 7 + 228log 8 + c + 22nlogn 6 2n2nlogn
Therefore, the complexity of this algorithm is O¢ n2nlogn ≤.
This algorithm is another example of dynamic programming. The algorithm stores the 
results of the subproblems in the array list and uses them later to check whether a new number 
is prime.
Is there any algorithm better than O¢ n2nlogn ≤? Let us examine the well-known Eratosthenes 
algorithm for finding prime numbers. Eratosthenes (276–194 b.c.) was a Greek mathematician
who devised a clever algorithm, known as the Sieve of Eratosthenes, for finding all prime num-
bers … n. His algorithm is to use an array named primes of n Boolean values. Initially, all 
elements in primes are set true. Since the multiples of 2 are not prime, set primes[2 * i]
tofalse for all 2 … i … n/2, as shown in Figure 22.3. Since we don’t care about primes[0]
andprimes[1], these values are marked *  in the figure.
dynamic programming
Sieve of Eratosthenes
FIGURE 22.3 The values in primes are changed with each prime number k.
/H11003/H11003 TTTTTTTTTT T T TTT TT TTT TTTT TTinitial
0    1     2    3    4     5    6     7    8    9    10   11   12   13   14   15   16   17   18   19   20   21  22   23   24  25   26   27
k = 2 
index
primes array
/H11003/H11003 TTFTFT FTFT F T F TF TF TFT FT FT FT
k = 3 /H11003/H11003 TTFTFT FFFT F T F FF TF TFF FT FT FF
k = 5 /H11003/H11003 TTFTFT FFFT F T F FF TF TFF FT FF FF
Since the multiples of 3 are not prime, set primes[3 * i] to false for all 3 … i … n/3.
Because the multiples of 5 are not prime, set primes[5 * i] to false for all 5 … i … n/5.
Note that you don’t need to consider the multiples of 4, because the multiples of 4 are also the 
multiples of 2, which have already been considered. Similarly, multiples of 6,8, and 9 need 
not be considered. You only need to consider the multiples of a prime number k = 2,3,5,7,
11, . . . , and set the corresponding element in primes to false. Afterward, if primes[i] is
```

</details>


## PDF page 865

<details>
<summary>Page text</summary>

```text
842 Chapter 22  Developing Efficient Algorithms
still true, then i is a prime number. As shown in Figure 22.3, 2,3,5,7,11,13,17,19, and 23
are prime numbers. Listing 22.7 gives the program for finding the prime numbers using the 
Sieve of Eratosthenes algorithm.
LISTING 22.7 SieveOfEratosthenes.java
 1 import java.util.Scanner;
 2
 3 public class SieveOfEratosthenes {
 4 public static void main(String[] args) {
 5      Scanner input = new Scanner(System.in);
 6      System.out.print("Find all prime numbers <= n, enter n: ");
 7 int n = input.nextInt();
 8
 9 boolean[] primes = new boolean[n + 1]; // Prime number sieve
10
11 // Initialize primes[i] to true
12 for (int i = 0; i < primes.length; i++) {
13 primes[i] = true;
14      }
15
16 for (int k = 2; k <= n / k; k++) {
17 if (primes[k]) {
18 for (int i = k; i <= n / k; i++) {
19 primes[k * i] = false; // k * i is not prime
20          }
21        }
22      }
23
24 int count = 0; // Count the number of prime numbers found so far
25 // Print prime numbers
26 for (int i = 2; i < primes.length; i++) {
27 if (primes[i]) {
28          count++;
29 if (count % 10 == 0)
30            System.out.printf("%7d\n", i);
31 else
32            System.out.printf("%7d", i);
33        }
34      }
35
36      System.out.println("\n" + count + 
37 " prime(s) less than or equal to " + n);
38    }
39  }
sieve
initialize sieve
nonprime
Find all prime numbers <= n, enter n: 1000
The prime numbers are:
      2      3      5      7     11     13     17     19     23     29
     31     37     41     43     47     53     59     61     67     71
...
...
168 prime(s) less than or equal to 1000
Note that k <= n / k (line 16). Otherwise, k * i would be greater than n (line 19). What 
is the time complexity of this algorithm?
```

</details>


## PDF page 866

<details>
<summary>Page text</summary>

```text
22.8 Finding the Closest Pair of Points Using Divide-and-Conquer  843
For each prime number k (line 17), the algorithm sets primes[k * i] to false (line 19). 
This is performed n / k – k + 1 times in the for loop (line 18). Thus, the complexity for 
finding all prime numbers up to n is
n
2 - 2 + 1 + n3 - 3 + 1 + n5 - 5 + 1 + n7 - 7 + 1 + n11 - 11 + 1 c
= O¢ n2 + n3 + n5 + n7 + n11 + c≤ 6 O(np(n))
= O¢n 2nlogn≤
Algorithm Complexity Description
Listing 5.15 O(n2) Brute-force, checking all possible divisors
Listing 22.5 O(n2n) Checking divisors up to 2n
Listing 22.6 O¢ n2nlogn ≤ Checking prime divisors up to 2n
Listing 22.7 O¢ n2nlogn ≤ Sieve of Eratosthenes
TABLE 22.5  Comparisons of Prime-Number Algorithms
22.17 Prove that if n is not prime, there must exist a prime number p such that p 6 = 2n
and p is a factor of n.
22.18 Describe how the sieve of Eratosthenes is used to find the prime numbers.
22.8 Finding the Closest Pair of Points Using 
Divide-and-Conquer
This section presents efficient algorithms for finding the closest pair of points using 
divide-and-conquer.
Given a set of points, the closest-pair problem is to find the two points that are nearest to 
each other. As shown in Figure 22.4, a line is drawn to connect the two nearest points in the 
closest-pair animation.
Section 8.6, Case Study: Finding the Closest Pair, presented a brute-force algorithm for 
finding the closest pair of points. The algorithm computes the distances between all pairs of 
points and finds the one with the minimum distance. Clearly, the algorithm takes O(n2) time. 
Can we design a more efficient algorithm?
✓Point✓
Check
Key
Point
closest-pair animation on 
Companion Website
The number of items in 
the series is p(n).
This upper bound O¢ n2nlogn ≤ is very loose. The actual time complexity is much better than 
O¢ n2nlogn ≤. The Sieve of Eratosthenes algorithm is good for a small n such that the array 
primes can fit in the memory.
Table 22.5 summarizes the complexity of these three algorithms for finding all prime num-
bers up to n.
```

</details>


## PDF page 867

<details>
<summary>Page text</summary>

```text
844 Chapter 22  Developing Efficient Algorithms
We will use an approach called divide-and-conquer to solve this problem. The approach 
divides the problem into subproblems, solves the subproblems, then combines the solutions of 
the subproblems to obtain the solution for the entire problem. Unlike the dynamic program-
ming approach, the subproblems in the divide-and-conquer approach don’t overlap. A sub-
problem is like the original problem with a smaller size, so you can apply recursion to solve 
the problem. In fact, all the solutions for recursive problems follow the divide-and-conquer 
approach.
Listing 22.8 describes how to solve the closest pair problem using the divide-and-conquer 
approach.
LISTING 22.8 Algorithm for Finding the Closest Pair
Step 1: Sort the points in increasing order of x-coordinates. For the 
points with the same x-coordinates, sort on y-coordinates. This results 
in a sorted list S of points.
Step 2: Divide S into two subsets, S1 and S2, of equal size using the 
midpoint in the sorted list. Let the midpoint be in S1. Recursively find 
the closest pair in S1 and S2. Let d1 and d2 denote the distance of the 
closest pairs in the two subsets, respectively. 
Step 3: Find the closest pair between a point in S1 and a point in S2 and 
denote their distance as d3. The closest pair is the one with the dis-
tance min(d1, d2, d3).
Selection sort takes O(n2) time. In Chapter 23 we will introduce merge sort and heap sort.
These sorting algorithms take O(n log n) time. Step 1 can be done in O(n log n) time.
Step 3 can be done in O(n) time. Let d = min(d1, d2). We already know that the closest-
pair distance cannot be larger than d. For a point in S1 and a point in S2 to form the closest 
pair in S, the left point must be in stripL and the right point in stripR, as illustrated in 
Figure 22.5a.
For a point p in stripL, you need only consider a right point within the d * 2d rectangle, 
as shown in 22.5b. Any right point outside the rectangle cannot form the closest pair with 
p. Since the closest-pair distance in S2 is greater than or equal to d, there can be at most six 
points in the rectangle. Thus, for each point in stripL, at most six points in stripR need to 
be considered.
For each point p in stripL, how do you locate the points in the corresponding d * 2d
rectangle area in stripR? This can be done efficiently if the points in stripL and stripR
are sorted in increasing order of their y-coordinates. Let pointsOrderedOnY be the list of 
the points sorted in increasing order of y-coordinates.pointsOrderedOnY can be obtained 
beforehand in the algorithm. stripL and stripR can be obtained from pointsOrderedOnY
in Step 3 as shown in Listing 22.9.
divide-and-conquer
FIGURE 22.4 The closet-pair animation draws a line to connect the closest pair of points 
dynamically as points are added and removed interactively.
```

</details>


## PDF page 868

<details>
<summary>Page text</summary>

```text
22.8 Finding the Closest Pair of Points Using Divide-and-Conquer  845
LISTING 22.9 Algorithm for Obtaining stripL and stripR
 1 for each point p in pointsOrderedOnY
 2 if (p is in S1 and mid.x – p.x <= d)
 3      append p to stripL; 
 4 else if (p is in S2 and p.x - mid.x <= d)
 5      append p to stripR;
Let the points in stripL and stripR be {p0, p1, c , pk} and {q0, q1, c , qt}, as shown in 
Figure 22.5c. The closest pair between a point in stripL and a point in stripR can be found 
using the algorithm described in Listing 22.10.
LISTING 22.10 Algorithm for Finding the Closest Pair 
in Step 3
 1  d = min(d1, d2);
 2  r = 0; // r is the index of a point in stripR
 3 for (each point p in stripL) {
 4 // Skip the points in stripR below p.y - d
 5 while (r < stripR.length && q[r].y <= p.y - d)
 6      r++; 
 7
 8    let r1 = r;
 9 while (r1 < stripR.length && |q[r1].y – p.y| <= d) {
10 // Check if (p, q[r1]) is a possible closest pair
11 if (distance(p, q[r1]) < d) {
12        d = distance(p, q[r1]); 
13        (p, q[r1]) is now the current closest pair;
14      }
15
16      r1 = r1 + 1;
17    }
18  }
The points in stripL are considered from p0, p1, c , pk in this order. For a point p in 
stripL, skip the points in stripR that are below p.y – d  (lines 5–6). Once a point is 
skipped, it will no longer be considered. The while loop (lines 9–17) checks whether (p,
q[r1]) is a possible closest pair. There are at most six such q[r1] pairs, because the distance 
between two points in stripR cannot be less than d. So the complexity for finding the closest 
pair in Step 3 is O(n).
stripL
stripR
update closest pair
FIGURE 22.5 The midpoint divides the points into two sets of equal size.
mid
d2
d1
d
(a) (b) (c)
d
stripL stripR
S1 S2
dd
stripLstripR
p d p
q[r]
stripL stripR
```

</details>


## PDF page 869

<details>
<summary>Page text</summary>

```text
846 Chapter 22  Developing Efficient Algorithms
Note that Step 1 in Listing 22.8 is performed only once to presort the points. Assume that 
all the points are presorted. Let T(n) denote the time complexity for this algorithm. Thus,
Step 2 Step 3
T(n) = 2T(n/2) + O(n) = O(n logn)
Therefore, the closest pair of points can be found in O(n log n) time. The complete implemen-
tation of this algorithm is left as an exercise (see Programming Exercise 22.7).
22.19 What is the divide-and-conquer approach? Give an example.
22.20 What is the difference between divide-and-conquer and dynamic programming?
22.21 Can you design an algorithm for finding the minimum element in a list using divide-
and-conquer? What is the complexity of this algorithm?
22.9 Solving the Eight Queens Problem Using 
Backtracking
This section solves the Eight Queens problem using the backtracking approach.
The Eight Queens problem is to find a solution to place a queen in each row on a chessboard 
such that no two queens can attack each other. The problem can be solved using recursion (See 
Programming Exercise 18.34). In this section, we will introduce a common algorithm design 
technique called backtracking for solving this problem. The backtracking approach searches 
for a candidate solution incrementally, abandoning that option as soon as it determines that the 
candidate cannot possibly be a valid solution, and then looks for a new candidate.
You can use a two-dimensional array to represent a chessboard. However, since each row 
can have only one queen, it is sufficient to use a one-dimensional array to denote the position 
of the queen in the row. Thus, you can define the queens array as:
int[] queens = new int[8];
Assignj to queens[i] to denote that a queen is placed in row i and column j. Figure 22.6a 
shows the contents of the queens array for the chessboard in Figure 22.6b.
✓Point✓
Check
Key
Point
backtracking
FIGURE 22.6 queens[i] denotes the position of the queen in row i.
(a) (b)
0
4
7
5
2
6
1
3
queens[0]
queens[1]
queens[2]
queens[3]
queens[4]
queens[5]
queens[6]
queens[7]
The search starts from the first row with k = 0, where k is the index of the current row 
being considered. The algorithm checks whether a queen can be possibly placed in the jth
column in the row for j = 0, 1, c , 7, in this order. The search is implemented as follows:
 ■ If successful, it continues to search for a placement for a queen in the next row. If the 
current row is the last row, a solution is found.
 ■ If not successful, it backtracks to the previous row and continues to search for a new 
placement in the next column in the previous row.
 ■ If the algorithm backtracks to the first row and cannot find a new placement for a 
queen in this row, no solution can be found.
search algorithm
Eight Queens animation on 
the Companion Website
```

</details>


## PDF page 870

<details>
<summary>Page text</summary>

```text
22.9 Solving the Eight Queens Problem Using Backtracking  847
To see how the algorithm works, go to www.cs.armstrong.edu/liang/animation/
EightQueensAnimation.html.
Listing 22.11 gives the program that displays a solution for the Eight Queens problem.
LISTING 22.11 EightQueens.java
  1 import javafx.application.Application;
  2 import javafx.geometry.Pos;
  3 import javafx.stage.Stage;
  4 import javafx.scene.Scene;
  5 import javafx.scene.control.Label;
  6 import javafx.scene.image.Image;
  7 import javafx.scene.image.ImageView;
  8 import javafx.scene.layout.GridPane;
  9
 10 public class EightQueens extends Application {
 11 public static final int SIZE = 8; // The size of the chess board
 12 // queens are placed at (i, queens[i])
 13 // -1 indicates that no queen is currently placed in the ith row
 14 // Initially, place a queen at (0, 0) in the 0th row
 15 private int[] queens = {-1, -1, -1, -1, -1, -1, -1, -1};
 16
 17    @Override // Override the start method in the Application class
 18 public void start(Stage primaryStage) {
 19 search(); // Search for a solution 
 20
 21 // Display chess board
 22      GridPane chessBoard = new GridPane();
 23      chessBoard.setAlignment(Pos.CENTER);
 24      Label[][] labels = new Label[SIZE][SIZE];
 25 for (int i = 0; i < SIZE; i++)
 26 for (int j = 0; j < SIZE; j++) {
 27          chessBoard.add(labels[i][j] = new Label(), j, i);
 28          labels[i][j].setStyle("-fx-border-color: black");
 29          labels[i][j].setPrefSize(55, 55);
 30        }
 31
 32 // Display queens
 33      Image image = new Image("image/queen.jpg");
 34 for (int i = 0; i < SIZE; i++)
 35        labels[i][queens[i]].setGraphic(new ImageView(image));
 36
 37 // Create a scene and place it in the stage
 38      Scene scene = new Scene(chessBoard, 55 * SIZE, 55 * SIZE);
 39      primaryStage.setTitle("EightQueens"); // Set the stage title
 40      primaryStage.setScene(scene); // Place the scene in the stage
 41      primaryStage.show(); // Display the stage
 42    }
 43
 44 /** Search for a solution */
 45 private boolean search() {
 46 // k - 1 indicates the number of queens placed so far
 47 // We are looking for a position in the kth row to place a queen
 48 int k = 0;
 49 while (k >= 0 && k < SIZE) {
 50 // Find a position to place a queen in the kth row
 51 int j = findPosition(k);
 52 if (j < 0) {
 53 queens[k] = -1;
 54 k--; // back track to the previous row
 55        } else {
queen positions
search for solution
find a column
create cells
set queen image
backtrack
```

</details>


## PDF page 871

<details>
<summary>Page text</summary>

```text
848 Chapter 22  Developing Efficient Algorithms
 56 queens[k] = j;
 57 k++;
 58        }
 59      }
 60
 61 if (k == -1)
 62 return false; // No solution
 63 else
 64 return true; // A solution is found
 65    }
 66
 67 public int findPosition(int k) {
 68 int start = queens[k] + 1; // Search for a new placement
 69
 70 for (int j = start; j < SIZE; j++) {
 71 if (isValid(k, j))
 72 return j; // (k, j) is the place to put the queen now
 73      }
 74
 75 return -1;
 76    }
 77
 78 /** Return true if a queen can be placed at (row, column) */
 79 public boolean isValid(int row, int column) {
 80 for (int i = 1; i <= row; i++)
 81 if (queens[row - i] == column // Check column
 82          || queens[row - i] == column - i // Check upleft diagonal
 83          || queens[row - i] == column + i) // Check upright diagonal
 84 return false; // There is a conflict
 85 return true; // No conflict
 86    }
 87  }
The program invokes search() (line 19) to search for a solution. Initially, no queens are 
placed in any rows (line 15). The search now starts from the first row with k = 0 (line 48) and 
finds a place for the queen (line 51). If successful, place it in the row (line 56) and consider the 
next row (line 57). If not successful, backtrack to the previous row (lines 53–54).
ThefindPosition(k) method searches for a possible position to place a queen in row 
k starting from queen[k] + 1 (line 68). It checks whether a queen can be placed at start,
start + 1 , . . . , and 7, in this order (lines 70–73). If possible, return the column index 
(line 72); otherwise, return -1 (line 75).
TheisValid(row, column) method is called to check whether placing a queen at the 
specified position causes a conflict with the queens placed earlier (line 71). It ensures that no 
queen is placed in the same column (line 81), in the upper-left diagonal (line 82), or in the 
upper-right diagonal (line 83), as shown in Figure 22.7.
place a queen
search the next row
FIGURE 22.7 InvokingisValid(row, column) checks whether a queen can be placed at 
(row, column).
01234567
0
1
2
3
4
5
6
7
upright diagonal
check
column
upleft
(row, column)
```

</details>


## PDF page 872

<details>
<summary>Page text</summary>

```text
22.10 Computational Geometry: Finding a Convex Hull  849
22.22 What is backtracking? Give an example.
22.23 If you generalize the Eight Queens problem to the n-Queens problem in an n-by-n
chessboard, what will be the complexity of the algorithm?
22.10 Computational Geometry: Finding a Convex Hull
This section presents efficient geometric algorithms for finding a convex hull for a set 
of points.
Computational geometry is to study the algorithms for geometrical problems. It has appli-
cations in computer graphics, games, pattern recognition, image processing, robotics, geo-
graphical information systems, and computer-aided design and manufacturing. Section 22.8 
presented a geometrical algorithm for finding the closest pair of points. This section intro-
duces geometrical algorithms for finding a convex hull.
Given a set of points, a convex hull is the smallest convex polygon that encloses all these 
points, as shown in Figure 22.8a. A polygon is convex if every line connecting two vertices is 
inside the polygon. For example, the vertices v0, v1, v2, v3, v4, and v5 in Figure 22.8a form 
a convex polygon, but not in Figure 22.8b, because the line that connects v3 and v1 is not 
inside the polygon.
✓Point✓
Check
Key
Point
convex hull
FIGURE 22.8 A convex hull is the smallest convex polygon that contains a set of points.
(a) A convex hull (b) A nonconvex polygon (c) Convex hull animation
v3
v2
v1
v4
v5 v0 v1
v3
v2
v0v5
v4
A convex hull has many applications in game programming, pattern recognition, and 
image processing. Before we introduce the algorithms, it is helpful to get acquainted with the 
concept using an interactive tool from www.cs.armstrong.edu/liang/animation/ConvexHull.html, as 
shown in Figure 22.8c. This tool allows you to add and remove points and displays the convex 
hull dynamically.
Many algorithms have been developed to find a convex hull. This section introduces two 
popular algorithms: the gift-wrapping algorithm and Graham’s algorithm.
22.10.1 Gift-Wrapping Algorithm
An intuitive approach, called the gift-wrapping algorithm, works as shown in Listing 22.12:
LISTING 22.12 Finding a Convex Hull Using Gift-
Wrapping Algorithm
Step 1: Given a list of points S, let the points in S be labeled s0, s1,
..., sk. Select the rightmost lowest point S. As shown in Figure 22.9a, 
h0 is such a point. Add h0 to list H. (H is initially empty. H will hold 
all points in the convex hull after the algorithm is finished.) Let t0
be h0.
convex hull animation on the 
Companion Website
```

</details>


## PDF page 873

<details>
<summary>Page text</summary>

```text
850 Chapter 22  Developing Efficient Algorithms
Step 2: Let t1 be s0.
        For every point p in S,
          if p is on the right side of the direct line from t0 to t1, then
            let t1 be p.
(After Step 2, no points lie on the right side of the direct line from t0
to t1, as shown in Figure 22.9b.)
Step 3: If t1 is h0 (see Figure 22.9d), the points in H form a convex 
hull for S. Otherwise, add t1 to H, let t0 be t1, and go back to Step 2 
(see Figure 22.9c).
The convex hull is expanded incrementally. The correctness is supported by the fact that no 
points lie on the right side of the direct line from t0 to t1 after Step 2. This ensures that every 
line segment with two points in S falls inside the polygon.
Finding the rightmost lowest point in Step 1 can be done in O(n) time. Whether a point is 
on the left side of a line, right side, or on the line can be determined in O(1) time (see Program-
ming Exercise 3.32). Thus, it takes O(n) time to find a new point t1 in Step 2. Step 2 is repeated 
h times, where h is the size of the convex hull. Therefore, the algorithm takes O(hn) time. In 
the worst-case, h is n.
The implementation of this algorithm is left as an exercise (see Programming Exercise 22.9).
22.10.2 Graham’s Algorithm
A more efficient algorithm was developed by Ronald Graham in 1972, as shown in Listing 22.13.
LISTING 22.13 Finding a Convex Hull Using Graham's 
Algorithm
Step 1: Given a list of points S, select the rightmost lowest point and 
name it p0. As shown in Figure 22.10a, p0 is such a point.
correctness of the algorithm
time complexity of the 
algorithm
FIGURE 22.9 (a) h0 is the rightmost lowest point in S. (b) Step 2 finds point t1. (c) A convex hull is expanded repeatedly. 
(d) A convex hull is found when t1 becomes h0.
(a) Step 1 (b) Step 2 (c) Repeat Step 2 (d) H is found
t1 = h0t0
t0
t1
t1
t0h0
FIGURE 22.10 (a) p0 is the rightmost lowest point in S. (b) Points are sorted by their angles. (c–d) A convex hull is 
discovered incrementally.
(a) Step 1 (b) Step 2 (c) p3 into H (d) p2 off H
p0 p0 p0 p0
XX
p1 p1
p1p2 p2 p2p3 p3
x-axis x-axis x-axis
Step 2: Sort the points in S angularly along the x-axis with p0 as the 
center, as shown in Figure 22.10b. If there is a tie and two points have 
the same angle, discard the one that is closer to p0. The points in S are 
now sorted as p0, p1, p2, ..., pn-1.
```

</details>


## PDF page 874

<details>
<summary>Page text</summary>

```text
Step 3: Push p0, p1, and p2 into stack H. (After the algorithm finishes, 
H contains all the points in the convex hull.)
Step 4:
     i = 3;
     while (i < n) {
       Let t1 and t2 be the top first and second element in stack H;
       if (pi is on the left side of the direct line from t2 to t1) {
         Push pi to H;
         i++; // Consider the next point in S.
       }
       else
         Pop the top element off stack H.
     }
Step 5: The points in H form a convex hull.
The convex hull is discovered incrementally. Initially, p0, p1,and p2 form a convex hull. 
Consider p3. p3 is outside of the current convex hull since points are sorted in increasing order 
of their angles. If p3 is strictly on the left side of the line from p1 to p2 (see Figure 22.10c), 
push p3 into H. Now p0, p1, p2, and p3 form a convex hull. If p3 is on the right side of the line 
from p1 to p2 (see Figure 22.10d), pop p2 out of H and push p3 into H. Now p0, p1, and p3
form a convex hull and p2 is inside of this convex hull. You can prove by induction that all the 
points in H in Step 5 form a convex hull for all the points in the input list S.
Finding the rightmost lowest point in Step 1 can be done in O(n) time. The angles can be 
computed using trigonometry functions. However, you can sort the points without actually 
computing their angles. Observe that p2 would make a greater angle than p1 if and only if p2
lies on the left side of the line from p0 to p1. Whether a point is on the left side of a line can 
be determined in O(1) time, as shown in Programming Exercise 3.32. Sorting in Step 2 can be 
done in O(n log n) time using the merge-sort or heap-sort algorithms that will be introduced 
in Chapter 23. Step 4 can be done in O(n) time. Therefore, the algorithm takes O(n logn) time.
The implementation of this algorithm is left as an exercise (see Programming Exercise 22.11).
22.24 What is a convex hull?
22.25 Describe the gift-wrapping algorithm for finding a convex hull. Should list H be 
implemented using an ArrayList or a LinkedList?
22.26 Describe Graham’s algorithm for finding a convex hull. Why does the algorithm use 
a stack to store the points in a convex hull?
correctness of the algorithm
time complexity of the 
algorithm
✓Point✓
Check
KEY TERMS
average-case analysis 822
backtracking approach 846
best-case input 822
Big O notation 822
brute force 833
constant time 823
convex hull 849
divide-and-conquer approach 844
dynamic programming approach 832
exponential time 829
growth rate 822
logarithmic time 828
quadratic time 825
space complexity 823
time complexity 823
worst-case input 822
CHAPTER SUMMARY
1. The Big O notation  is a theoretical approach for analyzing the performance of an 
algorithm. It estimates how fast an algorithm’s execution time increases as the input 
size increases, which enables you to compare two algorithms by examining their 
growth rates.
Chapter Summary  851
```

</details>


## PDF page 875

<details>
<summary>Page text</summary>

```text
852 Chapter 22  Developing Efficient Algorithms
2. An input that results in the shortest execution time is called the best-case input and one 
that results in the longest execution time is called the worst-case input. Best case and 
worst case are not representative, but worst-case analysis is very useful. You can be 
assured that the algorithm will never be slower than the worst case.
3. An average-case analysis attempts to determine the average amount of time among all 
possible input of the same size. Average-case analysis is ideal, but difficult to perform, 
because for many problems it is hard to determine the relative probabilities and distribu-
tions of various input instances.
4. If the time is not related to the input size, the algorithm is said to take constant time with 
the notation O(1).
5. Linear search takes O(n) time. An algorithm with the O(n) time complexity is called a 
linear algorithm and it exhibits a linear growth rate. Binary search takes O(logn) time. 
An algorithm with the O(log n) time complexity is called a logarithmic algorithm, and 
it exhibits a logarithmic growth rate.
6. The worst-time complexity for selection sort is O(n2). An algorithm with the O(n2) time 
complexity is called a quadratic algorithm, and it exhibits a quadratic growth rate.
7. The time complexity for the Tower of Hanoi problem is O(2n). An algorithm with the 
O(2n) time complexity is called an exponential algorithm, and it exhibits an exponential 
growth rate.
8. A Fibonacci number at a given index can be found in O(n) time using dynamic 
programming.
9. Dynamic programming is the process of solving subproblems, then combining the solu-
tions of the subproblems to obtain an overall solution. The key idea behind dynamic 
programming is to solve each subproblem only once and store the results for subprob-
lems for later use to avoid redundant computing of the subproblems.
10. Euclid’s GCD algorithm takes O(log n) time.
11. All prime numbers less than or equal to n can be found in O¢ n2nlog n≤ time.
12. The closest pair can be found in O(n log n) time using the divide-and-conquer approach .
13. The divide-and-conquer approach divides the problem into subproblems, solves the 
subproblems, then combines the solutions of the subproblems to obtain the solution for 
the entire problem. Unlike the dynamic programming approach, the subproblems in the 
divide-and-conquer approach don’t overlap. A subproblem is like the original problem 
with a smaller size, so you can apply recursion to solve the problem.
14. The Eight Queens problem can be solved using backtracking.
15. The backtracking approach searches for a candidate solution incrementally, abandoning 
that option as soon as it determines that the candidate cannot possibly be a valid solu-
tion, and then looks for a new candidate.
16. A convex hull for a set of points can be found in O(n2) time using the gift-wrapping 
algorithm and in O(n logn) time using the Graham’s algorithm.
```

</details>


## PDF page 876

<details>
<summary>Page text</summary>

```text
Programming Exercises  853
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/test.html.
PROGRAMMING EXERCISES
*22.1 (Maximum consecutive increasingly ordered substring ) Write a program that 
prompts the user to enter a string and displays the maximum consecutive 
increasingly ordered substring. Analyze the time complexity of your program. 
Here is a sample run:
Enter a string:abcabcdgabxy
abcdg
Enter a string: abcabcdgabmnsxy
abmnsxy
Enter a string: Welcome
Welo
Enter a string s1: Welcome to Java
Enter a string s2: come
matched at index 3 
Enter a string s1: Mississippi
Enter a string s2: sip
matched at index 6 
**22.2 (Maximum increasingly ordered subsequence ) Write a program that prompts 
the user to enter a string and displays the maximum increasingly ordered sub-
sequence of characters. Analyze the time complexity of your program. Here is 
a sample run:
*22.3 (Pattern matching) Write a program that prompts the user to enter two strings 
and tests whether the second string is a substring of the first string. Suppose
the neighboring characters in the string are distinct.  (Don’t use the indexOf
method in the String class.) Analyze the time complexity of your algorithm. 
Your algorithm needs to be at least O(n) time. Here is a sample run of the 
program:
*22.4 (Pattern matching) Write a program that prompts the user to enter two strings 
and tests whether the second string is a substring of the first string. (Don’t use 
the indexOf method in the String class.) Analyze the time complexity of 
your algorithm. Here is a sample run of the program:
```

</details>


## PDF page 877

<details>
<summary>Page text</summary>

```text
854 Chapter 22  Developing Efficient Algorithms
*22.5 (Same-number subsequence) Write an O(n) program that prompts the user to 
enter a sequence of integers ending with 0 and finds the longest subsequence 
with the same number. Here is a sample run of the program:
Enter a series of numbers ending with 0: 
2 4 4 8 8 8 8 2 4 4 0
The longest same number sequence starts at index 3 with 4 values of 8 
40 41 42 43 44 45
Listing 22.3 GCD
Listing 22.4 GCDEuclid
*22.6 (Execution time for GCD) Write a program that obtains the execution time for 
finding the GCD of every two consecutive Fibonacci numbers from the index 
40 to index 45 using the algorithms in Listings 22.3 and 22.4. Your program 
should print a table like this:
(Hint: You can use the following code template to obtain the execution time.)
long startTime = System.currentTimeMillis();
perform the task;
long endTime = System.currentTimeMillis();
long executionTime = endTime - startTime;
**22.7 (Closest pair of points ) Section 22.8 introduced an algorithm for finding the 
closest pair of points using a divide-and-conquer approach. Implement the 
algorithm to meet the following requirements:
■  Define the classes Point and CompareY in the same way as in Programming
Exercise 20.4.
■  Define a class named Pair with the data fields p1 and p2 to represent two 
points, and a method named getDistance() that returns the distance 
between the two points.
■  Implement the following methods:
/** Return the distance of the closest pair of points */
public static Pair getClosestPair(double[][] points) 
/** Return the distance of the closest pair of points */
public static Pair getClosestPair(Point[] points) 
  /** Return the distance of the closest pair of points 
 * in pointsOrderedOnX[low..high]. This is a recursive 
 * method. pointsOrderedOnX and pointsOrderedOnY are 
 * not changed in the subsequent recursive calls.
 */
public static Pair distance(Point[] pointsOrderedOnX, 
int low, int high, Point[] pointsOrderedOnY)
```

</details>


## PDF page 878

<details>
<summary>Page text</summary>

```text
Programming Exercises  855
/** Compute the distance between two points p1 and p2 */
public static double distance(Point p1, Point p2) 
/** Compute the distance between points (x1, y1) and (x2, y2) */
public static double distance(double x1, double y1, 
double x2, double y2) 
**22.8 (All prime numbers up to 10,000,000,000) Write a program that finds 
all prime numbers up to 10,000,000,000. There are approximately 
455,052,511 such prime numbers. Your program should meet the following 
requirements:
■  Your program should store the prime numbers in a binary data file, named 
PrimeNumbers.dat. When a new prime number is found, the number is 
appended to the file.
■  To find whether a new number is prime, your program should load the 
prime numbers from the file to an array of the long type of size 10000.
If no number in the array is a divisor for the new number, continue to read 
the next 10000 prime numbers from the data file, until a divisor is found 
or all numbers in the file are read. If no divisor is found, the new number 
is prime.
■  Since this program takes a long time to finish, you should run it as a batch 
job from a UNIX machine. If the machine is shut down and rebooted, your 
program should resume by using the prime numbers stored in the binary data 
file rather than start over from scratch.
**22.9 (Geometry: gift-wrapping algorithm for finding a convex hull) Section 22.10.1 
introduced the gift-wrapping algorithm for finding a convex hull for a set of 
points. Assume that the Java’s coordinate system is used for the points. Imple-
ment the algorithm using the following method:
/** Return the points that form a convex hull */
public static ArrayList<Point2D> getConvexHull(double[][] s) 
Point2D is defined in Section 9.6.
  Write a test program that prompts the user to enter the set size and the points 
and displays the points that form a convex hull. Here is a sample run:
How many points are in the set? 6
Enter 6 points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
The convex hull is 
  (1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)       
22.10 (Number of prime numbers) Programming Exercise 22.8 stores the prime num-
bers in a file named PrimeNumbers.dat. Write a program that finds the num-
ber of prime numbers that are less than or equal to 10, 100, 1,000, 10,000,
100,000, 1,000,000, 10,000,000, 100,000,000, 1,000,000,000, and 
10,000,000,000. Your program should read the data from PrimeNumbers.dat.
```

</details>


## PDF page 879

<details>
<summary>Page text</summary>

```text
856 Chapter 22  Developing Efficient Algorithms
**22.11 (Geometry: Graham’s algorithm for finding a convex hull ) Section  22.10.2 
introduced Graham’s algorithm for finding a convex hull for a set of points. 
Assume that the Java’s coordinate system is used for the points. Implement the 
algorithm using the following method:
/** Return the points that form a convex hull */
public static ArrayList<MyPoint> getConvexHull(double[][] s) 
MyPoint is a static inner class defined as follows:
private static class MyPoint implements Comparable<MyPoint> {
double x, y;
    MyPoint rightMostLowestPoint;
    MyPoint(double x, double y) {
this.x = x; this.y = y;
    }
public void setRightMostLowestPoint(MyPoint p) {
rightMostLowestPoint = p;
    }
    @Override
public int compareTo(MyPoint o) {
// Implement it to compare this point with point o 
// angularly along the x-axis with rightMostLowestPoint 
// as the center, as shown in Figure 22.10b. By implementing
// the Comparable interface, you can use the Array.sort 
// method to sort the points to simplify coding.
    }
  }
  Write a test program that prompts the user to enter the set size and the points 
and displays the points that form a convex hull. Here is a sample run:
How many points are in the set? 6
Enter 6 points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
The convex hull is 
  (1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)       
*22.12 (Last 100 prime numbers ) Programming Exercise 22.8 stores the prime num-
bers in a file named PrimeNumbers.dat. Write an efficient program that reads 
the last 100 numbers in the file. ( Hint: Don’t read all numbers from the file. 
Skip all numbers before the last 100 numbers in the file.)
**22.13 (Geometry: convex hull animation ) Programming Exercise 22.11 finds a con-
vex hull for a set of points entered from the console. Write a program that ena-
bles the user to add/remove points by clicking the left/right mouse button, and 
displays a convex hull, as shown in Figure 22.8c.
*22.14 (Execution time for prime numbers ) Write a program that obtains the execu-
tion time for finding all the prime numbers less than 8,000,000, 10,000,000,
```

</details>


## PDF page 880

<details>
<summary>Page text</summary>

```text
Programming Exercises  857
12,000,000, 14,000,000, 16,000,000, and 18,000,000 using the algorithms in 
Listings 22.5–22.7. Your program should print a table like this:
8000000 10000000 12000000 14000000 16000000 18000000
Listing 22.5
Listing 22.6
Listing 22.7
FIGURE 22.11 (a) Programming Exercise22.15 displays a non-crossed polygon for a set of 
points. (b) Two or more sides intersect in a crossed polygon.
(a) (b) Crossed polygon
**22.15 (Geometry: non-cross polygon) Write a program that enables the user to add/
remove points by clicking the left/right mouse button, and displays a non-
crossed polygon that links all the points, as shown in Figure 22.11a. A polygon 
is crossed if two or more sides intersect, as shown in Figure 22.11b. Use the 
following algorithm to construct a polygon from a set of points.
Step 1: Given a set of points S, select the rightmost lowest 
point p0 in the set S.
Step 2: Sort the points in S angularly along the x-axis
with p0 as the center. If there is a tie and two points have 
the same angle, the one that is closer to p0 is considered 
greater. The points in S are now sorted as p0, p1, p2, ..., 
pn-1.
Step 3: The sorted points form a non-cross polygon.
**22.16 (Linear search animation ) Write a program that animates the linear search 
algorithm. Create an array that consists of 20 distinct numbers from 1 to 20 
in a random order. The array elements are displayed in a histogram, as shown 
in Figure 22.12. You need to enter a search key in the text field. Clicking the 
Step button causes the program to perform one comparison in the algorithm and 
repaints the histogram with a bar indicating the search position. This button 
also freezes the text field to prevent its value from being changed. When the 
algorithm is finished, display the status in the label at the top of the border pane 
to inform the user. Clicking the Reset button creates a new random array for a 
new start. This button also makes the text field editable.
```

</details>


## PDF page 881

<details>
<summary>Page text</summary>

```text
858 Chapter 22  Developing Efficient Algorithms
**22.17 (Closest-pair animation) Write a program that enables the user to add/remove 
points by clicking the left/right mouse button, and displays a line that connects 
the pair of nearest points, as shown in Figure 22.4.
**22.18 (Binary search animation) Write a program that animates the binary search algo-
rithm. Create an array with numbers from 1 to 20 in this order. The array ele-
ments are displayed in a histogram, as shown in Figure 22.13. You need to enter 
a search key in the text field. Clicking the Step button causes the program to 
perform one comparison in the algorithm. Use a light-gray color to paint the bars 
for the numbers in the current search range and use a black color to paint the a bar 
indicating the middle number in the search range. The Step button also freezes the 
text field to prevent its value from being changed. When the algorithm is finished, 
display the status in a label at the top of a border pane. Clicking the Reset button 
enables a new search to start. This button also makes the text field editable.
FIGURE 22.13 The program animates a binary search.
*22.19 (Largest block) The problem for finding a largest block is described in Pro-
gramming Exercise 8.35. Design a dynamic programming algorithm for solv-
ing this problem in O(n2) time. Write a test program that displays a 10-by-10 
square matrix, as shown in Figure 22.14a. Each element in the matrix is 0 or 
1, randomly generated with a click of the Refresh button. Display each number 
centered in a text field. Use a text field for each entry. Allow the user to change 
the entry value.  Click the Find Largest Block  button to find a largest square 
submatrix that consists of 1s. Highlight the numbers in the block, as shown in 
Figure  22.14b. See www.cs.armstrong.edu/liang/animation/FindLargestBlock.html
for an interactive test.
FIGURE 22.12 The program animates a linear search.
```

</details>


## PDF page 882

<details>
<summary>Page text</summary>

```text
Programming Exercises  859
***22.20 (Game: multiple Sudoku solutions) The complete solution for the Sudoku prob-
lem is given in Supplement VI.A. A Sudoku problem may have multiple solu-
tions. Modify Sudoku.java in Supplement VI.A to display the total number of 
the solutions. Display two solutions if multiple solutions exist.
***22.21 (Game: Sudoku ) The complete solution for the Sudoku problem is given in 
Supplement VI.C. Write a program that lets the user enter the input from the 
text fields, as shown in Figure 22.15a. Clicking the Solve button displays the 
result, as shown in  Figure 22.15b–c.
***22.22 (Game: recursive Sudoku) Write a recursive solution for the Sudoku problem.
***22.23 (Game: multiple Eight Queens solution) Write a program to display all possible 
solutions for the Eight Queens puzzle in a scroll pane, as shown in Figure 22.16. 
For each solution, put a label to denote the solution number. ( Hint: Place all 
solution panes into an HBox and place this one pane into a ScrollPane.)
**22.24 (Find the smallest number ) Write a method that uses the divide-and-conquer 
approach to find the smallest number in a list.
FIGURE 22.14 The program finds the largest block of 1s.
(a) (b)
FIGURE 22.15 The program solves the Sudoku problem.
(a) (b) (c)
```

</details>


## PDF page 883

<details>
<summary>Page text</summary>

```text
860 Chapter 22  Developing Efficient Algorithms
***22.25 (Game: Sudoku) Revise Programming Exercise 22.21 to display all solutions 
for the Sudoku game, as shown in Figure 22.17a. When you click the Solve
button, the program stores all solutions in an ArrayList. Each element in the 
list is a two-dimensional 9-by-9 grid. If the program has multiple solutions, the 
Next button appears as shown in Figure 22.17b. You can click the Next button 
to display the next solution and also a label to show the solution count. When 
the Clear button is clicked, the cells are cleared and the Next button is hidden 
as shown in Figure 22.17c.
FIGURE 22.17 The program can display multiple Sudoku solutions.
(a) (b )( c)
FIGURE 22.16 All solutions are placed in a scroll pane.
```

</details>
