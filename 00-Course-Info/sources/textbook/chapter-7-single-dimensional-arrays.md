# Chapter 7 Single-Dimensional Arrays

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 268

<details>
<summary>Page text</summary>

```text
SINGLE-DIMENSIONAL
ARRAYS
Objectives
■ To describe why arrays are necessary in programming (§7.1).
■ To declare array reference variables and create arrays (§§7.2.1–7.2.2).
■ To obtain array size using arrayRefVar.length and know default 
values in an array (§7.2.3).
■ To access array elements using indexes (§7.2.4).
■ To declare, create, and initialize an array using an array initializer (§7.2.5).
■ To program common array operations (displaying arrays, summing 
all elements, finding the minimum and maximum elements, random 
shuffling, and shifting elements) (§7.2.6).
■ To simplify programming using the for each loops (§7.2.7).
■ To apply arrays in application development (AnalyzeNumbers,
DeckOfCards) (§§7.3–7.4).
■ To copy contents from one array to another (§7.5).
■ To develop and invoke methods with array arguments and return values 
(§§7.6–7.8).
■ To define a method with a variable-length argument list (§7.9).
■ To search elements using the linear (§7.10.1) or binary (§7.10.2) 
search algorithm.
■ To sort an array using the selection sort approach (§7.11).
■ To use the methods in the java.util.Arrays class (§7.12).
■ To pass arguments to the main method from the command line (§7.13).
CHAPTER
7
```

</details>


## PDF page 269

<details>
<summary>Page text</summary>

```text
246 Chapter 7  Single-Dimensional Arrays
7.1 Introduction
A single array variable can reference a large collection of data.
Often you will have to store a large number of values during the execution of a program. 
Suppose, for instance, that you need to read 100 numbers, compute their average, and find 
out how many numbers are above the average. Your program first reads the numbers and 
computes their average, then compares each number with the average to determine whether 
it is above the average. In order to accomplish this task, the numbers must all be stored in 
variables. You have to declare 100 variables and repeatedly write almost identical code 
100 times. Writing a program this way would be impractical. So, how do you solve this 
problem?
An efficient, organized approach is needed. Java and most other high-level languages pro-
vide a data structure, the array, which stores a fixed-size sequential collection of elements of 
the same type. In the present case, you can store all 100 numbers into an array and access them 
through a single array variable. 
This chapter introduces single-dimensional arrays. The next chapter will introduce two-
dimensional and multidimensional arrays.
7.2 Array Basics
Once an array is created, its size is fixed. An array reference variable is used to 
access the elements in an array using an index.
An array is used to store a collection of data, but often we find it more useful to think of an 
array as a collection of variables of the same type. Instead of declaring individual variables, 
such as number0, number1, . . . , and number99, you declare one array variable such as 
numbers and use numbers[0], numbers[1], . . . , and numbers[99] to represent indi-
vidual variables. This section introduces how to declare array variables, create arrays, and 
process arrays using indexes.
7.2.1 Declaring Array Variables
To use an array in a program, you must declare a variable to reference the array and specify 
the array’s element type. Here is the syntax for declaring an array variable:
elementType[] arrayRefVar;
TheelementType can be any data type, and all elements in the array will have the same 
data type. For example, the following code declares a variable myList that references an 
array of double elements.
double[] myList;
Note
You can also use elementType arrayRefVar[] to declare an array variable. This 
style comes from the C/C++ language and was adopted in Java to accommodate C/C++ 
programmers. The style elementType[] arrayRefVar is preferred.
7.2.2  Creating Arrays
Unlike declarations for primitive data type variables, the declaration of an array variable does 
not allocate any space in memory for the array. It creates only a storage location for the refer-
ence to an array. If a variable does not contain a reference to an array, the value of the variable 
isnull. You cannot assign elements to an array unless it has already been created. After an 
Key
Point
problem
why array?
Key
Point
index
element type
preferred syntax
null
```

</details>


## PDF page 270

<details>
<summary>Page text</summary>

```text
7.2 Array Basics  247
array variable is declared, you can create an array by using the new operator and assign its 
reference to the variable with the following syntax: 
arrayRefVar = new elementType[arraySize];
This statement does two things: (1) it creates an array using new elementType[arraySize];
(2) it assigns the reference of the newly created array to the variable arrayRefVar.
Declaring an array variable, creating an array, and assigning the reference of the array to 
the variable can be combined in one statement as:
elementType[] arrayRefVar = new elementType[arraySize];
or
elementType arrayRefVar[] = new elementType[arraySize];
Here is an example of such a statement:
double[] myList = new double[10];
This statement declares an array variable, myList, creates an array of ten elements of 
double type, and assigns its reference to myList. To assign values to the elements, use 
the syntax:
arrayRefVar[index] = value;
For example, the following code initializes the array.
myList[0] = 5.6;
myList[1] = 4.5;
myList[2] = 3.3;
myList[3] = 13.2;
myList[4] = 4.0;
myList[5] = 34.33;
myList[6] = 34.0;
myList[7] = 45.45;
myList[8] = 99.993;
myList[9] = 11123;
This array is illustrated in Figure 7.1.
new operator
FIGURE 7.1 The array myList has ten elements of double type and int indices from 0 to 9.
double[] myList = new double[10];
myList reference myList[0]
myList[1]
myList[2]
myList[3]
myList[4]
myList[6]
myList[5]
myList[7]
myList[8]
myList[9]
Array reference
variable
Array element at
index 5
5.6
4.5
3.3
13.2
4.0
34.33
34.0
45.45
99.993
11123
Element value
```

</details>


## PDF page 271

<details>
<summary>Page text</summary>

```text
248 Chapter 7  Single-Dimensional Arrays
Note
An array variable that appears to hold an array actually contains a reference to that array. 
Strictly speaking, an array variable and an array are different, but most of the time the 
distinction can be ignored. Thus it is all right to say, for simplicity, that myList is an 
array, instead of stating, at greater length, that myList is a variable that contains a 
reference to an array of ten double elements.
7.2.3 Array Size and Default Values
When space for an array is allocated, the array size must be given, specifying the number of ele-
ments that can be stored in it. The size of an array cannot be changed after the array is created. 
Size can be obtained using arrayRefVar.length. For example, myList.length is 10.
When an array is created, its elements are assigned the default value of 0 for the numeric 
primitive data types, \u0000 for char types, and false for boolean types.
7.2.4 Accessing Array Elements
The array elements are accessed through the index. Array indices are 0 based; that is, they 
range from 0 to arrayRefVar.length-1. In the example in Figure 7.1, myList holds ten 
double values, and the indices are from 0 to 9.
Each element in the array is represented using the following syntax, known as an indexed
variable:
arrayRefVar[index];
For example, myList[9] represents the last element in the array myList.
Caution
Some programming languages use parentheses to reference an array element, as in 
myList(9), but Java uses brackets, as in myList[9].
An indexed variable can be used in the same way as a regular variable. For example, the 
following code adds the values in myList[0] and myList[1] to myList[2].
myList[2] = myList[0] + myList[1];
The following loop assigns 0 to myList[0],1 to myList[1], . . . , and 9 to myList[9]:
for (int i = 0; i < myList.length; i++) {
  myList[i] = i;
}
7.2.5 Array Initializers
Java has a shorthand notation, known as the array initializer, which combines the declaration, 
creation, and initialization of an array in one statement using the following syntax:
elementType[] arrayRefVar = {value0, value1, ..., valuek};
For example, the statement
double[] myList = {1.9, 2.9, 3.4, 3.5};
declares, creates, and initializes the array myList with four elements, which is equivalent to 
the following statements:
double[] myList = new double[4];
myList[0] = 1.9;
myList[1] = 2.9;
array vs. array variable
array length
default values
0 based
indexed variable
array initializer
```

</details>


## PDF page 272

<details>
<summary>Page text</summary>

```text
7.2 Array Basics  249
myList[2] = 3.4;
myList[3] = 3.5;
Caution
Thenew operator is not used in the array-initializer syntax. Using an array initializer, you 
have to declare, create, and initialize the array all in one statement. Splitting it would 
cause a syntax error. Thus, the next statement is wrong:
double[] myList;
myList = {1.9, 2.9, 3.4, 3.5};
7.2.6 Processing Arrays
When processing array elements, you will often use a for loop—for two reasons:
 ■ All of the elements in an array are of the same type. They are evenly processed in the 
same fashion repeatedly using a loop.
 ■ Since the size of the array is known, it is natural to use a for loop.
Assume the array is created as follows:
double[] myList = new double[10];
The following are some examples of processing arrays.
1. Initializing arrays with input values:  The following loop initializes the array myList
with user input values.
java.util.Scanner input = new java.util.Scanner(System.in);
System.out.print("Enter " + myList.length + " values: ");
for (int i = 0; i < myList.length; i++) 
  myList[i] = input.nextDouble();
2. Initializing arrays with random values: The following loop initializes the array myList
with random values between 0.0 and 100.0, but less than 100.0.
for (int i = 0; i < myList.length; i++) {
  myList[i] = Math.random() * 100;
}
3. Displaying arrays: To print an array, you have to print each element in the array using a 
loop like the following:
for (int i = 0; i < myList.length; i++) {
  System.out.print(myList[i] + " ");
}
Tip
For an array of the char[] type, it can be printed using one print statement. For exam-
ple, the following code displays Dallas:
char[] city = {'D', 'a', 'l', 'l', 'a', 's'};
System.out.println(city);
4. Summing all elements: Use a variable named total to store the sum. Initially total
is 0.  Add each element in the array to total using a loop like this:
double total = 0;
for (int i = 0; i < myList.length; i++) {
  total += myList[i];
}
print character array
```

</details>


## PDF page 273

<details>
<summary>Page text</summary>

