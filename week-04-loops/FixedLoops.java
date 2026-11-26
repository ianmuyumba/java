// Task 6: debugging infinite loops.
//
// BUGGY version (InfiniteLoopDebug.java in the handout). Do not run it; it never stops:
//
//   int x = 1;
//   while (x <= 5) { System.out.println("x = " + x); }           // BUG 1: x never changes
//
//   for (int i = 5; i >= 1; i++) { System.out.println(i); }      // BUG 2: i moves AWAY from the end
//
//   int y = 10;
//   while (y > 0) { System.out.println("y = " + y); }            // BUG 3: y never changes
//
// Rule: every loop needs an update that moves its variable TOWARD making the condition false.
public class FixedLoops {
    public static void main(String[] args) {
        System.out.println("=== FIXED BUG 1 ===");
        int x = 1;
        while (x <= 5) {
            System.out.println("x = " + x);
            x++;                                   // fix: update x
        }

        System.out.println("\n=== FIXED BUG 2 ===");
        for (int i = 5; i >= 1; i--) {             // fix: count down, not up
            System.out.println("i = " + i);
        }

        System.out.println("\n=== FIXED BUG 3 ===");
        int y = 10;
        while (y > 0) {
            System.out.println("y = " + y);
            y--;                                   // fix: update y
        }

        System.out.println("\nAll loops terminated successfully!");
    }
}
