// Task 2: nested if-else. The outer if validates the marks; the inner chain grades them.
public class StudentGrade {
    static void grade(int marks) {
        System.out.print(marks + " -> ");
        if (marks >= 0 && marks <= 100) {
            if (marks >= 70) {
                System.out.println("Grade: A");
            } else if (marks >= 60) {
                System.out.println("Grade: B");
            } else if (marks >= 50) {
                System.out.println("Grade: C");
            } else if (marks >= 40) {
                System.out.println("Grade: D");
            } else {
                System.out.println("Grade: F (Fail)");
            }
        } else {
            System.out.println("Invalid marks! Please enter a value between 0 and 100.");
        }
    }

    public static void main(String[] args) {
        grade(75);    // the task's starting value
        grade(-10);   // experiments
        grade(105);
        grade(45);
        grade(100);
    }
}
