// Task 1: an abstract class (shared state and code, IS-A) combined with an
// interface (a capability, CAN-DO).

abstract class Animal {
    protected String name;                 // state: interfaces can't have instance fields

    public Animal(String name) {
        this.name = name;
    }

    public void sleep() {                  // shared, already-written behaviour
        System.out.println(name + " is sleeping.");
    }

    public abstract void makeSound();      // each animal must decide
}

interface Flyable {
    int MAX_ALTITUDE = 10000;              // implicitly public static final (a constant)
    void fly();                            // implicitly public abstract
}

class Bird extends Animal implements Flyable {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying up to " + MAX_ALTITUDE + " feet.");
    }
}

// Something unrelated to Animal can also fly. This is why Flyable is an interface.
class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane cruising below " + MAX_ALTITUDE + " feet.");
    }
}

public class InterfaceVsAbstract {
    public static void main(String[] args) {
        Bird myBird = new Bird("Tweety");
        myBird.sleep();
        myBird.makeSound();
        myBird.fly();

        System.out.println("\n=== ANYTHING FLYABLE ===");
        Flyable[] flyers = {myBird, new Airplane()};
        for (Flyable f : flyers) {
            f.fly();
        }
    }
}
