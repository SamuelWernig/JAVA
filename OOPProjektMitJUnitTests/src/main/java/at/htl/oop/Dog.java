package at.htl.oop;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Wuff!";
    }
}