// Task 2: the basic syntax elements of a Java program.
/*
 * Multi-line comment: starts with slash-star, ends with star-slash.
 */
public class SyntaxExplorer {                 // class declaration
    public static void main(String[] args) {  // main method: program entry point
        int age = 20;              // whole number
        double height = 1.75;      // decimal number
        char grade = 'A';          // single character (single quotes)
        boolean isStudent = true;  // true / false
        String name = "Alice";     // text: a reference type (double quotes)

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Grade: " + grade);
        System.out.println("Is Student: " + isStudent);
    }
}