```text
250 Chapter 7  Single-Dimensional Arrays
5. Finding the largest element:  Use a variable named max to store the largest element. 
Initiallymax is myList[0]. To find the largest element in the array myList, compare 
each element with max, and update max if the element is greater than max.
double max = myList[0];
for (int i = 1; i < myList.length; i++) {
if (myList[i] > max) max = myList[i];
}
6. Finding the smallest index of the largest element:  Often you need to locate the largest 
element in an array. If an array has multiple elements with the same largest value, find the 
smallest index of such an element. Suppose the array myList is {1,5,3,4,5,5}. The 
largest element is 5 and the smallest index for 5 is 1. Use a variable named max to store 
the largest element and a variable named indexOfMax to denote the index of the largest 
element. Initially max is myList[0], and indexOfMax is 0. Compare each element in 
myList with max, and update max and indexOfMax if the element is greater than max.
double max = myList[0];
int indexOfMax = 0;
for (int i = 1; i < myList.length; i++) {
if (myList[i] > max) {
    max = myList[i];
    indexOfMax = i;
  }
}
7. Random shuffling: In many applications, you need to randomly reorder the elements 
in an array. This is called shuffling. To accomplish this, for each element myList[i],
randomly generate an index j and swap myList[i] with myList[j], as follows:
Random shuffling
VideoNote
Random shuffling
swap
myList
i
[1]
[i]
for (int i = myList.length – 1; i > 0; i––) {
// Generate an index j randomly with 0 <= j <= i
int j = (int)(Math.random()
    * (i + 1));
// Swap myList[i] with myList[j]
double temp = myList[i];
  myList[i] = myList[j];
  myList[j] = temp;
}
.
.[0]
A random index [j]
double temp = myList[0]; // Retain the first element
// Shift elements left
for (int i = 1; i < myList.length; i++) {
  myList[i - 1] = myList[i];
}
// Move the first element to fill in the last position
myList[myList.length - 1] = temp;
myList
8. Shifting elements: Sometimes you need to shift the elements left or right. Here is an 
example of shifting the elements one position to the left and filling the last element with 
the first element:
9. Simplifying coding: Arrays can be used to greatly simplify coding for certain tasks. For 
example, suppose you wish to obtain the English name of a given month by its number. 
If the month names are stored in an array, the month name for a given month can be
```

</details>


## PDF page 274

<details>
<summary>Page text</summary>

```text
7.2 Array Basics  251
accessed simply via the index. The following code prompts the user to enter a month 
number and displays its month name:
String[] months = {"January", "February", ..., "December"};
System.out.print("Enter a month number (1 to 12): ");
int monthNumber = input.nextInt();
System.out.println("The month is " + months[monthNumber - 1]);
  If you didn’t use the months array, you would have to determine the month name using 
a lengthy multi-way if-else statement as follows:
if (monthNumber == 1)
  System.out.println("The month is January");
else if (monthNumber == 2)
  System.out.println("The month is February");
...
else
  System.out.println("The month is December");
7.2.7 Foreach Loops
Java supports a convenient for loop, known as a foreach loop, which enables you to traverse 
the array sequentially without using an index variable. For example, the following code dis-
plays all the elements in the array myList:
for (double e: myList) {
  System.out.println(e);
}
You can read the code as “for each element e in myList, do the following.” Note that the 
variable,e, must be declared as the same type as the elements in myList.
In general, the syntax for a foreach loop is
for (elementType element: arrayRefVar) {
// Process the element
}
You still have to use an index variable if you wish to traverse the array in a different order or 
change the elements in the array.
Caution
Accessing an array out of bounds is a common programming error that throws a runtime 
ArrayIndexOutOfBoundsException. To avoid it, make sure that you do not use 
an index beyond arrayRefVar.length – 1.
Programmers often mistakenly reference the first element in an array with index 1, but 
it should be 0. This is called the off-by-one error. Another common off-by-one error in 
a loop is using <= where < should be used. For example, the following loop is wrong.
for (int i = 0; i <= list.length; i++)
  System.out.print(list[i] + " ");
The<= should be replaced by <.
7.1 How do you declare an array reference variable and how do you create an array?
7.2 When is the memory allocated for an array?
ArrayIndexOutOfBounds-
Exception
off-by-one error
✓Point✓
Check
```

</details>


## PDF page 275

<details>
<summary>Page text</summary>

```text
252 Chapter 7  Single-Dimensional Arrays
7.3 What is the output of the following code?
int x = 30;
int[] numbers = new int[x];
x = 60;
System.out.println("x is " + x);
System.out.println("The size of numbers is " + numbers.length);
7.4 Indicatetrue or false for the following statements:
■ Every element in an array has the same type.
■ The array size is fixed after an array reference variable is declared.
■ The array size is fixed after it is created.
■ The elements in an array must be a primitive data type.
7.5 Which of the following statements are valid?
int i = new int(30);
double d[] = new double[30];
char[] r = new char(1..30);
int i[] = (3, 4, 3, 2);
float f[] = {2.3, 4.5, 6.6};
char[] c = new char();
7.6 How do you access elements in an array? 
7.7 What is the array index type? What is the lowest index? What is the representation of 
the third element in an array named a?
7.8 Write statements to do the following:
a. Create an array to hold 10 double values.
b. Assign the value 5.5 to the last element in the array.
c. Display the sum of the first two elements.
d. Write a loop that computes the sum of all elements in the array.
e. Write a loop that finds the minimum element in the array.
f. Randomly generate an index and display the element of this index in the array.
g. Use an array initializer to create another array with the initial values 3.5, 5.5,
4.52, and 5.6.
7.9 What happens when your program attempts to access an array element with an inva-
lid index?
7.10 Identify and fix the errors in the following code:
1 public class Test {
2 public static void main(String[] args) {
3 double[100] r;
4
5 for (int i = 0; i < r.length(); i++);
6        r(i) = Math.random * 100;
7    }
8  }
7.11 What is the output of the following code?
 1 public class Test { 
 2 public static void main(String[] args) {
 3 int list[] = {1, 2, 3, 4, 5, 6};
```

</details>


## PDF page 276

<details>
<summary>Page text</summary>

```text
7.3 Case Study: Analyzing Numbers  253
 4 for (int i = 1; i < list.length; i++)
 5        list[i] = list[i - 1];
 6
 7 for (int i = 0; i < list.length; i++)
 8        System.out.print(list[i] + " ");
 9    }
10  }
7.3 Case Study: Analyzing Numbers
The problem is to write a program that finds the number of items above the average of 
all items.
Now you can write a program using arrays to solve the problem proposed at the beginning of 
this chapter. The problem is to read 100 numbers, get the average of these numbers, and find the 
number of the items greater than the average. To be flexible for handling any number of input, we 
will let the user enter the number of input, rather than fixing it to 100. Listing 7.1 gives a solution.
Key
Point
Enter the number of items: 10
Enter the numbers: 3.4 5 6 1 6.5 7.8 3.5 8.5 6.3 9.5
Average is 5.75
Number of elements above the average is 6 
LISTING 7.1 AnalyzeNumbers.java
 1 public class AnalyzeNumbers {
 2 public static void main(String[] args) { numbers[0]
3      java.util.Scanner input = new java.util.Scanner(System.in);numbers[1]:
 4      System.out.print("Enter the number of items: "); numbers[2]:
 5 int n = input.nextInt();
 6 double [] numbers = new double[n];                                  .
 7 double sum = 0;                                                     .
 8 numbers[i]: .
 9      System.out.print("Enter the numbers: ");
10 for (int i = 0; i < n; i++) { numbers[n - 3]:
11 numbers[i] = input.nextDouble(); numbers[n - 2]:
12 sum += numbers[i]; numbers[n - 1]:
13      }
14
15 double average = sum / n; 
16
17 int count = 0; // The number of elements above average
18 for (int i = 0; i < n; i++) 
19 if (numbers[i] > average)
20          count++;
21
22      System.out.println("Average is " + average);
23      System.out.println("Number of elements above the average is "
24        + count);
25    }
26  }
create array
store number in array
get average
above average?
The program prompts the user to enter the array size (line 5) and creates an array with the 
specified size (line 6). The program reads the input, stores numbers into the array (line 11), 
adds each number to sum in line 11, and obtains the average (line 15). It then compares
```

</details>


## PDF page 277

<details>
<summary>Page text</summary>

```text
254 Chapter 7  Single-Dimensional Arrays
each number in the array with the average to count the number of values above the average 
(lines 17–20).
7.4 Case Study: Deck of Cards
The problem is to create a program that will randomly select four cards from a deck 
of cards.
Say you want to write a program that will pick four cards at random from a deck of 52 cards. 
All the cards can be represented using an array named deck, filled with initial values 0 to 51,
as follows:
int[] deck = new int[52];
// Initialize cards
for (int i = 0; i < deck.length; i++)
  deck[i] = i;
Card numbers 0 to 12, 13 to 25, 26 to 38, and 39 to 51 represent 13 Spades, 13 Hearts, 
13 Diamonds, and 13 Clubs, respectively, as shown in Figure 7.2. cardNumber / 13 deter-
mines the suit of the card and cardNumber % 13 determines the rank of the card, as shown 
in Figure 7.3. After shuffling the array deck, pick the first four cards from deck. The program 
displays the cards from these four card numbers.
Key
Point
VideoNote
Deck of cards
FIGURE 7.2 52 cards are stored in an array named deck.
0
.
.
.
12
13
.
.
.
25
26
.
.
.
38
39
.
.
.
51
13 Diamonds ( )
13 Clubs ( )
0
.
.
.
12
13
.
.
.
25
26
.
.
.
38
39
.
.
.
51
deck
[0]
.
.
.
[12]
[13]
.
.
.
[25]
[26]
.
.
.
[38]
[39]
.
.
.
[51]
Random shuffle
6
48
11
24
.
.
.
.
.
.
.
.
.
.
.
.
.
.
.
.
deck
[0]
[1]
[2]
[3]
[4]
[5]
.
.
.
[25]
[26]
.
.
.
[38]
[39]
.
.
.
[51]
Card number 6 is the
7 (6 % 13 = 6) of
Spades (7 / 13 is 0)
Card number 48 is the
10 (48 % 13 = 9) of
Clubs (48 / 13 is 3)
Card number 11 is the
Queen (11 % 13 = 11) of
Spades (11 / 13 is 0)
Card number 24 is the
Queen (24 % 13 = 11) of
Hearts (24 / 13 is 1)
13 Hearts ( )
13 Spades ( )
FIGURE 7.3 CardNumber identifies a card’s suit and rank number.
cardNumber / 13 = 
0
3
2
1
Spades
Hearts
Diamonds
Clubs
cardNumber % 13 = 
0
11
10
.
Ace
12
.
12
Jack
Queen
King
```

</details>


## PDF page 278

<details>
<summary>Page text</summary>

