# Week 7 - Practical Session 7 - Inheritance and Method Overriding

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 7 - Practical Session 7 - Inheritance and Method Overriding.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Practical Session 7: Inheritance and Method Overriding 
Student-Centered, Self-Paced Lab 
 
       Learning Outcomes Covered 
By the end of this practical session, you will be able to: 
1. Analyze inheritance hierarchies to determine which fields/methods are inherited vs 
newly added. 
2. Create a subclass that extends a superclass, overriding methods appropriately. 
3. Evaluate whether inheritance or composition is more suitable for a given relationship. 
4. Design a class hierarchy for a real-world scenario (e.g., Vehicle → Car, Bike, Truck). 
Time Required: 120–150 minutes 
Instructor Intervention: None – you will figure it out yourself! 
 
✓ Before You Begin 
Ensure you have completed Week 1 through Week 6 practical sessions. You will need: 
• VS Code open 
• Your java-course folder with week6 subfolder 
• Git configured and connected to GitHub
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
✓ Your Roadmap 
 
TASK 1: The Basics of Inheritance (extends) 
Objective 
Analyze how a subclass inherits fields and methods from a superclass without rewriting code. 
Step 1.1: Create a New Folder 
1. Open VS Code. 
2. Open your java-course folder.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
3. Right-click the java-course folder → New Folder. 
4. Name it: week7 
5. Press Enter. 
Step 1.2: Create the File 
1. Right-click the week7 folder → New File. 
2. Name the file: InheritanceDemo.java 
3. Press Enter. 
Step 1.3: Write the Code 
Copy and paste this code into InheritanceDemo.java: 
java 
// This program demonstrates the basics of inheritance using the 'extends' keyword. 
 
// ============================================================ 
// SUPERCLASS (Parent) 
// ============================================================ 
class Animal { 
    // A protected field. It can be accessed by this class and any subclass. 
    protected String name; 
 
    // Constructor for Animal 
    public Animal(String name) { 
        this.name = name; 
    } 
 
    // A behavior shared by all animals. 
    public void eat() {
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
System.out.println(name + " is eating."); 
    } 
 
    // Another shared behavior. 
    public void sleep() { 
        System.out.println(name + " is sleeping."); 
    } 
} 
 
// ============================================================ 
// SUBCLASS (Child) 
// ============================================================ 
// The 'extends' keyword means Dog inherits allViewController everything from Animal. 
class Dog extends Animal { 
 
    // Constructor for Dog 
    public Dog(String name) { 
        // Call the superclass (Animal) constructor. 
        // Must be the very first line in the constructor. 
        super(name); 
    } 
 
    // A behavior unique to Dog (not in Animal). 
    public void bark() { 
        System.out.println(name + " is barking: Woof! Woof!"); 
    }
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
} 
 
// ============================================================ 
// MAIN CLASS 
// ============================================================ 
public class InheritanceDemo { 
    public static void main(String[] args) { 
 
        // Create a Dog object. 
        Dog myDog = new Dog("Buddy"); 
 
        // Call a method inherited from Animal. 
        myDog.eat();   // Inherited method 
 
        // Call a method inherited from Animal. 
        myDog.sleep(); // Inherited method 
 
        // Call a method defined ONLY in Dog. 
        myDog.bark();  // Subclass-specific method 
    } 
} 
Step 1.4: Run the Program 
Save and run. Observe how Dog can call eat() and sleep() even though those methods are not 
written inside the Dog class.
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
Expected Output: 
Buddy is eating. 
Buddy is sleeping. 
Buddy is barking: Woof! Woof! 
   Task 1 Complete 
• □ I created InheritanceDemo.java 
• □ I ran the program successfully 
• □ I understand that Dog inherits from Animal 
 
