// Task 3a: procedural style. The data (length, width) lives in local variables
// and is passed into separate static functions.
public class RectangleProcedural {
    public static double calculateArea(double length, double width) {
        return length * width;
    }

    public static double calculatePerimeter(double length, double width) {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        double length = 5.0;
        double width = 3.0;

        System.out.println("Procedural Approach:");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea(length, width));
        System.out.println("Perimeter: " + calculatePerimeter(length, width));
    }
}
