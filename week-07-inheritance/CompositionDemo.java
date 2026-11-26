// Task 4: composition (HAS-A). A Car has an Engine; it is not an Engine.
// The wrong way would be:  class Car extends Engine { }

class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    private final Engine engine;     // the Car owns an Engine object

    public Car() {
        this.engine = new Engine();
    }

    public void startCar() {
        System.out.println("Car is starting...");
        engine.start();              // delegate the work to the part
    }
}

// Inheritance is the right tool when the IS-A test passes: a SportsCar IS-A Car.
class SportsCar extends Car {
    public void launchControl() {
        System.out.println("Launch control engaged!");
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.startCar();

        System.out.println();
        SportsCar fast = new SportsCar();
        fast.startCar();             // inherited from Car (which uses its Engine)
        fast.launchControl();
    }
}
