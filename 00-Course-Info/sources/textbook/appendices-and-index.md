# Appendices and index

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1286

<details>
<summary>Page text</summary>

```text
1263
APPENDIXES
Appendix A
Java Keywords
Appendix B
The ASCII Character Set
Appendix C
Operator Precedence Chart
Appendix D
Java Modifiers
Appendix E
Special Floating-Point Values
Appendix F
Number Systems
Appendix G
Bitwise Operations
Appendix H
Regular Expressions
Appendix I
Enumerated Types
```

</details>


## PDF page 1287

<details>
<summary>Page text</summary>

```text
This page intentionally left blank
```

</details>


## PDF page 1288

<details>
<summary>Page text</summary>

```text
1265
Java Keywords
The following fifty keywords are reserved for use by the Java language:
APPENDIXA
abstract
assert
boolean
break
byte
case
catch
char
class
const
continue
default
do
double
else
enum
extends
final
finally
float
for
goto
if
implements
import
instanceof
int
interface
long
native
new
package
private
protected
public
return
short
static
strictfp*
super
switch
synchronized
this
throw
throws
transient
try
void
volatile
while
The keywords goto and const are C++ keywords reserved, but not currently used in Java. 
This enables Java compilers to identify them and to produce better error messages if they 
appear in Java programs.
The literal values true, false, and null are not keywords, just like literal value 100.
However, you cannot use them as identifiers, just as you cannot use 100 as an identifier.
In the code listing, we use the keyword color for true,false, and null to be consistent 
with their coloring in Java IDEs.
*Thestrictfp keyword is a modifier for a method or class that enables it to use strict floating-point calcu-
lations. Floating-point arithmetic can be executed in one of two modes: strict or nonstrict. The strict mode 
guarantees that the evaluation result is the same on all Java Virtual Machine implementations. The nonstrict 
mode allows intermediate results from calculations to be stored in an extended format different from the 
standard IEEE floating-point number format. The extended format is machine-dependent and enables code 
to be executed faster. However, when you execute the code using the nonstrict mode on different JVMs, you 
may not always get precisely the same results. By default, the nonstrict mode is used for floating-point calcu-
lations. To use the strict mode in a method or a class, add the strictfp keyword in the method or the class 
declaration. Strict floating-point may give you slightly better precision than nonstrict floating-point, but the 
distinction will only affect some applications. Strictness is not inherited; that is, the presence of strictfp on 
a class or interface declaration does not cause extended classes or interfaces to be strict.
```

</details>


## PDF page 1289

<details>
<summary>Page text</summary>

```text
1266
APPENDIXB
The ASCII Character Set
Tables B.1 and B.2 show ASCII characters and their respective decimal and hexadecimal 
codes. The decimal or hexadecimal code of a character is a combination of its row index and 
column index. For example, in Table B.1, the letter A is at row 6 and column 5, so its decimal 
equivalent is 65; in Table B.2, letter A is at row 4 and column 1, so its hexadecimal equivalent 
is 41.
```

</details>


## PDF page 1290

<details>
<summary>Page text</summary>

```text
1267
TABLE B.1  ASCII Character Set in the Decimal Index
0123456789
0 nul soh stx etx eot enq ack bel bs ht
1 nl vt ff cr so si dle dcl dc2 dc3
2 dc4 nak syn etb can em sub esc fs gs
3r s u s s p ! ”#$% & ’
4 ()* + , - ./0 1
523456789: ;
6 6 = 7 ? @ ABCDE
7 F GHI J KLM NO
8 P QRS TUVW XY
9Z[ \ ] ¿ - ’ab c
1 0 d e fg h ijk lm
1 1 nopqr st uvw
1 2 xyz { /H20841 } ∼ del
TABLE B.2  ASCII Character Set in the Hexadecimal Index
0123456789ABC D EF
0 nul soh stx etx eot enq ack bel bs ht nl vt ff cr so si
1 dle dcl dc2 dc3 dc4 nak syn etb can em sub esc fs gs rs us
2 s p !”# $ % & ’()* + , - ./
30123456789: ; 6 = 7 ?
4 @ ABCDEF GHI J KLM NO
5 P QRS TUVW XYZ[ \ ] ¿ -
6’abcdefghi j kl m no
7pqr st uvw xyz { /H20841 } ∼ del
```

</details>


## PDF page 1291

<details>
<summary>Page text</summary>

```text
1268
APPENDIXC
Operator Precedence Chart
The operators are shown in decreasing order of precedence from top to bottom. Operators in 
the same group have the same precedence, and their associativity is shown in the table.
Operator Name Associativity
() Parentheses Left to right
() Function call Left to right
[] Array subscript Left to right
. Object member access Left to right
++ Postincrement Left to right
–– Postdecrement Left to right
++ Preincrement Right to left
–– Predecrement Right to left
+ Unary plus Right to left
– Unary minus Right to left
! Unary logical negation Right to left
(type) Unary casting Right to left
new Creating object Right to left
* Multiplication Left to right
/ Division Left to right
% Remainder Left to right
+ Addition Left to right
– Subtraction Left to right
<< Left shift Left to right
>> Right shift with sign extension Left to right
>>> Right shift with zero extension Left to right
< Less than Left to right
<= Less than or equal to Left to right
> Greater than Left to right
>= Greater than or equal to Left to right
instanceof Checking object type Left to right
```

</details>


## PDF page 1292

<details>
<summary>Page text</summary>

```text
Appendix C 1269
Operator Name Associativity
== Equal comparison Left to right
!= Not equal Left to right
& (Unconditional AND) Left to right
^ (Exclusive OR) Left to right
| (Unconditional OR) Left to right
&& Conditional AND Left to right
|| Conditional OR Left to right
?: Ternary condition Right to left
= Assignment Right to left
+= Addition assignment Right to left
–= Subtraction assignment Right to left
*= Multiplication assignment Right to left
/= Division assignment Right to left
%= Remainder assignment Right to left
```

</details>


## PDF page 1293

<details>
<summary>Page text</summary>

```text
1270
APPENDIXD
Java Modifiers
Modifiers are used on classes and class members (constructors, methods, data, and class-level 
blocks), but the final modifier can also be used on local variables in a method. A modifier 
that can be applied to a class is called a class modifier. A modifier that can be applied to a 
method is called a method modifier. A modifier that can be applied to a data field is called a 
data modifier. A modifier that can be applied to a class-level block is called a block modifier.
The following table gives a summary of the Java modifiers.
Modifier Class Constructor Method Data Block Explanation
(default)* UU U U U A class, constructor, method, 
or data field is  visible in this 
package.
public UU U U A class, constructor, method, 
or data field is  visible to all the 
programs  in any package.
private UU U A constructor, method, or data 
field is only visible in this class.
protected UU U A constructor, method, or data 
field is visible in this package 
and in subclasses of this class in 
any package.
static UU U Define a class method, a  class 
data field, or a static  initializa-
tion block.
final UU U A final class cannot be 
extended. A final method cannot 
be modified in a subclass. 
A final data field  is a constant.
abstract UU An abstract class must be 
extended. An abstract method 
must be implemented in a con-
crete subclass.
native U A native method indicates  that 
the method is  implemented 
using a language other than 
Java.
*Default access doesn’t have a modifier associated with it. For example: class Test {}
```

</details>


## PDF page 1294

<details>
<summary>Page text</summary>

```text
Appendix D 1271
The modifiers default (no modifier), public, private, and protected are known as 
visibility or accessibility modifiers because they specify how classes and class members are 
accessed.
The modifiers public,private,protected,static,final, and abstract can also 
be applied to inner classes.
Modifier Class Constructor Method Data Block Explanation
synchronized UU Only one thread at a time can 
execute this method.
strictfp UU Use strict floating-point
calculations to guarantee that 
the evaluation result is the 
same on all JVMs.
transient U Mark a nonserializable 
instance data field.
```

</details>


## PDF page 1295

<details>
<summary>Page text</summary>

```text
1272
APPENDIXE
Special Floating-Point Values
Dividing an integer by zero is invalid and throws ArithmeticException, but dividing a 
floating-point value by zero does not cause an exception. Floating-point arithmetic can over-
flow to infinity if the result of the operation is too large for a double or a float, or under-
flow to zero if the result is too small for a double or a float. Java provides the special 
floating-point values POSITIVE_INFINITY, NEGATIVE_INFINITY, and NaN (Not a Num-
ber) to denote these results. These values are defined as special constants in the Float class 
and the Double class.
If a positive floating-point number is divided by zero, the result is POSITIVE_INFINITY.
If a negative floating-point number is divided by zero, the result is NEGATIVE_INFINITY.
If a floating-point zero is divided by zero, the result is NaN, which means that the result is 
undefined mathematically. The string representations of these three values are Infinity,
-Infinity, and NaN. For example,
System.out.print(1.0 / 0); // Print Infinity
System.out.print(–1.0 / 0); // Print –Infinity
System.out.print(0.0 / 0); // Print NaN
These special values can also be used as operands in computations. For example, a number 
divided by POSITIVE_INFINITY yields a positive zero. Table E.1 summarizes various com-
binations of the /, *, %, +, and – operators.
TABLE E.1  Special Floating-Point Values
x y x/y x*y x%y x + yx - y
Finite { 0.0 { infinity { 0.0 NaN Finite Finite
Finite { infinity { 0.0 { 0.0 x { infinity infinity
{ 0.0 { 0.0 NaN { 0.0 NaN { 0.0 { 0.0
{ infinity Finite { infinity { 0.0 NaN { infinity { infinity
{ infinity { infinity NaN { 0.0 NaN { infinity infinity
{ 0.0 { infinity { 0.0 NaN {  0.0 { infinity { 0.0
NaN Any NaN NaN NaN NaN NaN
Any NaN NaN NaN NaN NaN NaN
Note
If one of the operands is NaN, the result is NaN.
```

</details>


## PDF page 1296

<details>
<summary>Page text</summary>

```text
1273
Number Systems
F.1 Introduction
Computers use binary numbers internally, because computers are made naturally to store and 
process 0s and 1s. The binary number system has two digits, 0 and 1. A number or character 
is stored as a sequence of 0s and 1s. Each 0 or 1 is called a bit (binary digit).
In our daily life we use decimal numbers. When we write a number such as 20 in a pro-
gram, it is assumed to be a decimal number. Internally, computer software is used to convert 
decimal numbers into binary numbers, and vice versa.
We write computer programs using decimal numbers. However, to deal with an operating 
system, we need to reach down to the “machine level” by using binary numbers. Binary num-
bers tend to be very long and cumbersome. Often hexadecimal numbers are used to abbreviate 
them, with each hexadecimal digit representing four binary digits. The hexadecimal number 
system has 16 digits: 0–9 and A–F. The letters A, B, C, D, E, and F correspond to the decimal 
numbers 10, 11, 12, 13, 14, and 15.
The digits in the decimal number system are 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9. A decimal 
number is represented by a sequence of one or more of these digits. The value that each digit 
represents depends on its position, which denotes an integral power of 10. For example, the 
digits 7, 4, 2, and 3 in decimal number 7423 represent 7000, 400, 20, and 3, respectively, as 
shown below:
/H20841 7 /H20841 4 /H20841 2 /H20841 3 /H20841 = 7 * 103 + 4 * 102 + 2 * 101 + 3 * 100
103 102 101 100 = 7000 + 400 + 20 + 3 = 7423
The decimal number system has ten digits, and the position values are integral powers of 10. 
We say that 10 is the base or radix of the decimal number system. Similarly, since the binary 
number system has two digits, its base is 2, and since the hex number system has 16 digits, 
its base is 16.
If 1101 is a binary number, the digits 1, 1, 0, and 1 represent 1 * 23,1 * 22,0 * 21, and 
1 * 20, respectively:
/H20841 1 /H20841 1 /H20841 0 /H20841 1 /H20841 = 1 * 23 + 1 * 22 + 0 * 21 + 1 * 20
23 22 21 20 = 8 + 4 + 0 + 1 = 13
If 7423 is a hex number, the digits 7, 4, 2, and 3 represent 7 * 163,4 * 162,2 * 161, and 
3 * 160, respectively:
/H20841 7 /H20841 4 /H20841 2 /H20841 3 /H20841 = 7 * 163 + 4 * 162 + 2 * 161 + 3 * 160
163 162 161 160 = 28672 + 1024 + 32 + 3 = 29731
binary numbers
decimal numbers
hexadecimal number
radix
base
APPENDIXF
```

</details>


## PDF page 1297

<details>
<summary>Page text</summary>

```text
1274 Appendix F
F.2 Conversions Between Binary and Decimal Numbers
Given a binary number bnbn - 1bn - 2 c b2b1b0, the equivalent decimal value is
bn * 2n + bn - 1 * 2n - 1 + bn - 2 * 2n - 2 + c + b2 * 22 + b1 * 21 + b0 * 20
Here are some examples of converting binary numbers to decimals:
binary to decimal
Binary Conversion Formula Decimal
10 1 * 21 + 0 * 20  2
1000 1 * 23 + 0 * 22 + 0 * 21 + 0 * 20  8
10101011 1 * 27 + 0 * 26 + 1 * 25 + 0 * 24 + 1 * 23 + 0 * 22 +
1 * 21 + 1 * 20
171
To convert a decimal number d to a binary number is to find the bits bn, bn—1, bn—2, . . . , b2, b1
and b0 such that
d = bn * 2n + bn - 1 * 2n - 1 + bn - 2 * 2n - 2 + c + b2 * 22 + b1 * 21 + b0 * 20
These bits can be found by successively dividing d by 2 until the quotient is 0. The remainders 
are b0, b1, b2, c , bn - 2, bn - 1, and bn.
For example, the decimal number 123 is 1111011 in binary. The conversion is done as follows:
21
0
1
b6
0
23
2
1
27
6
b4
1
3
b5
1
2
Quotient
Remainder
15
14
b3
1
7
2
30
b2
0
15
2
60
61
b1
1
30
b0
2
122
1
61
12330
Tip
The Windows Calculator, as shown in Figure F.1, is a useful tool for performing number 
conversions. To run it, search for Calculator from the Start button and launch Calcula-
tor, then under View select Scientific.
decimal to binary
BinaryDecimal
Hex
FIGURE F.1  You can perform number conversions using the Windows Calculator.
```

</details>


## PDF page 1298

<details>
<summary>Page text</summary>

```text
Appendix F 1275
F.3 Conversions Between Hexadecimal and Decimal 
Numbers
Given a hexadecimal number hnhn - 1hn - 2 c h2h1h0, the equivalent decimal value is
hn * 16n + hn - 1 * 16n - 1 + hn - 2 * 16n - 2 + c + h2 * 162 + h1 * 161 + h0 * 160
Here are some examples of converting hexadecimal numbers to decimals:
hex to decimal
Hexadecimal Conversion Formula Decimal
7F 7 * 161 + 15 * 160  127
FFFF 15 * 163 + 15 * 162 + 15 * 161 + 15 * 160 65535
431 4 * 162 + 3 * 161 + 1 * 160  1073
To convert a decimal number d to a hexadecimal number is to find the hexadecimal digits 
hn, hn - 1, hn - 2, c , h2, h1, and h0 such that
d = hn * 16n + hn - 1 * 16n - 1 + hn - 2 * 16n - 2 + c + h2 * 162
+ h1 * 161 + h0 * 160
These numbers can be found by successively dividing d by 16 until the quotient is 0. The 
remainders are h0, h1, h2, c , hn - 2, hn - 1, and hn.
For example, the decimal number 123 is 7B in hexadecimal. The conversion is done as 
follows:
Quotient
Remainder
16 7
0
7
h1
0
16 123
112
11
h0
7
F.4 Conversions Between Binary and Hexadecimal 
Numbers
To convert a hexadecimal to a binary number, simply convert each digit in the hexadecimal 
number into a four-digit binary number, using Table F.1. 
For example, the hexadecimal number 7B is 1111011, where 7 is 111 in binary, and B is 
1011 in binary.
To convert a binary number to a hexadecimal, convert every four binary digits from right 
to left in the binary number into a hexadecimal number. 
For example, the binary number 1110001101 is 38D, since 1101 is D, 1000 is 8, and 11 is 
3, as shown below.
1 110001101
D83
decimal to hex
hex to binary
binary to hex
```

</details>


## PDF page 1299

<details>
<summary>Page text</summary>

```text
1276 Appendix F
Note
Octal numbers are also useful. The octal number system has eight digits, 0 to 7. A deci-
mal number 8 is represented in the octal system as 10.
Here are some good online resources for practicing number conversions:
 ■ http://forums.cisco.com/CertCom/game/binary_game_page.htm
 ■ http://people.sinclair.edu/nickreeder/Flash/binDec.htm
 ■ http://people.sinclair.edu/nickreeder/Flash/binHex.htm
F.1 Convert the following decimal numbers into hexadecimal and binary numbers:
100; 4340; 2000
F.2 Convert the following binary numbers into hexadecimal and decimal numbers:
1000011001; 100000000; 100111
F.3 Convert the following hexadecimal numbers into binary and decimal numbers:
FEFA9; 93; 2000
✓Point✓
Check
TABLE F.1  Converting Hexadecimal to Binary
Hexadecimal Binary Decimal
0 0000 0
1 0001 1
2 0010 2
3 0011 3
4 0100 4
5 0101 5
6 0110 6
7 0111 7
8 1000 8
9 1001 9
A 1010 10
B 1011 11
C 1100 12
D 1101 13
E 1110 14
F 1111 15
```

</details>


## PDF page 1300

<details>
<summary>Page text</summary>

```text
1277
Bitwise Operations
To write programs at the machine-level, often you need to deal with binary numbers directly 
and perform operations at the bit-level. Java provides the bitwise operators and shift operators 
defined in Table G.1.
The bit operators apply only to integer types (byte,short,int, and long). A character 
involved in a bit operation is converted to an integer. All bitwise operators can form bitwise 
assignment operators, such as =,|=,<<=,>>=, and >>>=.
APPENDIXG
TABLE G.1  
Operator Name
Example
(using bytes in the example) Description
& Bitwise AND 10101110& 10010010 
yields 10000010
The AND of two corresponding 
bits yields a 1 if both bits are 1.
| Bitwise
inclusive OR
10101110| 10010010 
yields 10111110
The OR of two corresponding  bits 
yields a 1 if either bit is 1.
^ Bitwise
exclusive OR
10101110^ 10010010
yields 00111100
The XOR of two corresponding
bits yields a 1 only if two bits are
different.
~ One’s
complement
~10101110 yields 
01010001
The operator toggles each bit  from 
0 to 1 and from 1 to 0.
<< Left shift 10101110<< 2 yields
10111000
The operator shifts bits in the  first 
operand left by the number  of bits 
specified in the second  operand, 
filling with 0s on the right.
>> Right shift
with sign
extension
10101110>> 2 yields
11101011
00101110>> 2 yields
00001011
The operator shifts bit in the first
operand right by the number of bits  
specified in the second operand,
filling with the highest (sign) bit
on the left.
>>> Unsigned right 
shift with zero 
extension
10101110>>> 2 yields 
00101011
00101110>>> 2 yields 
00001011
The operator shifts bit in the first
operand right by the number of bits  
specified in the second operand,
filling with 0s on the left.
```

</details>


## PDF page 1301

<details>
<summary>Page text</summary>

```text
1278
APPENDIXH
Regular Expressions
Often you need to write the code to validate user input such as to check whether the input is 
a number, a string with all lowercase letters, or a social security number. How do you write 
this type of code? A simple and effective way to accomplish this task is to use the regular 
expression.
A regular expression (abbreviated regex) is a string that describes a pattern for matching 
a set of strings. Regular expression is a powerful tool for string manipulations. You can use 
regular expressions for matching, replacing, and splitting strings. 
H.1 Matching Strings
Let us begin with the matches method in the String class. At first glance, the matches
method is very similar to the equals method. For example, the following two statements 
both evaluate to true.
"Java".matches("Java");
"Java".equals("Java");
However, the matches method is more powerful. It can match not only a fixed string, but 
also a set of strings that follow a pattern. For example, the following statements all evaluate 
totrue.
"Java is fun".matches("Java.*")
"Java is cool".matches("Java.*")
"Java is powerful".matches("Java.*")
"Java.*" in the preceding statements is a regular expression. It describes a string pattern 
that begins with Java followed by any zero or more characters. Here, the substring .* matches 
any zero or more characters.
H.2 Regular Expression Syntax
A regular expression consists of literal characters and special symbols. Table H.1 lists some 
frequently used syntax for regular expressions.
Note
Backslash is a special character that starts an escape sequence in a string. So you need 
to use \\d in Java to represent \d.
Note
Recall that a whitespace character is ' ','\t','\n','\r', or '\f'. So \s is the 
same as [ \t\n\r\f], and \S is the same as [^ \t\n\r\f].
regular expression
matches
```

