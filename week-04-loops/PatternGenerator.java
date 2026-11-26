import java.util.Scanner;

// Task 4: nested loops. The outer loop picks the row; the inner loop prints that row's characters.
public class PatternGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("\n=== PATTERN 1: Right Triangle ===");
        for (int i = 1; i <= rows; i++) {          // row i has i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n=== PATTERN 2: Inverted Right Triangle ===");
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n=== PATTERN 3: Pyramid ===");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {  // leading spaces: rows - i
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) { // stars: 1, 3, 5, ...
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n=== PATTERN 4: Number Triangle ===");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\n=== PATTERN 5: Multiplication Table ===");
        System.out.print("    ");
        for (int i = 1; i <= rows; i++) {
            System.out.printf("%4d", i);           // %4d: integer, 4 characters wide
        }
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i <= rows; i++) {
            System.out.print("----");
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.printf("%3d|", i);
            for (int j = 1; j <= rows; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
        scanner.close();
    }
}