TASK 2: Method Overriding & the super Keyword 
Objective 
Create a subclass that overrides a superclass method to provide its own specific 
implementation, while using super to access the original behavior if needed. 
Step 2.1: Create the File 
Create a new file called OverridingDemo.java in the week7 folder. 
Step 2.2: Write the Code 
java 
// This program demonstrates Method Overriding and the 'super' keyword. 
 
// ============================================================ 
// SUPERCLASS 
// ============================================================ 
class Employee { 
    // Protected field 
    protected String name; 
    protected double baseSalary;
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
// Constructor 
    public Employee(String name, double baseSalary) { 
        this.name = name; 
        this.baseSalary = baseSalary; 
    } 
 
    // Method to calculate salary. 
    public double calculateSalary() { 
        return baseSalary; 
    } 
 
    // Method to display info. 
    public void displayInfo() { 
        System.out.println("Name: " + name); 
        System.out.println("Base Salary: KSh " + baseSalary); 
    } 
} 
 
// ============================================================ 
// SUBCLASS 
// ============================================================ 
class Manager extends Employee { 
    // A field unique to Manager. 
    private double bonus;
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
// Constructor 
    public Manager(String name, double baseSalary, double bonus) { 
        // Call the Employee constructor. 
        super(name, baseSalary); 
        // Set the Manager-specific field. 
        this.bonus = bonus; 
    } 
 
    // OVERRIDING the calculateSalary method. 
    // We use the @Override annotation to tell the compiler we are overriding. 
    @Override 
    public double calculateSalary() { 
        // Use 'super' to call the parent's version of the method. 
        double base = super.calculateSalary(); 
         
        // Add the bonus to the base salary. 
        return base + bonus; 
    } 
 
    // OVERRIDING the displayInfo method. 
    @Override 
    public void displayInfo() { 
        // Call the parent's displayInfo first. 
        super.displayInfo(); 
         
        // Then add Manager-specific information.
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
System.out.println("Bonus: KSh " + bonus); 
        System.out.println("Total Salary: KSh " + calculateSalary()); 
    } 
} 
 
// ============================================================ 
// MAIN CLASS 
// ============================================================ 
public class OverridingDemo { 
    public static void main(String[] args) { 
 
        // Create a regular Employee. 
        Employee emp = new Employee("Alice", 50000); 
        System.out.println("=== EMPLOYEE ==="); 
        emp.displayInfo(); 
        System.out.println("Calculated Salary: " + emp.calculateSalary()); 
 
        System.out.println(); 
 
        // Create a Manager. 
        Manager mgr = new Manager("Bob", 80000, 20000); 
        System.out.println("=== MANAGER ==="); 
        mgr.displayInfo(); 
        System.out.println("Calculated Salary: " + mgr.calculateSalary()); 
    } 
}
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
Step 2.3: Run the Program 
Save and run. Notice how Manager overrides calculateSalary() to add the bonus, but uses 
super.calculateSalary() to avoid rewriting the base logic. 
Step 2.4: Analyze the Code 
Answer these questions in your notebook: 
1. What does the @Override annotation do? 
2. Why is super.calculateSalary() used inside the overridden method? 
3. What would happen if we removed super.displayInfo() from the Manager class? 
   Task 2 Complete 
• □ I created OverridingDemo.java 
• □ I ran the program successfully 
• □ I understand how @Override works 
 
TASK 3: The protected Access Modifier 
Objective 
Understand how protected allows subclasses to access data that is hidden from the rest of the 
world. 
Step 3.1: Observe the Modifiers 
Look at the Employee class in Task 2. 
java 
protected String name; 
protected double baseSalary; 
1. If these were private, could Manager access them? (No, private means only that class). 
2. If these were public, could any other class modify them? (Yes, which breaks 
encapsulation). 
3. protected is the middle ground: It is accessible within the same package AND by any 
subclass.
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
Step 3.2: Test It! 
In your Manager class, try to directly print name without using a getter, just to prove it works: 
java 
// Inside Manager class, add this method: 
public void printNameDirectly() { 
    // This works because 'name' is protected in Employee! 
    System.out.println("Direct access to name: " + name); 
} 
Run it from the main method. It works! If name were private, this would cause a compilation 
error. 
   Task 3 Complete 
