// Task 3: try / catch / finally, and the difference between handling an exception
// where it happens and letting it propagate to the caller.
public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        System.out.println("=== EXAMPLE 1: Division by Zero ===");
        int numerator = 10;
        int denominator = 0;
        try {
            int result = numerator / denominator;     // throws ArithmeticException
            System.out.println("Result: " + result);  // skipped
        } catch (ArithmeticException e) {
            System.out.println("Error caught: You cannot divide by zero!");
            System.out.println("Java says: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed (cleaning up resources).");
        }
        System.out.println("Program continues safely...\n");

        System.out.println("=== EXAMPLE 2: Array Out of Bounds ===");
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error caught: The array index is out of bounds!");
        }
        System.out.println("Program continues safely...\n");

        System.out.println("=== EXAMPLE 3a: Caught inside the method ===");
        performRiskyOperation();

        System.out.println("\n=== EXAMPLE 3b: Propagated to the caller ===");
        try {
            parseOrThrow("abc");                       // the exception travels up to here
        } catch (NumberFormatException e) {
            System.out.println("main() caught what parseOrThrow() threw: " + e.getMessage());
        }

        System.out.println("\nProgram finished.");
    }

    // Handles its own problem: the caller never knows anything went wrong.
    public static void performRiskyOperation() {
        try {
            int number = Integer.parseInt("abc");     // NumberFormatException
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("Error caught: Invalid number format.");
        }
    }

    // No try/catch here, so the exception propagates up the call stack to the caller.
    public static int parseOrThrow(String text) {
        return Integer.parseInt(text);
    }
}