</details>


## PDF page 1302

<details>
<summary>Page text</summary>

```text
Appendix H 1279
TABLE H.1  Frequently Used Regular Expressions
Regular Expression Matches Example
x a specified character x Java  matches Java
. any single character Java matches J..a
(ab|cd) ab or cd ten matches t(en|im)
[abc] a, b, or c Java matches Ja[uvwx]a
[^abc] any character except 
a, b, or c
Java matches Ja[^ars]a
[a-z] a through z Java matches [A-M]av[a-d]
[^a-z] any character except 
a through z
Java matches Jav[^b-d]
[a-e[m-p]] a through e or 
m through p
Java matches[A-G[I-M]]av[a-d]
[a-e&&[c-p]] intersection of a-e 
with c-p
Java matches[A-P&&[I-M]]av[a-d]
\d a digit, same as [0-9] Java2 matches "Java[\\d]"
\D a non-digit $Java matches "[\\D][\\D]ava"
\w a word character Java1 matches "[\\w]ava[\\w]"
\W a non-word character $Java matches "[\\W][\\w]ava"
\s a whitespace character "Java 2" matches "Java\\s2"
\S a non-whitespace char Javamatches"[\\S]ava"
p* zero or more 
occurrences of pattern p
aaaabb matches "a*bb"
ababab matches "(ab)*"
p+ one or more occurrences 
of pattern p
a matches "a+b*"
able matches "(ab)+.*"
p? zero or one occurrence of 
pattern p
Java matches "J?Java"
Java matches "J?ava"
p{n} exactly n occurrences of 
pattern p
Java matches "Ja{1}.*"
Java does not match ".{2}"
p{n,} at least n occurrences of 
pattern p
aaaa matches "a{1,}"
a does not match "a{2,}"
p{n,m} between n and m occur-
rences (inclusive)
aaaa matches "a{1,9}"
abb does not match "a{2,9}bb"
Note
A word character is any letter, digit, or the underscore character. So \w is the same 
as [a-z[A-Z][0-9]_] or simply [a-zA-Z0-9_], and \W is the same as 
[^a-zA-Z0-9_].
Note
The last six entries *,+,?,{n},{n,}, and {n, m} in Table H.1 are called quantifiers
that specify how many times the pattern before a quantifier may repeat. For example, A*
matches zero or more A’s,A+ matches one or more A’s,A? matches zero or one A’s,A{3}
matches exactly AAA,A{3,} matches at least three A’s, and A{3,6} matches between 
3 and 6 A’s.* is the same as {0,},+ is the same as {1,}, and ? is the same as {0,1}.
quantifier
```

</details>


## PDF page 1303

<details>
<summary>Page text</summary>

```text
1280 Appendix H
Caution
Do not use spaces in the repeat quantifiers. For example, A{3,6} cannot be written as 
A{3, 6} with a space after the comma.
Note
You may use parentheses to group patterns. For example, (ab){3} matches ababab,
butab{3} matches abbb.
Let us use several examples to demonstrate how to construct regular expressions.
Example 1 
The pattern for social security numbers is xxx-xx-xxxx, where x is a digit. A regular 
expression for social security numbers can be described as
[\\d]{3}-[\\d]{2}-[\\d]{4}
For example,
"111-22-3333".matches("[\\d]{3}-[\\d]{2}-[\\d]{4}") returns true.
"11-22-3333".matches("[\\d]{3}-[\\d]{2}-[\\d]{4}") returns false.
Example 2
An even number ends with digits 0,2,4,6, or 8. The pattern for even numbers can be 
described as 
[\\d]*[02468]
For example,
"123".matches("[\\d]*[02468]") returns false.
"122".matches("[\\d]*[02468]") returns true.
Example 3
The pattern for telephone numbers is (xxx) xxx-xxxx, where x is a digit and the first 
digit cannot be zero. A regular expression for telephone numbers can be described as
\\([1-9][\\d]{2}\\) [\\d]{3}-[\\d]{4}
Note that the parentheses symbols ( and ) are special characters in a regular expression for 
grouping patterns. To represent a literal ( or ) in a regular expression, you have to use \\(
and\\).
For example,
"(912) 921-2728".matches("\\([1-9][\\d]{2}\\) [\\d]{3}-[\\d]{4}")
returns true.
"921-2728".matches("\\([1-9][\\d]{2}\\) [\\d]{3}-[\\d]{4}")
returns false.
Example 4
Suppose the last name consists of at most 25 letters and the first letter is in uppercase. The 
pattern for a last name can be described as
[A-Z][a-zA-Z]{1,24}
Note that you cannot have arbitrary whitespace in a regular expression. For example, [A-Z]
[a-zA-Z]{1, 24} would be wrong.
```

</details>


## PDF page 1304

<details>
<summary>Page text</summary>

```text
Appendix H 1281
For example,
"Smith".matches("[A-Z][a-zA-Z]{1,24}") returns true.
"Jones123".matches("[A-Z][a-zA-Z]{1,24}") returns false.
Example 5
Java identifiers are defined in Section 2.4, “Identifiers.” 
 ■ An identifier must start with a letter, an underscore (_), or a dollar sign ($). It cannot 
start with a digit.
 ■ An identifier is a sequence of characters that consists of letters, digits, underscores 
(_), and dollar signs ($).
The pattern for identifiers can be described as
[a-zA-Z_$][\\w$]*
Example 6
What strings are matched by the regular expression "Welcome to (Java|HTML)"? The 
answer is Welcome to Java or Welcome to HTML.
Example 7
What strings are matched by the regular expression "A.*"? The answer is any string that 
starts with letter A.
H.3 Replacing and Splitting Strings
The matches method in the String class returns true if the string matches the regular 
expression. The String class also contains the replaceAll, replaceFirst, and split
methods for replacing and splitting strings, as shown in Figure H.1.
FIGURE H.1 TheString class contains the methods for matching, replacing, and splitting strings using regular 
expressions.
java.lang.String
+matches(regex: String): boolean
+replaceAll(regex: String, replacement:
   String): String
+replaceFirst(regex: String,
   replacement: String): String
+split(regex: String): String[]
+split(regex: String, limit: int): String[]
Returns true if this string matches the pattern.
Returns a new string that replaces all matching substrings with
     the replacement.
Returns a new string that replaces the first matching substring
     with the replacement.
Returns an array of strings consisting of the substrings split by
     the matches.
Same as the preceding split method except that the limit
     parameter controls the number of times the pattern is applied.
ThereplaceAll method replaces all matching substring and the replaceFirst method 
replaces the first matching substring. For example, the following code 
System.out.println("Java Java Java".replaceAll("v\\w", "wi"));
displays
Jawi Jawi Jawi
```

</details>


## PDF page 1305

<details>
<summary>Page text</summary>

```text
1282 Appendix H
The following code 
System.out.println("Java Java Java".replaceFirst("v\\w", "wi"));
displays
Jawi Java Java
There are two overloaded split methods. The split(regex) method splits a string into 
substrings delimited by the matches. For example, the following statement
String[] tokens = "Java1HTML2Perl".split("\\d");
splits string "Java1HTML2Perl" into Java, HTML, and Perl and saved in tokens[0],
tokens[1], and tokens[2].
In the split(regex, limit) method, the limit parameter determines how many times 
the pattern is matched. If limit <= 0,split(regex, limit) is same as split(regex).
Iflimit > 0, the pattern is matched at most limit – 1 times. Here are some examples:
"Java1HTML2Perl".split("\\d", 0); splits into Java, HTML, Perl
"Java1HTML2Perl".split("\\d", 1); splits into Java1HTML2Perl
"Java1HTML2Perl".split("\\d", 2); splits into Java, HTML2Perl
"Java1HTML2Perl".split("\\d", 3); splits into Java, HTML, Perl
"Java1HTML2Perl".split("\\d", 4); splits into Java, HTML, Perl
"Java1HTML2Perl".split("\\d", 5); splits into Java, HTML, Perl
Note
By default, all the quantifiers are greedy. This means that they will match as many 
occurrences as possible. For example, the following statement displays JRvaa, since 
the first match is aaa.
System.out.println("Jaaavaa".replaceFirst("a+", "R"));
You can change a qualifier’s default behavior by appending a question mark (?) after it. 
The quantifier becomes reluctant, which means that it will match as few occurrences 
as possible. For example, the following statement displays JRaavaa, since the first 
match is a.
System.out.println("Jaaavaa".replaceFirst("a+?", "R"));
```

</details>


## PDF page 1306

<details>
<summary>Page text</summary>

```text
1283
Enumerated Types
I.1 Simple Enumerated Types
An enumerated type defines a list of enumerated values. Each value is an identifier. For exam-
ple, the following statement declares a type, named MyFavoriteColor, with values RED,
BLUE,GREEN, and YELLOW in this order.
enum MyFavoriteColor {RED, BLUE, GREEN, YELLOW};
A value of an enumerated type is like a constant and so, by convention, is spelled with all 
uppercase letters. So, the preceding declaration uses RED, not red. By convention, an enumer-
ated type is named like a class with first letter of each word capitalized.
Once a type is defined, you can declare a variable of that type:
MyFavoriteColor color;
The variable color can hold one of the values defined in the enumerated type 
MyFavoriteColor or null, but nothing else. Java enumerated type is type-safe, meaning 
that an attempt to assign a value other than one of the enumerated values or null will result 
in a compile error. 
The enumerated values can be accessed using the syntax
EnumeratedTypeName.valueName
For example, the following statement assigns enumerated value BLUE to variable color:
color = MyFavoriteColor.BLUE;
Note that you have to use the enumerated type name as a qualifier to reference a value such 
asBLUE.
As with any other type, you can declare and initialize a variable in one statement:
MyFavoriteColor color = MyFavoriteColor.BLUE;
An enumerated type is treated as a special class. An enumerated type variable is therefore a 
reference variable. An enumerated type is a subtype of the Object class and the Comparable
interface. Therefore, an enumerated type inherits all the methods in the Object class and the 
compraeTo method in the Comparable interface. Additionally, you can use the following 
methods on an enumerated object:
 ■ public String name();
Returns a name of the value for the object.
 ■ public int ordinal();
Returns the ordinal value associated with the enumerated value. The first value in 
an enumerated type has an ordinal value of 0, the second has an ordinal value of 1, 
the third one 3, and so on.
APPENDIXI
```

</details>


## PDF page 1307

<details>
<summary>Page text</summary>

```text
1284 Appendix I
Listing I.1 gives a program that demonstrates the use of enumerated types.
LISTING I.1 EnumeratedTypeDemo.java
  1 public class EnumeratedTypeDemo {
  2 static enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY,
  3 FRIDAY, SATURDAY};
  4
  5 public static void main(String[] args) {
  6 Day day1 = Day.FRIDAY;
  7      Day day2 = Day.THURSDAY;
  8
  9      System.out.println("day1's name is " + day1.name());
 10      System.out.println("day2's name is " + day2.name());
 11      System.out.println("day1's ordinal is " + day1.ordinal());
 12      System.out.println("day2's ordinal is " + day2.ordinal());
 13
 14      System.out.println("day1.equals(day2) returns " + 
 15 day1.equals(day2));
 16      System.out.println("day1.toString() returns " + 
 17 day1.toString());
 18      System.out.println("day1.compareTo(day2) returns " + 
 19 day1.compareTo(day2));
 20    }
 21  }
define an enum type
declare an enum variable
get enum name
get enum ordinal
compare enum values
day1's name is FRIDAY
day2's name is THURSDAY
day1's ordinal is 5
day2's ordinal is 4
day1.equals(day2) returns false
day1.toString() returns FRIDAY
day1.compareTo(day2) returns 1
An enumerated type Day is defined in lines 2–3. Variables day1 and day2 are declared 
as the Day type and assigned enumerated values in lines 6–7. Since day1’s value is FRIDAY,
its ordinal value is 5 (line 11). Since day2’s value is THURSDAY, its ordinal value is 4 
(line 12). 
Since an enumerated type is a subclass of the Object class and the Comparable interface, 
you can invoke the methods equals,toString, and comareTo from an enumerated object 
reference variable (lines 14–19). day1.equals(day2) returns true if day1 and day2 have 
the same ordinal value. day1.compareTo(day2) returns the difference between day1’s
ordinal value to day2’s.
Alternatively, you can rewrite the code in Listing I.1 into Listing I.2.
LISTING I.2 StandaloneEnumTypeDemo.java
  1 public class StandaloneEnumTypeDemo {
  2 public static void main(String[] args) {
  3 Day day1 = Day.FRIDAY;
  4      Day day2 = Day.THURSDAY;
  5
  6      System.out.println("day1's name is " + day1.name());
  7      System.out.println("day2's name is " + day2.name());
  8      System.out.println("day1's ordinal is " + day1.ordinal());
```

</details>


## PDF page 1308

<details>
<summary>Page text</summary>

```text
Appendix I 1285
  9      System.out.println("day2's ordinal is " + day2.ordinal());
 10
 11      System.out.println("day1.equals(day2) returns " + 
 12 day1.equals(day2));
 13      System.out.println("day1.toString() returns " + 
 14 day1.toString());
 15      System.out.println("day1.compareTo(day2) returns " + 
 16 day1.compareTo(day2));
 17    }
 18  }
 19
 20 enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY,
 21 FRIDAY, SATURDAY}
An enumerated type can be defined inside a class, as shown in lines 2–3 in Listing I.1, or 
standalone as shown in lines 20–21 Listing I.2. In the former case, the type is treated as an 
inner class. After the program is compiled, a class named EnumeratedTypeDemo$Day.class 
is created. In the latter case, the type is treated as a standalone class. After the program is 
compiled, a class named Day.class is created.
Note
When an enumerated type is declared inside a class, the type must be declared as a 
member of the class and cannot be declared inside a method. Furthermore, the type is 
always static. For this reason, the static keyword in line 2 in Listing I.1 may be 
omitted. The visibility modifiers on inner class can be also be applied to enumerated 
types defined inside a class.
Tip
Using enumerated values (e.g., Day.MONDAY,Day.TUESDAY, and so on) rather than 
literal integer values (e.g., 0, 1, and so on) can make program easier to read and maintain.
I.2 Using if or switch Statements with an 
Enumerated Variable
An enumerated variable holds a value. Often your program needs to perform a specific action 
depending on the value. For example, if the value is Day.MONDAY, play soccer; if the value is 
Day.TUESDAY, take piano lesson, and so on. You can use an if statement or a switch state-
ment to test the value in the variable, as shown in (a) and (b)
if (day.equals(Day.MONDAY)) {
// process Monday
}
else if (day.equals(Day.TUESDAY)) {
// process Tuesday
}
else
  ...
switch (day) {
case MONDAY: 
// process Monday
break;
case TUESDAY: 
// process Tuesday
break;
  ...
}
Equivalent
(a) (b)
In the switch statement in (b), the case label is an unqualified enumerated value (e.g., 
MONDAY, but not Day.MONDAY).
```

</details>


## PDF page 1309

<details>
<summary>Page text</summary>

```text
1286 Appendix I
I.3 Processing Enumerated Values Using 
a Foreach Loop
Each enumerated type has a static method values() that returns all enumerated values for 
the type in an array. For example,
Day[] days = Day.values();
You can use a regular for loop in (a) or a foreach loop in (b) to process all the values in 
the array.
I.4 Enumerated Types with Data Fields, 
Constructors, and Methods
The simple enumerated types introduced in the preceding section define a type with a list of 
enumerated values. You can also define an enumerate type with data fields, constructors, and 
methods, as shown in Listing I.3.
LISTING I.3 TrafficLight.java
  1 public enum TrafficLight {
  2    RED ("Please stop"), GREEN ("Please go"),
  3    YELLOW ("Please caution");
  4
  5 private String description;
  6
  7 private TrafficLight(String description) {
  8 this.description = description;
  9    }
 10
 11 public String getDescription() {
 12 return description;
 13    }
 14  }
The enumerated values are defined in lines 2–3. The value declaration must be the first 
statement in the type declaration. A data field named description is declared in line 5 to 
describe an enumerated value. The constructor TrafficLight is declared in lines 7–9. The 
constructor is invoked whenever an enumerated value is accessed. The enumerated value’s 
argument is passed to the constructor, which is then assigned to description.
Listing I.4 gives a test program to use TrafficLight.
LISTING I.4 TestTrafficLight.java
  1 public class TestTrafficLight {
  2 public static void main(String[] args) {
  3      TrafficLight light = TrafficLight.RED;
  4      System.out.println(light.getDescription());
  5    }
  6  }
for (int i = 0; i < days.length; i++)
  System.out.println(days[i]);
for (Day day: days)
  System.out.println(day);
Equivalent
(a) (b)
```

</details>


## PDF page 1310

<details>
<summary>Page text</summary>

```text
Appendix I 1287
An enumerated value TrafficLight.red is assigned to variable light (line 3). Accessing 
TrafficLight.RED causes the JVM to invoke the constructor with argument “please stop”. 
The methods in enumerated type are invoked in the same way as the methods in a class. 
light.getDescription() returns the description for the enumerated value (line 4).
Note
The Java syntax requires that the constructor for enumerated types be private to prevent 
it from being invoked directly. The private modifier may be omitted. In this case, it is 
considered private by default.
```

</details>


## PDF page 1311

<details>
<summary>Page text</summary>

```text
This page intentionally left blank
```

</details>


## PDF page 1312

<details>
<summary>Page text</summary>

```text
1289
INDEX
Symbols
— (decrement operator), 55–56
- (subtraction operator), 46, 50–51
. (dot operator), 330
. (object member access operator), 330, 429
/ (division operator), 46, 50
//, in line comment syntax, 18
/*, in block comment syntax, 18
/**.*/ (Javadoc comment syntax), 18
/= (division assignment operator), 54–55
; (semicolons), common errors, 84
\ (backslash character), as directory separator, 474
\ (escape characters), 126
|| (or logical operator), 93–97
+ (addition operator), 46, 50
+ (string concatenation operator), 38, 131
++ (increment operator), 55–56
+= (addition assignment operator), augmented, 54–55
= (assignment operator), 41–43, 54–55
= (equals operator), 76
-= (subtraction assignment operator), 54–55
== (comparison operator), 76, 432
== (equal to operator), 76
! (not logical operator), 93–97
!= (not equal to comparison operator), 76
$ (dollar sign character), use in source code, 40
% (remainder or modulo operator), 46, 50
%= (remainder assignment operator), 54–55
&& (and logical operator), 93–97
( ) (parentheses), 14, 225
* (multiplication operator), 15, 46, 50
*= (multiplication assignment operator), 54–55
^ (exclusive or logical operator), 93–97
{} (curly braces), 13, 79, 83
< (less than comparison operator), 76
<= (less than or equal to comparison operator), 76
> (greater than comparison operator), 76
>= (greater than or equal to comparison operator), 76
Numbers
24-point game, 794–796
A
abs method, Math class, 121–122, 524
Absolute file name, 473
Abstract classes
AbstractCollection class, 762
AbstractGraph, 1025–1026
AbstractGraph.java example, 1028–1033
AbstractMap class, 812
AbstractSet class, 798
AbstractTree class, 935–936
case study: abstract number class, 501–503
case study: Calendar andGregorianCalendar classes, 503–506
characteristics of, 500–501
Circle.java andRectangle.java examples, 498
compared with interfaces, 517–520
GeometricObject.java example, 496–498
InputStream andOutputStream classes, 680–681
interfaces compared to, 506
key terms, 528–529
modeling graphs and, 1024
MyAbstractList.java example, 899
overview of, 366–367, 495–496
questions and exercises, 528–533
Rational.java example, 522–524
reasons for using abstract methods, 498
summary, 528–529
TestCalendar.java example, 504–505
TestGeometricObject.java example, 498–499
TestRationalClass.java example, 521–522
using as interface, 896
Abstract data type (ADT), 366
Abstract methods
characteristics of, 500
GenericMatrix.java example, 753–755
GeometricObject class, 497–498
implementing in subclasses, 496
in interfaces, 506
inNumber class, 524
overview of, 225–226
reasons for using, 498–499
abstract modifier, for denoting abstract methods, 496
Abstract number class
LargestNumbers.java, 502–503
overview of, 501–503
Abstract Windows Toolkit. see AWT (Abstract Windows Toolkit)
AbstractCollection class, 763
AbstractGraph class, 1062
AbstractGraph.java example, 1028–1033
Edge as inner class of, 1065
overview of, 1025–1026
WeightedGraph class extending, 1065–1066
AbstractMap class, 812
AbstractSet class, 798
AbstractTree class, 936–937
Access, Microsoft
JDBC drivers for accessing Oracle databases, 1189–1196
tutorials on, 1178
Accessor methods. see Getter (accessor) methods
acos method, trigonometry, 120–121
Actions (behaviors), object, 322
ActionEvent, 588–589
Activation records, invoking methods and, 208
Actual concrete types, 738
Actual parameters, defining methods and, 205
Ada, high-level languages, 8
add method
implementing linked lists, 906–907
List interface, 768
Addition (+) operator, 46, 50
Addition (+=) assignment operator, augmented assignment 
operators, 54–55
```

