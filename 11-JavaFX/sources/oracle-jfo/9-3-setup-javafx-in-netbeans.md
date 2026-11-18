# 9-3 Setup JavaFX in NetBeans

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 9-3 Setup JavaFX in NetBeans.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
1 
Supplemental Instructions for JavaFX 
on JDK 17 in NetBeans 
Part 1: Download and Setup JavaFX Libraries for JDK 17 
Overview 
The JavaFX platform lets you create graphical user interface (GUI) driven applications for desktops, 
web browsers, and mobile devices. JavaFX libraries were originally included within the core Java SE 
platform until Java SE 11. The decision to decouple JavaFX from the core JDK allows the JavaFX 
libraries to be maintained by its passionate open-source community. If you are using Oracle JDK11 
or later, you must manually download and setup the JavaFX libraries to write JavaFX applications. 
Instructions to do so in this document are based on material from https://openjfx.io/openjfx-
docs/. 
Tasks 
1. Navigate to the JavaFX Product page: https://gluonhq.com/products/javafx/ 
2. Scroll down the page and download the software development kit (SDK) zip for your 
operating system. 
3. Inside this zip you’ll see a folder such as javafx-sdk-17.0.1. 
4. Extract and add this folder to a known location. 
5. Your system will refer to this location each time it needs JavaFX. 
• Example for Windows: 
- Extract to the folder C:\Program Files\Java\ 
6. Add an environment variable that points to the JavaFX runtime lib directory: 
• Example for Windows: 
- Press the Start button 
- Type cmd, and then press Enter to open a Command Prompt 
- Type the following and press enter: 
set PATH_TO_FX="C:\Program Files\Java\javafx-sdk-17.0.1\lib" 
• For Linux and Mac: 
- Open a terminal
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
2 
- Type the following and press Enter. Of course, replace path/to with the relevant 
directory: 
export PATH_TO_FX=path/to/javafx-sdk-17.0.1/lib 
7. Add the libraries to NetBeans. 
a. In NetBeans, navigate to Tools > Libraries. 
b. Click New Library... 
c. Name the library JavaFX17 and click OK. 
d. Click Add JAR/Folder… 
e. Navigate to the lib folder, select the eight JAR files, and click Add JAR/Folder 
f. Click OK.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
3 
Part 2: Create a New JavaFX Project in NetBeans 
Overview 
To date, NetBeans 12.5 has trouble generating new JavaFX projects. However, there is a simple 
workaround, which involves creating and modifying a new regular Java project. 
Leading up to JDK 9, Java underwent a process of modularization. Modularization is what allowed 
for the decoupling of JavaFX libraries from the core JDK. Your programs can also be constructed as 
modules. Modularization however is not covered in this course. These instructions will show you 
how to create a non-modular Java FX project. 
Please note that the following Tasks are required for each JavaFX project 
Tasks 
1. Ensure that you’ve completed Part 1. 
2. Launch NetBeans. 
3. Go to File > New Project and select the following: 
• Categories: Java with Ant 
• Projects: Java Application 
4. Click Next. 
5. Name the project, un-check to create a main class, and click Finish. 
6. Add the supplied JavaFXMain.java file (drag and drop) to the project package (ignore any 
errors at this point). 
7. Right click on the project and select Properties.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
4 
8. Select Libraries from the left pane of the Project Properties window. 
a. Click the + button for Classpath. 
b. Select Add Library. 
 
9. Select JavaFX17, which you created in Part 1, and click Add Library. 
10. Select Run from the left pane of the Project Properties window. 
11. Enter the text below into the VM Arguments window: (Assuming you’ve added the JavaFX 
SDK to the location specified in Part 1). 
• This helps provide access to the relevant JavaFX modules 
• You may need to add more if your projects grow more complex and make use of other 
aspects of JavaFX
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
5 
• Update highlighted text below as necessary to match your sdk version 
--module-path "C:\Program Files\Java\javafx-sdk-17.0.1\lib" --
add-modules javafx.media,javafx.controls,javafx.fxml 
 
12. A
s your JavaFX programs grow more complicated, you may need to include other modules 
for the additional functionality. JavaFX modules include: 
• javafx.base 
• javafx.control 
• javafx.fxml 
• javafx.graphics 
• javafx.media 
• javafx.swing 
• javafx.web 
13. Click OK.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners.  
6 
14. If you get an error similar to the following: 
Error occurred during initialization of boot layer 
java.lang.module.FindException: Module javafx.controls not found 
Right click on the project, select Properties > Build > Compiling and un-check Compile on 
Save, and then run again.
```

</details>
