import java.util.ArrayList;
import java.util.Arrays;

// Task 5: the same job with a fixed-size array and with a resizable ArrayList.
public class ArrayVsArrayList {
    public static void main(String[] args) {
        System.out.println("=== ARRAY vs ARRAYLIST COMPARISON ===\n");

        System.out.println("--- ARRAY APPROACH ---");
        String[] arrayStudents = {"Alice", "Bob", "Charlie"};
        System.out.println("Array contents: " + Arrays.toString(arrayStudents));
        System.out.println("Array length: " + arrayStudents.length);
        // Adding a 4th element means creating a bigger array and copying across:
        String[] bigger = Arrays.copyOf(arrayStudents, 4);
        bigger[3] = "Diana";
        System.out.println("To add Diana we had to copy into a new array: " + Arrays.toString(bigger) + "\n");

        System.out.println("--- ARRAYLIST APPROACH ---");
        ArrayList<String> listStudents = new ArrayList<>();
        listStudents.add("Alice");
        listStudents.add("Bob");
        listStudents.add("Charlie");
        System.out.println("ArrayList contents: " + listStudents);
        System.out.println("ArrayList size: " + listStudents.size());
        listStudents.add("Diana");
        System.out.println("After adding Diana, size: " + listStudents.size());
        listStudents.remove("Bob");
        System.out.println("After removing Bob, size: " + listStudents.size());
        System.out.println("Updated contents: " + listStudents + "\n");

        System.out.println("=== TRADE-OFF COMPARISON ===");
        String[][] rows = {
            {"Feature", "Array", "ArrayList"},
            {"Size", "Fixed", "Dynamic"},
            {"Element types", "Primitives & objects", "Objects only"},
            {"Length", ".length", ".size()"},
            {"Add element", "Assign by index", ".add()"},
            {"Remove element", "Manual shift", ".remove()"},
            {"Memory", "Lower", "Higher (boxing, spare capacity)"},
            {"Access speed", "Fastest", "Fast (small overhead)"},
            {"Best for", "Fixed-size data", "Changing-size data"}
        };
        for (String[] r : rows) {
            System.out.printf("%-15s | %-20s | %s%n", r[0], r[1], r[2]);
        }

        System.out.println("\n=== WHEN TO USE WHICH ===");
        System.out.println("Use ARRAY when the count is known and fixed, you store primitives,");
        System.out.println("  or you need maximum performance (e.g. days of week, pixel grid).");
        System.out.println("Use ARRAYLIST when the count changes, or you want add/remove/contains");
        System.out.println("  (e.g. shopping cart, class roster).");
    }
}
