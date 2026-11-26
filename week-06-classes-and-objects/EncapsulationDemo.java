// Task 1: why encapsulation matters. Public fields accept anything; private fields
// behind validating setters keep the object valid.

class BadStudent {
    public String name;      // anyone can write anything here
    public int age;
    public double gpa;
}

class GoodStudent {
    private String name;     // only this class can touch the fields
    private int age;
    private double gpa;

    public GoodStudent(String name, int age, double gpa) {
        this.name = name;
        setAge(age);         // reuse the setter so the constructor validates too
        setGpa(gpa);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Error: Invalid age. Age must be between 0 and 150.");
        }
    }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Error: Invalid GPA. GPA must be between 0.0 and 4.0.");
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        System.out.println("=== TESTING BAD STUDENT ===");
        BadStudent bad = new BadStudent();
        bad.name = "Alice";
        bad.age = -100;      // accepted: impossible data
        bad.gpa = 15.5;      // accepted: impossible data
        System.out.println("BadStudent Name: " + bad.name);
        System.out.println("BadStudent Age: " + bad.age + " (Corrupted!)");
        System.out.println("BadStudent GPA: " + bad.gpa + " (Corrupted!)");

        System.out.println("\n=== TESTING GOOD STUDENT ===");
        GoodStudent good = new GoodStudent("Bob", 20, 3.5);
        System.out.println("GoodStudent Name: " + good.getName());
        System.out.println("GoodStudent Age: " + good.getAge());
        System.out.println("GoodStudent GPA: " + good.getGpa());

        System.out.println("\nAttempting to set invalid age and GPA...");
        good.setAge(-100);   // rejected
        good.setGpa(15.5);   // rejected
        // good.age = -100;  // would not even compile: age has private access
        System.out.println("GoodStudent Age after invalid attempt: " + good.getAge());
        System.out.println("GoodStudent GPA after invalid attempt: " + good.getGpa());
    }
}
