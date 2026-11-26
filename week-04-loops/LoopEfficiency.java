// Task 5: count loop iterations to compare algorithm growth (Big-O).
// Pass n as an argument to experiment, e.g.  java LoopEfficiency.java 20
public class LoopEfficiency {
    public static void main(String[] args) {
        int n = (args.length > 0) ? Integer.parseInt(args[0]) : 10;

        int count1 = 0;                           // linear
        for (int i = 0; i < n; i++) {
            count1++;
        }

        int count2 = 0;                           // nested square
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count2++;
            }
        }

        int count3 = 0;                           // triangular: j starts at i
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                count3++;
            }
        }

        int count4 = 0;                           // linear with a condition
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                count4++;
            }
        }

        System.out.println("=== ALGORITHM 1: Linear Loop ===");
        System.out.println("n = " + n + ", Iterations: " + count1 + ", Time Complexity: O(n)");
        System.out.println("\n=== ALGORITHM 2: Nested Loop (Square) ===");
        System.out.println("n = " + n + ", Iterations: " + count2 + ", Formula n * n = " + (n * n) + ", O(n^2)");
        System.out.println("\n=== ALGORITHM 3: Triangular Loop ===");
        System.out.println("n = " + n + ", Iterations: " + count3 + ", Formula n(n+1)/2 = " + (n * (n + 1) / 2) + ", O(n^2)");
        System.out.println("\n=== ALGORITHM 4: Loop with Condition ===");
        System.out.println("n = " + n + ", Even numbers counted: " + count4 + ", Total iterations: " + n + ", O(n)");

        System.out.println("\n=== COMPARISON TABLE ===");
        System.out.printf("%-10s | %10s | %s%n", "Algorithm", "Iterations", "Complexity");
        System.out.println("-----------|------------|-----------");
        System.out.printf("%-10s | %10d | %s%n", "Linear", count1, "O(n)");
        System.out.printf("%-10s | %10d | %s%n", "Nested", count2, "O(n^2)");
        System.out.printf("%-10s | %10d | %s%n", "Triangular", count3, "O(n^2)  (about n^2/2)");
        System.out.printf("%-10s | %10d | %s%n", "Condition", n, "O(n)  (" + count4 + " counted)");
    }
}
