// Task 5: evaluate compound boolean expressions step by step.
// Precedence: !  before  &&  before  ||
public class BooleanAnalysis {
    public static void main(String[] args) {
        // Expression 1: (5 > 3) && (4 < 2) || (10 == 10)
        boolean part1 = (5 > 3);      // true
        boolean part2 = (4 < 2);      // false
        boolean part3 = (10 == 10);   // true
        System.out.println("5 > 3: " + part1);
        System.out.println("4 < 2: " + part2);
        System.out.println("10 == 10: " + part3);

        boolean intermediate = part1 && part2;          // && first: false
        System.out.println("part1 && part2: " + intermediate);
        System.out.println("Final result: " + (intermediate || part3));                 // true
        System.out.println("Direct result: " + ((5 > 3) && (4 < 2) || (10 == 10)));     // true

        // Expression 2: !(5 > 3) || (4 < 2) && (10 == 10)
        boolean notPart = !(5 > 3);                     // false
        boolean andPart = (4 < 2) && (10 == 10);        // false && true = false
        System.out.println("\n!(5 > 3): " + notPart);
        System.out.println("(4 < 2) && (10 == 10): " + andPart);
        System.out.println("Final result 2: " + (notPart || andPart));                  // false
        System.out.println("Direct result 2: " + (!(5 > 3) || (4 < 2) && (10 == 10)));  // false
    }
}
