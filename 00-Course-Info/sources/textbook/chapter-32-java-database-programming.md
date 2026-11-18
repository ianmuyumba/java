# Chapter 32 Java Database Programming

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1196

<details>
<summary>Page text</summary>

```text
JAVA DATABASE
PROGRAMMING
Objectives
■ To understand the concepts of databases and database management 
systems (§32.2).
■ To understand the relational data model: relational data structures, 
constraints, and languages (§32.2).
■ To use SQL to create and drop tables and to retrieve and modify data 
(§32.3).
■ To learn how to load a driver, connect to a database, execute statements,
and process result sets using JDBC (§32.4).
■ To use prepared statements to execute precompiled SQL statements 
(§32.5).
■ To use callable statements to execute stored SQL procedures and 
functions (§32.6).
■ To explore database metadata using the DatabaseMetaData and 
ResultSetMetaData interfaces (§32.7).
CHAPTER
32
```

</details>


## PDF page 1197

<details>
<summary>Page text</summary>

```text
1174 Chapter 32  Java Database Programming
32.1 Introduction
Java provides the API for developing database applications that works with any 
relational database systems.
You may have heard a lot about database systems. Database systems are everywhere. Your 
social security information is stored in a database by the government. If you shop online, 
your purchase information is stored in a database by the company. If you attend a university, 
your academic information is stored in a database by the university. Database systems not 
only store data, they also provide means of accessing, updating, manipulating, and analyzing 
data. Your social security information is updated periodically, and you can register for courses 
online. Database systems play an important role in society and in commerce.
This chapter introduces database systems, the SQL language, and how database applica-
tions can be developed using Java. If you already know SQL, you can skip Sections 32.2 
and 32.3.
32.2 Relational Database Systems
SQL is the standard database language for defining and accessing databases.
A database system consists of a database, the software that stores and manages data in the 
database, and the application programs that present data and enable the user to interact with 
the database system, as shown in Figure 32.1.
Key
Point
Key
Pointdatabase system
FIGURE 32.1 A database system consists of data, database management software, and 
application programs.
database
Application Users
Application Programs
Database Management System (DBMS)
System Users
A database is a repository of data that form information. When you purchase a database 
system—such as MySQL, Oracle, IBM’s DB2 and Informix, Microsoft SQL Server, or 
Sybase—from a software vendor, you actually purchase the software comprising a database
management system (DBMS). Database management systems are designed for use by profes-
sional programmers and are not suitable for ordinary customers. Application programs are 
built on top of the DBMS for customers to access and update the database. Thus, applica-
tion programs can be viewed as the interfaces between the database system and its users. 
Application programs may be stand-alone GUI applications or Web applications and may 
access several different database systems in the network, as shown in Figure 32.2.
Most of today’s database systems are relational database systems. They are based on the 
relational data model, which has three key components: structure, integrity, and language. 
DBMS
```

</details>


## PDF page 1198

<details>
<summary>Page text</summary>

```text
32.2 Relational Database Systems  1175
Structure defines the representation of the data. Integrity imposes constraints on the data. 
Language provides the means for accessing and manipulating data.
32.2.1 Relational Structures
The relational model is built around a simple and natural structure. A relation is actually a 
table that consists of nonduplicate rows. Tables are easy to understand and use. The relational 
model provides a simple yet powerful way to represent data.
A row of a table represents a record, and a column of a table represents the value of a single 
attribute of the record. In relational database theory, a row is called a tuple and a column is 
called an attribute. Figure 32.3 shows a sample table that stores information about the courses 
offered by a university. The table has eight tuples, and each tuple has five attributes.
relational model
tuple
attribute
FIGURE 32.2 An application program can access multiple database systems.
Database Management System
database
Application Programs
Application Users
Database Management System
……
…
FIGURE 32.3 A table has a table name, column names, and rows.
Columns/Attributes
Tuples/
Rows 11111      CSCI         1301       Introduction to Java I         4 
11112      CSCI         1302       Introduction to Java II 3
11113      CSCI         3720       Database Systems 3
11114      CSCI         4750       Rapid Java Application 3
11115      MATH         2750       Calculus I 5
11116      MATH         3750       Calculus II 5
11117      EDUC         1111       Reading 3
11118      ITEC         1344       Database Administration 3
courseId subjectId courseNumber title numOfCreditsCourse Table
Relation/Table Name
Tables describe the relationship among data. Each row in a table represents a record of 
related data. For example, “11111,” “CSCI,” “1301,” “Introduction to Java I,” and “4” are 
related to form a record (the first row in Figure 32.3) in the Course table. Just as the data in 
the same row are related, so too data in different tables may be related through common attrib-
utes. Suppose the database has two other tables, Student and Enrollment, as shown in
```

</details>


## PDF page 1199

<details>
<summary>Page text</summary>

```text
1176 Chapter 32  Java Database Programming
Figures 32.4 and 32.5. The Course table and the Enrollment table are related through their 
common attribute courseId, and the Enrollment table and the Student table are related 
throughssn.
FIGURE 32.4 AStudent table stores student information.
deptID
444111110  Jacob      R  Smith      9129219434  1985-04-09  99   Kingston Street  31435   BIOL
444111111  John       K  Stevenson  9129219434  null        100  Main Street      31411   BIOL
444111112  George     K  Smith      9129213454  1974-10-10  1200 Abercorn St.     31419   CS
444111113  Frank      E  Jones      9125919434  1970-09-09  100  Main Street      31411   BIOL
444111114  Jean       K  Smith      9129219434  1970-02-09  100  Main Street      31411   CHEM 
444111115  Josh       R  Woo        7075989434  1970-02-09  555  Franklin St.     31411   CHEM
444111116  Josh       R  Smith      9129219434  1973-02-09  100  Main Street      31411   BIOL
444111117  Joy        P  Kennedy    9129229434  1974-03-19  103  Bay Street       31412   CS
444111118  Toni       R  Peterson   9129229434  1964-04-29  103  Bay Street       31412   MATH
444111119  Patrick    R  Stoneman   9129229434  1969-04-29  101  Washington St.   31435   MATH
444111120  Rick       R  Carter     9125919434  1986-04-09  19   West Ford St.    31411   BIOL
Student Table
ssn firstName mi lastName phone birthDate street zipCode
FIGURE 32.5 AnEnrollment table stores student enrollment information.
Enrollment Table
444111110 11111 2004-03-19 A
444111110 11112 2004-03-19 B
444111110 11113 2004-03-19 C
444111111 11111 2004-03-19 D
444111111 11112 2004-03-19 F
444111111 11113 2004-03-19 A
444111112 11114 2004-03-19 B
444111112 11115 2004-03-19 C
444111112 11116 2004-03-19 D
444111113 11111 2004-03-19 A
444111113 11113 2004-03-19 A
444111114 11115 2004-03-19 B
444111115 11115 2004-03-19 F
444111115 11116 2004-03-19 F
444111116 11111 2004-03-19 D
444111117 11111 2004-03-19 D
444111118 11111 2004-03-19 A
444111118 11112 2004-03-19 D
444111118  11113 2004-03-19 B
ssn courseId dateRegistered grade
32.2.2 Integrity Constraints
An integrity constraint imposes a condition that all the legal values in a table must satisfy. 
Figure  32.6 shows an example of some integrity constraints in the Subject and Course
tables.
In general, there are three types of constraints: domain constraints, primary key con-
straints, and foreign key constraints. Domain constraints  and primary key constraints  are 
known as intrarelational constraints  meaning that a constraint involves only one relation. 
The foreign key constraint  is interrelational meaning that a constraint involves more than 
one relation.
integrity constraint
```

</details>


## PDF page 1200

<details>
<summary>Page text</summary>

```text
32.2 Relational Database Systems  1177
Domain Constraints
Domain constraints specify the permissible values for an attribute. Domains can be specified 
using standard data types, such as integers, floating-point numbers, fixed-length strings, and 
variant-length strings. The standard data type specifies a broad range of values. Additional 
constraints can be specified to narrow the ranges. For example, you can specify that the 
numOfCredits attribute (in the Course table) must be greater than 0 and less than 5. You 
can also specify whether an attribute can be null, which is a special value in a database 
meaning unknown or not applicable. As shown in the Student table, birthDate may be 
null.
Primary Key Constraints
To understand primary keys, it is helpful to know superkeys, keys, and candidate keys. A 
superkey is an attribute or a set of attributes that uniquely identifies the relation. That is, no 
two tuples have the same values on a superkey. By definition, a relation consists of a set of 
distinct tuples. The set of all attributes in the relation forms a superkey.
A keyK is a minimal superkey, meaning that any proper subset of K is not a superkey. A 
relation can have several keys. In this case, each of the keys is called a candidate key. The 
primary key is one of the candidate keys designated by the database designer. The primary 
key is often used to identify tuples in a relation. As shown in Figure 32.6, courseId is the 
primary key in the Course table.
Foreign Key Constraints
In a relational database, data are related. Tuples in a relation are related, and tuples in dif-
ferent relations are related through their common attributes. Informally speaking, the com-
mon attributes are foreign keys. The foreign key constraints define the relationships among 
relations.
Formally, a set of attributes FK is a foreign key in a relation R that references relation T if 
it satisfies the following two rules:
 ■ The attributes in FK have the same domain as the primary key in T.
 ■ A nonnull value on FK in R must match a primary key value in T.
domain constraint
superkey
primary key 
candidate key
relational database 
foreign key constraint
foreign key 
FIGURE 32.6 TheEnrollment table and the Course table have integrity constraints.
11111 CSCI 1301 Introduction to Java I 4
11112 CSCI 1302 Introduction to Java II 3
11113 CSCI 3720 Database Systems 3
...
444111110 11111 2004-03-19 A
444111110 11112 2004-03-19 B
444111110 11113 2004-03-19 C
...
Course Table
Each value in the
numOfCredits column must be
greater than 0 and less than 5
Each value in courseId in the
Enrollment table must match a value
incourseId in the Course table
Each row must have a
value for courseId, and
the value must be unique
Enrollment Table ssn courseId dateRegistered grade
courseId subjectId courseNumber title numOfCredits
```

