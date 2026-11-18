# Oracle Section 9 · Projects and resources

[Lesson](README.md) · [Practice](PRACTICE.md) · [Student Guide](sources/oracle-jfo/9-3-student-guide.md) · [Audit](../ORACLE_AUDIT.md)

## Live lesson numbering

| Live Oracle lesson | Archived source filename |
|---|---|
| 9-1 Introduction to JavaFX | `9-1-introduction-to-javafx.md` |
| 9-2 Colors and Shapes | `9-4-colors-and-shapes.md` |
| 9-3 Graphics, Audio, and MouseEvents | `9-5-graphics-audio-and-mouseevents.md` |

The Eclipse and NetBeans setup documents are separate resources, not lessons 9-2 and 9-3. Archive filenames reflect the previous download naming; the lesson text and the live course confirm the mapping above.

## Newly restored starters

- [JavaFXMain.java](exercises/JavaFXMain/JavaFXMain.java): initial Application, Stage, Scene and Group setup.
- [JavaFXMainEx1.java](exercises/JavaFXMainEx1/JavaFXMainEx1.java): extend the initial scene with colour and shapes.
- [Goal project](exercises/GoalTestStudent/README.md): the two supplied classes, Duke and Glove images, and Note5 sound.

These are unfinished Oracle starters. A blank window can be the expected starting state rather than a launch failure.

## Image data and a visible node serve different jobs

An `Image` holds image data; an `ImageView` is the node added to the scene graph. You can call `imageView.setImage(otherImage)` while retaining the view's position and other properties. An image alone cannot be added as a scene-graph node.

The guide encourages moving object-specific nodes and handlers into a domain class instead of placing every line in `start()`. Keep a goal object's image view and its interactions together; let the application construct and place goals.

## Resolve resources deliberately

`Goal.class.getResource("Images/Duke.png")` searches relative to the class's package. `Goal.class.getResource("/Images/Duke.png")` searches from the classpath root. A missing resource returns null, so calling `toString()` on it produces a misleading `NullPointerException`.

```java
java.net.URL imageUrl = Goal_Student_9_3.class.getResource("Images/Duke.png");
if (imageUrl == null) throw new IllegalStateException("Missing Images/Duke.png");
javafx.scene.image.Image image = new javafx.scene.image.Image(imageUrl.toExternalForm());
```

The guide describes package `goaltest`, but the supplied `_Student_9_3` files have no package declaration. Keep the supplied default-package names while practising, or add a package to **both** classes and adjust source, output and resource paths together. The project README explains a matching classpath layout.

## Event handlers and coordinates

`event -> ...` supplies behaviour that runs when the event occurs; registering a handler does not run the handler immediately. `getX()`/`getY()` describe coordinates relative to the event source, while `getSceneX()`/`getSceneY()` describe scene coordinates. Convert coordinates when moving nodes between different parents or coordinate systems.

For image and audio work, use `javafx.controls` and `javafx.media` in the module configuration. Test images appearing, the intended mouse event firing, the sound playing, and resources still loading after compilation. Reading the code is not a substitute for these GUI checks.
