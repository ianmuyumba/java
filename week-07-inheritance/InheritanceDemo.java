// Task 1: extends. Dog inherits name, eat() and sleep() from Animal and adds bark().

class Animal {
    protected String name;               // visible to subclasses

    public Animal(String name) {
        this.name = name;
    }

    public void eat()   { System.out.println(name + " is eating."); }
    public void sleep() { System.out.println(name + " is sleeping."); }
}

class Dog extends Animal {               // Dog IS-AN Animal
    public Dog(String name) {
        super(name);                     // run Animal's constructor first
    }

    public void bark() {                 // new behaviour only Dogs have
        System.out.println(name + " is barking: Woof! Woof!");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy");
        myDog.eat();     // inherited
        myDog.sleep();   // inherited
        myDog.bark();    // Dog's own
    }
}
