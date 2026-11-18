# 0-6 Creating Your First Java Project in NetBeans

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 0-6 Creating Your First Java Project in NetBeans.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
1 
Creating your first Java Projects in NetBeans 
Part 1: Create a Java Project and add an existing .java file 
Overview 
In this section, you will download the HelloWorld.zip, create a new project in NetBeans, and add an 
existing .java file to the project. 
Tasks 
1. Download the zip file HelloWorld.zip for this practice. Extract the zip file, noting the 
location. 
 
2. Launch NetBeans. 
 
3. Go to File > New Project and select the following: 
a. Categories: Java with Ant 
b. Projects: Java Application 
 
4. Click Next >.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
2 
5. Name the project MyFirstProject.  Uncheck the box to Create Main Class and click Finish.
 
 
6. In the Projects window, click the plus sign to expand the project and click the plus sign to 
expand Source Packages to show the <default package>.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
3 
7. Navigate to the folder in which you extracted the HelloWorld.zip file in step 1 and select the 
HelloWorld.java file. 
 
8. Drag the HelloWorld.java file from the folder on your device and drop it in <default 
package>. 
 
 
9. Click the plus sign next to <default package> and you will see the HelloWorld.java file in 
the package. Double-click the HelloWorld.java file and it will open in a new tab in the Code 
Editor window.
 
 
10. Click the Run button to test.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
4 
11. If prompted to Select the main class, select the default HelloWorld and click OK.
 
 
12. In the Output window below the Code Editor, you will see the message “Hello World!”
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
5 
Part 2: Create a Project in NetBeans with a main class 
Overview 
In this section, you will create and run a NetBeans java project with a main Java class. 
Tasks 
1. Launch NetBeans if not opened. 
 
2. Go to File > New Project and select the following: 
a. Categories: Java with Ant 
b. Projects: Java Application 
 
3. Click Next >.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
6 
4. Name the project MySecondProject.  Check the box to Create Main Class and click Finish. 
 
 
5. In the Code Editor, locate the main method of the MySecondProject class and enter the line 
of code as shown below:  
System.out.println("Hello again world");
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
7 
6. Click the Run button to test. You should see the message “Hello again world” displayed in 
the Output console at the bottom of the IDE.
 
 
Note an important difference between the first project and the second project. In 
MySecondProject, when the Create Main Class box is checked in Task 4, a named package is also 
created. NetBeans adds a suggested package and class name based on the name of the project. 
 
The format of the suggested name is packagename.MainClassName, in this case 
mysecondproject.MySecondProject.  You can edit the names at this point if you want something 
other than the suggested naming format.
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
Copyright © 2024, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
8 
In Part 1, as you did not create a Main Class, the package was named <default package>. If a 
package has a name other than <default package>, it is important to note that a package 
declaration must be included as the first line of code in the .java file. If you create a class in an 
existing package, NetBeans will automatically add the package declaration for you. In the Code 
Editor for your second project, scroll to the top of the code and you will see the package declaration. 
 
Observe that in your first project, as the package was <default package>, if you scroll to the top of 
the .java file in the Code Editor, you will see that there is no package declaration. 
If you add an existing  .java file to a package that has been named, you need to add the package 
declaration manually, as the first line of code in the .java file using the format: 
package packagename;
```

</details>
