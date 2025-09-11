package at.htlle.oop;

import at.htl.oop.*;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class AnimalAdministratorTest {

    @Test
    void testSoundDog(){
        Animal animal = new Dog("Dog");
        assertEquals("Wuff!", animal.makeSound());
    }
    @Test
    void testSoundCat(){
        Animal animal = new Cat("Cat");
        assertEquals("Miau!", animal.makeSound());
    }
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

    @Test
    void testAnimalAdministartion() {
        AnimalAdministration.main(new String[]{});

    }
}
