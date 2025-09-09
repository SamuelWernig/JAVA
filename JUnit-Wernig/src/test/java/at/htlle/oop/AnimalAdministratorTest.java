package at.htlle.oop;

import at.htl.oop.Animal;
import at.htl.oop.Cat;
import at.htl.oop.Dog;
import at.htl.oop.Zoo;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalAdministratorTest {

    @Test
    void testSound(){
        Animal animal = new Dog("Dog");
        assertEquals("Wuff!", animal.makeSound());
    }

}