</details>


## PDF page 1313

<details>
<summary>Page text</summary>

```text
1290 Index
APIs (Application Program Interfaces)
Java API for accessing relational databases. see JDBC (Java Database 
Connectivity)
libraries as, 11
Application Program Interfaces (APIs), 11
Application-scoped bean, 1233
Apps, developing on Web servers, 11
Arc
overview, 567
ShowArc.java, 568–569
Arguments
defining methods and, 205
passing by values, 212–215
receiving string arguments from command line, 272–273
variable-length argument lists, 264–265
Arithmetic operators, in SQL, 1186
ArithmeticException class, 453
Arithmetic/logic units, CPU components, 3
Array elements, 248
Array initializers, 248–249
ArrayBlockingQueue class, 1122–1123
arraycopy method,System class, 256
ArrayIndexOutOfBoundsException, 251
ArrayList class
animation of array lists, 897
case study: custom stack class, 439
cloning arrays, 514
compared with LinkedList, 769–770
creating and adding numbers to array lists, 437–438
creating array lists and adding elements to, 764–767
defined under List interface, 767
DistinctNumbers.java example, 435–438
as example of generic class, 738–739
implementing array lists, 900–901
implementing bucket sorts, 881–882
implementing buckets, 993
implementing stacks using array lists. see Stacks
MyArrayList, 897
MyArrayList compared with MyLinkedList, 918–919
MyArrayList.java example, 901–904
representing edges in graphs, 1023–1024
SetListPerformanceTest.java example, 807–808
storing edge objects in, 1021
for storing elements in a list, 762
storing heaps in, 875
storing list of objects in, 432–433
TestArrayAndLinkedList.java, 770–771
TestArrayList.java example, 433–436
TestMyArrayList.java example, 905–906
Vector class compared with, 781
Arrays, in general
edge arrays, 1020–1021
as fixed-size data structure, 900
implementing binary heaps using, 875
ragged arrays, 1022
sorting using Heap class, 879
storing lists in. seeArrayList class
storing vertices in, 1020
Arrays, multi-dimensional
case study: daily temperature and humidity, 
302–303
case study: guessing birthdays, 304–305
overview of, 301–302
Adelson-Velsky, G. M., 966
Adjacency lists, representing edges, 1022–1024
Adjacency matrices
representing edges, 1021–1024
weighted, 1064
Adjacent edges, overview of, 1018
ADT (abstract data type), 366
Aggregating classes, 374
Aggregating objects, 374
Aggregation relationships, objects, 374–375
AIFF audio files, 662
Algorithms, 34
analyzing Towers of Hanoi problem, 828–829
Big O notation for measuring efficiency of, 822–825
binary search, 828
bubble sort, 864–866
comparing growth functions, 829–830
comparing prime numbers, 837
determining Big O for repetition, sequence, and selection statements, 
824–827
EfficientPrimeNumbers.java example, 839–842
external sorts. see External sorts
finding closest pair of points, 843–846
finding convex hull for a set of points, 849–851
finding Fibonacci numbers, 831–833
finding greatest common denominator, 833–834
finding prime numbers, 837
GCDEuclid.java example, 835–837
GCD.java example, 834–835
gift-wrapping algorithm, 849–850
Graham’s algorithm, 850–851
graph algorithms, 1017
greedy, 956
heap sort. see Heap sorts
key terms, 851
merge sort, 867–870
overview of, 821–822
PrimeNumbers.java example, 838–839
questions and exercises, 853–860
quick sort, 870–874
recurrence relations and, 829
selection sort and insertion sort, 828
SieveOfEratosthenes.java example, 842–843
solving Eight Queens problem, 846–849
forsort method, 745
summary, 851–852
Algorithms, spanning tree
Dijkstra’s single-source shortest-path algorithm, 1079–1084
MST algorithm, 1075–1076
Prim’s minimum spanning tree algorithm, 1073–1075
Aliases, column aliases, 1185–1186
Ambiguous invocation, of methods, 221
American Standard Code for Information Interchange (ASCII). see ASCII 
(American Standard Code for Information Interchange)
And (&&) logical operator, 93–97
Animation
ClockAnimation.java, 615–616
FadeTransition, 612–613
PathTransition, 609–612
Timeline, 614–616
using threads to control (flashing text case study), 1105
Anonymous arrays, 258
Anonymous objects, 331
```

</details>


## PDF page 1314

<details>
<summary>Page text</summary>

```text
Index  1291
Assignment statements (assignment expressions)
assigning value to variables, 36
overview of, 41–43
Associative arrays. see Maps
Associativity, of operators, 105, 1268–1269
atan method, trigonometry, 120–121
Attributes
columns in relational structures, 1175
object, 322
table, 1181
Audio files
case study: national flags and anthems, 665–667
MediaDemo.java, 663–664
Auto commit, SQL statements and, 1194
Autoboxing/Autounboxing, 383–384, 739–740
Autoenforcement, of integrity constraints, 1178
Average-case analysis, measuring algorithm efficiency, 
522, 836
A VL trees
AVLTree.java, 972–977
balancing nodes on a path, 970–971
deleting elements, 972
designing classes for, 969–970
key terms, 982
overriding the insert method, 970
overview of, 965–966
questions and exercises, 982–983
rebalancing, 966–968
rotations for balancing, 971
summary, 982
TestAVLTree.java, 978–981
time complexity of, 981
AVLTree class
overview of, 972–977
as subclass of BST class, 969
testing, 978–981
AWT (Abstract Windows Toolkit)
Color class, 546–547
Date class, 334–335, 503–504
Error class, 456, 458
event classes in, 588
EventObject class, 588–590
exceptions. seeException class
File class, 473–475, 678
Font class, 547–548
GeometricObject class, 496–499
GuessDate class, 304–305
IllegalArgumentException class, 459
InputMismatchException class, 454–455, 479
KeyEvent class, 603
MalformedURLException class, 483
MouseEvent class, 602–603
Polygon class, 569–570
String class, 386
Swing vs., 536
B
Babylonian method, 239
Backslash character (\), as directory separator, 474
Backtracking algorithm, 846–849
Backward pointer, in doubly linked lists, 920
Balance factor, for A VL nodes, 966
questions and exercises, 305–319
summary, 305
Arrays, single-dimensional
accessing elements, 248
ArrayList class, 435–436
Arrays class, 270–272
case study: analyzing numbers, 253–254
case study: counting occurrences of letters, 
261–264
case study: deck of cards, 254–256
case study: generic method for sorting, 744–745
constructing strings from, 386
converting strings to/from, 389–390
copying, 256–257
creating, 246–248, 510–512
declaring, 246
foreach loops, 251–253
initializers, 248–249
key terms, 275
of objects, 351–353
overview of, 245–246
passing to methods, 257–260
processing, 249–251
questions and exercises, 276–285
returning from methods, 260–261
searching, 265–269
serializing, 696–697
size and default values, 248
sorting, 269–270, 510–512
summary, 275–276
treating as objects in Java, 330
variable-length argument lists, 264–265
Arrays, two-dimensional
case study: finding closest pair of points, 296–297
case study: grading multiple-choice test, 294–296
case study: Sudoku, 298–301
declaring variables and creating two-dimensional arrays, 
288–289
obtaining length of two-dimensional arrays, 289–290
overview of, 287–288
passing to methods to two-dimensional arrays, 293–294
processing two-dimensional arrays, 291–293
questions and exercises, 305–319
ragged arrays, 290–291
representing graph edges with, 1020–1021
representing weighted graphs, 1063–1064
summary, 305
Arrays class, 270–271
Arrows keys, on keyboards, 5
ASCII (American Standard Code for Information Interchange)
character data type (char) and, 126
data input and output streams, 685
decimal and hexadecimal equivalents, 1267
encoding scheme, 3
text encoding, 678
text I/O vs. binary I/O, 679
asin method, trigonometry, 120–121
asList method, 771
Assemblers, 7
Assembly language, 7
Assignment operator (=), 1277
augmented, 54–55
overview of, 41–43
```

</details>


## PDF page 1315

<details>
<summary>Page text</summary>

```text
1292 Index
TestBSTWithIterator.java example, 953–954
tree traversal, 933–934
TreeControl.java example, 949–952
Tree.java example, 935–936
Binary trees, 930
binarySearch method
applying to lists, 774
Arrays class, 270–271
BindException, server sockets and, 1141
Binding properties
BindingDemo.java, 544
ShowCircleCentered.java, 542–543
Bit operators, 1277
Bits (binary digits), 3
Bitwise operators, 1277
Block comments, in Welcome.java, 12–13
Block modifiers, 1270–1271
Block style, programming style, 19
Blocking queues, 1122–1124
Blocks, in Welcome.java, 12–13
BMI (Body Mass Index), 89–90, 370–373
Boolean accessor method, 345
boolean data type
java.util.Random, 334–335
overview of, 76–78
Boolean expressions
case study: determining leap year, 97–98
conditional expressions, 103–104
defined, 76
if statements and, 78–79
if-else statements, 80–81
writing, 86–87
Boolean literals, 77
Boolean operators, 1184
Boolean values
defined, 76
as format specifier, 146
logical operators and, 93–94
redundancy in testing, 84
Boolean variables
assigning, 86
overview of, 76–77
redundancy in testing, 84
BorderPane
overview of, 556
ShowBorderPane.java, 557
Bottom-up implementation, 227–229
Bounded generic types
erasing, 750–751
GenericMatrix.java example, 752–757
MaxUsingGenericType.java example, 746–747
overview of, 743–744
Bounded wildcards, 748
Boxing, converting wrapper object to primitive value, 383
Braces. see Curly braces ({})
Breadth-first searches (BFS)
AbstractGraph class, 1031
applications of, 1047–1048
finding BFS trees, 1018
implementing, 1046
overview of, 1045
TestBFS.java, 1046–1047
traversing graphs, 1037
Breadth-first traversal, tree traversal, 934
Balanced nodes
in AVL trees, 966
AVLTree class, 972–973, 976–977
Base cases, in recursion, 712
BASIC, high-level languages, 8
Bean machine game, 280–281, 627
beginIndex method, for obtaining substrings from strings, 136
Behaviors (actions), object, 322
Behind the scene evaluation, expressions, 105
Best-case input, measuring algorithm efficiency, 822, 836
between-and operator, in SQL, 1185
BFS (breadth-first searches). see Breadth-first searches (BFS)
Big O
determining for repetition, sequence, and selection statements, 
824–827
for measuring algorithm efficiency, 822–823
BigDecimal class, 384–385, 501
Binary
files, 678
machine language as binary code, 7
operators, 47
searches, 266–269, 716–717
Binary digits (Bits), 3
Binary heaps (binary trees), 874. see also Heap sorts
Binary I/O
BufferedInputStream andBufferedOutputStream classes,
719–722
characters and strings in, 716
classes, 712–713
DataInputStream andDataOutputStream classes, 716–718
DetectEndOfFile.java, 687–688
FileInputStream andFileOutputStream classes,
681–682
FilterInputStream andFilterOutputStream classes, 684
overview of, 678
TestDataStream.java, 686–687
TestFileStream.java, 682–683
vs. text I/O, 679–680
Binary numbers
converting to/from decimal, 731, 1274
converting to/from hexadecimal, 1275
overview of, 1271
Binary search algorithm, 858
analyzing, 828
recurrence relations and, 829
Binary search trees (BST)
AbstractTree.java example, 936–937
BST class, 935–936
BST.java example, 937–941
case study: data compression, 954–956
deleting elements, 943–945
displaying/visualizing binary trees, 949
HuffmanCode.java example, 956–958
implementing using linked structure, 930–931
inserting elements, 932–933
iterators, 952–953
key terms, 959
overview of, 929–930
questions and exercises, 959–964
representation of, 931–932
searching for elements, 932
summary, 959
TestBSTDelete.java example, 946–948
TestBST.java example, 942–943
```

</details>


## PDF page 1316

<details>
<summary>Page text</summary>

```text
Index  1293
Catching exceptions. see alsotry-catch blocks
catch block omitted when finally clause is used, 467
CircleWithException.java example, 463
InputMismatchExceptionDemo.java example, 454–455
overview of, 459–461
QuotientWithException.java example, 521–522
CDs (compact discs), as storage device, 5
Cells
in Sudoku grid, 298
in tic-tac-toe case study, 657–662
Celsius, converting to/from Fahrenheit, 50–51, 236
Chained exceptions, 469–470
char data type. see Characters (char data type)
Characters (char data type)
applying numeric operators to, 223–224
in binary I/O, 684–685
case study: counting monetary units, 63–65
case study: ignoring nonalphanumeric characters when checking
palindromes, 396–398
casting to/from numeric types, 127
comparing, 76
constructing strings from arrays of, 386
converting to strings, 389–390
decimal and hexadecimal equivalents of ASCII character set, 1267
escape characters, 126
finding, 136–137
generic method for sorting array of Comparable objects, 744
hash codes for primitive types, 987
overview of, 125
RandomCharacter.java, 224
retrieving in strings, 131–132
TestRandomCharacter.java, 224–225
Unicode and ASCII and, 125–126
charAt (index) method
retrieving characters in strings, 131–132
StringBuilder class, 395
CheckBox, 634–636
Checked exceptions, 457
checkIndex method, 906
Checkpoint Questions, recurrence relations and, 829
Child, searching for elements in BST, 932–933
Choice lists. see Combo boxes
Circle class, 322
Circle and Ellipse
overview, 565
ShowEllipse.java, 566–567
Circular
doubly linked lists, 920
Circular, singly linked lists, 919
Clarity, class design guidelines, 526
Class diagrams, UML, 323
Class loaders, 17
Class modifiers, Java modifiers, 1270–1271
ClassCastException, 428
Classes
abstract. see Abstract classes
abstraction and encapsulation in, 366–367
benefits of generics, 738
case study: designing class for matrix using generic types, 752–755
case study: designing class for stacks, 378–380
case study: designing Course class, 376–377
inCircleWithPrivateDataFields.javaexample, 345–346
inCircleWithStaticMembers.java example, 338–339
clients of, 325
break statements
controlling loops, 184–187
using with switch statements, 100
Breakpoints, setting for debugging, 106
Brute-force algorithm, 833
BST (binary search trees). see Binary search trees (BST)
BST class
AbstractTree.java example, 936–937
AVLTree class as subclass of, 969
BST.java example, 937–941
overview of, 935
TestBSTDelete.java example, 946–948
TestBST.java example, 942–943
time complexity of, 948
Tree.java example, 935–936
Bubble sorts, 279
bubble sort algorithms, 865
BubbleSort.java example, 866
overview of, 864–865
time complexity of, 866
Buckets
bucket sorts, 881–883
separate chaining and, 993, 1012
BufferedInputStream andBufferedOutputStream classes, 688–690
Buffers, creating, 1120, 1123
Bugs (logic errors), 21, 106
Bus, function of, 2–3
Button, 632–634
ButtonBase, 632–633
Button,ButtonDemo.java, 633–634
byte type, numeric types
hash codes for primitive types, 987
overview of, 45
Bytecode
translating Java source file into, 15
verifier, 17
Bytes
defined, 3
measuring storage capacity in, 4
C
C, high-level languages, 8
C++, high-level languages, 8
Cable modems, 6
Calendar class, 503–504
Call stacks
displaying in debugging, 106
invoking methods and, 207
CallableStatement, for executing SQL stored procedures, 1199–1202
Calling
methods, 206–208
objects, 331
Candidate keys, 1215
canRead method,File class, 474–475
canWrite method,File class, 474–475
capacity method,StringBuilder class, 395
Case sensitivity
identifiers and, 39–40
inWelcome.java, 14
Casting. see Type casting
Casting objects
CastingDemo.java example, 428–431
overview of, 427–428
```

</details>


## PDF page 1317

<details>
<summary>Page text</summary>

```text
1294 Index
clone method, shallow and deep copies, 515–516
Cloneable interface
House.java example, 514–517
overview, 513–514
Closest-pair animation, 858
Closest pair problem, two-dimensional array applied to, 
296–297COBOL, high-level languages, 8
Code
arrays for simplifying, 250–251
comments and, 101
incremental development, 161
programming. see Programs/programming
reuse. see Reusable code
sharing. see Sharing code
in software development process, 61–62
Coding trees, 954–955. see also Huffman coding trees
Coherent purpose, class design guidelines, 526
Collections
Collection interface, 762–764
iterators for traversing collections, 766
singleton and unmodifiable, 816–817
static methods for, 773–777
synchronized collections, 1127–1128
TestCollection.java example, 764–766
Collections class
singleton and unmodifiable collections, 816–817
static methods, 774
synchronization wrapper methods, 1127
Collections Framework hierarchy
ArrayList and LinkedList classes, 769–771
case study: applet displaying bouncing balls, 777–781
case study: stacks used to evaluate expressions, 786–790
Collection interface, 762–764
Comparator interface, 772–773
Dequeue interface, 783–784
designing complex data structures, 1024
iterators for traversing collections, 766
key terms, 790
List interface, 767–768
Map interface, 986
methods of List interface, 767–768
overview of, 761–762
PriorityQueue class, 784–785
quiz and exercises, 791–796
Queue interface, 783
queues and priority queues, 783
static methods for lists and collections, 773–777
summary, 790–791
synchronized collections for lists, sets, and maps, 
1127–1128
TestCollection.java example, 764–766
TestIterator.java example, 766–767
Vector and Stack classes, 781–782
Collisions, in hashing
double hashing, 991–993
handling using open addressing, 989
handling using separate chaining, 993
linear probing, 989–990
overview of, 987
quadratic probing, 990–991
Columns (attributes)
column aliases, 1185–1186
creating, 336–337
relational structures, 1175
Classes (continued)
commenting, 18–19
inComputeExpression.java, 14–15
data field encapsulation for maintaining, 344–345
defining custom exception classes, 470–473
defining for objects, 322–324
defining generic, 740–742
design guidelines, 525–528
identifiers, 39–40
inner (nested) classes. see Inner (nested) classes
from Java Library, 334
JDBC, 1190
names/naming conventions, 13, 44
Point2D, 336–337
preventing extension of, 442–443
raw types and backward compatibility, 746
static variables, constants, and methods, 337–338
inTestCircleWithPrivateDataFields.java example,
346–347
inTestCircleWithStaticMembers.java example, 339–342
thread-safe, 1111
in UML diagram, 324
variable scope and, 337–338
visibility modifiers, 342–344
inWelcome.java, 12
inWelcomeWithThreeMessages.java, 14
Classes, binary I/O
BufferedInputStream andBufferedOutputStream classes,
688–690
DataInputStream andDataOutputStream classes, 684–686
DetectEndOfFile.java, 687–688
FileInputStream andFileOutputStream classes, 681–683
FilterInputStream andFilterOutputStream classes, 684
overview of, 680–681
TestDataStream.java, 686–687
TestFileStream.java, 682–683
Class’s contract, 366
Clients
client sockets, 1141–1142
client.java, 1145–1146
client/server example, 1143
multiple clients connected to single server, 1148–1157
StudentClient.java, 1153–1154
TicTacToeClient.java, 1162–1167
Client/server computing
case study: distributed tic-tac-toe games, 1156–1157
client sockets, 1141–1142
client.java, 1145–1146
client/server example, 1143
data transmission through sockets, 1142
InetAddress class, 1147–1148
multiple clients connected to single server, 1148–1151
overview of, 1140
sending and receiving objects, 1151–1156
server sockets, 1140–1141
server.java, 1143–1144
TicTacToeClient.java, 1162–1167
TicTacToeConstants.java, 1157
TicTacToeServer.java, 1157–1162
ClockPane Class
ClockPane.java, 574–577
DisplayClock.java, 573–574
paintClock method, 576–577
Clock speed, CPUs, 3
```

</details>


## PDF page 1318

<details>
<summary>Page text</summary>