</details>


## PDF page 1201

<details>
<summary>Page text</summary>

```text
1178 Chapter 32  Java Database Programming
As shown in Figure 32.6, courseId is the foreign key in Enrollment that references the 
primary key courseId in Course. Every courseId value must match a courseId value 
inCourse.
Enforcing Integrity Constraints
The database management system enforces integrity constraints and rejects operations that 
would violate them. For example, if you attempt to insert the new record (“11115,” “CSCI,” 
“2490,” “C++ Programming,” 0) into the Course table, it would fail because the credit hours 
must be greater than 0; if you attempted to insert a record with the same primary key as an 
existing record in the table, the DBMS would report an error and reject the operation; if you 
attempted to delete a record from the Course table whose primary key value is referenced by 
the records in the Enrollment table, the DBMS would reject this operation.
Note
All relational database systems support primary key constraints and foreign key 
constraints but not all database systems support domain constraints. In the Microsoft 
Access database, for example, you cannot specify the constraint that numOfCredits
is greater than 0 and less than 5.
32.1 What are superkeys, candidate keys, and primary keys? 
32.2 What is a foreign key? 
32.3 Can a relation have more than one primary key or foreign key?
32.4 Does a foreign key need to be a primary key in the same relation?
32.5 Does a foreign key need to have the same name as its referenced primary key?
32.6 Can a foreign key value be null?
32.3 SQL
Structured Query Language (SQL) is the language for defining tables and integrity 
constraints, and for accessing and manipulating data.
SQL (pronounced “S-Q-L” or “sequel”) is the universal language for accessing relational 
database systems. Application programs may allow users to access a database without directly 
using SQL, but these applications themselves must use SQL to access the database. This 
section introduces some basic SQL commands. 
Note
There are many relational database management systems. They share the common SQL 
language but do not all support every feature of SQL. Some systems have their own 
extensions to SQL. This section introduces standard SQL supported by all systems. 
SQL can be used on MySQL, Oracle, Sybase, IBM DB2, IBM Informix, MS Access, or 
any other relational database system. This chapter uses MySQL to demonstrate SQL and uses 
MySQL, Oracle, and Access to demonstrate Java database programming. The Companion 
Website contains the following supplements on how to install and use three popular databases:
MySQL, Oracle, and Access:
 ■ Supplement IV.B: Tutorial for MySQL
 ■ Supplement IV.C: Tutorial for Oracle
 ■ Supplement IV.D: Tutorial for Microsoft Access
auto enforcement
✓Point✓
Check
Key
Point
SQL
database language
standard SQL
MySQL Tutorial
Oracle Tutorial
Access Tutorial
```

</details>


## PDF page 1202

<details>
<summary>Page text</summary>

```text
32.3 SQL 1179
32.3.1 Creating a User Account on MySQL
Assume that you have installed MySQL 5 with the default configuration. To match all the 
examples in this book, you should create a user named scott with the password tiger. You can 
perform the administrative tasks using the MySQL Workbench or using the command line. 
MySQL Workbench is a GUI tool for managing MySQL databases. Here are the steps to cre-
ate a user from the command line:
1. From the DOS command prompt, type
mysql –uroot -p
You will be prompted to enter the root password, as shown in Figure 32.7.
2. At the mysql prompt, enter
use mysql;
3. To create user scott with password tiger, enter
create user 'scott'@'localhost' identified by 'tiger';
4. To grant privileges to scott, enter
grant select, insert, update, delete, create, create view, drop,
execute, references on *.* to 'scott'@'localhost';
 ■ If you want to enable remote access of the account from any IP address, enter
grant all privileges on *.* to 'scott'@'%'
  identified by 'tiger';
 ■ If you want to restrict the account’s remote access to just one particular IP address, 
enter
grant all privileges on *.* to 'scott'@'ipAddress'
  identified by 'tiger';
5. Enter
exit;
to exit the MySQL console.
FIGURE 32.7 You can access a MySQL database server from the command window.
```

</details>


## PDF page 1203

<details>
<summary>Page text</summary>

```text
1180 Chapter 32  Java Database Programming
Note
On Windows, your MySQL database server starts every time your computer starts. You 
can stop it by typing the command net stop mysql  and restart it by typing the 
commandnet start mysql.
By default, the server contains two databases named mysql and test. The mysql database 
contains the tables that store information about the server and its users. This database is 
intended for the server administrator to use. For example, the administrator can use it to cre-
ate users and grant or revoke user privileges. Since you are the owner of the server installed 
on your system, you have full access to the mysql database. However, you should not cre-
ate user tables in the mysql database. You can use the test database to store data or create 
new databases. You can also create a new database using the command create database 
databasename or delete an existing database using the command drop database 
databasename.
32.3.2 Creating a Database
To match the examples in this book, you should create a database named javabook. Here are 
the steps to create it:
1. From the DOS command prompt, type
mysql –uscott -ptiger
to login to mysql, as shown in Figure 32.8.
2. At the mysql prompt, enter
create database javabook;
stop mysql
start mysql
FIGURE 32.8 You can create databases in MySQL.
For your convenience, the SQL statements for creating and initializing tables used in this 
book are provided in Supplement IV.A. You can download the script for MySQL and save it 
to script.sql. To execute the script, first switch to the javabook database using the following 
command:
use javabook;
and then type
source script.sql;
as shown in Figure 32.9.
run script file
```

</details>


## PDF page 1204

<details>
<summary>Page text</summary>

```text
32.3 SQL 1181
FIGURE 32.9 You can run SQL commands in a script file.
Note
You can populate the javabook database using the script from Supplement IV.A.
32.3.3 Creating and Dropping Tables
Tables are the essential objects in a database. To create a table, use the create table state-
ment to specify a table name, attributes, and types, as in the following example:
create table Course (
  courseId char(5),
  subjectId char(4) not null,
  courseNumber integer,
  title varchar(50) not null,
  numOfCredits integer,
primary key (courseId)
);
This statement creates the Course table with attributes courseId, subjectId,
courseNumber, title, and numOfCredits. Each attribute has a data type that specifies 
the type of data stored in the attribute. char(5) specifies that courseId consists of five 
characters. varchar(50) specifies that title is a variant-length string with a maximum 
of 50 characters. integer specifies that courseNumber is an integer. The primary key is 
courseId.
The tables Student and Enrollment can be created as follows:
create table Student (
  ssn char(9),
  firstName varchar(25),
  mi char(1),
  lastName varchar(25),
  birthDate date,
  street varchar(25),
  phone char(11),
  zipCode char(5),
  deptId char(4),
primary key (ssn)
);
populating database
create table
create table Enrollment (
  ssn char(9),
  courseId char(5),
  dateRegistered date,
  grade char(1),
primary key (ssn, courseId),
foreign key (ssn) references
    Student(ssn),
foreign key (courseId) references
    Course(courseId)
);
Note
SQL keywords are not case sensitive. This book adopts the following naming conventions: 
tables are named in the same way as Java classes, and attributes are named in the same 
way as Java variables. SQL keywords are named in the same way as Java keywords.
naming convention
```

</details>


## PDF page 1205

<details>
<summary>Page text</summary>

```text
1182 Chapter 32  Java Database Programming
If a table is no longer needed, it can be dropped permanently using the drop table com-
mand. For example, the following statement drops the Course table: 
drop table Course;
If a table to be dropped is referenced by other tables, you have to drop the other tables 
first. For example, if you have created the tables Course, Student, and Enrollment and 
want to drop Course, you have to first drop Enrollment, because Course is referenced by 
Enrollment.
Figure 32.10 shows how to enter the create table statement from the MySQL console.
drop table
FIGURE 32.10 A table is created using the create table statement.
FIGURE 32.11 (a) You can use Notepad to create a text file for SQL commands. (b) You 
can run the SQL commands in a script file from MySQL.
(a) (b)
If you make typing errors, you have to retype the whole command. To avoid retyping, you 
can save the command in a file, and then run the command from the file. To do so, create a 
text file to contain commands, named, for example, test.sql. You can create the text file using 
any text editor, such as Notepad, as shown in Figure 32.11a. To comment a line, precede it 
with two dashes. You can now run the script file by typing source test.sql from the SQL 
command prompt, as shown in Figure 32.11b.
32.3.4 Simple Insert, Update, and Delete
Once a table is created, you can insert data into it. You can also update and delete records. 
This section introduces simple insert, update, and delete statements.
The syntax to insert a record into a table is:
insert into tableName [(column1, column2, ..., column)]
values (value1, value2, ..., valuen);
```

</details>


## PDF page 1206

<details>
<summary>Page text</summary>

