// Task 2: an abstract class forces every subclass to implement calculateArea()
// and stops anyone creating a vague "new Shape()".

abstract class Shape {
    protected String name;

    public Shape(String name) {            // abstract classes can still have constructors
        this.name = name;
    }

    public abstract double calculateArea(); // no body: subclasses MUST provide one

    public void displayName() {             // concrete method shared by all shapes
        System.out.println("Shape: " + name);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        // Shape s = new Shape("blob");   // compile error: Shape is abstract
        Shape myCircle = new Circle(5.0);
        Shape myRect = new Rectangle(4.0, 6.0);

        myCircle.displayName();
        System.out.printf("Area: %.2f%n%n", myCircle.calculateArea());

        myRect.displayName();
        System.out.printf("Area: %.2f%n", myRect.calculateArea());
    }
}