```text
Index  1295
naming conventions, 
overview of, 629–630
quiz and exercises, 668–676
scroll bars, 651–652
ScrollBarDemo.java, 652–653
SliderDemo.java, 655–656
sliders, 654
summary, 668
text area, 641–642
TextAreaDemo.java, 644
Composition, in designing stacks and queues, 921
Composition relationships
betweenArrayList and MyStack, 439–440
aggregation and, 374–375
Compound expressions
case study: stacks used to evaluate, 786–787
EvaluateExpression.java example, 
788–790
Compression
data compression using Huffman coding, 
954–956
of hash codes, 988–989
HuffmanCode.java example, 956–958
Compute expression, 14
Computers
communication devices, 6–7
CPUs, 3
input/output devices, 5–6
memory, 4
OSs (operating systems), 9–10
overview of, 2–3
programming languages, 7–9
storage devices, 4–5
concat method, 131
Concatenate strings, 36, 131
Concurrency, impact of running multiple threads, 1101
Conditional expressions, 103–104
Conditions
on locks for thread cooperation, 1114–1115
thread synchronization using, 1112–1113
ThreadCooperation.java, 1116–1119
Connect four game, 313
Connected circles problem
ConnectedCircles.java, 1043–1045
overview of, 1042–1043
Connected graphs, 1018
Consistency, class design guidelines, 526
Consoles
defined, 12
formatting output, 145–149
input, 12
output, 12
reading input, 37–39
Constant time, comparing growth functions, 830
Constants
class, 337–338
declaring, 338
identifiers, 39–40
KeyCode constants, 604
named constants, 43
naming conventions, 44
TicTacToeConstants.java, 1157
wrapper classes and, 381
Constructor chaining, 417–418
Combo boxes
ComboBoxDemo.java, 645–646
overview of, 644–645
Command-line arguments, 272–275
Comments
code maintainability and, 101
programming style and, 18
inWelcome.java, 12–13
Common denominator, finding greatest common denominator. see Gcd 
(greatest common denominator)
Communication devices, computers and, 6–7
Compact discs (CDs), as storage device, 4–5
Comparable interface
ComparableRectangle.java example, 511–512
Comparator interface vs., 773
as example of generic interface, 738–739
generic method for sorting array of Comparable objects, 744
overview of, 509–510
PriorityQueue class and, 784
Rational class implementing, 522
SortComparableObjects.java example, 510–511
SortRectangles.java example, 512–513
TreeMap class and, 813
Comparator interface
Comparable vs., 773
GeometricObjectComparator.java, 772
methods of, 772
PriorityQueue class and, 784
TestComparator.java, 772–773
TestTreeSetWithComparator.java example, 804–806
TreeMap class and, 813
compare method, 772–773
compareTo method
Cloneable interface and, 513
Comparable interface defining, 509–510
ComparableRectangle.java example, 511–512
comparing strings, generic method for sorting array of Comparable
objects, 745
implementing in Rational class, 522
wrapper classes and, 381
compareToIgnoreCase method, strings, Comparing strings, 
Comparison operators, 76, 432, 1184
Compatibility, raw types and backward compatibility, 746–747
Compile errors (Syntax errors)
common errors, 13–14
debugging, 106
programming errors, 20
Compile time
error detection at, 738
restrictions on generic types, 751
Xlint:unchecked error, 746
Compilers
ambiguous invocation and, 221
reporting syntax errors, 20
translating Java source file into bytecode file, 15–16
translating source program into machine code, 8–9
Complete graphs, 1018
Completeness, class design guidelines, 527
Complex numbers, Math class, 531
Components
JSF GUI, 1222–1226
TextFieldDemo.java, 639–641
ListView, 647–649
ListViewDemo.java, 649–650, 661–662
```

</details>


## PDF page 1319

<details>
<summary>Page text</summary>

```text
1296 Index
Cursor, mouse, 6
Cycle, connected graphs, 1018
D
.dat files (binary), 680
Data, arrays for referencing, 246
Data compression
Huffman coding for, 954–956
HuffmanCode.java example, 956–959
Data definition language (DDL), 1192
Data fields
accessing object data, 330–331
encapsulating, 344–345, 526
in interfaces, 508
object state represented by, 322–323
protected in abstract classes, 899
referencing, 331, 356–357
inSimpleCircle example, 325–326
inTV.java example, 327
UML diagram of, 324
Data modifiers, 1270–1271
Data streams. seeDataInputStream/DataOutputStream classes
Data structures. see also Collections Framework hierarchy
array lists. seeArrayList class
choosing, 762
collections. see Collections
first-in, first-out, 782
linked lists. seeLinkedList class
lists. see Lists
queues. see Queues
stacks. see Stacks
Data structures, implementing
array lists, 900–901
GenericQueue.java example, 922
implementingMyLinkedList class, 909–915
linked lists, 906–908
lists, 896–897
MyAbstractList.java example, 899
MyArrayList compared with MyLinkedList, 918–919
MyArrayList.java example, 901–904
MyLinkedList.java example, 908–910, 916–918
MyList.java example, 897–898
MyPriorityQueue.java example, 924
overview of, 895–896
priority queues, 924
quiz and exercises, 926–928
stacks and queues, 920–921
summary, 925
TestMyArrayList.java example, 905–906
TestMyLinkedList.java example, 909–910
TestPriorityQueue.java example, 924–925
TestStackQueue.java example, 922–923
variations on linked lists, 919–920
Data transmission, through sockets, 1142
Data types
ADT (abstract data type), 366
boolean, 76–78, 335
Constructors
in abstract classes, 498
forAbstractGrpah class, 1028–1029
forAVLTree class, 972–973
forBMI class, 372
calling subclass constructors, 416–417
creating objects with, 329
creatingRandom objects, 335
forDataInputStream and DataOutputStream classes, 685
forDate class, 335
generic classes and, 742
interfaces vs. abstract classes, 517
invoking with this reference, 374–375
forLoan class, 357–358
object methods and, 322–323
private, 344
inSimpleCircle example, 325–326
forString class, 386
forStringBuilder class, 393
inTV.java example, 327
UML diagram of, 324
forUnweightedGraph class, 1033–1034
forWeightedGraph class, 1066–1067
wrapper classes and, 527
Containers
creating data structures, 762
maps as, 810
removing elements from, 808
storing objects in, 763
types supported by Java Collections 
Framework, 762
contains method, 809
Contention, thread priorities and, 1104
continue statements, for controlling loops, 184–187
Contract, object class as, 322
Control, 539–542
Control units, CPUs, 3
Control variables, in for loops, 171–172
Conversion methods, for wrapper classes, 381
Convex hull
finding for set of points, 849
gift-wrapping algorithm applied to, 849–580
Graham’s algorithm applied to, 850–851
Copying
arrays, 256–257
files, 691
Core, of CPU, 3
cos method, trigonometry, 120–121
Cosine function, 581
Counter-controlled loops, 159
Coupon collector’s problem, 260
Course class, 376
CPUs (central processing units), 3
round-robin scheduling, 1104
time sharing by threads, 1098
create table statement, 1181
Critical regions, avoiding thread race conditions, 1111
Cubic time, comparing growth functions, 829–830
Curly braces ({})
in block syntax, 13
dangers of omitting, 172
forgetting to use, 83
currentTimeMillis method, 52
```

</details>


## PDF page 1320

<details>
<summary>Page text</summary>

```text
Index  1297
Declaring methods
generic methods, 743
static methods, 337
Declaring variables
array variables, 246
overview of, 40–41
specifying data types and, 35–36
two-dimensional array variables, 288–289
Decrement (––) operator, 55–56
Deep copies, 516
Default field values, for data fields, 331–332
Degree of vertex, 1018
Delete key, on keyboards, 6
delete method, AVLTree class, 981
Delete statements, SQL, 1182–1183
Delimiters, token reading methods and, 479
Denominator. see Gcd (greatest common denominator)
Denominators, in rational numbers, 520
Deployment, in software development process, 60
Depth-first searches (DFS)
AbstractGraph class, 1031
applications, 1041–1042
case study: connected circles problem, 1042–1043
finding DFS trees, 1018
implementing, 1039–1040
traversing graphs, 1037–1038
Depth-first traversal, tree traversal, 933
Dequeue interface, LinkedList class, 783–784
dequeue method, 922
DescriptionPane class, 642–643
Descriptive names
benefits of, 40
for variables, 35
Deserialization, of objects, 695
Design guidelines, classes, 525–528
Determining Big O
for repetition statements, 824–827
for selection statements, 824–827
for sequence statements, 824–827
DFS (depth-first searches). see Depth-first searches (DFS)
Dial-up modems, 6
Dictionaries. see Maps
Digital subscriber lines (DSLs), 6
Digital versatile disc (DVDs), 5
Digits, matching, 98
Dijkstra’s single-source shortest-path algorithm, 1079–1083
Direct recursion, 709
Directed graphs, 1017
Directories
case study: determining directory size, 717
DirectorySize.java, 717–718
File class and, 474
file paths, 473
disjoint method, 776
Disks, as storage device, 5
Display message
inWelcome.java, 12
inWelcomeWithThreeMessages.java, 14
distinct keyword, for eliminating duplicate tuples, 
1186–1187
Divide-and-conquer algorithm, 844
Divide-and-conquer strategy. see Stepwise refinement
Division (/=) assignment operator, 42
char. see Characters (char data type)
double. seedouble (double precision), numeric types
float. see Floating-point numbers (float data type)
fundamental. see Primitive types
generic. see Generics
int. see Integers (int data type)
long. seelong, numeric types
numeric, 44–46, 56–58
reference types. see Reference types
specifying, 35
strings, 130
types of, 41
using abstract class as, 500
Database management system (DBMS)
overview of, 1174
SQL as. see SQL (Structured Query Language)
Database metadata
DatabaseMetaData interface, 1202–1204
obtaining database tables, 1204
overview of, 1202
ResultSetMetaData interface, 1204–1205
TestDatabaseMetaData.java, 1203
TestResultSetMetaData.java, 1205
Databases
accessing using JavaFX, 1194–1196
creating in MySQL, 1180–1181
database system, 1174–1175
populating, 1181
relational. see Relational DBMS
DataInputStream/DataOutputStream classes
DetectEndOfFile.java, 687
external sorts and, 884–885
overview of, 684
TestDataStream.java, 686
Date class
case study: Calendar and GregorianCalendar
classes, 503–504
java.util, 334–335
DBMS (database management system). see Database management 
system (DBMS)
DDL (data definition language), 1192
De Morgan’s law, 95
Deadlocks, avoiding, 1126
Debugging
benefits of stepwise refinement, 232
code modularization and, 215
selections, 106
Decimal numbers
BigDecimal class, 384–385
converting to hexadecimals, 182–183, 217–219, 731
converting to/from binary, 731, 1274
converting to/from hexadecimal, 1275
division of, 51
equivalents of ASCII character set, 1267
overview of, 1273
Declaring constants, 43, 337
Declaring exceptions
CircleWithException.java example, 463–464
ReadData.java example, 478–479
TestCircleWithCustomException.java example, 471–472
throws keyword for, 458
```

</details>


## PDF page 1321

<details>
<summary>Page text</summary>

```text
1298 Index
Edge-weighted graphs
overview of, 1062
WeightedGraph class, 1064
Eight Queens puzzle
EightQueens.java, 847–848
parallel, 1136
recursion, 734–735
single-dimensional arrays, 281
solving, 846–847
Element type, specifying for arrays, 246
Emirp, 240
Empty element, 1221
Encapsulation
inCircleWithPrivateDataFields.java example, 
345–346
class design guidelines, 525–526
of classes, 366–367
of data fields, 344–345
information hiding with, 225
ofRational class, 525
Encoding schemes
defined, 3–4
mapping characters to binary equivalents, 125
End of file exception (EOFException), 687
End-of-line style, block styles, 19
enqueue method, 922
entrySet method, Map interface, 812
Equal (=) operator, for assignment, 76
Equal to (==) operator, for comparison, 76
equalArea method, for comparing areas of geometric objects, 499
Equals method
Arrays class, 271
Comparator interface, 772
Object class, 422
Erasure and restrictions, on generics, 750–752
Error class, 456, 458
Errors, programming. see Programming errors
Euclid’s algorithm
finding greatest common denominator, 835
GCDEuclid.java example, 835–837
Euler, 1016–1017
Event delegation, 589
Event handlers/event handling, 587–588, 604, 597–599
Ever-waiting threads, 1118
Exception class
exceptions in, 456
extending, 470
injava.lang, 471
subclasses of, 456–457
Exception handling. see also Programming errors
BindException, 1141
catching exceptions, 459–461, 463
chained exceptions, 469–470
checked and unchecked, 457
CircleWithException.java example, 463–464
ClassCastException, 428
declaring exceptions (throws), 458, 463
defined, 450
defining custom exception classes, 470–473
EOFException, 687
inException class, 456
exception classes cannot be generic, 752
FileNotFoundException, 681
Division operator (/), 46, 50
DNS (Domain Name Servers), 1140
Documentation, programming and, 18
Domain constraints, integrity constraints in relational 
model, 1176
Domain Name Servers (DNS), 1140
Domain names
overview of, 1140
using to create socket, 1141
Dot operator (.), 330
Dot pitch, measuring sharpness of displays, 6
double (double precision), numeric types
converting characters and numeric values to strings, 389
declaring variables and, 41
generic method for sorting array of Comparable
objects, 744
hash codes for primitive types, 987
java.util.Random, 335
overview of numeric types, 45
precision of, 178–179
Double hashing, collision handling, 991–993
Doubly linked lists, 920
do-while loops
deciding when to use, 174–175
overview of, 168–170
Downcasting objects, 427
drawArc method, 567–569
Drivers, JDBC, 1189–1191
Drives, 5
drop table statement, 1182
Drop-down lists. see Combo boxes
DSLs (digital subscriber lines), 6
DVDs (Digital versatile disc), 5
Dynamic binding, inheritance and, 424–427
Dynamic programming
computing Fibonacci numbers, 832–833
Dijkstra’s algorithm, 1083
E
Eclipse
built in debugging, 106
creating/editing Java source code, 15
Edge arrays
representing edges, 1020–1021
weighted edges using, 1063–1064
Edge class, 1021
Edges
AbstractGraph class, 1029
adjacency lists, 1022–1024
adjacency matrices, 1021–1022
adjacent and incident, 1018
defining as objects, 1021
Graph.java example, 1028
on graphs, 1017
Prim’s algorithm and, 1072
representing edge arrays, 1020–1021
TestGraph.java example, 1026
TestMinimumSpanningTree.java, 1076–1077
TestWeightedGraph.java, 1070–1071
weighted adjacency matrices, 1064
weighted edges using edge array, 1063–1064
weighted graphs, 1062
WeightedGraph class, 1065–1066
```

</details>


## PDF page 1322

<details>
<summary>Page text</summary>

```text
Index  1299
Feet, converting to/from meters, 236
fib method, 710–712
Fibonacci, Leonardo, 710
Fibonacci numbers
algorithm for finding, 831
case study: computing, 709–710
ComputeFibonacci.java, 710–712
computing recursively, 729
ImprovedFibonacci.java example, 832
recurrence relations and, 829
FigurePanel class
File class, 473–475, 678
File I/O. see I/O (input/output)
File pointers, random-access files and, 698
FileInputStream/FileOutputStream classes
overview of, 681–682
TestFileStream.java, 682–684
Files
case study: copying files, 691
case study: replacing text in, 480
File class, 473–475, 678
input/output, 476
key terms, 486
quiz and exercises, 488–493
reading data from, 478–479
reading data from Web, 482–484
summary, 487
TestFileClass.java, 475
writing data to, 476–477
fill method, 776
FilterInputStream/FilterOutputStream classes, 684
final keyword, for declaring constants, 43
final modifier, for preventing classes from being extended, 
442–443
finally clause, in exception handling, 466–467
First-in, first out data structures, 783
float data type. see Floating-point numbers (float data type)
Floating-point literals, 49
Floating-point numbers (float data type)
approximation of, 66
converting to integers, 56
hash codes for primitive types, 987
java.util.Random, 335
minimizing numeric errors related to loops, 178–179
numeric types for, 45
overview of numeric types, 45
special values, 1272
specifying data types, 35
specifying precision, 147
Flowcharts
do-while loops, 169
if statements, 78–79
if-else statements, 80
for loops, 171
switch statements, 100
while loops, 158
FlowLayout class
FlowPane
HBox and VBox, 558
overview, 552
ShowFlowPane.java, 553
Folding, hash codes and, 987
Font, FontDemo.java, 548
finally clause in, 466–467
getting information about exceptions, 461–462
inHouse.java example, 515
IllegalMonitorStateException, 1118
InputMismatchExceptionDemo.java example, 454
InterruptedException, 1103
IOException, 456
key terms, 486
NotSerializableException, 695
overview of, 39, 449–450
quiz and exercises, 488–493
Quotient.java example, 450
QuotientWithException.java example, 452–454
QuotientWithIf.java example, 451
QuotientWithMethod.java example, 451–452
rethrowing exceptions, 468–469
summary, 487
TestCircleWithException.java example, 464–466
TestException.java example, 462
throwing exceptions, 458–459, 468
types of exceptions, 455–459
UnknownHostException, 1142
unsupported operations of Collection interface, 764
when to use exceptions, 467–468
Exception propagation, 459
Exclusive or (^) logical operator, 93–97
Execution stacks. see Call stacks
Executor interface, 1107
Executors
AccountWithoutSync.java, 1109–1110
thread pools and, 1107–1108
exists method, for checking file instances, 474
Explicit casting, 56–57, 427
Exponent method, Math class, 121
Exponent operations, 48
Exponential algorithms, 829, 852
Expressions
assignment statements and, 41–43
behind the scene evaluation, 105
Boolean. see Boolean expressions
case study: stacks used to evaluate, 786–787
EvaluateExpression.java example, 788–790
evaluating, 50–51
extends keyword, interface inheritance and, 518
External sorts
complexity of, 889–890
CreateFile.java example, 883–885
implementation phases, 884–889
overview of, 883
F
Facelet, binding database with, 1239–1245
Factorials
case study: computing factorials, 706–707
ComputeFactorial.java, 707–709
ComputeFactorialTailRecusion.java, 727–728
tail recursion and, 727
FadeTransition, 612–613
Fahrenheit, converting Celsius to/from, 51, 235
Fail-fast, iterators, 1128
Fairness policy, locks and, 1113
Fall-through behavior, switch statements, 101
```

</details>


## PDF page 1323

<details>
<summary>Page text</summary>

```text
1300 Index
restrictions on generic types, 750–752
summary, 757–758
wildcards for specifying range of generic types, 747–750
Genome, 367
GeometricObject class
Circle.java andRectangle.java, 498
overview of, 496
TestGeometricObject.java, 498–499
getAbsolutePath method,File class, 574–575
getArea method,SimpleCircle example, 325
getArray method, 293–294
getBMI method,BMI class, 372
getCharacterFrequency method, 958
getChars method, converting strings into arrays, 389
getDateCreated method,Date class, 354
getIndex method,ArrayList class, 435
getMinimumSpanningTree method,WeightedGraph class, 107, 
1077–1078
getPerimeter method,SimpleCircle example, 325
getRadius method,CircleWithPrivateDataFields.java
example, 346
getRandomLowerCaseLetter method, 261, 263
getResponse method, 1235, 1239, 1243
getSize method, finding directory size, 440
getSource method, events, 588
getStackTrace method, for getting information about exceptions, 462
getStatus method,BMI class, 372
Getter (accessor) methods
ArrayList class and, 436
encapsulation of data fields and, 344–347
implementing linked lists, 906–907
getTime() method, 1221
Gift-wrapping algorithm, 849–850
Gigabytes (GBs), of storage, 4
Gigahertz (GHz), clock speed, 3
GMT (Greenwich Mean Time), 52
Gosling, James, 10
Graham’s algorithm, 850–851
Graph interface, 1024–1025
Graph theory, 1016
Graphical user interface (GUI), 630, 1222–1226
Graphs
AbstractGraph.java example, 1028–1033
breadth-first searches (BFS), 1045–1048
case study: connected circles problem, 1042–1045
case study: nine tails problem, 1048–1053
ConnectedCircles.java, 1043–1045
depth-first searches (DFS), 1038–1042
Displayable.java example, 1034
DisplayUSMap.java example, 1035–1037
Graph.java example, 1028
GraphView.java example, 1035
key terms, 1053
modeling, 1024–1026
overview of, 1047–1049
questions and exercises, 1054–1059
representing edges, 1020–1021
representing vertices, 1019–1020
summary, 1054
terminology regarding, 1017–1019
TestGraph.java example, 1026–1028
traversing, 1038
UnweightedGraph.java example, 1033–1034
visualization of, 1034–1035
for loops
deciding when to use, 175
nesting, 176, 291
overview of, 170–174
processing arrays with, 249
variable scope and, 222–223
foreach (enhanced) loops
implicit use of iterator by, 771
overview of, 251–253
for traversing collections, 767
Foreign key constraints, integrity constraints in relational model, 
1176–1178
Fork/Join Framework
merge sorts compared with, 869
for parallel programming, 1128–1130
ParallelMax.java, 1132–1133
ForkJoinTask class, 1129
Forks, 1129
Formal generic type, 738
Formal parameters. see Parameters
Format specifiers, 146–148
FORTRAN, high-level languages, 8
Forward pointer, in doubly linked lists, 920
Fractals
case study, 722–723
H-tree fractals, 735
Koch snowflake fractal, 733
SierpinskiTriangle.java, 723–725
Frames (windows)
ScrollBarDemo.java, 652–653
SliderDemo.java, 655–656
Free cells, in Sudoku grid, 298
frequency method, collections and, 776
from clause,select statements, 1183
Function keys, on keyboards, 5
Functions, 205. see also Methods
Fundamental types (Primitive types). see Primitive types
G
Galton box, 280
Garbage collection, JVM and, 333
GBs (gigabytes), of storage, 4
Gcd (greatest common denominator)
algorithm for finding, 833–835
case study: finding greatest common denominator, 179–181
computing recursively, 729
gcd method, 216, 424
GCDEuclid.java example, 835–837
GCD.java example, 834–835
Rational class and, 522
Generic instantiation, 738
Generics
case study: designing class for matrix using generic types, 752–757
case study: generic method for sorting array, 744–745
defining generic classes and interfaces, 740–741
erasing generic types, 750–752
GenericStack class, 740–742
key terms, 757
methods, 742–744
motivation for using, 738–740
overview of, 737–738
questions and exercises, 758–759
raw types and backward compatibility and, 746–747
```

