# Week 5 - Understanding What You Have Achieved

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 5 - Understanding What You Have Achieved.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Understanding What You Have Achieved 
Your Learning Journey: Week 5 Practical Session 
Dear Student, 
You have just completed a practical session that covered one of the most practical and powerful 
concepts in programming: managing collections of data . You didn't just read about arrays and 
ArrayLists – you used them to build a fully functional Student Roster Manager that can add, view, 
search, and remove student records. 
This document will help you understand exactly what you have learned, why it matters, and how 
it connects to your future as a developer. 
Read through this carefully. You might be surprised by how much you already know! 
 
✓ Your Achievement Map 
Here is a summary of everything you have accomplished: 
               YOUR ACHIEVEMENTS                                                                                                    
 WEEK 5: ARRAYS AND ARRAYLISTS                                                                                                         
     Created and manipulated arrays (1D and 2D)                       
     Implemented array algorithms (max, min, average, search)         
     Analyzed time complexity of array algorithms                     
     Created and used ArrayLists (add, remove, get, set, size)        
     Compared arrays vs ArrayLists and chose the right one             
     Debugged ArrayIndexOutOfBoundsException                          
     Built an integrated Student Roster Manager                       
     Pushed Week 5 code to GitHub                                     
 YOU CAN NOW STORE AND MANAGE COLLECTIONS OF DATA!
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
➢ Learning Outcome 1: Analyze array algorithms to determine their time complexity 
(linear vs quadratic) 
What You Did: 
In Task 2, you created ArrayAlgorithms.java and implemented five different algorithms: 
Algorithm Iterations (n=10) Time Complexity 
Find Maximum 10 O(n) 
Find Minimum 10 O(n) 
Calculate Average 10 O(n) 
Linear Search 6 (found early) O(n) – best case O(1) 
Count Above Threshold 10 O(n) 
 
What You Learned: 
Linear vs Quadratic Complexity 
Complexity Growth Pattern Example Iterations (n=10) Iterations (n=100) 
O(1) Constant Access array by index 1 1 
O(n) Linear Find max, sum, search 10 100 
O(n²) Quadratic Nested loops 100 10,000
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Why This Matters in Real Life 
Imagine you are building a system for Safaricom that processes M-Pesa transactions: 
Scenario Algorithm Used n = 10,000 transactions Time Estimate 
Find the largest transaction today Linear (O(n)) 10,000 operations ~0.001 seconds 
Compare every transaction with 
every other (fraud detection) 
Quadratic 
(O(n²)) 
100,000,000 
operations ~10 seconds 
Access a specific transaction by ID Constant (O(1)) 1 operation Instant 
Key Insight: Choosing an O(n) algorithm over an O(n²) algorithm can mean the difference 
between a fast, responsive app and a system that times out. 
What You Can Now Do: 
You can look at any array algorithm and determine whether it is O(n) or O(n²). You can also 
estimate how it will perform as the data grows – a critical skill for building scalable fintech 
systems. 
 
➢ Learning Outcome 2: Evaluate the trade-offs between using arrays and ArrayLists for 
different scenarios 
What You Did: 
In Task 5, you created ArrayVsArrayList.java and implemented the same task using both data 
structures.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
What You Learned: 
Side-by-Side Comparison 
Feature Array ArrayList 
Size Fixed (must know upfront) Dynamic (grows/shrinks) 
Data types Primitives + Objects Objects only (wrapper classes) 
Length method .length (property) .size() (method) 
Add element Assign by index .add() 
Remove element Manual shifting required .remove() 
Search Manual loop .contains(), .indexOf() 
Memory Less overhead More overhead 
Performance Faster access Slightly slower access 
 
When to Use Each 
Scenario Recommended Why 
Storing fixed subjects (Math, English, 
Science) Array Number of subjects is fixed 
Storing student names that change ArrayList Students may be added/removed
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
Scenario Recommended Why 
Storing 10,000 M-Pesa transactions for 
processing Array Fixed batch size, faster access 
Building a shopping cart (items 
added/removed) ArrayList Dynamic size needed 
Storing a 3×3 tic-tac-toe board 2D Array Fixed grid 
Storing customer search history ArrayList Grows as customer searches 
 
