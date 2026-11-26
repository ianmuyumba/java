// Task 1: if / else-if / else. Classifies a number as positive, negative or zero.
// check() is called with each experiment value from the task (10, -5, 0).
public class PositiveNegativeZero {
    static void check(int number) {
        if (number > 0) {
            System.out.println(number + " is positive.");
        } else if (number < 0) {
            System.out.println(number + " is negative.");
        } else {
            System.out.println(number + " is zero.");   // only value left
        }
    }

    public static void main(String[] args) {
        check(10);
        check(-5);
        check(0);
    }
}
