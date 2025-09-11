package at.htlle.oop;

import at.htl.oop.Animal;
import at.htl.oop.Cat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {

    @Test
    void testConstructor() {
        Animal c = new Cat("Cat");
        assertEquals("Cat", c.getName());
    }


    @Test
    void testSoundCat(){
        Animal animal = new Cat("Cat");
        assertEquals("Miau!", animal.makeSound());
    }
}