</details>


## PDF page 1324

<details>
<summary>Page text</summary>

```text
Index  1301
TestMyHashMap.java example of map implementation, 
1002–1003
TestMyHashSet.java example of set implementation, 1010–1011
what it is, 986–987
HashMap class
concrete implementation of Map class, 810–812
implementation of Map class, 986
load factor thresholds, 994
overview of, 813
TestMap.javaexample, 813–815
types of maps, 810–811
HashSet class
case study: counting keywords, 809–810
implementation of Set class, 1002
overview of, 797–798
TestHashSet.java example, 799–800
TestMethodsInCollection.java example, 800–802
types of sets, 798
Hashtable, 813
HBox and VBox
definition, 560
overview, 558
ShowHBoxVBox.java, 559
Heap class
Heap.java example, 878–879
operations for manipulating heaps in, 878
sorting arrays with, 879
Heap sorts
adding nodes to heaps, 875–876
algorithm for, 874–875
arrays using heaps, 879
complexity of, 880–881
Heap class, 877–878
Heap.java example, 878–879
HeapSort.java example, 879–880
removing root from heap, 876–877
storing heaps, 875
Heaps
adding nodes to, 875–876
arrays using, 879
binary heaps (binary trees), 874
dynamic memory allocation and, 259
implementing priority queues with, 924
removing root from, 876–877
storing, 875
Helper methods, recursive
overview of, 714
RecursivePalindrome.java, 714–715
Hertz (Hz), clock speed in, 3
Hex integer literals, 49
Hexadecimal numbers
converting to/from binary, 1275–1276
converting to/from decimal, 182–183, 217–219, 731, 1275
equivalents of ASCII character set, 1267
overview of, 1273
Hidden data fields, referencing, 356–357
High-level languages, 8–9
Hilbert curve, 736
Horizontal scroll bars, 652
Horizontal sliders, 654, 655
Hosts
IdentifyHostNameIP.java, 1148
local hosts and, 1141
UnknownHostException, 1142
Greater than (>) comparison operator, 76
Greater than or equal to (>=) comparison operator, 76
Greatest common denominator. see Gcd (greatest common denominator)
Greedy algorithms
Dijkstra’s algorithm, 1083
overview of, 956
Greenwich Mean Time (GMT), 52
GregorianCalendar class
Cloneable interface and, 513–514
injava.util package, 361
overview of, 503–504
TestCalendar.java, 504–506
GridPane
overview, 555
ShowGridPane.java, 555–556
Grids, representing using two-dimensional array, 298
Growth rates
algorithm for comparing, 829–830
comparing algorithms based on, 822
H
Hamiltonian path/cycle, 1042
Hand-traces, for debugging, 106
Hangman game, 284, 490, 581, 792, 794
Hard disks, as storage device, 5
Hardware, 2
Has-a relationships
in aggregation models, 374–375
composition and, 440
Hash codes
compressing, 988–389
vs. hash functions, 987
for primitive types, 987
for strings, 987–988
Hash functions
vs. hash codes, 987
as index to hash table, 986
Hash tables, 986. see also Maps
measuring fullness using load factor, 993
parameters, 1001
hashCode method, 798, 987
Hashing
collision handling using open addressing, 989
collision handling using separate chaining, 993
compressing hash codes, 988–989
double hashing open addressing, 991–993
function, 986
hash codes for primitive types, 987
hash codes for strings, 987–988
hash functions vs. hash codes, 987
key terms, 1011
linear probing open addressing, 989–990
load factor and rehashing, 993–995
map implementation with, 995–996
MyHashMap.java example of map implementation, 997–1002
MyHashSet.java example of set implementation, 1005–1010
MyMap.java example of map implementation, 996–997
MySet.java example of set implementation, 1004–1005
overview of, 985–986
quadratic probing open addressing, 990–991
questions and exercises, 1012–1013
set implementation with, 1004
summary, 1011–1012
```

</details>


## PDF page 1325

<details>
<summary>Page text</summary>

```text
1302 Index
MyList.java, 897–898
string index range, 131
indexOf method, 136–137
List interface, 769
MyArrayList.java example, 901, 905
Indirect recursion, 709
InetAddress class, 1147–1148
Infinite loops, 160
Infinite recursion, 709
Information
getting information about exceptions, 461–462
hiding (encapsulation), 225
Inheritance
ArrayList object, 432–433
calling subclass constructors, 416–417
calling superclass methods, 418–419
case study: custom stack class, 439–440
casting objects and, 427–428
CastingDemo.java example, 427–431
CircleFromGeometricObject.java example, 412–414
constructor chaining and, 417–418
in designing stacks and queues, 921
DistinctNumbers.java example, 436–438
dynamic binding and, 424–427
equals method of Object class, 431–432
generic classes, 742
interface inheritance, 506–507, 518
is-a relationships and, 440
key terms, 443
Object class and, 422–423
overriding methods and, 420–422
overview of, 409–410
preventing classes from being extended or overridden, 
442–443
protected data and methods, 440–442
questions and exercises, 448–493
RectangleFromGeometricObject.java example, 414–415
SimpleGeometricObject.java example, 411–412
summary, 443–444
superclasses and subclasses and, 410–411
TestArrayList.java example, 433–436
TestCircleRectangle.java example, 415–416
usingsuper keyword, 416
initializeJdbc method, 1243
Initializing variables
AnalyzeNumbers.java, 253–254
arrays, 249–250
declaring variables and, 41
multidimensional arrays, 289
two-dimensional arrays, 291
Inner (nested) classes
AbstractGraph class, 1031
anonymous, 594–595
AnonymousListenerDemo.java, 595–597
creating new, 1125–1126
for defining listener classes, 593–594
KeyEventDemo.java, 604
ShortestPathTree class as inner class of WeightedGraph class,
1082–1083
TicTacToe.java, 658–659
Inorder traversal
time complexity of, 948
tree traversal, 933
HTML (Hypertext Markup Language)
element, 1217
scripting language for document layout, 11
H-trees
fractals, 735
recursive approach to, 706
Huffman coding trees
data compression using, 954–956
HuffmanCode.java example, 956–959
Hypertext Markup Language. see HTML (Hypertext Markup Language)
Hz (Hertz), clock speed in, 3
I
Icons. see Image icons
Identifiers, 39–40
IDEs (integrated development environments)for creating/editing Java 
source code, 11, 15–16
IEEE (Institute of Electrical and Electronics Engineers), floating point 
standard (IEEE 754), 45
if statements
common errors, 83–87
in computing body mass index, 89–90
in computing taxes, 90–93
conditional operator used with, 104
nesting, 81
overview of, 78–80
SimpleIfDemo.java example, 79–80
if-else statements
conditional expressions and, 112
dangling else ambiguity, 84–85
multi-way, 81–83
overview of, 81–83
recursion and, 712
IllegalArgumentException class, 459
IllegalMonitorStateException, 1118
Image , 549–552
Image class, 549
Image icons, ComboBoxDemo.java, 646
Images,ShowImage.java, 550–551
ImageView , 549–552
Immutable
BigInteger andBigDecimal classes, 384–385
class, 354
objects, 353–354
Rational class, 525
String object, 386–387
wrapper classes, 381
Implementation (coding), in software development process, 61–62
Implementation methods, 229–232
Implicit casting, 127, 427
Importing, types of import statements, 38
Increment (++) operator, 55–56
increment method, in Increment.java example, 212–213
Incremental development
benefits of stepwise refinement, 232
coding incrementally, 161
testing and, 62
Indentation, programming style, 19
Indexed variables Elements, 248
Indexes
accessing elements in arrays, 246, 248
finding characters/substrings in a string, 136–137
List interface and, 769
```

</details>


## PDF page 1326

<details>
<summary>Page text</summary>

```text
Index  1303
generic method for sorting array of Comparable objects, 744
greatest common denominator of, 833
hash codes for primitive types, 987
IntegerMatrix.java example, 755–756
java.util.Random, 335–336
numeric types for, 44–45
sorting, 881
sorting int values, 887
specifying data types, 35
TestIntegerMatrix.java example, 756
Integrated development environments (IDEs), 11–12, 15–16
for creating/editing Java source code, 15–16
overview of, 11–12
Integrity, in relational data model, 1174–1175
Integrity constraints
domain constraints, 1177
enforcing, 1178
overview of, 1176–1177
primary and foreign key constraints, 1177–1178
Intelligent guesses, 161
Interfaces
abstract classes compared with, 517–520
benefits of, 512
benefits of generics, 738
case study: Rational class, 520–521
Cloneable interface, 513–514
Comparable interface, 509–510
ComparableRectangle.java example, 511–512
DBMS as, 1174
for defining common class behaviors, 560
defining generic, 740–742
House.java example, 514–517
key terms, 528
overview of, 496
questions and exercises, 528–533
raw types and backward compartibility, 778
SortComparableObjects.java example, 510–512
SortRectangles.java example, 512–513
summary, 528–529
TestEdible.java example, 506–509
Interned strings, 386–387
Internet, 1140
Internet Protocol (IP) addresses. see IP (Internet Protocol) addresses
Internet Service Providers (ISPs), 1140
Interpreters, translating source program into machine code, 10–11
Interrelational constraints, 1176–1177
InterruptedException,Thread class, 1103
Intrarelational constraints, 1176–1177
Invoking methods, 206–207, 331, 743
I/O (input/output)
binary I/O classes, 680–681
BufferedInputStream andBufferedOutputStream classes, 
688–690
case study: copying files, 391
case study: replacing text, 580–581
Copy.java, 691–692
data transmission streams through sockets, 1142
DataInputStream andDataOutputStream classes, 684–686
DetectEndOfFile.java, 687–688
FileInputStream andFileOutputStream classes, 681–682
FilterInputStream andFilterOutputStream classes, 684
handling text I/O in Java, 678–679
key terms, 700
Input. see also I/O (input/output)
reading from console, 37–40
redirecting using while loops, 168–169
runtime errors, 20–21
streams. seeInputStream classes
Input, process, output (IPO), 39
InputMismatchException class, 454–455, 479
Input/output devices, computers and, 5–6
InputStream classes
BufferedInputStream, 688–690
case study: copying files, 691
data transmission through sockets, 1142
DataInputStream, 684–686
deserialization and, 695
DetectEndOfFile.java, 687–688
FileInputStream, 681–682
FilterInputStream, 684
ObjectInputStream, 692–693, 1151
overview of, 680–681
TestDataStream.java, 686–687
TestFileStream.java, 682–683
TestObjectInputStream.java, 694
Insert key, on keyboards, 6
insert method
AVLTree class, 981
overriding, 970–971
Insert statements, SQL, 1182–1183
Insertion order, LinkedHashMap class, 813
Insertion sort algorithms
analyzing, 828
recurrence relations and, 829
Insertion sorts, arrays, 862–864
Instance methods
accessing object data and methods, 330–331
inCircleWithStaticMembers.java, 338–339
class design guidelines, 325–328
invoking, 368, 371
when to use instance methods vs. static, 338–339
Instance variables
accessing object data and methods, 305
class design guidelines, 392–393
static variables compared with, 337–339
inTestCircleWithStaticMembers.java, 339
when to use instance variables vs. static, 341
Instances. see also Objects
checking file instantiation, 474
checking object instantiation, 322, 428
generic instantiation, 738
Institute of Electrical and Electronics Engineers (IEEE), floating point 
standard (IEEE 754), 45
int data type. see Integers (int data type)
Integer literals, 49
Integers (int data type)
ArrayList for, 437
BigInteger class, 387–385
bit operators and, 1277
case study: designing class for matrix using generic types, 752–753
casting to/from char types, 127
converting characters and numeric values to strings, 389–390
declaring variables and, 40
division of, 46, 51, 450–454
finding larger between two, 205
floating-point numbers converted to, 56–57
```

</details>


## PDF page 1327

<details>
<summary>Page text</summary>

```text
1304 Index
Java database programming
accessing databases using JavaFX, 1194–1196
CallableStatement for executing SQL stored procedures, 
1199–1202
column aliases, 1185–1186
creating databases, 1180–1181
creating tables, 1181–1182
creating user account in MySQL, 1179–1180
database metadata, 1202–1203
developing database applications using JDBC, 1190–1193
insert, update, and delete statements, 1182–1183
integrity constraints, 1176–1178
JDBC (Java Database Connectivity), 1189–1190
key terms, 1206
metadata retrieval, 1202
obtaining tables, 1204
operators, 1184–1186
overview of, 1173–1174
PreparedStatement for creating parameterized SQLstatements,
1197–1199
queries, 1183–1184
questions and exercises, 1207–1211
relational DBMS, 1174–1175
relational structures, 1175–1176
result set metadata, 1204–1206
SimpleJDBC.java, 1193–1194
SQL (Structured Query Language), 1178
summary, 1206
table joins, 1188–1189
tuples, 1186–1188
Java Development Toolkit (JDK)
jdb debugger in, 106
overview of, 11–12
Java EE (Java Enterprise Edition), 12
JavaFX
Arc, 567–569
binding properties, 542–544
BorderPane, 556–558
case study: ClockPane Class, 572–577
Circle and Ellipse, 565–567
Color class, 546–547
FlowPane, 552–554
Font class, 547–549
GridPane, 555–556
HBox and VBox, 558–560
Image and ImageView Classes, 549–552
key terms, 577
Layout panes, 552
Line, 562–563
nodes, 545–546
panes, 539–540
Polygon and Polyline, 569–572
quiz and exercises, 578–583
Rectangle, 564–565
shapes, 560
structure, 536–539
summary, 577–578
Text, 560–562
vs Swing and AWT, 536
JavaFX CSS, 545
JavaFX UI controls
BounceBallSlider.java, 656
button, 632–634
Invoking methods (continued)
object I/O, 692–693
overview of, 476, 677–678
questions and exercises, 701–704
random-access files, 697–699
reading data from file using Scanner class, 478–480
reading data from Web, 482–484
serializable interface, 695–696
serializing arrays, 696–697
summary, 701
TestDataStream.java, 686–687
TestFileStream.java, 682–683
TestObjectInputStream.java, 694
TestObjectOutputStream.java, 693–694
TestRandomAccessFile.java, 699–700
text I/O vs. binary I/O, 679–680
types of I/O devices, 5–6
writing data to file using PrintWriter class,
476–477
IOException, 681–682
IP (Internet Protocol) addresses
client sockets and, 1141
InetAddress class, 1147–1148
overview of, 1140
IPO (input, process, output), 39
is null operator, in SQL, 1185
Is-a relationships
design guide for when to use interfaces vs. classes, 518
inheritance and, 440
isAbsolute method,File class, 474–475
isDigit method,Character class, 144
isDirectory method,File class, 474–475
isFile method,File class, 474–475
isHidden method,File class, 474–475
Is-kind-of relationships, 518
isPalindrome method
RecursivePalindrome.java, 714–715
as tail-recursive method, 727
isPrime method, prime numbers, 217
ISPs (Internet Service Providers), 1140
isValid method, applying to grid, 300
Iterable interface, 766
Iteration/iterators
advantages and variations of, 953–954
binary search trees and, 952–953
fail-fast, 1128
Iterable interface, 952
Iterator object, 766
lists and, 770–771
loops and, 158
MyArrayList.java example, 901
recursion compared with, 726
TestIterator.java example, 766–767
TestMyArrayList.java example, 905
traversing collections, 766
J
JavaBean, 1217–1220
Java Collections Framework. see Collections 
Framework hierarchy
java command, for executing Java program, 17
Java Database Connectivity. see JDBC (Java Database Connectivity)
```

</details>


## PDF page 1328

<details>
<summary>Page text</summary>

```text
Index  1305
Random class, 335–336
Scanner class, 38, 578–480
jdb debugger, 106
JDBC (Java Database Connectivity)
developing database applications, 1190–1193
overview of, 1189–1190
SimpleJDBC.java, 1193–1194
JDK (Java Development Toolkit)
Fork/Join Framework in JDK 7, 1128–1129
jdb debugger in, 106
overview of, 11–12
join method,Thread class, 1104
Joins
Fork/Join Framework and, 1128
tables, 1188–1189
JSF (JavaServer Faces)
AddressRegistration.xhtml, 1247–1248
AddressRegistrationJSFBean.java, 1249–1252
AddressStoredStatus.xhtml, 1248–1249
binding database with Facelets, 1239–1245
Calculator.xhtml, 1232–1233
CalculatorJSFBean.java, 1231–1232
case study: calculator, 1230–1233
ConfirmAddress.xhtml, 1248
Core Tag Library, 1236
CourseNameJSFBean.java, 1242–1243
creating pages in, 1215–1217
CurrentTime.xhtml, 1220–1222
DisplayStudent.xhtml, 1243–1245
expressions, 1220–1222
GuessNumber.xhtml, 1235
GuessNumberJSFBean.java, 1233–1235
GUI components, 1222–1226
index.xhtml, 1215–1217
introduction to, 1214
managedJavaBean for, 1217–1220
key terms, 1252
opening new pages in, 1245–1261
processing forms, 1226–1230
ProcessStudentRegistrationForm.xhtml, 1228–1230
project development, using NetBeans, 1214
projects, creating steps of, 1214–1215
question and exercises, 1253–1261
RegistrationJSFBean.java, 1226–1228
session tracking, 1233–1235
StudentRegistrationForm.xhtml, 1223–1226
summary, 1206
tablestyle.css, 1245
TimeBean.java, 1218–1220
ValidateForm.xhtml, 1237–1238
ValidateFormJSFBean.java, 1238–1239
validating input, 1235–1239
JVM (Java Virtual Machine)
defined, 16
detecting runtime errors, 450
garbage collection, 256
heap as storage area in, 259
interned string and, 387
K
KBs (kilobytes), 4
Key constants, 604
Keyboards, 5–6
ButtonDemo.java, 633–634
case study: developing tic-tac-toe game, 657–662
case study: national flags and anthems, 665–667
CheckBox, 634–636
CheckBoxDemo.java, 635–636
ComboBox, 644–647
ComboBoxDemo.java, 646–647
DescriptionPane.java, 642–643
Labeled and Label, 630–632
LabelWithGraphic.java, 630–632
ListView, 647–651
ListViewDemo.java, 649–650
MediaDemo.java, 663–665
programming exercises, 668–676
quiz, 668
RadioButton, 637–639
RadioButtonDemo.java, 638–639
ScrollBar, 651–653
ScrollBarDemo.java, 652–653
Slider, 654–657
SliderDemo.java, 655
TextArea, 641–644
TextAreaDemo.java, 644
Textfield, 639–641
TextFieldDemo.java, 639–641
TicTacToe.java, 658–661
video and audio, 662–665
Java language specification, 11–12
Java Library, 334
Java ME (Java Micro Edition), 12
Java programming
creating, compiling, and executing programs, 
15–18
displaying text in message dialog box, 23
high-level languages, 8
introduction to, 11–12
simple examples, 12–15
Java SE (Java Standard Edition), 12
JavaServer Faces. see JSF (JavaServer Faces)
Java Virtual Machine. see JVM (Java Virtual Machine)
javac command, for compiling Java program, 17
Javadoc comments (/**.*/), 18
java.io
File class, 473–475
PrintWriter class, 476–477
RandomAccessFile class, 698
java.lang
Comparable interface, 509
Exception class, 471
Number class, 501
packages, 62
Throwable class, 455–457, 461–462
java.net
MalformedURLException class, 483
URL class, 483
java.util
Arrays class, 270–272
Calandar class, 503–504
creating stacks, 790
Date class, 334–335, 384
EventObject class, 588–589
GregorianCalendar class, 361, 503–504
Java Collections Framework and, 762
```

