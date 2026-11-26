import java.util.Scanner;

// Task 4: read a name and two numbers with Scanner, then calculate.
public class InteractiveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("     INTERACTIVE CALCULATOR");
        System.out.println("========================================");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();          // whole line, spaces included
        System.out.println("\nHello, " + name + "! Let's do some calculations.\n");

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        int intNum1 = (int) num1;                  // % is shown on whole numbers
        int intNum2 = (int) num2;

        System.out.println("\n========================================");
        System.out.println("           RESULTS FOR " + name.toUpperCase());
        System.out.println("========================================");
        System.out.println("First Number: " + num1);
        System.out.println("Second Number: " + num2);
        System.out.println("----------------------------------------");
        System.out.println("Addition: " + num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + (num1 * num2));

        if (num2 != 0) {      // double / 0 gives Infinity rather than an error, so guard it
            System.out.println("Division: " + num1 + " / " + num2 + " = " + (num1 / num2));
        } else {
            System.out.println("Division: Cannot divide by zero!");
        }
        if (intNum2 != 0) {   // int % 0 throws ArithmeticException
            System.out.println("Modulus: " + intNum1 + " % " + intNum2 + " = " + (intNum1 % intNum2));
        } else {
            System.out.println("Modulus: Cannot divide by zero!");
        }
        System.out.println("========================================");

        System.out.println("\n=== ADDITIONAL CALCULATIONS ===");
        System.out.println("Average of " + num1 + " and " + num2 + " = " + (num1 + num2) / 2);
        System.out.println("Square of " + num1 + " = " + (num1 * num1));

        scanner.close();
        System.out.println("\nThank you for using the calculator, " + name + "!");
    }
}
