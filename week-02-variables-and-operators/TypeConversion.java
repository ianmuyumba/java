// Task 3: implicit (widening) and explicit (narrowing) casts, and String conversion.
public class TypeConversion {
    public static void main(String[] args) {
        // Widening: small type -> big type, automatic, no data lost
        int intValue = 100;
        double doubleValue = intValue;
        long longValue = intValue;
        float floatValue = 3.14f;
        double doubleFromFloat = floatValue;

        System.out.println("=== IMPLICIT CASTING ===");
        System.out.println("int value: " + intValue);
        System.out.println("double value (from int): " + doubleValue);
        System.out.println("long value (from int): " + longValue);
        System.out.println("double value (from float): " + doubleFromFloat); // float imprecision becomes visible

        // Narrowing: big type -> small type, needs (type), may lose data
        double pi = 3.14159;
        int truncatedPi = (int) pi;                 // 3: decimals are cut off, not rounded
        double largeDouble = 123.456789;
        float smallFloat = (float) largeDouble;     // fewer digits of precision

        System.out.println("\n=== EXPLICIT CASTING ===");
        System.out.println("double pi: " + pi);
        System.out.println("int pi (truncated): " + truncatedPi);
        System.out.println("double value: " + largeDouble);
        System.out.println("float value (cast): " + smallFloat);

        // These would NOT compile:
        // int wrongInt = 3.14;        // double -> int needs a cast
        // int wrongString = "100";    // a String is not a number; use Integer.parseInt
        // int wrongBoolean = true;    // boolean is not numeric in Java
        // String wrongChar = 'A';     // char is not a String; use "A" or String.valueOf('A')
        System.out.println("\n=== TYPE MISMATCH ERRORS ===");
        System.out.println("The following lines would cause compilation errors:");
        System.out.println("int wrongInt = 3.14; // double to int without cast");
        System.out.println("int wrongString = \"100\"; // String to int");
        System.out.println("int wrongBoolean = true; // boolean to int");
        System.out.println("String wrongChar = 'A'; // char to String");

        // Converting to and from String
        String numberString = "" + 42;                       // or String.valueOf(42)
        int parsedInt = Integer.parseInt("123");
        double parsedDouble = Double.parseDouble("45.67");

        System.out.println("\n=== STRING CONVERSION ===");
        System.out.println("Number as string: " + numberString);
        System.out.println("Parsed int: " + parsedInt);
        System.out.println("Parsed double: " + parsedDouble);
    }
}