• □ I understand the difference between private, protected, and public. 
 
TASK 4: Evaluate Inheritance vs. Composition 
Objective 
Evaluate when to use Inheritance (is-a) versus Composition (has-a). A common trap for 
beginners is using inheritance for everything. 
Step 4.1: The "Is-A" vs "Has-A" Rule 
• Inheritance (Is-a): A Car is a Vehicle. A Dog is an Animal. (Use extends). 
• Composition (Has-a): A Car has an Engine. A Computer has a Processor. (Use instance 
variables). 
Step 4.2: The Wrong Way (Inheritance) 
Do not write code for this, just read it. A beginner might write: 
java 
class Engine { ... } 
class Car extends Engine { ... } // WRONG! A Car is NOT an Engine. A Car HAS an Engine. 
Step 4.3: The Right Way (Composition)
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
Create a new file called CompositionDemo.java in the week7 folder. 
java 
// This program demonstrates Composition (HAS-A relationship). 
// We use instance variables instead of 'extends'. 
 
// The Engine class (Independent component). 
class Engine { 
    public void start() { 
        System.out.println("Engine started."); 
    } 
} 
 
// The Car class (Uses Composition). 
class Car { 
    // The Car HAS-A Engine. 
    // We create an Engine object as a field. 
    private Engine engine; 
 
    // Constructor initializes the Engine. 
    public Car() { 
        this.engine = new Engine(); 
    } 
 
    // The Car delegates the starting action to its Engine. 
    public void startCar() { 
        System.out.println("Car is starting...");
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
// Call the Engine's method. 
        engine.start();  
    } 
} 
 
public class CompositionDemo { 
    public static void main(String[] args) { 
        Car myCar = new Car(); 
        myCar.startCar(); 
    } 
} 
Step 4.4: Evaluate the Difference 
In your notebook, write down: 
1. Why is Composition better for Car and Engine? 
2. When would you use Inheritance instead? (Hint: Think of a SportsCar or Truck). 
   Task 4 Complete 
• □ I created CompositionDemo.java 
• □ I can explain "is-a" vs "has-a" 
 
TASK 5: Design a Class Hierarchy (Shapes) 
Objective 
Design a real-world class hierarchy using a superclass and multiple subclasses. 
Step 5.1: Create the File 
Create a new file called ShapeHierarchy.java in the week7 folder. 
Step 5.2: Write the Code 
java
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
// This program demonstrates designing a class hierarchy with inheritance. 
 
// ============================================================ 
// SUPERCLASS 
// ============================================================ 
class Shape { 
    // Common attribute for all shapes. 
    protected String name; 
 
    // Constructor 
    public Shape(String name) { 
        this.name = name; 
    } 
 
    // A method to be overridden by subclasses. 
    public double calculateArea() { 
        return 0.0; 
    } 
 
    // Overriding the toString() method from the Object class. 
    // This is used when you print an object. 
    @Override 
    public String toString() { 
        return "Shape: " + name; 
    } 
}
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
// ============================================================ 
// SUBCLASS 1 
// ============================================================ 
class Circle extends Shape { 
    private double radius; 
 
    public Circle(String name, double radius) { 
        super(name); // Call Shape constructor 
        this.radius = radius; 
    } 
 
    // Override calculateArea for Circle 
    @Override 
    public double calculateArea() { 
        return Math.PI * radius * radius; 
    } 
 
    // Override toString 
    @Override 
    public String toString() { 
        return super.toString() + " | Radius: " + radius; 
    } 
} 
 
// ============================================================
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
// SUBCLASS 2 
// ============================================================ 
class Rectangle extends Shape { 
    private double length; 
    private double width; 
 
