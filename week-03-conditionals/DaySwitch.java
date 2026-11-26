// Task 6, version B: the same mapping with a switch.
public class DaySwitch {
    public static void main(String[] args) {
        int day = 3;

        switch (day) {
            case 1: System.out.println("Monday");    break;
            case 2: System.out.println("Tuesday");   break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday");  break;
            case 5: System.out.println("Friday");    break;
            case 6: System.out.println("Saturday");  break;
            case 7: System.out.println("Sunday");    break;
            default: System.out.println("Invalid day");
        }

        // Modern alternative (Java 14+): a switch expression, no break and no fall-through
        String name = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
        System.out.println("Switch expression: " + name);
    }
}
