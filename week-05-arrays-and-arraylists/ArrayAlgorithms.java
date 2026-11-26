// Task 2: classic single-pass array algorithms, all O(n).
public class ArrayAlgorithms {
    public static void main(String[] args) {
        int[] marks = {65, 72, 48, 91, 57, 83, 69, 75, 52, 88};

        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\n");

        // Maximum and minimum: start with the first element, then compare the rest
        int max = marks[0];
        int min = marks[0];
        int maxIterations = 0;
        for (int i = 0; i < marks.length; i++) {
            maxIterations++;
            if (marks[i] > max) max = marks[i];
            if (marks[i] < min) min = marks[i];
        }
        System.out.println("=== FIND MAXIMUM ===");
        System.out.println("Maximum mark: " + max + "  (iterations: " + maxIterations + ", O(n))");
        System.out.println("\n=== FIND MINIMUM ===");
        System.out.println("Minimum mark: " + min + "  (iterations: " + maxIterations + ", O(n))");

        // Average: sum, then divide. Cast first so the division isn't integer division.
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        double average = (double) sum / marks.length;
        System.out.println("\n=== CALCULATE AVERAGE ===");
        System.out.println("Sum: " + sum);
        System.out.println("Number of marks: " + marks.length);
        System.out.printf("Average: %.2f%n", average);

        // Linear search: stop as soon as the target is found
        int target = 83;
        int foundIndex = -1;          // -1 means "not found"
        int searchIterations = 0;
        for (int i = 0; i < marks.length; i++) {
            searchIterations++;
            if (marks[i] == target) {
                foundIndex = i;
                break;
            }
        }
        System.out.println("\n=== LINEAR SEARCH ===");
        if (foundIndex != -1) {
            System.out.println("Found " + target + " at index " + foundIndex);
        } else {
            System.out.println(target + " not found in the array.");
        }
        System.out.println("Iterations: " + searchIterations + "  (best O(1), worst O(n))");

        // Count matching elements
        int threshold = 70;
        int count = 0;
        for (int mark : marks) {
            if (mark >= threshold) count++;
        }
        System.out.println("\n=== COUNT ABOVE THRESHOLD ===");
        System.out.println("Marks above or equal to " + threshold + ": " + count + " of " + marks.length);

        System.out.println("\n=== COMPLEXITY SUMMARY ===");
        System.out.printf("%-15s | %10s | %s%n", "Algorithm", "Iterations", "Complexity");
        System.out.println("----------------|------------|-----------");
        System.out.printf("%-15s | %10d | %s%n", "Find Maximum", maxIterations, "O(n)");
        System.out.printf("%-15s | %10d | %s%n", "Find Minimum", maxIterations, "O(n)");
        System.out.printf("%-15s | %10d | %s%n", "Average", marks.length, "O(n)");
        System.out.printf("%-15s | %10d | %s%n", "Linear Search", searchIterations, "O(n)");
        System.out.printf("%-15s | %10d | %s%n", "Count Above", marks.length, "O(n)");
    }
}
