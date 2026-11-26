// Tasks 2 and 3: overriding with @Override, reusing the parent's logic via super,
// and protected fields that a subclass can read directly.

class Employee {
    protected String name;         // Task 3: protected = same package + subclasses
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Base Salary: KSh " + baseSalary);
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;   // extend the parent's result
    }

    @Override
    public void displayInfo() {
        super.displayInfo();                       // print name and base first
        System.out.println("Bonus: KSh " + bonus);
        System.out.println("Total Salary: KSh " + calculateSalary());
    }

    // Task 3: direct access to an inherited protected field (would not compile if it were private)
    public void printNameDirectly() {
        System.out.println("Direct access to name: " + name);
    }
}

public class OverridingDemo {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 50000);
        System.out.println("=== EMPLOYEE ===");
        emp.displayInfo();
        System.out.println("Calculated Salary: " + emp.calculateSalary());

        System.out.println();
        Manager mgr = new Manager("Bob", 80000, 20000);
        System.out.println("=== MANAGER ===");
        mgr.displayInfo();
        System.out.println("Calculated Salary: " + mgr.calculateSalary());

        System.out.println("\n=== PROTECTED ACCESS ===");
        mgr.printNameDirectly();
    }
}