```text
32.3 SQL 1183
For example, the following statement inserts a record into the Course table. The new record 
has the courseId ‘11113’, subjectId ‘CSCI’, courseNumber ‘3720’, title ‘Database 
Systems’, and creditHours 3.
insert into Course (courseId, subjectId, courseNumber, title, numOfCredits)
values ('11113', 'CSCI', '3720', 'Database Systems', 3);
The column names are optional. If they are omitted, all the column values for the record must 
be entered, even though the columns have default values. String values are case sensitive and 
enclosed inside single quotation marks in SQL.
The syntax to update a table is:
update tableName
set column1 = newValue1 [, column2 = newValue2, ...]
[where condition];
For example, the following statement changes the numOfCredits for the course whose 
title is Database Systems to 4.
update Course 
set numOfCredits = 4
where title = 'Database Systems';
The syntax to delete records from a table is:
delete from tableName
[where condition];
For example, the following statement deletes the Database Systems course from the Course
table:
delete from Course 
where title = 'Database Systems';
The following statement deletes all the records from the Course table:
delete from Course;
32.3.5 Simple Queries
To retrieve information from tables, use a select statement with the following syntax:
select column-list
from table-list
[where condition];
The select clause lists the columns to be selected. The from clause refers to the tables 
involved in the query. The optional where clause specifies the conditions for the selected 
rows.
Query 1: Select all the students in the CS department, as shown in Figure 32.12.
select firstName, mi, lastName
from Student
where deptId = 'CS';
```

</details>


## PDF page 1207

<details>
<summary>Page text</summary>

```text
1184 Chapter 32  Java Database Programming
32.3.6 Comparison and Boolean Operators
SQL has six comparison operators, as shown in Table 32.1, and three Boolean operators, as 
shown in Table 32.2.
Operator Description
= Equal to 
<> or != Not equal to
< Less than
<= Less than or equal to
> Greater than
>= Greater than or equal to
TABLE 32.1  Comparison Operators
Operator Description
not Logical negation
and Logical conjunction
or Logical disjunction
TABLE 32.2  Boolean Operators
FIGURE 32.12 The result of the select statement is displayed in the MySQL console.
Note
The comparison and Boolean operators in SQL have the same meanings as in Java. In 
SQL the equal to  operator is =, but in Java it is ==. In SQL the not equal to
operator is <> or !=, but in Java it is !=. The not, and, and or operators are !, &&
(&), and || (|) in Java.
Query 2:  Get the names of the students who are in the CS dept and live in the ZIP code 
31411.
select firstName, mi, lastName 
from Student
where deptId = 'CS' and zipCode = '31411';
Note
To select all the attributes from a table, you don’t have to list all the attribute names 
in the select clause. Instead, you can just use an asterisk (*), which stands for all the 
attributes. For example, the following query displays all the attributes of the students 
who are in the CS dept and live in ZIP code 31411.
select * 
from Student
where deptId = 'CS' and zipCode = '31411';
```

</details>


## PDF page 1208

<details>
<summary>Page text</summary>

```text
32.3 SQL 1185
32.3.7 The like,between-and, and is null Operators
SQL has a like operator that can be used for pattern matching. The syntax to check whether 
a string s has a pattern p is
s like p or s not like p
You can use the wildcard characters % (percent symbol) and _ (underline symbol) in the 
pattern p. % matches zero or more characters, and _ matches any single character in s. For 
example, lastName like '_mi%'  matches any string whose second and third letters are 
m and i.lastName not like '_mi%'  excludes any string whose second and third letters 
arem and i.
Note
In earlier versions of MS Access, the wildcard character is *, and the character ? matches 
any single character.
Thebetween-and operator checks whether a value v is between two other values, v1 and 
v2, using the following syntax:
v between v1 and v2 orv not between v1 and v2
v between v1 and v2  is equivalent to v >= v1 and v <= v2 , and v not 
between v1 and v2 is equivalent to v < v1 or v > v2.
Theis null operator checks whether a value v is null using the following syntax:
v is null or v is not null
Query 3: Get the Social Security numbers of the students whose grades are between ‘C’ and ‘A’.
select ssn 
from Enrollment
where grade between 'C' and 'A';
32.3.8 Column Alias
When a query result is displayed, SQL uses the column names as column headings. Usually 
the user gives abbreviated names for the columns, and the columns cannot have spaces when 
the table is created. Sometimes it is desirable to give more descriptive names in the result 
heading. You can use the column aliases with the following syntax:
select columnName [as] alias
Query 4: Get the last name and ZIP code of the students in the CS department. Display the 
column headings as “Last Name” for lastName and “Zip Code” for zipCode. The query result 
is shown in Figure 32.13.
FIGURE 32.13 You can use a column alias in the display.
```

</details>


## PDF page 1209

<details>
<summary>Page text</summary>

```text
1186 Chapter 32  Java Database Programming
select lastName as "Last Name", zipCode as "Zip Code"
from Student
where deptId = 'CS';
Note
Theas keyword is optional in MySQL and Oracle, but it is required in MS Access.
32.3.9 The Arithmetic Operators
You can use the arithmetic operators * (multiplication), / (division), + (addition), and –
(subtraction) in SQL.
Query 5: Assume that a credit hour is 50 minutes of lectures and get the total minutes for 
each course with the subject CSCI. The query result is shown in Figure 32.14.
select title, 50 * numOfCredits as "Lecture Minutes Per Week"
from Course
where subjectId = 'CSCI';
FIGURE 32.14 You can use arithmetic operators in SQL.
FIGURE 32.15 (a) The duplicate tuples are displayed. (b) The distinct tuples are displayed.
(a) (b)
32.3.10 Displaying Distinct Tuples
SQL provides the distinct keyword, which can be used to eliminate duplicate tuples in the 
result. Figure 32.15a displays all the subject IDs used by the courses, and Figure 32.15b dis-
plays all the distinct subject IDs used by the courses using the following statement.
select distinct subjectId as "Subject ID"
from Course;
```

</details>


## PDF page 1210

<details>
<summary>Page text</summary>

```text
32.3 SQL 1187
When there is more than one column in the select clause, the distinct keyword applies 
to the whole tuple in the result. For example, the following statement displays all tuples with 
distinctsubjectId and title, as shown in Figure 32.16. Note that some tuples may have 
the same subjectId but different title. These tuples are distinct.
select distinct subjectId, title
from Course;
FIGURE 32.17 You can sort results using the order by clause.
FIGURE 32.16 The keyword distinct applies to the entire tuple.
32.3.11 Displaying Sorted Tuples
SQL provides the order by clause to sort the output using the following syntax:
select column-list
from table-list
[where condition]
[order by columns-to-be-sorted];
In the syntax, columns-to-be-sorted specifies a column or a list of columns to be sorted. 
By default, the order is ascending. To sort in a descending order, append the desc keyword. 
You could also append the asc keyword after columns-to-be-sorted, but it is not neces-
sary. When multiple columns are specified, the rows are sorted based on the first column, then 
the rows with the same values on the first column are sorted based on the second column, and 
so on.
Query 6: List the full names of the students in the CS department, ordered primarily on 
their last names in descending order and secondarily on their first names in ascending order. 
The query result is shown in Figure 32.17.
```

</details>


## PDF page 1211

<details>
<summary>Page text</summary>

```text
1188 Chapter 32  Java Database Programming
select lastName, firstName, deptId
from Student
where deptId = 'CS'
order by lastName desc, firstName asc;
32.3.12 Joining Tables
Often you need to get information from multiple tables, as demonstrated in the next query.
Query 7: List the courses taken by the student Jacob Smith. To solve this query, you need 
to join tables Student and Enrollment, as shown in Figure 32.18.
FIGURE 32.18 Student and Enrollment are joined on ssn.
A tuple
Student Table
ssn    lastName  mi  firstName …
Enrollment Table
ssn   courseId …
Equal
FIGURE 32.19 Query 7 demonstrates queries involving multiple tables.
You can write the query in SQL:
select distinct lastName, firstName, courseId
from Student, Enrollment
where Student.ssn = Enrollment.ssn and 
  lastName = 'Smith' and firstName = 'Jacob';
The tables Student and Enrollment are listed in the from clause. The query examines 
every pair of rows, each made of one item from Student and another from Enrollment and 
selects the pairs that satisfy the condition in the where clause. The rows in Student have the 
last name, Smith, and the first name, Jacob, and both rows from Student and Enrollment
have the same ssn values. For each pair selected, lastName and firstName from Student
andcourseId from Enrollment are used to produce the result, as shown in Figure 32.19. 
Student and Enrollment have the same attribute ssn. To distinguish them in a query, use 
Student.ssn and Enrollment.ssn.
```

</details>


## PDF page 1212

<details>
<summary>Page text</summary>

