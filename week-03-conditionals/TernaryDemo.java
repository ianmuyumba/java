// Task 4: the ternary operator, condition ? valueIfTrue : valueIfFalse
public class TernaryDemo {
    public static void main(String[] args) {
        int age = 20;

        // Traditional if-else
        String eligibilityIfElse;
        if (age >= 18) {
            eligibilityIfElse = "Eligible to vote";
        } else {
            eligibilityIfElse = "Not eligible to vote";
        }
        System.out.println("Using if-else: " + eligibilityIfElse);

        // The same decision as one expression
        String eligibilityTernary = (age >= 18) ? "Eligible to vote" : "Not eligible to vote";
        System.out.println("Using ternary: " + eligibilityTernary);

        int number = 7;
        String evenOdd = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println(number + " is " + evenOdd);
    }
}
