import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Task 1: the "big three" collections: List (ordered, duplicates allowed),
// Set (unique), Map (key -> value).
public class CollectionsDemo {
    public static void main(String[] args) {
        System.out.println("=== LIST (ArrayList) ===");
        List<String> nameList = new ArrayList<>();   // program to the interface type
        nameList.add("Alice");
        nameList.add("Bob");
        nameList.add("Alice");                       // duplicate kept
        System.out.println("List contents: " + nameList);
        System.out.println("Element at index 1: " + nameList.get(1));

        System.out.println("\n=== SET (HashSet) ===");
        Set<String> nameSet = new HashSet<>();
        nameSet.add("Alice");
        nameSet.add("Bob");
        boolean added = nameSet.add("Alice");        // duplicate rejected, add() returns false
        nameSet.add("Charlie");
        System.out.println("Set contents: " + nameSet + "   (order not guaranteed)");
        System.out.println("Second 'Alice' added? " + added);
        System.out.println("Does the set contain Bob? " + nameSet.contains("Bob"));   // O(1)

        System.out.println("\n=== MAP (HashMap) ===");
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");
        studentMap.put(101, "David");                // same key: the value is REPLACED
        System.out.println("Map contents: " + studentMap);
        System.out.println("Student with ID 102: " + studentMap.get(102));
        System.out.println("Student with ID 999: " + studentMap.getOrDefault(999, "none"));

        System.out.println("Iterating through the Map:");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " | Name: " + entry.getValue());
        }
    }
}