```text
32.4 JDBC 1189
For more features of SQL, see Supplements IV.H and IV.I.
32.7 Create the tables Course, Student, and Enrollment using the create table
statements in Section  32.3.3, Creating and Dropping Tables. Insert rows into the 
Course,Student, and Enrollment tables using the data in Figures 32.3–32.5.
32.8 List all CSCI courses with at least four credit hours.
32.9 List all students whose last names contain the letter e two times.
32.10 List all students whose birthdays are null.
32.11 List all students who take Math courses.
32.12 List the number of courses in each subject.
32.13 Assume that each credit hour is 50 minutes of lectures. Get the total minutes for the 
courses that each student takes.
32.4 JDBC
JDBC is the Java API for accessing relational database.
The Java API for developing Java database applications is called JDBC. JDBC is the trade-
marked name of a Java API that supports Java programs that access relational databases. 
JDBC is not an acronym, but it is often thought to stand for Java Database Connectivity.
JDBC provides Java programmers with a uniform interface for accessing and manipulating 
relational databases. Using the JDBC API, applications written in the Java programming lan-
guage can execute SQL statements, retrieve results, present data in a user-friendly interface, 
and propagate changes back to the database. The JDBC API can also be used to interact with 
multiple data sources in a distributed, heterogeneous environment.
The relationships between Java programs, JDBC API, JDBC drivers, and relational data-
bases are shown in Figure 32.20. The JDBC API is a set of Java interfaces and classes used to 
write Java programs for accessing and manipulating relational databases. Since a JDBC driver 
serves as the interface to facilitate communications between JDBC and a proprietary data-
base, JDBC drivers are database specific and are normally provided by the database vendors. 
You need MySQL JDBC drivers to access the MySQL database, and Oracle JDBC drivers 
✓Point✓
Check
Key
Point
FIGURE 32.20 Java programs access and manipulate databases through JDBC drivers.
Java Programs
JDBC API
JDBC-ODBC
Bridge Driver
Local or remote
ORACLE DB
Microsoft ODBC
Driver
Microsoft Access
Database
MySQL JDBC
Driver
Local or remote
MySQL DB
Oracle JDBC
Driver
```

</details>


## PDF page 1213

<details>
<summary>Page text</summary>

```text
1190 Chapter 32  Java Database Programming
to access the Oracle database. For the Access database, use the JDBC-ODBC bridge driver 
included in the JDK. ODBC is a technology developed by Microsoft for accessing databases 
on the Windows platform. An ODBC driver is preinstalled on Windows. The JDBC-ODBC 
bridge driver allows a Java program to access any ODBC data source.
32.4.1 Developing Database Applications Using JDBC
The JDBC API is a Java application program interface to generic SQL databases that enables 
Java developers to develop DBMS-independent Java applications using a uniform interface.
The JDBC API consists of classes and interfaces for establishing connections with data-
bases, sending SQL statements to databases, processing the results of SQL statements, and 
obtaining database metadata. Four key interfaces are needed to develop any database appli-
cation using Java: Driver, Connection, Statement, and ResultSet. These interfaces 
define a framework for generic SQL database access. The JDBC API defines these interfaces, 
and the JDBC driver vendors provide the implementation for the interfaces. Programmers use 
these interfaces.
The relationship of these interfaces is shown in Figure 32.21. A JDBC application loads an 
appropriate driver using the Driver interface, connects to the database using the Connection
interface, creates and executes SQL statements using the Statement interface, and processes 
the result using the ResultSet interface if the statements return results. Note that some state-
ments, such as SQL data definition statements and SQL data modification statements, do not 
return results.
FIGURE 32.21 JDBC classes enable Java programs to connect to the database, send SQL 
statements, and process results.
Driver
Connection Connection
Statement
ResultSet
Statement
ResultSet
Statement
ResultSet
Statement
ResultSet
The JDBC interfaces and classes are the building blocks in the development of Java data-
base programs. A typical Java program takes the following steps to access a database.
1. Loading drivers.
An appropriate driver must be loaded using the statement shown below before connecting to 
a database.
Class.forName("JDBCDriverClass");
A driver is a concrete class that implements the java.sql.Driver interface. The drivers for 
Access, MySQL, and Oracle are listed in Table 32.3. If your program accesses several differ-
ent databases, all their respective drivers must be loaded.
The JDBC-ODBC driver for Access is bundled in JDK. The most recent platform inde-
pendent version of MySQL JDBC driver is mysql-connector-java-5.1.26.jar. This 
file is contained in a ZIP file downloadable from dev.mysql.com/downloads/connector/j/ . The 
most recent version of Oracle JDBC driver is ojdbc6.jar (downloadable from www.oracle
.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html ). To use the MySQL and 
mysql-connector-java-5.1.26.jar
```

</details>


## PDF page 1214

<details>
<summary>Page text</summary>

```text
32.4 JDBC 1191
Oracle drivers, you have to add mysql-connector-java-5.1.26.jar and ojdbc6.jar in the 
classpath using the following DOS command on Windows:
set classpath=%classpath%;c:\book\lib\mysql-connector-java-5.1.26.jar;
c:\book\lib\ojdbc6.jar
If you use an IDE such as Eclipse or NetBeans, you need to add these jar files into the library 
in the IDE.
Note
com.mysql.jdbc.Driver is a class in mysql-connector-java-5.1.26.jar, and 
oracle.jdbc.driver.OracleDriver is a class in ojdbc6.jar. mysql-connector-
java-5.1.26.jar, and ojdbc6.jar contains many classes to support the driver. These 
classes are used by JDBC but not directly by JDBC programmers. When you use a class 
explicitly in the program, it is automatically loaded by the JVM. The driver classes, 
however, are not used explicitly in the program, so you have to write the code to tell 
the JVM to load them.
Note
Java 6 supports automatic driver discovery, so you don’t have to load the driver explicitly.
At the time of this writing, however, this feature is not supported for all database drivers. 
To be safe, load the driver explicitly. 
2. Establishing connections.
To connect to a database, use the static method getConnection(databaseURL) in the 
DriverManager class, as follows:
Connection connection = DriverManager.getConnection(databaseURL);
wheredatabaseURL is the unique identifier of the database on the Internet. Table 32.4 lists 
the URL patterns for the Access, MySQL, and Oracle databases.
ojdbc6.jar
why load a driver?
automatic driver discovery
Database URL Pattern
Access jdbc:odbc:dataSource
MySQL jdbc:mysql://hostname/dbname
Oracle jdbc:oracle:thin:@hostname:port#:oracleDBSID
TABLE 32.4  JDBC URLs
TABLE 32.3  JDBC Drivers
Database Driver Class Source
Access sun.jdbc.odbc.JdbcOdbcDriver Already in JDK
MySQL com.mysql.jdbc.Driver mysql-connector-java-5.1.26.jar
Oracle oracle.jdbc.driver.OracleDriver ojdbc6.jar
For an ODBC data source, the databaseURL is jdbc:odbc:dataSource. An ODBC 
data source can be created using the ODBC Data Source Administrator on Windows. See 
Supplement IV.D, Tutorial for Microsoft Access, on how to create an ODBC data source for 
an Access database. connect Access DB
```

</details>


## PDF page 1215

<details>
<summary>Page text</summary>

```text
1192 Chapter 32  Java Database Programming
Suppose a data source named ExampleMDBDataSource has been created for an Access 
database. The following statement creates a Connection object:
Connection connection = DriverManager.getConnection
  ("jdbc:odbc:ExampleMDBDataSource");
The databaseURL for a MySQL database specifies the host name and database name to 
locate a database. For example, the following statement creates a Connection object for the 
local MySQL database javabook with username scott and password tiger:
Connection connection = DriverManager.getConnection
  ("jdbc:mysql://localhost/javabook", "scott", "tiger");
Recall that by default, MySQL contains two databases named mysql and test. Section 32.3.2, 
Creating a Database, created a custom database named javabook. We will use javabook in 
the examples.
The databaseURL for an Oracle database specifies the hostname, the port# where the 
database listens for incoming connection requests, and the oracleDBSID database name to 
locate a database. For example, the following statement creates a Connection object for the 
Oracle database on liang.armstrong.edu with the username scott and password tiger:
Connection connection = DriverManager.getConnection
  ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
"scott", "tiger");
3. Creating statements.
If a Connection object can be envisioned as a cable linking your program to a database, an 
object of Statement can be viewed as a cart that delivers SQL statements for execution by 
the database and brings the result back to the program. Once a Connection object is created, 
you can create statements for executing SQL statements as follows:
Statement statement = connection.createStatement();
4. Executing statements.
SQL data definition language (DDL) and update statements can be executed using 
executeUpdate(String sql) , and an SQL query statement can be executed using 
executeQuery(String sql) . The result of the query is returned in ResultSet. For 
example, the following code executes the SQL statement create table Temp (col1 
char(5), col2 char(5)):
statement.executeUpdate
  ("create table Temp (col1 char(5), col2 char(5))");
This next code executes the SQL query select firstName, mi, lastName from 
Student where lastName = 'Smith':
// Select the columns from the Student table
ResultSet resultSet = statement.executeQuery
  ("select firstName, mi, lastName from Student where lastName "
    + " = 'Smith'");
5. Processing ResultSet.
TheResultSet maintains a table whose current row can be retrieved. The initial row posi-
tion is null. You can use the next method to move to the next row and the various getter 
methods to retrieve values from a current row. For example, the following code displays all 
the results from the preceding SQL query.
// Iterate through the result and print the student names
while (resultSet.next())
connect MySQL DB
connect Oracle DB
```

</details>


## PDF page 1216

<details>
<summary>Page text</summary>

