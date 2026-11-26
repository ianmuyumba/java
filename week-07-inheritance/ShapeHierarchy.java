// Task 5: a class hierarchy. Shared name and toString() live in Shape;
// each subclass supplies its own area formula.

class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public double calculateArea() {
        return 0.0;                      // a generic shape has no formula (week 8 makes this abstract)
    }

    @Override
    public String toString() {
        return "Shape: " + name;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString() + " | Radius: " + radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return super.toString() + " | Length: " + length + ", Width: " + width;
    }
}

public class ShapeHierarchy {
    public static void main(String[] args) {
        Circle c = new Circle("My Circle", 5.0);
        System.out.println(c);                         // println calls toString()
        System.out.printf("Area: %.2f%n%n", c.calculateArea());

        Rectangle r = new Rectangle("My Rectangle", 4.0, 6.0);
        System.out.println(r);
        System.out.printf("Area: %.2f%n", r.calculateArea());
    }
}
