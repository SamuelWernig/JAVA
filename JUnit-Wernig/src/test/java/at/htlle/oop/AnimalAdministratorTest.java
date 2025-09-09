package at.htlle.oop;

import at.htl.oop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

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
        assertEquals("Dog: Wuff!", zoo.getAllSounds());
    }
    @Test
    void testMainOutput_containsAnimalSounds() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));


        AnimalAdministration.main(new String[]{});


        String output = out.toString();


        assertTrue(output.contains("Yoda: Wuff"));
        assertTrue(output.contains("Lea: Miau"));

        System.setOut(System.out);
    }
}
