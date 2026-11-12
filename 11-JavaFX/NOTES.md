# Unit 11 · JavaFX (Graphical User Interfaces)

> **Oracle JFo:** Section 9 (9-1 Introduction to JavaFX, 9-2 Setup JavaFX in Eclipse, 9-3 Setup JavaFX in NetBeans, 9-4 Colors and Shapes, 9-5 Graphics, Audio, and MouseEvents, 9-6 Practice: CampusMap)
> **Class:** not part of RBCS 7121 (an Oracle JFo extension topic)
> **Files in this folder**
> - `oracle-jfo/`: lessons 9-1 to 9-6 (no starter code was provided for this section)

---

## Learning outcomes

1. Explain what JavaFX is and how a JavaFX program is structured (Application → Stage → Scene → nodes).
2. Set up JavaFX in an IDE (it's a separate download from the JDK since Java 11).
3. Lay out and draw nodes: shapes, colours, text, images, buttons.
4. Respond to user actions with **event handlers** (button clicks, mouse events).
5. Add images and audio.

---

## 1. What is JavaFX?

**JavaFX** is Java's toolkit for building **graphical** (windowed) applications: buttons, shapes, images, animation, media. So far every program in this course has been console-based; JavaFX programs open a window instead.

Since **Java 11**, JavaFX is **not bundled** with the JDK. You download the **OpenJFX SDK** (openjfx.io) and add it to your project. The setup steps for each IDE are in `oracle-jfo/9-2 Setup JavaFX in Eclipse.pdf` and `9-3 Setup JavaFX in NetBeans.pdf`.

Running from the terminal with the SDK unzipped to `C:\javafx-sdk`:
```
javac --module-path C:\javafx-sdk\lib --add-modules javafx.controls HelloFX.java
java  --module-path C:\javafx-sdk\lib --add-modules javafx.controls HelloFX
```
(Add `javafx.media` for audio.)

---

## 2. The theatre metaphor: Stage, Scene, nodes

```
Stage   (the window, i.e. the theatre)
 └── Scene   (the content shown in it, i.e. the set; it has a width and height)
      └── Root node, e.g. a Pane, Group or VBox   (a container)
           ├── Rectangle   (shape node)
           ├── Circle
           ├── Button      (control node)
           └── ImageView   (image node)
```

- **Stage**: the window. The first one (`primaryStage`) is created for you.
- **Scene**: what's displayed in the stage. Only one scene shows at a time.
- **Node**: everything inside a scene is a node, and nodes form a tree called the **scene graph**. Containers (`Group`, `Pane`, `VBox`, `HBox`, `BorderPane`, `StackPane`) hold other nodes.

---

## 3. A minimal JavaFX program

```java
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloFX extends Application {      // 1. extend Application

    @Override
    public void start(Stage primaryStage) {     // 2. start() replaces main's job
        Button btn = new Button("Say Hello");
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setOnAction(e -> System.out.println("Hello, World!"));   // event handler

        Group root = new Group();               // 3. root container
        root.getChildren().add(btn);            //    add nodes to it

        Scene scene = new Scene(root, 300, 200);   // 4. a scene of 300 × 200 pixels
        primaryStage.setTitle("My First JavaFX App");
        primaryStage.setScene(scene);           // 5. put the scene on the stage
        primaryStage.show();                    // 6. show the window
    }

    public static void main(String[] args) {
        launch(args);                           // starts JavaFX, which calls start()
    }
}
```

**Structure to remember:** `extends Application` → `start(Stage)` → create nodes → add them to the root → `new Scene(root, w, h)` → `stage.setScene(scene)` → `stage.show()`.

---

## 4. Coordinates, colours and shapes (JFo 9-4)

### The coordinate system
The origin **(0, 0) is the top-left corner**. **x increases to the right; y increases downwards** (the opposite of maths graphs).

```
(0,0) ─────────► x
  │
  │      ● (100, 50)
  ▼
  y
```

### Shapes (`javafx.scene.shape`)
```java
Rectangle rect = new Rectangle(50, 50, 120, 80);    // x, y, width, height (top-left corner)
Circle circle = new Circle(250, 90, 40);            // centerX, centerY, radius (CENTRE!)
Line line = new Line(0, 0, 300, 200);               // startX, startY, endX, endY
Ellipse ellipse = new Ellipse(150, 150, 60, 30);    // centerX, centerY, radiusX, radiusY
Polygon tri = new Polygon(100, 10,  150, 90,  50, 90);   // x,y pairs for each corner
Text label = new Text(60, 40, "Dorm 1: 400");       // x, y (baseline), text
```
⚠️ A Rectangle is positioned by its **top-left corner**; a Circle by its **centre**. When calculating distances, use the **geometric centre** of each shape (the CampusMap practice warns about this).

### Colours (`javafx.scene.paint.Color`)
```java
rect.setFill(Color.CORNFLOWERBLUE);            // named colour
circle.setFill(Color.rgb(255, 99, 71));        // red, green, blue (0–255)
circle.setFill(Color.rgb(255, 0, 0, 0.5));     // + opacity (0.0 transparent – 1.0 solid)
rect.setStroke(Color.BLACK);                   // the outline
rect.setStrokeWidth(3);
Color c = Color.web("#1E90FF");                // a hex colour
```

### Moving and transforming nodes
```java
rect.setX(10); rect.setY(20);           // shape-specific position
circle.setCenterX(200);
node.setTranslateX(30);                 // shift any node
node.setRotate(45);                     // degrees
node.setScaleX(1.5);                    // stretch
node.setVisible(false);
```

---

## 5. Graphics, audio and mouse events (JFo 9-5)

### Images
```java
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

Image map = new Image("file:campus.png");     // or getClass().getResource("campus.png").toString()
ImageView bg = new ImageView(map);
bg.setFitWidth(600);
bg.setPreserveRatio(true);
root.getChildren().add(0, bg);                // index 0 = drawn first = behind everything else
```
Nodes added **later** are drawn **on top** of earlier ones.

### Audio
```java
import javafx.scene.media.AudioClip;

AudioClip click = new AudioClip(getClass().getResource("click.wav").toString());
click.play();
```
(Short sound effects use `AudioClip`; longer music uses `Media` + `MediaPlayer`.)

### Events and handlers
An **event** is something the user does (a click, a mouse move, a key press). You attach a **handler**, which is code that runs when the event happens. A **lambda** (`e -> { ... }`) is the shortest way to write one.

```java
button.setOnAction(e -> count++);                        // button clicked

circle.setOnMouseClicked(e -> circle.setFill(Color.RED));
circle.setOnMouseEntered(e -> circle.setOpacity(0.5));   // hover
circle.setOnMouseExited(e -> circle.setOpacity(1.0));

// Drag a circle around (CampusMap: "the location of each dorm must be adjustable")
circle.setOnMouseDragged(e -> {
    circle.setCenterX(e.getX());     // the mouse position, in scene coordinates
    circle.setCenterY(e.getY());
    updateCenterPoint();             // recalculate whatever depends on it
});

scene.setOnKeyPressed(e -> System.out.println("Key: " + e.getCode()));
```

| Mouse event | Fires when |
|-------------|------------|
| `setOnMouseClicked` | pressed and released |
| `setOnMousePressed` / `setOnMouseReleased` | button goes down / up |
| `setOnMouseDragged` | moved while held down |
| `setOnMouseEntered` / `setOnMouseExited` | the pointer enters / leaves the node |
| `setOnMouseMoved` | moved without a button held |

`e.getX()`, `e.getY()` give the position; `e.getButton()` tells you which button.

---

## 6. Worked example: a draggable weighted centre point

This is the core of the **CampusMap** practice (9-6): dorms are circles you can drag; the "centre of all students" is a weighted average of the dorm centres, weighted by population.

```java
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CenterPoint extends Application {
    private final Circle[] dorms = new Circle[3];
    private final int[] population = {400, 250, 120};
    private final Circle center = new Circle(6, Color.BLACK);
    private final Text centerLabel = new Text();

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        double[][] start = {{100, 100}, {400, 120}, {250, 300}};
        Color[] colours = {Color.CORNFLOWERBLUE, Color.LIGHTGREEN, Color.SALMON};

        for (int i = 0; i < dorms.length; i++) {
            Circle d = new Circle(start[i][0], start[i][1], 30, colours[i]);
            d.setOnMouseDragged(e -> {
                d.setCenterX(e.getX());
                d.setCenterY(e.getY());
                updateCenter();
            });
            dorms[i] = d;
            root.getChildren().add(d);
        }
        root.getChildren().addAll(center, centerLabel);
        updateCenter();

        stage.setTitle("Campus Center");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    private void updateCenter() {
        double sumX = 0, sumY = 0, total = 0;
        for (int i = 0; i < dorms.length; i++) {
            sumX += dorms[i].getCenterX() * population[i];   // weight each dorm by its population
            sumY += dorms[i].getCenterY() * population[i];
            total += population[i];
        }
        double cx = sumX / total, cy = sumY / total;
        center.setCenterX(cx);
        center.setCenterY(cy);
        centerLabel.setX(cx + 8);
        centerLabel.setY(cy - 8);
        centerLabel.setText(String.format("All students (%.0f, %.0f)", cx, cy));
    }

    public static void main(String[] args) { launch(args); }
}
```

This uses almost everything from the course: arrays, loops, methods, fields and encapsulation, plus JavaFX shapes and events.

---

## 7. Exercises

| Task | Concepts |
|------|----------|
| Install the JavaFX SDK and run `HelloFX` (9-2 / 9-3) | setup |
| Draw a house from a Rectangle, Polygon (roof) and Circle (window) in your own colours | shapes, colours, coordinates |
| A button that counts clicks and shows the count in a `Text` | events, fields |
| A circle that changes colour on hover and follows the mouse when dragged | mouse events |
| **CampusMap** (`oracle-jfo/9-6 Practice.pdf`): a background map, ≥ 3 adjustable dorms showing name and population, a weighted centre of all students, and a study-group centre, all updating live | everything |

---

## 8. Common mistakes

| Mistake | Fix |
|---------|-----|
| `package javafx.application does not exist` | The JavaFX SDK isn't on the module path; follow 9-2/9-3 |
| A blank window | You forgot `root.getChildren().add(node)` or `stage.show()` |
| A shape appears in the wrong place | Remember that y points **down**, and that a Circle is positioned by its centre while a Rectangle uses its top-left corner |
| The background image hides everything | Add it **first** (index 0) |
| Image or audio not found | Check the path; `getResource` paths are relative to the class |
| Writing all your code in `main` | Put the setup in `start()`; `main` only calls `launch(args)` |

---

## 9. Practice questions

1. What are the Stage, the Scene and nodes? How are they related?
2. Which method replaces `main` as the entry point of the GUI logic? What must `main` call?
3. Where is (0, 0), and which way does y increase?
4. How is a Rectangle positioned compared with a Circle?
5. Write code that makes a circle turn red when clicked.
6. What is an event handler? What does `e -> ...` mean?
7. How do you put an image *behind* the other nodes?
8. Why does the CampusMap use a **weighted** average for the centre of all students?

<details>
<summary><b>Answers</b></summary>

1. The Stage is the window; the Scene is the content displayed in it; nodes are the elements (shapes, controls, images) arranged in a tree under the scene's root container. Stage → Scene → root → nodes.
2. `start(Stage primaryStage)`. `main` calls `launch(args)`, which sets JavaFX up and calls `start`.
3. At the top-left corner. y increases **downwards**.
4. A Rectangle by its top-left corner (x, y) plus width and height; a Circle by its centre (centerX, centerY) plus radius.
5. `circle.setOnMouseClicked(e -> circle.setFill(Color.RED));`
6. Code that runs in response to an event. `e -> ...` is a lambda: a short anonymous function that receives the event object `e`.
7. Add it to the root first (`root.getChildren().add(0, imageView)`); nodes added later are drawn on top.
8. Dorms with more students should pull the centre towards them more strongly, like a centre of mass: Σ(position × population) / Σ population.
</details>

---

## 10. Summary

- JavaFX = GUI apps. `extends Application`, set everything up in `start(Stage)`, and `main` calls `launch(args)`.
- Stage (window) → Scene (content) → root container → nodes (the scene graph).
- (0,0) is the top-left and y goes down. Rectangles use their top-left corner; Circles use their centre.
- Shapes: `Rectangle`, `Circle`, `Line`, `Polygon`, `Text`. Colours: `Color.NAME`, `Color.rgb(r,g,b,a)`; `setFill`, `setStroke`.
- Images: `Image` + `ImageView`. Audio: `AudioClip`.
- Events: `setOnAction`, `setOnMouseClicked`, `setOnMouseDragged`… with lambda handlers.