```text
7.4 Case Study: Deck of Cards  255
Listing 7.2 gives the solution to the problem.
LISTING 7.2 DeckOfCards.java
 1 public class DeckOfCards {
 2 public static void main(String[] args) {
 3 int[] deck = new int[52];
 4      String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
 5      String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
 6 "10", "Jack", "Queen", "King"};
 7
 8 // Initialize the cards
 9 for (int i = 0; i < deck.length; i++)
10        deck[i] = i;
11
12 // Shuffle the cards
13 for (int i = 0; i < deck.length; i++) {
14 // Generate an index randomly
15 int index = (int)(Math.random() * deck.length);
16 int temp = deck[i];
17        deck[i] = deck[index]; 
18        deck[index] = temp;
19      }
20
21 // Display the first four cards
22 for (int i = 0; i < 4; i++) {
23        String suit = suits[deck[i] / 13];
24        String rank = ranks[deck[i] % 13];
25        System.out.println("Card number " + deck[i] + ": "
26          + rank + " of " + suit);
27      }
28    }
29  }
create array deck
array of strings
array of strings
initialize deck
shuffle deck
suit of a card
rank of a card
Card number 6: 7 of Spades
Card number 48: 10 of Clubs
Card number 11: Queen of Spades
Card number 24: Queen of Hearts 
The program creates an array suits for four suits (line 4) and an array ranks for 13 cards in 
a suit (lines 5–6). Each element in these arrays is a string.
The program initializes deck with values 0 to 51 in lines 9–10. The deck value 0 repre-
sents the card Ace of Spades, 1 represents the card 2 of Spades, 13 represents the card Ace of 
Hearts, and 14 represents the card 2 of Hearts.
Lines 13–19 randomly shuffle the deck. After a deck is shuffled, deck[i] contains an 
arbitrary value. deck[i] / 13 is 0,1,2, or 3, which determines the suit (line 23). deck[i]
% 13 is a value between 0 and 12, which determines the rank (line 24). If the suits array is 
not defined, you would have to determine the suit using a lengthy multi-way if-else state-
ment as follows:
if (deck[i] / 13 == 0)
  System.out.print("suit is Spades");
else if (deck[i] / 13 == 1)
  System.out.print("suit is Hearts");
else if (deck[i] / 13 == 2)
  System.out.print("suit is Diamonds");
else
  System.out.print("suit is Clubs");
```

</details>


## PDF page 279

<details>
<summary>Page text</summary>

```text
256 Chapter 7  Single-Dimensional Arrays
Withsuits = {"Spades", "Hearts", "Diamonds", "Clubs"} created in an array, 
suits[deck / 13] gives the suit for the deck. Using arrays greatly simplifies the solution 
for this program.
7.12 Will the program pick four random cards if you replace lines 22–27 in Listing 7.2 
DeckOfCards.java with the following code? 
for (int i = 0; i < 4; i++) {
int cardNumber = (int)(Math.random() * deck.length);
   String suit = suits[cardNumber / 13];
   String rank = ranks[cardNumber % 13];
   System.out.println("Card number " + cardNumber + ": "
     + rank + " of " + suit);
 }
7.5 Copying Arrays
To copy the contents of one array into another, you have to copy the array’s individual 
elements into the other array.
Often, in a program, you need to duplicate an array or a part of an array. In such cases you 
could attempt to use the assignment statement (=), as follows:
list2 = list1;
However, this statement does not copy the contents of the array referenced by list1 to 
list2, but instead merely copies the reference value from list1 to list2. After this state-
ment,list1 and list2 reference the same array, as shown in Figure 7.4. The array previously 
referenced by list2 is no longer referenced; it becomes garbage, which will be automatically 
collected by the Java Virtual Machine (this process is called garbage collection).
✓Point✓
Check
Key
Point
copy reference
garbage collection
FIGURE 7.4 Before the assignment statement, list1 and list2 point to separate memory 
locations. After the assignment, the reference of the list1 array is passed to list2.
Contents
oflist1
Contents
oflist1
Contents
oflist2
Contents
oflist2
list1
list2
Before the assignment
list2 = list1;
list1
list2
After the assignment
list2 = list1;
In Java, you can use assignment statements to copy primitive data type variables, but not 
arrays. Assigning one array variable to another array variable actually copies one reference to 
another and makes both variables point to the same memory location.
There are three ways to copy arrays:
 ■ Use a loop to copy individual elements one by one.
 ■ Use the static arraycopy method in the System class.
 ■ Use the clone method to copy arrays; this will be introduced in Chapter 13, Abstract 
Classes and Interfaces.
```

</details>


## PDF page 280

<details>
<summary>Page text</summary>

```text
7.6 Passing Arrays to Methods  257
You can write a loop to copy every element from the source array to the corresponding element 
in the target array. The following code, for instance, copies sourceArray to targetArray
using a for loop.
int[] sourceArray = {2, 3, 1, 5, 10};
int[] targetArray = new int[sourceArray.length];
for (int i = 0; i < sourceArray.length; i++) {
  targetArray[i] = sourceArray[i];
}
Another approach is to use the arraycopy method in the java.lang.System class to copy 
arrays instead of using a loop. The syntax for arraycopy is:
arraycopy(sourceArray, srcPos, targetArray, tarPos, length);
The parameters srcPos and tarPos indicate the starting positions in sourceArray and 
targetArray, respectively. The number of elements copied from sourceArray to targ-
etArray is indicated by length. For example, you can rewrite the loop using the following 
statement:
System.arraycopy(sourceArray,0, targetArray, 0, sourceArray.length);
Thearraycopy method does not allocate memory space for the target array. The target array 
must have already been created with its memory space allocated. After the copying takes place, 
targetArray and sourceArray have the same content but independent memory locations.
Note
The arraycopy method violates the Java naming convention. By convention, this 
method should be named arrayCopy (i.e., with an uppercase C).
7.13 Use the arraycopy method to copy the following array to a target array t:
int[] source = {3, 4, 5};
7.14 Once an array is created, its size cannot be changed. Does the following code resize 
the array?
int[] myList;
myList = new int[10];
// Sometime later you want to assign a new array to myList
myList = new int[20];
7.6 Passing Arrays to Methods
When passing an array to a method, the reference of the array is passed to the method.
Just as you can pass primitive type values to methods, you can also pass arrays to methods. 
For example, the following method displays the elements in an int array:
public static void printArray(int[] array) {
for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] + " ");
  }
}
You can invoke it by passing an array. For example, the following statement invokes the 
printArray method to display 3,1,2,6,4, and 2.
printArray(new int[]{3, 1, 2, 6, 4, 2});
arraycopy method
✓Point✓
Check
Key
Point
```

</details>


## PDF page 281

<details>
<summary>Page text</summary>

```text
258 Chapter 7  Single-Dimensional Arrays
Note
The preceding statement creates an array using the following syntax:
new elementType[]{value0, value1, ..., valuek};
There is no explicit reference variable for the array. Such array is called an anonymous
array.
Java uses pass-by-value to pass arguments to a method. There are important differences 
between passing the values of variables of primitive data types and passing arrays.
 ■ For an argument of a primitive type, the argument’s value is passed.
 ■ For an argument of an array type, the value of the argument is a reference to an array; 
this reference value is passed to the method. Semantically, it can be best described as 
pass-by-sharing, that is, the array in the method is the same as the array being passed. 
Thus, if you change the array in the method, you will see the change outside the method.
Take the following code, for example:
public class Test {
public static void main(String[] args) {
int x = 1; // x represents an int value
int[] y = new int[10]; // y represents an array of int values
m(x, y); // Invoke m with arguments x and y
    System.out.println("x is " + x);
    System.out.println("y[0] is " + y[0]);
  }
public static void m(int number, int[] numbers) {
    number = 1001; // Assign a new value to number
    numbers[0] = 5555; // Assign a new value to numbers[0]
  }
}
anonymous array
pass-by-value
pass-by-sharing
x is 1
y[0] is 5555
FIGURE 7.5 The primitive type value in x is passed to number, and the reference value in y
is passed to numbers.
reference
Activation record for the
main method
int[] y:
int x:1
Stack
Activation record for
methodm
int[] numbers:
int number: 1 An array of
tenint
values is
stored here
Arrays are
stored in a
heap.
Heap
reference
You may wonder why after m is invoked, x remains 1, but y[0] become 5555. This is 
becausey and numbers, although they are independent variables, reference the same array, as 
illustrated in Figure 7.5. When m(x, y) is invoked, the values of x and y are passed to num-
ber and numbers. Since y contains the reference value to the array, numbers now contains 
the same reference value to the same array.
```

</details>


## PDF page 282

<details>
<summary>Page text</summary>

```text
7.6 Passing Arrays to Methods  259
Note
Arrays are objects in Java (objects are introduced in Chapter 9). The JVM stores the 
objects in an area of memory called the heap, which is used for dynamic memory 
allocation.
Listing 7.3 gives another program that shows the difference between passing a primitive data 
type value and an array reference variable to a method.
The program contains two methods for swapping elements in an array. The first method, 
named swap, fails to swap two int arguments. The second method, named swapFirst-
TwoInArray, successfully swaps the first two elements in the array argument.
LISTING 7.3  TestPassArray.java
 1 public class TestPassArray {
 2 /** Main method */
 3 public static void main(String[] args) {
 4 int[] a = {1, 2};
 5
 6 // Swap elements using the swap method
 7      System.out.println("Before invoking swap");
 8      System.out.println("array is {" + a[0] + ", " + a[1] + "}");
 9 swap(a[ 0], a[1]);
10      System.out.println("After invoking swap");
11      System.out.println("array is {" + a[0] + ", " + a[1] + "}");
12
13 // Swap elements using the swapFirstTwoInArray method
14      System.out.println("Before invoking swapFirstTwoInArray");
15      System.out.println("array is {" + a[0] + ", " + a[1] + "}");
16 swapFirstTwoInArray(a);
17      System.out.println("After invoking swapFirstTwoInArray");
18      System.out.println("array is {" + a[0] + ", " + a[1] + "}");
19    }
20
21 /** Swap two variables */
22 public static void swap(int n1, int n2) {
23 int temp = n1;
24      n1 = n2;
25      n2 = temp;
26    }
27
28 /** Swap the first two elements in the array */
29 public static void swapFirstTwoInArray(int[] array) {
30 int temp = array[0];
31      array[0] = array[1];
32      array[1] = temp;
33    }
34  }
heap
false swap
swap array elements
Before invoking swap
array is {1, 2}
After invoking swap
array is {1, 2}
Before invoking swapFirstTwoInArray
array is {1, 2}
After invoking swapFirstTwoInArray
array is {2, 1}
```

</details>


## PDF page 283

<details>
<summary>Page text</summary>