```text
32.4 JDBC 1193
  System.out.println(resultSet.getString(1) + " " +
    resultSet.getString(2) + " " + resultSet.getString(3));
The getString(1), getString(2), and getString(3) methods retrieve the col-
umn values for firstName, mi, and lastName, respectively. Alternatively, you can use 
getString("firstName"), getString("mi"), and getString("lastName") to 
retrieve the same three column values. The first execution of the next() method sets the cur-
rent row to the first row in the result set, and subsequent invocations of the next() method 
set the current row to the second row, third row, and so on, to the last row.
Listing 32.1 is a complete example that demonstrates connecting to a database, executing 
a simple query, and processing the query result with JDBC. The program connects to a local 
MySQL database and displays the students whose last name is Smith.
LISTING 32.1 SimpleJDBC.java
 1 import java.sql.*;
 2
 3 public class SimpleJdbc {
 4 public static void main(String[] args)
 5 throws SQLException, ClassNotFoundException {
 6 // Load the JDBC driver
 7 Class.forName( "com.mysql.jdbc.Driver");
 8      System.out.println("Driver loaded");
 9
10 // Connect to a database
11 Connection connection = DriverManager.getConnection
12 ( "jdbc:mysql://localhost/javabook" , "scott", "tiger");
13      System.out.println("Database connected");
14
15 // Create a statement
16 Statement statement = connection.createStatement();
17
18 // Execute a statement
19 ResultSet resultSet = statement.executeQuery
20 ( "select firstName, mi, lastName from Student where lastName "
21 + " = 'Smith'");
22
23 // Iterate through the result and print the student names
24 while (resultSet.next())
25        System.out.println(resultSet.getString(1) + "\t" +
26 resultSet.getString( 2) + "\t" + resultSet.getString(3));
27
28 // Close the connection
29 connection.close();
30    }
31  }
The statement in line 7 loads a JDBC driver for MySQL, and the statement in lines 11–13 
connects to a local MySQL database. You can change them to connect to an Access or Oracle 
database. The program creates a Statement object (line 16), executes an SQL statement and 
returns a ResultSet object (lines 19–21), and retrieves the query result from the ResultSet
object (lines 24–26). The last statement (line 29) closes the connection and releases resources 
related to the connection. You can rewrite this program using the try-with-resources syntax. 
See www.cs.armstrong.edu/liang/intro10e/html/SimpleJdbcWithAutoClose.html .
Note
If you run this program from the DOS prompt, specify the appropriate driver in the 
classpath, as shown in Figure 32.22.
load driver
connect database
create statement
execute statement
get result
close connection
run from DOS prompt
```

</details>


## PDF page 1217

<details>
<summary>Page text</summary>

```text
1194 Chapter 32  Java Database Programming
The classpath directory and jar files are separated by commas. The period (.) represents 
the current directory. For convenience, the driver files are placed under the c:\book\lib
directory.
Caution
Do not use a semicolon ( ;) to end the Oracle SQL command in a Java program. The 
semicolon may not work with the Oracle JDBC drivers. It does work, however, with the 
other drivers used in this book.
Note
TheConnection interface handles transactions and specifies how they are processed. 
By default, a new connection is in autocommit mode, and all its SQL statements are 
executed and committed as individual transactions. The commit occurs when the state-
ment completes or the next execute occurs, whichever comes first. In the case of state-
ments returning a result set, the statement completes when the last row of the result set 
has been retrieved or the result set has been closed. If a single statement returns multiple 
results, the commit occurs when all the results have been retrieved. You can use the 
setAutoCommit(false) method to disable autocommit, so that all SQL statements 
are grouped into one transaction that is terminated by a call to either the commit() or 
the rollback() method. The rollback() method undoes all the changes made 
by the transaction.
32.4.2 Accessing a Database from JavaFX 
This section gives an example that demonstrates connecting to a database from a JavaFX pro-
gram. The program lets the user enter the SSN and the course ID to find a student’s grade, as 
shown in Figure 32.23. The code in Listing 32.2 uses the MySQL database on the localhost.
the semicolon issue
auto commit
FIGURE 32.22 You must include the driver file to run Java database programs.
FIGURE 32.23 A JavaFX client can access the database on the server.
LISTING 32.2 FindGrade.java
 1 import javafx.application.Application;
 2 import javafx.scene.Scene;
 3 import javafx.scene.control.Button;
 4 import javafx.scene.control.Label;
 5 import javafx.scene.control.TextField;
 6 import javafx.scene.layout.HBox;
 7 import javafx.scene.layout.VBox;
 8 import javafx.stage.Stage;
 9 import java.sql.*;
```

</details>


## PDF page 1218

<details>
<summary>Page text</summary>

```text
32.4 JDBC 1195
10
11 public class FindGrade extends Application {
12 // Statement for executing queries
13 private Statement stmt;
14 private TextField tfSSN = new TextField();
15 private TextField tfCourseId = new TextField();
16 private Label lblStatus = new Label();
17
18    @Override // Override the start method in the Application class
19 public void start(Stage primaryStage) {
20 // Initialize database connection and create a Statement object
21      initializeDB();
22
23      Button btShowGrade = new Button("Show Grade");
24      HBox hBox = new HBox(5);
25      hBox.getChildren().addAll(new Label("SSN"), tfSSN, 
26 new Label("Course ID"), tfCourseId, (btShowGrade));
27
28      VBox vBox = new VBox(10);
29      vBox.getChildren().addAll(hBox, lblStatus);
30
31      tfSSN.setPrefColumnCount(6);
32      tfCourseId.setPrefColumnCount(6);
33      btShowGrade.setOnAction(e -> showGrade());
34
35 // Create a scene and place it in the stage
36      Scene scene = new Scene(vBox, 420, 80);
37      primaryStage.setTitle("FindGrade"); // Set the stage title
38      primaryStage.setScene(scene); // Place the scene in the stage
39      primaryStage.show(); // Display the stage
40    }
41
42 private void initializeDB() {
43 try {
44 // Load the JDBC driver
45 Class.forName( "com.mysql.jdbc.Driver");
46 //      Class.forName("oracle.jdbc.driver.OracleDriver");
47        System.out.println("Driver loaded");
48
49 // Establish a connection
50 Connection connection = DriverManager.getConnection
51 ( "jdbc:mysql://localhost/javabook", "scott", "tiger");
52 //    ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
53 //     "scott", "tiger");
54        System.out.println("Database connected");
55
56 // Create a statement
57 stmt = connection.createStatement();
58      }
59 catch (Exception ex) {
60        ex.printStackTrace();
61      }
62    }
63
64 private void showGrade() {
65      String ssn = tfSSN.getText();
66      String courseId = tfCourseId.getText();
67 try {
68        String queryString = "select firstName, mi, " +
69 "lastName, title, grade from Student, Enrollment, Course " +
button listener
load driver
Oracle driver commented
connect to MySQL database
connect to Oracle commented
create statement
execute statement
show result
```

</details>


## PDF page 1219

<details>
<summary>Page text</summary>

```text
1196 Chapter 32  Java Database Programming
70 "where Student.ssn = '" + ssn + "' and Enrollment.courseId "
71          + "= '" + courseId +
72 "' and Enrollment.courseId = Course.courseId " +
73 " and Enrollment.ssn = Student.ssn";
74
75 ResultSet rset = stmt.executeQuery(queryString);
76
77 if (rset.next()) {
78          String lastName = rset.getString(1);
79          String mi = rset.getString(2);
80          String firstName = rset.getString(3);
81          String title = rset.getString(4);
82          String grade = rset.getString(5);
83
84 // Display result in a label
85          lblStatus.setText(firstName + " " + mi +
86 " " + lastName + "'s grade on course " + title + " is " +
87            grade);
88        } else {
89          lblStatus.setText("Not found");
90        }
91      }
92 catch (SQLException ex) {
93        ex.printStackTrace();
94      }
95    }
96  }
TheinitializeDB() method (lines 42–62) loads the MySQL driver (line 45), connects 
to the MySQL database on host liang.armstrong.edu (lines 50–51) and creates a state-
ment (line 57).
Note
There is a security hole in this program. If you enter 1' or true or '1 in the SSN
field, you will get the first student’s score, because the query string now becomes
select firstName, mi, lastName, title, grade 
from Student, Enrollment, Course 
where Student.ssn = '1' or true or '1' and
      Enrollment.courseId = ' ' and
      Enrollment.courseId = Course.courseId and
      Enrollment.ssn = Student.ssn;
You can avoid this problem by using the PreparedStatement interface, which is 
discussed in the next section.
32.14 What are the advantages of developing database applications using Java?
32.15 Describe the following JDBC interfaces: Driver, Connection, Statement, and 
ResultSet.
32.16 How do you load a JDBC driver? What are the driver classes for MySQL, Access, 
and Oracle?
32.17 How do you create a database connection? What are the URLs for MySQL, Access, 
and Oracle?
32.18 How do you create a Statement and execute an SQL statement?
32.19 How do you retrieve values in a ResultSet?
32.20 Does JDBC automatically commit a transaction? How do you set autocommit to false?
security hole
✓Point✓
Check
```

</details>


## PDF page 1220

<details>
<summary>Page text</summary>

