package at.htlle.oop;

import at.htl.oop.Animal;
import at.htl.oop.Dog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogTest {

    @Test
    void testConstructor() {
        Animal d = new Dog("Dog");
        assertEquals("Dog", d.getName());
    }

    @Test
    void testSoundDog() {
        Animal animal = new Dog("Dog");
        assertEquals("Wuff!", animal.makeSound());
    }
}
