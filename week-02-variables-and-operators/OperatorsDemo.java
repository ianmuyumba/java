// Task 2: arithmetic, precedence, relational, logical and increment operators.
public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 17;
        int b = 5;

        System.out.println("=== ARITHMETIC OPERATORS ===");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Sum (a + b): " + (a + b));
        System.out.println("Difference (a - b): " + (a - b));
        System.out.println("Product (a * b): " + (a * b));
        System.out.println("Quotient (a / b): " + (a / b));    // int division: 3, decimals dropped
        System.out.println("Remainder (a % b): " + (a % b));   // 17 = 5*3 + 2

        System.out.println("\n=== OPERATOR PRECEDENCE ===");
        System.out.println("10 + 5 * 2 = " + (10 + 5 * 2));         // * first: 10 + 10 = 20
        System.out.println("(10 + 5) * 2 = " + ((10 + 5) * 2));     // () first: 15 * 2 = 30
        System.out.println("20 % 3 + 4 * 2 = " + (20 % 3 + 4 * 2)); // 2 + 8 = 10

        System.out.println("\n=== RELATIONAL OPERATORS ===");
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        boolean x = true;
        boolean y = false;
        System.out.println("\n=== LOGICAL OPERATORS ===");
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x && y: " + (x && y));   // AND: both must be true
        System.out.println("x || y: " + (x || y));   // OR: at least one true
        System.out.println("!x: " + (!x));           // NOT: flips the value

        int counter = 5;
        int postIncrement = counter++;   // uses 5, then counter becomes 6
        int preIncrement = ++counter;    // counter becomes 7, then uses 7
        System.out.println("\n=== INCREMENT/DECREMENT ===");
        System.out.println("counter after post-increment: " + postIncrement);
        System.out.println("counter after pre-increment: " + preIncrement);
        System.out.println("Final counter value: " + counter);
    }
}