</details>


## PDF page 1329

<details>
<summary>Page text</summary>

```text
1306 Index
Line
overview, 562
ShowLine.java, 562–563
Line comments, in Welcome.java, 13
Line numbers, in Welcome.java, 12
Linear probing, collision handling, 989–990
Linear search algorithm, 857–858
comparing growth functions, 829–830
recurrence relations and, 829
Linear searches, arrays, 265–266
Linked data structures
binary search trees, 930–931
blocking queues, 1122–1123
hash maps. seeLinkedHashMap class
hash sets. seeLinkedHashSet class
lists. seeLinkedList class
LinkedBlockingQueue class, 1122–1123
LinkedHashMap class
concrete implementation of Map class, 810–812
implementation of Map class, 986
overview of, 813
TestMap.java example, 813–815
types of maps, 810–811
LinkedHashSet class
implementation of Set class, 1002
ordering elements in hash sets, 800
overview of, 802
SetListPerformanceTest.java example, 807
types of sets, 798
LinkedList class
animation of linked lists, 897
compared with ArrayList, 769–770
defined under List interface, 767
Dequeue interface, 783–784
implementing buckets, 993
implementing linked lists, 906–908
implementingMyLinkedList class, 909–916
implementing queues using linked lists. see Queues
MyArrayList compared with MyLinkedList, 918–919
MyLinkedList, 897
MyLinkedList.java example, 908–909, 916–918
representing edges in graphs using linked lists, 1023
SetListPerformanceTest.java example, 807
TestArrayAndLinkedList.java, 770–771
TestMyLinkedList.java example, 909
variations on linked lists, 919–920
Linux OS, 9
List interface
common features of lists defined in, 896–897
methods of, 767–769
overview of, 767
Vector class implementing, 781
ListIterator interface, 768
Lists
adjacency lists for representing edges, 1022
array lists. seeArrayList class
as collection type, 762
comparing performance with sets, 806–808
finding maximum number in, 1132–1133
implementing, 896–897
linked lists. see LinkedList class
List interface, 767
ListViewDemo.java, 649–650
methods of List interface, 767–769
KeyEvents
ControlCircleWithMouseAndKey.java,
605–606
KeyEventDemo.java, 604–605
overview of, 603–604
KeyListener interface, 603
Keys
hashing functions, 986
integrity constraints, 1176–1178
maps and, 1011
keySet method, Map interface, 812
Key/value pairs, in maps, 810–811
Keywords (reserved words)
break and continue, 184–187
case study: counting, 809–810
distinct, 1186–1187
extends, 518
final, 43
list of Java keywords, 1265
super, 416
synchronized, 1111
throw, 158–459
throws, 458
transient, 295
inWelcome.java, 13
Kilobytes (KBs), 4
Knight’s Tour, 733–734, 1058
Koch snowflake fractal, 733
Kruskal’s algorithm, 1090–1091
L
Labeling vertices, 1020
Label, 630–632
Labeled, 630–632
Labels,LabelWithGraphic.java, 630–632
Lambda expression, 597–599
Landis, E. M., 966
Languages
in relational data model, 1174–1175
SQL as database language, 1178
LANs (local area networks), 6
lastIndexOf method
List interface, 767
MyArrayList.java example, 897, 904
MyList.java, 897
strings, 136–137
lastModified method, File class, 174–175
Latin square, 318–319
Layout panes
BorderPane, 556–558
FlowPane, 552–554
GridPane, 555–556
HBox and VBox, 558–560
Left subtree, of binary trees, 930
Left-heavy, balancing A VL nodes, 966
Length, strings, 130–131, 395
length method, File class, 474–475
Less than (<) comparison operator, 1184
Less than or equal to (<=) comparison 
operator, 1184
Letters, counting, 263–264
Libraries, APIs as, 11–12
like operator, in SQL, 1185
```

</details>


## PDF page 1330

<details>
<summary>Page text</summary>

```text
Index  1307
creating arrays, 257
deciding which to use, 174–176
design strategies, 163
do-while loop, 168–170
examples of determining Big O, 824–827
graph edges, 1018
input and output redirections, 167–168
iteration compared with recursion, 726
key terms, 190
for loop, 170–174
minimizing numeric errors related to, 178–179
nesting, 176–177
overview of, 158
quiz and exercises, 191–201
sentinel-controlled, 165–167
summary, 191
while loop, 158–161
Lottery game, 792
Lower-bound wildcards, 748
Low-level languages, 7
LR imbalance, A VL nodes, 967–968
LR rotation
AVLTree class, 973
balancing nodes on a path, 970
options for balancing AVL nodes, 967–968
M
Mac OS, 9
Machine language
bytecode compared with, 16
overview of, 7
translating source program into, 8–9
Machine stacks. see Call stacks
Main class
defined, 323
inTestSimpleCircle.java example, 324
main method
inComputeExpression.java, 114–15
invoking, 207
main class vs., 323
receiving string arguments from command line, 272–273
inSimpleCircle.java example, 326–327
inTestSimpleCircle.java example, 324
inTestTV.java example, 328–329
thread for, 1098
inWelcome.java, 13
inWelcomeWithThreeMessages.java, 14
Maintenance, in software development process, 60
MalformedURLException class, 483
Map interface
methods, 811
overview of, 811
Maps
case study: counting occurrence of words using tree map, 815–816
containers supported by Java Collections Framework, 762
hash maps. seeHashMap class
key terms, 817
linked hash maps. seeLinkedHashMap class
overview of, 797–798, 810–813
quiz and exercises, 818–820
MyAbstractList.java example, 899
MyList.java example, 897–898
singleton and unmodifiable, 816–817
static methods for, 773–777
synchronized collections for, 1127–1128
ListView, 647–651
Literal values, not using as identifiers, 1265
Literals
Boolean literals, 77
character literals, 125
constructing strings from string literal, 386
defined, 48
floating-point literals, 49
integer literals, 49
LL imbalance, A VL nodes, 966–967
LL rotation
AVLTree class, 973–974
balancing nodes on a path, 970
implementing, 971
options for balancing AVL nodes, 966–967
Load factor
hash sets and, 798
rehashing and, 993–995
Loans
Loan calculator case study, in event-driven programming, 600–602
Loan.java object, 368–370
Local area networks (LANs), 6 
Local hosts, IP addresses and, 1141
Local variables, 222
Lock interface, 1112
Locker puzzle, 281
Locks
AccountWithSyncUsingLock.java, 1113–1114
case study: producer/consumer thread cooperation, 1121–1122
deadlocks and, 1126
enforcing cooperation among threads, 1114–1115
semaphores compared with, 1125–1126
thread synchronization using, 1112–1113
ThreadCooperation.java, 1116–1119
Logarithmic algorithm, 828–830
Logic errors (bugs), 21, 106
Logical operators (Boolean operators)
overview of, 93
TestBooleanOperators.java example, 94–96
truth tables, 93–94
Long, numeric types
converting characters and numeric values to strings, 389–390
hash codes for primitive types, 987
integer literals and, 49
java.util.Random, 335–336
overview of numeric types, 45
Loop body, 158
Loop-continuation-condition
do-while loop, 168–169
loop design and, 163
in multiple subtraction quiz, 164
overview of, 158–159
Loops
break and continue keywords as controls in, 184–187
case study: displaying prime numbers, 188–190
case study: finding greatest common denominator, 179–181
case study: guessing numbers, 161–163
case study: multiple subtraction quiz, 164–165
case study: predicting future tuition, 181
```

</details>


## PDF page 1331

<details>
<summary>Page text</summary>

```text
1308 Index
Mersenne prime, 240
MessagePanel class
DisplayClock.java, 573–574
ClockPane.java, 574–576
Metadata retrieval, from databases
database metadata, 1202–1203
obtaining tables, 1204
overview of, 1202
result set metadata, 1204–1205
Meters, converting to/from feet, 236
Method header, 205
Method modifiers, 205, 1270–1271
Method signature, 205
Methods
abstraction and, 225–226
accessing object methods, 330–331
calling, 206–208
case study: converting decimals to hexadecimals, 182–183
case study: generating random numbers, 223–225
case study: generic method for sorting array, 744–745
class, 337–338
Collection interface, 764
commenting, 18
Comparator interface, 772
defining, 204–206
deprecated methods of Thread class, 1103
generic, 742–744
identifiers, 39–40
implementation details, 229–232
invoking, 206–208, 331, 743
key terms, 232
modularizing code, 215–217
naming conventions, 44
object actions defined by, 322–323
overloading, 219–222
overriding, 970
overview of, 203–204
passing arrays to, 257–260
passing objects to, 347–351
passing parameters by values, 212–215
passing to two-dimensional arrays, 293–294
quiz and exercises, 234–244
recursive methods, 706
returning arrays from, 260–261
rounding, 121
static. see Static methods
stepwise refinement, 225–226, 232
summary, 233
synchronization wrapper methods, 1127
thread coordination, 1118–1119
top-down and/or bottom-up implementation, 227–229
top-down design, 226–227
tracing or stepping over as debugging technique, 106
trigonometric, 120–121
variable scope and, 222–223
void method example, 209–211
MHz (Megahertz), clock speed, 3
Microsoft Access. see Access
Microsoft Windows, 9
Million bits per second (Mbps), 6
min method
finding minimum element in lists, 776
Math class, 122
Maps (continued)
singleton and unmodifiable, 816–817
summary, 817–818
synchronized collections for, 1127–1128
TestMap.java example, 813–814
tree maps. seeTreeMap class
Maps, implementing with hashing
MyHashMap.java example, 997–1002
MyMap.java example, 996–997
overview of, 995–996
TestMyHashMap.java, 1002–1003
Marker interfaces, 513
Match braces, in Welcome.java, 13
matches method, strings, 342
Math class
BigInteger and BigDecimal classes, 384–385
complex numbers, 531–532
exponent methods, 121
invoking object methods, 331
methods generally, 120
pow(a, b) method, 48
random method, 87–88, 98–99, 122
rounding methods, 121–122
service methods, 122
trigonometric methods, 120–121
Matrices
adjacency matrices for representing edges, 1021–1022
case study: designing class for matrix using generic types, 752–753
GenericMatrix.java example, 753–755
IntegerMatrix.java example, 755
RationalMatrix.java example, 755–756
TestIntegerMatrix.java example, 756
TestRationalMatrix.java example, 756–757
two-dimensional arrays for storing, 288–289
max method
defining and invoking, 206–208
finding maximum element in lists, 776
finding maximum number in lists, 1132–1133
GeometricObjectComparator.java example, 773
MaxUsingGenericType.java example, 746–747
overloading, 220
overview of, 122
ParallelMax.java, 1132–1133
maxRow variable, for finding largest sum, 292
Mbps (million bits per second), 6
MBs (megabytes), of storage, 4
Media, 662–665
MediaPlayer, 662–665
MediaView, 662–665
Megabytes (MBs), of storage, 4
Megahertz (MHz), clock speed, 3
Memory, computers, 3–4
Merge sorts
CreateFile.java example of external sort, 884
heap sort compared with, 880
merge sort algorithms, 867
MergeSort.java example, 867–869
overview of, 866
ParallelMergeSort.java, 1130–1132
quick sorts compared with, 874
recurrence relations and, 829
time complexity of, 870
mergeSort method, 868–869
```

</details>


## PDF page 1332

<details>
<summary>Page text</summary>

```text
Index  1309
Multi-way if-else statements
in computing taxes, 90–93
overview of, 81–83
Mutator methods. see Setter (mutator) methods
MySQL
creating databases, 1180–1181
creating tables, 1181–1182
creating user account in, 1179–1180
JDBC drivers for accessing Oracle databases, 
1189–1192
stopping/starting, 1180
tutorials on, 1178
N
Named constants. see Constants
Naming conventions
class design guidelines, 526
interfaces, 518
programming and, 44
SQL tables, 1181
wrapper classes, 380
Naming rules, identifiers, 39–40
NavigableMap interface, 813
N-by-n matrix, 238
Negative angles, drawing arcs, 569
Neighbors
depth-first searches (DFS), 1038
vertices, 1018, 1022–1023
Nested classes. see Inner (nested) classes
Nestedif statements
in computing body mass index, 89–90
in computing taxes, 90–93
overview of, 81
Nested loops, 176–177, 291, 824–825
NetBeans
built in debugging, 106
for creating/editing Java source code, 15
for developing JSF applications, 1214
Network interface cards (NICs), 6
Networking
case study: distributed tic-tac-toe games, 
1156–1157
client sockets, 1141–1142
client.java, 1145–1147
client/server computing, 1140
client/server example, 1143
data transmission through sockets, 1142
InetAddress class, 1147–1148
multiple clients connected to single server, 
1148–1151
overview of, 1139–1140
quiz and exercises, 1168–1171
sending and receiving objects, 1151–1156
server sockets, 1140–1141
server.java, 1143–1144
summary, 1168
TicTacToeClient.java, 1162–1168
TicTacToeConstants.java, 1157
TicTacToeServer.java, 1157–1162
new operator
creating arrays, 246–247
creating objects, 329
next method, whitespace characters and, 133
nextLine method, whitespace characters and, 133
Minimum spanning trees (MSTs)
MST algorithm, 1075–1076
overview of, 1072
Prim’s minimum spanning tree algorithm, 1073–1075
TestMinimumSpanningTree.java, 1076–1078
weighted graphs and, 1062
WeightedGraph class, 1067–1069
Mnemonics, in assembly language, 7
Modeling, graphs and, 1024–1028
Model-View-Controller (MVC) architecture, 1217
Modems (modulator/demodulator), 6
Modifier keys, on keyboards, 5
Modifiers
list of, 1270–1271
method modifier, 205
Modularizing code
GreatestCommonDivisorMethod.java, 215–216
overview of, 215
PrimeNumberMethod.java, 216–217
Monitors (displays), 6
Monitors/monitoring, threads and, 1118
Motherboard, 3
Mouse, as I/O device, 6
MouseEvents
ControlCircleWithMouseAndKey.java, 605–606
event-driven programming, 602–603
MouseEvent, 602–603
MST algorithm, 1075–1076
MST class, 1075–1076
MSTs. see Minimum spanning trees (MSTs)
Multi-dimensional arrays. see Arrays, multi-dimensional
Multimedia. see JavaFX UI controls
Multiple choice test, 294–296
Multiplication (*=) assignment operator, 54
Multiplication operator (*), 15, 46, 50
Multiplication table, 176
Multiplicities, in object composition, 373
Multiprocessing, 10
Multiprogramming, 10
Multithreading, 10
blocking queues, 1122–1124
case study: clock with audio, 1139–1142
case study: flashing text, 1105–1106
case study: producer/consumer, 1119–1122
cooperation among threads, 114–1119
creating tasks and threads, 1098–1099
deadlocks and, 1126
key terms, 1133
MultiThreadServer.java, 1149–1151
overview of, 1097–1098
quiz and exercises, 1134–1138
semaphores, 1124–1126
servers serving multiple clients, 1149
summary, 1133–1134
synchronization using locks, 1112–1114
synchronized collections, 1127–1128
synchronized keyword, 1111
synchronizing statements, 1111–1112
TaskThreadDemo.java, 1100–1101
Thread class, 1102–1104
thread concepts, 1198
thread pools, 1106–1108
thread states, 1126–1127
thread synchronization, 1108–1111
```

</details>


## PDF page 1333

<details>
<summary>Page text</summary>

```text
1310 Index
O
Object class, 422–423, 431–432
Object I/O. seeObjectInputStream/ObjectOutputStream classes
Object member access operator (.), 330, 429
Object reference variables, 330
ObjectInputStream/ObjectOutputStream classes
overview of, 692–693
serializable interface, 695–696
Serializing arrays, 696–697
TestObjectInputStream.java, 694
TestObjectOutputStream.java, 693–694
Object-oriented programming (OOP), 322, 330, 370–373
Objects
accessing data and methods of, 330–331
accessing via reference variables, 330
array of, 351–352
ArrayList class, 432–433
arrays as, 259
automatic conversion between primitive types and wrapper class 
types, 383–384
BigInteger and BigDecimal classes, 384–385
cannot be created from abstract classes, 500
case study: designing class for stacks, 378–380
case study: designing Course class, 376–377
casting, 427–428
CircleWithPrivateDataFields.java example, 345–346
CircleWithStaticMembers.java example, 338–339
class abstraction and encapsulation, 366–367
class design guidelines, 525–527
classes from Java Library, 334
comparing primitive variables with reference variables, 332–334
composing, 374–375
constructors, 329
creating, 324–325
data field encapsulation for maintaining classes, 344–345
Date class, 334–335
defining classes for, 322–324
edges defined as, 1021
equals method of Object class, 431–432
event listener object, 589
event objects, 588
immutable, 353–354
inheritance. see inheritance
key terms, 358, 399
Loan.java, 368–370
null values, 331–332
Object class, 422–423
object-oriented thinking, 370–373 
overview of, 321–322, 365–366
passing to methods, 347–351
polymorphism, 123
processing primitive data type values as, 380–383
quiz and exercises, 359–364, 399–408
Random class, 355–356
reference data fields and, 331
representing edges, 1021
runnable objects, 1098
sending and receiving over network, 1151–1156
SimpleCircle.java example, 324–325
static variables, constants, and methods and, 337–338
summary, 359, 398–399
TestCircleWithPrivateDataFields.java example, 346–347
TestCircleWithStaticMembers.java example, 339–342
Next-line style, block styles, 19
NICs (network interface cards), 6
Nine tails problem
graphic approach to, 1048–1053
reducing to shortest path problem, 1086–1090
No-arg constructors
class design guidelines, 526
Loan class, 368
wrapper classes not having, 381
Node, 536–539
Nodes, A VL trees
balancing on a path, 970–971
creating, 973
creating and storing in AVLTreeNode, 969–970
deleting elements, 972
rotation, 973–974
Nodes, binary trees
deleting leaf node, 944–945
overview of, 930
representing binary search trees, 931
Nodes,JavaFX, 545–546
Nodes, linked lists
creating, 910
deleting, 914–916
overview of, 906–908
storing elements in, 911
Nonleaves, finding, 960
Not (!) logical operator, 93–97
Not equal to (!=) comparison operator, 76
NotSerializableException, 695
null values, objects, 331–332
NullPointerException, as runtime error, 332
Number class
case study: abstract number class, 501
as root class for numeric wrapper classes, 585
Numbers/numeric types
abstract number class, 501–503
binary. see Binary numbers
case study: converting hexadecimals to decimals, 217–219
case study: displaying prime numbers, 188–190
case study: generating random numbers, 223–225
case study: guessing numbers, 161–163
casting to/from char types, 127
conversion between numeric types, 56–58, 364
converting to/from strings, 389–390
decimal. see Decimal numbers
double. seedouble
floating-point. see Floating-point numbers 
(float data type)
generating random numbers, 87–88
GreatestCommonDivisorMethod.java, 215–216
hexadecimal. see Hexadecimal numbers
integers. see Integers (int data type)
LargestNumbers.java, 502–503
overview of, 44–46
PrimeNumberMethod.java, 216–217
processing large numbers, 384–385
types of number systems, 1273
Numerators, in rational numbers, 520
Numeric keypads, on keyboards, 5
Numeric literals, 48–49
Numeric operators
applied to characters, 127
overview of, 46–47
```

</details>


## PDF page 1334

<details>
<summary>Page text</summary>