```text
260 Chapter 7  Single-Dimensional Arrays
As shown in Figure 7.6, the two elements are not swapped using the swap method. However, 
they are swapped using the swapFirstTwoInArray method. Since the parameters in the 
swap method are primitive type, the values of a[0] and a[1] are passed to n1 and n2 inside 
the method when invoking swap(a[0], a[1]) . The memory locations for n1 and n2 are 
independent of the ones for a[0] and a[1]. The contents of the array are not affected by 
this call.
FIGURE 7.6 When passing an array to a method, the reference of the array is passed 
to the method.
Invokeswap(int n1, int n2).
The primitive type values in
a[0] and a[1] are passed to the
swap method.
InvokeswapFirstTwoInArray(int[]
array). The reference value in a is passed
to the swapFirstTwoInArray method.
The arrays are
stored in a
heap.
Stack Heap
Activation record for
theswap method
Activation record for
themain method
n2:2
n1:1
int[] a reference reference
reference
Stack
Activation record for the
swapFirstTwoInArray
method
Activation record for the
main method
int[] a
int[] array
a[0]:1
a[1]:2
 l public static int[] reverse(int[] list) {
 2 int[] result = new int[list.length];
3
 4 for (int i = 0, j = result.length - 1;
 5        i < list.length; i++, j--) {
 6     result[j] = list[i];
 7}
8
 9 return result;
10 }
list
result
The parameter in the swapFirstTwoInArray method is an array. As shown in Figure 7.6, 
the reference of the array is passed to the method. Thus the variables a (outside the method) 
and array (inside the method) both refer to the same array in the same memory location. 
Therefore, swapping array[0] with array[1] inside the method swapFirstTwoInArray
is the same as swapping a[0] with a[1] outside of the method.
7.7 Returning an Array from a Method
When a method returns an array, the reference of the array is returned.
You can pass arrays when invoking a method. A method may also return an array. For exam-
ple, the following method returns an array that is the reversal of another array.
Key
Point
create array
return array
Line 2 creates a new array result. Lines 4–7 copy elements from array list to array 
result. Line 9 returns the array. For example, the following statement returns a new array 
list2 with elements 6,5,4,3,2,1.
int[] list1 = {1, 2, 3, 4, 5, 6};
int[] list2 = reverse(list1);
```

</details>


## PDF page 284

<details>
<summary>Page text</summary>

```text
7.8 Case Study: Counting the Occurrences of Each Letter  261
7.15 Suppose the following code is written to reverse the contents in an array, explain 
why it is wrong. How do you fix it?
int[] list = {1, 2, 3, 5, 4};
for (int i = 0, j = list.length - 1; i < list.length; i++, j--) {
  // Swap list[i] with list[j]
int temp = list[i];
  list[i] = list[j];
  list[j] = temp;
}
7.8 Case Study: Counting the Occurrences 
of Each Letter
This section presents a program to count the occurrences of each letter in an array of 
characters.
The program given in Listing 7.4 does the following:
1. Generates 100 lowercase letters randomly and assigns them to an array of characters, as 
shown in Figure 7.7a. You can obtain a random letter by using the getRandomLower-
CaseLetter() method in the RandomCharacter class in Listing 6.10.
2. Count the occurrences of each letter in the array. To do so, create an array, say counts,
of 26 int values, each of which counts the occurrences of a letter, as shown in 
Figure  7.7b. That is, counts[0] counts the number of a’s, counts[1] counts the 
number of b’s, and so on.
✓Point✓
Check
Key
Point
FIGURE 7.7 Thechars array stores 100 characters, and the counts array stores 26 counts, 
each of which counts the occurrences of a letter.
…
…
chars[0]
chars[1]
…
…
chars[98]
chars[99]
…
…
counts[0]
counts[1]
…
…
counts[24]
counts[25]
(a) (b)
LISTING 7.4 CountLettersInArray.java
 1 public class CountLettersInArray {
 2 /** Main method */
 3 public static void main(String[] args) {
 4 // Declare and create an array
 5 char[] chars = createArray();
 6
 7 // Display the array
 8      System.out.println("The lowercase letters are:");
 9 displayArray(chars);
10
create array
pass array
```

</details>


## PDF page 285

<details>
<summary>Page text</summary>

```text
262 Chapter 7  Single-Dimensional Arrays
11 // Count the occurrences of each letter
12 int[] counts = countLetters(chars);
13
14 // Display counts
15      System.out.println();
16      System.out.println("The occurrences of each letter are:");
17 displayCounts(counts);
18    }
19
20 /** Create an array of characters */
21 public static char[] createArray() {
22 // Declare an array of characters and create it
23 char[] chars = new char[100];
24
25 // Create lowercase letters randomly and assign 
26 // them to the array
27 for (int i = 0; i < chars.length; i++) 
28        chars[i] = RandomCharacter.getRandomLowerCaseLetter();
29
30 // Return the array
31 return chars;
32    }
33
34 /** Display the array of characters */
35 public static void displayArray(char[] chars) {
36 // Display the characters in the array 20 on each line
37 for (int i = 0; i < chars.length; i++) {
38 if ((i + 1) % 20 == 0)
39          System.out.println(chars[i]);
40 else
41          System.out.print(chars[i] + " ");
42      }
43    }
44
45 /** Count the occurrences of each letter */
46 public static int[] countLetters(char[] chars) {
47 // Declare and create an array of 26 int
48 int[] counts = new int[26];
49
50 // For each lowercase letter in the array, count it
51 for (int i = 0; i < chars.length; i++) 
52        counts[chars[i] - 'a']++;
53
54 return counts;
55    }
56
57 /** Display counts */
58 public static void displayCounts(int[] counts) {
59 for (int i = 0; i < counts.length; i++) {
60 if ((i + 1) % 10 == 0)
61          System.out.println(counts[i] + " " + (char)(i + 'a'));
62 else
63          System.out.print(counts[i] + " " + (char)(i + 'a') + " ");
64      }
65    }
66  }
return array
pass array
increase count
```

</details>


## PDF page 286

<details>
<summary>Page text</summary>

```text
7.8 Case Study: Counting the Occurrences of Each Letter  263
The createArray method (lines 21–32) generates an array of 100 random lowercase let-
ters. Line 5 invokes the method and assigns the array to chars. What would be wrong if you 
rewrote the code as follows?
char[] chars = new char[100];
chars = createArray();
You would be creating two arrays. The first line would create an array by using new char[100].
The second line would create an array by invoking createArray() and assign the reference 
of the array to chars. The array created in the first line would be garbage because it is no longer 
referenced, and as mentioned earlier Java automatically collects garbage behind the scenes. 
Your program would compile and run correctly, but it would create an array unnecessarily.
Invoking getRandomLowerCaseLetter() (line 28) returns a random lowercase letter.
This method is defined in the RandomCharacter class in Listing 6.10.
The countLetters method (lines 46–55) returns an array of 26 int values, each of 
which stores the number of occurrences of a letter. The method processes each letter in the 
array and increases its count by one. A brute-force approach to count the occurrences of each 
letter might be as follows:
for (int i = 0; i < chars.length; i++) 
if (chars[i] == 'a')
    counts[0]++;
else if (chars[i] == 'b')
    counts[1]++;
  ...
But a better solution is given in lines 51–52.
for (int i = 0; i < chars.length; i++) 
      counts[chars[i] - 'a']++;
If the letter ( chars[i]) is a, the corresponding count is counts['a' - 'a']  (i.e., 
counts[0]). If the letter is b, the corresponding count is counts['b' - 'a']  (i.e., 
counts[1]), since the Unicode of b is one more than that of a. If the letter is z, the cor-
responding count is counts['z' - 'a'] (i.e., counts[25]), since the Unicode of z is 25
more than that of a.
Figure 7.8 shows the call stack and heap during and after executing createArray. See 
Checkpoint Question 7.18 to show the call stack and heap for other methods in the program.
The lowercase letters are:
e y l s r i b k j v j h a b z n w b t v 
s c c k r d w a m p w v u n q a m p l o 
a z g d e g f i n d x m z o u l o z j v 
h w i w n t g x w c d o t x h y v z y z 
q e a m f w p g u q t r e n n w f c r f 
The occurrences of each letter are:
5 a 3 b 4 c 4 d 4 e 4 f 4 g 3 h 3 i 3 j
2 k 3 l 4 m 6 n 4 o 3 p 3 q 4 r 2 s 4 t
3 u 5 v 8 w 3 x 3 y 6 z
```

</details>


## PDF page 287

<details>
<summary>Page text</summary>

```text
264 Chapter 7  Single-Dimensional Arrays
7.16 True or false? When an array is passed to a method, a new array is created and passed 
to the method.
7.17 Show the output of the following two programs:
✓Point✓
Check
FIGURE 7.8 (a) An array of 100 characters is created when executing createArray.
(b) This array is returned and assigned to the variable chars in the main method.
Array of 100
characters
Stack
(a) Executing
createArray in line 5
(b) After exiting
createArray in line 5
Heap
Activation record for the
createArray method
Activation record for the
main method
Array of 100
characters
Stack Heap
Activation record for the
main method
char[] chars: refchar[] chars: ref
char[] chars: ref
public class Test {
public static void main(String[] args) {
int number = 0;
int[] numbers = new int[1];
    m(number, numbers);
    System.out.println("number is " + number
      + " and numbers[0] is " + numbers[0]);
  }
public static void m(int x, int[] y) {
    x = 3;
    y[0] = 3;
  }
}
(a)
public class Test {
public static void main(String[] args) {
int[] list = {1, 2, 3, 4, 5};
    reverse(list);
for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
public static void reverse(int[] list) {
int[] newList = new int[list.length];
for (int i = 0; i < list.length; i++)
      newList[i] = list[list.length - 1 - i];
    list = newList;
  }
}
(b)
7.18 Where are the arrays stored during execution? Show the contents of the stack and 
heap during and after executing displayArray,countLetters,displayCounts
in Listing 7.4.
7.9 Variable-Length Argument Lists
A variable number of arguments of the same type can be passed to a method and 
treated as an array.
You can pass a variable number of arguments of the same type to a method. The parameter in 
the method is declared as follows:
typeName... parameterName
In the method declaration, you specify the type followed by an ellipsis ( ...). Only one 
variable-length parameter may be specified in a method, and this parameter must be the last 
parameter. Any regular parameters must precede it.
Key
Point
```

</details>


## PDF page 288

<details>
<summary>Page text</summary>