```text
32.5 PreparedStatement
PreparedStatement enables you to create parameterized SQL statements.
Once a connection to a particular database is established, it can be used to send SQL statements 
from your program to the database. The Statement interface is used to execute static SQL 
statements that don’t contain any parameters. The PreparedStatement interface, extend-
ingStatement, is used to execute a precompiled SQL statement with or without parameters. 
Since the SQL statements are precompiled, they are efficient for repeated executions.
A PreparedStatement object is created using the prepareStatement method in the 
Connection interface. For example, the following code creates a PreparedStatement for 
an SQL insert statement:
PreparedStatement preparedStatement = connection.prepareStatement
  ("insert into Student (firstName, mi, lastName) " +
"values (?, ?, ?)");
Thisinsert statement has three question marks as placeholders for parameters representing 
values for firstName,mi, and lastName in a record of the Student table.
As a subinterface of Statement, the PreparedStatement interface inherits all the 
methods defined in Statement. It also provides the methods for setting parameters in the 
object of PreparedStatement. These methods are used to set the values for the parameters 
before executing statements or procedures. In general, the setter methods have the following 
name and signature:
setX(int parameterIndex, X value);
where X is the type of the parameter, and parameterIndex is the index of the parameter
in the statement. The index starts from 1. For example, the method setString(int
parameterIndex, String value) sets a String value to the specified parameter.
The following statements pass the parameters "Jack","A", and "Ryan" to the placehold-
ers for firstName,mi, and lastName in preparedStatement:
preparedStatement.setString(1, "Jack");
preparedStatement.setString(2, "A");
preparedStatement.setString(3, "Ryan");
After setting the parameters, you can execute the prepared statement by invoking 
executeQuery() for a SELECT statement and executeUpdate() for a DDL or update 
statement.
The executeQuery() and executeUpdate() methods are similar to the ones defined 
in the Statement interface except that they don’t have any parameters, because the SQL 
statements are already specified in the prepareStatement method when the object of 
PreparedStatement is created.
Using a prepared SQL statement, Listing 32.2 can be improved as in Listing 32.3.
LISTING 32.3 FindGradeUsingPreparedStatement.java
 1 import javafx.application.Application;
 2 import javafx.scene.Scene;
 3 import javafx.scene.control.Button;
 4 import javafx.scene.control.Label;
 5 import javafx.scene.control.TextField;
 6 import javafx.scene.layout.HBox;
 7 import javafx.scene.layout.VBox;
 8 import javafx.stage.Stage;
 9 import java.sql.*;
10
Key
Point
32.5 PreparedStatement 1197
```

</details>


## PDF page 1221

<details>
<summary>Page text</summary>

```text
1198 Chapter 32  Java Database Programming
11 public class FindGradeUsingPreparedStatement extends Application {
12 // PreparedStatement for executing queries
13 private PreparedStatement preparedStatement;
14 private TextField tfSSN = new TextField();
15 private TextField tfCourseId = new TextField();
16 private Label lblStatus = new Label();
17
18    @Override // Override the start method in the Application class
19 public void start(Stage primaryStage) {
20 // Initialize database connection and create a Statement object
21      initializeDB();
22
23      Button btShowGrade = new Button("Show Grade");
24      HBox hBox = new HBox(5);
25      hBox.getChildren().addAll(new Label("SSN"), tfSSN, 
26 new Label("Course ID"), tfCourseId, (btShowGrade));
27
28      VBox vBox = new VBox(10);
29      vBox.getChildren().addAll(hBox, lblStatus);
30
31      tfSSN.setPrefColumnCount(6);
32      tfCourseId.setPrefColumnCount(6);
33      btShowGrade.setOnAction(e -> showGrade());
34
35 // Create a scene and place it in the stage
36      Scene scene = new Scene(vBox, 420, 80);
37      primaryStage.setTitle("FindGrade"); // Set the stage title
38      primaryStage.setScene(scene); // Place the scene in the stage
39      primaryStage.show(); // Display the stage
40    }
41
42 private void initializeDB() {
43 try {
44 // Load the JDBC driver
45        Class.forName("com.mysql.jdbc.Driver");
46 //      Class.forName("oracle.jdbc.driver.OracleDriver");
47        System.out.println("Driver loaded");
48
49 // Establish a connection
50        Connection connection = DriverManager.getConnection
51          ("jdbc:mysql://localhost/javabook", "scott", "tiger");
52 //    ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
53 //     "scott", "tiger");
54        System.out.println("Database connected");
55
56 String queryString = "select firstName, mi, " +
57 "lastName, title, grade from Student, Enrollment, Course " +
58 "where Student.ssn = ? and Enrollment.courseId = ? " +
59 "and Enrollment.courseId = Course.courseId";
60
61 // Create a statement
62 preparedStatement = connection.prepareStatement(queryString);
63      }
64 catch (Exception ex) {
65        ex.printStackTrace();
66      }
67    }
68
69 private void showGrade() {
70      String ssn = tfSSN.getText();
load driver
connect database
placeholder
prepare statement
```

</details>


## PDF page 1222

<details>
<summary>Page text</summary>

```text
71      String courseId = tfCourseId.getText();
72 try {
73 preparedStatement.setString( 1, ssn);
74 preparedStatement.setString( 2, courseId);
75 ResultSet rset = preparedStatement.executeQuery();
76
77 if (rset.next()) {
78          String lastName = rset.getString(1);
79          String mi = rset.getString(2);
80          String firstName = rset.getString(3);
81          String title = rset.getString(4);
82          String grade = rset.getString(5);
83
84 // Display result in a label
85          lblStatus.setText(firstName + " " + mi +
86 " " + lastName + "'s grade on course " + title + " is " +
87            grade);
88        } else {
89          lblStatus.setText("Not found");
90        }
91      }
92 catch (SQLException ex) {
93        ex.printStackTrace();
94      }
95    }
96  }
This example does exactly the same thing as Listing 32.2 except that it uses the prepared 
statement to dynamically set the parameters. The code in this example is almost the same as 
in the preceding example. The new code is highlighted.
A prepared query string is defined in lines 56–59 with ssn and courseId as parameters. 
An SQL prepared statement is obtained in line 62. Before executing the query, the actual 
values of ssn and courseId are set to the parameters in lines 73–74. Line 75 executes the 
prepared statement.
32.21 Describe prepared statements. How do you create instances of 
PreparedStatement ? How do you execute a PreparedStatement? How do 
you set parameter values in a PreparedStatement?
32.22 What are the benefits of using prepared statements?
32.6 CallableStatement
CallableStatement enables you to execute SQL stored procedures.
The CallableStatement interface is designed to execute SQL-stored procedures. The 
procedures may have IN, OUT or IN OUT  parameters. An IN parameter receives a value 
passed to the procedure when it is called. An OUT parameter returns a value after the proce-
dure is completed, but it doesn’t contain any value when the procedure is called. An IN OUT
parameter contains a value passed to the procedure when it is called and returns a value after 
it is completed. For example, the following procedure in Oracle PL/SQL has IN parameter p1,
OUT parameter p2, and IN OUT parameter p3.
create or replace procedure sampleProcedure
  (p1 in varchar, p2 out number, p3 in out integer) is
begin
  /* do something */
end sampleProcedure;
/
execute statement
show result
✓Point✓
Check
Key
Point
IN parameter
OUT parameter
IN OUT parameter
32.6 CallableStatement 1199
```

</details>


## PDF page 1223

<details>
<summary>Page text</summary>

```text
1200 Chapter 32  Java Database Programming
Note
The syntax of stored procedures is vendor specific. We use both Oracle and MySQL for 
demonstrations of stored procedures in this book.
A CallableStatement object can be created using the prepareCall(String
call) method  in the Connection interface. For example, the following code cre-
ates a CallableStatement cstmt on Connection connection for the procedure 
sampleProcedure.
CallableStatement callableStatement = connection.prepareCall(
"{call sampleProcedure(?, ?, ?)}");
{call sampleProcedure(?, ?, ...)}  is referred to as the SQL escape syntax, which 
signals the driver that the code within it should be handled differently. The driver parses 
the escape syntax and translates it into code that the database understands. In this example,
sampleProcedure is an Oracle procedure. The call is translated to the string begin
sampleProcedure(?, ?, ?); end and passed to an Oracle database for execution.
You can call procedures as well as functions. The syntax to create an SQL callable state-
ment for a function is:
{? = call functionName(?, ?, ...)}
CallableStatement inherits PreparedStatement. Additionally, the 
CallableStatement interface provides methods for registering the OUT parameters and 
for getting values from the OUT parameters.
Before calling an SQL procedure, you need to use appropriate setter methods to pass values 
toIN and IN OUT parameters, and use registerOutParameter to register OUT and IN OUT
parameters. For example, before calling procedure sampleProcedure, the following state-
ments pass values to parameters p1 (IN) and p3 (IN OUT) and register parameters p2 (OUT)
andp3 (IN OUT):
callableStatement.setString(1, "Dallas"); // Set Dallas to p1
callableStatement.setLong(3, 1); // Set 1 to p3
// Register OUT parameters
callableStatement.registerOutParameter(2, java.sql.Types.DOUBLE);
callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
You can use execute() or executeUpdate() to execute the procedure depending on the 
type of SQL statement, then use getter methods to retrieve values from the OUT parameters. 
For example, the next statements retrieve the values from parameters p2 and p3.
double d = callableStatement.getDouble(2);
int i = callableStatement.getInt(3);
Let us define a MySQL function that returns the number of the records in the table that match 
the specified firstName and lastName in the Student table.
/* For the callable statement example. Use MySQL version 5 */
drop function if exists studentFound;
delimiter //
create function studentFound(first varchar(20), last varchar(20))
returns int
begin
declare result int;
select count(*) into result
```

</details>


## PDF page 1224

<details>
<summary>Page text</summary>