```text
Index  1311
Overflows
Rational class, 524
variables, 45
Overloading methods, 219–222
Overriding methods, 419–422, 970
P
p (pi), estimating, 237
Package-private (package-access) visibility modifiers, 342
Packages
organizing classes in, 343
organizing programs in, 18
Packet-based communication, Java supporting, 1140
Page Down key, on keyboards, 5
Page Up key, on keyboards, 5
Pair of points, algorithm for finding closest, 843–846
Palindromes
case study: checking if string is a palindrome, 187–188
case study: ignoring nonalphanumeric characters when checking
palindromes, 396–398
palindrome integers, 234
palindromic primes, 240
RecursivePalindrome.java, 714–715
RecursivePalindromeUsingSubstring.java, 713–714
Panels
ButtonInPane.java, 540
MessagePanel class. seeMessagePanel class
Parallel edges, 1018
Parallel programming. see also Multithreading
overview of, 1128–1129
ParallelMax.java, 1132–1133
ParallelMergeSort.java, 1130–1132
Parameters
actual parameters, 205
defining methods and, 204–205
generic classes, 742
generic methods, 744
generic parameters not allowed in static context, 751–752
as local variable, 222
order association, 212
passing by values, 212–215
variable-length argument lists, 264–265
Parent, 539
Parentheses (( ))
defining and invoking methods and, 225
inWelcome.java, 14
Parsing methods, 382
Pascal, high-level languages, 8
Pass-by-sharing
arrays to methods, 258
objects to methods, 348–349
Pass-by-value
arrays to methods, 258
Increment.java example, 212–213
objects to methods, 347–348
overview of, 212
TestPassByValue.java example, 213–215
PaswordField, 641
PathTransition, 609–612
Passwords, checking if string is valid password, 238
Pentagonal numbers, 234
Perfect hash function, 986
TestLoanClass.java, 367–368
TestSimpleCircle.java example, 324–326
TestTV.java example, 328–329
this reference and, 356–358
TotalArea.java example, 352–353
TV.java example, 327–328
variable scope and, 355–356
vertices as object of any type, 1019
visibility modifiers, 342–344
Octal integer literals, 49
Off-by-one errors
arrays and, 251
in loops, 160
OOP (object-oriented programming), 322, 330, 370–373
Open addressing, hashing
collision handling using, 989
double hashing, 991–993
linear probing, 989–990
quadratic probing, 990–991
Operands
defined, 46
incompatible, 95
Operators
assignment operator (=), 41–43
augmented assignment operators, 54–55
bit operators, 1277
comparison operators, 76
increment and decrement operators, 55–56
numeric operators, 46–47
precedence and associativity, 104–106
precedence and associativity chart, 1268–1269
precedence rules, 50–51
processing, 786
SQL arithmetic operators, 1186
SQL comparison or Boolean operators, 1184
SQLlike,between-between-and, and is null operators, 1185
unary and binary, 47
Option buttons. See Radio buttons
Or (||) logical operator, 93–97
Oracle
JDBC drivers for accessing Oracle databases, 1189–1192
tutorials on, 1178
order by clause, displaying sorted tuples, 1187–1188
OSs (operating systems)
overview of, 9
tasks of, 9–10
Output. see also I/O (input/output)
redirection, 167–168
streams, 678–679
OutputStream classes
BufferedOutputStream, 688–690
case study: copying files, 691–692
data transmission through sockets, 1142
DataOutputStream, 684–686
DetectEndOfFile.java, 687
FileOutputStream, 681–682
FilterOutputStream, 684
ObjectOutputStream, 692–693, 1151
overview of, 680–681
serialization and, 695
TestDataStream.java, 686–687
TestFileStream.java, 682–683
TestObjectOutputStream.java, 693–694
```

</details>


## PDF page 1335

<details>
<summary>Page text</summary>

```text
1312 Index
Priority queues
implementing, 924
MyPriorityQueue.java example, 924
overview of, 783
PriorityQueue class, 784–785
for storing weighted edges, 1063
TestPriorityQueue.java example, 924–925
PriorityBlockingQueue class, 1122–1123
PriorityQueue class, 784–785
private
encapsulation of data fields and, 344–345
visibility modifier, 343–344, 440–443
Problems
breaking into subproblems, 190
creating programs to address, 34
solving with recursion, 712–713
Procedural paradigm, compared with object-oriented paradigm, 
372–373
Procedures, 205. see also Methods
Processing arrays, 249–251
Programming errors. see also Exception handling
ClassCastException, 428
debugging, 106
logic errors, 21–23
minimizing numeric errors related to loops, 178–179
runtime errors, 20–21
selections, 83–87
syntax errors, 14, 20
using generic classes for detecting, 738–739
Programming languages
assembly language, 7
high-level languages, 8–9
Java. see Java programming
machine language, 7
overview of, 2
Programming style
block styles, 19
comments and, 19
indentation and spacing, 19
overview of, 18–19
Programs/programming
assignment statements and expressions, 41–43
augmented assignment operators, 54–55
case study: counting monetary units, 63–65
case study: displaying current time, 52–53
character data type, 125–130
coding incrementally, 161
databases. see Java database programming
evaluating expressions and operator precedence rules, 
50–51
exponent operations, 48
identifiers, 39–40
increment and decrement operators, 55–56
introduction to, 34
with Java language. see Java programming
key terms, 67
modularizing code, 215–217
named constants, 43
naming conventions, 44
numeric literals, 48–50
numeric operators, 46–47
numeric type conversions, 56–58
numeric types, 44–45
Perfectly balanced trees, 966
Pivot element, 870
Pixels (picture elements)
measuring resolution in, 6
Points, 849
algorithm for finding closest pair of, 843–846
finding convex hull for a set of points, 849
Polygon and Polyline
overview, 569
ShowPolygon.java, 570–571
Polymorphism
CastingDemo.java example, 428–431
overview of, 423
PolymorphismDemo.java example, 423
Polynomial hash codes, 988
Postfix decrement operator, 55–56
Postfix increment operator, 55–56
Postorder traversal
time complexity of, 948
tree traversal, 933
pow method,Math class, 48
Precedence, operator, 104–106, 1268–1270
Prefix decrement operator, 55–56
Prefix increment operator, 55–56
Prefix notation, 794
Preorder traversal
time complexity of, 948
tree traversal, 933
PreparedStatement, for creating parameterized SQL statements, 
1197–1199
Primary key constraints, integrity constraints in relational model, 
1176–1178
Prime numbers
algorithm for finding, 837
case study: displaying prime numbers, 188–190
comparing prime number algorithms, 843
EfficientPrimeNumbers.java example, 839–842
PrimeNumberMethod.java, 216–217
PrimeNumbers.java example, 838–839
SieveOfEratosthenes.java example, 842–843
types of, 240
Primitive types (fundamental types)
automatic conversion between primitive types and wrapper class 
types, 383–384, 739
casting, 429
comparing parameters of primitive type with parameters of reference 
types, 349
comparing primitive variables with reference variables, 332–334
converting wrapper object to/from (boxing/unboxing), 383
creating arrays of, 351
hash codes for, 987
Prim’s minimum spanning tree algorithm
Dijkstra’s algorithm compared to, 1078
overview of, 1073–1075
print method,PrintWriter class, 38, 476–477, 744–745
printf method,PrintWriter class, 476
Printing arrays, 291
println method,PrintWriter class, 38, 476
printStackTrace method, 461
PrintWriter class
case study: replacing text, 480–482
writing data to file using, 476–477
for writing text data, 678
```

</details>


## PDF page 1336

<details>
<summary>Page text</summary>

```text
Index  1313
random method
case study: generating random numbers, 223–225
case study: lottery, 98–99
Math class, 87–88, 122
Random numbers
case study: generating random numbers, 223–225
case study: lottery, 98–99
generating, 87–88
Random-access files
overview of, 697–699
TestRandomAccessFile.java, 699–700
Random-access memory (RAM), 4–5
Rational class
case study: designing class for matrix using generic types, 752–753
overview of, 520–521
Rational.java example, 522–525
RationalMatrix.java example, 755–756
TestRationalClass.java example, 521–522
TestRationalMatrix.java example, 756–757
Rational numbers, representing and processing, 520–522
Raw types, backward compatiblity and, 746–747
readASolution method, applying to Sudoku grid, 300
Read-only streams, 697. see alsoInputStream class
Read-only views, Collections class, 816
Rebalancing A VL trees, 966–968
Records
insert, update, and delete, 1182–1183
relational structures, 1175
Rectangle
overview, 564
ShowRectangle.java, 564–565
Recurrence relations, in analysis of algorithm complexity, 829
Recursion
binary searches, 716–717
case study: computing factorials, 706–707
case study: computing Fibonacci numbers, 709–710
case study: determining directory size, 717
case study: fractals, 722–723
case study: Towers of Hanoi, 719–721
ComputeFactorial.java, 707–709
ComputeFactorialTailRecursion.java, 727–728
ComputeFibonacci.java, 710–712
depth-first searches (DFS), 1038–1039
DirectorySize.java, 717–719
displaying/visualizing binary trees, 949
Fork/Join Framework and, 1128
helper methods, 714
iteration compared with, 726–727
key terms, 728
overview of, 706
problem solving by thinking recursively, 712–713
questions and exercises, 728–736
RecursivePalindrome.java, 714–715
RecursivePalindromeUsingSubstring.java, 713–714
RecursiveSelectionSort.java, 715–716
selection sorts, 715
SierpinskiTriangle.java, 723–724
summary, 728
tail recursion, 727
TowersOfHanoi.java, 721–722
Recursive methods, 706
Red-black trees, 986, 1002
Reduction, characteristics of recursion, 712
overview of, 2
questions and exercises, 68–74
reading input from console, 37–39
recursive methods in, 706
software development process, 59–63
string data type, 130–139
summary, 67–68
variables, 40–41
writing a simple program, 34–37
protected
data and methods, 440–442
visibility modifier, 343–344, 440–442
Protected data fields, in abstract classes, 899
Pseudocode, 34
Public classes, 325
public method, 346
public visibility modifier, 342–344, 440–442
Python, high-level languages, 8
Q
Quadratic algorithm, 825, 829–830
Quadratic probing, collision handling, 990–991
Queries, SQL, 1183–1184
Query methods, Map interface, 811
Query operations, Collection interface, 764
Queue interface, 783, 1123
Queues
blocking queues. see Blocking queues
breadth-first search algorithm, 1045
bucket sorts and, 882–883
as collection type, 762
Deque interface, 783–786
GenericQueue.java example, 922–923
implementing, 920–921
overview of, 782
priority queues. see Priority queues
Queue interface, 783, 1123
TestStackQueue.java example, 922–923
unbounded, 1122
WeightedGraph class, 1067–1068
Quick sorts
merge sorts compared with, 874
overview of, 870
quick sort algorithm, 870–871
QuickSort.java example, 871–874
Quincunx, 280
Quotients
Quotient.java example, 450
QuotientWithException.java example, 452–454
QuotientWithIf.java example, 451
QuotientWithMethod.java example, 451–452
R
Race conditions, in multithreaded programs, 1111
Radio buttons
creating, 1222–1226
RadioButtonDemo.java, 638–639
Radix sorts, 881–883
Ragged arrays, 290–291, 1022
RAM (random-access memory), 4–5
Random class,java.util, 335–336
```

</details>


## PDF page 1337

<details>
<summary>Page text</summary>

```text
1314 Index
Right subtree, of binary trees, 930
Right-heavy, balancing A VL nodes, 966
RL imbalance, A VL nodes, 967–968
RL rotation
AVLTree class, 972–973
balancing nodes on a path, 970
options for balancing AVL nodes, 967–968
Root, of binary trees, 930–931
Rotation
AVLTree class, 972–973
balancing nodes on a path, 970–971
implementing, 971
methods for performing, 977
options for balancing AVL nodes, 966–967
Rounding methods, Math class, 122
Round-robin scheduling, of CPU time, 1104
Rows. see Tuples (rows)
RR imbalance, A VL nodes, 966–967
RR rotation
AVLTree class, 974, 975
balancing nodes on a path, 970
options for balancing AVL nodes, 966–967
run method, for running threads, 1100, 1101
Runnable interface
tasks as instances of, 1098–1099
Thread class, 1102
Runtime errors
debugging, 106
declaring, 457–458
exception handling and, 39, 450
NullPointerException as, 332
programming errors, 21
Runtime stacks. see Call stacks
S
Scanner class
obtaining input with, 67
for reading console input, 37–39
reading data from file using, 478–479
for reading text data, 678
Scanners
case study: replacing text, 480–481
creating, 454
Scene, 536–539
Scheduling operations, 10
Scientific notation, of integer literals, 49–50
Scope, of variables, 42, 222–223
Screen resolution, 6
Script, for creating MySQL database, 1180–1181
Scroll bars
overview of, 651
ScrollBarDemo.java, 652–653
Scroll panes
DescriptionPanel.java, 643
overview of, 641
scrolling lists, 648
search method,AVLTree class, 981
Searches
arrays, 265
binary search trees. see Binary search trees
binary searches, 266–269, 716–717
linear searches, 265–266
Reference types
classes as, 330
comparing parameters of primitive type with parameters of reference 
types, 349
comparing primitive variables with, 332–334
generic types as, 738
reference data fields, 331–332
string data type as, 130
Reference variables
accessing objects with, 330
array of objects as array of, 352
comparing primitive variables with, 332–334
regionMatches method, strings, 134–135
Register listeners
ControlCircle.java, 592–593
ControlCircleWithMouseAndKey.java, 605–606
KeyEventDemo.java, 604
LoanCalculator.java, 600
overview of, 589–590
Regular expressions, matching strings with, 388
Rehashing
load factor and, 993–995
time complexity of hashing methods and, 1002
Relational DBMS
foreign keys in, 1177
integrity constraints, 1176–1178
overview of, 1174–1175
relational structures, 1175–1176
Relational model, 1175
Relational structures, 1175–1176
Relations, 1175
Relative file names, 473–474
Remainder (%) or modulo operator, 46, 50
Remainder (%=) assignment operator, 54–55
remove method, linked lists, 906–907
Repetition
determining Big O for repetition statements, 824–827
loops. see Loops
replace method, strings, 388
replaceAll method, strings, 388
replaceFirst method, strings, 388
Request-scoped bean, 1233
Requirements specification, in software development process, 59–60
Reserved words. see Keywords (reserved words)
Resource ordering, to avoid deadlocks, 1126
Resources, role of OSs in allocating, 9
Responsibilities, separation as class design principle, 526
Result set metadata, 1205
ResultSetMetaData interface
overview of, 1205
TestResultSetMetaData.java, 1205–106
return statements, 207
Return value type
constructors not having, 329
in defining methods, 205
Reusable code
benefits of stepwise refinement, 232
code modularization and, 215
method enabling, 208
methods for, 204
reverse method
applying to lists, 774
returning arrays from methods, 260–261
```

</details>


## PDF page 1338

<details>
<summary>Page text</summary>

```text
Index  1315
setPriority method,Thread class, 1104
setRadius method
CircleWithPrivateDataFields.java example, 346
SimpleCircle example, 325
Sets
case study: counting keywords, 809–810
as collection type, 762
comparing list performance with, 806–808
HashSet class, 798–799
key terms, 817
LinkedHashSet class, 802
overview of, 798
questions and exercises, 818–820
singleton and unmodifiable, 8816–817
summary, 817–818
synchronized collections for, 1127–1128
TestHashSet.java example, 799–800
TestMethodsInCollection.java example, 800–801
TestTreeSet.java example, 803–804
TestTreeSetWithComparator.java example, 804–806
TreeSet class, 802–803
Sets, implementing with hashing
MyHashSet.java example, 1005–1010
MySet.java example, 1004–1005
overview of, 1004
TestMyHashSet.java example, 1010–1011
Setter (mutator) methods
ArrayList class and, 436
encapsulation of data fields and, 344–347
implementing linked lists, 906–907
Seven Bridges of Königsberg problem, 1016–1017
Shallow copies, clone method and, 515–516
Shapes, 539–542
Arc, 567–569
Circle and Ellipse, 565–567
Line, 562–563
Polygon and Polyline, 569–572
Rectangle, 564–565
text, 560–562
Sharing code, 208
short, numeric types
hash codes for primitive types, 987
overview of, 45
Short-circuited OR operator, 96
Shortest path tree, 1082
Shortest paths
case study: weighted nine tails problem, 1086–1090
Dijkstra’s algorithm, 1079–1084
finding with graph, 117
nine tails problem, 1048–1053
overview of, 1078–1079
TestShortestPath.java, 1084–1086
WeightedGraph class and, 1069
ShortestPathTree class, 1082–1084
Shuffling arrays, 250–251, 292
Sierpinski triangle
case study, 722–723
computing recursively, 729, 735–736
SierpinskiTriangle.java, 723–726
Sieve of Eratosthenes, 842–843
Simple graphs, 1017
sin method, trigonometry, 120–121
Single precision numbers. see Floating-point numbers (float data type)
recursive approach to searching for words, 706
search keys, 986, 1011
Secondary clustering, quadratic probing issue, 991
Segments, merging, 886–887
select statements
column aliases and, 1185–1186
queries with, 1183–1184
Selection sort algorithm
analyzing, 828
recurrence relations and, 829
Selection sorts
arrays, 265, 269–270
RecursiveSelectionSort.java, 715–716
using recursion, 715
Selection statements, 76, 78, 724–727
Selections
Addition.Quiz.java example, 77–78
boolean data type, 76–78
case study: computing Body Mass Index, 89–90
case study: computing taxes, 90–93
case study: determining leap year, 97
case study: guessing birthdays, 139–142
case study: lottery, 98–99
common errors, 83–84
conditional expressions, 103–104
debugging, 106
formatting console output, 145–146
generating random numbers, 87–88
if statements, 78–79
if-else statements, 80–81
key terms, 107
logical operators, 93–97
nestedif statements and multi-way if-else statements, 81–83
operator precedence and associativity, 104–106
overview of, 76
questions and exercises, 108–118
summary and exercises, 107
switch statements, 100–103
Semaphores, controlling thread access to shared resources, 1124–1126
Semicolons (;), common errors, 83
Sentinel-controlled loops, 165–167
Separate chaining
handling collision in hashing, 993
implementing map using hashing, 995–996
Sequence statements, determining Big O for, 824–827
Sequential files, input/output streams, 697
Serialization
of arrays, 696–697
of objects, 695
Student.java example, 1152
Servers
client/server example, 1143
multiple clients connected to single server, 1148–1151
server sockets, 1140–1141
server.java, 1143–1144
StudentServer.java, 1154–1156
TicTacToeServer.java, 1157–1162
ServerSocket class, 1140
Session-scoped bean, 1233, 1252
Session tracking, 1233–1235
set method,List interface, 768
Set operations, Collection interface, 764
setLength method,StringBuilder class, 395–396
```

</details>


## PDF page 1339

<details>
<summary>Page text</summary>

```text
1316 Index
Specific import, 18
split method, strings, 388, 389
SQL (Structured Query Language)
CallableStatement for executing SQL stored procedures, 
1199–1202
column aliases, 1185–1186
creating databases, 1180–1181
creating tables, 1181–1182
creating user account in MySQL, 1179–1180
for defining and accessing databases, 1174
insert, update, and delete statements, 1182–1183
JDBC and, 1190–1194
operators, 1184–1186
overview of, 1178
PreparedStatement for creating parameterized SQL statements, 
1197–1198
queries, 1183–1184
table joins, 1188–1189
tuples, 1187–1188
Stack class, 782
StackOfIntegers class, 378–379
StackOverflowError, recursion causing, 726
Stacks
case study: designing class for stacks, 378–379
case study: evaluating expressions, 786–787
EvaluateExpression.java example, 788–790
GenericStack class, 741–742
implementing, 820–821
Stack class, 782
TestStackQueue.java example, 922–923
Stage , 536, 539
start method, for starting threads, 1099, 1101
Starvation, thread priorities and, 1104
State
of objects, 322–323
of threads, 1126–1127
Statements
break statements, 101
continue statements, 184–185
executing one at a time, 106
executing repeatedly (loops), 158
in high-level languages, 7
if. seeif statements
if-else. seeif-else statements
return statements, 206
switch statements, 100–101
synchronizing, 1111–1112
terminators, 13
Statements, SQL
auto commit and, 1194
CallableStatementfor executing SQL stored procedures, 1199–1200
create table statement, 1181
drop table statement, 1182
insert, update, and delete, 1182–1183
PreparedStatement for creating parameterized SQL statements,
1103–1104
select statements, 1183–1185
Static methods
inCircleWithStaticMembers.java, 338–339
class design guidelines, 526–527
declaring, 338
defined, 338
for lists and collections, 773
Single-dimensional arrays. see Arrays, single-dimensional
Single-source shortest path algorithm, Dijkstra’s, 1079–1084
Singly linked lists. seeLinkedList class
Sinking sorts, 280, 864–866
sleep method,Thread class, 1103
Sliders
overview of, 654
SliderDemo.java, 655–656
Sockets
client sockets, 1141–1142
data transmission through, 1142
overview of, 1140
server sockets, 1140–1141
inServer.java example, 1143–1144
Software
development process, 59–61
programs as, 2
sort method
Arrays class, 270–271
ComparableRectangle.java example, 511–512
lists and, 773–774
SortRectangles.java example, 512–513
using recursion, 715–716
SortedMap interface, 812, 813
Sorting
adding nodes to heaps, 875–876
arrays using heaps, 879
bubble sort algorithm, 962–963
bucket sorts and radix sorts, 881–882
complexity of external sorts, 889–890
complexity of heap sorts, 879–880
CreateFile.java example of external sort, 883–885
external sorts, 883
Heap class and, 878–879
heap sort algorithm, 874–875
Heap.java example, 878–879
HeapSort.java example, 879–880
implementation phases of external sorts, 884–885
key terms, 890
merge sort algorithm, 867–870
overview of, 862
questions and exercises, 891–894
quick sort algorithm, 870–874
removing root from heap, 876–877
storing heaps, 875
summary, 890
Sorting arrays
bubble sorts, 279
case study: generic method for, 744–745
insertion sorts, 862–864
overview of, 269
selection sorts, 265, 269–270
Source objects, event sources and, 588–589
Source program or source code, 7, 39–40
Spacing, programming style and, 18
Spanning trees
graphs, 1018
minimum spanning trees, 1072–1073
MST algorithm, 1075–1076
Prim’s minimum spanning tree algorithm, 1073–1075
TestMinimumSpanningTree.java, 1076–1078
traversing graphs and, 1037–1038
Special characters, 14
```