```text
7.10 Searching Arrays  265
Java treats a variable-length parameter as an array. You can pass an array or a variable 
number of arguments to a variable-length parameter. When invoking a method with a vari-
able number of arguments, Java creates an array and passes the arguments to it. Listing 7.5 
contains a method that prints the maximum value in a list of an unspecified number of values.
LISTING 7.5 VarArgsDemo.java
 1 public class VarArgsDemo {
 2 public static void main(String[] args) {
 3 printMax( 34, 3, 3, 2, 56.5);
 4 printMax( new double[]{1, 2, 3});
 5    }
 6
 7 public static void printMax(double... numbers) {
 8 if (numbers.length == 0) {
 9        System.out.println("No argument passed");
10 return;
11      }
12
13 double result = numbers[0];
14
15 for (int i = 1; i < numbers.length; i++)
16 if (numbers[i] > result)
17          result = numbers[i];
18
19      System.out.println("The max value is " + result);
20    }
21  }
Line 3 invokes the printMax method with a variable-length argument list passed to the array 
numbers. If no arguments are passed, the length of the array is 0 (line 8).
Line 4 invokes the printMax method with an array.
7.19 What is wrong in the following method header?
public static void print(String... strings, double... numbers)
public static void print(double... numbers, String name)
public static double... print(double d1, double d2)
7.20 Can you invoke the printMax method in Listing 7.5 using the following statements?
printMax(1, 2, 2, 1, 4);
printMax(new double[]{1, 2, 3});
printMax(new int[]{1, 2, 3});
7.10 Searching Arrays
If an array is sorted, binary search is more efficient than linear search for finding an 
element in the array.
Searching is the process of looking for a specific element in an array—for example, discov-
ering whether a certain score is included in a list of scores. Searching is a common task in 
computer programming. Many algorithms and data structures are devoted to searching. This 
section discusses two commonly used approaches, linear search and binary search.
7.10.1 The Linear Search Approach
The linear search approach compares the key element key sequentially with each element in 
the array. It continues to do so until the key matches an element in the array or the array is 
exhausted without a match being found. If a match is made, the linear search returns the index 
pass variable-length arg list
pass an array arg
a variable-length arg 
parameter
✓Point✓
Check
Key
Point
linear search
binary search
```

</details>


## PDF page 289

<details>
<summary>Page text</summary>

```text
266 Chapter 7  Single-Dimensional Arrays
of the element in the array that matches the key. If no match is found, the search returns -1.
ThelinearSearch method in Listing 7.6 gives the solution.
LISTING 7.6  LinearSearch.java
linear search animation on 
Companion Website
list
key Compare key with list[i] for i = 0, 1, …
[0] [1] [2] …
1 public class LinearSearch {
2   /** The method for finding a key in the list */
3 public static int linearSearch(int[] list, int key) {
4 for (int i = 0; i < list.length; i++) {
5 if (key == list[i])
6 return i;
7}
8 return -1;
9}
10 }
To better understand this method, trace it with the following statements:
1 int[] list = {1, 4, 4, 2, 5, -3, 6, 2};
2 int i = linearSearch(list, 4); // Returns 1
3 int j = linearSearch(list, -4); // Returns -1
4 int k = linearSearch(list, -3); // Returns 5
The linear search method compares the key with each element in the array. The elements can 
be in any order. On average, the algorithm will have to examine half of the elements in an 
array before finding the key, if it exists. Since the execution time of a linear search increases 
linearly as the number of array elements increases, linear search is inefficient for a large array.
7.10.2 The Binary Search Approach
Binary search is the other common search approach for a list of values. For binary search to 
work, the elements in the array must already be ordered. Assume that the array is in ascending 
order. The binary search first compares the key with the element in the middle of the array. 
Consider the following three cases:
 ■ If the key is less than the middle element, you need to continue to search for the key 
only in the first half of the array.
 ■ If the key is equal to the middle element, the search ends with a match.
 ■ If the key is greater than the middle element, you need to continue to search for the 
key only in the second half of the array.
Clearly, the binary search method eliminates at least half of the array after each comparison. 
Sometimes you eliminate half of the elements, and sometimes you eliminate half plus one. 
Suppose that the array has n elements. For convenience, let n be a power of 2. After the first 
comparison, n/2 elements are left for further search; after the second comparison, (n/2)/2
elements are left. After the kth comparison, n/2k elements are left for further search. When 
k = log2n, only one element is left in the array, and you need only one more comparison. 
Therefore, in the worst case when using the binary search approach, you need log2n+1 com-
parisons to find an element in the sorted array. In the worst case for a list of 1024 (210) ele-
ments, binary search requires only 11 comparisons, whereas a linear search requires 1023
comparisons in the worst case.
The portion of the array being searched shrinks by half after each comparison. Let low and 
high denote, respectively, the first index and last index of the array that is currently being 
searched. Initially, low is 0 and high is list.length–1. Let mid denote the index of the 
middle element, so mid is (low + high)/2. Figure 7.9 shows how to find key 11 in the list 
{2,4,7,10,11,45,50,59,60,66,69,70,79} using binary search.
binary search animation on 
Companion Website
```

</details>


## PDF page 290

<details>
<summary>Page text</summary>

```text
7.10 Searching Arrays  267
You now know how the binary search works. The next task is to implement it in Java. 
Don’t rush to give a complete implementation. Implement it incrementally, one step at a time. 
You may start with the first iteration of the search, as shown in Figure 7.10a. It compares the 
key with the middle element in the list whose low index is 0 and high index is list.length
- 1. If key < list[mid], set the high index to mid - 1; if key == list[mid], a match 
is found and return mid; if key > list[mid], set the low index to mid + 1.
Next consider implementing the method to perform the search repeatedly by adding a loop, 
as shown in Figure 7.10b. The search ends if the key is found, or if the key is not found when 
low > high.
When the key is not found, low is the insertion point where a key would be inserted to 
maintain the order of the list. It is more useful to return the insertion point than -1. The 
method must return a negative value to indicate that the key is not in the list. Can it simply 
return–low? No. If the key is less than list[0],low would be 0.-0 is 0. This would indi-
cate that the key matches list[0]. A good choice is to let the method return –low – 1 if the 
key is not in the list. Returning –low – 1 indicates not only that the key is not in the list, but 
also where the key would be inserted.
why not -1?
FIGURE 7.9 Binary search eliminates half of the list from further consideration after each 
comparison.
key is 11 low
key /H11021 50
key /H11022 7
[0] [1] [2] [3] [4] [5] [7] [8] [9] [10] [11]
2list 4 7 10 11 45 50 59 60 66 69 70 79
mid
[6]
high
[12]
low
[0] [1] [2] [3] [4] [5]
2list 4 7 10 11 45
mid high
key /H11005/H11005 11
[3] [4] [5]
list 10 11 45
low mid high
public static int binarySearch(
int[] list, int key) {
int low = 0;
int high = list.length - 1;
int mid = (low + high) / 2;
if (key < list[mid])
      high = mid - 1;
else if (key == list[mid])
return mid;
else
      low = mid + 1;
}
(a) Version 1
public static int binarySearch(
int[] list, int key) {
int low = 0;
int high = list.length - 1;
while (high >= low) {
int mid = (low + high) / 2;
if (key < list[mid])
      high = mid - 1;
else if (key == list[mid])
return mid;
else
      low = mid + 1;
}
return -1; // Not found
}
(b) Version 2
FIGURE 7.10 Binary search is implemented incrementally.
```

</details>


## PDF page 291

<details>
<summary>Page text</summary>

```text
268 Chapter 7  Single-Dimensional Arrays
The complete program is given in Listing 7.7.
LISTING 7.7  BinarySearch.java
 1 public class BinarySearch {
 2 /** Use binary search to find the key in the list */
 3 public static int binarySearch(int[] list, int key) {
 4 int low = 0;
 5 int high = list.length - 1;
 6
 7 while (high >= low) {
 8 int mid = (low + high) / 2;
 9 if (key < list[mid])
10          high = mid - 1;
11 else if (key == list[mid])
12 return mid;
13 else
14          low = mid + 1;
15 }
16
17 return –low - 1; // Now high < low, key not found 
18    }
19  }
The binary search returns the index of the search key if it is contained in the list (line 12). 
Otherwise, it returns –low – 1 (line 17).
What would happen if we replaced (high >= low)  in line 7 with (high > low )? The 
search would miss a possible matching element. Consider a list with just one element. The 
search would miss the element.
Does the method still work if there are duplicate elements in the list? Yes, as long as the 
elements are sorted in increasing order. The method returns the index of one of the matching 
elements if the element is in the list.
To better understand this method, trace it with the following statements and identify low
andhigh when the method returns.
int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
int i = BinarySearch.binarySearch(list, 2); // Returns 0
int j = BinarySearch.binarySearch(list, 11); // Returns 4
int k = BinarySearch.binarySearch(list, 12); // Returns –6
int l = BinarySearch.binarySearch(list, 1); // Returns –1
int m = BinarySearch.binarySearch(list, 3); // Returns –2
Here is the table that lists the low and high values when the method exits and the value 
returned from invoking the method.
first half
second half
Method Low High Value Returned
binarySearch(list, 2) 0 1 0
binarySearch(list, 11) 3 5 4
binarySearch(list, 12) 5 4 -6
binarySearch(list, 1) 0 -1 -1
binarySearch(list, 3) 1 0 -2
Note
Linear search is useful for finding an element in a small array or an unsorted array, but 
it is inefficient for large arrays. Binary search is more efficient, but it requires that the 
array be presorted.
binary search benefits
```

</details>


## PDF page 292

<details>
<summary>Page text</summary>

```text
7.11 Sorting Arrays  269
7.21 Ifhigh is a very large integer such as the maximum int value 2147483647,(low
+ high) / 2 may cause overflow. How do you fix it to avoid overflow?
7.22 Use Figure 7.9 as an example to show how to apply the binary search approach to a 
search for key 10 and key 12 in list {2,4,7,10,11,45,50,59,60,66,69,70,79}.
7.23 If the binary search method returns -4, is the key in the list? Where should the key 
be inserted if you wish to insert the key into the list?
7.11 Sorting Arrays
Sorting, like searching, is a common task in computer programming. Many different 
algorithms have been developed for sorting. This section introduces an intuitive sort-
ing algorithm: selection sort.
Suppose that you want to sort a list in ascending order. Selection sort finds the smallest 
number in the list and swaps it with the first element. It then finds the smallest number 
remaining and swaps it with the second element, and so on, until only a single number 
remains. Figure 7.11 shows how to sort the list { 2,9,5,4,8,1,6} using selection sort.
✓Point✓
Check
Key
Point
selection sort
selection sort animation on 
Companion Website
FIGURE 7.11 Selection sort repeatedly selects the smallest number and swaps it with the first number in the list.
Select 1 (the smallest) and swap it
with 2 (the first) in the list.
The number 1 is now in the
correct position and thus no
longer needs to be considered.
The number 2 is now in the
correct position and thus no
longer needs to be considered.
The number 4 is now in the
correct position and thus no
longer needs to be considered.
The number 5 is now in the
correct position and thus no
longer needs to be considered.
The number 6 is now in the
correct position and thus no
longer needs to be considered.
2
1
1
1
1
1
1
9
9
2
2
2
2
2
5
swap
5
5
4
4
4
4
4
4
4
5
5
5
5
8
8
8
8
8
6
6
1
2
9
9
9
9
8
6
6
6
6
6
8
9
The number 8 is now in the
correct position and thus no
longer needs to be considered.
Select 2 (the smallest) and swap it
with 9 (the first) in the remaining
list.
Select 4 (the smallest) and swap it
with 5 (the first) in the remaining
list.
5 is the smallest and in the right
position. No swap is necessary.
Select 6 (the smallest) and swap it
with 8 (the first) in the remaining
list.
Select 8 (the smallest) and swap it
with 9 (the first) in the remaining
list.
Since there is only one element
remaining in the list, the sort is
completed.
swap
swap
swap
swap
You know how the selection-sort approach works. The task now is to implement it in Java. 
Beginners find it difficult to develop a complete solution on the first attempt. Start by writing 
the code for the first iteration to find the smallest element in the list and swap it with the first 
element, and then observe what would be different for the second iteration, the third, and so 
on. The insight this gives will enable you to write a loop that generalizes all the iterations.
VideoNote
Selection sort
```