```text
from Student
where Student.firstName = first and
    Student.lastName = last;
return result;
end;
//
delimiter ;
/* Please note that there is a space between delimiter and ; */
If you use an Oracle database, the function can be defined as follows:
create or replace function studentFound 
  (first varchar2, last varchar2)
/* Do not name firstName and lastName. */
return number is
  numberOfSelectedRows number := 0;
begin
select count(*) into numberOfSelectedRows
from Student
where Student.firstName = first and
    Student.lastName = last;
return numberOfSelectedRows;
end studentFound;
/
Suppose the function studentFound is already created in the database. Listing 32.4 gives an 
example that tests this function using callable statements.
LISTING 32.4 TestCallableStatement.java
 1 import java.sql.*;
 2
 3 public class TestCallableStatement {
 4 /** Creates new form TestTableEditor */
 5 public static void main(String[] args) throws Exception {
 6 Class.forName( "com.mysql.jdbc.Driver");
 7      Connection connection = DriverManager.getConnection(
 8 "jdbc:mysql://localhost/javabook",
 9 "scott", "tiger");
10 //    Connection connection = DriverManager.getConnection(
11 //      ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
12 //      "scott", "tiger");
13
14 // Create a callable statement
15 CallableStatement callableStatement = connection.prepareCall(
16 "{? = call studentFound(?, ?)}");
17
18      java.util.Scanner input = new java.util.Scanner(System.in);
19      System.out.print("Enter student's first name: ");
20      String firstName = input.nextLine();
21      System.out.print("Enter student's last name: ");
22      String lastName = input.nextLine();
23
24 callableStatement.setString( 2, firstName);
25 callableStatement.setString( 3, lastName);
26 callableStatement.registerOutParameter( 1, Types.INTEGER);
27 callableStatement.execute();
load driver
connect database
create callable statement
enterfistName
enterlastName
setIN parameter
setIN parameter
registerOUT parameter
execute statement
32.6 CallableStatement 1201
```

</details>


## PDF page 1225

<details>
<summary>Page text</summary>

```text
1202 Chapter 32  Java Database Programming
28
29 if (callableStatement.getInt(1) >= 1)
30        System.out.println(firstName + " " + lastName +
31 " is in the database");
32 else
33        System.out.println(firstName + " " + lastName +
34 " is not in the database");
35    }
36  }
getOUT parameter
Enter student's first name: Jacob
Enter student's last name: Smith
Jacob Smith is in the database
Enter student's first name: John
Enter student's last name: Smith
John Smith is not in the database
The program loads a MySQL driver (line 6), connects to a MySQL database (lines 7–9), 
and creates a callable statement for executing the function studentFound (lines 15–16).
The function’s first parameter is the return value; its second and third parameters corre-
spond to the first and last names. Before executing the callable statement, the program sets the 
first name and last name (lines 24–25) and registers the OUT parameter (line 26). The state-
ment is executed in line 27.
The function’s return value is obtained in line 29. If the value is greater than or equal to 1,
the student with the specified first and last name is found in the table.
32.23 Describe callable statements. How do you create instances of CallableStatement?
How do you execute a CallableStatement? How do you register OUT parameters 
in a CallableStatement?
32.7 Retrieving Metadata
The database metadata such as database URL, username, JDBC driver name can be 
obtained using the DatabaseMetaData interface and result set metadata such as table 
column count and column names can be obtained using the ResultSetMetaData
interface.
JDBC provides the DatabaseMetaData interface for obtaining database-wide information, 
and the ResultSetMetaData interface for obtaining information on a specific ResultSet.
32.7.1 Database Metadata
TheConnection interface establishes a connection to a database. It is within the context of a 
connection that SQL statements are executed and results are returned. A connection also provides 
access to database metadata information that describes the capabilities of the database, supported 
SQL grammar, stored procedures, and so on. To obtain an instance of DatabaseMetaData for 
a database, use the getMetaData method on a Connection object like this:
DatabaseMetaData dbMetaData = connection.getMetaData();
If your program connects to a local MySQL database, the program in Listing 32.5 displays the 
database information statements shown in Figure 32.24.
✓Point✓
Check
Key
Point
database metadata
```

</details>


## PDF page 1226

<details>
<summary>Page text</summary>

```text
32.7 Retrieving Metadata  1203
LISTING 32.5 TestDatabaseMetaData.java
 1 import java.sql.*;
 2
 3 public class TestDatabaseMetaData {
 4 public static void main(String[] args)
 5 throws SQLException, ClassNotFoundException {
 6 // Load the JDBC driver
 7 Class.forName( "com.mysql.jdbc.Driver");
 8      System.out.println("Driver loaded");
 9
10 // Connect to a database
11      Connection connection = DriverManager.getConnection
12        ("jdbc:mysql://localhost/javabook", "scott", "tiger");
13      System.out.println("Database connected");
14
15 DatabaseMetaData dbMetaData = connection.getMetaData();
16      System.out.println("database URL: " + dbMetaData.getURL());
17      System.out.println("database username: " +
18 dbMetaData.getUserName());
19      System.out.println("database product name: " +
20        dbMetaData.getDatabaseProductName());
21      System.out.println("database product version: " +
22        dbMetaData.getDatabaseProductVersion());
23      System.out.println("JDBC driver name: " +
24        dbMetaData.getDriverName());
25      System.out.println("JDBC driver version: " +
26        dbMetaData.getDriverVersion());
27      System.out.println("JDBC driver major version: " +
28        dbMetaData.getDriverMajorVersion());
29      System.out.println("JDBC driver minor version: " +
30        dbMetaData.getDriverMinorVersion());
31      System.out.println("Max number of connections: " +
32        dbMetaData.getMaxConnections());
33      System.out.println("MaxTableNameLength: " +
34        dbMetaData.getMaxTableNameLength());
35      System.out.println("MaxColumnsInTable: " +
36        dbMetaData.getMaxColumnsInTable());
37
38 // Close the connection
39      connection.close();
40    }
41  }
load driver
connect database
database metadata
get metadata
FIGURE 32.24 TheDatabaseMetaData interface enables you to obtain database information.
```

</details>


## PDF page 1227

<details>
<summary>Page text</summary>

```text
1204 Chapter 32  Java Database Programming
32.7.2 Obtaining Database Tables
You can identify the tables in the database through database metadata using the getTables
method. Listing 32.6 displays all the user tables in the javabook database on a local MySQL 
database. Figure 32.25 shows a sample output of the program.
LISTING 32.6 FindUserTables.java
 1 import java.sql.*;
 2
 3 public class FindUserTables {
 4 public static void main(String[] args)
 5 throws SQLException, ClassNotFoundException {
 6 // Load the JDBC driver
 7 Class.forName( "com.mysql.jdbc.Driver");
 8      System.out.println("Driver loaded");
 9
10 // Connect to a database
11      Connection connection = DriverManager.getConnection
12        ("jdbc:mysql://localhost/javabook", "scott", "tiger");
13      System.out.println("Database connected");
14
15 DatabaseMetaData dbMetaData = connection.getMetaData();
16
17 ResultSet rsTables = dbMetaData.getTables( null, null, null,
18 new String[] {"TABLE"});
19      System.out.print("User tables: ");
20 while (rsTables.next()) 
21        System.out.print(rsTables.getString("TABLE_NAME") + " ");
22
23 // Close the connection
24      connection.close();
25    }
26  }
load driver
connect database
database metadata
obtain tables
get table names
FIGURE 32.25 You can find all the tables in the database.
Line 17 obtains table information in a result set using the getTables method. One of the 
columns in the result set is TABLE_NAME. Line 21 retrieves the table name from this result 
set column.
32.7.3 Result Set Metadata
The ResultSetMetaData interface describes information pertaining to the result set. A 
ResultSetMetaData object can be used to find the types and properties of the columns in a 
ResultSet. To obtain an instance of ResultSetMetaData, use the getMetaData method 
on a result set like this.
ResultSetMetaData rsMetaData = resultSet.getMetaData();
```

</details>


## PDF page 1228

<details>
<summary>Page text</summary>

```text
32.7 Retrieving Metadata  1205
You can use the getColumnCount() method to find the number of columns in the result and 
thegetColumnName(int) method to get the column names. For example, Listing 32.7 dis-
plays all the column names and contents resulting from the SQL SELECT statement select
* from Enrollment. The output is shown in Figure 32.26.
LISTING 32.7 TestResultSetMetaData.java
 1 import java.sql.*;
 2
 3 public class TestResultSetMetaData {
 4 public static void main(String[] args)
 5 throws SQLException, ClassNotFoundException {
 6 // Load the JDBC driver
 7 Class.forName( "com.mysql.jdbc.Driver");
 8      System.out.println("Driver loaded");
 9
10 // Connect to a database
11      Connection connection = DriverManager.getConnection
12        ("jdbc:mysql://localhost/javabook", "scott", "tiger");
13      System.out.println("Database connected");
14
15 // Create a statement
16      Statement statement = connection.createStatement();
17
18 // Execute a statement
19      ResultSet resultSet = statement.executeQuery
20        ("select * from Enrollment");
21
22 ResultSetMetaData rsMetaData = resultSet.getMetaData();
23 for (int i = 1; i <= rsMetaData.getColumnCount(); i++) 
24        System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
25      System.out.println();
26
27 // Iterate through the result and print the students' names
28 while (resultSet.next()) {
29 for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
30          System.out.printf("%-12s\t", resultSet.getObject(i));
31        System.out.println();
32      }
33
34 // Close the connection
35      connection.close();
36    }
37  }
load driver
connect database
create statement
create result set
result set metadata
column count
column name
FIGURE 32.26 TheResultSetMetaData interface enables you to obtain result set 
information.
```

</details>


