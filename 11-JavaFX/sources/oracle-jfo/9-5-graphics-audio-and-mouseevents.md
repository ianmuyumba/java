# 9-5 Graphics, Audio, and MouseEvents

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: 9-5 Graphics, Audio, and MouseEvents.pdf

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
9-3
Graphics, Audio, and 
MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its affiliates. 
Other names may be trademarks of their respective owners.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Objectives
• This lesson covers the following objectives:
- Create and use a JavaFX image and ImageView
- Create and use JavaFX audio
- Create and use MouseEvent s
- Understand Lambda expressions in GUI applications
3
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Using Y our Own Graphics
• JavaFX can provide UI elements, shapes, and text
- But if you have a talent for art, you can use your own graphics in 
p
lace of those that JavaFX provides
• For example:
- The art for the level-s elect button wasn’t created by JavaFX
- But we used JavaFX to procedurally add level numbers, text, and 
t
he graphic of Duke
4
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
A JavaFX Image and ImageView
• An Image i s an object that describes the location of a graphics 
file (.png, .jpg, .gif … )
Image image;
String imagePath = "Images/Fan1.png";
image = new Image(getClass().getResource(imagePath).toString);
• An ImageView i s the actual Node
- Calling its constructor requires an Image argument
ImageView imageView = new ImageView(image);
- An ImageView a lso contains the same properties as any other 
node: x-position, y-position, width, height …
5
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Why Have Both an Image and ImageView?
• One big advantage is animation
- Images can be swapped in and out of the same ImageView
• The Fan in Java Puzzle Ball takes advantage of this
- The fan cycles through 2 images when it's blowing
• Custom buttons also benefit
- You could use different images forb uttons depending on their 
state:
• Is the mouse hovering over the button?
• Is the user clicking the button?
6
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
ImageView Hints, 1 of 2
• How to create Images:
Image image1 = new 
Image(getClass().getResource("Images/fan1.png").toString());
Image image2 = new 
Image(getClass().getResource("Images/fan2.png").toString());
• How to create an ImageView :
ImageView imageView = new ImageView(image1); 
7
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
ImageView Hints, 2 of 2
• How to swap an Image into an ImageView:
imageView.setImage(image2);
-imageView r etains its properties, such as positioning
8
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Creating Objects with Node Properties
• So far, we’ve written all JavaFX code in the start() me thod
- This is similar to the beginning of the course, where most code was 
w
ritten in the main() method
• Object- oriented code shouldn’t be written this way
- Instead, objects should have Node fields
• The start()  and main() methods are intended to be drivers
9
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Example: The Goal Class
• Fields
-private Image dukeImage ;
-private ImageView  dukeImageView;
• Constructor
- T akes arguments for x and  y positions
- Assigns the image to its respective ImageView
- Positions dukeImageView a ccording to the x and y arguments
10
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, 1 of 2
• Create a new Java project and name it GoalTest
• Right- click on the project and select New >package
- Name the package g oaltest
• Add the supplied java files G oal.java and GoalTest.java to the 
package
11
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1, 2 of 2
• Right- click the project again and create another new package, 
and name it goaltest.Images
• Right- click the project once more and create another new 
package, and name it goaltest.Audio
• This creates a folder structure that can be used to easily 
r
eference image and audio files
12
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
File Locations
• Add the supplied image and audio files to the correct location 
(
drag and drop or copy and paste) to the package folders in your 
IDE
imageView.setImage(image2);
• Images/Duke.png r efers to a folder within the GoalTest folder
- …\G oalTest\ src\goaltest\Images
- Or a package within a package
13
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 1 continued
• Notice that …
- The Root Node is publicly available
- The Goal cl ass is an ordinary Java class file type
• Write the Goal cl ass according to the specifications on the slide 9
- You’ll also need to add this class's ImageView t o the Root Node
• Instantiate a few Goal objects from the start() 
met
hod
14
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Scaling a Node
• It’s very easy to make a rectangle wider:
• But if you try the same thing with an ImageView …
- It might look awful!
15
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Scaling a Node the Right Way
• JavaFX is very good at scaling graphics
- The quality of the image is less likely to deteriorate
• You have the option to preserve the aspect ratio of an 
Ima
geView
- An ImageView ’s width and height scale together
- This avoids distortion
imageView.setPreserveRatio(true);
imageView.setFitWidth(25);
16
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Ordering Nodes
• Sometimes, testers of Java Puzzle Ball didn’t realize that their 
g
oal was to get the ball to Duke
• We thought adding a baseball glove would help solve the 
pr
oblem
• Duke and the glove are two separate ImageViews
- These needed to be ordered properly so that the glove doesn’t 
d
isplay behind the hand
17
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Ordering Nodes the Right Way
• The order that Nodes are added to the Root Node determines the 
o
rder that they are displayed
• Nodes added early are buried under nodes added later
root.getChildren().addAll(gloveImageView, dukeImageView);
• To fix this you could …
- Change the order that Nodes are added to the Root Node
- Bring an ImageView to the front or back
gloveImageView.toFront();   //Either one of these
dukeImageView.toBack();     //will solve the problem
18
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Goal Class, 1 of 4
• Fields
-private Image dukeIma ge;
-private ImageV iew dukeImageView;
-private Image gloveIm age;
-private ImageV iew gloveImageView;
19
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Goal Class, 2 of 4
• Constructor
- T akes arguments for x an d y positions
- Assigns each Image to its respective ImageView
- Positions dukeImageView  according to the x and y arguments
- Positions and scales gloveImageView  relative to 
dukeImageView
20
```

</details>


## PDF page 21

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 2
• Continue editing the G oalTest project
• Write the Goal  class according to the specifications on the 
previous slide
- The constructor should still take only two arguments
- A glove should appear on top of Duke’s hand
• Hint:  Nodes, including ImageViews, have getter and setter 
methods for properties like position
21
```

