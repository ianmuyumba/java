// Task 1: declaring, filling, reading and looping over arrays.
public class ArrayBasics {
    public static void main(String[] args) {
        int[] numbers = new int[5];        // 5 slots, indexes 0..4, all start at 0
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        int[] scores = {85, 92, 78, 95, 88, 76, 90};   // array literal: size from the values
        String[] names = {"Alice", "Bob", "Charlie", "Diana"};

        System.out.println("=== ACCESSING ARRAY ELEMENTS ===");
        System.out.println("First number: " + numbers[0]);
        System.out.println("Third number: " + numbers[2]);
        System.out.println("Last number: " + numbers[numbers.length - 1]);
        System.out.println("Length of numbers array: " + numbers.length);   // a field, no ()
        System.out.println("Length of scores array: " + scores.length);
        System.out.println("Length of names array: " + names.length);

        System.out.println("\n=== TRADITIONAL FOR LOOP ===");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        System.out.println("\n=== ENHANCED FOR LOOP ===");
        for (int num : numbers) {
            System.out.println("Value: " + num);
        }

        System.out.println("\n=== NAMES ARRAY ===");
        for (String name : names) {
            System.out.println("Name: " + name);
        }

        System.out.println("\n=== DEFAULT VALUES ===");
        int[] defaultInts = new int[3];
        boolean[] defaultBooleans = new boolean[3];
        String[] defaultStrings = new String[3];
        System.out.println("Default int: " + defaultInts[0]);          // 0
        System.out.println("Default boolean: " + defaultBooleans[0]);  // false
        System.out.println("Default String: " + defaultStrings[0]);    // null (no object yet)
    }
}
