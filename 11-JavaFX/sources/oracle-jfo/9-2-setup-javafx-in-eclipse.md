# 9-2 Setup JavaFX in Eclipse

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 9-2 Setup JavaFX in Eclipse.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
1 
Supplemental Instructions for JavaFX 
on JDK 17 in Eclipse 
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
1. Navigate to the JavaFX Product page: https://gluonhq.com/products/javafx/. 
2. Scroll down the page and download the software development kit (SDK) zip for your 
operating system. 
3. Inside this zip you’ll see a folder such as javafx-sdk-17.0.1. Extract and add this folder to a 
known location. 
4. Your system will refer to this location each time it needs JavaFX. 
• Example for Windows: 
- Extract to the folder C:\Program Files\Java\
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
2 
5. Install the JavaFX plugins to Eclipse: 
a. Start Eclipse and select Help from the menu. 
b. Select Eclipse Marketplace from the drop-down menu. 
 
c. Type fx in the search bar, and then click the Go button.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
3 
d. Select the latest version of e(fx)clipse and click the Install button. 
 
e. Agree to the terms of the license agreement and click Finish. 
 
f. Eclipse will install the selected software (this may take a few minutes). 
g. When the software is installed, you will be asked to restart Eclipse, click Restart Now 
to complete the installation.
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
4 
6. Add the libraries to Eclipse. 
a. In Eclipse, navigate to Window > Preferences. 
 
b. From the options expand: Java > Build Path > User Libraries.  Click New. 
 
c. Name the library JavaFX17 and click OK.
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
5 
d. Click Add External JARs…
 
e. Navigate to the lib folder, select the eight JAR files, and click Open.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
6 
f. Click Apply and Close.
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
7 
Part 2: Create a New JavaFX Project in Eclipse 
Overview 
Leading up to JDK 9, Java underwent a process of modularization. Modularization is what allowed 
for the decoupling of JavaFX libraries from the core JDK. Your programs can also be constructed as 
modules. Modularization however is not covered in this course. These instructions will show you 
how to create a non-modular Java FX project. 
The following tasks are required for every new JavaFX project. 
Tasks 
1. Ensure that you’ve completed Part 1. 
2. Launch Eclipse. 
3. Go to File > New > Java Project. 
4. Name the project, and then click Next.
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
8 
5. Click the Libraries tab, click Classpath, and then Add Library. 
 
6. Select User Library > Next.
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
9 
7. Select JavaFX17, which you created in Part 1, and click Finish to close the User Libraries tab, 
then Finish to create the project.
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
10 
8. Copy the supplied JavaFXMain.java file to the project package (ignore any errors at this 
point).  
 
9. Click the down arrow next to the Run button and select Run Configurations.
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
11 
10. Double click Java Application in the filter pane and click JavaFXMain. Click the Arguments 
tab.
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. Other 
names may be trademarks of their respective owners. 
12 
11. Enter the text below into the VM Arguments window: (Assuming you’ve added the JavaFX 
SDK to the location specified in Part 1). 
• This helps provide access to the relevant JavaFX modules 
• You may need to add more if your projects grow more complex and make use of other 
aspects of JavaFX 
• Update highlighted text below as necessary to match your sdk version 
--module-path "C:\Program Files\Java\javafx-sdk-17.0.1\lib" --
add-modules javafx.media,javafx.controls,javafx.fxml 
 
12.  
Click Run. 
13. As your JavaFX programs grow more complicated, you may need to include other modules 
for the additional functionality. JavaFX modules include: 
• javafx.base 
• javafx.control 
• javafx.fxml 
• javafx.graphics 
• javafx.media 
• javafx.swing 
• javafx.web
```

</details>