</details>


## PDF page 293

<details>
<summary>Page text</summary>

```text
270 Chapter 7  Single-Dimensional Arrays
The solution can be described as follows:
for (int i = 0; i < list.length - 1; i++) {
  select the smallest element in list[i..list.length-1];
  swap the smallest with list[i], if necessary;
  // list[i] is in its correct position. 
  // The next iteration applies on list[i+1..list.length-1]
}
Listing 7.8 implements the solution.
LISTING 7.8 SelectionSort.java
 1 public class SelectionSort {
 2 /** The method for sorting the numbers */
 3 public static void selectionSort(double[] list) {
 4 for (int i = 0; i < list.length - 1; i++) {
 5 // Find the minimum in the list[i..list.length-1]
 6 double currentMin = list[i];
 7 int currentMinIndex = i;
 8
 9 for (int j = i + 1; j < list.length; j++) {
10 if (currentMin > list[j]) {
11            currentMin = list[j];
12            currentMinIndex = j;
13          }
14        }
15
16 // Swap list[i] with list[currentMinIndex] if necessary
17 if (currentMinIndex != i) {
18          list[currentMinIndex] = list[i];
19          list[i] = currentMin;
20        }
21      }
22    }
23  }
TheselectionSort(double[] list) method sorts any array of double elements. The 
method is implemented with a nested for loop. The outer loop (with the loop control vari-
ablei) (line 4) is iterated in order to find the smallest element in the list, which ranges from 
list[i] to list[list.length-1], and exchange it with list[i].
The variable i is initially 0. After each iteration of the outer loop, list[i] is in the right 
place. Eventually, all the elements are put in the right place; therefore, the whole list is sorted.
To understand this method better, trace it with the following statements:
double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
SelectionSort.selectionSort(list);
7.24 Use Figure 7.11 as an example to show how to apply the selection-sort approach to 
sort {3.4,5,3,3.5,2.2,1.9,2}.
7.25 How do you modify the selectionSort method in Listing 7.8 to sort numbers in 
decreasing order?
7.12 The Arrays Class
Thejava.util.Arrays class contains useful methods for common array operations 
such as sorting and searching.
select
swap
✓Point✓
Check
Key
Point
```

</details>


## PDF page 294

<details>
<summary>Page text</summary>

```text
7.12 The Arrays Class 271
The java.util.Arrays class contains various static methods for sorting and searching 
arrays, comparing arrays, filling array elements, and returning a string representation of the 
array. These methods are overloaded for all primitive types.
You can use the sort or parallelSort method to sort a whole array or a partial array. 
For example, the following code sorts an array of numbers and an array of characters.
double[] numbers = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
java.util.Arrays.sort(numbers); // Sort the whole array
java.util.Arrays.parallelSort(numbers); // Sort the whole array
char[] chars = {'a', 'A', '4', 'F', 'D', 'P'};
java.util.Arrays.sort(chars, 1, 3); // Sort part of the array
java.util.Arrays.parallelSort(chars, 1, 3); // Sort part of the array
Invokingsort(numbers) sorts the whole array numbers. Invoking sort(chars, 1, 3)
sorts a partial array from chars[1] to chars[3-1]. parallelSort is more efficient if 
your computer has multiple processors. 
You can use the binarySearch method to search for a key in an array. The array must be pre-
sorted in increasing order. If the key is not in the array, the method returns –(insertionIndex 
+ 1). For example, the following code searches the keys in an array of integers and an array 
of characters.
int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
System.out.println("1. Index is " + 
java.util.Arrays.binarySearch(list, 11));
System.out.println("2. Index is " + 
       java.util.Arrays.binarySearch(list, 12));
char[] chars = {'a', 'c', 'g', 'x', 'y', 'z'};
System.out.println("3. Index is " + 
       java.util.Arrays.binarySearch(chars, 'a'));
System.out.println("4. Index is " + 
       java.util.Arrays.binarySearch(chars, 't'));
The output of the preceding code is
1. Index is 4
2. Index is -6
3. Index is 0
4. Index is -4
You can use the equals method to check whether two arrays are strictly equal. Two arrays 
are strictly equal if their corresponding elements are the same. In the following code, list1
andlist2 are equal, but list2 and list3 are not.
int[] list1 = {2, 4, 7, 10};
int[] list2 = {2, 4, 7, 10};
int[] list3 = {4, 2, 7, 10};
System.out.println(java.util.Arrays.equals(list1, list2)); // true
System.out.println(java.util.Arrays.equals(list2, list3)); // false
You can use the fill method to fill in all or part of the array. For example, the following code 
fillslist1 with 5 and fills 8 into elements list2[1] through list2[5-1].
int[] list1 = {2, 4, 7, 10};
int[] list2 = {2, 4, 7, 7, 7, 10};
java.util.Arrays.fill(list1, 5); // Fill 5 to the whole array
java.util.Arrays.fill(list2, 1, 5, 8); // Fill 8 to a partial array
sort
parallelSort
binarySearch
equals
fill
```

</details>


## PDF page 295

<details>
<summary>Page text</summary>

```text
272 Chapter 7  Single-Dimensional Arrays
You can also use the toString method to return a string that represents all elements in the array. 
This is a quick and simple way to display all elements in the array. For example, the following code
int[] list = {2, 4, 7, 10};
System.out.println(Arrays.toString(list));
displays[2, 4, 7, 10].
7.26 What types of array can be sorted using the java.util.Arrays.sort method? 
Does this sort method create a new array?
7.27 To apply java.util.Arrays.binarySearch(array, key) , should the array 
be sorted in increasing order, in decreasing order, or neither?
7.28 Show the output of the following code:
int[] list1 = {2, 4, 7, 10};
java.util.Arrays.fill(list1, 7);
System.out.println(java.util.Arrays.toString(list1));
int[] list2 = {2, 4, 7, 10};
System.out.println(java.util.Arrays.toString(list2));
System.out.print(java.util.Arrays.equals(list1, list2));
7.13 Command-Line Arguments
Themain method can receive string arguments from the command line.
Perhaps you have already noticed the unusual header for the main method, which has the 
parameter args of String[] type. It is clear that args is an array of strings. The main
method is just like a regular method with a parameter. You can call a regular method by pass-
ing actual parameters. Can you pass arguments to main? Yes, of course you can. In the fol-
lowing examples, the main method in class TestMain is invoked by a method in A.
toString
✓Point✓
Check
Key
Point
VideoNote
Command-line arguments
A main method is just a regular method. Furthermore, you can pass arguments from the 
command line.
7.13.1 Passing Strings to the main Method
You can pass strings to a main method from the command line when you run the program. 
The following command line, for example, starts the program TestMain with three strings: 
arg0,arg1, and arg2:
java TestMain arg0 arg1 arg2
arg0, arg1, and arg2 are strings, but they don’t have to appear in double quotes on the 
command line. The strings are separated by a space. A string that contains a space must be 
enclosed in double quotes. Consider the following command line:
java TestMain "First num" alpha 53
public class A {
public static void main(String[] args) {
    String[] strings = {"New York",
"Boston", "Atlanta"};
TestMain.main(strings);
  }
}
public class TestMain {
public static void main(String[] args) {
for (int i = 0; i < args.length; i++)
      System.out.println(args[i]);
  }
}
```

</details>


## PDF page 296

<details>
<summary>Page text</summary>

```text
7.13 Command-Line Arguments 273
It starts the program with three strings: First num, alpha, and 53. Since First num is a 
string, it is enclosed in double quotes. Note that 53 is actually treated as a string. You can use 
"53" instead of 53 in the command line.
When the main method is invoked, the Java interpreter creates an array to hold the com-
mand-line arguments and pass the array reference to args. For example, if you invoke a 
program with n arguments, the Java interpreter creates an array like this one:
args = new String[n];
The Java interpreter then passes args to invoke the main method.
Note
If you run the program with no strings passed, the array is created with new String[0].
In this case, the array is empty with length 0. args references to this empty array. 
Therefore,args is not null, but args.length is 0.
7.13.2 Case Study: Calculator
Suppose you are to develop a program that performs arithmetic operations on integers. The 
program receives an expression in one string argument. The expression consists of an inte-
ger followed by an operator and another integer. For example, to add two integers, use this 
command:
java Calculator 2 + 3
The program will display the following output:
2 + 3 = 5
Figure 7.12 shows sample runs of the program.
The strings passed to the main program are stored in args, which is an array of strings. The 
first string is stored in args[0], and args.length is the number of strings passed.
Here are the steps in the program:
1. Use args.length to determine whether the expression has been provided as three 
arguments in the command line. If not, terminate the program using System.exit(1).
2. Perform a binary arithmetic operation on the operands args[0] and args[2] using the 
operator in args[1].
VideoNote
Command-line argument
FIGURE 7.12 The program takes three arguments (operand1 operator operand2) from 
the command line and displays the expression and the result of the arithmetic operation.
Add
Subtract
Multiply
Divide
```

</details>


## PDF page 297

<details>
<summary>Page text</summary>

```text
274 Chapter 7  Single-Dimensional Arrays
The program is shown in Listing 7.9.
LISTING 7.9  Calculator.java
 1 public class Calculator {
 2 /** Main method */
 3 public static void main(String[] args) {
 4 // Check number of strings passed
 5 if (args.length != 3) {
 6        System.out.println(
 7 "Usage: java Calculator operand1 operator operand2");
 8        System.exit(0);
 9      }
10
11 // The result of the operation
12 int result = 0;
13
14 // Determine the operator
15 switch (args[1].charAt(0)) { 
16 case '+': result = Integer.parseInt(args[0]) +
17                           Integer.parseInt(args[2]);
18 break;
19 case '-': result = Integer.parseInt(args[0]) -
20                           Integer.parseInt(args[2]);
21 break;
22 case '.': result = Integer.parseInt(args[0]) *
23                           Integer.parseInt(args[2]);
24 break;
25 case '/': result = Integer.parseInt(args[0]) /
26                           Integer.parseInt(args[2]);
27      }
28
29 // Display result
30      System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
31        + " = " + result);
32    }
33  }
Integer.parseInt(args[0]) (line 16) converts a digital string into an integer. The string 
must consist of digits. If not, the program will terminate abnormally. 
We used the . symbol for multiplication, not the common * symbol. The reason for this is 
that the * symbol refers to all the files in the current directory when it is used on a command 
line. The following program displays all the files in the current directory when issuing the 
commandjava Test *:
public class Test {
public static void main(String[] args) {
for (int i = 0; i < args.length; i++)
      System.out.println(args[i]);
  }
}
To circumvent this problem, we will have to use a different symbol for the multiplication operator.
7.29 This book declares the main method as
public static void main(String[] args)
Can it be replaced by one of the following lines?
public static void main(String args[])
public static void main(String[] x)
check argument
check operator
✓Point✓
Check
```