</details>


## PDF page 22

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Image and Audio Similarities
• Creating a JavaFX Image  object …
Image image = new 
Image(getClass().getResource("Images/fan1.png").toString());
• Is very similar to creating a JavaFX AudioCli p object
AudioClip audio = new 
AudioClip(getClass().getResource("Audio/Note5.wav").toString()); 
• It’s common to store images and audio in their 
ow
n packages/folders
22
```

</details>


## PDF page 23

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Image and Audio Differences
• An AudioClip object describes the location of an audio file 
(.wav, .mp3 …)
AudioClip audio = new  
AudioClip(getClass().getResource("Audio/Note5.wav").toString());
• And unlike an Image …
- There is no AudioClip  equivalent of an ImageView
- Audio can be played by referencing the AudioClip  object directly
audio.play();
- There are many other AudioClip  methods you can call
23
```

</details>


## PDF page 24

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Goal Class, 3 of 4
• Fields
-private Image dukeIma ge;
-private ImageV iew dukeImageView;
-private Image gloveIm age;
-private ImageV iew gloveImageView; 
-private AudioC lip tone;
24
```

</details>


## PDF page 25

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
The Goal Class, 4 of 4
• The Goal class contains an AudioClip o bject as a field
- A tone plays when the mouse is pressed on Duke
- We’ll see how to implement this feature in the next part of this 
l
esson
25
```

</details>


## PDF page 26

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 3
• Continue editing the G oalTest project
• Declare an AudioClip  object as a field
• Instantiate the AudioCli p object
- Use the supplied .wav file N ote5.wav
26
```

</details>


## PDF page 27

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mouse and Keyboard Events, 1 of 2
• Nodes can detect mouse and keyboard events
- This is true about ImageView s, too! 
- You aren’t limited to buttons and other GUI components
27
```

</details>


## PDF page 28

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Mouse and Keyboard Events, 2 of 2
• Helpful methods to make this happen include:
-setOnMouseClicked()
-setOnMouseDragged()
-setOnMouseEntered()
-setOnMouseExited()
-setOnMouseMoved()
-setOnMousePressed()
-setOnMouseReleased()
28
```

</details>


## PDF page 29

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Lambda Expressions
• These methods use a special argument, called a Lambda 
exp
ression:
imageView.setOnMousePressed( /*Lambda Expression*/ );
• Lambda expressions use special syntax:
(MouseEvent me) -> System.out.println("Pressed")
• Curley braces allow Lambda expressions to contain multiple 
st
atements:
(MouseEvent me) -> {
   System.out.println("Statement 1");
   System.out.println("Statement 2");
}//end MouseEvent
29
```

</details>


## PDF page 30

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Lambda Expressions as Arguments
• When these are combined, we get the following:
imageView.setOnMousePressed( (MouseEvent me) -> {
    System.out.println("Statement 1");
    System.out.println("Statement 2");
} );
• What this code does:
- Allows imageView  to detect a mouse press at any time
- If that occurs, the two print statements are executed
- Otherwise, this code is ignored
30
```

</details>


## PDF page 31

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
MouseEvent
• A MouseEve nt object exists only within the scope of the Lambda 
expression
• It contains many useful properties and methods:
imageView.setOnMousePressed( (MouseEvent me) -> {
    System.out.println(me.getSceneX());
    System.out.println(me.getSceneY());
} );
• In this example:
-me i s the MouseEvent object
-me is  accessed to print the x  and y positions of the mouse cursor 
when imageView is pressed
31
```

</details>


## PDF page 32

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
MouseEvent Methods, 1 of 2
•getSceneX()
•getSceneY()
- Returns a double
- Returns the position of the cursor within the JavaFX Scene
- The top-left corner of the Scene is position (0,0) 
32
```

</details>


## PDF page 33

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
MouseEvent Methods, 2 of 2
•getScreenX()
•getScreenY()
- Returns a double
- Returns the position of the cursor on your computer’s screen
- The top-left corner of your computer’s screen is (0,0)
33
```

</details>


## PDF page 34

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Event Listening
• When you write code for MouseEve nts
- You’re telling a Node to listen for a particular event
- But the events don’t actually have to occur
• As long as the Node is listening …
- It can detect any event, at any time
• A Node can listen for many events
imageView.setOnMousePressed( /*Lambda Expression*/ );
imageView.setOnMouseDragged( /*Lambda Expression*/ );
imageView.setOnMouseReleased(/*Lambda Expression*/ );
34
```

</details>


## PDF page 35

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Exercise 4
• Continue editing the G oalTest project
• Complete the interact ions() method so that …
- Duke listens for a mouse press and mouse drag
- Play a sound when the mouse is pressed
- Print the x an d y positions of the mouse dragged event
- This will be helpful for the problem set
• What if interactions() is never called?
- Comment out this method call in the constructor
35
```

</details>


## PDF page 36

<details>
<summary>Page text</summary>

```text
JFo 9-3
Graphics, Audio, and MouseEvents
Copyright © 2026, Oracle and/or its affiliates. Oracle®, Java, MySQL and NetSuite are registered trademarks of Oracle and/or its 
affiliates. Other names may be trademarks of their respective owners.
Summary
• In this lesson, you should have learned how to:
- Create and use a JavaFX image and ImageView
- Create and use JavaFX audio
- Create and use MouseEvent s
- Understand Lambda expressions in GUI applications
36
```

</details>


## PDF page 37

<details>
<summary>Page text</summary>

```text

```

</details>
