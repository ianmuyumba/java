// Task 6: debugging ArrayIndexOutOfBoundsException.
//
// BUGGY version (ArrayIndexDebug.java in the handout), array {10, 20, 30, 40, 50}, valid indexes 0..4:
//
//   for (int i = 0; i <= numbers.length; i++) ...   // BUG 1: i reaches 5
//   numbers[5]                                       // BUG 2: hard-coded index past the end
//   numbers[-1]                                      // BUG 3: negative index
//
// Each one throws: java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
public class FixedArrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("=== FIXED BUG 1 ===");
        for (int i = 0; i < numbers.length; i++) {          // < not <=
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        System.out.println("\n=== FIXED BUG 2 ===");
        System.out.println("Last element: " + numbers[numbers.length - 1]);

        System.out.println("\n=== FIXED BUG 3 ===");
        System.out.println("First element: " + numbers[0]);

        // Showing what the original bug does, caught safely:
        try {
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nOriginal bug 2 throws: " + e.getMessage());
        }

        System.out.println("\nAll arrays accessed safely!");
    }
}
