# 9-1 Introduction to JavaFX

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 9-1 Introduction to JavaFX.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text

```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Java Foundations
9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Create a JavaFX project
- Explain the components of the default JavaFX project
- Describe different types of Nodes and Panes
- Explain the Scene Graph, Root Node, Scenes, and Stages
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
It’s Almost Time for Final Exams!
• It’s important to study
• Do you like to study with friends?
- But do your friends live in other dorms?
- Where is the best place to meet your friends?
- What is the most centrally located point on campus?
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
JavaFX Can Help
• JavaFX is used to create GUI applications
• GUI: Graphical user interface
• A GUI application allows us to see the answer on a map
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• The reference material for this slide C ampusMap.mp4 
demonstrates a completed application written using JavaFX
• Play CampusMap.m p4
• Each square is aligned with the correct dorm on the map
• Each dorm’s population is adjusted by clicking and dragging the 
t
ext below each square
• Observe changes in the following center points:
- All students in all dorms
- A study group of three friends living in Dorms 1, 2, and 4 
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
But That’s Not my Campus!
• You’re right
• It would be better if the program used your school’s …
- Map of campus
- Dorm names
- Dorm populations
- And your group of friends
• That’s this section’s problem set
• Section 9 discusses everything you’ll need to re-c reate the 
program
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 1 of 2
• Create a J avaFX  project
- The reference material for this lesson provided instructions to 
c
reate a JavaFX project in NetBeans or Eclipse
- If you are using a different IDE, consult the documentation for the 
s
teps to do this
• Experiment with the program 
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2, 2 of 2
• Can you make these changes?
- Change the button’s label
- Change what’s printed when the button is clicked
- Create another button and display both buttons
- Change the default size of the application’s window
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Default JavaFX Project, 1 of 2
public class JavaFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn); Continued on next slide…
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Default JavaFX Project, 2 of 2
… continued
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }//end method start
    public static void main(String[] args) {
        launch(args);
    }//end method main
}//end class JavaFXMain 
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Two Methods: start() and main()
•start() i s the entry point for all JavaFX applications 
- Think of it as the main method for JavaFX
public void start(Stage primaryStage) {
    …
    }//end method start
•main() i s still required in your programs
- It launches the JavaFX application
public static void main(String[] args) {
        launch(args);
    }//end method main
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Buttons Are Objects, 1 of 2
• Buttons are like any other object
- They can be instantiated
- They contain fields
- They contain methods
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Buttons Are Objects, 2 of 2
public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
    …
    }//end method start
• From this code, we can tell …
- Buttons contain a text field
- Buttons contain a method for changing the text field
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Buttons Are Nodes
• Some of these fields and methods are designed to store and 
ma
nipulate visual properties:
-btn.getText()
-btn.setMinHeight()
-btn.setLayoutX()   //set x position
-btn.setLayoutY()   //set y position
-btn.isPressed()  //is it  pressed?
• Objects like this are called JavaFX Nodes
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Nodes
• There are many types of JavaFX Nodes:
• Visual objects you’ll create will most likely …
- Be a Node, or
- Include a Node as a field
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Node Interaction, 1 of 2
• The following helps handle Button interaction:
public void start(Stage primaryStage) {
   … 
   btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
         System.out.println("Hello World!");
      }//end method handle
   });//end setOnAction 
   …
}//end method start
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Node Interaction, 2 of 2
• This is called an “a nonymous inner class”
- Doesn’t the syntax look messy?
- Java SE 8 Lambda expressions are an elegant alternative
- We’ll discuss Lambda expressions later in this section
public void start(Stage primaryStage) {
   … 
   btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
         System.out.println("Hello World!");
      }//end method handle
   });//end setOnAction 
   …
}//end method start
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Creating Nodes
• Nodes are instantiated like any other Java object:
public void start(Stage primaryStage) {
   Button btn1 = new Button();
   Button btn2 = new Button();
   btn1.setText("Say 'Hello World'");
   btn2.setText("222");
   …
}//end method start
• After you instantiate a Node:
- It exists and memory is allocated to store the object
- Its fields can be manipulated, and methods can be called
- But it might not be displayed … 
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Displaying Nodes, 1 of 2
• There are a few steps to displaying a node
public void start(Stage primaryStage) {
   Button btn1 = new Button();
   Button btn2 = new Button();
   btn.setText("Say 'Hello World'");
   btn.setText("222");
   StackPane root = new StackPane();
   root.getChildren().add(btn1);
   root.getChildren().add(btn2);
   …
}//end method start
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Displaying Nodes, 2 of 2
• First, add each Node to the Root Node
- It’s usually named root
- It’s very much like an ArrayList  of all Nodes
public void start(Stage primaryStage) {
   Button btn1 = new Button();
   Button btn2 = new Button();
   btn.setText("Say 'Hello World'");
   btn.setText("222");
   StackPane root = new StackPane();
   root.getChildren().add(btn1);
   root.getChildren().add(btn2);
   …
}//end method start
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Adding Nodes to the Root Node, 1 of 2
• You could add each Node separately:
root.getChildren().add(btn1);
root.getChildren().add(btn2);
root.getChildren().add(btn3);
• Or you could add many Nodes at once:
root.getChildren().addAll(btn1, btn2, btn3);
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Adding Nodes to the Root Node, 2 of 2
• But don’t add the same Node more than once
- This causes a compiler error:
root.getChildren().add(btn1);
root.getChildren().add(btn1);
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
StackPane Root Node
• The Root Node in this example is a StackPane
StackPane root = new StackPane();
root.getChildren().addAll(btn1, btn2);
- The StackPane  stacks Nodes on top of 
each other
- But small buttons could become buried 
an
d unreachable
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Panes as Root Nodes
• Each Pane determines the layout of Nodes
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Programming Different Panes as Root Nodes
• It's easy to design the root  node as a different pane
• Just specify a different reference type and object type
StackPane root = new StackPane();
root.getChildren().addAll(btn1, btn2);
TilePane root = new TilePane();
root.getChildren().addAll(btn1, btn2);
VBox root = new VBox();
root.getChildren().addAll(btn1, btn2);
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Edit your current JavaFX project
- We’re going to do a little experimenting
• After adding a button to the Root Node, try to change its position
-  btn1.setLayoutY(100);
• Will a button’s position change if the Root Node wasn't a 
StackPane? 
• Try these alternatives:
-TilePane -VBox -Group
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Group Root Node
• A G roup allows you to place Nodes anywhere
Group root = new Group();
root.getChildren().addAll(btn1, btn2);
btn1.setLayoutY(100);
• A pane may restrict where Nodes are placed
- You couldn’t move them even if you wanted to
- You couldn’t click and drag a node that’s locked in a pane
StackPane root = new StackPane();
root.getChildren().addAll(btn1, btn2);
btn1.setLayoutY(100);           //Has no effect
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
A Group Can Contain a Pane
• Panes are also Nodes
- Any node can be added to the Root Node
• A Pane may be a good option for storing buttons, text input 
d
ialog boxes, and other GUI elements
- You can’t quite move individual Nodes in a Pane
- But you can move the entire Pane in a Group
- Move the Pane like you would any other Node
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4
• Edit your current JavaFX project
- It’s time for more experimenting
• Can you figure out how to do the following?
- Create an HBox  pane and add several buttons to it
- Add the HBox  pane to a Group Root Node
- Position the HBox n ear the bottom of the window
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The JavaFX Scene Graph
• How you decide to add nodes can be drawn as a Scene Graph
- The Root Node contains an Hbox
- The HBox  acts as a container for buttons
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Scene Graph
• The HBox  keeps the GUI organized and conveniently located
• The rest of the window could be used for other Nodes 
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Scene and Stage
• If we look at the rest of the default JavaFX program, we notice 
t
wo more things:
- A Scene  (which contains the root Node)
- A Stage  (which contains the scene)
public void start(Stage primaryStage) {
   …
   Scene scene = new Scene(root, 300, 250);
        
   primaryStage.setTitle("Hello World!");
   primaryStage.setScene(scene);
   primaryStage.show();    
}//end method start
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is the Scene?
• There are a few notable properties that describe a Scene:
- Scene Graph
• The Scene is the container for all content in the JavaFX Scene Graph
- Size
• The width and height of the Scene can be set
- Background
• The background can be set as a Color or BackgroundImage
- Cursor Information
• The Scene can detect mouse events and handles cursor properties
Scene scene = new Scene(root, 300, 250, Color.BLACK);
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Is the Stage?
• Think of the Stage as the application window
• Here are two notable Stage properties:
- Title
• The Title of the Stage can be set
- Scene
• The Stage contains a Scene
primaryStage.setTitle("Hello World!");
primaryStage.setScene(scene);
primaryStage.show();    
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Hierarchy Animation
• A Stage is the top- level container
• A Stage contains a Scene
• A Scene contains a Root Node
• The Root Node contains other 
N
odes
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Many Scenes, One Stage
• It’s possible to swap any scene into a single Stage
37
```

</details>


## PDF page 38

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Many Scenes, Many Stages
• It’s also possible to create many Stages
38
```

</details>


## PDF page 39

<details>
<summary>Page text</summary>

```text
JFo 9-1
Introduction to JavaFX
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• This lesson covers the following objectives:
- Create a JavaFX project
- Explain the components of the default JavaFX project
- Describe different types of Nodes and Panes
- Explain the Scene Graph, Root Node, Scenes, and Stages
39
```

</details>


## PDF page 40

<details>
<summary>Page text</summary>

```text

```

</details>
