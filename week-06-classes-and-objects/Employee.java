// Task 3: 'this' for name clashes, and constructor chaining with this(...).
public class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;

    // The "full" constructor: the only one that actually assigns fields
    public Employee(int id, String name, double salary, String department) {
        this.id = id;                 // this.id = field, id = parameter
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Employee(int id, String name, double salary) {
        this(id, name, salary, "Unassigned");   // must be the FIRST statement
    }

    public Employee(int id, String name) {
        this(id, name, 25000.0);                // chains to the 3-arg, then the 4-arg
    }

    public void giveRaise(double amount) {
        if (amount > 0) {
            this.salary += amount;
            System.out.println(name + " received a raise. New salary: " + this.salary);
        }
    }

    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name
                + " | Salary: " + salary + " | Dept: " + department);
    }
}