</details>


## PDF page 298

<details>
<summary>Page text</summary>

```text
Chapter Summary  275
public static void main(String x[])
static void main(String x[])
7.30 Show the output of the following program when invoked using
1. java Test I have a dream
2. java Test “1 2 3”
3. java Test
public class Test {
public static void main(String[] args) {
    System.out.println("Number of strings is " + args.length);
for (int i = 0; i < args.length; i++) 
      System.out.println(args[i]);
  }
}
KEY TERMS
anonymous array 258
array 246
array initializer 248
binary search 265
garbage collection 256
index 246
indexed variable 248
linear search 265
off-by-one error 251
selection sort 269
CHAPTER SUMMARY
1. A variable is declared as an array type using the syntax elementType[] arrayRefVar
or elementType arrayRefVar[] . The style elementType[] arrayRefVar  is 
preferred, although elementType arrayRefVar[] is legal.
2. Unlike declarations for primitive data type variables, the declaration of an array variable 
does not allocate any space in memory for the array. An array variable is not a primitive 
data type variable. An array variable contains a reference to an array.
3. You cannot assign elements to an array unless it has already been created. You 
can create an array by using the new operator with the following syntax: new
elementType[arraySize].
4. Each element in the array is represented using the syntax arrayRefVar[index]. An 
index must be an integer or an integer expression.
5. After an array is created, its size becomes permanent and can be obtained using 
arrayRefVar.length. Since the index of an array always begins with 0, the last 
index is always arrayRefVar.length - 1. An out-of-bounds error will occur if you 
attempt to reference elements beyond the bounds of an array.
6. Programmers often mistakenly reference the first element in an array with index 1, but 
it should be 0. This is called the index off-by-one error.
```

</details>


## PDF page 299

<details>
<summary>Page text</summary>

```text
276 Chapter 7  Single-Dimensional Arrays
7. When an array is created, its elements are assigned the default value of 0 for the numeric 
primitive data types, \u0000 for char types, and false for boolean types.
8. Java has a shorthand notation, known as the array initializer, which combines declaring 
an array, creating an array, and initializing an array in one statement, using the syntax 
elementType[] arrayRefVar = {value0, value1, ..., valuek}.
9. When you pass an array argument to a method, you are actually passing the reference 
of the array; that is, the called method can modify the elements in the caller’s original 
array.
10. If an array is sorted, binary search is more efficient than linear search for finding an 
element in the array.
11. Selection sort finds the smallest number in the list and swaps it with the first element. 
It then finds the smallest number remaining and swaps it with the first element in the 
remaining list, and so on, until only a single number remains.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
Sections 7.2–7.5
*7.1 (Assign grades) Write a program that reads student scores, gets the best score, 
and then assigns grades based on the following scheme:
Grade is A if score is Ú best - 10
Grade is B if score is Ú best - 20;
Grade is C if score is Ú best - 30;
Grade is D if score is Ú best - 40;
Grade is F otherwise.
The program prompts the user to enter the total number of students, then prompts 
the user to enter all of the scores, and concludes by displaying the grades. Here 
is a sample run:
Enter the number of students: 4
Enter 4 scores: 40 55 70 58
Student 0 score is 40 and grade is C
Student 1 score is 55 and grade is B
Student 2 score is 70 and grade is A
Student 3 score is 58 and grade is B
7.2 (Reverse the numbers entered) Write a program that reads ten integers and dis-
plays them in the reverse of the order in which they were read.
```

</details>


## PDF page 300

<details>
<summary>Page text</summary>

```text
**7.3 (Count occurrence of numbers) Write a program that reads the integers between 1 
and 100 and counts the occurrences of each. Assume the input ends with 0. Here 
is a sample run of the program:
Programming Exercises  277
Enter the integers between 1 and 100: 2 5 6 5 4 3 23 43 2 0
2 occurs 2 times
3 occurs 1 time
4 occurs 1 time
5 occurs 2 times
6 occurs 1 time
23 occurs 1 time
43 occurs 1 time
Note that if a number occurs more than one time, the plural word “times” is used 
in the output.
7.4 (Analyze scores) Write a program that reads an unspecified number of scores and 
determines how many scores are above or equal to the average and how many 
scores are below the average. Enter a negative number to signify the end of the 
input. Assume that the maximum number of scores is 100.
**7.5 (Print distinct numbers) Write a program that reads in ten numbers and displays 
the number of distinct numbers and the distinct numbers separated by exactly one 
space (i.e., if a number appears multiple times, it is displayed only once). ( Hint:
Read a number and store it to an array if it is new. If the number is already in the 
array, ignore it.) After the input, the array contains the distinct numbers. Here is 
the sample run of the program:
Enter ten numbers: 1 2 3 2 1 6 3 4 5 2
The number of distinct number is 6
The distinct numbers are: 1 2 3 6 4 5
*7.6 (Revise Listing 5.15, PrimeNumber.java) Listing 5.15 determines whether a num-
bern is prime by checking whether 2,3,4,5,6,  ..., n/2 is a divisor. If a divisor 
is found, n is not prime. A more efficient approach is to check whether any of the 
prime numbers less than or equal to 2n can divide n evenly. If not, n is prime. 
Rewrite Listing 5.15 to display the first 50 prime numbers using this approach. 
You need to use an array to store the prime numbers and later use them to check 
whether they are possible divisors for n.
*7.7 (Count single digits) Write a program that generates 100 random integers between 
0 and 9 and displays the count for each number. (Hint: Use an array of ten integers, 
saycounts, to store the counts for the number of 0s, 1s, ...,  9s.)
Sections 7.6–7.8
7.8 (Average an array) Write two overloaded methods that return the average of an 
array with the following headers:
public static int average(int[] array)
public static double average(double[] array)
Write a test program that prompts the user to enter ten double values, invokes this 
method, and displays the average value.
```

</details>


## PDF page 301

<details>
<summary>Page text</summary>

```text
278 Chapter 7  Single-Dimensional Arrays
7.9 (Find the smallest element) Write a method that finds the smallest element in an 
array of double values using the following header:
public static double min(double[] array)
Write a test program that prompts the user to enter ten numbers, invokes this 
method to return the minimum value, and displays the minimum value. Here is a 
sample run of the program:
Enter ten numbers: 1.9 2.5 3.7 2 1.5 6 3 4 5 2
The minimum number is: 1.5
Enter ten numbers: 1.9 2.5 3.7 2 1 6 3 4 5 2
The mean is 3.11
The standard deviation is 1.55738 
7.10 (Find the index of the smallest element) Write a method that returns the index of 
the smallest element in an array of integers. If the number of such elements is 
greater than 1, return the smallest index. Use the following header:
public static int indexOfSmallestElement(double[] array)
Write a test program that prompts the user to enter ten numbers, invokes this 
method to return the index of the smallest element, and displays the index.
*7.11 (Statistics: compute deviation) Programming Exercise 5.45 computes the stand-
ard deviation of numbers. This exercise uses a different but equivalent formula to
compute the standard deviation of n numbers.
mean =
a
n
i = 1
xi
n = x1 + x2 + g + xnn deviation = H a
n
i = 1
(xi - mean)2
n - 1
To compute the standard deviation with this formula, you have to store the indi-
vidual numbers using an array, so that they can be used after the mean is obtained.
Your program should contain the following methods:
/** Compute the deviation of double values */
public static double deviation(double[] x) 
/** Compute the mean of an array of double values */
public static double mean(double[] x) 
Write a test program that prompts the user to enter ten numbers and displays the 
mean and standard deviation, as shown in the following sample run:
*7.12 (Reverse an array ) The reverse method in Section  7.7 reverses an array by 
copying it to a new array. Rewrite the method that reverses the array passed in 
the argument and returns this array. Write a test program that prompts the user to
```

</details>


## PDF page 302

<details>
<summary>Page text</summary>

```text
enter ten numbers, invokes the method to reverse the numbers, and displays the 
numbers.
Section 7.9
*7.13 (Random number chooser) Write a method that returns a random number between 
1 and 54, excluding the numbers passed in the argument. The method header is 
specified as follows:
public static int getRandom(int... numbers)
7.14 (Computing gcd) Write a method that returns the gcd of an unspecified number 
of integers. The method header is specified as follows:
public static int gcd(int... numbers)
Write a test program that prompts the user to enter five numbers, invokes the 
method to find the gcd of these numbers, and displays the gcd.
Sections 7.10–7.12
7.15 (Eliminate duplicates) Write a method that returns a new array by eliminating the 
duplicate values in the array using the following method header:
public static int[] eliminateDuplicates(int[] list)
Write a test program that reads in ten integers, invokes the method, and displays 
the result. Here is the sample run of the program:
Programming Exercises  279
Enter ten numbers: 1 2 3 2 1 6 3 4 5 2
The distinct numbers are: 1 2 3 6 4 5
7.16 (Execution time) Write a program that randomly generates an array of 100,000 
integers and a key. Estimate the execution time of invoking the linearSearch
method in Listing 7.6. Sort the array and estimate the execution time of invok-
ing the binarySearch method in Listing 7.7. You can use the following code 
template to obtain the execution time:
long startTime = System.currentTimeMillis();
perform the task;
long endTime = System.currentTimeMillis();
long executionTime = endTime - startTime;
**7.17 (Sort students) Write a program that prompts the user to enter the number of stu-
dents, the students’ names, and their scores, and prints student names in decreas-
ing order of their scores.
**7.18 (Bubble sort) Write a sort method that uses the bubble-sort algorithm. The bubble-
sort algorithm makes several passes through the array. On each pass, successive 
neighboring pairs are compared. If a pair is not in order, its values are swapped; 
otherwise, the values remain unchanged. The technique is called a bubble sort or 
sinking sort because the smaller values gradually “bubble” their way to the top 
and the larger values “sink” to the bottom. Write a test program that reads in ten 
double numbers, invokes the method, and displays the sorted numbers.
```

