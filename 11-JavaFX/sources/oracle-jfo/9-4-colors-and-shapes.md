# 9-4 Colors and Shapes

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 9-4 Colors and Shapes.pdf

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
9-2
Colors and Shapes
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Guess What, Boys and Girls?!
• Today we’re going to learn about colors and shapes!
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Create and use custom colors
- Create shapes and explain their properties and behaviors
- Reference the JavaFX API Documentation
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
What Can I Do with Colors in JavaFX?
• Color shapes
• Create gradients
• Colorize images
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
JavaFX Contains a Color Class
• Colors can be stored as variables:
Color color = Color.BLUE;
• Colors can be passed in methods:
Scene scene = new Scene(root, 300, 250, Color.BLACK);
- This example makes the scene’s background black
• But before using any Color …
- You’ll first need to make the following import:
import javafx.scene.paint.Color;
- Ignore your IDE’s other Color import suggestions
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Referencing a Color
• There are many colors in JavaFX
• Typing Color.  in your IDE reveals the entire list of possible 
colors
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Customizing a Color
• If you’re unhappy with the colors that JavaFX provides, there are 
wa
ys to customize your own color
• The Color cl ass contains methods to do this:
- Customize a color by mixing red, green, and blue components
- Opacity can also be controlled
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Range of Color Components
Component Range of values
Red 0–255
Green 0–255
Blue 0–255
Opacity 0.0–1.0
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Color Example
• In this example, the resulting color contains …
Color color = Color.rgb(255, 255, 20);
- As much Red as possible
- As much Green as possible
- Only a little Blue
• The resulting color is very close to yellow
- But how do we know this?
- For the most part, finding the perfect color is “guess and check,” 
b
ut there are guiding principles
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Rules of Additive Color Mixing
Code Examples: Color Description
Color.rgb(255, 0, 0); Red Pure red
Color.rgb(0, 255, 0); green Pure green
Color.rgb(0, 0, 255); blue Pure blue
Color.rgb(255, 255, 0); yellow No blue
Color.rgb(0, 0, 0); black No color
Color.rgb(255, 255, 255); white All color
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1
• Create a new JavaFX project using Ja vaFXMainEx1.java 
- JavaFXMainEX1.java is  a copy of JavaFXMain.java
- Change the Root Node to a Group type
- Remove the button and any other unnecessary code relating to the 
b
utton
• Experiment with customizing colors
- Create a few custom colors
- Admire your custom colors through the scene’s background by 
p
roviding  a Color argument when the Scene is instantiated
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
This Is a Rectangle
• This is how to instantiate a JavaFX Rectangle:
Rectangle rect = new Rectangle(20, 20, 100, 200);
• You’ll first need to make the following import:
import javafx.scene.shape.Rectangle;
- Ignore your IDE’s other Rectangle import suggestions
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Important Methods for Rectangles, 1 of 2
• We can get a sense of a Rectangle’s properties from the 
con
structor and the following methods:
-setX(double d) 
-setY(double d)
-setWidth(double d)
-setHeight(double d)
-setFill(Paint paint)
-setStroke(Paint paint)
-setStrokeWidth(double d)
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Important Methods for Rectangles, 2 of 2
• There are many more Rectangle methods besides these seven
• But what exactly will these methods do?
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Continue editing the JavaFX project that you created in the 
pr
evious exercise
• Create a Rectangle and add it to the Root Node
• Call each method outlined in the previous slide
• Can you figure out what each method does?
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Method Descriptions, Part 1
•setFill(Paint paint)
- Sets the color of the Rectangle
•setStroke(Paint paint)
- Sets the color of the Rectangle’s outline
•setStrokeWidth(double d)
- Sets the width of the Rectangle’s outline
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Method Descriptions, Part 2
•setX(double d)
•setY(double d)
- Sets the x o r y position of the 
Rectangle
•setWidth(double d)
•setHeight(double d)
- Sets the width or height of the 
R
ectangle
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Changing a Node’s Position, 1 of 2
• We’ve seen a couple ways to change a node’s position … but 
w
hich way is preferable?
•setX(double d) 
•setY(double d)
- These are preferable in most cases
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Changing a Node’s Position, 2 of 2
•setLayoutX(d ouble d) 
•setLayoutY( double d)
- Use these if your Node is locked in a Layout pane, such as a 
FlowPan
e
- Or if setX() i s unavailable, which is the case with UI elements, 
such as Buttons
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Positioning a Node
• Most Nodes are positioned with respect to their top-left corner
- And not with respect to their geographic center
• If you call setX(100) on  a Node …
- The x-position of the Node’s top-l eft corner is set to 100
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Coordinate Systems
• Mathematical Coordinate 
S
ystem 
- The origin is located at the 
b
ottom-left corner
• JavaFX Coordinate System
- The origin is located at the 
to
p-left corner
- The y-a xis is backward
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Positioning Example
• This Rectangle is positioned at (4,2) by calling:
-setX(4);
-setY(2);
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Many Shapes Are Available in JavaFX
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The JavaFX API Documentation
• This contains class information and code examples of JavaFX 
fea
tures
• Go to https://openjfx.io/javadoc/17/index.html
• The Graphics module is a helpful starting point
• There is a search feature to allow you to locate specific classes, or 
you ca
n browse the packages for ideas
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Explore the JavaFX API Documentation
• Can you figure out how to create a right triangle with a gradient 
co
loring using the JavaFX project that you created in the 
previous exercise?
• Hint: use the search box to first search 
f
or gradient, then search for Polygon 
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exploring the API Documentation: 
Linear Gradient Example, 1 of 2
• The Linear Gradient example shows us …
- How to create a gradient:
//create simple linear gradient
LinearGradient gradient1 = new LinearGradient(0, 0, 1, 0, true, 
CycleMethod.NO_CYCLE, new Stop[] {
    new Stop(0, Color.DODGERBLUE),
  new Stop(1, Color.BLACK)
});
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exploring the API Documentation: 
Linear Gradient Example, 2 of 2
• The Linear Gradient example shows us …
- How to color a shape with a gradient:
- Remember to make the proper imports
//First rectangle
Rectangle rect1 = new Rectangle(0,0,80,80);
//set rectangle fill
rect1.setFill(gradient1);
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exploring the API Documentation: 
Polygon Example, 1 of 2
• Type polygon i n the API search box - the Polygon example 
shows us …
- How to create a polygon from an array of points:
//Simple triangle
Polygon polygon1 = new Polygon(new double[]{
    80.0, 10.0,
    80.0, 80.0,
  10.0, 80.0
});
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exploring the API Documentation: 
Polygon Example, 2 of 2
• Combine this with the gradient example, and you’ll have your 
s
olution
- But even better, you’ll understand how the API Documentation is a 
v
aluable resource
- This could prove very useful when you do the problem set
//Simple triangle
Polygon polygon1 = new Polygon(new double[]{
    80.0, 10.0,
    80.0, 80.0,
  10.0, 80.0
});
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Polygon
• The Polygon has similar methods as a Rectangle
- Nodes share the same methods
• If you experiment with setLayout X()…
- You’ll notice that the Polygon is positioned with respect to where 
i
ts top-left corner would be
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Secrets about Java Puzzle Ball
• We drew lines and polygons for  collision detection
- But these lines are hidden in the latest version
• We also drew two octagons around each bumper
- An inner octagon handles collision detection
- An outer octagon detects if the ball is far enough away for the 
b
umper to rotate
• We had to do extra work to position and rotate Nodes the way we 
w
anted
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 9-2
Colors and Shapes!
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Create and use custom colors
- Create shapes and explain their properties and behaviors
- Reference the JavaFX API Documentation
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text

```

</details>