Real-World Fintech Example 
M-Pesa Agent System: 
• Array: Fixed list of 5 allowed transaction types (Send Money, Withdraw, Deposit, Buy 
Airtime, Pay Bill) 
• ArrayList: Dynamic list of all transactions processed today (could be 10, could be 10,000) 
What You Can Now Do: 
You can evaluate a programming problem, decide whether an array or ArrayList is more 
appropriate, and justify your choice based on memory, performance, and flexibility. 
 
➢ Learning Outcome 3: Debug array index out-of-bounds errors by simulating loop 
conditions 
What You Did: 
In Task 6, you examined three buggy programs with array index errors and fixed them:
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
Bug Problem Exception Thrown Fix 
Bug 
1 i <= numbers.length ArrayIndexOutOfBoundsException Change to i < numbers.length 
Bug 
2 
numbers[5] 
(hardcoded) ArrayIndexOutOfBoundsException Use numbers.length - 1 
Bug 
3 numbers[-1] ArrayIndexOutOfBoundsException Use index 0 
What You Learned: 
The Golden Rule of Array Indexing 
text 
For an array of length n: 
- Valid indices are: 0, 1, 2, ..., n-1 
- The last valid index is: n - 1 
- The length property returns n 
- Index n is ALWAYS out of bounds! 
Trace Table Example 
Buggy Code: 
java 
int[] numbers = {10, 20, 30, 40, 50}; 
for (int i = 0; i <= numbers.length; i++) { 
    System.out.println(numbers[i]); 
} 
Trace:
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
Iteration i i <= 5? numbers[i] Status 
1 0 true 10    OK 
2 1 true 20    OK 
3 2 true 30    OK 
4 3 true 40    OK 
5 4 true 50    OK 
6 5 true CRASH!   Index 5 out of bounds 
Why This Matters in Real Life 
In fintech, an unhandled exception can: 
• Freeze an M-Pesa agent's terminal 
• Cause a transaction to be partially processed (money deducted but not credited) 
• Trigger a system-wide crash affecting thousands of users 
• Lead to regulatory penalties and loss of customer trust 
Real-World Scenario: 
An M-Pesa agent system processes a batch of 100 transactions. A developer wrote i <= 
batchSize instead of i < batchSize. At transaction 101, the system crashes. The agent cannot 
process any more transactions for the day. Customers are turned away. The agent loses 
revenue. 
Learning to debug index errors prevents these disasters. 
What You Can Now Do: 
You can trace any array loop, identify off-by-one errors, and fix 
ArrayIndexOutOfBoundsException before it crashes your program.
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
➢ Learning Outcome 4: Design an application that uses both arrays and ArrayLists to 
manage a collection 
What You Did: 
In Task 7, you built StudentRoster.java – a complete menu-driven application that: 
• Uses an array for fixed subjects (Math, English, Science) 
• Uses ArrayLists for dynamic student names and marks 
• Allows adding, viewing, searching, and removing students 
• Calculates class averages and displays formatted tables 
What You Learned: 
Application Architecture
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
Key Design Decisions 
Decision Why 
Subjects stored in array Number of subjects is fixed and known upfront 
Student names stored in ArrayList Students can be added or removed dynamically 
Marks stored in ArrayList of int[] Each student has a fixed set of marks (one per subject) 
Menu uses do-while loop Menu must display at least once 
Switch used for menu Multiple exact choices (1-6) 
Real-World Applications 
This same architecture is used in: 
Application Fixed Data (Array) Dynamic Data (ArrayList) 
M-Pesa Agent System Transaction types Transaction history 
Banking App Account types (Savings, Current) Customer accounts 
E-commerce Store Product categories Shopping cart items 
Hospital System Departments Patient records 
School Management Subjects offered Student enrollments 
What You Can Now Do: 
You can design and build a complete application that uses arrays for fixed data and ArrayLists 
for dynamic data, with a user-friendly menu interface.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
➢ Your Progress: Where You Started vs. Where You Are Now 
Before Week 5 After Week 5 
Didn't know how to store multiple 
values Can use arrays to store fixed-size data 
Didn't know about ArrayList Can use ArrayList to store dynamic data 
Didn't understand time complexity Can analyze O(n) vs O(n²) algorithms 
Didn't know how to debug index errors Can trace and fix ArrayIndexOutOfBoundsException 
Didn't know when to use array vs 
ArrayList 
Can evaluate trade-offs and choose the right 
structure 
Couldn't build data-driven applications Built a complete Student Roster Manager 
 
