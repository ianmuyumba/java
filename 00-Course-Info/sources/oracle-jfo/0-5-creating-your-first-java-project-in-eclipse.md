# 0-5 Creating Your First Java Project in Eclipse

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 0-5 Creating Your First Java Project in Eclipse.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
1 
Creating your first Java Projects in Eclipse 
Part 1: Create a Java Project and add an existing .java file 
Overview 
In this section, you will download the HelloWorld.zip, create a new project in Eclipse, and add an 
existing .java file to the project. 
Tasks 
1. Download the zip file HelloWorld.zip for this practice. Extract the zip file, noting the 
location. 
 
2. Launch Eclipse. 
 
3. Go to File > New > Java Project. 
a. Add the Project name: HelloWorld 
 
4. Click Finish.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
2 
5. When prompted to create module, click Don’t Create.
 
 
6. Click the Restore icon to see the Package Explorer window (if it is not open).
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
3 
7. In the Package Explorer window, click the arrow to expand the project and show the src 
package folder. 
 
 
8. Navigate to the folder in which you extracted the HelloWorld.zip file in step 1 and select the 
HelloWorld.java file.   
 
9. Drag the HelloWorld.java file from the folder on your device and drop it on the src package 
folder.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
4 
10. When prompted, select Copy files and click OK.
 
 
11. Click the arrow next to the src package folder, then click the arrow next to (default 
package) and you will see the HelloWorld.java file in the package. Double-click the 
HelloWorld.java file and it will open in a new tab in the Code Editor window.
 
 
12. Click the Run button to test.
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
5 
13. In the Console window below the Code Editor, you will see the message “Hello World!”
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
6 
Part 2: Create a Project in Eclipse with a main class 
Overview 
In this section, you will create and run an Eclipse java project with a main Java class. 
Tasks 
1. Launch Eclipse if not opened. 
 
2. Go to File > New > Java Project and select the following: 
a. Add the project name – MySecondProject 
 
3. Click Finish.
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
7 
4. When prompted to create module, click Don’t Create. 
 
 
5. In the Package Explorer, right-click on the project MySecondProject and click New > 
Package. In the New Java Package window, enter the Name: mysecondproject and click 
Finish.
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
8 
6. In the Package Explorer, right-click on the package mysecondproject and click New > 
Class. In the New Java Class window, enter the Name: HelloMain, check the box to create 
public static void main(String[] args) and click Finish. The newly created HelloMain class 
will open in a new tab in the Code Editor.
 
 
7. In the Code Editor, locate the main method of the HelloMain class and enter the line of code 
as shown below:  
System.out.println("Hello again world");
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
9 
8. Ensure the class HelloMain is highlighted in the Package Explorer, then click the Run button 
to test (or click the small down arrow at the right of the Run button and select which .java 
file you want to run). If prompted, click OK to save the changes. You should see the message 
“Hello again world” displayed in the Console output at the bottom of the IDE.
 
  
Note an important difference between the first project and the second project. In Task 5 of 
MySecondProject, you added a package explicitly, and named it mysecondproject. 
 
 
In Part1, you did not create a Main Class.  You simply dragged an existing .java file into the src 
package folder; the package was implicitly created and named (default package) by Eclipse.  
If a package has a name other than (default package), it is important to note that a package 
declaration must be included as the first line of code in the .java file. If you explicitly create a class in 
an existing package, Eclipse will automatically add the package declaration for you.  
In the Code Editor for your second project, scroll to the top of the code and you will see the package 
declaration.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
10 
 
Observe that in your first project, the package was (default package). If you scroll to the top of the 
.java file in the Code Editor, you will see that there is no package declaration. 
If you add an existing .java file to a package that has already been named, you need to add the 
package declaration manually as the first line of code in the  .java file using the format: 
package packagename;
```

</details>