    public Rectangle(String name, double length, double width) { 
        super(name); // Call Shape constructor 
        this.length = length; 
        this.width = width; 
    } 
 
    // Override calculateArea for Rectangle 
    @Override 
    public double calculateArea() { 
        return length * width; 
    } 
 
    // Override toString 
    @Override 
    public String toString() { 
        return super.toString() + " | Length: " + length + ", Width: " + width; 
    } 
} 
 
// ============================================================
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
// MAIN CLASS 
// ============================================================ 
public class ShapeHierarchy { 
    public static void main(String[] args) { 
         
        // Create a Circle 
        Circle c = new Circle("My Circle", 5.0); 
        System.out.println(c.toString()); 
        System.out.println("Area: " + c.calculateArea()); 
 
        System.out.println(); 
 
        // Create a Rectangle 
        Rectangle r = new Rectangle("My Rectangle", 4.0, 6.0); 
        System.out.println(r.toString()); 
        System.out.println("Area: " + r.calculateArea()); 
    } 
} 
Step 5.3: Run the Program 
Save and run. Notice how both Circle and Rectangle share the name and toString() logic from 
Shape, but calculate the area differently. 
   Task 5 Complete 
• □ I created ShapeHierarchy.java 
• □ I ran the program successfully 
• □ I understand how toString() is overridden
```

</details>


## PDF page 18

<details>
<summary>Page text</summary>

```text
TASK 6: Push to GitHub 
Step 6.1: Stage and Commit 
1. Open the Source Control panel in VS Code. 
2. Stage all new files in week7. 
3. Commit with message: Week 7: Inheritance - extends, super, overriding, composition 
4. Push to GitHub. 
Step 6.2: Verify on GitHub 
Go to your repository and confirm all Week 7 files are there. 
   Task 6 Complete 
• □ I committed and pushed all files 
• □ I verified on GitHub 
 
✓ Final Self-Assessment Checklist 
• □ I can explain what extends does. 
• □ I understand the difference between a superclass and a subclass. 
• □ I can override a method and use the @Override annotation. 
• □ I can use the super keyword to call a parent method. 
• □ I understand what the protected access modifier does. 
• □ I can explain the difference between "is-a" (inheritance) and "has-a" (composition). 
• □ I can design a class hierarchy (like Shape -> Circle/Rectangle). 
• □ I pushed all Week 7 code to GitHub.
```

</details>


## PDF page 19

<details>
<summary>Page text</summary>

```text
✓ Troubleshooting Guide 
Problem Solution 
cannot find symbol: method Ensure the method name is spelled correctly, and you didn't make it private in the parent class. 
constructor ... cannot be 
applied 
Make sure you are calling super(...) with the exact 
parameters the parent constructor expects. 
Trying to access a private field 
from a subclass Change the field to protected in the parent class. 
 
✓ Reflection Questions 
1. Why is inheritance referred to as an "is-a" relationship? 
2. How does overriding a method differ from overloading a method? (Hint: Think about the 
parameters). 
3. If a superclass has a method void doSomething(), and a subclass overrides it, which 
version gets called if you create an object of the subclass? 
4. In your own words, why is Composition sometimes preferred over Inheritance? 
 
✓ What You've Achieved 
You have just: 
• Mastered the extends keyword for inheritance. 
• Used Method Overriding to customize behavior. 
• Learned how to use the super keyword to access parent classes. 
• Evaluated the difference between Inheritance and Composition. 
• Designed a complete hierarchy using Shape, Circle, and Rectangle. 
You are now writing code that models the real world efficiently!
```

</details>


## PDF page 20

<details>
<summary>Page text</summary>

```text
✓ Next Steps 
In Week 8, you will: 
1. Dive into Polymorphism (one object, many forms). 
2. Learn how to store different subclasses in a single array/ArrayList. 
3. Discover Abstract Classes and Interfaces. 
 
END OF PRACTICAL SESSION 7
```

</details>
