package at.htlle.oop;

import at.htl.oop.*;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {
    @Test
    void testAddAnimalandGetNumberOfAnimals(){
        Zoo zoo = new Zoo();
        zoo.addAnimal(new Dog("Dog"));
        zoo.addAnimal(new Cat("Cat"));
        assertEquals(2, zoo.getNumberOfAnimals());
    }
    @Test
    void testGetAllSounds(){
        Zoo zoo = new Zoo();
        zoo.addAnimal(new Dog("Dog"));
        //assertEquals("Dog: Wuff!", zoo.getAllSounds().get(0));
        assertTrue(zoo.getAllSounds().contains("Dog: Wuff!"));
    }
}
