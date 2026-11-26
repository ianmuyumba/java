// Task 3: upcasting (always safe), downcasting (risky) and instanceof (the safety check).

class Vehicle { }

class Car extends Vehicle {
    public void openTrunk() {
        System.out.println("Trunk opened.");
    }
}

class Bike extends Vehicle { }

public class CastingDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Car();     // upcast: automatic
        Vehicle v2 = new Bike();
        System.out.println("Upcasting successful.");
        // v1.openTrunk();          // compile error: the Vehicle TYPE has no openTrunk()

        System.out.println("\nChecking types safely...");
        if (v1 instanceof Car) {
            Car c1 = (Car) v1;      // downcast: safe because we checked
            c1.openTrunk();
        }

        if (v2 instanceof Car) {
            System.out.println("This will not print.");
        } else {
            System.out.println("v2 is not a Car, it is a Bike. Downcasting prevented!");
        }

        // Modern form (Java 16+): pattern matching tests and casts in one step
        if (v1 instanceof Car car) {
            car.openTrunk();
        }

        // Experiment: the BUGGY lines, which downcast without checking.
        // The compiler accepts them, but they crash at runtime.
        try {
            Car c2 = (Car) v2;
            c2.openTrunk();
        } catch (ClassCastException e) {
            System.out.println("\nWithout instanceof: " + e.getClass().getSimpleName());
            System.out.println("  " + e.getMessage());
        }
    }
}
