package at.htl.oop;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String makeSound();

    public String getName() {
        return name;
    }
}