## PDF page 1229

<details>
<summary>Page text</summary>

```text
1206 Chapter 32  Java Database Programming
32.24 What is DatabaseMetaData for? Describe the methods in DatabaseMetaData.
How do you get an instance of DatabaseMetaData?
32.25 What is ResultSetMetaData for? Describe the methods in ResultSetMetaData.
How do you get an instance of ResultSetMetaData?
32.26 How do you find the number of columns in a result set? How do you find the column 
names in a result set?
✓Point✓
Check
KEY TERMS
candidate key 1177
database system 1174
domain constraint 1177
foreign key 1177
foreign key constraint 1177
integrity constraint 1176
primary key 1177
relational database 1177
Structured Query Language (SQL) 1178
superkey 1177
CHAPTER SUMMARY
1. This chapter introduced the concepts of database systems , relational databases ,
relational data models, data integrity, and SQL. You learned how to develop database 
applications using Java.
2. The Java API for developing Java database applications is called JDBC. JDBC provides 
Java programmers with a uniform interface for accessing and manipulating relational 
databases.
3. The JDBC API consists of classes and interfaces for establishing connections with data-
bases, sending SQL statements to databases, processing the results of SQL statements, 
and obtaining database metadata.
4. Since a JDBC driver serves as the interface to facilitate communications between JDBC 
and a proprietary database, JDBC drivers are database specific. A JDBC-ODBC bridge 
driver is included in JDK to support Java programs that access databases through ODBC 
drivers. If you use a driver other than the JDBC-ODBC bridge driver, make sure it is in 
the classpath before running the program.
5. Four key interfaces are needed to develop any database application using Java: Driver,
Connection,Statement, and ResultSet. These interfaces define a framework for 
generic SQL database access. The JDBC driver vendors provide implementation for them.
6. A JDBC application loads an appropriate driver using the Driver interface, connects 
to the database using the Connection interface, creates and executes SQL statements 
using the Statement interface, and processes the result using the ResultSet interface 
if the statements return results.
7. The PreparedStatement interface is designed to execute dynamic SQL statements
with parameters. These SQL statements are precompiled for efficient use when 
repeatedly executed.
8. Database metadata is information that describes the database itself. JDBC provides 
the DatabaseMetaData interface for obtaining database-wide information and the 
ResultSetMetaData interface for obtaining information on the specific ResultSet.
```

</details>


## PDF page 1230

<details>
<summary>Page text</summary>

```text
Programming Exercises  1207
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
*32.1 (Access and update a Staff table) Write a program that views, inserts, and 
updates staff information stored in a database, as shown in Figure  32.27a. The 
View button displays a record with a specified ID. The Insert button inserts a new 
record. The Update button updates the record for the specified ID. The Staff
table is created as follows:
create table Staff (
  id char(9) not null,
  lastName varchar(15),
  firstName varchar(15),
  mi char(1),
  address varchar(20),
  city varchar(20),
  state char(2),
  telephone char(10),
  email varchar(40),
  primary key (id)
);
FIGURE 32.27 (a) The program lets you view, insert, and update staff information. (b) The PieChart and BarChart
components display the query data obtained from the data module.
(a) (b)
**32.2 (Visualize data) Write a program that displays the number of students in each 
department in a pie chart and a bar chart, as shown in Figure 32.27b. The number 
of students for each department can be obtained from the Student table (see 
Figure 32.4) using the following SQL statement:
select deptId, count(*)
from Student
where deptId is not null
group by deptId;
*32.3 (Connection dialog) Develop a subclass of BorderPane named DBConnectionPane
that enables the user to select or enter a JDBC driver and a URL and to enter a user-
name and password, as shown in Figure 32.28. When the Connect to DB button is 
clicked, a Connection object for the database is stored in the connection prop-
erty. You can then use the getConnection() method to return the connection.
```

</details>


## PDF page 1231

<details>
<summary>Page text</summary>

```text
1208 Chapter 32  Java Database Programming
*32.4 (Find grades) Listing 32.2, FindGrade.java, presented a program that finds a stu-
dent’s grade for a specified course. Rewrite the program to find all the grades for 
a specified student, as shown in Figure 32.29.
FIGURE 32.28 TheDBConnectionPane component enables the user to enter database information.
FIGURE 32.29 The program displays the grades for the courses for a specified student.
FIGURE 32.30 (a) Enter a table name to display the table contents. (b) Select a table name from the combo box to 
display its contents.
(a) (b)
*32.5 (Display table contents ) Write a program that displays the content for a given 
table. As shown in Figure 32.30a, you enter a table and click the Show Contents
button to display the table contents in the text area.
*32.6 (Find tables and showing their contents) Write a program that fills in table names 
in a combo box, as shown in Figure 32.30b. You can select a table from the combo 
box to display its contents in the text area.
**32.7 (Populate Quiz table) Create a table named Quiz as follows:
create table Quiz(
  questionId int,
  question varchar(4000),
  choicea varchar(1000),
```

</details>


## PDF page 1232

<details>
<summary>Page text</summary>

```text
Programming Exercises  1209
  choiceb varchar(1000),
  choicec varchar(1000),
  choiced varchar(1000),
  answer varchar(5));
The Quiz table stores multiple-choice questions. Suppose the multiple-choice 
questions are stored in a text file accessible from www.cs.armstrong.edu/liang/data/
Quiz.txt in the following format:
1. question1
a. choice a
b. choice b
c. choice c
d. choice d
Answer:cd
2. question2
a. choice a
b. choice b
c. choice c
d. choice d
Answer:a
...
Write a program that reads the data from the file and populate it into the Quiz
table.
*32.8 (Populate Salary table) Create a table named Salary as follows:
create table Salary(
  firstName varchar(100),
  lastName varchar(100),
  rank varchar(15),
  salary float);
Obtain the data for salary from http://cs.armstrong.edu/liang/data/Salary.txt and popu-
late it into the Salary table in the database.
*32.9 (Copy table) Suppose the database contains a student table defined as follows:
create table Student1 (
  username varchar(50) not null,
  password varchar(50) not null,
  fullname varchar(200) not null,
constraint pkStudent primary key (username)
);
Create a new table named Student2 as follows:
create table Student2 (
  username varchar(50) not null,
  password varchar(50) not null,
  firstname varchar(100),
  lastname varchar(100),
constraint pkStudent primary key (username)
);
A full name is in the form of firstname mi lastname or firstname 
lastname. For example, John K Smith  is a full name. Write a program that
```

</details>


## PDF page 1233

<details>
<summary>Page text</summary>

```text
1210 Chapter 32  Java Database Programming
copies table Student1 into Student2. Your task is to split a full name into 
firstname, mi, and lastname for each record in Student1 and store a new 
record into Student2.
*32.10 (Record unsubmitted exercises) The following three tables store information on 
students, assigned exercises, and exercise submission in LiveLab. LiveLab is an 
automatic grading system for grading programming exercises.
create table AGSStudent (
  username varchar(50) not null,
  password varchar(50) not null,
  fullname varchar(200) not null,
  instructorEmail varchar(100) not null,
constraint pkAGSStudent primary key (username)
);
create table ExerciseAssigned (
  instructorEmail varchar(100),
  exerciseName varchar(100),
  maxscore double default 10,
constraint pkCustomExercise primary key
    (instructorEmail, exerciseName)
);
create table AGSLog (
  username varchar(50), /* This is the student's user name */
  exerciseName varchar(100), /* This is the exercise */
  score double default null,
  submitted bit default 0,
constraint pkLog primary key (username, exerciseName)
);
TheAGSStudent table stores the student information. The ExerciseAssigned
table assigns the exercises by an instructor. The AGSLog table stores the grading 
results. When a student submits an exercise, a record is stored in the AGSLog table. 
However, there is no record in AGSLog if a student did not submit the exercise.
Write a program that adds a new record for each student and an assigned exercise 
to the student in the AGSLog table if a student has not submitted the exercise. 
The record should have 0 on score and submitted. For example, if the tables 
contain the following data in AGSLog before you run this program, the AGSLog
table now contains the new records after the program runs.
AGSStudent
username password fullname instructorEmail
abc p1 John Roo t@gmail.com
cde p2 Yao Mi c@gmail.com
wbc p3 F3 t@gmail.com
ExerciseAssigned
instructorEmail exerciseName maxScore
t@gmail.com e1 10
t@gmail.com e2 10
c@gmail.com e1 4
c@gmail.com e4 20
```

</details>


## PDF page 1234

<details>
<summary>Page text</summary>

```text
Programming Exercises  1211
*32.11 (Baby names) Create the following table:
create table Babyname (
  year integer,
  name varchar(50),
  gender char(1),
  count integer,
constraint pkBabyname primary key (year, name, gender)
);
The baby name ranking data was described in Programming Exercise 12.31. Write 
a program to read data from the following URL and store into the Babyname table.
http://www.cs.armstrong.edu/liang/data/babynamesranking2001.txt,
…
http://www.cs.armstrong.edu/liang/data/babynamesranking2010.txt.
AGSLog
username exerciseName score submitted
abc e1 9 1
wbc e2 7 1
AGSLog after the program runs
username exerciseName score submitted
abc e1 9 1
wbc e2 7 1
abc e2 0 0
wbc e1 0 0
cde e1 0 0
cde e4 0 0
```

</details>


## PDF page 1235

<details>
<summary>Page text</summary>

```text
This page intentionally left blank
```

</details>