➢ How to Prove You've Achieved These Outcomes 
Here are the artifacts (proof) you now have: 
1. GitHub Repository: https://github.com/YOUR-USERNAME/java-course 
2. Seven Java Files in week5: 
o ArrayBasics.java 
o ArrayAlgorithms.java 
o MatrixDemo.java 
o ArrayListBasics.java 
o ArrayVsArrayList.java 
o ArrayIndexDebug.java and FixedArrays.java 
o StudentRoster.java
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
3. Commit History: Shows your progress 
4. Reflection Notes: Your answers to questions 
These artifacts are your portfolio pieces. Employers can see them! 
 
➢ How This Connects to Your Career 
Learning Outcome Career Application 
Analyze time complexity Interviews test Big-O notation. You can analyze O(n) vs O(n²). 
Evaluate array vs 
ArrayList 
Every project requires choosing the right data structure. You can 
justify your choice. 
Debug index errors ArrayIndexOutOfBoundsException is the #1 runtime error. You can fix it. 
Design data-driven 
applications 
Every software system manages collections of data. You can build 
it. 
Git & GitHub Your portfolio is growing with each week. Employers check this. 
 
 
➢ Student Reflection: In Your Own Words 
Answer these questions in your notebook. Be honest – this helps you learn: 
1. Which data structure did you find more useful: arrays or ArrayLists? Why? 
2. What was the most challenging part of this practical session? 
3. What error message did you encounter, and how did you solve it? 
4. In your own words, when would you use an array vs an ArrayList? 
5. How will arrays and ArrayLists help you build real-world applications?
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
6. What is one thing you want to learn more about? 
 
➢ What's Next? 
In Week 6, you will: 
1. Dive deeper into classes and objects 
2. Learn about constructors and encapsulation 
3. Build a BankAccount class and a Book class 
4. Continue pushing your code to GitHub 
But before you move on, make sure you can answer YES to these questions: 
• □ I can declare, initialize, and access arrays. 
• □ I can iterate through arrays using for and enhanced for loops. 
• □ I can implement array algorithms (max, min, average, search). 
• □ I can work with 2D arrays. 
• □ I can create and use ArrayLists. 
• □ I can add, remove, access, and update ArrayList elements. 
• □ I can compare arrays and ArrayLists and choose the right one. 
• □ I can debug array index out-of-bounds errors. 
• □ I have pushed my Week 5 code to GitHub. 
• □ I am excited to learn more! 
If you answered YES to all, you are ready for Week 6! 
 
➢ Key Terms Glossary 
Term Definition 
Array Fixed-size data structure that stores elements of the same type
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
Term Definition 
Index Position of an element in an array (starts at 0) 
Length Number of elements in an array (.length) 
2D Array Array of arrays (matrix/grid) 
ArrayList Dynamic-size collection that can grow/shrink 
add() Method to add an element to an ArrayList 
remove() Method to remove an element from an ArrayList 
get() Method to access an element by index 
set() Method to replace an element at an index 
size() Method that returns the number of elements in an ArrayList 
contains() Method that checks if an element exists 
indexOf() Method that returns the index of an element 
ArrayIndexOutOfBoundsException Error thrown when accessing invalid index 
O(n) Linear time complexity 
O(n²) Quadratic time complexity
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
Term Definition 
Autoboxing Automatic conversion of primitive to wrapper class 
Unboxing Automatic conversion of wrapper class to primitive 
 
➢ Final Words 
"Programs must be written for people to read, and only incidentally for machines to execute." – 
Harold Abelson 
You started this week not knowing how to store multiple values. You end this week with: 
• Seven working programs 
• A growing GitHub portfolio 
• A clear understanding of arrays and ArrayLists 
• The ability to analyze algorithm efficiency 
• The skill to debug index errors 
• A complete Student Roster Manager 
Data is everywhere in programming. Every app, every system, every game manages 
collections of data. You now understand how. 
Keep going! 
 
END OF ACHIEVEMENT GUIDE FOR WEEK 5 
"The best way to learn is by doing." – Anonymous 
 
Instructor Note: I encourage you to keep it as a reference and to fill in the reflection questions. 
This helps consolidate your learning and gives you a tangible sense of accomplishment. Use the 
self-assessment checklist to identify where you may need additional support before moving to 
Week 6.
```

</details>
