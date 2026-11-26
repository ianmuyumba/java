// Task 7: debugging a faulty conditional.
// Intention: "working age" means 18 to 65 inclusive.
//
// FAULTY version (FaultyConditional.java in the handout):
//     if (age >= 18 || age <= 65)   // BUG: || is true for EVERY integer
//
// Every number is either >= 18 or <= 65, so the faulty test always passes.
// The fix is &&: the age must satisfy BOTH bounds.
public class FixedConditional {
    static boolean faulty(int age) { return age >= 18 || age <= 65; }
    static boolean fixed(int age)  { return age >= 18 && age <= 65; }

    public static void main(String[] args) {
        int[] testAges = {10, 17, 18, 20, 65, 66, 70};   // normal and boundary cases
        System.out.println("age | faulty | fixed");
        for (int age : testAges) {
            System.out.printf("%3d | %-6s | %s%n", age, faulty(age), fixed(age));
        }

        int age = 20;
        if (fixed(age)) {
            System.out.println("You are of working age.");
        } else {
            System.out.println("You are not of working age.");
        }
    }
}