</details>


## PDF page 303

<details>
<summary>Page text</summary>

```text
280 Chapter 7  Single-Dimensional Arrays
**7.19 (Sorted?) Write the following method that returns true if the list is already sorted 
in increasing order.
public static boolean isSorted(int[] list)
Write a test program that prompts the user to enter a list and displays whether 
the list is sorted or not. Here is a sample run. Note that the first number in the 
input indicates the number of the elements in the list. This number is not part 
of the list.  
Enter list: 8 10 1 5 16 61 9 11 1
The list is not sorted
Enter list: 10 1 1 3 4 4 5 7 9 11 21
The list is already sorted
FIGURE 7.13 Each ball takes a random path and falls into a slot.
(a) (b) (c)
*7.20 (Revise selection sort) In Section 7.11, you used selection sort to sort an array. 
The selection-sort method repeatedly finds the smallest number in the current 
array and swaps it with the first. Rewrite this program by finding the largest num-
ber and swapping it with the last. Write a test program that reads in ten double 
numbers, invokes the method, and displays the sorted numbers.
***7.21 (Game: bean machine) The bean machine, also known as a quincunx or the Gal-
ton box, is a device for statistics experiments named after English scientist Sir 
Francis Galton. It consists of an upright board with evenly spaced nails (or pegs) 
in a triangular form, as shown in Figure 7.13.
Balls are dropped from the opening of the board. Every time a ball hits a nail, it 
has a 50% chance of falling to the left or to the right. The piles of balls are accu-
mulated in the slots at the bottom of the board.
Write a program that simulates the bean machine. Your program should prompt 
the user to enter the number of the balls and the number of the slots in the machine. 
Simulate the falling of each ball by printing its path. For example, the path for 
the ball in Figure 7.13b is LLRRLLR and the path for the ball in Figure 7.13c is
```

</details>


## PDF page 304

<details>
<summary>Page text</summary>

```text
(Hint: Create an array named slots. Each element in slots stores the num-
ber of balls in a slot. Each ball falls into a slot via a path. The number of Rs in 
a path is the position of the slot where the ball falls. For example, for the path 
LRLRLRR, the ball falls into slots[4], and for the path is RRLLLLL, the ball 
falls into slots[2].)
***7.22 (Game: Eight Queens) The classic Eight Queens puzzle is to place eight queens 
on a chessboard such that no two queens can attack each other (i.e., no two queens 
are on the same row, same column, or same diagonal). There are many possible 
solutions. Write a program that displays one such solution. A sample output is 
shown below:
|Q| | | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | |Q| | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | |Q| | | | |
**7.23 (Game: locker puzzle) A school has 100 lockers and 100 students. All lockers are 
closed on the first day of school. As the students enter, the first student, denoted 
S1, opens every locker. Then the second student, S2, begins with the second 
locker, denoted L2, and closes every other locker. Student S3 begins with the 
third locker and changes every third locker (closes it if it was open, and opens it if 
it was closed). Student S4 begins with locker L4 and changes every fourth locker. 
Student S5 starts with L5 and changes every fifth locker, and so on, until student 
S100 changes L100.
After all the students have passed through the building and changed the lockers, 
which lockers are open? Write a program to find your answer and display all 
open locker numbers separated by exactly one space.
(Hint: Use an array of 100 Boolean elements, each of which indicates whether a 
locker is open (true) or closed (false). Initially, all lockers are closed.)
**7.24 (Simulation: coupon collector’s problem) Coupon collector is a classic statistics 
problem with many practical applications. The problem is to pick objects from 
a set of objects repeatedly and find out how many picks are needed for all the 
Enter the number of balls to drop: 5
Enter the number of slots in the bean machine: 8
LRLRLRR
RRLLLRR
LLRLLRR
RRLLLLL
LRLRRLR
    O
    O
  OOO
RLRRLRR. Display the final buildup of the balls in the slots in a histogram. Here 
is a sample run of the program:
VideoNote
Coupon collector’s problem
Programming Exercises  281
```

</details>


## PDF page 305

<details>
<summary>Page text</summary>

```text
282 Chapter 7  Single-Dimensional Arrays
objects to be picked at least once. A variation of the problem is to pick cards from 
a shuffled deck of 52 cards repeatedly and find out how many picks are needed 
before you see one of each suit. Assume a picked card is placed back in the deck 
before picking another. Write a program to simulate the number of picks needed 
to get four cards from each suit and display the four cards picked (it is possible a 
card may be picked twice). Here is a sample run of the program: 
Queen of Spades
5 of Clubs
Queen of Hearts
4 of Diamonds
Number of picks: 12
Enter list1: 5 2 5 6 1 6
Enter list2: 5 2 5 6 1 6
Two lists are strictly identical
Enter list1: 5 2 5 6 6 1
Enter list2: 5 2 5 6 1 6
Two lists are not strictly identical
7.25 (Algebra: solve quadratic equations ) Write a method for solving a quadratic 
equation using the following header:
public static int solveQuadratic(double[] eqn, double[] roots)
The coefficients of a quadratic equation ax2 + bx + c = 0 are passed to the 
array eqn and the real roots are stored in roots. The method returns the num-
ber of real roots. See Programming Exercise 3.1 on how to solve a quadratic 
equation.
Write a program that prompts the user to enter values for a, b, and c and displays 
the number of real roots and all real roots.
7.26 (Strictly identical arrays ) The arrays list1 and list2 are strictly identical
if their corresponding elements are equal. Write a method that returns true if 
list1 and list2 are strictly identical, using the following header:
public static boolean equals(int[] list1, int[] list2)
Write a test program that prompts the user to enter two lists of integers and dis-
plays whether the two are strictly identical. Here are the sample runs. Note that 
the first number in the input indicates the number of the elements in the list. This 
number is not part of the list.
7.27 (Identical arrays) The arrays list1 and list2 are identical if they have the 
same contents. Write a method that returns true if list1 and list2 are identi-
cal, using the following header:
public static boolean equals(int[] list1, int[] list2)
```

</details>


## PDF page 306

<details>
<summary>Page text</summary>

```text
Write a test program that prompts the user to enter two lists of integers and dis-
plays whether the two are identical. Here are the sample runs. Note that the first 
number in the input indicates the number of the elements in the list. This number 
is not part of the list.
Enter list1: 5 2 5 6 6 1
Enter list2: 5 5 2 6 1 6
Two lists are identical
Enter list1: 5 5 5 6 6 1
Enter list2: 5 2 5 6 1 6
Two lists are not identical
*7.28 (Math: combinations) Write a program that prompts the user to enter 10 integers 
and displays all combinations of picking two numbers from the 10.
*7.29 (Game: pick four cards) Write a program that picks four cards from a deck of 52 
cards and computes their sum. An Ace, King, Queen, and Jack represent 1, 13, 
12, and 11, respectively. Your program should display the number of picks that 
yields the sum of 24.
*7.30 (Pattern recognition: consecutive four equal numbers ) Write the following 
method that tests whether the array has four consecutive numbers with the same 
value. 
public static boolean isConsecutiveFour(int[] values)
Write a test program that prompts the user to enter a series of integers and dis-
plays if the series contains four consecutive numbers with the same value. Your 
program should first prompt the user to enter the input size—i.e., the number of 
values in the series. Here are sample runs:
VideoNote
Consecutive four
Enter the number of values: 8
Enter the values: 3 4 5 5 5 5 4 5
The list has consecutive fours 
Enter the number of values: 9
Enter the values: 3 4 5 5 6 5 5 4 5
The list has no consecutive fours 
**7.31 (Merge two sorted lists) Write the following method that merges two sorted lists 
into a new sorted list.
public static int[] merge(int[] list1, int[] list2)
Programming Exercises  283
```

</details>


## PDF page 307

<details>
<summary>Page text</summary>

```text
284 Chapter 7  Single-Dimensional Arrays
Implement the method in a way that takes at most list1.length + list2.
length comparisons. Write a test program that prompts the user to enter two 
sorted lists and displays the merged list. Here is a sample run. Note that the first 
number in the input indicates the number of the elements in the list. This number 
is not part of the list.
Enter list1: 5 1 5 16 61 111
Enter list2: 4 2 4 5 6
The merged list is 1 2 4 5 5 6 16 61 111
Enter list: 8 10 1 5 16 61 9 11 1
After the partition, the list is 9 1 5 1 10 61 11 16
**7.32 (Partition of a list) Write the following method that partitions the list using the 
first element, called a pivot.
public static int partition(int[] list)
After the partition, the elements in the list are rearranged so that all the elements 
before the pivot are less than or equal to the pivot and the elements after the pivot 
are greater than the pivot. The method returns the index where the pivot is located 
in the new list. For example, suppose the list is { 5 ,2 ,9 ,3 ,6 ,8 } . After the parti-
tion, the list becomes {3, 2, 5, 9, 6, 8}. Implement the method in a way that takes 
at most list.length comparisons. Write a test program that prompts the user 
to enter a list and displays the list after the partition. Here is a sample run. Note 
that the first number in the input indicates the number of the elements in the list. 
This number is not part of the list.
*7.33 (Culture: Chinese Zodiac) Simplify Listing 3.9 using an array of strings to store 
the animal names.
**7.34 (Sort characters in a string) Write a method that returns a sorted string using the 
following header:
public static String sort(String s)
For example, sort("acb") returns abc.
Write a test program that prompts the user to enter a string and displays the sorted 
string.
***7.35 (Game: hangman) Write a hangman game that randomly generates a word and 
prompts the user to guess one letter at a time, as shown in the sample run. Each 
letter in the word is displayed as an asterisk. When the user makes a correct 
guess, the actual letter is then displayed. When the user finishes a word, display
```

</details>


## PDF page 308

<details>
<summary>Page text</summary>

```text
the number of misses and ask the user whether to continue to play with another 
word. Declare an array to store words, as follows:
// Add any words you wish in this array
String[] words = {"write", "that", ...};
(Guess) Enter a letter in word ******* > p 
(Guess) Enter a letter in word p****** > r 
(Guess) Enter a letter in word pr**r** > p 
     p is already in the word
(Guess) Enter a letter in word pr**r** > o 
(Guess) Enter a letter in word pro*r** > g 
(Guess) Enter a letter in word progr** > n 
     n is not in the word
(Guess) Enter a letter in word progr** > m 
(Guess) Enter a letter in word progr*m > a 
The word is program. You missed 1 time
Do you want to guess another word? Enter y or n>
Programming Exercises  285
```

</details>


## PDF page 309

<details>
<summary>Page text</summary>

```text
This page intentionally left blank
```

</details>