</details>


## PDF page 1340

<details>
<summary>Page text</summary>

```text
Index  1317
Structure, in relational data model, 1174–1175
Structured Query Language. see SQL (Structured Query Language)
Subclasses
abstract methods and, 496
abstracting, 500
constructors, 416–417
of Exception class, 456–457
inheritance and, 410–411
ofRuntimeException class, 457
Subdirectories, 717
Subgraphs, 1018
Subinterfaces, 518
substring method, 135, 714
Substrings, 135–136
Subtraction (-) operator, 46, 50
Subtraction (-=) assignment operator, 54–55
Subtrees
of binary trees, 930
searching for elements in BST, 932
Sudoku puzzle, 298–301, 859–860, 1137–1138
sum method, 293–294
super keyword, 416
Superclass methods, 418–419
Superclasses
of abstract class can be concrete, 500
classes extending, 517
inheritance and, 410–411
subclasses related to, 496
Superkey attribute, primary key constraints and, 1177
Supplementary characters, Unicode, 125
swap method
swapping elements in an array, 259–260
inTestPassByValue.java example, 213–214
switch statements
ChineseZodiac.java example, 102–103
overview of, 100–101
Synchronization wrapper methods, Collections class, 1128
Synchronized blocks, 1112, 1133
Synchronized collections, 1126–1127
synchronized keyword, 1111
Syntax errors (compile errors)
common errors, 14
debugging, 106–107
programming errors, 20–21
Syntax rules, in Welcome.java, 14
System activities, role of OSs, 9
System analysis, in software development process, 59–60
System design, in software development process, 59, 61
System errors, 456
System resources, allocating, 9
System.in, 37
System.out, 37, 145–149
T
Tables
creating, 1181–1182
dropping, 1182
insert, update, and delete records, 1182–1183
integrity constraints, 1176–1178
joins, 1188–1189
obtaining, 1204
queries, 1183–1184
relational structures, 1175
when to use instance methods vs. static, 338–339
wrapper classes and, 382
Static variables
inCircleWithStaticMembers.java, 338–339
class, 337–338
class design guidelines, 526–527
declaring, 338
instance variables compared with, 337
inTestCircleWithStaticMembers.java, 339
when to use instance variables vs. static, 340
Stepwise refinement
benefits of, 232
implementation details, 229–232
method abstraction, 225–226
top-down and/or bottom-up implementation, 227–229
top-down design, 226–227
Storage devices
CDs and DVDs, 5
disks, 5
overview of, 4–5
USB flash drives, 5
Storage units, for measuring memory, 3-
Stored procedures, executing SQL stored procedures, 1199–1202
Stream-based communication, Java supporting, 1140
String class, 386
String concatenation operator (+), 36
String literals, 386
String variables, 386
StringBuffer class, 386, 393, 397
StringBuilder class
case study: ignoring nonalphanumeric characters when checking
palindromes, 396–397
modifying strings in, 393–395
overview of, 338, 393
toString,capacity,length,setLength, and charAt methods,
395–396
Strings
in binary I/O, 684–685
case study: checking if string is a palindrome, 187–188
case study: converting hexadecimals to decimals, 188–189
case study: ignoring nonalphanumeric characters when checking
palindromes, 396–397
Character class, 189–190
command-line arguments, 272–275
concatenating, 36, 130
constructing, 386
converting to/from arrays, 389
finding characters or substrings in, 388–389
formatting, 390–392
generic method for sorting array of Comparable objects,
744–745
hash codes for, 987–988
immutable and interned, 386–387
key terms, 275
matching, replacing, and splitting by patterns, 388–389
overview of, 386
questions and exercises, 276–285
replacing, and splitting, 387
string data type, 130
StringBuilder andStringBuffer classes, 393–396
substrings, 37, 135–136
summary, 275–276
inWelcome.java, 12–13
```

</details>


## PDF page 1341

<details>
<summary>Page text</summary>

```text
1318 Index
Three-dimensional arrays. see Arrays, multi-dimensional
throw keyword
chained exceptions, 470
throw ex for rethrowing exceptions, 469
for throwing exceptions, 459
Throwable class
generic classes not extending, 752
getting information about exceptions, 461–462
java.lang, 455–456
Throwing exceptions
CircleWithException.java example, 463
QuotientWithException.java example, 453
rethrowing, 468–469
TestCircleWithCustomException.java example, 471
throw keyword for, 458–459
throws keyword
for declaring exceptions, 458
IOException, 680–681
Tic-tac-toe game, 308, 1156–1157
TimeBean, 1220
Time sharing, threads sharing CPU time, 1098
Timers, for animation control, 1105–1106
toCharArray method, converting strings into arrays, 389
ToggleButton, 637
ToggleGroup, 637–638
Token reading methods, Scanner class, 479–480
Top-down design, 226–227
Top-down implementation, 227–229
toString method
ArrayList class, 435
Arrays class, 270–271
Date class, 335
MyArrayList.java example, 903
Object class, 431
StringBuilder class, 395–396
total variable, for storing sums, 291
Towers of Hanoi problem
analyzing algorithm for, 828–829
computing recursively, 730
nonrecursive computation, 796
recurrence relations and, 829
Tracing a program, 36
transient keyword, serialization and, 695
Transistors, CPUs, 3
Transmission Control Protocol (TCP), 1140
Traveling salesperson problem (TSP), 1091
Traversing binary search trees, 933–934
Traversing graphs
breadth-first searches (BFS), 1045–1048
case study: connected circles problem, 1042–1045
depth-first searches (DFS), 1038–1042
overview of, 1038
TestWeightedGraph.java, 1071
Tree class
as inner class of AbstractGraph class, 1031
MST class extending, 1075–1076
ShortestPathTree class extending, 1082–1084
traversing graphs and, 1037
Tree interface, BST class, 935–936
Tree traversal, 933–935
TreeMap class
case study: counting occurrence of words, 815–816
concrete implementation of Map class, 810–812
Tables, storing, 288
Tail recursion
ComputeFactorialTailRecusion.java, 727–728
overview of, 727
tanmethod, trigonometry, 120–121
TaskClass, 1100
Tasks
creating, 1098–1099
running multiple. see Multithreading
TaskThreadDemo.java, 1100–1101
threads providing mechanism for running, 1098
TBs (terabytes), of storage, 4
TCP (Transmission Control Protocol), 1140
Teamwork, facilitated by stepwise refinement, 232
Terabytes (TBs), of storage, 4
Testing
benefits of stepwise refinement, 232
in software development process, 60, 62–63
Text
case study: replacing text, 480–481
files, 678
overview, 560
ShowText.java, 561–562
.txt files (text), 680
TextAreaDemo.java, 644
TextFieldDemo.java, 639–641
TextArea, 641–644
TextField, 639–641
Text I/O
vs. binary I/O, 679–680
handling in Java, 678–679
overview of, 678
TextPad, for creating/editing Java source code, 15
this reference
invoking constructors with, 357–358
overview of, 356–358
referencing hidden data fields with, 356–357
Thread class
creating tasks and, 1100
deprecated methods, 1103
methods of, 1103–1104
overview of, 1102
Thread pools, 1106–1108
Thread synchronization
AccountWithoutSync.java, 1109–1111
overview of, 1108–1109
synchronization using locks, 1112–1114
synchronized keyword, 1111
synchronizing statements, 1111–1112
Threads
blocking queues, 1122–1124
case study: producer/consumer thread cooperation, 1119–1122
controlling animation with (flashing text case study), 1105–1106
creating, 1098–1099
deadlocks and, 1126
locks enforcing cooperation among threads, 1114–1115
overview of, 1098
semaphores, 1124–1126
states, 1126–1127
TaskThreadDemo.java, 1100–1102
Thread class, 1102–1104
ThreadCooperation.java, 1116–1119
Thread-safe classes, 1111, 1128
```

</details>


## PDF page 1342

<details>
<summary>Page text</summary>

```text
Index  1319
Underflow, floating point numbers, 66
Undirected graphs, 1017
Unicode
character data type (char) and, 125–129
data input and output streams, 685
generating random numbers and, 223
text encoding, 678
text I/O vs. binary I/O, 679
Unified Modeling Language. see UML (Unified Modeling Language)
Uniform Resource Locators. see URLs (Uniform Resource Locators)
Unique addresses, for each byte of memory, 4
Universal serial bus (USB) flash drives, 5
UNIX epoch, 52
UnknownHostException, local hosts and, 1142
Unweighted graphs
defined, 1018
modeling graphs and, 1024, 1026
UnweightedGraph.java example, 1033–1034
Upcasting objects, 427
Update methods, Map interface, 811
Update statements, SQL, 1182–1183
URL class,java.net, 482
URLs (Uniform Resource Locators)
for connecting JDBC to other databases, 1191
ReadFileFromURL.java example, 483–484
reading data from Web, 482–483
USB (universal serial bus) flash drives, 5
User accounts, MySQL, 1179–1180
User Datagram Protocol (UDP), 1140
UTF-8, 685. see also Unicode
V
valueOf methods
converting strings into arrays, 389
wrapper classes and, 382
Value-returning methods
return statements required by, 207
TestReturnGradeMethod.java, 209–211
void method and, 205
Values
hashing functions, 986
maps and, 1011
values method,Map interface, 811
Variable-length argument lists, 264–265
Variables
Boolean variables. see Boolean variables
comparing primitive variables with reference variables, 
332–334
control variables in for loops, 171–172
declaring, 35–36, 41
declaring array variables, 246
declaring for two-dimensional arrays, 288–289
displaying/modifying, 106
hidden, 355
identifiers, 39–40
naming conventions, 44
overflow, 65
overview of, 40–41
reference variables, 330
scope of, 41, 222–223, 355–356
static variables, 337–338
implementation of Map class, 986
overview of, 813
TestMap.java example, 813–815
types of maps, 810–811
Trees
AVL trees. see AVL trees
binary search. see Binary search trees
connected graphs, 1018
creating BFS trees, 1046
Huffman coding. see Huffman coding trees
overview of, 930
red-black trees, 986, 1002
spanning trees. see Spanning trees
traversing, 933–934
TreeSet class
implementation of Set class, 1002
overview of, 802–803
TestTreeSet.java example, 803–804
TestTreeSetWithComparator.java example, 504–506
types of sets, 798
Trigonometric methods, Math class, 120–121
trimToSize method, 904
True/false (Boolean) values, 76
Truth tables, 93–94
try-catch blocks
catching exceptions, 457, 459–461
chained exceptions, 469–470
CircleWithException.java example, 464–465
exception classes cannot be generic, 752
InputMismatchExceptionDemo.java example, 454
QuotientWithException.java example, 452
rethrowing exceptions, 468–469
when to use exceptions, 467–468
Tuples (rows)
displaying distinct, 1186–1187
displaying sorted, 1187–1188
primary key constraints and, 1176
relational structures, 1175
Twin primes, 240
Two-dimensional arrays. see Arrays, two-dimensional
Type casting
betweenchar and numeric types, 127
generic types and, 740
loss of precision, 65
for numeric type conversion, 56–57
Type erasure, erasing generic types, 750–751
U
UDP (User Datagram Protocol), 1140
UML (Unified Modeling Language)
aggregation shown in, 374
class diagrams with, 323
diagram for Loan class, 367
diagram of StackOfIntegers, 378
diagram of static variables and methods, 337–339
Unary operators, 47
Unbounded queues, 1123
Unbounded wildcards, 748
Unboxing, 383
Unchecked exceptions, 457
Unconditional AND operator, 104
```

</details>


## PDF page 1343

<details>
<summary>Page text</summary>

```text
1320 Index
representing, 1063
shortest paths, 1078
summary, 1090
TestMinimumSpanningTree.java, 1076–1078
TestShortestPath.java, 1084–1086
TestWeightedGraph.java, 1070–1072
weighted adjacency matrices, 1064
weighted edges using edge array, 1063–1064
WeightedGraph class, 1065–1066
WeightedGraph.java, 1066–1070
WeightedEdge class, 1064
WeightedGraph class
getMinimumSpanningTree method, 1075, 1077–1078
overview of, 1097–1098
ShortestPathTree class as inner class of, 1082–1083
TestWeightedGraph.java, 1070–1072
WeightedGraph.java, 1066–1070
Well-balanced trees
AVL trees, 966
binary search trees, 986
whereclause ,select statements, 1183
while loops
case study: guessing numbers, 161–163
case study: multiple subtraction quiz, 164–165
case study: predicting future tuition, 181
deciding when to use, 174–176
design strategies, 163
do-while loop. seedo-while loop
input and output redirections, 167–168
overview of, 158–159
RepeatAdditionQuiz.java example, 160–161
sentinel-controlled, 165–167
servers serving multiple clients, 1149
syntax of, 158
Whitespace
characters, 133
as delimiter in token reading methods, 479
Wildcard import, 38
Wildcards, for specifying range of generic types, 
747–750
Windows. see Frames (windows)
Windows OSs, 9
Wireless networking, 6
Worst-case input
heap sorts and, 880
measuring algorithm efficiency, 822, 836
Wrapper classes
automatic conversion between primitive types and wrapper class 
types, 683–684, 739
File class as, 473
numeric, 521
primitive types and, 380–383
Wrapping lines of text or words, 641, 643
Write-only streams, 697. see alsoOutputStream class
X
Xlint:unchecked error, compile time errors, 746
Vector class
methods, 781–782
overview of, 781
Stack class extending, 782
Vertex-weighted graphs, 1063
Vertical scroll bars, 652
Vertical sliders, 654, 655
Vertices
AbstractGraph class, 1031
adjacent and incident, 1018
depth-first searches (DFS), 1038
Graph.java example, 1028
on graphs, 1017
Prim’s algorithm and, 1072
representing on graphs, 1019–1020
shortest paths. see Shortest paths
TestBFS.java, 1046
TestGraph.java example, 1026
TestMinimumSpanningTree.java, 1076
TestWeightedGraph.java, 1070
vertex-weighted graphs, 1063
weighted adjacency matrices, 1064
WeightedGraph class, 1065–1066
Video, MediaDemo.java, 663–664
View-scoped bean, 1233
Virtual machines (VMs), 16. see also JVM 
(Java Virtual Machine)
Visibility (accessibility) modifiers
classes and, 342–343
protected,public, and private, 440–442
Visual Basic, high-level languages, 8
Visualizing (displaying) graphs
Displayable.java example, 1034
DisplayUSMap.java example, 1035–1037
GraphView.java example, 1035
overview of, 1034
VLSI (very large-scale integration), 706
VMs (virtual machines), 21. see also JVM (Java Virtual Machine)
void method
defined, 205
defining and invoking, 209
TestVoidMethod.java, 209
W
Web, reading file data from, 482–484
Weighted graphs
case study: weighted nine tails problem, 1086–1089
defined, 1017
Dijkstra’s single-source shortest-path algorithm, 1079–1084
key terms, 1090
minimum spanning trees, 1072–1073
modeling graphs and, 1024
MST algorithm, 1075–1076
overview of, 1015–1016
Prim’s minimum spanning tree algorithm, 1073–1075
priority adjacency lists, 1064–1065
questions and exercises, 1090–1096
```

</details>


## PDF page 1344

<details>
<summary>Page text</summary>

```text
Console Input
Scanner input = new Scanner(System.in);
int intValue = input.nextInt();
long longValue = input.nextLong();
double doubleValue = input.nextDouble();
float floatValue = input.nextFloat();
String string = input.next();
String line = input.nextLine();
Console Output
System.out.println(anyValue);
Primitive Data Types
byte 8  bits
short 16 bits
int 32 bits
long 64 bits
float 32 bits
double 64 bits
char 16 bits
boolean true/false
Relational Operators
<     less than
<=    less than or equal to
>     greater than
>=    greater than or equal to
==    equal to
!=    not equal
Logical Operators
&&     short circuit AND
||     short circuit OR
!      NOT
^      exclusive OR 
Arithmetic Operators
+ addition
- subtraction
* multiplication
/ division
% remainder
++var preincrement
--var predecrement
var++ postincrement
var-- postdecrement
switch Statements
switch (intExpression) {
  case value1:
    statements;
break;
  ...
case valuen:
    statements;
break;
  default:
    statements;
}
Companion Web site: www.pearsonhighered.com/liang 
Assignment Operators
= assignment
+= addition assignment
-= subtraction assignment
*= multiplication assignment
/= division assignment
%= remainder assignment 
if Statements
if (condition) {
  statements;
}
if (condition) {
  statements;
}
else {
  statements;
}
if (condition1) { 
  statements;
}
else if (condition2) { 
  statements;
}
else { 
  statements;
}
loop Statements
while (condition) {
  statements;
}
do {
  statements;
} while (condition);
for (init; condition;
  adjustment) {
  statements;
}
Java Quick Reference
Conditional Expression 
boolean-expression ? expression1 :
  expression2
y = (x > 0) ? 1 : -1
System.out.println(number % 2 == 0 ?
  "number is even" : "number is odd");
```

</details>


## PDF page 1345

<details>
<summary>Page text</summary>

```text
Frequently Used Static Constants/Methods
Math.PI
Math.random()
Math.pow(a, b)
Math.abs(a)
Math.max(a, b)
Math.min(a, b)
Math.sqrt(a)
Math.sin(radians)
Math.asin(a)
Math.toRadians(degrees)
Math.toDegress(radians)
System.currentTimeMillis()
Integer.parseInt(string)
Integer.parseInt(string, radix)
Double.parseDouble(string)
Arrays.sort(type[] list)
Arrays.binarySearch(type[] list, type key)
Array/Length/Initializer
 int[] list = new int[10];
 list.length;
 int[] list = {1, 2, 3, 4};
Multidimensional Array/Length/Initializer
 int[][] list = new int[10][10];
 list.length;
 list[0].length;
 int[][] list = {{1, 2}, {3, 4}};
Ragged Array
 int[][] m = {{1, 2, 3, 4},
              {1, 2, 3},
              {1, 2},
              {1}};
String Class
String s = "Welcome";
String s = new String(char[]);
int length = s.length();
char ch = s.charAt(index);
int d = s.compareTo(s1);
boolean b = s.equals(s1);
boolean b = s.startsWith(s1);
boolean b = s.endsWith(s1);
boolean b = s.contains(s1);
String s1 = s.trim();
String s1 = s.toUpperCase();
String s1 = s.toLowerCase();
int index = s.indexOf(ch);
int index = s.lastIndexOf(ch);
String s1 = s.substring(ch);
String s1 = s.substring(i,j);
char[] chs = s.toCharArray();
boolean b = s.matches(regex);
String s1 = s.replaceAll(regex,repl);
String[] tokens = s.split(regex);
Companion Web site: www.pearsonhighered.com/liang
Object Class
Object o = new Object();
o.toString();
o.equals(o1);
File Class
File file =
  new File(filename);
file.exists()
file.renameTo(File)
file.delete()
Text File Output
 PrintWriter output =
   new PrintWriter(filename);
 output.print(...);
 output.println(...);
 output.printf(...);
Text File Input
  Scanner input = new Scanner(
   new File(filename));
ArrayList Class
ArrayList<E> list = new ArrayList<>();
list.add(object);
list.add(index, object);
list.clear();
Object o = list.get(index);
boolean b = list.isEmpty();
boolean b = list.contains(object);
int i = list.size();
list.remove(index);
list.set(index, object);
int i = list.indexOf(object);
int i = list.lastIndexOf(object);
printf Method
System.out.printf("%b %c %d %f %e %s",
  true, 'A', 45, 45.5, 45.5, "Welcome");
System.out.printf("%-5d %10.2f %10.2e %8s",
45, 45.5, 45.5, "Welcome");
Comparable Interface
c.compareTo(Comparable)
c is a Comparable object
Java Quick Reference
Uploaded by [StormRG]
```

</details>
