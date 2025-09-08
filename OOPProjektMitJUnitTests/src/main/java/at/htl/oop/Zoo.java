package at.htl.oop;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private final List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<String> getAllSounds() {
        List<String> sounds = new ArrayList<>();
        for (Animal animal : animals) {
            sounds.add(animal.getName() + ": " + animal.makeSound());
        }
        return sounds;
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }
}