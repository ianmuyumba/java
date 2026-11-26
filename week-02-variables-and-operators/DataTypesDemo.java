// Task 1: choose the right data type for each value.
public class DataTypesDemo {
    public static void main(String[] args) {
        // Integer types (whole numbers)
        byte studentAge = 20;               // 8-bit:  -128 .. 127
        short yearOfBirth = 2006;           // 16-bit: -32,768 .. 32,767
        int population = 54000000;          // 32-bit: about +/- 2.1 billion (Kenya)
        long worldPopulation = 8000000000L; // 64-bit: needs the L suffix

        // Decimal types
        float interestRate = 7.5f;          // ~7 digits: needs the f suffix
        double accountBalance = 15000.75;   // ~15 digits: the default decimal type

        // Character, boolean, text
        char grade = 'A';                   // one character, single quotes
        char currencySymbol = 'K';
        boolean isActive = true;
        boolean isVerified = false;
        String studentName = "Alice Wanjiku";   // reference type, double quotes
        String courseName = "Object-Oriented Programming";

        System.out.println("=== INTEGER TYPES ===");
        System.out.println("Student Age (byte): " + studentAge);
        System.out.println("Year of Birth (short): " + yearOfBirth);
        System.out.println("Kenya Population (int): " + population);
        System.out.println("World Population (long): " + worldPopulation);

        System.out.println("\n=== DECIMAL TYPES ===");
        System.out.println("Interest Rate (float): " + interestRate + "%");
        System.out.println("Account Balance (double): KSh " + accountBalance);

        System.out.println("\n=== CHARACTER TYPE ===");
        System.out.println("Grade (char): " + grade);
        System.out.println("Currency Symbol (char): " + currencySymbol);

        System.out.println("\n=== BOOLEAN TYPE ===");
        System.out.println("Is Active (boolean): " + isActive);
        System.out.println("Is Verified (boolean): " + isVerified);

        System.out.println("\n=== STRING TYPE ===");
        System.out.println("Student Name (String): " + studentName);
        System.out.println("Course Name (String): " + courseName);
    }
}
